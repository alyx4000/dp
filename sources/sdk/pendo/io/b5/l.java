package sdk.pendo.io.b5;

import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.Signature;
import sdk.pendo.io.y4.h2;
import sdk.pendo.io.y4.i1;

/* loaded from: classes6.dex */
public abstract class l implements sdk.pendo.io.z4.c0 {

    /* renamed from: a, reason: collision with root package name */
    protected final h f914a;
    protected final PrivateKey b;
    protected final short c;
    protected final String d;

    protected l(h hVar, PrivateKey privateKey, short s, String str) {
        if (hVar == null) {
            throw new NullPointerException("crypto");
        }
        if (privateKey == null) {
            throw new NullPointerException("privateKey");
        }
        this.f914a = hVar;
        this.b = privateKey;
        this.c = s;
        this.d = str;
    }

    @Override // sdk.pendo.io.z4.c0
    public sdk.pendo.io.z4.d0 a(i1 i1Var) {
        return null;
    }

    @Override // sdk.pendo.io.z4.c0
    public byte[] a(i1 i1Var, byte[] bArr) {
        if (i1Var != null && i1Var.b() != this.c) {
            throw new IllegalStateException("Invalid algorithm: " + i1Var);
        }
        try {
            Signature f = this.f914a.g().f(this.d);
            f.initSign(this.b, this.f914a.h());
            if (i1Var == null) {
                f.update(bArr, 16, 20);
            } else {
                f.update(bArr, 0, bArr.length);
            }
            return f.sign();
        } catch (GeneralSecurityException e) {
            throw new h2((short) 80, (Throwable) e);
        }
    }
}
