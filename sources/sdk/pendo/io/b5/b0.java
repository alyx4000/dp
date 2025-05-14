package sdk.pendo.io.b5;

import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import sdk.pendo.io.m3.q1;
import sdk.pendo.io.y4.h2;
import sdk.pendo.io.y4.i1;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
public class b0 implements sdk.pendo.io.z4.c0 {

    /* renamed from: a, reason: collision with root package name */
    private final h f899a;
    private final PrivateKey b;
    private final PublicKey c;
    private Signature d = null;

    public b0(h hVar, PrivateKey privateKey, PublicKey publicKey) {
        if (hVar == null) {
            throw new NullPointerException("crypto");
        }
        if (privateKey == null) {
            throw new NullPointerException("privateKey");
        }
        this.f899a = hVar;
        this.b = privateKey;
        this.c = publicKey;
    }

    @Override // sdk.pendo.io.z4.c0
    public byte[] a(i1 i1Var, byte[] bArr) {
        try {
            try {
                Signature a2 = a();
                if (i1Var != null) {
                    if (i1Var.b() != 1) {
                        throw new IllegalStateException("Invalid algorithm: " + i1Var);
                    }
                    bArr = new sdk.pendo.io.e4.c(new sdk.pendo.io.e4.a(l3.d(i1Var.a()), q1.s), bArr).g();
                }
                a2.update(bArr, 0, bArr.length);
                byte[] sign = a2.sign();
                a2.initVerify(this.c);
                a2.update(bArr, 0, bArr.length);
                if (a2.verify(sign)) {
                    return sign;
                }
                throw new h2((short) 80);
            } catch (GeneralSecurityException e) {
                throw new h2((short) 80, (Throwable) e);
            }
        } finally {
            this.d = null;
        }
    }

    protected boolean b() {
        try {
            return f0.a(a().getProvider());
        } catch (GeneralSecurityException unused) {
            return true;
        }
    }

    protected Signature a() {
        if (this.d == null) {
            Signature f = this.f899a.g().f("NoneWithRSA");
            this.d = f;
            f.initSign(this.b, this.f899a.h());
        }
        return this.d;
    }

    @Override // sdk.pendo.io.z4.c0
    public sdk.pendo.io.z4.d0 a(i1 i1Var) {
        if (i1Var != null && 1 == i1Var.b() && f0.a() && b()) {
            return this.f899a.a(i1Var, this.b, true, this.c);
        }
        return null;
    }
}
