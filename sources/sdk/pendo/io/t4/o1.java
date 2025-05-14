package sdk.pendo.io.t4;

import java.lang.ref.SoftReference;
import java.net.Socket;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.ECPublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLEngine;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
class o1 extends sdk.pendo.io.r4.j {
    private static final Logger f = Logger.getLogger(o1.class.getName());
    private static final boolean g = i0.b("external.sdk.pendo.io.org.bouncycastle.jsse.keyManager.checkEKU", true);
    private static final Map<String, f> h = a();
    private static final Map<String, f> i = b();
    private final boolean b;
    private final sdk.pendo.io.p4.b c;
    private final List<KeyStore.Builder> d;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicLong f1596a = new AtomicLong();
    private final Map<String, SoftReference<KeyStore.PrivateKeyEntry>> e = Collections.synchronizedMap(new a(16, 0.75f, true));

    class a extends LinkedHashMap<String, SoftReference<KeyStore.PrivateKeyEntry>> {
        a(int i, float f, boolean z) {
            super(i, f, z);
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, SoftReference<KeyStore.PrivateKeyEntry>> entry) {
            return size() > 16;
        }
    }

    private static final class b implements f {

        /* renamed from: a, reason: collision with root package name */
        final String f1597a;
        final Class<? extends PublicKey> b;
        final int c;

        b(String str, Class<? extends PublicKey> cls, int i) {
            this.f1597a = str;
            this.b = cls;
            this.c = i;
        }

        @Override // sdk.pendo.io.t4.o1.f
        public boolean a(PublicKey publicKey, boolean[] zArr, sdk.pendo.io.s4.a aVar) {
            return a(publicKey) && j0.a(publicKey, zArr, this.c, aVar);
        }

        private boolean a(PublicKey publicKey) {
            Class<? extends PublicKey> cls;
            String str = this.f1597a;
            return (str != null && str.equalsIgnoreCase(a0.b(publicKey))) || ((cls = this.b) != null && cls.isInstance(publicKey));
        }
    }

    private static final class c implements f {

        /* renamed from: a, reason: collision with root package name */
        final sdk.pendo.io.m3.v f1598a;

        c(sdk.pendo.io.m3.v vVar) {
            this.f1598a = vVar;
        }

        @Override // sdk.pendo.io.t4.o1.f
        public boolean a(PublicKey publicKey, boolean[] zArr, sdk.pendo.io.s4.a aVar) {
            return a(publicKey) && j0.a(publicKey, zArr, 0, aVar);
        }

        private boolean a(PublicKey publicKey) {
            if ("EC".equalsIgnoreCase(a0.b(publicKey)) || ECPublicKey.class.isInstance(publicKey)) {
                return this.f1598a.b(a0.a(publicKey));
            }
            return false;
        }
    }

    private static final class d implements Comparable<d> {
        static final e v0 = e.MISMATCH_SNI;
        static final d w0 = new d(e.NONE, Integer.MAX_VALUE, -1, null, null, null);
        final int A;
        final e f;
        final String f0;
        final int s;
        final KeyStore t0;
        final X509Certificate[] u0;

        d(e eVar, int i, int i2, String str, KeyStore keyStore, X509Certificate[] x509CertificateArr) {
            this.f = eVar;
            this.s = i;
            this.A = i2;
            this.f0 = str;
            this.t0 = keyStore;
            this.u0 = x509CertificateArr;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            boolean b = b();
            if (b != dVar.b()) {
                return b ? -1 : 1;
            }
            int i = this.s;
            int i2 = dVar.s;
            return i != i2 ? i < i2 ? -1 : 1 : this.f.compareTo(dVar.f);
        }

        boolean b() {
            return this.f.compareTo(v0) < 0;
        }

        boolean a() {
            return e.OK == this.f && this.s == 0;
        }
    }

    enum e {
        OK,
        RSA_MULTI_USE,
        MISMATCH_SNI,
        EXPIRED,
        NONE
    }

    interface f {
        boolean a(PublicKey publicKey, boolean[] zArr, sdk.pendo.io.s4.a aVar);
    }

    o1(boolean z, sdk.pendo.io.p4.b bVar, List<KeyStore.Builder> list) {
        this.b = z;
        this.c = bVar;
        this.d = list;
    }

    private static void a(Map<String, f> map, int i2) {
        sdk.pendo.io.m3.v a2;
        if (!sdk.pendo.io.y4.p0.a(i2, sdk.pendo.io.y4.v0.g)) {
            throw new IllegalStateException("Invalid named group for TLS 1.3 EC filter");
        }
        String b2 = sdk.pendo.io.y4.p0.b(i2);
        if (b2 == null || (a2 = sdk.pendo.io.f4.a.a(b2)) == null) {
            f.warning("Failed to register public key filter for EC with " + sdk.pendo.io.y4.p0.g(i2));
        } else {
            a(map, a0.a("EC", i2), new c(a2));
        }
    }

    private String[] c(List<String> list, Principal[] principalArr, x1 x1Var, boolean z) {
        int i2;
        int i3;
        List<d> list2;
        o1 o1Var = this;
        if (o1Var.d.isEmpty() || list.isEmpty()) {
            return null;
        }
        int size = list.size();
        Set<Principal> a2 = a(principalArr);
        sdk.pendo.io.s4.a a3 = x1.a(x1Var, true);
        Date date = new Date();
        String a4 = a(x1Var, z);
        int size2 = o1Var.d.size();
        int i4 = 0;
        List<d> list3 = null;
        while (i4 < size2) {
            try {
                KeyStore.Builder builder = o1Var.d.get(i4);
                KeyStore keyStore = builder.getKeyStore();
                if (keyStore == null) {
                    i2 = i4;
                    i3 = size2;
                } else {
                    Enumeration<String> aliases = keyStore.aliases();
                    List<d> list4 = list3;
                    while (aliases.hasMoreElements()) {
                        try {
                            list2 = list4;
                            i2 = i4;
                            i3 = size2;
                        } catch (KeyStoreException e2) {
                            e = e2;
                            list2 = list4;
                            i2 = i4;
                            i3 = size2;
                        }
                        try {
                            d a5 = a(i4, builder, keyStore, aliases.nextElement(), list, size, a2, a3, z, date, a4);
                            if (a5.compareTo(d.w0) < 0) {
                                list4 = a(list2, a5);
                                i4 = i2;
                            } else {
                                i4 = i2;
                                list4 = list2;
                            }
                            size2 = i3;
                        } catch (KeyStoreException e3) {
                            e = e3;
                            list3 = list2;
                            f.log(Level.WARNING, "Failed to fully process KeyStore.Builder at index " + i2, (Throwable) e);
                            i4 = i2 + 1;
                            o1Var = this;
                            size2 = i3;
                        }
                    }
                    i2 = i4;
                    i3 = size2;
                    list3 = list4;
                }
            } catch (KeyStoreException e4) {
                e = e4;
                i2 = i4;
                i3 = size2;
            }
            i4 = i2 + 1;
            o1Var = this;
            size2 = i3;
        }
        if (list3 == null || list3.isEmpty()) {
            return null;
        }
        Collections.sort(list3);
        return a(list3, c());
    }

    private d d(List<String> list, Principal[] principalArr, x1 x1Var, boolean z) {
        int i2;
        int i3;
        boolean z2;
        int i4;
        d dVar;
        int i5;
        int i6;
        o1 o1Var = this;
        d dVar2 = d.w0;
        if (o1Var.d.isEmpty() || list.isEmpty()) {
            return dVar2;
        }
        int size = list.size();
        Set<Principal> a2 = a(principalArr);
        boolean z3 = true;
        sdk.pendo.io.s4.a a3 = x1.a(x1Var, true);
        Date date = new Date();
        String a4 = a(x1Var, z);
        int size2 = o1Var.d.size();
        int i7 = 0;
        int i8 = size;
        d dVar3 = dVar2;
        while (i7 < size2) {
            try {
                KeyStore.Builder builder = o1Var.d.get(i7);
                KeyStore keyStore = builder.getKeyStore();
                if (keyStore == null) {
                    i2 = i7;
                    i3 = size2;
                    z2 = z3;
                } else {
                    Enumeration<String> aliases = keyStore.aliases();
                    d dVar4 = dVar3;
                    int i9 = i8;
                    while (aliases.hasMoreElements()) {
                        try {
                            i5 = i9;
                            dVar = dVar4;
                            i2 = i7;
                            i3 = size2;
                        } catch (KeyStoreException e2) {
                            e = e2;
                            i8 = i9;
                            i2 = i7;
                            i3 = size2;
                            z2 = z3;
                            dVar = dVar4;
                        }
                        try {
                            dVar4 = a(i7, builder, keyStore, aliases.nextElement(), list, i9, a2, a3, z, date, a4);
                            if (dVar4.compareTo(dVar) < 0) {
                                try {
                                    if (dVar4.a()) {
                                        return dVar4;
                                    }
                                    if (dVar4.b()) {
                                        z2 = true;
                                        i6 = i5;
                                        try {
                                            i9 = Math.min(i6, dVar4.s + 1);
                                        } catch (KeyStoreException e3) {
                                            e = e3;
                                            i4 = i6;
                                            dVar3 = dVar4;
                                            f.log(Level.WARNING, "Failed to fully process KeyStore.Builder at index " + i2, (Throwable) e);
                                            i8 = i4;
                                            i7 = i2 + 1;
                                            o1Var = this;
                                            z3 = z2;
                                            size2 = i3;
                                        }
                                    } else {
                                        z2 = true;
                                        i9 = i5;
                                    }
                                    z3 = z2;
                                    i7 = i2;
                                    size2 = i3;
                                } catch (KeyStoreException e4) {
                                    e = e4;
                                    i6 = i5;
                                    z2 = true;
                                }
                            } else {
                                i9 = i5;
                                i7 = i2;
                                dVar4 = dVar;
                                size2 = i3;
                                z3 = true;
                            }
                        } catch (KeyStoreException e5) {
                            e = e5;
                            i8 = i5;
                            z2 = true;
                            dVar3 = dVar;
                            i4 = i8;
                            f.log(Level.WARNING, "Failed to fully process KeyStore.Builder at index " + i2, (Throwable) e);
                            i8 = i4;
                            i7 = i2 + 1;
                            o1Var = this;
                            z3 = z2;
                            size2 = i3;
                        }
                    }
                    i8 = i9;
                    i2 = i7;
                    i3 = size2;
                    z2 = z3;
                    dVar3 = dVar4;
                }
            } catch (KeyStoreException e6) {
                e = e6;
                i2 = i7;
                i3 = size2;
                z2 = z3;
            }
            i7 = i2 + 1;
            o1Var = this;
            z3 = z2;
            size2 = i3;
        }
        return dVar3;
    }

    @Override // sdk.pendo.io.r4.j
    public sdk.pendo.io.r4.l b(String[] strArr, Principal[] principalArr, SSLEngine sSLEngine) {
        return b(a(strArr), principalArr, x1.a(sSLEngine), true);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseClientAlias(String[] strArr, Principal[] principalArr, Socket socket) {
        return a(a(strArr), principalArr, x1.a(socket), false);
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineClientAlias(String[] strArr, Principal[] principalArr, SSLEngine sSLEngine) {
        return a(a(strArr), principalArr, x1.a(sSLEngine), false);
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineServerAlias(String str, Principal[] principalArr, SSLEngine sSLEngine) {
        return a(a(str), principalArr, x1.a(sSLEngine), true);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseServerAlias(String str, Principal[] principalArr, Socket socket) {
        return a(a(str), principalArr, x1.a(socket), true);
    }

    @Override // javax.net.ssl.X509KeyManager
    public X509Certificate[] getCertificateChain(String str) {
        KeyStore.PrivateKeyEntry a2 = a(str);
        if (a2 == null) {
            return null;
        }
        return (X509Certificate[]) a2.getCertificateChain();
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getClientAliases(String str, Principal[] principalArr) {
        return c(a(str), principalArr, null, false);
    }

    @Override // javax.net.ssl.X509KeyManager
    public PrivateKey getPrivateKey(String str) {
        KeyStore.PrivateKeyEntry a2 = a(str);
        if (a2 == null) {
            return null;
        }
        return a2.getPrivateKey();
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getServerAliases(String str, Principal[] principalArr) {
        return c(a(str), principalArr, null, true);
    }

    private static void a(Map<String, f> map, int i2, String str, Class<? extends PublicKey> cls, String... strArr) {
        b bVar = new b(str, cls, i2);
        for (String str2 : strArr) {
            a(map, str2, bVar);
        }
    }

    private sdk.pendo.io.r4.l b(List<String> list, Principal[] principalArr, x1 x1Var, boolean z) {
        d d2 = d(list, principalArr, x1Var, z);
        if (d2.compareTo(d.w0) < 0) {
            try {
                String str = list.get(d2.s);
                sdk.pendo.io.r4.l a2 = a(str, d2.A, d2.f0, d2.t0, d2.u0);
                if (a2 != null) {
                    Logger logger = f;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine("Found matching key of type: " + str + ", from alias: " + d2.A + "." + d2.f0);
                    }
                    return a2;
                }
            } catch (Exception e2) {
                f.log(Level.FINER, "Failed to load private key", (Throwable) e2);
            }
        }
        f.fine("No matching key found");
        return null;
    }

    private String c() {
        return "." + this.f1596a.incrementAndGet();
    }

    private static void a(Map<String, f> map, Class<? extends PublicKey> cls, String... strArr) {
        a(map, 0, (String) null, cls, strArr);
    }

    @Override // sdk.pendo.io.r4.j
    public sdk.pendo.io.r4.l b(String[] strArr, Principal[] principalArr, Socket socket) {
        return b(a(strArr), principalArr, x1.a(socket), true);
    }

    private static void a(Map<String, f> map, String str) {
        a(map, 0, str, (Class<? extends PublicKey>) null, str);
    }

    private static Map<String, f> b() {
        HashMap hashMap = new HashMap();
        a(hashMap, EdDSAParameterSpec.Ed25519);
        a(hashMap, EdDSAParameterSpec.Ed448);
        a(hashMap, 31);
        a(hashMap, 32);
        a(hashMap, 33);
        a(hashMap, 23);
        a(hashMap, 24);
        a(hashMap, 25);
        a(hashMap, "RSA");
        a(hashMap, "RSASSA-PSS");
        a(hashMap, (Class<? extends PublicKey>) DSAPublicKey.class, 3, 22);
        a(hashMap, (Class<? extends PublicKey>) ECPublicKey.class, 17);
        a(hashMap, "RSA", 5, 19, 23);
        a(hashMap, 2, "RSA", 1);
        return Collections.unmodifiableMap(hashMap);
    }

    private static void a(Map<String, f> map, int i2, String str, Class<? extends PublicKey> cls, int... iArr) {
        a(map, i2, str, cls, a(iArr));
    }

    private KeyStore.PrivateKeyEntry b(String str) {
        int i2;
        int lastIndexOf;
        int parseInt;
        try {
            int indexOf = str.indexOf(46, 0);
            if (indexOf <= 0 || (lastIndexOf = str.lastIndexOf(46)) <= (i2 = indexOf + 1) || (parseInt = Integer.parseInt(str.substring(0, indexOf))) < 0 || parseInt >= this.d.size()) {
                return null;
            }
            KeyStore.Builder builder = this.d.get(parseInt);
            String substring = str.substring(i2, lastIndexOf);
            KeyStore keyStore = builder.getKeyStore();
            if (keyStore == null) {
                return null;
            }
            KeyStore.Entry entry = keyStore.getEntry(substring, builder.getProtectionParameter(substring));
            if (entry instanceof KeyStore.PrivateKeyEntry) {
                return (KeyStore.PrivateKeyEntry) entry;
            }
            return null;
        } catch (Exception e2) {
            f.log(Level.FINER, "Failed to load PrivateKeyEntry: " + str, (Throwable) e2);
            return null;
        }
    }

    private static void a(Map<String, f> map, int i2, String str, int... iArr) {
        a(map, i2, str, (Class<? extends PublicKey>) null, iArr);
    }

    private static void a(Map<String, f> map, Class<? extends PublicKey> cls, int... iArr) {
        a(map, 0, (String) null, cls, iArr);
    }

    private static void a(Map<String, f> map, String str, int... iArr) {
        a(map, 0, str, iArr);
    }

    private static void a(Map<String, f> map, String str, f fVar) {
        if (map.put(str, fVar) != null) {
            throw new IllegalStateException("Duplicate keys in filters");
        }
    }

    private static List<d> a(List<d> list, d dVar) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(dVar);
        return list;
    }

    private String a(List<String> list, Principal[] principalArr, x1 x1Var, boolean z) {
        d d2 = d(list, principalArr, x1Var, z);
        if (d2.compareTo(d.w0) >= 0) {
            f.fine("No matching key found");
            return null;
        }
        String str = list.get(d2.s);
        String a2 = a(d2, c());
        Logger logger = f;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("Found matching key of type: " + str + ", returning alias: " + a2);
        }
        return a2;
    }

    @Override // sdk.pendo.io.r4.j
    public sdk.pendo.io.r4.l a(String[] strArr, Principal[] principalArr, Socket socket) {
        return b(a(strArr), principalArr, x1.a(socket), false);
    }

    @Override // sdk.pendo.io.r4.j
    public sdk.pendo.io.r4.l a(String[] strArr, Principal[] principalArr, SSLEngine sSLEngine) {
        return b(a(strArr), principalArr, x1.a(sSLEngine), false);
    }

    private static Map<String, f> a() {
        HashMap hashMap = new HashMap();
        a(hashMap, EdDSAParameterSpec.Ed25519);
        a(hashMap, EdDSAParameterSpec.Ed448);
        a(hashMap, 31);
        a(hashMap, 32);
        a(hashMap, 33);
        a(hashMap, 23);
        a(hashMap, 24);
        a(hashMap, 25);
        a(hashMap, "RSA");
        a(hashMap, "RSASSA-PSS");
        a(hashMap, (Class<? extends PublicKey>) DSAPublicKey.class, "DSA");
        a(hashMap, (Class<? extends PublicKey>) ECPublicKey.class, "EC");
        return Collections.unmodifiableMap(hashMap);
    }

    private sdk.pendo.io.r4.l a(String str, int i2, String str2, KeyStore keyStore, X509Certificate[] x509CertificateArr) {
        Key a2 = e0.a(keyStore, str2, this.d.get(i2).getProtectionParameter(str2));
        if (a2 instanceof PrivateKey) {
            return new n1(str, (PrivateKey) a2, x509CertificateArr);
        }
        return null;
    }

    private static String a(d dVar, String str) {
        return dVar.A + "." + dVar.f0 + str;
    }

    private static String[] a(List<d> list, String str) {
        String[] strArr = new String[list.size()];
        Iterator<d> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            strArr[i2] = a(it.next(), str);
            i2++;
        }
        return strArr;
    }

    private static e a(X509Certificate x509Certificate, Date date, String str) {
        try {
            x509Certificate.checkValidity(date);
            if (str != null) {
                try {
                    q1.a(str, x509Certificate, "HTTPS");
                } catch (CertificateException unused) {
                    return e.MISMATCH_SNI;
                }
            }
            if ("RSA".equalsIgnoreCase(a0.b(x509Certificate.getPublicKey()))) {
                boolean[] keyUsage = x509Certificate.getKeyUsage();
                if (j0.a(keyUsage, 0) && j0.a(keyUsage, 2)) {
                    return e.RSA_MULTI_USE;
                }
            }
            return e.OK;
        } catch (CertificateException unused2) {
            return e.EXPIRED;
        }
    }

    @Override // sdk.pendo.io.r4.j
    protected sdk.pendo.io.r4.l a(String str, String str2) {
        PrivateKey privateKey;
        KeyStore.PrivateKeyEntry a2 = a(str2);
        if (a2 == null || (privateKey = a2.getPrivateKey()) == null) {
            return null;
        }
        X509Certificate[] a3 = a0.a(a2.getCertificateChain());
        if (l3.b(a3)) {
            return null;
        }
        return new n1(str, privateKey, a3);
    }

    static e a(boolean z, sdk.pendo.io.p4.b bVar, List<String> list, sdk.pendo.io.s4.a aVar, boolean z2, Date date, String str, X509Certificate[] x509CertificateArr, int i2) {
        String str2 = list.get(i2);
        Logger logger = f;
        logger.finer("EE cert potentially usable for key type: " + str2);
        if (a(z, bVar, x509CertificateArr, aVar, z2)) {
            return a(x509CertificateArr[0], date, str);
        }
        logger.finer("Unsuitable chain for key type: " + str2);
        return e.NONE;
    }

    static List<String> a(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (str == null) {
                throw new IllegalArgumentException("Key types cannot be null");
            }
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static String[] a(int... iArr) {
        int length = iArr.length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = a0.b(iArr[i2]);
        }
        return strArr;
    }

    static int a(List<String> list, int i2, Set<Principal> set, sdk.pendo.io.s4.a aVar, boolean z, X509Certificate[] x509CertificateArr) {
        if (a(x509CertificateArr, set)) {
            return a(x509CertificateArr[0], list, i2, aVar, z);
        }
        return -1;
    }

    private d a(int i2, KeyStore.Builder builder, KeyStore keyStore, String str, List<String> list, int i3, Set<Principal> set, sdk.pendo.io.s4.a aVar, boolean z, Date date, String str2) {
        X509Certificate[] a2;
        int a3;
        e a4;
        return (!keyStore.isKeyEntry(str) || (a3 = a(list, i3, set, aVar, z, (a2 = a0.a(keyStore.getCertificateChain(str))))) < 0 || e.NONE == (a4 = a(this.b, this.c, list, aVar, z, date, str2, a2, a3))) ? d.w0 : new d(a4, a3, i2, str, keyStore, a2);
    }

    private KeyStore.PrivateKeyEntry a(String str) {
        KeyStore.PrivateKeyEntry privateKeyEntry;
        if (str == null) {
            return null;
        }
        SoftReference<KeyStore.PrivateKeyEntry> softReference = this.e.get(str);
        if (softReference != null && (privateKeyEntry = softReference.get()) != null) {
            return privateKeyEntry;
        }
        KeyStore.PrivateKeyEntry b2 = b(str);
        if (b2 != null) {
            this.e.put(str, new SoftReference<>(b2));
        }
        return b2;
    }

    static String a(x1 x1Var, boolean z) {
        sdk.pendo.io.r4.b a2;
        sdk.pendo.io.r4.c a3;
        if (x1Var == null || !z || (a2 = x1Var.a()) == null || (a3 = a0.a(a2.e())) == null) {
            return null;
        }
        return a3.c();
    }

    private static sdk.pendo.io.e4.f a(boolean z) {
        if (g) {
            return z ? sdk.pendo.io.e4.f.f0 : sdk.pendo.io.e4.f.t0;
        }
        return null;
    }

    private static int a(X509Certificate x509Certificate, List<String> list, int i2, sdk.pendo.io.s4.a aVar, boolean z) {
        Map<String, f> map = z ? i : h;
        PublicKey publicKey = x509Certificate.getPublicKey();
        boolean[] keyUsage = x509Certificate.getKeyUsage();
        for (int i3 = 0; i3 < i2; i3++) {
            f fVar = map.get(list.get(i3));
            if (fVar != null && fVar.a(publicKey, keyUsage, aVar)) {
                return i3;
            }
        }
        return -1;
    }

    static Set<Principal> a(Principal[] principalArr) {
        if (principalArr == null) {
            return null;
        }
        if (principalArr.length > 0) {
            HashSet hashSet = new HashSet();
            for (Principal principal : principalArr) {
                if (principal != null) {
                    hashSet.add(principal);
                }
            }
            if (!hashSet.isEmpty()) {
                return Collections.unmodifiableSet(hashSet);
            }
        }
        return Collections.emptySet();
    }

    private static boolean a(boolean z, sdk.pendo.io.p4.b bVar, X509Certificate[] x509CertificateArr, sdk.pendo.io.s4.a aVar, boolean z2) {
        try {
            j0.a(z, bVar, aVar, Collections.emptySet(), x509CertificateArr, a(z2), -1);
            return true;
        } catch (CertPathValidatorException e2) {
            f.log(Level.FINEST, "Certificate chain check failed", (Throwable) e2);
            return false;
        }
    }

    private static boolean a(X509Certificate[] x509CertificateArr, Set<Principal> set) {
        if (l3.b(x509CertificateArr)) {
            return false;
        }
        if (set == null || set.isEmpty()) {
            return true;
        }
        int length = x509CertificateArr.length;
        do {
            length--;
            if (length < 0) {
                X509Certificate x509Certificate = x509CertificateArr[0];
                return x509Certificate.getBasicConstraints() >= 0 && set.contains(x509Certificate.getSubjectX500Principal());
            }
        } while (!set.contains(x509CertificateArr[length].getIssuerX500Principal()));
        return true;
    }

    static boolean a(boolean z, String str, X509Certificate x509Certificate, x1 x1Var) {
        f fVar = (z ? i : h).get(str);
        if (fVar == null) {
            return false;
        }
        return fVar.a(x509Certificate.getPublicKey(), x509Certificate.getKeyUsage(), x1.a(x1Var, true));
    }
}
