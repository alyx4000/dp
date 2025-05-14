package sdk.pendo.io.y4;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;

/* loaded from: classes4.dex */
class y0 {
    private static int o = 16384;

    /* renamed from: a, reason: collision with root package name */
    private final b f1810a;
    private final c b;
    private final c c;
    private w2 d;
    private InputStream e;
    private OutputStream f;
    private sdk.pendo.io.z4.g g = null;
    private sdk.pendo.io.z4.g h;
    private sdk.pendo.io.z4.g i;
    private sdk.pendo.io.z4.g j;
    private v0 k;
    private int l;
    private int m;
    private boolean n;

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f1811a;
        volatile byte[] b;
        volatile int c;

        private b() {
            byte[] bArr = new byte[5];
            this.f1811a = bArr;
            this.b = bArr;
            this.c = 0;
        }

        void a(InputStream inputStream, int i) {
            while (this.c < i) {
                try {
                    int read = inputStream.read(this.b, this.c, i - this.c);
                    if (read < 0) {
                        return;
                    } else {
                        this.c += read;
                    }
                } catch (InterruptedIOException e) {
                    this.c += e.bytesTransferred;
                    e.bytesTransferred = 0;
                    throw e;
                }
            }
        }

        void b(InputStream inputStream, int i) {
            int i2 = i + 5;
            a(i2);
            a(inputStream, i2);
            if (this.c < i2) {
                throw new EOFException();
            }
        }

        boolean a(InputStream inputStream) {
            a(inputStream, 5);
            if (this.c == 0) {
                return false;
            }
            if (this.c >= 5) {
                return true;
            }
            throw new EOFException();
        }

        void a() {
            this.b = this.f1811a;
            this.c = 0;
        }

        private void a(int i) {
            if (this.b.length < i) {
                byte[] bArr = new byte[i];
                System.arraycopy(this.b, 0, bArr, 0, this.c);
                this.b = bArr;
            }
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private long f1812a;
        private boolean b;

        private c() {
            this.f1812a = 0L;
            this.b = false;
        }

        synchronized long a() {
            return this.f1812a;
        }

        synchronized void b() {
            this.f1812a = 0L;
            this.b = false;
        }

        synchronized long a(short s) {
            long j;
            if (this.b) {
                throw new h2(s, "Sequence numbers exhausted");
            }
            j = this.f1812a;
            long j2 = 1 + j;
            this.f1812a = j2;
            if (j2 == 0) {
                this.b = true;
            }
            return j;
        }
    }

    y0(w2 w2Var, InputStream inputStream, OutputStream outputStream) {
        this.f1810a = new b();
        this.b = new c();
        this.c = new c();
        sdk.pendo.io.z4.x xVar = sdk.pendo.io.z4.x.f1889a;
        this.h = xVar;
        this.i = null;
        this.j = xVar;
        this.k = null;
        int i = o;
        this.l = i;
        this.m = i;
        this.n = false;
        this.d = w2Var;
        this.e = inputStream;
        this.f = outputStream;
    }

    private void a(byte[] bArr, int i, int i2) {
        if (1 != i2 || 1 != bArr[i]) {
            throw new h2((short) 10, "Malformed " + u.b((short) 20));
        }
    }

    void b() {
        sdk.pendo.io.z4.g gVar = this.g;
        if (gVar == null) {
            throw new h2((short) 80);
        }
        this.j = gVar;
        this.c.b();
    }

    void c() {
        sdk.pendo.io.z4.g gVar = this.h;
        sdk.pendo.io.z4.g gVar2 = this.g;
        if (gVar != gVar2 || this.j != gVar2) {
            throw new h2((short) 40);
        }
        this.g = null;
    }

    int d() {
        return this.l;
    }

    boolean e() {
        return this.c.a() >= 1048576;
    }

    void f() {
        if (this.g == null) {
            throw new h2((short) 10, "No pending cipher");
        }
        a(false);
    }

    void g() {
        this.h.c();
        this.b.b();
    }

    void h() {
        this.j.b();
        this.c.b();
    }

    boolean i() {
        if (!this.f1810a.a(this.e)) {
            return false;
        }
        short a2 = a(this.f1810a.b, 0);
        v0 e = l3.e(this.f1810a.b, 1);
        int c2 = l3.c(this.f1810a.b, 3);
        a(c2, this.m, (short) 22);
        this.f1810a.b(this.e, c2);
        try {
            if (this.n && 20 == a2) {
                a(this.f1810a.b, 5, c2);
                return true;
            }
            sdk.pendo.io.z4.n a3 = a(a2, e, this.f1810a.b, 5, c2);
            this.f1810a.a();
            this.d.a(a3.d, a3.f1886a, a3.b, a3.c);
            return true;
        } finally {
            this.f1810a.a();
        }
    }

    private static void a(int i, int i2, short s) {
        if (i > i2) {
            throw new h2(s);
        }
    }

    int b(int i) {
        return this.j.a(i, this.l) + 5;
    }

    void c(int i) {
        this.l = i;
        this.m = this.h.a(i);
    }

    private short a(byte[] bArr, int i) {
        short d = l3.d(bArr, i);
        sdk.pendo.io.z4.g gVar = this.i;
        if (gVar != null && d == 23) {
            this.h = gVar;
            this.i = null;
            this.m = gVar.a(this.l);
            this.b.b();
        } else if (!this.h.a()) {
            switch (d) {
                case 23:
                    if (!this.d.s()) {
                        throw new h2((short) 10, "Not ready for " + u.b((short) 23));
                    }
                case 20:
                case 21:
                case 22:
                    return d;
                default:
                    throw new h2((short) 10, "Unsupported " + u.b(d));
            }
        } else if (23 != d && (!this.n || 20 != d)) {
            throw new h2((short) 10, "Opaque " + u.b(d));
        }
        return d;
    }

    boolean b(byte[] bArr, int i, int i2) {
        if (i2 < 5) {
            return false;
        }
        int c2 = l3.c(bArr, i + 3);
        if (i2 != c2 + 5) {
            return false;
        }
        short a2 = a(bArr, i + 0);
        v0 e = l3.e(bArr, i + 1);
        a(c2, this.m, (short) 22);
        if (this.n && 20 == a2) {
            a(bArr, i + 5, c2);
            return true;
        }
        sdk.pendo.io.z4.n a3 = a(a2, e, bArr, i + 5, c2);
        this.d.a(a3.d, a3.f1886a, a3.b, a3.c);
        return true;
    }

    void a() {
        this.f1810a.a();
        try {
            this.e.close();
            e = null;
        } catch (IOException e) {
            e = e;
        }
        try {
            this.f.close();
        } catch (IOException e2) {
            if (e == null) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    void b(boolean z) {
        this.n = z;
    }

    sdk.pendo.io.z4.n a(short s, v0 v0Var, byte[] bArr, int i, int i2) {
        sdk.pendo.io.z4.n a2 = this.h.a(this.b.a((short) 10), s, v0Var, bArr, i, i2);
        a(a2.c, this.l, (short) 22);
        if (a2.c >= 1 || a2.d == 23) {
            return a2;
        }
        throw new h2((short) 47);
    }

    void a(boolean z) {
        sdk.pendo.io.z4.g gVar = this.g;
        if (gVar == null) {
            throw new h2((short) 80);
        }
        if (this.i != null) {
            throw new h2((short) 80);
        }
        if (z) {
            this.i = gVar;
            return;
        }
        this.h = gVar;
        this.m = gVar.a(this.l);
        this.b.b();
    }

    x0 a(int i) {
        int max = Math.max(0, Math.min(this.l, i));
        return new x0(b(max), max);
    }

    x0 a(byte[] bArr) {
        int i = 0;
        short a2 = a(bArr, 0);
        int c2 = l3.c(bArr, 3);
        a(c2, this.m, (short) 22);
        int i2 = c2 + 5;
        if (23 == a2 && this.d.s()) {
            i = Math.max(0, Math.min(this.l, this.h.b(c2)));
        }
        return new x0(i2, i);
    }

    void a(sdk.pendo.io.z4.g gVar) {
        this.g = gVar;
    }

    void a(v0 v0Var) {
        this.k = v0Var;
    }

    void a(short s, byte[] bArr, int i, int i2) {
        if (this.k == null) {
            return;
        }
        a(i2, this.l, (short) 80);
        if (i2 < 1 && s != 23) {
            throw new h2((short) 80);
        }
        long a2 = this.c.a((short) 80);
        v0 v0Var = this.k;
        sdk.pendo.io.z4.q a3 = this.j.a(a2, s, v0Var, 5, bArr, i, i2);
        int i3 = a3.c - 5;
        l3.a(i3);
        l3.a(a3.d, a3.f1888a, a3.b + 0);
        l3.a(v0Var, a3.f1888a, a3.b + 1);
        l3.a(i3, a3.f1888a, a3.b + 3);
        try {
            this.f.write(a3.f1888a, a3.b, a3.c);
            this.f.flush();
        } catch (InterruptedIOException e) {
            throw new h2((short) 80, (Throwable) e);
        }
    }
}
