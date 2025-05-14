package sdk.pendo.io.f4;

import java.math.BigInteger;

/* loaded from: classes6.dex */
public class g {
    public int a(sdk.pendo.io.v4.d dVar) {
        return (dVar.d() + 7) / 8;
    }

    public byte[] a(BigInteger bigInteger, int i) {
        byte[] byteArray = bigInteger.toByteArray();
        if (i < byteArray.length) {
            byte[] bArr = new byte[i];
            System.arraycopy(byteArray, byteArray.length - i, bArr, 0, i);
            return bArr;
        }
        if (i <= byteArray.length) {
            return byteArray;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(byteArray, 0, bArr2, i - byteArray.length, byteArray.length);
        return bArr2;
    }
}
