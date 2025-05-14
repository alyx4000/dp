package com.extole.android.sdk.impl.app;

import com.extole.android.sdk.RewardService;
import com.extole.android.sdk.impl.http.MeRewardEndpoints;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: RewardServiceImpl.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J+\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/extole/android/sdk/impl/app/RewardServiceImpl;", "Lcom/extole/android/sdk/RewardService;", "meRewardEndpoints", "Lcom/extole/android/sdk/impl/http/MeRewardEndpoints;", "(Lcom/extole/android/sdk/impl/http/MeRewardEndpoints;)V", "getMeRewardEndpoints", "()Lcom/extole/android/sdk/impl/http/MeRewardEndpoints;", "pollReward", "Lorg/json/JSONObject;", "pollingId", "", "timeoutSeconds", "", "retries", "", "(Ljava/lang/String;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RewardServiceImpl implements RewardService {
    private final MeRewardEndpoints meRewardEndpoints;

    public RewardServiceImpl(MeRewardEndpoints meRewardEndpoints) {
        Intrinsics.checkNotNullParameter(meRewardEndpoints, "meRewardEndpoints");
        this.meRewardEndpoints = meRewardEndpoints;
    }

    public final MeRewardEndpoints getMeRewardEndpoints() {
        return this.meRewardEndpoints;
    }

    @Override // com.extole.android.sdk.RewardService
    public Object pollReward(String str, long j, int i, Continuation<? super JSONObject> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new RewardServiceImpl$pollReward$2(i, this, str, j, null), continuation);
    }
}
