package sdk.pendo.io.b5;

import java.security.PublicKey;
import sdk.pendo.io.y4.i1;
import sdk.pendo.io.y4.j1;

/* loaded from: classes6.dex */
public class a0 implements sdk.pendo.io.z4.f0 {

    /* renamed from: a, reason: collision with root package name */
    private final h f898a;
    private final PublicKey b;
    private final int c;

    public a0(h hVar, PublicKey publicKey, int i) {
        if (hVar == null) {
            throw new NullPointerException("crypto");
        }
        if (publicKey == null) {
            throw new NullPointerException("publicKey");
        }
        if (!j1.h(i)) {
            throw new IllegalArgumentException("signatureScheme");
        }
        this.f898a = hVar;
        this.b = publicKey;
        this.c = i;
    }

    @Override // sdk.pendo.io.z4.f0
    public sdk.pendo.io.z4.e0 a(sdk.pendo.io.y4.d0 d0Var) {
        i1 a2 = d0Var.a();
        if (a2 != null) {
            int a3 = j1.a(a2);
            int i = this.c;
            if (a3 == i) {
                int a4 = j1.a(i);
                String i2 = this.f898a.i(a4);
                return this.f898a.a(w0.a(i2) + "WITHRSAANDMGF1", w0.a(a4, i2, this.f898a.g()), d0Var.b(), this.b);
            }
        }
        throw new IllegalStateException("Invalid algorithm: " + a2);
    }

    @Override // sdk.pendo.io.z4.f0
    public boolean a(sdk.pendo.io.y4.d0 d0Var, byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
