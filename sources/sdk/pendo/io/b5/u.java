package sdk.pendo.io.b5;

import java.security.PublicKey;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;

/* loaded from: classes6.dex */
public class u extends w {
    public u(h hVar, PublicKey publicKey) {
        super(hVar, publicKey, (short) 8, EdDSAParameterSpec.Ed448);
    }
}
