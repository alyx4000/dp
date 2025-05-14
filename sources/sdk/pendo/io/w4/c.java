package sdk.pendo.io.w4;

/* loaded from: classes4.dex */
class c implements e {

    /* renamed from: a, reason: collision with root package name */
    protected final int[] f1737a;

    c(int[] iArr) {
        this.f1737a = sdk.pendo.io.d5.a.a(iArr);
    }

    @Override // sdk.pendo.io.w4.e
    public int a() {
        return this.f1737a[r0.length - 1];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return sdk.pendo.io.d5.a.a(this.f1737a, ((c) obj).f1737a);
        }
        return false;
    }

    public int hashCode() {
        return sdk.pendo.io.d5.a.b(this.f1737a);
    }
}
