package sdk.pendo.io.e2;

import sdk.pendo.io.b2.g;
import sdk.pendo.io.b2.h;

/* loaded from: classes6.dex */
public class c implements e<Object> {
    @Override // sdk.pendo.io.e2.e
    public <E> void a(E e, Appendable appendable, g gVar) {
        sdk.pendo.io.z1.d a2 = sdk.pendo.io.z1.d.a(e.getClass(), h.f883a);
        appendable.append('{');
        boolean z = false;
        for (sdk.pendo.io.z1.b bVar : a2.a()) {
            Object a3 = a2.a((sdk.pendo.io.z1.d) e, bVar.b());
            if (a3 != null || !gVar.a()) {
                if (z) {
                    appendable.append(',');
                } else {
                    z = true;
                }
                sdk.pendo.io.b2.d.a(bVar.c(), a3, appendable, gVar);
            }
        }
        appendable.append('}');
    }
}
