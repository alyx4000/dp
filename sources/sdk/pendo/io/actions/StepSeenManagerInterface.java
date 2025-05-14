package sdk.pendo.io.actions;

import sdk.pendo.io.models.StepSeen;

/* loaded from: classes6.dex */
public interface StepSeenManagerInterface {
    String getCurrentStepGuideId();

    String getCurrentStepId();

    Integer getCurrentStepIndex();

    StepSeen getCurrentStepSeen();

    Integer getPreviousStepIndex();

    boolean isBackwardsStep();

    boolean isBannerGuideStep();

    boolean isLaunchGuideFromGuideStep();

    void reset();

    void setCurrentStepSeen(StepSeen stepSeen);

    void setIsBannerGuideStep(boolean z);

    void setIsLaunchGuideFromGuideStep(boolean z);
}
