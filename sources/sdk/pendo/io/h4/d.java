package sdk.pendo.io.h4;

import sdk.pendo.io.d5.f;

/* loaded from: classes6.dex */
public class d extends b {
    @Override // sdk.pendo.io.g4.c
    public int a(byte[] bArr, int i) {
        d();
        f.a(this.e, bArr, i);
        f.a(this.f, bArr, i + 8);
        f.a(this.g, bArr, i + 16);
        f.a(this.h, bArr, i + 24);
        f.a(this.i, bArr, i + 32);
        f.a(this.j, bArr, i + 40);
        f.a(this.k, bArr, i + 48);
        f.a(this.l, bArr, i + 56);
        reset();
        return 64;
    }

    @Override // sdk.pendo.io.g4.c
    public String a() {
        return "SHA-512";
    }

    @Override // sdk.pendo.io.g4.c
    public int b() {
        return 64;
    }

    @Override // sdk.pendo.io.h4.b, sdk.pendo.io.g4.c
    public void reset() {
        super.reset();
        this.e = 7640891576956012808L;
        this.f = -4942790177534073029L;
        this.g = 4354685564936845355L;
        this.h = -6534734903238641935L;
        this.i = 5840696475078001361L;
        this.j = -7276294671716946913L;
        this.k = 2270897969802886507L;
        this.l = 6620516959819538809L;
    }
}
