package sdk.pendo.io.y4;

/* loaded from: classes4.dex */
public class w implements u1 {

    /* renamed from: a, reason: collision with root package name */
    protected sdk.pendo.io.z4.j f1805a;
    protected l b;
    protected i1 c;
    protected sdk.pendo.io.z4.c0 d;

    public w(sdk.pendo.io.z4.j jVar, sdk.pendo.io.z4.c0 c0Var, l lVar, i1 i1Var) {
        if (lVar == null) {
            throw new IllegalArgumentException("'certificate' cannot be null");
        }
        if (lVar.d()) {
            throw new IllegalArgumentException("'certificate' cannot be empty");
        }
        if (c0Var == null) {
            throw new IllegalArgumentException("'signer' cannot be null");
        }
        this.d = c0Var;
        this.f1805a = jVar;
        this.b = lVar;
        this.c = i1Var;
    }

    @Override // sdk.pendo.io.y4.u1
    public byte[] a(byte[] bArr) {
        return this.d.a(d(), bArr);
    }

    @Override // sdk.pendo.io.y4.u1
    public sdk.pendo.io.z4.d0 b() {
        return this.d.a(d());
    }

    @Override // sdk.pendo.io.y4.u1
    public i1 c() {
        return this.c;
    }

    protected i1 d() {
        if (!sdk.pendo.io.a5.h.c(this.f1805a)) {
            return null;
        }
        i1 c = c();
        if (c != null) {
            return c;
        }
        throw new IllegalStateException("'signatureAndHashAlgorithm' cannot be null for (D)TLS 1.2+");
    }

    @Override // sdk.pendo.io.y4.v1
    public l a() {
        return this.b;
    }
}
