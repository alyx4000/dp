package sdk.pendo.io.s0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final List<sdk.pendo.io.t0.a> f1533a = new ArrayList();

    public static class a {
        public a(c cVar) {
            d.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(c cVar) {
        Iterator<sdk.pendo.io.t0.a> it = f1533a.iterator();
        while (it.hasNext()) {
            if (it.next().a().a().equals(cVar.a())) {
                return;
            }
        }
        f1533a.add(new sdk.pendo.io.t0.a(cVar));
    }

    public static a b(c cVar) {
        return new a(cVar);
    }

    public static sdk.pendo.io.t0.a a(sdk.pendo.io.s0.a aVar) {
        for (sdk.pendo.io.t0.a aVar2 : f1533a) {
            if (aVar2.a(aVar)) {
                return aVar2;
            }
        }
        return null;
    }
}
