package sdk.pendo.io.y4;

import java.io.InputStream;

/* loaded from: classes4.dex */
public abstract class c implements l2 {

    /* renamed from: a, reason: collision with root package name */
    protected int f1769a;
    protected r1 b;

    protected c(int i) {
        this.f1769a = i;
    }

    @Override // sdk.pendo.io.y4.l2
    public byte[] a() {
        if (h()) {
            throw new h2((short) 80);
        }
        return null;
    }

    @Override // sdk.pendo.io.y4.l2
    public void b(l lVar) {
    }

    @Override // sdk.pendo.io.y4.l2
    public void c() {
    }

    @Override // sdk.pendo.io.y4.l2
    public void d() {
        if (h()) {
            throw new h2((short) 10);
        }
    }

    @Override // sdk.pendo.io.y4.l2
    public short[] f() {
        return null;
    }

    @Override // sdk.pendo.io.y4.l2
    public boolean g() {
        return true;
    }

    public boolean h() {
        return false;
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(r1 r1Var) {
        this.b = r1Var;
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(InputStream inputStream) {
        if (!h()) {
            throw new h2((short) 10);
        }
    }
}
