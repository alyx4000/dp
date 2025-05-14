package sdk.pendo.io.t4;

import androidx.core.view.InputDeviceCompat;
import java.security.AlgorithmParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import java.util.logging.Logger;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import sdk.pendo.io.t4.f0;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
class w1 {
    private static final Logger f = Logger.getLogger(w1.class.getName());
    private static final int[] g = a();

    /* renamed from: a, reason: collision with root package name */
    private final a f1621a;
    private final AlgorithmParameters b;
    private final f0 c;
    private final boolean d;
    private final boolean e;

    private enum a {
        ed25519(2055, EdDSAParameterSpec.Ed25519, EdDSAParameterSpec.Ed25519),
        ed448(2056, EdDSAParameterSpec.Ed448, EdDSAParameterSpec.Ed448),
        ecdsa_secp256r1_sha256(1027, "SHA256withECDSA", "EC"),
        ecdsa_secp384r1_sha384(1283, "SHA384withECDSA", "EC"),
        ecdsa_secp521r1_sha512(1539, "SHA512withECDSA", "EC"),
        ecdsa_brainpoolP256r1tls13_sha256(2074, "SHA256withECDSA", "EC"),
        ecdsa_brainpoolP384r1tls13_sha384(2075, "SHA384withECDSA", "EC"),
        ecdsa_brainpoolP512r1tls13_sha512(2076, "SHA512withECDSA", "EC"),
        rsa_pss_pss_sha256(2057, "SHA256withRSAandMGF1", "RSASSA-PSS"),
        rsa_pss_pss_sha384(2058, "SHA384withRSAandMGF1", "RSASSA-PSS"),
        rsa_pss_pss_sha512(2059, "SHA512withRSAandMGF1", "RSASSA-PSS"),
        rsa_pss_rsae_sha256(2052, "SHA256withRSAandMGF1", "RSA"),
        rsa_pss_rsae_sha384(2053, "SHA384withRSAandMGF1", "RSA"),
        rsa_pss_rsae_sha512(2054, "SHA512withRSAandMGF1", "RSA"),
        rsa_pkcs1_sha256(InputDeviceCompat.SOURCE_GAMEPAD, "SHA256withRSA", "RSA", true),
        rsa_pkcs1_sha384(1281, "SHA384withRSA", "RSA", true),
        rsa_pkcs1_sha512(1537, "SHA512withRSA", "RSA", true),
        sm2sig_sm3(1800, "SM3withSM2", "EC"),
        dsa_sha256(1026, "dsa_sha256", "SHA256withDSA", "DSA"),
        ecdsa_sha224(771, "ecdsa_sha224", "SHA224withECDSA", "EC"),
        rsa_sha224(769, "rsa_sha224", "SHA224withRSA", "RSA"),
        dsa_sha224(770, "dsa_sha224", "SHA224withDSA", "DSA"),
        ecdsa_sha1(515, "SHA1withECDSA", "EC", true),
        rsa_pkcs1_sha1(InputDeviceCompat.SOURCE_DPAD, "SHA1withRSA", "RSA", true),
        dsa_sha1(514, "dsa_sha1", "SHA1withDSA", "DSA"),
        rsa_md5(InputDeviceCompat.SOURCE_KEYBOARD, "rsa_md5", "MD5withRSA", "RSA");

        private final String jcaSignatureAlgorithm;
        private final String jcaSignatureAlgorithmBC;
        private final String keyAlgorithm;
        private final String keyType13;
        private final String name;
        private final int namedGroup13;
        private final int signatureScheme;
        private final boolean supportedCerts13;
        private final boolean supportedPost13;
        private final boolean supportedPre13;
        private final String text;

        a(int i, String str, String str2) {
            this(i, str, str2, true, true, sdk.pendo.io.y4.j1.d(i));
        }

        a(int i, String str, String str2, String str3) {
            this(i, str, str2, str3, false, false, -1);
        }

        a(int i, String str, String str2, String str3, boolean z, boolean z2, int i2) {
            String a2 = a0.a(str3, i2);
            String a3 = a0.a(str2, str3);
            this.signatureScheme = i;
            this.name = str;
            this.text = str + "(0x" + Integer.toHexString(i) + ")";
            this.jcaSignatureAlgorithm = str2;
            this.jcaSignatureAlgorithmBC = a3;
            this.keyAlgorithm = str3;
            this.keyType13 = a2;
            this.supportedPost13 = z;
            this.supportedPre13 = i2 < 0 || sdk.pendo.io.y4.p0.a(i2, sdk.pendo.io.y4.v0.f);
            this.supportedCerts13 = z2;
            this.namedGroup13 = i2;
        }

        a(int i, String str, String str2, boolean z) {
            this(i, str, str2, false, z, -1);
        }

        a(int i, String str, String str2, boolean z, boolean z2, int i2) {
            this(i, sdk.pendo.io.y4.j1.c(i), str, str2, z, z2, i2);
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Map<Integer, w1> f1622a;
        private final int[] b;
        private final int[] c;

        b(Map<Integer, w1> map, int[] iArr, int[] iArr2) {
            this.f1622a = map;
            this.b = iArr;
            this.c = iArr2;
        }
    }

    w1(a aVar, AlgorithmParameters algorithmParameters, f0 f0Var, boolean z, boolean z2) {
        this.f1621a = aVar;
        this.b = algorithmParameters;
        this.c = f0Var;
        this.d = z;
        this.e = z2;
    }

    private static void a(boolean z, sdk.pendo.io.b5.h hVar, f0.c cVar, Map<Integer, w1> map, a aVar) {
        boolean z2;
        f0 f0Var;
        boolean z3;
        int i = aVar.signatureScheme;
        if (!z || o.b(i)) {
            int i2 = aVar.namedGroup13;
            AlgorithmParameters algorithmParameters = null;
            if (i2 >= 0) {
                f0 a2 = f0.a(cVar, i2);
                if (a2 != null && a2.f() && a2.g()) {
                    f0Var = a2;
                    z2 = false;
                } else {
                    f0Var = a2;
                    z2 = true;
                }
            } else {
                z2 = false;
                f0Var = null;
            }
            boolean m = hVar.m(i);
            if (m) {
                try {
                    algorithmParameters = hVar.l(i);
                } catch (Exception unused) {
                    z3 = false;
                }
            }
            z3 = m;
            if (map.put(Integer.valueOf(i), new w1(aVar, algorithmParameters, f0Var, z3, z2)) != null) {
                throw new IllegalStateException("Duplicate entries for SignatureSchemeInfo");
            }
        }
    }

    static b b(boolean z, sdk.pendo.io.b5.h hVar, f0.c cVar) {
        Map<Integer, w1> a2 = a(z, hVar, cVar);
        return new b(a2, a(a2, "jdk.tls.client.SignatureSchemes"), a(a2, "jdk.tls.server.SignatureSchemes"));
    }

    private static boolean b(int i) {
        if (i == 515 || i == 771 || i == 1027 || i == 1283 || i == 1539) {
            return true;
        }
        switch (i) {
            case 2074:
            case 2075:
            case 2076:
                return true;
            default:
                return false;
        }
    }

    String c() {
        return this.f1621a.jcaSignatureAlgorithmBC;
    }

    String d() {
        return this.f1621a.keyAlgorithm;
    }

    String e() {
        return this.f1621a.keyType13;
    }

    short f() {
        return sdk.pendo.io.y4.j1.e(this.f1621a.signatureScheme);
    }

    sdk.pendo.io.y4.i1 g() {
        return a(this.f1621a.signatureScheme);
    }

    int h() {
        return this.f1621a.signatureScheme;
    }

    boolean i() {
        return this.d;
    }

    boolean j() {
        return !this.e && this.f1621a.supportedCerts13;
    }

    boolean k() {
        return !this.e && this.f1621a.supportedPost13;
    }

    boolean l() {
        return this.f1621a.supportedPre13;
    }

    public String toString() {
        return this.f1621a.text;
    }

    private static int[] a(Map<Integer, w1> map, String str) {
        Logger logger;
        StringBuilder append;
        String str2;
        String[] c = i0.c(str);
        if (c == null) {
            return g;
        }
        int length = c.length;
        int[] iArr = new int[length];
        int i = 0;
        for (String str3 : c) {
            int a2 = a(str3);
            if (a2 < 0) {
                logger = f;
                append = new StringBuilder("'").append(str);
                str2 = "' contains unrecognised SignatureScheme: ";
            } else {
                w1 w1Var = map.get(Integer.valueOf(a2));
                if (w1Var == null) {
                    logger = f;
                    append = new StringBuilder("'").append(str);
                    str2 = "' contains unsupported SignatureScheme: ";
                } else if (w1Var.i()) {
                    iArr[i] = a2;
                    i++;
                } else {
                    logger = f;
                    append = new StringBuilder("'").append(str);
                    str2 = "' contains disabled SignatureScheme: ";
                }
            }
            logger.warning(append.append(str2).append(str3).toString());
        }
        if (i < length) {
            iArr = sdk.pendo.io.d5.a.c(iArr, i);
        }
        if (iArr.length < 1) {
            f.severe("'" + str + "' contained no usable SignatureScheme values");
        }
        return iArr;
    }

    String b() {
        return this.f1621a.jcaSignatureAlgorithm;
    }

    private static int[] a() {
        a[] values = a.values();
        int[] iArr = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            iArr[i] = values[i].signatureScheme;
        }
        return iArr;
    }

    static String[] b(Collection<w1> collection) {
        if (collection == null) {
            return l3.i;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<w1> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().c());
        }
        return (String[]) arrayList.toArray(l3.i);
    }

    private static Map<Integer, w1> a(boolean z, sdk.pendo.io.b5.h hVar, f0.c cVar) {
        TreeMap treeMap = new TreeMap();
        for (a aVar : a.values()) {
            a(z, hVar, cVar, treeMap, aVar);
        }
        return treeMap;
    }

    boolean b(sdk.pendo.io.s4.a aVar, boolean z, boolean z2, f0.b bVar) {
        if (this.d) {
            return a(z && j(), z2 && l(), bVar) && a(aVar);
        }
        return false;
    }

    static List<w1> a(b bVar, boolean z, s0 s0Var, sdk.pendo.io.y4.v0[] v0VarArr, f0.b bVar2) {
        sdk.pendo.io.y4.v0 c = sdk.pendo.io.y4.v0.c(v0VarArr);
        if (!l3.b(c)) {
            return null;
        }
        int[] iArr = z ? bVar.c : bVar.b;
        sdk.pendo.io.y4.v0 a2 = sdk.pendo.io.y4.v0.a(v0VarArr);
        sdk.pendo.io.s4.a c2 = s0Var.c();
        boolean e = l3.e(c);
        boolean z2 = !l3.e(a2);
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            w1 w1Var = (w1) bVar.f1622a.get(sdk.pendo.io.d5.d.b(i));
            if (w1Var != null && w1Var.b(c2, e, z2, bVar2)) {
                arrayList.add(w1Var);
            }
        }
        if (arrayList.isEmpty()) {
            return Collections.emptyList();
        }
        arrayList.trimToSize();
        return Collections.unmodifiableList(arrayList);
    }

    static String[] a(Collection<w1> collection) {
        if (collection == null) {
            return l3.i;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<w1> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().b());
        }
        return (String[]) arrayList.toArray(l3.i);
    }

    static sdk.pendo.io.y4.i1 a(int i) {
        if (l3.o(i)) {
            return sdk.pendo.io.y4.j1.f(i);
        }
        throw new IllegalArgumentException();
    }

    static Vector<sdk.pendo.io.y4.i1> a(List<w1> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Vector<sdk.pendo.io.y4.i1> vector = new Vector<>(list.size());
        for (w1 w1Var : list) {
            if (w1Var != null) {
                vector.add(w1Var.g());
            }
        }
        if (vector.isEmpty()) {
            return null;
        }
        vector.trimToSize();
        return vector;
    }

    private static int a(String str) {
        for (a aVar : a.values()) {
            if (aVar.name.equalsIgnoreCase(str)) {
                return aVar.signatureScheme;
            }
        }
        return -1;
    }

    static List<w1> a(b bVar, Vector<sdk.pendo.io.y4.i1> vector) {
        if (vector == null || vector.isEmpty()) {
            return null;
        }
        int size = vector.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            sdk.pendo.io.y4.i1 elementAt = vector.elementAt(i);
            if (elementAt != null) {
                w1 w1Var = (w1) bVar.f1622a.get(Integer.valueOf(sdk.pendo.io.y4.j1.a(elementAt)));
                if (w1Var != null) {
                    arrayList.add(w1Var);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.trimToSize();
        return Collections.unmodifiableList(arrayList);
    }

    boolean a(sdk.pendo.io.s4.a aVar, boolean z, boolean z2, f0.b bVar) {
        if (this.d) {
            return a(z && k(), z2 && l(), bVar) && a(aVar);
        }
        return false;
    }

    private boolean a(boolean z, boolean z2, f0.b bVar) {
        f0 f0Var = this.c;
        if (f0Var != null) {
            return (z && f0.a(bVar, f0Var.e())) || (z2 && f0.f(bVar));
        }
        if (z || z2) {
            return !b(this.f1621a.signatureScheme) || f0.f(bVar);
        }
        return false;
    }

    private boolean a(sdk.pendo.io.s4.a aVar) {
        Set<sdk.pendo.io.s4.b> set = a0.i;
        return aVar.permits(set, this.f1621a.name, null) && aVar.permits(set, this.f1621a.keyAlgorithm, null) && aVar.permits(set, this.f1621a.jcaSignatureAlgorithm, this.b);
    }
}
