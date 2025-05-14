package sdk.pendo.io.k1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Arrays;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f1251a = new byte[0];

    public static int a(byte b) {
        return b >= 0 ? b : 256 - (~(b - 1));
    }

    public static int a(int i) {
        if (i > 268435455 || i < 0) {
            throw new k("Invalid byte length (" + i + ") for converting to bit length");
        }
        return i * 8;
    }

    public static int b(int i) {
        return i / 8;
    }

    public static byte[] c(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        return allocate.array();
    }

    public static byte[] d(int i) {
        return a(i, (SecureRandom) null);
    }

    public static byte[] e(byte[] bArr) {
        int length = bArr.length / 2;
        return a(bArr, length, length);
    }

    public static String f(byte[] bArr) {
        String a2 = new sdk.pendo.io.u0.b().a(bArr);
        int[] b = b(bArr);
        return Arrays.toString(b) + "(" + b.length + "bytes/" + a(b.length) + "bits) | base64url encoded: " + a2;
    }

    public static int a(byte[] bArr) {
        return a(bArr.length);
    }

    public static int[] b(byte[] bArr) {
        int[] iArr = new int[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            iArr[i] = a(bArr[i]);
        }
        return iArr;
    }

    public static byte[] c(byte[] bArr) {
        return a(bArr, 0, bArr.length / 2);
    }

    public static byte[] d(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[(length - 1) - i] = bArr[i];
        }
        return bArr2;
    }

    public static byte[] a(byte[]... bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (byte[] bArr2 : bArr) {
                byteArrayOutputStream.write(bArr2);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new IllegalStateException("IOEx from ByteArrayOutputStream?!", e);
        }
    }

    public static byte[] a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.putLong(j);
        return allocate.array();
    }

    public static byte[] a(int i, SecureRandom secureRandom) {
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        byte[] bArr = new byte[i];
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = f1251a;
        }
        if (bArr2 == null) {
            bArr2 = f1251a;
        }
        int min = Math.min(bArr.length, bArr2.length);
        int max = Math.max(bArr.length, bArr2.length);
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            i |= bArr[i2] ^ bArr2[i2];
        }
        return i == 0 && min == max;
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }
}
