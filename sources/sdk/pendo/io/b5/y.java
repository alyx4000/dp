package sdk.pendo.io.b5;

import java.security.GeneralSecurityException;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sdk.pendo.io.y4.h2;

/* loaded from: classes6.dex */
final class y implements sdk.pendo.io.z4.r {

    /* renamed from: a, reason: collision with root package name */
    private final h f931a;
    private final PublicKey b;

    y(h hVar, PublicKey publicKey) {
        this.f931a = hVar;
        this.b = publicKey;
    }

    @Override // sdk.pendo.io.z4.r
    public byte[] a(byte[] bArr, int i, int i2) {
        try {
            Cipher f = this.f931a.f();
            try {
                f.init(3, this.b, this.f931a.h());
                return f.wrap(new SecretKeySpec(bArr, i, i2, "TLS"));
            } catch (Exception e) {
                try {
                    f.init(1, this.b, this.f931a.h());
                    return f.doFinal(bArr, i, i2);
                } catch (Exception unused) {
                    throw new h2((short) 80, (Throwable) e);
                }
            }
        } catch (GeneralSecurityException e2) {
            throw new h2((short) 80, (Throwable) e2);
        }
    }
}
