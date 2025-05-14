package external.sdk.pendo.io.glide.load.engine;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class o {

    /* renamed from: a, reason: collision with root package name */
    private final Map<sdk.pendo.io.q.f, i<?>> f674a = new HashMap();
    private final Map<sdk.pendo.io.q.f, i<?>> b = new HashMap();

    o() {
    }

    i<?> a(sdk.pendo.io.q.f fVar, boolean z) {
        return a(z).get(fVar);
    }

    void b(sdk.pendo.io.q.f fVar, i<?> iVar) {
        Map<sdk.pendo.io.q.f, i<?>> a2 = a(iVar.h());
        if (iVar.equals(a2.get(fVar))) {
            a2.remove(fVar);
        }
    }

    private Map<sdk.pendo.io.q.f, i<?>> a(boolean z) {
        return z ? this.b : this.f674a;
    }

    void a(sdk.pendo.io.q.f fVar, i<?> iVar) {
        a(iVar.h()).put(fVar, iVar);
    }
}
