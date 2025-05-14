package sdk.pendo.io.i1;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Set;

/* loaded from: classes6.dex */
abstract class g {

    /* renamed from: a, reason: collision with root package name */
    protected String f1180a;
    protected SecureRandom b;

    protected g(String str, SecureRandom secureRandom) {
        this.f1180a = str;
        this.b = secureRandom;
    }

    abstract String a();

    protected KeyFactory b() {
        String a2 = a();
        try {
            String str = this.f1180a;
            return str == null ? KeyFactory.getInstance(a2) : KeyFactory.getInstance(a2, str);
        } catch (NoSuchAlgorithmException e) {
            throw new sdk.pendo.io.k1.g("Couldn't find " + a2 + " KeyFactory! " + e, e);
        } catch (NoSuchProviderException e2) {
            throw new sdk.pendo.io.k1.g("Cannot get KeyFactory instance with provider " + this.f1180a, e2);
        }
    }

    public boolean c() {
        Set<String> algorithms = Security.getAlgorithms("KeyFactory");
        Set<String> algorithms2 = Security.getAlgorithms("KeyPairGenerator");
        String a2 = a();
        return algorithms2.contains(a2) && algorithms.contains(a2);
    }
}
