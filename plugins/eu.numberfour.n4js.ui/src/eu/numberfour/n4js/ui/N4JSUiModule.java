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
package eu.numberfour.n4js.ui;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.ui.editor.DirtyStateEditorSupport;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher.LastSegmentFinder;
import org.eclipse.xtext.ui.editor.contentassist.IContentAssistantFactory;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory;
import org.eclipse.xtext.ui.editor.doubleClicking.DoubleClickStrategyProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;
import org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingHelper;
import org.eclipse.xtext.ui.resource.DefaultResourceUIServiceProvider;
import org.eclipse.xtext.ui.shared.Access;
import org.eclipse.xtext.ui.util.IssueUtil;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.Singleton;

import eu.numberfour.n4js.CancelIndicatorBaseExtractor;
import eu.numberfour.n4js.N4JSRuntimeModule;
import eu.numberfour.n4js.binaries.BinariesPreferenceStore;
import eu.numberfour.n4js.binaries.OsgiBinariesPreferenceStore;
import eu.numberfour.n4js.external.ExternalLibraryWorkspace;
import eu.numberfour.n4js.external.GitCloneSupplier;
import eu.numberfour.n4js.external.TargetPlatformInstallLocationProvider;
import eu.numberfour.n4js.external.TypeDefinitionGitLocationProvider;
import eu.numberfour.n4js.generator.common.CompilerDescriptor;
import eu.numberfour.n4js.generator.common.IComposedGenerator;
import eu.numberfour.n4js.generator.common.IGeneratorMarkerSupport;
import eu.numberfour.n4js.generator.ui.GeneratorMarkerSupport;
import eu.numberfour.n4js.preferences.ExternalLibraryPreferenceStore;
import eu.numberfour.n4js.preferences.OsgiExternalLibraryPreferenceStore;
import eu.numberfour.n4js.projectModel.IN4JSCore;
import eu.numberfour.n4js.ts.findReferences.TargetURIKey;
import eu.numberfour.n4js.ts.ui.search.BuiltinSchemeAwareTargetURIKey;
import eu.numberfour.n4js.ts.ui.search.LabellingReferenceFinder;
import eu.numberfour.n4js.ui.building.FileSystemAccessWithoutTraceFileSupport;
import eu.numberfour.n4js.ui.building.N4JSBuilderParticipant;
import eu.numberfour.n4js.ui.building.instructions.ComposedGeneratorRegistry;
import eu.numberfour.n4js.ui.containers.N4JSAllContainersStateProvider;
import eu.numberfour.n4js.ui.contentassist.ContentAssistContextFactory;
import eu.numberfour.n4js.ui.contentassist.ContentAssistantFactory;
import eu.numberfour.n4js.ui.contentassist.CustomN4JSParser;
import eu.numberfour.n4js.ui.contentassist.SimpleLastSegmentFinder;
import eu.numberfour.n4js.ui.editor.AlwaysAddNatureCallback;
import eu.numberfour.n4js.ui.editor.N4JSDirtyStateEditorSupport;
import eu.numberfour.n4js.ui.editor.N4JSDoubleClickStrategyProvider;
import eu.numberfour.n4js.ui.editor.N4JSLocationInFileProvider;
import eu.numberfour.n4js.ui.editor.NFARAwareResourceForEditorInputFactory;
import eu.numberfour.n4js.ui.editor.autoedit.AutoEditStrategyProvider;
import eu.numberfour.n4js.ui.editor.syntaxcoloring.HighlightingConfiguration;
import eu.numberfour.n4js.ui.editor.syntaxcoloring.InvalidatingHighlightingHelper;
import eu.numberfour.n4js.ui.editor.syntaxcoloring.ParserBasedDocumentTokenSource;
import eu.numberfour.n4js.ui.editor.syntaxcoloring.TemplateAwarePartitionTokenScanner;
import eu.numberfour.n4js.ui.editor.syntaxcoloring.TemplateAwareTokenScanner;
import eu.numberfour.n4js.ui.editor.syntaxcoloring.TokenToAttributeIdMapper;
import eu.numberfour.n4js.ui.editor.syntaxcoloring.TokenTypeToPartitionMapper;
import eu.numberfour.n4js.ui.internal.ConsoleOutputStreamProvider;
import eu.numberfour.n4js.ui.internal.EclipseBasedN4JSWorkspace;
import eu.numberfour.n4js.ui.labeling.N4JSContentAssistLabelProvider;
import eu.numberfour.n4js.ui.labeling.N4JSHoverProvider;
import eu.numberfour.n4js.ui.labeling.N4JSHyperlinkLabelProvider;
import eu.numberfour.n4js.ui.preferences.N4JSBuilderPreferenceAccess;
import eu.numberfour.n4js.ui.projectModel.IN4JSEclipseCore;
import eu.numberfour.n4js.ui.quickfix.N4JSIssue;
import eu.numberfour.n4js.ui.quickfix.N4JSMarkerResolutionGenerator;
import eu.numberfour.n4js.ui.resource.OutputFolderAwareResourceServiceProvider;
import eu.numberfour.n4js.ui.search.N4JSReferenceQueryExecutor;
import eu.numberfour.n4js.ui.utils.CancelIndicatorUiExtractor;
import eu.numberfour.n4js.ui.validation.ManifestAwareResourceValidator;
import eu.numberfour.n4js.utils.process.OutputStreamProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
@SuppressWarnings("restriction")
public class N4JSUiModule extends eu.numberfour.n4js.ui.AbstractN4JSUiModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		bindIGenerator(binder);
	}

	/**
	 * Create a new UIModule in the given plugin.
	 */
	public N4JSUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	@Override
	public Class<? extends IXtextBuilderParticipant> bindIXtextBuilderParticipant() {
		return N4JSBuilderParticipant.class;
	}

	/**
	 * Re-binds the {@link Singleton @Singleton} {@link ExternalLibraryWorkspace N4JS external library workspace}
	 * instance declared and created in the {@link N4JSRuntimeModule}.
	 */
	public Provider<ExternalLibraryWorkspace> provideN4JSExternalLibraryWorkspace() {
		return Access.contributedProvider(ExternalLibraryWorkspace.class);
	}

	/**
	 * Re-binds the {@link GitCloneSupplier} to the singleton instance declared in the contribution module.
	 */
	public Provider<GitCloneSupplier> provideGitCloneSupplier() {
		return Access.contributedProvider(GitCloneSupplier.class);
	}

	@Override
	public Provider<IAllContainersState> provideIAllContainersState() {
		return new N4JSAllContainersStateProvider();
	}

	/**
	 * A custom {@link DirtyStateEditorSupport} that uses a custom JobFamily.
	 */
	public Class<? extends DirtyStateEditorSupport> bindDirtyStateEditorSupport() {
		return N4JSDirtyStateEditorSupport.class;
	}

	/**
	 * Bind the {@link ILocationInFileProvider} that is aware of derived elements.
	 */
	public Class<? extends ILocationInFileProvider> bindILocationInFileProvider() {
		return N4JSLocationInFileProvider.class;
	}

	/**
	 * Bind the {@link org.eclipse.xtext.ui.editor.findrefs.ReferenceQueryExecutor} that maps to types.
	 */
	public Class<? extends org.eclipse.xtext.ui.editor.findrefs.ReferenceQueryExecutor> bindReferenceQueryExecutor() {
		return N4JSReferenceQueryExecutor.class;
	}

	/**
	 * Bind the {@link org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder} that find references solely to types (and
	 * TVariables, IdentifiableElement and TEnumLiterals).
	 */
	public Class<? extends org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder> bindIReferenceFinder() {
		return LabellingReferenceFinder.class;
	}

	/**
	 * Bind the {@link IResourceValidator} that knows how to ignore files that are not in source folders according to
	 * the manifest.
	 */
	public Class<? extends IResourceValidator> bindResourceValidator() {
		return ManifestAwareResourceValidator.class;
	}

	/**
	 * De-configure the hard coded built in scheme from the runtime bundle.
	 */
	public Class<? extends XtextResourceSet> bindXtextResourceSet() {
		return SynchronizedXtextResourceSet.class;
	}

	/**
	 * Configure the IN4JSCore instance to use the implementation that is backed by the Eclipse workspace.
	 */
	public Class<? extends IN4JSCore> bindIN4JSCore() {
		return IN4JSEclipseCore.class;
	}

	/**
	 * Binds the external library preference store to use the {@link OsgiExternalLibraryPreferenceStore OSGi} one. This
	 * provider binding is required to share the same singleton instance between modules, hence injectors.
	 */
	public Provider<ExternalLibraryPreferenceStore> provideExternalLibraryPreferenceStore() {
		return Access.contributedProvider(ExternalLibraryPreferenceStore.class);
	}

	/**
	 * Binds the binaries preference store to use the {@link OsgiBinariesPreferenceStore} one. This provider binding is
	 * required to share the same singleton instance between modules, hence injectors.
	 */
	public Provider<BinariesPreferenceStore> provideBinariesPreferenceStore() {
		return Access.contributedProvider(BinariesPreferenceStore.class);
	}

	/**
	 * Binds the target platform location provider to the Eclipse based implementation. This requires a running
	 * {@link Platform platform} and an existing and available {@link IWorkspace workspace}.
	 */
	public Provider<TargetPlatformInstallLocationProvider> provideTargetPlatformInstallLocationProvider() {
		return Access.contributedProvider(TargetPlatformInstallLocationProvider.class);
	}

	/**
	 * Binds the type definition Git location provider.
	 */
	public Provider<TypeDefinitionGitLocationProvider> provideTypeDefinitionGitLocationProvider() {
		return Access.contributedProvider(TypeDefinitionGitLocationProvider.class);
	}

	/**
	 * Configure the IN4JSCore instance to use the implementation that is backed by the Eclipse workspace.
	 */
	public Provider<IN4JSEclipseCore> provideIN4JSEclipseCore() {
		return Access.contributedProvider(IN4JSEclipseCore.class);
	}

	/**
	 * Configure the IN4JSCore instance to use the implementation that is backed by the Eclipse workspace.
	 */
	public Provider<EclipseBasedN4JSWorkspace> provideEclipseBasedN4JSWorkspace() {
		return Access.contributedProvider(EclipseBasedN4JSWorkspace.class);
	}

	@Override
	public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		return NFARAwareResourceForEditorInputFactory.class;
	}

	/**
	 * custom builder preferences initializer that iterates over all default configurations provided by the sub
	 * generators contained in the found composite generators.
	 */
	@Override
	public void configureBuilderPreferenceStoreInitializer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer.class)
				.annotatedWith(com.google.inject.name.Names.named("builderPreferenceInitializer"))
				.to(eu.numberfour.n4js.ui.preferences.N4JSBuilderPreferenceAccess.Initializer.class);
	}

	/**
	 * @return custom builder preference access sets the activation of the builder participant to be always true so that
	 *         dirty state handling is always enabled.
	 */
	public Class<? extends BuilderPreferenceAccess> bindBuilderPreferenceAccess() {
		return N4JSBuilderPreferenceAccess.class;
	}

	/**
	 * @return iterates over all registered composite generators to pick up the default output configurations of their
	 *         contained sub generators
	 */
	public Class<? extends IOutputConfigurationProvider> bindIOutputConfigurationProvider() {
		return eu.numberfour.n4js.ui.building.N4JSOutputConfigurationProvider.class;
	}

	/**
	 * Filter fully qualified proposals also by their last segment and not only by their fully qualified name.
	 */
	public Class<? extends PrefixMatcher> bindPrefixMatcher() {
		return FQNPrefixMatcher.class;
	}

	/**
	 * No special treatment for uppercase module name segments.
	 */
	public Class<? extends LastSegmentFinder> bindLastSegmentFinder() {
		return SimpleLastSegmentFinder.class;
	}

	/**
	 * Binds the output stream provider to the console based one in the UI.
	 */
	public Class<? extends OutputStreamProvider> bindOutputStreamProvider() {
		return ConsoleOutputStreamProvider.class;
	}

	/**
	 * Bind the customized content assist parser infrastructure.
	 */
	public Class<? extends ParserBasedContentAssistContextFactory.StatefulFactory> bindStatefulParserBasedContentAssistContextFactory() {
		return ContentAssistContextFactory.class;
	}

	@Override
	public Class<? extends IContentAssistParser> bindIContentAssistParser() {
		return CustomN4JSParser.class;
	}

	/**
	 * Loads all registered composed generators via the extension point if there are some the first found composite
	 * generator is registered as IGenerator (this binding is required internally by the Xtext builder participant) or
	 * if there are no composite generators found, a dummy IComposedGenerator implementation is bound as IGenerator.
	 *
	 *
	 * @param binder
	 *            the Google guice binder
	 */
	private void bindIGenerator(Binder binder) {
		IComposedGenerator composedGenerator = null;
		List<IComposedGenerator> composedGenerators = ComposedGeneratorRegistry.getComposedGenerators();
		if (!composedGenerators.isEmpty()) {
			composedGenerator = composedGenerators.get(0);
		} else {
			composedGenerator = new IComposedGenerator() {

				@Override
				public void doGenerate(Resource input, IFileSystemAccess fsa) {
					// nothing to do, as dummy generator
				}

				@Override
				public Set<CompilerDescriptor> getCompilerDescriptors() {
					return new HashSet<>();
				}
			};
		}
		binder.bind(IGenerator.class).toInstance(composedGenerator);
	}

	/**
	 * Binds a specific label provider for the content assist use case.
	 */
	@Override
	public void configureContentProposalLabelProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.jface.viewers.ILabelProvider.class)
				.annotatedWith(org.eclipse.xtext.ui.editor.contentassist.ContentProposalLabelProvider.class)
				.to(N4JSContentAssistLabelProvider.class);
	}

	/**
	 * Binds a specific label provider for the hyper linking use case.
	 */
	@Override
	public void configureHyperlinkLabelProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.jface.viewers.ILabelProvider.class)
				.annotatedWith(org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkLabelProvider.class)
				.to(N4JSHyperlinkLabelProvider.class);
	}

	/**
	 * Bind custom MarkerResolutionGenerator.
	 */

	// ==== BEGIN injection work-around ====
	// work-around for an injection problem with MarkerResolutionGenerator:
	// MarkerResolutionGenerator contains a non-optional injection of IWorkbench which causes problems in
	// headless tests; we cannot change that in N4JSMarkerResolutionGenerator, because the field is private
	//
	// TODO remove work-around when this injection is changed to optional in a future Xtext version
	// (also remove related hacks in classes ChangeManager and IssueUtilN4 (search for "==== BEGIN"))
	//
	// public Class<? extends MarkerResolutionGenerator> bindMarkerResolutionGenerator() {
	// return N4JSMarkerResolutionGenerator.class;
	// }
	public void configureMarkerResolutionGenerator(com.google.inject.Binder binder) {
		if (org.eclipse.ui.PlatformUI.isWorkbenchRunning()) {
			binder.bind(MarkerResolutionGenerator.class).to(N4JSMarkerResolutionGenerator.class);
		}
	}

	// ==== END injection work-around ====

	/**
	 * Bind custom XtextEditor.
	 */
	public Class<? extends XtextEditor> bindXtextEditor() {
		return N4JSEditor.class;
	}

	/**
	 * Bind custom IssueUtil.
	 */
	public Class<? extends IssueUtil> bindIssueUtil() {
		return N4JSIssue.Util.class;
	}

	/**
	 * Bind custom IEObjectHoverProvider.
	 */
	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return N4JSHoverProvider.class;
	}

	/**
	 * Bind a callback that always add the nature silently.
	 */
	@Override
	public Class<? extends IXtextEditorCallback> bindIXtextEditorCallback() {
		return AlwaysAddNatureCallback.class;
	}

	/**
	 * Bind an implementation can handle find references to builtin types.
	 */
	public Class<? extends TargetURIKey> bindTargetURIKey() {
		return BuiltinSchemeAwareTargetURIKey.class;
	}

	/**
	 * Bind a proper token mapper for the special token types in N4JS
	 */
	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return TokenToAttributeIdMapper.class;
	}

	/**
	 * Bind a proper highlighting configuration
	 */
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return HighlightingConfiguration.class;
	}

	/**
	 * Configure the parser based token source for the coloring.
	 */
	public Class<? extends DocumentTokenSource> bindDocumentTokenSource() {
		return ParserBasedDocumentTokenSource.class;
	}

	/**
	 * Configure the token to partition type mapper.
	 */
	public Class<? extends TerminalsTokenTypeToPartitionMapper> bindTerminalTokenTypeToPartitionMapper() {
		return TokenTypeToPartitionMapper.class;
	}

	@Override
	public Class<? extends IHighlightingHelper> bindIHighlightingHelper() {
		return InvalidatingHighlightingHelper.class;
	}

	@Override
	public Class<? extends ITokenScanner> bindITokenScanner() {
		return TemplateAwareTokenScanner.class;
	}

	@Override
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return AutoEditStrategyProvider.class;
	}

	@Override
	public Class<? extends IContentAssistantFactory> bindIContentAssistantFactory() {
		return ContentAssistantFactory.class;
	}

	@Override
	public Class<? extends IPartitionTokenScanner> bindIPartitionTokenScanner() {
		return TemplateAwarePartitionTokenScanner.class;
	}

	/**
	 * Bind the double click strategy provider.
	 */
	public Class<? extends DoubleClickStrategyProvider> bindDoubleClickStrategyProvider() {
		return N4JSDoubleClickStrategyProvider.class;
	}

	/**
	 * Bind the mechanism to extract a cancel indicator (a "real" cancel indicator in IDE scenario, a "NullImpl" one in
	 * the headless compiler).
	 */
	public Class<? extends CancelIndicatorBaseExtractor> bindCancelIndicatorExtractor() {
		return CancelIndicatorUiExtractor.class;
	}

	/**
	 * Avoid unnecessary overhead for trace file lookup.
	 */
	public Class<? extends EclipseResourceFileSystemAccess2> bindEclipseResourceFileSystemAccess2() {
		return FileSystemAccessWithoutTraceFileSupport.class;
	}

	/**
	 * Filter out output-folders from compilation-processing.
	 */
	public Class<? extends DefaultResourceUIServiceProvider> bindResourceUIServiceProvider() {
		return OutputFolderAwareResourceServiceProvider.class;
	}

	/** Generating markers. */
	public Class<? extends IGeneratorMarkerSupport> bindIGeneratorMarkerSupport() {
		return GeneratorMarkerSupport.class;
	}
}
