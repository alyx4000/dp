package sdk.pendo.io.actions;

import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.configurations.GuideCapping;
import sdk.pendo.io.g9.f;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideConfigurationModel;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.y8.a;

/* loaded from: classes6.dex */
public class GuideShowDecider implements GuideShowDeciderInterface {
    private static volatile GuideShowDecider INSTANCE;

    public static synchronized GuideShowDeciderInterface getInstance() {
        GuideShowDecider guideShowDecider;
        synchronized (GuideShowDecider.class) {
            if (INSTANCE == null) {
                INSTANCE = new GuideShowDecider();
            }
            guideShowDecider = INSTANCE;
        }
        return guideShowDecider;
    }

    private boolean hasInternet() {
        if (f.a()) {
            return true;
        }
        PendoLogger.d("Not showing guide due to connectivity.", new Object[0]);
        return false;
    }

    private boolean isShowingCurrentGuide(String str) {
        return VisualGuidesManager.getInstance().isGuideShowing(str);
    }

    private boolean isWithinThrottlingInterval(GuideModel guideModel, int i) {
        GuidesConfigurationManager guidesConfigurationManager = GuidesConfigurationManager.INSTANCE;
        if (!guidesConfigurationManager.getIsThrottlingEnabled() || guidesConfigurationManager.getLastSeenTimeMS() == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StepGuideModel guideStepModel = guideModel.getGuideStepModel(i);
        GuideConfigurationModel configuration = guideStepModel != null ? guideStepModel.getConfiguration() : null;
        return (currentTimeMillis + (configuration != null ? configuration.getDelayMs() : 0L)) - guidesConfigurationManager.getLastSeenTimeMS().longValue() <= ((long) guidesConfigurationManager.getThrottlingIntervalMS());
    }

    public boolean hasCappingLeft(GuideModel guideModel) {
        GuideCapping capping = guideModel.getGeneralGuideConfiguration().getCapping();
        if (capping != null && capping.canConsumeOne()) {
            return true;
        }
        if (!shouldSendCappingEvent(guideModel)) {
            return false;
        }
        PendoCommandParameterInjector.getInstance().handlePendoCappedOutAnalytics(guideModel);
        return false;
    }

    public boolean isOngoingMultiStep(int i) {
        return i > 0 || i < StepSeenManager.getInstance().getPreviousStepIndex().intValue();
    }

    public boolean isShowingFullSizeGuide() {
        return VisualGuidesManager.getInstance().isAnyFullScreenGuideShowing();
    }

    public boolean shouldActivateThrottlingConsideringActivation(GuideModel guideModel) {
        sdk.pendo.io.k0.f activations = guideModel.getActivations();
        if (activations == null || activations.size() == 0) {
            return true;
        }
        try {
            String iVar = activations.iterator().next().e().a("event").toString();
            if (iVar.contains(ActivationManager.ActivationEvents.APP_LAUNCH.getActivationEvent())) {
                return true;
            }
            return iVar.contains(ActivationManager.ActivationEvents.VIEW.getActivationEvent());
        } catch (Exception unused) {
            PendoLogger.d("shouldActivateThrottlingConsideringActivation - either guideActivationsArray is empty or guide's missing an event property", new Object[0]);
            return false;
        }
    }

    public boolean shouldSendCappingEvent(GuideModel guideModel) {
        return !guideModel.isInControlGroup();
    }

    @Override // sdk.pendo.io.actions.GuideShowDeciderInterface
    public boolean shouldShowGuide(GuideModel guideModel, int i) {
        if (!hasInternet()) {
            return false;
        }
        if (a.d().t() || isOngoingMultiStep(i)) {
            return true;
        }
        if (isShowingCurrentGuide(guideModel.getGuideId())) {
            return false;
        }
        if (StepSeenManager.getInstance().isLaunchGuideFromGuideStep()) {
            return true;
        }
        if (!shouldActivateThrottlingConsideringActivation(guideModel) || !isWithinThrottlingInterval(guideModel, i)) {
            return hasCappingLeft(guideModel);
        }
        StepSeenManager.getInstance().reset();
        return false;
    }
}
