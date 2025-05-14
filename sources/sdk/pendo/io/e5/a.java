package sdk.pendo.io.e5;

import java.io.ByteArrayOutputStream;
import sdk.pendo.io.d5.i;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final d f1027a = new b();

    public static byte[] a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((str.length() / 4) * 3);
        try {
            f1027a.a(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new c("unable to decode base64 string: " + e.getMessage(), e);
        }
    }

    public static String b(byte[] bArr, int i, int i2) {
        return i.b(a(bArr, i, i2));
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        d dVar = f1027a;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(dVar.a(i2));
        try {
            dVar.a(bArr, i, i2, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new e("exception encoding base64 string: " + e.getMessage(), e);
        }
    }

    public static String a(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }
}
