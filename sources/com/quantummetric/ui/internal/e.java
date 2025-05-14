package com.quantummetric.ui.internal;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.google.logging.type.LogSeverity;
import com.quantummetric.instrument.internal.df.b;
import com.quantummetric.ui.EventListener;
import com.quantummetric.ui.EventType;
import com.quantummetric.ui.QuantumMetric;
import com.quantummetric.ui.internal.ak;
import com.quantummetric.ui.internal.am;
import com.quantummetric.ui.internal.bp.AnonymousClass3;
import com.quantummetric.ui.internal.bu;
import com.quantummetric.ui.internal.df.AnonymousClass12;
import com.quantummetric.ui.internal.df.AnonymousClass4;
import com.quantummetric.ui.internal.g;
import io.sentry.protocol.ViewHierarchyNode;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
final class e implements Application.ActivityLifecycleCallbacks {
    private static e T;
    df H;
    bu.AnonymousClass1.RunnableC00311.C00321 I;
    boolean M;
    String P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private am U;
    private boolean X;

    /* renamed from: a, reason: collision with root package name */
    int f242a;
    long b;
    boolean c;
    boolean d;
    boolean f;
    volatile boolean g;
    WeakReference<Activity> h;
    boolean u;
    boolean e = true;
    volatile boolean l = true;
    int p = 100;
    boolean t = true;
    boolean J = true;
    boolean K = false;
    boolean L = true;
    boolean N = true;
    private String Y = "";
    int O = -1;
    private boolean Z = false;
    List<Integer> D = new ArrayList();
    List<Integer> E = new ArrayList();
    Map<Integer, List<Integer>> G = new HashMap();
    List<String> s = new ArrayList();
    List<String> i = new CopyOnWriteArrayList();
    List<String> j = new CopyOnWriteArrayList();
    List<String> m = new CopyOnWriteArrayList();
    List<String> k = new CopyOnWriteArrayList();
    List<String> n = new ArrayList();
    List<String> o = new ArrayList();
    List<String> q = new ArrayList();
    List<String> r = new ArrayList();
    Set<Integer> F = new HashSet();
    final List<String> v = new CopyOnWriteArrayList();
    final List<String> w = new CopyOnWriteArrayList();
    final List<String> x = new CopyOnWriteArrayList();
    final List<String> y = new CopyOnWriteArrayList();
    final List<String> z = new CopyOnWriteArrayList();
    final List<String> A = new CopyOnWriteArrayList();
    private Map<f, WeakReference<View>> W = new HashMap();
    List<String> B = new ArrayList();
    List<String> C = new ArrayList();
    private ViewOnAttachStateChangeListenerC0034e V = new ViewOnAttachStateChangeListenerC0034e(0);

    /* renamed from: com.quantummetric.instrument.internal.e$13, reason: invalid class name */
    final class AnonymousClass13 implements f {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<View> f247a;
        boolean b;
        final float c = (float) de.a(8.0d);
        private boolean e;
        private /* synthetic */ String f;

        AnonymousClass13(String str) {
            this.f = str;
            this.e = !e.this.q.contains(this.f);
        }

        @Override // com.quantummetric.instrument.internal.e.f
        public final void a(final float f, final float f2, final float f3, final boolean z) {
            if (!this.e || e.this.g) {
                return;
            }
            final WeakReference weakReference = (WeakReference) e.this.W.get(this);
            cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.e.13.1
                /* JADX WARN: Code restructure failed: missing block: B:95:0x0211, code lost:
                
                    r5 = (com.quantummetric.ui.internal.cx) r5;
                    r5.a(0, (int) r2);
                    com.quantummetric.ui.internal.df.a((android.view.View) r4, r5);
                    com.quantummetric.ui.internal.cl.b(new com.quantummetric.ui.internal.df.AnonymousClass19(r1, r4, r5), 500);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:96:0x0224, code lost:
                
                    return;
                 */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r10v0, types: [com.quantummetric.instrument.internal.e$13$1$1] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void run() {
                    /*
                        Method dump skipped, instructions count: 601
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.e.AnonymousClass13.AnonymousClass1.run():void");
                }
            });
        }
    }

    interface a {
        void a();

        void b();
    }

    interface b {
        void a(int i);

        void a(am.a aVar);
    }

    interface c {
        void a(View view);
    }

    interface d {
        void a(AccessibilityEvent accessibilityEvent);
    }

    /* renamed from: com.quantummetric.instrument.internal.e$e, reason: collision with other inner class name */
    static class ViewOnAttachStateChangeListenerC0034e implements View.OnAttachStateChangeListener {
        private ViewOnAttachStateChangeListenerC0034e() {
        }

        /* synthetic */ ViewOnAttachStateChangeListenerC0034e(byte b) {
            this();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            final e a2 = e.a();
            if (a2 != null) {
                if (a2.H != null) {
                    a2.H.a(view, true);
                }
                cl.c(new Runnable() { // from class: com.quantummetric.instrument.internal.e.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.j(e.this);
                    }
                });
            }
        }
    }

    interface f {
        void a(float f, float f2, float f3, boolean z);
    }

    private e() {
    }

    static /* synthetic */ int a(int i) {
        if (i <= 0 || i > 99) {
            return i == 2038 ? 11 : 3;
        }
        return 2;
    }

    private int a(List<View> list) {
        int i = -1;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (this.E.contains(Integer.valueOf(list.get(i2).hashCode()))) {
                i = i2;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:18|(1:109)(1:22)|23|(2:25|(4:27|28|29|(1:31)(3:33|(2:37|(1:39))|41)))|108|28|29|(0)(0)) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0064 A[Catch: all -> 0x0086, TryCatch #1 {all -> 0x0086, blocks: (B:29:0x005f, B:33:0x0064, B:35:0x006c, B:37:0x007a), top: B:28:0x005f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View a(final android.view.View r19, float r20, float r21, boolean r22, int[] r23, com.quantummetric.instrument.internal.e.c r24) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.e.a(android.view.View, float, float, boolean, int[], com.quantummetric.instrument.internal.e$c):android.view.View");
    }

    static /* synthetic */ da a(da daVar) {
        da daVar2;
        View view = daVar.B.get();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i < 5) {
                if (!view.isClickable()) {
                    if (!(view.getParent() instanceof View)) {
                        break;
                    }
                    view = (View) view.getParent();
                    i++;
                } else {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        return (!z || daVar.B.get() == view || (daVar2 = df.a().get(Integer.valueOf(view.hashCode()))) == null || daVar2.B.get() == null) ? daVar : daVar2;
    }

    public static e a() {
        if (T == null) {
            T = new e();
        }
        return T;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.view.View r8, java.lang.String r9) {
        /*
            boolean r0 = r8 instanceof android.view.ViewGroup
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L36
            r0 = r8
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r3 = r0.getChildCount()
            r4 = 3
            if (r3 > r4) goto L36
            r3 = r1
            r4 = r2
        L12:
            int r5 = r0.getChildCount()
            if (r3 >= r5) goto L37
            android.view.View r5 = r0.getChildAt(r3)
            boolean r6 = r5 instanceof android.widget.TextView
            if (r6 == 0) goto L33
            if (r4 == 0) goto L23
            goto L3d
        L23:
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.lang.CharSequence r6 = r5.getText()
            if (r6 == 0) goto L33
            int r6 = r5.length()
            r7 = 1
            if (r6 <= r7) goto L33
            r4 = r5
        L33:
            int r3 = r3 + 1
            goto L12
        L36:
            r4 = r2
        L37:
            if (r4 == 0) goto L3d
            java.lang.String r2 = d(r4)
        L3d:
            boolean r0 = com.quantummetric.ui.internal.de.b(r2)
            if (r0 == 0) goto L9a
            boolean r0 = com.quantummetric.ui.internal.de.b(r9)
            if (r0 != 0) goto L4a
            goto L9b
        L4a:
            boolean r9 = com.quantummetric.ui.internal.aa.o
            if (r9 == 0) goto L9a
            java.util.concurrent.ConcurrentHashMap r9 = com.quantummetric.ui.internal.df.a()
            int r8 = r8.hashCode()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.Object r8 = r9.get(r8)
            com.quantummetric.instrument.internal.da r8 = (com.quantummetric.ui.internal.da) r8
            if (r8 == 0) goto L9a
            com.quantummetric.instrument.internal.i r9 = r8.E
            if (r9 == 0) goto L9a
            com.quantummetric.instrument.internal.i r8 = r8.E
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            com.quantummetric.instrument.internal.i$a[] r0 = com.quantummetric.instrument.internal.i.a.values()
            int r2 = r0.length
        L72:
            if (r1 >= r2) goto L95
            r3 = r0[r1]
            java.lang.String r3 = r3.name()
            java.lang.String r3 = r8.optString(r3)
            boolean r4 = com.quantummetric.ui.internal.de.b(r3)
            if (r4 != 0) goto L92
            int r4 = r9.length()
            if (r4 == 0) goto L8f
            java.lang.String r4 = "."
            r9.append(r4)
        L8f:
            r9.append(r3)
        L92:
            int r1 = r1 + 1
            goto L72
        L95:
            java.lang.String r9 = r9.toString()
            goto L9b
        L9a:
            r9 = r2
        L9b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.e.a(android.view.View, java.lang.String):java.lang.String");
    }

    private void a(int i, List<View> list) {
        int i2 = i + 1;
        if (i2 < list.size()) {
            while (i2 < list.size()) {
                View view = list.get(i2);
                if (view != null) {
                    this.E.add(Integer.valueOf(view.hashCode()));
                    com.quantummetric.ui.internal.a.a(view, "<BODY", i2, this.H.new AnonymousClass12());
                    this.H.a(view);
                }
                i2++;
            }
            Activity activity = this.h.get();
            if (activity != null) {
                QuantumMetric.a(-35, activity.getClass().getSimpleName(), new j[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, int i, int i2) {
        String a2 = de.a(view);
        String a3 = view.getParent() instanceof View ? de.a((View) view.getParent()) : null;
        if (view.getParent() instanceof View) {
            if (this.K && de.b(a2) && de.b(a3)) {
                return;
            }
            String b2 = b(view, (String) null, false);
            long currentTimeMillis = System.currentTimeMillis();
            bf bfVar = new bf();
            bfVar.put("t", "H");
            bfVar.put("n", b2);
            bfVar.put("PP", ad.a((View) view.getParent()));
            bfVar.put("P", ad.a(view));
            bfVar.put(ViewHierarchyNode.JsonKeys.X, Integer.valueOf(i));
            bfVar.put(ViewHierarchyNode.JsonKeys.Y, Integer.valueOf(i2));
            long j = currentTimeMillis - this.b;
            if (j <= 0) {
                j = 0;
            }
            bfVar.put("tc", Long.valueOf(j));
            bfVar.put("ts", Long.valueOf(currentTimeMillis));
            if (QuantumMetric.b != null) {
                QuantumMetric.b.g.a("qc", bfVar);
            }
        }
    }

    private void a(View view, com.quantummetric.ui.internal.b bVar) {
        try {
            if (this.t && this.H != null && (bVar instanceof ae) && (bVar.e instanceof cr)) {
                cr crVar = (cr) bVar.e;
                if (crVar.o) {
                    return;
                }
                boolean z = false;
                Activity activity = null;
                r2 = null;
                View view2 = null;
                if (((!(view instanceof ViewGroup) || ((ViewGroup) view).getChildCount() <= 0) ? null : ((ViewGroup) view).getChildAt(0)) != null) {
                    if ((view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0) {
                        view2 = ((ViewGroup) view).getChildAt(0);
                    }
                    activity = de.c(view2);
                }
                String simpleName = activity != null ? activity.getClass().getSimpleName() : "";
                if (view != null && (!e(view) || this.s.contains(simpleName))) {
                    z = true;
                }
                crVar.o = z;
                if (z) {
                    view.removeOnAttachStateChangeListener(this.V);
                    view.addOnAttachStateChangeListener(this.V);
                    df dfVar = this.H;
                    if (dfVar.f185a == null) {
                        dfVar.f185a = dfVar.new b();
                    }
                    dfVar.f185a.a(crVar);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void a(Window window, String str) {
        if (window == null || this.r.contains(str) || a(window.getCallback())) {
            return;
        }
        AnonymousClass13 anonymousClass13 = new AnonymousClass13(str);
        this.W.put(anonymousClass13, new WeakReference<>(window.getDecorView()));
        window.setCallback(new dk(window, anonymousClass13));
    }

    static /* synthetic */ void a(e eVar, Activity activity) {
        if (activity != null) {
            eVar.a(activity.getWindow(), activity.getClass().getSimpleName());
        }
    }

    static /* synthetic */ void a(e eVar, View view, float f2, float f3) {
        view.getLocationOnScreen(new int[]{0, 0});
        eVar.a(view, (int) (((f2 - r1[0]) / view.getWidth()) * 100.0f), (int) (((f3 - r1[1]) / view.getHeight()) * 100.0f));
    }

    static /* synthetic */ void a(e eVar, View view, String str, boolean z) {
        df dfVar;
        String b2 = com.quantummetric.ui.internal.a.b(view);
        String simpleName = view.getClass().getSimpleName();
        String a2 = de.a(view);
        if (z) {
            boolean contains = eVar.C.contains(str);
            if (!contains && eVar.B.size() > 0) {
                View view2 = view;
                for (int i = 0; i < 6 && view2 != null; i++) {
                    String a3 = de.a(view2);
                    if (!de.b(a3)) {
                        contains = eVar.B.contains(a3);
                    }
                    if (contains || !(view2.getParent() instanceof View)) {
                        break;
                    }
                    view2 = (View) view2.getParent();
                }
            }
            if (!contains) {
                com.quantummetric.ui.internal.a.b(str);
                if (QuantumMetric.b != null) {
                    try {
                        Iterator<EventListener<View>> it = de.k().l.f48a.iterator();
                        while (it.hasNext()) {
                            it.next().onEvent(view);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        } else if (de.b(view)) {
            if (af.f26a == null) {
                af.f26a = new af();
            }
            af.f26a.a(view, simpleName, a2, simpleName, null, true);
        }
        com.quantummetric.ui.internal.a.b(b2, str);
        if (af.f26a == null) {
            af.f26a = new af();
        }
        af.f26a.a(view, str, a2, simpleName, null, false);
        if (!ck.a(view) || (dfVar = eVar.H) == null) {
            return;
        }
        da daVar = df.i.get(Integer.valueOf(view.hashCode()));
        if (((view == null || dfVar.c == null) ? false : dfVar.c.contains(Integer.valueOf(view.hashCode()))) && (daVar instanceof cz)) {
            cz czVar = (cz) daVar;
            boolean z2 = true;
            boolean z3 = (de.b(czVar.y) && de.b(czVar.z)) ? false : true;
            if (!z3) {
                for (String str2 : czVar.x) {
                    if (!de.b(str2)) {
                        break;
                    }
                }
            }
            z2 = z3;
            if (z2) {
                int i2 = (!ag.j(view) || (!(view.getBackground() instanceof RippleDrawable) && de.d(view))) ? 200 : LogSeverity.CRITICAL_VALUE;
                cl.b(dfVar.new AnonymousClass4(new WeakReference(view), 0, true, i2), i2);
            }
        }
    }

    static /* synthetic */ void a(e eVar, AccessibilityEvent accessibilityEvent) {
        final ArrayList arrayList = new ArrayList(accessibilityEvent.getText());
        final String obj = accessibilityEvent.getContentDescription() != null ? accessibilityEvent.getContentDescription().toString() : "";
        final String obj2 = accessibilityEvent.getClassName() != null ? accessibilityEvent.getClassName().toString() : "";
        cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.e.12
            @Override // java.lang.Runnable
            public final void run() {
                int a2 = arrayList.size() > 0 ? de.a((CharSequence) arrayList.get(0)) : 0;
                da a3 = a2 != 0 ? df.a(a2) : null;
                if (a3 == null || a3.B.get() == null) {
                    String str = !de.b(obj) ? obj : obj2;
                    if (de.b(str)) {
                        return;
                    }
                    com.quantummetric.ui.internal.a.b("", str);
                    return;
                }
                if (!aa.k || !de.b(a3.B.get())) {
                    a3 = e.a(a3);
                }
                View view = a3.B.get();
                e.a(e.this, view, e.b(view, obj, false), false);
                e.this.a(view, 50, 50);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final boolean z, final boolean z2) {
        if (this.o.isEmpty() || !de.a(str, this.o)) {
            b(str, z, z2);
        } else {
            cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.e.7
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.b(str, z, z2);
                }
            }, this.p);
        }
    }

    private void a(List<Integer> list, View view) {
        if (view != null) {
            try {
                list.add(Integer.valueOf(view.hashCode()));
                if (view instanceof ViewGroup) {
                    for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                        a(list, ((ViewGroup) view).getChildAt(i));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void a(List<View> list, final String str) {
        final ArrayList arrayList = new ArrayList();
        this.E.clear();
        this.G.clear();
        if (!this.d) {
            b(arrayList, str);
            return;
        }
        bp bpVar = new bp(bz.a(), new dc() { // from class: com.quantummetric.instrument.internal.e.9
            @Override // com.quantummetric.ui.internal.dc
            public final void a() {
                e.this.b((List<com.quantummetric.ui.internal.b>) arrayList, str);
            }
        });
        boolean z = list.size() == 1;
        Iterator<View> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            View next = it.next();
            if (this.g) {
                arrayList.add(dh.b(next));
                break;
            }
            this.E.add(Integer.valueOf(next.hashCode()));
            com.quantummetric.ui.internal.b a2 = dh.a(next, bpVar);
            if (z && (a2 instanceof ae)) {
                ae aeVar = (ae) a2;
                if (aeVar.e instanceof cr) {
                    ((cr) aeVar.e).o = false;
                }
            }
            arrayList.add(a2);
            a(next, a2);
        }
        bpVar.d = true;
        bpVar.a(false);
        if (bpVar.e) {
            return;
        }
        cl.a(bpVar.new AnonymousClass3(), 50);
    }

    static boolean a(Activity activity) {
        try {
            if (activity instanceof ComponentActivity) {
                return ((ComponentActivity) activity).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    private boolean a(View.AccessibilityDelegate accessibilityDelegate) {
        boolean z = accessibilityDelegate instanceof com.quantummetric.ui.internal.d;
        if (z || accessibilityDelegate == null) {
            return z;
        }
        try {
            for (Field field : accessibilityDelegate.getClass().getDeclaredFields()) {
                if (field.getType() == View.AccessibilityDelegate.class) {
                    field.setAccessible(true);
                    return a((View.AccessibilityDelegate) field.get(accessibilityDelegate));
                }
            }
            return z;
        } catch (Throwable unused) {
            return z;
        }
    }

    private static boolean a(View view, List<String> list, List<String> list2) {
        if (list.size() <= 0 || !list.contains(de.a(view))) {
            return list2.size() > 0 && list2.contains(view.getClass().getSimpleName());
        }
        return true;
    }

    private boolean a(Window.Callback callback) {
        boolean z = callback instanceof dk;
        if (callback == null || z) {
            return z;
        }
        for (Field field : callback.getClass().getDeclaredFields()) {
            if (field.getType() == Window.Callback.class) {
                try {
                    field.setAccessible(true);
                    return a((Window.Callback) field.get(callback));
                } catch (Exception unused) {
                    return z;
                }
            }
        }
        return z;
    }

    static int b(Activity activity) {
        int rotation;
        WindowManager windowManager = activity.getWindowManager();
        Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        return (defaultDisplay == null || !((rotation = defaultDisplay.getRotation()) == 1 || rotation == 3)) ? 0 : 90;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(View view, String str, boolean z) {
        String a2 = de.a(view);
        if (!de.b(a2) && z) {
            return a2;
        }
        String d2 = d(view);
        if (de.b(d2)) {
            if (aa.k && de.b(view)) {
                d2 = a(view, a2);
            }
            if (de.b(d2)) {
                return !de.b(str) ? str : view.getClass().getSimpleName();
            }
        }
        return d2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<android.view.View> b(java.util.List<android.view.View> r13) {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            com.quantummetric.instrument.internal.e$5 r2 = new com.quantummetric.instrument.internal.e$5
            r2.<init>()
            java.util.Collections.sort(r13, r2)
            int r2 = r13.size()
            r3 = 1
            int r2 = r2 - r3
            r4 = 0
            r5 = 0
            r7 = r4
            r6 = r5
            r8 = r6
        L1d:
            if (r2 < 0) goto Lbe
            java.lang.Object r9 = r13.get(r2)
            android.view.View r9 = (android.view.View) r9
            boolean r10 = r9 instanceof android.view.ViewGroup
            if (r10 == 0) goto La4
            if (r10 == 0) goto L39
            r8 = r9
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            int r11 = r8.getChildCount()
            if (r11 <= 0) goto L39
            android.view.View r8 = r8.getChildAt(r5)
            goto L3a
        L39:
            r8 = r4
        L3a:
            if (r8 == 0) goto L52
            if (r10 == 0) goto L4c
            r8 = r9
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            int r11 = r8.getChildCount()
            if (r11 <= 0) goto L4c
            android.view.View r8 = r8.getChildAt(r5)
            goto L4d
        L4c:
            r8 = r4
        L4d:
            android.app.Activity r8 = com.quantummetric.ui.internal.de.c(r8)
            goto L53
        L52:
            r8 = r4
        L53:
            if (r10 == 0) goto L63
            r10 = r9
            android.view.ViewGroup r10 = (android.view.ViewGroup) r10
            int r11 = r10.getChildCount()
            if (r11 <= 0) goto L63
            android.view.View r10 = r10.getChildAt(r5)
            goto L64
        L63:
            r10 = r4
        L64:
            if (r10 == 0) goto L70
            android.content.Context r10 = r10.getContext()
            boolean r10 = r10 instanceof android.app.Activity
            if (r10 == 0) goto L70
            r10 = r3
            goto L71
        L70:
            r10 = r5
        L71:
            if (r10 == 0) goto L78
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            r1.put(r8, r11)
        L78:
            if (r6 == 0) goto L7c
            if (r8 != r7) goto Lbe
        L7c:
            if (r6 != 0) goto La2
            if (r10 == 0) goto La1
            if (r8 == 0) goto La1
            java.lang.Class r6 = r8.getClass()
            java.lang.String r6 = r6.getSimpleName()
            if (r9 == 0) goto L9c
            boolean r7 = e(r9)
            if (r7 == 0) goto L9a
            java.util.List<java.lang.String> r7 = r12.s
            boolean r6 = r7.contains(r6)
            if (r6 == 0) goto L9c
        L9a:
            r6 = r3
            goto L9d
        L9c:
            r6 = r5
        L9d:
            if (r6 != 0) goto La1
            r6 = r3
            goto La2
        La1:
            r6 = r5
        La2:
            r7 = r8
            r8 = r10
        La4:
            java.lang.Object r10 = r1.get(r7)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            if (r8 != 0) goto Lb6
            if (r10 == 0) goto Lb6
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto Lb6
            r10 = r3
            goto Lb7
        Lb6:
            r10 = r5
        Lb7:
            r0.add(r10, r9)
            int r2 = r2 + (-1)
            goto L1d
        Lbe:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.e.b(java.util.List):java.util.List");
    }

    private void b(int i) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.D.iterator();
        while (it.hasNext()) {
            if (i == it.next().intValue()) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        this.D.removeAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, String str, boolean z) {
        am amVar;
        String simpleName = activity.getClass().getSimpleName();
        if (de.b(str) && ag.a(activity)) {
            if (an.f56a == null) {
                an.f56a = new an();
            }
            an anVar = an.f56a;
            String a2 = anVar.a((FragmentActivity) activity);
            if (!de.b(a2)) {
                str = anVar.a(simpleName, a2);
            }
        }
        final String str2 = de.b(str) ? simpleName : str;
        View findViewById = activity.findViewById(R.id.content);
        final View findViewById2 = findViewById == null ? activity.getWindow().getDecorView().findViewById(R.id.content) : findViewById;
        if ((cd.f161a || QuantumMetric.b == null) || this.n.contains(str2) || findViewById2 == null) {
            this.f = false;
            return;
        }
        boolean b2 = b(simpleName);
        final boolean z2 = b2 || this.g;
        final boolean z3 = (this.g || d(activity)) ? true : z;
        b(activity.hashCode());
        if (this.L) {
            g();
        }
        if (this.c) {
            if (this.H == null) {
                this.H = new df();
                e();
            }
            e(activity);
            dh.a(findViewById2.hashCode(), simpleName, str);
            if (b2) {
                dh.a(findViewById2.hashCode());
            }
            if (aa.B) {
                b(findViewById2);
            }
            if (ag.c && (amVar = this.U) != null) {
                amVar.f54a = true;
            }
            this.f = true;
            this.b = System.currentTimeMillis();
            if (findViewById2.getHeight() != 0) {
                a(str2, z2, z3);
            } else {
                findViewById2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.quantummetric.instrument.internal.e.6
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        findViewById2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        e.this.a(str2, z2, z3);
                    }
                });
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.quantummetric.instrument.internal.e$11] */
    private void b(View view) {
        try {
            View.AccessibilityDelegate accessibilityDelegate = (View.AccessibilityDelegate) View.class.getDeclaredMethod("getAccessibilityDelegate", new Class[0]).invoke(view, new Object[0]);
            if (!com.quantummetric.ui.internal.d.a() || a(accessibilityDelegate)) {
                return;
            }
            view.setAccessibilityDelegate(new com.quantummetric.ui.internal.d(accessibilityDelegate, new d() { // from class: com.quantummetric.instrument.internal.e.11
                @Override // com.quantummetric.instrument.internal.e.d
                public final void a(AccessibilityEvent accessibilityEvent) {
                    try {
                        e.a(e.this, accessibilityEvent);
                    } catch (Throwable unused) {
                    }
                }
            }));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, boolean z, boolean z2) {
        am amVar;
        try {
            WeakReference<Activity> weakReference = this.h;
            if (weakReference != null && weakReference.get() != null) {
                if (af.f26a == null) {
                    af.f26a = new af();
                }
                af.f26a.a(str);
                Activity activity = this.h.get();
                if (activity != null) {
                    a(activity.getWindow(), activity.getClass().getSimpleName());
                }
                List<View> b2 = b(d());
                int a2 = a(b2);
                boolean z3 = true;
                if (!z2 && a2 != -1) {
                    if (this.E.size() < b2.size()) {
                        a(a2, b2);
                        z3 = false;
                    } else {
                        z3 = true ^ b(a2, b2);
                    }
                }
                if (z3) {
                    if (this.H != null && this.E.size() > 0) {
                        this.H.b();
                    }
                    a(b2, str);
                } else if (ag.c && (amVar = this.U) != null) {
                    amVar.a();
                }
                if (!z && this.d) {
                    df dfVar = this.H;
                    Activity activity2 = this.h.get();
                    View findViewById = activity2.findViewById(R.id.content);
                    if (findViewById == null) {
                        findViewById = activity2.getWindow().getDecorView().findViewById(R.id.content);
                    }
                    dfVar.b(findViewById);
                    Iterator<View> it = b2.iterator();
                    while (it.hasNext()) {
                        this.H.a(it.next());
                    }
                }
            }
        } catch (Exception unused) {
        }
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final List<com.quantummetric.ui.internal.b> list, final String str) {
        dk.b();
        final boolean z = this.Z;
        final boolean z2 = this.R;
        final int i = this.O;
        if (z) {
            this.Z = false;
        }
        if (z2) {
            this.R = false;
        }
        cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.e.10
            /* JADX WARN: Code restructure failed: missing block: B:52:0x00d9, code lost:
            
                if (r1 > 0) goto L32;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void run() {
                /*
                    Method dump skipped, instructions count: 266
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.e.AnonymousClass10.run():void");
            }
        });
    }

    private boolean b(int i, List<View> list) {
        int i2;
        if (i == this.E.size() - 1) {
            Activity activity = this.h.get();
            View findViewById = activity.findViewById(R.id.content);
            if (findViewById == null) {
                findViewById = activity.getWindow().getDecorView().findViewById(R.id.content);
            }
            if (findViewById != null) {
                int indexOf = this.E.indexOf(Integer.valueOf(de.f(findViewById)));
                if (indexOf < i) {
                    i = c(indexOf, list) - 1;
                }
            }
        }
        if (i < 0 || (i2 = i + 1) >= this.E.size()) {
            return false;
        }
        while (i2 != this.E.size()) {
            final int size = this.E.size() - 1;
            int intValue = this.E.remove(size).intValue();
            if (this.G.containsKey(Integer.valueOf(intValue))) {
                this.H.a(this.G.get(Integer.valueOf(intValue)));
            }
            cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.e.8
                @Override // java.lang.Runnable
                public final void run() {
                    com.quantummetric.ui.internal.a.a(size);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(View view, float f2, float f3, int[] iArr) {
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        return ((float) i) < f2 && ((float) iArr[1]) < f3 && f2 < ((float) (i + view.getWidth())) && f3 < ((float) (iArr[1] + view.getHeight()));
    }

    static /* synthetic */ boolean b(e eVar, String str) {
        return eVar.b(str, "blacklist");
    }

    private boolean b(String str) {
        if (!this.j.isEmpty() || !this.i.isEmpty()) {
            boolean b2 = b(str, "whitelist");
            if (b(str, "blacklist") && !b2) {
                return true;
            }
        }
        return false;
    }

    private boolean b(String str, String str2) {
        List<String> list;
        str2.hashCode();
        switch (str2) {
            case "whitelist":
                list = this.j;
                break;
            case "pause":
                list = this.k;
                break;
            case "blacklist":
                list = this.i;
                break;
            default:
                list = this.m;
                break;
        }
        return !de.b(str) && de.a(str, list);
    }

    private static int c(int i, List<View> list) {
        try {
            List<View> f2 = f();
            HashMap hashMap = new HashMap();
            for (View view : f2) {
                Integer valueOf = Integer.valueOf(view.hashCode());
                Activity activity = null;
                r6 = null;
                View view2 = null;
                if (((!(view instanceof ViewGroup) || ((ViewGroup) view).getChildCount() <= 0) ? null : ((ViewGroup) view).getChildAt(0)) != null) {
                    if ((view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0) {
                        view2 = ((ViewGroup) view).getChildAt(0);
                    }
                    activity = de.c(view2);
                }
                hashMap.put(valueOf, activity != null ? activity.getClass().getSimpleName() : "");
            }
            String str = (String) hashMap.get(Integer.valueOf(list.get(i).hashCode()));
            if (de.b(str) || list.size() <= i) {
                return -1;
            }
            while (true) {
                i++;
                if (i >= list.size()) {
                    return -1;
                }
                String str2 = (String) hashMap.get(Integer.valueOf(list.get(i).hashCode()));
                if (!de.b(str2) && !str.equals(str2)) {
                    return i;
                }
            }
        } catch (Exception unused) {
            return -1;
        }
    }

    static Display c(Activity activity) {
        WindowManager windowManager = activity.getWindowManager();
        if (windowManager != null) {
            return windowManager.getDefaultDisplay();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(View view) {
        boolean z = view.getBackground() != null;
        if (z && (view.getBackground() instanceof ColorDrawable)) {
            return ((ColorDrawable) view.getBackground()).getColor() != 0;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: Exception -> 0x0042, TRY_LEAVE, TryCatch #0 {Exception -> 0x0042, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x000f, B:9:0x0017, B:11:0x002b, B:13:0x0032, B:18:0x003e), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String d(android.view.View r4) {
        /*
            java.lang.String r0 = ""
            boolean r1 = r4 instanceof android.widget.TextView     // Catch: java.lang.Exception -> L42
            if (r1 == 0) goto L42
            r1 = r4
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch: java.lang.Exception -> L42
            java.lang.CharSequence r1 = r1.getText()     // Catch: java.lang.Exception -> L42
            if (r1 == 0) goto L42
            int r2 = r1.length()     // Catch: java.lang.Exception -> L42
            r3 = 50
            if (r2 >= r3) goto L42
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.quantummetric.instrument.internal.da> r2 = com.quantummetric.ui.internal.df.i     // Catch: java.lang.Exception -> L42
            int r4 = r4.hashCode()     // Catch: java.lang.Exception -> L42
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Exception -> L42
            java.lang.Object r4 = r2.get(r4)     // Catch: java.lang.Exception -> L42
            com.quantummetric.instrument.internal.da r4 = (com.quantummetric.ui.internal.da) r4     // Catch: java.lang.Exception -> L42
            boolean r2 = r4 instanceof com.quantummetric.ui.internal.cz     // Catch: java.lang.Exception -> L42
            if (r2 == 0) goto L3b
            r2 = r4
            com.quantummetric.instrument.internal.cz r2 = (com.quantummetric.ui.internal.cz) r2     // Catch: java.lang.Exception -> L42
            boolean r2 = r2.o     // Catch: java.lang.Exception -> L42
            if (r2 != 0) goto L3b
            com.quantummetric.instrument.internal.cz r4 = (com.quantummetric.ui.internal.cz) r4     // Catch: java.lang.Exception -> L42
            boolean r4 = r4.p     // Catch: java.lang.Exception -> L42
            if (r4 == 0) goto L39
            goto L3b
        L39:
            r4 = 0
            goto L3c
        L3b:
            r4 = 1
        L3c:
            if (r4 != 0) goto L42
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Exception -> L42
        L42:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.e.d(android.view.View):java.lang.String");
    }

    private List<View> d() {
        ArrayList arrayList = new ArrayList();
        List<View> h = h();
        if (h.size() > 0) {
            arrayList.addAll(h);
        } else if (this.h.get() != null) {
            Activity activity = this.h.get();
            View findViewById = activity.findViewById(R.id.content);
            if (findViewById == null) {
                findViewById = activity.getWindow().getDecorView().findViewById(R.id.content);
            }
            arrayList.add(findViewById);
        }
        return arrayList;
    }

    private boolean d(Activity activity) {
        boolean z;
        int b2 = b(activity);
        int i = this.O;
        if (i < 0 || i == b2) {
            z = false;
        } else {
            z = true;
            this.Z = true;
        }
        this.O = b2;
        return z;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.quantummetric.instrument.internal.e$2] */
    private void e() {
        try {
            if (this.c && ag.c && this.U == null) {
                this.U = new am(new b() { // from class: com.quantummetric.instrument.internal.e.2
                    @Override // com.quantummetric.instrument.internal.e.b
                    public final void a(int i) {
                        am.a aVar;
                        if (e.this.H != null) {
                            df dfVar = e.this.H;
                            Iterator<am.a> it = dfVar.h.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    aVar = null;
                                    break;
                                } else {
                                    aVar = it.next();
                                    if (aVar.b == i) {
                                        break;
                                    }
                                }
                            }
                            if (aVar != null) {
                                dfVar.h.remove(aVar);
                            }
                        }
                    }

                    @Override // com.quantummetric.instrument.internal.e.b
                    public final void a(am.a aVar) {
                        if (e.this.H == null || e.this.h == null || e.this.h.get() == null) {
                            return;
                        }
                        dh.a(aVar.c, aVar.f55a);
                        if (e.b(e.this, aVar.f55a)) {
                            dh.a(aVar.c);
                        }
                        df dfVar = e.this.H;
                        dfVar.h.remove(aVar);
                        dfVar.h.add(aVar);
                        if (aa.w) {
                            e eVar = e.this;
                            e.a(eVar, (Activity) eVar.h.get());
                        }
                    }
                });
            }
            WeakReference<Activity> weakReference = this.h;
            if (weakReference == null || !ag.a(weakReference.get())) {
                return;
            }
            FragmentManager supportFragmentManager = ((FragmentActivity) this.h.get()).getSupportFragmentManager();
            supportFragmentManager.unregisterFragmentLifecycleCallbacks(this.U);
            supportFragmentManager.registerFragmentLifecycleCallbacks(this.U, true);
        } catch (Throwable unused) {
        }
    }

    private static void e(Activity activity) {
        if (activity != null) {
            try {
                TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new TypedValue().data, new int[]{R.attr.colorButtonNormal});
                aa.F = obtainStyledAttributes.getColor(0, 0);
                obtainStyledAttributes.recycle();
            } catch (Exception unused) {
            }
        }
    }

    private static boolean e(View view) {
        return view.getWidth() >= de.a() && de.b((double) (de.b() - view.getHeight())) < 81;
    }

    private static List<View> f() {
        ArrayList arrayList = new ArrayList();
        try {
            Object invoke = Class.forName("android.view.WindowManagerGlobal").getMethod("getInstance", new Class[0]).invoke(null, null);
            Object b2 = by.b(invoke, "mViews");
            Object b3 = by.b(invoke, "mLock");
            if ((b2 instanceof Collection) && b3 != null) {
                synchronized (b3) {
                    arrayList.addAll((Collection) b2);
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private void g() {
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke(null, null);
            Object b2 = by.b(invoke, "mRoots");
            if (!(b2 instanceof ArrayList) || (b2 instanceof g)) {
                return;
            }
            g gVar = new g(new g.a<Object>() { // from class: com.quantummetric.instrument.internal.e.4

                /* renamed from: com.quantummetric.instrument.internal.e$4$1, reason: invalid class name */
                final class AnonymousClass1 implements Runnable {
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        e.j(e.this);
                    }
                }

                @Override // com.quantummetric.instrument.internal.g.a
                public final void a() {
                    cl.c(new AnonymousClass1());
                }

                @Override // com.quantummetric.instrument.internal.g.a
                public final void a(Object obj) {
                    cl.c(new AnonymousClass1());
                }
            });
            gVar.addAll((ArrayList) b2);
            Field declaredField = cls.getDeclaredField("mRoots");
            declaredField.setAccessible(true);
            declaredField.set(invoke, gVar);
        } catch (Throwable unused) {
        }
    }

    private List<View> h() {
        ArrayList arrayList = new ArrayList();
        try {
            List<View> f2 = f();
            for (View view : f2) {
                if (ae.a(view)) {
                    Activity activity = null;
                    r6 = null;
                    View view2 = null;
                    if (((!(view instanceof ViewGroup) || ((ViewGroup) view).getChildCount() <= 0) ? null : ((ViewGroup) view).getChildAt(0)) != null) {
                        if ((view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0) {
                            view2 = ((ViewGroup) view).getChildAt(0);
                        }
                        activity = de.c(view2);
                    }
                    if (activity != null && !this.D.contains(Integer.valueOf(activity.hashCode()))) {
                    }
                }
                arrayList.add(view);
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(f2);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x01fc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void j(com.quantummetric.ui.internal.e r13) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.e.j(com.quantummetric.instrument.internal.e):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d A[Catch: all -> 0x005e, TryCatch #0 {all -> 0x005e, blocks: (B:4:0x0003, B:6:0x0013, B:11:0x001d, B:13:0x0021, B:14:0x0028, B:16:0x002e, B:18:0x0034, B:22:0x0041, B:25:0x0049, B:28:0x004b, B:30:0x0051, B:33:0x0055), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0051 A[Catch: all -> 0x005e, TryCatch #0 {all -> 0x005e, blocks: (B:4:0x0003, B:6:0x0013, B:11:0x001d, B:13:0x0021, B:14:0x0028, B:16:0x002e, B:18:0x0034, B:22:0x0041, B:25:0x0049, B:28:0x004b, B:30:0x0051, B:33:0x0055), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0055 A[Catch: all -> 0x005e, TRY_LEAVE, TryCatch #0 {all -> 0x005e, blocks: (B:4:0x0003, B:6:0x0013, B:11:0x001d, B:13:0x0021, B:14:0x0028, B:16:0x002e, B:18:0x0034, B:22:0x0041, B:25:0x0049, B:28:0x004b, B:30:0x0051, B:33:0x0055), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void a(final android.app.Activity r5, final java.lang.String r6, final boolean r7) {
        /*
            r4 = this;
            if (r5 == 0) goto L60
            r0 = 0
            java.lang.Class r1 = r5.getClass()     // Catch: java.lang.Throwable -> L5e
            java.lang.String r1 = r1.getSimpleName()     // Catch: java.lang.Throwable -> L5e
            r4.a(r1, r6)     // Catch: java.lang.Throwable -> L5e
            boolean r1 = com.quantummetric.ui.internal.cd.f161a     // Catch: java.lang.Throwable -> L5e
            r2 = 1
            if (r1 != 0) goto L1a
            com.quantummetric.instrument.internal.bu r1 = com.quantummetric.ui.QuantumMetric.b     // Catch: java.lang.Throwable -> L5e
            if (r1 != 0) goto L18
            goto L1a
        L18:
            r1 = r0
            goto L1b
        L1a:
            r1 = r2
        L1b:
            if (r1 != 0) goto L4b
            com.quantummetric.instrument.internal.an r1 = com.quantummetric.ui.internal.an.f56a     // Catch: java.lang.Throwable -> L5e
            if (r1 != 0) goto L28
            com.quantummetric.instrument.internal.an r1 = new com.quantummetric.instrument.internal.an     // Catch: java.lang.Throwable -> L5e
            r1.<init>()     // Catch: java.lang.Throwable -> L5e
            com.quantummetric.ui.internal.an.f56a = r1     // Catch: java.lang.Throwable -> L5e
        L28:
            com.quantummetric.instrument.internal.an r1 = com.quantummetric.ui.internal.an.f56a     // Catch: java.lang.Throwable -> L5e
            boolean r3 = r1.d     // Catch: java.lang.Throwable -> L5e
            if (r3 == 0) goto L3e
            boolean r3 = com.quantummetric.ui.internal.de.b(r6)     // Catch: java.lang.Throwable -> L5e
            if (r3 != 0) goto L3e
            java.util.Set<java.lang.String> r1 = r1.g     // Catch: java.lang.Throwable -> L5e
            boolean r1 = r1.contains(r6)     // Catch: java.lang.Throwable -> L5e
            if (r1 == 0) goto L3e
            r1 = r2
            goto L3f
        L3e:
            r1 = r0
        L3f:
            if (r1 != 0) goto L48
            boolean r1 = r4.b(r6)     // Catch: java.lang.Throwable -> L5e
            if (r1 == 0) goto L48
            goto L49
        L48:
            r2 = r0
        L49:
            r4.g = r2     // Catch: java.lang.Throwable -> L5e
        L4b:
            boolean r1 = com.quantummetric.ui.internal.cl.a()     // Catch: java.lang.Throwable -> L5e
            if (r1 == 0) goto L55
            r4.b(r5, r6, r7)     // Catch: java.lang.Throwable -> L5e
            return
        L55:
            com.quantummetric.instrument.internal.e$1 r1 = new com.quantummetric.instrument.internal.e$1     // Catch: java.lang.Throwable -> L5e
            r1.<init>()     // Catch: java.lang.Throwable -> L5e
            com.quantummetric.ui.internal.cl.c(r1)     // Catch: java.lang.Throwable -> L5e
            goto L60
        L5e:
            r4.f = r0
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.e.a(android.app.Activity, java.lang.String, boolean):void");
    }

    final void a(Window window) {
        View decorView = window != null ? window.getDecorView() : null;
        HashSet hashSet = new HashSet();
        for (Map.Entry<f, WeakReference<View>> entry : this.W.entrySet()) {
            if (entry.getValue() == null || entry.getValue().get() == null || entry.getValue().get() == decorView) {
                hashSet.add(entry.getKey());
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            this.W.remove((f) it.next());
        }
    }

    final void a(String str) {
        if (QuantumMetric.b != null) {
            if (de.b(str)) {
                str = this.P;
            } else {
                this.P = str;
            }
            WeakReference<Activity> weakReference = this.h;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            a(this.h.get(), str, true);
        }
    }

    final void a(String str, String str2) {
        if (this.m.isEmpty() && this.k.isEmpty()) {
            return;
        }
        boolean z = b(str, "resume") || b(str2, "resume");
        boolean z2 = b(str, "pause") || b(str2, "pause");
        if (this.l && z2) {
            cd.a(true);
        } else if (z) {
            cd.a(false);
        } else if (z2) {
            cd.a(true);
        }
    }

    final boolean a(String str, boolean z) {
        if (de.b(str)) {
            return false;
        }
        String c2 = c();
        String str2 = this.P;
        if (str2 == null) {
            str2 = "";
        }
        if (z) {
            if (!de.a(c2, str) && !de.a(str2, str)) {
                return false;
            }
        } else if (!c2.equals(str) && !str2.equals(str)) {
            return false;
        }
        return true;
    }

    final int b() {
        WeakReference<Activity> weakReference = this.h;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return this.h.get().hashCode();
    }

    final String c() {
        WeakReference<Activity> weakReference = this.h;
        return (weakReference == null || weakReference.get() == null) ? "" : this.h.get().getClass().getSimpleName();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.X = false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.X = false;
        this.F.remove(Integer.valueOf(activity.hashCode()));
        a(activity.getWindow());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0022 A[SYNTHETIC] */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onActivityPaused(android.app.Activity r11) {
        /*
            r10 = this;
            r0 = 0
            r10.X = r0
            boolean r1 = r10.c
            if (r1 == 0) goto Ld4
            java.util.List<java.lang.Integer> r1 = r10.D
            r1.clear()
            r1 = 1
            if (r11 == 0) goto L7c
            boolean r2 = r11.isFinishing()
            if (r2 == 0) goto L7c
            int r2 = r11.hashCode()
            java.util.List r3 = f()
            java.util.Iterator r3 = r3.iterator()
            r4 = r0
        L22:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L7c
            java.lang.Object r5 = r3.next()
            android.view.View r5 = (android.view.View) r5
            boolean r6 = r5 instanceof android.view.ViewGroup
            r7 = 0
            if (r6 == 0) goto L41
            r8 = r5
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            int r9 = r8.getChildCount()
            if (r9 <= 0) goto L41
            android.view.View r8 = r8.getChildAt(r0)
            goto L42
        L41:
            r8 = r7
        L42:
            if (r8 == 0) goto L56
            if (r6 == 0) goto L52
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            int r6 = r5.getChildCount()
            if (r6 <= 0) goto L52
            android.view.View r7 = r5.getChildAt(r0)
        L52:
            android.app.Activity r7 = com.quantummetric.ui.internal.de.c(r7)
        L56:
            if (r7 == 0) goto L22
            int r5 = r7.hashCode()
            java.util.List<java.lang.Integer> r6 = r10.D
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            boolean r6 = r6.contains(r7)
            if (r6 != 0) goto L6c
            if (r2 != r5) goto L6c
            r6 = r1
            goto L6d
        L6c:
            r6 = r0
        L6d:
            if (r6 == 0) goto L70
            r4 = r1
        L70:
            if (r4 == 0) goto L22
            java.util.List<java.lang.Integer> r6 = r10.D
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6.add(r5)
            goto L22
        L7c:
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r3 = r11.findViewById(r2)
            if (r3 != 0) goto L91
            android.view.Window r11 = r11.getWindow()
            android.view.View r11 = r11.getDecorView()
            android.view.View r3 = r11.findViewById(r2)
        L91:
            android.view.View r11 = com.quantummetric.ui.internal.de.e(r3)
            if (r11 == 0) goto Lc2
            java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> r2 = r10.G
            int r3 = r11.hashCode()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r2 = r2.containsKey(r3)
            if (r2 != 0) goto Lc2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r10.a(r2, r11)
            int r3 = r2.size()
            if (r3 <= 0) goto Lc2
            java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> r3 = r10.G
            int r11 = r11.hashCode()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r3.put(r11, r2)
        Lc2:
            boolean r11 = com.quantummetric.ui.internal.cd.f161a
            if (r11 != 0) goto Lca
            com.quantummetric.instrument.internal.bu r11 = com.quantummetric.ui.QuantumMetric.b
            if (r11 != 0) goto Lcb
        Lca:
            r0 = r1
        Lcb:
            if (r0 != 0) goto Ld4
            com.quantummetric.instrument.internal.df r11 = r10.H
            if (r11 == 0) goto Ld4
            com.quantummetric.ui.internal.df.c()
        Ld4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.e.onActivityPaused(android.app.Activity):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (this.X) {
            return;
        }
        if (this.M) {
            this.X = true;
        }
        this.h = new WeakReference<>(activity);
        if (!this.F.contains(Integer.valueOf(activity.hashCode()))) {
            this.F.add(Integer.valueOf(activity.hashCode()));
            this.f242a++;
        }
        if (this.c) {
            if (this.Q) {
                this.Q = false;
                if (!aa.j) {
                    this.R = true;
                    r2 = de.b(this.P) ? null : this.P;
                    if (!aa.i) {
                        return;
                    }
                }
                ak.a().a(ak.a.APP_RESUME);
            } else {
                this.P = null;
            }
            a(activity, r2, this.u);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        this.h = new WeakReference<>(activity);
        this.F.add(Integer.valueOf(activity.hashCode()));
        this.X = false;
        if (this.c) {
            e();
        }
        if (aa.j) {
            return;
        }
        if (this.f242a == 0) {
            if (this.b > 0 && this.c && !this.S) {
                this.Q = true;
                this.e = true;
                bz.a().c();
                bu.AnonymousClass1.RunnableC00311.C00321 c00321 = this.I;
                if (c00321 != null) {
                    c00321.b();
                }
                df dfVar = this.H;
                if (dfVar != null && dfVar.d != null && dfVar.d.size() > 0) {
                    dfVar.d();
                }
                this.Y = "";
            }
            this.b = System.currentTimeMillis();
        }
        this.S = activity.isChangingConfigurations();
        this.f242a++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        int i;
        this.X = false;
        boolean z = true;
        if (this.F.contains(Integer.valueOf(activity.hashCode())) && (i = this.f242a) > 0) {
            this.f242a = i - 1;
        }
        this.S = activity.isChangingConfigurations();
        if (aa.j || this.S || this.f242a != 0 || !this.c) {
            return;
        }
        this.e = false;
        bz a2 = bz.a();
        try {
            if (a2.h != null) {
                a2.h.f156a = true;
            }
        } catch (Exception unused) {
        }
        dk.a(true);
        bu.AnonymousClass1.RunnableC00311.C00321 c00321 = this.I;
        if (c00321 != null) {
            c00321.a();
        }
        ak.a().a(ak.a.APP_SUSPEND);
        df dfVar = this.H;
        if (dfVar != null && dfVar.e != null) {
            dfVar.e.cancel();
        }
        if (aa.i) {
            List<Integer> list = this.D;
            if (list != null) {
                list.clear();
            }
            df dfVar2 = this.H;
            if (dfVar2 != null) {
                if (dfVar2.c != null) {
                    dfVar2.c.clear();
                } else {
                    dfVar2.c = new HashSet<>();
                }
            }
            List<Integer> list2 = this.E;
            if (list2 != null) {
                list2.clear();
            }
        }
        if (!cd.f161a && QuantumMetric.b != null) {
            z = false;
        }
        if (z) {
            return;
        }
        QuantumMetric.sendEvent(-20, "", new EventType[0]);
    }
}
