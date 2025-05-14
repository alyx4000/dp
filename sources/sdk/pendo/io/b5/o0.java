package sdk.pendo.io.b5;

import java.security.KeyPair;
import java.security.PublicKey;

/* loaded from: classes6.dex */
public class o0 implements sdk.pendo.io.z4.e {

    /* renamed from: a, reason: collision with root package name */
    protected final p0 f921a;
    protected KeyPair b;
    protected PublicKey c;

    public o0(p0 p0Var) {
        this.f921a = p0Var;
    }

    @Override // sdk.pendo.io.z4.e
    public byte[] a() {
        KeyPair b = this.f921a.b();
        this.b = b;
        return this.f921a.a(b.getPublic());
    }

    @Override // sdk.pendo.io.z4.e
    public sdk.pendo.io.z4.b0 b() {
        return this.f921a.a(this.b.getPrivate(), this.c);
    }

    @Override // sdk.pendo.io.z4.e
    public void a(byte[] bArr) {
        this.c = this.f921a.b(bArr);
    }
}
