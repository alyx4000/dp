package sdk.pendo.io.b5;

import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.Signature;
import sdk.pendo.io.m3.q1;
import sdk.pendo.io.y4.i1;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
public class c0 implements sdk.pendo.io.z4.f0 {

    /* renamed from: a, reason: collision with root package name */
    private final h f900a;
    private final PublicKey b;
    private Signature c = null;

    public c0(h hVar, PublicKey publicKey) {
        if (hVar == null) {
            throw new NullPointerException("crypto");
        }
        if (publicKey == null) {
            throw new NullPointerException("publicKey");
        }
        this.f900a = hVar;
        this.b = publicKey;
    }

    protected Signature a() {
        if (this.c == null) {
            Signature f = this.f900a.g().f("NoneWithRSA");
            this.c = f;
            f.initVerify(this.b);
        }
        return this.c;
    }

    protected boolean b() {
        try {
            return f0.a(a().getProvider());
        } catch (GeneralSecurityException unused) {
            return true;
        }
    }

    @Override // sdk.pendo.io.z4.f0
    public sdk.pendo.io.z4.e0 a(sdk.pendo.io.y4.d0 d0Var) {
        i1 a2 = d0Var.a();
        if (a2 != null && a2.b() == 1 && f0.a() && b()) {
            return this.f900a.a(d0Var, this.b);
        }
        return null;
    }

    @Override // sdk.pendo.io.z4.f0
    public boolean a(sdk.pendo.io.y4.d0 d0Var, byte[] bArr) {
        i1 a2 = d0Var.a();
        try {
            Signature a3 = a();
            if (a2 == null) {
                a3.update(bArr, 0, bArr.length);
            } else {
                if (a2.b() != 1) {
                    throw new IllegalStateException("Invalid algorithm: " + a2);
                }
                byte[] g = new sdk.pendo.io.e4.c(new sdk.pendo.io.e4.a(l3.d(a2.a()), q1.s), bArr).g();
                a3.update(g, 0, g.length);
            }
            return a3.verify(d0Var.b());
        } catch (GeneralSecurityException e) {
            throw c.b("unable to process signature: " + e.getMessage(), e);
        }
    }
}
