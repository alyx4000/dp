package sdk.pendo.io.y4;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public final class c1 {

    /* renamed from: a, reason: collision with root package name */
    private final short f1770a;
    private final byte[] b;

    public c1(short s, byte[] bArr) {
        if (!l3.e(s)) {
            throw new IllegalArgumentException("'nameType' must be from 0 to 255");
        }
        if (bArr == null) {
            throw new NullPointerException("'nameData' cannot be null");
        }
        if (bArr.length < 1 || !l3.o(bArr.length)) {
            throw new IllegalArgumentException("'nameData' must have length from 1 to 65535");
        }
        this.f1770a = s;
        this.b = bArr;
    }

    public void a(OutputStream outputStream) {
        l3.a(this.f1770a, outputStream);
        l3.a(this.b, outputStream);
    }

    public short b() {
        return this.f1770a;
    }

    public byte[] a() {
        return this.b;
    }

    public static c1 a(InputStream inputStream) {
        return new c1(l3.g(inputStream), l3.a(inputStream, 1));
    }
}
