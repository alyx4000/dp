package com.quantummetric.ui.internal;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.node.LayoutNode;
import com.quantummetric.ui.internal.bd;
import com.quantummetric.ui.internal.cj;
import com.quantummetric.ui.internal.s;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
final class dh {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<Integer> f239a = new HashSet();
    private static final Set<Integer> b = new HashSet();
    private static final Set<Integer> c = new HashSet();
    private static final Set<Integer> d = new HashSet();
    private static final Map<Integer, String> e = new ConcurrentHashMap();
    private static final Map<Integer, String> f = new ConcurrentHashMap();
    private static final Map<Integer, String> g = new ConcurrentHashMap();
    private static final Map<WeakReference<Object>, bd.b> h = new HashMap();

    static b a(Object obj, bp bpVar) {
        b bVar = null;
        if (obj instanceof View) {
            bVar = a((View) obj, (dg) null, bpVar);
        } else if (ag.c(obj)) {
            bVar = a((b) null, (LayoutNode) obj, bpVar);
        }
        Map<WeakReference<Object>, bd.b> map = h;
        if (map.size() > 0) {
            try {
                for (Map.Entry<WeakReference<Object>, bd.b> entry : map.entrySet()) {
                    Object obj2 = entry.getKey().get();
                    bd.b value = entry.getValue();
                    if (obj2 != null && value != null) {
                        a(obj2, value);
                    }
                }
            } catch (Throwable unused) {
            }
            h.clear();
        }
        return bVar;
    }

    static da a(View view, da daVar) {
        da c2 = da.c(view);
        a(view, c2, daVar);
        df.a(view.hashCode(), c2);
        return c2;
    }

    static dg a(View view, c cVar, bp bpVar) {
        dg a2;
        if (view == null) {
            return null;
        }
        da daVar = df.a().get(Integer.valueOf(view.hashCode()));
        if (daVar != null) {
            daVar.a((Object) view);
            a2 = dg.a(daVar);
        } else {
            da c2 = da.c(view);
            a(view, c2, cVar);
            df.a(view.hashCode(), c2);
            a2 = dg.a(c2);
            a(view, a2);
        }
        b(view, a2, bpVar);
        return a2;
    }

    private static dg a(View view, dg dgVar, bp bpVar) {
        dg a2;
        if (a(view)) {
            return new m(view);
        }
        if (dgVar == null) {
            dgVar = a(view, view.getParent() instanceof View ? df.i.get(Integer.valueOf(view.getParent().hashCode())) : null, bpVar);
        }
        boolean z = (view instanceof ViewGroup) && dgVar != null && (dgVar.e instanceof da) && !((da) dgVar.e).n();
        if (dgVar instanceof v) {
            s.a(view);
            v vVar = (v) dgVar;
            LayoutNode a3 = v.a(vVar.F.get());
            s.a();
            if (s.b()) {
                a(vVar, a3, bpVar);
            }
        } else if (z) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null && childAt.getParent() == viewGroup && (a2 = a(childAt, dgVar.e, bpVar)) != null) {
                    dgVar.a(a(childAt, a2, bpVar));
                }
            }
        }
        return dgVar;
    }

    private static t a(LayoutNode layoutNode, b bVar, bp bpVar) {
        s.a();
        if (!s.c(layoutNode)) {
            s.a().a(layoutNode, s.d.f281a);
            return null;
        }
        t a2 = a(layoutNode, bVar.e, bpVar, false);
        a(a2, layoutNode, bpVar);
        a(a2, bpVar);
        bVar.a(a2);
        return a2;
    }

    static t a(LayoutNode layoutNode, c cVar, bp bpVar, boolean z) {
        boolean z2;
        c cVar2 = s.a().c.get(Integer.valueOf(layoutNode.hashCode()));
        co coVar = cVar2 instanceof co ? (co) cVar2 : null;
        if (coVar == null) {
            coVar = co.a(layoutNode);
            z2 = true;
        } else {
            coVar.a((Object) layoutNode);
            z2 = false;
        }
        if (cVar == null) {
            cVar = s.a().b(layoutNode);
        }
        if (cVar != null) {
            coVar.b = cVar.b;
            coVar.c = cVar.c;
            coVar.d = cVar.d;
            if (!coVar.e) {
                coVar.e = cVar.e;
            }
        }
        t a2 = t.a(coVar, z);
        a2.a(bpVar);
        if (z2) {
            s.a().a(a2);
        }
        a(layoutNode, a2);
        if (coVar instanceof cj.b) {
            cj.a((cj.b) coVar, coVar.b, coVar.d, coVar.e);
        }
        return a2;
    }

    private static t a(b bVar, LayoutNode layoutNode, bp bpVar) {
        t tVar;
        t tVar2;
        b bVar2;
        t tVar3 = null;
        if (layoutNode != null) {
            if (bVar instanceof t) {
                tVar2 = null;
                bVar2 = bVar;
            } else {
                if (bVar != null) {
                    return a(layoutNode, bVar, bpVar);
                }
                t a2 = a(layoutNode, null, bpVar, false);
                a(a2, bpVar);
                tVar2 = a2;
                bVar2 = a2;
            }
            Iterator it = layoutNode.getZSortedChildren().asMutableList().iterator();
            while (it.hasNext()) {
                tVar3 = a((LayoutNode) it.next(), bVar2, bpVar);
            }
            tVar = tVar3;
            tVar3 = tVar2;
        } else {
            tVar = null;
        }
        return tVar3 == null ? tVar : tVar3;
    }

    static void a() {
        f239a.clear();
        b.clear();
        c.clear();
        d.clear();
        e.clear();
        f.clear();
        g.clear();
    }

    static void a(int i) {
        f239a.add(Integer.valueOf(i));
    }

    static void a(int i, String str) {
        g.put(Integer.valueOf(i), str);
    }

    static void a(int i, String str, String str2) {
        e.put(Integer.valueOf(i), str);
        if (de.b(str2)) {
            return;
        }
        f.put(Integer.valueOf(i), str2);
    }

    private static void a(View view, da daVar, c cVar) {
        bd.b a2;
        int hashCode = view.hashCode();
        Set<Integer> set = b;
        if ((!set.isEmpty() || !d.isEmpty()) && !daVar.b) {
            daVar.b = set.contains(Integer.valueOf(hashCode));
            daVar.d = d.contains(Integer.valueOf(hashCode));
        }
        if (c.contains(Integer.valueOf(hashCode))) {
            daVar.c = true;
        }
        if (cVar != null) {
            daVar.a(cVar.b, cVar.c, cVar.d, cVar.e);
        }
        if (daVar.b || !(view instanceof ViewGroup) || (a2 = bd.a().a(daVar)) == null || a2 == null) {
            return;
        }
        daVar.a(a2.i, false, a2.g, a2.h);
    }

    private static void a(t tVar, bp bpVar) {
        View t;
        if (!(tVar instanceof w) || (t = ((w) tVar).t()) == null) {
            return;
        }
        dg a2 = a(t, tVar.e, bpVar);
        a(t, a2, bpVar);
        tVar.a(a2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(Object obj, b bVar) {
        if ((bVar instanceof cj.a) && bd.a().o) {
            try {
                bd.a().a(obj, ((cj.a) bVar).v(), h);
            } catch (Exception unused) {
            }
        }
    }

    private static void a(Object obj, bd.b bVar) {
        da daVar;
        if (obj == null) {
            return;
        }
        boolean z = obj instanceof View;
        int hashCode = obj.hashCode();
        if (z) {
            daVar = df.a().get(Integer.valueOf(hashCode));
        } else {
            c cVar = s.a().c.get(Integer.valueOf(hashCode));
            daVar = cVar instanceof co ? (co) cVar : null;
        }
        if (daVar == null) {
            return;
        }
        int i = 0;
        if (bVar != null) {
            daVar.a(bVar.i, false, bVar.g, bVar.h);
        }
        if (!(obj instanceof ViewGroup)) {
            if (ag.e && ag.c(obj)) {
                Iterator it = ((LayoutNode) obj).getZSortedChildren().asMutableList().iterator();
                while (it.hasNext()) {
                    a((LayoutNode) it.next(), bVar);
                }
                return;
            }
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) obj;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            a(viewGroup.getChildAt(i), bVar);
            i++;
        }
    }

    static boolean a(View view) {
        if (view == null) {
            return false;
        }
        Set<Integer> set = f239a;
        boolean contains = set.contains(Integer.valueOf(view.hashCode()));
        if (contains || !bd.a().a(view)) {
            return contains;
        }
        set.add(Integer.valueOf(view.hashCode()));
        return true;
    }

    static m b(View view) {
        return new m(view);
    }

    static String b(int i) {
        return e.get(Integer.valueOf(i));
    }

    private static void b(View view, dg dgVar, bp bpVar) {
        if (view == null || dgVar == null || bpVar == null) {
            return;
        }
        dgVar.a(bpVar);
        if (dgVar.e instanceof cs) {
            ((cs) dgVar.e).a(bpVar, null);
        }
    }

    static String c(int i) {
        return f.get(Integer.valueOf(i));
    }

    static void c(View view) {
        if (view != null) {
            b.add(Integer.valueOf(view.hashCode()));
            c.add(Integer.valueOf(view.hashCode()));
        }
    }

    static String d(int i) {
        return g.get(Integer.valueOf(i));
    }

    static void d(View view) {
        if (view != null) {
            b.add(Integer.valueOf(view.hashCode()));
        }
    }

    static void e(View view) {
        if (view != null) {
            d.add(Integer.valueOf(view.hashCode()));
        }
    }
}
