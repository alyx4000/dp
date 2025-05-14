package sdk.pendo.io.c5;

import java.math.BigInteger;
import java.security.SecureRandom;
import sdk.pendo.io.z4.c;
import sdk.pendo.io.z4.t;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected BigInteger f954a;
    protected BigInteger b;
    protected BigInteger c;
    protected BigInteger d;
    protected BigInteger e;
    protected BigInteger f;
    protected BigInteger g;
    protected BigInteger h;
    protected t i;
    protected SecureRandom j;

    private BigInteger a() {
        BigInteger a2 = b.a(this.i, this.f954a, this.b);
        return this.e.subtract(this.b.modPow(this.f, this.f954a).multiply(a2).mod(this.f954a)).mod(this.f954a).modPow(this.g.multiply(this.f).add(this.c), this.f954a);
    }

    public BigInteger a(BigInteger bigInteger) {
        BigInteger a2 = b.a(this.f954a, bigInteger);
        this.e = a2;
        this.g = b.a(this.i, this.f954a, this.d, a2);
        BigInteger a3 = a();
        this.h = a3;
        return a3;
    }

    public void a(BigInteger bigInteger, BigInteger bigInteger2, t tVar, SecureRandom secureRandom) {
        this.f954a = bigInteger;
        this.b = bigInteger2;
        this.i = tVar;
        this.j = secureRandom;
    }

    public void a(c cVar, t tVar, SecureRandom secureRandom) {
        a(cVar.b(), cVar.a(), tVar, secureRandom);
    }
}
