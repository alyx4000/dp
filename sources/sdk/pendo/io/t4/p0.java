package sdk.pendo.io.t4;

import external.sdk.pendo.io.mozilla.javascript.Token;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
class p0 extends SSLContextSpi {
    private static final Logger j = Logger.getLogger(p0.class.getName());
    private static final Set<sdk.pendo.io.s4.b> k = a0.g;
    private static final Map<String, d> l;
    private static final Map<String, d> m;
    private static final Map<String, sdk.pendo.io.y4.v0> n;
    private static final Map<String, sdk.pendo.io.y4.v0> o;
    private static final List<String> p;
    private static final List<String> q;
    private static final List<String> r;
    private static final List<String> s;

    /* renamed from: a, reason: collision with root package name */
    protected final boolean f1599a;
    protected final sdk.pendo.io.b5.i b;
    protected final Map<String, d> c;
    protected final Map<String, sdk.pendo.io.y4.v0> d;
    protected final String[] e;
    protected final String[] f;
    protected final String[] g;
    protected final String[] h;
    private e i = null;

    class a implements Comparator<sdk.pendo.io.y4.v0> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(sdk.pendo.io.y4.v0 v0Var, sdk.pendo.io.y4.v0 v0Var2) {
            if (v0Var.f(v0Var2)) {
                return -1;
            }
            return v0Var2.f(v0Var) ? 1 : 0;
        }
    }

    static {
        Map<String, d> a2 = a();
        l = a2;
        m = a(a2);
        Map<String, sdk.pendo.io.y4.v0> b = b();
        n = b;
        o = b(b);
        List<String> a3 = a(a2.keySet());
        p = a3;
        q = a(a3);
        List<String> b2 = b(b.keySet());
        r = b2;
        s = b(b2);
    }

    p0(boolean z, sdk.pendo.io.b5.i iVar, List<String> list) {
        this.f1599a = z;
        this.b = iVar;
        Map<String, d> map = z ? m : l;
        this.c = map;
        Map<String, sdk.pendo.io.y4.v0> map2 = z ? o : n;
        this.d = map2;
        List<String> list2 = z ? q : p;
        List<String> list3 = z ? s : r;
        this.e = a(map, list2);
        this.f = b(map, list2);
        this.g = a(map2, list3, list);
        this.h = c(map2, list3);
    }

    private static void a(Map<String, d> map, String str, int i) {
        if (map.put(str, d.a(i, str)) != null) {
            throw new IllegalStateException("Duplicate names in supported-cipher-suites");
        }
    }

    private static List<String> b(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("TLSv1.2");
        arrayList.add("TLSv1.1");
        arrayList.add("TLSv1");
        arrayList.retainAll(set);
        arrayList.trimToSize();
        return Collections.unmodifiableList(arrayList);
    }

    static KeyManager[] d() {
        d0 a2 = n0.a();
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(a2.f1570a, a2.b);
        return keyManagerFactory.getKeyManagers();
    }

    static TrustManager[] e() {
        KeyStore a2 = m1.a();
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(a2);
        return trustManagerFactory.getTrustManagers();
    }

    protected synchronized e c() {
        e eVar;
        eVar = this.i;
        if (eVar == null) {
            throw new IllegalStateException("SSLContext has not been initialized.");
        }
        return eVar;
    }

    @Override // javax.net.ssl.SSLContextSpi
    protected synchronized SSLEngine engineCreateSSLEngine() {
        return s1.a(c());
    }

    @Override // javax.net.ssl.SSLContextSpi
    protected synchronized SSLSessionContext engineGetClientSessionContext() {
        return c().a();
    }

    @Override // javax.net.ssl.SSLContextSpi
    protected SSLParameters engineGetDefaultSSLParameters() {
        c();
        return t1.b(b(true));
    }

    @Override // javax.net.ssl.SSLContextSpi
    protected synchronized SSLSessionContext engineGetServerSessionContext() {
        return c().d();
    }

    @Override // javax.net.ssl.SSLContextSpi
    protected SSLServerSocketFactory engineGetServerSocketFactory() {
        return new u0(c());
    }

    @Override // javax.net.ssl.SSLContextSpi
    protected SSLSocketFactory engineGetSocketFactory() {
        return new d1(c());
    }

    @Override // javax.net.ssl.SSLContextSpi
    protected SSLParameters engineGetSupportedSSLParameters() {
        c();
        return t1.b(c(true));
    }

    @Override // javax.net.ssl.SSLContextSpi
    protected synchronized void engineInit(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) {
        this.i = null;
        sdk.pendo.io.b5.h a2 = this.b.a(secureRandom);
        sdk.pendo.io.p4.b g = a2.g();
        sdk.pendo.io.r4.j a3 = a(g, keyManagerArr);
        sdk.pendo.io.r4.k a4 = a(g, trustManagerArr);
        a2.h().nextInt();
        this.i = new e(this, a2, a3, a4);
    }

    String[] f() {
        return c(this.c);
    }

    String[] g() {
        return c(this.d);
    }

    boolean h() {
        return this.f1599a;
    }

    private static List<String> a(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("TLS_CHACHA20_POLY1305_SHA256");
        arrayList.add("TLS_AES_256_GCM_SHA384");
        arrayList.add("TLS_AES_128_GCM_SHA256");
        arrayList.add("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");
        arrayList.add("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
        arrayList.add("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
        arrayList.add("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        arrayList.add("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
        arrayList.add("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        arrayList.add("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        arrayList.add("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
        arrayList.add("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
        arrayList.add("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
        arrayList.add("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
        arrayList.add("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
        arrayList.add("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
        arrayList.add("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
        arrayList.add("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
        arrayList.add("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
        arrayList.add("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
        arrayList.add("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
        arrayList.add("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
        arrayList.add("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
        arrayList.add("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
        arrayList.add("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
        arrayList.add("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
        arrayList.add("TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
        arrayList.add("TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
        arrayList.add("TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
        arrayList.add("TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
        arrayList.add("TLS_RSA_WITH_AES_256_GCM_SHA384");
        arrayList.add("TLS_RSA_WITH_AES_128_GCM_SHA256");
        arrayList.add("TLS_RSA_WITH_AES_256_CBC_SHA256");
        arrayList.add("TLS_RSA_WITH_AES_128_CBC_SHA256");
        arrayList.add("TLS_RSA_WITH_AES_256_CBC_SHA");
        arrayList.add("TLS_RSA_WITH_AES_128_CBC_SHA");
        arrayList.retainAll(set);
        arrayList.trimToSize();
        return Collections.unmodifiableList(arrayList);
    }

    private static List<String> b(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        o.b(arrayList);
        arrayList.trimToSize();
        return Collections.unmodifiableList(arrayList);
    }

    private static String[] c(Map<String, sdk.pendo.io.y4.v0> map, List<String> list) {
        return a(map, "jdk.tls.server.protocols", list, (List<String>) null);
    }

    private String[] d(boolean z) {
        return z ? this.e : this.f;
    }

    private String[] e(boolean z) {
        return z ? this.g : this.h;
    }

    @Override // javax.net.ssl.SSLContextSpi
    protected synchronized SSLEngine engineCreateSSLEngine(String str, int i) {
        return s1.a(c(), str, i);
    }

    private static List<String> a(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        o.a(arrayList);
        arrayList.trimToSize();
        return Collections.unmodifiableList(arrayList);
    }

    private static Map<String, sdk.pendo.io.y4.v0> b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("TLSv1.3", sdk.pendo.io.y4.v0.g);
        linkedHashMap.put("TLSv1.2", sdk.pendo.io.y4.v0.f);
        linkedHashMap.put("TLSv1.1", sdk.pendo.io.y4.v0.e);
        linkedHashMap.put("TLSv1", sdk.pendo.io.y4.v0.d);
        linkedHashMap.put("SSLv3", sdk.pendo.io.y4.v0.c);
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static String[] c(Map<String, ?> map) {
        return a((Collection<String>) map.keySet());
    }

    private static Map<String, d> a() {
        TreeMap treeMap = new TreeMap();
        a(treeMap, "TLS_AES_128_CCM_8_SHA256", 4869);
        a(treeMap, "TLS_AES_128_CCM_SHA256", 4868);
        a(treeMap, "TLS_AES_128_GCM_SHA256", 4865);
        a(treeMap, "TLS_AES_256_GCM_SHA384", 4866);
        a(treeMap, "TLS_CHACHA20_POLY1305_SHA256", 4867);
        a(treeMap, "TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        a(treeMap, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        a(treeMap, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        a(treeMap, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", Token.COMMENT);
        a(treeMap, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        a(treeMap, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        a(treeMap, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", Token.GENEXPR);
        a(treeMap, "TLS_DHE_DSS_WITH_ARIA_128_CBC_SHA256", 49218);
        a(treeMap, "TLS_DHE_DSS_WITH_ARIA_128_GCM_SHA256", 49238);
        a(treeMap, "TLS_DHE_DSS_WITH_ARIA_256_CBC_SHA384", 49219);
        a(treeMap, "TLS_DHE_DSS_WITH_ARIA_256_GCM_SHA384", 49239);
        a(treeMap, "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        a(treeMap, "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA256", 189);
        a(treeMap, "TLS_DHE_DSS_WITH_CAMELLIA_128_GCM_SHA256", 49280);
        a(treeMap, "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        a(treeMap, "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA256", 195);
        a(treeMap, "TLS_DHE_DSS_WITH_CAMELLIA_256_GCM_SHA384", 49281);
        a(treeMap, "TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        a(treeMap, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        a(treeMap, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        a(treeMap, "TLS_DHE_RSA_WITH_AES_128_CCM", 49310);
        a(treeMap, "TLS_DHE_RSA_WITH_AES_128_CCM_8", 49314);
        a(treeMap, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        a(treeMap, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        a(treeMap, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        a(treeMap, "TLS_DHE_RSA_WITH_AES_256_CCM", 49311);
        a(treeMap, "TLS_DHE_RSA_WITH_AES_256_CCM_8", 49315);
        a(treeMap, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", Token.LETEXPR);
        a(treeMap, "TLS_DHE_RSA_WITH_ARIA_128_CBC_SHA256", 49220);
        a(treeMap, "TLS_DHE_RSA_WITH_ARIA_128_GCM_SHA256", 49234);
        a(treeMap, "TLS_DHE_RSA_WITH_ARIA_256_CBC_SHA384", 49221);
        a(treeMap, "TLS_DHE_RSA_WITH_ARIA_256_GCM_SHA384", 49235);
        a(treeMap, "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        a(treeMap, "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA256", 190);
        a(treeMap, "TLS_DHE_RSA_WITH_CAMELLIA_128_GCM_SHA256", 49276);
        a(treeMap, "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        a(treeMap, "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA256", 196);
        a(treeMap, "TLS_DHE_RSA_WITH_CAMELLIA_256_GCM_SHA384", 49277);
        a(treeMap, "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_AES_128_CCM", 49324);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_AES_128_CCM_8", 49326);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_AES_256_CCM", 49325);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_AES_256_CCM_8", 49327);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_ARIA_128_CBC_SHA256", 49224);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_ARIA_128_GCM_SHA256", 49244);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_ARIA_256_CBC_SHA384", 49225);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_ARIA_256_GCM_SHA384", 49245);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_CAMELLIA_128_CBC_SHA256", 49266);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_CAMELLIA_128_GCM_SHA256", 49286);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_CAMELLIA_256_CBC_SHA384", 49267);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_CAMELLIA_256_GCM_SHA384", 49287);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        a(treeMap, "TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        a(treeMap, "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        a(treeMap, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        a(treeMap, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        a(treeMap, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        a(treeMap, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        a(treeMap, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        a(treeMap, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        a(treeMap, "TLS_ECDHE_RSA_WITH_ARIA_128_CBC_SHA256", 49228);
        a(treeMap, "TLS_ECDHE_RSA_WITH_ARIA_128_GCM_SHA256", 49248);
        a(treeMap, "TLS_ECDHE_RSA_WITH_ARIA_256_CBC_SHA384", 49229);
        a(treeMap, "TLS_ECDHE_RSA_WITH_ARIA_256_GCM_SHA384", 49249);
        a(treeMap, "TLS_ECDHE_RSA_WITH_CAMELLIA_128_CBC_SHA256", 49270);
        a(treeMap, "TLS_ECDHE_RSA_WITH_CAMELLIA_128_GCM_SHA256", 49290);
        a(treeMap, "TLS_ECDHE_RSA_WITH_CAMELLIA_256_CBC_SHA384", 49271);
        a(treeMap, "TLS_ECDHE_RSA_WITH_CAMELLIA_256_GCM_SHA384", 49291);
        a(treeMap, "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        a(treeMap, "TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        a(treeMap, "TLS_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        a(treeMap, "TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        a(treeMap, "TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        a(treeMap, "TLS_RSA_WITH_AES_128_CCM", 49308);
        a(treeMap, "TLS_RSA_WITH_AES_128_CCM_8", 49312);
        a(treeMap, "TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        a(treeMap, "TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        a(treeMap, "TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        a(treeMap, "TLS_RSA_WITH_AES_256_CCM", 49309);
        a(treeMap, "TLS_RSA_WITH_AES_256_CCM_8", 49313);
        a(treeMap, "TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        a(treeMap, "TLS_RSA_WITH_ARIA_128_CBC_SHA256", 49212);
        a(treeMap, "TLS_RSA_WITH_ARIA_128_GCM_SHA256", 49232);
        a(treeMap, "TLS_RSA_WITH_ARIA_256_CBC_SHA384", 49213);
        a(treeMap, "TLS_RSA_WITH_ARIA_256_GCM_SHA384", 49233);
        a(treeMap, "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        a(treeMap, "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256", 186);
        a(treeMap, "TLS_RSA_WITH_CAMELLIA_128_GCM_SHA256", 49274);
        a(treeMap, "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        a(treeMap, "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA256", 192);
        a(treeMap, "TLS_RSA_WITH_CAMELLIA_256_GCM_SHA384", 49275);
        a(treeMap, "TLS_RSA_WITH_NULL_SHA", 2);
        a(treeMap, "TLS_RSA_WITH_NULL_SHA256", 59);
        return Collections.unmodifiableMap(treeMap);
    }

    private static Map<String, sdk.pendo.io.y4.v0> b(Map<String, sdk.pendo.io.y4.v0> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        o.b(linkedHashMap.keySet());
        return Collections.unmodifiableMap(linkedHashMap);
    }

    s0 c(boolean z) {
        return new s0(this, f(), g());
    }

    private static Map<String, d> a(Map<String, d> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        o.a(linkedHashMap.keySet());
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static String[] b(Map<String, d> map, List<String> list) {
        return a(map, list, i0.b("external.sdk.pendo.io.org.bouncycastle.jsse.server.dh.disableDefaultSuites", false), "jdk.tls.server.cipherSuites");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int[] a(sdk.pendo.io.b5.h r13, sdk.pendo.io.t4.s0 r14, sdk.pendo.io.y4.v0[] r15) {
        /*
            r12 = this;
            java.lang.String[] r0 = r14.f()
            sdk.pendo.io.s4.a r14 = r14.c()
            sdk.pendo.io.y4.v0 r1 = sdk.pendo.io.y4.v0.c(r15)
            sdk.pendo.io.y4.v0 r15 = sdk.pendo.io.y4.v0.a(r15)
            boolean r1 = sdk.pendo.io.y4.l3.e(r1)
            boolean r15 = sdk.pendo.io.y4.l3.e(r15)
            r2 = 1
            r15 = r15 ^ r2
            int r3 = r0.length
            int[] r3 = new int[r3]
            int r4 = r0.length
            r5 = 0
            r6 = r5
            r7 = r6
        L21:
            if (r6 >= r4) goto L52
            r8 = r0[r6]
            java.util.Map<java.lang.String, sdk.pendo.io.t4.d> r9 = r12.c
            java.lang.Object r9 = r9.get(r8)
            sdk.pendo.io.t4.d r9 = (sdk.pendo.io.t4.d) r9
            if (r9 != 0) goto L30
            goto L4f
        L30:
            boolean r10 = r9.e()
            if (r10 == 0) goto L39
            if (r1 != 0) goto L3c
            goto L4f
        L39:
            if (r15 != 0) goto L3c
            goto L4f
        L3c:
            java.util.Set<sdk.pendo.io.s4.b> r10 = sdk.pendo.io.t4.p0.k
            r11 = 0
            boolean r8 = r14.permits(r10, r8, r11)
            if (r8 != 0) goto L46
            goto L4f
        L46:
            int r8 = r7 + 1
            int r9 = r9.a()
            r3[r7] = r9
            r7 = r8
        L4f:
            int r6 = r6 + 1
            goto L21
        L52:
            int[] r13 = sdk.pendo.io.y4.l3.a(r13, r3, r5, r7)
            int r14 = r13.length
            if (r14 < r2) goto L5a
            return r13
        L5a:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "No usable cipher suites enabled"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.t4.p0.a(sdk.pendo.io.b5.h, sdk.pendo.io.t4.s0, sdk.pendo.io.y4.v0[]):int[]");
    }

    s0 b(boolean z) {
        return new s0(this, d(z), e(z));
    }

    private static List<String> b(String str, List<String> list) {
        String[] c = i0.c(str);
        if (c == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(c.length);
        for (String str2 : c) {
            if (!arrayList.contains(str2)) {
                if (n.containsKey(str2)) {
                    arrayList.add(str2);
                } else {
                    j.warning("'" + str + "' contains unsupported protocol: " + str2);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        j.severe("'" + str + "' contained no supported protocols (ignoring)");
        return list;
    }

    sdk.pendo.io.y4.v0[] a(s0 s0Var) {
        String[] l2 = s0Var.l();
        sdk.pendo.io.s4.a c = s0Var.c();
        TreeSet treeSet = new TreeSet(new a());
        for (String str : l2) {
            sdk.pendo.io.y4.v0 v0Var = this.d.get(str);
            if (v0Var != null && c.permits(k, str, null)) {
                treeSet.add(v0Var);
            }
        }
        if (treeSet.isEmpty()) {
            throw new IllegalStateException("No usable protocols enabled");
        }
        return (sdk.pendo.io.y4.v0[]) treeSet.toArray(new sdk.pendo.io.y4.v0[treeSet.size()]);
    }

    private static String[] a(Collection<String> collection) {
        return (String[]) collection.toArray(new String[collection.size()]);
    }

    static sdk.pendo.io.y4.v0 b(String str) {
        return n.get(str);
    }

    static d a(String str) {
        return l.get(str);
    }

    boolean b(String[] strArr) {
        if (strArr == null) {
            return false;
        }
        for (String str : strArr) {
            if (str == null || !this.d.containsKey(str)) {
                return false;
            }
        }
        return true;
    }

    static String a(int i) {
        if (i == 0) {
            return "SSL_NULL_WITH_NULL_NULL";
        }
        if (!l3.o(i)) {
            return null;
        }
        for (d dVar : l.values()) {
            if (dVar.a() == i) {
                return dVar.d();
            }
        }
        return null;
    }

    String[] a(boolean z) {
        return (String[]) d(z).clone();
    }

    private static String[] a(Map<String, d> map, List<String> list, boolean z, String str) {
        List<String> a2 = a(str, list);
        String[] strArr = new String[a2.size()];
        int i = 0;
        for (String str2 : a2) {
            d dVar = map.get(str2);
            if (dVar != null && (!z || a2 != list || !sdk.pendo.io.y4.z1.c(dVar.a()))) {
                if (k0.h.permits(k, str2, null)) {
                    strArr[i] = str2;
                    i++;
                }
            }
        }
        return a0.b(strArr, i);
    }

    private static String[] a(Map<String, d> map, List<String> list) {
        return a(map, list, i0.b("external.sdk.pendo.io.org.bouncycastle.jsse.client.dh.disableDefaultSuites", false), "jdk.tls.client.cipherSuites");
    }

    private static String[] a(Map<String, sdk.pendo.io.y4.v0> map, String str, List<String> list, List<String> list2) {
        if (list2 == null) {
            list2 = b(str, list);
        }
        String[] strArr = new String[list2.size()];
        int i = 0;
        for (String str2 : list2) {
            if (map.containsKey(str2) && k0.i.permits(k, str2, null)) {
                strArr[i] = str2;
                i++;
            }
        }
        return a0.b(strArr, i);
    }

    private static String[] a(Map<String, sdk.pendo.io.y4.v0> map, List<String> list, List<String> list2) {
        return a(map, "jdk.tls.client.protocols", list, list2);
    }

    private static List<String> a(String str, List<String> list) {
        String[] c = i0.c(str);
        if (c == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(c.length);
        for (String str2 : c) {
            if (!arrayList.contains(str2)) {
                if (l.containsKey(str2)) {
                    arrayList.add(str2);
                } else {
                    j.warning("'" + str + "' contains unsupported cipher suite: " + str2);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        j.severe("'" + str + "' contained no supported cipher suites (ignoring)");
        return list;
    }

    static String a(sdk.pendo.io.y4.v0 v0Var) {
        if (v0Var == null) {
            return "NONE";
        }
        for (Map.Entry<String, sdk.pendo.io.y4.v0> entry : n.entrySet()) {
            if (entry.getValue().b(v0Var)) {
                return entry.getKey();
            }
        }
        return "NONE";
    }

    String[] a(String[] strArr) {
        if (strArr == null) {
            throw new NullPointerException("'cipherSuites' cannot be null");
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (l3.b(str)) {
                throw new IllegalArgumentException("'cipherSuites' cannot contain null or empty string elements");
            }
            if (this.c.containsKey(str)) {
                arrayList.add(str);
            }
        }
        return a((Collection<String>) arrayList);
    }

    protected sdk.pendo.io.r4.j a(sdk.pendo.io.p4.b bVar, KeyManager[] keyManagerArr) {
        if (keyManagerArr != null) {
            for (KeyManager keyManager : keyManagerArr) {
                if (keyManager instanceof X509KeyManager) {
                    return y1.a(bVar, (X509KeyManager) keyManager);
                }
            }
        }
        return h.f1583a;
    }

    protected sdk.pendo.io.r4.k a(sdk.pendo.io.p4.b bVar, TrustManager[] trustManagerArr) {
        if (trustManagerArr == null) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                trustManagerArr = trustManagerFactory.getTrustManagers();
            } catch (Exception e) {
                j.log(Level.WARNING, "Failed to load default trust managers", (Throwable) e);
            }
        }
        if (trustManagerArr != null) {
            for (TrustManager trustManager : trustManagerArr) {
                if (trustManager instanceof X509TrustManager) {
                    return z1.a(this.f1599a, bVar, (X509TrustManager) trustManager);
                }
            }
        }
        return i.f1585a;
    }

    void a(s0 s0Var, boolean z) {
        boolean z2 = !z;
        if (s0Var.f() == d(z2)) {
            s0Var.c(d(z));
        }
        if (s0Var.l() == e(z2)) {
            s0Var.e(e(z));
        }
    }

    String a(s0 s0Var, int i) {
        String a2 = a(i);
        if (a2 != null && a0.a(s0Var.f(), a2) && s0Var.c().permits(k, a2, null) && this.c.containsKey(a2) && (!this.f1599a || o.a(a2))) {
            return a2;
        }
        throw new IllegalStateException("SSL connection negotiated unsupported ciphersuite: " + i);
    }

    String a(s0 s0Var, sdk.pendo.io.y4.v0 v0Var) {
        String a2 = a(v0Var);
        if (a2 != null && a0.a(s0Var.l(), a2) && s0Var.c().permits(k, a2, null) && this.d.containsKey(a2) && (!this.f1599a || o.b(a2))) {
            return a2;
        }
        throw new IllegalStateException("SSL connection negotiated unsupported protocol: " + v0Var);
    }
}
