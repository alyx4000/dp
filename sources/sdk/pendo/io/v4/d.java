package sdk.pendo.io.v4;

import java.math.BigInteger;
import java.util.Random;

/* loaded from: classes4.dex */
public abstract class d implements sdk.pendo.io.v4.b {

    public static abstract class a extends d {
        public d m() {
            int d = d();
            if ((d & 1) == 0) {
                throw new IllegalStateException("Half-trace only defined for odd m");
            }
            int i = (d + 1) >>> 1;
            int a2 = 31 - sdk.pendo.io.d5.d.a(i);
            d dVar = this;
            int i2 = 1;
            while (a2 > 0) {
                dVar = dVar.a(i2 << 1).a(dVar);
                a2--;
                i2 = i >>> a2;
                if ((i2 & 1) != 0) {
                    dVar = dVar.a(2).a(this);
                }
            }
            return dVar;
        }

        public boolean n() {
            return false;
        }

        public int o() {
            int d = d();
            int a2 = 31 - sdk.pendo.io.d5.d.a(d);
            d dVar = this;
            int i = 1;
            while (a2 > 0) {
                dVar = dVar.a(i).a(dVar);
                a2--;
                i = d >>> a2;
                if ((i & 1) != 0) {
                    dVar = dVar.j().a(this);
                }
            }
            if (dVar.g()) {
                return 0;
            }
            if (dVar.f()) {
                return 1;
            }
            throw new IllegalStateException("Internal error in trace calculation");
        }
    }

    public static abstract class b extends d {
    }

    public static class c extends a {
        private int g;
        private int h;
        private int[] i;
        f j;

        c(int i, int i2, int i3, int i4, BigInteger bigInteger) {
            if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
                throw new IllegalArgumentException("x value invalid in F2m field element");
            }
            if (i3 == 0 && i4 == 0) {
                this.g = 2;
                this.i = new int[]{i2};
            } else {
                if (i3 >= i4) {
                    throw new IllegalArgumentException("k2 must be smaller than k3");
                }
                if (i3 <= 0) {
                    throw new IllegalArgumentException("k2 must be larger than 0");
                }
                this.g = 3;
                this.i = new int[]{i2, i3, i4};
            }
            this.h = i;
            this.j = new f(bigInteger);
        }

        @Override // sdk.pendo.io.v4.d
        public d a(d dVar) {
            f fVar = (f) this.j.clone();
            fVar.a(((c) dVar).j, 0);
            return new c(this.h, this.i, fVar);
        }

        @Override // sdk.pendo.io.v4.d
        public int b() {
            return this.j.d();
        }

        @Override // sdk.pendo.io.v4.d
        public d c(d dVar) {
            int i = this.h;
            int[] iArr = this.i;
            return new c(i, iArr, this.j.a(((c) dVar).j, i, iArr));
        }

        @Override // sdk.pendo.io.v4.d
        public int d() {
            return this.h;
        }

        @Override // sdk.pendo.io.v4.d
        public d e() {
            int i = this.h;
            int[] iArr = this.i;
            return new c(i, iArr, this.j.a(i, iArr));
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.h == cVar.h && this.g == cVar.g && sdk.pendo.io.d5.a.a(this.i, cVar.i) && this.j.equals(cVar.j);
        }

        @Override // sdk.pendo.io.v4.d
        public boolean f() {
            return this.j.g();
        }

        @Override // sdk.pendo.io.v4.d
        public boolean g() {
            return this.j.h();
        }

        @Override // sdk.pendo.io.v4.d
        public d h() {
            return this;
        }

        public int hashCode() {
            return (this.j.hashCode() ^ this.h) ^ sdk.pendo.io.d5.a.b(this.i);
        }

        @Override // sdk.pendo.io.v4.d
        public d i() {
            return (this.j.h() || this.j.g()) ? this : a(this.h - 1);
        }

        @Override // sdk.pendo.io.v4.d
        public d j() {
            int i = this.h;
            int[] iArr = this.i;
            return new c(i, iArr, this.j.b(i, iArr));
        }

        @Override // sdk.pendo.io.v4.d
        public boolean k() {
            return this.j.i();
        }

        @Override // sdk.pendo.io.v4.d
        public BigInteger l() {
            return this.j.j();
        }

        c(int i, int[] iArr, f fVar) {
            this.h = i;
            this.g = iArr.length == 1 ? 2 : 3;
            this.i = iArr;
            this.j = fVar;
        }

        @Override // sdk.pendo.io.v4.d
        public d a() {
            return new c(this.h, this.i, this.j.c());
        }

        @Override // sdk.pendo.io.v4.d
        public d b(d dVar) {
            return c(dVar.e());
        }

        @Override // sdk.pendo.io.v4.d
        public d d(d dVar) {
            return a(dVar);
        }

        @Override // sdk.pendo.io.v4.d
        public d a(d dVar, d dVar2, d dVar3) {
            return b(dVar, dVar2, dVar3);
        }

        @Override // sdk.pendo.io.v4.d
        public d b(d dVar, d dVar2, d dVar3) {
            f fVar = this.j;
            f fVar2 = ((c) dVar).j;
            f fVar3 = ((c) dVar2).j;
            f fVar4 = ((c) dVar3).j;
            f b = fVar.b(fVar2, this.h, this.i);
            f b2 = fVar3.b(fVar4, this.h, this.i);
            if (b == fVar || b == fVar2) {
                b = (f) b.clone();
            }
            b.a(b2, 0);
            b.c(this.h, this.i);
            return new c(this.h, this.i, b);
        }

        @Override // sdk.pendo.io.v4.d
        public d a(d dVar, d dVar2) {
            f fVar = this.j;
            f fVar2 = ((c) dVar).j;
            f fVar3 = ((c) dVar2).j;
            f d = fVar.d(this.h, this.i);
            f b = fVar2.b(fVar3, this.h, this.i);
            if (d == fVar) {
                d = (f) d.clone();
            }
            d.a(b, 0);
            d.c(this.h, this.i);
            return new c(this.h, this.i, d);
        }

        @Override // sdk.pendo.io.v4.d
        public d a(int i) {
            if (i < 1) {
                return this;
            }
            int i2 = this.h;
            int[] iArr = this.i;
            return new c(i2, iArr, this.j.a(i, i2, iArr));
        }
    }

    /* renamed from: sdk.pendo.io.v4.d$d, reason: collision with other inner class name */
    public static class C0249d extends b {
        BigInteger g;
        BigInteger h;
        BigInteger i;

        C0249d(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            if (bigInteger3 == null || bigInteger3.signum() < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("x value invalid in Fp field element");
            }
            this.g = bigInteger;
            this.h = bigInteger2;
            this.i = bigInteger3;
        }

        private d e(d dVar) {
            if (dVar.j().equals(this)) {
                return dVar;
            }
            return null;
        }

        @Override // sdk.pendo.io.v4.d
        public d a(d dVar) {
            return new C0249d(this.g, this.h, a(this.i, dVar.l()));
        }

        @Override // sdk.pendo.io.v4.d
        public d b(d dVar) {
            return new C0249d(this.g, this.h, b(this.i, d(dVar.l())));
        }

        protected BigInteger c(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.g.subtract(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        @Override // sdk.pendo.io.v4.d
        public int d() {
            return this.g.bitLength();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0249d)) {
                return false;
            }
            C0249d c0249d = (C0249d) obj;
            return this.g.equals(c0249d.g) && this.i.equals(c0249d.i);
        }

        @Override // sdk.pendo.io.v4.d
        public d h() {
            if (this.i.signum() == 0) {
                return this;
            }
            BigInteger bigInteger = this.g;
            return new C0249d(bigInteger, this.h, bigInteger.subtract(this.i));
        }

        public int hashCode() {
            return this.g.hashCode() ^ this.i.hashCode();
        }

        @Override // sdk.pendo.io.v4.d
        public d i() {
            if (g() || f()) {
                return this;
            }
            if (!this.g.testBit(0)) {
                throw new RuntimeException("not done yet");
            }
            if (this.g.testBit(1)) {
                BigInteger add = this.g.shiftRight(2).add(sdk.pendo.io.v4.b.b);
                BigInteger bigInteger = this.g;
                return e(new C0249d(bigInteger, this.h, this.i.modPow(add, bigInteger)));
            }
            if (this.g.testBit(2)) {
                BigInteger modPow = this.i.modPow(this.g.shiftRight(3), this.g);
                BigInteger b = b(modPow, this.i);
                if (b(b, modPow).equals(sdk.pendo.io.v4.b.b)) {
                    return e(new C0249d(this.g, this.h, b));
                }
                return e(new C0249d(this.g, this.h, b(b, sdk.pendo.io.v4.b.c.modPow(this.g.shiftRight(2), this.g))));
            }
            BigInteger shiftRight = this.g.shiftRight(1);
            BigInteger modPow2 = this.i.modPow(shiftRight, this.g);
            BigInteger bigInteger2 = sdk.pendo.io.v4.b.b;
            if (!modPow2.equals(bigInteger2)) {
                return null;
            }
            BigInteger bigInteger3 = this.i;
            BigInteger b2 = b(b(bigInteger3));
            BigInteger add2 = shiftRight.add(bigInteger2);
            BigInteger subtract = this.g.subtract(bigInteger2);
            Random random = new Random();
            while (true) {
                BigInteger bigInteger4 = new BigInteger(this.g.bitLength(), random);
                if (bigInteger4.compareTo(this.g) < 0 && e(bigInteger4.multiply(bigInteger4).subtract(b2)).modPow(shiftRight, this.g).equals(subtract)) {
                    BigInteger[] a2 = a(bigInteger4, bigInteger3, add2);
                    BigInteger bigInteger5 = a2[0];
                    BigInteger bigInteger6 = a2[1];
                    if (b(bigInteger6, bigInteger6).equals(b2)) {
                        return new C0249d(this.g, this.h, c(bigInteger6));
                    }
                    if (!bigInteger5.equals(sdk.pendo.io.v4.b.b) && !bigInteger5.equals(subtract)) {
                        return null;
                    }
                }
            }
        }

        @Override // sdk.pendo.io.v4.d
        public d j() {
            BigInteger bigInteger = this.g;
            BigInteger bigInteger2 = this.h;
            BigInteger bigInteger3 = this.i;
            return new C0249d(bigInteger, bigInteger2, b(bigInteger3, bigInteger3));
        }

        @Override // sdk.pendo.io.v4.d
        public BigInteger l() {
            return this.i;
        }

        @Override // sdk.pendo.io.v4.d
        public d a() {
            BigInteger add = this.i.add(sdk.pendo.io.v4.b.b);
            if (add.compareTo(this.g) == 0) {
                add = sdk.pendo.io.v4.b.f1678a;
            }
            return new C0249d(this.g, this.h, add);
        }

        protected BigInteger b(BigInteger bigInteger) {
            BigInteger shiftLeft = bigInteger.shiftLeft(1);
            return shiftLeft.compareTo(this.g) >= 0 ? shiftLeft.subtract(this.g) : shiftLeft;
        }

        protected BigInteger c(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger subtract = bigInteger.subtract(bigInteger2);
            return subtract.signum() < 0 ? subtract.add(this.g) : subtract;
        }

        protected BigInteger d(BigInteger bigInteger) {
            return sdk.pendo.io.d5.b.a(this.g, bigInteger);
        }

        @Override // sdk.pendo.io.v4.d
        public d e() {
            return new C0249d(this.g, this.h, d(this.i));
        }

        static BigInteger a(BigInteger bigInteger) {
            int bitLength = bigInteger.bitLength();
            if (bitLength < 96 || bigInteger.shiftRight(bitLength - 64).longValue() != -1) {
                return null;
            }
            return sdk.pendo.io.v4.b.b.shiftLeft(bitLength).subtract(bigInteger);
        }

        protected BigInteger b(BigInteger bigInteger, BigInteger bigInteger2) {
            return e(bigInteger.multiply(bigInteger2));
        }

        @Override // sdk.pendo.io.v4.d
        public d c(d dVar) {
            return new C0249d(this.g, this.h, b(this.i, dVar.l()));
        }

        @Override // sdk.pendo.io.v4.d
        public d d(d dVar) {
            return new C0249d(this.g, this.h, c(this.i, dVar.l()));
        }

        protected BigInteger e(BigInteger bigInteger) {
            if (this.h == null) {
                return bigInteger.mod(this.g);
            }
            boolean z = bigInteger.signum() < 0;
            if (z) {
                bigInteger = bigInteger.abs();
            }
            int bitLength = this.g.bitLength();
            boolean equals = this.h.equals(sdk.pendo.io.v4.b.b);
            while (bigInteger.bitLength() > bitLength + 1) {
                BigInteger shiftRight = bigInteger.shiftRight(bitLength);
                BigInteger subtract = bigInteger.subtract(shiftRight.shiftLeft(bitLength));
                if (!equals) {
                    shiftRight = shiftRight.multiply(this.h);
                }
                bigInteger = shiftRight.add(subtract);
            }
            while (bigInteger.compareTo(this.g) >= 0) {
                bigInteger = bigInteger.subtract(this.g);
            }
            return (!z || bigInteger.signum() == 0) ? bigInteger : this.g.subtract(bigInteger);
        }

        private BigInteger[] a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            int bitLength = bigInteger3.bitLength();
            int lowestSetBit = bigInteger3.getLowestSetBit();
            BigInteger bigInteger4 = sdk.pendo.io.v4.b.b;
            BigInteger bigInteger5 = bigInteger;
            BigInteger bigInteger6 = bigInteger4;
            BigInteger bigInteger7 = sdk.pendo.io.v4.b.c;
            BigInteger bigInteger8 = bigInteger6;
            for (int i = bitLength - 1; i >= lowestSetBit + 1; i--) {
                bigInteger8 = b(bigInteger8, bigInteger6);
                if (bigInteger3.testBit(i)) {
                    bigInteger6 = b(bigInteger8, bigInteger2);
                    bigInteger4 = b(bigInteger4, bigInteger5);
                    bigInteger7 = e(bigInteger5.multiply(bigInteger7).subtract(bigInteger.multiply(bigInteger8)));
                    bigInteger5 = e(bigInteger5.multiply(bigInteger5).subtract(bigInteger6.shiftLeft(1)));
                } else {
                    bigInteger4 = e(bigInteger4.multiply(bigInteger7).subtract(bigInteger8));
                    BigInteger e = e(bigInteger5.multiply(bigInteger7).subtract(bigInteger.multiply(bigInteger8)));
                    bigInteger7 = e(bigInteger7.multiply(bigInteger7).subtract(bigInteger8.shiftLeft(1)));
                    bigInteger5 = e;
                    bigInteger6 = bigInteger8;
                }
            }
            BigInteger b = b(bigInteger8, bigInteger6);
            BigInteger b2 = b(b, bigInteger2);
            BigInteger e2 = e(bigInteger4.multiply(bigInteger7).subtract(b));
            BigInteger e3 = e(bigInteger5.multiply(bigInteger7).subtract(bigInteger.multiply(b)));
            BigInteger b3 = b(b, b2);
            for (int i2 = 1; i2 <= lowestSetBit; i2++) {
                e2 = b(e2, e3);
                e3 = e(e3.multiply(e3).subtract(b3.shiftLeft(1)));
                b3 = b(b3, b3);
            }
            return new BigInteger[]{e2, e3};
        }

        @Override // sdk.pendo.io.v4.d
        public d b(d dVar, d dVar2, d dVar3) {
            BigInteger bigInteger = this.i;
            BigInteger l = dVar.l();
            BigInteger l2 = dVar2.l();
            BigInteger l3 = dVar3.l();
            return new C0249d(this.g, this.h, e(bigInteger.multiply(l).add(l2.multiply(l3))));
        }

        protected BigInteger a(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger add = bigInteger.add(bigInteger2);
            return add.compareTo(this.g) >= 0 ? add.subtract(this.g) : add;
        }

        @Override // sdk.pendo.io.v4.d
        public d a(d dVar, d dVar2, d dVar3) {
            BigInteger bigInteger = this.i;
            BigInteger l = dVar.l();
            BigInteger l2 = dVar2.l();
            BigInteger l3 = dVar3.l();
            return new C0249d(this.g, this.h, e(bigInteger.multiply(l).subtract(l2.multiply(l3))));
        }

        @Override // sdk.pendo.io.v4.d
        public d a(d dVar, d dVar2) {
            BigInteger bigInteger = this.i;
            BigInteger l = dVar.l();
            BigInteger l2 = dVar2.l();
            return new C0249d(this.g, this.h, e(bigInteger.multiply(bigInteger).add(l.multiply(l2))));
        }
    }

    public abstract d a();

    public abstract d a(d dVar);

    public d a(d dVar, d dVar2, d dVar3) {
        return c(dVar).d(dVar2.c(dVar3));
    }

    public int b() {
        return l().bitLength();
    }

    public abstract d b(d dVar);

    public abstract d c(d dVar);

    public byte[] c() {
        return sdk.pendo.io.d5.b.a((d() + 7) / 8, l());
    }

    public abstract int d();

    public abstract d d(d dVar);

    public abstract d e();

    public boolean f() {
        return b() == 1;
    }

    public boolean g() {
        return l().signum() == 0;
    }

    public abstract d h();

    public abstract d i();

    public abstract d j();

    public boolean k() {
        return l().testBit(0);
    }

    public abstract BigInteger l();

    public String toString() {
        return l().toString(16);
    }

    public d a(d dVar, d dVar2) {
        return j().a(dVar.c(dVar2));
    }

    public d b(d dVar, d dVar2, d dVar3) {
        return c(dVar).a(dVar2.c(dVar3));
    }

    public d a(int i) {
        d dVar = this;
        for (int i2 = 0; i2 < i; i2++) {
            dVar = dVar.j();
        }
        return dVar;
    }
}
