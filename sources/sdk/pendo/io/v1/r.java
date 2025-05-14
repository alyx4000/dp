package sdk.pendo.io.v1;

import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class r extends j {
    r() {
    }

    @Override // sdk.pendo.io.v1.j
    public String a() {
        return "[*]";
    }

    @Override // sdk.pendo.io.v1.j
    public void a(String str, sdk.pendo.io.o1.h hVar, Object obj, g gVar) {
        if (gVar.e().a(obj)) {
            Iterator<String> it = gVar.e().c(obj).iterator();
            while (it.hasNext()) {
                a(str, obj, gVar, Collections.singletonList(it.next()));
            }
        } else if (gVar.e().e(obj)) {
            for (int i = 0; i < gVar.e().d(obj); i++) {
                try {
                    a(i, str, obj, gVar);
                } catch (sdk.pendo.io.n1.k e) {
                    if (gVar.f().contains(sdk.pendo.io.n1.i.REQUIRE_PROPERTIES)) {
                        throw e;
                    }
                }
            }
        }
    }

    @Override // sdk.pendo.io.v1.j
    public boolean e() {
        return false;
    }
}
