package sdk.pendo.io.b5;

import java.security.KeyPair;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;

/* loaded from: classes6.dex */
public class m0 implements sdk.pendo.io.z4.e {

    /* renamed from: a, reason: collision with root package name */
    protected final n0 f917a;
    protected KeyPair b;
    protected DHPublicKey c;

    public m0(n0 n0Var) {
        this.f917a = n0Var;
    }

    @Override // sdk.pendo.io.z4.e
    public byte[] a() {
        KeyPair b = this.f917a.b();
        this.b = b;
        return this.f917a.a((DHPublicKey) b.getPublic());
    }

    @Override // sdk.pendo.io.z4.e
    public sdk.pendo.io.z4.b0 b() {
        return this.f917a.a((DHPrivateKey) this.b.getPrivate(), this.c);
    }

    @Override // sdk.pendo.io.z4.e
    public void a(byte[] bArr) {
        this.c = this.f917a.b(bArr);
    }
}
