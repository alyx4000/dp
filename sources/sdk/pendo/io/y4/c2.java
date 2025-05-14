package sdk.pendo.io.y4;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class c2 extends c {
    protected sdk.pendo.io.z4.o c;
    protected u1 d;
    protected sdk.pendo.io.z4.f e;
    protected sdk.pendo.io.z4.e f;

    public c2(int i) {
        this(i, null);
    }

    private static int a(int i) {
        if (i == 17 || i == 19) {
            return i;
        }
        throw new IllegalArgumentException("unsupported key exchange algorithm");
    }

    protected void b(OutputStream outputStream) {
        l3.c(this.f.a(), outputStream);
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

    public c2(int i, sdk.pendo.io.z4.o oVar) {
        super(a(i));
        this.d = null;
        this.e = null;
        this.c = oVar;
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(OutputStream outputStream) {
        b(outputStream);
    }

    @Override // sdk.pendo.io.y4.l2
    public sdk.pendo.io.z4.b0 b() {
        return this.f.b();
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public byte[] a() {
        c0 c0Var = new c0();
        b2.a(this.c, c0Var);
        this.f = this.b.b().a(this.c).a();
        b(c0Var);
        l3.a(this.b, this.d, (byte[]) null, c0Var);
        return c0Var.toByteArray();
    }

    @Override // sdk.pendo.io.y4.l2
    public void b(InputStream inputStream) {
        a(l3.c(inputStream, 1));
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(v1 v1Var) {
        l3.c(v1Var);
    }

    @Override // sdk.pendo.io.y4.l2
    public void b(v1 v1Var) {
        this.d = l3.c(v1Var);
    }

    protected void a(byte[] bArr) {
        b2.a(this.c.a(), bArr);
        this.f.a(bArr);
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(l lVar) {
        this.e = lVar.a(0);
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public void a(InputStream inputStream) {
        c0 c0Var = new c0();
        sdk.pendo.io.f5.b bVar = new sdk.pendo.io.f5.b(inputStream, c0Var);
        this.c = b2.a(this.b, bVar);
        byte[] c = l3.c(bVar, 1);
        l3.a(this.b, inputStream, this.e, (byte[]) null, c0Var);
        this.f = this.b.b().a(this.c).a();
        a(c);
    }
}
