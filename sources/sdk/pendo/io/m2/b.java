package sdk.pendo.io.m2;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"", "c", "", "a", "", "kotlinx-serialization-json"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class b {
    public static final byte a(char c) {
        if (c < '~') {
            return d.CHAR_TO_TOKEN[c];
        }
        return (byte) 0;
    }

    public static final char a(int i) {
        if (i < 117) {
            return d.ESCAPE_2_CHAR[i];
        }
        return (char) 0;
    }
}
