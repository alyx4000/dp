package sdk.pendo.io.f9;

import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import io.sentry.protocol.Request;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntProgression;
import org.json.JSONArray;
import org.json.JSONObject;
import sdk.pendo.io.events.IdentificationData;
import sdk.pendo.io.g9.m0;
import sdk.pendo.io.g9.o0;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.sdk.react.PlatformStateManager;
import sdk.pendo.io.views.custom.PendoFloatingVisualGuideView;
import sdk.pendo.io.views.listener.FloatingListenerButton;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002\f BG\u0012\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*\u0012\u0006\u00101\u001a\u00020/\u0012\u0006\u00103\u001a\u00020\u0014\u0012\u0006\u00105\u001a\u00020\u0014\u0012\u0006\u00107\u001a\u00020\u0014\u0012\u0006\u00109\u001a\u00020\u0014¢\u0006\u0004\b@\u0010AJ8\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J0\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J.\u0010\f\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u00182\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0003H\u0007J&\u0010\f\u001a\u00020\u000b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0019\u0010 \u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b \u0010!J'\u0010\f\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0000¢\u0006\u0004\b\f\u0010$J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tH\u0000¢\u0006\u0004\b\f\u0010%J\u001f\u0010 \u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0007H\u0000¢\u0006\u0004\b \u0010'J0\u0010\f\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00072\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*H\u0007J\u0017\u0010\f\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\f\u0010!J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\f\u0010,J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\f\u0010-R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010.R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u00100R\u0014\u00103\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u00102R\u0014\u00105\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00102R\u0014\u00107\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00102R\u0014\u00109\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00102RP\u0010?\u001a>\u0012\u0004\u0012\u00020\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020;0(j\b\u0012\u0004\u0012\u00020;`*0:j\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020;0(j\b\u0012\u0004\u0012\u00020;`*`<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lsdk/pendo/io/f9/h;", "", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "activityRef", "Landroid/view/View;", "currentRootViewData", "Lorg/json/JSONObject;", "screenData", "Lorg/json/JSONArray;", "textsWithElementsInfo", "", "a", "viewNullable", "", "discoverySet", "specialElementsJsonArray", "viewElement", "screenElementInfo", "view", "", "c", "", "selectedIndex", "", "viewType", "currentScreenId", "Lsdk/pendo/io/f9/h$a;", "activity", "", "rootViews", "childElements", "b", "(Landroid/view/View;)Z", "specialElementInfo", "specialElementChildJsonArray", "(Lorg/json/JSONObject;Lorg/json/JSONArray;Lorg/json/JSONArray;)Lorg/json/JSONArray;", "(Lorg/json/JSONObject;Lorg/json/JSONArray;)V", "element", "(Landroid/view/View;Lorg/json/JSONObject;)V", "Ljava/util/ArrayList;", "Lsdk/pendo/io/f9/d;", "Lkotlin/collections/ArrayList;", "fragmentsInfoList", "(Landroid/view/View;Lorg/json/JSONArray;)V", "(Lorg/json/JSONArray;Lorg/json/JSONObject;)V", "Ljava/util/ArrayList;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "viewPagerOnPageSelectedListener", "Z", "isRespondToScrollChangeEventsForScreenId", "d", "excludeNestedText", "e", "includeText", "f", "isForCapture", "Ljava/util/HashMap;", "Lsdk/pendo/io/f9/h$b;", "Lkotlin/collections/HashMap;", "g", "Ljava/util/HashMap;", "specialViewsMap", "<init>", "(Ljava/util/ArrayList;Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;ZZZZ)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<d> fragmentsInfoList;

    /* renamed from: b, reason: from kotlin metadata */
    private final ViewPager.OnPageChangeListener viewPagerOnPageSelectedListener;

    /* renamed from: c, reason: from kotlin metadata */
    private final boolean isRespondToScrollChangeEventsForScreenId;

    /* renamed from: d, reason: from kotlin metadata */
    private final boolean excludeNestedText;

    /* renamed from: e, reason: from kotlin metadata */
    private final boolean includeText;

    /* renamed from: f, reason: from kotlin metadata */
    private final boolean isForCapture;

    /* renamed from: g, reason: from kotlin metadata */
    private final HashMap<String, ArrayList<b>> specialViewsMap;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\t\u0012\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00110\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR3\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00110\u000e8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/f9/h$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lorg/json/JSONObject;", "a", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "screenDataJson", "", "Ljava/util/ArrayList;", "Lsdk/pendo/io/f9/h$b;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/Map;", "()Ljava/util/Map;", "specialViewMap", "<init>", "(Lorg/json/JSONObject;Ljava/util/Map;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final /* data */ class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final JSONObject screenDataJson;

        /* renamed from: b, reason: from kotlin metadata */
        private final Map<String, ArrayList<b>> specialViewMap;

        /* JADX WARN: Multi-variable type inference failed */
        public a(JSONObject screenDataJson, Map<String, ? extends ArrayList<b>> specialViewMap) {
            Intrinsics.checkNotNullParameter(screenDataJson, "screenDataJson");
            Intrinsics.checkNotNullParameter(specialViewMap, "specialViewMap");
            this.screenDataJson = screenDataJson;
            this.specialViewMap = specialViewMap;
        }

        /* renamed from: a, reason: from getter */
        public final JSONObject getScreenDataJson() {
            return this.screenDataJson;
        }

        public final Map<String, ArrayList<b>> b() {
            return this.specialViewMap;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            return Intrinsics.areEqual(this.screenDataJson, aVar.screenDataJson) && Intrinsics.areEqual(this.specialViewMap, aVar.specialViewMap);
        }

        public int hashCode() {
            return (this.screenDataJson.hashCode() * 31) + this.specialViewMap.hashCode();
        }

        public String toString() {
            return "ScreenData(screenDataJson=" + this.screenDataJson + ", specialViewMap=" + this.specialViewMap + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/f9/h$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "viewId", "lastKnownSelectedIndex", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "c", "Ljava/lang/ref/WeakReference;", "()Ljava/lang/ref/WeakReference;", "viewWeakRef", "<init>", "(IILjava/lang/ref/WeakReference;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final /* data */ class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int viewId;

        /* renamed from: b, reason: from kotlin metadata */
        private final int lastKnownSelectedIndex;

        /* renamed from: c, reason: from kotlin metadata */
        private final WeakReference<View> viewWeakRef;

        public b(int i, int i2, WeakReference<View> viewWeakRef) {
            Intrinsics.checkNotNullParameter(viewWeakRef, "viewWeakRef");
            this.viewId = i;
            this.lastKnownSelectedIndex = i2;
            this.viewWeakRef = viewWeakRef;
        }

        /* renamed from: a, reason: from getter */
        public final int getLastKnownSelectedIndex() {
            return this.lastKnownSelectedIndex;
        }

        /* renamed from: b, reason: from getter */
        public final int getViewId() {
            return this.viewId;
        }

        public final WeakReference<View> c() {
            return this.viewWeakRef;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            return this.viewId == bVar.viewId && this.lastKnownSelectedIndex == bVar.lastKnownSelectedIndex && Intrinsics.areEqual(this.viewWeakRef, bVar.viewWeakRef);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.viewId) * 31) + Integer.hashCode(this.lastKnownSelectedIndex)) * 31) + this.viewWeakRef.hashCode();
        }

        public String toString() {
            return "SpecialViewItem(viewId=" + this.viewId + ", lastKnownSelectedIndex=" + this.lastKnownSelectedIndex + ", viewWeakRef=" + this.viewWeakRef + ")";
        }
    }

    public h(ArrayList<d> fragmentsInfoList, ViewPager.OnPageChangeListener viewPagerOnPageSelectedListener, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(fragmentsInfoList, "fragmentsInfoList");
        Intrinsics.checkNotNullParameter(viewPagerOnPageSelectedListener, "viewPagerOnPageSelectedListener");
        this.fragmentsInfoList = fragmentsInfoList;
        this.viewPagerOnPageSelectedListener = viewPagerOnPageSelectedListener;
        this.isRespondToScrollChangeEventsForScreenId = z;
        this.excludeNestedText = z2;
        this.includeText = z3;
        this.isForCapture = z4;
        this.specialViewsMap = new HashMap<>();
    }

    private final boolean c(View view) {
        TextView d;
        if (view instanceof TextView) {
            return true;
        }
        return (!q0.k(view) || (d = q0.d(view)) == null || d.getText() == null) ? false : true;
    }

    public final void a(JSONObject screenData, Activity activity) {
        Intrinsics.checkNotNullParameter(screenData, "screenData");
        Intrinsics.checkNotNullParameter(activity, "activity");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("kind", "activity");
        screenData.put("name", activity.getClass().getSimpleName());
        screenData.put("info", jSONObject);
    }

    public final boolean b(View view) {
        if (view == null) {
            return true;
        }
        if (view instanceof PendoFloatingVisualGuideView) {
            PendoLogger.d("ScreenDataHelper", "View is of type PendoFloatingVisualGuideView, return from scan");
            return true;
        }
        if (!(view instanceof FloatingListenerButton)) {
            return false;
        }
        PendoLogger.d("ScreenDataHelper", "View is of type FloatingListenerButton, return from scan");
        return true;
    }

    public final void a(JSONArray specialElementChildJsonArray, JSONObject specialElementInfo) {
        Intrinsics.checkNotNullParameter(specialElementChildJsonArray, "specialElementChildJsonArray");
        Intrinsics.checkNotNullParameter(specialElementInfo, "specialElementInfo");
        if (specialElementChildJsonArray.length() > 0) {
            specialElementInfo.put("childViews", specialElementChildJsonArray);
        }
    }

    public final void b(View element, JSONObject screenElementInfo) {
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(screenElementInfo, "screenElementInfo");
        if (a(element, screenElementInfo, this.fragmentsInfoList)) {
            return;
        }
        a(element, screenElementInfo);
    }

    public final void a(JSONObject specialElementInfo, JSONArray specialElementsJsonArray) {
        Intrinsics.checkNotNullParameter(specialElementInfo, "specialElementInfo");
        Intrinsics.checkNotNullParameter(specialElementsJsonArray, "specialElementsJsonArray");
        if (specialElementInfo.has("name")) {
            specialElementsJsonArray.put(specialElementInfo);
        }
    }

    private final void a(View viewElement, int selectedIndex, String viewType) {
        if (viewElement.getId() == -1) {
            viewElement.setId(View.generateViewId());
        }
        b bVar = new b(viewElement.getId(), selectedIndex, new WeakReference(viewElement));
        if (!this.specialViewsMap.containsKey(viewType)) {
            ArrayList<b> arrayList = new ArrayList<>();
            arrayList.add(bVar);
            this.specialViewsMap.put(viewType, arrayList);
        } else {
            ArrayList<b> arrayList2 = this.specialViewsMap.get(viewType);
            if (arrayList2 != null) {
                arrayList2.add(bVar);
            }
        }
    }

    public final a a(String currentScreenId, WeakReference<Activity> activityRef, WeakReference<View> currentRootViewData) {
        Intrinsics.checkNotNullParameter(currentScreenId, "currentScreenId");
        Intrinsics.checkNotNullParameter(activityRef, "activityRef");
        JSONObject put = new JSONObject().put("retroactiveScreenId", currentScreenId);
        JSONArray jSONArray = new JSONArray();
        Intrinsics.checkNotNull(put);
        a(activityRef, currentRootViewData, put, jSONArray);
        put.put("texts", jSONArray);
        return new a(put, this.specialViewsMap);
    }

    public final JSONArray a(JSONObject specialElementInfo, JSONArray specialElementChildJsonArray, JSONArray specialElementsJsonArray) {
        Intrinsics.checkNotNullParameter(specialElementInfo, "specialElementInfo");
        Intrinsics.checkNotNullParameter(specialElementChildJsonArray, "specialElementChildJsonArray");
        Intrinsics.checkNotNullParameter(specialElementsJsonArray, "specialElementsJsonArray");
        return specialElementInfo.has("name") ? specialElementChildJsonArray : specialElementsJsonArray;
    }

    public final boolean a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return !q0.a(view, 0) || (PlatformStateManager.INSTANCE.isReactNativeAnalyticsEnabled() && view.getVisibility() != 0);
    }

    public final boolean a(View viewElement, JSONObject screenElementInfo, ArrayList<d> fragmentsInfoList) {
        Intrinsics.checkNotNullParameter(viewElement, "viewElement");
        Intrinsics.checkNotNullParameter(screenElementInfo, "screenElementInfo");
        Intrinsics.checkNotNullParameter(fragmentsInfoList, "fragmentsInfoList");
        Iterator<d> it = fragmentsInfoList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            d next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            d dVar = next;
            if (viewElement.hashCode() == dVar.getRootViewHashCode()) {
                JSONObject jSONObject = new JSONObject();
                screenElementInfo.put("name", dVar.getFragmentName());
                jSONObject.put("kind", Request.JsonKeys.FRAGMENT);
                screenElementInfo.put("info", jSONObject);
                it.remove();
                return true;
            }
        }
        return false;
    }

    private final void a(final View viewElement, JSONObject screenElementInfo) {
        int size;
        JSONObject jSONObject = new JSONObject();
        if (viewElement instanceof TabLayout) {
            jSONObject.put("kind", "TabLayout");
            TabLayout tabLayout = (TabLayout) viewElement;
            int selectedTabPosition = tabLayout.getSelectedTabPosition();
            if (this.includeText) {
                sdk.pendo.io.g9.m mVar = sdk.pendo.io.g9.m.f1138a;
                TabLayout.Tab tabAt = tabLayout.getTabAt(selectedTabPosition);
                jSONObject.put("selectedTitle", mVar.a(String.valueOf(tabAt != null ? tabAt.getText() : null)));
                if (this.isForCapture) {
                    TabLayout.Tab tabAt2 = tabLayout.getTabAt(selectedTabPosition);
                    jSONObject.put("selectedTitleText", m0.b(String.valueOf(tabAt2 != null ? tabAt2.getText() : null)));
                }
            }
            jSONObject.put("selectedIndex", selectedTabPosition);
            size = tabLayout.getTabCount();
            a(viewElement, selectedTabPosition, "TabLayout");
        } else if (viewElement instanceof ViewPager) {
            jSONObject.put("kind", "ViewPager");
            ViewPager viewPager = (ViewPager) viewElement;
            jSONObject.put("selectedIndex", viewPager.getCurrentItem());
            PagerAdapter adapter = viewPager.getAdapter();
            size = adapter != null ? adapter.getCount() : -1;
            if (!this.isRespondToScrollChangeEventsForScreenId) {
                viewElement.post(new Runnable() { // from class: sdk.pendo.io.f9.h$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.a(viewElement, this);
                    }
                });
            }
        } else {
            if (!(viewElement instanceof BottomNavigationView)) {
                return;
            }
            jSONObject.put("kind", "BottomNavigationView");
            BottomNavigationView bottomNavigationView = (BottomNavigationView) viewElement;
            int selectedItemId = bottomNavigationView.getSelectedItemId();
            if (this.includeText) {
                sdk.pendo.io.g9.m mVar2 = sdk.pendo.io.g9.m.f1138a;
                MenuItem findItem = bottomNavigationView.getMenu().findItem(selectedItemId);
                jSONObject.put("selectedTitle", mVar2.a(String.valueOf(findItem != null ? findItem.getTitle() : null)));
                if (this.isForCapture) {
                    MenuItem findItem2 = bottomNavigationView.getMenu().findItem(selectedItemId);
                    jSONObject.put("selectedTitleText", m0.b(String.valueOf(findItem2 != null ? findItem2.getTitle() : null)));
                }
            }
            jSONObject.put("selectedId", selectedItemId);
            size = bottomNavigationView.getMenu().size();
            a(viewElement, selectedItemId, "BottomNavigationView");
        }
        jSONObject.put("numberOfIndexes", size);
        screenElementInfo.put("name", viewElement.getClass().getSimpleName());
        screenElementInfo.put("info", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View viewElement, h this$0) {
        Intrinsics.checkNotNullParameter(viewElement, "$viewElement");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager viewPager = (ViewPager) viewElement;
        viewPager.removeOnPageChangeListener(this$0.viewPagerOnPageSelectedListener);
        viewPager.addOnPageChangeListener(this$0.viewPagerOnPageSelectedListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a(WeakReference<Activity> activityRef, WeakReference<View> currentRootViewData, JSONObject screenData, JSONArray textsWithElementsInfo) {
        JSONObject jSONObject;
        View view;
        T t;
        Activity activity = activityRef.get();
        if (activity == null) {
            PendoLogger.w("ScreenDataHelper -> ScreenManager retrieveScreenInfoAndTexts -> activity is null", new Object[0]);
            return;
        }
        a(screenData, activity);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        JSONArray jSONArray = new JSONArray();
        if (currentRootViewData == null || (view = currentRootViewData.get()) == null) {
            jSONObject = null;
        } else {
            PendoLogger.d("ScreenDataHelper -> retrieveScreenInfoAndTexts and add PendoTouchListeners", new Object[0]);
            PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
            if (platformStateManager.isReactNativeAnalyticsEnabled()) {
                t = platformStateManager.getReactRoots(view);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(view);
                t = hashSet;
            }
            objectRef.element = t;
            a((Set<? extends View>) t, textsWithElementsInfo, jSONArray);
            jSONObject = screenData.put("childViews", jSONArray);
        }
        if (jSONObject == null) {
            PendoLogger.w("ScreenDataHelper -> ScreenManager retrieveScreenInfoAndTexts -> current root view is null", new Object[0]);
        }
    }

    private final void a(View viewNullable, Set<View> discoverySet, JSONArray specialElementsJsonArray, JSONArray textsWithElementsInfo) {
        if (b(viewNullable)) {
            return;
        }
        Intrinsics.checkNotNull(viewNullable);
        if (a(viewNullable)) {
            o0.f1142a.a(viewNullable);
            return;
        }
        o0 o0Var = o0.f1142a;
        o0Var.d(viewNullable);
        a(viewNullable, textsWithElementsInfo);
        discoverySet.add(viewNullable);
        JSONObject jSONObject = new JSONObject();
        b(viewNullable, jSONObject);
        if (viewNullable instanceof ViewGroup) {
            JSONArray jSONArray = new JSONArray();
            ViewGroup viewGroup = (ViewGroup) viewNullable;
            if (viewGroup.getChildCount() > 0) {
                IntProgression a2 = o0Var.a(viewGroup);
                int first = a2.getFirst();
                int last = a2.getLast();
                int step = a2.getStep();
                if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                    while (true) {
                        View childAt = viewGroup.getChildAt(first);
                        if (!discoverySet.contains(childAt)) {
                            a(childAt, discoverySet, a(jSONObject, jSONArray, specialElementsJsonArray), textsWithElementsInfo);
                        }
                        if (first == last) {
                            break;
                        } else {
                            first += step;
                        }
                    }
                }
                a(jSONArray, jSONObject);
            }
        }
        a(jSONObject, specialElementsJsonArray);
    }

    public void a(Set<? extends View> rootViews, JSONArray textsWithElementsInfo, JSONArray childElements) {
        Intrinsics.checkNotNullParameter(rootViews, "rootViews");
        Intrinsics.checkNotNullParameter(textsWithElementsInfo, "textsWithElementsInfo");
        Intrinsics.checkNotNullParameter(childElements, "childElements");
        Iterator<T> it = rootViews.iterator();
        while (it.hasNext()) {
            a((View) it.next(), new LinkedHashSet(), childElements, textsWithElementsInfo);
        }
    }

    public final void a(View view, JSONArray textsWithElementsInfo) {
        boolean z;
        IdentificationData a2;
        String createRetroElementIdentifier;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(textsWithElementsInfo, "textsWithElementsInfo");
        if (c(view) && (z = this.includeText) && (createRetroElementIdentifier = (a2 = sdk.pendo.io.m8.b.a(view, Boolean.valueOf(z), Boolean.valueOf(this.excludeNestedText))).createRetroElementIdentifier()) != null) {
            PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
            if (platformStateManager.isNotReactNativeApp() || (platformStateManager.isReactNativeAnalyticsEnabled() && a2.getTextBase64() != null)) {
                textsWithElementsInfo.put(sdk.pendo.io.g9.m.f1138a.b(createRetroElementIdentifier));
            }
        }
    }
}
