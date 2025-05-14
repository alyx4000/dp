package sdk.pendo.io.i4;

import java.math.BigInteger;
import sdk.pendo.io.d5.g;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private BigInteger f1204a;
    private BigInteger b;
    private BigInteger c;
    private BigInteger d;
    private int e;
    private int f;
    private b g;

    public a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i, int i2, BigInteger bigInteger4, b bVar) {
        if (i2 != 0) {
            if (i2 > bigInteger.bitLength()) {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            }
            if (i2 < i) {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        if (i > bigInteger.bitLength() && !g.b("external.sdk.pendo.io.org.bouncycastle.dh.allow_unsafe_p_value")) {
            throw new IllegalArgumentException("unsafe p value so small specific l required");
        }
        this.f1204a = bigInteger2;
        this.b = bigInteger;
        this.c = bigInteger3;
        this.e = i;
        this.f = i2;
        this.d = bigInteger4;
        this.g = bVar;
    }

    public BigInteger a() {
        return this.f1204a;
    }

    public BigInteger b() {
        return this.b;
    }

    public BigInteger c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (c() != null) {
            if (!c().equals(aVar.c())) {
                return false;
            }
        } else if (aVar.c() != null) {
            return false;
        }
        return aVar.b().equals(this.b) && aVar.a().equals(this.f1204a);
    }

    public int hashCode() {
        return (b().hashCode() ^ a().hashCode()) ^ (c() != null ? c().hashCode() : 0);
    }
}
