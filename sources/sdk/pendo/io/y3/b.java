package sdk.pendo.io.y3;

import java.util.Enumeration;
import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.d0;
import sdk.pendo.io.m3.e0;
import sdk.pendo.io.m3.h;
import sdk.pendo.io.m3.j0;
import sdk.pendo.io.m3.j1;
import sdk.pendo.io.m3.q;
import sdk.pendo.io.m3.t;
import sdk.pendo.io.m3.w;
import sdk.pendo.io.m3.w1;
import sdk.pendo.io.m3.z1;

/* loaded from: classes4.dex */
public class b extends t {
    private w A;
    private q f;
    private e0 f0;
    private sdk.pendo.io.e4.a s;
    private sdk.pendo.io.m3.c t0;

    private b(d0 d0Var) {
        Enumeration m = d0Var.m();
        q a2 = q.a(m.nextElement());
        this.f = a2;
        int a3 = a(a2);
        this.s = sdk.pendo.io.e4.a.a(m.nextElement());
        this.A = w.a(m.nextElement());
        int i = -1;
        while (m.hasMoreElements()) {
            j0 j0Var = (j0) m.nextElement();
            int n = j0Var.n();
            if (n <= i) {
                throw new IllegalArgumentException("invalid optional field in private key info");
            }
            if (n == 0) {
                this.f0 = e0.a(j0Var, false);
            } else {
                if (n != 1) {
                    throw new IllegalArgumentException("unknown optional field in private key info");
                }
                if (a3 < 1) {
                    throw new IllegalArgumentException("'publicKey' requires version v2(1) or later");
                }
                this.t0 = j1.b(j0Var, false);
            }
            i = n;
        }
    }

    public static b a(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(d0.a(obj));
        }
        return null;
    }

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public a0 b() {
        h hVar = new h(5);
        hVar.a(this.f);
        hVar.a(this.s);
        hVar.a(this.A);
        e0 e0Var = this.f0;
        if (e0Var != null) {
            hVar.a(new z1(false, 0, e0Var));
        }
        sdk.pendo.io.m3.c cVar = this.t0;
        if (cVar != null) {
            hVar.a(new z1(false, 1, cVar));
        }
        return new w1(hVar);
    }

    public sdk.pendo.io.e4.a h() {
        return this.s;
    }

    private static int a(q qVar) {
        int m = qVar.m();
        if (m < 0 || m > 1) {
            throw new IllegalArgumentException("invalid version for private key info");
        }
        return m;
    }
}
