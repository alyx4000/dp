package external.sdk.pendo.io.mozilla.javascript.debug;

import external.sdk.pendo.io.mozilla.javascript.Context;

/* loaded from: classes2.dex */
public interface Debugger {
    DebugFrame getFrame(Context context, DebuggableScript debuggableScript);

    void handleCompilationDone(Context context, DebuggableScript debuggableScript, String str);
}
