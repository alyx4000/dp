package sdk.pendo.io.e1;

import java.security.PublicKey;
import java.security.interfaces.EdECPublicKey;

/* loaded from: classes6.dex */
public class c extends a {
    public c() {
        super("EdDSA", "EdDSA", "OKP");
    }

    @Override // sdk.pendo.io.e1.a
    public void a(PublicKey publicKey) {
        sdk.pendo.io.h1.d.a(publicKey, EdECPublicKey.class);
    }
}
