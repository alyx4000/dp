package sdk.pendo.io.e2;

import sdk.pendo.io.b2.g;
import sdk.pendo.io.b2.i;

/* loaded from: classes6.dex */
public class a implements e<Object> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // sdk.pendo.io.e2.e
    public <E> void a(E e, Appendable appendable, g gVar) {
        gVar.c(appendable);
        boolean z = false;
        for (Object obj : (Object[]) e) {
            if (z) {
                gVar.i(appendable);
            } else {
                z = true;
            }
            i.a(obj, appendable, gVar);
        }
        gVar.d(appendable);
    }
}
