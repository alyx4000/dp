package sdk.pendo.io.j4;

/* loaded from: classes6.dex */
public class e {
    public static byte[] a(c cVar, int i) {
        byte[] bArr = new byte[i];
        if (i * 8 <= cVar.b()) {
            System.arraycopy(cVar.a(), 0, bArr, 0, i);
        } else {
            int b = cVar.b() / 8;
            for (int i2 = 0; i2 < i; i2 += b) {
                byte[] a2 = cVar.a();
                int i3 = i - i2;
                if (a2.length <= i3) {
                    System.arraycopy(a2, 0, bArr, i2, a2.length);
                } else {
                    System.arraycopy(a2, 0, bArr, i2, i3);
                }
            }
        }
        return bArr;
    }
}
