package sdk.pendo.io.m3;

import java.math.BigInteger;

/* loaded from: classes6.dex */
public class q extends a0 {
    static final o0 A = new a(q.class, 2);
    private final byte[] f;
    private final int s;

    static class a extends o0 {
        a(Class cls, int i) {
            super(cls, i);
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(s1 s1Var) {
            return q.b(s1Var.k());
        }
    }

    public q(long j) {
        this.f = BigInteger.valueOf(j).toByteArray();
        this.s = 0;
    }

    static q b(byte[] bArr) {
        return new q(bArr, false);
    }

    static boolean c(byte[] bArr) {
        int length = bArr.length;
        if (length == 0) {
            return true;
        }
        if (length != 1) {
            return bArr[0] == (bArr[1] >> 7) && !sdk.pendo.io.d5.g.b("external.sdk.pendo.io.org.bouncycastle.asn1.allow_unsafe_integer");
        }
        return false;
    }

    static int d(byte[] bArr) {
        int length = bArr.length - 1;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            if (bArr[i] != (bArr[i2] >> 7)) {
                break;
            }
            i = i2;
        }
        return i;
    }

    @Override // sdk.pendo.io.m3.a0
    boolean a(a0 a0Var) {
        if (a0Var instanceof q) {
            return sdk.pendo.io.d5.a.a(this.f, ((q) a0Var).f);
        }
        return false;
    }

    @Override // sdk.pendo.io.m3.a0
    boolean h() {
        return false;
    }

    @Override // sdk.pendo.io.m3.a0, sdk.pendo.io.m3.t
    public int hashCode() {
        return sdk.pendo.io.d5.a.b(this.f);
    }

    public BigInteger k() {
        return new BigInteger(1, this.f);
    }

    public BigInteger l() {
        return new BigInteger(this.f);
    }

    public int m() {
        byte[] bArr = this.f;
        int length = bArr.length;
        int i = this.s;
        if (length - i <= 4) {
            return a(bArr, i, -1);
        }
        throw new ArithmeticException("ASN.1 Integer out of int range");
    }

    public String toString() {
        return l().toString();
    }

    public q(BigInteger bigInteger) {
        this.f = bigInteger.toByteArray();
        this.s = 0;
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        yVar.a(z, 2, this.f);
    }

    q(byte[] bArr, boolean z) {
        if (c(bArr)) {
            throw new IllegalArgumentException("malformed integer");
        }
        this.f = z ? sdk.pendo.io.d5.a.a(bArr) : bArr;
        this.s = d(bArr);
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        return y.a(z, this.f.length);
    }

    public static q a(Object obj) {
        if (obj == null || (obj instanceof q)) {
            return (q) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (q) A.a((byte[]) obj);
        } catch (Exception e) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
        }
    }

    public static q a(j0 j0Var, boolean z) {
        return (q) A.a(j0Var, z);
    }

    public boolean a(int i) {
        byte[] bArr = this.f;
        int length = bArr.length;
        int i2 = this.s;
        return length - i2 <= 4 && a(bArr, i2, -1) == i;
    }

    static int a(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        int max = Math.max(i, length - 4);
        int i3 = i2 & bArr[max];
        while (true) {
            max++;
            if (max >= length) {
                return i3;
            }
            i3 = (i3 << 8) | (bArr[max] & 255);
        }
    }
}
