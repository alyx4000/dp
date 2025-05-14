package sdk.pendo.io.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import sdk.pendo.io.n1.c;

/* loaded from: classes4.dex */
public class g implements sdk.pendo.io.o1.d {
    private static final sdk.pendo.io.o1.c j = new sdk.pendo.io.o1.c();

    /* renamed from: a, reason: collision with root package name */
    private final sdk.pendo.io.n1.a f1656a;
    private final Object b;
    private final Object c;
    private final sdk.pendo.io.o1.g d;
    private final Object e;
    private final List<sdk.pendo.io.o1.h> f;
    private final boolean h;
    private final HashMap<sdk.pendo.io.o1.g, Object> g = new HashMap<>();
    private int i = 0;

    private static class a implements c.b {

        /* renamed from: a, reason: collision with root package name */
        private final int f1657a;
        private final String b;
        private final Object c;

        private a(int i, String str, Object obj) {
            this.f1657a = i;
            this.b = str;
            this.c = obj;
        }
    }

    public g(sdk.pendo.io.o1.g gVar, Object obj, sdk.pendo.io.n1.a aVar, boolean z) {
        sdk.pendo.io.o1.i.a(gVar, "path can not be null", new Object[0]);
        sdk.pendo.io.o1.i.a(obj, "root can not be null", new Object[0]);
        sdk.pendo.io.o1.i.a(aVar, "configuration can not be null", new Object[0]);
        this.h = z;
        this.d = gVar;
        this.e = obj;
        this.f1656a = aVar;
        this.b = aVar.f().a();
        this.c = aVar.f().a();
        this.f = new ArrayList();
    }

    public void a(String str, sdk.pendo.io.o1.h hVar, Object obj) {
        if (this.h) {
            this.f.add(hVar);
        }
        this.f1656a.f().a(this.b, this.i, obj);
        this.f1656a.f().a(this.c, this.i, str);
        this.i++;
        if (a().d().isEmpty()) {
            return;
        }
        int i = this.i - 1;
        Iterator<sdk.pendo.io.n1.c> it = a().d().iterator();
        while (it.hasNext()) {
            if (c.a.ABORT == it.next().a(new a(i, str, obj))) {
                throw j;
            }
        }
    }

    @Override // sdk.pendo.io.o1.d
    public <T> T b() {
        if (this.i != 0) {
            return (T) this.c;
        }
        throw new sdk.pendo.io.n1.k("No results for path: " + this.d.toString());
    }

    public HashMap<sdk.pendo.io.o1.g, Object> c() {
        return this.g;
    }

    public boolean d() {
        return this.h;
    }

    public sdk.pendo.io.x1.b e() {
        return this.f1656a.f();
    }

    public Set<sdk.pendo.io.n1.i> f() {
        return this.f1656a.e();
    }

    public Object g() {
        return this.e;
    }

    @Override // sdk.pendo.io.o1.d
    public <T> T getValue() {
        return (T) a(true);
    }

    @Override // sdk.pendo.io.o1.d
    public sdk.pendo.io.n1.a a() {
        return this.f1656a;
    }

    @Override // sdk.pendo.io.o1.d
    public <T> T a(boolean z) {
        if (!this.d.c()) {
            return (T) this.b;
        }
        if (this.i == 0) {
            throw new sdk.pendo.io.n1.k("No results for path: " + this.d.toString());
        }
        int d = e().d(this.b);
        T t = d > 0 ? (T) e().a(this.b, d - 1) : null;
        return (t == null || !z) ? t : (T) e().g(t);
    }
}
