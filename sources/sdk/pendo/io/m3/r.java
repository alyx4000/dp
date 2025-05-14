package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public abstract class r extends a0 {
    static final o0 f = new a(r.class, 5);

    static class a extends o0 {
        a(Class cls, int i) {
            super(cls, i);
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(s1 s1Var) {
            return r.b(s1Var.k());
        }
    }

    r() {
    }

    static r b(byte[] bArr) {
        if (bArr.length == 0) {
            return q1.s;
        }
        throw new IllegalStateException("malformed NULL encoding encountered");
    }

    @Override // sdk.pendo.io.m3.a0
    boolean a(a0 a0Var) {
        return a0Var instanceof r;
    }

    @Override // sdk.pendo.io.m3.a0, sdk.pendo.io.m3.t
    public int hashCode() {
        return -1;
    }

    public String toString() {
        return "NULL";
    }
}
