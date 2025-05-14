package sdk.pendo.io.b5;

import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import sdk.pendo.io.y4.i1;

/* loaded from: classes6.dex */
public class w implements sdk.pendo.io.z4.f0 {

    /* renamed from: a, reason: collision with root package name */
    protected final h f929a;
    protected final PublicKey b;
    protected final short c;
    protected final String d;

    public w(h hVar, PublicKey publicKey, short s, String str) {
        if (hVar == null) {
            throw new NullPointerException("crypto");
        }
        if (publicKey == null) {
            throw new NullPointerException("publicKey");
        }
        this.f929a = hVar;
        this.b = publicKey;
        this.c = s;
        this.d = str;
    }

    @Override // sdk.pendo.io.z4.f0
    public sdk.pendo.io.z4.e0 a(sdk.pendo.io.y4.d0 d0Var) {
        i1 a2 = d0Var.a();
        if (a2 != null && a2.b() == this.c && a2.a() == 8) {
            return this.f929a.a(this.d, (AlgorithmParameterSpec) null, d0Var.b(), this.b);
        }
        throw new IllegalStateException("Invalid algorithm: " + a2);
    }

    @Override // sdk.pendo.io.z4.f0
    public boolean a(sdk.pendo.io.y4.d0 d0Var, byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
