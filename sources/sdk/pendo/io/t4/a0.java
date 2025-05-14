package sdk.pendo.io.t4;

import java.io.IOException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import kotlin.text.Typography;
import org.bouncycastle.asn1.ASN1Encoding;
import sdk.pendo.io.y4.l3;
import sdk.pendo.io.y4.m3;

/* loaded from: classes6.dex */
abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f1551a = i0.b("jdk.tls.allowLegacyMasterSecret", true);
    private static final boolean b = i0.b("jdk.tls.allowLegacyResumption", false);
    private static final int c = i0.a("jdk.tls.maxCertificateChainLength", 10, 1, Integer.MAX_VALUE);
    private static final int d = i0.a("jdk.tls.maxHandshakeMessageSize", 32768, 1024, Integer.MAX_VALUE);
    private static final boolean e = i0.b("com.sun.net.ssl.requireCloseNotify", true);
    private static final boolean f = i0.b("jdk.tls.useExtendedMasterSecret", true);
    static final Set<sdk.pendo.io.s4.b> g = Collections.unmodifiableSet(EnumSet.of(sdk.pendo.io.s4.b.KEY_AGREEMENT));
    static final Set<sdk.pendo.io.s4.b> h = Collections.unmodifiableSet(EnumSet.of(sdk.pendo.io.s4.b.KEY_ENCAPSULATION));
    static final Set<sdk.pendo.io.s4.b> i = Collections.unmodifiableSet(EnumSet.of(sdk.pendo.io.s4.b.SIGNATURE));
    static String j = "";
    static X509Certificate[] k = new X509Certificate[0];

    static class a extends sdk.pendo.io.r4.e {
        a(int i, byte[] bArr) {
            super(i, bArr);
        }
    }

    static boolean a() {
        return f1551a;
    }

    static boolean b() {
        return b;
    }

    static int c() {
        return c;
    }

    static int d() {
        return d;
    }

    static boolean e() {
        return e;
    }

    static String f(String str) {
        return a(str, '[', ']');
    }

    static void a(i1 i1Var) {
        if (!i1Var.getEnableSessionCreation()) {
            throw new IllegalStateException("Cannot resume session and session creation is disabled");
        }
    }

    static <T> boolean b(T[] tArr) {
        for (T t : tArr) {
            if (t == null) {
                return true;
            }
        }
        return false;
    }

    static X500Principal[] c(Vector<m3> vector) {
        if (vector == null || vector.isEmpty()) {
            return null;
        }
        int size = vector.size();
        X500Principal[] x500PrincipalArr = new X500Principal[size];
        for (int i2 = 0; i2 < size; i2++) {
            m3 m3Var = vector.get(i2);
            if (2 != m3Var.a()) {
                return null;
            }
            x500PrincipalArr[i2] = a(m3Var.b());
        }
        return x500PrincipalArr;
    }

    static String d(String str) {
        if (b(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (!Character.isWhitespace(charAt)) {
                cArr[i2] = charAt;
                i2++;
            }
        }
        return i2 == 0 ? j : i2 == length ? str : new String(cArr, 0, i2);
    }

    static String e(String str) {
        return a(str, Typography.quote, Typography.quote);
    }

    static boolean f() {
        return f;
    }

    static <T> T[] a(T[] tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) ((Object[]) tArr.clone());
    }

    static String b(int i2) {
        return a(i2);
    }

    static boolean c(String str) {
        sdk.pendo.io.y4.v0 b2 = p0.b(str);
        return b2 != null && l3.d(b2);
    }

    static X500Principal[] d(Vector<sdk.pendo.io.c4.c> vector) {
        if (vector == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = vector.size();
        for (int i2 = 0; i2 < size; i2++) {
            X500Principal a2 = a(vector.get(i2));
            if (a2 != null) {
                linkedHashSet.add(a2);
            }
        }
        return (X500Principal[]) linkedHashSet.toArray(new X500Principal[0]);
    }

    static boolean a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    static List<String> b(Vector<sdk.pendo.io.y4.u0> vector) {
        if (vector == null || vector.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(vector.size());
        Iterator<sdk.pendo.io.y4.u0> it = vector.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        return arrayList;
    }

    static sdk.pendo.io.r4.e a(sdk.pendo.io.y4.c1 c1Var) {
        short b2 = c1Var.b();
        byte[] a2 = c1Var.a();
        return b2 != 0 ? new a(b2, a2) : new sdk.pendo.io.r4.c(a2);
    }

    static String b(PublicKey publicKey) {
        String algorithm = publicKey.getAlgorithm();
        if ("RSA".equalsIgnoreCase(algorithm)) {
            if (sdk.pendo.io.y3.a.k.b(sdk.pendo.io.e4.g.a(publicKey.getEncoded()).h().h())) {
                return "RSASSA-PSS";
            }
        }
        return algorithm;
    }

    static List<sdk.pendo.io.r4.e> a(Vector<sdk.pendo.io.y4.c1> vector) {
        if (vector == null || vector.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(vector.size());
        Enumeration<sdk.pendo.io.y4.c1> elements = vector.elements();
        while (elements.hasMoreElements()) {
            arrayList.add(a(elements.nextElement()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    static X509Certificate[] b(sdk.pendo.io.b5.h hVar, sdk.pendo.io.y4.l lVar) {
        if (lVar == null || lVar.d()) {
            return k;
        }
        try {
            int c2 = lVar.c();
            X509Certificate[] x509CertificateArr = new X509Certificate[c2];
            for (int i2 = 0; i2 < c2; i2++) {
                x509CertificateArr[i2] = sdk.pendo.io.b5.g.a(hVar, lVar.a(i2)).l();
            }
            return x509CertificateArr;
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    static String[] a(String[] strArr, int i2) {
        String[] strArr2 = new String[i2];
        System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i2));
        return strArr2;
    }

    static boolean b(String str) {
        return str == null || str.length() < 1;
    }

    static sdk.pendo.io.y4.t1 a(sdk.pendo.io.b5.h hVar, sdk.pendo.io.r4.l lVar) {
        return new sdk.pendo.io.b5.l0(hVar, a(hVar, lVar.b()), lVar.c());
    }

    static String[] b(String[] strArr, int i2) {
        return i2 < strArr.length ? a(strArr, i2) : strArr;
    }

    static sdk.pendo.io.y4.u1 a(sdk.pendo.io.y4.r1 r1Var, sdk.pendo.io.b5.h hVar, sdk.pendo.io.r4.l lVar, sdk.pendo.io.y4.i1 i1Var) {
        return new sdk.pendo.io.b5.d(new sdk.pendo.io.z4.j(r1Var), hVar, lVar.c(), a(hVar, lVar.b()), i1Var);
    }

    static sdk.pendo.io.y4.u1 a(sdk.pendo.io.y4.r1 r1Var, sdk.pendo.io.b5.h hVar, sdk.pendo.io.r4.l lVar, sdk.pendo.io.y4.i1 i1Var, byte[] bArr) {
        return new sdk.pendo.io.b5.d(new sdk.pendo.io.z4.j(r1Var), hVar, lVar.c(), a(hVar, lVar.b(), bArr), i1Var);
    }

    static boolean a(Object obj, Object obj2) {
        return obj == obj2 || !(obj == null || obj2 == null || !obj.equals(obj2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x000e, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static sdk.pendo.io.r4.e a(java.util.Vector<sdk.pendo.io.y4.c1> r5, java.util.Collection<sdk.pendo.io.r4.d> r6) {
        /*
            boolean r0 = r5.isEmpty()
            if (r0 != 0) goto L40
            java.util.List r5 = a(r5)
            java.util.Iterator r6 = r6.iterator()
        Le:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L40
            java.lang.Object r0 = r6.next()
            sdk.pendo.io.r4.d r0 = (sdk.pendo.io.r4.d) r0
            if (r0 == 0) goto Le
            int r1 = r0.a()
            java.util.Iterator r2 = r5.iterator()
        L24:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto Le
            java.lang.Object r3 = r2.next()
            sdk.pendo.io.r4.e r3 = (sdk.pendo.io.r4.e) r3
            if (r3 == 0) goto L24
            int r4 = r3.b()
            if (r4 == r1) goto L39
            goto L24
        L39:
            boolean r0 = r0.a(r3)
            if (r0 == 0) goto Le
            return r3
        L40:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.t4.a0.a(java.util.Vector, java.util.Collection):sdk.pendo.io.r4.e");
    }

    static String a(String str, short s, short s2) {
        return str + " " + sdk.pendo.io.y4.h.b(s) + " " + sdk.pendo.io.y4.g.b(s2) + " alert";
    }

    static String a(sdk.pendo.io.y4.a1 a1Var) {
        if (a1Var == null || !a1Var.K()) {
            return null;
        }
        sdk.pendo.io.y4.u0 b2 = a1Var.b();
        return b2 == null ? "" : b2.a();
    }

    static String a(int i2) {
        if (i2 == 0) {
            return "UNKNOWN";
        }
        if (i2 == 1) {
            return "KE:RSA";
        }
        if (i2 == 3) {
            return "DHE_DSS";
        }
        if (i2 == 5) {
            return "DHE_RSA";
        }
        if (i2 == 7) {
            return "DH_DSS";
        }
        if (i2 == 9) {
            return "DH_RSA";
        }
        if (i2 == 22) {
            return "SRP_DSS";
        }
        if (i2 == 23) {
            return "SRP_RSA";
        }
        switch (i2) {
            case 16:
                return "ECDH_ECDSA";
            case 17:
                return "ECDHE_ECDSA";
            case 18:
                return "ECDH_RSA";
            case 19:
                return "ECDHE_RSA";
            default:
                throw new IllegalArgumentException();
        }
    }

    static Vector<sdk.pendo.io.c4.c> a(sdk.pendo.io.r4.k kVar) {
        HashSet hashSet = new HashSet();
        for (X509Certificate x509Certificate : kVar.getAcceptedIssuers()) {
            hashSet.add(x509Certificate.getBasicConstraints() >= 0 ? x509Certificate.getSubjectX500Principal() : x509Certificate.getIssuerX500Principal());
        }
        if (hashSet.isEmpty()) {
            return null;
        }
        Vector<sdk.pendo.io.c4.c> vector = new Vector<>(hashSet.size());
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            vector.add(sdk.pendo.io.c4.c.a(((X500Principal) it.next()).getEncoded()));
        }
        return vector;
    }

    static sdk.pendo.io.y4.l a(sdk.pendo.io.b5.h hVar, X509Certificate[] x509CertificateArr) {
        if (l3.b(x509CertificateArr)) {
            throw new IllegalArgumentException();
        }
        sdk.pendo.io.z4.f[] fVarArr = new sdk.pendo.io.z4.f[x509CertificateArr.length];
        for (int i2 = 0; i2 < x509CertificateArr.length; i2++) {
            fVarArr[i2] = new sdk.pendo.io.b5.g(hVar, x509CertificateArr[i2]);
        }
        return new sdk.pendo.io.y4.l(fVarArr);
    }

    static sdk.pendo.io.y4.l a(sdk.pendo.io.b5.h hVar, X509Certificate[] x509CertificateArr, byte[] bArr) {
        if (l3.b(x509CertificateArr)) {
            throw new IllegalArgumentException();
        }
        sdk.pendo.io.y4.m[] mVarArr = new sdk.pendo.io.y4.m[x509CertificateArr.length];
        for (int i2 = 0; i2 < x509CertificateArr.length; i2++) {
            mVarArr[i2] = new sdk.pendo.io.y4.m(new sdk.pendo.io.b5.g(hVar, x509CertificateArr[i2]), null);
        }
        return new sdk.pendo.io.y4.l(bArr, mVarArr);
    }

    static String a(String str, String str2) {
        return !str.endsWith("withRSAandMGF1") ? str : str + ":" + str2;
    }

    static String a(Key key) {
        return key instanceof PrivateKey ? a((PrivateKey) key) : key instanceof PublicKey ? b((PublicKey) key) : key.getAlgorithm();
    }

    static String a(String str, int i2) {
        return i2 < 0 ? str : str + "/" + sdk.pendo.io.y4.p0.f(i2);
    }

    static String a(short s) {
        if (s == 1) {
            return "RSA";
        }
        if (s == 2) {
            return "DSA";
        }
        if (s == 64) {
            return "EC";
        }
        throw new IllegalArgumentException();
    }

    static sdk.pendo.io.m3.v a(PublicKey publicKey) {
        sdk.pendo.io.m3.g i2;
        try {
            sdk.pendo.io.e4.a h2 = sdk.pendo.io.e4.g.a(publicKey.getEncoded()).h();
            if (!sdk.pendo.io.f4.h.l.b(h2.h()) || (i2 = h2.i()) == null) {
                return null;
            }
            sdk.pendo.io.m3.a0 b2 = i2.b();
            if (b2 instanceof sdk.pendo.io.m3.v) {
                return (sdk.pendo.io.m3.v) b2;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    static String a(PrivateKey privateKey) {
        String algorithm = privateKey.getAlgorithm();
        if ("RSA".equalsIgnoreCase(algorithm)) {
            if (sdk.pendo.io.y3.a.k.b(sdk.pendo.io.y3.b.a(privateKey.getEncoded()).h().h())) {
                return "RSASSA-PSS";
            }
        }
        return algorithm;
    }

    static Vector<sdk.pendo.io.y4.u0> a(String[] strArr) {
        if (l3.b(strArr)) {
            return null;
        }
        Vector<sdk.pendo.io.y4.u0> vector = new Vector<>(strArr.length);
        for (String str : strArr) {
            vector.add(sdk.pendo.io.y4.u0.a(str));
        }
        return vector;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        if ((r1 instanceof sdk.pendo.io.r4.c) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:
    
        return (sdk.pendo.io.r4.c) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002b, code lost:
    
        return new sdk.pendo.io.r4.c(r1.a());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static sdk.pendo.io.r4.c a(java.util.List<sdk.pendo.io.r4.e> r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L2c
            java.util.Iterator r3 = r3.iterator()
        L7:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L2c
            java.lang.Object r1 = r3.next()
            sdk.pendo.io.r4.e r1 = (sdk.pendo.io.r4.e) r1
            if (r1 == 0) goto L7
            int r2 = r1.b()
            if (r2 != 0) goto L7
            boolean r3 = r1 instanceof sdk.pendo.io.r4.c
            if (r3 == 0) goto L22
            sdk.pendo.io.r4.c r1 = (sdk.pendo.io.r4.c) r1
            return r1
        L22:
            sdk.pendo.io.r4.c r3 = new sdk.pendo.io.r4.c     // Catch: java.lang.RuntimeException -> L2c
            byte[] r1 = r1.a()     // Catch: java.lang.RuntimeException -> L2c
            r3.<init>(r1)     // Catch: java.lang.RuntimeException -> L2c
            return r3
        L2c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.t4.a0.a(java.util.List):sdk.pendo.io.r4.c");
    }

    static String a(String str, List<w1> list) {
        String[] b2 = w1.b(list);
        StringBuilder sb = new StringBuilder(str);
        sb.append(':');
        for (String str2 : b2) {
            sb.append(' ');
            sb.append(str2);
        }
        return sb.toString();
    }

    static byte[] a(sdk.pendo.io.w3.a aVar) {
        return aVar == null ? l3.e : aVar.a(ASN1Encoding.DER);
    }

    static List<byte[]> a(sdk.pendo.io.y4.o oVar) {
        if (oVar == null) {
            return null;
        }
        short c2 = oVar.c();
        if (c2 == 1) {
            return Collections.singletonList(a(oVar.a()));
        }
        if (c2 != 2) {
            return null;
        }
        Vector b2 = oVar.b();
        int size = b2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(a((sdk.pendo.io.w3.a) b2.elementAt(i2)));
        }
        return Collections.unmodifiableList(arrayList);
    }

    static X500Principal a(sdk.pendo.io.b5.h hVar, sdk.pendo.io.y4.l lVar) {
        if (lVar == null || lVar.d()) {
            return null;
        }
        try {
            return a(hVar, lVar.a(0)).getSubjectX500Principal();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    static X509Certificate a(sdk.pendo.io.b5.h hVar, sdk.pendo.io.z4.f fVar) {
        return sdk.pendo.io.b5.g.a(hVar, fVar).l();
    }

    static X509Certificate[] a(Certificate[] certificateArr) {
        if (certificateArr == null) {
            return null;
        }
        if (certificateArr instanceof X509Certificate[]) {
            if (b(certificateArr)) {
                return null;
            }
            return (X509Certificate[]) certificateArr;
        }
        X509Certificate[] x509CertificateArr = new X509Certificate[certificateArr.length];
        for (int i2 = 0; i2 < certificateArr.length; i2++) {
            Certificate certificate = certificateArr[i2];
            if (!(certificate instanceof X509Certificate)) {
                return null;
            }
            x509CertificateArr[i2] = (X509Certificate) certificate;
        }
        return x509CertificateArr;
    }

    static boolean a(String str) {
        return !b(str);
    }

    private static String a(String str, char c2, char c3) {
        int length;
        return (str == null || (length = str.length() - 1) <= 0 || str.charAt(0) != c2 || str.charAt(length) != c3) ? str : str.substring(1, length);
    }

    static X500Principal a(sdk.pendo.io.c4.c cVar) {
        if (cVar == null) {
            return null;
        }
        return new X500Principal(cVar.a(ASN1Encoding.DER));
    }
}
