package sdk.pendo.io.a5;

import com.amplitude.reactnative.DatabaseConstants;
import expo.modules.securestore.encryptors.AESEncryptor;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import sdk.pendo.io.y4.a1;
import sdk.pendo.io.y4.h2;
import sdk.pendo.io.y4.l3;
import sdk.pendo.io.y4.v0;
import sdk.pendo.io.z4.b0;
import sdk.pendo.io.z4.n;
import sdk.pendo.io.z4.q;

/* loaded from: classes6.dex */
public class d implements sdk.pendo.io.z4.g {

    /* renamed from: a, reason: collision with root package name */
    protected final sdk.pendo.io.z4.j f851a;
    protected final int b;
    protected final int c;
    protected final int d;
    protected final int e;
    protected final e f;
    protected final e g;
    protected final byte[] h;
    protected final byte[] i;
    protected final boolean j;
    protected final int k;

    public d(sdk.pendo.io.z4.j jVar, e eVar, e eVar2, int i, int i2, int i3) {
        int i4;
        a1 d = jVar.d();
        v0 s = d.s();
        if (!h.b(s)) {
            throw new h2((short) 80);
        }
        boolean c = h.c(s);
        this.j = c;
        int a2 = a(c, i3);
        this.k = a2;
        if (a2 == 1) {
            this.d = 4;
            this.e = 8;
        } else {
            if (a2 != 2) {
                throw new h2((short) 80);
            }
            this.d = 12;
            this.e = 0;
        }
        this.f851a = jVar;
        this.b = i;
        this.c = i2;
        this.f = eVar2;
        this.g = eVar;
        int i5 = this.d;
        byte[] bArr = new byte[i5];
        this.h = bArr;
        byte[] bArr2 = new byte[i5];
        this.i = bArr2;
        boolean f = jVar.f();
        if (c) {
            a(d, eVar2, bArr, !f);
            a(d, eVar, bArr2, f);
            return;
        }
        int i6 = (i * 2) + (this.d * 2);
        byte[] a3 = h.a(jVar, i6);
        if (f) {
            eVar2.a(a3, 0, i);
            int i7 = i + 0;
            eVar.a(a3, i7, i);
            int i8 = i7 + i;
            System.arraycopy(a3, i8, bArr, 0, this.d);
            int i9 = this.d;
            i4 = i8 + i9;
            System.arraycopy(a3, i4, bArr2, 0, i9);
        } else {
            eVar.a(a3, 0, i);
            int i10 = i + 0;
            eVar2.a(a3, i10, i);
            int i11 = i10 + i;
            System.arraycopy(a3, i11, bArr2, 0, this.d);
            int i12 = this.d;
            i4 = i11 + i12;
            System.arraycopy(a3, i4, bArr, 0, i12);
        }
        if (i6 != i4 + this.d) {
            throw new h2((short) 80);
        }
        byte[] bArr3 = new byte[this.d + this.e];
        bArr3[0] = (byte) (~bArr2[0]);
        bArr3[1] = (byte) (~bArr[1]);
        eVar.a(bArr3, i2, (byte[]) null);
        eVar2.a(bArr3, i2, (byte[]) null);
    }

    @Override // sdk.pendo.io.z4.g
    public n a(long j, short s, v0 v0Var, byte[] bArr, int i, int i2) {
        short s2;
        byte b;
        if (b(i2) < 0) {
            throw new h2((short) 50);
        }
        byte[] bArr2 = this.h;
        int length = bArr2.length + this.e;
        byte[] bArr3 = new byte[length];
        int i3 = this.k;
        int i4 = 0;
        if (i3 == 1) {
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            int i5 = this.e;
            System.arraycopy(bArr, i, bArr3, length - i5, i5);
        } else {
            if (i3 != 2) {
                throw new h2((short) 80);
            }
            l3.a(j, bArr3, length - 8);
            while (true) {
                byte[] bArr4 = this.h;
                if (i4 >= bArr4.length) {
                    break;
                }
                bArr3[i4] = (byte) (bArr4[i4] ^ bArr3[i4]);
                i4++;
            }
        }
        int i6 = this.e;
        int i7 = i + i6;
        int i8 = i2 - i6;
        int a2 = this.f.a(i8);
        try {
            this.f.a(bArr3, this.c, a(j, s, v0Var, i2, a2));
            if (this.f.a(bArr, i7, i8, bArr, i7) != a2) {
                throw new h2((short) 80);
            }
            if (this.j) {
                do {
                    a2--;
                    if (a2 < 0) {
                        throw new h2((short) 10);
                    }
                    b = bArr[i7 + a2];
                } while (b == 0);
                s2 = (short) (b & UByte.MAX_VALUE);
            } else {
                s2 = s;
            }
            return new n(bArr, i7, a2, s2);
        } catch (RuntimeException e) {
            throw new h2((short) 20, (Throwable) e);
        }
    }

    @Override // sdk.pendo.io.z4.g
    public int b(int i) {
        return ((i - this.c) - this.e) - (this.j ? 1 : 0);
    }

    @Override // sdk.pendo.io.z4.g
    public void c() {
        a(this.f851a.c(), this.f, this.h, !this.f851a.f());
    }

    @Override // sdk.pendo.io.z4.g
    public q a(long j, short s, v0 v0Var, int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        byte[] bArr2 = this.i;
        int length = bArr2.length + this.e;
        byte[] bArr3 = new byte[length];
        int i5 = this.k;
        if (i5 == 1) {
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            l3.a(j, bArr3, this.i.length);
        } else {
            if (i5 != 2) {
                throw new h2((short) 80);
            }
            l3.a(j, bArr3, length - 8);
            int i6 = 0;
            while (true) {
                byte[] bArr4 = this.i;
                if (i6 >= bArr4.length) {
                    break;
                }
                bArr3[i6] = (byte) (bArr4[i6] ^ bArr3[i6]);
                i6++;
            }
        }
        boolean z = this.j;
        e eVar = this.g;
        int i7 = i3 + (z ? 1 : 0);
        int a2 = eVar.a(i7);
        int i8 = this.e;
        int i9 = i8 + a2;
        int i10 = i4 + i9;
        byte[] bArr5 = new byte[i10];
        if (i8 != 0) {
            System.arraycopy(bArr3, length - i8, bArr5, i4, i8);
            i4 += this.e;
        }
        short s2 = this.j ? (short) 23 : s;
        short s3 = s2;
        try {
            this.g.a(bArr3, this.c, a(j, s2, v0Var, i9, i3));
            System.arraycopy(bArr, i2, bArr5, i4, i3);
            if (this.j) {
                bArr5[i4 + i3] = (byte) s;
            }
            if (i4 + this.g.a(bArr5, i4, i7, bArr5, i4) == i10) {
                return new q(bArr5, 0, i10, s3);
            }
            throw new h2((short) 80);
        } catch (RuntimeException e) {
            throw new h2((short) 80, (Throwable) e);
        }
    }

    @Override // sdk.pendo.io.z4.g
    public void b() {
        a(this.f851a.c(), this.g, this.i, this.f851a.f());
    }

    protected byte[] a(long j, short s, v0 v0Var, int i, int i2) {
        if (this.j) {
            byte[] bArr = new byte[5];
            l3.a(s, bArr, 0);
            l3.a(v0Var, bArr, 1);
            l3.a(i, bArr, 3);
            return bArr;
        }
        byte[] bArr2 = new byte[13];
        l3.a(j, bArr2, 0);
        l3.a(s, bArr2, 8);
        l3.a(v0Var, bArr2, 9);
        l3.a(i2, bArr2, 11);
        return bArr2;
    }

    @Override // sdk.pendo.io.z4.g
    public int a(int i) {
        return i + this.c + this.e + (this.j ? 1 : 0);
    }

    @Override // sdk.pendo.io.z4.g
    public int a(int i, int i2) {
        if (this.j) {
            i = Math.min(i2, i + 0) + 1;
        }
        return i + this.c + this.e;
    }

    private static int a(boolean z, int i) {
        if (i != 1) {
            if (i == 2) {
                return 2;
            }
            if (i != 3) {
                throw new h2((short) 80);
            }
        }
        return z ? 2 : 1;
    }

    protected void a(a1 a1Var, e eVar, byte[] bArr, boolean z) {
        if (!this.j) {
            throw new h2((short) 80);
        }
        b0 I = z ? a1Var.I() : a1Var.H();
        if (I == null) {
            throw new h2((short) 80);
        }
        a(eVar, bArr, I, a1Var.u());
    }

    protected void a(e eVar, byte[] bArr, b0 b0Var, int i) {
        byte[] bArr2 = l3.e;
        byte[] a2 = sdk.pendo.io.z4.k.a(b0Var, i, DatabaseConstants.KEY_FIELD, bArr2, this.b).a();
        byte[] a3 = sdk.pendo.io.z4.k.a(b0Var, i, AESEncryptor.IV_PROPERTY, bArr2, this.d).a();
        eVar.a(a2, 0, this.b);
        System.arraycopy(a3, 0, bArr, 0, this.d);
        a3[0] = (byte) (a3[0] ^ ByteCompanionObject.MIN_VALUE);
        eVar.a(a3, this.c, (byte[]) null);
    }

    @Override // sdk.pendo.io.z4.g
    public boolean a() {
        return this.j;
    }
}
