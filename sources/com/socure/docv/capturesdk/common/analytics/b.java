package com.socure.docv.capturesdk.common.analytics;

import com.socure.docv.capturesdk.common.network.model.stepup.Data;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final e f287a;

    public b(com.socure.docv.capturesdk.common.network.repository.b repoHolder, CoroutineExceptionHandler exceptionHandler) {
        Intrinsics.checkNotNullParameter(repoHolder, "repoHolder");
        Intrinsics.checkNotNullParameter(exceptionHandler, "exceptionHandler");
        this.f287a = new e(repoHolder.c(), exceptionHandler);
    }

    public final void a(Data session) {
        Intrinsics.checkNotNullParameter(session, "session");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_EM", "updateSessionData called");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("reference_id", session.getEventId());
        linkedHashMap.put("distinct_id", session.getEventId());
        linkedHashMap.put("is_internal", String.valueOf(session.isInternal()));
        linkedHashMap.put("account_id", String.valueOf(session.getAccountId()));
        linkedHashMap.put("environment", session.getEnvironment());
        linkedHashMap.put("language", session.getConfig().getLanguage());
        this.f287a.a(linkedHashMap);
    }

    public final void a(Map<String, String> lateAttrs) {
        Intrinsics.checkNotNullParameter(lateAttrs, "lateAttrs");
        e eVar = this.f287a;
        eVar.getClass();
        Intrinsics.checkNotNullParameter(lateAttrs, "lateAttrs");
        eVar.c.putAll(lateAttrs);
    }

    public final void a(String eventName, Pair<String, String>... args) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(args, "args");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_EM", "Sending event: " + eventName);
        try {
            e eVar = this.f287a;
            Pair[] args2 = (Pair[]) Arrays.copyOf(args, args.length);
            eVar.getClass();
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(args2, "args");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(eVar.b)), null, null, new d(eventName, eVar, args2, null), 3, null);
        } catch (Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_EM", "Ex in sendEvent: " + th.getLocalizedMessage(), null, 4, null);
        }
    }
}
