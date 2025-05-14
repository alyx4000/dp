package sdk.pendo.io.m3;

import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1Encoding;

/* loaded from: classes6.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private OutputStream f1396a;

    y(OutputStream outputStream) {
        this.f1396a = outputStream;
    }

    static int a(int i) {
        if (i < 128) {
            return 1;
        }
        int i2 = 2;
        while (true) {
            i >>>= 8;
            if (i == 0) {
                return i2;
            }
            i2++;
        }
    }

    public static y a(OutputStream outputStream) {
        return new y(outputStream);
    }

    static int b(int i) {
        if (i < 31) {
            return 1;
        }
        int i2 = 2;
        while (true) {
            i >>>= 7;
            if (i == 0) {
                return i2;
            }
            i2++;
        }
    }

    void a() {
    }

    u1 b() {
        return new u1(this.f1396a);
    }

    j2 c() {
        return new j2(this.f1396a);
    }

    final void d(int i) {
        if (i < 128) {
            c(i);
            return;
        }
        int i2 = 5;
        byte[] bArr = new byte[5];
        do {
            i2--;
            bArr[i2] = (byte) i;
            i >>>= 8;
        } while (i != 0);
        int i3 = 5 - i2;
        int i4 = i2 - 1;
        bArr[i4] = (byte) (i3 | 128);
        a(bArr, i4, i3 + 1);
    }

    public static y a(OutputStream outputStream, String str) {
        return str.equals(ASN1Encoding.DER) ? new u1(outputStream) : str.equals(ASN1Encoding.DL) ? new j2(outputStream) : new y(outputStream);
    }

    final void c(int i) {
        this.f1396a.write(i);
    }

    final void b(boolean z, int i) {
        if (z) {
            c(i);
        }
    }

    static int a(boolean z, int i) {
        return (z ? 1 : 0) + a(i) + i;
    }

    final void a(byte[] bArr, int i, int i2) {
        this.f1396a.write(bArr, i, i2);
    }

    void a(g[] gVarArr) {
        for (g gVar : gVarArr) {
            gVar.b().a(this, true);
        }
    }

    final void a(boolean z, int i, byte b) {
        b(z, i);
        d(1);
        c(b);
    }

    final void a(boolean z, int i, byte b, byte[] bArr, int i2, int i3) {
        b(z, i);
        d(i3 + 1);
        c(b);
        a(bArr, i2, i3);
    }

    final void a(boolean z, int i, byte[] bArr) {
        b(z, i);
        d(bArr.length);
        a(bArr, 0, bArr.length);
    }

    final void a(boolean z, int i, byte[] bArr, int i2, int i3) {
        b(z, i);
        d(i3);
        a(bArr, i2, i3);
    }

    final void a(boolean z, int i, byte[] bArr, int i2, int i3, byte b) {
        b(z, i);
        d(i3 + 1);
        a(bArr, i2, i3);
        c(b);
    }

    final void a(boolean z, int i, g[] gVarArr) {
        b(z, i);
        c(128);
        a(gVarArr);
        c(0);
        c(0);
    }

    final void a(boolean z, int i, int i2) {
        if (z) {
            if (i2 < 31) {
                c(i | i2);
                return;
            }
            byte[] bArr = new byte[6];
            int i3 = 5;
            bArr[5] = (byte) (i2 & 127);
            while (i2 > 127) {
                i2 >>>= 7;
                i3--;
                bArr[i3] = (byte) ((i2 & 127) | 128);
            }
            int i4 = i3 - 1;
            bArr[i4] = (byte) (31 | i);
            a(bArr, i4, 6 - i4);
        }
    }

    void a(a0 a0Var, boolean z) {
        a0Var.a(this, z);
    }

    void a(a0[] a0VarArr) {
        for (a0 a0Var : a0VarArr) {
            a0Var.a(this, true);
        }
    }
}
