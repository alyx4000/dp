package sdk.pendo.io.y4;

/* loaded from: classes4.dex */
public final class f1 implements Comparable {
    private final byte[] f;

    public f1(byte[] bArr) {
        this.f = sdk.pendo.io.d5.a.a(bArr);
    }

    public byte[] a() {
        return sdk.pendo.io.d5.a.a(this.f);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return sdk.pendo.io.d5.a.b(this.f, ((f1) obj).f);
    }

    public boolean equals(Object obj) {
        if (obj instanceof f1) {
            return sdk.pendo.io.d5.a.a(this.f, ((f1) obj).f);
        }
        return false;
    }

    public int hashCode() {
        return sdk.pendo.io.d5.a.b(this.f);
    }

    public String toString() {
        return sdk.pendo.io.e5.f.b(this.f);
    }
}
