package sdk.pendo.io.models;

import sdk.pendo.io.k0.f;
import sdk.pendo.io.l0.c;

/* loaded from: classes6.dex */
public class GuidesConfigurationModel {

    @c("lastStepSeen")
    private LastStepSeenConfigurationModel mLastStepSeenConfigurationModel;

    @c("order")
    private f mOrder;

    @c("throttling")
    private ThrottlingConfigurationModel mThrottlingConfigurationModel;

    public LastStepSeenConfigurationModel getLastStepSeenConfigurationModel() {
        return this.mLastStepSeenConfigurationModel;
    }

    public ThrottlingConfigurationModel getThrottlingConfigurationModel() {
        return this.mThrottlingConfigurationModel;
    }
}
