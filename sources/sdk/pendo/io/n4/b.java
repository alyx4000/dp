package sdk.pendo.io.n4;

import sdk.pendo.io.h4.c;

/* loaded from: classes6.dex */
public class b extends a implements Cloneable {
    public b() {
        super(new c());
    }

    @Override // java.security.MessageDigest, java.security.MessageDigestSpi
    public Object clone() {
        b bVar = (b) super.clone();
        bVar.f = new c((c) this.f);
        return bVar;
    }
}
