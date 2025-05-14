package sdk.pendo.io.y4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Hashtable;

/* loaded from: classes4.dex */
public final class g1 {

    /* renamed from: a, reason: collision with root package name */
    private int f1777a;
    private short b;
    private l c;
    private sdk.pendo.io.z4.b0 d;
    private v0 e;
    private l f;
    private byte[] g;
    private byte[] h;
    private byte[] i;
    private boolean j;

    public static final class b {
        private v0 e;

        /* renamed from: a, reason: collision with root package name */
        private int f1778a = -1;
        private short b = -1;
        private l c = null;
        private sdk.pendo.io.z4.b0 d = null;
        private l f = null;
        private byte[] g = null;
        private byte[] h = null;
        private byte[] i = null;
        private boolean j = false;

        public g1 a() {
            a(this.f1778a >= 0, "cipherSuite");
            a(this.b >= 0, "compressionAlgorithm");
            a(this.d != null, "masterSecret");
            return new g1(this.f1778a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }

        public b b(l lVar) {
            this.f = lVar;
            return this;
        }

        public b a(int i) {
            this.f1778a = i;
            return this;
        }

        public b b(byte[] bArr) {
            this.h = bArr;
            return this;
        }

        public b a(short s) {
            this.b = s;
            return this;
        }

        public b a(boolean z) {
            this.j = z;
            return this;
        }

        public b a(l lVar) {
            this.c = lVar;
            return this;
        }

        public b a(sdk.pendo.io.z4.b0 b0Var) {
            this.d = b0Var;
            return this;
        }

        public b a(v0 v0Var) {
            this.e = v0Var;
            return this;
        }

        public b a(byte[] bArr) {
            this.g = bArr;
            return this;
        }

        public b a(Hashtable hashtable) {
            if (hashtable == null || hashtable.isEmpty()) {
                this.i = null;
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                w2.a(byteArrayOutputStream, hashtable);
                this.i = byteArrayOutputStream.toByteArray();
            }
            return this;
        }

        private void a(boolean z, String str) {
            if (!z) {
                throw new IllegalStateException("Required session parameter '" + str + "' not configured");
            }
        }
    }

    private g1(int i, short s, l lVar, sdk.pendo.io.z4.b0 b0Var, v0 v0Var, l lVar2, byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z) {
        this.g = null;
        this.h = null;
        this.f1777a = i;
        this.b = s;
        this.c = lVar;
        this.d = b0Var;
        this.e = v0Var;
        this.f = lVar2;
        this.g = sdk.pendo.io.d5.a.a(bArr);
        this.h = sdk.pendo.io.d5.a.a(bArr2);
        this.i = bArr3;
        this.j = z;
    }

    public void a() {
        sdk.pendo.io.z4.b0 b0Var = this.d;
        if (b0Var != null) {
            b0Var.destroy();
        }
    }

    public g1 b() {
        return new g1(this.f1777a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
    }

    public int c() {
        return this.f1777a;
    }

    public short d() {
        return this.b;
    }

    public l e() {
        return this.c;
    }

    public sdk.pendo.io.z4.b0 f() {
        return this.d;
    }

    public v0 g() {
        return this.e;
    }

    public byte[] h() {
        return this.g;
    }

    public l i() {
        return this.f;
    }

    public byte[] j() {
        return this.h;
    }

    public boolean k() {
        return this.j;
    }

    public Hashtable l() {
        if (this.i == null) {
            return null;
        }
        return w2.d(new ByteArrayInputStream(this.i));
    }
}
