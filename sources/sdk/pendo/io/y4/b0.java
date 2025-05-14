package sdk.pendo.io.y4;

import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Hashtable;

/* loaded from: classes4.dex */
class b0 implements j2 {

    /* renamed from: a, reason: collision with root package name */
    protected r1 f1767a;
    private c0 b = new c0();
    private Hashtable c = new Hashtable();
    private boolean d = false;
    private boolean e = false;

    b0(r1 r1Var) {
        this.f1767a = r1Var;
    }

    protected void a(Integer num) {
        if (this.c.containsKey(num)) {
            return;
        }
        this.c.put(num, this.f1767a.b().d(num.intValue()));
    }

    protected sdk.pendo.io.z4.t b(Integer num) {
        return ((sdk.pendo.io.z4.t) this.c.get(num)).d();
    }

    protected Integer c(int i) {
        return sdk.pendo.io.d5.d.b(i);
    }

    protected void d(int i) {
        a(c(i));
    }

    protected sdk.pendo.io.z4.t e(int i) {
        return b(c(i));
    }

    @Override // sdk.pendo.io.y4.j2
    public sdk.pendo.io.z4.t f() {
        sdk.pendo.io.z4.t tVar;
        h();
        a1 d = this.f1767a.d();
        int t = d.t();
        if (t == 0 || t == 1) {
            tVar = new t(this.f1767a, e(1), e(2));
        } else {
            tVar = e(d.u());
        }
        c0 c0Var = this.b;
        if (c0Var != null) {
            c0Var.a(tVar);
        }
        return tVar;
    }

    @Override // sdk.pendo.io.y4.j2
    public void g() {
        if (this.e) {
            throw new IllegalStateException("Already sealed");
        }
        this.e = true;
        h();
    }

    protected void h() {
        if (this.d || !this.e || this.b == null || this.c.size() > 4) {
            return;
        }
        Enumeration elements = this.c.elements();
        while (elements.hasMoreElements()) {
            this.b.a((sdk.pendo.io.z4.t) elements.nextElement());
        }
        this.b = null;
    }

    @Override // sdk.pendo.io.z4.t
    public void reset() {
        c0 c0Var = this.b;
        if (c0Var != null) {
            c0Var.reset();
            return;
        }
        Enumeration elements = this.c.elements();
        while (elements.hasMoreElements()) {
            ((sdk.pendo.io.z4.t) elements.nextElement()).reset();
        }
    }

    protected void a(Hashtable hashtable, int i) {
        a(hashtable, c(i));
    }

    @Override // sdk.pendo.io.y4.j2
    public void b() {
        int i;
        a1 d = this.f1767a.d();
        int t = d.t();
        if (t == 0 || t == 1) {
            d(1);
            i = 2;
        } else {
            i = d.u();
        }
        d(i);
    }

    @Override // sdk.pendo.io.z4.t
    public byte[] c() {
        throw new IllegalStateException("Use 'forkPRFHash' to get a definite hash");
    }

    @Override // sdk.pendo.io.z4.t
    public sdk.pendo.io.z4.t d() {
        throw new IllegalStateException("attempt to clone a DeferredHash");
    }

    @Override // sdk.pendo.io.y4.j2
    public void e() {
        if (this.e) {
            throw new IllegalStateException("Too late to force buffering");
        }
        this.d = true;
    }

    protected void a(Hashtable hashtable, Integer num) {
        sdk.pendo.io.z4.t b = b(num);
        c0 c0Var = this.b;
        if (c0Var != null) {
            c0Var.a(b);
        }
        hashtable.put(num, b);
    }

    @Override // sdk.pendo.io.y4.j2
    public void b(int i) {
        if (this.e) {
            throw new IllegalStateException("Too late to track more hash algorithms");
        }
        d(i);
    }

    @Override // sdk.pendo.io.y4.j2
    public void a(OutputStream outputStream) {
        c0 c0Var = this.b;
        if (c0Var == null) {
            throw new IllegalStateException("Not buffering");
        }
        c0Var.a(outputStream);
    }

    @Override // sdk.pendo.io.z4.t
    public void b(byte[] bArr, int i, int i2) {
        c0 c0Var = this.b;
        if (c0Var != null) {
            c0Var.write(bArr, i, i2);
            return;
        }
        Enumeration elements = this.c.elements();
        while (elements.hasMoreElements()) {
            ((sdk.pendo.io.z4.t) elements.nextElement()).b(bArr, i, i2);
        }
    }

    @Override // sdk.pendo.io.y4.j2
    public byte[] a(int i) {
        sdk.pendo.io.z4.t tVar = (sdk.pendo.io.z4.t) this.c.get(c(i));
        if (tVar == null) {
            throw new IllegalStateException("CryptoHashAlgorithm." + i + " is not being tracked");
        }
        h();
        sdk.pendo.io.z4.t d = tVar.d();
        c0 c0Var = this.b;
        if (c0Var != null) {
            c0Var.a(d);
        }
        return d.c();
    }

    @Override // sdk.pendo.io.y4.j2
    public void a() {
        int i;
        a1 d = this.f1767a.d();
        Hashtable hashtable = new Hashtable();
        int t = d.t();
        if (t == 0 || t == 1) {
            a(hashtable, 1);
            i = 2;
        } else {
            i = d.u();
        }
        a(hashtable, i);
        this.b = null;
        this.c = hashtable;
        this.d = false;
        this.e = true;
    }
}
