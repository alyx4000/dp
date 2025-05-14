package com.quantummetric.ui.internal;

import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.ViewProps;
import com.quantummetric.ui.internal.ax.AnonymousClass5;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
final class di {

    /* renamed from: a, reason: collision with root package name */
    List<cx> f240a;
    List<String> b;
    final b c;

    di(b bVar) {
        this.c = bVar;
        this.f240a = new ArrayList();
        this.b = new ArrayList();
    }

    private di(b bVar, List<cx> list, List<String> list2) {
        this.c = bVar;
        this.f240a = list;
        this.b = list2;
    }

    private static String a(b bVar) {
        StringBuilder sb = new StringBuilder();
        if (bVar.o != 0.0f) {
            sb.append("rotate(").append(bVar.o).append("deg) ");
        }
        if (bVar.p != 1.0f) {
            sb.append("scaleX(").append(bVar.p).append(") ");
        }
        if (bVar.q != 1.0f) {
            sb.append("scaleY(").append(bVar.q).append(") ");
        }
        return sb.toString();
    }

    static void a(ar arVar, ch chVar) {
        bh bhVar;
        b(arVar, chVar);
        if (chVar instanceof m) {
            return;
        }
        c(arVar, chVar);
        if (!(chVar instanceof t) || (bhVar = ((t) chVar).E) == null) {
            return;
        }
        c(arVar, bhVar);
    }

    private void b(ar arVar) {
        List<b> q = this.c.q();
        if (q != null) {
            for (int i = 0; i < q.size(); i++) {
                new di(q.get(i), this.f240a, this.b).a(arVar);
            }
        }
    }

    private static void b(ar arVar, ch chVar) {
        StringBuilder append;
        if ((chVar instanceof t) && ((t) chVar).C) {
            append = arVar.f65a.append(ViewProps.POSITION).append(":").append((Object) "initial");
        } else {
            arVar.f65a.append(aa.ad).append(":").append(Integer.valueOf(chVar.a())).append(";");
            append = arVar.f65a.append(aa.ac).append(":").append(Integer.valueOf(chVar.b()));
        }
        append.append(";");
        arVar.a(aa.ag, Integer.valueOf(chVar.d()), aa.f, chVar.d() != 0).a(aa.ah, Integer.valueOf(chVar.c()), aa.f, chVar.c() != 0);
    }

    private static void c(ar arVar, ch chVar) {
        arVar.a(aa.M, de.b(chVar.e()), !(chVar.e() == 0 || ((chVar instanceof b) && ((b) chVar).u.a())));
        arVar.a(ViewProps.OPACITY, Float.valueOf(chVar.f()), chVar.f() < 1.0f);
        if (chVar.g() != 0.0f) {
            arVar.a(chVar.g());
        }
        arVar.f65a.append((CharSequence) chVar.h().f65a);
    }

    final ar a() {
        ar arVar = new ar(60);
        this.c.l();
        a(arVar, this.c);
        b bVar = this.c;
        if (bVar instanceof m) {
            arVar.f65a.append(AppStateModule.APP_STATE_BACKGROUND).append(":").append((Object) "repeating-linear-gradient(45deg, #253343, #253343 10px, #ffffff 10px, #ffffff 20px)").append(";");
            return arVar;
        }
        String a2 = a(bVar);
        boolean z = false;
        ar a3 = arVar.a(aa.ak, Integer.valueOf(this.c.m), this.c.m != 0);
        String str = aa.aj;
        if (this.c.p() && !this.c.g.equals("DecorView")) {
            z = true;
        }
        a3.a(str, "none", z).a(ViewProps.TRANSFORM, a2, !a2.isEmpty());
        if (this.c.e instanceof cx) {
            this.f240a.add((cx) this.c.e);
        }
        return arVar;
    }

    final void a(ar arVar) {
        b bVar = this.c;
        if (bVar != null) {
            if (bVar instanceof dj) {
                dj djVar = (dj) bVar;
                a.d(djVar.F.get());
                this.b.add(a.b(djVar.F.get()));
                if (djVar.e != null) {
                    db dbVar = (db) djVar.e;
                    if (dbVar.o != null) {
                        cl.c(dbVar.o.new AnonymousClass5());
                    } else {
                        dbVar.p = true;
                    }
                }
            }
            this.c.r();
            arVar.a(a(), this.c);
            b(arVar);
            if (this.c.z) {
                arVar.a(this.c);
            }
        }
    }

    final String b() {
        ar arVar = new ar(200);
        try {
            this.c.e(arVar);
            a(arVar);
        } catch (Exception unused) {
        }
        return arVar.toString();
    }
}
