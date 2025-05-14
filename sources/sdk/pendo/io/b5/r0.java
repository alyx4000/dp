package sdk.pendo.io.b5;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
public class r0 extends sdk.pendo.io.a5.b {
    private static final byte[] c = f();
    protected final h b;

    public r0(h hVar, byte[] bArr) {
        super(bArr);
        this.b = hVar;
    }

    public static r0 a(h hVar, sdk.pendo.io.z4.b0 b0Var) {
        if (b0Var instanceof r0) {
            return (r0) b0Var;
        }
        if (b0Var instanceof sdk.pendo.io.a5.b) {
            return hVar.d(sdk.pendo.io.a5.b.a((sdk.pendo.io.a5.b) b0Var));
        }
        throw new IllegalArgumentException("unrecognized TlsSecret - cannot copy data: " + b0Var.getClass().getName());
    }

    private static byte[] f() {
        byte[] bArr = new byte[120];
        int i = 0;
        for (int i2 = 0; i2 < 15; i2++) {
            byte b = (byte) (i2 + 65);
            int i3 = 0;
            while (i3 <= i2) {
                bArr[i] = b;
                i3++;
                i++;
            }
        }
        return bArr;
    }

    protected byte[] b(int i, String str, byte[] bArr, int i2) {
        if (i == 0) {
            return b(bArr, i2);
        }
        byte[] c2 = sdk.pendo.io.d5.a.c(sdk.pendo.io.d5.i.a(str), bArr);
        return 1 == i ? a(c2, i2) : b(i, c2, i2);
    }

    @Override // sdk.pendo.io.a5.b
    protected sdk.pendo.io.a5.a e() {
        return this.b;
    }

    @Override // sdk.pendo.io.z4.b0
    public synchronized sdk.pendo.io.z4.b0 a(int i, String str, byte[] bArr, int i2) {
        c();
        try {
            if (i == 4) {
                return sdk.pendo.io.z4.k.a(this, 4, str, bArr, i2);
            }
            if (i == 5) {
                return sdk.pendo.io.z4.k.a(this, 5, str, bArr, i2);
            }
            if (i != 7) {
                return this.b.d(b(i, str, bArr, i2));
            }
            return sdk.pendo.io.z4.k.a(this, 7, str, bArr, i2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected byte[] b(int i, byte[] bArr, int i2) {
        String replaceAll = this.b.i(sdk.pendo.io.z4.k.b(i)).replaceAll("-", "");
        byte[] bArr2 = new byte[i2];
        byte[] bArr3 = this.f849a;
        a(replaceAll, bArr3, 0, bArr3.length, bArr, bArr2);
        return bArr2;
    }

    @Override // sdk.pendo.io.z4.b0
    public synchronized sdk.pendo.io.z4.b0 a(int i, byte[] bArr, int i2) {
        if (i2 < 1) {
            return this.b.d(l3.e);
        }
        int d = sdk.pendo.io.z4.k.d(i);
        if (i2 > d * 255) {
            throw new IllegalArgumentException("'length' must be <= 255 * (output size of 'hashAlgorithm')");
        }
        c();
        byte[] bArr2 = this.f849a;
        try {
            String j = this.b.j(i);
            Mac b = this.b.g().b(j);
            b.init(new SecretKeySpec(bArr2, 0, bArr2.length, j));
            byte[] bArr3 = new byte[i2];
            byte[] bArr4 = new byte[d];
            int i3 = 0;
            byte b2 = 0;
            while (true) {
                b.update(bArr, 0, bArr.length);
                b2 = (byte) (b2 + 1);
                b.update(b2);
                b.doFinal(bArr4, 0);
                int i4 = i2 - i3;
                if (i4 <= d) {
                    System.arraycopy(bArr4, 0, bArr3, i3, i4);
                    return this.b.d(bArr3);
                }
                System.arraycopy(bArr4, 0, bArr3, i3, d);
                i3 += d;
                b.update(bArr4, 0, d);
            }
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    protected byte[] b(byte[] bArr, int i) {
        MessageDigest h = this.b.g().h(MessageDigestAlgorithms.MD5);
        MessageDigest h2 = this.b.g().h("SHA-1");
        int digestLength = h.getDigestLength();
        int digestLength2 = h2.getDigestLength();
        byte[] bArr2 = new byte[Math.max(digestLength, digestLength2)];
        byte[] bArr3 = new byte[i];
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            h2.update(c, i4, i2);
            int i5 = i2 + 1;
            i4 += i2;
            byte[] bArr4 = this.f849a;
            h2.update(bArr4, 0, bArr4.length);
            h2.update(bArr, 0, bArr.length);
            h2.digest(bArr2, 0, digestLength2);
            byte[] bArr5 = this.f849a;
            h.update(bArr5, 0, bArr5.length);
            h.update(bArr2, 0, digestLength2);
            int i6 = i - i3;
            if (i6 < digestLength) {
                h.digest(bArr2, 0, digestLength);
                System.arraycopy(bArr2, 0, bArr3, i3, i6);
                i3 += i6;
            } else {
                h.digest(bArr3, i3, digestLength);
                i3 += digestLength;
            }
            i2 = i5;
        }
        return bArr3;
    }

    @Override // sdk.pendo.io.z4.b0
    public synchronized sdk.pendo.io.z4.b0 a(int i, sdk.pendo.io.z4.b0 b0Var) {
        Mac b;
        c();
        byte[] bArr = this.f849a;
        this.f849a = null;
        try {
            String j = this.b.j(i);
            b = this.b.g().b(j);
            b.init(new SecretKeySpec(bArr, 0, bArr.length, j));
            a(this.b, b0Var).a(b);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
        return this.b.d(b.doFinal());
    }

    protected void a(String str, byte[] bArr, int i, int i2, byte[] bArr2, byte[] bArr3) {
        String str2 = "Hmac" + str;
        Mac b = this.b.g().b(str2);
        b.init(new SecretKeySpec(bArr, i, i2, str2));
        int macLength = b.getMacLength();
        byte[] bArr4 = new byte[macLength];
        byte[] bArr5 = new byte[macLength];
        int i3 = 0;
        byte[] bArr6 = bArr2;
        while (i3 < bArr3.length) {
            b.update(bArr6, 0, bArr6.length);
            b.doFinal(bArr4, 0);
            b.update(bArr4, 0, macLength);
            b.update(bArr2, 0, bArr2.length);
            b.doFinal(bArr5, 0);
            System.arraycopy(bArr5, 0, bArr3, i3, Math.min(macLength, bArr3.length - i3));
            i3 += macLength;
            bArr6 = bArr4;
        }
    }

    protected byte[] a(byte[] bArr, int i) {
        byte[] bArr2 = this.f849a;
        int length = (bArr2.length + 1) / 2;
        byte[] bArr3 = new byte[i];
        a(MessageDigestAlgorithms.MD5, bArr2, 0, length, bArr, bArr3);
        byte[] bArr4 = new byte[i];
        byte[] bArr5 = this.f849a;
        a("SHA1", bArr5, bArr5.length - length, length, bArr, bArr4);
        for (int i2 = 0; i2 < i; i2++) {
            bArr3[i2] = (byte) (bArr3[i2] ^ bArr4[i2]);
        }
        return bArr3;
    }

    protected synchronized void a(Mac mac) {
        c();
        byte[] bArr = this.f849a;
        mac.update(bArr, 0, bArr.length);
    }
}
