package sdk.pendo.io.b5;

import java.security.PrivateKey;
import java.security.spec.AlgorithmParameterSpec;
import sdk.pendo.io.y4.i1;

/* loaded from: classes6.dex */
public abstract class v implements sdk.pendo.io.z4.c0 {

    /* renamed from: a, reason: collision with root package name */
    protected final h f927a;
    protected final PrivateKey b;
    protected final short c;
    protected final String d;

    public v(h hVar, PrivateKey privateKey, short s, String str) {
        if (hVar == null) {
            throw new NullPointerException("crypto");
        }
        if (privateKey == null) {
            throw new NullPointerException("privateKey");
        }
        this.f927a = hVar;
        this.b = privateKey;
        this.c = s;
        this.d = str;
    }

    @Override // sdk.pendo.io.z4.c0
    public byte[] a(i1 i1Var, byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    @Override // sdk.pendo.io.z4.c0
    public sdk.pendo.io.z4.d0 a(i1 i1Var) {
        if (i1Var != null && i1Var.b() == this.c && i1Var.a() == 8) {
            return this.f927a.a(this.d, (AlgorithmParameterSpec) null, this.b, false);
        }
        throw new IllegalStateException("Invalid algorithm: " + i1Var);
    }
}
