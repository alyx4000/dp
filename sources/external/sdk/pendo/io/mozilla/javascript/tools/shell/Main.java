package external.sdk.pendo.io.mozilla.javascript.tools.shell;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.ContextAction;
import external.sdk.pendo.io.mozilla.javascript.Function;
import external.sdk.pendo.io.mozilla.javascript.GeneratedClassLoader;
import external.sdk.pendo.io.mozilla.javascript.Kit;
import external.sdk.pendo.io.mozilla.javascript.NativeArray;
import external.sdk.pendo.io.mozilla.javascript.RhinoException;
import external.sdk.pendo.io.mozilla.javascript.Script;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.SecurityController;
import external.sdk.pendo.io.mozilla.javascript.commonjs.module.ModuleScope;
import external.sdk.pendo.io.mozilla.javascript.commonjs.module.Require;
import external.sdk.pendo.io.mozilla.javascript.tools.SourceReader;
import external.sdk.pendo.io.mozilla.javascript.tools.ToolErrorReporter;
import io.sentry.protocol.SentryStackFrame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes2.dex */
public class Main {
    private static final int EXITCODE_FILE_NOT_FOUND = 4;
    private static final int EXITCODE_RUNTIME_ERROR = 3;
    protected static ToolErrorReporter errorReporter;
    static String mainModule;
    static List<String> modulePath;
    static Require require;
    private static SecurityProxy securityImpl;
    public static ShellContextFactory shellContextFactory = new ShellContextFactory();
    public static Global global = new Global();
    protected static int exitCode = 0;
    static boolean processStdin = true;
    static List<String> fileList = new ArrayList();
    static boolean sandboxed = false;
    static boolean useRequire = false;
    private static final ScriptCache scriptCache = new ScriptCache(32);

    private static class IProxy implements ContextAction<Object>, QuitAction {
        private static final int EVAL_INLINE_SCRIPT = 2;
        private static final int PROCESS_FILES = 1;
        private static final int SYSTEM_EXIT = 3;
        String[] args;
        String scriptText;
        private int type;

        IProxy(int i) {
            this.type = i;
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.QuitAction
        public void quit(Context context, int i) {
            if (this.type != 3) {
                throw Kit.codeBug();
            }
            System.exit(i);
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.ContextAction
        public Object run(Context context) {
            if (Main.useRequire) {
                Main.require = Main.global.installRequire(context, Main.modulePath, Main.sandboxed);
            }
            int i = this.type;
            if (i == 1) {
                Main.processFiles(context, this.args);
                return null;
            }
            if (i != 2) {
                throw Kit.codeBug();
            }
            Main.evalInlineScript(context, this.scriptText);
            return null;
        }
    }

    static class ScriptCache extends LinkedHashMap<String, ScriptReference> {
        private static final long serialVersionUID = -6866856136258508615L;
        int capacity;
        ReferenceQueue<Script> queue;

        ScriptCache(int i) {
            super(i + 1, 2.0f, true);
            this.capacity = i;
            this.queue = new ReferenceQueue<>();
        }

        ScriptReference get(String str, byte[] bArr) {
            while (true) {
                ScriptReference scriptReference = (ScriptReference) this.queue.poll();
                if (scriptReference == null) {
                    break;
                }
                remove(scriptReference.path);
            }
            ScriptReference scriptReference2 = get(str);
            if (scriptReference2 == null || Arrays.equals(bArr, scriptReference2.digest)) {
                return scriptReference2;
            }
            remove(scriptReference2.path);
            return null;
        }

        void put(String str, byte[] bArr, Script script) {
            put(str, new ScriptReference(str, bArr, script, this.queue));
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, ScriptReference> entry) {
            return size() > this.capacity;
        }
    }

    static class ScriptReference extends SoftReference<Script> {
        byte[] digest;
        String path;

        ScriptReference(String str, byte[] bArr, Script script, ReferenceQueue<Script> referenceQueue) {
            super(script, referenceQueue);
            this.path = str;
            this.digest = bArr;
        }
    }

    static {
        global.initQuitAction(new IProxy(3));
    }

    static void evalInlineScript(Context context, String str) {
        try {
            Script compileString = context.compileString(str, "<command>", 1, null);
            if (compileString != null) {
                compileString.exec(context, getShellScope());
            }
        } catch (RhinoException e) {
            ToolErrorReporter.reportException(context.getErrorReporter(), e);
            exitCode = 3;
        } catch (VirtualMachineError e2) {
            e2.printStackTrace();
            Context.reportError(ToolErrorReporter.getMessage("msg.uncaughtJSException", e2.toString()));
            exitCode = 3;
        }
    }

    public static int exec(String[] strArr) {
        ToolErrorReporter toolErrorReporter = new ToolErrorReporter(false, global.getErr());
        errorReporter = toolErrorReporter;
        shellContextFactory.setErrorReporter(toolErrorReporter);
        String[] processOptions = processOptions(strArr);
        int i = exitCode;
        if (i > 0) {
            return i;
        }
        if (processStdin) {
            fileList.add(null);
        }
        Global global2 = global;
        if (!global2.initialized) {
            global2.init(shellContextFactory);
        }
        IProxy iProxy = new IProxy(1);
        iProxy.args = processOptions;
        shellContextFactory.call(iProxy);
        return exitCode;
    }

    private static byte[] getDigest(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(obj instanceof String ? ((String) obj).getBytes(StandardCharsets.UTF_8) : (byte[]) obj);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static PrintStream getErr() {
        return getGlobal().getErr();
    }

    public static Global getGlobal() {
        return global;
    }

    public static InputStream getIn() {
        return getGlobal().getIn();
    }

    public static PrintStream getOut() {
        return getGlobal().getOut();
    }

    static Scriptable getScope(String str) {
        File file;
        URI uri;
        if (!useRequire) {
            return global;
        }
        if (str == null) {
            uri = new File(System.getProperty("user.dir")).toURI();
        } else {
            if (SourceReader.toUrl(str) != null) {
                try {
                    uri = new URI(str);
                } catch (URISyntaxException unused) {
                    file = new File(str);
                }
            } else {
                file = new File(str);
            }
            uri = file.toURI();
        }
        return new ModuleScope(global, uri, null);
    }

    static Scriptable getShellScope() {
        return getScope(null);
    }

    private static void initJavaPolicySecuritySupport() {
        try {
            SecurityProxy securityProxy = (SecurityProxy) JavaPolicySecurity.class.newInstance();
            securityImpl = securityProxy;
            SecurityController.initGlobal(securityProxy);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | LinkageError e) {
            throw new IllegalStateException("Can not load security support: " + e, e);
        }
    }

    private static Script loadCompiledScript(Context context, String str, byte[] bArr, Object obj) {
        if (bArr == null) {
            throw new FileNotFoundException(str);
        }
        int lastIndexOf = str.lastIndexOf(47);
        int i = lastIndexOf < 0 ? 0 : lastIndexOf + 1;
        int lastIndexOf2 = str.lastIndexOf(46);
        if (lastIndexOf2 < i) {
            lastIndexOf2 = str.length();
        }
        String substring = str.substring(i, lastIndexOf2);
        try {
            GeneratedClassLoader createLoader = SecurityController.createLoader(context.getApplicationClassLoader(), obj);
            Class<?> defineClass = createLoader.defineClass(substring, bArr);
            createLoader.linkClass(defineClass);
            if (Script.class.isAssignableFrom(defineClass)) {
                return (Script) defineClass.newInstance();
            }
            throw Context.reportRuntimeError("msg.must.implement.Script");
        } catch (IllegalAccessException e) {
            Context.reportError(e.toString());
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            Context.reportError(e2.toString());
            throw new RuntimeException(e2);
        }
    }

    public static void main(String[] strArr) {
        try {
            if (Boolean.getBoolean("rhino.use_java_policy_security")) {
                initJavaPolicySecuritySupport();
            }
        } catch (SecurityException e) {
            e.printStackTrace(System.err);
        }
        int exec = exec(strArr);
        if (exec != 0) {
            System.exit(exec);
        }
    }

    public static void processFile(Context context, Scriptable scriptable, String str) {
        SecurityProxy securityProxy = securityImpl;
        if (securityProxy == null) {
            processFileSecure(context, scriptable, str, null);
        } else {
            securityProxy.callProcessFileSecure(context, scriptable, str);
        }
    }

    public static void processFileNoThrow(Context context, Scriptable scriptable, String str) {
        try {
            processFile(context, scriptable, str);
        } catch (RhinoException e) {
            ToolErrorReporter.reportException(context.getErrorReporter(), e);
            exitCode = 3;
        } catch (IOException e2) {
            Context.reportError(ToolErrorReporter.getMessage("msg.couldnt.read.source", str, e2.getMessage()));
            exitCode = 4;
        } catch (VirtualMachineError e3) {
            e3.printStackTrace();
            Context.reportError(ToolErrorReporter.getMessage("msg.uncaughtJSException", e3.toString()));
            exitCode = 3;
        }
    }

    static void processFileSecure(Context context, Scriptable scriptable, String str, Object obj) {
        Script compileString;
        boolean endsWith = str.endsWith(".class");
        Object readFileOrUrl = readFileOrUrl(str, !endsWith);
        byte[] digest = getDigest(readFileOrUrl);
        String str2 = str + "_" + context.getOptimizationLevel();
        ScriptReference scriptReference = scriptCache.get(str2, digest);
        Script script = scriptReference != null ? scriptReference.get() : null;
        if (script == null) {
            if (endsWith) {
                compileString = loadCompiledScript(context, str, (byte[]) readFileOrUrl, obj);
            } else {
                String str3 = (String) readFileOrUrl;
                if (str3.length() > 0 && str3.charAt(0) == '#') {
                    for (int i = 1; i != str3.length(); i++) {
                        char charAt = str3.charAt(i);
                        if (charAt == '\n' || charAt == '\r') {
                            str3 = str3.substring(i);
                            break;
                        }
                    }
                }
                compileString = context.compileString(str3, str, 1, obj);
            }
            script = compileString;
            scriptCache.put(str2, digest, script);
        }
        if (script != null) {
            script.exec(context, scriptable);
        }
    }

    static void processFiles(Context context, String[] strArr) {
        Object[] objArr = new Object[strArr.length];
        System.arraycopy(strArr, 0, objArr, 0, strArr.length);
        global.defineProperty("arguments", context.newArray(global, objArr), 2);
        for (String str : fileList) {
            try {
                processSource(context, str);
            } catch (RhinoException e) {
                ToolErrorReporter.reportException(context.getErrorReporter(), e);
                exitCode = 3;
            } catch (IOException e2) {
                Context.reportError(ToolErrorReporter.getMessage("msg.couldnt.read.source", str, e2.getMessage()));
                exitCode = 4;
            } catch (VirtualMachineError e3) {
                e3.printStackTrace();
                Context.reportError(ToolErrorReporter.getMessage("msg.uncaughtJSException", e3.toString()));
                exitCode = 3;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x0171, code lost:
    
        if (r2.equals("-help") == false) goto L102;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String[] processOptions(java.lang.String[] r9) {
        /*
            Method dump skipped, instructions count: 443
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.tools.shell.Main.processOptions(java.lang.String[]):java.lang.String[]");
    }

    public static void processSource(Context context, String str) {
        if (str != null && !str.equals("-")) {
            if (useRequire && str.equals(mainModule)) {
                require.requireMain(context, str);
                return;
            } else {
                processFile(context, getScope(str), str);
                return;
            }
        }
        Scriptable shellScope = getShellScope();
        String characterEncoding = shellContextFactory.getCharacterEncoding();
        ShellConsole console = global.getConsole(characterEncoding != null ? Charset.forName(characterEncoding) : Charset.defaultCharset());
        if (str == null) {
            console.println(context.getImplementationVersion());
        }
        boolean z = false;
        int i = 1;
        while (!z) {
            String[] prompts = global.getPrompts(context);
            String str2 = str == null ? prompts[0] : null;
            console.flush();
            StringBuilder sb = new StringBuilder();
            while (true) {
                try {
                    String readLine = console.readLine(str2);
                    if (readLine == null) {
                        z = true;
                        break;
                    }
                    sb.append(readLine).append('\n');
                    i++;
                    if (context.stringIsCompilableUnit(sb.toString())) {
                        break;
                    } else {
                        str2 = prompts[1];
                    }
                } catch (IOException e) {
                    console.println(e.toString());
                }
            }
            try {
                try {
                    String sb2 = sb.toString();
                    Script compileString = context.compileString(sb2, "<stdin>", i, null);
                    if (compileString != null) {
                        Object exec = compileString.exec(context, shellScope);
                        if (exec != Context.getUndefinedValue() && (!(exec instanceof Function) || !sb2.trim().startsWith(SentryStackFrame.JsonKeys.FUNCTION))) {
                            try {
                                console.println(Context.toString(exec));
                            } catch (RhinoException e2) {
                                ToolErrorReporter.reportException(context.getErrorReporter(), e2);
                            }
                        }
                        NativeArray nativeArray = global.history;
                        nativeArray.put((int) nativeArray.getLength(), nativeArray, sb);
                    }
                } catch (VirtualMachineError e3) {
                    e3.printStackTrace();
                    Context.reportError(ToolErrorReporter.getMessage("msg.uncaughtJSException", e3.toString()));
                    exitCode = 3;
                }
            } catch (RhinoException e4) {
                ToolErrorReporter.reportException(context.getErrorReporter(), e4);
                exitCode = 3;
            }
        }
        console.println();
        console.flush();
    }

    private static Object readFileOrUrl(String str, boolean z) {
        return SourceReader.readFileOrUrl(str, z, shellContextFactory.getCharacterEncoding());
    }

    public static void setErr(PrintStream printStream) {
        getGlobal().setErr(printStream);
    }

    public static void setIn(InputStream inputStream) {
        getGlobal().setIn(inputStream);
    }

    public static void setOut(PrintStream printStream) {
        getGlobal().setOut(printStream);
    }
}
