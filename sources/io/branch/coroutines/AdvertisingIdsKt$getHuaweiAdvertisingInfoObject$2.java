package io.branch.coroutines;

import android.content.Context;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import io.branch.referral.BranchLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AdvertisingIds.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/huawei/hms/ads/identifier/AdvertisingIdClient$Info;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.branch.coroutines.AdvertisingIdsKt$getHuaweiAdvertisingInfoObject$2", f = "AdvertisingIds.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class AdvertisingIdsKt$getHuaweiAdvertisingInfoObject$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AdvertisingIdClient.Info>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdvertisingIdsKt$getHuaweiAdvertisingInfoObject$2(Context context, Continuation<? super AdvertisingIdsKt$getHuaweiAdvertisingInfoObject$2> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdvertisingIdsKt$getHuaweiAdvertisingInfoObject$2(this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AdvertisingIdClient.Info> continuation) {
        return ((AdvertisingIdsKt$getHuaweiAdvertisingInfoObject$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(this.$context);
        } catch (Exception e) {
            BranchLogger.d("getHuaweiAdvertisingInfoObject exception: " + e);
            return null;
        }
    }
}
