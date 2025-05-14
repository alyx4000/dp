package sdk.pendo.io.t4;

import java.security.AlgorithmParameters;
import java.security.Key;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes6.dex */
class k0 extends a {
    private static final Logger e = Logger.getLogger(k0.class.getName());
    private static final g f = g.a(l0.d, "jdk.tls.disabledAlgorithms", "SSLv3, TLSv1, TLSv1.1, RC4, DES, MD5withRSA, DH keySize < 1024, EC keySize < 224, 3DES_EDE_CBC, anon, NULL, include jdk.disabled.namedCurves");
    private static final g g = g.a(l0.e, "jdk.certpath.disabledAlgorithms", "MD2, MD5, SHA1 jdkCA & usage TLSServer, RSA keySize < 1024, DSA keySize < 1024, EC keySize < 224, include jdk.disabled.namedCurves");
    static final k0 h = new k0(null, true);
    static final k0 i = new k0(null, false);
    private final sdk.pendo.io.s4.a b;
    private final Set<String> c;
    private final boolean d;

    k0(sdk.pendo.io.s4.a aVar, boolean z) {
        super(null);
        this.b = aVar;
        this.c = null;
        this.d = z;
    }

    private String b(String str) {
        int indexOf = str.indexOf(58);
        return indexOf < 0 ? str : str.substring(0, indexOf);
    }

    private boolean c(String str) {
        return b(this.c, str);
    }

    @Override // sdk.pendo.io.s4.a
    public boolean permits(Set<sdk.pendo.io.s4.b> set, String str, AlgorithmParameters algorithmParameters) {
        g gVar;
        a(set);
        a(str);
        if (this.c != null) {
            String b = b(str);
            if (!c(str)) {
                Logger logger = e;
                if (logger.isLoggable(Level.FINEST)) {
                    logger.finest("Signature algorithm '" + str + "' not in supported signature algorithms");
                }
                return false;
            }
            str = b;
        }
        sdk.pendo.io.s4.a aVar = this.b;
        if (aVar != null && !aVar.permits(set, str, algorithmParameters)) {
            return false;
        }
        g gVar2 = f;
        if (gVar2 == null || gVar2.permits(set, str, algorithmParameters)) {
            return !this.d || (gVar = g) == null || gVar.permits(set, str, algorithmParameters);
        }
        return false;
    }

    k0(sdk.pendo.io.s4.a aVar, String[] strArr, boolean z) {
        super(null);
        this.b = aVar;
        this.c = a.b(strArr);
        this.d = z;
    }

    @Override // sdk.pendo.io.s4.a
    public boolean permits(Set<sdk.pendo.io.s4.b> set, String str, Key key, AlgorithmParameters algorithmParameters) {
        g gVar;
        a(set);
        a(str);
        a(key);
        if (this.c != null) {
            String b = b(str);
            if (!c(str)) {
                Logger logger = e;
                if (logger.isLoggable(Level.FINEST)) {
                    logger.finest("Signature algorithm '" + str + "' not in supported signature algorithms");
                }
                return false;
            }
            str = b;
        }
        sdk.pendo.io.s4.a aVar = this.b;
        if (aVar != null && !aVar.permits(set, str, key, algorithmParameters)) {
            return false;
        }
        g gVar2 = f;
        if (gVar2 == null || gVar2.permits(set, str, key, algorithmParameters)) {
            return !this.d || (gVar = g) == null || gVar.permits(set, str, key, algorithmParameters);
        }
        return false;
    }

    @Override // sdk.pendo.io.s4.a
    public boolean permits(Set<sdk.pendo.io.s4.b> set, Key key) {
        g gVar;
        a(set);
        a(key);
        sdk.pendo.io.s4.a aVar = this.b;
        if (aVar != null && !aVar.permits(set, key)) {
            return false;
        }
        g gVar2 = f;
        if (gVar2 == null || gVar2.permits(set, key)) {
            return !this.d || (gVar = g) == null || gVar.permits(set, key);
        }
        return false;
    }
}
