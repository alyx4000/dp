package sdk.pendo.io.f4;

import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.s1;
import sdk.pendo.io.m3.t;

/* loaded from: classes6.dex */
public class f extends t {
    private static g s = new g();
    protected sdk.pendo.io.v4.d f;

    public f(sdk.pendo.io.v4.d dVar) {
        this.f = dVar;
    }

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public a0 b() {
        return new s1(s.a(this.f.l(), s.a(this.f)));
    }
}
