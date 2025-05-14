package sdk.pendo.io.t4;

import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.interfaces.DSAKey;
import java.security.interfaces.DSAParams;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHKey;
import javax.crypto.spec.DHParameterSpec;

/* loaded from: classes6.dex */
class g extends sdk.pendo.io.t4.a {
    private static final Logger d = Logger.getLogger(g.class.getName());
    private final Set<String> b;
    private final Map<String, List<c>> c;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1578a;

        static {
            int[] iArr = new int[b.values().length];
            f1578a = iArr;
            try {
                iArr[b.EQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1578a[b.GE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1578a[b.GT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1578a[b.LE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1578a[b.LT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1578a[b.NE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private enum b {
        EQ("=="),
        GE(">="),
        GT(">"),
        LE("<="),
        LT("<"),
        NE("!=");

        private final String s;

        b(String str) {
            this.s = str;
        }

        static boolean a(b bVar, int i, int i2) {
            switch (a.f1578a[bVar.ordinal()]) {
                case 1:
                    if (i == i2) {
                        break;
                    }
                    break;
                case 2:
                    if (i >= i2) {
                        break;
                    }
                    break;
                case 3:
                    if (i > i2) {
                        break;
                    }
                    break;
                case 4:
                    if (i <= i2) {
                        break;
                    }
                    break;
                case 5:
                    if (i < i2) {
                        break;
                    }
                    break;
                case 6:
                    if (i != i2) {
                        break;
                    }
                    break;
            }
            return true;
        }

        static b a(String str) {
            for (b bVar : values()) {
                if (bVar.s.equals(str)) {
                    return bVar;
                }
            }
            throw new IllegalArgumentException("'s' is not a valid operator: " + str);
        }
    }

    private static abstract class c {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        boolean a(AlgorithmParameters algorithmParameters) {
            return true;
        }

        boolean a(Key key) {
            return true;
        }
    }

    private static class d extends c {

        /* renamed from: a, reason: collision with root package name */
        static final d f1579a = new d();

        private d() {
            super(null);
        }

        @Override // sdk.pendo.io.t4.g.c
        public boolean a(Key key) {
            return false;
        }
    }

    private static class e extends c {

        /* renamed from: a, reason: collision with root package name */
        private final b f1580a;
        private final int b;

        e(b bVar, int i) {
            super(null);
            this.f1580a = bVar;
            this.b = i;
        }

        private boolean a(int i) {
            return i < 1 ? i < 0 : !b.a(this.f1580a, i, this.b);
        }

        private static int b(AlgorithmParameters algorithmParameters) {
            DHParameterSpec dHParameterSpec;
            String algorithm = algorithmParameters.getAlgorithm();
            try {
                if ("EC".equals(algorithm)) {
                    ECParameterSpec eCParameterSpec = (ECParameterSpec) algorithmParameters.getParameterSpec(ECParameterSpec.class);
                    if (eCParameterSpec != null) {
                        return eCParameterSpec.getOrder().bitLength();
                    }
                    return -1;
                }
                if (!"DiffieHellman".equals(algorithm) || (dHParameterSpec = (DHParameterSpec) algorithmParameters.getParameterSpec(DHParameterSpec.class)) == null) {
                    return -1;
                }
                return dHParameterSpec.getP().bitLength();
            } catch (InvalidParameterSpecException unused) {
                return -1;
            }
        }

        private static int b(Key key) {
            byte[] encoded;
            BigInteger p;
            if (key instanceof RSAKey) {
                p = ((RSAKey) key).getModulus();
            } else if (key instanceof ECKey) {
                p = ((ECKey) key).getParams().getOrder();
            } else if (key instanceof DSAKey) {
                DSAParams params = ((DSAKey) key).getParams();
                if (params == null) {
                    return -1;
                }
                p = params.getP();
            } else {
                if (!(key instanceof DHKey)) {
                    if (!(key instanceof SecretKey)) {
                        return -1;
                    }
                    SecretKey secretKey = (SecretKey) key;
                    if (!"RAW".equals(secretKey.getFormat()) || (encoded = secretKey.getEncoded()) == null) {
                        return -1;
                    }
                    if (encoded.length > 268435455) {
                        return 0;
                    }
                    return encoded.length * 8;
                }
                p = ((DHKey) key).getParams().getP();
            }
            return p.bitLength();
        }

        @Override // sdk.pendo.io.t4.g.c
        boolean a(AlgorithmParameters algorithmParameters) {
            return a(b(algorithmParameters));
        }

        @Override // sdk.pendo.io.t4.g.c
        boolean a(Key key) {
            return a(b(key));
        }
    }

    private g(sdk.pendo.io.t4.b bVar, Set<String> set, Map<String, List<c>> map) {
        super(bVar);
        this.b = set;
        this.c = map;
    }

    private static void a(Map<String, List<c>> map, String str, c cVar) {
        List<c> list = map.get(str);
        if (list == null) {
            list = new ArrayList<>(1);
            map.put(str, list);
        }
        list.add(cVar);
    }

    private static String b(String str) {
        return "DiffieHellman".equalsIgnoreCase(str) ? "DH" : str.toUpperCase(Locale.ENGLISH).replace("SHA-", "SHA");
    }

    private List<c> c(String str) {
        List<c> list;
        return (str == null || (list = this.c.get(str)) == null) ? Collections.emptyList() : list;
    }

    @Override // sdk.pendo.io.s4.a
    public final boolean permits(Set<sdk.pendo.io.s4.b> set, String str, AlgorithmParameters algorithmParameters) {
        a(set);
        a(str);
        if (a(this.b, str)) {
            return false;
        }
        Iterator<c> it = c(a(str, algorithmParameters)).iterator();
        while (it.hasNext()) {
            if (!it.next().a(algorithmParameters)) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(Set<String> set, Map<String, List<c>> map, String str) {
        if (str.regionMatches(true, 0, "include ", 0, 8)) {
            return false;
        }
        int indexOf = str.indexOf(32);
        if (indexOf < 0) {
            String b2 = b(str);
            set.add(b2);
            a(map, b2, d.f1579a);
            return true;
        }
        String b3 = b(str.substring(0, indexOf));
        String trim = str.substring(indexOf + 1).trim();
        if (trim.indexOf(38) >= 0 || !trim.startsWith("keySize")) {
            return false;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(trim);
        if (!"keySize".equals(stringTokenizer.nextToken())) {
            return false;
        }
        b a2 = b.a(stringTokenizer.nextToken());
        int parseInt = Integer.parseInt(stringTokenizer.nextToken());
        if (stringTokenizer.hasMoreTokens()) {
            return false;
        }
        a(map, b3, new e(a2, parseInt));
        return true;
    }

    private static String b(Key key) {
        String a2;
        if (key == null || (a2 = a0.a(key)) == null) {
            return null;
        }
        return b(a2);
    }

    @Override // sdk.pendo.io.s4.a
    public final boolean permits(Set<sdk.pendo.io.s4.b> set, String str, Key key, AlgorithmParameters algorithmParameters) {
        a(str);
        return a(set, str, key, algorithmParameters);
    }

    private boolean a(Set<sdk.pendo.io.s4.b> set, String str, Key key, AlgorithmParameters algorithmParameters) {
        a(set);
        a(key);
        if ((a0.a(str) && !permits(set, str, algorithmParameters)) || !permits(set, a0.a(key), null)) {
            return false;
        }
        Iterator<c> it = c(b(key)).iterator();
        while (it.hasNext()) {
            if (!it.next().a(key)) {
                return false;
            }
        }
        return true;
    }

    @Override // sdk.pendo.io.s4.a
    public final boolean permits(Set<sdk.pendo.io.s4.b> set, Key key) {
        return a(set, null, key, null);
    }

    static g a(sdk.pendo.io.t4.b bVar, String str, String str2) {
        String[] a2 = i0.a(str, str2);
        if (a2 == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < a2.length; i++) {
            if (!a(hashSet, hashMap, a2[i])) {
                d.warning("Ignoring unsupported entry in '" + str + "': " + a2[i]);
            }
        }
        return new g(bVar, Collections.unmodifiableSet(hashSet), Collections.unmodifiableMap(hashMap));
    }

    private static String a(String str, AlgorithmParameters algorithmParameters) {
        String algorithm;
        if (algorithmParameters == null || (algorithm = algorithmParameters.getAlgorithm()) == null) {
            return null;
        }
        String b2 = b(str);
        if (b2.equalsIgnoreCase(b(algorithm))) {
            return b2;
        }
        return null;
    }
}
