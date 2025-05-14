package sdk.pendo.io.u1;

import java.util.Iterator;
import java.util.List;
import sdk.pendo.io.o1.d;
import sdk.pendo.io.o1.h;
import sdk.pendo.io.q1.c;

/* loaded from: classes3.dex */
public class a implements c {
    @Override // sdk.pendo.io.q1.c
    public Object a(String str, h hVar, Object obj, d dVar, List<sdk.pendo.io.q1.b> list) {
        StringBuilder sb = new StringBuilder();
        if (dVar.a().f().e(obj)) {
            for (Object obj2 : dVar.a().f().f(obj)) {
                if (obj2 instanceof String) {
                    sb.append(obj2.toString());
                }
            }
        }
        if (list != null) {
            Iterator it = sdk.pendo.io.q1.b.a(String.class, dVar, list).iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
            }
        }
        return sb.toString();
    }
}
