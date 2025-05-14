package sdk.pendo.io.n4;

import java.security.DigestException;
import java.security.MessageDigest;
import sdk.pendo.io.g4.c;

/* loaded from: classes6.dex */
public class a extends MessageDigest {
    protected c f;
    protected int s;

    protected a(c cVar) {
        super(cVar.a());
        this.f = cVar;
        this.s = cVar.b();
    }

    @Override // java.security.MessageDigestSpi
    public int engineDigest(byte[] bArr, int i, int i2) {
        int i3 = this.s;
        if (i2 < i3) {
            throw new DigestException("partial digests not returned");
        }
        if (bArr.length - i < i3) {
            throw new DigestException("insufficient space in the output buffer to store the digest");
        }
        this.f.a(bArr, i);
        return this.s;
    }

    @Override // java.security.MessageDigestSpi
    public int engineGetDigestLength() {
        return this.s;
    }

    @Override // java.security.MessageDigestSpi
    public void engineReset() {
        this.f.reset();
    }

    @Override // java.security.MessageDigestSpi
    public void engineUpdate(byte b) {
        this.f.a(b);
    }

    @Override // java.security.MessageDigestSpi
    public byte[] engineDigest() {
        byte[] bArr = new byte[this.s];
        this.f.a(bArr, 0);
        return bArr;
    }

    @Override // java.security.MessageDigestSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f.b(bArr, i, i2);
    }
}
