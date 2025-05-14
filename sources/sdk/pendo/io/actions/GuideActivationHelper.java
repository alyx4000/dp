package sdk.pendo.io.actions;

import android.app.Activity;
import android.view.View;
import com.iterable.iterableapi.IterableConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.events.ConditionData;
import sdk.pendo.io.events.IdentificationData;
import sdk.pendo.io.f9.f;
import sdk.pendo.io.g9.o0;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.listeners.views.OnElementInScreenFoundListener;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.Quadruple;
import sdk.pendo.io.models.StepLocationModel;
import sdk.pendo.io.n1.a;
import sdk.pendo.io.n1.b;
import sdk.pendo.io.n1.g;
import sdk.pendo.io.n1.i;
import sdk.pendo.io.n1.l;
import sdk.pendo.io.n8.c;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b<\u0010=J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010\u000b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J$\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0012\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\bJL\u0010\u001f\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\u001d0\u001c2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aJJ\u0010\"\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\u001d0\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010!\u001a\u00020\u001eJ\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0016\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004J\b\u0010*\u001a\u0004\u0018\u00010\u0004JF\u0010-\u001a\u00020\b2,\u0010+\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\u001d0\u001a2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ<\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u001a2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u000e0/j\b\u0012\u0004\u0012\u00020\u000e`02\u0006\u00102\u001a\u00020\u0004R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010:\u001a\n 9*\u0004\u0018\u000108088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lsdk/pendo/io/actions/GuideActivationHelper;", "", "Lsdk/pendo/io/actions/ActivationManager$Trigger;", IterableConstants.ITERABLE_IN_APP_TRIGGER, "Lorg/json/JSONObject;", "objectData", "", "isGuideMatchesPageOrView", "", "objectDataKey", "selector", "isSelectorMatch", "featureSelector", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "getView", "isFeatureSelectorMatch", "pageSelector", "isPageSelectorMatch", "trackSelector", "isTrackSelectorMatch", "jsonString", "Lsdk/pendo/io/n1/b;", "jsonPathParse", "Lsdk/pendo/io/actions/ActivationManager$ActivationEvents;", "activationEvent", "", "guidesTriggers", "", "Lsdk/pendo/io/models/Quadruple;", "", "getGuidesMatchingCurrentActivationTrigger", "viewReference", "currentStepIndex", "getGuidesMatchingCurrentActivationTriggerForTooltips", "isGuideTriggerMatchSelector", "screenData", IdentificationData.SERIALIZED_NAME, "getObjectDataForScreenAndElement", "trackEventJSON", "getObjectDataForTrackEvent", "getObjectDataForScreen", "getCurrentScreenData", "guideCandidatesList", "guideTriggeredByView", "showGuide", "triggerList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "roots", "path", "Lsdk/pendo/io/actions/ElementInfoAndViewRef;", "getMatchingElementsIfExist", "Lsdk/pendo/io/f9/f;", "screenManager", "Lsdk/pendo/io/f9/f;", "Lsdk/pendo/io/n1/a;", "kotlin.jvm.PlatformType", "conf", "Lsdk/pendo/io/n1/a;", "<init>", "(Lsdk/pendo/io/f9/f;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class GuideActivationHelper {
    private final a conf;
    private final f screenManager;

    public GuideActivationHelper(f screenManager) {
        Intrinsics.checkNotNullParameter(screenManager, "screenManager");
        this.screenManager = screenManager;
        this.conf = a.b().a(i.DEFAULT_PATH_LEAF_TO_NULL, i.SUPPRESS_EXCEPTIONS);
    }

    private final WeakReference<View> getView(String featureSelector, JSONObject objectData) {
        WeakReference<View> weakReference;
        if (objectData != null && featureSelector != null) {
            if (!objectData.has("retroElementInfo")) {
                PendoLogger.w("objectData has no retroElementInfo", new Object[0]);
                return null;
            }
            sdk.pendo.io.b2.a aVar = (sdk.pendo.io.b2.a) jsonPathParse(objectData.get("retroElementInfo").toString()).a(featureSelector, new l[0]);
            if (aVar != null && aVar.size() > 0) {
                IdentificationData makeFromJson = IdentificationData.makeFromJson(aVar.c());
                Activity f = c.g().f();
                if (f != null) {
                    q0.b a2 = o0.a(o0.f1142a, f, false, 2, null);
                    View a3 = sdk.pendo.io.m8.a.a((a2 == null || (weakReference = a2.f1145a) == null) ? null : weakReference.get(), makeFromJson, true, (ConditionData) null);
                    if (a3 != null) {
                        return new WeakReference<>(a3);
                    }
                }
            }
        }
        return null;
    }

    private final boolean isGuideMatchesPageOrView(ActivationManager.Trigger trigger, JSONObject objectData) {
        if (!isPageSelectorMatch(objectData, trigger.getActivation().getPageSelector())) {
            return false;
        }
        StepLocationModel location = trigger.getLocation();
        String featureSelector = location != null ? location.getFeatureSelector() : null;
        if (featureSelector == null || StringsKt.isBlank(featureSelector)) {
            return true;
        }
        StepLocationModel location2 = trigger.getLocation();
        return isFeatureSelectorMatch(objectData, location2 != null ? location2.getFeatureSelector() : null);
    }

    private final boolean isSelectorMatch(JSONObject objectData, String objectDataKey, String selector) {
        if (objectData != null && objectData.has(objectDataKey)) {
            if (!(selector == null || selector.length() == 0)) {
                sdk.pendo.io.b2.a aVar = (sdk.pendo.io.b2.a) jsonPathParse(objectData.get(objectDataKey).toString()).a(selector, new l[0]);
                return !(aVar == null || aVar.isEmpty());
            }
        }
        PendoLogger.i("isSelectorMatch with " + objectDataKey + " key -> objectData or key or trackSelector are not exist", new Object[0]);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String showGuide$default(GuideActivationHelper guideActivationHelper, List list, WeakReference weakReference, int i, Object obj) {
        if ((i & 2) != 0) {
            weakReference = null;
        }
        return guideActivationHelper.showGuide(list, weakReference);
    }

    public final JSONObject getCurrentScreenData() {
        return this.screenManager.n();
    }

    public final Set<Quadruple<String, Integer, ActivationManager.ActivationEvents, WeakReference<View>>> getGuidesMatchingCurrentActivationTrigger(JSONObject objectData, ActivationManager.ActivationEvents activationEvent, List<ActivationManager.Trigger> guidesTriggers) {
        Intrinsics.checkNotNullParameter(activationEvent, "activationEvent");
        Intrinsics.checkNotNullParameter(guidesTriggers, "guidesTriggers");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList<ActivationManager.Trigger> arrayList = new ArrayList();
        for (Object obj : guidesTriggers) {
            String event = ((ActivationManager.Trigger) obj).getActivation().getEvent();
            boolean z = false;
            if (!(event == null || event.length() == 0)) {
                Intrinsics.checkNotNull(event);
                if (event.contentEquals(activationEvent.getActivationEvent()) || event.contentEquals(ActivationManager.ActivationEvents.ANY.getActivationEvent())) {
                    z = true;
                }
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        for (ActivationManager.Trigger trigger : arrayList) {
            if (isGuideTriggerMatchSelector(trigger, objectData)) {
                for (String str : trigger.getGuideIds()) {
                    ActivationManager.ActivationEvents fromString = ActivationManager.ActivationEvents.INSTANCE.fromString(trigger.getActivation().getEvent());
                    if (fromString != null) {
                        Integer currentStepIndex = StepSeenManager.getInstance().getCurrentStepIndex();
                        Intrinsics.checkNotNull(currentStepIndex);
                        StepLocationModel location = trigger.getLocation();
                        linkedHashSet.add(new Quadruple(str, currentStepIndex, fromString, getView(location != null ? location.getFeatureSelector() : null, objectData)));
                    }
                }
            }
        }
        return linkedHashSet;
    }

    public final Set<Quadruple<String, Integer, ActivationManager.ActivationEvents, WeakReference<View>>> getGuidesMatchingCurrentActivationTriggerForTooltips(ActivationManager.Trigger trigger, WeakReference<View> viewReference, int currentStepIndex) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(viewReference, "viewReference");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : trigger.getGuideIds()) {
            ActivationManager.ActivationEvents fromString = ActivationManager.ActivationEvents.INSTANCE.fromString(trigger.getActivation().getEvent());
            if (fromString != null) {
                linkedHashSet.add(new Quadruple(str, Integer.valueOf(currentStepIndex), fromString, viewReference));
            }
        }
        return linkedHashSet;
    }

    public final List<ElementInfoAndViewRef> getMatchingElementsIfExist(final List<ActivationManager.Trigger> triggerList, HashSet<View> roots, final JSONObject path) {
        Intrinsics.checkNotNullParameter(triggerList, "triggerList");
        Intrinsics.checkNotNullParameter(roots, "roots");
        Intrinsics.checkNotNullParameter(path, "path");
        final ArrayList arrayList = new ArrayList();
        if (o0.a(o0.f1142a, roots, false, new OnElementInScreenFoundListener() { // from class: sdk.pendo.io.actions.GuideActivationHelper$getMatchingElementsIfExist$1
            /* JADX WARN: Removed duplicated region for block: B:17:0x0042 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0012 A[SYNTHETIC] */
            @Override // sdk.pendo.io.listeners.views.OnElementInScreenFoundListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onViewFound(org.json.JSONObject r9, java.lang.ref.WeakReference<android.view.View> r10) {
                /*
                    r8 = this;
                    java.lang.String r0 = "retroElementInfo"
                    java.lang.String r1 = "viewAsJson"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
                    java.lang.String r1 = "viewRef"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
                    java.util.List<sdk.pendo.io.actions.ActivationManager$Trigger> r1 = r1
                    java.util.Iterator r1 = r1.iterator()
                L12:
                    boolean r2 = r1.hasNext()
                    if (r2 == 0) goto L88
                    java.lang.Object r2 = r1.next()
                    sdk.pendo.io.actions.ActivationManager$Trigger r2 = (sdk.pendo.io.actions.ActivationManager.Trigger) r2
                    r3 = 0
                    org.json.JSONObject r4 = r9.getJSONObject(r0)     // Catch: java.lang.Exception -> L79
                    org.json.JSONObject r5 = r2     // Catch: java.lang.Exception -> L79
                    r5.put(r0, r4)     // Catch: java.lang.Exception -> L79
                    sdk.pendo.io.models.StepLocationModel r5 = r2.getLocation()     // Catch: java.lang.Exception -> L79
                    if (r5 == 0) goto L33
                    java.lang.String r5 = r5.getFeatureSelector()     // Catch: java.lang.Exception -> L79
                    goto L34
                L33:
                    r5 = 0
                L34:
                    if (r5 == 0) goto L3f
                    boolean r5 = kotlin.text.StringsKt.isBlank(r5)     // Catch: java.lang.Exception -> L79
                    if (r5 == 0) goto L3d
                    goto L3f
                L3d:
                    r5 = r3
                    goto L40
                L3f:
                    r5 = 1
                L40:
                    if (r5 != 0) goto L12
                    sdk.pendo.io.actions.GuideActivationHelper r5 = r3     // Catch: java.lang.Exception -> L79
                    org.json.JSONObject r6 = r2     // Catch: java.lang.Exception -> L79
                    java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L79
                    java.lang.String r7 = "toString(...)"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch: java.lang.Exception -> L79
                    sdk.pendo.io.n1.b r5 = r5.jsonPathParse(r6)     // Catch: java.lang.Exception -> L79
                    sdk.pendo.io.models.StepLocationModel r6 = r2.getLocation()     // Catch: java.lang.Exception -> L79
                    java.lang.String r6 = r6.getFeatureSelector()     // Catch: java.lang.Exception -> L79
                    sdk.pendo.io.n1.l[] r7 = new sdk.pendo.io.n1.l[r3]     // Catch: java.lang.Exception -> L79
                    java.lang.Object r5 = r5.a(r6, r7)     // Catch: java.lang.Exception -> L79
                    sdk.pendo.io.b2.a r5 = (sdk.pendo.io.b2.a) r5     // Catch: java.lang.Exception -> L79
                    if (r5 == 0) goto L12
                    int r5 = r5.size()     // Catch: java.lang.Exception -> L79
                    if (r5 <= 0) goto L12
                    java.util.ArrayList<sdk.pendo.io.actions.ElementInfoAndViewRef> r5 = r4     // Catch: java.lang.Exception -> L79
                    sdk.pendo.io.actions.ElementInfoAndViewRef r6 = new sdk.pendo.io.actions.ElementInfoAndViewRef     // Catch: java.lang.Exception -> L79
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch: java.lang.Exception -> L79
                    r6.<init>(r4, r10, r2)     // Catch: java.lang.Exception -> L79
                    r5.add(r6)     // Catch: java.lang.Exception -> L79
                    goto L12
                L79:
                    r2 = move-exception
                    java.lang.String r4 = r2.getMessage()
                    if (r4 != 0) goto L82
                    java.lang.String r4 = "getRetroElementInfoMatchingSelector"
                L82:
                    java.lang.Object[] r3 = new java.lang.Object[r3]
                    sdk.pendo.io.logging.PendoLogger.w(r2, r4, r3)
                    goto L12
                L88:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.actions.GuideActivationHelper$getMatchingElementsIfExist$1.onViewFound(org.json.JSONObject, java.lang.ref.WeakReference):void");
            }
        }, 2, null) == null) {
            return null;
        }
        return arrayList;
    }

    public final JSONObject getObjectDataForScreen(JSONObject screenData) {
        Intrinsics.checkNotNullParameter(screenData, "screenData");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(ActivationManager.SCREEN_DATA_KEY, screenData);
        jSONObject.put(ActivationManager.SCREEN_DATA_KEY, jSONObject2);
        return jSONObject;
    }

    public final JSONObject getObjectDataForScreenAndElement(JSONObject screenData, JSONObject elementInfo) {
        Intrinsics.checkNotNullParameter(screenData, "screenData");
        Intrinsics.checkNotNullParameter(elementInfo, "elementInfo");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put(ActivationManager.SCREEN_DATA_KEY, screenData);
        jSONObject.put(ActivationManager.SCREEN_DATA_KEY, jSONObject2);
        jSONObject3.put("retroElementInfo", elementInfo);
        jSONObject.put("retroElementInfo", jSONObject3);
        return jSONObject;
    }

    public final JSONObject getObjectDataForTrackEvent(JSONObject trackEventJSON) {
        Intrinsics.checkNotNullParameter(trackEventJSON, "trackEventJSON");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ActivationManager.TRACK_EVENT_KEY, trackEventJSON);
        return jSONObject;
    }

    public final boolean isFeatureSelectorMatch(JSONObject objectData, String featureSelector) {
        return isSelectorMatch(objectData, "retroElementInfo", featureSelector);
    }

    public final boolean isGuideTriggerMatchSelector(ActivationManager.Trigger trigger, JSONObject objectData) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        String event = trigger.getActivation().getEvent();
        if (Intrinsics.areEqual(event, ActivationManager.ActivationEvents.APP_LAUNCH.getActivationEvent()) ? true : Intrinsics.areEqual(event, ActivationManager.ActivationEvents.ANY.getActivationEvent())) {
            return true;
        }
        if (Intrinsics.areEqual(event, ActivationManager.ActivationEvents.TRACK_EVENT.getActivationEvent())) {
            return isTrackSelectorMatch(objectData, trigger.getActivation().getTrackSelector());
        }
        if (Intrinsics.areEqual(event, ActivationManager.ActivationEvents.VIEW.getActivationEvent())) {
            return isGuideMatchesPageOrView(trigger, objectData);
        }
        if (Intrinsics.areEqual(event, ActivationManager.ActivationEvents.CLICK.getActivationEvent())) {
            return isPageSelectorMatch(objectData, trigger.getActivation().getPageSelector()) && isFeatureSelectorMatch(objectData, trigger.getActivation().getFeatureSelector());
        }
        PendoLogger.i("isStepTriggerMatch -> unknown activation event", new Object[0]);
        return false;
    }

    public final boolean isPageSelectorMatch(JSONObject objectData, String pageSelector) {
        return isSelectorMatch(objectData, ActivationManager.SCREEN_DATA_KEY, pageSelector);
    }

    public final boolean isTrackSelectorMatch(JSONObject objectData, String trackSelector) {
        return isSelectorMatch(objectData, ActivationManager.TRACK_EVENT_KEY, trackSelector);
    }

    public final b jsonPathParse(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        b a2 = g.a(this.conf).a(jsonString);
        Intrinsics.checkNotNullExpressionValue(a2, "parse(...)");
        return a2;
    }

    public final String showGuide(List<Quadruple<String, Integer, ActivationManager.ActivationEvents, WeakReference<View>>> guideCandidatesList, WeakReference<View> guideTriggeredByView) {
        Intrinsics.checkNotNullParameter(guideCandidatesList, "guideCandidatesList");
        return guideCandidatesList.isEmpty() ^ true ? GuidesManager.INSTANCE.show(guideCandidatesList, guideTriggeredByView) : "";
    }
}
