package sdk.pendo.io.b5;

import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.Signature;
import sdk.pendo.io.y4.h2;
import sdk.pendo.io.y4.i1;
import sdk.pendo.io.y4.j1;

/* loaded from: classes6.dex */
public class n implements sdk.pendo.io.z4.c0 {

    /* renamed from: a, reason: collision with root package name */
    private final h f918a;
    private final PrivateKey b;
    private final int c;

    public n(h hVar, PrivateKey privateKey, int i) {
        if (hVar == null) {
            throw new NullPointerException("crypto");
        }
        if (privateKey == null) {
            throw new NullPointerException("privateKey");
        }
        if (!j1.g(i)) {
            throw new IllegalArgumentException("signatureScheme");
        }
        this.f918a = hVar;
        this.b = privateKey;
        this.c = i;
    }

    @Override // sdk.pendo.io.z4.c0
    public sdk.pendo.io.z4.d0 a(i1 i1Var) {
        return null;
    }

    @Override // sdk.pendo.io.z4.c0
    public byte[] a(i1 i1Var, byte[] bArr) {
        if (i1Var == null || j1.a(i1Var) != this.c) {
            throw new IllegalStateException("Invalid algorithm: " + i1Var);
        }
        try {
            Signature f = this.f918a.g().f("NoneWithECDSA");
            f.initSign(this.b, this.f918a.h());
            f.update(bArr, 0, bArr.length);
            return f.sign();
        } catch (GeneralSecurityException e) {
            throw new h2((short) 80, (Throwable) e);
        }
    }
}
