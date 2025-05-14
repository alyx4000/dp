package sdk.pendo.io.p3;

import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.h;
import sdk.pendo.io.m3.q;
import sdk.pendo.io.m3.s1;
import sdk.pendo.io.m3.t;
import sdk.pendo.io.m3.w1;

/* loaded from: classes6.dex */
public class a extends t {
    private byte[] f;
    private int s;

    public a(byte[] bArr, int i) {
        this.f = sdk.pendo.io.d5.a.a(bArr);
        this.s = i;
    }

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public a0 b() {
        h hVar = new h(2);
        hVar.a(new s1(this.f));
        if (this.s != 12) {
            hVar.a(new q(this.s));
        }
        return new w1(hVar);
    }
}
