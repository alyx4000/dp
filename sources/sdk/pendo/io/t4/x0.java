package sdk.pendo.io.t4;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import sdk.pendo.io.y4.j3;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
class x0 implements SSLSessionContext {
    private static final Logger g = Logger.getLogger(x0.class.getName());
    private static final int h = i0.a("javax.net.ssl.sessionCacheSize", 20480, 0, Integer.MAX_VALUE);
    protected final e d;

    /* renamed from: a, reason: collision with root package name */
    protected final Map<sdk.pendo.io.y4.f1, b> f1624a = new a(16, 0.75f, true);
    protected final Map<String, b> b = new HashMap();
    protected final ReferenceQueue<v0> c = new ReferenceQueue<>();
    protected int e = h;
    protected int f = 86400;

    class a extends LinkedHashMap<sdk.pendo.io.y4.f1, b> {
        a(int i, float f, boolean z) {
            super(i, f, z);
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<sdk.pendo.io.y4.f1, b> entry) {
            boolean z = x0.this.e > 0 && size() > x0.this.e;
            if (z) {
                x0.this.c(entry.getValue());
            }
            return z;
        }
    }

    private static final class b extends SoftReference<v0> {

        /* renamed from: a, reason: collision with root package name */
        private final sdk.pendo.io.y4.f1 f1625a;
        private final String b;

        b(sdk.pendo.io.y4.f1 f1Var, v0 v0Var, ReferenceQueue<v0> referenceQueue) {
            super(v0Var, referenceQueue);
            if (f1Var == null || v0Var == null || referenceQueue == null) {
                throw null;
            }
            this.f1625a = f1Var;
            this.b = x0.b(v0Var);
        }

        public String a() {
            return this.b;
        }

        public sdk.pendo.io.y4.f1 b() {
            return this.f1625a;
        }
    }

    x0(e eVar) {
        this.d = eVar;
    }

    private void c() {
        int i = 0;
        while (true) {
            b bVar = (b) this.c.poll();
            if (bVar == null) {
                break;
            }
            b(bVar);
            i++;
        }
        if (i > 0) {
            g.fine("Processed " + i + " session entries (soft references) from the reference queue");
        }
    }

    private void d() {
        c();
        long a2 = a(System.currentTimeMillis());
        Iterator<b> it = this.f1624a.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (a(next, a2)) {
                it.remove();
                c(next);
            }
        }
    }

    p0 b() {
        return this.d.b();
    }

    @Override // javax.net.ssl.SSLSessionContext
    public synchronized Enumeration<byte[]> getIds() {
        ArrayList arrayList;
        d();
        arrayList = new ArrayList(this.f1624a.size());
        Iterator<sdk.pendo.io.y4.f1> it = this.f1624a.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        return Collections.enumeration(arrayList);
    }

    @Override // javax.net.ssl.SSLSessionContext
    public SSLSession getSession(byte[] bArr) {
        if (bArr != null) {
            return a(bArr);
        }
        throw new NullPointerException("'sessionID' cannot be null");
    }

    @Override // javax.net.ssl.SSLSessionContext
    public synchronized int getSessionCacheSize() {
        return this.e;
    }

    @Override // javax.net.ssl.SSLSessionContext
    public synchronized int getSessionTimeout() {
        return this.f;
    }

    @Override // javax.net.ssl.SSLSessionContext
    public synchronized void setSessionCacheSize(int i) {
        int size;
        if (this.e == i) {
            return;
        }
        if (i < 0) {
            throw new IllegalArgumentException("'size' cannot be < 0");
        }
        this.e = i;
        d();
        if (this.e > 0 && (size = this.f1624a.size()) > this.e) {
            Iterator<b> it = this.f1624a.values().iterator();
            for (size = this.f1624a.size(); it.hasNext() && size > this.e; size--) {
                b next = it.next();
                it.remove();
                c(next);
            }
        }
    }

    @Override // javax.net.ssl.SSLSessionContext
    public synchronized void setSessionTimeout(int i) {
        if (this.f == i) {
            return;
        }
        if (i < 0) {
            throw new IllegalArgumentException("'seconds' cannot be < 0");
        }
        this.f = i;
        d();
    }

    private static String b(String str, int i) {
        if (str == null || i < 0) {
            return null;
        }
        return (str + ':' + Integer.toString(i)).toLowerCase(Locale.ENGLISH);
    }

    synchronized void c(byte[] bArr) {
        b bVar = (b) b((Map<sdk.pendo.io.y4.f1, V>) this.f1624a, b(bArr));
        if (bVar != null) {
            c(bVar);
        }
    }

    private v0 a(b bVar) {
        if (bVar == null) {
            return null;
        }
        v0 v0Var = bVar.get();
        if (v0Var != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!a(bVar, a(currentTimeMillis))) {
                v0Var.a(currentTimeMillis);
                return v0Var;
            }
        }
        b(bVar);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(v0 v0Var) {
        if (v0Var == null) {
            return null;
        }
        return b(v0Var.getPeerHost(), v0Var.getPeerPort());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(b bVar) {
        return b(this.b, bVar.a(), bVar);
    }

    private long a(long j) {
        int i = this.f;
        if (i < 1) {
            return Long.MIN_VALUE;
        }
        return j - (i * 1000);
    }

    private static sdk.pendo.io.y4.f1 b(byte[] bArr) {
        if (l3.g(bArr)) {
            return null;
        }
        return new sdk.pendo.io.y4.f1(bArr);
    }

    private static <K, V> V b(Map<K, V> map, K k) {
        map.getClass();
        if (k == null) {
            return null;
        }
        return map.remove(k);
    }

    sdk.pendo.io.b5.h a() {
        return this.d.c();
    }

    private static <K, V> boolean b(Map<K, V> map, K k, V v) {
        if (map == null || v == null) {
            throw null;
        }
        if (k == null) {
            return false;
        }
        V remove = map.remove(k);
        if (remove == v) {
            return true;
        }
        if (remove == null) {
            return false;
        }
        map.put(k, remove);
        return false;
    }

    synchronized v0 a(String str, int i) {
        v0 a2;
        c();
        b bVar = (b) a((Map<String, V>) this.b, b(str, i));
        a2 = a(bVar);
        if (a2 != null) {
            this.f1624a.get(bVar.b());
        }
        return a2;
    }

    private void b(b bVar) {
        b(this.f1624a, bVar.b(), bVar);
        c(bVar);
    }

    synchronized v0 a(byte[] bArr) {
        c();
        return a((b) a((Map<sdk.pendo.io.y4.f1, V>) this.f1624a, b(bArr)));
    }

    private boolean a(b bVar, long j) {
        v0 v0Var = bVar.get();
        if (v0Var == null) {
            return true;
        }
        if (v0Var.getCreationTime() < j) {
            v0Var.o();
        }
        return !v0Var.isValid();
    }

    private static <K, V> void a(Map<K, V> map, K k, V v) {
        if (map == null || v == null) {
            throw null;
        }
        if (k != null) {
            map.put(k, v);
        }
    }

    private static <K, V> V a(Map<K, V> map, K k) {
        map.getClass();
        if (k == null) {
            return null;
        }
        return map.get(k);
    }

    synchronized v0 a(String str, int i, j3 j3Var, z zVar, boolean z) {
        c();
        if (!z) {
            return new v0(this, str, i, j3Var, zVar);
        }
        sdk.pendo.io.y4.f1 b2 = b(j3Var.a());
        b bVar = (b) a((Map<sdk.pendo.io.y4.f1, V>) this.f1624a, b2);
        v0 v0Var = bVar == null ? null : bVar.get();
        if (v0Var == null || v0Var.q() != j3Var) {
            v0 v0Var2 = new v0(this, str, i, j3Var, zVar);
            if (b2 != null) {
                bVar = new b(b2, v0Var2, this.c);
                this.f1624a.put(b2, bVar);
            }
            v0Var = v0Var2;
        }
        if (bVar != null) {
            a(this.b, bVar.a(), bVar);
        }
        return v0Var;
    }
}
