package sdk.pendo.io.w4;

import java.math.BigInteger;

/* loaded from: classes4.dex */
class d implements f {

    /* renamed from: a, reason: collision with root package name */
    protected final a f1738a;
    protected final e b;

    d(a aVar, e eVar) {
        this.f1738a = aVar;
        this.b = eVar;
    }

    @Override // sdk.pendo.io.w4.a
    public int a() {
        return this.f1738a.a() * this.b.a();
    }

    @Override // sdk.pendo.io.w4.a
    public BigInteger b() {
        return this.f1738a.b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f1738a.equals(dVar.f1738a) && this.b.equals(dVar.b);
    }

    public int hashCode() {
        return this.f1738a.hashCode() ^ sdk.pendo.io.d5.d.a(this.b.hashCode(), 16);
    }
}
