package sdk.pendo.io.a5;

import kotlin.UByte;
import sdk.pendo.io.y4.a1;
import sdk.pendo.io.y4.h2;
import sdk.pendo.io.y4.l3;
import sdk.pendo.io.y4.v0;
import sdk.pendo.io.z4.n;
import sdk.pendo.io.z4.q;
import sdk.pendo.io.z4.s;

/* loaded from: classes6.dex */
public class f implements sdk.pendo.io.z4.g {

    /* renamed from: a, reason: collision with root package name */
    protected final sdk.pendo.io.z4.j f852a;
    protected final byte[] b;
    protected final boolean c;
    protected final boolean d;
    protected final boolean e;
    protected final boolean f;
    protected final g g;
    protected final g h;
    protected final k i;
    protected final k j;

    public f(sdk.pendo.io.z4.j jVar, g gVar, g gVar2, s sVar, s sVar2, int i) {
        j jVar2;
        a1 d = jVar.d();
        v0 s = d.s();
        if (h.c(s)) {
            throw new h2((short) 80);
        }
        this.f852a = jVar;
        this.b = jVar.a().a(256);
        boolean L = d.L();
        this.c = L;
        boolean a2 = h.a(s);
        this.d = a2;
        boolean z = true;
        this.e = !s.g();
        if (!d.N() || !v0.d.d(s) || (!L && d.Q())) {
            z = false;
        }
        this.f = z;
        this.h = gVar;
        this.g = gVar2;
        if (jVar.f()) {
            gVar2 = gVar;
            gVar = gVar2;
        }
        int c = (i * 2) + sVar.c() + sVar2.c();
        c = a2 ? c : c + gVar.a() + gVar2.a();
        byte[] a3 = h.a(jVar, c);
        sVar.a(a3, 0, sVar.c());
        int c2 = sVar.c() + 0;
        sVar2.a(a3, c2, sVar2.c());
        int c3 = c2 + sVar2.c();
        gVar.a(a3, c3, i);
        int i2 = c3 + i;
        gVar2.a(a3, i2, i);
        int i3 = i2 + i;
        int a4 = gVar.a();
        int a5 = gVar2.a();
        if (a2) {
            gVar.b(new byte[a4], 0, a4);
            gVar2.b(new byte[a5], 0, a5);
        } else {
            gVar.b(a3, i3, a4);
            int i4 = i3 + a4;
            gVar2.b(a3, i4, a5);
            i3 = i4 + a5;
        }
        if (i3 != c) {
            throw new h2((short) 80);
        }
        if (jVar.f()) {
            this.j = new j(jVar, sVar2);
            jVar2 = new j(jVar, sVar);
        } else {
            this.j = new j(jVar, sVar);
            jVar2 = new j(jVar, sVar2);
        }
        this.i = jVar2;
    }

    protected int a(byte[] bArr, int i, int i2, int i3, int i4) {
        byte b;
        int i5;
        int i6 = i + i2;
        byte b2 = bArr[i6 - 1];
        int i7 = (b2 & UByte.MAX_VALUE) + 1;
        if (this.e) {
            i3 = 256;
        }
        if (i7 > Math.min(i3, i2 - i4)) {
            i5 = 0;
            b = 0;
            i7 = 0;
        } else {
            int i8 = i6 - i7;
            b = 0;
            while (true) {
                int i9 = i8 + 1;
                b = (byte) ((bArr[i8] ^ b2) | b);
                if (i9 >= i6) {
                    break;
                }
                i8 = i9;
            }
            i5 = b != 0 ? 0 : i7;
        }
        byte[] bArr2 = this.b;
        while (i7 < 256) {
            b = (byte) (b | (bArr2[i7] ^ b2));
            i7++;
        }
        bArr2[0] = (byte) (bArr2[0] ^ b);
        return i5;
    }

    @Override // sdk.pendo.io.z4.g
    public boolean a() {
        return false;
    }

    @Override // sdk.pendo.io.z4.g
    public int b(int i) {
        int i2;
        int a2 = this.h.a();
        int size = this.j.getSize();
        if (this.c) {
            i2 = i - size;
            size = i2 % a2;
        } else {
            i2 = i - (i % a2);
        }
        int i3 = (i2 - size) - 1;
        return this.d ? i3 - a2 : i3;
    }

    protected int c(int i) {
        return Math.min(d(sdk.pendo.io.d5.f.c(this.f852a.a().a(4), 0)), i);
    }

    protected int d(int i) {
        if (i == 0) {
            return 32;
        }
        int i2 = 0;
        while ((i & 1) == 0) {
            i2++;
            i >>= 1;
        }
        return i2;
    }

    @Override // sdk.pendo.io.z4.g
    public n a(long j, short s, v0 v0Var, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        byte[] bArr2;
        int a2 = this.g.a();
        int size = this.i.getSize();
        int max = this.c ? a2 + size : Math.max(a2, size + 1);
        if (this.d) {
            max += a2;
        }
        if (i2 < max) {
            throw new h2((short) 50);
        }
        boolean z = this.c;
        int i5 = z ? i2 - size : i2;
        if (i5 % a2 != 0) {
            throw new h2((short) 21);
        }
        if (z && (!l3.a(size, this.i.a(j, s, bArr, i, i2 - size), 0, bArr, (i + i2) - size))) {
            throw new h2((short) 20);
        }
        this.g.a(bArr, i, i5, bArr, i);
        if (this.d) {
            i5 -= a2;
            i3 = i + a2;
        } else {
            i3 = i;
        }
        int a3 = a(bArr, i3, i5, a2, this.c ? 0 : size);
        boolean z2 = a3 == 0;
        int i6 = i5 - a3;
        if (this.c) {
            i4 = i3;
            bArr2 = bArr;
        } else {
            i6 -= size;
            i4 = i3;
            bArr2 = bArr;
            z2 |= !l3.a(size, this.i.a(j, s, bArr, i4, i6, i5 - size, this.b), 0, bArr2, i4 + i6);
        }
        if (z2) {
            throw new h2((short) 20);
        }
        return new n(bArr2, i4, i6, s);
    }

    @Override // sdk.pendo.io.z4.g
    public void b() {
        throw new h2((short) 80);
    }

    @Override // sdk.pendo.io.z4.g
    public void c() {
        throw new h2((short) 80);
    }

    @Override // sdk.pendo.io.z4.g
    public q a(long j, short s, v0 v0Var, int i, byte[] bArr, int i2, int i3) {
        byte[] bArr2;
        int i4;
        int i5;
        int a2 = this.h.a();
        int size = this.j.getSize();
        int i6 = a2 - ((!this.c ? i3 + size : i3) % a2);
        if (this.f) {
            i6 += c((256 - i6) / a2) * a2;
        }
        int i7 = size + i3 + i6;
        boolean z = this.d;
        if (z) {
            i7 += a2;
        }
        int i8 = i + i7;
        byte[] bArr3 = new byte[i8];
        if (z) {
            System.arraycopy(this.f852a.a().a(a2), 0, bArr3, i, a2);
            i5 = a2 + i;
            bArr2 = bArr;
            i4 = i2;
        } else {
            bArr2 = bArr;
            i4 = i2;
            i5 = i;
        }
        System.arraycopy(bArr2, i4, bArr3, i5, i3);
        int i9 = i5 + i3;
        if (!this.c) {
            byte[] a3 = this.j.a(j, s, bArr, i2, i3);
            System.arraycopy(a3, 0, bArr3, i9, a3.length);
            i9 += a3.length;
        }
        byte b = (byte) (i6 - 1);
        int i10 = i9;
        int i11 = 0;
        while (i11 < i6) {
            bArr3[i10] = b;
            i11++;
            i10++;
        }
        int i12 = i10 - i;
        this.h.a(bArr3, i, i12, bArr3, i);
        if (this.c) {
            byte[] a4 = this.j.a(j, s, bArr3, i, i12);
            System.arraycopy(a4, 0, bArr3, i10, a4.length);
            i10 += a4.length;
        }
        if (i10 == i8) {
            return new q(bArr3, 0, i8, s);
        }
        throw new h2((short) 80);
    }

    @Override // sdk.pendo.io.z4.g
    public int a(int i) {
        return a(this.g.a(), this.i.getSize(), 256, i);
    }

    @Override // sdk.pendo.io.z4.g
    public int a(int i, int i2) {
        int a2 = this.h.a();
        return a(a2, this.j.getSize(), this.f ? 256 : a2, i);
    }

    protected int a(int i, int i2, int i3, int i4) {
        if (this.d) {
            i4 += i;
        }
        int i5 = i4 + i3;
        if (this.c) {
            return (i5 - (i5 % i)) + i2;
        }
        int i6 = i5 + i2;
        return i6 - (i6 % i);
    }
}
