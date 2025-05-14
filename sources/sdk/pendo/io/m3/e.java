package sdk.pendo.io.m3;

import java.io.IOException;

/* loaded from: classes6.dex */
public class e extends a0 {
    private final byte f;
    static final o0 s = new a(e.class, 1);
    public static final e A = new e((byte) 0);
    public static final e f0 = new e((byte) -1);

    static class a extends o0 {
        a(Class cls, int i) {
            super(cls, i);
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(s1 s1Var) {
            return e.b(s1Var.k());
        }
    }

    private e(byte b) {
        this.f = b;
    }

    static e b(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
        }
        byte b = bArr[0];
        return b != -1 ? b != 0 ? new e(b) : A : f0;
    }

    @Override // sdk.pendo.io.m3.a0
    boolean a(a0 a0Var) {
        return (a0Var instanceof e) && k() == ((e) a0Var).k();
    }

    @Override // sdk.pendo.io.m3.a0
    boolean h() {
        return false;
    }

    @Override // sdk.pendo.io.m3.a0, sdk.pendo.io.m3.t
    public int hashCode() {
        return k() ? 1 : 0;
    }

    @Override // sdk.pendo.io.m3.a0
    a0 i() {
        return k() ? f0 : A;
    }

    public boolean k() {
        return this.f != 0;
    }

    public String toString() {
        return k() ? "TRUE" : "FALSE";
    }

    public static e b(boolean z) {
        return z ? f0 : A;
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        yVar.a(z, 1, this.f);
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        return y.a(z, 1);
    }

    public static e a(Object obj) {
        if (obj == null || (obj instanceof e)) {
            return (e) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (e) s.a((byte[]) obj);
        } catch (IOException e) {
            throw new IllegalArgumentException("failed to construct boolean from byte[]: " + e.getMessage());
        }
    }
}
