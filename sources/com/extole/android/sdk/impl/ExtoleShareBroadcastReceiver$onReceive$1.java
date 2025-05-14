package com.extole.android.sdk.impl;

import com.extole.android.sdk.ExtoleLogger;
import com.extole.android.sdk.impl.http.EventEndpoints;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ExtoleShareBroadcastReceiver.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.impl.ExtoleShareBroadcastReceiver$onReceive$1", f = "ExtoleShareBroadcastReceiver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class ExtoleShareBroadcastReceiver$onReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $accessToken;
    final /* synthetic */ ExtoleLogger $extoleLogger;
    final /* synthetic */ String $partnerShareId;
    final /* synthetic */ String $programDomain;
    final /* synthetic */ String $selectedAppPackage;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExtoleShareBroadcastReceiver$onReceive$1(String str, ExtoleLogger extoleLogger, String str2, String str3, String str4, Continuation<? super ExtoleShareBroadcastReceiver$onReceive$1> continuation) {
        super(2, continuation);
        this.$accessToken = str;
        this.$extoleLogger = extoleLogger;
        this.$partnerShareId = str2;
        this.$programDomain = str3;
        this.$selectedAppPackage = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExtoleShareBroadcastReceiver$onReceive$1(this.$accessToken, this.$extoleLogger, this.$partnerShareId, this.$programDomain, this.$selectedAppPackage, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ExtoleShareBroadcastReceiver$onReceive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String str = this.$accessToken;
        if (str == null || str.length() == 0) {
            this.$extoleLogger.debug("Access Token is empty", new Object[0]);
        }
        String str2 = this.$partnerShareId;
        if (str2 == null || str2.length() == 0) {
            this.$extoleLogger.debug("Partner Share Id is empty", new Object[0]);
        }
        EventEndpoints eventEndpoints = new EventEndpoints(this.$programDomain, this.$accessToken, MapsKt.emptyMap());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("event_name", "share");
        linkedHashMap.put("data", MapsKt.mapOf(TuplesKt.to("share.channel", this.$selectedAppPackage), TuplesKt.to("partner_share_id", this.$partnerShareId)));
        eventEndpoints.post(linkedHashMap);
        return Unit.INSTANCE;
    }
}
