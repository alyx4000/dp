package sdk.pendo.io.b5;

import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import javax.crypto.spec.DHParameterSpec;

/* loaded from: classes6.dex */
class a {
    static AlgorithmParameterSpec a(sdk.pendo.io.z4.a aVar) {
        return new sdk.pendo.io.o4.b(aVar.c(), aVar.d(), aVar.a(), aVar.b());
    }

    static DHParameterSpec b(h hVar, AlgorithmParameterSpec algorithmParameterSpec) {
        try {
            AlgorithmParameters e = hVar.g().e("DiffieHellman");
            e.init(algorithmParameterSpec);
            DHParameterSpec dHParameterSpec = (DHParameterSpec) e.getParameterSpec(DHParameterSpec.class);
            if (dHParameterSpec != null) {
                return dHParameterSpec;
            }
            return null;
        } catch (AssertionError | Exception unused) {
            return null;
        }
    }

    static boolean c(h hVar, sdk.pendo.io.z4.a aVar) {
        return (aVar == null || b(hVar, aVar) == null) ? false : true;
    }

    static KeySpec a(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        return new sdk.pendo.io.o4.c(bigInteger, dHParameterSpec);
    }

    static DHParameterSpec b(h hVar, sdk.pendo.io.z4.a aVar) {
        return b(hVar, a(aVar));
    }

    static AlgorithmParameters a(h hVar, AlgorithmParameterSpec algorithmParameterSpec) {
        try {
            AlgorithmParameters e = hVar.g().e("DiffieHellman");
            e.init(algorithmParameterSpec);
            if (((DHParameterSpec) e.getParameterSpec(DHParameterSpec.class)) != null) {
                return e;
            }
            return null;
        } catch (AssertionError | Exception unused) {
            return null;
        }
    }

    static AlgorithmParameters a(h hVar, sdk.pendo.io.z4.a aVar) {
        return a(hVar, a(aVar));
    }
}
