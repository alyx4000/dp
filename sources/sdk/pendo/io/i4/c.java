package sdk.pendo.io.i4;

import java.math.BigInteger;

/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private BigInteger f1206a;
    private BigInteger b;
    private BigInteger c;
    private d d;

    public c(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, d dVar) {
        this.f1206a = bigInteger3;
        this.c = bigInteger;
        this.b = bigInteger2;
        this.d = dVar;
    }

    public BigInteger a() {
        return this.f1206a;
    }

    public BigInteger b() {
        return this.c;
    }

    public BigInteger c() {
        return this.b;
    }

    public d d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return cVar.b().equals(this.c) && cVar.c().equals(this.b) && cVar.a().equals(this.f1206a);
    }

    public int hashCode() {
        return (b().hashCode() ^ c().hashCode()) ^ a().hashCode();
    }
}
