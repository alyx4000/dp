package com.socure.docv.capturesdk.common.analytics;

import android.util.Base64;
import com.google.gson.Gson;
import com.socure.docv.capturesdk.common.utils.Utils;
import expo.modules.notifications.service.NotificationsService;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;

@DebugMetadata(c = "com.socure.docv.capturesdk.common.analytics.MixPanelAgent$sendEvent$1", f = "MixPanelAgent.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f290a;
    public final /* synthetic */ String b;
    public final /* synthetic */ e c;
    public final /* synthetic */ Pair<String, String>[] d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String str, e eVar, Pair<String, String>[] pairArr, Continuation<? super d> continuation) {
        super(2, continuation);
        this.b = str;
        this.c = eVar;
        this.d = pairArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new d(this.b, this.c, this.d, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f290a;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("event", this.b);
                Utils utils = Utils.INSTANCE;
                Map<String, String> map = this.c.c;
                Pair<String, String>[] pairArr = this.d;
                linkedHashMap.put("properties", utils.argsIntoAttrs(map, (Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
                String json = new Gson().toJson(linkedHashMap);
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_MPA", "sendEvent - json: " + json);
                com.socure.docv.capturesdk.common.network.repository.a aVar = this.c.f291a;
                Intrinsics.checkNotNullExpressionValue(json, "json");
                byte[] bytes = json.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                String encodeToString = Base64.encodeToString(bytes, 2);
                Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString((json).to…eArray(), Base64.NO_WRAP)");
                this.f290a = 1;
                obj = aVar.f295a.a(encodeToString, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Response response = (Response) obj;
            String str = response.isSuccessful() ? NotificationsService.SUCCEEDED_KEY : "failed";
            com.socure.docv.capturesdk.common.logger.b.b("SDLT_MPA", "Event sending " + str + ": " + this.b + " | response: [" + response.code() + ", " + response.message() + "]");
        } catch (Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_MPA", "ex in sendEvent: " + th.getLocalizedMessage(), null, 4, null);
        }
        return Unit.INSTANCE;
    }
}
