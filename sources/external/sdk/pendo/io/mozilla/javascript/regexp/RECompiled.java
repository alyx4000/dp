package external.sdk.pendo.io.mozilla.javascript.regexp;

import java.io.Serializable;

/* loaded from: classes2.dex */
class RECompiled implements Serializable {
    private static final long serialVersionUID = -6144956577595844213L;
    int anchorCh = -1;
    int classCount;
    RECharSet[] classList;
    int flags;
    int parenCount;
    byte[] program;
    final char[] source;

    RECompiled(String str) {
        this.source = str.toCharArray();
    }
}
