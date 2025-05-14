package sdk.pendo.io.actions;

import android.view.View;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.react.uimanager.ViewProps;
import com.iterable.iterableapi.IterableConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.b6.b;
import sdk.pendo.io.c8.h;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.f9.f;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.ActivationModel;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.Quadruple;
import sdk.pendo.io.models.StepLocationModel;
import sdk.pendo.io.models.StepModel;
import sdk.pendo.io.w6.a;
import sdk.pendo.io.x5.j;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002efB\t\b\u0002¢\u0006\u0004\bd\u0010MJ\"\u0010\b\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002Jb\u0010\u0012\u001aR\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\f0\u000bj(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\f`\u00112\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u001e\u001a\u00020\u0016J\u0014\u0010!\u001a\u00020\u00162\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u0013J\u0006\u0010\"\u001a\u00020\u0016J\"\u0010%\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u000e\u0010'\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\tJ\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u0013J\u000e\u0010*\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010-\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010+J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020(0.H\u0007J=\u00104\u001a\u00020\u00162,\u00101\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\f00H\u0000¢\u0006\u0004\b2\u00103J=\u00107\u001a\u00020\u00162,\u00105\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\f00H\u0000¢\u0006\u0004\b6\u00103J\b\u00108\u001a\u00020\u0016H\u0007J\b\u00109\u001a\u00020\u0016H\u0007R\u0014\u0010:\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b<\u0010;R\u0014\u0010=\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u0010;R\u0014\u0010>\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u0010;R2\u0010B\u001a\u0012\u0012\u0004\u0012\u00020@0?j\b\u0012\u0004\u0012\u00020@`A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR&\u0010H\u001a\b\u0012\u0004\u0012\u00020(0.8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bH\u0010I\u0012\u0004\bL\u0010M\u001a\u0004\bJ\u0010KR\u0016\u0010O\u001a\u0004\u0018\u00010N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u0004\u0018\u00010N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010PR\u0014\u0010R\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010PR\u001d\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00010\u00198\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\"\u0010X\u001a\u00020W8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R8\u0010_\u001a&\u0012\f\u0012\n ^*\u0004\u0018\u00010\u001a0\u001a ^*\u0012\u0012\f\u0012\n ^*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010\u00190\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010TR\u0014\u0010c\u001a\u00020`8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\ba\u0010b¨\u0006g"}, d2 = {"Lsdk/pendo/io/actions/ActivationManager;", "", "", "guideId", "Lsdk/pendo/io/models/ActivationModel;", "activationModel", "Lsdk/pendo/io/models/StepLocationModel;", "locationModel", "addGuideIdForActivationAndLocation", "Lorg/json/JSONObject;", "objectData", "Ljava/util/LinkedHashSet;", "Lsdk/pendo/io/models/Quadruple;", "", "Lsdk/pendo/io/actions/ActivationManager$ActivationEvents;", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "Lkotlin/collections/LinkedHashSet;", "getGuidesWithMatchingViewsCurrentlyOnScreen", "", "Lsdk/pendo/io/actions/ElementInfoAndViewRef;", "getRetroElementInfoMatchingSelector", "", "handleRestart", "sendTrackEventsReceivedWhileStartSessionWasPendingApproval", "Lsdk/pendo/io/w6/a;", "", "isInitedObservable", "isInited", "setIsInitedObservable", ViewProps.START, "Lsdk/pendo/io/models/GuideModel;", "guides", "restartWithGuides", "clear", "viewElementInfo", "guideTriggeredByView", "handleClick", "trackEventJSON", "handleTrack", "Lsdk/pendo/io/actions/ActivationManager$Trigger;", "getGuidesTriggers", "removeGuideIdFromTriggers", "Lsdk/pendo/io/models/StepModel;", "stepModel", "handleLaunchGuideFromGuide", "", "getTriggersForStep", "", "guidesSetWithTrackActivation", "populateGuidesSetWithTrackActivationBeforeSessionStart$pendoIO_release", "(Ljava/util/Set;)V", "populateGuidesSetWithTrackActivationBeforeSessionStart", "guidesSetWithViewActivation", "populateGuideSetWithViewActivation$pendoIO_release", "populateGuideSetWithViewActivation", "handleScreenView", "handleAnyActivation", "TAG", "Ljava/lang/String;", "TRACK_EVENT_KEY", "ELEMENT_INFO_KEY", "SCREEN_DATA_KEY", "Ljava/util/ArrayList;", "Lsdk/pendo/io/c8/h$a;", "Lkotlin/collections/ArrayList;", "trackEventsBeforeSessionStart", "Ljava/util/ArrayList;", "getTrackEventsBeforeSessionStart", "()Ljava/util/ArrayList;", "setTrackEventsBeforeSessionStart", "(Ljava/util/ArrayList;)V", "triggers", "Ljava/util/List;", "getTriggers", "()Ljava/util/List;", "getTriggers$annotations", "()V", "Lsdk/pendo/io/b6/b;", "screenChangedSubscription", "Lsdk/pendo/io/b6/b;", "inScreenChangedSubscription", "activationTriggerSubscription", "activationTriggerSubject", "Lsdk/pendo/io/w6/a;", "getActivationTriggerSubject", "()Lsdk/pendo/io/w6/a;", "Lsdk/pendo/io/actions/GuideActivationHelper;", "guideActivationHelper", "Lsdk/pendo/io/actions/GuideActivationHelper;", "getGuideActivationHelper", "()Lsdk/pendo/io/actions/GuideActivationHelper;", "setGuideActivationHelper", "(Lsdk/pendo/io/actions/GuideActivationHelper;)V", "kotlin.jvm.PlatformType", "sIsInitedObservable", "Lsdk/pendo/io/f9/f;", "getScreenManager", "()Lsdk/pendo/io/f9/f;", "screenManager", "<init>", "ActivationEvents", "Trigger", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class ActivationManager {
    public static final String ELEMENT_INFO_KEY = "retroElementInfo";
    public static final ActivationManager INSTANCE;
    public static final String SCREEN_DATA_KEY = "retroactiveScreenData";
    private static final String TAG = "ActivationManager";
    public static final String TRACK_EVENT_KEY = "trackEventInfo";
    private static final a<Object> activationTriggerSubject;
    private static final b activationTriggerSubscription;
    private static GuideActivationHelper guideActivationHelper;
    private static final b inScreenChangedSubscription;
    private static final a<Boolean> sIsInitedObservable;
    private static final b screenChangedSubscription;
    private static ArrayList<h.a> trackEventsBeforeSessionStart;
    private static final List<Trigger> triggers;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/actions/ActivationManager$ActivationEvents;", "", "activationEvent", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getActivationEvent", "()Ljava/lang/String;", "APP_LAUNCH", "VIEW", "CLICK", "PREVIEW", "TRACK_EVENT", ThreadConfined.ANY, "API", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ActivationEvents {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ActivationEvents[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private static final HashMap<String, ActivationEvents> map;
        private final String activationEvent;
        public static final ActivationEvents APP_LAUNCH = new ActivationEvents("APP_LAUNCH", 0, "appLaunch");
        public static final ActivationEvents VIEW = new ActivationEvents("VIEW", 1, "view");
        public static final ActivationEvents CLICK = new ActivationEvents("CLICK", 2, "click");
        public static final ActivationEvents PREVIEW = new ActivationEvents("PREVIEW", 3, "preview");
        public static final ActivationEvents TRACK_EVENT = new ActivationEvents("TRACK_EVENT", 4, "track");
        public static final ActivationEvents ANY = new ActivationEvents(ThreadConfined.ANY, 5, "any");
        public static final ActivationEvents API = new ActivationEvents("API", 6, "api");

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lsdk/pendo/io/actions/ActivationManager$ActivationEvents$Companion;", "", "()V", "map", "Ljava/util/HashMap;", "", "Lsdk/pendo/io/actions/ActivationManager$ActivationEvents;", "Lkotlin/collections/HashMap;", "getMap", "()Ljava/util/HashMap;", "fromString", "type", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ActivationEvents fromString(String type) {
                if (type != null) {
                    return ActivationEvents.INSTANCE.getMap().get(type);
                }
                return null;
            }

            public final HashMap<String, ActivationEvents> getMap() {
                return ActivationEvents.map;
            }
        }

        private static final /* synthetic */ ActivationEvents[] $values() {
            return new ActivationEvents[]{APP_LAUNCH, VIEW, CLICK, PREVIEW, TRACK_EVENT, ANY, API};
        }

        static {
            ActivationEvents[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
            map = new HashMap<>();
            for (ActivationEvents activationEvents : values()) {
                map.put(activationEvents.activationEvent, activationEvents);
            }
        }

        private ActivationEvents(String str, int i, String str2) {
            this.activationEvent = str2;
        }

        public static EnumEntries<ActivationEvents> getEntries() {
            return $ENTRIES;
        }

        public static ActivationEvents valueOf(String str) {
            return (ActivationEvents) Enum.valueOf(ActivationEvents.class, str);
        }

        public static ActivationEvents[] values() {
            return (ActivationEvents[]) $VALUES.clone();
        }

        public final String getActivationEvent() {
            return this.activationEvent;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/actions/ActivationManager$Trigger;", "", "activation", "Lsdk/pendo/io/models/ActivationModel;", IterableConstants.ITERABLE_IN_APP_LOCATION, "Lsdk/pendo/io/models/StepLocationModel;", "(Lsdk/pendo/io/models/ActivationModel;Lsdk/pendo/io/models/StepLocationModel;)V", "getActivation", "()Lsdk/pendo/io/models/ActivationModel;", "guideIds", "", "", "getGuideIds", "()Ljava/util/Set;", "getLocation", "()Lsdk/pendo/io/models/StepLocationModel;", "addGuideId", "", "guideId", "removeGuideId", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Trigger {
        private final ActivationModel activation;
        private final Set<String> guideIds;
        private final StepLocationModel location;

        public Trigger(ActivationModel activation, StepLocationModel stepLocationModel) {
            Intrinsics.checkNotNullParameter(activation, "activation");
            this.activation = activation;
            this.location = stepLocationModel;
            this.guideIds = new LinkedHashSet();
        }

        public final void addGuideId(String guideId) {
            Intrinsics.checkNotNullParameter(guideId, "guideId");
            this.guideIds.add(guideId);
        }

        public final ActivationModel getActivation() {
            return this.activation;
        }

        public final Set<String> getGuideIds() {
            return this.guideIds;
        }

        public final StepLocationModel getLocation() {
            return this.location;
        }

        public final void removeGuideId(String guideId) {
            Intrinsics.checkNotNullParameter(guideId, "guideId");
            this.guideIds.remove(guideId);
        }
    }

    static {
        b bVar;
        j<String> a2;
        j<String> a3;
        ActivationManager activationManager = new ActivationManager();
        INSTANCE = activationManager;
        trackEventsBeforeSessionStart = new ArrayList<>();
        triggers = new ArrayList();
        a<Object> n = a.n();
        Intrinsics.checkNotNullExpressionValue(n, "create(...)");
        activationTriggerSubject = n;
        guideActivationHelper = new GuideActivationHelper(activationManager.getScreenManager());
        j<String> r = activationManager.getScreenManager().r();
        b bVar2 = null;
        if (r == null || (a3 = r.a(sdk.pendo.io.v6.a.b())) == null) {
            bVar = null;
        } else {
            final AnonymousClass1 anonymousClass1 = new Function1<String, Unit>() { // from class: sdk.pendo.io.actions.ActivationManager.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    if (VisualGuidesManager.getInstance().isAnyFullScreenGuideShowing()) {
                        return;
                    }
                    ActivationManager.INSTANCE.handleScreenView();
                }
            };
            bVar = a3.a(new e() { // from class: sdk.pendo.io.actions.ActivationManager$$ExternalSyntheticLambda0
                @Override // sdk.pendo.io.d6.e
                public final void accept(Object obj) {
                    ActivationManager._init_$lambda$0(Function1.this, obj);
                }
            }, new sdk.pendo.io.a9.a("ActivationManager, screenChangedSubscription"));
        }
        screenChangedSubscription = bVar;
        j<String> d = activationManager.getScreenManager().d();
        if (d != null && (a2 = d.a(sdk.pendo.io.v6.a.b())) != null) {
            final AnonymousClass2 anonymousClass2 = new Function1<String, Unit>() { // from class: sdk.pendo.io.actions.ActivationManager.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    if (VisualGuidesManager.getInstance().isAnyFullScreenGuideShowing()) {
                        return;
                    }
                    ActivationManager.INSTANCE.handleScreenView();
                }
            };
            bVar2 = a2.a(new e() { // from class: sdk.pendo.io.actions.ActivationManager$$ExternalSyntheticLambda1
                @Override // sdk.pendo.io.d6.e
                public final void accept(Object obj) {
                    ActivationManager._init_$lambda$1(Function1.this, obj);
                }
            }, new sdk.pendo.io.a9.a("ActivationManager, inScreenChangedSubscription"));
        }
        inScreenChangedSubscription = bVar2;
        b a4 = n.a(sdk.pendo.io.v6.a.b()).a(new e() { // from class: sdk.pendo.io.actions.ActivationManager$$ExternalSyntheticLambda2
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                ActivationManager._init_$lambda$2(obj);
            }
        }, new sdk.pendo.io.a9.a("ActivationManager, activationTriggerSubscription"));
        Intrinsics.checkNotNullExpressionValue(a4, "subscribe(...)");
        activationTriggerSubscription = a4;
        sIsInitedObservable = a.b(Boolean.FALSE);
    }

    private ActivationManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(Object obj) {
        if (VisualGuidesManager.getInstance().isAnyFullScreenGuideShowing()) {
            return;
        }
        INSTANCE.handleAnyActivation();
    }

    private final Object addGuideIdForActivationAndLocation(String guideId, ActivationModel activationModel, StepLocationModel locationModel) {
        Object obj;
        Iterator<T> it = triggers.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Trigger trigger = (Trigger) obj;
            if (Intrinsics.areEqual(trigger.getActivation(), activationModel) && Intrinsics.areEqual(trigger.getLocation(), locationModel)) {
                break;
            }
        }
        Trigger trigger2 = (Trigger) obj;
        if (trigger2 != null) {
            trigger2.addGuideId(guideId);
            return Unit.INSTANCE;
        }
        Trigger trigger3 = new Trigger(activationModel, locationModel);
        trigger3.addGuideId(guideId);
        triggers.add(trigger3);
        return trigger3;
    }

    private final LinkedHashSet<Quadruple<String, Integer, ActivationEvents, WeakReference<View>>> getGuidesWithMatchingViewsCurrentlyOnScreen(JSONObject objectData) {
        List<ElementInfoAndViewRef> retroElementInfoMatchingSelector;
        LinkedHashSet<Quadruple<String, Integer, ActivationEvents, WeakReference<View>>> linkedHashSet = new LinkedHashSet<>();
        if (objectData != null && (retroElementInfoMatchingSelector = INSTANCE.getRetroElementInfoMatchingSelector()) != null) {
            for (ElementInfoAndViewRef elementInfoAndViewRef : retroElementInfoMatchingSelector) {
                Integer currentStepIndex = StepSeenManager.getInstance().getCurrentStepIndex();
                GuideActivationHelper guideActivationHelper2 = guideActivationHelper;
                Trigger matchingTrigger = elementInfoAndViewRef.getMatchingTrigger();
                WeakReference<View> viewReference = elementInfoAndViewRef.getViewReference();
                Intrinsics.checkNotNull(currentStepIndex);
                linkedHashSet.addAll(guideActivationHelper2.getGuidesMatchingCurrentActivationTriggerForTooltips(matchingTrigger, viewReference, currentStepIndex.intValue()));
            }
        }
        return linkedHashSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cd, code lost:
    
        if (r7.isEmpty() == false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<sdk.pendo.io.actions.ElementInfoAndViewRef> getRetroElementInfoMatchingSelector() {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.actions.ActivationManager.getRetroElementInfoMatchingSelector():java.util.List");
    }

    private final f getScreenManager() {
        f x = PendoInternal.x();
        Intrinsics.checkNotNullExpressionValue(x, "getScreenManager(...)");
        return x;
    }

    public static /* synthetic */ void getTriggers$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String handleClick$default(ActivationManager activationManager, JSONObject jSONObject, WeakReference weakReference, int i, Object obj) {
        if ((i & 2) != 0) {
            weakReference = null;
        }
        return activationManager.handleClick(jSONObject, weakReference);
    }

    private final synchronized void handleRestart() {
        PendoLogger.i("ActivationManager-> handleRestart after new init", new Object[0]);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(guideActivationHelper.getGuidesMatchingCurrentActivationTrigger(null, ActivationEvents.APP_LAUNCH, getGuidesTriggers()));
        PendoInternal.d(false);
        sendTrackEventsReceivedWhileStartSessionWasPendingApproval();
        if (linkedHashSet.isEmpty()) {
            populateGuidesSetWithTrackActivationBeforeSessionStart$pendoIO_release(linkedHashSet);
        }
        if (linkedHashSet.isEmpty()) {
            populateGuideSetWithViewActivation$pendoIO_release(linkedHashSet);
        }
        if ((!linkedHashSet.isEmpty()) && Intrinsics.areEqual(GuideActivationHelper.showGuide$default(guideActivationHelper, CollectionsKt.toList(linkedHashSet), null, 2, null), "")) {
            trackEventsBeforeSessionStart.clear();
        }
    }

    private final void sendTrackEventsReceivedWhileStartSessionWasPendingApproval() {
        CollectionsKt.sortedWith(trackEventsBeforeSessionStart, new Comparator() { // from class: sdk.pendo.io.actions.ActivationManager$sendTrackEventsReceivedWhileStartSessionWasPendingApproval$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((h.a) t).d()), Long.valueOf(((h.a) t2).d()));
            }
        });
        Iterator<T> it = trackEventsBeforeSessionStart.iterator();
        while (it.hasNext()) {
            sdk.pendo.io.c8.f.f().a((h.a) it.next());
        }
    }

    public final synchronized void clear() {
        triggers.clear();
    }

    public final a<Object> getActivationTriggerSubject() {
        return activationTriggerSubject;
    }

    public final GuideActivationHelper getGuideActivationHelper() {
        return guideActivationHelper;
    }

    public final List<Trigger> getGuidesTriggers() {
        List<Trigger> triggersForStep = getTriggersForStep();
        return triggersForStep.isEmpty() ^ true ? triggersForStep : triggers;
    }

    public final ArrayList<h.a> getTrackEventsBeforeSessionStart() {
        return trackEventsBeforeSessionStart;
    }

    public final List<Trigger> getTriggers() {
        return triggers;
    }

    public final List<Trigger> getTriggersForStep() {
        List<ActivationModel> stepActivations;
        ArrayList arrayList = new ArrayList();
        if (StepSeenManager.getInstance().getCurrentStepSeen() != null) {
            String currentStepGuideId = StepSeenManager.getInstance().getCurrentStepGuideId();
            String currentStepId = StepSeenManager.getInstance().getCurrentStepId();
            if (currentStepGuideId != null && currentStepId != null) {
                GuideModel guide = GuidesManager.INSTANCE.getGuide(currentStepGuideId);
                StepModel guideStepModel = guide != null ? guide.getGuideStepModel(currentStepId) : null;
                if (guideStepModel != null && (stepActivations = guideStepModel.getStepActivations()) != null) {
                    Intrinsics.checkNotNull(stepActivations);
                    for (ActivationModel activationModel : stepActivations) {
                        if (StepSeenManager.getInstance().isBackwardsStep()) {
                            if (Intrinsics.areEqual(activationModel.getEvent(), ActivationEvents.APP_LAUNCH.getActivationEvent())) {
                                activationModel.setEvent(ActivationEvents.ANY.getActivationEvent());
                            } else if (Intrinsics.areEqual(activationModel.getEvent(), ActivationEvents.CLICK.getActivationEvent())) {
                                activationModel.setEvent(ActivationEvents.VIEW.getActivationEvent());
                                activationModel.setIsActivationOverridden(true);
                            }
                        }
                        if (StepSeenManager.getInstance().isBannerGuideStep()) {
                            activationModel = new ActivationModel();
                            activationModel.setEvent(ActivationEvents.ANY.getActivationEvent());
                        } else {
                            Intrinsics.checkNotNull(activationModel);
                        }
                        Trigger trigger = new Trigger(activationModel, guideStepModel.getStepLocationModel());
                        trigger.addGuideId(currentStepGuideId);
                        arrayList.add(trigger);
                    }
                }
            }
        }
        return arrayList;
    }

    public final synchronized void handleAnyActivation() {
        if (PendoInternal.U()) {
            GuideActivationHelper.showGuide$default(guideActivationHelper, CollectionsKt.toList(guideActivationHelper.getGuidesMatchingCurrentActivationTrigger(null, ActivationEvents.ANY, getGuidesTriggers())), null, 2, null);
        }
    }

    public final String handleClick(JSONObject viewElementInfo, WeakReference<View> guideTriggeredByView) {
        JSONObject currentScreenData = guideActivationHelper.getCurrentScreenData();
        if (currentScreenData == null || viewElementInfo == null) {
            return "";
        }
        PendoLogger.i("ActivationManager-> handleClick for viewElement: " + viewElementInfo, new Object[0]);
        Set<Quadruple<String, Integer, ActivationEvents, WeakReference<View>>> guidesMatchingCurrentActivationTrigger = guideActivationHelper.getGuidesMatchingCurrentActivationTrigger(guideActivationHelper.getObjectDataForScreenAndElement(currentScreenData, viewElementInfo), ActivationEvents.CLICK, INSTANCE.getGuidesTriggers());
        return guidesMatchingCurrentActivationTrigger.isEmpty() ^ true ? guideActivationHelper.showGuide(CollectionsKt.toList(guidesMatchingCurrentActivationTrigger), guideTriggeredByView) : "";
    }

    public final synchronized void handleLaunchGuideFromGuide(String guideId, StepModel stepModel) {
        List<ActivationModel> stepActivations;
        ActivationModel activationModel;
        Intrinsics.checkNotNullParameter(guideId, "guideId");
        Unit unit = null;
        boolean z = (stepModel != null ? stepModel.getStepLocationModel() : null) != null;
        String event = (stepModel == null || (stepActivations = stepModel.getStepActivations()) == null || (activationModel = (ActivationModel) CollectionsKt.first((List) stepActivations)) == null) ? null : activationModel.getEvent();
        if (event != null) {
            PendoLogger.i("ActivationManager-> handleLaunchGuideFromGuide for guideId: " + guideId + ", is tooltip: " + z + " and self activationEvent: " + event, new Object[0]);
            if (!z) {
                ArrayList arrayList = new ArrayList();
                ActivationEvents fromString = ActivationEvents.INSTANCE.fromString(event);
                Intrinsics.checkNotNull(fromString);
                arrayList.add(new Quadruple(guideId, 0, fromString, null));
                GuideActivationHelper.showGuide$default(guideActivationHelper, arrayList, null, 2, null);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            PendoLogger.e(TAG, "handleLaunchGuideFromGuide with null guideActivationEvent for guideId: " + guideId + ", is tooltip: " + z + " ");
        }
    }

    public final synchronized void handleScreenView() {
        if (PendoInternal.U()) {
            PendoLogger.i("ActivationManager-> handleScreenView", new Object[0]);
            Unit unit = null;
            if (guideActivationHelper.getCurrentScreenData() != null) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                INSTANCE.populateGuideSetWithViewActivation$pendoIO_release(linkedHashSet);
                if (!linkedHashSet.isEmpty()) {
                    GuideActivationHelper.showGuide$default(guideActivationHelper, CollectionsKt.toList(linkedHashSet), null, 2, null);
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                PendoLogger.i("ActivationManager-> handleScreenView the currentScreenData is null", new Object[0]);
            }
        }
    }

    public final synchronized void handleTrack(JSONObject trackEventJSON) {
        Intrinsics.checkNotNullParameter(trackEventJSON, "trackEventJSON");
        PendoLogger.i("ActivationManager-> handleTrack with trackEvent: " + trackEventJSON, new Object[0]);
        Set<Quadruple<String, Integer, ActivationEvents, WeakReference<View>>> guidesMatchingCurrentActivationTrigger = guideActivationHelper.getGuidesMatchingCurrentActivationTrigger(guideActivationHelper.getObjectDataForTrackEvent(trackEventJSON), ActivationEvents.TRACK_EVENT, getGuidesTriggers());
        if (!guidesMatchingCurrentActivationTrigger.isEmpty()) {
            GuideActivationHelper.showGuide$default(guideActivationHelper, CollectionsKt.toList(guidesMatchingCurrentActivationTrigger), null, 2, null);
        }
    }

    public final synchronized boolean isInited() {
        Boolean o;
        o = sIsInitedObservable.o();
        Intrinsics.checkNotNull(o);
        return o.booleanValue();
    }

    public final synchronized a<Boolean> isInitedObservable() {
        a<Boolean> sIsInitedObservable2;
        sIsInitedObservable2 = sIsInitedObservable;
        Intrinsics.checkNotNullExpressionValue(sIsInitedObservable2, "sIsInitedObservable");
        return sIsInitedObservable2;
    }

    public final void populateGuideSetWithViewActivation$pendoIO_release(Set<Quadruple<String, Integer, ActivationEvents, WeakReference<View>>> guidesSetWithViewActivation) {
        Intrinsics.checkNotNullParameter(guidesSetWithViewActivation, "guidesSetWithViewActivation");
        JSONObject currentScreenData = guideActivationHelper.getCurrentScreenData();
        if (currentScreenData != null) {
            JSONObject objectDataForScreen = guideActivationHelper.getObjectDataForScreen(currentScreenData);
            GuideActivationHelper guideActivationHelper2 = guideActivationHelper;
            ActivationEvents activationEvents = ActivationEvents.VIEW;
            ActivationManager activationManager = INSTANCE;
            guidesSetWithViewActivation.addAll(SetsKt.plus((Set) guideActivationHelper2.getGuidesMatchingCurrentActivationTrigger(objectDataForScreen, activationEvents, activationManager.getGuidesTriggers()), (Iterable) activationManager.getGuidesWithMatchingViewsCurrentlyOnScreen(objectDataForScreen)));
        }
    }

    public final void populateGuidesSetWithTrackActivationBeforeSessionStart$pendoIO_release(Set<Quadruple<String, Integer, ActivationEvents, WeakReference<View>>> guidesSetWithTrackActivation) {
        Intrinsics.checkNotNullParameter(guidesSetWithTrackActivation, "guidesSetWithTrackActivation");
        JSONObject jSONObject = new JSONObject();
        Iterator<T> it = trackEventsBeforeSessionStart.iterator();
        while (it.hasNext()) {
            jSONObject.put(TRACK_EVENT_KEY, ((h.a) it.next()).c());
            Set<Quadruple<String, Integer, ActivationEvents, WeakReference<View>>> guidesMatchingCurrentActivationTrigger = guideActivationHelper.getGuidesMatchingCurrentActivationTrigger(jSONObject, ActivationEvents.TRACK_EVENT, INSTANCE.getGuidesTriggers());
            if (!guidesMatchingCurrentActivationTrigger.isEmpty()) {
                guidesSetWithTrackActivation.addAll(guidesMatchingCurrentActivationTrigger);
                return;
            }
        }
        trackEventsBeforeSessionStart.clear();
    }

    public final synchronized void removeGuideIdFromTriggers(String guideId) {
        Intrinsics.checkNotNullParameter(guideId, "guideId");
        Iterator<Trigger> it = triggers.iterator();
        while (it.hasNext()) {
            Trigger next = it.next();
            next.getGuideIds().remove(guideId);
            if (next.getGuideIds().isEmpty()) {
                it.remove();
            }
        }
    }

    public final synchronized void restartWithGuides(List<? extends GuideModel> guides) {
        StepModel stepModel;
        Intrinsics.checkNotNullParameter(guides, "guides");
        try {
            triggers.clear();
            for (GuideModel guideModel : guides) {
                List<StepModel> steps = guideModel.getSteps();
                if (steps != null && (stepModel = steps.get(0)) != null) {
                    Intrinsics.checkNotNull(stepModel);
                    List<ActivationModel> stepActivations = stepModel.getStepActivations();
                    if (stepActivations != null) {
                        Intrinsics.checkNotNull(stepActivations);
                        for (ActivationModel activationModel : stepActivations) {
                            StepLocationModel stepLocationModel = stepModel.getStepLocationModel();
                            ActivationManager activationManager = INSTANCE;
                            String guideId = guideModel.getGuideId();
                            Intrinsics.checkNotNullExpressionValue(guideId, "getGuideId(...)");
                            Intrinsics.checkNotNull(activationModel);
                            activationManager.addGuideIdForActivationAndLocation(guideId, activationModel, stepLocationModel);
                        }
                    }
                }
            }
            handleRestart();
        } catch (Exception e) {
            String str = "GuideIds in restart payload\n";
            Iterator<T> it = guides.iterator();
            while (it.hasNext()) {
                str = str + ((GuideModel) it.next()).getGuideId() + " \n";
            }
            PendoLogger.e(e, e.getMessage(), str);
        }
    }

    public final void setGuideActivationHelper(GuideActivationHelper guideActivationHelper2) {
        Intrinsics.checkNotNullParameter(guideActivationHelper2, "<set-?>");
        guideActivationHelper = guideActivationHelper2;
    }

    public final synchronized void setIsInitedObservable(boolean isInited) {
        sIsInitedObservable.onNext(Boolean.valueOf(isInited));
    }

    public final void setTrackEventsBeforeSessionStart(ArrayList<h.a> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        trackEventsBeforeSessionStart = arrayList;
    }

    public final void start() {
    }
}
