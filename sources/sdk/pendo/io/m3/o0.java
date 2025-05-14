package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
abstract class o0 extends k0 {
    final i0 b;

    o0(Class cls, int i) {
        super(cls);
        this.b = i0.a(0, i);
    }

    final a0 a(a0 a0Var) {
        if (this.f1391a.isInstance(a0Var)) {
            return a0Var;
        }
        throw new IllegalStateException("unexpected object: " + a0Var.getClass().getName());
    }

    final a0 a(byte[] bArr) {
        return a(a0.a(bArr));
    }

    a0 a(d0 d0Var) {
        throw new IllegalStateException("unexpected implicit constructed encoding");
    }

    a0 a(s1 s1Var) {
        throw new IllegalStateException("unexpected implicit primitive encoding");
    }

    final a0 a(j0 j0Var, boolean z) {
        if (128 == j0Var.m()) {
            return a(j0Var.a(z, this));
        }
        throw new IllegalStateException("this method only valid for CONTEXT_SPECIFIC tags");
    }
}
