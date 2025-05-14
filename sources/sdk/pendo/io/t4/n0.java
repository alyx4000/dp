package sdk.pendo.io.t4;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.util.logging.Logger;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.KeyStoreBuilderParameters;
import javax.net.ssl.ManagerFactoryParameters;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
class n0 extends KeyManagerFactorySpi {
    private static final Logger d = Logger.getLogger(n0.class.getName());

    /* renamed from: a, reason: collision with root package name */
    protected final boolean f1592a;
    protected final sdk.pendo.io.p4.b b;
    protected sdk.pendo.io.r4.j c;

    n0(boolean z, sdk.pendo.io.p4.b bVar) {
        this.f1592a = z;
        this.b = bVar;
    }

    private static KeyStore a(String str) {
        String b = b(str);
        String e = i0.e("javax.net.ssl.keyStoreProvider");
        return l3.b(e) ? KeyStore.getInstance(b) : KeyStore.getInstance(b, e);
    }

    private static String b(String str) {
        String e = i0.e("javax.net.ssl.keyStoreType");
        return e == null ? str : e;
    }

    @Override // javax.net.ssl.KeyManagerFactorySpi
    protected KeyManager[] engineGetKeyManagers() {
        sdk.pendo.io.r4.j jVar = this.c;
        if (jVar != null) {
            return new KeyManager[]{jVar};
        }
        throw new IllegalStateException("KeyManagerFactory not initialized");
    }

    @Override // javax.net.ssl.KeyManagerFactorySpi
    protected void engineInit(KeyStore keyStore, char[] cArr) {
        this.c = new p1(this.f1592a, this.b, keyStore, cArr);
    }

    static d0 a() {
        BufferedInputStream bufferedInputStream;
        String defaultType = KeyStore.getDefaultType();
        String e = i0.e("javax.net.ssl.keyStore");
        BufferedInputStream bufferedInputStream2 = null;
        if ("NONE".equals(e) || e == null || !new File(e).exists()) {
            e = null;
        }
        KeyStore a2 = a(defaultType);
        String b = i0.b("javax.net.ssl.keyStorePassword");
        char[] charArray = b != null ? b.toCharArray() : null;
        try {
            if (e == null) {
                d.config("Initializing default key store as empty");
                bufferedInputStream = null;
            } else {
                d.config("Initializing default key store from path: " + e);
                bufferedInputStream = new BufferedInputStream(new FileInputStream(e));
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                a2.load(bufferedInputStream, charArray);
            } catch (NullPointerException unused) {
                a2 = KeyStore.getInstance("BCFKS");
                a2.load(null, null);
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return new d0(a2, charArray);
        } catch (Throwable th2) {
            bufferedInputStream2 = bufferedInputStream;
            th = th2;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
    }

    @Override // javax.net.ssl.KeyManagerFactorySpi
    protected void engineInit(ManagerFactoryParameters managerFactoryParameters) {
        if (!(managerFactoryParameters instanceof KeyStoreBuilderParameters)) {
            throw new InvalidAlgorithmParameterException("Parameters must be instance of KeyStoreBuilderParameters");
        }
        this.c = new o1(this.f1592a, this.b, ((KeyStoreBuilderParameters) managerFactoryParameters).getParameters());
    }
}
