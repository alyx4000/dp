package com.quantummetric.ui.internal;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
final class bq extends dg {
    static boolean A = true;
    static boolean B = true;
    static int C = 6;
    private static boolean G = true;
    boolean E;
    private int I;
    private int J;
    private int K;
    private int L;
    static List<String> D = new ArrayList();
    private static List<a> H = new ArrayList();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        int f131a;
        String b;
        String c;
        String d;

        a(JSONObject jSONObject) {
            this.f131a = jSONObject.optInt("event_id");
            this.b = jSONObject.optString("id");
            this.c = jSONObject.optString("class");
            this.d = jSONObject.optString("page_regex");
        }
    }

    public bq(View view) {
        super(view);
        this.E = false;
        this.I = 0;
        this.J = 0;
        this.K = 3;
        this.L = 0;
    }

    static int a(View view) {
        for (a aVar : H) {
            boolean equals = !de.b(aVar.b) ? aVar.b.equals(de.a(view)) : true;
            if (equals && !de.b(aVar.c)) {
                equals = aVar.c.equals(view.getClass().getSimpleName());
            }
            if (equals && !de.b(aVar.d)) {
                equals = e.a().a(aVar.d, true);
            }
            if (equals) {
                return aVar.f131a;
            }
        }
        return 0;
    }

    static void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            G = jSONObject.optBoolean("ccs_animation", G);
            A = jSONObject.optBoolean("enabled", A);
            B = jSONObject.optBoolean("lrs_enabled", B);
            C = jSONObject.optInt("lrs_threshold_sec", C);
            D = y.a(jSONObject, "block_lrs");
            H.clear();
            JSONArray optJSONArray = jSONObject.optJSONArray("spinner_timing");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        a aVar = new a(optJSONObject);
                        if (aVar.f131a != 0) {
                            H.add(aVar);
                        }
                    }
                }
            }
            if (A) {
                return;
            }
            G = false;
        }
    }

    private static int b(View view) {
        int i = 0;
        try {
            TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(new TypedValue().data, new int[]{R.attr.colorAccent});
            i = obtainStyledAttributes.getColor(0, 0);
            obtainStyledAttributes.recycle();
            return i;
        } catch (Throwable unused) {
            return i;
        }
    }

    @Override // com.quantummetric.ui.internal.dg, com.quantummetric.ui.internal.b
    public final void a(ar arVar) {
        d(arVar);
        if (this.E) {
            arVar.a((ar) "<div id=\"").a((ar) (com.quantummetric.ui.internal.a.d(this.f) + "-inner")).a((ar) "\"class=\"pb\" style=\"");
            f(arVar);
            arVar.a((ar) "\"></div>");
        }
    }

    @Override // com.quantummetric.ui.internal.dg
    protected final void a(bp bpVar) {
        super.a(bpVar);
        View view = this.F.get();
        if (A && !this.w && (view instanceof ProgressBar)) {
            ProgressBar progressBar = (ProgressBar) view;
            boolean isIndeterminate = progressBar.isIndeterminate();
            Drawable indeterminateDrawable = isIndeterminate ? progressBar.getIndeterminateDrawable() : progressBar.getProgressDrawable();
            if (indeterminateDrawable != null && indeterminateDrawable.isVisible() && de.b(this.d)) {
                if (isIndeterminate && this.E) {
                    return;
                }
                bpVar.a((da) this.e, indeterminateDrawable, this.d, new h<String>() { // from class: com.quantummetric.instrument.internal.bq.1
                    @Override // com.quantummetric.ui.internal.h
                    public final /* bridge */ /* synthetic */ void a(String str) {
                        bq.this.a(str);
                    }
                });
            }
        }
    }

    final void f(ar arVar) {
        int i = this.j - this.I;
        int i2 = this.k - this.J;
        int min = Math.min(i, i2);
        int i3 = (this.j - min) / 2;
        int i4 = (this.k - min) / 2;
        if (i2 * i <= 0) {
            min = 0;
        }
        arVar.f65a.append(aa.ad).append(":").append(Integer.valueOf(min)).append(";");
        arVar.f65a.append(aa.ac).append(":").append(Integer.valueOf(min)).append(";");
        if (i > 0) {
            int round = Math.round(min / 10);
            if (round > this.K) {
                this.K = round;
            }
            String str = aa.ag;
            arVar.f65a.append(str).append(":").append(Integer.valueOf(i3)).append(aa.f).append(";");
            String str2 = aa.ah;
            arVar.f65a.append(str2).append(":").append(Integer.valueOf(i4)).append(aa.f).append(";");
            arVar.f65a.append("border").append(":").append((Object) (this.K + "px solid #f3f3f3")).append(";");
            arVar.f65a.append("border-top").append(":").append((Object) (this.K + "px solid " + de.b(this.L))).append(";");
        }
    }

    @Override // com.quantummetric.ui.internal.dg, com.quantummetric.ui.internal.b
    public final void j() {
        super.j();
        View view = this.F.get();
        if (G && (view instanceof ProgressBar)) {
            ProgressBar progressBar = (ProgressBar) view;
            boolean isIndeterminate = progressBar.isIndeterminate();
            this.E = isIndeterminate;
            if (isIndeterminate) {
                this.I = de.b(view.getPaddingLeft() + view.getPaddingRight());
                this.J = de.b(view.getPaddingTop() + view.getPaddingBottom());
                ColorStateList indeterminateTintList = progressBar.getIndeterminateTintList();
                if (indeterminateTintList != null) {
                    this.L = indeterminateTintList.getDefaultColor();
                }
                if (this.L == 0) {
                    this.L = b(view);
                }
            }
        }
    }
}
