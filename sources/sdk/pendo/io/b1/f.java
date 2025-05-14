package sdk.pendo.io.b1;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes6.dex */
public class f {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [javax.crypto.Cipher] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    static Cipher a(String str, String str2) {
        try {
            str = str2 == null ? Cipher.getInstance(str) : Cipher.getInstance(str, str2);
            return str;
        } catch (NoSuchAlgorithmException e) {
            e = e;
            throw new sdk.pendo.io.k1.g(e.toString(), e);
        } catch (NoSuchProviderException e2) {
            throw new sdk.pendo.io.k1.g("Unable to get a Cipher implementation of " + str + " using provider " + str2, e2);
        } catch (NoSuchPaddingException e3) {
            e = e3;
            throw new sdk.pendo.io.k1.g(e.toString(), e);
        }
    }
}
