package sdk.pendo.io.v4;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Random;
import java.util.Set;
import sdk.pendo.io.d5.b;
import sdk.pendo.io.v4.d;
import sdk.pendo.io.v4.e;

/* loaded from: classes4.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    protected sdk.pendo.io.w4.a f1679a;
    protected sdk.pendo.io.v4.d b;
    protected sdk.pendo.io.v4.d c;
    protected BigInteger d;
    protected BigInteger e;
    protected int f = 0;

    public static abstract class a extends c {
        private BigInteger[] g;

        protected a(int i, int i2, int i3, int i4) {
            super(a(i, i2, i3, i4));
            this.g = null;
        }

        private static sdk.pendo.io.w4.a a(int i, int i2, int i3, int i4) {
            if (i2 == 0) {
                throw new IllegalArgumentException("k1 must be > 0");
            }
            if (i3 == 0) {
                if (i4 == 0) {
                    return sdk.pendo.io.w4.b.a(new int[]{0, i2, i});
                }
                throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
            }
            if (i3 <= i2) {
                throw new IllegalArgumentException("k2 must be > k1");
            }
            if (i4 > i3) {
                return sdk.pendo.io.w4.b.a(new int[]{0, i2, i3, i4, i});
            }
            throw new IllegalArgumentException("k3 must be > k2");
        }

        @Override // sdk.pendo.io.v4.c
        public e a(BigInteger bigInteger, BigInteger bigInteger2) {
            sdk.pendo.io.v4.d a2 = a(bigInteger);
            sdk.pendo.io.v4.d a3 = a(bigInteger2);
            int d = d();
            if (d == 5 || d == 6) {
                if (!a2.g()) {
                    a3 = a3.b(a2).a(a2);
                } else if (!a3.j().equals(b())) {
                    throw new IllegalArgumentException();
                }
            }
            return a(a2, a3);
        }

        @Override // sdk.pendo.io.v4.c
        protected e a(int i, BigInteger bigInteger) {
            sdk.pendo.io.v4.d dVar;
            sdk.pendo.io.v4.d a2 = a(bigInteger);
            if (a2.g()) {
                dVar = b().i();
            } else {
                sdk.pendo.io.v4.d a3 = a(a2.j().e().c(b()).a(a()).a(a2));
                if (a3 != null) {
                    if (a3.k() != (i == 1)) {
                        a3 = a3.a();
                    }
                    int d = d();
                    dVar = (d == 5 || d == 6) ? a3.a(a2) : a3.c(a2);
                } else {
                    dVar = null;
                }
            }
            if (dVar != null) {
                return a(a2, dVar);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }

        private static BigInteger a(SecureRandom secureRandom, int i) {
            BigInteger b;
            do {
                b = sdk.pendo.io.d5.b.b(i, secureRandom);
            } while (b.signum() <= 0);
            return b;
        }

        @Override // sdk.pendo.io.v4.c
        public sdk.pendo.io.v4.d a(SecureRandom secureRandom) {
            int f = f();
            return a(a(secureRandom, f)).c(a(a(secureRandom, f)));
        }

        protected sdk.pendo.io.v4.d a(sdk.pendo.io.v4.d dVar) {
            sdk.pendo.io.v4.d dVar2;
            d.a aVar = (d.a) dVar;
            boolean n = aVar.n();
            if (n && aVar.o() != 0) {
                return null;
            }
            int f = f();
            if ((f & 1) != 0) {
                sdk.pendo.io.v4.d m = aVar.m();
                if (n || m.j().a(m).a(dVar).g()) {
                    return m;
                }
                return null;
            }
            if (dVar.g()) {
                return dVar;
            }
            sdk.pendo.io.v4.d a2 = a(sdk.pendo.io.v4.b.f1678a);
            Random random = new Random();
            do {
                sdk.pendo.io.v4.d a3 = a(new BigInteger(f, random));
                sdk.pendo.io.v4.d dVar3 = dVar;
                dVar2 = a2;
                for (int i = 1; i < f; i++) {
                    sdk.pendo.io.v4.d j = dVar3.j();
                    dVar2 = dVar2.j().a(j.c(a3));
                    dVar3 = j.a(dVar);
                }
                if (!dVar3.g()) {
                    return null;
                }
            } while (dVar2.j().a(dVar2).g());
            return dVar2;
        }
    }

    public static abstract class b extends c {
        protected b(BigInteger bigInteger) {
            super(sdk.pendo.io.w4.b.a(bigInteger));
        }

        @Override // sdk.pendo.io.v4.c
        protected e a(int i, BigInteger bigInteger) {
            sdk.pendo.io.v4.d a2 = a(bigInteger);
            sdk.pendo.io.v4.d i2 = a2.j().a(this.b).c(a2).a(this.c).i();
            if (i2 == null) {
                throw new IllegalArgumentException("Invalid point compression");
            }
            if (i2.k() != (i == 1)) {
                i2 = i2.h();
            }
            return a(a2, i2);
        }

        private static BigInteger a(SecureRandom secureRandom, BigInteger bigInteger) {
            while (true) {
                BigInteger b = sdk.pendo.io.d5.b.b(bigInteger.bitLength(), secureRandom);
                if (b.signum() > 0 && b.compareTo(bigInteger) < 0) {
                    return b;
                }
            }
        }

        @Override // sdk.pendo.io.v4.c
        public sdk.pendo.io.v4.d a(SecureRandom secureRandom) {
            BigInteger b = e().b();
            return a(a(secureRandom, b)).c(a(a(secureRandom, b)));
        }
    }

    /* renamed from: sdk.pendo.io.v4.c$c, reason: collision with other inner class name */
    public static class C0248c extends a {
        private int h;
        private int i;
        private int j;
        private int k;
        private e.d l;

        public C0248c(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(i, i2, i3, i4);
            this.h = i;
            this.i = i2;
            this.j = i3;
            this.k = i4;
            this.d = bigInteger3;
            this.e = bigInteger4;
            this.l = new e.d(this, null, null);
            this.b = a(bigInteger);
            this.c = a(bigInteger2);
            this.f = 6;
        }

        @Override // sdk.pendo.io.v4.c
        protected e a(sdk.pendo.io.v4.d dVar, sdk.pendo.io.v4.d dVar2) {
            return new e.d(this, dVar, dVar2);
        }

        @Override // sdk.pendo.io.v4.c
        public int f() {
            return this.h;
        }

        @Override // sdk.pendo.io.v4.c
        public e g() {
            return this.l;
        }

        @Override // sdk.pendo.io.v4.c
        public sdk.pendo.io.v4.d a(BigInteger bigInteger) {
            return new d.c(this.h, this.i, this.j, this.k, bigInteger);
        }
    }

    public static class d extends b {
        private static final Set<BigInteger> j = Collections.synchronizedSet(new HashSet());
        private static final b.a k = new b.a();
        BigInteger g;
        BigInteger h;
        e.C0250e i;

        public d(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
            this(bigInteger, bigInteger2, bigInteger3, bigInteger4, bigInteger5, false);
        }

        @Override // sdk.pendo.io.v4.c
        protected e a(sdk.pendo.io.v4.d dVar, sdk.pendo.io.v4.d dVar2) {
            return new e.C0250e(this, dVar, dVar2);
        }

        @Override // sdk.pendo.io.v4.c
        public e b(e eVar) {
            int d;
            return (this == eVar.e() || d() != 2 || eVar.k() || !((d = eVar.e().d()) == 2 || d == 3 || d == 4)) ? super.b(eVar) : new e.C0250e(this, a(eVar.b.l()), a(eVar.c.l()), new sdk.pendo.io.v4.d[]{a(eVar.d[0].l())});
        }

        @Override // sdk.pendo.io.v4.c
        public int f() {
            return this.g.bitLength();
        }

        @Override // sdk.pendo.io.v4.c
        public e g() {
            return this.i;
        }

        public d(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, boolean z) {
            super(bigInteger);
            if (z) {
                this.g = bigInteger;
                j.add(bigInteger);
            } else {
                if (!j.contains(bigInteger)) {
                    b.a aVar = k;
                    if (!aVar.b(bigInteger)) {
                        int a2 = sdk.pendo.io.d5.g.a("external.sdk.pendo.io.org.bouncycastle.ec.fp_max_size", 1042);
                        int a3 = sdk.pendo.io.d5.g.a("external.sdk.pendo.io.org.bouncycastle.ec.fp_certainty", 100);
                        int bitLength = bigInteger.bitLength();
                        if (a2 < bitLength) {
                            throw new IllegalArgumentException("Fp q value out of range");
                        }
                        if (sdk.pendo.io.u4.a.a(bigInteger) || !sdk.pendo.io.u4.a.a(bigInteger, sdk.pendo.io.g4.b.a(), c.b(bitLength, a3))) {
                            throw new IllegalArgumentException("Fp q value not prime");
                        }
                        aVar.a(bigInteger);
                    }
                }
                this.g = bigInteger;
            }
            this.h = d.C0249d.a(bigInteger);
            this.i = new e.C0250e(this, null, null);
            this.b = a(bigInteger2);
            this.c = a(bigInteger3);
            this.d = bigInteger4;
            this.e = bigInteger5;
            this.f = 4;
        }

        @Override // sdk.pendo.io.v4.c
        public sdk.pendo.io.v4.d a(BigInteger bigInteger) {
            return new d.C0249d(this.g, this.h, bigInteger);
        }
    }

    protected c(sdk.pendo.io.w4.a aVar) {
        this.f1679a = aVar;
    }

    public abstract sdk.pendo.io.v4.d a(BigInteger bigInteger);

    public abstract sdk.pendo.io.v4.d a(SecureRandom secureRandom);

    protected abstract e a(int i, BigInteger bigInteger);

    protected abstract e a(sdk.pendo.io.v4.d dVar, sdk.pendo.io.v4.d dVar2);

    public sdk.pendo.io.v4.d b() {
        return this.c;
    }

    public BigInteger c() {
        return this.e;
    }

    public int d() {
        return this.f;
    }

    public sdk.pendo.io.w4.a e() {
        return this.f1679a;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof c) && a((c) obj));
    }

    public abstract int f();

    public abstract e g();

    public BigInteger h() {
        return this.d;
    }

    public int hashCode() {
        return (e().hashCode() ^ sdk.pendo.io.d5.d.a(a().l().hashCode(), 8)) ^ sdk.pendo.io.d5.d.a(b().l().hashCode(), 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i, int i2) {
        if (i >= 1536) {
            if (i2 <= 100) {
                return 3;
            }
            if (i2 <= 128) {
                return 4;
            }
            return 4 + (((i2 - 128) + 1) / 2);
        }
        if (i >= 1024) {
            if (i2 <= 100) {
                return 4;
            }
            if (i2 <= 112) {
                return 5;
            }
            return (((i2 - 112) + 1) / 2) + 5;
        }
        if (i < 512) {
            if (i2 <= 80) {
                return 40;
            }
            return 40 + (((i2 - 80) + 1) / 2);
        }
        if (i2 <= 80) {
            return 5;
        }
        if (i2 <= 100) {
            return 7;
        }
        return 7 + (((i2 - 100) + 1) / 2);
    }

    protected void a(e eVar) {
        if (eVar == null || this != eVar.e()) {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
    }

    protected void a(e[] eVarArr, int i, int i2) {
        if (eVarArr == null) {
            throw new IllegalArgumentException("'points' cannot be null");
        }
        if (i < 0 || i2 < 0 || i > eVarArr.length - i2) {
            throw new IllegalArgumentException("invalid range specified for 'points'");
        }
        for (int i3 = 0; i3 < i2; i3++) {
            e eVar = eVarArr[i + i3];
            if (eVar != null && this != eVar.e()) {
                throw new IllegalArgumentException("'points' entries must be null or on this curve");
            }
        }
    }

    public e b(e eVar) {
        if (this == eVar.e()) {
            return eVar;
        }
        if (eVar.k()) {
            return g();
        }
        e o = eVar.o();
        return a(o.i().l(), o.j().l());
    }

    public e a(BigInteger bigInteger, BigInteger bigInteger2) {
        return a(a(bigInteger), a(bigInteger2));
    }

    public e b(BigInteger bigInteger, BigInteger bigInteger2) {
        e a2 = a(bigInteger, bigInteger2);
        if (a2.m()) {
            return a2;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }

    public e a(byte[] bArr) {
        e g;
        int f = (f() + 7) / 8;
        byte b2 = bArr[0];
        if (b2 != 0) {
            if (b2 == 2 || b2 == 3) {
                if (bArr.length != f + 1) {
                    throw new IllegalArgumentException("Incorrect length for compressed encoding");
                }
                g = a(b2 & 1, sdk.pendo.io.d5.b.a(bArr, 1, f));
                if (!g.a(true, true)) {
                    throw new IllegalArgumentException("Invalid point");
                }
            } else if (b2 != 4) {
                if (b2 != 6 && b2 != 7) {
                    throw new IllegalArgumentException("Invalid point encoding 0x" + Integer.toString(b2, 16));
                }
                if (bArr.length != (f * 2) + 1) {
                    throw new IllegalArgumentException("Incorrect length for hybrid encoding");
                }
                BigInteger a2 = sdk.pendo.io.d5.b.a(bArr, 1, f);
                BigInteger a3 = sdk.pendo.io.d5.b.a(bArr, f + 1, f);
                if (a3.testBit(0) != (b2 == 7)) {
                    throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
                }
                g = b(a2, a3);
            } else {
                if (bArr.length != (f * 2) + 1) {
                    throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
                }
                g = b(sdk.pendo.io.d5.b.a(bArr, 1, f), sdk.pendo.io.d5.b.a(bArr, f + 1, f));
            }
        } else {
            if (bArr.length != 1) {
                throw new IllegalArgumentException("Incorrect length for infinity encoding");
            }
            g = g();
        }
        if (b2 == 0 || !g.k()) {
            return g;
        }
        throw new IllegalArgumentException("Invalid infinity encoding");
    }

    public boolean a(c cVar) {
        return this == cVar || (cVar != null && e().equals(cVar.e()) && a().l().equals(cVar.a().l()) && b().l().equals(cVar.b().l()));
    }

    public sdk.pendo.io.v4.d a() {
        return this.b;
    }

    public void a(e[] eVarArr) {
        a(eVarArr, 0, eVarArr.length, null);
    }

    public void a(e[] eVarArr, int i, int i2, sdk.pendo.io.v4.d dVar) {
        a(eVarArr, i, i2);
        int d2 = d();
        if (d2 == 0 || d2 == 5) {
            if (dVar != null) {
                throw new IllegalArgumentException("'iso' not valid for affine coordinates");
            }
            return;
        }
        sdk.pendo.io.v4.d[] dVarArr = new sdk.pendo.io.v4.d[i2];
        int[] iArr = new int[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i + i4;
            e eVar = eVarArr[i5];
            if (eVar != null && (dVar != null || !eVar.l())) {
                dVarArr[i3] = eVar.a(0);
                iArr[i3] = i5;
                i3++;
            }
        }
        if (i3 == 0) {
            return;
        }
        sdk.pendo.io.v4.a.a(dVarArr, 0, i3, dVar);
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = iArr[i6];
            eVarArr[i7] = eVarArr[i7].a(dVarArr[i6]);
        }
    }

    public h a(e eVar, String str, g gVar) {
        Hashtable hashtable;
        h a2;
        a(eVar);
        synchronized (eVar) {
            hashtable = eVar.e;
            if (hashtable == null) {
                hashtable = new Hashtable(4);
                eVar.e = hashtable;
            }
        }
        synchronized (hashtable) {
            h hVar = (h) hashtable.get(str);
            a2 = gVar.a(hVar);
            if (a2 != hVar) {
                hashtable.put(str, a2);
            }
        }
        return a2;
    }
}
