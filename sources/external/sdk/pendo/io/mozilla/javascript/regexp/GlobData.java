package external.sdk.pendo.io.mozilla.javascript.regexp;

import external.sdk.pendo.io.mozilla.javascript.Function;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;

/* loaded from: classes2.dex */
final class GlobData {
    Scriptable arrayobj;
    StringBuilder charBuf;
    int dollar = -1;
    boolean global;
    Function lambda;
    int leftIndex;
    int mode;
    String repstr;
    String str;

    GlobData() {
    }
}
