package sdk.pendo.io.y4;

/* loaded from: classes4.dex */
class k3 implements j3 {

    /* renamed from: a, reason: collision with root package name */
    final byte[] f1784a;
    final g1 b;
    boolean c;

    k3(byte[] bArr, g1 g1Var) {
        if (bArr == null) {
            throw new IllegalArgumentException("'sessionID' cannot be null");
        }
        if (bArr.length > 32) {
            throw new IllegalArgumentException("'sessionID' cannot be longer than 32 bytes");
        }
        this.f1784a = sdk.pendo.io.d5.a.a(bArr);
        this.b = g1Var;
        this.c = bArr.length > 0 && g1Var != null;
    }

    @Override // sdk.pendo.io.y4.j3
    public synchronized byte[] a() {
        return this.f1784a;
    }

    @Override // sdk.pendo.io.y4.j3
    public synchronized boolean b() {
        return this.c;
    }

    @Override // sdk.pendo.io.y4.j3
    public synchronized g1 c() {
        g1 g1Var;
        g1Var = this.b;
        return g1Var == null ? null : g1Var.b();
    }

    @Override // sdk.pendo.io.y4.j3
    public synchronized void invalidate() {
        this.c = false;
    }
}
