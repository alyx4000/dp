package sdk.pendo.io.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.GuidesActionsManager;
import sdk.pendo.io.actions.GuidesConfigurationManager;
import sdk.pendo.io.actions.GuidesManager;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.PendoCommandParameterInjector;
import sdk.pendo.io.actions.PendoCommandsEventBus;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.g9.g;
import sdk.pendo.io.k0.f;
import sdk.pendo.io.l0.c;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.o8.b;
import sdk.pendo.io.sdk.react.PlatformStateManager;
import sdk.pendo.io.v6.a;
import sdk.pendo.io.x5.j;

/* loaded from: classes6.dex */
public class InitModel {
    public static final Object CACHE_LOCK = new Object();
    private static final String REMOTE_DEBUG_INFO_TAG = "info";
    private static final String REMOTE_DEBUG_MESSAGES_TAG = "messages";

    @c("guideActions")
    private f mGuideActions;

    @c("guides")
    private List<GuideModel> mGuides;

    @c("configuration")
    private InitConfiguration mInitConfiguration;

    @c("metadata")
    private MetadataModel mMetadata;

    private void checkIfDebugRemoteNeededAndInit() {
        DebugConfigurationModel debugConfigurationModel = this.mInitConfiguration.getDebugConfigurationModel();
        if (debugConfigurationModel != null) {
            final b b = b.b();
            b.a(debugConfigurationModel.getRefreshIntervalMs());
            b.a();
            b.a(true);
            j.c(b.d(), TimeUnit.SECONDS, a.b()).a(sdk.pendo.io.d9.c.a(new e<Long>() { // from class: sdk.pendo.io.models.InitModel.1
                @Override // sdk.pendo.io.d6.e
                public void accept(Long l) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        JSONArray e = b.e();
                        b.a();
                        JSONObject a2 = g.a();
                        jSONObject.put(InitModel.REMOTE_DEBUG_MESSAGES_TAG, e);
                        jSONObject.put(InitModel.REMOTE_DEBUG_INFO_TAG, a2);
                        sdk.pendo.io.p8.a.d().a(jSONObject);
                    } catch (Exception e2) {
                        PendoLogger.e(e2, e2.getMessage(), new Object[0]);
                    }
                }
            }, "InitModel interval observable for remote debug observer"));
        }
    }

    private void sendGuidesReceivedAnalytics() {
        for (GuideModel guideModel : getGuideList()) {
            ArrayList arrayList = new ArrayList();
            if (VisualGuidesManager.getInstance().getVisualGuide(guideModel.getGuideId()) != null) {
                arrayList.add(new PendoCommandsEventBus.Parameter("seenReason", "string", VisualGuidesManager.getInstance().getVisualGuide(guideModel.getGuideId()).getActivatedBy()));
            }
            PendoCommandParameterInjector.getInstance().addGenericParamsInjectAndDispatch(guideModel, PendoCommandEventType.AnalyticsEventType.GUIDE_RECEIVED.eventType, arrayList);
        }
    }

    public List<GuideModel> getGuideList() {
        List<GuideModel> list = this.mGuides;
        return list != null ? list : new ArrayList();
    }

    public InitConfiguration getInitConfiguration() {
        return this.mInitConfiguration;
    }

    public void init() {
        synchronized (CACHE_LOCK) {
            if (this.mInitConfiguration != null) {
                PendoInternal.w().a(this.mInitConfiguration.getInitAnalyticsModel().isIncludePageViewTexts(), this.mInitConfiguration.getInitAnalyticsModel().isIncludeFeatureClickTexts(), this.mInitConfiguration.getInitAnalyticsModel().isIncludeFeatureClickNestedTexts(), this.mInitConfiguration.getInitAnalyticsModel().isIncludeRetroElementCompatibilityHashes(), this.mInitConfiguration.getInitAnalyticsModel().isOldScreenIdFormat(), this.mInitConfiguration.getInitAnalyticsModel().isIgnoreDynamicFragmentsInScrollView(), this.mInitConfiguration.getInitAnalyticsModel().isRespondToScrollChangeEventsForScreenId(), this.mInitConfiguration.getInitAnalyticsModel().globalLayoutChangeDebouncer().longValue(), this.mInitConfiguration.getInitAnalyticsModel().isShouldDetectClicksForAccessibility());
                checkIfDebugRemoteNeededAndInit();
                if (this.mInitConfiguration.getReactConfigurationModel() != null && this.mInitConfiguration.getReactConfigurationModel().getRnnClickDelayMs() >= 0) {
                    PlatformStateManager.INSTANCE.setRnnClickDelayMs(this.mInitConfiguration.getReactConfigurationModel().getRnnClickDelayMs());
                }
                GuidesConfigurationModel guidesConfigurationModel = this.mInitConfiguration.getGuidesConfigurationModel();
                if (guidesConfigurationModel != null) {
                    if (guidesConfigurationModel.getThrottlingConfigurationModel() != null) {
                        GuidesConfigurationManager.INSTANCE.setThrottlingConfiguration(guidesConfigurationModel.getThrottlingConfigurationModel());
                    }
                    if (guidesConfigurationModel.getLastStepSeenConfigurationModel() != null) {
                        GuidesConfigurationManager.INSTANCE.setLastStepSeenConfigurationModel(guidesConfigurationModel.getLastStepSeenConfigurationModel());
                    }
                }
                sdk.pendo.io.c8.b.f().b(this.mInitConfiguration.getInitAnalyticsModel());
                sdk.pendo.io.c8.b.f().a(this.mInitConfiguration.getInitAnalyticsModel());
                PendoLogger.d("Buffer and storage size params updated:  bufferQueueSize = '" + sdk.pendo.io.c8.b.f().e() + "' bufferDuration = '" + sdk.pendo.io.c8.b.f().d() + "' maxStorageSizeMB = '" + sdk.pendo.io.c8.b.f().g() + "'.", new Object[0]);
            } else {
                PendoLogger.d("Using default buffer and default storage size:  bufferQueueSize = '" + sdk.pendo.io.c8.b.f().e() + "' bufferDuration = '" + sdk.pendo.io.c8.b.f().d() + "' maxStorageSizeMB = '" + sdk.pendo.io.c8.b.f().g() + "'.", new Object[0]);
            }
            if (!GuidesActionsManager.isInited()) {
                GuidesActionsManager.init();
            }
            if (VisualGuidesManager.getInstance().isAnyGuideShowing()) {
                GuidesActionsManager.getInstance().dismissVisibleGuides();
            }
            PendoInternal.a(this.mMetadata);
            GuidesManager.INSTANCE.storeAndActivateSessionGuides(getGuideList(), PendoCommand.getPendoCommands(this.mGuideActions));
            sendGuidesReceivedAnalytics();
            ActivationManager.INSTANCE.restartWithGuides(getGuideList());
        }
    }

    public void setGuides(List<GuideModel> list) {
        this.mGuides = list;
    }
}
