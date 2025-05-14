package sdk.pendo.io.t4;

import java.lang.reflect.Method;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.UnrecoverableKeyException;

/* loaded from: classes6.dex */
abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Method f1573a = r1.a("java.security.KeyStore$PasswordProtection", "getProtectionAlgorithm", (Class<?>[]) new Class[0]);

    static Key a(KeyStore keyStore, String str, KeyStore.ProtectionParameter protectionParameter) {
        if (protectionParameter == null) {
            throw new UnrecoverableKeyException("requested key requires a password");
        }
        if (!(protectionParameter instanceof KeyStore.PasswordProtection)) {
            throw new UnsupportedOperationException();
        }
        KeyStore.PasswordProtection passwordProtection = (KeyStore.PasswordProtection) protectionParameter;
        Method method = f1573a;
        if (method == null || r1.a(passwordProtection, method) == null) {
            return keyStore.getKey(str, passwordProtection.getPassword());
        }
        throw new KeyStoreException("unsupported password protection algorithm");
    }
}
