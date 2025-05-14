package sdk.pendo.io.b5;

import java.security.PrivateKey;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.RSAPrivateKey;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import sdk.pendo.io.y4.i1;
import sdk.pendo.io.y4.j1;

/* loaded from: classes6.dex */
public class d extends sdk.pendo.io.y4.w {
    public d(sdk.pendo.io.z4.j jVar, h hVar, PrivateKey privateKey, sdk.pendo.io.y4.l lVar, i1 i1Var) {
        super(jVar, a(hVar, privateKey, lVar, i1Var), lVar, i1Var);
    }

    private static g a(h hVar, sdk.pendo.io.y4.l lVar) {
        if (lVar == null || lVar.d()) {
            throw new IllegalArgumentException("No certificate");
        }
        return g.a(hVar, lVar.a(0));
    }

    private static sdk.pendo.io.z4.c0 a(h hVar, PrivateKey privateKey, sdk.pendo.io.y4.l lVar, i1 i1Var) {
        String algorithm = privateKey.getAlgorithm();
        if ((privateKey instanceof RSAPrivateKey) || "RSA".equalsIgnoreCase(algorithm) || "RSASSA-PSS".equalsIgnoreCase(algorithm)) {
            if (i1Var != null) {
                int a2 = j1.a(i1Var);
                if (j1.h(a2)) {
                    return new z(hVar, privateKey, a2);
                }
            }
            try {
                return new b0(hVar, privateKey, a(hVar, lVar).i());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if ((privateKey instanceof DSAPrivateKey) || "DSA".equalsIgnoreCase(algorithm)) {
            return new j(hVar, privateKey);
        }
        if (b.a(privateKey)) {
            if (i1Var != null) {
                int a3 = j1.a(i1Var);
                if (j1.g(a3)) {
                    return new n(hVar, privateKey, a3);
                }
            }
            return new p(hVar, privateKey);
        }
        if (EdDSAParameterSpec.Ed25519.equalsIgnoreCase(algorithm)) {
            return new r(hVar, privateKey);
        }
        if (EdDSAParameterSpec.Ed448.equalsIgnoreCase(algorithm)) {
            return new t(hVar, privateKey);
        }
        throw new IllegalArgumentException("'privateKey' type not supported: " + privateKey.getClass().getName());
    }
}
