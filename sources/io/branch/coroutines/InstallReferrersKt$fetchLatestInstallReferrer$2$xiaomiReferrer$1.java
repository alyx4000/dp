package io.branch.coroutines;

import android.content.Context;
import io.branch.data.InstallReferrerResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InstallReferrers.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lio/branch/data/InstallReferrerResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.branch.coroutines.InstallReferrersKt$fetchLatestInstallReferrer$2$xiaomiReferrer$1", f = "InstallReferrers.kt", i = {}, l = {242}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class InstallReferrersKt$fetchLatestInstallReferrer$2$xiaomiReferrer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InstallReferrerResult>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InstallReferrersKt$fetchLatestInstallReferrer$2$xiaomiReferrer$1(Context context, Continuation<? super InstallReferrersKt$fetchLatestInstallReferrer$2$xiaomiReferrer$1> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InstallReferrersKt$fetchLatestInstallReferrer$2$xiaomiReferrer$1(this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InstallReferrerResult> continuation) {
        return ((InstallReferrersKt$fetchLatestInstallReferrer$2$xiaomiReferrer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = InstallReferrersKt.getXiaomiGetAppsReferrerDetails(this.$context, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
