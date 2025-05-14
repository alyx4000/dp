package sdk.pendo.io.b5;

import java.security.PrivateKey;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;

/* loaded from: classes6.dex */
public class t extends v {
    public t(h hVar, PrivateKey privateKey) {
        super(hVar, privateKey, (short) 8, EdDSAParameterSpec.Ed448);
    }
}
