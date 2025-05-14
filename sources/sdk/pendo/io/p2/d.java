package sdk.pendo.io.p2;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class d<T> implements Iterable<b<?>> {
    private final T A;
    private final List<b<?>> f;
    private final k f0;
    private final T s;

    d(T t, T t2, List<b<?>> list, k kVar) {
        sdk.pendo.io.o2.h.a(t, "lhs", new Object[0]);
        sdk.pendo.io.o2.h.a(t2, "rhs", new Object[0]);
        sdk.pendo.io.o2.h.a(list, "diffList", new Object[0]);
        this.f = list;
        this.s = t;
        this.A = t2;
        if (kVar == null) {
            this.f0 = k.J0;
        } else {
            this.f0 = kVar;
        }
    }

    public List<b<?>> a() {
        return Collections.unmodifiableList(this.f);
    }

    public int b() {
        return this.f.size();
    }

    @Override // java.lang.Iterable
    public Iterator<b<?>> iterator() {
        return this.f.iterator();
    }

    public String toString() {
        return a(this.f0);
    }

    public String a(k kVar) {
        if (this.f.isEmpty()) {
            return "";
        }
        j jVar = new j(this.s, kVar);
        j jVar2 = new j(this.A, kVar);
        for (b<?> bVar : this.f) {
            jVar.a(bVar.c(), bVar.a());
            jVar2.a(bVar.c(), bVar.b());
        }
        return String.format("%s %s %s", jVar.a(), "differs from", jVar2.a());
    }
}
