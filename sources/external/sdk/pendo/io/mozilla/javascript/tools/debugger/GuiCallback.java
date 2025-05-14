package external.sdk.pendo.io.mozilla.javascript.tools.debugger;

import external.sdk.pendo.io.mozilla.javascript.tools.debugger.Dim;

/* loaded from: classes2.dex */
public interface GuiCallback {
    void dispatchNextGuiEvent();

    void enterInterrupt(Dim.StackFrame stackFrame, String str, String str2);

    boolean isGuiEventThread();

    void updateSourceText(Dim.SourceInfo sourceInfo);
}
