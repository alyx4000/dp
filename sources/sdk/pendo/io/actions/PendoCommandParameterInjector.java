package sdk.pendo.io.actions;

import com.iterable.iterableapi.IterableConstants;
import io.sentry.clientreport.DiscardedEvent;
import java.util.ArrayList;
import java.util.List;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.PendoCommandsEventBus;
import sdk.pendo.io.actions.guides.AddGenericParamsAndDispatchAction;
import sdk.pendo.io.c8.d;
import sdk.pendo.io.events.ConditionData;
import sdk.pendo.io.g9.e0;
import sdk.pendo.io.g9.z;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepContentModel;
import sdk.pendo.io.utilities.script.JavascriptRunner;
import sdk.pendo.io.y8.a;

/* loaded from: classes6.dex */
public final class PendoCommandParameterInjector {
    private static volatile PendoCommandParameterInjector INSTANCE = null;
    private static final String TAG = "PendoCommandParameterInjector";

    private PendoCommandParameterInjector() {
    }

    public static synchronized PendoCommandParameterInjector getInstance() {
        PendoCommandParameterInjector pendoCommandParameterInjector;
        synchronized (PendoCommandParameterInjector.class) {
            if (INSTANCE == null) {
                INSTANCE = new PendoCommandParameterInjector();
            }
            pendoCommandParameterInjector = INSTANCE;
        }
        return pendoCommandParameterInjector;
    }

    public void addGenericParamsInjectAndDispatch(GuideModel guideModel, String str, List<PendoCommandsEventBus.Parameter> list) {
        if (guideModel != null) {
            try {
                if (guideModel.getSteps() != null && !GuidesManager.INSTANCE.getGuideActions().isEmpty() && !a.d().h()) {
                    e0.a(new AddGenericParamsAndDispatchAction(guideModel, str, list));
                }
            } catch (Exception e) {
                PendoLogger.w(e, e.getMessage(), "PendoCommandParameterInjector addGenericParamsInjectAndDispatch " + str + " " + guideModel);
            }
        }
    }

    public JavascriptRunner.GuideContext generateCommandContext(GuideModel guideModel, List<PendoCommandsEventBus.Parameter> list, PendoCommandEventType pendoCommandEventType) {
        String activatedBy;
        JavascriptRunner.GuideContext guideContext = new JavascriptRunner.GuideContext(guideModel.getGuideId());
        guideContext.set("guideId", guideModel.getGuideId());
        StepContentModel stepContentModel = guideModel.getStepContentModel(StepSeenManager.getInstance().getCurrentStepIndex().intValue());
        if (stepContentModel != null && stepContentModel.getGuideStepId() != null) {
            guideContext.set(VisualGuideBase.GUIDE_STEP_ID_PARAMETER_NAME, stepContentModel.getGuideStepId());
            if (stepContentModel.getPollTypes() != null && !stepContentModel.getPollTypes().isEmpty()) {
                guideContext.set("pollTypes", stepContentModel.getPollTypes().toString());
            }
        }
        VisualGuideBase visualGuide = VisualGuidesManager.getInstance().getVisualGuide(guideModel.getGuideId());
        if (visualGuide != null && (activatedBy = visualGuide.getActivatedBy()) != null) {
            guideContext.set("seenReason", activatedBy);
        }
        guideContext.set("accountId", PendoInternal.k());
        guideContext.set("visitorId", PendoInternal.D());
        guideContext.set("language", guideModel.getGuideLanguage());
        if (list != null) {
            for (PendoCommandsEventBus.Parameter parameter : list) {
                guideContext.set(parameter.getParameterName(), parameter.getParameterValue());
            }
        }
        guideContext.set("eventType", pendoCommandEventType);
        return guideContext;
    }

    public void handleControlGroupAnalytics(GuideModel guideModel) {
        handleGuideNotSeenGeneric(guideModel, PendoCommandEventType.AnalyticsEventType.GUIDE_NOT_DISPLAYED_CONTROL_GROUP, "control");
    }

    public void handleGuideDisplayedAnalytics(final String str, final String str2) {
        if (GuidesActionsManager.getInstance().wasGuideFullyDisplayedAfterAnimation(str)) {
            e0.a(new sdk.pendo.io.s8.a() { // from class: sdk.pendo.io.actions.PendoCommandParameterInjector.1
                @Override // sdk.pendo.io.s8.a
                protected void execute() {
                    GuideModel guide = GuidesManager.INSTANCE.getGuide(str);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new PendoCommandsEventBus.Parameter("seenReason", "string", str2));
                    if (guide != null) {
                        PendoCommandParameterInjector.this.addGenericParamsInjectAndDispatch(guide, PendoCommandEventType.AnalyticsEventType.GUIDE_DISPLAYED.eventType, arrayList);
                        z.a(str, 0L);
                    }
                }
            });
        }
    }

    public void handleGuideNotSeenContentError(GuideModel guideModel) {
        handleGuideNotSeenGeneric(guideModel, PendoCommandEventType.AnalyticsEventType.GUIDE_NOT_DISPLAYED_CONTENT_ERROR, "download-content-error");
    }

    public void handleGuideNotSeenContentNotReady(GuideModel guideModel) {
        handleGuideNotSeenGeneric(guideModel, PendoCommandEventType.AnalyticsEventType.GUIDE_NOT_DISPLAYED_CONTENT_NOT_READY, "content-not-ready");
    }

    public void handleGuideNotSeenGeneric(GuideModel guideModel, PendoCommandEventType.AnalyticsEventType analyticsEventType, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PendoCommandsEventBus.Parameter("notDisplayedReason", "string", str));
        arrayList.add(new PendoCommandsEventBus.Parameter(DiscardedEvent.JsonKeys.REASON, "string", str));
        addGenericParamsInjectAndDispatch(guideModel, analyticsEventType.eventType, arrayList);
    }

    public void handleGuideNotSeenImageError(GuideModel guideModel) {
        handleGuideNotSeenGeneric(guideModel, PendoCommandEventType.AnalyticsEventType.GUIDE_NOT_DISPLAYED_IMAGE_ERROR, "download-image-error");
    }

    public void handleGuideNotSeenImageNotReady(GuideModel guideModel) {
        handleGuideNotSeenGeneric(guideModel, PendoCommandEventType.AnalyticsEventType.GUIDE_NOT_DISPLAYED_CONTENT_NOT_READY, "image-not-ready");
    }

    public void handleGuideTimeoutAnalytics(String str, long j) {
        GuideModel guide = GuidesManager.INSTANCE.getGuide(str);
        if (guide != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PendoCommandsEventBus.Parameter("displayDurationInMillis", ConditionData.NUMBER_VALUE, Long.toString(j)));
            arrayList.add(new PendoCommandsEventBus.Parameter(IterableConstants.ITERABLE_INBOX_IMP_DISPLAY_DURATION, ConditionData.NUMBER_VALUE, Long.toString(j)));
            d.a aVar = d.a.TIME_OUT;
            arrayList.add(new PendoCommandsEventBus.Parameter(DiscardedEvent.JsonKeys.REASON, "string", aVar.b()));
            arrayList.add(new PendoCommandsEventBus.Parameter("notDisplayedReason", "string", aVar.b()));
            arrayList.add(new PendoCommandsEventBus.Parameter(PendoCommandAction.PendoCommandGlobalAction.SendPendoGenericAnalyticsConsts.DISMISSED_BY, "string", aVar.b()));
            if (VisualGuidesManager.getInstance().getVisualGuide(str) != null) {
                arrayList.add(new PendoCommandsEventBus.Parameter("seenReason", "string", VisualGuidesManager.getInstance().getVisualGuide(str).getActivatedBy()));
            }
            addGenericParamsInjectAndDispatch(guide, PendoCommandEventType.AnalyticsEventType.GUIDE_DISMISSED_TIMEOUT.eventType, arrayList);
        }
        z.g(str);
    }

    public void handlePendoCappedOutAnalytics(GuideModel guideModel) {
        ArrayList arrayList = new ArrayList();
        d.b bVar = d.b.ERROR_REASON_CAPPING;
        arrayList.add(new PendoCommandsEventBus.Parameter("notDisplayedReason", "string", bVar.b()));
        arrayList.add(new PendoCommandsEventBus.Parameter(DiscardedEvent.JsonKeys.REASON, "string", bVar.b()));
        addGenericParamsInjectAndDispatch(guideModel, PendoCommandEventType.AnalyticsEventType.GUIDE_NOT_DISPLAYED_OUT_OF_CAPPING.eventType, arrayList);
    }

    public void handlePendoUserActionAnalytics(String str, long j) {
        GuideModel guide = GuidesManager.INSTANCE.getGuide(str);
        if (guide != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PendoCommandsEventBus.Parameter("displayDurationInMillis", ConditionData.NUMBER_VALUE, Long.toString(j)));
            arrayList.add(new PendoCommandsEventBus.Parameter(IterableConstants.ITERABLE_INBOX_IMP_DISPLAY_DURATION, ConditionData.NUMBER_VALUE, Long.toString(j)));
            d.a aVar = d.a.USER_ACTION;
            arrayList.add(new PendoCommandsEventBus.Parameter(DiscardedEvent.JsonKeys.REASON, "string", aVar.b()));
            arrayList.add(new PendoCommandsEventBus.Parameter(PendoCommandAction.PendoCommandGlobalAction.SendPendoGenericAnalyticsConsts.DISMISSED_BY, "string", aVar.b()));
            if (VisualGuidesManager.getInstance().getVisualGuide(str) != null) {
                arrayList.add(new PendoCommandsEventBus.Parameter("seenReason", "string", VisualGuidesManager.getInstance().getVisualGuide(str).getActivatedBy()));
            }
            addGenericParamsInjectAndDispatch(guide, PendoCommandEventType.AnalyticsEventType.GUIDE_DISMISSED_USER_ACTION.eventType, arrayList);
        }
        z.g(str);
    }
}
