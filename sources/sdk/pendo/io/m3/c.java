package sdk.pendo.io.m3;

import androidx.core.view.InputDeviceCompat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* loaded from: classes6.dex */
public abstract class c extends a0 implements g0, d {
    final byte[] f;
    static final o0 s = new a(c.class, 3);
    private static final char[] A = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    static class a extends o0 {
        a(Class cls, int i) {
            super(cls, i);
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(d0 d0Var) {
            return d0Var.n();
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(s1 s1Var) {
            return c.b(s1Var.k());
        }
    }

    c(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("'data' cannot be null");
        }
        if (bArr.length == 0 && i != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        }
        if (i > 7 || i < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        this.f = sdk.pendo.io.d5.a.b(bArr, (byte) i);
    }

    static c b(byte[] bArr) {
        int length = bArr.length;
        if (length < 1) {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        int i = bArr[0] & UByte.MAX_VALUE;
        if (i > 0) {
            if (i > 7 || length < 2) {
                throw new IllegalArgumentException("invalid pad bits detected");
            }
            byte b = bArr[length - 1];
            if (b != ((byte) ((255 << i) & b))) {
                return new f2(bArr, false);
            }
        }
        return new j1(bArr, false);
    }

    @Override // sdk.pendo.io.m3.a0
    boolean a(a0 a0Var) {
        if (!(a0Var instanceof c)) {
            return false;
        }
        byte[] bArr = this.f;
        byte[] bArr2 = ((c) a0Var).f;
        int length = bArr.length;
        if (bArr2.length != length) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        int i = length - 1;
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        int i3 = 255 << (bArr[0] & UByte.MAX_VALUE);
        return ((byte) (bArr[i] & i3)) == ((byte) (bArr2[i] & i3));
    }

    @Override // sdk.pendo.io.m3.g0
    public String c() {
        try {
            byte[] g = g();
            StringBuffer stringBuffer = new StringBuffer((g.length * 2) + 1);
            stringBuffer.append('#');
            for (int i = 0; i != g.length; i++) {
                byte b = g[i];
                char[] cArr = A;
                stringBuffer.append(cArr[(b >>> 4) & 15]);
                stringBuffer.append(cArr[b & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            throw new z("Internal error encoding BitString: " + e.getMessage(), e);
        }
    }

    @Override // sdk.pendo.io.m3.d
    public int d() {
        return this.f[0] & UByte.MAX_VALUE;
    }

    @Override // sdk.pendo.io.m3.r2
    public a0 e() {
        return b();
    }

    @Override // sdk.pendo.io.m3.d
    public InputStream f() {
        byte[] bArr = this.f;
        return new ByteArrayInputStream(bArr, 1, bArr.length - 1);
    }

    @Override // sdk.pendo.io.m3.a0, sdk.pendo.io.m3.t
    public int hashCode() {
        byte[] bArr = this.f;
        if (bArr.length < 2) {
            return 1;
        }
        int i = bArr[0] & UByte.MAX_VALUE;
        int length = bArr.length - 1;
        return (sdk.pendo.io.d5.a.c(bArr, 0, length) * InputDeviceCompat.SOURCE_KEYBOARD) ^ ((byte) ((255 << i) & bArr[length]));
    }

    @Override // sdk.pendo.io.m3.a0
    a0 i() {
        return new j1(this.f, false);
    }

    @Override // sdk.pendo.io.m3.a0
    a0 j() {
        return new f2(this.f, false);
    }

    public byte[] k() {
        byte[] bArr = this.f;
        if (bArr[0] == 0) {
            return sdk.pendo.io.d5.a.b(bArr, 1, bArr.length);
        }
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    public String toString() {
        return c();
    }

    c(byte[] bArr, boolean z) {
        if (z) {
            if (bArr == null) {
                throw new NullPointerException("'contents' cannot be null");
            }
            if (bArr.length < 1) {
                throw new IllegalArgumentException("'contents' cannot be empty");
            }
            int i = bArr[0] & UByte.MAX_VALUE;
            if (i > 0) {
                if (bArr.length < 2) {
                    throw new IllegalArgumentException("zero length data with non-zero pad bits");
                }
                if (i > 7) {
                    throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
                }
            }
        }
        this.f = bArr;
    }

    public static c a(Object obj) {
        if (obj == null || (obj instanceof c)) {
            return (c) obj;
        }
        if (obj instanceof g) {
            a0 b = ((g) obj).b();
            if (b instanceof c) {
                return (c) b;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (c) s.a((byte[]) obj);
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct BIT STRING from byte[]: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static c a(j0 j0Var, boolean z) {
        return (c) s.a(j0Var, z);
    }
}
