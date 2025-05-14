package com.quantummetric.ui.internal;

import android.view.View;

/* loaded from: classes5.dex */
final class ad {

    /* renamed from: a, reason: collision with root package name */
    private static String f25a = "";

    static String a() {
        return "iframe,div,.bi{position:absolute;width:calc(var(--w)*1px);height:calc(var(--h)*1px);background-color:var(--bc);--bc:rgb(0,0,0,0);border-radius:calc(var(--br,0)*1px);--br:0;display:var(--d,block);z-index:var(--z);--z:0;top:0px;left:0px;}div{box-sizing:border-box;}.p{overflow:hidden}.t{height:100%;width:100%;overflow:hidden;display:flex;position:relative;align-items:center;font-size:calc(var(--fs)*1px);}.wtc{color:rgb(255,255,255);}.btc{color:rgb(0,0,0);}.wbc{--bc:white;}.bbc{--bc:black;}.i{object-fit:contain;position:absolute;}div::-webkit-scrollbar{display:none;}.s{width:100%;height:100%;}.sl{white-space:nowrap}@-webkit-keyframes spin{0%{-webkit-transform:rotate(0deg);} 100%{-webkit-transform:rotate(360deg);}}.pb{-webkit-animation:spin 2s cubic-bezier(0.4, 0, 0.2, 1) infinite;border-radius:50%;}.tat{margin-bottom:auto;}.tavc{margin-bottom:auto;margin-top:auto}.tab{margin-top:auto;}.tal{margin-right:auto;text-align:left}.tahc{margin-right:auto;margin-left:auto;text-align:center}.tar{margin-left:auto;text-align:right;}@keyframes shimmer { to { background-position-x: 0% } }" + f25a;
    }

    static String a(View view) {
        ar arVar = new ar();
        a(view, arVar, 3, 0);
        return arVar.toString();
    }

    static String a(co coVar) {
        String str;
        ar a2;
        String str2;
        ar arVar = new ar();
        if (coVar != null) {
            if (!de.b(coVar.y)) {
                str = coVar.y;
                a2 = arVar.a((ar) "[");
                str2 = "data-id";
            } else if (!de.b(coVar.z)) {
                str = coVar.z;
                a2 = arVar.a((ar) "[");
                str2 = "data-role";
            }
            a2.a((ar) str2).a((ar) "='").a((ar) str).a((ar) "']");
        }
        return arVar.toString();
    }

    private static void a(View view, ar arVar) {
        da daVar = df.a().get(Integer.valueOf(view.hashCode()));
        if (daVar == null || daVar.E == null) {
            return;
        }
        daVar.E.a(arVar);
    }

    private static void a(View view, ar arVar, int i, int i2) {
        int i3 = i2 + 1;
        if (i2 >= i || view == null) {
            return;
        }
        String a2 = de.a(view);
        if (i3 <= i && (view.getParent() instanceof View)) {
            a((View) view.getParent(), arVar, i, i3);
        }
        if (!(arVar.f65a.length() == 0)) {
            arVar.a((ar) ">");
        }
        (!de.b(a2) ? arVar.a((ar) "[").a((ar) "data-id").a((ar) "='").a((ar) a2) : arVar.a((ar) "[").a((ar) "data-c").a((ar) "='").a((ar) view.getClass().getSimpleName())).a((ar) "']");
        a(view, arVar);
        b(view, arVar);
        if (cc.a(view)) {
            arVar.a((ar) ">div");
        }
    }

    static void a(ar arVar, String str, String str2) {
        arVar.a((ar) "[").a((ar) str).a((ar) "='").a((ar) str2).a((ar) "']");
    }

    static void a(String str) {
        f25a = str;
    }

    static String b() {
        return "background: linear-gradient(to right, #eee, #fafafa, #eee);background-size: 300%;background-position-x: 100%;animation: shimmer 1s infinite linear;";
    }

    private static void b(View view, ar arVar) {
        da daVar;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            if (!cc.b(view2)) {
                int h = de.h(view);
                if (h > 0) {
                    arVar.a((ar) ":nth-child(").a((ar) Integer.valueOf(h + 1)).a((ar) ")");
                    return;
                }
                return;
            }
            if (!ag.a(view2) || (daVar = df.a().get(Integer.valueOf(view.hashCode()))) == null || daVar.D < 0) {
                return;
            }
            arVar.a((ar) "[").a((ar) "data-ind").a((ar) "='").a((ar) Integer.toString(daVar.D)).a((ar) "']");
        }
    }

    static String c() {
        return "box-shadow:0 2px 2px 0 rgba(0, 0, 0, 0.2), 0 2px 6px 0 rgba(0, 0, 0, 0.19);";
    }
}
