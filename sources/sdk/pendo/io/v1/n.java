package sdk.pendo.io.v1;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class n extends j {
    private final Collection<sdk.pendo.io.n1.l> f;

    n(Collection<sdk.pendo.io.n1.l> collection) {
        this.f = collection;
    }

    public boolean a(Object obj, Object obj2, sdk.pendo.io.n1.a aVar, g gVar) {
        m mVar = new m(obj, obj2, aVar, gVar.c());
        Iterator<sdk.pendo.io.n1.l> it = this.f.iterator();
        while (it.hasNext()) {
            if (!it.next().a(mVar)) {
                return false;
            }
        }
        return true;
    }

    @Override // sdk.pendo.io.v1.j
    public boolean e() {
        return false;
    }

    n(sdk.pendo.io.n1.l lVar) {
        this.f = Collections.singletonList(lVar);
    }

    @Override // sdk.pendo.io.v1.j
    public void a(String str, sdk.pendo.io.o1.h hVar, Object obj, g gVar) {
        if (gVar.e().a(obj)) {
            if (a(obj, gVar.g(), gVar.a(), gVar)) {
                if (!gVar.d()) {
                    hVar = sdk.pendo.io.o1.h.s;
                }
                if (b()) {
                    gVar.a(str, hVar, obj);
                    return;
                } else {
                    g().a(str, hVar, obj, gVar);
                    return;
                }
            }
            return;
        }
        if (!gVar.e().e(obj)) {
            if (f()) {
                throw new sdk.pendo.io.n1.f(String.format("Filter: %s can not be applied to primitives. Current context is: %s", toString(), obj));
            }
            return;
        }
        Iterator<?> it = gVar.e().f(obj).iterator();
        int i = 0;
        while (it.hasNext()) {
            if (a(it.next(), gVar.g(), gVar.a(), gVar)) {
                a(i, str, obj, gVar);
            }
            i++;
        }
    }

    @Override // sdk.pendo.io.v1.j
    public String a() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < this.f.size(); i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append("?");
        }
        sb.append("]");
        return sb.toString();
    }
}
