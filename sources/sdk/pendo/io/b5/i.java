package sdk.pendo.io.b5;

import java.security.DigestException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;

/* loaded from: classes6.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private sdk.pendo.io.p4.b f910a = new sdk.pendo.io.p4.a();

    private static class a extends SecureRandom {

        /* renamed from: sdk.pendo.io.b5.i$a$a, reason: collision with other inner class name */
        private static class C0092a extends SecureRandomSpi {
            private final byte[] A;
            private final SecureRandom f;
            private final byte[] f0;
            private final MessageDigest s;

            C0092a(SecureRandom secureRandom, MessageDigest messageDigest) {
                this.f = secureRandom;
                this.s = messageDigest;
                byte[] generateSeed = secureRandom.generateSeed(messageDigest.getDigestLength());
                this.A = generateSeed;
                this.f0 = new byte[generateSeed.length];
            }

            private void a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
                this.s.update(bArr);
                this.s.update(bArr2);
                try {
                    this.s.digest(bArr3, 0, bArr3.length);
                } catch (DigestException e) {
                    throw c.b("unable to generate nonce data: " + e.getMessage(), e);
                }
            }

            @Override // java.security.SecureRandomSpi
            protected byte[] engineGenerateSeed(int i) {
                return this.f.generateSeed(i);
            }

            @Override // java.security.SecureRandomSpi
            protected void engineNextBytes(byte[] bArr) {
                synchronized (this.s) {
                    int length = this.f0.length;
                    int i = 0;
                    while (i != bArr.length) {
                        byte[] bArr2 = this.f0;
                        if (length == bArr2.length) {
                            this.f.nextBytes(bArr2);
                            byte[] bArr3 = this.A;
                            byte[] bArr4 = this.f0;
                            a(bArr3, bArr4, bArr4);
                            length = 0;
                        }
                        bArr[i] = this.f0[length];
                        i++;
                        length++;
                    }
                }
            }

            @Override // java.security.SecureRandomSpi
            protected void engineSetSeed(byte[] bArr) {
                synchronized (this.s) {
                    byte[] bArr2 = this.A;
                    a(bArr2, bArr, bArr2);
                }
            }
        }

        a(sdk.pendo.io.p4.b bVar, SecureRandom secureRandom) {
            super(new C0092a(secureRandom, bVar.h("SHA-512")), secureRandom.getProvider());
        }
    }

    public h a(SecureRandom secureRandom) {
        if (secureRandom == null) {
            try {
                sdk.pendo.io.p4.b bVar = this.f910a;
                secureRandom = bVar instanceof sdk.pendo.io.p4.a ? SecureRandom.getInstance("DEFAULT") : SecureRandom.getInstance("DEFAULT", bVar.h("SHA-512").getProvider());
            } catch (GeneralSecurityException e) {
                throw c.b("unable to create JcaTlsCrypto: " + e.getMessage(), e);
            }
        }
        return a(secureRandom, new a(this.f910a, secureRandom));
    }

    public h a(SecureRandom secureRandom, SecureRandom secureRandom2) {
        return new h(this.f910a, secureRandom, secureRandom2);
    }

    public sdk.pendo.io.p4.b a() {
        return this.f910a;
    }

    public i a(Provider provider) {
        this.f910a = new sdk.pendo.io.p4.c(provider);
        return this;
    }
}
