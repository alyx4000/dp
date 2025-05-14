package sdk.pendo.io.y4;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class x2 extends c {
    protected t1 c;
    protected sdk.pendo.io.z4.r d;
    protected sdk.pendo.io.z4.b0 e;

    public x2(int i) {
        super(a(i));
        this.c = null;
    }

    private static int a(int i) {
        if (i == 1) {
            return i;
        }
        throw new IllegalArgumentException("unsupported key exchange algorithm");
    }

    @Override // sdk.pendo.io.y4.l2
    public sdk.pendo.io.z4.b0 b() {
        sdk.pendo.io.z4.b0 b0Var = this.e;
        this.e = null;
        return b0Var;
    }

    @Override // sdk.pendo.io.y4.l2
    public void e() {
        throw new h2((short) 80);
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public short[] f() {
        return new short[]{1, 2, 64};
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(OutputStream outputStream) {
        this.e = l3.a(this.b, this.d, outputStream);
    }

    @Override // sdk.pendo.io.y4.l2
    public void b(InputStream inputStream) {
        this.e = this.c.a(new sdk.pendo.io.z4.j(this.b), l3.a(this.b, inputStream));
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(v1 v1Var) {
        l3.c(v1Var);
    }

    @Override // sdk.pendo.io.y4.l2
    public void b(v1 v1Var) {
        this.c = l3.b(v1Var);
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(l lVar) {
        this.d = lVar.a(0).a(3);
    }
}
