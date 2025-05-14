package sdk.pendo.io.b5;

import java.security.KeyPair;
import java.security.PublicKey;

/* loaded from: classes6.dex */
public class u0 implements sdk.pendo.io.z4.e {

    /* renamed from: a, reason: collision with root package name */
    protected final v0 f926a;
    protected KeyPair b;
    protected PublicKey c;

    public u0(v0 v0Var) {
        this.f926a = v0Var;
    }

    @Override // sdk.pendo.io.z4.e
    public byte[] a() {
        KeyPair b = this.f926a.b();
        this.b = b;
        return this.f926a.a(b.getPublic());
    }

    @Override // sdk.pendo.io.z4.e
    public sdk.pendo.io.z4.b0 b() {
        return this.f926a.a(this.b.getPrivate(), this.c);
    }

    @Override // sdk.pendo.io.z4.e
    public void a(byte[] bArr) {
        this.c = this.f926a.a(bArr);
    }
}
