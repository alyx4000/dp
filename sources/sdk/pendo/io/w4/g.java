package sdk.pendo.io.w4;

import java.math.BigInteger;

/* loaded from: classes4.dex */
class g implements a {

    /* renamed from: a, reason: collision with root package name */
    protected final BigInteger f1739a;

    g(BigInteger bigInteger) {
        this.f1739a = bigInteger;
    }

    @Override // sdk.pendo.io.w4.a
    public int a() {
        return 1;
    }

    @Override // sdk.pendo.io.w4.a
    public BigInteger b() {
        return this.f1739a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            return this.f1739a.equals(((g) obj).f1739a);
        }
        return false;
    }

    public int hashCode() {
        return this.f1739a.hashCode();
    }
}
