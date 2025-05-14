package sdk.pendo.io.h;

import external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.Log;
import external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.LogListV2;
import external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.Operator;
import external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.State;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import sdk.pendo.io.f.j;
import sdk.pendo.io.g2.f;
import sdk.pendo.io.j.h;
import sdk.pendo.io.l2.m;
import sdk.pendo.io.m.b;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/h/b;", "Lsdk/pendo/io/h/a;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/LogListV2;", "logList", "Lsdk/pendo/io/m/b;", "a", "", "logListJson", "<init>", "()V", "b", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class b implements sdk.pendo.io.h.a {
    private static final sdk.pendo.io.l2.a b = m.a(null, a.f, 1, null);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lsdk/pendo/io/l2/d;", "", "a", "(Lsdk/pendo/io/l2/d;)V"}, k = 3, mv = {1, 6, 0})
    static final class a extends Lambda implements Function1<sdk.pendo.io.l2.d, Unit> {
        public static final a f = new a();

        a() {
            super(1);
        }

        public final void a(sdk.pendo.io.l2.d Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.a(true);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(sdk.pendo.io.l2.d dVar) {
            a(dVar);
            return Unit.INSTANCE;
        }
    }

    private final sdk.pendo.io.m.b a(LogListV2 logList) {
        List<Operator> operators = logList.getOperators();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = operators.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((Operator) it.next()).getLogs());
        }
        ArrayList<Log> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            Log log = (Log) obj;
            if (!(log.getState() == null || (log.getState() instanceof State.Pending) || (log.getState() instanceof State.Rejected))) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (Log log2 : arrayList2) {
            try {
                arrayList3.add(new sdk.pendo.io.m.d(h.f1214a.b(sdk.pendo.io.j.a.f1212a.a(log2.getKey())), ((log2.getState() instanceof State.Retired) || (log2.getState() instanceof State.ReadOnly)) ? Long.valueOf(log2.getState().getTimestamp()) : null));
            } catch (IllegalArgumentException e) {
                return new j(e, log2.getKey());
            } catch (NoSuchAlgorithmException e2) {
                return new j(e2, log2.getKey());
            } catch (InvalidKeySpecException e3) {
                return new j(e3, log2.getKey());
            }
        }
        return new b.C0193b(arrayList3);
    }

    @Override // sdk.pendo.io.h.a
    public sdk.pendo.io.m.b a(String logListJson) {
        Intrinsics.checkNotNullParameter(logListJson, "logListJson");
        try {
            return a((LogListV2) b.a(LogListV2.INSTANCE.serializer(), logListJson));
        } catch (f e) {
            return new sdk.pendo.io.f.d(e);
        }
    }
}
