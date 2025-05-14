package sdk.pendo.io.g;

import external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.State;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.l2.h;
import sdk.pendo.io.l2.i;
import sdk.pendo.io.l2.s;
import sdk.pendo.io.l2.x;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¨\u0006\b"}, d2 = {"Lsdk/pendo/io/g/d;", "Lsdk/pendo/io/l2/x;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State;", "Lsdk/pendo/io/l2/h;", "element", "a", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class d extends x<State> {
    public d() {
        super(State.INSTANCE.serializer());
    }

    @Override // sdk.pendo.io.l2.x
    protected h a(h element) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (!(element instanceof s)) {
            return element;
        }
        s sVar = (s) element;
        String str = (String) CollectionsKt.first(sVar.keySet());
        Object obj = sVar.get(str);
        if (obj != null) {
            return new s(MapsKt.plus((s) obj, TuplesKt.to("type", i.a(str))));
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.serialization.json.JsonObject");
    }
}
