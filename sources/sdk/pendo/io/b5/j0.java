package sdk.pendo.io.b5;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
public class j0 implements sdk.pendo.io.a5.g {

    /* renamed from: a, reason: collision with root package name */
    private final Cipher f912a;
    private final String b;
    private final boolean c;
    private SecretKey d;
    private byte[] e;

    public j0(Cipher cipher, String str, boolean z) {
        this.f912a = cipher;
        this.b = str;
        this.c = z;
    }

    @Override // sdk.pendo.io.a5.g
    public int a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        try {
            this.f912a.init(this.c ? 1 : 2, this.d, new IvParameterSpec(this.e), (SecureRandom) null);
            this.e = null;
            if (!this.c) {
                int i4 = i + i2;
                this.e = l3.a(bArr, i4 - this.f912a.getBlockSize(), i4);
            }
            int i5 = 0;
            while (i2 > 32768) {
                i5 += this.f912a.update(bArr, i, 32768, bArr2, i3 + i5);
                i += 32768;
                i2 -= 32768;
            }
            int update = i5 + this.f912a.update(bArr, i, i2, bArr2, i3 + i5);
            int doFinal = update + this.f912a.doFinal(bArr2, i3 + update);
            if (this.c) {
                int i6 = i3 + doFinal;
                this.e = l3.a(bArr2, i6 - this.f912a.getBlockSize(), i6);
            }
            return doFinal;
        } catch (GeneralSecurityException e) {
            throw c.b(e.getMessage(), e);
        }
    }

    @Override // sdk.pendo.io.a5.g
    public void b(byte[] bArr, int i, int i2) {
        if (this.e != null) {
            throw new IllegalStateException("unexpected reinitialization of an implicit-IV cipher");
        }
        this.e = l3.a(bArr, i, i2 + i);
    }

    @Override // sdk.pendo.io.a5.g
    public int a() {
        return this.f912a.getBlockSize();
    }

    @Override // sdk.pendo.io.a5.g
    public void a(byte[] bArr, int i, int i2) {
        this.d = new SecretKeySpec(bArr, i, i2, this.b);
    }
}
