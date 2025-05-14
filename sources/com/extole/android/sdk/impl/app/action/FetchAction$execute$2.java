package com.extole.android.sdk.impl.app.action;

import com.extole.android.sdk.Zone;
import com.extole.android.sdk.impl.ExtoleInternal;
import com.extole.android.sdk.impl.ZoneResponseKey;
import com.extole.android.sdk.impl.Zones;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FetchAction.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.impl.app.action.FetchAction$execute$2", f = "FetchAction.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class FetchAction$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ExtoleInternal $extole;
    int label;
    final /* synthetic */ FetchAction this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FetchAction$execute$2(FetchAction fetchAction, ExtoleInternal extoleInternal, Continuation<? super FetchAction$execute$2> continuation) {
        super(2, continuation);
        this.this$0 = fetchAction;
        this.$extole = extoleInternal;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FetchAction$execute$2(this.this$0, this.$extole, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FetchAction$execute$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Map<String, ? extends Object> prepareRequestData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            prepareRequestData = this.this$0.prepareRequestData(this.$extole);
            this.label = 1;
            obj = this.$extole.getServices().getZoneService().getZones(CollectionsKt.toSet(this.this$0.getZones()), prepareRequestData, this.$extole.getLabels(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Map<ZoneResponseKey, Zone> all = ((Zones) obj).getAll();
        ExtoleInternal extoleInternal = this.$extole;
        for (Map.Entry<ZoneResponseKey, Zone> entry : all.entrySet()) {
            Zone value = entry.getValue();
            if (value != null) {
                extoleInternal.getZonesResponse().add(entry.getKey(), value);
            }
        }
        return Unit.INSTANCE;
    }
}
