package sdk.pendo.io.y4;

/* loaded from: classes4.dex */
public abstract class e implements v2 {

    /* renamed from: a, reason: collision with root package name */
    private final sdk.pendo.io.z4.h f1774a;
    private volatile q1 b;

    protected e(sdk.pendo.io.z4.h hVar) {
        this.f1774a = hVar;
    }

    @Override // sdk.pendo.io.y4.v2
    public void G() {
    }

    @Override // sdk.pendo.io.y4.v2
    public short[] M() {
        return new short[]{1};
    }

    protected abstract int[] P();

    protected abstract v0[] Q();

    @Override // sdk.pendo.io.y4.v2
    public void a(short s, short s2) {
    }

    @Override // sdk.pendo.io.y4.v2
    public void a(short s, short s2, String str, Throwable th) {
    }

    @Override // sdk.pendo.io.y4.v2
    public boolean t() {
        return false;
    }

    @Override // sdk.pendo.io.y4.v2
    public void u() {
    }

    @Override // sdk.pendo.io.y4.v2
    public boolean w() {
        return false;
    }

    @Override // sdk.pendo.io.y4.v2
    public m2 z() {
        return new y();
    }

    @Override // sdk.pendo.io.y4.v2
    public void a(q1 q1Var) {
        this.b = q1Var;
    }
}
