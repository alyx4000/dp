package sdk.pendo.io.x7;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
final class k {

    /* renamed from: a, reason: collision with root package name */
    private Map<h, Map<c, j>> f1758a = new HashMap();
    private Set<h> b = new HashSet();

    protected k(Collection<j> collection, boolean z) {
        if (collection != null) {
            for (j jVar : collection) {
                Map<c, j> map = this.f1758a.get(jVar.c());
                if (map == null) {
                    map = new HashMap<>();
                    this.f1758a.put(jVar.c(), map);
                }
                map.put(jVar.b(), jVar);
                if (jVar.e()) {
                    this.b.add(jVar.d());
                }
            }
        }
        if (z) {
            if (collection == null || collection.isEmpty()) {
                throw new sdk.pendo.io.z7.a("No transitions defined");
            }
            for (j jVar2 : collection) {
                h c = jVar2.c();
                if (this.b.contains(c)) {
                    throw new sdk.pendo.io.z7.a("Some events defined for final State: " + c);
                }
                h d = jVar2.d();
                if (!this.b.contains(d) && !this.f1758a.containsKey(d)) {
                    throw new sdk.pendo.io.z7.a("No events defined for non-final State: " + d);
                }
            }
        }
    }

    public j a(h hVar, c cVar) {
        Map<c, j> map = this.f1758a.get(hVar);
        if (map == null) {
            return null;
        }
        return map.get(cVar);
    }

    protected boolean a(h hVar) {
        return this.b.contains(hVar);
    }
}
