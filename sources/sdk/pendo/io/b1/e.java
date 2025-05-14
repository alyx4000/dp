package sdk.pendo.io.b1;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;

/* loaded from: classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final sdk.pendo.io.h7.a f876a = sdk.pendo.io.h7.b.a((Class<?>) e.class);

    public static boolean a(String str, int i) {
        int a2 = sdk.pendo.io.k1.a.a(i);
        try {
            int maxAllowedKeyLength = Cipher.getMaxAllowedKeyLength(str);
            boolean z = a2 <= maxAllowedKeyLength;
            if (!z) {
                f876a.a("max allowed key length for {} is {}", str, Integer.valueOf(maxAllowedKeyLength));
            }
            return z;
        } catch (NoSuchAlgorithmException e) {
            f876a.a("Unknown/unsupported algorithm, {} {}", str, e);
            return false;
        }
    }
}
