package com.quantummetric.ui.internal;

import android.view.View;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
final class cc extends dg {
    static boolean A = true;
    static boolean B = false;
    static boolean C = false;
    private static int D;
    private static List<String> E = new ArrayList();

    cc(View view) {
        super(view);
    }

    static void a(JSONObject jSONObject) {
        E = y.a(jSONObject, "custom_scroll");
        A = jSONObject.optBoolean("scroll_divs", A);
        B = jSONObject.optBoolean("scroll_divs_lists", B);
        C = jSONObject.optBoolean("view_scroll_listener", C);
    }

    static boolean a(View view) {
        if (!c(view)) {
            if (!(ag.a(view) || (view instanceof AbsListView) || ag.b(view))) {
                return false;
            }
        }
        return true;
    }

    static boolean b(View view) {
        return ag.a(view) || (view instanceof AbsListView) || ag.b(view);
    }

    static boolean c(View view) {
        if (view != null) {
            return (view instanceof ScrollView) || (view instanceof HorizontalScrollView) || ag.g((Object) view) || ag.b(view) || E.contains(view.getClass().getSimpleName());
        }
        return false;
    }

    @Override // com.quantummetric.ui.internal.dg, com.quantummetric.ui.internal.b
    public final void a(ar arVar) {
        StringBuilder append;
        if (this.F.get() != null) {
            super.a(arVar);
            arVar.a((ar) "<div id=\"").a((ar) a.a(this.F.get())).a((ar) "\" style=\"");
            if (this.e instanceof cx) {
                if (((cx) this.e).z) {
                    append = arVar.f65a.append(ViewProps.OVERFLOW).append(":").append((Object) ViewProps.SCROLL);
                } else {
                    String str = aa.ag;
                    arVar.f65a.append(str).append(":").append(Integer.valueOf(de.b(-r0.s))).append(aa.f).append(";");
                    String str2 = aa.ah;
                    append = arVar.f65a.append(str2).append(":").append(Integer.valueOf(de.b(-r0.t))).append(aa.f);
                }
                append.append(";");
                if (D > 0 && this.j > D) {
                    arVar.f65a.append(aa.ad).append(":").append(Integer.valueOf((this.j - D) - 1)).append(";");
                }
            }
            arVar.a((ar) "\" class=\"s\">");
        }
    }

    @Override // com.quantummetric.ui.internal.dg, com.quantummetric.ui.internal.b
    public final void j() {
        super.j();
        if (this.F.get() != null) {
            D = de.b(r0.getPaddingRight());
        }
    }
}
