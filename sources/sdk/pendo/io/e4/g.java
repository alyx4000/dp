package sdk.pendo.io.e4;

import java.util.Enumeration;
import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.d0;
import sdk.pendo.io.m3.j1;
import sdk.pendo.io.m3.t;
import sdk.pendo.io.m3.w1;

/* loaded from: classes6.dex */
public class g extends t {
    private a f;
    private sdk.pendo.io.m3.c s;

    public g(a aVar, byte[] bArr) {
        this.s = new j1(bArr);
        this.f = aVar;
    }

    public static g a(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(d0.a(obj));
        }
        return null;
    }

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public a0 b() {
        sdk.pendo.io.m3.h hVar = new sdk.pendo.io.m3.h(2);
        hVar.a(this.f);
        hVar.a(this.s);
        return new w1(hVar);
    }

    public a h() {
        return this.f;
    }

    public sdk.pendo.io.m3.c i() {
        return this.s;
    }

    public g(d0 d0Var) {
        if (d0Var.size() != 2) {
            throw new IllegalArgumentException("Bad sequence size: " + d0Var.size());
        }
        Enumeration m = d0Var.m();
        this.f = a.a(m.nextElement());
        this.s = j1.b(m.nextElement());
    }
}
