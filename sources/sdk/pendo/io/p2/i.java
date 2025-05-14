package sdk.pendo.io.p2;

/* loaded from: classes6.dex */
final class i {

    /* renamed from: a, reason: collision with root package name */
    private final Object f1494a;
    private final int b;

    i(Object obj) {
        this.b = System.identityHashCode(obj);
        this.f1494a = obj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.b == iVar.b && this.f1494a == iVar.f1494a;
    }

    public int hashCode() {
        return this.b;
    }
}
