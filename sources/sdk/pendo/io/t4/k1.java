package sdk.pendo.io.t4;

import java.math.BigInteger;
import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import sdk.pendo.io.y4.g2;
import sdk.pendo.io.y4.h2;
import sdk.pendo.io.y4.j3;
import sdk.pendo.io.y4.l3;
import sdk.pendo.io.y4.m3;

/* loaded from: classes6.dex */
class k1 extends sdk.pendo.io.y4.a0 implements j1 {
    private static final Logger B = Logger.getLogger(k1.class.getName());
    private static final int C = i0.a("jdk.tls.ephemeralDHKeySize", 2048, 1024, 8192);
    private static final sdk.pendo.io.z4.a[] D = d0();
    private static final boolean E = i0.b("jdk.tls.server.enableCAExtension", true);
    private static final boolean F = i0.b("external.sdk.pendo.io.org.bouncycastle.jsse.server.enableSessionResumption", true);
    private static final boolean G = i0.b("external.sdk.pendo.io.org.bouncycastle.jsse.server.enableTrustedCAKeysExtension", false);
    protected boolean A;
    protected final i1 t;
    protected final s0 u;
    protected final y v;
    protected v0 w;
    protected sdk.pendo.io.r4.e x;
    protected Set<String> y;
    protected sdk.pendo.io.y4.v1 z;

    k1(i1 i1Var, s0 s0Var) {
        super(i1Var.b().c());
        this.v = new y();
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = false;
        this.t = i1Var;
        this.u = s0Var.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static sdk.pendo.io.z4.a[] d0() {
        /*
            java.lang.String r0 = "jdk.tls.server.defaultDHEParameters"
            java.lang.String r0 = sdk.pendo.io.t4.i0.d(r0)
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            java.lang.String r0 = sdk.pendo.io.t4.a0.d(r0)
            java.lang.String r0 = sdk.pendo.io.t4.a0.e(r0)
            int r2 = r0.length()
            r3 = 1
            if (r2 >= r3) goto L1a
            return r1
        L1a:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = -1
        L20:
            int r5 = r5 + r3
            if (r5 >= r2) goto L9c
            char r6 = r0.charAt(r5)
            r7 = 123(0x7b, float:1.72E-43)
            if (r7 == r6) goto L2d
            goto L9c
        L2d:
            int r5 = r5 + 1
            r6 = 44
            int r7 = r0.indexOf(r6, r5)
            if (r7 > r5) goto L38
            goto L9c
        L38:
            int r8 = r7 + 1
            r9 = 125(0x7d, float:1.75E-43)
            int r9 = r0.indexOf(r9, r8)
            if (r9 > r8) goto L43
            goto L9c
        L43:
            java.math.BigInteger r5 = a(r0, r5, r7)     // Catch: java.lang.Exception -> L9c
            java.math.BigInteger r7 = a(r0, r8, r9)     // Catch: java.lang.Exception -> L9c
            sdk.pendo.io.z4.a r8 = sdk.pendo.io.y4.z1.b(r5, r7)     // Catch: java.lang.Exception -> L9c
            if (r8 == 0) goto L55
        L51:
            r4.add(r8)     // Catch: java.lang.Exception -> L9c
            goto L85
        L55:
            r8 = 120(0x78, float:1.68E-43)
            boolean r8 = r5.isProbablePrime(r8)     // Catch: java.lang.Exception -> L9c
            if (r8 != 0) goto L7e
            java.util.logging.Logger r7 = sdk.pendo.io.t4.k1.B     // Catch: java.lang.Exception -> L9c
            java.util.logging.Level r8 = java.util.logging.Level.WARNING     // Catch: java.lang.Exception -> L9c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9c
            r10.<init>()     // Catch: java.lang.Exception -> L9c
            java.lang.String r11 = "Non-prime modulus ignored in security property [jdk.tls.server.defaultDHEParameters]: "
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch: java.lang.Exception -> L9c
            r11 = 16
            java.lang.String r5 = r5.toString(r11)     // Catch: java.lang.Exception -> L9c
            java.lang.StringBuilder r5 = r10.append(r5)     // Catch: java.lang.Exception -> L9c
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L9c
            r7.log(r8, r5)     // Catch: java.lang.Exception -> L9c
            goto L85
        L7e:
            sdk.pendo.io.z4.a r8 = new sdk.pendo.io.z4.a     // Catch: java.lang.Exception -> L9c
            r10 = 0
            r8.<init>(r5, r1, r7, r10)     // Catch: java.lang.Exception -> L9c
            goto L51
        L85:
            int r5 = r9 + 1
            if (r5 < r2) goto L96
            int r0 = r4.size()
            sdk.pendo.io.z4.a[] r0 = new sdk.pendo.io.z4.a[r0]
            java.lang.Object[] r0 = r4.toArray(r0)
            sdk.pendo.io.z4.a[] r0 = (sdk.pendo.io.z4.a[]) r0
            return r0
        L96:
            char r7 = r0.charAt(r5)
            if (r6 == r7) goto L20
        L9c:
            java.util.logging.Logger r0 = sdk.pendo.io.t4.k1.B
            java.util.logging.Level r2 = java.util.logging.Level.WARNING
            java.lang.String r3 = "Invalid syntax for security property [jdk.tls.server.defaultDHEParameters]"
            r0.log(r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.t4.k1.d0():sdk.pendo.io.z4.a[]");
    }

    @Override // sdk.pendo.io.y4.v2
    public int B() {
        return a0.d();
    }

    @Override // sdk.pendo.io.y4.e, sdk.pendo.io.y4.v2
    public synchronized void G() {
        super.G();
        boolean z = true;
        this.A = true;
        j3 f = this.c.f();
        v0 v0Var = this.w;
        if (v0Var == null || v0Var.q() != f) {
            x0 d = this.t.b().d();
            String peerHost = this.t.getPeerHost();
            int peerPort = this.t.getPeerPort();
            z zVar = new z(null, this.x);
            if (!F || l3.d(this.c) || !this.c.e().M()) {
                z = false;
            }
            this.w = d.a(peerHost, peerPort, f, zVar, z);
        }
        this.t.a(new o0(this.c, this.w));
    }

    @Override // sdk.pendo.io.y4.d3
    public sdk.pendo.io.y4.n I() {
        if (!e0()) {
            return null;
        }
        e b = this.t.b();
        sdk.pendo.io.y4.v0 a2 = this.c.a();
        List<w1> a3 = b.a(true, this.u, new sdk.pendo.io.y4.v0[]{a2}, this.v.f1627a);
        y yVar = this.v;
        yVar.b = a3;
        yVar.c = a3;
        Vector<sdk.pendo.io.y4.i1> a4 = w1.a(a3);
        Vector<sdk.pendo.io.c4.c> a5 = E ? a0.a(b.f()) : null;
        if (!l3.e(a2)) {
            return new sdk.pendo.io.y4.n(new short[]{64, 1, 2}, a4, a5);
        }
        byte[] bArr = l3.e;
        y yVar2 = this.v;
        List<w1> list = yVar2.b;
        List<w1> list2 = yVar2.c;
        return new sdk.pendo.io.y4.n(bArr, a4, list != list2 ? w1.a(list2) : null, a5);
    }

    @Override // sdk.pendo.io.y4.d3
    public sdk.pendo.io.y4.v1 N() {
        return this.z;
    }

    @Override // sdk.pendo.io.y4.e
    protected int[] P() {
        return this.t.b().b().a(b(), this.u, f());
    }

    @Override // sdk.pendo.io.y4.e
    protected sdk.pendo.io.y4.v0[] Q() {
        return this.t.b().b().a(this.u);
    }

    @Override // sdk.pendo.io.y4.f
    protected boolean R() {
        return false;
    }

    @Override // sdk.pendo.io.y4.f
    protected boolean T() {
        return false;
    }

    @Override // sdk.pendo.io.y4.f
    protected boolean V() {
        return this.v.g != null;
    }

    @Override // sdk.pendo.io.y4.f
    protected int W() {
        return f0.b(this.v.f1627a);
    }

    @Override // sdk.pendo.io.y4.f
    protected int X() {
        int c = f0.c(this.v.f1627a);
        if (c >= C) {
            return c;
        }
        return 0;
    }

    @Override // sdk.pendo.io.y4.f
    protected Vector<sdk.pendo.io.y4.u0> Y() {
        return a0.a(this.u.d());
    }

    @Override // sdk.pendo.io.y4.f
    protected boolean Z() {
        return this.u.q();
    }

    @Override // sdk.pendo.io.y4.f, sdk.pendo.io.y4.d3
    public sdk.pendo.io.y4.v0 a() {
        sdk.pendo.io.y4.v0 a2 = super.a();
        B.fine("Server selected protocol version: " + this.t.b().b().a(this.u, a2));
        return a2;
    }

    @Override // sdk.pendo.io.y4.f
    protected sdk.pendo.io.y4.u0 a0() {
        if (this.u.h() == null && this.u.p() == null) {
            return super.a0();
        }
        List<String> b = a0.b((Vector<sdk.pendo.io.y4.u0>) this.p);
        String a2 = this.t.a(Collections.unmodifiableList(b));
        if (a2 == null) {
            throw new h2((short) 120);
        }
        if (a2.length() < 1) {
            return null;
        }
        if (b.contains(a2)) {
            return sdk.pendo.io.y4.u0.a(a2);
        }
        throw new h2((short) 120);
    }

    @Override // sdk.pendo.io.y4.f
    protected boolean b0() {
        return this.u.h() == null && this.u.p() == null;
    }

    @Override // sdk.pendo.io.y4.d3
    public sdk.pendo.io.y4.o c() {
        return null;
    }

    @Override // sdk.pendo.io.y4.v2
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public sdk.pendo.io.b5.h b() {
        return this.t.b().c();
    }

    @Override // sdk.pendo.io.y4.f
    protected int d(int i) {
        return f0.b(this.v.f1627a, i);
    }

    protected boolean e0() {
        return this.u.j() || this.u.r();
    }

    @Override // sdk.pendo.io.y4.v2
    public boolean h() {
        return a0.e();
    }

    @Override // sdk.pendo.io.y4.v2
    public boolean i() {
        return !a0.a();
    }

    @Override // sdk.pendo.io.y4.f, sdk.pendo.io.y4.d3
    public Hashtable<Integer, byte[]> k() {
        super.k();
        if (this.x != null) {
            g2.c(this.r);
        }
        return this.r;
    }

    @Override // sdk.pendo.io.y4.d3
    public byte[] m() {
        if (!F || l3.d(this.c)) {
            return null;
        }
        return this.c.k().a(32);
    }

    @Override // sdk.pendo.io.t4.j1
    public synchronized boolean o() {
        return this.A;
    }

    @Override // sdk.pendo.io.y4.v2
    public int p() {
        return a0.c();
    }

    @Override // sdk.pendo.io.y4.f, sdk.pendo.io.y4.d3
    public int q() {
        e b = this.t.b();
        sdk.pendo.io.y4.a1 d = this.c.d();
        f0.b(this.v.f1627a, d.j());
        Vector h = d.h();
        Vector i = d.i();
        this.v.d = b.a(h);
        y yVar = this.v;
        yVar.e = h == i ? yVar.d : b.a(i);
        Logger logger = B;
        if (logger.isLoggable(Level.FINEST)) {
            logger.finest(a0.a("Peer signature_algorithms", this.v.d));
            y yVar2 = this.v;
            List<w1> list = yVar2.e;
            if (list != yVar2.d) {
                logger.finest(a0.a("Peer signature_algorithms_cert", list));
            }
        }
        if (h.f1583a == b.e()) {
            throw new h2((short) 40);
        }
        this.y = new HashSet();
        int q = super.q();
        this.y = null;
        logger.fine("Server selected cipher suite: " + this.t.b().b().a(this.u, q));
        return q;
    }

    @Override // sdk.pendo.io.y4.d3
    public int[] v() {
        this.v.f1627a = this.t.b().a(this.u, new sdk.pendo.io.y4.v0[]{this.c.a()});
        return f0.e(this.v.f1627a);
    }

    @Override // sdk.pendo.io.y4.v2
    public boolean x() {
        return a0.b();
    }

    @Override // sdk.pendo.io.y4.d3
    public j3 a(byte[] bArr) {
        v0 a2;
        x0 d = this.t.b().d();
        if (F && (a2 = d.a(bArr)) != null) {
            j3 q = a2.q();
            if (a(a2, q)) {
                this.w = a2;
                return q;
            }
        }
        a0.a(this.t);
        return null;
    }

    @Override // sdk.pendo.io.y4.v2
    public void b(boolean z) {
        if (!z && !i0.b("sun.security.ssl.allowLegacyHelloMessages", true)) {
            throw new h2((short) 40);
        }
    }

    @Override // sdk.pendo.io.y4.f
    protected int c(int i) {
        return f0.c(this.v.f1627a, Math.max(i, C));
    }

    @Override // sdk.pendo.io.y4.v2
    public boolean d() {
        return a0.f();
    }

    private void a(LinkedHashMap<String, w1> linkedHashMap, String str) {
        for (Map.Entry<String, w1> entry : linkedHashMap.entrySet()) {
            String key = entry.getKey();
            if (key.equals(str)) {
                return;
            }
            this.y.add(key);
            Logger logger = B;
            if (logger.isLoggable(Level.FINER)) {
                logger.finer("Server found no credentials for signature scheme '" + entry.getValue() + "' (keyType '" + key + "')");
            }
        }
    }

    @Override // sdk.pendo.io.y4.f
    protected boolean b(int i) {
        sdk.pendo.io.y4.v1 a2 = a(this.v.g, i);
        if (a2 == null) {
            B.finer("Server found no credentials for cipher suite: " + p0.a(i));
            return false;
        }
        boolean b = super.b(i);
        if (b) {
            this.z = a2;
        }
        return b;
    }

    protected sdk.pendo.io.y4.v1 c(Principal[] principalArr, int i) {
        String b = a0.b(i);
        if (this.y.contains(b)) {
            return null;
        }
        sdk.pendo.io.r4.l a2 = this.t.a(new String[]{b}, principalArr);
        if (a2 != null) {
            return 1 == i ? a0.a(b(), a2) : a0.a(this.c, b(), a2, null);
        }
        this.y.add(b);
        return null;
    }

    protected boolean a(v0 v0Var, j3 j3Var) {
        sdk.pendo.io.y4.g1 c;
        if (j3Var != null && j3Var.b()) {
            sdk.pendo.io.y4.v0 s = this.c.d().s();
            if (l3.e(s) || (c = j3Var.c()) == null || !s.b(c.g()) || !sdk.pendo.io.d5.a.b(r(), c.c()) || !sdk.pendo.io.d5.a.b(this.f, c.c()) || !c.k()) {
                return false;
            }
            z p = v0Var.p();
            sdk.pendo.io.r4.e eVar = this.x;
            sdk.pendo.io.r4.e b = p.b();
            if (a0.a(eVar, b)) {
                return true;
            }
            B.finest("Session not resumable - SNI mismatch; connection: " + eVar + ", session: " + b);
            return false;
        }
        return false;
    }

    protected sdk.pendo.io.y4.v1 b(Principal[] principalArr, int i) {
        Logger logger;
        StringBuilder sb;
        sdk.pendo.io.s4.a c = this.u.c();
        short j = l3.j(i);
        LinkedHashMap<String, w1> linkedHashMap = new LinkedHashMap<>();
        for (w1 w1Var : this.v.d) {
            if (l3.b(w1Var.h(), i)) {
                String b = j == w1Var.f() ? a0.b(i) : w1Var.d();
                if (!this.y.contains(b) && !linkedHashMap.containsKey(b) && w1Var.a(c, false, true, this.v.f1627a)) {
                    linkedHashMap.put(b, w1Var);
                }
            }
        }
        if (linkedHashMap.isEmpty()) {
            logger = B;
            sb = new StringBuilder("Server (1.2) has no key types to try for KeyExchangeAlgorithm ");
        } else {
            sdk.pendo.io.r4.l a2 = this.t.a((String[]) linkedHashMap.keySet().toArray(l3.i), principalArr);
            if (a2 != null) {
                String a3 = a2.a();
                a(linkedHashMap, a3);
                w1 w1Var2 = linkedHashMap.get(a3);
                if (w1Var2 == null) {
                    throw new h2((short) 80, "Key manager returned invalid key type");
                }
                Logger logger2 = B;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine("Server (1.2) selected credentials for signature scheme '" + w1Var2 + "' (keyType '" + a3 + "'), with private key algorithm '" + a0.a(a2.c()) + "'");
                }
                return a0.a(this.c, b(), a2, w1Var2.g());
            }
            a(linkedHashMap, (String) null);
            logger = B;
            sb = new StringBuilder("Server (1.2) did not select any credentials for KeyExchangeAlgorithm ");
        }
        logger.fine(sb.append(i).toString());
        return null;
    }

    @Override // sdk.pendo.io.y4.e, sdk.pendo.io.y4.v2
    public void a(short s, short s2, String str, Throwable th) {
        Level level;
        if (s == 1) {
            level = Level.FINE;
        } else {
            level = s2 == 80 ? Level.WARNING : Level.INFO;
        }
        Logger logger = B;
        if (logger.isLoggable(level)) {
            String a2 = a0.a("Server raised", s, s2);
            if (str != null) {
                a2 = a2 + ": " + str;
            }
            logger.log(level, a2, th);
        }
    }

    @Override // sdk.pendo.io.y4.e, sdk.pendo.io.y4.v2
    public void a(short s, short s2) {
        super.a(s, s2);
        Level level = s == 1 ? Level.FINE : Level.INFO;
        Logger logger = B;
        if (logger.isLoggable(level)) {
            logger.log(level, a0.a("Server received", s, s2));
        }
    }

    @Override // sdk.pendo.io.y4.d3
    public void a(sdk.pendo.io.y4.l lVar) {
        if (!e0()) {
            throw new h2((short) 80);
        }
        if (lVar != null && !lVar.d()) {
            this.t.checkClientTrusted(a0.b(b(), lVar), "TLS-client-auth");
        } else if (this.u.j()) {
            throw new h2(l3.d(this.c) ? (short) 116 : (short) 40);
        }
    }

    @Override // sdk.pendo.io.y4.d3
    public void a(j3 j3Var) {
        Logger logger;
        String str;
        byte[] a2 = j3Var.a();
        v0 v0Var = this.w;
        if (v0Var != null && v0Var.q() == j3Var) {
            B.fine("Server resumed session: " + sdk.pendo.io.e5.f.b(a2));
        } else {
            this.w = null;
            if (l3.g(a2)) {
                logger = B;
                str = "Server did not specify a session ID";
            } else {
                logger = B;
                str = "Server specified new session: " + sdk.pendo.io.e5.f.b(a2);
            }
            logger.fine(str);
            a0.a(this.t);
        }
        i1 i1Var = this.t;
        i1Var.a(i1Var.b().d(), this.c.d(), this.v, this.w);
    }

    private static BigInteger a(String str, int i, int i2) {
        return new BigInteger(str.substring(i, i2), 16);
    }

    @Override // sdk.pendo.io.y4.f, sdk.pendo.io.y4.d3
    public void a(Hashtable hashtable) {
        Logger logger;
        String str;
        super.a(hashtable);
        Vector g = this.c.d().g();
        if (g != null) {
            Collection<sdk.pendo.io.r4.d> m = this.u.m();
            if (m == null || m.isEmpty()) {
                logger = B;
                str = "Server ignored SNI (no matchers specified)";
            } else {
                sdk.pendo.io.r4.e a2 = a0.a((Vector<sdk.pendo.io.y4.c1>) g, m);
                this.x = a2;
                if (a2 == null) {
                    throw new h2((short) 112);
                }
                logger = B;
                str = "Server accepted SNI: " + this.x;
            }
            logger.fine(str);
        }
        if (l3.d(this.c)) {
            this.v.g = a0.d((Vector<sdk.pendo.io.c4.c>) g2.i(hashtable));
        } else if (G) {
            this.v.g = a0.c((Vector<m3>) this.n);
        }
    }

    protected sdk.pendo.io.y4.v1 a(Principal[] principalArr, int i) {
        int i2 = l3.i(i);
        if (i2 == 0) {
            return a(principalArr, l3.e);
        }
        if (i2 == 1 || i2 == 3 || i2 == 5 || i2 == 17 || i2 == 19) {
            return (1 == i2 || !l3.b(this.c.a())) ? c(principalArr, i2) : b(principalArr, i2);
        }
        return null;
    }

    protected sdk.pendo.io.y4.v1 a(Principal[] principalArr, byte[] bArr) {
        Logger logger;
        String str;
        sdk.pendo.io.s4.a c = this.u.c();
        LinkedHashMap<String, w1> linkedHashMap = new LinkedHashMap<>();
        for (w1 w1Var : this.v.d) {
            String e = w1Var.e();
            if (!this.y.contains(e) && !linkedHashMap.containsKey(e) && w1Var.a(c, true, false, this.v.f1627a)) {
                linkedHashMap.put(e, w1Var);
            }
        }
        if (linkedHashMap.isEmpty()) {
            logger = B;
            str = "Server (1.3) found no usable signature schemes";
        } else {
            sdk.pendo.io.r4.l a2 = this.t.a((String[]) linkedHashMap.keySet().toArray(l3.i), principalArr);
            if (a2 != null) {
                String a3 = a2.a();
                a(linkedHashMap, a3);
                w1 w1Var2 = linkedHashMap.get(a3);
                if (w1Var2 == null) {
                    throw new h2((short) 80, "Key manager returned invalid key type");
                }
                Logger logger2 = B;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine("Server (1.3) selected credentials for signature scheme '" + w1Var2 + "' (keyType '" + a3 + "'), with private key algorithm '" + a0.a(a2.c()) + "'");
                }
                return a0.a(this.c, b(), a2, w1Var2.g(), bArr);
            }
            a(linkedHashMap, (String) null);
            logger = B;
            str = "Server (1.3) did not select any credentials";
        }
        logger.fine(str);
        return null;
    }
}
