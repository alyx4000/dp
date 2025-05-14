package sdk.pendo.io.b5;

import java.security.PrivateKey;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;

/* loaded from: classes6.dex */
public class r extends v {
    public r(h hVar, PrivateKey privateKey) {
        super(hVar, privateKey, (short) 7, EdDSAParameterSpec.Ed25519);
    }
}
