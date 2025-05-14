package com.extole.android.sdk.impl.app;

import com.extole.android.sdk.impl.ResponseEntity;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* compiled from: RewardServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.impl.app.RewardServiceImpl$pollReward$2", f = "RewardServiceImpl.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class RewardServiceImpl$pollReward$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super JSONObject>, Object> {
    final /* synthetic */ String $pollingId;
    final /* synthetic */ int $retries;
    final /* synthetic */ long $timeoutSeconds;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RewardServiceImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RewardServiceImpl$pollReward$2(int i, RewardServiceImpl rewardServiceImpl, String str, long j, Continuation<? super RewardServiceImpl$pollReward$2> continuation) {
        super(2, continuation);
        this.$retries = i;
        this.this$0 = rewardServiceImpl;
        this.$pollingId = str;
        this.$timeoutSeconds = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RewardServiceImpl$pollReward$2(this.$retries, this.this$0, this.$pollingId, this.$timeoutSeconds, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super JSONObject> continuation) {
        return ((RewardServiceImpl$pollReward$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        RewardServiceImpl rewardServiceImpl;
        Iterator<Integer> it;
        RewardServiceImpl$pollReward$2 rewardServiceImpl$pollReward$2;
        String str;
        long j;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            IntRange intRange = new IntRange(0, this.$retries);
            RewardServiceImpl rewardServiceImpl2 = this.this$0;
            String str2 = this.$pollingId;
            long j2 = this.$timeoutSeconds;
            rewardServiceImpl = rewardServiceImpl2;
            it = intRange.iterator();
            rewardServiceImpl$pollReward$2 = this;
            str = str2;
            j = j2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = this.J$0;
            it = (Iterator) this.L$2;
            str = (String) this.L$1;
            rewardServiceImpl = (RewardServiceImpl) this.L$0;
            ResultKt.throwOnFailure(obj);
            rewardServiceImpl$pollReward$2 = this;
        }
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            ResponseEntity<JSONObject> rewardStatus = rewardServiceImpl.getMeRewardEndpoints().getRewardStatus(str, null, null);
            if (!Intrinsics.areEqual(rewardStatus.getEntity().getString("status"), "PENDING")) {
                return rewardStatus.getEntity();
            }
            long millis = TimeUnit.SECONDS.toMillis(j);
            rewardServiceImpl$pollReward$2.L$0 = rewardServiceImpl;
            rewardServiceImpl$pollReward$2.L$1 = str;
            rewardServiceImpl$pollReward$2.L$2 = it;
            rewardServiceImpl$pollReward$2.J$0 = j;
            rewardServiceImpl$pollReward$2.label = 1;
            if (DelayKt.delay(millis, rewardServiceImpl$pollReward$2) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return null;
    }
}
