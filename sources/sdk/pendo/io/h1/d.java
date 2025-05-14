package sdk.pendo.io.h1;

import java.security.Key;
import java.security.interfaces.RSAKey;
import sdk.pendo.io.k1.f;

/* loaded from: classes6.dex */
public class d {
    public static <K extends Key> K a(Key key, Class<K> cls) {
        b(key);
        try {
            return cls.cast(key);
        } catch (ClassCastException e) {
            throw new f("Invalid key " + e);
        }
    }

    public static void b(Key key) {
        if (key == null) {
            throw new f("The key must not be null.");
        }
    }

    public static void a(Key key) {
        int bitLength;
        if (key == null) {
            throw new f("The RSA key must not be null.");
        }
        if ((key instanceof RSAKey) && (bitLength = ((RSAKey) key).getModulus().bitLength()) < 2048) {
            throw new f("An RSA key of size 2048 bits or larger MUST be used with the all JOSE RSA algorithms (given key was only " + bitLength + " bits).");
        }
    }

    public static void a(Key key, String str, int i) {
        int length;
        b(key);
        String algorithm = key.getAlgorithm();
        if (!"AES".equals(algorithm)) {
            throw new f("Invalid key for JWE " + str + ", expected an AES key but an " + algorithm + " key was provided.");
        }
        if (key.getEncoded() != null && (length = key.getEncoded().length) != i) {
            throw new f("Invalid key for JWE " + str + ", expected a " + sdk.pendo.io.k1.a.a(i) + " bit key but a " + sdk.pendo.io.k1.a.a(length) + " bit key was provided.");
        }
    }
}
