package com.quantummetric.ui.internal;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import android.util.Range;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.facebook.react.uimanager.ViewProps;
import com.quantummetric.ui.internal.af;
import com.quantummetric.ui.internal.cj;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.actions.configurations.GuideTransition;

/* loaded from: classes5.dex */
final class ck extends dg implements cj.a {
    private static WeakReference<LinkedHashMap> G;
    String[] A;
    String B;
    String C;
    int D;
    int E;
    private String H;
    private int I;
    private int J;
    private Typeface K;
    private int L;
    private int M;
    private float N;
    private int O;
    private boolean P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private Drawable[] U;
    private Drawable V;
    private Drawable W;
    private int X;
    private String Y;
    private boolean Z;
    private a aa;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        List<b> f170a = new ArrayList();
        Map<Range<Integer>, List<b>> b = new LinkedHashMap();

        a() {
        }

        static void a(ar arVar, Range<Integer> range, char[] cArr) {
            if (range.getLower().intValue() < 0 || cArr.length < range.getUpper().intValue()) {
                return;
            }
            for (int intValue = range.getLower().intValue(); intValue < range.getUpper().intValue(); intValue++) {
                char c = cArr[intValue];
                arVar.a((ar) (c == '\n' ? "</br>" : Character.valueOf(c)));
            }
        }

        static boolean a(Object obj) {
            return (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof StyleSpan) || (obj instanceof UnderlineSpan) || (obj instanceof SuperscriptSpan) || (obj instanceof StrikethroughSpan);
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        Range<Integer> f171a;
        int b;
        boolean c;
        float d;
        int e;
        boolean f;
        boolean g;
        boolean h;

        b(int i, int i2, Object obj, ck ckVar) {
            this.d = -1.0f;
            this.e = 0;
            this.f171a = Range.create(Integer.valueOf(i), Integer.valueOf(i2));
            if (obj instanceof ForegroundColorSpan) {
                this.b = ((ForegroundColorSpan) obj).getForegroundColor();
                this.c = true;
                return;
            }
            if (obj instanceof RelativeSizeSpan) {
                this.d = ((RelativeSizeSpan) obj).getSizeChange() * cj.a(ckVar);
                return;
            }
            if (obj instanceof StyleSpan) {
                this.e = ((StyleSpan) obj).getStyle();
                return;
            }
            if (obj instanceof UnderlineSpan) {
                this.f = true;
            } else if (obj instanceof SuperscriptSpan) {
                this.h = true;
            } else if (obj instanceof StrikethroughSpan) {
                this.g = true;
            }
        }
    }

    ck(View view) {
        super(view);
        this.H = "";
        this.Z = ag.e(view);
    }

    private void a(Drawable drawable, ar arVar) {
        StringBuilder append;
        if (this.V == null) {
            if (this.X != 0) {
                arVar.a(aa.X, Integer.valueOf(this.X), aa.f, this.U[0] != null).a(aa.aa, Integer.valueOf(this.X), aa.f, this.U[1] != null).a(aa.Z, Integer.valueOf(this.X), aa.f, this.U[2] != null).a(aa.Y, Integer.valueOf(this.X), aa.f, this.U[3] != null);
            }
        } else if (this.Q != 0) {
            arVar.f65a.append(aa.X).append(":").append(Integer.valueOf(this.Q)).append(aa.f).append(";");
        }
        if (this.W != null && this.P && this.S > 0) {
            arVar.f65a.append(aa.Z).append(":").append(Integer.valueOf(this.Q)).append(aa.f).append(";");
        }
        if (ag.n(this.F.get())) {
            arVar.f65a.append(aa.ae).append(":").append((Object) "auto").append(";");
            append = arVar.f65a.append(aa.af).append(":").append((Object) "100%");
        } else {
            arVar.f65a.append(aa.af).append(":").append(Integer.valueOf(de.b(drawable.getIntrinsicWidth()))).append(aa.f).append(";");
            append = arVar.f65a.append(aa.ae).append(":").append(Integer.valueOf(de.b(drawable.getIntrinsicHeight()))).append(aa.f);
        }
        append.append(";");
    }

    private void a(Drawable drawable, String str, ar arVar) {
        String str2;
        if (de.b(str)) {
            str2 = "<img/>";
        } else {
            arVar.a((ar) "<img src=\"").a((ar) str).a((ar) "\" style=\"");
            a(drawable, arVar);
            str2 = "\">";
        }
        arVar.a((ar) str2);
    }

    static boolean a(View view) {
        if (view instanceof TextView) {
            return (view instanceof CheckBox) || (view instanceof RadioButton) || (view instanceof CheckedTextView) || ag.j(view);
        }
        return false;
    }

    @Override // com.quantummetric.ui.internal.dg, com.quantummetric.ui.internal.b
    public final void a(ar arVar) {
        if (this.w) {
            super.a(arVar);
        }
        cj.a((com.quantummetric.ui.internal.b) this, arVar);
    }

    @Override // com.quantummetric.ui.internal.dg
    protected final void a(bp bpVar) {
        super.a(bpVar);
        final int i = 0;
        if (!(this.e != null && ((cz) this.e).q) || bpVar == null) {
            return;
        }
        final cz czVar = (cz) this.e;
        if (this.V != null && (this.k > 0 || this.j > 0)) {
            bpVar.a(czVar, this.V, null, new h<String>() { // from class: com.quantummetric.instrument.internal.ck.1
                @Override // com.quantummetric.ui.internal.h
                public final /* bridge */ /* synthetic */ void a(String str) {
                    String str2 = str;
                    ck.this.B = str2;
                    czVar.y = str2;
                }
            });
        }
        Drawable drawable = this.W;
        if (drawable != null) {
            bpVar.a(czVar, drawable, null, new h<String>() { // from class: com.quantummetric.instrument.internal.ck.2
                @Override // com.quantummetric.ui.internal.h
                public final /* bridge */ /* synthetic */ void a(String str) {
                    String str2 = str;
                    ck.this.C = str2;
                    czVar.z = str2;
                }
            });
        }
        while (true) {
            Drawable[] drawableArr = this.U;
            if (i >= drawableArr.length) {
                return;
            }
            Drawable drawable2 = drawableArr[i];
            if (drawable2 != null) {
                bpVar.a(czVar, drawable2, null, new h<String>() { // from class: com.quantummetric.instrument.internal.ck.3
                    @Override // com.quantummetric.ui.internal.h
                    public final /* bridge */ /* synthetic */ void a(String str) {
                        String str2 = str;
                        ck.this.A[i] = str2;
                        czVar.x[i] = str2;
                    }
                });
            }
            i++;
        }
    }

    @Override // com.quantummetric.ui.internal.dg
    final boolean a(Drawable drawable) {
        return !this.Z && super.a(drawable);
    }

    @Override // com.quantummetric.instrument.internal.cj.a
    public final ar f(ar arVar) {
        StringBuilder append;
        String str;
        String str2;
        String str3;
        ar a2 = cj.a((cj.a) this, arVar);
        bz.a();
        a2.a("font-family", bz.a(this.Y), !TextUtils.isEmpty(this.Y)).a("line-height", Integer.valueOf(this.O), aa.f, this.O > 0).a(GuideTransition.GUIDE_TRANSITION_DIRECTION_FIELD, "rtl", this.P).a("border-bottom", "solid " + de.b(this.M) + "1px", this.M != 0);
        if (this.L != 0) {
            arVar.a(aa.Q, aa.R, (this.L & 1) != 0);
            arVar.a(aa.S, aa.T, (this.L & 2) != 0);
        }
        if (this.F.get() != null) {
            int paintFlags = ((TextView) this.F.get()).getPaintFlags();
            if ((paintFlags & 16) == 16) {
                str2 = aa.U;
                str3 = aa.V;
            } else if ((paintFlags & 8) == 8) {
                str2 = aa.U;
                str3 = aa.W;
            }
            arVar.f65a.append(str2).append(":").append((Object) str3).append(";");
        }
        if (this.j > 0 && this.k > this.j * 3 && this.H.length() > 2 && this.k < de.b(de.b() / 2.0f) && this.j < de.b(de.a() / 2.0f)) {
            arVar.f65a.append("writing-mode").append(":").append((Object) "vertical-lr").append(";");
            arVar.f65a.append(ViewProps.TRANSFORM).append(":").append((Object) "rotate(180deg)").append(";");
        }
        if (this.e != null && ((cz) this.e).q) {
            Drawable[] drawableArr = this.U;
            if (drawableArr[0] != null || drawableArr[2] != null) {
                append = arVar.f65a.append("flex-direction").append(":");
                str = "row";
            } else if (drawableArr[1] != null || drawableArr[3] != null) {
                append = arVar.f65a.append("flex-direction").append(":");
                str = "column";
            }
            append.append((Object) str).append(";");
        }
        return arVar;
    }

    @Override // com.quantummetric.instrument.internal.cj.a
    public final void g(ar arVar) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        if (!(this.e != null && ((cz) this.e).q)) {
            if (this.e != null) {
                cj.a(this.H, (cz) this.e, arVar, this.aa);
                return;
            }
            return;
        }
        Drawable drawable5 = this.V;
        if (drawable5 != null) {
            a(drawable5, this.B, arVar);
        }
        boolean z = this.P;
        if (z || (drawable4 = this.U[0]) == null) {
            Drawable[] drawableArr = this.U;
            Drawable drawable6 = drawableArr[1];
            if (drawable6 != null) {
                a(drawable6, this.A[1], arVar);
            } else if (z && (drawable = drawableArr[2]) != null) {
                a(drawable, this.A[2], arVar);
            }
        } else {
            a(drawable4, this.A[0], arVar);
        }
        if (this.e != null) {
            cj.a(this.H, (cz) this.e, arVar, this.aa);
        }
        boolean z2 = this.P;
        if (!z2 && (drawable3 = this.U[2]) != null) {
            a(drawable3, this.A[2], arVar);
            return;
        }
        Drawable[] drawableArr2 = this.U;
        Drawable drawable7 = drawableArr2[3];
        if (drawable7 != null) {
            a(drawable7, this.A[3], arVar);
            return;
        }
        Drawable drawable8 = this.W;
        if (drawable8 != null) {
            a(drawable8, this.C, arVar);
        } else {
            if (!z2 || (drawable2 = drawableArr2[0]) == null) {
                return;
            }
            a(drawable2, this.A[0], arVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:214:0x017e, code lost:
    
        if (r9 != 2) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fd, code lost:
    
        if (com.quantummetric.instrument.internal.bz.b.a(r8) != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0152, code lost:
    
        if ((r9.getCurrent() instanceof android.graphics.drawable.NinePatchDrawable) != false) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:200:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x021a  */
    @Override // com.quantummetric.ui.internal.dg, com.quantummetric.ui.internal.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j() {
        /*
            Method dump skipped, instructions count: 970
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.ck.j():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0227 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012e  */
    @Override // com.quantummetric.ui.internal.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void l() {
        /*
            Method dump skipped, instructions count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.ck.l():void");
    }

    @Override // com.quantummetric.ui.internal.b
    public final void m() {
        af.k b2;
        int ellipsisCount;
        super.m();
        View view = this.F.get();
        if (view != null) {
            TextView textView = (TextView) view;
            if (this.e != null && ((cz) this.e).r) {
                this.H = textView.getHint().toString();
            } else if (textView.getText() != null) {
                this.H = textView.getText().toString();
                cz czVar = (cz) this.e;
                if (czVar != null && czVar.w == 0 && this.H.length() > 0) {
                    czVar.w = de.a(textView.getText());
                    if (czVar.v) {
                        if (af.f26a == null) {
                            af.f26a = new af();
                        }
                        af afVar = af.f26a;
                        String a2 = de.a((View) textView);
                        if (!de.b(a2) && (b2 = afVar.b(a2)) != null) {
                            b2.a(textView.getText(), czVar);
                        }
                    }
                }
            }
            this.P = textView.getLayoutDirection() == 1;
            TextUtils.TruncateAt ellipsize = textView.getEllipsize();
            if (ellipsize == null || !ellipsize.name().equals("END") || textView.getLayout() == null || (ellipsisCount = textView.getLayout().getEllipsisCount(textView.getLineCount() - 1)) <= 0) {
                return;
            }
            String obj = textView.getText().subSequence(0, textView.getText().length() - ellipsisCount).toString();
            if (de.b(obj)) {
                return;
            }
            this.H = obj + "…";
        }
    }

    @Override // com.quantummetric.instrument.internal.cj.a
    public final int t() {
        return this.D;
    }

    @Override // com.quantummetric.instrument.internal.cj.a
    public final float u() {
        return this.N;
    }

    @Override // com.quantummetric.instrument.internal.cj.a
    public final String v() {
        return this.H;
    }
}
