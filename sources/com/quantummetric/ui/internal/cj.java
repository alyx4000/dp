package com.quantummetric.ui.internal;

import android.view.View;
import android.widget.EditText;
import com.quantummetric.ui.QuantumMetric;
import com.quantummetric.ui.internal.ac;
import com.quantummetric.ui.internal.af;
import com.quantummetric.ui.internal.bd;

/* loaded from: classes5.dex */
final class cj {

    /* renamed from: a, reason: collision with root package name */
    static float f166a = 1.0f;

    interface a {
        ar f(ar arVar);

        void g(ar arVar);

        int t();

        float u();

        String v();
    }

    interface b {
        void a(ar arVar);

        void a(boolean z);

        boolean a();

        void b(boolean z);

        boolean b();

        boolean c();

        void d();

        boolean e();

        void f();

        boolean g();

        Object h();

        short[] i();

        boolean j();
    }

    static float a(ck ckVar) {
        return ((int) ((de.b(ckVar.u()) - f166a) * 10.0d)) / 10.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static ar a(a aVar, ar arVar) {
        ac acVar = ((com.quantummetric.ui.internal.b) aVar).u;
        arVar.a(aa.N, de.b(aVar.t()), !(acVar.f23a != null && (acVar.f23a.contains(ac.a.WHITE_TEXT_COLOR) || acVar.f23a.contains(ac.a.BLACK_TEXT_COLOR)))).f65a.append(aa.P).append(":").append(Float.valueOf(((int) ((de.b(aVar.u()) - f166a) * 10.0d)) / 10.0f)).append(";");
        return arVar;
    }

    static String a(b bVar, String str) {
        if (bVar.g() && !y.e) {
            return str;
        }
        if (!bVar.a()) {
            return bVar.b() ? ab.a(str) : str;
        }
        if (bVar instanceof cz) {
            a((cz) bVar, str);
        }
        return de.h(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String a(java.lang.String r17, com.quantummetric.instrument.internal.cj.b r18, com.quantummetric.ui.internal.ar r19, com.quantummetric.instrument.internal.ck.a r20) {
        /*
            Method dump skipped, instructions count: 559
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.cj.a(java.lang.String, com.quantummetric.instrument.internal.cj$b, com.quantummetric.instrument.internal.ar, com.quantummetric.instrument.internal.ck$a):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void a(com.quantummetric.ui.internal.b bVar, ar arVar) {
        a aVar = (a) bVar;
        arVar.a((ar) "<div style=\"");
        aVar.f(arVar).a((ar) "\" class=\"");
        ac acVar = bVar.u;
        arVar.a((ar) "t");
        if (acVar.f23a != null) {
            if (acVar.f23a.contains(ac.a.WHITE_TEXT_COLOR)) {
                arVar.a((ar) " wtc");
            }
            if (acVar.f23a.contains(ac.a.BLACK_TEXT_COLOR)) {
                arVar.a((ar) " btc");
            }
            if (acVar.f23a.contains(ac.a.SINGLE_LINE)) {
                arVar.a((ar) " sl");
            }
        }
        arVar.a((ar) "\" id=\"").a((ar) com.quantummetric.ui.internal.a.d(bVar.f)).a((ar) "-text\">");
        aVar.g(arVar);
        arVar.a((ar) "</div>");
    }

    static void a(b bVar, boolean z, boolean z2, boolean z3) {
        String str;
        if (z) {
            bVar.a(z);
        } else if (z2 && !bVar.a()) {
            bVar.b(true);
        } else if (z3) {
            bVar.d();
        }
        if (!bVar.a() && !bVar.c() && y.e) {
            if (!bVar.b()) {
                bVar.f();
            }
            bVar.a(true);
            bVar.b(false);
            bd.a().a(bVar.h(), "block_everything");
        }
        if (z3) {
            if (bVar.a() && bVar.e()) {
                bVar.d();
                bVar.a(false);
                bVar.b(false);
                return;
            }
            return;
        }
        if (bVar.j()) {
            if (y.c) {
                bVar.a(true);
                str = "input_masking_everything";
            } else if (bVar.a() || !y.d) {
                str = "";
            } else {
                bVar.b(true);
                str = "input_enc_everything";
            }
            bd.a().a(bVar.h(), str);
        }
    }

    private static void a(cz czVar, String str) {
        View view = czVar.B.get();
        if (!(view instanceof EditText) || QuantumMetric.b == null) {
            return;
        }
        if (czVar.u || (bk.a() && czVar.o)) {
            de.l().a(str, view.hashCode());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void b(b bVar, String str) {
        if (de.b(str) || bVar.a() || bVar.b()) {
            return;
        }
        c cVar = (c) bVar;
        bd a2 = bd.a();
        bd.b a3 = a2.a(cVar, str, cVar.a_(), a2.j);
        if (a3 != null) {
            bVar.b(a3.g);
            if (!a3.g) {
                bVar.a(true);
            }
        } else if (y.e && !bVar.c() && bd.a().p) {
            String a_ = cVar.a_();
            bd a4 = bd.a();
            if (a4.a(cVar, str, a_, a4.k) != null) {
                bVar.d();
            }
        }
        if (af.f26a == null) {
            af.f26a = new af();
        }
        af afVar = af.f26a;
        if (af.l) {
            for (af.k kVar : afVar.j) {
                if (str.contains(kVar.f)) {
                    if ((de.b(kVar.e) || cVar == null) ? true : kVar.e.equals(cVar.a_())) {
                        kVar.a(str, bVar);
                    }
                }
            }
        }
        if (af.f26a == null) {
            af.f26a = new af();
        }
        af afVar2 = af.f26a;
        if (af.m) {
            for (af.k kVar2 : afVar2.k) {
                if (de.a(str, kVar2.h)) {
                    if ((de.b(kVar2.e) || cVar == null) ? true : kVar2.e.equals(cVar.a_())) {
                        kVar2.a(str, bVar);
                    }
                }
            }
        }
    }
}
