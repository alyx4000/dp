package sdk.pendo.io.m3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public abstract class w extends a0 implements x {
    byte[] f;
    static final o0 s = new a(w.class, 4);
    static final byte[] A = new byte[0];

    static class a extends o0 {
        a(Class cls, int i) {
            super(cls, i);
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(d0 d0Var) {
            return d0Var.p();
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(s1 s1Var) {
            return s1Var;
        }
    }

    public w(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("'string' cannot be null");
        }
        this.f = bArr;
    }

    static w b(byte[] bArr) {
        return new s1(bArr);
    }

    @Override // sdk.pendo.io.m3.a0
    boolean a(a0 a0Var) {
        if (a0Var instanceof w) {
            return sdk.pendo.io.d5.a.a(this.f, ((w) a0Var).f);
        }
        return false;
    }

    @Override // sdk.pendo.io.m3.r2
    public a0 e() {
        return b();
    }

    @Override // sdk.pendo.io.m3.a0, sdk.pendo.io.m3.t
    public int hashCode() {
        return sdk.pendo.io.d5.a.b(k());
    }

    @Override // sdk.pendo.io.m3.a0
    a0 i() {
        return new s1(this.f);
    }

    @Override // sdk.pendo.io.m3.a0
    a0 j() {
        return new s1(this.f);
    }

    public byte[] k() {
        return this.f;
    }

    public String toString() {
        return "#" + sdk.pendo.io.d5.i.b(sdk.pendo.io.e5.f.a(this.f));
    }

    public static w a(Object obj) {
        if (obj == null || (obj instanceof w)) {
            return (w) obj;
        }
        if (obj instanceof g) {
            a0 b = ((g) obj).b();
            if (b instanceof w) {
                return (w) b;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (w) s.a((byte[]) obj);
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct OCTET STRING from byte[]: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static w a(j0 j0Var, boolean z) {
        return (w) s.a(j0Var, z);
    }

    @Override // sdk.pendo.io.m3.x
    public InputStream a() {
        return new ByteArrayInputStream(this.f);
    }
}
