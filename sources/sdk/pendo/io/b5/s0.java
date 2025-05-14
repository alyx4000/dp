package sdk.pendo.io.b5;

import java.security.KeyPair;
import java.security.PublicKey;

/* loaded from: classes6.dex */
public class s0 implements sdk.pendo.io.z4.e {

    /* renamed from: a, reason: collision with root package name */
    protected final t0 f924a;
    protected KeyPair b;
    protected PublicKey c;

    public s0(t0 t0Var) {
        this.f924a = t0Var;
    }

    @Override // sdk.pendo.io.z4.e
    public byte[] a() {
        KeyPair b = this.f924a.b();
        this.b = b;
        return this.f924a.a(b.getPublic());
    }

    @Override // sdk.pendo.io.z4.e
    public sdk.pendo.io.z4.b0 b() {
        return this.f924a.a(this.b.getPrivate(), this.c);
    }

    @Override // sdk.pendo.io.z4.e
    public void a(byte[] bArr) {
        this.c = this.f924a.a(bArr);
    }
}
