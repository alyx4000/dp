package sdk.pendo.io.b5;

import java.security.PrivateKey;
import sdk.pendo.io.y4.i1;
import sdk.pendo.io.y4.j1;

/* loaded from: classes6.dex */
public class z implements sdk.pendo.io.z4.c0 {

    /* renamed from: a, reason: collision with root package name */
    private final h f932a;
    private final PrivateKey b;
    private final int c;

    public z(h hVar, PrivateKey privateKey, int i) {
        if (hVar == null) {
            throw new NullPointerException("crypto");
        }
        if (privateKey == null) {
            throw new NullPointerException("privateKey");
        }
        if (!j1.h(i)) {
            throw new IllegalArgumentException("signatureScheme");
        }
        this.f932a = hVar;
        this.b = privateKey;
        this.c = i;
    }

    @Override // sdk.pendo.io.z4.c0
    public byte[] a(i1 i1Var, byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    @Override // sdk.pendo.io.z4.c0
    public sdk.pendo.io.z4.d0 a(i1 i1Var) {
        if (i1Var != null) {
            int a2 = j1.a(i1Var);
            int i = this.c;
            if (a2 == i) {
                int a3 = j1.a(i);
                String i2 = this.f932a.i(a3);
                return this.f932a.a(w0.a(i2) + "WITHRSAANDMGF1", w0.a(a3, i2, this.f932a.g()), this.b, true);
            }
        }
        throw new IllegalStateException("Invalid algorithm: " + i1Var);
    }
}
