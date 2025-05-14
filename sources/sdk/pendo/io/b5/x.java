package sdk.pendo.io.b5;

import java.security.MessageDigest;

/* loaded from: classes6.dex */
public class x implements sdk.pendo.io.z4.t {

    /* renamed from: a, reason: collision with root package name */
    private final MessageDigest f930a;

    public x(MessageDigest messageDigest) {
        this.f930a = messageDigest;
    }

    @Override // sdk.pendo.io.z4.t
    public void b(byte[] bArr, int i, int i2) {
        this.f930a.update(bArr, i, i2);
    }

    @Override // sdk.pendo.io.z4.t
    public byte[] c() {
        return this.f930a.digest();
    }

    @Override // sdk.pendo.io.z4.t
    public sdk.pendo.io.z4.t d() {
        try {
            return new x((MessageDigest) this.f930a.clone());
        } catch (CloneNotSupportedException unused) {
            throw new UnsupportedOperationException("unable to clone digest");
        }
    }

    @Override // sdk.pendo.io.z4.t
    public void reset() {
        this.f930a.reset();
    }
}
