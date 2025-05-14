package sdk.pendo.io.l1;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.Mac;
import sdk.pendo.io.k1.f;
import sdk.pendo.io.k1.g;

/* loaded from: classes6.dex */
public class a {
    public static Mac a(String str, Key key, String str2) {
        Mac a2 = a(str, str2);
        a(a2, key);
        return a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [javax.crypto.Mac] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    public static Mac a(String str, String str2) {
        try {
            str = str2 == null ? Mac.getInstance(str) : Mac.getInstance(str, str2);
            return str;
        } catch (NoSuchAlgorithmException e) {
            throw new g("Unable to get a MAC implementation of algorithm name: " + str, e);
        } catch (NoSuchProviderException e2) {
            throw new g("Unable to get a MAC implementation of algorithm name: " + str + " using provider " + str2, e2);
        }
    }

    public static void a(Mac mac, Key key) {
        try {
            mac.init(key);
        } catch (InvalidKeyException e) {
            throw new f("Key is not valid for " + mac.getAlgorithm() + " - " + e, e);
        }
    }
}
