package sdk.pendo.io.y4;

import androidx.core.view.ViewCompat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import sdk.pendo.io.y4.g1;

/* loaded from: classes4.dex */
public abstract class w2 implements q1 {
    protected static final Integer G = sdk.pendo.io.d5.d.b(65281);
    protected static final Integer H = sdk.pendo.io.d5.d.b(35);
    protected boolean A;
    protected boolean B;
    protected boolean C;
    protected boolean D;
    protected j E;
    protected k F;

    /* renamed from: a, reason: collision with root package name */
    private i f1807a;
    private i b;
    private i c;
    final y0 d;
    final Object e;
    private int f;
    j2 g;
    private k2 h;
    private p2 i;
    private volatile boolean j;
    private volatile boolean k;
    private volatile boolean l;
    private volatile boolean m;
    private volatile boolean n;
    private volatile boolean o;
    private volatile boolean p;
    private volatile int q;
    protected j3 r;
    protected g1 s;
    protected sdk.pendo.io.z4.b0 t;
    protected byte[] u;
    protected int v;
    protected Hashtable w;
    protected Hashtable x;
    protected short y;
    protected boolean z;

    protected w2() {
        this.f1807a = new i(0);
        this.b = new i(2);
        this.c = new i(0);
        this.e = new Object();
        this.f = -1;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = 0;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = -1;
        this.w = null;
        this.x = null;
        this.y = (short) 0;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = new j();
        this.F = new k();
        this.d = new y0(this, this.E, this.F);
    }

    private void y() {
        while (this.b.a() >= 2) {
            byte[] a2 = this.b.a(2, 0);
            a(a2[0], a2[1]);
        }
    }

    private void z() {
    }

    protected void A() {
        if (l3.b(k())) {
            throw new h2((short) 40);
        }
        a((short) 100, "Renegotiation not supported");
    }

    public void B() {
        if (!this.D) {
            throw new IllegalStateException("Cannot use resumeHandshake() in non-blocking mode!");
        }
        if (!u()) {
            throw new IllegalStateException("No handshake in progress");
        }
        b();
    }

    protected void C() {
        try {
            if (this.d.i()) {
                return;
            }
            if (!this.l) {
                throw new h2((short) 40);
            }
            if (m().h()) {
                p();
                throw new n2();
            }
            c(false);
        } catch (RuntimeException e) {
            a((short) 80, "Failed to read record", e);
            throw new h2((short) 80, e);
        } catch (h2 e2) {
            a(e2.a(), "Failed to read record", e2);
            throw e2;
        } catch (i2 e3) {
            throw e3;
        } catch (IOException e4) {
            a((short) 80, "Failed to read record", e4);
            throw e4;
        }
    }

    protected void D() {
        r1 k = k();
        a1 d = k.d();
        byte[] a2 = l3.a(k, this.g, k.i());
        d.V = a2;
        d.B = null;
        g0.a(this, (short) 20, a2);
    }

    protected void E() {
        F();
        this.d.b();
    }

    protected void F() {
        b((short) 20, new byte[]{1}, 0, 1);
    }

    protected void G() {
        r1 k = k();
        a1 d = k.d();
        byte[] a2 = l3.a(k, this.g, k.i());
        d.V = a2;
        if ((!this.z || d.M()) && d.y() == null) {
            d.B = a2;
        }
        g0.a(this, (short) 20, a2);
    }

    public int a() {
        return this.f1807a.a();
    }

    protected abstract void a(short s, f0 f0Var);

    protected void b() {
        while (this.y != 21) {
            if (t()) {
                throw new h2((short) 80);
            }
            C();
        }
    }

    protected void c() {
        a1 h;
        r1 k = k();
        if (k != null && (h = k.h()) != null) {
            h.a();
        }
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = -1;
        this.w = null;
        this.x = null;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
    }

    public void d() {
        c(true);
    }

    protected void e() {
        this.d.a();
    }

    public void f() {
        if (this.D) {
            throw new IllegalStateException("Cannot use closeInput() in blocking mode!");
        }
        if (this.j) {
            return;
        }
        if (this.E.available() > 0) {
            throw new EOFException();
        }
        if (!this.l) {
            throw new h2((short) 40);
        }
        if (m().h()) {
            p();
            throw new n2();
        }
        c(false);
    }

    protected void g() {
        try {
            b l = l();
            a1 d = l.d();
            if (!l.l() || d.p() == null || d.y() == null) {
                throw new h2((short) 80);
            }
            this.d.c();
            this.y = (short) 21;
            this.g = new b0(l);
            this.b.c();
            this.c.c();
            v0 s = d.s();
            this.m = !l3.c(s);
            this.l = true;
            this.n = l3.e(s);
            if (this.D) {
                this.h = new k2(this);
                this.i = new p2(this);
            }
            g1 g1Var = this.s;
            if (g1Var == null) {
                this.t = d.q();
                this.s = new g1.b().a(d.e()).a(d.k()).a(d.M()).a(d.o()).a(l.b().a(this.t)).a(d.s()).b(d.x()).a(d.w()).b(d.z()).a(this.x).a();
                this.r = l3.a(d.F(), this.s);
            } else {
                d.R = g1Var.e();
                d.S = this.s.i();
                d.y = this.s.h();
                d.z = this.s.j();
            }
            l.a(m(), this.r);
        } finally {
            c();
        }
    }

    public int h() {
        return this.d.d();
    }

    public int i() {
        if (this.D) {
            throw new IllegalStateException("Cannot use getAvailableInputBytes() in blocking mode! Use getInputStream().available() instead.");
        }
        return a();
    }

    public int j() {
        if (this.D) {
            throw new IllegalStateException("Cannot use getAvailableOutputBytes() in blocking mode! Use getOutputStream() instead.");
        }
        return this.F.a().a();
    }

    protected abstract r1 k();

    abstract b l();

    protected abstract v2 m();

    protected int n() {
        return 0;
    }

    protected void o() {
    }

    protected void p() {
        this.j = true;
        this.k = true;
        r();
        if (!this.l) {
            c();
        }
        e();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean q() {
        /*
            r4 = this;
            sdk.pendo.io.y4.r1 r0 = r4.k()
            sdk.pendo.io.y4.a1 r0 = r0.e()
            r1 = 0
            if (r0 == 0) goto L2d
            boolean r2 = r0.P()
            if (r2 == 0) goto L2d
            int r2 = r0.l()
            if (r2 != 0) goto L1c
            sdk.pendo.io.y4.l r0 = r0.o()
            goto L20
        L1c:
            sdk.pendo.io.y4.l r0 = r0.x()
        L20:
            if (r0 == 0) goto L2d
            boolean r0 = r0.d()
            if (r0 != 0) goto L2d
            int r0 = r4.n()
            goto L2e
        L2d:
            r0 = r1
        L2e:
            r2 = 1
            if (r0 == r2) goto L3c
            r3 = 2
            if (r0 == r3) goto L38
            r4.A()
            return r1
        L38:
            r4.a(r2)
            return r2
        L3c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.y4.w2.q():boolean");
    }

    protected void r() {
        sdk.pendo.io.z4.b0 b0Var = this.t;
        if (b0Var != null) {
            b0Var.destroy();
            this.t = null;
        }
        g1 g1Var = this.s;
        if (g1Var != null) {
            g1Var.a();
            this.s = null;
        }
        j3 j3Var = this.r;
        if (j3Var != null) {
            j3Var.invalidate();
            this.r = null;
        }
    }

    boolean s() {
        return this.l;
    }

    public boolean t() {
        return this.j;
    }

    public boolean u() {
        b l;
        return (this.j || (l = l()) == null || !l.l()) ? false : true;
    }

    protected boolean v() {
        switch (this.y) {
            case 0:
            case 1:
            case 4:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return true;
            case 2:
            case 3:
            case 5:
            case 9:
            case 13:
            default:
                return false;
        }
    }

    public boolean w() {
        return this.p;
    }

    protected boolean x() {
        switch (this.y) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 9:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 20:
            case 21:
                return true;
            case 6:
            case 8:
            case 10:
            case 12:
            case 14:
            case 16:
            case 19:
            default:
                return false;
        }
    }

    protected w2(InputStream inputStream, OutputStream outputStream) {
        this.f1807a = new i(0);
        this.b = new i(2);
        this.c = new i(0);
        this.e = new Object();
        this.f = -1;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = 0;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = -1;
        this.w = null;
        this.x = null;
        this.y = (short) 0;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = true;
        this.d = new y0(this, inputStream, outputStream);
    }

    protected static Hashtable d(ByteArrayInputStream byteArrayInputStream) {
        if (byteArrayInputStream.available() < 1) {
            return null;
        }
        byte[] b = l3.b(byteArrayInputStream);
        a(byteArrayInputStream);
        return c(b);
    }

    protected void a(short s) {
        if (s >= 0) {
            if (!n0.a(s)) {
                throw new h2((short) 80);
            }
            this.d.c(1 << (s + 8));
        }
    }

    protected void b(boolean z) {
        if (z != this.B) {
            throw new h2((short) 10);
        }
    }

    protected void c(boolean z) {
        if (this.j) {
            return;
        }
        this.j = true;
        if (!this.l) {
            c();
            if (z) {
                a((short) 90, "User canceled handshake");
            }
        }
        a((short) 0, "Connection closed");
        e();
    }

    public int e(byte[] bArr, int i, int i2) {
        if (this.D) {
            throw new IllegalStateException("Cannot use readOutput() in blocking mode! Use getOutputStream() instead.");
        }
        int min = Math.min(j(), i2);
        this.F.a().b(bArr, i, min, 0);
        return min;
    }

    protected void f(ByteArrayInputStream byteArrayInputStream) {
        if (!this.l || !this.n) {
            throw new h2((short) 10);
        }
        short g = l3.g(byteArrayInputStream);
        a(byteArrayInputStream);
        if (!l0.a(g)) {
            throw new h2((short) 47);
        }
        boolean z = 1 == g;
        l3.f(k());
        this.d.g();
        this.o = z | this.o;
    }

    public void g(byte[] bArr, int i, int i2) {
        if (!this.l) {
            throw new IllegalStateException("Cannot write application data until initial handshake completed.");
        }
        synchronized (this.e) {
            while (i2 > 0) {
                if (this.j) {
                    throw new IOException("Cannot write application data on closed/failed TLS connection");
                }
                if (this.m) {
                    int i3 = this.q;
                    if (i3 != 1) {
                        if (i3 == 2) {
                            this.m = false;
                        } else if (i2 > 1) {
                            b((short) 23, bArr, i, 1);
                            i++;
                            i2--;
                        }
                    }
                    b((short) 23, l3.e, 0, 0);
                } else if (this.n) {
                    if (this.o) {
                        d(false);
                    } else if (this.d.e()) {
                        d(true);
                    }
                }
                int min = Math.min(i2, this.d.d());
                b((short) 23, bArr, i, min);
                i += min;
                i2 -= min;
            }
        }
    }

    void h(byte[] bArr, int i, int i2) {
        v0 a2;
        if (i2 < 4) {
            throw new h2((short) 80);
        }
        short d = l3.d(bArr, i);
        if (d != 0 && d != 1 && (d == 4 ? !((a2 = k().a()) == null || l3.e(a2)) : d != 24)) {
            this.g.b(bArr, i, i2);
        }
        int i3 = 0;
        do {
            int min = Math.min(i2 - i3, this.d.d());
            b((short) 22, bArr, i + i3, min);
            i3 += min;
        } while (i3 < i2);
    }

    protected static void a(ByteArrayInputStream byteArrayInputStream) {
        if (byteArrayInputStream.available() > 0) {
            throw new h2((short) 50);
        }
    }

    protected static Hashtable d(byte[] bArr) {
        int d;
        Hashtable hashtable = new Hashtable();
        if (bArr.length > 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            boolean z = false;
            do {
                d = l3.d(byteArrayInputStream);
                if (hashtable.put(sdk.pendo.io.d5.d.b(d), l3.b(byteArrayInputStream)) != null) {
                    throw new h2((short) 47, "Repeated extension: " + e0.b(d));
                }
                z |= 41 == d;
            } while (byteArrayInputStream.available() > 0);
            if (z && 41 != d) {
                throw new h2((short) 47, "'pre_shared_key' MUST be last in ClientHello");
            }
        }
        return hashtable;
    }

    protected static Vector e(ByteArrayInputStream byteArrayInputStream) {
        byte[] b = l3.b(byteArrayInputStream, 1);
        a(byteArrayInputStream);
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(b);
        Vector vector = new Vector();
        while (byteArrayInputStream2.available() > 0) {
            vector.addElement(new k1(l3.d(byteArrayInputStream2), l3.b(byteArrayInputStream2)));
        }
        return vector;
    }

    protected void b(short s) {
        if (s == 0) {
            if (!this.l) {
                throw new h2((short) 40);
            }
            c(false);
        } else {
            if (s == 41) {
                throw new h2((short) 10);
            }
            if (s == 100) {
                throw new h2((short) 40);
            }
        }
    }

    protected void c(ByteArrayInputStream byteArrayInputStream) {
        r1 k = k();
        a1 d = k.d();
        boolean i = k.i();
        byte[] a2 = l3.a(d.J(), byteArrayInputStream);
        a(byteArrayInputStream);
        byte[] a3 = l3.a(k, this.g, !i);
        if (!sdk.pendo.io.d5.a.d(a3, a2)) {
            throw new h2((short) 51);
        }
        d.W = a3;
        if ((!this.z || d.M()) && d.p() == null) {
            d.B = a3;
        }
    }

    protected boolean f(byte[] bArr, int i, int i2) {
        try {
            return this.d.b(bArr, i, i2);
        } catch (RuntimeException e) {
            a((short) 80, "Failed to process record", e);
            throw new h2((short) 80, e);
        } catch (h2 e2) {
            a(e2.a(), "Failed to process record", e2);
            throw e2;
        } catch (IOException e3) {
            a((short) 80, "Failed to process record", e3);
            throw e3;
        }
    }

    protected void a(boolean z) {
        b l = l();
        v2 m = m();
        this.f = Math.max(1024, m.B());
        this.g = new b0(l);
        this.y = (short) 0;
        this.z = false;
        this.A = false;
        l.a(m);
        a1 d = l.d();
        if (z != d.O()) {
            throw new h2((short) 80);
        }
        d.E = m.t();
    }

    public x0 b(byte[] bArr) {
        if (this.D) {
            throw new IllegalStateException("Cannot use previewInputRecord() in blocking mode!");
        }
        if (this.E.available() != 0) {
            throw new IllegalStateException("Can only use previewInputRecord() for record-aligned input.");
        }
        if (this.j) {
            throw new IOException("Connection is closed, cannot accept any more input");
        }
        return e(bArr);
    }

    public int c(byte[] bArr, int i, int i2) {
        if (i2 < 1) {
            return 0;
        }
        while (this.f1807a.a() == 0) {
            if (this.j) {
                if (this.k) {
                    throw new IOException("Cannot read application data on failed TLS connection");
                }
                return -1;
            }
            if (!this.l) {
                throw new IllegalStateException("Cannot read application data until initial handshake completed.");
            }
            C();
        }
        int min = Math.min(i2, this.f1807a.a());
        this.f1807a.b(bArr, i, min, 0);
        return min;
    }

    public int d(byte[] bArr, int i, int i2) {
        if (this.D) {
            throw new IllegalStateException("Cannot use readInput() in blocking mode! Use getInputStream() instead.");
        }
        int min = Math.min(i2, this.f1807a.a());
        if (min < 1) {
            return 0;
        }
        this.f1807a.b(bArr, i, min, 0);
        return min;
    }

    protected x0 e(byte[] bArr) {
        try {
            return this.d.a(bArr);
        } catch (RuntimeException e) {
            a((short) 80, "Failed to read record", e);
            throw new h2((short) 80, e);
        } catch (h2 e2) {
            a(e2.a(), "Failed to read record", e2);
            throw e2;
        } catch (IOException e3) {
            a((short) 80, "Failed to read record", e3);
            throw e3;
        }
    }

    protected static byte[] a(boolean z, r1 r1Var) {
        byte[] a2 = r1Var.k().a(32);
        if (z) {
            l3.f(a2, 0);
        }
        return a2;
    }

    protected static Hashtable c(byte[] bArr) {
        Hashtable hashtable = new Hashtable();
        if (bArr.length > 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            do {
                int d = l3.d(byteArrayInputStream);
                if (hashtable.put(sdk.pendo.io.d5.d.b(d), l3.b(byteArrayInputStream)) != null) {
                    throw new h2((short) 47, "Repeated extension: " + e0.b(d));
                }
            } while (byteArrayInputStream.available() > 0);
        }
        return hashtable;
    }

    protected void b(ByteArrayInputStream byteArrayInputStream) {
        r1 k = k();
        a1 d = k.d();
        boolean i = k.i();
        byte[] a2 = l3.a(d.J(), byteArrayInputStream);
        a(byteArrayInputStream);
        byte[] a3 = l3.a(k, this.g, !i);
        if (!sdk.pendo.io.d5.a.d(a3, a2)) {
            throw new h2((short) 51);
        }
        d.W = a3;
        d.B = null;
    }

    protected void d(boolean z) {
        if (!this.l || !this.n) {
            throw new h2((short) 80);
        }
        g0.a(this, (short) 24, l3.b(z ? (short) 1 : (short) 0));
        l3.e(k());
        this.d.h();
        this.o = (z ? 1 : 0) & (this.o ? 1 : 0);
    }

    public void e(boolean z) {
        this.p = z;
    }

    protected static byte[] a(byte[] bArr) {
        return l3.f(bArr);
    }

    private void b(byte[] bArr, int i, int i2) {
        v0 a2 = k().a();
        if (a2 == null || l3.e(a2)) {
            throw new h2((short) 10);
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (l3.d(bArr, i + i3) != 1) {
                throw new h2((short) 50);
            }
            if (this.B || this.b.a() > 0 || this.c.a() > 0) {
                throw new h2((short) 10);
            }
            this.d.f();
            this.B = true;
            o();
        }
    }

    protected static void a(r1 r1Var, l2 l2Var) {
        sdk.pendo.io.z4.b0 b = l2Var.b();
        if (b == null) {
            throw new h2((short) 80);
        }
        try {
            r1Var.d().r = l3.a(r1Var, b);
        } finally {
            b.destroy();
        }
    }

    protected void b(short s, String str, Throwable th) {
        m().a((short) 2, s, str, th);
        try {
            this.d.a((short) 21, new byte[]{2, (byte) s}, 0, 2);
        } catch (Exception unused) {
        }
    }

    protected boolean a(j3 j3Var) {
        g1 c;
        this.r = null;
        this.s = null;
        this.t = null;
        if (j3Var == null || !j3Var.b() || (c = j3Var.c()) == null) {
            return false;
        }
        if (!c.k()) {
            v2 m = m();
            if (!m.x() || m.i()) {
                return false;
            }
        }
        sdk.pendo.io.z4.b0 a2 = l3.a(k().b(), c.f());
        if (a2 == null) {
            return false;
        }
        this.r = j3Var;
        this.s = c;
        this.t = a2;
        return true;
    }

    protected void b(short s, byte[] bArr, int i, int i2) {
        try {
            this.d.a(s, bArr, i, i2);
        } catch (RuntimeException e) {
            a((short) 80, "Failed to write record", e);
            throw new h2((short) 80, e);
        } catch (h2 e2) {
            a(e2.a(), "Failed to write record", e2);
            throw e2;
        } catch (IOException e3) {
            a((short) 80, "Failed to write record", e3);
            throw e3;
        }
    }

    protected static void b(OutputStream outputStream, Hashtable hashtable, int i) {
        byte[] bArr = (byte[]) hashtable.get(g2.q);
        if (bArr != null) {
            l3.a(41);
            l3.a(41, outputStream);
            int length = bArr.length + i;
            l3.a(length);
            l3.a(length, outputStream);
            outputStream.write(bArr);
        }
    }

    protected void a(short s, short s2) {
        m().a(s, s2);
        if (s == 1) {
            b(s2);
        } else {
            p();
            throw new i2(s2);
        }
    }

    protected void a(short s, String str, Throwable th) {
        if (((this.l || w()) && (th instanceof InterruptedIOException)) || this.j) {
            return;
        }
        b(s, str, th);
        p();
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.D) {
            throw new IllegalStateException("Cannot use offerInput() in blocking mode! Use getInputStream() instead.");
        }
        if (this.j) {
            throw new IOException("Connection is closed, cannot accept any more input");
        }
        if (this.E.available() == 0 && f(bArr, i, i2)) {
            if (this.j && !this.l) {
                throw new h2((short) 80);
            }
            return;
        }
        this.E.a(bArr, i, i2);
        while (this.E.available() >= 5) {
            byte[] bArr2 = new byte[5];
            if (5 != this.E.a(bArr2)) {
                throw new h2((short) 80);
            }
            if (this.E.available() < e(bArr2).b()) {
                return;
            }
            C();
            if (this.j) {
                if (!this.l) {
                    throw new h2((short) 80);
                }
                return;
            }
        }
    }

    public x0 a(int i) {
        if (!this.l) {
            throw new IllegalStateException("Cannot use previewOutputRecord() until initial handshake completed.");
        }
        if (this.D) {
            throw new IllegalStateException("Cannot use previewOutputRecord() in blocking mode!");
        }
        if (this.F.a().a() != 0) {
            throw new IllegalStateException("Can only use previewOutputRecord() for record-aligned output.");
        }
        if (this.j) {
            throw new IOException("Connection is closed, cannot produce any more output");
        }
        if (i < 1) {
            return new x0(0, 0);
        }
        if (this.m) {
            int i2 = this.q;
            if (i2 == 1 || i2 == 2) {
                return x0.a(this.d.a(0), this.d.a(i));
            }
            x0 a2 = this.d.a(1);
            return i > 1 ? x0.a(a2, this.d.a(i - 1)) : a2;
        }
        x0 a3 = this.d.a(i);
        if (!this.n) {
            return a3;
        }
        if (this.o || this.d.e()) {
            return x0.a(a3, this.d.b(g0.a(1)));
        }
        return a3;
    }

    private void a(i iVar) {
        v0 a2;
        v0 a3;
        while (iVar.a() >= 4) {
            int b = iVar.b();
            short s = (short) (b >>> 24);
            if (!h0.c(s)) {
                throw new h2((short) 10, "Handshake message of unrecognized type: " + ((int) s));
            }
            int i = b & ViewCompat.MEASURED_SIZE_MASK;
            if (i > this.f) {
                throw new h2((short) 80, "Handshake message length exceeds the maximum: " + h0.b(s) + ", " + i + " > " + this.f);
            }
            int i2 = i + 4;
            if (iVar.a() < i2) {
                return;
            }
            if (s != 0 && ((a3 = k().a()) == null || !l3.e(a3))) {
                b(20 == s);
            }
            f0 b2 = iVar.b(i2);
            if (s != 0 && s != 1 && s != 2 && (s == 4 ? !((a2 = k().a()) == null || l3.e(a2)) : !(s == 15 || s == 20 || s == 24))) {
                b2.a(this.g);
            }
            b2.skip(4L);
            a(s, b2);
        }
    }

    protected short a(Hashtable hashtable, Hashtable hashtable2, short s) {
        short n = g2.n(hashtable2);
        if (n < 0 || (n0.a(n) && (this.z || n == g2.n(hashtable)))) {
            return n;
        }
        throw new h2(s);
    }

    protected void a(short s, byte[] bArr, int i, int i2) {
        switch (s) {
            case 20:
                b(bArr, i, i2);
                return;
            case 21:
                this.b.a(bArr, i, i2);
                y();
                return;
            case 22:
                if (this.c.a() > 0) {
                    this.c.a(bArr, i, i2);
                    a(this.c);
                    return;
                }
                i iVar = new i(bArr, i, i2);
                a(iVar);
                int a2 = iVar.a();
                if (a2 > 0) {
                    this.c.a(bArr, (i + i2) - a2, a2);
                    return;
                }
                return;
            case 23:
                if (!this.l) {
                    throw new h2((short) 10);
                }
                this.f1807a.a(bArr, i, i2);
                z();
                return;
            default:
                throw new h2((short) 10);
        }
    }

    protected void a(short s, String str) {
        m().a((short) 1, s, str, null);
        b((short) 21, new byte[]{1, (byte) s}, 0, 2);
    }

    protected static Hashtable a(int i, byte[] bArr) {
        Hashtable hashtable = new Hashtable();
        if (bArr.length > 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            do {
                int d = l3.d(byteArrayInputStream);
                if (!l3.a(i, d)) {
                    throw new h2((short) 47, "Invalid extension: " + e0.b(d));
                }
                if (hashtable.put(sdk.pendo.io.d5.d.b(d), l3.b(byteArrayInputStream)) != null) {
                    throw new h2((short) 47, "Repeated extension: " + e0.b(d));
                }
            } while (byteArrayInputStream.available() > 0);
        }
        return hashtable;
    }

    protected void a(l lVar) {
        if (lVar == null) {
            throw new h2((short) 80);
        }
        r1 k = k();
        a1 d = k.d();
        if (d.o() != null) {
            throw new h2((short) 80);
        }
        g0 g0Var = new g0((short) 11);
        lVar.a(k, g0Var, null);
        g0Var.a(this);
        d.R = lVar;
    }

    protected void a(d0 d0Var) {
        g0 g0Var = new g0((short) 15);
        d0Var.a(g0Var);
        g0Var.a(this);
    }

    protected void a(l lVar, OutputStream outputStream) {
        r1 k = k();
        a1 d = k.d();
        if (d.o() != null) {
            throw new h2((short) 80);
        }
        if (lVar == null) {
            lVar = l.e;
        }
        if (lVar.d() && !k.i() && d.s().g()) {
            a((short) 41, "SSLv3 client didn't provide credentials");
        } else {
            g0 g0Var = new g0((short) 11);
            lVar.a(k, g0Var, outputStream);
            g0Var.a(this);
        }
        d.R = lVar;
    }

    protected void a(Vector vector) {
        g0 g0Var = new g0((short) 23);
        a(g0Var, vector);
        g0Var.a(this);
    }

    protected static void a(OutputStream outputStream, Hashtable hashtable) {
        a(outputStream, hashtable, 0);
    }

    protected static void a(OutputStream outputStream, Hashtable hashtable, int i) {
        if (hashtable == null || hashtable.isEmpty()) {
            return;
        }
        byte[] a2 = a(hashtable, i);
        int length = a2.length + i;
        l3.a(length);
        l3.a(length, outputStream);
        outputStream.write(a2);
    }

    protected static void a(Hashtable hashtable, int i, ByteArrayOutputStream byteArrayOutputStream) {
        a((OutputStream) byteArrayOutputStream, hashtable, true);
        a((OutputStream) byteArrayOutputStream, hashtable, false);
        b(byteArrayOutputStream, hashtable, i);
    }

    protected static byte[] a(Hashtable hashtable) {
        return a(hashtable, 0);
    }

    protected static byte[] a(Hashtable hashtable, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(hashtable, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    protected static void a(OutputStream outputStream, Hashtable hashtable, boolean z) {
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Integer num = (Integer) keys.nextElement();
            int intValue = num.intValue();
            if (41 != intValue) {
                byte[] bArr = (byte[]) hashtable.get(num);
                if (z == (bArr.length == 0)) {
                    l3.a(intValue);
                    l3.a(intValue, outputStream);
                    l3.a(bArr, outputStream);
                }
            }
        }
    }

    protected static void a(OutputStream outputStream, Vector vector) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < vector.size(); i++) {
            k1 k1Var = (k1) vector.elementAt(i);
            int b = k1Var.b();
            l3.a(b);
            l3.a(b, (OutputStream) byteArrayOutputStream);
            l3.a(k1Var.a(), (OutputStream) byteArrayOutputStream);
        }
        l3.b(byteArrayOutputStream.toByteArray(), outputStream);
    }
}
