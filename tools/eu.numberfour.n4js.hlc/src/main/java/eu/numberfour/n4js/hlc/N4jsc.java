/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package eu.numberfour.n4js.hlc;

import static com.google.common.base.Preconditions.checkState;
import static com.google.inject.util.Modules.override;
import static eu.numberfour.n4js.utils.git.GitUtils.getMasterBranch;
import static eu.numberfour.n4js.utils.git.GitUtils.hardReset;
import static eu.numberfour.n4js.utils.git.GitUtils.pull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.log4j.varia.NullAppender;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Throwables;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.util.Modules;

import eu.numberfour.n4js.N4JSRuntimeModule;
import eu.numberfour.n4js.N4JSStandaloneSetup;
import eu.numberfour.n4js.binaries.BinariesPreferenceStore;
import eu.numberfour.n4js.binaries.IllegalBinaryStateException;
import eu.numberfour.n4js.binaries.nodejs.NodeJsBinary;
import eu.numberfour.n4js.binaries.nodejs.NpmBinary;
import eu.numberfour.n4js.external.HeadlessTargetPlatformInstallLocationProvider;
import eu.numberfour.n4js.external.NpmManager;
import eu.numberfour.n4js.external.TargetPlatformInstallLocationProvider;
import eu.numberfour.n4js.external.TypeDefinitionGitLocationProvider;
import eu.numberfour.n4js.external.libraries.PackageJson;
import eu.numberfour.n4js.external.libraries.TargetPlatformModel;
import eu.numberfour.n4js.generator.headless.HeadlessHelper;
import eu.numberfour.n4js.generator.headless.N4HeadlessCompiler;
import eu.numberfour.n4js.generator.headless.N4JSCompileException;
import eu.numberfour.n4js.generator.headless.N4JSHeadlessGeneratorModule;
import eu.numberfour.n4js.internal.FileBasedWorkspace;
import eu.numberfour.n4js.n4JS.N4JSPackage;
import eu.numberfour.n4js.n4mf.N4MFStandaloneSetup;
import eu.numberfour.n4js.n4mf.N4mfPackage;
import eu.numberfour.n4js.regex.RegularExpressionStandaloneSetup;
import eu.numberfour.n4js.runner.RunnerFrontEnd;
import eu.numberfour.n4js.runner.SystemLoaderInfo;
import eu.numberfour.n4js.runner.extension.IRunnerDescriptor;
import eu.numberfour.n4js.runner.extension.RunnerRegistry;
import eu.numberfour.n4js.runner.nodejs.NodeRunner.NodeRunnerDescriptorProvider;
import eu.numberfour.n4js.tester.CliTestTreeTransformer;
import eu.numberfour.n4js.tester.TestCatalogSupplier;
import eu.numberfour.n4js.tester.TestTreeTransformer;
import eu.numberfour.n4js.tester.TesterFacade;
import eu.numberfour.n4js.tester.TesterFrontEnd;
import eu.numberfour.n4js.tester.TesterModule;
import eu.numberfour.n4js.tester.extension.ITesterDescriptor;
import eu.numberfour.n4js.tester.extension.TesterRegistry;
import eu.numberfour.n4js.tester.nodejs.NodeTester.NodeTesterDescriptorProvider;
import eu.numberfour.n4js.ts.TypeExpressionsStandaloneSetup;
import eu.numberfour.n4js.ts.TypesStandaloneSetup;
import eu.numberfour.n4js.ts.typeRefs.TypeRefsPackage;
import eu.numberfour.n4js.ts.types.TypesPackage;
import eu.numberfour.n4js.utils.io.FileDeleter;

/**
 * N4JS Compiler.
 *
 * This class is the entry point to all command-line options and provides a main-Method for starting the compiler.
 *
 * Upon errors main-method exits the program through System.exit() providing an error code different to zero.
 */
public class N4jsc {

	/**
	 * Marker used to distinguish between compile-messages and runner output.
	 */
	public static final String MARKER_RUNNER_OUPTUT = "======= =======";

	/** Normal successful exit. */
	public final static int EXITCODE_SUCCESS = 0;

	/** Exit with 1, wrong parameter set given */
	public final static int EXITCODE_WRONG_CMDLINE_OPTIONS = 1;

	/** Exit with 2, if compilation did not succeed. */
	public final static int EXITCODE_COMPILE_ERROR = 2;

	/** Exit with 3, if configuration is erroneous. */
	public final static int EXITCODE_CONFIGURATION_ERROR = 3;

	/** Exit with 4, if required runner could not be loaded. */
	public final static int EXITCODE_RUNNER_NOT_FOUND = 4;

	/** Exit with 5, if module to run doesn't exist. */
	public final static int EXITCODE_MODULE_TO_RUN_NOT_FOUND = 5;

	/** Exit code indicating an unsuccessful execution of the runner. */
	public static final int EXITCODE_RUNNER_STOPPED_WITH_ERROR = 6;

	/** Exit code indicating that assembling the test catalog failed for compiler projects. */
	public static final int EXITCODE_TEST_CATALOG_ASSEMBLATION_ERROR = 7;

	private static final HashMap<Integer, String> exitCodeExplained = new HashMap<>();

	static {
		exitCodeExplained.put(EXITCODE_SUCCESS, "normal successful exit");
		exitCodeExplained.put(EXITCODE_WRONG_CMDLINE_OPTIONS, "wrong parameter set given");
		exitCodeExplained.put(EXITCODE_COMPILE_ERROR, "compilation did not succeed");
		exitCodeExplained.put(EXITCODE_CONFIGURATION_ERROR, "configuration is erroneous");
		exitCodeExplained.put(EXITCODE_RUNNER_NOT_FOUND, "required runner could not be loaded");
		exitCodeExplained.put(EXITCODE_MODULE_TO_RUN_NOT_FOUND, "module to run doesn't exist");
		exitCodeExplained.put(EXITCODE_RUNNER_STOPPED_WITH_ERROR, "unsuccessful execution of the runner");
		exitCodeExplained.put(EXITCODE_TEST_CATALOG_ASSEMBLATION_ERROR,
				"assembling the test catalog failed for compiler projects");
	}

	/** Printing of usage and exit */
	@Option(name = "--help", aliases = "-h", usage = "print help & exit")
	// , help=true // TODO new versions(>3.5.2014) of args4j, support help-flag
	boolean help = false;

	/** Debug print of all read-in arguments */
	@Option(name = "--debug", usage = "print information about the current setup of the compiler")
	boolean debug = false;

	@Option(name = "--projectlocations", aliases = "-pl", metaVar = "directory", required = false, usage = "provide folder(s) to search for projects. If not set, the base folder of the running jvm will be taken as the location. "
			+ "Multiple folders can be given separated by the systems path-separator(: or ;). Only direct subfolders will be queried for projects.")
	String projectLocations;

	@Option(name = "--preferences", usage = "provide custom compiler preference settings stored in a *.properties file")
	File preferencesProperties;

	@Option(name = "-t", metaVar = "type", usage = "provide the type to build (defaults to dontcompile). "
			+ "\n'allprojects' compiles all projects found in the projectlocations, no other argument required. "
			+ "\n'projects' interprets the arguments as projects-folders and compiles them. "
			+ "\n'singlefile' interprets the arguments as paths to N4JS-source files and compiles only those both."
			+ "\n'dontcompile' don't generate anything.")
	Type buildtype = Type.dontcompile;

	@Option(name = "--testCatalogFile", aliases = "-tc", required = false, usage = "if specified, a test catalog file will be generated to the given file location. The generated test catalog file will represent all "
			+ "tests that are available among the compiled sources. If the file does not exists at the given location, a new file will be created to "
			+ "the specified location. If a file already exists at the given location then the content of the existing file content will be replaced "
			+ "with the newly assembled test catalog. If an invalid file location is specified as the test catalog file output, then the catalog generation will fail.")
	File testCatalogFile;

	@Option(name = "--targetPlatformFile", aliases = "-tp", required = false, usage = "if specified, then all third party dependencies declared in the target platform file "
			+ "will be downloaded, installed and made available for all the N4JS projects before the compile (and run) phase. If the target platform file is given but the "
			+ "target platform install location is not specified (via the --targetPlatformInstallLocation flag), then a the compilation phase will be aborted and the execution will be interrupted."
			+ "If --targetPlatformSkipInstall is provided this parameter is ignored.")
	File targetPlatformFile;

	@Option(name = "--targetPlatformInstallLocation", aliases = "-tl", required = false, usage = "if specified and the target platform file is given as well, then all third party dependencies "
			+ "specified in the target platform file will be downloaded to that given location. If the target platform file is given, but the target platform install location is not specified, "
			+ "then a the compilation phase will be aborted and the execution will be interrupted."
			+ "If --targetPlatformSkipInstall is provided this parameter is ignored.")
	File targetPlatformInstallLocation;

	@Option(name = "--targetPlatformSkipInstall", required = false, usage = "usually dependencies defined in the target platform file will be installed into the folder defined by option --targetPlatformInstallLocation. "
			+ "If this flag is provided, this installation will be skipped, assuming the given folder already contains the required files and everything is up-to-date."
			+ "Use with care, because no checks will be performed whether the location actually contains all required dependencies.")
	boolean targetPlatformSkipInstall = false;

	@Option(name = "--keepCompiling", usage = "keep compiling - even if errors are encountered")
	boolean keepCompiling = false;

	@Option(name = "--notests", usage = "don't process test-folders")
	// , forbids = "--testonly" // TODO new versions(>3.5.2014) of arg4j allow exclusions
	boolean notests = false;

	@Option(name = "--testonly", usage = "only transpile contents of test-folders")
	// , forbids = "--notests" // TODO new versions(>3.5.2014) of arg4j allow exclusions
	boolean testonly = false;

	@Option(name = "--verbose", aliases = "-v", usage = "verbose output during build")
	boolean verbose = false;

	// -- --- --- - -- --- --- - -- --- --- - -- --- --- - -- --- --- - -- --- --- -
	// Options for execution (=running)
	@Option(name = "--run", aliases = "-r", metaVar = "pathToFileToRun", usage = "path to the file that should be run after compilation.")
	File runThisFile = null;

	@Option(name = "--runWith", aliases = "-rw", metaVar = "runnerId", usage = "ID of runner to use, last segment is sufficient, e.g. nodejs.")
	String runner = "nodejs";

	@Option(name = "--systemLoader", aliases = "-sl", required = false, usage = "when specified the given javascript system loader will be used "
			+ "for running the module. If not specified, the by default the System.js loader will be used. The following system "
			+ "loaders are available: sjs and cjs where sjs stands for System.js and cjs stands for Common JS.")
	String systemLoader;

	@Option(name = "--nodejsLocation", required = false, usage = "when configured then the Node.js binary located under the given absolute path "
			+ "will be used for executing modules. When specified then the absolute path of the folder that contains the Node.js binary should be "
			+ "specified. If not set, then the default /usr/local/bin (on Unix systems) or C:\\Program Files\\nodejs (on Windows systems) location "
			+ "will be used to look for the Node.js binary. ")
	File nodeJsBinaryRoot;

	@Option(name = "--list-runners", aliases = "-lr", usage = "show list of available runners.")
	boolean listRunners = false;

	@Option(name = "--test", /* aliases = "-t", */metaVar = "path", usage = "path must point to a project, folder, or file containing tests.")
	File testThisLocation = null;

	@Option(name = "--testWith", aliases = "-tw", metaVar = "testerId", usage = "ID of tester to use, last segment is sufficient, e.g. nodejs")
	String tester = "nodejs";

	@Option(name = "--list-testers", aliases = "-lt", usage = "show list of available testers")
	boolean listTesters = false;

	@Option(name = "--implementationId", aliases = "-impl", metaVar = "ID", required = false, usage = "if there are API projects among the dependencies of the module to run, this specifies the ID of the "
			+ "implementation to use; only required when running/testing if there are API projects and there exists "
			+ "more than one implementation.")
	String implementationId = null;

	// -- --- --- - -- --- --- - -- --- --- - -- --- --- - -- --- --- - -- --- --- -
	// Special debugging features, hidden from normal usage
	@Option(name = "--log",
			// no usage, do not show in help
			required = false)
	boolean log = false;

	@Option(name = "--logfile",
			// no usage, do not show in help
			required = false)
	String logFile = "n4jsc.log";

	/**
	 * Catch all last arguments as files. The actual meaning of these files depends on the {@link #buildtype} (-t)
	 * option
	 */
	@Argument(multiValued = true, usage = "filename of source (or project, see -t) to compile")
	List<File> srcFiles = new ArrayList<>();

	@Inject
	private N4HeadlessCompiler headless;

	@Inject
	private RunnerFrontEnd runnerFrontEnd;

	@Inject
	private RunnerRegistry runnerRegistry;

	@Inject
	private TesterFrontEnd testerFrontEnd;

	@Inject
	private TesterFacade testerFacade;

	@Inject
	private TesterRegistry testerRegistry;

	@Inject
	private FileBasedWorkspace fbWorkspace;

	@Inject
	private TestCatalogSupplier testCatalogSupplier;

	@Inject
	private TargetPlatformInstallLocationProvider installLocationProvider;

	@Inject
	private NpmManager npmManager;

	@Inject
	private NodeRunnerDescriptorProvider nodeRunnerDescriptorProvider;

	@Inject
	private NodeTesterDescriptorProvider nodeTesterDescriptorProvider;

	@Inject
	private Provider<NodeJsBinary> nodeJsBinaryProvider;

	@Inject
	private Provider<NpmBinary> npmBinaryProvider;

	@Inject
	private BinariesPreferenceStore binariesPreferenceStore;

	@Inject
	private TypeDefinitionGitLocationProvider gitLocationProvider;

	/**
	 * Entry point to start the compiler. Parses the Parameters.
	 *
	 * @param args
	 *            the parameters.
	 */
	public static void main(String[] args) {

		try {
			new N4jsc().doMain(args);
		} catch (ExitCodeException e) {
			if (e.exitCode != EXITCODE_SUCCESS) {
				warn(e.getMessage() + " exitcode: " + e.exitCode + explanationOfExitCode(e.exitCode));
				System.out.flush();
			}
			System.exit(e.getExitCode());
		}

	}

	/**
	 * worker-pendant to {@link #main(String[])}
	 *
	 * @param args
	 *            parameters from command-line
	 * @throws ExitCodeException
	 *             in case of errors.
	 */
	void doMain(String[] args) throws ExitCodeException {
		try {

			CmdLineParser parser = new CmdLineParser(this);
			parser.setUsageWidth(130);

			try {

				parser.parseArgument(args);

			} catch (CmdLineException e) {
				System.err.println(e.getMessage());
				printExtendedUsage(parser, System.err);
				// exit with error-code 1
				throw new ExitCodeException(EXITCODE_WRONG_CMDLINE_OPTIONS);
			}

			// debug before help, shortcut for check-settings without running
			if (debug) {
				printDebugLines();
			} else {
				// Reconfigure Logging to be quite:
				Logger.getRootLogger().removeAllAppenders();
				Logger.getRootLogger().addAppender(new NullAppender());
			}

			// Check help option:
			if (help) {
				// print and exit:
				printExtendedUsage(parser, System.out);
				throw new ExitCodeException(EXITCODE_SUCCESS);
			}

			// Injection should not be called before making sure the argument parsing successfully finished. Such as
			// help.
			initInjection(refProperties());

			// Wire up available runners and testers.
			runnerRegistry.register(nodeRunnerDescriptorProvider.get());
			testerRegistry.register(nodeTesterDescriptorProvider.get());

			if (listRunners) {
				printAvailableRunners(System.out);
				throw new ExitCodeException(EXITCODE_SUCCESS);
			}
			if (listTesters) {
				printAvailableTesters(System.out);
				throw new ExitCodeException(EXITCODE_SUCCESS);
			}

			EnumSet<Type> noSrcRequired = EnumSet.of(Type.allprojects, Type.dontcompile);
			// missing arguments (only build all doesn't require one OR if nothing will be compiled).
			if (srcFiles.isEmpty() && (!noSrcRequired.contains(buildtype))) {
				// print and exit:
				System.out.println("Missing arguments.");
				printExtendedUsage(parser, System.out);
				throw new ExitCodeException(EXITCODE_WRONG_CMDLINE_OPTIONS);
			}

			// check missing runner
			if ((runThisFile != null) && isNotGiven(runner)) {
				// print and exit:
				System.out.println("Missing arguments for running: runner must be named with option -rw");
				printExtendedUsage(parser, System.out);
				throw new ExitCodeException(EXITCODE_WRONG_CMDLINE_OPTIONS);
			}
			// check missing tester
			if ((testThisLocation != null) && isNotGiven(tester)) {
				// print and exit:
				System.out.println("Missing arguments for testing: tester must be named with option -tw");
				printExtendedUsage(parser, System.out);
				throw new ExitCodeException(EXITCODE_WRONG_CMDLINE_OPTIONS);
			}
			// check runner/tester conflict
			if (runThisFile != null && testThisLocation != null) {
				// print and exit:
				System.out.println("Conflicting arguments: must not provide both -r and -t");
				printExtendedUsage(parser, System.out);
				throw new ExitCodeException(EXITCODE_WRONG_CMDLINE_OPTIONS);
			}

			if (null != testCatalogFile) {

				if (testCatalogFile.exists()) {
					if (testCatalogFile.isDirectory()) {
						final String msg = "The location of the test catalog file points to a directory and not to a file. "
								+ testCatalogFile;
						System.out.println(msg);
						printExtendedUsage(parser, System.out);
						throw new ExitCodeException(EXITCODE_TEST_CATALOG_ASSEMBLATION_ERROR, msg);
					}

					if (!testCatalogFile.delete()) {
						final String msg = "Error while deleting existing test catalog file. " + testCatalogFile;
						System.out.println(msg);
						printExtendedUsage(parser, System.out);
						throw new ExitCodeException(EXITCODE_TEST_CATALOG_ASSEMBLATION_ERROR, msg);
					}
				}

				try {
					if (!testCatalogFile.createNewFile()) {
						final String msg = "Error while creating test catalog file at: " + testCatalogFile;
						System.out.println(msg);
						printExtendedUsage(parser, System.out);
						throw new ExitCodeException(EXITCODE_TEST_CATALOG_ASSEMBLATION_ERROR, msg);
					}
				} catch (final IOException e) {
					System.out.println("Error while creating test catalog file. " + e.getMessage());
					printExtendedUsage(parser, System.out);
					throw new ExitCodeException(EXITCODE_TEST_CATALOG_ASSEMBLATION_ERROR, e);
				}

				if (!testCatalogFile.exists() || !testCatalogFile.canWrite()) {
					final String msg = "Cannot access test catalog file at: " + testCatalogFile;
					System.out.println(msg);
					printExtendedUsage(parser, System.out);
					throw new ExitCodeException(EXITCODE_TEST_CATALOG_ASSEMBLATION_ERROR, msg);
				}

			}

			final SystemLoaderInfo systemLoaderType = SystemLoaderInfo.fromString(systemLoader);
			if (null == systemLoaderType) {
				systemLoader = SystemLoaderInfo.SYSTEM_JS.getId();
			}

			checkTargetPlatformConfigurations();
			if (null != nodeJsBinaryRoot) {
				binariesPreferenceStore.setPath(nodeJsBinaryProvider.get(), nodeJsBinaryRoot.toURI());
				binariesPreferenceStore.save();
			}
			validateBinaries();
			cloneGitRepositoryAndInstallNpmPackages();

			// run and dispatch.
			compileAndExecute();
		} catch (ExitCodeException e) {
			e.printStackTrace();
			throw e;
		} finally {
			targetPlatformFile = null;
			targetPlatformInstallLocation = null;
		}
	}

	private void validateBinaries() throws ExitCodeException {
		IStatus status = nodeJsBinaryProvider.get().validate();
		if (!status.isOK()) {
			System.out.println(status.getMessage());
			if (null != status.getException()) {
				status.getException().printStackTrace();
			}
			throw new ExitCodeException(EXITCODE_CONFIGURATION_ERROR, status.getMessage(), status.getException());
		}
		if (null != targetPlatformFile) {
			status = npmBinaryProvider.get().validate();
			if (!status.isOK()) {
				System.out.println(status.getMessage());
				if (null != status.getException()) {
					status.getException().printStackTrace();
				}
				throw new ExitCodeException(EXITCODE_CONFIGURATION_ERROR, status.getMessage(), status.getException());
			}
		}
	}

	private void cloneGitRepositoryAndInstallNpmPackages() throws ExitCodeException {
		checkState(installLocationProvider instanceof HeadlessTargetPlatformInstallLocationProvider);

		if (targetPlatformSkipInstall) {

			/**
			 * TLDR; Silent check in case of invocation `--targetPlatformInstallLocation foo
			 * --targetPlatformSkipInstall`, provided <code>foo</code> can be used as location of extra resources (i.e.
			 * external libraries).
			 *
			 *
			 * With `targetPlatformSkipInstall` {@link #checkTargetPlatformConfigurations} is not validating install
			 * location but we might want to use it for extra sources (we assume user have manually prepared that, e.g.
			 * by previous invocation of the compiler). In such case subsequent invocations can skip installing, skip
			 * normal validation of the location (i.e. one that throws errors), but need to consider
			 * `targetPlatformInstallLocation`. Thus we set provided value in the
			 * HeadlessTargetPlatformInstallLocationProvider, other wise
			 * {@link #convertToFilesAddTargetPlatformAndCheckWritableDir} will not add resources to build.
			 *
			 * Note that {@link #convertToFilesAddTargetPlatformAndCheckWritableDir} cannot use raw user input (i.e.
			 * {@link #targetPlatformInstallLocation}) as it would get NPE when compiler is invoked without
			 * `targetPlatformInstallLocation` but with `targetPlatformSkipInstall`.
			 *
			 */

			if (null != targetPlatformInstallLocation
					&& targetPlatformInstallLocation.exists()
					&& targetPlatformInstallLocation.isDirectory()
					&& targetPlatformInstallLocation.canRead()
					&& targetPlatformInstallLocation.canWrite()) {
				((HeadlessTargetPlatformInstallLocationProvider) installLocationProvider)
						.setTargetPlatformInstallLocation(targetPlatformInstallLocation.toURI());
			}
			return;// no git setup, no package.json creation, no npm install
		}

		// at this point `targetPlatformSkipInstall=false`, `targetPlatformInstallLocation!=null`,
		// `targetPlatformFile=null` -> see {@link #checkTargetPlatformConfigurations}

		try {

			((HeadlessTargetPlatformInstallLocationProvider) installLocationProvider)
					.setTargetPlatformInstallLocation(targetPlatformInstallLocation.toURI());

			// pull n4jsd to install location
			java.net.URI gitRepositoryLocation = installLocationProvider
					.getTargetPlatformLocalGitRepositoryLocation();
			Path localClonePath = new File(gitRepositoryLocation).toPath();
			hardReset(gitLocationProvider.getGitLocation().getRepositoryRemoteURL(), localClonePath,
					getMasterBranch(), true);
			pull(localClonePath);

			// Convert target platform file into package JSON for now.
			TargetPlatformModel model = TargetPlatformModel.readValue(targetPlatformFile.toURI());
			PackageJson packageJson = PackageJson.createN4DefaultWithDependencies(model);
			File packageJsonFile = new File(targetPlatformInstallLocation, PackageJson.PACKAGE_JSON);
			try {
				if (!packageJsonFile.exists()) {
					packageJsonFile.createNewFile();
				}
				try (PrintWriter pw = new PrintWriter(packageJsonFile)) {
					pw.write(packageJson.toString());
					pw.flush();
					((HeadlessTargetPlatformInstallLocationProvider) installLocationProvider)
							.setTargetPlatformFileLocation(packageJsonFile.toURI());

					// install dependencies if needed
					final Map<String, String> dependencies = packageJson.getDependencies();
					if (null != dependencies) {
						final Iterable<String> packageNames = dependencies.keySet();
						for (final String packageName : packageNames) {
							try {
								final IStatus status = npmManager.installDependency(packageName,
										new NullProgressMonitor());
								if (!status.isOK()) {
									throw new ExitCodeException(EXITCODE_CONFIGURATION_ERROR, status.getMessage(),
											status.getException());
								}
							} catch (final IllegalBinaryStateException e) {
								final IStatus status = e.getStatus();
								throw new ExitCodeException(EXITCODE_CONFIGURATION_ERROR, status.getMessage(),
										status.getException());
							}
						}
					}

				}
			} catch (IOException e) {
				throw new ExitCodeException(EXITCODE_CONFIGURATION_ERROR,
						"Error while consuming target platform file.",
						e);
			}

		} catch (Exception e) {
			((HeadlessTargetPlatformInstallLocationProvider) installLocationProvider)
					.setTargetPlatformFileLocation(null);
			((HeadlessTargetPlatformInstallLocationProvider) installLocationProvider)
					.setTargetPlatformInstallLocation(null);
			if (e instanceof ExitCodeException) {
				throw e;
			}
			Throwables.propagateIfPossible(e);
		}
	}

	/**
	 * Checks state of target platform related configurations. Can perform file system modifications to make it
	 * consistent with provided data, in particular can clean {@link #targetPlatformInstallLocation}.
	 *
	 * <ul>
	 * <li>if it does not exist and --targetPlatformSkipInstall is not specified, location is created
	 * <li>if it does exist and --targetPlatformSkipInstall is not specified, delete contents of that location if any
	 * <li>if it does not exist and --targetPlatformSkipInstall is specified, proceed
	 * <li>if it does exist and --targetPlatformSkipInstall is not specified, proceed
	 * </ul>
	 *
	 * @throws ExitCodeException
	 *             if configuration is inconsistent or cannot be fixed.
	 */
	private void checkTargetPlatformConfigurations() throws ExitCodeException {
		if (targetPlatformSkipInstall) {
			// don't validate, target platform locations should not be used (but see special case in {@link
			// #cloneGitRepositoryAndInstallNpmPackages}
			return;
		}

		if (null == targetPlatformInstallLocation && null == targetPlatformFile) {
			// force `targetPlatformSkipInstall` for old setups and tests (previously we have treated `null ==
			// targetPlatformFile` similar to `targetPlatformSkipInstall` in some cases).
			// In general assume that if user provides no target platform data, it means skip installing npms
			targetPlatformSkipInstall = true;
			return;
		}

		if (null == targetPlatformInstallLocation) {
			throw new ExitCodeException(EXITCODE_CONFIGURATION_ERROR,
					"Target platform install location has to be specified, or `--targetPlatformSkipInstall` flag must be provided.");
		} else {
			if (targetPlatformInstallLocation.exists()) {
				if (!targetPlatformInstallLocation.isDirectory()) {
					throw new ExitCodeException(EXITCODE_CONFIGURATION_ERROR,
							"Target platform install location does not point to a directory at: "
									+ targetPlatformInstallLocation + ".");
				}
				if (!targetPlatformInstallLocation.canWrite()) {
					throw new ExitCodeException(EXITCODE_CONFIGURATION_ERROR,
							"Target platform install location cannot be accessed at: " + targetPlatformInstallLocation
									+ ".");
				}

				// GH-176 clean directory (but not <code>if(targetPlatformSkipInstall)</code>)
				try {
					FileDeleter.delete(targetPlatformInstallLocation);
				} catch (Exception e) {
					throw new ExitCodeException(EXITCODE_CONFIGURATION_ERROR,
							"Existing target platform install location cannot be cleared at: "
									+ targetPlatformInstallLocation + ".",
							e);
				}
			}

			try {
				checkState(targetPlatformInstallLocation.mkdirs());
			} catch (Exception e) {
				throw new ExitCodeException(EXITCODE_CONFIGURATION_ERROR,
						"Target platform install location cannot be created at: " + targetPlatformInstallLocation + ".",
						e);
			}

			if (null == targetPlatformFile) {
				throw new ExitCodeException(
						EXITCODE_CONFIGURATION_ERROR,
						"Target platform install location should be specified when a target platform file is configured.");
			} else {
				if (!targetPlatformFile.exists()) {
					throw new ExitCodeException(EXITCODE_CONFIGURATION_ERROR,
							"Target platform file does not exist at: " + targetPlatformFile + ".");
				}
				if (!targetPlatformFile.isFile()) {
					throw new ExitCodeException(EXITCODE_CONFIGURATION_ERROR,
							"Target platform file does not point to a file at: " + targetPlatformFile + ".");
				}
				if (!targetPlatformFile.canRead()) {
					throw new ExitCodeException(EXITCODE_CONFIGURATION_ERROR,
							"Target platform file content cannot be read at: " + targetPlatformFile + ".");
				}
			}
		}

	}

	/**
	 * Dumps available runners to a stream
	 *
	 * @param out
	 *            stream to print to
	 */
	private void printAvailableRunners(PrintStream out) {
		List<String> runnerIds = determineAvailableRunnerIds();
		if (runnerIds.isEmpty()) {
			out.println("No runners found.");
		} else {
			out.println("Available runners are: \n\t" + Joiner.on("\n\t").join(runnerIds));
		}
	}

	/**
	 * @return list of runner-IDs available.
	 */
	private List<String> determineAvailableRunnerIds() {
		return runnerRegistry.getDescriptors().values().stream()
				.map(a -> a.getId())
				.collect(Collectors.toList());
	}

	/**
	 * Dumps available testers to a stream
	 *
	 * @param out
	 *            stream to print to
	 */
	private void printAvailableTesters(PrintStream out) {
		List<String> testerIds = determineAvailableTesterIds();
		if (testerIds.isEmpty()) {
			out.println("No testers found.");
		} else {
			out.println("Available testers are: \n\t" + Joiner.on("\n\t").join(testerIds));
		}
	}

	/**
	 * @return list of tester-IDs available.
	 */
	private List<String> determineAvailableTesterIds() {
		return testerRegistry.getDescriptors().values().stream()
				.map(a -> a.getId())
				.collect(Collectors.toList());
	}

	/**
	 * @param string
	 *            to check
	 * @return true if null or just whitespaces.
	 */
	private static boolean isNotGiven(String string) {
		return string == null || string.trim().length() == 0;
	}

	/**
	 * Creates the injector for the test and injects all fields with the initialized injector.
	 */
	private void initInjection(Properties properties) {

		TypesPackage.eINSTANCE.getNsURI();
		TypeRefsPackage.eINSTANCE.getNsURI();
		N4JSPackage.eINSTANCE.getNsURI();
		N4mfPackage.eINSTANCE.getNsURI();
		XMLTypePackage.eINSTANCE.getNsURI();

		final Module cliTesterModule = override(new TesterModule())
				.with((Module) binder -> binder.bind(TestTreeTransformer.class).to(CliTestTreeTransformer.class));

		final Module module = Modules.combine(new N4JSRuntimeModule(), cliTesterModule,
				new N4JSHeadlessGeneratorModule(properties));
		RegularExpressionStandaloneSetup.doSetup();
		TypesStandaloneSetup.doSetup();
		N4MFStandaloneSetup.doSetup();
		TypeExpressionsStandaloneSetup.doSetup();
		final Injector injector = Guice.createInjector(module);
		new N4JSStandaloneSetup().register(injector);
		injector.injectMembers(this);
	}

	/**
	 * @param parser
	 *            cli
	 * @param ps
	 *            stream to write to
	 */
	private static void printExtendedUsage(CmdLineParser parser, PrintStream ps) {
		ps.println("Usage: java -jar n4jsc.jar [options] FILE FILE ...");
		parser.printUsage(ps);

	}

	/**
	 * Core algorithm to call the compiler followed initiating the runner or tester.
	 *
	 * @throws ExitCodeException
	 *             in error cases.
	 */
	private void compileAndExecute() throws ExitCodeException {
		if (debug) {
			System.out.println("N4JS compiling...");
		}
		try {
			switch (buildtype) {
			case singlefile:
				compileArgumentsAsSingleFiles();
				break;
			case projects:
				compileArgumentsAsProjects();
				break;
			case allprojects:
				compileAllProjects();
				break;
			case dontcompile:
			default:
				registerProjects();
			}
		} catch (N4JSCompileException e) {
			// dump all information to error-stream.
			e.userDump(System.err);
			throw new ExitCodeException(EXITCODE_COMPILE_ERROR);
		}

		if (null != testCatalogFile) {
			final String catalog = testCatalogSupplier.get();
			try (final FileOutputStream fos = new FileOutputStream(testCatalogFile)) {
				fos.write(catalog.getBytes());
				fos.flush();
			} catch (IOException e) {
				System.out.println("Error while writing test catalog file at: " + testCatalogFile);
				throw new ExitCodeException(EXITCODE_TEST_CATALOG_ASSEMBLATION_ERROR);
			}
		}

		// / Starting the runner
		if (runThisFile != null) {
			if (buildtype != Type.dontcompile) {
				flushAndIinsertMarkerInOutputs();
			}
			startRunner();
		} else if (testThisLocation != null) {
			if (buildtype != Type.dontcompile) {
				flushAndIinsertMarkerInOutputs();
			}
			startTester();
		}

		if (debug) {
			System.out.println("... done.");
		}
	}

	/**
	 * Inserts a Marker
	 */
	private static void flushAndIinsertMarkerInOutputs() {
		System.out.flush();
		System.err.flush();
		System.out.println(MARKER_RUNNER_OUPTUT);
		System.out.flush();
	}

	/**
	 * Actually start the requested file with the chosen runner. Workspace from headlesCompiler should be configured
	 * before calling this method.
	 *
	 * @throws ExitCodeException
	 *             in cases of errors
	 */
	private void startRunner() throws ExitCodeException {

		// 1. check if the file (and it's compiled counterpart) is in place.
		checkFileToRun();

		// 2. check if the chosen runner is available
		IRunnerDescriptor rd = checkRunner();

		try {
			Process process = runnerFrontEnd.run(rd.getId(), implementationId, systemLoader, fileToURI(runThisFile));

			int exit = process.waitFor();

			if (exit != 0) {
				throw new ExitCodeException(EXITCODE_RUNNER_STOPPED_WITH_ERROR, "The spawned runner '" + rd.getId()
						+ "' exited with code="
						+ exit + explanationOfExitCode(exit));
			}

		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ExitCodeException(EXITCODE_RUNNER_STOPPED_WITH_ERROR,
					"The spawned runner exited by throwing an exception", e1);
		}
	}

	/**
	 * @param exit
	 *            the code.
	 * @return empty string or explanation
	 */
	private static String explanationOfExitCode(int exit) {
		String ret = exitCodeExplained.get(exit);
		if (ret == null)
			return "";
		return " (" + ret + ")";
	}

	private void startTester() throws ExitCodeException {

		// 1. check if the file (and it's compiled counterpart) is in place.
		checkLocationToTest();

		// 2. check if the chosen tester is available
		ITesterDescriptor td = checkTester();

		try {
			Process process = testerFrontEnd.test(td.getId(), implementationId, fileToURI(testThisLocation));

			int exit = process.waitFor();

			if (exit != 0) {
				throw new ExitCodeException(EXITCODE_RUNNER_STOPPED_WITH_ERROR, "The spawned tester '" + td.getId()
						+ "' exited with code="
						+ exit + explanationOfExitCode(exit));
			}

		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ExitCodeException(EXITCODE_RUNNER_STOPPED_WITH_ERROR,
					"The spawned tester exited by throwing an exception", e1);
		} finally {
			testerFacade.shutdownFramework();
		}
	}

	/**
	 * Reads the runner name/ID from the --runWith command line option and checks for validity and, if successful,
	 * returns the {@link IRunnerDescriptor} for the given name/ID. Otherwise, an {@link ExitCodeException} is thrown.
	 *
	 * @return descriptor of runner selected via command line option --runWith
	 * @throws ExitCodeException
	 *             in Error cases
	 */
	private IRunnerDescriptor checkRunner() throws ExitCodeException {
		try {
			final List<IRunnerDescriptor> matchingRunnerDescs = findRunnerById(runner);

			if (matchingRunnerDescs.isEmpty()) {
				throw new ExitCodeException(EXITCODE_RUNNER_NOT_FOUND, "no runner found for id: " + runner);
			} else if (matchingRunnerDescs.size() > 1) {
				throw new ExitCodeException(EXITCODE_RUNNER_NOT_FOUND, "several runners match given id \"" + runner
						+ "\":\n\t" + Joiner.on("\n\t").join(matchingRunnerDescs));
			}

			return matchingRunnerDescs.get(0);
		} catch (IllegalArgumentException e) {
			// internally the registry throws IllegalArgumentExceptions if an runnerId is invalid.
			e.printStackTrace(); // dump problem, to help localize it. (it is really a rare case not expected to
			// happen.)
			throw new ExitCodeException(EXITCODE_RUNNER_NOT_FOUND, "no runner found for id: " + runner
					+ " Root cause is " + e.getMessage());
		}
	}

	private ITesterDescriptor checkTester() throws ExitCodeException {
		try {
			final List<ITesterDescriptor> matchingTesterDescs = findTesterById(tester);

			if (matchingTesterDescs.isEmpty()) {
				throw new ExitCodeException(EXITCODE_RUNNER_NOT_FOUND, "no tester found for id: " + tester);
			} else if (matchingTesterDescs.size() > 1) {
				throw new ExitCodeException(EXITCODE_RUNNER_NOT_FOUND, "several testers match given id \"" + tester
						+ "\":\n\t" + Joiner.on("\n\t").join(matchingTesterDescs));
			}

			return matchingTesterDescs.get(0);
		} catch (IllegalArgumentException e) {
			// internally the registry throws IllegalArgumentExceptions if an testerId is invalid.
			e.printStackTrace(); // dump problem, to help localize it. (it is really a rare case not expected to
			// happen.)
			throw new ExitCodeException(EXITCODE_RUNNER_NOT_FOUND, "no tester found for id: " + tester
					+ " Root cause is " + e.getMessage());
		}
	}

	private List<IRunnerDescriptor> findRunnerById(String runnerId) {
		if (runnerId == null || runnerId.trim().isEmpty())
			return Collections.emptyList();
		// 1st attempt: look for exact match
		final IRunnerDescriptor rd = runnerRegistry.getDescriptors().get(runnerId);
		if (rd != null)
			return Collections.singletonList(rd);
		// 2nd attempt: look for sloppy match (but full segments required!)
		final int r_len = runnerId.length();
		final List<IRunnerDescriptor> matchingRDs = determineAvailableRunnerIds().stream()
				.filter(id -> {
					final int id_len = id.length();
					return id_len >= r_len
							// a) id ends with runnerId (ignore case)
							&& id.substring(id_len - r_len, id_len).equalsIgnoreCase(runnerId)
					// b) full segment match (either full string or previous char is .)
							&& (id_len == r_len || id.charAt(id_len - r_len - 1) == '.');
				})
				.map(id -> runnerRegistry.getDescriptor(id))
				.collect(Collectors.toList());
		return matchingRDs;
	}

	private List<ITesterDescriptor> findTesterById(String testerId) {
		if (testerId == null || testerId.trim().isEmpty())
			return Collections.emptyList();
		// 1st attempt: look for exact match
		final ITesterDescriptor td = testerRegistry.getDescriptors().get(testerId);
		if (td != null)
			return Collections.singletonList(td);
		// 2nd attempt: look for sloppy match (but full segments required!)
		final int t_len = testerId.length();
		final List<ITesterDescriptor> matchingTDs = determineAvailableTesterIds().stream()
				.filter(id -> {
					final int id_len = id.length();
					return id_len >= t_len
							// a) id ends with runnerId (ignore case)
							&& id.substring(id_len - t_len, id_len).equalsIgnoreCase(testerId)
					// b) full segment match (either full string or previous char is .)
							&& (id_len == t_len || id.charAt(id_len - t_len - 1) == '.');
				})
				.map(id -> testerRegistry.getDescriptor(id))
				.collect(Collectors.toList());
		return matchingTDs;
	}

	/**
	 * Check if the file is there.
	 *
	 * @throws ExitCodeException
	 *             if module is missing
	 */
	private void checkFileToRun() throws ExitCodeException {
		if (runThisFile == null || !runThisFile.exists()) {
			throw new ExitCodeException(EXITCODE_MODULE_TO_RUN_NOT_FOUND);
		}
	}

	/**
	 * Check if the project, folder, or file is there.
	 *
	 * @throws ExitCodeException
	 *             if missing
	 */
	private void checkLocationToTest() throws ExitCodeException {
		if (testThisLocation == null || !testThisLocation.exists()) {
			throw new ExitCodeException(EXITCODE_MODULE_TO_RUN_NOT_FOUND);
		}
	}

	/**
	 * Compile type: single listed files.
	 *
	 * @return the headless compiler to be used in subsequent steps.
	 *
	 * @throws ExitCodeException
	 *             in cases of wrong configuration
	 * @throws N4JSCompileException
	 *             signaling compile-errors.
	 */
	private N4HeadlessCompiler compileArgumentsAsSingleFiles() throws ExitCodeException, N4JSCompileException {
		// check files exist and are readable:
		checkAllFilesAreSourcesAndReadable(srcFiles);

		if (projectLocations == null) {
			headless.compileSingleFiles(convertToFilesAddTargetPlatformAndCheckWritableDir(""), srcFiles);
		} else {
			headless.compileSingleFiles(convertToFilesAddTargetPlatformAndCheckWritableDir(projectLocations), srcFiles);
		}

		return headless;
	}

	/**
	 * Compile type: single projects
	 *
	 * @return the headless compiler to be used in subsequent steps.
	 *
	 * @throws ExitCodeException
	 *             in cases of wrong configuration
	 * @throws N4JSCompileException
	 *             in error cases
	 */
	private N4HeadlessCompiler compileArgumentsAsProjects() throws ExitCodeException, N4JSCompileException {

		if (projectLocations == null) {
			headless.compileProjects(convertToFilesAddTargetPlatformAndCheckWritableDir(""), srcFiles);
		} else {
			headless.compileProjects(convertToFilesAddTargetPlatformAndCheckWritableDir(projectLocations), srcFiles);
		}

		return headless;
	}

	/**
	 * Compile type: all projects.
	 *
	 * @return the headless compiler to be used in subsequent steps.
	 *
	 * @throws N4JSCompileException
	 *             in error cases
	 * @throws ExitCodeException
	 *             indicating cmdline parameters
	 */
	private N4HeadlessCompiler compileAllProjects() throws N4JSCompileException, ExitCodeException {
		if (projectLocations == null) {
			throw new ExitCodeException(EXITCODE_WRONG_CMDLINE_OPTIONS,
					"Require option for projectlocations to compile all projects.");
		} else {
			if (!srcFiles.isEmpty()) {
				warn("The list of source files is obsolete for built all projects. The following will be ignored: "
						+ Joiner.on(", ").join(srcFiles));
			}
			headless.compileAllProjects(convertToFilesAddTargetPlatformAndCheckWritableDir(projectLocations));
		}
		return headless;
	}

	/**
	 * Configure the injected file based workspace in order to run (called if no compile precedes the run)
	 */
	private void registerProjects() throws ExitCodeException, N4JSCompileException {
		if (projectLocations == null) {
			throw new ExitCodeException(EXITCODE_WRONG_CMDLINE_OPTIONS,
					"Require option for projectlocations.");
		} else {
			HeadlessHelper.registerProjects(convertToFilesAddTargetPlatformAndCheckWritableDir(projectLocations),
					fbWorkspace);
		}
	}

	/**
	 * Headless compiler setup after parsing the arguments for the proper properties.
	 *
	 * @return ready to use instance of {@link N4HeadlessCompiler}
	 */
	@Inject
	private N4HeadlessCompiler configHeadlessCompiler() {
		headless.setKeepOnCompiling(keepCompiling);
		headless.setCompileSourceCode(!testonly);
		headless.setProcessTestCode(!notests);
		headless.setCreateDebugOutput(debug);
		headless.setVerbose(verbose);
		if (log) {
			headless.setLogFile(logFile);
		}
		return headless;
	}

	/**
	 * Print to error stream.
	 *
	 * @param msg
	 *            message
	 */
	private static void warn(String msg) {
		if (msg == null)
			return;
		System.err.println(msg);
	}

	/**
	 * @return Properties or null
	 * @throws ExitCodeException
	 *             in cases of wrong config
	 */
	private Properties refProperties() throws ExitCodeException {
		if (preferencesProperties == null)
			return null;

		Properties ret = new Properties();
		try (FileInputStream stream = new FileInputStream(preferencesProperties)) {
			ret.load(stream);
		} catch (Exception e) {
			throw new ExitCodeException(EXITCODE_CONFIGURATION_ERROR,
					"Cannot load preference-properties from given file " + preferencesProperties, e);
		}
		return ret;
	}

	/**
	 * Ensure plain, readable files.
	 *
	 * @param files
	 *            to check
	 * @throws RuntimeException
	 *             if any file is not existent or not plain or not readable
	 */
	private void checkAllFilesAreSourcesAndReadable(List<File> files) {
		files.stream().forEach(
				f -> {
					if (!(f.exists() && f.canRead() && f.isFile())) {
						throw new RuntimeException("File '" + f.getAbsolutePath()
								+ "' is not a valid source file. (Base is " + new File(".").getAbsolutePath() + ")");
					}
				});
	}

	/**
	 * @param dirpaths
	 *            one or more paths separated by {@link File#pathSeparatorChar} OR empty string if no paths given.
	 */
	private List<File> convertToFilesAddTargetPlatformAndCheckWritableDir(String dirpaths) {
		final List<File> retList = new ArrayList<>();
		if (null != installLocationProvider.getTargetPlatformInstallLocation()) {
			final File tpLoc = new File(installLocationProvider.getTargetPlatformNodeModulesLocation());
			checkFileIsDirAndWriteable(tpLoc);
			retList.add(tpLoc);
		}
		if (!dirpaths.isEmpty()) {
			for (String dirpath : Splitter.on(File.pathSeparatorChar).split(dirpaths)) {
				final File ret = new File(dirpath);
				checkFileIsDirAndWriteable(ret);
				retList.add(ret);
			}
		}
		return retList;
	}

	private void checkFileIsDirAndWriteable(File f) {
		if (!f.exists()) {
			throw new RuntimeException("File " + f + " doesn't exist.");
		}
		if (!f.canWrite()) {
			throw new RuntimeException("File " + f + " is not writable.");
		}
		if (!f.isDirectory()) {
			throw new RuntimeException("File " + f + " is not a directory.");
		}
	}

	private static URI fileToURI(File file) {
		return URI.createURI(file.toURI().toString());
	}

	/**
	 * Dumping all options to screen.
	 */
	private void printDebugLines() {
		final char NL = '\n';
		StringBuffer sb = new StringBuffer();
		sb.append("N4jsc.options=").append(NL) //
				.append("debug=").append(debug).append(NL) //
				.append("runner=").append(runner).append(NL) //
				.append("listRunners=").append(listRunners).append(NL) //
				.append("runThisFile=").append(runThisFile).append(NL) //
				.append("tester=").append(tester).append(NL) //
				.append("listTesters=").append(listTesters).append(NL) //
				.append("testThisLocation=").append(testThisLocation).append(NL) //
				.append("preferencesProperties=").append(preferencesProperties).append(NL) //
				.append("projectLocations=").append(projectLocations).append(NL) //
				.append("type=").append(buildtype).append(NL)
				.append("testCatalogFile=").append(testCatalogFile).append(NL) //
				.append("srcFiles=");
		sb.append(srcFiles.stream()//
				.map(f -> f.toString())//
				.reduce((a, b) -> a + ", " + b)//
				.orElse("ø")).append(NL);
		sb.append("testonly=").append(testonly).append(NL) //
				.append("notests=").append(notests).append(NL) //
				.append("verbose=").append(verbose).append(NL);
		sb.append("Current execution directory = " + new File(".").getAbsolutePath());

		System.out.println(sb.toString());
	}

	/**
	 * Class Wrapping the information to shutdown VM in error-case. Remember to do user-output before throwing an
	 * instance of this class.
	 */
	protected static class ExitCodeException extends Exception {

		private int exitCode = 0;

		/**
		 * @return code to exit VM with.
		 */
		public int getExitCode() {
			return exitCode;
		}

		/**
		 * @param exitCode
		 *            code to shutdown VM with
		 */
		public ExitCodeException(int exitCode) {
			super();
			this.exitCode = exitCode;
		}

		/**
		 */
		public ExitCodeException(int exitCode, String message, Throwable cause, boolean enableSuppression,
				boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
			this.exitCode = exitCode;
		}

		/**
		 */
		public ExitCodeException(int exitcode, String string) {
			super(string);
			this.exitCode = exitcode;
		}

		/**
		 * @param exitCode
		 *            code to shutdown VM with
		 * @param message
		 *            user presentable cause
		 * @param cause
		 *            wrapped Exception.
		 */
		public ExitCodeException(int exitCode, String message, Throwable cause) {
			super(cause);
			this.exitCode = exitCode;
		}

		/**
		 * @param exitCode
		 *            code to shutdown VM with
		 * @param cause
		 *            wrapped Exception.
		 */
		public ExitCodeException(int exitCode, Throwable cause) {
			super(cause);
			this.exitCode = exitCode;
		}

		/**
		 * @return if a message is set.
		 */
		public boolean hasMessage() {
			return getMessage() != null && getMessage().length() > 0;
		}

	}

	/**
	 * Denoting the build-type.
	 */
	public static enum Type {
		/** Single file compile */
		singlefile("Build only single given file"),
		/** Compile given projects */
		projects("Compile given projects"),
		/** Compile all projects in project-locations folder */
		allprojects("Compile all projects in project-locations folder"),
		/** Default case */
		dontcompile("Do not compile");

		Type(String description) {
			this.description = description;

		}

		String description = "";
	}

}
