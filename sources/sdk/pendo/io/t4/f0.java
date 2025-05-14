package sdk.pendo.io.t4;

import androidx.core.view.InputDeviceCompat;
import java.security.AlgorithmParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import java.util.logging.Logger;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
class f0 {
    private static final Logger d = Logger.getLogger(f0.class.getName());
    private static final int[] e = {29, 30, 23, 24, 25, 31, 32, 33, 256, InputDeviceCompat.SOURCE_KEYBOARD, 258};

    /* renamed from: a, reason: collision with root package name */
    private final a f1575a;
    private final AlgorithmParameters b;
    private final boolean c;

    private enum a {
        sect163k1(1, "EC"),
        sect163r1(2, "EC"),
        sect163r2(3, "EC"),
        sect193r1(4, "EC"),
        sect193r2(5, "EC"),
        sect233k1(6, "EC"),
        sect233r1(7, "EC"),
        sect239k1(8, "EC"),
        sect283k1(9, "EC"),
        sect283r1(10, "EC"),
        sect409k1(11, "EC"),
        sect409r1(12, "EC"),
        sect571k1(13, "EC"),
        sect571r1(14, "EC"),
        secp160k1(15, "EC"),
        secp160r1(16, "EC"),
        secp160r2(17, "EC"),
        secp192k1(18, "EC"),
        secp192r1(19, "EC"),
        secp224k1(20, "EC"),
        secp224r1(21, "EC"),
        secp256k1(22, "EC"),
        secp256r1(23, "EC"),
        secp384r1(24, "EC"),
        secp521r1(25, "EC"),
        brainpoolP256r1(26, "EC"),
        brainpoolP384r1(27, "EC"),
        brainpoolP512r1(28, "EC"),
        x25519(29, "XDH"),
        x448(30, "XDH"),
        brainpoolP256r1tls13(31, "EC"),
        brainpoolP384r1tls13(32, "EC"),
        brainpoolP512r1tls13(33, "EC"),
        curveSM2(41, "EC"),
        ffdhe2048(256, "DiffieHellman"),
        ffdhe3072(InputDeviceCompat.SOURCE_KEYBOARD, "DiffieHellman"),
        ffdhe4096(258, "DiffieHellman"),
        ffdhe6144(259, "DiffieHellman"),
        ffdhe8192(260, "DiffieHellman");

        private final int bitsECDH;
        private final int bitsFFDHE;
        private final boolean char2;
        private final String jcaAlgorithm;
        private final String jcaGroup;
        private final String name;
        private final int namedGroup;
        private final boolean supportedPost13;
        private final boolean supportedPre13;
        private final String text;

        a(int i, String str) {
            this.namedGroup = i;
            this.name = sdk.pendo.io.y4.p0.e(i);
            this.text = sdk.pendo.io.y4.p0.g(i);
            this.jcaAlgorithm = str;
            this.jcaGroup = sdk.pendo.io.y4.p0.f(i);
            this.supportedPost13 = sdk.pendo.io.y4.p0.a(i, sdk.pendo.io.y4.v0.g);
            this.supportedPre13 = sdk.pendo.io.y4.p0.a(i, sdk.pendo.io.y4.v0.f);
            this.char2 = sdk.pendo.io.y4.p0.h(i);
            this.bitsECDH = sdk.pendo.io.y4.p0.a(i);
            this.bitsFFDHE = sdk.pendo.io.y4.p0.c(i);
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Map<Integer, f0> f1576a;
        private final boolean b;
        private List<f0> c = null;

        b(Map<Integer, f0> map, boolean z) {
            this.f1576a = map;
            this.b = z;
        }

        public synchronized List<f0> a() {
            return this.c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void a(List<f0> list) {
            this.c = list;
        }
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        private final Map<Integer, f0> f1577a;
        private final int[] b;

        c(Map<Integer, f0> map, int[] iArr) {
            this.f1577a = map;
            this.b = iArr;
        }
    }

    f0(a aVar, AlgorithmParameters algorithmParameters, boolean z) {
        this.f1575a = aVar;
        this.b = algorithmParameters;
        this.c = z;
    }

    private static void a(boolean z, sdk.pendo.io.b5.h hVar, boolean z2, boolean z3, Map<Integer, f0> map, a aVar) {
        int i = aVar.namedGroup;
        if (!z || o.a(i)) {
            boolean z4 = false;
            boolean z5 = (((z2 && aVar.char2) || (z3 && aVar.bitsFFDHE > 0)) || aVar.jcaGroup == null || !hVar.f(i)) ? false : true;
            AlgorithmParameters algorithmParameters = null;
            if (z5) {
                try {
                    algorithmParameters = hVar.k(i);
                } catch (Exception unused) {
                }
            }
            z4 = z5;
            if (map.put(Integer.valueOf(i), new f0(aVar, algorithmParameters, z4)) != null) {
                throw new IllegalStateException("Duplicate entries for NamedGroupInfo");
            }
        }
    }

    private static boolean b(Map<Integer, f0> map) {
        Iterator<f0> it = map.values().iterator();
        while (it.hasNext()) {
            if (sdk.pendo.io.y4.p0.o(it.next().e())) {
                return true;
            }
        }
        return false;
    }

    static boolean f(b bVar) {
        return bVar.b;
    }

    String c() {
        return this.f1575a.jcaAlgorithm;
    }

    String d() {
        return this.f1575a.jcaGroup;
    }

    int e() {
        return this.f1575a.namedGroup;
    }

    boolean g() {
        return this.f1575a.supportedPost13;
    }

    boolean h() {
        return this.f1575a.supportedPre13;
    }

    public String toString() {
        return this.f1575a.text;
    }

    private static int[] a(Map<Integer, f0> map) {
        Logger logger;
        StringBuilder sb;
        String[] c2 = i0.c("jdk.tls.namedGroups");
        if (c2 == null) {
            return e;
        }
        int length = c2.length;
        int[] iArr = new int[length];
        int i = 0;
        for (String str : c2) {
            int a2 = a(str);
            if (a2 < 0) {
                logger = d;
                sb = new StringBuilder("'jdk.tls.namedGroups' contains unrecognised NamedGroup: ");
            } else {
                f0 f0Var = map.get(Integer.valueOf(a2));
                if (f0Var == null) {
                    logger = d;
                    sb = new StringBuilder("'jdk.tls.namedGroups' contains unsupported NamedGroup: ");
                } else if (f0Var.f()) {
                    iArr[i] = a2;
                    i++;
                } else {
                    logger = d;
                    sb = new StringBuilder("'jdk.tls.namedGroups' contains disabled NamedGroup: ");
                }
            }
            logger.warning(sb.append(str).toString());
        }
        if (i < length) {
            iArr = sdk.pendo.io.d5.a.c(iArr, i);
        }
        if (iArr.length < 1) {
            d.severe("'jdk.tls.namedGroups' contained no usable NamedGroup values");
        }
        return iArr;
    }

    static b b(c cVar, s0 s0Var, sdk.pendo.io.y4.v0[] v0VarArr) {
        Map<Integer, f0> a2 = a(cVar, s0Var, v0VarArr);
        return new b(a2, b(a2));
    }

    static int c(b bVar) {
        Iterator<f0> it = a(bVar).iterator();
        int i = 0;
        while (it.hasNext()) {
            i = Math.max(i, it.next().b());
        }
        return i;
    }

    static Vector<Integer> d(b bVar) {
        return new Vector<>(bVar.f1576a.keySet());
    }

    static int[] e(b bVar) {
        Set keySet = bVar.f1576a.keySet();
        int[] iArr = new int[keySet.size()];
        Iterator it = keySet.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Integer) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    boolean f() {
        return this.c;
    }

    private static Map<Integer, f0> a(boolean z, sdk.pendo.io.b5.h hVar) {
        TreeMap treeMap = new TreeMap();
        boolean z2 = i0.b("external.sdk.pendo.io.org.bouncycastle.jsse.ec.disableChar2", false) || i0.b("external.sdk.pendo.io.org.bouncycastle.ec.disable_f2m", false);
        boolean z3 = !i0.b("jsse.enableFFDHE", true);
        for (a aVar : a.values()) {
            a(z, hVar, z2, z3, treeMap, aVar);
        }
        return treeMap;
    }

    static c b(boolean z, sdk.pendo.io.b5.h hVar) {
        Map<Integer, f0> a2 = a(z, hVar);
        return new c(a2, a(a2));
    }

    static int c(b bVar, int i) {
        for (f0 f0Var : a(bVar)) {
            if (f0Var.b() >= i) {
                return f0Var.e();
            }
        }
        return -1;
    }

    private static Map<Integer, f0> a(c cVar, s0 s0Var, sdk.pendo.io.y4.v0[] v0VarArr) {
        sdk.pendo.io.y4.v0 c2 = sdk.pendo.io.y4.v0.c(v0VarArr);
        sdk.pendo.io.y4.v0 a2 = sdk.pendo.io.y4.v0.a(v0VarArr);
        sdk.pendo.io.s4.a c3 = s0Var.c();
        boolean e2 = l3.e(c2);
        boolean z = !l3.e(a2);
        int length = cVar.b.length;
        LinkedHashMap linkedHashMap = new LinkedHashMap(length);
        for (int i = 0; i < length; i++) {
            Integer b2 = sdk.pendo.io.d5.d.b(cVar.b[i]);
            f0 f0Var = (f0) cVar.f1577a.get(b2);
            if (f0Var != null && f0Var.a(c3, e2, z)) {
                linkedHashMap.put(b2, f0Var);
            }
        }
        return linkedHashMap;
    }

    int b() {
        return this.f1575a.bitsFFDHE;
    }

    private static List<f0> a(b bVar, int[] iArr) {
        return a((Map<Integer, f0>) bVar.f1576a, iArr);
    }

    static int b(b bVar) {
        Iterator<f0> it = a(bVar).iterator();
        int i = 0;
        while (it.hasNext()) {
            i = Math.max(i, it.next().a());
        }
        return i;
    }

    static void b(b bVar, int[] iArr) {
        bVar.a(a(bVar, iArr));
    }

    int a() {
        return this.f1575a.bitsECDH;
    }

    private static Collection<f0> a(b bVar) {
        List<f0> a2 = bVar.a();
        return !a2.isEmpty() ? a2 : bVar.f1576a.values();
    }

    static int b(b bVar, int i) {
        for (f0 f0Var : a(bVar)) {
            if (f0Var.a() >= i) {
                return f0Var.e();
            }
        }
        return -1;
    }

    static f0 a(c cVar, int i) {
        return (f0) cVar.f1577a.get(Integer.valueOf(i));
    }

    private static int a(String str) {
        for (a aVar : a.values()) {
            if (aVar.name.equalsIgnoreCase(str)) {
                return aVar.namedGroup;
            }
        }
        return -1;
    }

    private static List<f0> a(Map<Integer, f0> map, int[] iArr) {
        if (l3.e(iArr)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            f0 f0Var = map.get(Integer.valueOf(i));
            if (f0Var != null) {
                arrayList.add(f0Var);
            }
        }
        if (arrayList.isEmpty()) {
            return Collections.emptyList();
        }
        arrayList.trimToSize();
        return arrayList;
    }

    static boolean a(b bVar, int i) {
        return bVar.f1576a.containsKey(Integer.valueOf(i));
    }

    boolean a(sdk.pendo.io.s4.a aVar, boolean z, boolean z2) {
        return this.c && ((z && g()) || (z2 && h())) && a(aVar);
    }

    private boolean a(sdk.pendo.io.s4.a aVar) {
        Set<sdk.pendo.io.s4.b> set = a0.g;
        return aVar.permits(set, d(), null) && aVar.permits(set, c(), this.b);
    }
}
