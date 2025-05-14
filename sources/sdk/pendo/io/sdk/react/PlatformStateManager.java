package sdk.pendo.io.sdk.react;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.f7.a;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.n8.c;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LJ\u000e\u0010M\u001a\u00020J2\u0006\u0010N\u001a\u00020OJ\u001a\u0010P\u001a\u0004\u0018\u00010O2\u0006\u0010N\u001a\u00020O2\u0006\u0010Q\u001a\u00020\u0004H\u0002J\u0006\u0010R\u001a\u00020\u0004J\b\u0010S\u001a\u0004\u0018\u00010\u0004J\u001e\u0010T\u001a\u0012\u0012\u0004\u0012\u00020O0=j\b\u0012\u0004\u0012\u00020O`>2\u0006\u0010U\u001a\u00020OJ \u0010V\u001a\u0012\u0012\u0004\u0012\u00020\u000b0=j\b\u0012\u0004\u0012\u00020\u000b`>2\u0006\u0010N\u001a\u00020OH\u0002J\u0006\u0010W\u001a\u00020\u0012J\u0006\u0010X\u001a\u00020\u0012J\u0006\u0010Y\u001a\u00020\u0012J\u0006\u0010Z\u001a\u00020\u0012J\u0006\u0010[\u001a\u00020\u0012JF\u0010\\\u001a\u00020J2\b\u0010]\u001a\u0004\u0018\u00010\u00042\u000e\u0010^\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010_2\u0014\u0010`\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010$2\u000e\u0010a\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010_J8\u0010b\u001a\u00020J2\u0016\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u000b0=j\b\u0012\u0004\u0012\u00020\u000b`>2\u0016\u0010c\u001a\u0012\u0012\u0004\u0012\u00020O0=j\b\u0012\u0004\u0012\u00020O`>H\u0002JX\u0010d\u001a\u00020J2\u0006\u0010N\u001a\u00020O2\u0016\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u000b0=j\b\u0012\u0004\u0012\u00020\u000b`>2\u0016\u0010c\u001a\u0012\u0012\u0004\u0012\u00020O0=j\b\u0012\u0004\u0012\u00020O`>2\u0016\u0010e\u001a\u0012\u0012\u0004\u0012\u00020\u000b0=j\b\u0012\u0004\u0012\u00020\u000b`>H\u0002J\u001c\u0010f\u001a\u00020J2\u0014\u0010g\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010$J$\u0010f\u001a\u00020J2\u0014\u0010g\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010$2\u0006\u0010h\u001a\u00020\u0012J\u0006\u0010G\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00040\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001c8G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00048G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R&\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0014R\u001a\u0010*\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u001e\u0010,\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0014R*\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R&\u00107\u001a\u0002062\u0006\u0010\u0017\u001a\u0002068G@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R*\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u000b0=j\b\u0012\u0004\u0012\u00020\u000b`>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010C\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\"\"\u0004\bE\u0010FR\u001e\u0010G\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0014¨\u0006i"}, d2 = {"Lsdk/pendo/io/sdk/react/PlatformStateManager;", "", "()V", "API_TRIGGERED_SCAN", "", "IS_NATIVE_STACK", "NATIVE_IDS", "TAG", "kotlin.jvm.PlatformType", "clickableElements", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getClickableElements", "()Ljava/util/HashMap;", "setClickableElements", "(Ljava/util/HashMap;)V", "forceNotifyNewScreen", "", "getForceNotifyNewScreen", "()Z", "setForceNotifyNewScreen", "(Z)V", "<set-?>", "Lsdk/pendo/io/Pendo$PendoOptions$Framework;", Pendo.PendoOptions.FRAMEWORK, "getFramework", "()Lsdk/pendo/io/Pendo$PendoOptions$Framework;", "Lsdk/pendo/io/Pendo$PendoOptions$FrameworkType;", Pendo.PendoOptions.FRAMEWORK_TYPE, "getFrameworkType", "()Lsdk/pendo/io/Pendo$PendoOptions$FrameworkType;", Pendo.PendoOptions.FRAMEWORK_VERSION, "getFrameworkVersion", "()Ljava/lang/String;", "info", "", "getInfo", "()Ljava/util/Map;", "setInfo", "(Ljava/util/Map;)V", "isAppAnalyticsDisabled", PlatformStateManager.IS_NATIVE_STACK, "setNativeStack", "isTrackEventSolutionOnly", PlatformStateManager.NATIVE_IDS, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getNativeIDs", "()Ljava/util/ArrayList;", "setNativeIDs", "(Ljava/util/ArrayList;)V", "platformStateManagerRNHelper", "Lsdk/pendo/io/sdk/react/PlatformStateManagerRNHelper;", "", "rnnClickDelayMs", "getRnnClickDelayMs", "()J", "setRnnClickDelayMs", "(J)V", "rootTagsSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getRootTagsSet", "()Ljava/util/HashSet;", "setRootTagsSet", "(Ljava/util/HashSet;)V", "screenName", "getScreenName", "setScreenName", "(Ljava/lang/String;)V", "useClickableElementsFromJS", "getUseClickableElementsFromJS", "extractFrameworkDataFromPendoOptions", "", "pendoOptions", "Lsdk/pendo/io/Pendo$PendoOptions;", "filterReactRoots", "activityRootView", "Landroid/view/View;", "findRNViewWithNativeId", "nativeId", "getFrameworkAsString", "getFrameworkTypeAsString", "getReactRoots", "currentRootView", "getRootsWithNativeId", "isFlutterCodelessApp", "isNotReactNativeApp", "isReactNativeAnalyticsEnabled", "isReactNativeApp", "isXamarinFormsOrMaui", "newScreenIdentified", "rnScreenName", "rnRootTags", "", "rnInfo", "clickableElementsArray", "reduceReachableRNRootViews", "reactRootViews", "retrieveAllValidRNRootViews", "filteredReactRootTags", "sendFailureInfo", "errorMap", "shouldSendErrorToBE", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PlatformStateManager {
    public static final String API_TRIGGERED_SCAN = "apiTriggeredScan";
    private static final String IS_NATIVE_STACK = "isNativeStack";
    private static final String NATIVE_IDS = "nativeIDs";
    private static boolean forceNotifyNewScreen;
    private static Pendo.PendoOptions.FrameworkType frameworkType;
    private static String frameworkVersion;
    private static boolean isAppAnalyticsDisabled;
    private static boolean isNativeStack;
    private static boolean isTrackEventSolutionOnly;
    private static PlatformStateManagerRNHelper platformStateManagerRNHelper;
    private static String screenName;
    private static boolean useClickableElementsFromJS;
    public static final PlatformStateManager INSTANCE = new PlatformStateManager();
    private static String TAG = "PlatformStateManager";
    private static long rnnClickDelayMs = 500;
    private static Pendo.PendoOptions.Framework framework = Pendo.PendoOptions.Framework.NATIVE;
    private static HashSet<Integer> rootTagsSet = new HashSet<>();
    private static Map<String, ? extends Object> info = new HashMap();
    private static ArrayList<String> nativeIDs = new ArrayList<>();
    private static HashMap<Integer, String> clickableElements = new HashMap<>();

    private PlatformStateManager() {
    }

    private final View findRNViewWithNativeId(View activityRootView, String nativeId) {
        try {
            Object invoke = Class.forName("com.facebook.react.uimanager.util.ReactFindViewUtil").getMethod("findView", View.class, String.class).invoke(null, activityRootView, nativeId);
            if (invoke instanceof View) {
                return (View) invoke;
            }
            return null;
        } catch (Exception e) {
            PendoLogger.d(TAG + " -> findRNViewWithNativeId " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    private final HashSet<Integer> getRootsWithNativeId(View activityRootView) {
        HashSet<Integer> hashSet = new HashSet<>();
        Iterator<String> it = nativeIDs.iterator();
        while (it.hasNext()) {
            String next = it.next();
            Intrinsics.checkNotNull(next);
            View findRNViewWithNativeId = findRNViewWithNativeId(activityRootView, next);
            if (findRNViewWithNativeId != null) {
                hashSet.add(Integer.valueOf(findRNViewWithNativeId.getId()));
            }
        }
        return hashSet;
    }

    private final void reduceReachableRNRootViews(HashSet<Integer> rootTagsSet2, HashSet<View> reactRootViews) {
        Iterator<View> it = reactRootViews.iterator();
        while (it.hasNext()) {
            View next = it.next();
            Iterator<View> it2 = reactRootViews.iterator();
            while (it2.hasNext()) {
                View next2 = it2.next();
                if (rootTagsSet2.contains(Integer.valueOf(next.getId())) && rootTagsSet2.contains(Integer.valueOf(next2.getId()))) {
                    try {
                        if (!Intrinsics.areEqual(next, next2) && next.findViewById(next2.getId()) != null) {
                            rootTagsSet2.remove(Integer.valueOf(next2.getId()));
                        }
                    } catch (Exception e) {
                        PendoLogger.w(TAG, e.getMessage());
                    }
                }
            }
        }
    }

    private final void retrieveAllValidRNRootViews(View activityRootView, HashSet<Integer> rootTagsSet2, HashSet<View> reactRootViews, HashSet<Integer> filteredReactRootTags) {
        Iterator<Integer> it = rootTagsSet2.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            try {
                Intrinsics.checkNotNull(next);
                View findViewById = activityRootView.findViewById(next.intValue());
                if (findViewById != null) {
                    reactRootViews.add(findViewById);
                    filteredReactRootTags.add(next);
                }
            } catch (Exception e) {
                PendoLogger.w(TAG, e.getMessage());
            }
        }
    }

    public final void extractFrameworkDataFromPendoOptions(Pendo.PendoOptions pendoOptions) {
        Intrinsics.checkNotNullParameter(pendoOptions, "pendoOptions");
        Pendo.PendoOptions.Framework framework2 = pendoOptions.getFramework();
        Intrinsics.checkNotNullExpressionValue(framework2, "getFramework(...)");
        framework = framework2;
        frameworkType = pendoOptions.getFrameworkType();
        frameworkVersion = pendoOptions.getFrameworkVersion();
        isAppAnalyticsDisabled = pendoOptions.getDisableAnalytics();
        boolean z = false;
        isTrackEventSolutionOnly = pendoOptions.getDisableAnalytics() || frameworkType == Pendo.PendoOptions.FrameworkType.TRACK;
        if (isReactNativeAnalyticsEnabled() && pendoOptions.getUseClickableElementsFromJS()) {
            z = true;
        }
        useClickableElementsFromJS = z;
        if (Pendo.PendoOptions.Framework.REACT_NATIVE != framework || Pendo.PendoOptions.FrameworkType.TRACK == frameworkType) {
            return;
        }
        platformStateManagerRNHelper = new PlatformStateManagerRNHelper();
    }

    public final void filterReactRoots(View activityRootView) {
        Intrinsics.checkNotNullParameter(activityRootView, "activityRootView");
        if (rootTagsSet.isEmpty() || !forceNotifyNewScreen) {
            return;
        }
        HashSet<View> hashSet = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        retrieveAllValidRNRootViews(activityRootView, rootTagsSet, hashSet, hashSet2);
        rootTagsSet.clear();
        rootTagsSet.addAll(hashSet2);
        rootTagsSet.addAll(getRootsWithNativeId(activityRootView));
        reduceReachableRNRootViews(rootTagsSet, hashSet);
        PendoLogger.d(TAG + " -> filterReactRoots " + rootTagsSet, new Object[0]);
    }

    public final HashMap<Integer, String> getClickableElements() {
        return clickableElements;
    }

    public final boolean getForceNotifyNewScreen() {
        return forceNotifyNewScreen;
    }

    public final Pendo.PendoOptions.Framework getFramework() {
        return framework;
    }

    public final String getFrameworkAsString() {
        String framework2 = framework.toString();
        Intrinsics.checkNotNullExpressionValue(framework2, "toString(...)");
        return framework2;
    }

    public final Pendo.PendoOptions.FrameworkType getFrameworkType() {
        return frameworkType;
    }

    public final String getFrameworkTypeAsString() {
        Pendo.PendoOptions.FrameworkType frameworkType2 = frameworkType;
        if (frameworkType2 != null) {
            return frameworkType2.toString();
        }
        return null;
    }

    public final String getFrameworkVersion() {
        return frameworkVersion;
    }

    public final Map<String, Object> getInfo() {
        return info;
    }

    public final ArrayList<String> getNativeIDs() {
        return nativeIDs;
    }

    public final HashSet<View> getReactRoots(View currentRootView) {
        Intrinsics.checkNotNullParameter(currentRootView, "currentRootView");
        HashSet<View> hashSet = new HashSet<>();
        if (frameworkType == Pendo.PendoOptions.FrameworkType.REACT_NAVIGATION && !isNativeStack && (!rootTagsSet.isEmpty())) {
            Iterator<Integer> it = rootTagsSet.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                Intrinsics.checkNotNull(next);
                View findViewById = currentRootView.findViewById(next.intValue());
                if (findViewById != null) {
                    PendoLogger.d(TAG + " -> getReactRoots, react rootView: " + findViewById.getClass().getSimpleName() + ", id: " + findViewById.getId(), new Object[0]);
                    hashSet.add(findViewById);
                }
            }
        } else {
            PendoLogger.d(TAG + " -> getReactRoots, return the current activity rootView: " + currentRootView.getClass().getSimpleName() + ", id: " + currentRootView.getId(), new Object[0]);
            hashSet.add(currentRootView);
        }
        return hashSet;
    }

    public final long getRnnClickDelayMs() {
        return rnnClickDelayMs;
    }

    public final HashSet<Integer> getRootTagsSet() {
        return rootTagsSet;
    }

    public final String getScreenName() {
        return screenName;
    }

    public final boolean getUseClickableElementsFromJS() {
        return useClickableElementsFromJS;
    }

    public final boolean isAppAnalyticsDisabled() {
        return isAppAnalyticsDisabled;
    }

    public final boolean isFlutterCodelessApp() {
        return Pendo.PendoOptions.Framework.FLUTTER == framework && Pendo.PendoOptions.FrameworkType.FLUTTER_OBSERVABLE == frameworkType;
    }

    public final boolean isNativeStack() {
        return isNativeStack;
    }

    public final boolean isNotReactNativeApp() {
        return !isReactNativeApp();
    }

    public final boolean isReactNativeAnalyticsEnabled() {
        return Pendo.PendoOptions.Framework.REACT_NATIVE == framework && !isTrackEventSolutionOnly;
    }

    public final boolean isReactNativeApp() {
        return Pendo.PendoOptions.Framework.REACT_NATIVE == framework;
    }

    public final boolean isTrackEventSolutionOnly() {
        return isTrackEventSolutionOnly;
    }

    public final boolean isXamarinFormsOrMaui() {
        return Pendo.PendoOptions.Framework.XAMARIN_FORMS == framework || Pendo.PendoOptions.Framework.MAUI == framework;
    }

    public final void newScreenIdentified(String rnScreenName, List<Integer> rnRootTags, Map<String, ? extends Object> rnInfo, List<? extends Object> clickableElementsArray) {
        Boolean bool;
        HashSet<Integer> hashSet;
        Boolean bool2;
        HashMap<Integer, String> hashMap;
        if (!isReactNativeAnalyticsEnabled() || rnScreenName == null) {
            return;
        }
        if (rnRootTags == null || rnRootTags.isEmpty()) {
            return;
        }
        PendoLogger.d(TAG + " -> newScreenIdentified: screenName=" + rnScreenName + ", rnRootTags=" + rnRootTags + ", rnInfo=" + rnInfo + ", clickableElements=" + clickableElementsArray, new Object[0]);
        screenName = rnScreenName;
        ArrayList<String> arrayList = null;
        if (platformStateManagerRNHelper == null || rnInfo == null || !rnInfo.containsKey(API_TRIGGERED_SCAN) || !(rnInfo.get(API_TRIGGERED_SCAN) instanceof Boolean)) {
            bool = null;
        } else {
            Object obj = rnInfo.get(API_TRIGGERED_SCAN);
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            bool = (Boolean) obj;
        }
        boolean z = bool == null || !bool.booleanValue();
        forceNotifyNewScreen = z;
        PendoLogger.d(TAG + " -> newScreenIdentified: forceNotifyNewScreen - " + z, new Object[0]);
        PlatformStateManagerRNHelper platformStateManagerRNHelper2 = platformStateManagerRNHelper;
        if (platformStateManagerRNHelper2 == null || (hashSet = platformStateManagerRNHelper2.populateRootTags(rnRootTags, rnInfo)) == null) {
            hashSet = new HashSet<>();
        }
        rootTagsSet = hashSet;
        if (clickableElementsArray != null) {
            PlatformStateManagerRNHelper platformStateManagerRNHelper3 = platformStateManagerRNHelper;
            if (platformStateManagerRNHelper3 == null || (hashMap = platformStateManagerRNHelper3.populateClickableElements(clickableElementsArray)) == null) {
                hashMap = new HashMap<>();
            }
            clickableElements = hashMap;
        }
        if (platformStateManagerRNHelper != null) {
            if (rnInfo != null && rnInfo.containsKey(IS_NATIVE_STACK) && (rnInfo.get(IS_NATIVE_STACK) instanceof Boolean)) {
                Object obj2 = rnInfo.get(IS_NATIVE_STACK);
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                bool2 = (Boolean) obj2;
            } else {
                bool2 = null;
            }
            if (bool2 != null) {
                isNativeStack = bool2.booleanValue();
            }
        }
        if (platformStateManagerRNHelper != null) {
            if (rnInfo != null && rnInfo.containsKey(NATIVE_IDS) && (rnInfo.get(NATIVE_IDS) instanceof ArrayList)) {
                Object obj3 = rnInfo.get(NATIVE_IDS);
                if (obj3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<*>");
                }
                arrayList = (ArrayList) obj3;
            }
            if (arrayList != null && (!arrayList.isEmpty()) && (arrayList.get(0) instanceof String)) {
                nativeIDs = arrayList;
            }
        }
        c.g().c(a.RESUME);
    }

    public final void sendFailureInfo(Map<String, ? extends Object> errorMap) {
        sendFailureInfo(errorMap, true);
    }

    public final void setClickableElements(HashMap<Integer, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        clickableElements = hashMap;
    }

    public final void setForceNotifyNewScreen(boolean z) {
        forceNotifyNewScreen = z;
    }

    public final void setInfo(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        info = map;
    }

    public final void setNativeIDs(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        nativeIDs = arrayList;
    }

    public final void setNativeStack(boolean z) {
        isNativeStack = z;
    }

    public final void setRnnClickDelayMs(long j) {
        rnnClickDelayMs = j;
    }

    public final void setRootTagsSet(HashSet<Integer> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        rootTagsSet = hashSet;
    }

    public final void setScreenName(String str) {
        screenName = str;
    }

    public final boolean useClickableElementsFromJS() {
        return useClickableElementsFromJS;
    }

    public final void sendFailureInfo(Map<String, ? extends Object> errorMap, boolean shouldSendErrorToBE) {
        if (errorMap == null || errorMap.isEmpty()) {
            return;
        }
        String str = "ReactNativePlugin: " + errorMap;
        if (shouldSendErrorToBE) {
            PendoLogger.e(str, new Object[0]);
        } else {
            PendoLogger.w(str, new Object[0]);
        }
    }
}
