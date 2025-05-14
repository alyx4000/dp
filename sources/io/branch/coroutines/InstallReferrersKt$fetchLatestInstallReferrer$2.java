package io.branch.coroutines;

import android.content.Context;
import io.branch.data.InstallReferrerResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InstallReferrers.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lio/branch/data/InstallReferrerResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.branch.coroutines.InstallReferrersKt$fetchLatestInstallReferrer$2", f = "InstallReferrers.kt", i = {0, 0, 0, 1, 1, 2}, l = {244, 244, 244, 244}, m = "invokeSuspend", n = {"huaweiReferrer", "samsungReferrer", "xiaomiReferrer", "samsungReferrer", "xiaomiReferrer", "xiaomiReferrer"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
/* loaded from: classes2.dex */
final class InstallReferrersKt$fetchLatestInstallReferrer$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InstallReferrerResult>, Object> {
    final /* synthetic */ Context $context;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InstallReferrersKt$fetchLatestInstallReferrer$2(Context context, Continuation<? super InstallReferrersKt$fetchLatestInstallReferrer$2> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InstallReferrersKt$fetchLatestInstallReferrer$2 installReferrersKt$fetchLatestInstallReferrer$2 = new InstallReferrersKt$fetchLatestInstallReferrer$2(this.$context, continuation);
        installReferrersKt$fetchLatestInstallReferrer$2.L$0 = obj;
        return installReferrersKt$fetchLatestInstallReferrer$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InstallReferrerResult> continuation) {
        return ((InstallReferrersKt$fetchLatestInstallReferrer$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0147 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x012d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x012e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.coroutines.InstallReferrersKt$fetchLatestInstallReferrer$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
