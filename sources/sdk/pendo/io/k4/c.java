package sdk.pendo.io.k4;

import java.util.Hashtable;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import sdk.pendo.io.d5.d;

/* loaded from: classes6.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    static final Hashtable f1291a;

    static {
        Hashtable hashtable = new Hashtable();
        f1291a = hashtable;
        hashtable.put("SHA-1", d.b(128));
        hashtable.put(McElieceCCA2KeyGenParameterSpec.SHA224, d.b(192));
        hashtable.put("SHA-256", d.b(256));
        hashtable.put("SHA-384", d.b(256));
        hashtable.put("SHA-512", d.b(256));
        hashtable.put("SHA-512/224", d.b(192));
        hashtable.put(SPHINCSKeyParameters.SHA512_256, d.b(256));
    }

    static int a(sdk.pendo.io.g4.c cVar) {
        return ((Integer) f1291a.get(cVar.a())).intValue();
    }

    static byte[] a(sdk.pendo.io.g4.c cVar, byte[] bArr, int i) {
        int i2 = (i + 7) / 8;
        byte[] bArr2 = new byte[i2];
        int b = i2 / cVar.b();
        int b2 = cVar.b();
        byte[] bArr3 = new byte[b2];
        int i3 = 1;
        int i4 = 0;
        for (int i5 = 0; i5 <= b; i5++) {
            cVar.a((byte) i3);
            cVar.a((byte) (i >> 24));
            cVar.a((byte) (i >> 16));
            cVar.a((byte) (i >> 8));
            cVar.a((byte) i);
            cVar.b(bArr, 0, bArr.length);
            cVar.a(bArr3, 0);
            int i6 = i5 * b2;
            int i7 = i2 - i6;
            if (i7 > b2) {
                i7 = b2;
            }
            System.arraycopy(bArr3, 0, bArr2, i6, i7);
            i3++;
        }
        int i8 = i % 8;
        if (i8 != 0) {
            int i9 = 8 - i8;
            int i10 = 0;
            while (i4 != i2) {
                int i11 = bArr2[i4] & 255;
                bArr2[i4] = (byte) ((i10 << (8 - i9)) | (i11 >>> i9));
                i4++;
                i10 = i11;
            }
        }
        return bArr2;
    }
}
