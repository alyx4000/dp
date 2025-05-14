package sdk.pendo.io.e4;

import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.s1;
import sdk.pendo.io.m3.t;
import sdk.pendo.io.m3.w1;

/* loaded from: classes6.dex */
public class c extends t {
    private byte[] f;
    private a s;

    public c(a aVar, byte[] bArr) {
        this.f = sdk.pendo.io.d5.a.a(bArr);
        this.s = aVar;
    }

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public a0 b() {
        sdk.pendo.io.m3.h hVar = new sdk.pendo.io.m3.h(2);
        hVar.a(this.s);
        hVar.a(new s1(this.f));
        return new w1(hVar);
    }
}
