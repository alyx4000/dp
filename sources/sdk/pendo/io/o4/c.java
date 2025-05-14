package sdk.pendo.io.o4;

import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;

/* loaded from: classes6.dex */
public class c extends DHPublicKeySpec {
    private final DHParameterSpec f;

    public c(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        super(bigInteger, dHParameterSpec.getP(), dHParameterSpec.getG());
        this.f = dHParameterSpec;
    }
}
