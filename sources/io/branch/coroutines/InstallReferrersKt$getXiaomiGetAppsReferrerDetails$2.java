package io.branch.coroutines;

import android.content.Context;
import android.os.RemoteException;
import com.miui.referrer.api.GetAppsReferrerClient;
import com.miui.referrer.api.GetAppsReferrerDetails;
import com.miui.referrer.api.GetAppsReferrerStateListener;
import io.branch.data.InstallReferrerResult;
import io.branch.referral.BranchLogger;
import io.branch.referral.Defines;
import io.branch.referral.util.DependencyUtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InstallReferrers.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lio/branch/data/InstallReferrerResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.branch.coroutines.InstallReferrersKt$getXiaomiGetAppsReferrerDetails$2", f = "InstallReferrers.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class InstallReferrersKt$getXiaomiGetAppsReferrerDetails$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InstallReferrerResult>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InstallReferrersKt$getXiaomiGetAppsReferrerDetails$2(Context context, Continuation<? super InstallReferrersKt$getXiaomiGetAppsReferrerDetails$2> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InstallReferrersKt$getXiaomiGetAppsReferrerDetails$2(this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InstallReferrerResult> continuation) {
        return ((InstallReferrersKt$getXiaomiGetAppsReferrerDetails$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (DependencyUtilsKt.classExists(DependencyUtilsKt.xiaomiInstallReferrerClass)) {
                    final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                    final GetAppsReferrerClient build = GetAppsReferrerClient.Companion.newBuilder(this.$context).build();
                    build.startConnection(new GetAppsReferrerStateListener() { // from class: io.branch.coroutines.InstallReferrersKt$getXiaomiGetAppsReferrerDetails$2.1
                        public void onGetAppsReferrerSetupFinished(int state) {
                            BranchLogger.d("getXiaomiGetAppsReferrerDetails onInstallReferrerSetupFinished response code: " + state);
                            InstallReferrerResult installReferrerResult = null;
                            if (state == 0) {
                                CompletableDeferred<InstallReferrerResult> completableDeferred = CompletableDeferred$default;
                                try {
                                    GetAppsReferrerDetails installReferrer = build.getInstallReferrer();
                                    installReferrerResult = new InstallReferrerResult(Defines.Jsonkey.Xiaomi_Get_Apps.getKey(), installReferrer.getInstallBeginTimestampSeconds(), installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds());
                                } catch (RemoteException e) {
                                    BranchLogger.d("getXiaomiGetAppsReferrerDetails exception: " + e);
                                }
                                completableDeferred.complete(installReferrerResult);
                            } else {
                                BranchLogger.d("getXiaomiGetAppsReferrerDetails response code: " + state);
                                CompletableDeferred$default.complete(null);
                            }
                            build.endConnection();
                        }

                        public void onGetAppsServiceDisconnected() {
                            if (CompletableDeferred$default.isCompleted()) {
                                return;
                            }
                            CompletableDeferred$default.complete(null);
                        }
                    });
                    this.label = 1;
                    obj = CompletableDeferred$default.await(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    return null;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return (InstallReferrerResult) obj;
        } catch (Exception e) {
            BranchLogger.d("getXiaomiGetAppsReferrerDetails exception: " + e);
            return null;
        }
    }
}
