package sdk.pendo.io.j4;

import java.security.SecureRandom;

/* loaded from: classes6.dex */
public class f extends SecureRandom {
    private final SecureRandom A;
    private final b f;
    private final c f0;
    private final boolean s;
    private sdk.pendo.io.k4.b t0;

    f(SecureRandom secureRandom, c cVar, b bVar, boolean z) {
        this.A = secureRandom;
        this.f0 = cVar;
        this.f = bVar;
        this.s = z;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int i) {
        return e.a(this.f0, i);
    }

    @Override // java.security.SecureRandom
    public String getAlgorithm() {
        return this.f.getAlgorithm();
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] bArr) {
        synchronized (this) {
            if (this.t0 == null) {
                this.t0 = this.f.a(this.f0);
            }
            if (this.t0.a(bArr, null, this.s) < 0) {
                this.t0.a(null);
                this.t0.a(bArr, null, this.s);
            }
        }
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void setSeed(long j) {
        synchronized (this) {
            SecureRandom secureRandom = this.A;
            if (secureRandom != null) {
                secureRandom.setSeed(j);
            }
        }
    }

    @Override // java.security.SecureRandom
    public void setSeed(byte[] bArr) {
        synchronized (this) {
            SecureRandom secureRandom = this.A;
            if (secureRandom != null) {
                secureRandom.setSeed(bArr);
            }
        }
    }
}
