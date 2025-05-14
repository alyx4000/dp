package sdk.pendo.io.f4;

import java.math.BigInteger;
import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.q;
import sdk.pendo.io.m3.t;
import sdk.pendo.io.m3.w1;

/* loaded from: classes6.dex */
public class d extends t implements h {
    private static final BigInteger t0 = BigInteger.valueOf(1);
    private BigInteger A;
    private sdk.pendo.io.v4.c f;
    private byte[] f0;
    private BigInteger s;

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public a0 b() {
        sdk.pendo.io.m3.h hVar = new sdk.pendo.io.m3.h(6);
        hVar.a(new q(t0));
        hVar.a((sdk.pendo.io.m3.g) null);
        hVar.a(new c(this.f, this.f0));
        hVar.a((sdk.pendo.io.m3.g) null);
        hVar.a(new q(this.s));
        if (this.A != null) {
            hVar.a(new q(this.A));
        }
        return new w1(hVar);
    }
}
