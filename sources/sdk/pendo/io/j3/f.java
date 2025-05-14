package sdk.pendo.io.j3;

import com.amplitude.reactnative.DatabaseConstants;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.k3.d;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/j3/f;", "", "Lsdk/pendo/io/k3/d$a;", "cursor", "", DatabaseConstants.KEY_FIELD, "", "a", "", ApiConstant.KEY_CODE, "", "b", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f1225a = new f();

    private f() {
    }

    public final String a(int code) {
        StringBuilder append;
        if (code < 1000 || code >= 5000) {
            append = new StringBuilder("Code must be in range [1000,5000): ").append(code);
        } else {
            if (!(1004 <= code && code < 1007)) {
                if (!(1015 <= code && code < 3000)) {
                    return null;
                }
            }
            append = new StringBuilder("Code ").append(code).append(" is reserved and may not be used.");
        }
        return append.toString();
    }

    public final void b(int code) {
        String a2 = a(code);
        if (a2 == null) {
            return;
        }
        Intrinsics.checkNotNull(a2);
        throw new IllegalArgumentException(a2.toString());
    }

    public final void a(d.a cursor, byte[] key) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(key, "key");
        int length = key.length;
        int i = 0;
        do {
            byte[] bArr = cursor.data;
            int i2 = cursor.com.facebook.react.uimanager.ViewProps.START java.lang.String;
            int i3 = cursor.com.facebook.react.uimanager.ViewProps.END java.lang.String;
            if (bArr != null) {
                while (i2 < i3) {
                    int i4 = i % length;
                    bArr[i2] = (byte) (bArr[i2] ^ key[i4]);
                    i2++;
                    i = i4 + 1;
                }
            }
        } while (cursor.b() != -1);
    }
}
