package sdk.pendo.io.k4;

import java.util.Hashtable;
import kotlin.UByte;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import sdk.pendo.io.d5.d;

/* loaded from: classes6.dex */
public class a implements b {
    private static final byte[] h = {1};
    private static final Hashtable i;

    /* renamed from: a, reason: collision with root package name */
    private sdk.pendo.io.g4.c f1290a;
    private byte[] b;
    private byte[] c;
    private long d;
    private sdk.pendo.io.j4.c e;
    private int f;
    private int g;

    static {
        Hashtable hashtable = new Hashtable();
        i = hashtable;
        hashtable.put("SHA-1", d.b(440));
        hashtable.put(McElieceCCA2KeyGenParameterSpec.SHA224, d.b(440));
        hashtable.put("SHA-256", d.b(440));
        hashtable.put(SPHINCSKeyParameters.SHA512_256, d.b(440));
        hashtable.put("SHA-512/224", d.b(440));
        hashtable.put("SHA-384", d.b(888));
        hashtable.put("SHA-512", d.b(888));
    }

    public a(sdk.pendo.io.g4.c cVar, int i2, sdk.pendo.io.j4.c cVar2, byte[] bArr, byte[] bArr2) {
        if (i2 > c.a(cVar)) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        }
        if (cVar2.b() < i2) {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
        this.f1290a = cVar;
        this.e = cVar2;
        this.f = i2;
        this.g = ((Integer) i.get(cVar.a())).intValue();
        byte[] a2 = c.a(this.f1290a, sdk.pendo.io.d5.a.a(a(), bArr2, bArr), this.g);
        this.b = a2;
        byte[] bArr3 = new byte[a2.length + 1];
        System.arraycopy(a2, 0, bArr3, 1, a2.length);
        this.c = c.a(this.f1290a, bArr3, this.g);
        this.d = 1L;
    }

    private void a(byte[] bArr, byte[] bArr2) {
        int i2 = 0;
        for (int i3 = 1; i3 <= bArr2.length; i3++) {
            int i4 = (bArr[bArr.length - i3] & UByte.MAX_VALUE) + (bArr2[bArr2.length - i3] & UByte.MAX_VALUE) + i2;
            i2 = i4 > 255 ? 1 : 0;
            bArr[bArr.length - i3] = (byte) i4;
        }
        for (int length = bArr2.length + 1; length <= bArr.length; length++) {
            int i5 = (bArr[bArr.length - length] & UByte.MAX_VALUE) + i2;
            i2 = i5 > 255 ? 1 : 0;
            bArr[bArr.length - length] = (byte) i5;
        }
    }

    private void b(byte[] bArr, byte[] bArr2) {
        this.f1290a.b(bArr, 0, bArr.length);
        this.f1290a.a(bArr2, 0);
    }

    private byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[this.f1290a.b()];
        b(bArr, bArr2);
        return bArr2;
    }

    @Override // sdk.pendo.io.k4.b
    public int a(byte[] bArr, byte[] bArr2, boolean z) {
        int length = bArr.length * 8;
        if (length > 262144) {
            throw new IllegalArgumentException("Number of bits per request limited to 262144");
        }
        if (this.d > 140737488355328L) {
            return -1;
        }
        if (z) {
            a(bArr2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            byte[] bArr3 = this.b;
            byte[] bArr4 = new byte[bArr3.length + 1 + bArr2.length];
            bArr4[0] = 2;
            System.arraycopy(bArr3, 0, bArr4, 1, bArr3.length);
            System.arraycopy(bArr2, 0, bArr4, this.b.length + 1, bArr2.length);
            a(this.b, b(bArr4));
        }
        byte[] a2 = a(this.b, length);
        byte[] bArr5 = this.b;
        byte[] bArr6 = new byte[bArr5.length + 1];
        System.arraycopy(bArr5, 0, bArr6, 1, bArr5.length);
        bArr6[0] = 3;
        a(this.b, b(bArr6));
        a(this.b, this.c);
        a(this.b, new byte[]{(byte) (r6 >> 24), (byte) (r6 >> 16), (byte) (r6 >> 8), (byte) this.d});
        this.d++;
        System.arraycopy(a2, 0, bArr, 0, bArr.length);
        return length;
    }

    private byte[] a() {
        byte[] a2 = this.e.a();
        if (a2.length >= (this.f + 7) / 8) {
            return a2;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    private byte[] a(byte[] bArr, int i2) {
        int i3 = i2 / 8;
        int b = i3 / this.f1290a.b();
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        byte[] bArr3 = new byte[i3];
        int b2 = this.f1290a.b();
        byte[] bArr4 = new byte[b2];
        for (int i4 = 0; i4 <= b; i4++) {
            b(bArr2, bArr4);
            int i5 = i4 * b2;
            int i6 = i3 - i5;
            if (i6 > b2) {
                i6 = b2;
            }
            System.arraycopy(bArr4, 0, bArr3, i5, i6);
            a(bArr2, h);
        }
        return bArr3;
    }

    @Override // sdk.pendo.io.k4.b
    public void a(byte[] bArr) {
        byte[] a2 = c.a(this.f1290a, sdk.pendo.io.d5.a.a(h, this.b, a(), bArr), this.g);
        this.b = a2;
        byte[] bArr2 = new byte[a2.length + 1];
        bArr2[0] = 0;
        System.arraycopy(a2, 0, bArr2, 1, a2.length);
        this.c = c.a(this.f1290a, bArr2, this.g);
        this.d = 1L;
    }
}
