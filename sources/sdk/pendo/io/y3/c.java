package sdk.pendo.io.y3;

import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.d0;
import sdk.pendo.io.m3.h;
import sdk.pendo.io.m3.j0;
import sdk.pendo.io.m3.q;
import sdk.pendo.io.m3.q1;
import sdk.pendo.io.m3.t;
import sdk.pendo.io.m3.w1;
import sdk.pendo.io.m3.z1;

/* loaded from: classes4.dex */
public class c extends t {
    public static final sdk.pendo.io.e4.a t0;
    public static final sdk.pendo.io.e4.a u0;
    public static final q v0;
    public static final q w0;
    private q A;
    private sdk.pendo.io.e4.a f;
    private q f0;
    private sdk.pendo.io.e4.a s;

    static {
        sdk.pendo.io.e4.a aVar = new sdk.pendo.io.e4.a(sdk.pendo.io.x3.a.i, q1.s);
        t0 = aVar;
        u0 = new sdk.pendo.io.e4.a(a.i, aVar);
        v0 = new q(20L);
        w0 = new q(1L);
    }

    public c() {
        this.f = t0;
        this.s = u0;
        this.A = v0;
        this.f0 = w0;
    }

    public static c a(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(d0.a(obj));
        }
        return null;
    }

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public a0 b() {
        h hVar = new h(4);
        if (!this.f.equals(t0)) {
            hVar.a(new z1(true, 0, this.f));
        }
        if (!this.s.equals(u0)) {
            hVar.a(new z1(true, 1, this.s));
        }
        if (!this.A.b(v0)) {
            hVar.a(new z1(true, 2, this.A));
        }
        if (!this.f0.b(w0)) {
            hVar.a(new z1(true, 3, this.f0));
        }
        return new w1(hVar);
    }

    public sdk.pendo.io.e4.a h() {
        return this.f;
    }

    public c(sdk.pendo.io.e4.a aVar, sdk.pendo.io.e4.a aVar2, q qVar, q qVar2) {
        this.f = aVar;
        this.s = aVar2;
        this.A = qVar;
        this.f0 = qVar2;
    }

    private c(d0 d0Var) {
        this.f = t0;
        this.s = u0;
        this.A = v0;
        this.f0 = w0;
        for (int i = 0; i != d0Var.size(); i++) {
            j0 j0Var = (j0) d0Var.a(i);
            int n = j0Var.n();
            if (n == 0) {
                this.f = sdk.pendo.io.e4.a.a(j0Var, true);
            } else if (n == 1) {
                this.s = sdk.pendo.io.e4.a.a(j0Var, true);
            } else if (n == 2) {
                this.A = q.a(j0Var, true);
            } else {
                if (n != 3) {
                    throw new IllegalArgumentException("unknown tag");
                }
                this.f0 = q.a(j0Var, true);
            }
        }
    }
}
