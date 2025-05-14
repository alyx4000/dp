package sdk.pendo.io.y4;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class w1 extends c {
    protected x1 c;
    protected sdk.pendo.io.z4.l d;
    protected u1 e;
    protected sdk.pendo.io.z4.f f;
    protected sdk.pendo.io.z4.e g;

    public w1(int i, x1 x1Var) {
        this(i, x1Var, null);
    }

    private static int a(int i) {
        if (i == 3 || i == 5) {
            return i;
        }
        throw new IllegalArgumentException("unsupported key exchange algorithm");
    }

    @Override // sdk.pendo.io.y4.l2
    public sdk.pendo.io.z4.b0 b() {
        return this.g.b();
    }

    @Override // sdk.pendo.io.y4.l2
    public void e() {
        throw new h2((short) 80);
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public short[] f() {
        return new short[]{2, 64, 1};
    }

    @Override // sdk.pendo.io.y4.c
    public boolean h() {
        return true;
    }

    private w1(int i, x1 x1Var, sdk.pendo.io.z4.l lVar) {
        super(a(i));
        this.e = null;
        this.f = null;
        this.c = x1Var;
        this.d = lVar;
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(OutputStream outputStream) {
        l3.a(this.g.a(), outputStream);
    }

    @Override // sdk.pendo.io.y4.l2
    public void b(InputStream inputStream) {
        this.g.a(l3.a(inputStream, 1));
    }

    public w1(int i, sdk.pendo.io.z4.l lVar) {
        this(i, null, lVar);
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public byte[] a() {
        c0 c0Var = new c0();
        z1.a(this.d, c0Var);
        sdk.pendo.io.z4.e a2 = this.b.b().a(this.d).a();
        this.g = a2;
        l3.a(a2.a(), (OutputStream) c0Var);
        l3.a(this.b, this.e, (byte[]) null, c0Var);
        return c0Var.toByteArray();
    }

    @Override // sdk.pendo.io.y4.l2
    public void b(v1 v1Var) {
        this.e = l3.c(v1Var);
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(v1 v1Var) {
        l3.c(v1Var);
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(l lVar) {
        this.f = lVar.a(0);
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public void a(InputStream inputStream) {
        c0 c0Var = new c0();
        sdk.pendo.io.f5.b bVar = new sdk.pendo.io.f5.b(inputStream, c0Var);
        this.d = z1.a(this.b, this.c, bVar);
        byte[] a2 = l3.a(bVar, 1);
        l3.a(this.b, inputStream, this.f, (byte[]) null, c0Var);
        sdk.pendo.io.z4.e a3 = this.b.b().a(this.d).a();
        this.g = a3;
        a3.a(a2);
    }
}
