package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public abstract class n0 extends a0 implements g0 {
    final byte[] f;
    static final o0 s = new a(n0.class, 28);
    private static final char[] A = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    static class a extends o0 {
        a(Class cls, int i) {
            super(cls, i);
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(s1 s1Var) {
            return n0.b(s1Var.k());
        }
    }

    n0(byte[] bArr, boolean z) {
        this.f = z ? sdk.pendo.io.d5.a.a(bArr) : bArr;
    }

    static n0 b(byte[] bArr) {
        return new b2(bArr, false);
    }

    @Override // sdk.pendo.io.m3.a0
    final boolean a(a0 a0Var) {
        if (a0Var instanceof n0) {
            return sdk.pendo.io.d5.a.a(this.f, ((n0) a0Var).f);
        }
        return false;
    }

    @Override // sdk.pendo.io.m3.g0
    public final String c() {
        int length = this.f.length;
        StringBuffer stringBuffer = new StringBuffer(((y.a(length) + length) * 2) + 3);
        stringBuffer.append("#1C");
        b(stringBuffer, length);
        for (int i = 0; i < length; i++) {
            a(stringBuffer, this.f[i]);
        }
        return stringBuffer.toString();
    }

    @Override // sdk.pendo.io.m3.a0
    final boolean h() {
        return false;
    }

    @Override // sdk.pendo.io.m3.a0, sdk.pendo.io.m3.t
    public final int hashCode() {
        return sdk.pendo.io.d5.a.b(this.f);
    }

    public String toString() {
        return c();
    }

    private static void b(StringBuffer stringBuffer, int i) {
        if (i < 128) {
            a(stringBuffer, i);
            return;
        }
        byte[] bArr = new byte[5];
        int i2 = 5;
        do {
            i2--;
            bArr[i2] = (byte) i;
            i >>>= 8;
        } while (i != 0);
        int i3 = 5 - i2;
        int i4 = i2 - 1;
        bArr[i4] = (byte) (i3 | 128);
        while (true) {
            int i5 = i4 + 1;
            a(stringBuffer, bArr[i4]);
            if (i5 >= 5) {
                return;
            } else {
                i4 = i5;
            }
        }
    }

    @Override // sdk.pendo.io.m3.a0
    final void a(y yVar, boolean z) {
        yVar.a(z, 28, this.f);
    }

    private static void a(StringBuffer stringBuffer, int i) {
        char[] cArr = A;
        stringBuffer.append(cArr[(i >>> 4) & 15]);
        stringBuffer.append(cArr[i & 15]);
    }

    @Override // sdk.pendo.io.m3.a0
    final int a(boolean z) {
        return y.a(z, this.f.length);
    }
}
