package sdk.pendo.io.m3;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.BERTags;

/* loaded from: classes6.dex */
public class f0 {

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f1387a;
    private final int b;
    private final byte[][] c;

    f0(InputStream inputStream, int i, byte[][] bArr) {
        this.f1387a = inputStream;
        this.b = i;
        this.c = bArr;
    }

    g a(int i) {
        a(false);
        int a2 = p.a(this.f1387a, i);
        int a3 = p.a(this.f1387a, this.b, a2 == 3 || a2 == 4 || a2 == 16 || a2 == 17 || a2 == 8);
        if (a3 < 0) {
            if ((i & 32) == 0) {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
            f0 f0Var = new f0(new s2(this.f1387a, this.b), this.b, this.c);
            int i2 = i & 192;
            return i2 != 0 ? 64 == i2 ? new t0(a2, f0Var) : new e1(i2, a2, f0Var) : f0Var.c(a2);
        }
        q2 q2Var = new q2(this.f1387a, a3, this.b);
        if ((i & BERTags.FLAGS) == 0) {
            return a(a2, q2Var);
        }
        f0 f0Var2 = new f0(q2Var, q2Var.a(), this.c);
        int i3 = i & 192;
        if (i3 == 0) {
            return f0Var2.b(a2);
        }
        boolean z = (i & 32) != 0;
        return 64 == i3 ? (e2) f0Var2.a(i3, a2, z) : new p2(i3, a2, z, f0Var2);
    }

    g b(int i) {
        if (i == 3) {
            return new v0(this);
        }
        if (i == 4) {
            return new y0(this);
        }
        if (i == 8) {
            return new l1(this);
        }
        if (i == 16) {
            return new l2(this);
        }
        if (i == 17) {
            return new n2(this);
        }
        throw new j("unknown DL object encountered: 0x" + Integer.toHexString(i));
    }

    g c(int i) {
        if (i == 3) {
            return new v0(this);
        }
        if (i == 4) {
            return new y0(this);
        }
        if (i == 8) {
            return new l1(this);
        }
        if (i == 16) {
            return new a1(this);
        }
        if (i == 17) {
            return new c1(this);
        }
        throw new j("unknown BER object encountered: 0x" + Integer.toHexString(i));
    }

    a0 a(int i, int i2, boolean z) {
        return !z ? j0.a(i, i2, ((q2) this.f1387a).e()) : j0.a(i, i2, b());
    }

    h b() {
        int read = this.f1387a.read();
        if (read < 0) {
            return new h(0);
        }
        h hVar = new h();
        do {
            g a2 = a(read);
            hVar.a(a2 instanceof r2 ? ((r2) a2).e() : a2.b());
            read = this.f1387a.read();
        } while (read >= 0);
        return hVar;
    }

    a0 a(int i, int i2) {
        return j0.b(i, i2, b());
    }

    g a(int i, q2 q2Var) {
        if (i == 3) {
            return new g2(q2Var);
        }
        if (i == 4) {
            return new t1(q2Var);
        }
        if (i == 8) {
            throw new j("externals must use constructed encoding (see X.690 8.18)");
        }
        if (i == 16) {
            throw new j("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
        }
        if (i == 17) {
            throw new j("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
        }
        try {
            return p.a(i, q2Var, this.c);
        } catch (IllegalArgumentException e) {
            throw new j("corrupted stream detected", e);
        }
    }

    public g a() {
        int read = this.f1387a.read();
        if (read < 0) {
            return null;
        }
        return a(read);
    }

    private void a(boolean z) {
        InputStream inputStream = this.f1387a;
        if (inputStream instanceof s2) {
            ((s2) inputStream).b(z);
        }
    }
}
