package sdk.pendo.io.actions;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.reactcommunity.rndatetimepicker.Common;
import expo.modules.updates.codesigning.CodeSigningAlgorithmKt;
import io.sentry.Session;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.actions.PendoBannerGuideManager;
import sdk.pendo.io.actions.PendoFloatingVisualGuideManager;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.k0.f;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.models.StepModel;
import sdk.pendo.io.n.d;
import sdk.pendo.io.n8.c;
import sdk.pendo.io.views.GuideViewHolder;
import sdk.pendo.io.views.custom.PendoLinearLayout;
import sdk.pendo.io.views.custom.PendoScrollView;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B%\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J(\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0006\u0010\u0012\u001a\u00020\u000eJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0013H\u0007R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lsdk/pendo/io/actions/BannerVisualGuide;", "Lsdk/pendo/io/actions/FloatingVisualGuide;", "", "idHash", "Landroid/view/View;", "viewFromJson", CodeSigningAlgorithmKt.CODE_SIGNING_METADATA_DEFAULT_KEY_ID, "Lsdk/pendo/io/actions/PendoBannerGuideManager$Builder;", "createBuilder", "Ljava/lang/ref/WeakReference;", "viewRef", "Lsdk/pendo/io/c8/d;", "analyticsData", "activatedBy", "", Session.JsonKeys.INIT, "", "show", "updateStepDuration", "Landroid/view/ViewGroup;", "createViewFromJson", "Lsdk/pendo/io/k0/f;", "getBannerProperties", "()Lsdk/pendo/io/k0/f;", "bannerProperties", "Lsdk/pendo/io/actions/PendoBannerGuideManager;", "getBannerManager", "()Lsdk/pendo/io/actions/PendoBannerGuideManager;", "bannerManager", "Lsdk/pendo/io/models/GuideModel;", "guideModel", "Lsdk/pendo/io/actions/VisualGuideLifecycleListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lsdk/pendo/io/actions/StepSeenManagerInterface;", "stepSeenManager", "<init>", "(Lsdk/pendo/io/models/GuideModel;Lsdk/pendo/io/actions/VisualGuideLifecycleListener;Lsdk/pendo/io/actions/StepSeenManagerInterface;)V", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class BannerVisualGuide extends FloatingVisualGuide {
    private static final String GRAVITY_FOR_BANNER = "gravity";
    private static final HashSet<String> SUPPORTED_BANNER_LAYOUT_PROPERTIES = new HashSet<>(CollectionsKt.listOf((Object[]) new String[]{ViewProps.POSITION, AppStateModule.APP_STATE_BACKGROUND, ViewProps.FONT_FAMILY, Common.TEXT_COLOR, "text", "textStyle", "textSize", "textDirection", ViewProps.PADDING, GRAVITY_FOR_BANNER, "frameColor", "frameWidth", "frameRadius", "layout_marginLeft", "layout_marginRight", "layout_marginTop", "layout_marginBottom", ViewProps.MAX_WIDTH, "backgroundImageUrl", "backgroundImageFillType", "accessibilityText", "ariaLabel"}));
    private static final HashSet<String> SUPPORTED_BANNER_PROPERTIES = new HashSet<>(CollectionsKt.listOf(GRAVITY_FOR_BANNER));

    public BannerVisualGuide(GuideModel guideModel, VisualGuideLifecycleListener visualGuideLifecycleListener, StepSeenManagerInterface stepSeenManagerInterface) {
        super(VisualGuideBase.VisualGuideType.BANNER, guideModel, visualGuideLifecycleListener, stepSeenManagerInterface);
    }

    private final PendoBannerGuideManager.Builder createBuilder(final String idHash, View viewFromJson, View root) {
        PendoFloatingVisualGuideManager.Builder withCustomView = new PendoBannerGuideManager.Builder(idHash).anchor(root, getGravity()).closePolicy(0L).background(getBackground()).toggleArrow(true).withCustomView(viewFromJson);
        String guideId = getGuideId();
        Intrinsics.checkNotNullExpressionValue(guideId, "getGuideId(...)");
        PendoFloatingVisualGuideManager.Builder withCallback = withCustomView.guideId(guideId).withCallback(new PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks() { // from class: sdk.pendo.io.actions.BannerVisualGuide$createBuilder$1
            @Override // sdk.pendo.io.actions.PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks
            public void onClosing(boolean fromUser, long displayDuration, boolean wasShown) {
                if (wasShown) {
                    if (fromUser) {
                        PendoCommandParameterInjector.getInstance().handlePendoUserActionAnalytics(BannerVisualGuide.this.mAnalyticsData.c(), displayDuration);
                    } else {
                        PendoCommandParameterInjector.getInstance().handleGuideTimeoutAnalytics(BannerVisualGuide.this.mAnalyticsData.c(), displayDuration);
                    }
                }
            }

            @Override // sdk.pendo.io.actions.PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks
            public void onDetach() {
                PendoBannerGuideManager companion = PendoBannerGuideManager.INSTANCE.getInstance();
                if (companion != null) {
                    companion.removeFromMap(idHash);
                }
                BannerVisualGuide.this.onDestroy();
            }

            @Override // sdk.pendo.io.actions.PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks
            public void onReadyForShow(ViewGroup guide) {
                Window window;
                BannerVisualGuide.this.mActivity = new WeakReference<>(c.g().f());
                if (guide != null) {
                    BannerVisualGuide.this.setContainerView(guide);
                }
                BannerVisualGuide bannerVisualGuide = BannerVisualGuide.this;
                Activity activity = bannerVisualGuide.mActivity.get();
                View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
                bannerVisualGuide.setRootView(decorView instanceof ViewGroup ? (ViewGroup) decorView : null);
                BannerVisualGuide bannerVisualGuide2 = BannerVisualGuide.this;
                VisualAnimationManager visualAnimationManager = bannerVisualGuide2.mVisualAnimationManager;
                WeakReference<Activity> weakReference = bannerVisualGuide2.mActivity;
                visualAnimationManager.performShow(weakReference != null ? weakReference.get() : null, null);
            }

            @Override // sdk.pendo.io.actions.PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks
            public void onTouchOutside(String id) {
            }
        });
        Intrinsics.checkNotNull(withCallback, "null cannot be cast to non-null type sdk.pendo.io.actions.PendoBannerGuideManager.Builder");
        return (PendoBannerGuideManager.Builder) withCallback;
    }

    private final synchronized PendoBannerGuideManager getBannerManager() {
        PendoFloatingVisualGuideManager.Companion companion = PendoFloatingVisualGuideManager.INSTANCE;
        Activity f = c.g().f();
        Intrinsics.checkNotNullExpressionValue(f, "getCurrentVisibleActivity(...)");
        companion.resetContext(f);
        return PendoBannerGuideManager.INSTANCE.getInstance();
    }

    private final f getBannerProperties() {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void show$lambda$0(sdk.pendo.io.actions.BannerVisualGuide r8, java.lang.String r9, android.view.View r10, android.view.ViewGroup r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, boolean r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, sdk.pendo.io.actions.PendoBannerGuideManager r24) {
        /*
            r0 = r8
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r24
            java.lang.String r6 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r6)
            java.lang.String r6 = "$root"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            sdk.pendo.io.actions.PendoBannerGuideManager$Builder r6 = r8.createBuilder(r9, r10, r11)
            if (r2 == 0) goto L23
            if (r3 == 0) goto L23
            sdk.pendo.io.actions.PendoFloatingVisualGuideManager$Builder r3 = r6.strokeColor(r13)
            r3.strokeWidth(r12)
        L23:
            if (r4 == 0) goto L28
            r6.frameRadius(r14)
        L28:
            r2 = r15
            r6.withTouchPassThrough(r15)
            r2 = r16
            r3 = r17
            r4 = r18
            r7 = r19
            r6.withMargins(r2, r3, r4, r7)
            r2 = r20
            r3 = r21
            r4 = r22
            r6.backgroundImageProperties(r2, r3, r4)
            r2 = r23
            r6.setPaneTitle(r2)
            sdk.pendo.io.actions.StepSeenManagerInterface r2 = sdk.pendo.io.actions.StepSeenManager.getInstance()
            r3 = 1
            r2.setIsBannerGuideStep(r3)
            r2 = 0
            boolean r4 = sdk.pendo.io.g9.q0.a(r11, r2)
            if (r4 == 0) goto L92
            android.view.accessibility.AccessibilityNodeInfo r4 = android.view.accessibility.AccessibilityNodeInfo.obtain()
            r11.onInitializeAccessibilityNodeInfo(r4)
            if (r4 == 0) goto L92
            boolean r1 = r4.isVisibleToUser()
            if (r1 == 0) goto L92
            sdk.pendo.io.f9.f r1 = sdk.pendo.io.PendoInternal.x()
            java.lang.ref.WeakReference r1 = r1.e()
            if (r1 == 0) goto L7e
            java.lang.Object r1 = r1.get()
            sdk.pendo.io.listeners.views.PendoDrawerListener r1 = (sdk.pendo.io.listeners.views.PendoDrawerListener) r1
            if (r1 == 0) goto L7e
            int r1 = r1.getDrawerState()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L7f
        L7e:
            r1 = 0
        L7f:
            if (r1 == 0) goto L87
            int r1 = r1.intValue()
            if (r1 != 0) goto L92
        L87:
            if (r5 == 0) goto L92
            sdk.pendo.io.actions.PendoBannerGuideManager$Builder r1 = r6.build()
            boolean r1 = r5.show(r1)
            goto L93
        L92:
            r1 = r2
        L93:
            if (r1 == 0) goto L99
            r8.getAndSetShowing(r3)
            goto Lb0
        L99:
            sdk.pendo.io.c8.h r1 = r8.getTracker()
            if (r1 == 0) goto La6
            sdk.pendo.io.c8.d$b r3 = sdk.pendo.io.c8.d.b.ERROR_REASON_UNKNOWN
            org.json.JSONObject r4 = r0.mAdditionalInfo
            sdk.pendo.io.g9.d.a(r1, r3, r4)
        La6:
            r8.onDestroy()
            sdk.pendo.io.actions.VisualGuidesManagerInterface r0 = sdk.pendo.io.actions.VisualGuidesManager.getInstance()
            r0.setIsFullScreenGuideShowing(r2)
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.actions.BannerVisualGuide.show$lambda$0(sdk.pendo.io.actions.BannerVisualGuide, java.lang.String, android.view.View, android.view.ViewGroup, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, sdk.pendo.io.actions.PendoBannerGuideManager):void");
    }

    public final View createViewFromJson(ViewGroup root) {
        Intrinsics.checkNotNullParameter(root, "root");
        View a2 = d.a(root.getContext(), getViewContentJson(GuideActionConfiguration.VisualGuideType.BANNER), (ViewGroup) null, GuideViewHolder.class, getGuideId(), this.mStepSeenManager.getCurrentStepId());
        if (a2 instanceof PendoScrollView) {
            View childAt = ((PendoScrollView) a2).getChildAt(0);
            ViewGroup.LayoutParams layoutParams = childAt != null ? childAt.getLayoutParams() : null;
            if (layoutParams != null) {
                layoutParams.height = -1;
            }
            ViewGroup.LayoutParams layoutParams2 = childAt != null ? childAt.getLayoutParams() : null;
            if (layoutParams2 != null) {
                layoutParams2.width = -1;
            }
        }
        String dimenViewStringPropertyClean = getDimenViewStringPropertyClean(ViewProps.MAX_WIDTH);
        if (a2 != null && dimenViewStringPropertyClean != null) {
            if (a2 instanceof PendoLinearLayout) {
                ((PendoLinearLayout) a2).setLayoutMaxWidth(q0.a(Integer.parseInt(dimenViewStringPropertyClean)));
            } else {
                ((PendoScrollView) a2).setLayoutMaxWidth(q0.a(Integer.parseInt(dimenViewStringPropertyClean)));
            }
        }
        return a2;
    }

    @Override // sdk.pendo.io.actions.FloatingVisualGuide
    public void init(WeakReference<View> viewRef, sdk.pendo.io.c8.d analyticsData, String activatedBy) {
        Intrinsics.checkNotNullParameter(analyticsData, "analyticsData");
        Intrinsics.checkNotNullParameter(activatedBy, "activatedBy");
        super.init(activatedBy, analyticsData);
        this.mAnalyticsData = analyticsData;
        f floatingViewProperties = getFloatingViewProperties();
        if (floatingViewProperties != null) {
            FloatingVisualGuide.extractProperties(floatingViewProperties, this.mViewPropertiesToBePopulated, SUPPORTED_BANNER_LAYOUT_PROPERTIES);
        }
        f bannerProperties = getBannerProperties();
        if (bannerProperties != null) {
            FloatingVisualGuide.extractProperties(bannerProperties, this.mViewPropertiesToBePopulated, SUPPORTED_BANNER_PROPERTIES);
        }
    }

    @Override // sdk.pendo.io.actions.FloatingVisualGuide, sdk.pendo.io.actions.VisualGuideBase
    public synchronized boolean show() {
        PendoLogger.d("BannerVisualGuide - show() starting", new Object[0]);
        final PendoBannerGuideManager bannerManager = getBannerManager();
        final String c = this.mAnalyticsData.c();
        Activity f = c.g().f();
        if (f == null) {
            return false;
        }
        StepGuideModel stepGuideModel = getStepGuideModel();
        if (stepGuideModel == null) {
            return false;
        }
        createVisualAnimationManager(stepGuideModel);
        View decorView = f.getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        final ViewGroup viewGroup = (ViewGroup) decorView;
        final View createViewFromJson = createViewFromJson(viewGroup);
        final String dimenViewStringPropertyClean = getDimenViewStringPropertyClean("frameWidth");
        final String dimenViewStringPropertyClean2 = getDimenViewStringPropertyClean("frameRadius");
        final String strokeColor = getStrokeColor();
        final String dimenViewStringPropertyClean3 = getDimenViewStringPropertyClean("layout_marginLeft");
        final String dimenViewStringPropertyClean4 = getDimenViewStringPropertyClean("layout_marginRight");
        final String dimenViewStringPropertyClean5 = getDimenViewStringPropertyClean("layout_marginTop");
        final String dimenViewStringPropertyClean6 = getDimenViewStringPropertyClean("layout_marginBottom");
        final String propertyValuefromViewProperties = getPropertyValuefromViewProperties("backgroundImageUrl");
        final String propertyValuefromViewProperties2 = getPropertyValuefromViewProperties("backgroundImageFillType");
        final String propertyValuefromViewProperties3 = getPropertyValuefromViewProperties("accessibilityText");
        final String propertyValuefromViewProperties4 = getPropertyValuefromViewProperties("ariaLabel");
        updateStepDuration();
        final boolean z = true;
        f.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.actions.BannerVisualGuide$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BannerVisualGuide.show$lambda$0(BannerVisualGuide.this, c, createViewFromJson, viewGroup, dimenViewStringPropertyClean, strokeColor, dimenViewStringPropertyClean2, z, dimenViewStringPropertyClean5, dimenViewStringPropertyClean3, dimenViewStringPropertyClean4, dimenViewStringPropertyClean6, propertyValuefromViewProperties, propertyValuefromViewProperties2, propertyValuefromViewProperties3, propertyValuefromViewProperties4, bannerManager);
            }
        });
        return true;
    }

    public final synchronized void updateStepDuration() {
        long j;
        HashMap<String, Long> bannerStepDuration;
        HashMap<String, Long> bannerStepDuration2;
        HashMap<String, Long> bannerStepDuration3;
        String currentStepId = this.mStepSeenManager.getCurrentStepId();
        PendoBannerGuideManager.Companion companion = PendoBannerGuideManager.INSTANCE;
        PendoBannerGuideManager companion2 = companion.getInstance();
        Long l = (companion2 == null || (bannerStepDuration3 = companion2.getBannerStepDuration()) == null) ? null : bannerStepDuration3.get(currentStepId);
        if (l == null || !this.mStepSeenManager.isBannerGuideStep()) {
            PendoLogger.d(VisualGuideBase.TAG, "updateStepDuration - new banner step is displayed");
            PendoBannerGuideManager companion3 = companion.getInstance();
            if (companion3 != null && (bannerStepDuration2 = companion3.getBannerStepDuration()) != null) {
                bannerStepDuration2.clear();
            }
            long currentTimeMillis = System.currentTimeMillis();
            PendoBannerGuideManager companion4 = companion.getInstance();
            if (companion4 != null && (bannerStepDuration = companion4.getBannerStepDuration()) != null) {
                bannerStepDuration.put(currentStepId, Long.valueOf(currentTimeMillis));
            }
            j = currentTimeMillis;
        } else {
            PendoLogger.d(VisualGuideBase.TAG, "updateStepDuration - same banner step is displayed");
            j = l.longValue();
        }
        setStartDuration(j);
    }
}
