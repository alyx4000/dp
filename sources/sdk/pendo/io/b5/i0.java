package sdk.pendo.io.b5;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes6.dex */
public class i0 implements sdk.pendo.io.a5.g {

    /* renamed from: a, reason: collision with root package name */
    private final int f911a;
    private final Cipher b;
    private final String c;
    private final int d;
    private SecretKey e;

    public i0(Cipher cipher, String str, int i, boolean z) {
        this.b = cipher;
        this.c = str;
        this.d = i;
        this.f911a = z ? 1 : 2;
    }

    @Override // sdk.pendo.io.a5.g
    public int a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = 0;
        while (i2 > 32768) {
            try {
                i4 += this.b.update(bArr, i, 32768, bArr2, i3 + i4);
                i += 32768;
                i2 -= 32768;
            } catch (GeneralSecurityException e) {
                throw c.b(e.getMessage(), e);
            }
        }
        int update = i4 + this.b.update(bArr, i, i2, bArr2, i3 + i4);
        return update + this.b.doFinal(bArr2, i3 + update);
    }

    @Override // sdk.pendo.io.a5.g
    public void b(byte[] bArr, int i, int i2) {
        try {
            this.b.init(this.f911a, this.e, new IvParameterSpec(bArr, i, i2), (SecureRandom) null);
        } catch (GeneralSecurityException e) {
            throw c.b(e.getMessage(), e);
        }
    }

    @Override // sdk.pendo.io.a5.g
    public int a() {
        return this.b.getBlockSize();
    }

    @Override // sdk.pendo.io.a5.g
    public void a(byte[] bArr, int i, int i2) {
        if (this.d != i2) {
            throw new IllegalStateException();
        }
        this.e = new SecretKeySpec(bArr, i, i2, this.c);
    }
}
