package sdk.pendo.io.e1;

import java.io.IOException;
import java.math.BigInteger;
import java.security.Key;
import java.security.PublicKey;
import java.security.interfaces.ECKey;
import org.tensorflow.lite.schema.BuiltinOptions;
import sdk.pendo.io.d1.e;

/* loaded from: classes6.dex */
public class b extends sdk.pendo.io.e1.a {
    private final String h;
    private final int i;

    public static class a extends b {
        public a() {
            super("ES256", "SHA256withECDSA", "P-256", 64);
        }
    }

    /* renamed from: sdk.pendo.io.e1.b$b, reason: collision with other inner class name */
    public static class C0116b extends b {
        public C0116b() {
            super("ES384", "SHA384withECDSA", "P-384", 96);
        }
    }

    public static class c extends b {
        public c() {
            super("ES512", "SHA512withECDSA", "P-521", 132);
        }
    }

    public static class d extends b {
        sdk.pendo.io.h7.a j;

        public d() {
            super("ES256K", "SHA256withECDSA", "secp256k1", 64);
            this.j = sdk.pendo.io.h7.b.a(getClass());
        }

        @Override // sdk.pendo.io.e1.a, sdk.pendo.io.a1.a
        public boolean d() {
            if (super.d()) {
                try {
                    return a(a(e.a.a("{\"kty\":\"EC\",\"x\":\"gi0g9DzM2SvjVV7iD_upIU0urmZRjpoIc4Efu8563y8\",\"y\":\"Y5K6GofrdlWNLlfT8-AEyJyVZ3yJJcGgkGroHQCAhmk\",\"crv\":\"secp256k1\",\"d\":\"Vd99BKh6pxt3mXSDJzHuVrCq52xBXAKVahbuFb6dqBc\"}").i(), new sdk.pendo.io.w0.a()), new byte[]{2, 6}) != null;
                } catch (sdk.pendo.io.k1.g e) {
                    this.j.a(c() + " is not available due to " + sdk.pendo.io.k1.b.a(e));
                }
            }
            return false;
        }
    }

    public b(String str, String str2, String str3, int i) {
        super(str, str2, "EC");
        this.h = str3;
        this.i = i;
    }

    public static byte[] a(byte[] bArr, int i) {
        int i2;
        if (bArr.length < 8 || bArr[0] != 48) {
            throw new IOException("Invalid format of ECDSA signature");
        }
        byte b = bArr[1];
        if (b > 0) {
            i2 = 2;
        } else {
            if (b != -127) {
                throw new IOException("Invalid format of ECDSA signature");
            }
            i2 = 3;
        }
        int i3 = bArr[i2 + 1];
        int i4 = i3;
        while (i4 > 0 && bArr[((i2 + 2) + i3) - i4] == 0) {
            i4--;
        }
        int i5 = i2 + 2 + i3;
        int i6 = bArr[i5 + 1];
        int i7 = i6;
        while (i7 > 0 && bArr[((i5 + 2) + i6) - i7] == 0) {
            i7--;
        }
        int max = Math.max(Math.max(i4, i7), i / 2);
        int i8 = bArr[i2 - 1] & 255;
        if (i8 != bArr.length - i2 || i8 != i3 + 2 + 2 + i6 || bArr[i2] != 2 || bArr[i5] != 2) {
            throw new IOException("Invalid format of ECDSA signature");
        }
        int i9 = max * 2;
        byte[] bArr2 = new byte[i9];
        System.arraycopy(bArr, i5 - i4, bArr2, max - i4, i4);
        System.arraycopy(bArr, ((i5 + 2) + i6) - i7, bArr2, i9 - i7, i7);
        return bArr2;
    }

    public static byte[] b(byte[] bArr) {
        int i;
        byte[] bArr2;
        int length = bArr.length / 2;
        int i2 = length;
        while (true) {
            i = 1;
            if (i2 <= 1 || bArr[length - i2] != 0) {
                break;
            }
            i2--;
        }
        int i3 = length - i2;
        int i4 = bArr[i3] < 0 ? i2 + 1 : i2;
        int i5 = length;
        while (i5 > 1 && bArr[(length * 2) - i5] == 0) {
            i5--;
        }
        int i6 = (length * 2) - i5;
        int i7 = bArr[i6] < 0 ? i5 + 1 : i5;
        int i8 = i4 + 2 + 2 + i7;
        if (i8 > 255) {
            throw new IOException("Invalid format of ECDSA signature");
        }
        if (i8 < 128) {
            bArr2 = new byte[i4 + 4 + 2 + i7];
        } else {
            bArr2 = new byte[i4 + 5 + 2 + i7];
            bArr2[1] = -127;
            i = 2;
        }
        bArr2[0] = BuiltinOptions.SliceOptions;
        int i9 = i + 1;
        bArr2[i] = (byte) i8;
        int i10 = i9 + 1;
        bArr2[i9] = 2;
        bArr2[i10] = (byte) i4;
        int i11 = i10 + 1 + i4;
        System.arraycopy(bArr, i3, bArr2, i11 - i2, i2);
        int i12 = i11 + 1;
        bArr2[i11] = 2;
        bArr2[i12] = (byte) i7;
        System.arraycopy(bArr, i6, bArr2, ((i12 + 1) + i7) - i5, i5);
        return bArr2;
    }

    private void d(Key key) {
        if (key instanceof ECKey) {
            String a2 = sdk.pendo.io.i1.e.a(((ECKey) key).getParams().getCurve());
            if (!f().equals(a2)) {
                throw new sdk.pendo.io.k1.f(c() + "/" + e() + " expects a key using " + f() + " but was " + a2);
            }
        }
    }

    public String f() {
        return this.h;
    }

    @Override // sdk.pendo.io.e1.a
    public byte[] a(sdk.pendo.io.a1.g gVar, byte[] bArr) {
        try {
            return a(super.a(gVar, bArr), this.i);
        } catch (IOException e) {
            throw new sdk.pendo.io.k1.g("Unable to convert DER encoding to R and S as a concatenated byte array.", e);
        }
    }

    @Override // sdk.pendo.io.e1.a
    public void a(PublicKey publicKey) {
        d(publicKey);
    }

    @Override // sdk.pendo.io.e1.a, sdk.pendo.io.e1.f
    public boolean a(byte[] bArr, Key key, byte[] bArr2, sdk.pendo.io.w0.a aVar) {
        if (bArr.length > this.i) {
            return false;
        }
        BigInteger a2 = sdk.pendo.io.i1.b.a(sdk.pendo.io.k1.a.c(bArr));
        BigInteger a3 = sdk.pendo.io.i1.b.a(sdk.pendo.io.k1.a.e(bArr));
        BigInteger order = sdk.pendo.io.i1.e.a(this.h).getOrder();
        BigInteger mod = a2.mod(order);
        BigInteger bigInteger = BigInteger.ZERO;
        if (mod.equals(bigInteger) || a3.mod(order).equals(bigInteger)) {
            return false;
        }
        try {
            return super.a(b(bArr), key, bArr2, aVar);
        } catch (IOException e) {
            throw new sdk.pendo.io.k1.g("Unable to convert R and S as a concatenated byte array to DER encoding.", e);
        }
    }
}
