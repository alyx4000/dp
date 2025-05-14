package sdk.pendo.io.actions;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.iterable.iterableapi.IterableConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.R;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.PendoCommandsEventBus;
import sdk.pendo.io.actions.configurations.GuideCapping;
import sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler;
import sdk.pendo.io.b6.b;
import sdk.pendo.io.c8.f;
import sdk.pendo.io.c8.h;
import sdk.pendo.io.constants.a;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.d6.j;
import sdk.pendo.io.events.ConditionData;
import sdk.pendo.io.g9.z;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.ActivationModel;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.models.StepModel;
import sdk.pendo.io.models.StepSeen;
import sdk.pendo.io.sdk.react.PlatformStateManager;
import sdk.pendo.io.x5.d;

/* loaded from: classes6.dex */
public abstract class VisualGuideBase extends GuideModel {
    public static final String DEFAULT_ACTIVATED_BY = "";
    private static final int DEFAULT_IRRELEVANT_VALUE = -1;
    public static final String DISMISS_VISIBLE_GUIDES = "dismissVisibleGuides";
    public static final String GUIDE_STEP_ID_PARAMETER_NAME = "guideStepId";
    static final long NO_CLOSE_DELAY = 0;
    public static final String TAG = "VisualGuideBase";
    String mActivatedBy;
    WeakReference<Activity> mActivity;
    JSONObject mAdditionalInfo;
    private b mAdvanceGuideCommandSubscription;
    String mCarouselId;
    private ViewGroup mContainer;
    long mCurrentGuideStepDuration;
    final sdk.pendo.io.u6.b<Object> mDestroyingSubject;
    private b mDismissGuideCommandSubscription;
    HashMap<String, GuideStepDuration> mGuideStepDurationMap;
    VisualGuideLifecycleListener mListener;
    private ViewGroup mRootView;
    AtomicBoolean mShowing;
    sdk.pendo.io.d8.b mStatusBarColorAnimation;
    protected StepSeenManagerInterface mStepSeenManager;
    VisualAnimationManager mVisualAnimationManager;
    VisualGuideType mVisualGuideType;

    public enum VisualGuideType {
        FULL_SCREEN(R.id.insert_visual_scrollview_container, R.layout.pnd_visual_insert),
        TOOLTIP(R.id.pnd_containerId, -1),
        BANNER(R.id.pnd_containerId, -1),
        CAROUSEL(R.id.pendo_view_pager_container, R.layout.pnd_view_pager);

        public final int mContainerId;
        public final int mLayoutId;

        VisualGuideType(int i, int i2) {
            this.mContainerId = i;
            this.mLayoutId = i2;
        }

        public int getContainerId() {
            return this.mContainerId;
        }

        public int getLayoutId() {
            return this.mLayoutId;
        }
    }

    VisualGuideBase(GuideModel guideModel, VisualGuideLifecycleListener visualGuideLifecycleListener) {
        super(guideModel);
        this.mActivatedBy = "";
        this.mCurrentGuideStepDuration = 0L;
        this.mAdditionalInfo = new JSONObject();
        this.mShowing = new AtomicBoolean(false);
        this.mGuideStepDurationMap = new HashMap<>();
        this.mDestroyingSubject = sdk.pendo.io.u6.b.f();
        this.mListener = visualGuideLifecycleListener;
    }

    private d<Object> destroyed() {
        return this.mDestroyingSubject;
    }

    private void fireNextTriggerForScreenChangeOnceNoGuideIsDisplayed() {
        VisualGuidesManager.getInstance().getIsFullScreenGuideShowingObservable().a(new j() { // from class: sdk.pendo.io.actions.VisualGuideBase$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.d6.j
            public final boolean test(Object obj) {
                return VisualGuideBase.lambda$fireNextTriggerForScreenChangeOnceNoGuideIsDisplayed$0((Boolean) obj);
            }
        }).f().a(sdk.pendo.io.d9.b.a(new e() { // from class: sdk.pendo.io.actions.VisualGuideBase$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                VisualGuideBase.this.m3037x790b3099((Boolean) obj);
            }
        }, "VisualGuideBase is full screen guide displayed observer"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleAdvanceGuide(sdk.pendo.io.actions.PendoCommand r5) {
        /*
            r4 = this;
            java.lang.String r0 = "guideId"
            java.lang.String r0 = r5.getParamValueFromCommand(r0)
            java.lang.String r1 = r4.getGuideId()
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L11
            return
        L11:
            java.lang.Integer r0 = r4.getNextGuideStepIndex(r5)
            if (r0 == 0) goto L42
            int r1 = r0.intValue()
            java.lang.String r1 = r4.getGuideStepId(r1)
            int r2 = r0.intValue()
            java.util.List r3 = r4.getSteps()
            int r3 = r3.size()
            if (r2 >= r3) goto L3a
            java.lang.String r2 = ""
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L3a
            boolean r0 = r4.advanceGuide(r5, r1, r0)
            goto L43
        L3a:
            r4.handleCapping()
            sdk.pendo.io.actions.StepSeenManagerInterface r0 = r4.mStepSeenManager
            r0.reset()
        L42:
            r0 = 1
        L43:
            if (r0 == 0) goto L5a
            r4.handleHidingVisualGuide(r5)
            sdk.pendo.io.b6.b r5 = r4.mAdvanceGuideCommandSubscription
            if (r5 == 0) goto L5a
            boolean r5 = r5.a()
            if (r5 != 0) goto L5a
            sdk.pendo.io.b6.b r5 = r4.mAdvanceGuideCommandSubscription
            r5.dispose()
            r5 = 0
            r4.mAdvanceGuideCommandSubscription = r5
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.actions.VisualGuideBase.handleAdvanceGuide(sdk.pendo.io.actions.PendoCommand):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDismissGuide(PendoCommand pendoCommand) {
        String paramValueFromCommand;
        try {
            paramValueFromCommand = pendoCommand.getParamValueFromCommand("guideId");
        } catch (Exception e) {
            PendoLogger.e(e.getMessage(), new Object[0]);
        }
        if ((TextUtils.isEmpty(paramValueFromCommand) || !getGuideId().equals(paramValueFromCommand)) && !DISMISS_VISIBLE_GUIDES.equals(pendoCommand.getSourceId())) {
            return;
        }
        if (PendoCommandEventType.SdkEventType.TIME_OUT.equals(pendoCommand.getEventType())) {
            PendoCommandParameterInjector.getInstance().handleGuideTimeoutAnalytics(getGuideId(), getDuration());
        }
        if (PendoCommandDispatcher.PredefinedCommands.SOURCE_ID_BACK_BUTTON.equals(pendoCommand.getSourceId())) {
            handleBackButtonAction();
        }
        GuideModel guide = GuidesManager.INSTANCE.getGuide(getGuideId());
        boolean equals = getGuideId().equals(this.mStepSeenManager.getCurrentStepGuideId());
        if (guide != null) {
            guide.setGuideShown();
            guide.getStatusValue().terminateGuide(guide);
            changeGuideActivationAfterDismissIfNeeded(guide);
        }
        notifyClose(pendoCommand);
        if (!equals || !this.mStepSeenManager.isLaunchGuideFromGuideStep()) {
            handleCapping();
        }
        if (equals) {
            this.mStepSeenManager.reset();
        }
        handleHidingVisualGuide(pendoCommand);
        b bVar = this.mDismissGuideCommandSubscription;
        if (bVar == null || bVar.a()) {
            return;
        }
        this.mDismissGuideCommandSubscription.dispose();
        this.mDismissGuideCommandSubscription = null;
    }

    private void handleHidingVisualGuide(PendoCommand pendoCommand) {
        hideVisualGuide(pendoCommand);
        GuidesConfigurationManager.INSTANCE.setLastSeenTimeMS(System.currentTimeMillis());
        fireNextTriggerForScreenChangeOnceNoGuideIsDisplayed();
    }

    private void hideWithAnimation() {
        this.mVisualAnimationManager.performHide(null, true);
    }

    private void hideWithNoAnimation() {
        this.mVisualAnimationManager.performHide(null, false);
    }

    static /* synthetic */ boolean lambda$fireNextTriggerForScreenChangeOnceNoGuideIsDisplayed$0(Boolean bool) {
        return !bool.booleanValue();
    }

    private void notifyClose(PendoCommand pendoCommand) {
        PendoCommandDispatcher.getInstance().dispatchCommand(new PendoCommand.Builder(PendoCommandAction.PendoCommandGlobalAction.NOTIFY_CLOSE, PendoCommandEventType.PENDO_COMMAND_EVENT_TYPE_ANY).setSourceId(getGuideId()).setScope(pendoCommand.getScope()).setParameters(PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.createPendoMetadataParams(getGuideId())).build(), true);
    }

    private boolean shouldManuallyTriggerHandleGlobalLayoutChanges() {
        PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
        return platformStateManager.isReactNativeApp() || platformStateManager.isFlutterCodelessApp();
    }

    private void subscribeForCommandActions() {
        this.mDismissGuideCommandSubscription = PendoGlobalCommandHandler.getInstance().getDismissGuideCommandPublisher().a(new e() { // from class: sdk.pendo.io.actions.VisualGuideBase$$ExternalSyntheticLambda3
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                VisualGuideBase.this.handleDismissGuide((PendoCommand) obj);
            }
        });
        this.mAdvanceGuideCommandSubscription = PendoGlobalCommandHandler.getInstance().getAdvanceGuideCommandPublisher().a(new e() { // from class: sdk.pendo.io.actions.VisualGuideBase$$ExternalSyntheticLambda4
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                VisualGuideBase.this.handleAdvanceGuide((PendoCommand) obj);
            }
        });
    }

    protected boolean advanceGuide(PendoCommand pendoCommand, String str, Integer num) {
        notifyClose(pendoCommand);
        this.mStepSeenManager.setCurrentStepSeen(new StepSeen(getGuideId(), str, num));
        return true;
    }

    final void cancelDuration() {
        try {
            this.mDestroyingSubject.onNext(a.f968a);
        } catch (Exception e) {
            PendoLogger.d(TAG, "cancelDuration, exception: " + e.getMessage());
        }
    }

    void changeGuideActivationAfterDismissIfNeeded(GuideModel guideModel) {
        StepModel guideStepModel = guideModel.getGuideStepModel(guideModel.getGuideStepId(0));
        if (guideStepModel == null || guideStepModel.getStepActivations() == null) {
            return;
        }
        for (ActivationModel activationModel : guideStepModel.getStepActivations()) {
            if (activationModel.isActivationOverriden() && ActivationManager.ActivationEvents.VIEW.getActivationEvent().equals(activationModel.getEvent()) && activationModel.getFeatureSelector() != null) {
                activationModel.setEvent(ActivationManager.ActivationEvents.CLICK.getActivationEvent());
                activationModel.setIsActivationOverridden(false);
            }
        }
    }

    void createVisualAnimationManager(StepGuideModel stepGuideModel) {
        this.mVisualAnimationManager = new VisualAnimationManager(getGuideId(), stepGuideModel.getConfiguration());
    }

    public void fireNextTrigger() {
        if (PlatformStateManager.INSTANCE.isTrackEventSolutionOnly()) {
            ActivationManager.INSTANCE.getActivationTriggerSubject().onNext(Boolean.TRUE);
        } else if (shouldManuallyTriggerHandleGlobalLayoutChanges()) {
            PendoInternal.x().a(false);
        } else {
            PendoInternal.x().l();
        }
    }

    public String getActivatedBy() {
        return this.mActivatedBy;
    }

    public final boolean getAndSetShowing(boolean z) {
        return this.mShowing.getAndSet(z);
    }

    public VisualAnimationManager getAnimationManager() {
        return this.mVisualAnimationManager;
    }

    protected ViewGroup getContainer() {
        return this.mContainer;
    }

    int getContainerId() {
        return this.mVisualGuideType.getContainerId();
    }

    public final synchronized long getDuration() {
        GuideStepDuration guideStepDuration = this.mGuideStepDurationMap.get(this.mStepSeenManager.getCurrentStepId());
        if (guideStepDuration == null) {
            return 0L;
        }
        return guideStepDuration.getDuration();
    }

    Integer getNextGuideStepIndex(PendoCommand pendoCommand) {
        Integer guideStepIndex = getGuideStepIndex(this.mStepSeenManager.getCurrentStepId());
        String str = null;
        if (guideStepIndex == null) {
            PendoLogger.w("Current guide step seen is null, not continuing to next guide", new Object[0]);
            return null;
        }
        List<PendoCommandsEventBus.Parameter> parameters = pendoCommand.getParameters();
        if (parameters != null) {
            for (PendoCommandsEventBus.Parameter parameter : parameters) {
                if (parameter.getParameterName().equals(GUIDE_STEP_ID_PARAMETER_NAME)) {
                    str = parameter.getParameterValue();
                }
            }
        }
        return str != null ? getGuideStepIndex(str) : Integer.valueOf(guideStepIndex.intValue() + 1);
    }

    final ViewGroup getRootView() {
        return this.mRootView;
    }

    StepGuideModel getStepGuideModel() {
        return getGuideStepModel(this.mStepSeenManager.getCurrentStepIndex().intValue());
    }

    VisualGuideType getVisualGuideType() {
        return this.mVisualGuideType;
    }

    public void handleBackButtonAction() {
        h tracker = getTracker();
        if (tracker == null || tracker.b() == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VisualGuideBase visualGuide = VisualGuidesManager.getInstance().getVisualGuide(getGuideId());
        if (visualGuide != null) {
            arrayList.add(new PendoCommandsEventBus.Parameter("seenReason", "string", visualGuide.getActivatedBy()));
            arrayList.add(new PendoCommandsEventBus.Parameter("displayDurationInMillis", ConditionData.NUMBER_VALUE, Long.toString(visualGuide.getDuration())));
            arrayList.add(new PendoCommandsEventBus.Parameter(IterableConstants.ITERABLE_INBOX_IMP_DISPLAY_DURATION, ConditionData.NUMBER_VALUE, Long.toString(visualGuide.getDuration())));
        }
        PendoCommandParameterInjector.getInstance().addGenericParamsInjectAndDispatch(this, PendoCommandEventType.AnalyticsEventType.GUIDE_DISMISSED_BACK_BUTTON.eventType, arrayList);
        z.g(getGuideId());
    }

    void handleCapping() {
        if (getGeneralGuideConfiguration() != null) {
            GuideCapping capping = getGeneralGuideConfiguration().getCapping();
            capping.consumeOne();
            if (capping.canConsumeOne()) {
                return;
            }
            ActivationManager.INSTANCE.removeGuideIdFromTriggers(getGuideId());
        }
    }

    public void handleGuideSeenAnalytics() {
        h tracker = getTracker();
        if (tracker == null) {
            PendoLogger.e("VisualGuideBase -> handleGuideSeenAnalytics, tracker is null ", new Object[0]);
            return;
        }
        boolean isGuideSeenAnalyticSent = StepSeenManager.getInstance().getCurrentStepSeen().isGuideSeenAnalyticSent();
        if (tracker.b() == null || isGuideSeenAnalyticSent) {
            return;
        }
        PendoCommandParameterInjector.getInstance().handleGuideDisplayedAnalytics(getGuideId(), this.mActivatedBy);
        StepSeenManager.getInstance().getCurrentStepSeen().setGuideSeenAnalyticSent(true);
    }

    void hideVisualGuide(final PendoCommand pendoCommand) {
        WeakReference<Activity> weakReference = this.mActivity;
        if (weakReference == null || weakReference.get() == null || this.mActivity.get().isFinishing()) {
            return;
        }
        this.mActivity.get().runOnUiThread(new Runnable() { // from class: sdk.pendo.io.actions.VisualGuideBase$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                VisualGuideBase.this.m3038lambda$hideVisualGuide$2$sdkpendoioactionsVisualGuideBase(pendoCommand);
            }
        });
    }

    protected void init(String str, sdk.pendo.io.c8.d dVar) {
        this.mListener.onCreate(this);
        setTracker(f.a(dVar));
        this.mActivatedBy = str;
        subscribeForCommandActions();
    }

    protected synchronized void initializeTimeoutCounter(int i) {
    }

    public final boolean isShowing() {
        return this.mShowing.get();
    }

    /* renamed from: lambda$fireNextTriggerForScreenChangeOnceNoGuideIsDisplayed$1$sdk-pendo-io-actions-VisualGuideBase, reason: not valid java name */
    /* synthetic */ void m3037x790b3099(Boolean bool) {
        fireNextTrigger();
    }

    /* renamed from: lambda$hideVisualGuide$2$sdk-pendo-io-actions-VisualGuideBase, reason: not valid java name */
    /* synthetic */ void m3038lambda$hideVisualGuide$2$sdkpendoioactionsVisualGuideBase(PendoCommand pendoCommand) {
        if (DISMISS_VISIBLE_GUIDES.equals(pendoCommand.getSourceId())) {
            hideWithNoAnimation();
        } else {
            hideWithAnimation();
        }
    }

    void onDestroy() {
    }

    protected synchronized void resetGuideStepDuration(String str) {
        GuideStepDuration guideStepDuration;
        if (this.mGuideStepDurationMap.containsKey(str) && (guideStepDuration = this.mGuideStepDurationMap.get(str)) != null) {
            guideStepDuration.reset();
        }
    }

    final void setContainerView(ViewGroup viewGroup) {
        this.mContainer = viewGroup;
    }

    final void setRootView(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    synchronized void setStartDuration(long j) {
        String currentStepId = this.mStepSeenManager.getCurrentStepId();
        GuideStepDuration guideStepDuration = this.mGuideStepDurationMap.get(currentStepId);
        if (guideStepDuration == null) {
            guideStepDuration = new GuideStepDuration();
            this.mGuideStepDurationMap.put(currentStepId, guideStepDuration);
        }
        guideStepDuration.setStartDuration(j);
    }

    public abstract boolean show();

    void startTimeout() {
    }

    protected void unsubscribeSubscriptions() {
        b bVar = this.mDismissGuideCommandSubscription;
        if (bVar != null && !bVar.a()) {
            this.mDismissGuideCommandSubscription.dispose();
            this.mDismissGuideCommandSubscription = null;
        }
        b bVar2 = this.mAdvanceGuideCommandSubscription;
        if (bVar2 == null || bVar2.a()) {
            return;
        }
        this.mAdvanceGuideCommandSubscription.dispose();
        this.mAdvanceGuideCommandSubscription = null;
    }

    VisualGuideBase(StepGuideModel stepGuideModel, VisualGuideLifecycleListener visualGuideLifecycleListener) {
        super(stepGuideModel);
        this.mActivatedBy = "";
        this.mCurrentGuideStepDuration = 0L;
        this.mAdditionalInfo = new JSONObject();
        this.mShowing = new AtomicBoolean(false);
        this.mGuideStepDurationMap = new HashMap<>();
        this.mDestroyingSubject = sdk.pendo.io.u6.b.f();
        this.mListener = visualGuideLifecycleListener;
    }
}
