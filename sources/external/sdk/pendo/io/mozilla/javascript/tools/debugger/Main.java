package external.sdk.pendo.io.mozilla.javascript.tools.debugger;

import com.google.logging.type.LogSeverity;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.ContextFactory;
import external.sdk.pendo.io.mozilla.javascript.Kit;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.tools.shell.Global;
import java.awt.Dimension;
import java.io.InputStream;
import java.io.PrintStream;
import javax.swing.JFrame;

/* loaded from: classes2.dex */
public class Main {
    private SwingGui debugGui;
    private Dim dim = new Dim();

    private static class IProxy implements Runnable, ScopeProvider {
        public static final int EXIT_ACTION = 1;
        public static final int SCOPE_PROVIDER = 2;
        private Scriptable scope;
        private final int type;

        public IProxy(int i) {
            this.type = i;
        }

        public static ScopeProvider newScopeProvider(Scriptable scriptable) {
            IProxy iProxy = new IProxy(2);
            iProxy.scope = scriptable;
            return iProxy;
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.debugger.ScopeProvider
        public Scriptable getScope() {
            if (this.type != 2) {
                Kit.codeBug();
            }
            if (this.scope == null) {
                Kit.codeBug();
            }
            return this.scope;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.type != 1) {
                Kit.codeBug();
            }
            System.exit(0);
        }
    }

    public Main(String str) {
        this.debugGui = new SwingGui(this.dim, str);
    }

    public static void main(String[] strArr) {
        Main main = new Main("Rhino JavaScript Debugger");
        main.doBreak();
        main.setExitAction(new IProxy(1));
        System.setIn(main.getIn());
        System.setOut(main.getOut());
        System.setErr(main.getErr());
        Global global = external.sdk.pendo.io.mozilla.javascript.tools.shell.Main.getGlobal();
        global.setIn(main.getIn());
        global.setOut(main.getOut());
        global.setErr(main.getErr());
        main.attachTo(external.sdk.pendo.io.mozilla.javascript.tools.shell.Main.shellContextFactory);
        main.setScope(global);
        main.pack();
        main.setSize(LogSeverity.CRITICAL_VALUE, 460);
        main.setVisible(true);
        external.sdk.pendo.io.mozilla.javascript.tools.shell.Main.exec(strArr);
    }

    public static Main mainEmbedded(ContextFactory contextFactory, Scriptable scriptable, String str) {
        return mainEmbeddedImpl(contextFactory, scriptable, str);
    }

    private static Main mainEmbeddedImpl(ContextFactory contextFactory, Object obj, String str) {
        if (str == null) {
            str = "Rhino JavaScript Debugger (embedded usage)";
        }
        Main main = new Main(str);
        main.doBreak();
        main.setExitAction(new IProxy(1));
        main.attachTo(contextFactory);
        if (obj instanceof ScopeProvider) {
            main.setScopeProvider((ScopeProvider) obj);
        } else {
            Scriptable scriptable = (Scriptable) obj;
            if (scriptable instanceof Global) {
                Global global = (Global) scriptable;
                global.setIn(main.getIn());
                global.setOut(main.getOut());
                global.setErr(main.getErr());
            }
            main.setScope(scriptable);
        }
        main.pack();
        main.setSize(LogSeverity.CRITICAL_VALUE, 460);
        main.setVisible(true);
        return main;
    }

    public void attachTo(ContextFactory contextFactory) {
        this.dim.attachTo(contextFactory);
    }

    public void clearAllBreakpoints() {
        this.dim.clearAllBreakpoints();
    }

    @Deprecated
    public void contextCreated(Context context) {
        throw new IllegalStateException();
    }

    @Deprecated
    public void contextEntered(Context context) {
        throw new IllegalStateException();
    }

    @Deprecated
    public void contextExited(Context context) {
        throw new IllegalStateException();
    }

    @Deprecated
    public void contextReleased(Context context) {
        throw new IllegalStateException();
    }

    public void detach() {
        this.dim.detach();
    }

    public void dispose() {
        clearAllBreakpoints();
        this.dim.go();
        this.debugGui.dispose();
        this.dim = null;
    }

    public void doBreak() {
        this.dim.setBreak();
    }

    public JFrame getDebugFrame() {
        return this.debugGui;
    }

    public PrintStream getErr() {
        return this.debugGui.getConsole().getErr();
    }

    public InputStream getIn() {
        return this.debugGui.getConsole().getIn();
    }

    public PrintStream getOut() {
        return this.debugGui.getConsole().getOut();
    }

    public void go() {
        this.dim.go();
    }

    public boolean isVisible() {
        return this.debugGui.isVisible();
    }

    public void pack() {
        this.debugGui.pack();
    }

    public void setBreakOnEnter(boolean z) {
        this.dim.setBreakOnEnter(z);
        this.debugGui.getMenubar().getBreakOnEnter().setSelected(z);
    }

    public void setBreakOnExceptions(boolean z) {
        this.dim.setBreakOnExceptions(z);
        this.debugGui.getMenubar().getBreakOnExceptions().setSelected(z);
    }

    public void setBreakOnReturn(boolean z) {
        this.dim.setBreakOnReturn(z);
        this.debugGui.getMenubar().getBreakOnReturn().setSelected(z);
    }

    public void setExitAction(Runnable runnable) {
        this.debugGui.setExitAction(runnable);
    }

    @Deprecated
    public void setOptimizationLevel(int i) {
    }

    public void setScope(Scriptable scriptable) {
        setScopeProvider(IProxy.newScopeProvider(scriptable));
    }

    public void setScopeProvider(ScopeProvider scopeProvider) {
        this.dim.setScopeProvider(scopeProvider);
    }

    public void setSize(int i, int i2) {
        this.debugGui.setSize(i, i2);
    }

    public void setSourceProvider(SourceProvider sourceProvider) {
        this.dim.setSourceProvider(sourceProvider);
    }

    public void setVisible(boolean z) {
        this.debugGui.setVisible(z);
    }

    public static Main mainEmbedded(ContextFactory contextFactory, ScopeProvider scopeProvider, String str) {
        return mainEmbeddedImpl(contextFactory, scopeProvider, str);
    }

    @Deprecated
    public void setSize(Dimension dimension) {
        this.debugGui.setSize(dimension.width, dimension.height);
    }

    public static Main mainEmbedded(String str) {
        ContextFactory global = ContextFactory.getGlobal();
        Global global2 = new Global();
        global2.init(global);
        return mainEmbedded(global, global2, str);
    }
}
