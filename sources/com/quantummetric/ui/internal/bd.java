package com.quantummetric.ui.internal;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.quantummetric.ui.QuantumMetric;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes5.dex */
final class bd {

    /* renamed from: a, reason: collision with root package name */
    static boolean f105a = false;
    static boolean b = false;
    static boolean c = false;
    static boolean d = false;
    private static bd u = null;
    private static boolean v = false;
    ConcurrentHashMap<String, b> e;
    ConcurrentHashMap<String, a> f;
    ConcurrentHashMap<Integer, String> g;
    List<b> h;
    List<b> i;
    List<String> j;
    List<String> k;
    List<String> l;
    List<String> m;
    List<String> n;
    boolean o;
    boolean p;
    boolean q = true;
    boolean r = false;
    boolean s = false;
    boolean t = false;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        String f106a;
        String b;
        String c;
        boolean d;

        a(String str, String str2, String str3, boolean z) {
            this.f106a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        String f107a;
        String b;
        String c;
        String d;
        String e;
        int[] f;
        boolean g;
        boolean h;
        boolean i;
        i j;
        private String k;

        b() {
            this.k = "";
        }

        b(JSONObject jSONObject) {
            this.k = "";
            this.f107a = jSONObject.optString("r_id");
            this.b = jSONObject.optString("c_id");
            this.c = jSONObject.optString("c_class");
            this.d = jSONObject.optString("activity");
            this.e = jSONObject.optString("regex");
            this.f = de.j(jSONObject.optString("path"));
            this.g = jSONObject.optBoolean("enc");
            boolean optBoolean = jSONObject.optBoolean("white");
            this.h = optBoolean;
            this.i = (this.g || optBoolean) ? false : true;
            if (aa.o) {
                this.j = i.a(jSONObject);
            }
            if (aa.s) {
                this.k = jSONObject.toString().replace("\"", "'");
            }
        }

        final void a(b bVar) {
            if (this.i || bVar == null) {
                return;
            }
            this.i = bVar.i;
            this.g = this.g || bVar.g;
            this.h = this.h || bVar.h;
        }

        public final String toString() {
            return this.k;
        }
    }

    private bd() {
    }

    static bd a() {
        if (u == null) {
            bd bdVar = new bd();
            u = bdVar;
            bdVar.e = new ConcurrentHashMap<>();
            u.f = new ConcurrentHashMap<>();
            u.g = new ConcurrentHashMap<>();
            u.j = new CopyOnWriteArrayList();
            u.k = new CopyOnWriteArrayList();
            u.n = new CopyOnWriteArrayList();
            u.l = new ArrayList();
            u.m = new ArrayList();
            u.h = new CopyOnWriteArrayList();
            u.i = new CopyOnWriteArrayList();
            if (QuantumMetric.f9a != null) {
                y yVar = QuantumMetric.f9a;
                if (QuantumMetric.b != null) {
                    aa.s = de.k().f && yVar.optBoolean("show_matched_conditions");
                }
            }
        }
        return u;
    }

    static String a(int i) {
        return a().g.remove(Integer.valueOf(i));
    }

    static boolean a(View view, String str, boolean z) {
        if (view != null) {
            for (int i = 0; i < 6; i++) {
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
                if (z && str.equals(de.a(view))) {
                    return true;
                }
                if (!z && str.equals(view.getClass().getSimpleName())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(b bVar, c cVar) {
        if (bVar.j == null || !(cVar instanceof da)) {
            return true;
        }
        return bVar.j.a(((da) cVar).E);
    }

    final b a(c cVar, String str, String str2, List<String> list) {
        String str3;
        b bVar;
        WeakReference<View> weakReference;
        if (!de.b(str)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                str3 = it.next();
                if (de.a(str, str3)) {
                    break;
                }
            }
        }
        str3 = "";
        View view = null;
        if (de.b(str3) || (bVar = this.e.get(str3)) == null) {
            return null;
        }
        if (!de.b(bVar.f107a) && !bVar.f107a.equals(str2)) {
            return null;
        }
        if ((!de.b(bVar.d) && !e.a().a(bVar.d, false)) || !a(bVar, cVar)) {
            return null;
        }
        if (!(cVar instanceof da)) {
            if (cVar instanceof co) {
                weakReference = ((co) cVar).x;
            }
            a(view, bVar.toString());
            return bVar;
        }
        weakReference = ((da) cVar).B;
        view = weakReference.get();
        a(view, bVar.toString());
        return bVar;
    }

    final b a(da daVar) {
        b bVar;
        b bVar2 = new b();
        View view = daVar.B.get();
        if (f105a) {
            bVar2.a(a(daVar, de.a(view)));
        }
        if (b) {
            bVar2.a(a(daVar, view.getClass().getSimpleName()));
        }
        if (d) {
            bVar2.a(b(daVar));
        }
        if (v) {
            if (QuantumMetric.b == null || !v) {
                bVar = null;
            } else {
                bu k = de.k();
                String str = "";
                bVar = this.e.get(k.h != null ? k.h.c() : "");
                if (bVar == null) {
                    bu k2 = de.k();
                    if (k2.h != null) {
                        e eVar = k2.h;
                        if (eVar.P != null) {
                            str = eVar.P;
                        }
                    }
                    if (!de.b(str)) {
                        bVar = this.e.get(str);
                    }
                }
                if (bVar != null) {
                    a(view, bVar.toString());
                }
            }
            bVar2.a(bVar);
        }
        if ((bVar2.i || bVar2.g || bVar2.h) ? false : true) {
            return null;
        }
        return bVar2;
    }

    final b a(da daVar, String str) {
        b bVar = this.e.get(str);
        if (bVar != null && daVar != null) {
            if (!a(bVar, daVar)) {
                bVar = null;
            }
            if (bVar != null) {
                a(daVar.B.get(), bVar.toString());
            }
        }
        return bVar;
    }

    final void a(Object obj, String str) {
        String str2;
        if (!aa.s || obj == null || de.b(str)) {
            return;
        }
        int hashCode = obj.hashCode();
        String str3 = a().g.get(Integer.valueOf(hashCode));
        if (de.b(str3)) {
            str2 = "";
        } else if (str3.contains(str)) {
            return;
        } else {
            str2 = str3 + "; ";
        }
        if (obj instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) obj;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                a(viewGroup.getChildAt(i), str);
                i++;
            }
        }
        if (obj instanceof TextView) {
            a().g.put(Integer.valueOf(hashCode), str2 + str);
        }
    }

    final void a(Object obj, String str, Map<WeakReference<Object>, b> map) {
        Object a2;
        if (de.b(str)) {
            return;
        }
        for (b bVar : this.h) {
            if (de.a(str, bVar.e) && (a2 = de.a(obj, bVar.f)) != null) {
                map.put(new WeakReference<>(a2), bVar);
                a(a2, bVar.toString());
            }
        }
    }

    final void a(String str, String str2) {
        if (!de.b(str)) {
            this.l.add(str);
        }
        if (de.b(str2)) {
            return;
        }
        this.m.add(str2);
    }

    final void a(JSONObject jSONObject) {
        b bVar = new b(jSONObject);
        if (de.b(bVar.f107a)) {
            if (!de.b(bVar.b)) {
                this.e.put(bVar.b, bVar);
                f105a = true;
            } else if (!de.b(bVar.c)) {
                this.e.put(bVar.c, bVar);
                b = true;
            } else if (de.b(bVar.e)) {
                if (bVar.j != null) {
                    this.i.add(bVar);
                    d = true;
                } else if (!de.b(bVar.d)) {
                    this.e.put(bVar.d, bVar);
                    v = true;
                }
            }
        } else if (de.b(bVar.e)) {
            this.e.put(bVar.f107a, bVar);
        }
        if (de.b(bVar.e)) {
            return;
        }
        if (bVar.f.length != 0) {
            this.o = true;
            this.h.add(bVar);
            return;
        }
        if (bVar.h) {
            this.k.add(bVar.e);
            this.p = true;
        } else {
            this.j.add(bVar.e);
        }
        this.e.put(bVar.e, bVar);
    }

    final boolean a(View view) {
        List<String> list;
        if (view == null) {
            return false;
        }
        boolean contains = this.l.isEmpty() ? false : this.l.contains(de.a(view));
        return (contains || (list = this.m) == null) ? contains : list.contains(view.getClass().getSimpleName());
    }

    final boolean a(String str) {
        a aVar = (!this.t || de.b(str)) ? null : this.f.get(str);
        return (aVar == null || aVar.d) ? false : true;
    }

    final b b(da daVar) {
        b bVar;
        if (daVar != null && daVar.E != null) {
            Iterator<b> it = this.i.iterator();
            while (it.hasNext()) {
                bVar = it.next();
                if (a(bVar, daVar)) {
                    break;
                }
            }
        }
        bVar = null;
        if (bVar != null) {
            a(daVar.B.get(), bVar.toString());
        }
        return bVar;
    }
}
