package sdk.pendo.io.x7;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class j {
    private static ThreadLocal<List<j>> e = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    private c f1757a;
    private h b;
    private h c;
    private boolean d;

    protected j(c cVar, h hVar, boolean z) {
        this.f1757a = cVar;
        this.c = hVar;
        this.d = z;
        a(this);
    }

    protected static List<j> a() {
        List<j> list = e.get();
        e.remove();
        return list;
    }

    public c b() {
        return this.f1757a;
    }

    public h c() {
        return this.b;
    }

    public h d() {
        return this.c;
    }

    public boolean e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f1757a.equals(jVar.f1757a) && this.b.equals(jVar.b);
    }

    public int hashCode() {
        return (this.f1757a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "Transition{event=" + this.f1757a + ", stateFrom=" + this.b + ", stateTo=" + this.c + '}';
    }

    private static void a(j jVar) {
        List<j> list = e.get();
        if (list == null) {
            list = new ArrayList<>();
            e.set(list);
        }
        list.add(jVar);
    }

    protected void a(h hVar) {
        this.b = hVar;
    }

    public j a(j... jVarArr) {
        for (j jVar : jVarArr) {
            jVar.a(this.c);
        }
        return this;
    }
}
