package sdk.pendo.io.actions;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.reactcommunity.rndatetimepicker.Common;
import io.sentry.Session;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.a8.c;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.PendoFloatingVisualGuideManager;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.c8.d;
import sdk.pendo.io.g9.k0;
import sdk.pendo.io.g9.p;
import sdk.pendo.io.k0.f;
import sdk.pendo.io.k0.l;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.models.StepModel;
import sdk.pendo.io.sdk.flutter.FlutterScreenManager;
import sdk.pendo.io.utilities.script.JavascriptRunner;
import sdk.pendo.io.views.GuideViewHolder;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 72\u00020\u0001:\u00017B%\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\b\u00102\u001a\u0004\u0018\u000101\u0012\b\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b5\u00106J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J(\u0010\u0013\u001a\u00020\t2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0006\u0010\u0016\u001a\u00020\tJ\u0010\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0019\u001a\u00020\tH\u0016R\"\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u0004\u0018\u00010$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0013\u0010.\u001a\u0004\u0018\u00010+8F¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00068"}, d2 = {"Lsdk/pendo/io/actions/ToolTipVisualGuide;", "Lsdk/pendo/io/actions/FloatingVisualGuide;", "", "idHash", "Landroid/view/View;", "viewFromJson", "Lsdk/pendo/io/a8/c$a;", "createBuilder", "builder", "", "addBackDropPropertiesToBuilder", "dimenName", "", "getDimenInPxFromStringInDP", "Ljava/lang/ref/WeakReference;", "viewRef", "Lsdk/pendo/io/c8/d;", "analyticsData", "activatedBy", Session.JsonKeys.INIT, "", "show", "removeOnMainThread", "guideId", "handleTouchOutsideTooltip", "onDestroy", "Ljava/util/HashMap;", "", "backDropPropertiesToBePopulated", "Ljava/util/HashMap;", "anchorView", "Landroid/view/View;", "Lsdk/pendo/io/k0/f;", "getBackDropProperties", "()Lsdk/pendo/io/k0/f;", "backDropProperties", "Lsdk/pendo/io/k0/l;", "getToolTipWidgetWrapperJsonObject", "()Lsdk/pendo/io/k0/l;", "toolTipWidgetWrapperJsonObject", "getTouchPassThrough", "()Z", "touchPassThrough", "Lsdk/pendo/io/a8/c;", "getTooltipManager", "()Lsdk/pendo/io/a8/c;", "tooltipManager", "Lsdk/pendo/io/models/GuideModel;", "guideModel", "Lsdk/pendo/io/actions/VisualGuideLifecycleListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lsdk/pendo/io/actions/StepSeenManagerInterface;", "stepSeenManager", "<init>", "(Lsdk/pendo/io/models/GuideModel;Lsdk/pendo/io/actions/VisualGuideLifecycleListener;Lsdk/pendo/io/actions/StepSeenManagerInterface;)V", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class ToolTipVisualGuide extends FloatingVisualGuide {
    private static final String CLICK_ACTION_CLICK_THROUGH_VALUE = "click_through";
    private View anchorView;
    private final HashMap<String, Object> backDropPropertiesToBePopulated;
    private static final int DEFAULT_BACKDROP_COLOR = Color.parseColor("#AA000000");
    private static final HashSet<String> SUPPORTED_TOOLTIP_PROPERTIES = new HashSet<>(CollectionsKt.listOf((Object[]) new String[]{ViewProps.POSITION, AppStateModule.APP_STATE_BACKGROUND, ViewProps.FONT_FAMILY, Common.TEXT_COLOR, "text", "textStyle", "textSize", "textDirection", ViewProps.PADDING, "gravity", "frameColor", "frameWidth", "frameRadius", "caret_width", "caret_height", "layout_marginLeft", "layout_marginRight", "layout_marginTop", "layout_marginBottom", "ariaLabel"}));
    private static final String BACKDROP_COLOR_KEY = "mobileBackdropBackground";
    private static final String SEE_THROUGH_FEATURE_TOGGLE = "seeThroughFeature";
    private static final String SEE_THROUGH_FEATURE_PADDING_TOP = "seeThroughFeaturePaddingTop";
    private static final String SEE_THROUGH_FEATURE_PADDING_RIGHT = "seeThroughFeaturePaddingRight";
    private static final String SEE_THROUGH_FEATURE_PADDING_BOTTOM = "seeThroughFeaturePaddingBottom";
    private static final String SEE_THROUGH_FEATURE_PADDING_LEFT = "seeThroughFeaturePaddingLeft";
    private static final String SEE_THROUGH_FEATURE_RADIUS = "seeThroughFeatureRadius";
    private static final HashSet<String> SUPPORTED_BACKDROP_PROPERTIES = new HashSet<>(CollectionsKt.listOf((Object[]) new String[]{BACKDROP_COLOR_KEY, SEE_THROUGH_FEATURE_TOGGLE, SEE_THROUGH_FEATURE_PADDING_TOP, SEE_THROUGH_FEATURE_PADDING_RIGHT, SEE_THROUGH_FEATURE_PADDING_BOTTOM, SEE_THROUGH_FEATURE_PADDING_LEFT, "hasMobileBackdrop", SEE_THROUGH_FEATURE_RADIUS, "ariaLabel"}));

    public ToolTipVisualGuide(GuideModel guideModel, VisualGuideLifecycleListener visualGuideLifecycleListener, StepSeenManagerInterface stepSeenManagerInterface) {
        super(VisualGuideBase.VisualGuideType.TOOLTIP, guideModel, visualGuideLifecycleListener, stepSeenManagerInterface);
        this.backDropPropertiesToBePopulated = new HashMap<>();
    }

    private final void addBackDropPropertiesToBuilder(c.a builder) {
        int i;
        boolean z = true;
        builder.withBackDrop(true);
        if (this.backDropPropertiesToBePopulated.get(SEE_THROUGH_FEATURE_TOGGLE) != null) {
            Object obj = this.backDropPropertiesToBePopulated.get(SEE_THROUGH_FEATURE_TOGGLE);
            if (!(obj != null && k0.a(obj))) {
                z = false;
            }
        }
        if (this.backDropPropertiesToBePopulated.get(BACKDROP_COLOR_KEY) != null) {
            Object obj2 = this.backDropPropertiesToBePopulated.get(BACKDROP_COLOR_KEY);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            i = Color.parseColor(k0.a((String) obj2));
        } else {
            i = DEFAULT_BACKDROP_COLOR;
        }
        builder.a(getDimenInPxFromStringInDP(SEE_THROUGH_FEATURE_PADDING_BOTTOM));
        builder.d(getDimenInPxFromStringInDP(SEE_THROUGH_FEATURE_PADDING_TOP));
        builder.b(getDimenInPxFromStringInDP(SEE_THROUGH_FEATURE_PADDING_LEFT));
        builder.c(getDimenInPxFromStringInDP(SEE_THROUGH_FEATURE_PADDING_RIGHT));
        builder.a(i);
        builder.withSeeThrough(z);
        builder.seeThroughRadius(getDimenInPxFromStringInDP(SEE_THROUGH_FEATURE_RADIUS));
    }

    private final c.a createBuilder(final String idHash, View viewFromJson) {
        PendoFloatingVisualGuideManager.Builder withCustomView = new c.a(idHash).anchor(this.anchorView, getPosition()).closePolicy(0L).background(getBackground()).toggleArrow(true).withCustomView(viewFromJson);
        String guideId = getGuideId();
        Intrinsics.checkNotNullExpressionValue(guideId, "getGuideId(...)");
        PendoFloatingVisualGuideManager.Builder withCallback = withCustomView.guideId(guideId).withCallback(new PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks() { // from class: sdk.pendo.io.actions.ToolTipVisualGuide$createBuilder$1
            @Override // sdk.pendo.io.actions.PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks
            public void onClosing(boolean fromUser, long displayDuration, boolean wasShown) {
                if (wasShown) {
                    if (fromUser) {
                        PendoCommandParameterInjector.getInstance().handlePendoUserActionAnalytics(ToolTipVisualGuide.this.mAnalyticsData.c(), displayDuration);
                    } else {
                        PendoCommandParameterInjector.getInstance().handleGuideTimeoutAnalytics(ToolTipVisualGuide.this.mAnalyticsData.c(), displayDuration);
                    }
                }
            }

            @Override // sdk.pendo.io.actions.PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks
            public void onDetach() {
                c a2 = c.INSTANCE.a();
                if (a2 != null) {
                    a2.removeFromMap(idHash);
                }
                ToolTipVisualGuide.this.onDestroy();
            }

            @Override // sdk.pendo.io.actions.PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks
            public void onReadyForShow(ViewGroup guide) {
                Window window;
                ToolTipVisualGuide.this.mActivity = new WeakReference<>(sdk.pendo.io.n8.c.g().f());
                if (guide != null) {
                    ToolTipVisualGuide.this.setContainerView(guide);
                }
                ToolTipVisualGuide toolTipVisualGuide = ToolTipVisualGuide.this;
                Activity activity = toolTipVisualGuide.mActivity.get();
                View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
                toolTipVisualGuide.setRootView(decorView instanceof ViewGroup ? (ViewGroup) decorView : null);
                ToolTipVisualGuide toolTipVisualGuide2 = ToolTipVisualGuide.this;
                VisualAnimationManager visualAnimationManager = toolTipVisualGuide2.mVisualAnimationManager;
                WeakReference<Activity> weakReference = toolTipVisualGuide2.mActivity;
                visualAnimationManager.performShow(weakReference != null ? weakReference.get() : null, null);
            }

            @Override // sdk.pendo.io.actions.PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks
            public void onTouchOutside(String id) {
                ToolTipVisualGuide.this.handleTouchOutsideTooltip(id);
            }
        });
        Intrinsics.checkNotNull(withCallback, "null cannot be cast to non-null type external.sdk.pendo.io.tooltip.PendoTooltipManager.Builder");
        return (c.a) withCallback;
    }

    private final f getBackDropProperties() {
        if (getSteps() != null) {
            Intrinsics.checkNotNullExpressionValue(getSteps(), "getSteps(...)");
            if (!r0.isEmpty()) {
                List<StepModel> steps = getSteps();
                Integer currentStepIndex = this.mStepSeenManager.getCurrentStepIndex();
                Intrinsics.checkNotNullExpressionValue(currentStepIndex, "getCurrentStepIndex(...)");
                return GuideActionConfiguration.getGuideContentProperties(steps.get(currentStepIndex.intValue()));
            }
        }
        return null;
    }

    private final float getDimenInPxFromStringInDP(String dimenName) {
        if (((String) this.backDropPropertiesToBePopulated.get(dimenName)) == null) {
            return 0.0f;
        }
        return k0.a(k0.b(r2), 0);
    }

    private final l getToolTipWidgetWrapperJsonObject() {
        if (getSteps() != null) {
            Intrinsics.checkNotNullExpressionValue(getSteps(), "getSteps(...)");
            if (!r0.isEmpty()) {
                List<StepModel> steps = getSteps();
                Integer currentStepIndex = this.mStepSeenManager.getCurrentStepIndex();
                Intrinsics.checkNotNullExpressionValue(currentStepIndex, "getCurrentStepIndex(...)");
                return GuideActionConfiguration.getTooltipWidgetWrapperObject(steps.get(currentStepIndex.intValue()));
            }
        }
        return null;
    }

    private final boolean getTouchPassThrough() {
        l a2;
        l toolTipWidgetWrapperJsonObject = getToolTipWidgetWrapperJsonObject();
        if (toolTipWidgetWrapperJsonObject == null || (a2 = k0.a(toolTipWidgetWrapperJsonObject.b("properties"), "click_action")) == null) {
            return false;
        }
        return StringsKt.equals(CLICK_ACTION_CLICK_THROUGH_VALUE, a2.a("value").g(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeOnMainThread$lambda$2(ToolTipVisualGuide this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mAnalyticsData == null) {
            return;
        }
        c a2 = c.INSTANCE.a();
        if (a2 != null) {
            String c = this$0.mAnalyticsData.c();
            Intrinsics.checkNotNullExpressionValue(c, "getGuideId(...)");
            a2.remove(c);
        }
        this$0.onDestroy();
        VisualGuidesManager.getInstance().setIsFullScreenGuideShowing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void show$lambda$1(sdk.pendo.io.actions.ToolTipVisualGuide r1, java.lang.String r2, android.view.View r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, boolean r7, java.lang.String r8, java.lang.String r9, boolean r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, sdk.pendo.io.a8.c r15) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            sdk.pendo.io.a8.c$a r2 = r1.createBuilder(r2, r3)
            if (r4 == 0) goto L1a
            if (r5 == 0) goto L1a
            sdk.pendo.io.actions.PendoFloatingVisualGuideManager$Builder r3 = r2.strokeColor(r5)
            r3.strokeWidth(r4)
        L1a:
            if (r6 == 0) goto L1f
            r2.frameRadius(r6)
        L1f:
            if (r7 == 0) goto L24
            r1.addBackDropPropertiesToBuilder(r2)
        L24:
            if (r8 == 0) goto L2b
            if (r9 == 0) goto L2b
            r2.a(r8, r9)
        L2b:
            r2.withTouchPassThrough(r10)
            r2.withMargins(r11, r12, r13, r14)
            java.lang.String r3 = "ariaLabel"
            java.lang.String r3 = r1.getPropertyValuefromViewProperties(r3)
            r2.setPaneTitle(r3)
            android.view.View r3 = r1.anchorView
            r4 = 0
            if (r3 == 0) goto L87
            boolean r3 = sdk.pendo.io.g9.q0.a(r3, r4)
            if (r3 == 0) goto L87
            android.view.accessibility.AccessibilityNodeInfo r3 = android.view.accessibility.AccessibilityNodeInfo.obtain()
            android.view.View r5 = r1.anchorView
            if (r5 == 0) goto L50
            r5.onInitializeAccessibilityNodeInfo(r3)
        L50:
            if (r3 == 0) goto L87
            boolean r3 = r3.isVisibleToUser()
            if (r3 == 0) goto L87
            sdk.pendo.io.f9.f r3 = sdk.pendo.io.PendoInternal.x()
            java.lang.ref.WeakReference r3 = r3.e()
            if (r3 == 0) goto L73
            java.lang.Object r3 = r3.get()
            sdk.pendo.io.listeners.views.PendoDrawerListener r3 = (sdk.pendo.io.listeners.views.PendoDrawerListener) r3
            if (r3 == 0) goto L73
            int r3 = r3.getDrawerState()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L74
        L73:
            r3 = 0
        L74:
            if (r3 == 0) goto L7c
            int r3 = r3.intValue()
            if (r3 != 0) goto L87
        L7c:
            if (r15 == 0) goto L87
            sdk.pendo.io.a8.c$a r2 = r2.build()
            boolean r2 = r15.a(r2)
            goto L88
        L87:
            r2 = r4
        L88:
            if (r2 == 0) goto L8f
            r2 = 1
            r1.getAndSetShowing(r2)
            goto La6
        L8f:
            sdk.pendo.io.c8.h r2 = r1.getTracker()
            if (r2 == 0) goto L9c
            sdk.pendo.io.c8.d$b r3 = sdk.pendo.io.c8.d.b.ERROR_REASON_UNKNOWN
            org.json.JSONObject r5 = r1.mAdditionalInfo
            sdk.pendo.io.g9.d.a(r2, r3, r5)
        L9c:
            r1.onDestroy()
            sdk.pendo.io.actions.VisualGuidesManagerInterface r1 = sdk.pendo.io.actions.VisualGuidesManager.getInstance()
            r1.setIsFullScreenGuideShowing(r4)
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.actions.ToolTipVisualGuide.show$lambda$1(sdk.pendo.io.actions.ToolTipVisualGuide, java.lang.String, android.view.View, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, sdk.pendo.io.a8.c):void");
    }

    public final synchronized c getTooltipManager() {
        PendoFloatingVisualGuideManager.Companion companion = PendoFloatingVisualGuideManager.INSTANCE;
        Activity f = sdk.pendo.io.n8.c.g().f();
        Intrinsics.checkNotNullExpressionValue(f, "getCurrentVisibleActivity(...)");
        companion.resetContext(f);
        return c.INSTANCE.a();
    }

    public final void handleTouchOutsideTooltip(String guideId) {
        l toolTipWidgetWrapperJsonObject = getToolTipWidgetWrapperJsonObject();
        if (toolTipWidgetWrapperJsonObject == null) {
            PendoLogger.d("No actions to handle touch outside tooltip event.", new Object[0]);
            return;
        }
        f b = p.b(toolTipWidgetWrapperJsonObject, "actions");
        if (b == null || b.size() <= 0) {
            return;
        }
        List<PendoCommand> pendoCommandsWithParameters = PendoCommand.getPendoCommandsWithParameters(b, PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.createPendoMetadataParams(guideId), new JavascriptRunner.GuideContext(guideId));
        JavascriptRunner.GuideContext.addBasicParamsToGuideCommands(pendoCommandsWithParameters);
        PendoCommandDispatcher.getInstance().dispatchCommands(pendoCommandsWithParameters, PendoCommandEventType.UserEventType.TAP_ON, true);
    }

    @Override // sdk.pendo.io.actions.FloatingVisualGuide
    public void init(WeakReference<View> viewRef, d analyticsData, String activatedBy) {
        Intrinsics.checkNotNullParameter(analyticsData, "analyticsData");
        Intrinsics.checkNotNullParameter(activatedBy, "activatedBy");
        super.init(activatedBy, analyticsData);
        this.mAnalyticsData = analyticsData;
        this.anchorView = viewRef != null ? viewRef.get() : null;
        f backDropProperties = getBackDropProperties();
        if (backDropProperties != null) {
            FloatingVisualGuide.extractProperties(backDropProperties, this.backDropPropertiesToBePopulated, SUPPORTED_BACKDROP_PROPERTIES);
        }
        f floatingViewProperties = getFloatingViewProperties();
        if (floatingViewProperties != null) {
            FloatingVisualGuide.extractProperties(floatingViewProperties, this.mViewPropertiesToBePopulated, SUPPORTED_TOOLTIP_PROPERTIES);
        }
    }

    @Override // sdk.pendo.io.actions.FloatingVisualGuide, sdk.pendo.io.actions.VisualGuideBase
    public synchronized void onDestroy() {
        super.onDestroy();
        this.anchorView = null;
        sdk.pendo.io.f9.f x = PendoInternal.x();
        FlutterScreenManager flutterScreenManager = x instanceof FlutterScreenManager ? (FlutterScreenManager) x : null;
        if (flutterScreenManager != null) {
            flutterScreenManager.T();
        }
    }

    public final synchronized void removeOnMainThread() {
        View view = this.anchorView;
        if (view != null) {
            view.post(new Runnable() { // from class: sdk.pendo.io.actions.ToolTipVisualGuide$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ToolTipVisualGuide.removeOnMainThread$lambda$2(ToolTipVisualGuide.this);
                }
            });
        }
    }

    @Override // sdk.pendo.io.actions.FloatingVisualGuide, sdk.pendo.io.actions.VisualGuideBase
    public synchronized boolean show() {
        boolean z = false;
        PendoLogger.d("TooltipVisualGuide - show() starting", new Object[0]);
        final c tooltipManager = getTooltipManager();
        final String c = this.mAnalyticsData.c();
        l viewContentJson = getViewContentJson(GuideActionConfiguration.VisualGuideType.TOOLTIP);
        String currentStepId = this.mStepSeenManager.getCurrentStepId();
        if (this.anchorView == null) {
            return false;
        }
        Activity f = sdk.pendo.io.n8.c.g().f();
        if (f == null) {
            return false;
        }
        StepGuideModel stepGuideModel = getStepGuideModel();
        if (stepGuideModel == null) {
            return false;
        }
        createVisualAnimationManager(stepGuideModel);
        View view = this.anchorView;
        final View a2 = sdk.pendo.io.n.d.a(view != null ? view.getContext() : null, viewContentJson, (ViewGroup) null, GuideViewHolder.class, getGuideId(), currentStepId);
        final boolean touchPassThrough = getTouchPassThrough();
        final String dimenViewStringPropertyClean = getDimenViewStringPropertyClean("frameWidth");
        final String dimenViewStringPropertyClean2 = getDimenViewStringPropertyClean("frameRadius");
        final String strokeColor = getStrokeColor();
        final String dimenViewStringPropertyClean3 = getDimenViewStringPropertyClean("caret_width");
        final String dimenViewStringPropertyClean4 = getDimenViewStringPropertyClean("caret_height");
        final String dimenViewStringPropertyClean5 = getDimenViewStringPropertyClean("layout_marginLeft");
        final String dimenViewStringPropertyClean6 = getDimenViewStringPropertyClean("layout_marginRight");
        final String dimenViewStringPropertyClean7 = getDimenViewStringPropertyClean("layout_marginTop");
        final String dimenViewStringPropertyClean8 = getDimenViewStringPropertyClean("layout_marginBottom");
        if (this.backDropPropertiesToBePopulated.get("hasMobileBackdrop") != null) {
            Object obj = this.backDropPropertiesToBePopulated.get("hasMobileBackdrop");
            if (obj != null && k0.a(obj)) {
                z = true;
            }
        }
        setStartDuration(System.currentTimeMillis());
        final boolean z2 = z;
        f.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.actions.ToolTipVisualGuide$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ToolTipVisualGuide.show$lambda$1(ToolTipVisualGuide.this, c, a2, dimenViewStringPropertyClean, strokeColor, dimenViewStringPropertyClean2, z2, dimenViewStringPropertyClean3, dimenViewStringPropertyClean4, touchPassThrough, dimenViewStringPropertyClean7, dimenViewStringPropertyClean5, dimenViewStringPropertyClean6, dimenViewStringPropertyClean8, tooltipManager);
            }
        });
        return true;
    }
}
