package sdk.pendo.io.t4;

import java.security.AlgorithmConstraints;
import java.security.AlgorithmParameters;
import java.security.CryptoPrimitive;
import java.security.Key;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes6.dex */
abstract class b0 extends a0 {
    static final Set<CryptoPrimitive> l = Collections.unmodifiableSet(EnumSet.of(CryptoPrimitive.KEY_AGREEMENT));
    static final Set<CryptoPrimitive> m = Collections.unmodifiableSet(EnumSet.of(CryptoPrimitive.KEY_ENCAPSULATION));
    static final Set<CryptoPrimitive> n = Collections.unmodifiableSet(EnumSet.of(CryptoPrimitive.SIGNATURE));
    static final AlgorithmConstraints o = new b(k0.h);

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1553a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[CryptoPrimitive.values().length];
            b = iArr;
            try {
                iArr[CryptoPrimitive.MESSAGE_DIGEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[CryptoPrimitive.SECURE_RANDOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[CryptoPrimitive.BLOCK_CIPHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[CryptoPrimitive.STREAM_CIPHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[CryptoPrimitive.MAC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[CryptoPrimitive.KEY_WRAP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[CryptoPrimitive.PUBLIC_KEY_ENCRYPTION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[CryptoPrimitive.SIGNATURE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[CryptoPrimitive.KEY_ENCAPSULATION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[CryptoPrimitive.KEY_AGREEMENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr2 = new int[sdk.pendo.io.s4.b.values().length];
            f1553a = iArr2;
            try {
                iArr2[sdk.pendo.io.s4.b.MESSAGE_DIGEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1553a[sdk.pendo.io.s4.b.SECURE_RANDOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1553a[sdk.pendo.io.s4.b.BLOCK_CIPHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f1553a[sdk.pendo.io.s4.b.STREAM_CIPHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f1553a[sdk.pendo.io.s4.b.MAC.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f1553a[sdk.pendo.io.s4.b.KEY_WRAP.ordinal()] = 6;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f1553a[sdk.pendo.io.s4.b.PUBLIC_KEY_ENCRYPTION.ordinal()] = 7;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f1553a[sdk.pendo.io.s4.b.SIGNATURE.ordinal()] = 8;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f1553a[sdk.pendo.io.s4.b.KEY_ENCAPSULATION.ordinal()] = 9;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f1553a[sdk.pendo.io.s4.b.KEY_AGREEMENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    static class b implements AlgorithmConstraints {

        /* renamed from: a, reason: collision with root package name */
        private final sdk.pendo.io.s4.a f1554a;

        b(sdk.pendo.io.s4.a aVar) {
            this.f1554a = aVar;
        }

        sdk.pendo.io.s4.a a() {
            return this.f1554a;
        }

        @Override // java.security.AlgorithmConstraints
        public boolean permits(Set<CryptoPrimitive> set, String str, AlgorithmParameters algorithmParameters) {
            return this.f1554a.permits(b0.b(set), str, algorithmParameters);
        }

        @Override // java.security.AlgorithmConstraints
        public boolean permits(Set<CryptoPrimitive> set, String str, Key key, AlgorithmParameters algorithmParameters) {
            return this.f1554a.permits(b0.b(set), str, key, algorithmParameters);
        }

        @Override // java.security.AlgorithmConstraints
        public boolean permits(Set<CryptoPrimitive> set, Key key) {
            return this.f1554a.permits(b0.b(set), key);
        }
    }

    static class c implements sdk.pendo.io.s4.a {

        /* renamed from: a, reason: collision with root package name */
        private final AlgorithmConstraints f1555a;

        c(AlgorithmConstraints algorithmConstraints) {
            this.f1555a = algorithmConstraints;
        }

        AlgorithmConstraints a() {
            return this.f1555a;
        }

        @Override // sdk.pendo.io.s4.a
        public boolean permits(Set<sdk.pendo.io.s4.b> set, String str, AlgorithmParameters algorithmParameters) {
            return this.f1555a.permits(b0.a(set), str, algorithmParameters);
        }

        @Override // sdk.pendo.io.s4.a
        public boolean permits(Set<sdk.pendo.io.s4.b> set, String str, Key key, AlgorithmParameters algorithmParameters) {
            return this.f1555a.permits(b0.a(set), str, key, algorithmParameters);
        }

        @Override // sdk.pendo.io.s4.a
        public boolean permits(Set<sdk.pendo.io.s4.b> set, Key key) {
            return this.f1555a.permits(b0.a(set), key);
        }
    }

    static AlgorithmConstraints a(sdk.pendo.io.s4.a aVar) {
        if (k0.h == aVar) {
            return o;
        }
        if (aVar == null) {
            return null;
        }
        return aVar instanceof c ? ((c) aVar).a() : new b(aVar);
    }

    static Object b(sdk.pendo.io.s4.a aVar) {
        return a(aVar);
    }

    static CryptoPrimitive a(sdk.pendo.io.s4.b bVar) {
        switch (a.f1553a[bVar.ordinal()]) {
            case 1:
                return CryptoPrimitive.MESSAGE_DIGEST;
            case 2:
                return CryptoPrimitive.SECURE_RANDOM;
            case 3:
                return CryptoPrimitive.BLOCK_CIPHER;
            case 4:
                return CryptoPrimitive.STREAM_CIPHER;
            case 5:
                return CryptoPrimitive.MAC;
            case 6:
                return CryptoPrimitive.KEY_WRAP;
            case 7:
                return CryptoPrimitive.PUBLIC_KEY_ENCRYPTION;
            case 8:
                return CryptoPrimitive.SIGNATURE;
            case 9:
                return CryptoPrimitive.KEY_ENCAPSULATION;
            case 10:
                return CryptoPrimitive.KEY_AGREEMENT;
            default:
                return null;
        }
    }

    static Set<sdk.pendo.io.s4.b> b(Set<CryptoPrimitive> set) {
        if (n == set) {
            return a0.i;
        }
        if (l == set) {
            return a0.g;
        }
        if (m == set) {
            return a0.h;
        }
        HashSet hashSet = new HashSet();
        Iterator<CryptoPrimitive> it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    static Set<CryptoPrimitive> a(Set<sdk.pendo.io.s4.b> set) {
        if (a0.i == set) {
            return n;
        }
        if (a0.g == set) {
            return l;
        }
        if (a0.h == set) {
            return m;
        }
        HashSet hashSet = new HashSet();
        Iterator<sdk.pendo.io.s4.b> it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    static sdk.pendo.io.s4.a a(AlgorithmConstraints algorithmConstraints) {
        if (algorithmConstraints == null) {
            return null;
        }
        return algorithmConstraints instanceof b ? ((b) algorithmConstraints).a() : new c(algorithmConstraints);
    }

    static sdk.pendo.io.s4.a a(Object obj) {
        return a((AlgorithmConstraints) obj);
    }

    static sdk.pendo.io.s4.b a(CryptoPrimitive cryptoPrimitive) {
        switch (a.b[cryptoPrimitive.ordinal()]) {
            case 1:
                return sdk.pendo.io.s4.b.MESSAGE_DIGEST;
            case 2:
                return sdk.pendo.io.s4.b.SECURE_RANDOM;
            case 3:
                return sdk.pendo.io.s4.b.BLOCK_CIPHER;
            case 4:
                return sdk.pendo.io.s4.b.STREAM_CIPHER;
            case 5:
                return sdk.pendo.io.s4.b.MAC;
            case 6:
                return sdk.pendo.io.s4.b.KEY_WRAP;
            case 7:
                return sdk.pendo.io.s4.b.PUBLIC_KEY_ENCRYPTION;
            case 8:
                return sdk.pendo.io.s4.b.SIGNATURE;
            case 9:
                return sdk.pendo.io.s4.b.KEY_ENCAPSULATION;
            case 10:
                return sdk.pendo.io.s4.b.KEY_AGREEMENT;
            default:
                return null;
        }
    }
}
