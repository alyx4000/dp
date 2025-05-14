package sdk.pendo.io.e4;

import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.l0;
import sdk.pendo.io.m3.m;
import sdk.pendo.io.m3.t;

/* loaded from: classes6.dex */
public class i extends t implements sdk.pendo.io.m3.f {
    a0 f;

    public i(a0 a0Var) {
        if (!(a0Var instanceof l0) && !(a0Var instanceof m)) {
            throw new IllegalArgumentException("unknown object passed to Time");
        }
        this.f = a0Var;
    }

    public static i a(Object obj) {
        if (obj == null || (obj instanceof i)) {
            return (i) obj;
        }
        if (obj instanceof l0) {
            return new i((l0) obj);
        }
        if (obj instanceof m) {
            return new i((m) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public a0 b() {
        return this.f;
    }

    public String h() {
        a0 a0Var = this.f;
        return a0Var instanceof l0 ? ((l0) a0Var).k() : ((m) a0Var).l();
    }

    public String toString() {
        return h();
    }
}
