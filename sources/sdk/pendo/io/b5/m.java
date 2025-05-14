package sdk.pendo.io.b5;

import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.Signature;
import sdk.pendo.io.y4.i1;

/* loaded from: classes6.dex */
public abstract class m implements sdk.pendo.io.z4.f0 {

    /* renamed from: a, reason: collision with root package name */
    protected final h f916a;
    protected final PublicKey b;
    protected final short c;
    protected final String d;

    protected m(h hVar, PublicKey publicKey, short s, String str) {
        if (hVar == null) {
            throw new NullPointerException("crypto");
        }
        if (publicKey == null) {
            throw new NullPointerException("publicKey");
        }
        this.f916a = hVar;
        this.b = publicKey;
        this.c = s;
        this.d = str;
    }

    @Override // sdk.pendo.io.z4.f0
    public sdk.pendo.io.z4.e0 a(sdk.pendo.io.y4.d0 d0Var) {
        return null;
    }

    @Override // sdk.pendo.io.z4.f0
    public boolean a(sdk.pendo.io.y4.d0 d0Var, byte[] bArr) {
        i1 a2 = d0Var.a();
        if (a2 != null && a2.b() != this.c) {
            throw new IllegalStateException("Invalid algorithm: " + a2);
        }
        try {
            Signature f = this.f916a.g().f(this.d);
            f.initVerify(this.b);
            if (a2 == null) {
                f.update(bArr, 16, 20);
            } else {
                f.update(bArr, 0, bArr.length);
            }
            return f.verify(d0Var.b());
        } catch (GeneralSecurityException e) {
            throw c.b("unable to process signature: " + e.getMessage(), e);
        }
    }
}
