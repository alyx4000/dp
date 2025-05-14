package sdk.pendo.io.k1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/* loaded from: classes6.dex */
public class c {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.security.MessageDigest] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    public static MessageDigest a(String str, String str2) {
        try {
            str = str2 == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, str2);
            return str;
        } catch (NoSuchAlgorithmException unused) {
            throw new k("Unable to get MessageDigest instance with " + str);
        } catch (NoSuchProviderException e) {
            throw new k("Unable to get a MessageDigest implementation of algorithm name: " + str + " using provider " + str2, e);
        }
    }
}
