package sdk.pendo.io.t4;

import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.x500.X500Principal;
import sdk.pendo.io.y4.e3;
import sdk.pendo.io.y4.g2;
import sdk.pendo.io.y4.h2;
import sdk.pendo.io.y4.j3;
import sdk.pendo.io.y4.l3;
import sdk.pendo.io.y4.m3;

/* loaded from: classes6.dex */
class g1 extends sdk.pendo.io.y4.v implements j1 {
    private static final Logger o = Logger.getLogger(g1.class.getName());
    private static final boolean p = i0.b("jdk.tls.client.enableCAExtension", false);
    private static final boolean q = i0.b("external.sdk.pendo.io.org.bouncycastle.jsse.client.enableSessionResumption", true);
    private static final boolean r = i0.b("jdk.tls.client.enableStatusRequestExtension", true);
    private static final boolean s = i0.b("external.sdk.pendo.io.org.bouncycastle.jsse.client.enableTrustedCAKeysExtension", false);
    private static final boolean t = i0.b("jsse.enableSNIExtension", true);
    protected final i1 j;
    protected final s0 k;
    protected final y l;
    protected v0 m;
    protected boolean n;

    class a implements sdk.pendo.io.y4.l1 {
        a() {
        }

        @Override // sdk.pendo.io.y4.l1
        public sdk.pendo.io.y4.v1 a(sdk.pendo.io.y4.n nVar) {
            e b = g1.this.j.b();
            sdk.pendo.io.y4.a1 d = ((sdk.pendo.io.y4.a) g1.this).c.d();
            sdk.pendo.io.y4.v0 s = d.s();
            boolean e = l3.e(s);
            Vector B = d.B();
            Vector C = d.C();
            g1.this.l.d = b.a(B);
            y yVar = g1.this.l;
            yVar.e = B == C ? yVar.d : b.a(C);
            if (g1.o.isLoggable(Level.FINEST)) {
                g1.o.finest(a0.a("Peer signature_algorithms", g1.this.l.d));
                y yVar2 = g1.this.l;
                if (yVar2.e != yVar2.d) {
                    g1.o.finest(a0.a("Peer signature_algorithms_cert", g1.this.l.e));
                }
            }
            if (h.f1583a == b.e()) {
                return null;
            }
            X500Principal[] d2 = a0.d((Vector<sdk.pendo.io.c4.c>) nVar.a());
            byte[] b2 = nVar.b();
            if (e != (b2 != null)) {
                throw new h2((short) 80);
            }
            short[] c = nVar.c();
            if (e == (c == null)) {
                return e ? g1.this.a((Principal[]) d2, b2) : l3.b(s) ? g1.this.a(d2, c) : g1.this.b(d2, c);
            }
            throw new h2((short) 80);
        }

        @Override // sdk.pendo.io.y4.l1
        public void a(e3 e3Var) {
            if (e3Var == null || e3Var.a() == null || e3Var.a().d()) {
                throw new h2((short) 40);
            }
            X509Certificate[] b = a0.b(g1.this.b(), e3Var.a());
            String a2 = a0.a(((sdk.pendo.io.y4.a) g1.this).c.d().n());
            g1.this.l.f = a0.a(e3Var.c());
            g1.this.j.checkServerTrusted(b, a2);
        }
    }

    g1(i1 i1Var, s0 s0Var) {
        super(i1Var.b().c());
        this.l = new y();
        this.m = null;
        this.n = false;
        this.j = i1Var;
        this.k = s0Var.b();
    }

    @Override // sdk.pendo.io.y4.m1
    public j3 A() {
        j3 q2;
        sdk.pendo.io.y4.g1 a2;
        if (q) {
            v0 o2 = this.k.o();
            if (o2 == null) {
                o2 = this.j.b().a().a(this.j.getPeerHost(), this.j.getPeerPort());
            }
            if (o2 != null && (a2 = a(o2, (q2 = o2.q()))) != null) {
                this.m = o2;
                if (!this.j.getEnableSessionCreation()) {
                    this.e = new int[]{a2.c()};
                }
                return q2;
            }
        }
        a0.a(this.j);
        return null;
    }

    @Override // sdk.pendo.io.y4.v2
    public int B() {
        return a0.d();
    }

    @Override // sdk.pendo.io.y4.m1
    public sdk.pendo.io.y4.x1 C() {
        return new m0();
    }

    @Override // sdk.pendo.io.y4.e, sdk.pendo.io.y4.v2
    public synchronized void G() {
        super.G();
        boolean z = true;
        this.n = true;
        j3 f = this.c.f();
        v0 v0Var = this.m;
        if (v0Var == null || v0Var.q() != f) {
            x0 a2 = this.j.b().a();
            String peerHost = this.j.getPeerHost();
            int peerPort = this.j.getPeerPort();
            z zVar = new z(this.k.g(), null);
            if (!q || l3.d(this.c)) {
                z = false;
            }
            this.m = a2.a(peerHost, peerPort, f, zVar, z);
        }
        this.j.a(new o0(this.c, this.m));
    }

    @Override // sdk.pendo.io.y4.m1
    public sdk.pendo.io.y4.l1 H() {
        return new a();
    }

    @Override // sdk.pendo.io.y4.e
    protected int[] P() {
        return this.j.b().b().a(b(), this.k, f());
    }

    @Override // sdk.pendo.io.y4.e
    protected sdk.pendo.io.y4.v0[] Q() {
        return this.j.b().b().a(this.k);
    }

    @Override // sdk.pendo.io.y4.a
    protected Vector<sdk.pendo.io.c4.c> R() {
        if (p) {
            return a0.a(this.j.b().f());
        }
        return null;
    }

    @Override // sdk.pendo.io.y4.a
    protected sdk.pendo.io.y4.p S() {
        if (r) {
            return new sdk.pendo.io.y4.p((short) 1, new sdk.pendo.io.y4.r0(null, null));
        }
        return null;
    }

    @Override // sdk.pendo.io.y4.a
    protected Vector<sdk.pendo.io.y4.q> T() {
        if (!r) {
            return null;
        }
        sdk.pendo.io.y4.r0 r0Var = new sdk.pendo.io.y4.r0(null, null);
        Vector<sdk.pendo.io.y4.q> vector = new Vector<>(2);
        vector.add(new sdk.pendo.io.y4.q((short) 2, r0Var));
        vector.add(new sdk.pendo.io.y4.q((short) 1, r0Var));
        return vector;
    }

    @Override // sdk.pendo.io.y4.a
    protected Vector<sdk.pendo.io.y4.u0> V() {
        return a0.a(this.k.d());
    }

    @Override // sdk.pendo.io.y4.a
    protected Vector<sdk.pendo.io.y4.c1> W() {
        String e;
        if (!t) {
            return null;
        }
        List<sdk.pendo.io.r4.e> n = this.k.n();
        if (n == null && (e = this.j.e()) != null && e.indexOf(46) > 0 && !sdk.pendo.io.d5.c.a(e)) {
            try {
                n = Collections.singletonList(new sdk.pendo.io.r4.c(e));
            } catch (RuntimeException unused) {
                o.fine("Failed to add peer host as default SNI host_name: " + e);
            }
        }
        if (n == null || n.isEmpty()) {
            return null;
        }
        Vector<sdk.pendo.io.y4.c1> vector = new Vector<>(n.size());
        for (sdk.pendo.io.r4.e eVar : n) {
            vector.add(new sdk.pendo.io.y4.c1((short) eVar.b(), eVar.a()));
        }
        return vector;
    }

    @Override // sdk.pendo.io.y4.a
    protected Vector<sdk.pendo.io.y4.i1> X() {
        List<w1> a2 = this.j.b().a(false, this.k, f(), this.l.f1627a);
        y yVar = this.l;
        yVar.b = a2;
        yVar.c = a2;
        return w1.a(a2);
    }

    @Override // sdk.pendo.io.y4.a
    protected Vector<sdk.pendo.io.y4.i1> Y() {
        return null;
    }

    @Override // sdk.pendo.io.y4.a
    protected Vector<m3> Z() {
        Vector<sdk.pendo.io.c4.c> a2;
        if (!s || (a2 = a0.a(this.j.b().f())) == null) {
            return null;
        }
        Vector<m3> vector = new Vector<>(a2.size());
        Iterator<sdk.pendo.io.c4.c> it = a2.iterator();
        while (it.hasNext()) {
            vector.add(new m3((short) 2, it.next()));
        }
        return vector;
    }

    @Override // sdk.pendo.io.y4.v2
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public sdk.pendo.io.b5.h b() {
        return this.j.b().c();
    }

    @Override // sdk.pendo.io.y4.a, sdk.pendo.io.y4.m1
    public void c(Hashtable hashtable) {
        super.c(hashtable);
        if (this.c.d().g() != null) {
            o.finer("Server accepted SNI?: " + g2.E(hashtable));
        }
    }

    @Override // sdk.pendo.io.y4.a
    protected Vector<Integer> d(Vector vector) {
        return f0.d(this.l.f1627a);
    }

    @Override // sdk.pendo.io.y4.v2
    public boolean h() {
        return a0.e();
    }

    @Override // sdk.pendo.io.y4.v2
    public boolean i() {
        return !a0.a();
    }

    @Override // sdk.pendo.io.t4.j1
    public synchronized boolean o() {
        return this.n;
    }

    @Override // sdk.pendo.io.y4.v2
    public int p() {
        return a0.c();
    }

    @Override // sdk.pendo.io.y4.a, sdk.pendo.io.y4.e, sdk.pendo.io.y4.v2
    public void u() {
        super.u();
        e b = this.j.b();
        sdk.pendo.io.y4.v0[] f = f();
        this.l.f1627a = b.a(this.k, f);
    }

    @Override // sdk.pendo.io.y4.v2
    public boolean x() {
        return a0.b();
    }

    protected String[] a(short[] sArr) {
        String[] strArr = new String[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            strArr[i] = a0.a(sArr[i]);
        }
        return strArr;
    }

    @Override // sdk.pendo.io.y4.v2
    public boolean d() {
        return a0.f();
    }

    protected sdk.pendo.io.y4.g1 a(v0 v0Var, j3 j3Var) {
        sdk.pendo.io.y4.g1 c;
        if (j3Var == null || !j3Var.b() || (c = j3Var.c()) == null || !sdk.pendo.io.y4.v0.a(f(), c.g()) || !sdk.pendo.io.d5.a.b(r(), c.c()) || l3.e(c.g())) {
            return null;
        }
        String g = this.k.g();
        if (g != null) {
            String a2 = v0Var.p().a();
            if (!g.equalsIgnoreCase(a2)) {
                o.finer("Session not resumable - endpoint ID algorithm mismatch; connection: " + g + ", session: " + a2);
                return null;
            }
        }
        return c;
    }

    @Override // sdk.pendo.io.y4.v2
    public void b(boolean z) {
        if (!z && !i0.b("sun.security.ssl.allowLegacyHelloMessages", true)) {
            throw new h2((short) 40);
        }
    }

    private void a(LinkedHashMap<String, w1> linkedHashMap, String str) {
        for (Map.Entry<String, w1> entry : linkedHashMap.entrySet()) {
            String key = entry.getKey();
            if (key.equals(str)) {
                return;
            }
            Logger logger = o;
            if (logger.isLoggable(Level.FINER)) {
                logger.finer("Client found no credentials for signature scheme '" + entry.getValue() + "' (keyType '" + key + "')");
            }
        }
    }

    @Override // sdk.pendo.io.y4.a, sdk.pendo.io.y4.m1
    public void b(sdk.pendo.io.y4.v0 v0Var) {
        o.fine("Client notified of selected protocol version: " + this.j.b().b().a(this.k, v0Var));
        super.b(v0Var);
    }

    @Override // sdk.pendo.io.y4.e, sdk.pendo.io.y4.v2
    public void a(short s2, short s3, String str, Throwable th) {
        super.a(s2, s3, str, th);
        Level level = s2 == 1 ? Level.FINE : s3 == 80 ? Level.WARNING : Level.INFO;
        Logger logger = o;
        if (logger.isLoggable(level)) {
            String a2 = a0.a("Client raised", s2, s3);
            if (str != null) {
                a2 = a2 + ": " + str;
            }
            logger.log(level, a2, th);
        }
    }

    @Override // sdk.pendo.io.y4.m1
    public void b(byte[] bArr) {
        v0 v0Var;
        if ((l3.g(bArr) || (v0Var = this.m) == null || !sdk.pendo.io.d5.a.a(bArr, v0Var.getId())) ? false : true) {
            o.fine("Server resumed session: " + sdk.pendo.io.e5.f.b(bArr));
        } else {
            this.m = null;
            if (l3.g(bArr)) {
                o.fine("Server did not specify a session ID");
            } else {
                o.fine("Server specified new session: " + sdk.pendo.io.e5.f.b(bArr));
            }
            a0.a(this.j);
        }
        i1 i1Var = this.j;
        i1Var.a(i1Var.b().a(), this.c.d(), this.l, this.m);
    }

    @Override // sdk.pendo.io.y4.e, sdk.pendo.io.y4.v2
    public void a(short s2, short s3) {
        super.a(s2, s3);
        Level level = s2 == 1 ? Level.FINE : Level.INFO;
        Logger logger = o;
        if (logger.isLoggable(level)) {
            logger.log(level, a0.a("Client received", s2, s3));
        }
    }

    @Override // sdk.pendo.io.y4.a, sdk.pendo.io.y4.m1
    public void b(j3 j3Var) {
        if (j3Var == null) {
            a0.a(this.j);
        }
        super.b(j3Var);
    }

    @Override // sdk.pendo.io.y4.a, sdk.pendo.io.y4.m1
    public void a(int i) {
        o.fine("Client notified of selected cipher suite: " + this.j.b().b().a(this.k, i));
        super.a(i);
    }

    protected sdk.pendo.io.y4.v1 b(Principal[] principalArr, short[] sArr) {
        sdk.pendo.io.r4.l b;
        String[] a2 = a(sArr);
        if (a2.length >= 1 && (b = this.j.b(a2, principalArr)) != null) {
            return a0.a(this.c, b(), b, null);
        }
        return null;
    }

    protected sdk.pendo.io.y4.v1 a(Principal[] principalArr, short[] sArr) {
        Logger logger;
        String str;
        short a2;
        LinkedHashMap<String, w1> linkedHashMap = new LinkedHashMap<>();
        for (w1 w1Var : this.l.d) {
            String d = w1Var.d();
            if (!linkedHashMap.containsKey(d) && (a2 = sdk.pendo.io.y4.h1.a(w1Var.f())) >= 0 && sdk.pendo.io.d5.a.b(sArr, a2) && this.l.b.contains(w1Var)) {
                linkedHashMap.put(d, w1Var);
            }
        }
        if (linkedHashMap.isEmpty()) {
            logger = o;
            str = "Client (1.2) found no usable signature schemes";
        } else {
            sdk.pendo.io.r4.l b = this.j.b((String[]) linkedHashMap.keySet().toArray(l3.i), principalArr);
            if (b != null) {
                String a3 = b.a();
                a(linkedHashMap, a3);
                w1 w1Var2 = linkedHashMap.get(a3);
                if (w1Var2 == null) {
                    throw new h2((short) 80, "Key manager returned invalid key type");
                }
                Logger logger2 = o;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine("Client (1.2) selected credentials for signature scheme '" + w1Var2 + "' (keyType '" + a3 + "'), with private key algorithm '" + a0.a(b.c()) + "'");
                }
                return a0.a(this.c, b(), b, w1Var2.g());
            }
            a(linkedHashMap, (String) null);
            logger = o;
            str = "Client (1.2) did not select any credentials";
        }
        logger.fine(str);
        return null;
    }

    protected sdk.pendo.io.y4.v1 a(Principal[] principalArr, byte[] bArr) {
        Logger logger;
        String str;
        LinkedHashMap<String, w1> linkedHashMap = new LinkedHashMap<>();
        for (w1 w1Var : this.l.d) {
            if (w1Var.k() && this.l.b.contains(w1Var)) {
                String e = w1Var.e();
                if (!linkedHashMap.containsKey(e)) {
                    linkedHashMap.put(e, w1Var);
                }
            }
        }
        if (linkedHashMap.isEmpty()) {
            logger = o;
            str = "Client (1.3) found no usable signature schemes";
        } else {
            sdk.pendo.io.r4.l b = this.j.b((String[]) linkedHashMap.keySet().toArray(l3.i), principalArr);
            if (b != null) {
                String a2 = b.a();
                a(linkedHashMap, a2);
                w1 w1Var2 = linkedHashMap.get(a2);
                if (w1Var2 == null) {
                    throw new h2((short) 80, "Key manager returned invalid key type");
                }
                Logger logger2 = o;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine("Client (1.3) selected credentials for signature scheme '" + w1Var2 + "' (keyType '" + a2 + "'), with private key algorithm '" + a0.a(b.c()) + "'");
                }
                return a0.a(this.c, b(), b, w1Var2.g(), bArr);
            }
            a(linkedHashMap, (String) null);
            logger = o;
            str = "Client (1.3) did not select any credentials";
        }
        logger.fine(str);
        return null;
    }
}
