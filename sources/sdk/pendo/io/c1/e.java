package sdk.pendo.io.c1;

import java.io.ByteArrayOutputStream;
import javax.crypto.Mac;
import org.bouncycastle.asn1.cmc.BodyPartID;
import sdk.pendo.io.i1.f;
import sdk.pendo.io.k1.k;

/* loaded from: classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private String f944a;

    public e(String str) {
        this.f944a = str;
    }

    public byte[] a(byte[] bArr, byte[] bArr2, int i, int i2, String str) {
        Mac a2 = sdk.pendo.io.l1.a.a(this.f944a, new f(bArr), str);
        int macLength = a2.getMacLength();
        if (i2 > BodyPartID.bodyIdMax) {
            throw new k("derived key too long " + i2);
        }
        int ceil = (int) Math.ceil(i2 / macLength);
        int i3 = ceil - 1;
        int i4 = i2 - (macLength * i3);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i5 = 0;
        while (i5 < ceil) {
            int i6 = i5 + 1;
            byte[] a3 = a(bArr2, i, i6, a2);
            if (i5 == i3) {
                a3 = sdk.pendo.io.k1.a.a(a3, 0, i4);
            }
            byteArrayOutputStream.write(a3, 0, a3.length);
            i5 = i6;
        }
        return byteArrayOutputStream.toByteArray();
    }

    byte[] a(byte[] bArr, int i, int i2, Mac mac) {
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        for (int i3 = 1; i3 <= i; i3++) {
            if (i3 == 1) {
                bArr2 = mac.doFinal(sdk.pendo.io.k1.a.a(bArr, sdk.pendo.io.k1.a.c(i2)));
                bArr3 = bArr2;
            } else {
                bArr3 = mac.doFinal(bArr3);
                for (int i4 = 0; i4 < bArr3.length; i4++) {
                    bArr2[i4] = (byte) (bArr3[i4] ^ bArr2[i4]);
                }
            }
        }
        return bArr2;
    }
}
