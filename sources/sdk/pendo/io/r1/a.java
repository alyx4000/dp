package sdk.pendo.io.r1;

import java.util.List;
import sdk.pendo.io.o1.d;
import sdk.pendo.io.o1.h;
import sdk.pendo.io.q1.b;
import sdk.pendo.io.q1.c;

/* loaded from: classes6.dex */
public class a implements c {
    @Override // sdk.pendo.io.q1.c
    public Object a(String str, h hVar, Object obj, d dVar, List<b> list) {
        sdk.pendo.io.x1.b f = dVar.a().f();
        if (list != null && list.size() > 0) {
            for (b bVar : list) {
                if (f.e(obj)) {
                    f.a(obj, f.d(obj), bVar.d());
                }
            }
        }
        return obj;
    }
}
