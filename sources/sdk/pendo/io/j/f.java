package sdk.pendo.io.j;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.k3.o;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.e0;
import sdk.pendo.io.w2.w;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lsdk/pendo/io/j/f;", "Lsdk/pendo/io/w2/w;", "Lsdk/pendo/io/w2/w$a;", "chain", "Lsdk/pendo/io/w2/d0;", "a", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class f implements w {
    @Override // sdk.pendo.io.w2.w
    public d0 a(w.a chain) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(chain, "chain");
        b0 request = chain.getRequest();
        b0.a h = request.h();
        h.a("Max-Size");
        d0 a2 = chain.a(h.a());
        e0 b = a2.b();
        Intrinsics.checkNotNull(b);
        String str = (String) CollectionsKt.firstOrNull((List) request.b("Max-Size"));
        if (str == null || (longOrNull = StringsKt.toLongOrNull(str)) == null) {
            return a2;
        }
        d0 a3 = a2.v().a(e0.INSTANCE.a(o.a(o.a(new d(b.a(), longOrNull.longValue()))), b.getS(), b.getContentLength())).a();
        return a3 == null ? a2 : a3;
    }
}
