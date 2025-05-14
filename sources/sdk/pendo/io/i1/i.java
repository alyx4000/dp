package sdk.pendo.io.i1;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.NamedParameterSpec;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import org.bouncycastle.jcajce.spec.XDHParameterSpec;

/* loaded from: classes6.dex */
public abstract class i extends g {
    public i(String str, SecureRandom secureRandom) {
        super(str, secureRandom);
    }

    public abstract PrivateKey a(byte[] bArr, String str);

    NamedParameterSpec a(String str) {
        try {
            return new NamedParameterSpec(str);
        } catch (NoClassDefFoundError e) {
            throw new sdk.pendo.io.k1.g(str + " NamedParameterSpec not available. " + sdk.pendo.io.k1.b.a(e));
        }
    }

    public abstract byte[] a(Key key);

    public abstract byte[] a(PrivateKey privateKey);

    public abstract PublicKey b(byte[] bArr, String str);

    public static i a(String str, String str2, SecureRandom secureRandom) {
        if (str.equals(EdDSAParameterSpec.Ed25519) || str.equals(EdDSAParameterSpec.Ed448)) {
            return new d(str2, secureRandom);
        }
        if (str.equals(XDHParameterSpec.X25519) || str.equals(XDHParameterSpec.X448)) {
            return new l(str2, secureRandom);
        }
        return null;
    }
}
