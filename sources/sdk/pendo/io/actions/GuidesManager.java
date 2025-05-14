package sdk.pendo.io.actions;

import android.content.Intent;
import android.os.Looper;
import android.view.TouchDelegate;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.PendoTouchDelegate;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.actions.configurations.GuideCapping;
import sdk.pendo.io.actions.guides.GuideContextSwitchRules;
import sdk.pendo.io.activities.PendoGuideVisualActivity;
import sdk.pendo.io.c8.d;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.f9.f;
import sdk.pendo.io.g8.a;
import sdk.pendo.io.g9.l;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.Completed;
import sdk.pendo.io.models.GeneralGuidesConfiguration;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.GuideStatus;
import sdk.pendo.io.models.Quadruple;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.models.StepModel;
import sdk.pendo.io.models.StepSeen;
import sdk.pendo.io.n8.c;
import sdk.pendo.io.sdk.flutter.FlutterScreenManager;
import sdk.pendo.io.sdk.react.PlatformStateManager;
import sdk.pendo.io.v5.b;
import sdk.pendo.io.x5.j;
import sdk.pendo.io.x5.o;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\be\u0010fJ$\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0002J\u0012\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007J\b\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J@\u0010\u0019\u001a\u00020\b2&\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00150\u00122\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0002J*\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0002J*\u0010$\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\nH\u0002J8\u0010'\u001a\u00020\b2&\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00150\u00122\u0006\u0010&\u001a\u00020%H\u0002J$\u0010)\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0016J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0016J\u0012\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020 H\u0016J\u0010\u0010-\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\u000e\u0010.\u001a\u00020\b2\u0006\u0010+\u001a\u00020 JF\u00100\u001a\u00020 2,\u0010/\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00150\u00120\u00032\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016J\u0010\u00102\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u00010\u0004J\u0006\u00103\u001a\u00020\bJ0\u00105\u001a\u00020\n2&\u00104\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00150\u0012H\u0007JX\u00106\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0018\u00010\u00122,\u0010/\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00150\u00120\u0003H\u0007J6\u00109\u001a\u00020\n2,\u00108\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00150\u001207H\u0007J6\u0010;\u001a\u00020\n2,\u0010:\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00150\u001207H\u0007J\b\u0010<\u001a\u00020\bH\u0016JQ\u0010@\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00142\u0006\u0010\"\u001a\u00020\u00132\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0000¢\u0006\u0004\b>\u0010?J\u0019\u0010C\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0000¢\u0006\u0004\bA\u0010BJQ\u0010E\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00142\u0006\u0010\"\u001a\u00020\u00132\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0000¢\u0006\u0004\bD\u0010?J[\u0010H\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00142\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u0010#\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u00132\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0000¢\u0006\u0004\bF\u0010GJ4\u0010K\u001a\u00020\b2\u0006\u0010J\u001a\u00020I2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0007J,\u0010L\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0007J\u0006\u0010M\u001a\u00020\bJ\u0006\u0010N\u001a\u00020\u0013J\u0006\u0010O\u001a\u00020\bR\u001c\u0010Q\u001a\n P*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR \u0010T\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00040S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010X\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\bX\u0010YR\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010WR\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010WRb\u0010]\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0018\u00010\u00122(\u0010\\\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0018\u00010\u00128\u0002@BX\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u001b\u0010d\u001a\u00020_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c¨\u0006g"}, d2 = {"Lsdk/pendo/io/actions/GuidesManager;", "Lsdk/pendo/io/actions/GuidesManagerInterface;", "Lsdk/pendo/io/g8/a;", "", "Lsdk/pendo/io/models/GuideModel;", "guideModelList", "Lsdk/pendo/io/actions/PendoCommand;", "guideActions", "", "setActiveGuidesAndGuideActions", "", "switchVisitor", "cancelCurrentGuide", "isUnableToShowGuide", GuideActionConfiguration.GUIDE_SCREEN_CONTENT_GUIDE, "interruptGuide", "purgeGuide", "sendError", "Lsdk/pendo/io/models/Quadruple;", "", "Lsdk/pendo/io/actions/ActivationManager$ActivationEvents;", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "guideModelStepIndexEventViewQuad", "guideTriggeredByView", "runGuide", "guideModel", "activatedBy", "targetViewRef", "startVisualTooltip", "Landroid/content/Intent;", "intent", "", "guideActionId", "stepIndex", "isPreviewGuide", "startVisualActivityAndSetAsFullScreen", "Lsdk/pendo/io/models/GuideStatus;", "status", "handleGuideStatusError", "guideActionsList", "storeAndActivateSessionGuides", "getGuideActions", "guideId", "getGuide", "addGuideToGuidesMap", "removeGuideFromSystem", "guideIdStepIndexActivationEventQuadruples", "show", "testGuideModel", "activateNonSessionGuide", "activateSessionGuides", "newGuide", "shouldShowTheGuide", "selectForShow", "", "guides", "handleGuidesWithErrorAndRemoveIt", "guideModelsOrdered", "handleControlGuidesAndRemoveIt", "showPreview", "targetView", "internalRunGuide$pendoIO_release", "(Lsdk/pendo/io/models/GuideModel;ZLsdk/pendo/io/actions/ActivationManager$ActivationEvents;ILjava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V", "internalRunGuide", "shouldWaitForActivityResumeToShowGuide$pendoIO_release", "(Lsdk/pendo/io/actions/ActivationManager$ActivationEvents;)Z", "shouldWaitForActivityResumeToShowGuide", "handleGuideShowing$pendoIO_release", "handleGuideShowing", "startExecutionByGuideType$pendoIO_release", "(Lsdk/pendo/io/models/GuideModel;Lsdk/pendo/io/actions/ActivationManager$ActivationEvents;Ljava/lang/ref/WeakReference;ZLjava/lang/String;ILjava/lang/ref/WeakReference;)V", "startExecutionByGuideType", "Lsdk/pendo/io/actions/FloatingVisualGuide;", "visualGuide", "startShowingFloatingVisualGuide", "startVisualBanner", "clear", "getCountGuidesInMemory", "setCurrentGuideAsNull", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "", "activeGuidesMap", "Ljava/util/Map;", "activeGuideActionList", "Ljava/util/List;", "FIRST_STEP_INDEX", "I", "sessionGuidesList", "sessionGuideActions", "<set-?>", "currentGuide", "Lsdk/pendo/io/models/Quadruple;", "Lsdk/pendo/io/q8/b;", "guidesApiManager$delegate", "Lkotlin/Lazy;", "getGuidesApiManager", "()Lsdk/pendo/io/q8/b;", "guidesApiManager", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class GuidesManager extends a implements GuidesManagerInterface {
    private static final int FIRST_STEP_INDEX = 0;
    public static final GuidesManager INSTANCE;
    private static final String TAG;
    private static List<PendoCommand> activeGuideActionList;
    private static final Map<String, GuideModel> activeGuidesMap;
    private static Quadruple<GuideModel, Integer, ActivationManager.ActivationEvents, WeakReference<View>> currentGuide;

    /* renamed from: guidesApiManager$delegate, reason: from kotlin metadata */
    private static final Lazy guidesApiManager;
    private static List<PendoCommand> sessionGuideActions;
    private static List<? extends GuideModel> sessionGuidesList;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GuideActionConfiguration.VisualGuideType.values().length];
            try {
                iArr[GuideActionConfiguration.VisualGuideType.FULLSCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuideActionConfiguration.VisualGuideType.TOOLTIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GuideActionConfiguration.VisualGuideType.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        final GuidesManager guidesManager = new GuidesManager();
        INSTANCE = guidesManager;
        TAG = "GuidesManager";
        activeGuidesMap = new HashMap();
        activeGuideActionList = new LinkedList();
        sessionGuidesList = new LinkedList();
        sessionGuideActions = new LinkedList();
        LazyThreadSafetyMode a2 = b.f1684a.a();
        final sdk.pendo.io.q5.a aVar = null;
        final byte b = 0 == true ? 1 : 0;
        guidesApiManager = LazyKt.lazy(a2, (Function0) new Function0<sdk.pendo.io.q8.b>() { // from class: sdk.pendo.io.actions.GuidesManager$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, sdk.pendo.io.q8.b] */
            @Override // kotlin.jvm.functions.Function0
            public final sdk.pendo.io.q8.b invoke() {
                sdk.pendo.io.i5.a aVar2 = sdk.pendo.io.i5.a.this;
                return (aVar2 instanceof sdk.pendo.io.i5.b ? ((sdk.pendo.io.i5.b) aVar2).getScope() : aVar2.getKoin().getScopeRegistry().getRootScope()).b(Reflection.getOrCreateKotlinClass(sdk.pendo.io.q8.b.class), aVar, b);
            }
        });
    }

    private GuidesManager() {
    }

    @JvmStatic
    public static final void cancelCurrentGuide(boolean switchVisitor) {
        Quadruple<GuideModel, Integer, ActivationManager.ActivationEvents, WeakReference<View>> quadruple = currentGuide;
        if (quadruple != null) {
            quadruple.getFirst().setCancelled();
            quadruple.getFirst().terminateStatus();
            if (switchVisitor) {
                PendoLogger.d("Dismissing guide " + quadruple.getFirst().getGuideName() + " because switching visitor", new Object[0]);
            }
        }
    }

    public static /* synthetic */ void cancelCurrentGuide$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        cancelCurrentGuide(z);
    }

    private final sdk.pendo.io.q8.b getGuidesApiManager() {
        return (sdk.pendo.io.q8.b) guidesApiManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handleGuideShowing$lambda$22(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleGuideShowing$lambda$23(String str, GuideModel guideModel, ActivationManager.ActivationEvents activationEvents, WeakReference weakReference, boolean z, int i, WeakReference weakReference2, GuideStatus guideStatus) {
        Intrinsics.checkNotNullParameter(guideModel, "$guideModel");
        String e = c.g().e();
        if (e == null || str == null || !Intrinsics.areEqual(e, str)) {
            INSTANCE.setCurrentGuideAsNull();
        } else {
            INSTANCE.startExecutionByGuideType$pendoIO_release(guideModel, activationEvents, weakReference, z, guideModel.getGuideId(), i, weakReference2);
        }
    }

    private final void handleGuideStatusError(Quadruple<GuideModel, Integer, ActivationManager.ActivationEvents, WeakReference<View>> guideModelStepIndexEventViewQuad, GuideStatus status) {
        if (guideModelStepIndexEventViewQuad.getThird() == ActivationManager.ActivationEvents.VIEW) {
            f x = PendoInternal.x();
            Intrinsics.checkNotNullExpressionValue(x, "getScreenManager(...)");
            f.a.a(x, false, 1, null);
        }
        GuideModel first = guideModelStepIndexEventViewQuad.getFirst();
        PendoCommandParameterInjector pendoCommandParameterInjector = PendoCommandParameterInjector.getInstance();
        Intrinsics.checkNotNullExpressionValue(pendoCommandParameterInjector, "getInstance(...)");
        status.sendError(first, pendoCommandParameterInjector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void internalRunGuide$lambda$19(GuideModel guideModel, boolean z, ActivationManager.ActivationEvents activationEvents, int i, WeakReference weakReference, WeakReference weakReference2, sdk.pendo.io.f7.a aVar) {
        Intrinsics.checkNotNullParameter(guideModel, "$guideModel");
        INSTANCE.handleGuideShowing$pendoIO_release(guideModel, z, activationEvents, i, weakReference, weakReference2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean internalRunGuide$lambda$20(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void internalRunGuide$lambda$21(GuideModel guideModel, GuideStatus guideStatus) {
        Intrinsics.checkNotNullParameter(guideModel, "$guideModel");
        PendoCommandParameterInjector pendoCommandParameterInjector = PendoCommandParameterInjector.getInstance();
        Intrinsics.checkNotNullExpressionValue(pendoCommandParameterInjector, "getInstance(...)");
        guideStatus.sendError(guideModel, pendoCommandParameterInjector);
        guideModel.terminateStatus();
        f x = PendoInternal.x();
        Intrinsics.checkNotNullExpressionValue(x, "getScreenManager(...)");
        f.a.a(x, false, 1, null);
    }

    private final void interruptGuide(GuideModel guide) {
        String guideId = guide.getGuideId();
        Intrinsics.checkNotNullExpressionValue(guideId, "getGuideId(...)");
        removeGuideFromSystem(guideId);
        ActivationManager activationManager = ActivationManager.INSTANCE;
        String guideId2 = guide.getGuideId();
        Intrinsics.checkNotNullExpressionValue(guideId2, "getGuideId(...)");
        activationManager.removeGuideIdFromTriggers(guideId2);
        GuideStatus statusValue = guide.getStatusValue();
        PendoCommandParameterInjector pendoCommandParameterInjector = PendoCommandParameterInjector.getInstance();
        Intrinsics.checkNotNullExpressionValue(pendoCommandParameterInjector, "getInstance(...)");
        statusValue.sendError(guide, pendoCommandParameterInjector);
        guide.terminateStatus();
    }

    private final boolean isUnableToShowGuide() {
        if (!sdk.pendo.io.g9.f.a()) {
            PendoLogger.d(TAG + "-> Not showing guide due to connectivity.", new Object[0]);
            return true;
        }
        if (PendoInternal.b()) {
            PendoLogger.d(TAG + "-> Pause guides from showing - api was called.", new Object[0]);
            return true;
        }
        if (!VisualGuidesManager.getInstance().isAnyFullScreenGuideShowing()) {
            return false;
        }
        PendoLogger.d(TAG + "-> Not showing guides because one is already showing.", new Object[0]);
        return true;
    }

    private final void purgeGuide(GuideModel guide) {
        ActivationManager activationManager = ActivationManager.INSTANCE;
        String guideId = guide.getGuideId();
        Intrinsics.checkNotNullExpressionValue(guideId, "getGuideId(...)");
        activationManager.removeGuideIdFromTriggers(guideId);
        StepSeenManager.getInstance().setCurrentStepSeen(null);
        activeGuidesMap.remove(guide.getGuideId());
    }

    private final synchronized void runGuide(final Quadruple<GuideModel, Integer, ActivationManager.ActivationEvents, WeakReference<View>> guideModelStepIndexEventViewQuad, final WeakReference<View> guideTriggeredByView) {
        j<GuideStatus> status = guideModelStepIndexEventViewQuad.getFirst().getStatus();
        final GuidesManager$runGuide$1 guidesManager$runGuide$1 = new Function1<GuideStatus, Boolean>() { // from class: sdk.pendo.io.actions.GuidesManager$runGuide$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(GuideStatus guideStatus) {
                return Boolean.valueOf(guideStatus.getStatus() >= GuideStatus.INSTANCE.getCONTENT_READY());
            }
        };
        status.a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.d6.j
            public final boolean test(Object obj) {
                boolean runGuide$lambda$14;
                runGuide$lambda$14 = GuidesManager.runGuide$lambda$14(Function1.this, obj);
                return runGuide$lambda$14;
            }
        }).f().a(sdk.pendo.io.d9.b.a(new e() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda4
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                GuidesManager.runGuide$lambda$18(Quadruple.this, guideTriggeredByView, (GuideStatus) obj);
            }
        }, "Run guide"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean runGuide$lambda$14(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runGuide$lambda$18(final Quadruple guideModelStepIndexEventViewQuad, final WeakReference weakReference, GuideStatus guideStatus) {
        Intrinsics.checkNotNullParameter(guideModelStepIndexEventViewQuad, "$guideModelStepIndexEventViewQuad");
        if (guideStatus.getHasError()) {
            GuidesManager guidesManager = INSTANCE;
            Intrinsics.checkNotNull(guideStatus);
            guidesManager.handleGuideStatusError(guideModelStepIndexEventViewQuad, guideStatus);
            return;
        }
        final GuideModel guideModel = (GuideModel) guideModelStepIndexEventViewQuad.getFirst();
        final int intValue = ((Number) guideModelStepIndexEventViewQuad.getSecond()).intValue();
        StepGuideModel guideStepModel = guideModel.getGuideStepModel(intValue);
        if (guideStepModel != null) {
            final ActivationManager.ActivationEvents activationEvents = (ActivationManager.ActivationEvents) guideModelStepIndexEventViewQuad.getThird();
            long delayMs = guideStepModel.getConfiguration().getDelayMs();
            PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
            if (platformStateManager.isReactNativeAnalyticsEnabled() && platformStateManager.getRnnClickDelayMs() > 0 && activationEvents == ActivationManager.ActivationEvents.CLICK) {
                List<StepModel> steps = guideModel.getSteps();
                if (GuideActionConfiguration.getStepVisualPendoGuideType(steps != null ? steps.get(intValue) : null) == GuideActionConfiguration.VisualGuideType.FULLSCREEN) {
                    delayMs = RangesKt.coerceAtLeast(delayMs, platformStateManager.getRnnClickDelayMs());
                }
            }
            if (delayMs <= 0) {
                INSTANCE.internalRunGuide$pendoIO_release(guideModel, false, activationEvents, intValue, (WeakReference) guideModelStepIndexEventViewQuad.getFourth(), weakReference);
            } else {
                PendoLogger.d("Pendo got delay.", new Object[0]);
                j.a(sdk.pendo.io.constants.a.f968a).b(delayMs, TimeUnit.MILLISECONDS).a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda12
                    @Override // sdk.pendo.io.d6.j
                    public final boolean test(Object obj) {
                        boolean runGuide$lambda$18$lambda$17$lambda$15;
                        runGuide$lambda$18$lambda$17$lambda$15 = GuidesManager.runGuide$lambda$18$lambda$17$lambda$15(obj);
                        return runGuide$lambda$18$lambda$17$lambda$15;
                    }
                }).a(sdk.pendo.io.a6.a.a()).a((o) sdk.pendo.io.d9.c.a(new e() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda1
                    @Override // sdk.pendo.io.d6.e
                    public final void accept(Object obj) {
                        GuidesManager.runGuide$lambda$18$lambda$17$lambda$16(GuideModel.this, activationEvents, intValue, guideModelStepIndexEventViewQuad, weakReference, obj);
                    }
                }, "GuidesManager delayed run observer"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean runGuide$lambda$18$lambda$17$lambda$15(Object obj) {
        boolean isAnyFullScreenGuideShowing = VisualGuidesManager.getInstance().isAnyFullScreenGuideShowing();
        PendoLogger.d("Is guide showing: " + isAnyFullScreenGuideShowing + ".", new Object[0]);
        return !isAnyFullScreenGuideShowing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runGuide$lambda$18$lambda$17$lambda$16(GuideModel guideModel, ActivationManager.ActivationEvents guideActivatedBy, int i, Quadruple guideModelStepIndexEventViewQuad, WeakReference weakReference, Object obj) {
        Intrinsics.checkNotNullParameter(guideModel, "$guideModel");
        Intrinsics.checkNotNullParameter(guideActivatedBy, "$guideActivatedBy");
        Intrinsics.checkNotNullParameter(guideModelStepIndexEventViewQuad, "$guideModelStepIndexEventViewQuad");
        PendoLogger.d("Running delayed guide.", new Object[0]);
        INSTANCE.internalRunGuide$pendoIO_release(guideModel, false, guideActivatedBy, i, (WeakReference) guideModelStepIndexEventViewQuad.getFourth(), weakReference);
    }

    private final void sendError(GuideModel guide) {
        GuideStatus statusValue = guide.getStatusValue();
        PendoCommandParameterInjector pendoCommandParameterInjector = PendoCommandParameterInjector.getInstance();
        Intrinsics.checkNotNullExpressionValue(pendoCommandParameterInjector, "getInstance(...)");
        statusValue.sendError(guide, pendoCommandParameterInjector);
    }

    private final synchronized void setActiveGuidesAndGuideActions(List<? extends GuideModel> guideModelList, List<PendoCommand> guideActions) {
        PendoLogger.v(TAG + "-> setActiveGuidesAndGuideActions with " + guideModelList.size() + " guides", new Object[0]);
        setCurrentGuideAsNull();
        activeGuidesMap.clear();
        activeGuideActionList = guideActions;
        for (GuideModel guideModel : guideModelList) {
            PendoLogger.v(TAG + "-> guideId: " + guideModel.getGuideId() + ", guideName: " + guideModel.getGuideName(), new Object[0]);
            GuidesManager guidesManager = INSTANCE;
            guidesManager.addGuideToGuidesMap(guideModel);
            if (guideModel.getContentUrl() == null) {
                guideModel.setContentReady();
                guidesManager.getGuidesApiManager().b(guideModel);
            } else {
                guideModel.setContentNotReady();
                guidesManager.getGuidesApiManager().a(guideModel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showPreview$lambda$12(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPreview$lambda$13(Boolean bool) {
        StepSeenManager.getInstance().setCurrentStepSeen(new StepSeen(GuideModel.PREVIEW_GUIDE_ID, GuideModel.PREVIEW_GUIDE_STEP_ID, 0));
        GuidesManager guidesManager = INSTANCE;
        GuideModel e = sdk.pendo.io.y8.a.d().e();
        Intrinsics.checkNotNullExpressionValue(e, "getPreviewGuide(...)");
        guidesManager.internalRunGuide$pendoIO_release(e, true, ActivationManager.ActivationEvents.PREVIEW, 0, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean startExecutionByGuideType$lambda$24(Object obj) {
        boolean isAnyFullScreenGuideShowing = VisualGuidesManager.getInstance().isAnyFullScreenGuideShowing();
        PendoLogger.d("Is guide showing: " + isAnyFullScreenGuideShowing + ".", new Object[0]);
        return !isAnyFullScreenGuideShowing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startExecutionByGuideType$lambda$25(GuideActionConfiguration.VisualGuideType visualGuideType, GuideModel guideModel, ActivationManager.ActivationEvents activationEvents, WeakReference weakReference, WeakReference weakReference2, Object obj) {
        Intrinsics.checkNotNullParameter(visualGuideType, "$visualGuideType");
        Intrinsics.checkNotNullParameter(guideModel, "$guideModel");
        if (visualGuideType == GuideActionConfiguration.VisualGuideType.TOOLTIP) {
            PendoLogger.d("Running delayed tooltip guide.", new Object[0]);
            INSTANCE.startVisualTooltip(guideModel, activationEvents, weakReference);
        } else {
            PendoLogger.d("Running delayed banner guide.", new Object[0]);
            INSTANCE.startVisualBanner(guideModel, activationEvents, weakReference2);
        }
    }

    private final synchronized void startVisualActivityAndSetAsFullScreen(Intent intent, String guideActionId, int stepIndex, boolean isPreviewGuide) {
        if (sdk.pendo.io.g9.c.a(intent, guideActionId, Integer.valueOf(stepIndex), Boolean.valueOf(isPreviewGuide))) {
            VisualGuidesManager.getInstance().setIsFullScreenGuideShowing(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startVisualBanner$default(GuidesManager guidesManager, GuideModel guideModel, ActivationManager.ActivationEvents activationEvents, WeakReference weakReference, int i, Object obj) {
        if ((i & 4) != 0) {
            weakReference = null;
        }
        guidesManager.startVisualBanner(guideModel, activationEvents, weakReference);
    }

    private final synchronized void startVisualTooltip(GuideModel guideModel, ActivationManager.ActivationEvents activatedBy, WeakReference<View> targetViewRef) {
        View view;
        if (targetViewRef != null) {
            try {
                view = targetViewRef.get();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            view = null;
        }
        if (view == null) {
            PendoLogger.e(TAG, "startVisualTooltip targetViewRef is null, cannot display tooltip, guide id - " + guideModel.getGuideId());
        } else {
            if (VisualGuidesManager.getInstance().isAnyFullScreenGuideShowing()) {
                return;
            }
            startShowingFloatingVisualGuide(new ToolTipVisualGuide(guideModel, VisualGuidesManager.getInstance(), StepSeenManager.getInstance()), guideModel, activatedBy, targetViewRef);
        }
    }

    public final synchronized void activateNonSessionGuide(GuideModel testGuideModel) {
        PendoLogger.d(TAG, "activating nonSession Guide");
        LinkedList linkedList = new LinkedList();
        if (testGuideModel != null) {
            linkedList.add(testGuideModel);
        }
        setActiveGuidesAndGuideActions(linkedList, CollectionsKt.emptyList());
        ActivationManager.INSTANCE.restartWithGuides(CollectionsKt.toList(activeGuidesMap.values()));
    }

    public final synchronized void activateSessionGuides() {
        PendoLogger.d(TAG, "activating session Guides");
        setActiveGuidesAndGuideActions(sessionGuidesList, sessionGuideActions);
        ActivationManager.INSTANCE.restartWithGuides(CollectionsKt.toList(activeGuidesMap.values()));
    }

    @Override // sdk.pendo.io.actions.GuidesManagerInterface
    public synchronized void addGuideToGuidesMap(GuideModel guideModel) {
        Intrinsics.checkNotNullParameter(guideModel, "guideModel");
        Map<String, GuideModel> map = activeGuidesMap;
        String guideId = guideModel.getGuideId();
        Intrinsics.checkNotNullExpressionValue(guideId, "getGuideId(...)");
        map.put(guideId, guideModel);
    }

    public final void clear() {
        activeGuidesMap.clear();
        activeGuideActionList = new LinkedList();
        sessionGuideActions = new LinkedList();
        sessionGuidesList = new LinkedList();
    }

    public final int getCountGuidesInMemory() {
        return activeGuidesMap.size();
    }

    @Override // sdk.pendo.io.actions.GuidesManagerInterface
    public synchronized GuideModel getGuide(String guideId) {
        Intrinsics.checkNotNullParameter(guideId, "guideId");
        return activeGuidesMap.get(guideId);
    }

    @Override // sdk.pendo.io.actions.GuidesManagerInterface
    public synchronized List<PendoCommand> getGuideActions() {
        return new LinkedList(activeGuideActionList);
    }

    public final boolean handleControlGuidesAndRemoveIt(List<Quadruple<GuideModel, Integer, ActivationManager.ActivationEvents, WeakReference<View>>> guideModelsOrdered) {
        Intrinsics.checkNotNullParameter(guideModelsOrdered, "guideModelsOrdered");
        if (guideModelsOrdered.isEmpty()) {
            return false;
        }
        Iterator<Quadruple<GuideModel, Integer, ActivationManager.ActivationEvents, WeakReference<View>>> it = guideModelsOrdered.iterator();
        boolean z = false;
        while (it.hasNext()) {
            GuideModel first = it.next().getFirst();
            if (!first.isInControlGroup()) {
                break;
            }
            it.remove();
            if (GuideShowDecider.getInstance().shouldShowGuide(first, 0)) {
                PendoCommandParameterInjector.getInstance().handleControlGroupAnalytics(first);
                first.capOut();
            }
            z = true;
        }
        return z;
    }

    public final void handleGuideShowing$pendoIO_release(final GuideModel guideModel, final boolean isPreviewGuide, final ActivationManager.ActivationEvents activatedBy, final int stepIndex, final WeakReference<View> targetView, final WeakReference<View> guideTriggeredByView) {
        Intrinsics.checkNotNullParameter(guideModel, "guideModel");
        final String e = c.g().e();
        j<GuideStatus> status = guideModel.getStatus();
        final GuidesManager$handleGuideShowing$1 guidesManager$handleGuideShowing$1 = new Function1<GuideStatus, Boolean>() { // from class: sdk.pendo.io.actions.GuidesManager$handleGuideShowing$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(GuideStatus guideStatus) {
                int status2 = guideStatus.getStatus();
                GuideStatus.Companion companion = GuideStatus.INSTANCE;
                return Boolean.valueOf(status2 == companion.getREADY() || guideStatus.getStatus() == companion.getGUIDE_SHOWN());
            }
        };
        status.a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda5
            @Override // sdk.pendo.io.d6.j
            public final boolean test(Object obj) {
                boolean handleGuideShowing$lambda$22;
                handleGuideShowing$lambda$22 = GuidesManager.handleGuideShowing$lambda$22(Function1.this, obj);
                return handleGuideShowing$lambda$22;
            }
        }).f().a(sdk.pendo.io.d9.b.a(new e() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda6
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                GuidesManager.handleGuideShowing$lambda$23(e, guideModel, activatedBy, targetView, isPreviewGuide, stepIndex, guideTriggeredByView, (GuideStatus) obj);
            }
        }, "GuideManager internalRunGuide"));
    }

    public final boolean handleGuidesWithErrorAndRemoveIt(List<Quadruple<GuideModel, Integer, ActivationManager.ActivationEvents, WeakReference<View>>> guides) {
        Intrinsics.checkNotNullParameter(guides, "guides");
        Iterator<Quadruple<GuideModel, Integer, ActivationManager.ActivationEvents, WeakReference<View>>> it = guides.iterator();
        boolean z = false;
        while (it.hasNext()) {
            GuideModel first = it.next().getFirst();
            if (first.getStatusValue() == null || !first.getStatusValue().getHasError()) {
                break;
            }
            first.capOut();
            purgeGuide(first);
            it.remove();
            sendError(first);
            z = true;
        }
        return z;
    }

    public final synchronized void internalRunGuide$pendoIO_release(final GuideModel guideModel, final boolean isPreviewGuide, final ActivationManager.ActivationEvents activatedBy, final int stepIndex, final WeakReference<View> targetView, final WeakReference<View> guideTriggeredByView) {
        Intrinsics.checkNotNullParameter(guideModel, "guideModel");
        if (!isPreviewGuide && activatedBy == ActivationManager.ActivationEvents.CLICK) {
            if (PlatformStateManager.INSTANCE.isReactNativeAnalyticsEnabled()) {
                if (GuideTapOnManager.getsIsTapIndicationRunning()) {
                    return;
                } else {
                    GuideTapOnManager.setsIsTapIndicationRunning(true);
                }
            }
            GuideTapOnManager.runTapOnIndication();
        }
        if (c.g().f() != null) {
            handleGuideShowing$pendoIO_release(guideModel, isPreviewGuide, activatedBy, stepIndex, targetView, guideTriggeredByView);
        } else if (shouldWaitForActivityResumeToShowGuide$pendoIO_release(activatedBy)) {
            c.g().c().f().a(sdk.pendo.io.d9.b.a(new e() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda9
                @Override // sdk.pendo.io.d6.e
                public final void accept(Object obj) {
                    GuidesManager.internalRunGuide$lambda$19(GuideModel.this, isPreviewGuide, activatedBy, stepIndex, targetView, guideTriggeredByView, (sdk.pendo.io.f7.a) obj);
                }
            }, TAG + " observing the next onResume"));
        }
        j<GuideStatus> status = guideModel.getStatus();
        final GuidesManager$internalRunGuide$2 guidesManager$internalRunGuide$2 = new Function1<GuideStatus, Boolean>() { // from class: sdk.pendo.io.actions.GuidesManager$internalRunGuide$2
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(GuideStatus guideStatus) {
                return Boolean.valueOf(guideStatus.getHasError());
            }
        };
        status.a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda10
            @Override // sdk.pendo.io.d6.j
            public final boolean test(Object obj) {
                boolean internalRunGuide$lambda$20;
                internalRunGuide$lambda$20 = GuidesManager.internalRunGuide$lambda$20(Function1.this, obj);
                return internalRunGuide$lambda$20;
            }
        }).f().a(sdk.pendo.io.d9.b.a(new e() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda11
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                GuidesManager.internalRunGuide$lambda$21(GuideModel.this, (GuideStatus) obj);
            }
        }, "GuideManager internalRunGuide"));
    }

    public final synchronized void removeGuideFromSystem(String guideId) {
        Intrinsics.checkNotNullParameter(guideId, "guideId");
        activeGuidesMap.remove(guideId);
    }

    public final Quadruple<GuideModel, Integer, ActivationManager.ActivationEvents, WeakReference<View>> selectForShow(List<Quadruple<String, Integer, ActivationManager.ActivationEvents, WeakReference<View>>> guideIdStepIndexActivationEventQuadruples) {
        GeneralGuidesConfiguration generalGuideConfiguration;
        GuideCapping capping;
        Intrinsics.checkNotNullParameter(guideIdStepIndexActivationEventQuadruples, "guideIdStepIndexActivationEventQuadruples");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(guideIdStepIndexActivationEventQuadruples, 10));
        Iterator<T> it = guideIdStepIndexActivationEventQuadruples.iterator();
        while (it.hasNext()) {
            Quadruple quadruple = (Quadruple) it.next();
            arrayList.add(new Quadruple(INSTANCE.getGuide((String) quadruple.getFirst()), quadruple.getSecond(), quadruple.getThird(), quadruple.getFourth()));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (true) {
            boolean z = false;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            GuideModel guideModel = (GuideModel) ((Quadruple) next).getFirst();
            if (guideModel != null && (generalGuideConfiguration = guideModel.getGeneralGuideConfiguration()) != null && (capping = generalGuideConfiguration.getCapping()) != null) {
                z = capping.canConsumeOne();
            }
            if (z) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = arrayList2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next2 = it3.next();
            GuideModel guideModel2 = (GuideModel) ((Quadruple) next2).getFirst();
            if (true ^ ((guideModel2 != null ? guideModel2.getStatusValue() : null) instanceof Completed)) {
                arrayList3.add(next2);
            }
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList3);
        Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type kotlin.collections.MutableList<sdk.pendo.io.models.Quadruple<sdk.pendo.io.models.GuideModel, kotlin.Int, sdk.pendo.io.actions.ActivationManager.ActivationEvents, java.lang.ref.WeakReference<android.view.View>?>>");
        List<Quadruple<GuideModel, Integer, ActivationManager.ActivationEvents, WeakReference<View>>> asMutableList = TypeIntrinsics.asMutableList(mutableList);
        if (asMutableList.isEmpty()) {
            PendoLogger.i(TAG + "->selectForShow there is no guide with capping remain", new Object[0]);
            return null;
        }
        if (asMutableList.size() > 1) {
            CollectionsKt.sortWith(asMutableList, new Comparator() { // from class: sdk.pendo.io.actions.GuidesManager$selectForShow$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((GuideModel) ((Quadruple) t).getFirst()).getPriority()), Integer.valueOf(((GuideModel) ((Quadruple) t2).getFirst()).getPriority()));
                }
            });
        }
        boolean handleGuidesWithErrorAndRemoveIt = handleGuidesWithErrorAndRemoveIt(asMutableList);
        boolean handleControlGuidesAndRemoveIt = handleControlGuidesAndRemoveIt(asMutableList);
        boolean z2 = handleControlGuidesAndRemoveIt;
        while (true) {
            if (!handleGuidesWithErrorAndRemoveIt && !handleControlGuidesAndRemoveIt) {
                break;
            }
            handleGuidesWithErrorAndRemoveIt = handleGuidesWithErrorAndRemoveIt(asMutableList);
            handleControlGuidesAndRemoveIt = handleControlGuidesAndRemoveIt(asMutableList);
            z2 = handleControlGuidesAndRemoveIt || z2;
        }
        String activationEvent = guideIdStepIndexActivationEventQuadruples.get(0).getThird().getActivationEvent();
        if ((asMutableList.isEmpty() && z2 && Intrinsics.areEqual(activationEvent, ActivationManager.ActivationEvents.CLICK.getActivationEvent())) || asMutableList.isEmpty()) {
            return null;
        }
        return (Quadruple) CollectionsKt.first((List) asMutableList);
    }

    public final void setCurrentGuideAsNull() {
        currentGuide = null;
    }

    public final boolean shouldShowTheGuide(Quadruple<GuideModel, Integer, ActivationManager.ActivationEvents, WeakReference<View>> newGuide) {
        Intrinsics.checkNotNullParameter(newGuide, "newGuide");
        Quadruple<GuideModel, Integer, ActivationManager.ActivationEvents, WeakReference<View>> quadruple = currentGuide;
        if (quadruple != null) {
            if (Intrinsics.areEqual(quadruple.getFirst().getGuideId(), newGuide.getFirst().getGuideId()) && quadruple.getSecond().intValue() == newGuide.getSecond().intValue()) {
                return false;
            }
            if (!Intrinsics.areEqual(quadruple.getFirst().getGuideId(), newGuide.getFirst().getGuideId()) && !GuideContextSwitchRules.INSTANCE.shouldInterruptCurrentGuide(quadruple.getThird(), newGuide.getThird())) {
                return false;
            }
        }
        return GuideShowDecider.getInstance().shouldShowGuide(newGuide.getFirst(), newGuide.getSecond().intValue());
    }

    public final boolean shouldWaitForActivityResumeToShowGuide$pendoIO_release(ActivationManager.ActivationEvents activatedBy) {
        return activatedBy == ActivationManager.ActivationEvents.TRACK_EVENT || activatedBy == ActivationManager.ActivationEvents.APP_LAUNCH;
    }

    @Override // sdk.pendo.io.actions.GuidesManagerInterface
    public synchronized String show(List<Quadruple<String, Integer, ActivationManager.ActivationEvents, WeakReference<View>>> guideIdStepIndexActivationEventQuadruples, WeakReference<View> guideTriggeredByView) {
        View view;
        Quadruple<GuideModel, Integer, ActivationManager.ActivationEvents, WeakReference<View>> selectForShow;
        Intrinsics.checkNotNullParameter(guideIdStepIndexActivationEventQuadruples, "guideIdStepIndexActivationEventQuadruples");
        try {
        } catch (Exception e) {
            String str = "";
            Iterator<T> it = guideIdStepIndexActivationEventQuadruples.iterator();
            while (it.hasNext()) {
                Quadruple quadruple = (Quadruple) it.next();
                Object first = quadruple.getFirst();
                Object second = quadruple.getSecond();
                Object third = quadruple.getThird();
                WeakReference weakReference = (WeakReference) quadruple.getFourth();
                str = str + "guideId: " + first + " stepIndex: " + second + " event: " + third + " view: " + ((weakReference == null || (view = (View) weakReference.get()) == null) ? null : Integer.valueOf(view.hashCode())) + "\n";
            }
            PendoLogger.e(e, "Guides manager show fed problematic content", str);
        }
        if (isUnableToShowGuide()) {
            return "";
        }
        Quadruple<GuideModel, Integer, ActivationManager.ActivationEvents, WeakReference<View>> quadruple2 = currentGuide;
        if (quadruple2 != null && quadruple2.getFirst().isCompleted()) {
            INSTANCE.setCurrentGuideAsNull();
        }
        if (StepSeenManager.getInstance().getCurrentStepSeen() != null) {
            Quadruple<String, Integer, ActivationManager.ActivationEvents, WeakReference<View>> quadruple3 = guideIdStepIndexActivationEventQuadruples.get(0);
            GuideModel guide = getGuide(quadruple3.getFirst());
            Intrinsics.checkNotNull(guide);
            selectForShow = new Quadruple<>(guide, quadruple3.getSecond(), quadruple3.getThird(), quadruple3.getFourth());
        } else {
            selectForShow = selectForShow(guideIdStepIndexActivationEventQuadruples);
        }
        if (selectForShow != null) {
            GuidesManager guidesManager = INSTANCE;
            if (!guidesManager.shouldShowTheGuide(selectForShow)) {
                return "";
            }
            Quadruple<GuideModel, Integer, ActivationManager.ActivationEvents, WeakReference<View>> quadruple4 = currentGuide;
            if (quadruple4 != null && !Intrinsics.areEqual(quadruple4.getFirst().getGuideId(), selectForShow.getFirst().getGuideId())) {
                guidesManager.interruptGuide(quadruple4.getFirst());
            }
            if (selectForShow.getThird() == ActivationManager.ActivationEvents.TRACK_EVENT) {
                ActivationManager activationManager = ActivationManager.INSTANCE;
                if (!activationManager.getTrackEventsBeforeSessionStart().isEmpty()) {
                    currentGuide = new Quadruple<>(selectForShow.getFirst(), selectForShow.getSecond(), ActivationManager.ActivationEvents.ANY, selectForShow.getFourth());
                    activationManager.getTrackEventsBeforeSessionStart().clear();
                    guidesManager.runGuide(selectForShow, guideTriggeredByView);
                    String guideId = selectForShow.getFirst().getGuideId();
                    Intrinsics.checkNotNullExpressionValue(guideId, "getGuideId(...)");
                    return guideId;
                }
            }
            currentGuide = selectForShow;
            guidesManager.runGuide(selectForShow, guideTriggeredByView);
            String guideId2 = selectForShow.getFirst().getGuideId();
            Intrinsics.checkNotNullExpressionValue(guideId2, "getGuideId(...)");
            return guideId2;
        }
        return "";
    }

    @Override // sdk.pendo.io.actions.GuidesManagerInterface
    public synchronized void showPreview() {
        GuidesActionsManager.getInstance().dismissVisibleGuides();
        j<Boolean> isFullScreenGuideShowingObservable = VisualGuidesManager.getInstance().getIsFullScreenGuideShowingObservable();
        final GuidesManager$showPreview$1 guidesManager$showPreview$1 = new Function1<Boolean, Boolean>() { // from class: sdk.pendo.io.actions.GuidesManager$showPreview$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Boolean bool) {
                return Boolean.valueOf(!bool.booleanValue());
            }
        };
        isFullScreenGuideShowingObservable.a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda2
            @Override // sdk.pendo.io.d6.j
            public final boolean test(Object obj) {
                boolean showPreview$lambda$12;
                showPreview$lambda$12 = GuidesManager.showPreview$lambda$12(Function1.this, obj);
                return showPreview$lambda$12;
            }
        }).f().a(sdk.pendo.io.d9.b.a(new e() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda3
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                GuidesManager.showPreview$lambda$13((Boolean) obj);
            }
        }, "GuidesManager full screen guide showing observer"));
    }

    public final void startExecutionByGuideType$pendoIO_release(final GuideModel guideModel, final ActivationManager.ActivationEvents activatedBy, final WeakReference<View> targetView, boolean isPreviewGuide, String guideId, int stepIndex, final WeakReference<View> guideTriggeredByView) {
        Intrinsics.checkNotNullParameter(guideModel, "guideModel");
        if (StepSeenManager.getInstance().getCurrentStepSeen() == null) {
            String guideStepId = guideModel.getGuideStepId(stepIndex);
            if (!Intrinsics.areEqual(guideStepId, "")) {
                StepSeenManager.getInstance().setCurrentStepSeen(new StepSeen(guideId, guideStepId, Integer.valueOf(stepIndex)));
            }
        }
        List<StepModel> steps = guideModel.getSteps();
        final GuideActionConfiguration.VisualGuideType stepVisualPendoGuideType = GuideActionConfiguration.getStepVisualPendoGuideType(steps != null ? steps.get(stepIndex) : null);
        Intrinsics.checkNotNullExpressionValue(stepVisualPendoGuideType, "getStepVisualPendoGuideType(...)");
        int i = WhenMappings.$EnumSwitchMapping$0[stepVisualPendoGuideType.ordinal()];
        if (i == 1) {
            Intent a2 = PendoGuideVisualActivity.a(guideId, activatedBy, isPreviewGuide);
            Intrinsics.checkNotNullExpressionValue(a2, "getVisualActivityIntent(...)");
            startVisualActivityAndSetAsFullScreen(a2, guideId, stepIndex, isPreviewGuide);
        } else if (i == 2 || i == 3) {
            j.a(sdk.pendo.io.constants.a.f968a).b(sdk.pendo.io.v6.a.a()).a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda7
                @Override // sdk.pendo.io.d6.j
                public final boolean test(Object obj) {
                    boolean startExecutionByGuideType$lambda$24;
                    startExecutionByGuideType$lambda$24 = GuidesManager.startExecutionByGuideType$lambda$24(obj);
                    return startExecutionByGuideType$lambda$24;
                }
            }).a(sdk.pendo.io.a6.a.a()).a((o) sdk.pendo.io.d9.c.a(new e() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda8
                @Override // sdk.pendo.io.d6.e
                public final void accept(Object obj) {
                    GuidesManager.startExecutionByGuideType$lambda$25(GuideActionConfiguration.VisualGuideType.this, guideModel, activatedBy, targetView, guideTriggeredByView, obj);
                }
            }, "GuidesManager main thread posting observer"));
        }
    }

    public final synchronized void startShowingFloatingVisualGuide(FloatingVisualGuide visualGuide, GuideModel guideModel, ActivationManager.ActivationEvents activatedBy, WeakReference<View> targetViewRef) {
        Intrinsics.checkNotNullParameter(visualGuide, "visualGuide");
        d a2 = sdk.pendo.io.c8.f.e().a(guideModel);
        VisualGuidesManager.getInstance().setIsFullScreenGuideShowing(true);
        f x = PendoInternal.x();
        FlutterScreenManager flutterScreenManager = x instanceof FlutterScreenManager ? (FlutterScreenManager) x : null;
        if (flutterScreenManager != null) {
            flutterScreenManager.c(targetViewRef != null ? targetViewRef.get() : null);
        }
        if (!l.a(targetViewRef, visualGuide, a2, activatedBy != null ? activatedBy.getActivationEvent() : null) && guideModel != null) {
            guideModel.setContentError();
        }
    }

    public final synchronized void startVisualBanner(GuideModel guideModel, ActivationManager.ActivationEvents activatedBy, WeakReference<View> guideTriggeredByView) {
        View view;
        Intrinsics.checkNotNullParameter(guideModel, "guideModel");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            TouchDelegate touchDelegate = (guideTriggeredByView == null || (view = guideTriggeredByView.get()) == null) ? null : view.getTouchDelegate();
            PendoTouchDelegate pendoTouchDelegate = touchDelegate instanceof PendoTouchDelegate ? (PendoTouchDelegate) touchDelegate : null;
            if (pendoTouchDelegate != null) {
                pendoTouchDelegate.a();
            }
        } else {
            PendoLogger.w(TAG, "startVisualBanner, cannot perform the original touch delegate, not on main thread.");
        }
        if (VisualGuidesManager.getInstance().isAnyFullScreenGuideShowing()) {
            return;
        }
        startShowingFloatingVisualGuide(new BannerVisualGuide(guideModel, VisualGuidesManager.getInstance(), StepSeenManager.getInstance()), guideModel, activatedBy, null);
    }

    @Override // sdk.pendo.io.actions.GuidesManagerInterface
    public synchronized void storeAndActivateSessionGuides(List<? extends GuideModel> guideModelList, List<PendoCommand> guideActionsList) {
        Intrinsics.checkNotNullParameter(guideModelList, "guideModelList");
        Intrinsics.checkNotNullParameter(guideActionsList, "guideActionsList");
        sessionGuidesList = guideModelList;
        sessionGuideActions = guideActionsList;
        setActiveGuidesAndGuideActions(guideModelList, guideActionsList);
    }
}
