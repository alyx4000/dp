package com.extole.android.sdk.impl;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CampaignImpl.kt */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.impl.CampaignImpl", f = "CampaignImpl.kt", i = {0, 0}, l = {43}, m = "fetchZone", n = {"this", "zoneName"}, s = {"L$0", "L$1"})
/* loaded from: classes.dex */
final class CampaignImpl$fetchZone$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CampaignImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CampaignImpl$fetchZone$1(CampaignImpl campaignImpl, Continuation<? super CampaignImpl$fetchZone$1> continuation) {
        super(continuation);
        this.this$0 = campaignImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchZone((String) null, (Map<String, ? extends Object>) null, this);
    }
}
