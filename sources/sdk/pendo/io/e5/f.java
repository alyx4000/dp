package sdk.pendo.io.e5;

import java.io.ByteArrayOutputStream;
import sdk.pendo.io.d5.i;

/* loaded from: classes6.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final g f1029a = new g();

    public static byte[] a(String str) {
        try {
            return f1029a.a(str, 0, str.length());
        } catch (Exception e) {
            throw new c("exception decoding Hex string: " + e.getMessage(), e);
        }
    }

    public static String b(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public static byte[] a(String str, int i, int i2) {
        try {
            return f1029a.a(str, i, i2);
        } catch (Exception e) {
            throw new c("exception decoding Hex string: " + e.getMessage(), e);
        }
    }

    public static String b(byte[] bArr, int i, int i2) {
        return i.b(a(bArr, i, i2));
    }

    public static byte[] a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f1029a.a(bArr, i, i2, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new e("exception encoding Hex string: " + e.getMessage(), e);
        }
    }
}
