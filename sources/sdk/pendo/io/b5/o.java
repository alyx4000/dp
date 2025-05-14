package sdk.pendo.io.b5;

import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.Signature;
import sdk.pendo.io.y4.i1;
import sdk.pendo.io.y4.j1;

/* loaded from: classes6.dex */
public class o implements sdk.pendo.io.z4.f0 {

    /* renamed from: a, reason: collision with root package name */
    private final h f920a;
    private final PublicKey b;
    private final int c;

    public o(h hVar, PublicKey publicKey, int i) {
        if (hVar == null) {
            throw new NullPointerException("crypto");
        }
        if (publicKey == null) {
            throw new NullPointerException("publicKey");
        }
        if (!j1.g(i)) {
            throw new IllegalArgumentException("signatureScheme");
        }
        this.f920a = hVar;
        this.b = publicKey;
        this.c = i;
    }

    @Override // sdk.pendo.io.z4.f0
    public sdk.pendo.io.z4.e0 a(sdk.pendo.io.y4.d0 d0Var) {
        return null;
    }

    @Override // sdk.pendo.io.z4.f0
    public boolean a(sdk.pendo.io.y4.d0 d0Var, byte[] bArr) {
        i1 a2 = d0Var.a();
        if (a2 == null || j1.a(a2) != this.c) {
            throw new IllegalStateException("Invalid algorithm: " + a2);
        }
        try {
            Signature f = this.f920a.g().f("NoneWithECDSA");
            f.initVerify(this.b);
            f.update(bArr, 0, bArr.length);
            return f.verify(d0Var.b());
        } catch (GeneralSecurityException e) {
            throw c.b("unable to process signature: " + e.getMessage(), e);
        }
    }
}
