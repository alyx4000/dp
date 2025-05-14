package sdk.pendo.io.sdk.react;

import androidx.exifinterface.media.ExifInterface;
import com.amplitude.reactnative.DatabaseConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tJ:\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000bj\b\u0012\u0004\u0012\u00020\u0005`\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fJ6\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\u0006\b\u0000\u0010\u0011\u0018\u00012\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0086\b¢\u0006\u0002\u0010\u0014¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/sdk/react/PlatformStateManagerRNHelper;", "", "()V", "populateClickableElements", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "clickableElementsArray", "", "populateRootTags", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "rnRootTags", "rnInfo", "", "verifyTypeAndGetValue", ExifInterface.GPS_DIRECTION_TRUE, "map", DatabaseConstants.KEY_FIELD, "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Object;", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PlatformStateManagerRNHelper {
    public static final String BOTTOM_BAR_TAG = "bottomBarTag";
    public static final String BOTTOM_SHEET_TAGS = "bottomSheetTags";
    public static final String MATERIAL_BOTTOM_BAR_TAG = "materialBottomTabTag";
    public static final String NATIVE_TAG = "nativeTag";
    public static final String NAVIGATION_BAR_TAG = "navigationBarTag";
    public static final String ON_PRESS_ACTION = "onPressAction";
    public static final String TAB_BAR_TAG = "tabBarTag";
    private static final String TAG = "PlatformStateManagerRNHelper";

    public final HashMap<Integer, String> populateClickableElements(List<? extends Object> clickableElementsArray) {
        Double d;
        Intrinsics.checkNotNullParameter(clickableElementsArray, "clickableElementsArray");
        HashMap<Integer, String> hashMap = new HashMap<>();
        try {
            for (Object obj : clickableElementsArray) {
                String str = null;
                Map map = obj instanceof Map ? (Map) obj : null;
                if (map != null && map.containsKey(NATIVE_TAG) && (map.get(NATIVE_TAG) instanceof Double)) {
                    Object obj2 = map.get(NATIVE_TAG);
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                    }
                    d = (Double) obj2;
                } else {
                    d = null;
                }
                Map map2 = obj instanceof Map ? (Map) obj : null;
                if (map2 != null && map2.containsKey(ON_PRESS_ACTION) && (map2.get(ON_PRESS_ACTION) instanceof String)) {
                    Object obj3 = map2.get(ON_PRESS_ACTION);
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    str = (String) obj3;
                }
                if (d != null && str != null) {
                    hashMap.put(Integer.valueOf((int) d.doubleValue()), str);
                }
            }
        } catch (Exception e) {
            PendoLogger.w(TAG, e.getMessage());
        }
        return hashMap;
    }

    public final HashSet<Integer> populateRootTags(List<Integer> rnRootTags, Map<String, ? extends Object> rnInfo) {
        Double d;
        Double d2;
        Double d3;
        Double d4;
        Intrinsics.checkNotNullParameter(rnRootTags, "rnRootTags");
        HashSet<Integer> hashSet = new HashSet<>(rnRootTags);
        if (rnInfo != null) {
            ArrayList arrayList = null;
            if (rnInfo.containsKey(NAVIGATION_BAR_TAG) && (rnInfo.get(NAVIGATION_BAR_TAG) instanceof Double)) {
                Object obj = rnInfo.get(NAVIGATION_BAR_TAG);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                }
                d = (Double) obj;
            } else {
                d = null;
            }
            if (d != null) {
                hashSet.add(Integer.valueOf((int) d.doubleValue()));
            }
            if (rnInfo.containsKey(BOTTOM_BAR_TAG) && (rnInfo.get(BOTTOM_BAR_TAG) instanceof Double)) {
                Object obj2 = rnInfo.get(BOTTOM_BAR_TAG);
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                }
                d2 = (Double) obj2;
            } else {
                d2 = null;
            }
            if (d2 != null) {
                hashSet.add(Integer.valueOf((int) d2.doubleValue()));
            }
            if (rnInfo.containsKey(TAB_BAR_TAG) && (rnInfo.get(TAB_BAR_TAG) instanceof Double)) {
                Object obj3 = rnInfo.get(TAB_BAR_TAG);
                if (obj3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                }
                d3 = (Double) obj3;
            } else {
                d3 = null;
            }
            if (d3 != null) {
                hashSet.add(Integer.valueOf((int) d3.doubleValue()));
            }
            if (rnInfo.containsKey(MATERIAL_BOTTOM_BAR_TAG) && (rnInfo.get(MATERIAL_BOTTOM_BAR_TAG) instanceof Double)) {
                Object obj4 = rnInfo.get(MATERIAL_BOTTOM_BAR_TAG);
                if (obj4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                }
                d4 = (Double) obj4;
            } else {
                d4 = null;
            }
            if (d4 != null) {
                hashSet.add(Integer.valueOf((int) d4.doubleValue()));
            }
            if (rnInfo.containsKey(BOTTOM_SHEET_TAGS) && (rnInfo.get(BOTTOM_SHEET_TAGS) instanceof ArrayList)) {
                Object obj5 = rnInfo.get(BOTTOM_SHEET_TAGS);
                if (obj5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<kotlin.Double>");
                }
                arrayList = (ArrayList) obj5;
            }
            if (arrayList != null) {
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Boolean.valueOf(hashSet.add(Integer.valueOf((int) ((Number) it.next()).doubleValue()))));
                }
            }
        }
        return hashSet;
    }

    public final /* synthetic */ <T> T verifyTypeAndGetValue(Map<String, ? extends Object> map, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (map == null || !map.containsKey(key)) {
            return null;
        }
        Object obj = map.get(key);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (!(obj instanceof Object)) {
            return null;
        }
        T t = (T) map.get(key);
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }
}
