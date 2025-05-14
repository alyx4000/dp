package sdk.pendo.io.m2;

import com.facebook.common.callercontext.ContextChain;
import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

@Metadata(d1 = {"\u00004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0007\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0018\u0010\u0003\u001a\u00020\b*\u00060\u0004j\u0002`\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u0015\u0010\u0003\u001a\u0004\u0018\u00010\t*\u00020\u0006H\u0000¢\u0006\u0004\b\u0003\u0010\n\"(\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\" \u0010\u0018\u001a\u00020\u00128\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"", ContextChain.TAG_INFRA, "", "a", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "value", "", "", "(Ljava/lang/String;)Ljava/lang/Boolean;", "", "[Ljava/lang/String;", "getESCAPE_STRINGS", "()[Ljava/lang/String;", "getESCAPE_STRINGS$annotations", "()V", "ESCAPE_STRINGS", "", "b", "[B", "getESCAPE_MARKERS", "()[B", "getESCAPE_MARKERS$annotations", "ESCAPE_MARKERS", "kotlinx-serialization-json"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f1385a;
    private static final byte[] b;

    static {
        String[] strArr = new String[93];
        for (int i = 0; i < 32; i++) {
            strArr[i] = "\\u" + a(i >> 12) + a(i >> 8) + a(i >> 4) + a(i);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f1385a = strArr;
        byte[] bArr = new byte[93];
        for (int i2 = 0; i2 < 32; i2++) {
            bArr[i2] = 1;
        }
        bArr[34] = (byte) 34;
        bArr[92] = (byte) 92;
        bArr[9] = (byte) 116;
        bArr[8] = (byte) 98;
        bArr[10] = (byte) 110;
        bArr[13] = (byte) 114;
        bArr[12] = (byte) 102;
        b = bArr;
    }

    private static final char a(int i) {
        int i2 = i & 15;
        return (char) (i2 < 10 ? i2 + 48 : (i2 - 10) + 97);
    }

    public static final void a(StringBuilder sb, String value) {
        int i;
        int i2;
        char charAt;
        String[] strArr;
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        sb.append(Typography.quote);
        int length = value.length();
        int i3 = 0;
        loop0: while (true) {
            i = i3;
            while (i3 < length) {
                i2 = i3 + 1;
                charAt = value.charAt(i3);
                strArr = f1385a;
                if (charAt >= strArr.length || strArr[charAt] == null) {
                    i3 = i2;
                }
            }
            sb.append((CharSequence) value, i, i3);
            sb.append(strArr[charAt]);
            i3 = i2;
        }
        if (i != 0) {
            sb.append((CharSequence) value, i, value.length());
        } else {
            sb.append(value);
        }
        sb.append(Typography.quote);
    }

    public static final Boolean a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.equals(str, "true", true)) {
            return Boolean.TRUE;
        }
        if (StringsKt.equals(str, Constants.CASEFIRST_FALSE, true)) {
            return Boolean.FALSE;
        }
        return null;
    }
}
