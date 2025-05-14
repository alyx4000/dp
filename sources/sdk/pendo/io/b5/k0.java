package sdk.pendo.io.b5;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.cmc.BodyPartID;
import sdk.pendo.io.y4.h2;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
public class k0 implements sdk.pendo.io.a5.e {
    private static final byte[] f = new byte[15];

    /* renamed from: a, reason: collision with root package name */
    protected final Cipher f913a;
    protected final Mac b;
    protected final int c;
    protected SecretKey d;
    protected byte[] e;

    public k0(sdk.pendo.io.p4.b bVar, boolean z) {
        this.f913a = bVar.d("ChaCha7539");
        this.b = bVar.b("Poly1305");
        this.c = z ? 1 : 2;
    }

    @Override // sdk.pendo.io.a5.e
    public int a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        try {
            if (this.c == 1) {
                byte[] bArr3 = new byte[i2 + 64];
                System.arraycopy(bArr, i, bArr3, 64, i2);
                b(bArr3);
                System.arraycopy(bArr3, 64, bArr2, i3, i2);
                a(bArr3);
                byte[] bArr4 = this.e;
                b(bArr4, 0, bArr4.length);
                b(bArr3, 64, i2);
                byte[] bArr5 = new byte[16];
                sdk.pendo.io.d5.f.b(this.e.length & BodyPartID.bodyIdMax, bArr5, 0);
                sdk.pendo.io.d5.f.b(i2 & BodyPartID.bodyIdMax, bArr5, 8);
                this.b.update(bArr5, 0, 16);
                this.b.doFinal(bArr2, i3 + i2);
                return i2 + 16;
            }
            int i4 = i2 - 16;
            byte[] bArr6 = new byte[i4 + 64];
            System.arraycopy(bArr, i, bArr6, 64, i4);
            b(bArr6);
            a(bArr6);
            byte[] bArr7 = this.e;
            b(bArr7, 0, bArr7.length);
            b(bArr, i, i4);
            byte[] bArr8 = new byte[16];
            sdk.pendo.io.d5.f.b(this.e.length & BodyPartID.bodyIdMax, bArr8, 0);
            sdk.pendo.io.d5.f.b(BodyPartID.bodyIdMax & i4, bArr8, 8);
            this.b.update(bArr8, 0, 16);
            this.b.doFinal(bArr8, 0);
            if (!l3.a(16, bArr8, 0, bArr, i + i4)) {
                throw new h2((short) 20);
            }
            System.arraycopy(bArr6, 64, bArr2, i3, i4);
            return i4;
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    protected void b(byte[] bArr) {
        if (bArr.length != this.f913a.doFinal(bArr, 0, bArr.length, bArr, 0)) {
            throw new IllegalStateException();
        }
    }

    @Override // sdk.pendo.io.a5.e
    public int a(int i) {
        return this.c == 1 ? i + 16 : i - 16;
    }

    protected void b(byte[] bArr, int i, int i2) {
        this.b.update(bArr, i, i2);
        int i3 = i2 % 16;
        if (i3 != 0) {
            this.b.update(f, 0, 16 - i3);
        }
    }

    @Override // sdk.pendo.io.a5.e
    public void a(byte[] bArr, int i, byte[] bArr2) {
        if (bArr == null || bArr.length != 12 || i != 16) {
            throw new h2((short) 80);
        }
        try {
            this.f913a.init(this.c, this.d, new IvParameterSpec(bArr), (SecureRandom) null);
            this.e = bArr2;
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    protected void a(byte[] bArr) {
        this.b.init(new SecretKeySpec(bArr, 0, 32, "Poly1305"));
        for (int i = 0; i < 64; i++) {
            bArr[i] = 0;
        }
    }

    @Override // sdk.pendo.io.a5.e
    public void a(byte[] bArr, int i, int i2) {
        this.d = new SecretKeySpec(bArr, i, i2, "ChaCha7539");
    }
}
