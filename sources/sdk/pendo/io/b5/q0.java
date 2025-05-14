package sdk.pendo.io.b5;

import java.security.InvalidKeyException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes6.dex */
public class q0 implements sdk.pendo.io.z4.s {

    /* renamed from: a, reason: collision with root package name */
    private final Mac f923a;
    private final String b;
    private final int c;

    public q0(int i, Mac mac, String str) {
        this.f923a = mac;
        this.b = str;
        this.c = sdk.pendo.io.z4.k.c(i);
    }

    @Override // sdk.pendo.io.z4.s
    public int a() {
        return this.c;
    }

    @Override // sdk.pendo.io.z4.v
    public byte[] b() {
        return this.f923a.doFinal();
    }

    @Override // sdk.pendo.io.z4.v
    public int c() {
        return this.f923a.getMacLength();
    }

    @Override // sdk.pendo.io.z4.v
    public void reset() {
        this.f923a.reset();
    }

    @Override // sdk.pendo.io.z4.v
    public void a(byte[] bArr, int i, int i2) {
        try {
            this.f923a.init(new SecretKeySpec(bArr, i, i2, this.b));
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override // sdk.pendo.io.z4.v
    public void b(byte[] bArr, int i, int i2) {
        this.f923a.update(bArr, i, i2);
    }
}
