package sdk.pendo.io.c4;

import java.util.Enumeration;
import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.d0;
import sdk.pendo.io.m3.f;
import sdk.pendo.io.m3.g;
import sdk.pendo.io.m3.j0;
import sdk.pendo.io.m3.t;
import sdk.pendo.io.m3.w1;

/* loaded from: classes6.dex */
public class c extends t implements f {
    private static d u0 = sdk.pendo.io.d4.b.Q;
    private d A;
    private boolean f;
    private b[] f0;
    private int s;
    private w1 t0;

    private c(d dVar, d0 d0Var) {
        this.A = dVar;
        this.f0 = new b[d0Var.size()];
        Enumeration m = d0Var.m();
        boolean z = true;
        int i = 0;
        while (m.hasMoreElements()) {
            Object nextElement = m.nextElement();
            b a2 = b.a(nextElement);
            z &= a2 == nextElement;
            this.f0[i] = a2;
            i++;
        }
        this.t0 = z ? w1.a(d0Var) : new w1(this.f0);
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
        return this.t0;
    }

    @Override // sdk.pendo.io.m3.t
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c) && !(obj instanceof d0)) {
            return false;
        }
        if (b().b(((g) obj).b())) {
            return true;
        }
        try {
            return this.A.a(this, new c(d0.a((Object) ((g) obj).b())));
        } catch (Exception unused) {
            return false;
        }
    }

    public b[] h() {
        return (b[]) this.f0.clone();
    }

    @Override // sdk.pendo.io.m3.t
    public int hashCode() {
        if (this.f) {
            return this.s;
        }
        this.f = true;
        int b = this.A.b(this);
        this.s = b;
        return b;
    }

    public String toString() {
        return this.A.a(this);
    }

    private c(d0 d0Var) {
        this(u0, d0Var);
    }

    public static c a(j0 j0Var, boolean z) {
        return a(d0.a(j0Var, true));
    }
}
