package sdk.pendo.io.y4;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class u2 extends c {
    protected x1 c;
    protected byte[] d;
    protected byte[] e;
    protected sdk.pendo.io.z4.l f;
    protected sdk.pendo.io.z4.o g;
    protected sdk.pendo.io.z4.e h;
    protected t1 i;
    protected sdk.pendo.io.z4.r j;
    protected sdk.pendo.io.z4.b0 k;

    public u2(int i, s2 s2Var, x1 x1Var) {
        this(i, s2Var, null, x1Var, null, null);
    }

    private static int a(int i) {
        if (i != 24) {
            switch (i) {
                case 13:
                case 14:
                case 15:
                    break;
                default:
                    throw new IllegalArgumentException("unsupported key exchange algorithm");
            }
        }
        return i;
    }

    protected byte[] b(int i) {
        sdk.pendo.io.z4.e eVar;
        sdk.pendo.io.z4.b0 b0Var;
        int i2 = this.f1769a;
        if (i2 == 13) {
            return new byte[i];
        }
        if ((i2 == 14 || i2 == 24) && (eVar = this.h) != null) {
            return eVar.b().a();
        }
        if (i2 != 15 || (b0Var = this.k) == null) {
            throw new h2((short) 80);
        }
        return b0Var.a();
    }

    @Override // sdk.pendo.io.y4.l2
    public void e() {
        if (this.f1769a == 15) {
            throw new h2((short) 80);
        }
    }

    @Override // sdk.pendo.io.y4.c
    public boolean h() {
        int i = this.f1769a;
        return i == 14 || i == 24;
    }

    private u2(int i, s2 s2Var, t2 t2Var, x1 x1Var, sdk.pendo.io.z4.l lVar, sdk.pendo.io.z4.o oVar) {
        super(a(i));
        this.d = null;
        this.e = null;
        this.i = null;
        this.c = x1Var;
        this.f = lVar;
        this.g = oVar;
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(OutputStream outputStream) {
        this.d.getClass();
        throw null;
    }

    @Override // sdk.pendo.io.y4.l2
    public sdk.pendo.io.z4.b0 b() {
        byte[] b = b(this.e.length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(b.length + 4 + this.e.length);
        l3.a(b, (OutputStream) byteArrayOutputStream);
        l3.a(this.e, (OutputStream) byteArrayOutputStream);
        sdk.pendo.io.d5.a.a(this.e, (byte) 0);
        this.e = null;
        return this.b.b().b(byteArrayOutputStream.toByteArray());
    }

    public u2(int i, t2 t2Var, sdk.pendo.io.z4.l lVar, sdk.pendo.io.z4.o oVar) {
        this(i, null, t2Var, null, lVar, oVar);
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public byte[] a() {
        throw null;
    }

    @Override // sdk.pendo.io.y4.l2
    public void b(InputStream inputStream) {
        l3.b(inputStream);
        throw null;
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(v1 v1Var) {
        throw new h2((short) 80);
    }

    protected void b(byte[] bArr) {
        b2.a(this.g.a(), bArr);
        this.h.a(bArr);
    }

    protected void a(byte[] bArr) {
        this.h.a(bArr);
    }

    @Override // sdk.pendo.io.y4.l2
    public void b(v1 v1Var) {
        if (this.f1769a != 15) {
            throw new h2((short) 80);
        }
        this.i = l3.b(v1Var);
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(l lVar) {
        if (this.f1769a != 15) {
            throw new h2((short) 10);
        }
        this.j = lVar.a(0).a(3);
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public void a(InputStream inputStream) {
        this.d = l3.b(inputStream);
        int i = this.f1769a;
        if (i == 14) {
            this.f = z1.a(this.b, this.c, inputStream);
            byte[] a2 = l3.a(inputStream, 1);
            this.h = this.b.b().a(this.f).a();
            a(a2);
            return;
        }
        if (i == 24) {
            this.g = b2.a(this.b, inputStream);
            byte[] c = l3.c(inputStream, 1);
            this.h = this.b.b().a(this.g).a();
            b(c);
        }
    }
}
