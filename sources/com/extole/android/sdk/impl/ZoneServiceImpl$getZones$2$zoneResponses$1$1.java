package com.extole.android.sdk.impl;

import com.extole.android.sdk.Zone;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ZoneServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/extole/android/sdk/Zone;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.impl.ZoneServiceImpl$getZones$2$zoneResponses$1$1", f = "ZoneServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class ZoneServiceImpl$getZones$2$zoneResponses$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Zone>, Object> {
    final /* synthetic */ Map<String, Object> $requestData;
    final /* synthetic */ String $zoneName;
    int label;
    final /* synthetic */ ZoneServiceImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ZoneServiceImpl$getZones$2$zoneResponses$1$1(ZoneServiceImpl zoneServiceImpl, String str, Map<String, Object> map, Continuation<? super ZoneServiceImpl$getZones$2$zoneResponses$1$1> continuation) {
        super(2, continuation);
        this.this$0 = zoneServiceImpl;
        this.$zoneName = str;
        this.$requestData = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZoneServiceImpl$getZones$2$zoneResponses$1$1(this.this$0, this.$zoneName, this.$requestData, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Zone> continuation) {
        return ((ZoneServiceImpl$getZones$2$zoneResponses$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Zone zone;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        zone = this.this$0.getZone(this.$zoneName, this.$requestData);
        return zone;
    }
}
