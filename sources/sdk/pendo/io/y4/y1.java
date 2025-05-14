package sdk.pendo.io.y4;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class y1 extends c {
    protected s1 c;
    protected sdk.pendo.io.z4.f d;

    public y1(int i) {
        super(a(i));
    }

    private static int a(int i) {
        if (i == 7 || i == 9) {
            return i;
        }
        throw new IllegalArgumentException("unsupported key exchange algorithm");
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(OutputStream outputStream) {
    }

    @Override // sdk.pendo.io.y4.l2
    public sdk.pendo.io.z4.b0 b() {
        return this.c.a(this.d);
    }

    @Override // sdk.pendo.io.y4.l2
    public void b(InputStream inputStream) {
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public void c() {
        throw new h2((short) 10);
    }

    @Override // sdk.pendo.io.y4.l2
    public void e() {
        throw new h2((short) 80);
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public short[] f() {
        return new short[]{4, 3};
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public boolean g() {
        return false;
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public void b(l lVar) {
        this.d = lVar.a(0).c(1);
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(v1 v1Var) {
        this.c = l3.a(v1Var);
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(l lVar) {
        this.d = lVar.a(0).c(1);
    }

    @Override // sdk.pendo.io.y4.l2
    public void b(v1 v1Var) {
        this.c = l3.a(v1Var);
    }
}
