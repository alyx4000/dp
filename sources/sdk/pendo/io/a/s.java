package sdk.pendo.io.a;

import kotlin.UByte;
import kotlin.UShort;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;

/* loaded from: classes6.dex */
public class s {
    static final s n = new s();

    /* renamed from: a, reason: collision with root package name */
    short f830a;
    private short b;
    private int[] c;
    int d;
    private int[] e;
    short f;
    short g;
    short h;
    short i;
    p j;
    s k;
    m l;
    s m;

    private s b(s sVar) {
        m mVar = this.l;
        while (mVar != null) {
            if (!((this.f830a & 16) != 0 && mVar == this.l.c)) {
                s sVar2 = mVar.b;
                if (sVar2.m == null) {
                    sVar2.m = sVar;
                    sVar = sVar2;
                }
            }
            mVar = mVar.c;
        }
        return sVar;
    }

    final void a(u uVar, boolean z) {
        short s;
        uVar.a(this);
        if (!z || (s = this.b) == 0) {
            return;
        }
        uVar.b(s & UShort.MAX_VALUE, this);
        if (this.c == null) {
            return;
        }
        int i = 1;
        while (true) {
            int[] iArr = this.c;
            if (i > iArr[0]) {
                return;
            }
            uVar.b(iArr[i], this);
            i++;
        }
    }

    public String toString() {
        return "L" + System.identityHashCode(this);
    }

    private void a(int i, int i2, int i3) {
        if (this.e == null) {
            this.e = new int[6];
        }
        int[] iArr = this.e;
        int i4 = iArr[0];
        if (i4 + 2 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.e = iArr2;
        }
        int[] iArr3 = this.e;
        int i5 = i4 + 1;
        iArr3[i5] = i;
        int i6 = i5 + 1;
        iArr3[i6] = i2 | i3;
        iArr3[0] = i6;
    }

    final void a(int i) {
        if (this.b == 0) {
            this.b = (short) i;
            return;
        }
        if (this.c == null) {
            this.c = new int[4];
        }
        int[] iArr = this.c;
        int i2 = iArr[0] + 1;
        iArr[0] = i2;
        if (i2 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 4];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.c = iArr2;
        }
        this.c[i2] = i;
    }

    final void a(s sVar) {
        s sVar2 = n;
        this.m = sVar2;
        s sVar3 = sVar2;
        s sVar4 = this;
        while (sVar4 != n) {
            s sVar5 = sVar4.m;
            sVar4.m = sVar3;
            if ((sVar4.f830a & 64) != 0 && sVar4.i != sVar.i) {
                sVar4.l = new m(sVar4.g, sVar.l.b, sVar4.l);
            }
            sVar3 = sVar4;
            sVar4 = sVar4.b(sVar5);
        }
        while (sVar3 != n) {
            s sVar6 = sVar3.m;
            sVar3.m = null;
            sVar3 = sVar6;
        }
    }

    final s a() {
        p pVar = this.j;
        return pVar == null ? this : pVar.f827a;
    }

    final void a(short s) {
        this.m = n;
        s sVar = this;
        while (sVar != n) {
            s sVar2 = sVar.m;
            sVar.m = null;
            if (sVar.i == 0) {
                sVar.i = s;
                sVar = sVar.b(sVar2);
            } else {
                sVar = sVar2;
            }
        }
    }

    final void a(d dVar, int i, boolean z) {
        if ((this.f830a & 4) != 0) {
            if (z) {
                dVar.c(this.d - i);
                return;
            } else {
                dVar.d(this.d - i);
                return;
            }
        }
        if (z) {
            a(i, PKIFailureInfo.duplicateCertReq, dVar.b);
            dVar.c(-1);
        } else {
            a(i, 268435456, dVar.b);
            dVar.d(-1);
        }
    }

    final boolean a(byte[] bArr, int i) {
        this.f830a = (short) (this.f830a | 4);
        this.d = i;
        int[] iArr = this.e;
        boolean z = false;
        if (iArr == null) {
            return false;
        }
        for (int i2 = iArr[0]; i2 > 0; i2 -= 2) {
            int[] iArr2 = this.e;
            int i3 = iArr2[i2 - 1];
            int i4 = iArr2[i2];
            int i5 = i - i3;
            int i6 = 268435455 & i4;
            if ((i4 & (-268435456)) == 268435456) {
                if (i5 < -32768 || i5 > 32767) {
                    int i7 = bArr[i3] & UByte.MAX_VALUE;
                    if (i7 < 198) {
                        bArr[i3] = (byte) (i7 + 49);
                    } else {
                        bArr[i3] = (byte) (i7 + 20);
                    }
                    z = true;
                }
                bArr[i6] = (byte) (i5 >>> 8);
                bArr[i6 + 1] = (byte) i5;
            } else {
                int i8 = i6 + 1;
                bArr[i6] = (byte) (i5 >>> 24);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (i5 >>> 16);
                bArr[i9] = (byte) (i5 >>> 8);
                bArr[i9 + 1] = (byte) i5;
            }
        }
        return z;
    }
}
