package sdk.pendo.io.t4;

/* loaded from: classes6.dex */
class m0 extends sdk.pendo.io.y4.x {
    private static final int d = i0.a("external.sdk.pendo.io.org.bouncycastle.jsse.client.dh.minimumPrimeBits", 2048, 1024, 16384);
    private static final boolean e = i0.b("external.sdk.pendo.io.org.bouncycastle.jsse.client.dh.unrestrictedGroups", false);

    m0() {
        super(d);
    }

    @Override // sdk.pendo.io.y4.x
    protected boolean c(sdk.pendo.io.z4.a aVar) {
        return e || super.c(aVar);
    }
}
