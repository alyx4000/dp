package com.extole.android.sdk;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* compiled from: RewardService.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/extole/android/sdk/RewardService;", "", "pollReward", "Lorg/json/JSONObject;", "pollingId", "", "timeoutSeconds", "", "retries", "", "(Ljava/lang/String;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface RewardService {
    Object pollReward(String str, long j, int i, Continuation<? super JSONObject> continuation) throws RestException;

    /* compiled from: RewardService.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object pollReward$default(RewardService rewardService, String str, long j, int i, Continuation continuation, int i2, Object obj) throws RestException {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pollReward");
            }
            if ((i2 & 2) != 0) {
                j = 5;
            }
            long j2 = j;
            if ((i2 & 4) != 0) {
                i = 5;
            }
            return rewardService.pollReward(str, j2, i, continuation);
        }
    }
}
