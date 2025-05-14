package sdk.pendo.io.y4;

import java.io.InputStream;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class e1 {

    /* renamed from: a, reason: collision with root package name */
    protected BigInteger f1775a;
    protected BigInteger b;
    protected BigInteger c;
    protected byte[] d;

    public e1(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr, BigInteger bigInteger3) {
        this.f1775a = bigInteger;
        this.b = bigInteger2;
        this.d = sdk.pendo.io.d5.a.a(bArr);
        this.c = bigInteger3;
    }

    public BigInteger a() {
        return this.c;
    }

    public BigInteger b() {
        return this.b;
    }

    public BigInteger c() {
        return this.f1775a;
    }

    public byte[] d() {
        return this.d;
    }

    public static e1 a(InputStream inputStream) {
        return new e1(c3.a(inputStream), c3.a(inputStream), l3.c(inputStream, 1), c3.a(inputStream));
    }
}
