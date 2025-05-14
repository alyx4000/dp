package sdk.pendo.io.g9;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.protocol.Device;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import sdk.pendo.io.actions.GuideActionConfiguration;

/* loaded from: classes6.dex */
public class k0 {

    /* renamed from: a, reason: collision with root package name */
    private static final HashSet<String> f1136a = new HashSet<>(Arrays.asList(ViewProps.PADDING_BOTTOM, ViewProps.PADDING_LEFT, ViewProps.PADDING_RIGHT, ViewProps.PADDING_TOP, "layout_marginBottom", "layout_marginLeft", "layout_marginRight", "layout_marginTop", "layout_minWidth"));

    public static boolean a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof ViewGroup) && a((ViewGroup) childAt)) {
                return true;
            }
            if (childAt != null && childAt.isFocusable() && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public static String b(String str) {
        if (!str.endsWith("dp") && !str.endsWith("px")) {
            return null;
        }
        String replace = str.replace("dp", "").replace("px", "");
        if (sdk.pendo.io.q2.a.a(replace)) {
            return replace;
        }
        return null;
    }

    public static String a(String str) {
        int length;
        return (str.startsWith("#") && (length = str.length()) != 4 && length != 7 && length == 9) ? String.format("#%s%s", str.substring(7), str.substring(1, 7)) : str;
    }

    private static sdk.pendo.io.k0.f a(sdk.pendo.io.k0.f fVar) {
        sdk.pendo.io.k0.f fVar2 = new sdk.pendo.io.k0.f();
        fVar2.a(a("layout_width", "dimen", "wrap_content"));
        fVar2.a(a("layout_height", "dimen", "wrap_content"));
        fVar2.a(a(Device.JsonKeys.ORIENTATION, "string", "vertical"));
        fVar2.a(a("enabled", "boolean", Boolean.TRUE));
        Iterator<String> it = f1136a.iterator();
        while (it.hasNext()) {
            sdk.pendo.io.k0.l a2 = a(fVar, it.next());
            if (a2 != null) {
                fVar2.a(a2);
            }
        }
        return fVar2;
    }

    private static sdk.pendo.io.k0.l a(String str, String str2, Object obj) {
        sdk.pendo.io.k0.l lVar = new sdk.pendo.io.k0.l();
        lVar.a("name", str);
        lVar.a("type", str2);
        if (str2.contains("string") || str2.contains("dimen")) {
            lVar.a("value", (String) obj);
        } else if (str2.contains("boolean")) {
            lVar.a("value", (Boolean) obj);
        }
        return lVar;
    }

    public static ViewGroup a(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getRootView();
        if (viewGroup.getChildCount() > 0) {
            viewGroup = (ViewGroup) viewGroup.getChildAt(0);
        }
        if (viewGroup instanceof FrameLayout) {
            return viewGroup;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof FrameLayout) {
                return (ViewGroup) childAt;
            }
        }
        return viewGroup;
    }

    public static int a(String str, int i) {
        return sdk.pendo.io.q2.a.a(str) ? q0.a(Float.parseFloat(str)) : i;
    }

    public static sdk.pendo.io.k0.l a(sdk.pendo.io.k0.f fVar, String str) {
        if (fVar != null && fVar.size() != 0) {
            for (int i = 0; i < fVar.size(); i++) {
                sdk.pendo.io.k0.l e = fVar.a(i).e();
                sdk.pendo.io.k0.n c = e.c("name");
                if (c != null && str.contentEquals(c.g())) {
                    return e;
                }
            }
        }
        return null;
    }

    public static boolean a(Rect rect, Rect rect2) {
        return rect.contains(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    public static boolean a(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean((String) obj);
    }

    public static sdk.pendo.io.k0.l a(sdk.pendo.io.k0.l lVar, GuideActionConfiguration.VisualGuideType visualGuideType) {
        sdk.pendo.io.k0.l lVar2 = new sdk.pendo.io.k0.l();
        lVar2.a("properties", a(lVar.b("properties")));
        lVar2.a(GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS, lVar.b(GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS));
        lVar2.a("widget", "LinearLayout");
        lVar2.a("id", "insert_container");
        lVar2.a("scrollable", Boolean.valueOf(visualGuideType.equals(GuideActionConfiguration.VisualGuideType.BANNER)));
        return lVar2;
    }
}
