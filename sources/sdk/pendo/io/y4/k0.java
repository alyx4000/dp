package sdk.pendo.io.y4;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class k0 {

    /* renamed from: a, reason: collision with root package name */
    protected final int f1782a;
    protected final byte[] b;

    public k0(int i, byte[] bArr) {
        if (!l3.o(i)) {
            throw new IllegalArgumentException("'namedGroup' should be a uint16");
        }
        if (bArr == null) {
            throw new NullPointerException("'keyExchange' cannot be null");
        }
        if (!a(bArr.length)) {
            throw new IllegalArgumentException("'keyExchange' must have length from 1 to (2^16 - 1)");
        }
        this.f1782a = i;
        this.b = bArr;
    }

    private static boolean a(int i) {
        return i > 0 && i < 65536;
    }

    public int b() {
        return this.f1782a;
    }

    public void a(OutputStream outputStream) {
        l3.a(b(), outputStream);
        l3.a(a(), outputStream);
    }

    public byte[] a() {
        return this.b;
    }

    public static k0 a(InputStream inputStream) {
        return new k0(l3.d(inputStream), l3.a(inputStream, 1));
    }
}
