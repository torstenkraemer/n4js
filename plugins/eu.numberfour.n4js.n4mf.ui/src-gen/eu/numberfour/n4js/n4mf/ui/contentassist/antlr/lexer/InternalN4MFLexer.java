package eu.numberfour.n4js.n4mf.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalN4MFLexer extends Lexer {
    public static final int App=44;
    public static final int ArtifactId=22;
    public static final int TestedProjects=12;
    public static final int KW_System=39;
    public static final int ProjectDependencies=8;
    public static final int ExecModule=23;
    public static final int LeftParenthesis=47;
    public static final int Test=41;
    public static final int ProjectVersion=11;
    public static final int Libraries=27;
    public static final int ModuleFilters=14;
    public static final int RightSquareBracket=54;
    public static final int VendorName=25;
    public static final int RuntimeEnvironment=9;
    public static final int RULE_ID=57;
    public static final int NoValidate=26;
    public static final int NoModuleWrap=16;
    public static final int RightParenthesis=48;
    public static final int Sources=33;
    public static final int Content=35;
    public static final int RULE_INT=58;
    public static final int ProjectType=20;
    public static final int External=32;
    public static final int RULE_ML_COMMENT=60;
    public static final int LeftSquareBracket=53;
    public static final int Resources=28;
    public static final int Library=36;
    public static final int Application=21;
    public static final int ImplementedProjects=7;
    public static final int Processor=29;
    public static final int User=42;
    public static final int ProjectName=19;
    public static final int In=46;
    public static final int VendorId=30;
    public static final int RULE_STRING=59;
    public static final int Node_builtin=17;
    public static final int N4js=40;
    public static final int Compile=34;
    public static final int Source=38;
    public static final int RULE_SL_COMMENT=61;
    public static final int ImplementationId=10;
    public static final int Comma=49;
    public static final int HyphenMinus=50;
    public static final int Output=37;
    public static final int MainModule=24;
    public static final int Colon=52;
    public static final int RightCurlyBracket=56;
    public static final int EOF=-1;
    public static final int ExtendedRuntimeEnvironment=4;
    public static final int FullStop=51;
    public static final int ModuleLoader=15;
    public static final int Commonjs=31;
    public static final int Lib=45;
    public static final int RULE_WS=62;
    public static final int LeftCurlyBracket=55;
    public static final int ProvidedRuntimeLibraries=5;
    public static final int RULE_ANY_OTHER=63;
    public static final int RequiredRuntimeLibraries=6;
    public static final int InitModules=18;
    public static final int API=43;
    public static final int RuntimeLibrary=13;

    // delegates
    // delegators

    public InternalN4MFLexer() {;} 
    public InternalN4MFLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalN4MFLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalN4MFLexer.g"; }

    // $ANTLR start "ExtendedRuntimeEnvironment"
    public final void mExtendedRuntimeEnvironment() throws RecognitionException {
        try {
            int _type = ExtendedRuntimeEnvironment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:19:28: ( 'ExtendedRuntimeEnvironment' )
            // InternalN4MFLexer.g:19:30: 'ExtendedRuntimeEnvironment'
            {
            match("ExtendedRuntimeEnvironment"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ExtendedRuntimeEnvironment"

    // $ANTLR start "ProvidedRuntimeLibraries"
    public final void mProvidedRuntimeLibraries() throws RecognitionException {
        try {
            int _type = ProvidedRuntimeLibraries;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:21:26: ( 'ProvidedRuntimeLibraries' )
            // InternalN4MFLexer.g:21:28: 'ProvidedRuntimeLibraries'
            {
            match("ProvidedRuntimeLibraries"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ProvidedRuntimeLibraries"

    // $ANTLR start "RequiredRuntimeLibraries"
    public final void mRequiredRuntimeLibraries() throws RecognitionException {
        try {
            int _type = RequiredRuntimeLibraries;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:23:26: ( 'RequiredRuntimeLibraries' )
            // InternalN4MFLexer.g:23:28: 'RequiredRuntimeLibraries'
            {
            match("RequiredRuntimeLibraries"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RequiredRuntimeLibraries"

    // $ANTLR start "ImplementedProjects"
    public final void mImplementedProjects() throws RecognitionException {
        try {
            int _type = ImplementedProjects;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:25:21: ( 'ImplementedProjects' )
            // InternalN4MFLexer.g:25:23: 'ImplementedProjects'
            {
            match("ImplementedProjects"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ImplementedProjects"

    // $ANTLR start "ProjectDependencies"
    public final void mProjectDependencies() throws RecognitionException {
        try {
            int _type = ProjectDependencies;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:27:21: ( 'ProjectDependencies' )
            // InternalN4MFLexer.g:27:23: 'ProjectDependencies'
            {
            match("ProjectDependencies"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ProjectDependencies"

    // $ANTLR start "RuntimeEnvironment"
    public final void mRuntimeEnvironment() throws RecognitionException {
        try {
            int _type = RuntimeEnvironment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:29:20: ( 'runtimeEnvironment' )
            // InternalN4MFLexer.g:29:22: 'runtimeEnvironment'
            {
            match("runtimeEnvironment"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RuntimeEnvironment"

    // $ANTLR start "ImplementationId"
    public final void mImplementationId() throws RecognitionException {
        try {
            int _type = ImplementationId;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:31:18: ( 'ImplementationId' )
            // InternalN4MFLexer.g:31:20: 'ImplementationId'
            {
            match("ImplementationId"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ImplementationId"

    // $ANTLR start "ProjectVersion"
    public final void mProjectVersion() throws RecognitionException {
        try {
            int _type = ProjectVersion;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:33:16: ( 'ProjectVersion' )
            // InternalN4MFLexer.g:33:18: 'ProjectVersion'
            {
            match("ProjectVersion"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ProjectVersion"

    // $ANTLR start "TestedProjects"
    public final void mTestedProjects() throws RecognitionException {
        try {
            int _type = TestedProjects;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:35:16: ( 'TestedProjects' )
            // InternalN4MFLexer.g:35:18: 'TestedProjects'
            {
            match("TestedProjects"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TestedProjects"

    // $ANTLR start "RuntimeLibrary"
    public final void mRuntimeLibrary() throws RecognitionException {
        try {
            int _type = RuntimeLibrary;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:37:16: ( 'runtimeLibrary' )
            // InternalN4MFLexer.g:37:18: 'runtimeLibrary'
            {
            match("runtimeLibrary"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RuntimeLibrary"

    // $ANTLR start "ModuleFilters"
    public final void mModuleFilters() throws RecognitionException {
        try {
            int _type = ModuleFilters;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:39:15: ( 'ModuleFilters' )
            // InternalN4MFLexer.g:39:17: 'ModuleFilters'
            {
            match("ModuleFilters"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ModuleFilters"

    // $ANTLR start "ModuleLoader"
    public final void mModuleLoader() throws RecognitionException {
        try {
            int _type = ModuleLoader;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:41:14: ( 'ModuleLoader' )
            // InternalN4MFLexer.g:41:16: 'ModuleLoader'
            {
            match("ModuleLoader"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ModuleLoader"

    // $ANTLR start "NoModuleWrap"
    public final void mNoModuleWrap() throws RecognitionException {
        try {
            int _type = NoModuleWrap;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:43:14: ( 'noModuleWrap' )
            // InternalN4MFLexer.g:43:16: 'noModuleWrap'
            {
            match("noModuleWrap"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NoModuleWrap"

    // $ANTLR start "Node_builtin"
    public final void mNode_builtin() throws RecognitionException {
        try {
            int _type = Node_builtin;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:45:14: ( 'node_builtin' )
            // InternalN4MFLexer.g:45:16: 'node_builtin'
            {
            match("node_builtin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Node_builtin"

    // $ANTLR start "InitModules"
    public final void mInitModules() throws RecognitionException {
        try {
            int _type = InitModules;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:47:13: ( 'InitModules' )
            // InternalN4MFLexer.g:47:15: 'InitModules'
            {
            match("InitModules"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "InitModules"

    // $ANTLR start "ProjectName"
    public final void mProjectName() throws RecognitionException {
        try {
            int _type = ProjectName;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:49:13: ( 'ProjectName' )
            // InternalN4MFLexer.g:49:15: 'ProjectName'
            {
            match("ProjectName"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ProjectName"

    // $ANTLR start "ProjectType"
    public final void mProjectType() throws RecognitionException {
        try {
            int _type = ProjectType;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:51:13: ( 'ProjectType' )
            // InternalN4MFLexer.g:51:15: 'ProjectType'
            {
            match("ProjectType"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ProjectType"

    // $ANTLR start "Application"
    public final void mApplication() throws RecognitionException {
        try {
            int _type = Application;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:53:13: ( 'application' )
            // InternalN4MFLexer.g:53:15: 'application'
            {
            match("application"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Application"

    // $ANTLR start "ArtifactId"
    public final void mArtifactId() throws RecognitionException {
        try {
            int _type = ArtifactId;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:55:12: ( 'ArtifactId' )
            // InternalN4MFLexer.g:55:14: 'ArtifactId'
            {
            match("ArtifactId"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ArtifactId"

    // $ANTLR start "ExecModule"
    public final void mExecModule() throws RecognitionException {
        try {
            int _type = ExecModule;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:57:12: ( 'ExecModule' )
            // InternalN4MFLexer.g:57:14: 'ExecModule'
            {
            match("ExecModule"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ExecModule"

    // $ANTLR start "MainModule"
    public final void mMainModule() throws RecognitionException {
        try {
            int _type = MainModule;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:59:12: ( 'MainModule' )
            // InternalN4MFLexer.g:59:14: 'MainModule'
            {
            match("MainModule"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MainModule"

    // $ANTLR start "VendorName"
    public final void mVendorName() throws RecognitionException {
        try {
            int _type = VendorName;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:61:12: ( 'VendorName' )
            // InternalN4MFLexer.g:61:14: 'VendorName'
            {
            match("VendorName"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VendorName"

    // $ANTLR start "NoValidate"
    public final void mNoValidate() throws RecognitionException {
        try {
            int _type = NoValidate;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:63:12: ( 'noValidate' )
            // InternalN4MFLexer.g:63:14: 'noValidate'
            {
            match("noValidate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NoValidate"

    // $ANTLR start "Libraries"
    public final void mLibraries() throws RecognitionException {
        try {
            int _type = Libraries;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:65:11: ( 'Libraries' )
            // InternalN4MFLexer.g:65:13: 'Libraries'
            {
            match("Libraries"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Libraries"

    // $ANTLR start "Resources"
    public final void mResources() throws RecognitionException {
        try {
            int _type = Resources;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:67:11: ( 'Resources' )
            // InternalN4MFLexer.g:67:13: 'Resources'
            {
            match("Resources"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Resources"

    // $ANTLR start "Processor"
    public final void mProcessor() throws RecognitionException {
        try {
            int _type = Processor;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:69:11: ( 'processor' )
            // InternalN4MFLexer.g:69:13: 'processor'
            {
            match("processor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Processor"

    // $ANTLR start "VendorId"
    public final void mVendorId() throws RecognitionException {
        try {
            int _type = VendorId;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:71:10: ( 'VendorId' )
            // InternalN4MFLexer.g:71:12: 'VendorId'
            {
            match("VendorId"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VendorId"

    // $ANTLR start "Commonjs"
    public final void mCommonjs() throws RecognitionException {
        try {
            int _type = Commonjs;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:73:10: ( 'commonjs' )
            // InternalN4MFLexer.g:73:12: 'commonjs'
            {
            match("commonjs"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Commonjs"

    // $ANTLR start "External"
    public final void mExternal() throws RecognitionException {
        try {
            int _type = External;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:75:10: ( 'external' )
            // InternalN4MFLexer.g:75:12: 'external'
            {
            match("external"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "External"

    // $ANTLR start "Sources"
    public final void mSources() throws RecognitionException {
        try {
            int _type = Sources;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:77:9: ( 'Sources' )
            // InternalN4MFLexer.g:77:11: 'Sources'
            {
            match("Sources"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Sources"

    // $ANTLR start "Compile"
    public final void mCompile() throws RecognitionException {
        try {
            int _type = Compile;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:79:9: ( 'compile' )
            // InternalN4MFLexer.g:79:11: 'compile'
            {
            match("compile"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Compile"

    // $ANTLR start "Content"
    public final void mContent() throws RecognitionException {
        try {
            int _type = Content;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:81:9: ( 'content' )
            // InternalN4MFLexer.g:81:11: 'content'
            {
            match("content"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Content"

    // $ANTLR start "Library"
    public final void mLibrary() throws RecognitionException {
        try {
            int _type = Library;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:83:9: ( 'library' )
            // InternalN4MFLexer.g:83:11: 'library'
            {
            match("library"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Library"

    // $ANTLR start "Output"
    public final void mOutput() throws RecognitionException {
        try {
            int _type = Output;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:85:8: ( 'Output' )
            // InternalN4MFLexer.g:85:10: 'Output'
            {
            match("Output"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Output"

    // $ANTLR start "Source"
    public final void mSource() throws RecognitionException {
        try {
            int _type = Source;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:87:8: ( 'source' )
            // InternalN4MFLexer.g:87:10: 'source'
            {
            match("source"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Source"

    // $ANTLR start "KW_System"
    public final void mKW_System() throws RecognitionException {
        try {
            int _type = KW_System;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:89:11: ( 'system' )
            // InternalN4MFLexer.g:89:13: 'system'
            {
            match("system"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_System"

    // $ANTLR start "N4js"
    public final void mN4js() throws RecognitionException {
        try {
            int _type = N4js;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:91:6: ( 'n4js' )
            // InternalN4MFLexer.g:91:8: 'n4js'
            {
            match("n4js"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "N4js"

    // $ANTLR start "Test"
    public final void mTest() throws RecognitionException {
        try {
            int _type = Test;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:93:6: ( 'test' )
            // InternalN4MFLexer.g:93:8: 'test'
            {
            match("test"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Test"

    // $ANTLR start "User"
    public final void mUser() throws RecognitionException {
        try {
            int _type = User;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:95:6: ( 'user' )
            // InternalN4MFLexer.g:95:8: 'user'
            {
            match("user"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "User"

    // $ANTLR start "API"
    public final void mAPI() throws RecognitionException {
        try {
            int _type = API;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:97:5: ( 'API' )
            // InternalN4MFLexer.g:97:7: 'API'
            {
            match("API"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "API"

    // $ANTLR start "App"
    public final void mApp() throws RecognitionException {
        try {
            int _type = App;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:99:5: ( 'app' )
            // InternalN4MFLexer.g:99:7: 'app'
            {
            match("app"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "App"

    // $ANTLR start "Lib"
    public final void mLib() throws RecognitionException {
        try {
            int _type = Lib;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:101:5: ( 'lib' )
            // InternalN4MFLexer.g:101:7: 'lib'
            {
            match("lib"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Lib"

    // $ANTLR start "In"
    public final void mIn() throws RecognitionException {
        try {
            int _type = In;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:103:4: ( 'in' )
            // InternalN4MFLexer.g:103:6: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "In"

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:105:17: ( '(' )
            // InternalN4MFLexer.g:105:19: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftParenthesis"

    // $ANTLR start "RightParenthesis"
    public final void mRightParenthesis() throws RecognitionException {
        try {
            int _type = RightParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:107:18: ( ')' )
            // InternalN4MFLexer.g:107:20: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesis"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:109:7: ( ',' )
            // InternalN4MFLexer.g:109:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "HyphenMinus"
    public final void mHyphenMinus() throws RecognitionException {
        try {
            int _type = HyphenMinus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:111:13: ( '-' )
            // InternalN4MFLexer.g:111:15: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinus"

    // $ANTLR start "FullStop"
    public final void mFullStop() throws RecognitionException {
        try {
            int _type = FullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:113:10: ( '.' )
            // InternalN4MFLexer.g:113:12: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStop"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:115:7: ( ':' )
            // InternalN4MFLexer.g:115:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:117:19: ( '[' )
            // InternalN4MFLexer.g:117:21: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftSquareBracket"

    // $ANTLR start "RightSquareBracket"
    public final void mRightSquareBracket() throws RecognitionException {
        try {
            int _type = RightSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:119:20: ( ']' )
            // InternalN4MFLexer.g:119:22: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightSquareBracket"

    // $ANTLR start "LeftCurlyBracket"
    public final void mLeftCurlyBracket() throws RecognitionException {
        try {
            int _type = LeftCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:121:18: ( '{' )
            // InternalN4MFLexer.g:121:20: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftCurlyBracket"

    // $ANTLR start "RightCurlyBracket"
    public final void mRightCurlyBracket() throws RecognitionException {
        try {
            int _type = RightCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:123:19: ( '}' )
            // InternalN4MFLexer.g:123:21: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightCurlyBracket"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:127:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '.' | '0' .. '9' )* )
            // InternalN4MFLexer.g:127:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '.' | '0' .. '9' )*
            {
            // InternalN4MFLexer.g:127:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalN4MFLexer.g:127:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalN4MFLexer.g:127:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '.' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='-' && LA2_0<='.')||(LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalN4MFLexer.g:
            	    {
            	    if ( (input.LA(1)>='-' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:129:10: ( ( '0' .. '9' )+ )
            // InternalN4MFLexer.g:129:12: ( '0' .. '9' )+
            {
            // InternalN4MFLexer.g:129:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalN4MFLexer.g:129:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:131:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalN4MFLexer.g:131:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalN4MFLexer.g:131:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalN4MFLexer.g:131:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalN4MFLexer.g:131:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalN4MFLexer.g:131:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalN4MFLexer.g:131:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalN4MFLexer.g:131:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalN4MFLexer.g:131:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalN4MFLexer.g:131:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalN4MFLexer.g:131:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:133:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalN4MFLexer.g:133:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalN4MFLexer.g:133:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalN4MFLexer.g:133:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:135:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalN4MFLexer.g:135:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalN4MFLexer.g:135:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalN4MFLexer.g:135:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalN4MFLexer.g:135:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalN4MFLexer.g:135:41: ( '\\r' )? '\\n'
                    {
                    // InternalN4MFLexer.g:135:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalN4MFLexer.g:135:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:137:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalN4MFLexer.g:137:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalN4MFLexer.g:137:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalN4MFLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalN4MFLexer.g:139:16: ( . )
            // InternalN4MFLexer.g:139:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalN4MFLexer.g:1:8: ( ExtendedRuntimeEnvironment | ProvidedRuntimeLibraries | RequiredRuntimeLibraries | ImplementedProjects | ProjectDependencies | RuntimeEnvironment | ImplementationId | ProjectVersion | TestedProjects | RuntimeLibrary | ModuleFilters | ModuleLoader | NoModuleWrap | Node_builtin | InitModules | ProjectName | ProjectType | Application | ArtifactId | ExecModule | MainModule | VendorName | NoValidate | Libraries | Resources | Processor | VendorId | Commonjs | External | Sources | Compile | Content | Library | Output | Source | KW_System | N4js | Test | User | API | App | Lib | In | LeftParenthesis | RightParenthesis | Comma | HyphenMinus | FullStop | Colon | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=60;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalN4MFLexer.g:1:10: ExtendedRuntimeEnvironment
                {
                mExtendedRuntimeEnvironment(); 

                }
                break;
            case 2 :
                // InternalN4MFLexer.g:1:37: ProvidedRuntimeLibraries
                {
                mProvidedRuntimeLibraries(); 

                }
                break;
            case 3 :
                // InternalN4MFLexer.g:1:62: RequiredRuntimeLibraries
                {
                mRequiredRuntimeLibraries(); 

                }
                break;
            case 4 :
                // InternalN4MFLexer.g:1:87: ImplementedProjects
                {
                mImplementedProjects(); 

                }
                break;
            case 5 :
                // InternalN4MFLexer.g:1:107: ProjectDependencies
                {
                mProjectDependencies(); 

                }
                break;
            case 6 :
                // InternalN4MFLexer.g:1:127: RuntimeEnvironment
                {
                mRuntimeEnvironment(); 

                }
                break;
            case 7 :
                // InternalN4MFLexer.g:1:146: ImplementationId
                {
                mImplementationId(); 

                }
                break;
            case 8 :
                // InternalN4MFLexer.g:1:163: ProjectVersion
                {
                mProjectVersion(); 

                }
                break;
            case 9 :
                // InternalN4MFLexer.g:1:178: TestedProjects
                {
                mTestedProjects(); 

                }
                break;
            case 10 :
                // InternalN4MFLexer.g:1:193: RuntimeLibrary
                {
                mRuntimeLibrary(); 

                }
                break;
            case 11 :
                // InternalN4MFLexer.g:1:208: ModuleFilters
                {
                mModuleFilters(); 

                }
                break;
            case 12 :
                // InternalN4MFLexer.g:1:222: ModuleLoader
                {
                mModuleLoader(); 

                }
                break;
            case 13 :
                // InternalN4MFLexer.g:1:235: NoModuleWrap
                {
                mNoModuleWrap(); 

                }
                break;
            case 14 :
                // InternalN4MFLexer.g:1:248: Node_builtin
                {
                mNode_builtin(); 

                }
                break;
            case 15 :
                // InternalN4MFLexer.g:1:261: InitModules
                {
                mInitModules(); 

                }
                break;
            case 16 :
                // InternalN4MFLexer.g:1:273: ProjectName
                {
                mProjectName(); 

                }
                break;
            case 17 :
                // InternalN4MFLexer.g:1:285: ProjectType
                {
                mProjectType(); 

                }
                break;
            case 18 :
                // InternalN4MFLexer.g:1:297: Application
                {
                mApplication(); 

                }
                break;
            case 19 :
                // InternalN4MFLexer.g:1:309: ArtifactId
                {
                mArtifactId(); 

                }
                break;
            case 20 :
                // InternalN4MFLexer.g:1:320: ExecModule
                {
                mExecModule(); 

                }
                break;
            case 21 :
                // InternalN4MFLexer.g:1:331: MainModule
                {
                mMainModule(); 

                }
                break;
            case 22 :
                // InternalN4MFLexer.g:1:342: VendorName
                {
                mVendorName(); 

                }
                break;
            case 23 :
                // InternalN4MFLexer.g:1:353: NoValidate
                {
                mNoValidate(); 

                }
                break;
            case 24 :
                // InternalN4MFLexer.g:1:364: Libraries
                {
                mLibraries(); 

                }
                break;
            case 25 :
                // InternalN4MFLexer.g:1:374: Resources
                {
                mResources(); 

                }
                break;
            case 26 :
                // InternalN4MFLexer.g:1:384: Processor
                {
                mProcessor(); 

                }
                break;
            case 27 :
                // InternalN4MFLexer.g:1:394: VendorId
                {
                mVendorId(); 

                }
                break;
            case 28 :
                // InternalN4MFLexer.g:1:403: Commonjs
                {
                mCommonjs(); 

                }
                break;
            case 29 :
                // InternalN4MFLexer.g:1:412: External
                {
                mExternal(); 

                }
                break;
            case 30 :
                // InternalN4MFLexer.g:1:421: Sources
                {
                mSources(); 

                }
                break;
            case 31 :
                // InternalN4MFLexer.g:1:429: Compile
                {
                mCompile(); 

                }
                break;
            case 32 :
                // InternalN4MFLexer.g:1:437: Content
                {
                mContent(); 

                }
                break;
            case 33 :
                // InternalN4MFLexer.g:1:445: Library
                {
                mLibrary(); 

                }
                break;
            case 34 :
                // InternalN4MFLexer.g:1:453: Output
                {
                mOutput(); 

                }
                break;
            case 35 :
                // InternalN4MFLexer.g:1:460: Source
                {
                mSource(); 

                }
                break;
            case 36 :
                // InternalN4MFLexer.g:1:467: KW_System
                {
                mKW_System(); 

                }
                break;
            case 37 :
                // InternalN4MFLexer.g:1:477: N4js
                {
                mN4js(); 

                }
                break;
            case 38 :
                // InternalN4MFLexer.g:1:482: Test
                {
                mTest(); 

                }
                break;
            case 39 :
                // InternalN4MFLexer.g:1:487: User
                {
                mUser(); 

                }
                break;
            case 40 :
                // InternalN4MFLexer.g:1:492: API
                {
                mAPI(); 

                }
                break;
            case 41 :
                // InternalN4MFLexer.g:1:496: App
                {
                mApp(); 

                }
                break;
            case 42 :
                // InternalN4MFLexer.g:1:500: Lib
                {
                mLib(); 

                }
                break;
            case 43 :
                // InternalN4MFLexer.g:1:504: In
                {
                mIn(); 

                }
                break;
            case 44 :
                // InternalN4MFLexer.g:1:507: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 45 :
                // InternalN4MFLexer.g:1:523: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 46 :
                // InternalN4MFLexer.g:1:540: Comma
                {
                mComma(); 

                }
                break;
            case 47 :
                // InternalN4MFLexer.g:1:546: HyphenMinus
                {
                mHyphenMinus(); 

                }
                break;
            case 48 :
                // InternalN4MFLexer.g:1:558: FullStop
                {
                mFullStop(); 

                }
                break;
            case 49 :
                // InternalN4MFLexer.g:1:567: Colon
                {
                mColon(); 

                }
                break;
            case 50 :
                // InternalN4MFLexer.g:1:573: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 51 :
                // InternalN4MFLexer.g:1:591: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 52 :
                // InternalN4MFLexer.g:1:610: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 53 :
                // InternalN4MFLexer.g:1:627: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 54 :
                // InternalN4MFLexer.g:1:645: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 55 :
                // InternalN4MFLexer.g:1:653: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 56 :
                // InternalN4MFLexer.g:1:662: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 57 :
                // InternalN4MFLexer.g:1:674: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 58 :
                // InternalN4MFLexer.g:1:690: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 59 :
                // InternalN4MFLexer.g:1:706: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 60 :
                // InternalN4MFLexer.g:1:714: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\26\52\12\uffff\1\50\2\uffff\3\50\2\uffff\1\52\1\uffff\31\52\1\163\17\uffff\17\52\1\u0085\1\52\1\u0087\7\52\1\u0091\5\52\1\uffff\17\52\1\u00a6\1\52\1\uffff\1\52\1\uffff\11\52\1\uffff\3\52\1\u00b5\1\u00b6\17\52\1\uffff\16\52\2\uffff\32\52\1\u00f0\1\u00f1\1\u00f2\27\52\1\u010e\1\u010f\1\52\1\u0111\1\u0112\3\uffff\27\52\1\u012a\2\52\1\u012d\2\uffff\1\u012e\2\uffff\10\52\1\u0137\16\52\1\uffff\1\u0147\1\u0148\2\uffff\1\52\1\u014a\6\52\1\uffff\10\52\1\u0159\2\52\1\u015c\1\52\1\u015e\1\u015f\2\uffff\1\52\1\uffff\3\52\1\u0164\1\u0165\3\52\1\u0169\5\52\1\uffff\2\52\1\uffff\1\u0171\2\uffff\4\52\2\uffff\3\52\1\uffff\4\52\1\u017d\1\u017e\1\u017f\1\uffff\12\52\1\u018a\3\uffff\3\52\1\u018e\4\52\1\u0193\1\u0194\1\uffff\3\52\1\uffff\4\52\2\uffff\5\52\1\u01a1\6\52\1\uffff\6\52\1\u01ae\2\52\1\u01b1\1\52\1\u01b3\1\uffff\2\52\1\uffff\1\52\1\uffff\12\52\1\u01c1\1\u01c2\1\52\2\uffff\1\u01c4\1\uffff";
    static final String DFA12_eofS =
        "\u01c5\uffff";
    static final String DFA12_minS =
        "\1\0\1\170\1\162\1\145\1\155\1\165\1\145\1\141\1\64\1\160\1\120\1\145\1\151\1\162\1\157\1\170\1\157\1\151\1\165\1\157\1\145\1\163\1\156\12\uffff\1\101\2\uffff\2\0\1\52\2\uffff\1\145\1\uffff\1\157\1\161\1\160\1\151\1\156\1\163\1\144\1\151\1\115\1\152\1\160\1\164\1\111\1\156\1\142\1\157\1\155\1\164\1\165\1\142\1\164\1\165\2\163\1\145\1\55\17\uffff\1\145\1\143\1\152\1\165\1\157\1\154\3\164\1\165\1\156\1\157\1\145\1\141\1\163\1\55\1\151\1\55\1\144\1\162\1\143\1\155\1\164\1\145\1\162\1\55\1\160\1\162\2\164\1\162\1\uffff\1\156\1\115\1\151\1\145\1\151\1\165\1\145\1\115\1\151\1\145\1\154\1\115\1\144\1\137\1\154\1\55\1\151\1\uffff\1\146\1\uffff\1\157\1\141\1\145\1\157\1\151\1\145\1\162\1\143\1\141\1\uffff\1\165\1\143\1\145\2\55\1\144\1\157\1\144\1\143\2\162\1\155\1\157\1\155\1\144\1\145\1\157\1\165\1\142\1\151\1\uffff\1\143\1\141\2\162\1\163\1\156\1\154\2\156\1\145\1\162\1\164\1\145\1\155\2\uffff\1\145\1\144\1\145\1\164\1\145\1\143\1\145\1\144\1\145\1\120\1\106\1\144\1\154\1\165\1\144\1\141\1\143\1\111\1\151\1\163\1\152\1\145\1\164\1\141\1\163\1\171\3\55\1\144\1\165\1\144\1\104\1\144\1\145\1\156\1\165\1\105\1\162\1\151\1\157\1\165\1\145\1\151\1\141\2\164\1\141\1\144\1\145\1\157\1\163\2\55\1\154\2\55\3\uffff\1\122\1\154\1\122\2\145\1\141\1\171\1\122\1\163\1\164\1\154\1\156\1\151\1\157\1\154\1\141\1\154\1\127\1\154\1\164\1\151\1\111\1\155\1\55\1\163\1\162\1\55\2\uffff\1\55\2\uffff\1\165\1\145\1\165\1\160\1\162\1\155\1\160\1\165\1\55\1\141\1\145\1\166\1\142\1\152\1\164\1\144\1\145\1\162\1\164\1\145\1\157\1\144\1\145\1\uffff\2\55\2\uffff\1\156\1\55\1\156\1\145\1\163\2\145\1\156\1\uffff\1\144\1\164\1\163\1\151\1\162\3\145\1\55\1\141\1\151\1\55\1\156\2\55\2\uffff\1\164\1\uffff\1\164\1\156\1\151\2\55\1\164\1\120\1\151\1\55\1\162\1\141\1\143\2\162\1\uffff\1\160\1\156\1\uffff\1\55\2\uffff\2\151\1\144\1\157\2\uffff\1\151\1\162\1\157\1\uffff\1\157\1\162\1\164\1\163\3\55\1\uffff\2\155\1\145\1\156\1\155\1\157\2\156\1\171\1\163\1\55\3\uffff\2\145\1\156\1\55\1\145\1\152\1\111\1\155\2\55\1\uffff\1\105\1\114\1\143\1\uffff\1\114\1\145\1\144\1\145\2\uffff\1\156\3\151\1\143\1\55\1\156\1\166\1\142\1\145\1\142\1\164\1\uffff\1\164\1\151\1\162\1\163\1\162\1\163\1\55\1\162\1\141\1\55\1\141\1\55\1\uffff\1\157\1\162\1\uffff\1\162\1\uffff\1\156\2\151\1\155\3\145\2\163\1\156\2\55\1\164\2\uffff\1\55\1\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\170\1\162\1\145\1\156\1\165\1\145\2\157\1\160\1\162\1\145\1\151\1\162\1\157\1\170\1\157\1\151\1\165\1\171\1\145\1\163\1\156\12\uffff\1\172\2\uffff\2\uffff\1\57\2\uffff\1\164\1\uffff\1\157\1\163\1\160\1\151\1\156\1\163\1\144\1\151\1\144\1\152\1\160\1\164\1\111\1\156\1\142\1\157\1\156\1\164\1\165\1\142\1\164\1\165\2\163\1\145\1\172\17\uffff\1\145\1\143\1\166\1\165\1\157\1\154\3\164\1\165\1\156\1\157\1\145\1\141\1\163\1\172\1\151\1\172\1\144\1\162\1\143\1\160\1\164\1\145\1\162\1\172\1\160\1\162\2\164\1\162\1\uffff\1\156\1\115\1\151\1\145\1\151\1\165\1\145\1\115\1\151\1\145\1\154\1\115\1\144\1\137\1\154\1\172\1\151\1\uffff\1\146\1\uffff\1\157\1\141\1\145\1\157\1\151\1\145\1\162\1\143\1\141\1\uffff\1\165\1\143\1\145\2\172\1\144\1\157\1\144\1\143\2\162\1\155\1\157\1\155\1\144\1\145\1\157\1\165\1\142\1\151\1\uffff\1\143\1\141\2\162\1\163\1\156\1\154\2\156\1\145\1\162\1\164\1\145\1\155\2\uffff\1\145\1\144\1\145\1\164\1\145\1\143\1\145\1\144\1\145\1\120\1\114\1\144\1\154\1\165\1\144\1\141\1\143\1\116\1\151\1\163\1\152\1\145\1\164\1\141\1\163\1\171\3\172\1\144\1\165\1\144\1\126\1\144\1\145\1\156\1\165\1\114\1\162\1\151\1\157\1\165\1\145\1\151\1\141\2\164\1\141\1\144\1\145\1\157\1\163\2\172\1\154\2\172\3\uffff\1\122\1\154\1\122\2\145\1\141\1\171\1\122\1\163\1\164\1\154\1\156\1\151\1\157\1\154\1\141\1\154\1\127\1\154\1\164\1\151\1\111\1\155\1\172\1\163\1\162\1\172\2\uffff\1\172\2\uffff\1\165\1\145\1\165\1\160\1\162\1\155\1\160\1\165\1\172\2\145\1\166\1\142\1\152\1\164\1\144\1\145\1\162\1\164\1\145\1\157\1\144\1\145\1\uffff\2\172\2\uffff\1\156\1\172\1\156\1\145\1\163\2\145\1\156\1\uffff\1\144\1\164\1\163\1\151\1\162\3\145\1\172\1\141\1\151\1\172\1\156\2\172\2\uffff\1\164\1\uffff\1\164\1\156\1\151\2\172\1\164\1\120\1\151\1\172\1\162\1\141\1\143\2\162\1\uffff\1\160\1\156\1\uffff\1\172\2\uffff\2\151\1\144\1\157\2\uffff\1\151\1\162\1\157\1\uffff\1\157\1\162\1\164\1\163\3\172\1\uffff\2\155\1\145\1\156\1\155\1\157\2\156\1\171\1\163\1\172\3\uffff\2\145\1\156\1\172\1\145\1\152\1\111\1\155\2\172\1\uffff\1\105\1\114\1\143\1\uffff\1\114\1\145\1\144\1\145\2\uffff\1\156\3\151\1\143\1\172\1\156\1\166\1\142\1\145\1\142\1\164\1\uffff\1\164\1\151\1\162\1\163\1\162\1\163\1\172\1\162\1\141\1\172\1\141\1\172\1\uffff\1\157\1\162\1\uffff\1\162\1\uffff\1\156\2\151\1\155\3\145\2\163\1\156\2\172\1\164\2\uffff\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\27\uffff\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\uffff\1\66\1\67\3\uffff\1\73\1\74\1\uffff\1\66\32\uffff\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\67\1\70\1\71\1\72\1\73\37\uffff\1\53\21\uffff\1\51\1\uffff\1\50\11\uffff\1\52\24\uffff\1\45\16\uffff\1\46\1\47\71\uffff\1\42\1\43\1\44\33\uffff\1\37\1\40\1\uffff\1\36\1\41\27\uffff\1\33\2\uffff\1\34\1\35\10\uffff\1\31\17\uffff\1\30\1\32\1\uffff\1\24\16\uffff\1\25\2\uffff\1\27\1\uffff\1\23\1\26\4\uffff\1\20\1\21\3\uffff\1\17\7\uffff\1\22\13\uffff\1\14\1\15\1\16\12\uffff\1\13\3\uffff\1\10\4\uffff\1\12\1\11\14\uffff\1\7\14\uffff\1\6\2\uffff\1\5\1\uffff\1\4\15\uffff\1\2\1\3\1\uffff\1\1";
    static final String DFA12_specialS =
        "\1\1\43\uffff\1\0\1\2\u019f\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\50\2\47\2\50\1\47\22\50\1\47\1\50\1\44\4\50\1\45\1\27\1\30\2\50\1\31\1\32\1\33\1\46\12\43\1\34\6\50\1\12\3\42\1\1\3\42\1\4\2\42\1\14\1\7\1\42\1\22\1\2\1\42\1\3\1\20\1\6\1\42\1\13\4\42\1\35\1\50\1\36\1\41\1\42\1\50\1\11\1\42\1\16\1\42\1\17\3\42\1\26\2\42\1\21\1\42\1\10\1\42\1\15\1\42\1\5\1\23\1\24\1\25\5\42\1\37\1\50\1\40\uff82\50",
            "\1\51",
            "\1\53",
            "\1\54",
            "\1\55\1\56",
            "\1\57",
            "\1\60",
            "\1\62\15\uffff\1\61",
            "\1\64\72\uffff\1\63",
            "\1\65",
            "\1\67\41\uffff\1\66",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100\11\uffff\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\0\120",
            "\0\120",
            "\1\121\4\uffff\1\122",
            "",
            "",
            "\1\125\16\uffff\1\124",
            "",
            "\1\126",
            "\1\127\1\uffff\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137\10\uffff\1\141\15\uffff\1\140",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\164",
            "\1\165",
            "\1\167\13\uffff\1\166",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\13\52\1\u0084\16\52",
            "\1\u0086",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b\2\uffff\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\21\52\1\u0090\10\52",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00a7",
            "",
            "\1\u00a8",
            "",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "",
            "",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de\5\uffff\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e7\4\uffff\1\u00e6",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6\11\uffff\1\u00f8\5\uffff\1\u00f9\1\uffff\1\u00f7",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe\6\uffff\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0110",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u012b",
            "\1\u012c",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0139\3\uffff\1\u0138",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\1\u0149",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u014b",
            "\1\u014c",
            "\1\u014d",
            "\1\u014e",
            "\1\u014f",
            "\1\u0150",
            "",
            "\1\u0151",
            "\1\u0152",
            "\1\u0153",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "\1\u0158",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u015a",
            "\1\u015b",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u015d",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\1\u0160",
            "",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0166",
            "\1\u0167",
            "\1\u0168",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u016a",
            "\1\u016b",
            "\1\u016c",
            "\1\u016d",
            "\1\u016e",
            "",
            "\1\u016f",
            "\1\u0170",
            "",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\1\u0172",
            "\1\u0173",
            "\1\u0174",
            "\1\u0175",
            "",
            "",
            "\1\u0176",
            "\1\u0177",
            "\1\u0178",
            "",
            "\1\u0179",
            "\1\u017a",
            "\1\u017b",
            "\1\u017c",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\1\u0180",
            "\1\u0181",
            "\1\u0182",
            "\1\u0183",
            "\1\u0184",
            "\1\u0185",
            "\1\u0186",
            "\1\u0187",
            "\1\u0188",
            "\1\u0189",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "",
            "\1\u018b",
            "\1\u018c",
            "\1\u018d",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u018f",
            "\1\u0190",
            "\1\u0191",
            "\1\u0192",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\1\u0195",
            "\1\u0196",
            "\1\u0197",
            "",
            "\1\u0198",
            "\1\u0199",
            "\1\u019a",
            "\1\u019b",
            "",
            "",
            "\1\u019c",
            "\1\u019d",
            "\1\u019e",
            "\1\u019f",
            "\1\u01a0",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u01a2",
            "\1\u01a3",
            "\1\u01a4",
            "\1\u01a5",
            "\1\u01a6",
            "\1\u01a7",
            "",
            "\1\u01a8",
            "\1\u01a9",
            "\1\u01aa",
            "\1\u01ab",
            "\1\u01ac",
            "\1\u01ad",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u01af",
            "\1\u01b0",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u01b2",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\1\u01b4",
            "\1\u01b5",
            "",
            "\1\u01b6",
            "",
            "\1\u01b7",
            "\1\u01b8",
            "\1\u01b9",
            "\1\u01ba",
            "\1\u01bb",
            "\1\u01bc",
            "\1\u01bd",
            "\1\u01be",
            "\1\u01bf",
            "\1\u01c0",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u01c3",
            "",
            "",
            "\2\52\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( ExtendedRuntimeEnvironment | ProvidedRuntimeLibraries | RequiredRuntimeLibraries | ImplementedProjects | ProjectDependencies | RuntimeEnvironment | ImplementationId | ProjectVersion | TestedProjects | RuntimeLibrary | ModuleFilters | ModuleLoader | NoModuleWrap | Node_builtin | InitModules | ProjectName | ProjectType | Application | ArtifactId | ExecModule | MainModule | VendorName | NoValidate | Libraries | Resources | Processor | VendorId | Commonjs | External | Sources | Compile | Content | Library | Output | Source | KW_System | N4js | Test | User | API | App | Lib | In | LeftParenthesis | RightParenthesis | Comma | HyphenMinus | FullStop | Colon | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_36 = input.LA(1);

                        s = -1;
                        if ( ((LA12_36>='\u0000' && LA12_36<='\uFFFF')) ) {s = 80;}

                        else s = 40;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='E') ) {s = 1;}

                        else if ( (LA12_0=='P') ) {s = 2;}

                        else if ( (LA12_0=='R') ) {s = 3;}

                        else if ( (LA12_0=='I') ) {s = 4;}

                        else if ( (LA12_0=='r') ) {s = 5;}

                        else if ( (LA12_0=='T') ) {s = 6;}

                        else if ( (LA12_0=='M') ) {s = 7;}

                        else if ( (LA12_0=='n') ) {s = 8;}

                        else if ( (LA12_0=='a') ) {s = 9;}

                        else if ( (LA12_0=='A') ) {s = 10;}

                        else if ( (LA12_0=='V') ) {s = 11;}

                        else if ( (LA12_0=='L') ) {s = 12;}

                        else if ( (LA12_0=='p') ) {s = 13;}

                        else if ( (LA12_0=='c') ) {s = 14;}

                        else if ( (LA12_0=='e') ) {s = 15;}

                        else if ( (LA12_0=='S') ) {s = 16;}

                        else if ( (LA12_0=='l') ) {s = 17;}

                        else if ( (LA12_0=='O') ) {s = 18;}

                        else if ( (LA12_0=='s') ) {s = 19;}

                        else if ( (LA12_0=='t') ) {s = 20;}

                        else if ( (LA12_0=='u') ) {s = 21;}

                        else if ( (LA12_0=='i') ) {s = 22;}

                        else if ( (LA12_0=='(') ) {s = 23;}

                        else if ( (LA12_0==')') ) {s = 24;}

                        else if ( (LA12_0==',') ) {s = 25;}

                        else if ( (LA12_0=='-') ) {s = 26;}

                        else if ( (LA12_0=='.') ) {s = 27;}

                        else if ( (LA12_0==':') ) {s = 28;}

                        else if ( (LA12_0=='[') ) {s = 29;}

                        else if ( (LA12_0==']') ) {s = 30;}

                        else if ( (LA12_0=='{') ) {s = 31;}

                        else if ( (LA12_0=='}') ) {s = 32;}

                        else if ( (LA12_0=='^') ) {s = 33;}

                        else if ( ((LA12_0>='B' && LA12_0<='D')||(LA12_0>='F' && LA12_0<='H')||(LA12_0>='J' && LA12_0<='K')||LA12_0=='N'||LA12_0=='Q'||LA12_0=='U'||(LA12_0>='W' && LA12_0<='Z')||LA12_0=='_'||LA12_0=='b'||LA12_0=='d'||(LA12_0>='f' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='k')||LA12_0=='m'||LA12_0=='o'||LA12_0=='q'||(LA12_0>='v' && LA12_0<='z')) ) {s = 34;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 35;}

                        else if ( (LA12_0=='\"') ) {s = 36;}

                        else if ( (LA12_0=='\'') ) {s = 37;}

                        else if ( (LA12_0=='/') ) {s = 38;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 39;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='*' && LA12_0<='+')||(LA12_0>=';' && LA12_0<='@')||LA12_0=='\\'||LA12_0=='`'||LA12_0=='|'||(LA12_0>='~' && LA12_0<='\uFFFF')) ) {s = 40;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_37 = input.LA(1);

                        s = -1;
                        if ( ((LA12_37>='\u0000' && LA12_37<='\uFFFF')) ) {s = 80;}

                        else s = 40;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}