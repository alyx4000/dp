package sdk.pendo.io.y4;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class a3 extends c {
    protected y2 c;
    protected sdk.pendo.io.z4.f d;
    protected byte[] e;
    protected sdk.pendo.io.z4.y f;
    protected u1 g;
    protected sdk.pendo.io.z4.z h;
    protected BigInteger i;

    public a3(int i, z2 z2Var, y2 y2Var) {
        super(a(i));
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.c = y2Var;
    }

    private static int a(int i) {
        switch (i) {
            case 21:
            case 22:
            case 23:
                return i;
            default:
                throw new IllegalArgumentException("unsupported key exchange algorithm");
        }
    }

    @Override // sdk.pendo.io.y4.l2
    public sdk.pendo.io.z4.b0 b() {
        sdk.pendo.io.z4.z zVar = this.h;
        return this.b.b().b(sdk.pendo.io.d5.b.a(zVar != null ? zVar.a(this.i) : this.f.a(this.i)));
    }

    @Override // sdk.pendo.io.y4.l2
    public void e() {
        if (this.f1769a != 21) {
            throw new h2((short) 80);
        }
    }

    @Override // sdk.pendo.io.y4.c
    public boolean h() {
        return true;
    }

    public a3(int i, b3 b3Var) {
        super(a(i));
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(OutputStream outputStream) {
        throw null;
    }

    @Override // sdk.pendo.io.y4.l2
    public void b(InputStream inputStream) {
        throw null;
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public byte[] a() {
        throw null;
    }

    @Override // sdk.pendo.io.y4.l2
    public void b(v1 v1Var) {
        if (this.f1769a == 21) {
            throw new h2((short) 80);
        }
        this.g = l3.c(v1Var);
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(v1 v1Var) {
        throw new h2((short) 80);
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(l lVar) {
        if (this.f1769a == 21) {
            throw new h2((short) 80);
        }
        this.d = lVar.a(0);
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public void a(InputStream inputStream) {
        InputStream inputStream2;
        c0 c0Var;
        if (this.f1769a != 21) {
            c0Var = new c0();
            inputStream2 = new sdk.pendo.io.f5.b(inputStream, c0Var);
        } else {
            inputStream2 = inputStream;
            c0Var = null;
        }
        e1 a2 = e1.a(inputStream2);
        if (c0Var != null) {
            l3.a(this.b, inputStream, this.d, (byte[]) null, c0Var);
        }
        sdk.pendo.io.z4.a0 a0Var = new sdk.pendo.io.z4.a0();
        a0Var.a(new BigInteger[]{a2.c(), a2.b()});
        if (!this.c.a(a0Var)) {
            throw new h2((short) 71);
        }
        this.e = a2.d();
        this.i = a(a2.c(), a2.a());
        this.f = this.b.b().a(a0Var);
    }

    protected static BigInteger a(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger mod = bigInteger2.mod(bigInteger);
        if (mod.equals(BigInteger.ZERO)) {
            throw new h2((short) 47);
        }
        return mod;
    }
}
