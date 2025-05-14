package sdk.pendo.io.r4;

import sdk.pendo.io.y4.l3;
import sdk.pendo.io.y4.o0;

/* loaded from: classes6.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private final int f1525a;
    private final byte[] b;

    protected e(int i, byte[] bArr) {
        if (!l3.q(i)) {
            throw new IllegalArgumentException("'nameType' should be between 0 and 255");
        }
        if (bArr == null) {
            throw new NullPointerException("'encoded' cannot be null");
        }
        this.f1525a = i;
        this.b = l3.a(bArr);
    }

    public final byte[] a() {
        return l3.a(this.b);
    }

    public final int b() {
        return this.f1525a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f1525a == eVar.f1525a && sdk.pendo.io.d5.a.a(this.b, eVar.b);
    }

    public int hashCode() {
        return this.f1525a ^ sdk.pendo.io.d5.a.b(this.b);
    }

    public String toString() {
        return "{type=" + o0.b((short) this.f1525a) + ", value=" + sdk.pendo.io.e5.f.b(this.b) + "}";
    }
}
