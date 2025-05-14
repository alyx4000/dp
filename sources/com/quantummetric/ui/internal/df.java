package com.quantummetric.ui.internal;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.quantummetric.ui.QuantumMetric;
import com.quantummetric.ui.internal.af;
import com.quantummetric.ui.internal.am;
import com.quantummetric.ui.internal.ax;
import com.quantummetric.ui.internal.ba;
import com.quantummetric.ui.internal.ck;
import com.quantummetric.ui.internal.cl;
import com.quantummetric.ui.internal.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes5.dex */
final class df {
    static boolean f = false;
    static boolean g = false;
    static ConcurrentHashMap<Integer, da> i = new ConcurrentHashMap<>();
    static Map<Integer, da> j = new HashMap();
    private static int n = 1000;
    private static int o = 0;
    private static cb p = null;
    private static AnonymousClass1 t = null;
    private static int w = 5000;
    private List<String> A;
    private int B;
    private int C;
    private int D;
    private boolean E;
    private boolean F;
    private int G;
    private boolean H;
    private List<String> L;

    /* renamed from: a, reason: collision with root package name */
    b f185a;
    Timer e;
    boolean k;
    volatile String l;
    cl.a m;
    private AnonymousClass41 q;
    private AnonymousClass7 r;
    private c s;
    private List<String> z;
    private HashSet<Integer> x = new HashSet<>();
    private HashSet<Integer> y = new HashSet<>();
    HashSet<am.a> h = new HashSet<>();
    Set<da> d = Collections.newSetFromMap(new ConcurrentHashMap());
    HashSet<Integer> b = new HashSet<>();
    HashSet<Integer> c = new HashSet<>();
    private List<String> I = new ArrayList();
    private List<String> J = new ArrayList();
    private Set<Integer> K = Collections.newSetFromMap(new ConcurrentHashMap());
    private List<String> u = new ArrayList();
    private List<String> v = new ArrayList();

    /* renamed from: com.quantummetric.instrument.internal.df$12, reason: invalid class name */
    final class AnonymousClass12 implements o<di> {
        AnonymousClass12() {
        }

        @Override // com.quantummetric.ui.internal.o
        public final /* bridge */ /* synthetic */ void a(di diVar) {
            df.this.a(diVar.f240a, false);
        }
    }

    /* renamed from: com.quantummetric.instrument.internal.df$25, reason: invalid class name */
    final class AnonymousClass25 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private /* synthetic */ WeakReference f204a;

        AnonymousClass25(WeakReference weakReference) {
            this.f204a = weakReference;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ct ctVar = (ct) this.f204a.get();
            if (ctVar == null || !(ctVar.B.get() instanceof ProgressBar)) {
                return;
            }
            ProgressBar progressBar = (ProgressBar) ctVar.B.get();
            Object indeterminateDrawable = progressBar.getIndeterminateDrawable();
            if ((indeterminateDrawable instanceof Animatable) && ((Animatable) indeterminateDrawable).isRunning() && ctVar.o > 0 && System.currentTimeMillis() - ctVar.o >= ((long) (bq.C * 1000))) {
                String a2 = de.a((View) progressBar);
                if (de.b(a2)) {
                    a2 = progressBar.getClass().getSimpleName();
                }
                if (bq.D.contains(a2)) {
                    return;
                }
                QuantumMetric.a(-22, a2 + ": Load exceeded " + bq.C + " seconds", new j[0]);
            }
        }
    }

    /* renamed from: com.quantummetric.instrument.internal.df$33, reason: invalid class name */
    final class AnonymousClass33 implements Runnable {
        AnonymousClass33() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str = df.this.l;
            df.this.l = "";
            com.quantummetric.ui.internal.e.a().a(str);
        }
    }

    /* renamed from: com.quantummetric.instrument.internal.df$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private /* synthetic */ WeakReference f223a;
        private /* synthetic */ int b;
        private /* synthetic */ boolean c;
        private /* synthetic */ int d;

        AnonymousClass4(WeakReference weakReference, int i, boolean z, int i2) {
            this.f223a = weakReference;
            this.b = i;
            this.c = z;
            this.d = i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                r6 = this;
                java.lang.ref.WeakReference r0 = r6.f223a
                java.lang.Object r0 = r0.get()
                android.view.View r0 = (android.view.View) r0
                if (r0 == 0) goto L79
                android.graphics.drawable.Drawable r1 = com.quantummetric.ui.internal.df.d(r0)
                boolean r2 = r1 instanceof android.graphics.drawable.AnimatedStateListDrawable
                r3 = 0
                if (r2 == 0) goto L22
                android.graphics.drawable.Drawable r1 = r1.getCurrent()
                boolean r2 = r1 instanceof android.graphics.drawable.AnimatedVectorDrawable
                if (r2 == 0) goto L22
                android.graphics.drawable.AnimatedVectorDrawable r1 = (android.graphics.drawable.AnimatedVectorDrawable) r1
                boolean r1 = r1.isRunning()
                goto L23
            L22:
                r1 = r3
            L23:
                boolean r2 = com.quantummetric.ui.internal.ag.j(r0)
                r4 = 4
                r5 = 1
                if (r2 == 0) goto L38
                boolean r2 = com.quantummetric.ui.internal.de.d(r0)
                if (r2 != 0) goto L38
                int r1 = r6.b
                if (r1 > r4) goto L37
                r1 = r5
                goto L38
            L37:
                r1 = r3
            L38:
                if (r1 == 0) goto L4b
                int r0 = r6.b
                if (r0 > r4) goto L79
                com.quantummetric.instrument.internal.df r1 = com.quantummetric.ui.internal.df.this
                java.lang.ref.WeakReference r2 = r6.f223a
                int r0 = r0 + r5
                boolean r3 = r6.c
                int r4 = r6.d
                com.quantummetric.ui.internal.df.a(r1, r2, r0, r3, r4)
                return
            L4b:
                boolean r1 = r6.c
                if (r1 == 0) goto L74
                android.view.ViewParent r1 = r0.getParent()
                boolean r1 = r1 instanceof android.widget.RadioGroup
                if (r1 == 0) goto L74
                android.view.ViewParent r0 = r0.getParent()
                android.widget.RadioGroup r0 = (android.widget.RadioGroup) r0
            L5d:
                int r1 = r0.getChildCount()
                if (r3 >= r1) goto L73
                android.view.View r1 = r0.getChildAt(r3)
                boolean r2 = r1 instanceof android.widget.RadioButton
                if (r2 == 0) goto L70
                com.quantummetric.instrument.internal.df r2 = com.quantummetric.ui.internal.df.this
                com.quantummetric.ui.internal.df.c(r2, r1)
            L70:
                int r3 = r3 + 1
                goto L5d
            L73:
                return
            L74:
                com.quantummetric.instrument.internal.df r1 = com.quantummetric.ui.internal.df.this
                com.quantummetric.ui.internal.df.c(r1, r0)
            L79:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.df.AnonymousClass4.run():void");
        }
    }

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        boolean f232a = false;
        private final WeakReference<cs> b;
        private float c;

        a(cs csVar, float f) {
            this.b = new WeakReference<>(csVar);
            this.c = f;
        }

        @Override // java.lang.Runnable
        public final void run() {
            cs csVar = this.b.get();
            if (csVar != null && (csVar.B.get() instanceof ImageView)) {
                Drawable drawable = ((ImageView) csVar.B.get()).getDrawable();
                if (ag.b(drawable)) {
                    DrawerArrowDrawable drawerArrowDrawable = (DrawerArrowDrawable) drawable;
                    if (this.c != drawerArrowDrawable.getProgress()) {
                        this.c = drawerArrowDrawable.getProgress();
                        df.a(df.this, (ImageView) csVar.B.get(), csVar);
                    }
                }
            }
            this.f232a = false;
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        private List<WeakReference<da>> b = new CopyOnWriteArrayList();

        b() {
        }

        final void a(final cr crVar) {
            boolean z;
            if (crVar == null || crVar.B.get() == null) {
                return;
            }
            Iterator<WeakReference<da>> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                WeakReference<da> next = it.next();
                if (next.get() != null && next.get().B.get() == crVar.B.get()) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                View view = crVar.B.get();
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
                this.b.add(new WeakReference<>(crVar));
            }
            if (crVar.f157a) {
                cl.a(new Runnable() { // from class: com.quantummetric.instrument.internal.df.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        df.c(df.this, crVar);
                    }
                }, 1000);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x003c A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x000e A[Catch: Exception -> 0x003c, TryCatch #0 {Exception -> 0x003c, blocks: (B:2:0x0000, B:4:0x0004, B:9:0x000e, B:10:0x0014, B:12:0x001a, B:14:0x0028, B:21:0x0030, B:17:0x0036), top: B:1:0x0000 }] */
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onGlobalLayout() {
            /*
                r4 = this;
                boolean r0 = com.quantummetric.ui.internal.cd.f161a     // Catch: java.lang.Exception -> L3c
                if (r0 != 0) goto Lb
                com.quantummetric.instrument.internal.bu r0 = com.quantummetric.ui.QuantumMetric.b     // Catch: java.lang.Exception -> L3c
                if (r0 != 0) goto L9
                goto Lb
            L9:
                r0 = 0
                goto Lc
            Lb:
                r0 = 1
            Lc:
                if (r0 != 0) goto L3c
                java.util.List<java.lang.ref.WeakReference<com.quantummetric.instrument.internal.da>> r0 = r4.b     // Catch: java.lang.Exception -> L3c
                java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L3c
            L14:
                boolean r1 = r0.hasNext()     // Catch: java.lang.Exception -> L3c
                if (r1 == 0) goto L3c
                java.lang.Object r1 = r0.next()     // Catch: java.lang.Exception -> L3c
                java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch: java.lang.Exception -> L3c
                java.lang.Object r2 = r1.get()     // Catch: java.lang.Exception -> L3c
                com.quantummetric.instrument.internal.da r2 = (com.quantummetric.ui.internal.da) r2     // Catch: java.lang.Exception -> L3c
                if (r2 == 0) goto L36
                java.lang.ref.WeakReference<android.view.View> r3 = r2.B     // Catch: java.lang.Exception -> L3c
                java.lang.Object r3 = r3.get()     // Catch: java.lang.Exception -> L3c
                if (r3 == 0) goto L36
                com.quantummetric.instrument.internal.df r1 = com.quantummetric.ui.internal.df.this     // Catch: java.lang.Exception -> L3c
                com.quantummetric.ui.internal.df.c(r1, r2)     // Catch: java.lang.Exception -> L3c
                goto L14
            L36:
                java.util.List<java.lang.ref.WeakReference<com.quantummetric.instrument.internal.da>> r2 = r4.b     // Catch: java.lang.Exception -> L3c
                r2.remove(r1)     // Catch: java.lang.Exception -> L3c
                goto L14
            L3c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.instrument.internal.df.b.onGlobalLayout():void");
        }
    }

    class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        boolean f235a = true;
        boolean b = false;

        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (this.b) {
                return;
            }
            if (cd.f161a || QuantumMetric.b == null) {
                return;
            }
            int i = this.f235a ? df.this.C : df.this.D;
            this.f235a = false;
            this.b = true;
            cl.a(new Runnable() { // from class: com.quantummetric.instrument.internal.df.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    Iterator<da> it = df.i.values().iterator();
                    while (it.hasNext()) {
                        df.c(df.this, it.next());
                    }
                    c.this.b = false;
                }
            }, i);
        }
    }

    static class d implements ViewTreeObserver.OnScrollChangedListener {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<cx> f237a = new WeakReference<>(null);
        private final WeakReference<View> b;
        private final WeakReference<ViewTreeObserver> c;

        d(View view) {
            this.b = new WeakReference<>(view);
            this.c = new WeakReference<>(view.getViewTreeObserver());
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            try {
                View view = this.b.get();
                if (view == null) {
                    if (this.c.get() != null) {
                        this.c.get().removeOnScrollChangedListener(this);
                        return;
                    }
                    return;
                }
                if (this.f237a.get() == null) {
                    da daVar = df.i.get(Integer.valueOf(view.hashCode()));
                    if (daVar instanceof cx) {
                        this.f237a = new WeakReference<>((cx) daVar);
                    }
                }
                cx cxVar = this.f237a.get();
                if (cxVar == null || !cxVar.b(view)) {
                    return;
                }
                df.a(view, cxVar);
            } catch (Exception unused) {
            }
        }
    }

    interface e {
        void a(da daVar);
    }

    /* JADX WARN: Type inference failed for: r4v16, types: [com.quantummetric.instrument.internal.df$1] */
    df() {
        JSONObject optJSONObject;
        this.C = 1000;
        this.D = 3000;
        this.E = true;
        this.F = true;
        this.G = 200;
        this.H = false;
        this.z = new ArrayList();
        this.A = new ArrayList();
        this.L = new ArrayList();
        t = new e() { // from class: com.quantummetric.instrument.internal.df.1
            @Override // com.quantummetric.instrument.internal.df.e
            public final void a(da daVar) {
                df.a(df.this, daVar);
            }
        };
        p = new cb();
        y yVar = QuantumMetric.f9a;
        if (yVar != null) {
            try {
                boolean z = ag.b;
                boolean z2 = ag.b;
                JSONObject optJSONObject2 = yVar.optJSONObject("view");
                if (optJSONObject2 != null) {
                    z = optJSONObject2.optBoolean("v_track", z);
                    z2 = optJSONObject2.optBoolean("t_track", z2);
                    int optInt = optJSONObject2.optInt("v_track_interval", 5000);
                    w = optInt > 0 ? optInt : 5000;
                    n = optJSONObject2.optInt("update_style_delay_ms", 1000);
                    o = optJSONObject2.optInt("scroll_update_delay");
                    List<String> a2 = y.a(optJSONObject2, "add_v_track");
                    List<String> a3 = y.a(optJSONObject2, "add_class_track");
                    this.u.addAll(a2);
                    this.v.addAll(a3);
                    this.J.addAll(y.a(optJSONObject2, "delayed_update"));
                    this.I.addAll(y.a(optJSONObject2, "block_listener"));
                    List<String> a4 = y.a(optJSONObject2, "add_delay_views");
                    List<String> a5 = y.a(optJSONObject2, "child_delay_class");
                    int optInt2 = optJSONObject2.optInt("add_delay", 50);
                    this.z = a4;
                    this.A = a5;
                    this.B = optInt2;
                    int optInt3 = optJSONObject2.optInt("global_first_interval", 1000);
                    int optInt4 = optJSONObject2.optInt("global_interval", 3000);
                    this.C = optInt3;
                    this.D = optInt4;
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("optimization");
                    if (optJSONObject3 != null) {
                        this.E = optJSONObject3.optBoolean("wait_layout", true);
                        this.F = optJSONObject3.optBoolean("block_layout_updates", true);
                        this.G = optJSONObject3.optInt("layout_update_delay", this.G);
                        this.H = optJSONObject3.optBoolean("recycler_children", this.H);
                    }
                    this.L = y.a(optJSONObject2, "ellips_text_listener");
                    cc.a(optJSONObject2);
                    aa.u = optJSONObject2.optBoolean("zindex_enabled", true);
                    aa.E = optJSONObject2.optBoolean("custom_drawing_order", false);
                    aa.x = optJSONObject2.optBoolean("grad_assum", true);
                    aa.z = optJSONObject2.optBoolean("span_enabled", true);
                    aa.v = optJSONObject2.optBoolean("react_track_overflow", aa.v);
                    dk.f241a = optJSONObject2.optBoolean("tap_enabled", true);
                    cj.f166a = (float) optJSONObject2.optDouble("decrease_font_size", 1.0d);
                    cy.p = optJSONObject2.optBoolean("input_refl", true);
                    y.j = y.a(optJSONObject2, "block_tint_for_views");
                    y.k = y.a(optJSONObject2, "get_wrapped_drawable");
                }
                f = z;
                g = z2;
            } catch (Exception unused) {
            }
            cb cbVar = p;
            try {
                JSONObject optJSONObject4 = yVar.optJSONObject("stat");
                if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject(ViewProps.SCROLL)) != null && optJSONObject != null) {
                    cbVar.f158a = optJSONObject.optBoolean("enabled", true);
                    cbVar.b = y.a(optJSONObject, "root_names");
                    cbVar.c = y.a(optJSONObject, "ignore_names");
                    cbVar.d = (cbVar.b.isEmpty() && cbVar.c.isEmpty()) ? false : true;
                }
            } catch (Exception unused2) {
            }
            if (ba.f99a == null) {
                ba.f99a = new ba();
            }
            this.k = !ba.f99a.d.containsKey("AbsListView");
        }
    }

    static /* synthetic */ ViewGroup.OnHierarchyChangeListener a(ViewGroup viewGroup) {
        return (ViewGroup.OnHierarchyChangeListener) by.b(viewGroup, ViewGroup.class, "mOnHierarchyChangeListener");
    }

    static da a(int i2) {
        for (da daVar : i.values()) {
            if ((daVar instanceof cz) && ((cz) daVar).w == i2) {
                return daVar;
            }
        }
        return null;
    }

    static ConcurrentHashMap<Integer, da> a() {
        return i;
    }

    static void a(int i2, da daVar) {
        try {
            ConcurrentHashMap<Integer, da> concurrentHashMap = i;
            if (concurrentHashMap == null || j == null || daVar == null) {
                return;
            }
            concurrentHashMap.put(Integer.valueOf(i2), daVar);
            if ((daVar instanceof db) || (daVar instanceof cx)) {
                j.put(Integer.valueOf(i2), daVar);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, View view2) {
        if (view2 == null || view == null) {
            return;
        }
        if (cd.f161a || QuantumMetric.b == null) {
            return;
        }
        da daVar = i.get(Integer.valueOf(view.hashCode()));
        Iterator<am.a> it = this.h.iterator();
        while (it.hasNext()) {
            am.a next = it.next();
            if (next.c == view2.hashCode()) {
                if (an.f56a == null) {
                    an.f56a = new an();
                }
                an anVar = an.f56a;
                if (anVar.a(next.f55a, view, view2)) {
                    String str = next.f55a;
                    com.quantummetric.ui.internal.e a2 = com.quantummetric.ui.internal.e.a();
                    if (a2 != null) {
                        QuantumMetric.sendNewPageNamed(anVar.a(a2.c(), str));
                        return;
                    }
                    return;
                }
            }
        }
        if (ag.a(view) && (daVar instanceof cx)) {
            ((cx) daVar).v = true;
        }
        if (h(view2)) {
            cl.a(this.m);
            this.m = cl.b(new AnonymousClass33(), 500);
            return;
        }
        com.quantummetric.ui.internal.e a3 = com.quantummetric.ui.internal.e.a();
        if (a3.f || a3.g) {
            return;
        }
        final com.quantummetric.ui.internal.b a4 = com.quantummetric.ui.internal.a.a(view2, com.quantummetric.ui.internal.a.a(view), b(view2, view), new AnonymousClass12());
        a(view2);
        if ((a4 instanceof dg) && a4.n == 0.0f) {
            cl.a(new Runnable() { // from class: com.quantummetric.instrument.internal.df.9
                @Override // java.lang.Runnable
                public final void run() {
                    if (a4.e instanceof da) {
                        df.c(df.this, (da) a4.e);
                    }
                }
            }, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
        if (g) {
            if ((view.getTranslationX() == 0.0f && view.getTranslationY() == 0.0f) || daVar == null) {
                return;
            }
            this.d.add(daVar);
            if (this.e == null) {
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, final cx cxVar) {
        if (cxVar.x) {
            if (cd.f161a || QuantumMetric.b == null) {
                return;
            }
            cxVar.x = false;
            final String a2 = com.quantummetric.ui.internal.a.a(view);
            cl.a(new Runnable() { // from class: com.quantummetric.instrument.internal.df.21
                @Override // java.lang.Runnable
                public final void run() {
                    cx.this.x = true;
                    int b2 = de.b(cx.this.s);
                    int b3 = de.b(cx.this.t);
                    if (cx.this.z) {
                        com.quantummetric.ui.internal.a.a(a2, b2, b3);
                    } else {
                        com.quantummetric.ui.internal.a.b(a2, b2, b3);
                    }
                    if (cx.this.y) {
                        cb cbVar = df.p;
                        try {
                            if (cbVar.e == cx.this) {
                                cbVar.j = true;
                                cbVar.b();
                                if (cbVar.g > 0) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long currentTimeMillis2 = System.currentTimeMillis() - cbVar.k;
                                    if (currentTimeMillis2 > 1000) {
                                        cbVar.a(currentTimeMillis, currentTimeMillis2);
                                        cbVar.a(false, currentTimeMillis);
                                    }
                                    int b4 = (cbVar.f.b() * 100) / cbVar.g;
                                    if (b4 > 100 || b4 <= cbVar.h) {
                                        return;
                                    }
                                    cbVar.h = b4;
                                    QuantumMetric.a("xs", Integer.valueOf(cbVar.h));
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }, o);
        }
    }

    private void a(final View view, da daVar) {
        Drawable drawable = daVar.C.get();
        if (ah.a(drawable)) {
            ah ahVar = (ah) drawable;
            if (ahVar.d != null && ahVar.d.d > 0) {
                cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.df.32
                    @Override // java.lang.Runnable
                    public final void run() {
                        df.this.a(view, true, false);
                    }
                }, Math.max(ahVar.d.d, 500));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0092, code lost:
    
        if (r13.g == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0094, code lost:
    
        r13.g.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0099, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return;
     */
    /* JADX WARN: Type inference failed for: r0v3, types: [V, com.quantummetric.instrument.internal.b, com.quantummetric.instrument.internal.dg] */
    /* JADX WARN: Type inference failed for: r13v3, types: [V, java.lang.Boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(final android.view.View r12, final boolean r13, boolean r14) {
        /*
            r11 = this;
            com.quantummetric.instrument.internal.ap r6 = new com.quantummetric.instrument.internal.ap     // Catch: java.lang.Exception -> L99
            r6.<init>()     // Catch: java.lang.Exception -> L99
            com.quantummetric.instrument.internal.ap r7 = new com.quantummetric.instrument.internal.ap     // Catch: java.lang.Exception -> L99
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> L99
            r7.<init>(r0)     // Catch: java.lang.Exception -> L99
            com.quantummetric.instrument.internal.bp r8 = new com.quantummetric.instrument.internal.bp     // Catch: java.lang.Exception -> L99
            com.quantummetric.instrument.internal.bz r9 = com.quantummetric.ui.internal.bz.a()     // Catch: java.lang.Exception -> L99
            com.quantummetric.instrument.internal.df$31 r10 = new com.quantummetric.instrument.internal.df$31     // Catch: java.lang.Exception -> L99
            r0 = r10
            r1 = r11
            r2 = r6
            r3 = r12
            r4 = r13
            r5 = r7
            r0.<init>()     // Catch: java.lang.Exception -> L99
            r8.<init>(r9, r10)     // Catch: java.lang.Exception -> L99
            r0 = 0
            com.quantummetric.instrument.internal.dg r0 = com.quantummetric.ui.internal.dh.a(r12, r0, r8)     // Catch: java.lang.Exception -> L99
            r1 = 1
            r2 = 0
            if (r13 == 0) goto L35
            com.quantummetric.instrument.internal.c r13 = r0.e     // Catch: java.lang.Exception -> L99
            java.lang.String r13 = r13.m     // Catch: java.lang.Exception -> L99
            boolean r13 = com.quantummetric.ui.internal.de.b(r13)     // Catch: java.lang.Exception -> L99
            if (r13 != 0) goto L35
            r13 = r1
            goto L36
        L35:
            r13 = r2
        L36:
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)     // Catch: java.lang.Exception -> L99
            r7.f61a = r13     // Catch: java.lang.Exception -> L99
            if (r14 == 0) goto L45
            com.quantummetric.instrument.internal.c r13 = r0.e     // Catch: java.lang.Exception -> L99
            com.quantummetric.instrument.internal.da r13 = (com.quantummetric.ui.internal.da) r13     // Catch: java.lang.Exception -> L99
            r11.a(r12, r13)     // Catch: java.lang.Exception -> L99
        L45:
            r6.f61a = r0     // Catch: java.lang.Exception -> L99
            r8.a()     // Catch: java.lang.Exception -> L99
            com.quantummetric.instrument.internal.k r13 = com.quantummetric.ui.internal.k.f262a     // Catch: java.lang.Exception -> L99
            if (r13 != 0) goto L55
            com.quantummetric.instrument.internal.k r13 = new com.quantummetric.instrument.internal.k     // Catch: java.lang.Exception -> L99
            r13.<init>()     // Catch: java.lang.Exception -> L99
            com.quantummetric.ui.internal.k.f262a = r13     // Catch: java.lang.Exception -> L99
        L55:
            com.quantummetric.instrument.internal.k r13 = com.quantummetric.ui.internal.k.f262a     // Catch: java.lang.Exception -> L99
            boolean r13 = r13.h     // Catch: java.lang.Exception -> L99
            if (r13 == 0) goto L99
            com.quantummetric.instrument.internal.k r13 = com.quantummetric.ui.internal.k.f262a     // Catch: java.lang.Exception -> L99
            if (r13 != 0) goto L66
            com.quantummetric.instrument.internal.k r13 = new com.quantummetric.instrument.internal.k     // Catch: java.lang.Exception -> L99
            r13.<init>()     // Catch: java.lang.Exception -> L99
            com.quantummetric.ui.internal.k.f262a = r13     // Catch: java.lang.Exception -> L99
        L66:
            com.quantummetric.instrument.internal.k r13 = com.quantummetric.ui.internal.k.f262a     // Catch: java.lang.Exception -> L99
            int r14 = com.quantummetric.instrument.internal.k.c.d     // Catch: java.lang.Exception -> L99
            com.quantummetric.instrument.internal.k$a r13 = r13.a(r12, r14)     // Catch: java.lang.Exception -> L99
            if (r13 == 0) goto L99
            java.lang.String r14 = com.quantummetric.ui.internal.de.a(r12)     // Catch: java.lang.Exception -> L99
            java.lang.String r0 = r13.f263a     // Catch: java.lang.Exception -> L99
            boolean r14 = r14.equals(r0)     // Catch: java.lang.Exception -> L99
            if (r14 != 0) goto L8e
            java.lang.Class r12 = r12.getClass()     // Catch: java.lang.Exception -> L99
            java.lang.String r12 = r12.getSimpleName()     // Catch: java.lang.Exception -> L99
            java.lang.String r14 = r13.b     // Catch: java.lang.Exception -> L99
            boolean r12 = r12.equals(r14)     // Catch: java.lang.Exception -> L99
            if (r12 == 0) goto L8d
            goto L8e
        L8d:
            r1 = r2
        L8e:
            if (r1 == 0) goto L99
            com.quantummetric.instrument.internal.k$b r12 = r13.g     // Catch: java.lang.Exception -> L99
            if (r12 == 0) goto L99
            com.quantummetric.instrument.internal.k$b r12 = r13.g     // Catch: java.lang.Exception -> L99
            r12.a()     // Catch: java.lang.Exception -> L99
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.df.a(android.view.View, boolean, boolean):void");
    }

    static void a(da daVar) {
        t.a(daVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.quantummetric.instrument.internal.df$40] */
    public void a(final da daVar, WebView webView) {
        if (ax.b && (daVar instanceof db) && webView.getHeight() > 0) {
            ((db) daVar).a(ax.a(daVar.B.get(), (AnonymousClass40) new ax.a() { // from class: com.quantummetric.instrument.internal.df.40
                @Override // com.quantummetric.instrument.internal.ax.a
                public final void a() {
                    df.c(df.this, daVar);
                }
            }));
        }
    }

    static /* synthetic */ void a(df dfVar, View view) {
        dfVar.a(view, !(view instanceof ImageView) && (g(view) || (view instanceof ProgressBar)), true);
    }

    static /* synthetic */ void a(df dfVar, final View view, final View view2) {
        if (view == null || view2 == null) {
            return;
        }
        try {
            if ((dfVar.z.size() <= 0 || !dfVar.z.contains(de.a(view))) && (dfVar.A.size() <= 0 || !dfVar.A.contains(view2.getClass().getSimpleName()))) {
                dfVar.a(view, view2);
            } else {
                dfVar.y.add(Integer.valueOf(view2.hashCode()));
                cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.df.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (view2 == null || !df.this.y.remove(Integer.valueOf(view2.hashCode()))) {
                            return;
                        }
                        df.this.a(view, view2);
                    }
                }, dfVar.B);
            }
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void a(df dfVar, View view, cz czVar) {
        ViewGroup viewGroup;
        int indexOfChild;
        final View childAt;
        if (aa.k && view.getClass().getSimpleName().equals("ReactEditText") && czVar.w == 0 && (indexOfChild = (viewGroup = (ViewGroup) view.getParent()).indexOfChild(view)) > 0 && (childAt = viewGroup.getChildAt(indexOfChild - 1)) != null) {
            cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.df.5
                @Override // java.lang.Runnable
                public final void run() {
                    com.quantummetric.ui.internal.a.a(com.quantummetric.ui.internal.a.b(childAt), de.b(childAt.getY()));
                }
            });
        }
    }

    static /* synthetic */ void a(df dfVar, ViewGroup viewGroup, cx cxVar) {
        if (viewGroup != null) {
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt != null && dfVar.c.contains(Integer.valueOf(childAt.hashCode()))) {
                    final String b2 = com.quantummetric.ui.internal.a.b(childAt);
                    final int b3 = de.b(childAt.getTop() + cxVar.t);
                    cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.df.28
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.quantummetric.ui.internal.a.a(b2, b3);
                        }
                    });
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.quantummetric.instrument.internal.df$26] */
    static /* synthetic */ void a(df dfVar, ImageView imageView, da daVar) {
        if (imageView != null && dfVar.c(imageView.hashCode()) && (daVar instanceof cs)) {
            cs csVar = (cs) daVar;
            if (imageView.getDrawable() != null || csVar.e()) {
                boolean z = true;
                if (!csVar.b()) {
                    Drawable drawable = csVar.C.get();
                    if (!(((drawable instanceof ah) || drawable == imageView.getBackground()) ? false : true)) {
                        z = false;
                    }
                }
                if (z || csVar.d()) {
                    final String str = csVar.m;
                    final String str2 = com.quantummetric.ui.internal.a.a(imageView) + " 0";
                    csVar.c();
                    csVar.a(new bp(bz.a(), null), new h<String>() { // from class: com.quantummetric.instrument.internal.df.26
                        @Override // com.quantummetric.ui.internal.h
                        public final /* synthetic */ void a(String str3) {
                            final String str4 = str3;
                            if ((de.b(str) || !str.equals(str4)) && !de.b(str4)) {
                                final boolean b2 = de.b(str);
                                cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.df.26.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        com.quantummetric.ui.internal.a.a(str2, "src", str4);
                                        if (b2) {
                                            com.quantummetric.ui.internal.a.d(str2);
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }
        }
    }

    static /* synthetic */ void a(df dfVar, final cz czVar, CharSequence charSequence) {
        af.k b2;
        if (czVar == null || !(czVar.B.get() instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) czVar.B.get();
        final boolean z = textView instanceof EditText;
        final String obj = charSequence != null ? charSequence.toString() : "";
        final String b3 = com.quantummetric.ui.internal.a.b(textView);
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
        cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.df.3
            @Override // java.lang.Runnable
            public final void run() {
                cj.b(czVar, obj);
                ar arVar = new ar();
                String a3 = cj.a(obj, czVar, arVar, (ck.a) null);
                String str = b3;
                String arVar2 = arVar.toString();
                TextView textView2 = (TextView) czVar.B.get();
                int i2 = 0;
                if (textView2 != null) {
                    Drawable[] compoundDrawables = textView2.getCompoundDrawables();
                    boolean z2 = (textView2 instanceof CompoundButton) && ((CompoundButton) textView2).getButtonDrawable() != null;
                    Drawable drawable = compoundDrawables[0];
                    if (drawable != null && z2) {
                        i2 = 2;
                    } else if (drawable != null || compoundDrawables[1] != null || z2) {
                        i2 = 1;
                    }
                }
                com.quantummetric.ui.internal.a.a(str, arVar2, i2);
                if (z) {
                    com.quantummetric.ui.internal.a.a(b3, a3, czVar.p);
                    dk.d();
                }
            }
        });
    }

    static /* synthetic */ void a(df dfVar, da daVar) {
        if (daVar != null) {
            dfVar.d.add(daVar);
            if (dfVar.e == null) {
                dfVar.d();
            }
        }
    }

    static /* synthetic */ void a(df dfVar, final k.a aVar, int i2, int i3, int i4) {
        if (dfVar.c(i4)) {
            dk.c();
            final bf bfVar = new bf();
            bfVar.put(aa.ah, de.b(i2) + aa.f);
            bfVar.put(aa.ac, Integer.valueOf(de.b(i3)));
            final String d2 = com.quantummetric.ui.internal.a.d(i4);
            cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.df.13
                @Override // java.lang.Runnable
                public final void run() {
                    k.a aVar2 = aVar;
                    if (aVar2 != null && aVar2.g != null) {
                        aVar2.g.a();
                    }
                    com.quantummetric.ui.internal.a.a(d2, bfVar);
                }
            });
        }
    }

    static /* synthetic */ void a(df dfVar, WeakReference weakReference) {
        if (bq.B) {
            cl.b(dfVar.new AnonymousClass25(weakReference), bq.C * 1000);
        }
    }

    static /* synthetic */ void a(df dfVar, WeakReference weakReference, int i2, boolean z, int i3) {
        cl.b(dfVar.new AnonymousClass4(weakReference, i2, z, i3), i3);
    }

    static /* synthetic */ void a(dg dgVar, String str) {
        ar arVar = new ar();
        dgVar.d(arVar);
        com.quantummetric.ui.internal.a.a(str, 0, (List<String>) null, arVar.toString());
    }

    static /* synthetic */ boolean a(View view, int i2) {
        if (!ae.a(view)) {
            return false;
        }
        da daVar = i.get(Integer.valueOf(i2));
        if (!(daVar instanceof cr)) {
            return false;
        }
        cr crVar = (cr) daVar;
        return (!crVar.o && crVar.p < 0.0f) || (aa.y && crVar.o);
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0229 A[Catch: Exception -> 0x02b5, TryCatch #0 {Exception -> 0x02b5, blocks: (B:5:0x000b, B:8:0x0013, B:15:0x0035, B:18:0x0040, B:20:0x0050, B:22:0x006c, B:24:0x0073, B:26:0x0095, B:28:0x009b, B:30:0x009f, B:32:0x00b6, B:34:0x00bf, B:36:0x00c7, B:37:0x00d0, B:39:0x00d8, B:41:0x00de, B:42:0x00e6, B:45:0x00ee, B:47:0x00f8, B:49:0x00fc, B:51:0x0108, B:53:0x010c, B:55:0x0120, B:57:0x0126, B:63:0x0135, B:65:0x013b, B:67:0x0158, B:69:0x015c, B:73:0x0176, B:74:0x018c, B:76:0x0192, B:77:0x0160, B:79:0x0168, B:82:0x0145, B:84:0x0150, B:85:0x019a, B:87:0x019e, B:88:0x01a5, B:91:0x01ad, B:93:0x01b1, B:95:0x01bf, B:99:0x01d3, B:101:0x01d7, B:102:0x01de, B:104:0x01e6, B:105:0x01ed, B:107:0x01f7, B:109:0x0214, B:111:0x0218, B:113:0x021c, B:115:0x0229, B:117:0x0240, B:118:0x0247, B:120:0x0259, B:121:0x025e, B:123:0x0262, B:125:0x0266, B:127:0x026a, B:130:0x027c, B:132:0x0284, B:134:0x0295, B:136:0x029f, B:137:0x02aa, B:138:0x02b2, B:141:0x01ff, B:144:0x007d, B:146:0x0085, B:148:0x0089, B:149:0x0090, B:150:0x005c, B:152:0x0064), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0295 A[Catch: Exception -> 0x02b5, TryCatch #0 {Exception -> 0x02b5, blocks: (B:5:0x000b, B:8:0x0013, B:15:0x0035, B:18:0x0040, B:20:0x0050, B:22:0x006c, B:24:0x0073, B:26:0x0095, B:28:0x009b, B:30:0x009f, B:32:0x00b6, B:34:0x00bf, B:36:0x00c7, B:37:0x00d0, B:39:0x00d8, B:41:0x00de, B:42:0x00e6, B:45:0x00ee, B:47:0x00f8, B:49:0x00fc, B:51:0x0108, B:53:0x010c, B:55:0x0120, B:57:0x0126, B:63:0x0135, B:65:0x013b, B:67:0x0158, B:69:0x015c, B:73:0x0176, B:74:0x018c, B:76:0x0192, B:77:0x0160, B:79:0x0168, B:82:0x0145, B:84:0x0150, B:85:0x019a, B:87:0x019e, B:88:0x01a5, B:91:0x01ad, B:93:0x01b1, B:95:0x01bf, B:99:0x01d3, B:101:0x01d7, B:102:0x01de, B:104:0x01e6, B:105:0x01ed, B:107:0x01f7, B:109:0x0214, B:111:0x0218, B:113:0x021c, B:115:0x0229, B:117:0x0240, B:118:0x0247, B:120:0x0259, B:121:0x025e, B:123:0x0262, B:125:0x0266, B:127:0x026a, B:130:0x027c, B:132:0x0284, B:134:0x0295, B:136:0x029f, B:137:0x02aa, B:138:0x02b2, B:141:0x01ff, B:144:0x007d, B:146:0x0085, B:148:0x0089, B:149:0x0090, B:150:0x005c, B:152:0x0064), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0135 A[Catch: Exception -> 0x02b5, TryCatch #0 {Exception -> 0x02b5, blocks: (B:5:0x000b, B:8:0x0013, B:15:0x0035, B:18:0x0040, B:20:0x0050, B:22:0x006c, B:24:0x0073, B:26:0x0095, B:28:0x009b, B:30:0x009f, B:32:0x00b6, B:34:0x00bf, B:36:0x00c7, B:37:0x00d0, B:39:0x00d8, B:41:0x00de, B:42:0x00e6, B:45:0x00ee, B:47:0x00f8, B:49:0x00fc, B:51:0x0108, B:53:0x010c, B:55:0x0120, B:57:0x0126, B:63:0x0135, B:65:0x013b, B:67:0x0158, B:69:0x015c, B:73:0x0176, B:74:0x018c, B:76:0x0192, B:77:0x0160, B:79:0x0168, B:82:0x0145, B:84:0x0150, B:85:0x019a, B:87:0x019e, B:88:0x01a5, B:91:0x01ad, B:93:0x01b1, B:95:0x01bf, B:99:0x01d3, B:101:0x01d7, B:102:0x01de, B:104:0x01e6, B:105:0x01ed, B:107:0x01f7, B:109:0x0214, B:111:0x0218, B:113:0x021c, B:115:0x0229, B:117:0x0240, B:118:0x0247, B:120:0x0259, B:121:0x025e, B:123:0x0262, B:125:0x0266, B:127:0x026a, B:130:0x027c, B:132:0x0284, B:134:0x0295, B:136:0x029f, B:137:0x02aa, B:138:0x02b2, B:141:0x01ff, B:144:0x007d, B:146:0x0085, B:148:0x0089, B:149:0x0090, B:150:0x005c, B:152:0x0064), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0176 A[Catch: Exception -> 0x02b5, TryCatch #0 {Exception -> 0x02b5, blocks: (B:5:0x000b, B:8:0x0013, B:15:0x0035, B:18:0x0040, B:20:0x0050, B:22:0x006c, B:24:0x0073, B:26:0x0095, B:28:0x009b, B:30:0x009f, B:32:0x00b6, B:34:0x00bf, B:36:0x00c7, B:37:0x00d0, B:39:0x00d8, B:41:0x00de, B:42:0x00e6, B:45:0x00ee, B:47:0x00f8, B:49:0x00fc, B:51:0x0108, B:53:0x010c, B:55:0x0120, B:57:0x0126, B:63:0x0135, B:65:0x013b, B:67:0x0158, B:69:0x015c, B:73:0x0176, B:74:0x018c, B:76:0x0192, B:77:0x0160, B:79:0x0168, B:82:0x0145, B:84:0x0150, B:85:0x019a, B:87:0x019e, B:88:0x01a5, B:91:0x01ad, B:93:0x01b1, B:95:0x01bf, B:99:0x01d3, B:101:0x01d7, B:102:0x01de, B:104:0x01e6, B:105:0x01ed, B:107:0x01f7, B:109:0x0214, B:111:0x0218, B:113:0x021c, B:115:0x0229, B:117:0x0240, B:118:0x0247, B:120:0x0259, B:121:0x025e, B:123:0x0262, B:125:0x0266, B:127:0x026a, B:130:0x027c, B:132:0x0284, B:134:0x0295, B:136:0x029f, B:137:0x02aa, B:138:0x02b2, B:141:0x01ff, B:144:0x007d, B:146:0x0085, B:148:0x0089, B:149:0x0090, B:150:0x005c, B:152:0x0064), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x018c A[Catch: Exception -> 0x02b5, TryCatch #0 {Exception -> 0x02b5, blocks: (B:5:0x000b, B:8:0x0013, B:15:0x0035, B:18:0x0040, B:20:0x0050, B:22:0x006c, B:24:0x0073, B:26:0x0095, B:28:0x009b, B:30:0x009f, B:32:0x00b6, B:34:0x00bf, B:36:0x00c7, B:37:0x00d0, B:39:0x00d8, B:41:0x00de, B:42:0x00e6, B:45:0x00ee, B:47:0x00f8, B:49:0x00fc, B:51:0x0108, B:53:0x010c, B:55:0x0120, B:57:0x0126, B:63:0x0135, B:65:0x013b, B:67:0x0158, B:69:0x015c, B:73:0x0176, B:74:0x018c, B:76:0x0192, B:77:0x0160, B:79:0x0168, B:82:0x0145, B:84:0x0150, B:85:0x019a, B:87:0x019e, B:88:0x01a5, B:91:0x01ad, B:93:0x01b1, B:95:0x01bf, B:99:0x01d3, B:101:0x01d7, B:102:0x01de, B:104:0x01e6, B:105:0x01ed, B:107:0x01f7, B:109:0x0214, B:111:0x0218, B:113:0x021c, B:115:0x0229, B:117:0x0240, B:118:0x0247, B:120:0x0259, B:121:0x025e, B:123:0x0262, B:125:0x0266, B:127:0x026a, B:130:0x027c, B:132:0x0284, B:134:0x0295, B:136:0x029f, B:137:0x02aa, B:138:0x02b2, B:141:0x01ff, B:144:0x007d, B:146:0x0085, B:148:0x0089, B:149:0x0090, B:150:0x005c, B:152:0x0064), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d3 A[Catch: Exception -> 0x02b5, TryCatch #0 {Exception -> 0x02b5, blocks: (B:5:0x000b, B:8:0x0013, B:15:0x0035, B:18:0x0040, B:20:0x0050, B:22:0x006c, B:24:0x0073, B:26:0x0095, B:28:0x009b, B:30:0x009f, B:32:0x00b6, B:34:0x00bf, B:36:0x00c7, B:37:0x00d0, B:39:0x00d8, B:41:0x00de, B:42:0x00e6, B:45:0x00ee, B:47:0x00f8, B:49:0x00fc, B:51:0x0108, B:53:0x010c, B:55:0x0120, B:57:0x0126, B:63:0x0135, B:65:0x013b, B:67:0x0158, B:69:0x015c, B:73:0x0176, B:74:0x018c, B:76:0x0192, B:77:0x0160, B:79:0x0168, B:82:0x0145, B:84:0x0150, B:85:0x019a, B:87:0x019e, B:88:0x01a5, B:91:0x01ad, B:93:0x01b1, B:95:0x01bf, B:99:0x01d3, B:101:0x01d7, B:102:0x01de, B:104:0x01e6, B:105:0x01ed, B:107:0x01f7, B:109:0x0214, B:111:0x0218, B:113:0x021c, B:115:0x0229, B:117:0x0240, B:118:0x0247, B:120:0x0259, B:121:0x025e, B:123:0x0262, B:125:0x0266, B:127:0x026a, B:130:0x027c, B:132:0x0284, B:134:0x0295, B:136:0x029f, B:137:0x02aa, B:138:0x02b2, B:141:0x01ff, B:144:0x007d, B:146:0x0085, B:148:0x0089, B:149:0x0090, B:150:0x005c, B:152:0x0064), top: B:4:0x000b }] */
    /* JADX WARN: Type inference failed for: r3v10, types: [com.quantummetric.instrument.internal.df$41] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(final android.view.View r16, final com.quantummetric.ui.internal.da r17, com.quantummetric.instrument.internal.ba.a r18) {
        /*
            Method dump skipped, instructions count: 695
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.df.a(android.view.View, com.quantummetric.instrument.internal.da, com.quantummetric.instrument.internal.ba$a):boolean");
    }

    static /* synthetic */ boolean a(df dfVar, int i2, int i3, boolean z) {
        da daVar = i.get(Integer.valueOf(i2));
        if (daVar instanceof cw) {
            cw cwVar = (cw) daVar;
            if (!cwVar.u && dfVar.c.contains(Integer.valueOf(i3))) {
                if (cwVar.r.contains(Integer.valueOf(i3))) {
                    return true;
                }
                if (!z) {
                    cwVar.r.add(Integer.valueOf(i3));
                }
            }
        }
        return false;
    }

    private static int b(View view, View view2) {
        da daVar = i.get(Integer.valueOf(view2.hashCode()));
        return (daVar != null ? daVar.l : (short) 0) + ((ViewGroup) view2).indexOfChild(view);
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [V, com.quantummetric.instrument.internal.dg] */
    static /* synthetic */ void b(df dfVar, da daVar) {
        if (daVar == null || daVar.B.get() == null || !de.b(daVar.m) || !dfVar.c.contains(Integer.valueOf(daVar.B.get().hashCode()))) {
            return;
        }
        final View view = daVar.B.get();
        final ap apVar = new ap();
        bp bpVar = new bp(bz.a(), new dc() { // from class: com.quantummetric.instrument.internal.df.30
            @Override // com.quantummetric.ui.internal.dc
            public final void a() {
                if (apVar.f61a != 0) {
                    final String b2 = com.quantummetric.ui.internal.a.b(view);
                    cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.df.30.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public final void run() {
                            dg dgVar = (dg) apVar.f61a;
                            if (dgVar == null || de.b(dgVar.d)) {
                                return;
                            }
                            df dfVar2 = df.this;
                            df.a(dgVar, b2);
                        }
                    });
                }
            }
        });
        apVar.f61a = dh.a(view, (com.quantummetric.ui.internal.c) null, bpVar);
        bpVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i2) {
        return !(cd.f161a || QuantumMetric.b == null) && this.c.contains(Integer.valueOf(i2));
    }

    static void c() {
        cb cbVar = p;
        if (cbVar != null) {
            cbVar.a(true, System.currentTimeMillis());
        }
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [V, com.quantummetric.instrument.internal.dg] */
    static /* synthetic */ void c(df dfVar, View view) {
        if ((view instanceof TextView) && (view.getParent() instanceof View)) {
            View view2 = (View) view.getParent();
            final String a2 = com.quantummetric.ui.internal.a.a(view2);
            final int b2 = b(view, view2);
            final ap apVar = new ap();
            bp bpVar = new bp(bz.a(), new dc() { // from class: com.quantummetric.instrument.internal.df.29
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.quantummetric.ui.internal.dc
                public final void a() {
                    if (apVar.f61a != 0) {
                        com.quantummetric.ui.internal.a.a((com.quantummetric.ui.internal.b) apVar.f61a, b2, a2);
                    }
                }
            });
            apVar.f61a = dh.a(view, (com.quantummetric.ui.internal.c) null, bpVar);
            bpVar.a();
        }
    }

    static /* synthetic */ void c(df dfVar, da daVar) {
        if (daVar == null || daVar.B == null || daVar.B.get() == null) {
            return;
        }
        final View view = daVar.B.get();
        int hashCode = view.hashCode();
        if (dfVar.c.contains(Integer.valueOf(hashCode)) && !dfVar.x.contains(Integer.valueOf(hashCode)) && daVar.a(view)) {
            cl.c(new Runnable() { // from class: com.quantummetric.instrument.internal.df.35
                @Override // java.lang.Runnable
                public final void run() {
                    if (ba.f99a == null) {
                        ba.f99a = new ba();
                    }
                    ba.a a2 = ba.f99a.a(view);
                    if (a2 == null || !a2.f100a.contains(ba.b.Visibility)) {
                        df.a(df.this, view);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(int i2) {
        if (b(i2)) {
            com.quantummetric.ui.internal.e a2 = com.quantummetric.ui.internal.e.a();
            if (!(a2.f || a2.g)) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ Drawable d(View view) {
        if (view instanceof CompoundButton) {
            return ((CompoundButton) view).getButtonDrawable();
        }
        if (view instanceof CheckedTextView) {
            return ((CheckedTextView) view).getCheckMarkDrawable();
        }
        return null;
    }

    static /* synthetic */ void e(df dfVar, View view) {
        if (dfVar.h(view)) {
            cl.a(dfVar.m);
            dfVar.m = cl.b(dfVar.new AnonymousClass33(), 500);
            return;
        }
        com.quantummetric.ui.internal.e a2 = com.quantummetric.ui.internal.e.a();
        if (a2.f || a2.g) {
            return;
        }
        dfVar.a(view, true);
        final String b2 = com.quantummetric.ui.internal.a.b(view);
        cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.df.10
            @Override // java.lang.Runnable
            public final void run() {
                com.quantummetric.ui.internal.a.c(b2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0012 A[Catch: Exception -> 0x01e8, TryCatch #2 {Exception -> 0x01e8, blocks: (B:4:0x0003, B:6:0x0008, B:11:0x0012, B:16:0x001b, B:18:0x001f, B:19:0x0026, B:21:0x003e, B:23:0x0044, B:24:0x0063, B:26:0x006b, B:28:0x0071, B:33:0x007c, B:39:0x008b, B:42:0x00e6, B:44:0x01b2, B:46:0x01b6, B:47:0x01bc, B:49:0x01c0, B:51:0x01c4, B:53:0x01ca, B:55:0x01de, B:62:0x00f0, B:64:0x00f6, B:66:0x00fa, B:67:0x0103, B:82:0x0143, B:97:0x0095, B:99:0x009b, B:102:0x00a3, B:104:0x00a9, B:105:0x00b7, B:107:0x00c0, B:109:0x00c4, B:111:0x00ca, B:112:0x00d8, B:114:0x00df), top: B:3:0x0003 }] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.quantummetric.instrument.internal.df$7] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean e(android.view.View r10) {
        /*
            Method dump skipped, instructions count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.df.e(android.view.View):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(final View view) {
        final int hashCode = view.hashCode();
        try {
            if (((view.getParent() instanceof CoordinatorLayout) && (((CoordinatorLayout.LayoutParams) view.getLayoutParams()).getBehavior() instanceof BottomSheetBehavior)) || this.J.contains(de.a(view))) {
                cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.df.27
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (view == null || !df.this.c.contains(Integer.valueOf(hashCode))) {
                            return;
                        }
                        df.a(df.this, view);
                    }
                }, n);
                return true;
            }
        } catch (Throwable unused) {
        }
        return this.K.contains(Integer.valueOf(hashCode));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(View view) {
        da daVar;
        if (view == null || (daVar = i.get(Integer.valueOf(view.hashCode()))) == null) {
            return false;
        }
        if (ah.a(daVar.C.get())) {
            return true;
        }
        if (dg.a(view.getBackground(), view.getClass().getSimpleName())) {
            Drawable drawable = daVar.C.get();
            if (((drawable instanceof ah) || drawable == view.getBackground()) ? false : true) {
                return true;
            }
        }
        return false;
    }

    private boolean h(View view) {
        boolean z = !de.b(this.l);
        if (z) {
            return ((float) view.getWidth()) / ((float) de.a()) > 0.9f && ((float) view.getHeight()) / ((float) de.b()) > 0.6f;
        }
        return z;
    }

    final void a(View view) {
        if (view != null) {
            try {
                if (e(view) || !(view instanceof ViewGroup)) {
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    a(viewGroup.getChildAt(i2));
                }
            } catch (Exception unused) {
            }
        }
    }

    final void a(View view, boolean z) {
        if (view != null) {
            try {
                int hashCode = view.hashCode();
                this.c.remove(Integer.valueOf(hashCode));
                if (z) {
                    da remove = i.remove(Integer.valueOf(hashCode));
                    if (ag.a(view) && (remove instanceof cx)) {
                        ((cx) remove).w = true;
                    }
                }
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        a(viewGroup.getChildAt(i2), z);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    final void a(List<Integer> list) {
        this.c.removeAll(list);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            i.remove(it.next());
        }
    }

    final void a(List<cx> list, boolean z) {
        if (z) {
            try {
                p.a();
            } catch (Exception unused) {
                return;
            }
        }
        for (cx cxVar : list) {
            if (cxVar != null && cxVar.B.get() != null) {
                cb cbVar = p;
                if (cbVar.f158a && cbVar.i) {
                    p.a(cxVar);
                }
                if (cxVar.z && (cxVar.s != 0 || cxVar.t != 0)) {
                    View view = cxVar.B.get();
                    if (this.c.contains(Integer.valueOf(view.hashCode()))) {
                        com.quantummetric.ui.internal.a.a(com.quantummetric.ui.internal.a.a(view), de.b(cxVar.s), de.b(cxVar.t));
                    }
                }
            }
        }
    }

    final void b() {
        try {
            ConcurrentHashMap<Integer, da> concurrentHashMap = i;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
                Iterator<Map.Entry<Integer, da>> it = j.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, da> next = it.next();
                    if (next.getValue() != null && next.getValue().B.get() != null) {
                        i.put(next.getKey(), next.getValue());
                    }
                    it.remove();
                }
            }
            HashSet<Integer> hashSet = this.c;
            if (hashSet != null) {
                hashSet.clear();
            } else {
                this.c = new HashSet<>();
            }
        } catch (Throwable unused) {
        }
    }

    final void b(View view) {
        if (view != null) {
            if (this.s == null) {
                this.s = new c();
            }
            this.s.f235a = true;
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.s);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.s);
        }
    }

    final void d() {
        if (f || g) {
            this.e = new Timer(true);
            final HashSet hashSet = new HashSet();
            Timer timer = this.e;
            TimerTask timerTask = new TimerTask() { // from class: com.quantummetric.instrument.internal.df.36
                /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:9:0x000e A[Catch: Exception -> 0x0052, TryCatch #0 {Exception -> 0x0052, blocks: (B:2:0x0000, B:4:0x0004, B:9:0x000e, B:10:0x0018, B:12:0x001e, B:14:0x0026, B:21:0x002e, B:17:0x0034, B:25:0x003a, B:27:0x0042), top: B:1:0x0000 }] */
                @Override // java.util.TimerTask, java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void run() {
                    /*
                        r3 = this;
                        boolean r0 = com.quantummetric.ui.internal.cd.f161a     // Catch: java.lang.Exception -> L52
                        if (r0 != 0) goto Lb
                        com.quantummetric.instrument.internal.bu r0 = com.quantummetric.ui.QuantumMetric.b     // Catch: java.lang.Exception -> L52
                        if (r0 != 0) goto L9
                        goto Lb
                    L9:
                        r0 = 0
                        goto Lc
                    Lb:
                        r0 = 1
                    Lc:
                        if (r0 != 0) goto L52
                        com.quantummetric.instrument.internal.df r0 = com.quantummetric.ui.internal.df.this     // Catch: java.lang.Exception -> L52
                        java.util.Set r0 = com.quantummetric.ui.internal.df.k(r0)     // Catch: java.lang.Exception -> L52
                        java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L52
                    L18:
                        boolean r1 = r0.hasNext()     // Catch: java.lang.Exception -> L52
                        if (r1 == 0) goto L3a
                        java.lang.Object r1 = r0.next()     // Catch: java.lang.Exception -> L52
                        com.quantummetric.instrument.internal.da r1 = (com.quantummetric.ui.internal.da) r1     // Catch: java.lang.Exception -> L52
                        if (r1 == 0) goto L34
                        java.lang.ref.WeakReference<android.view.View> r2 = r1.B     // Catch: java.lang.Exception -> L52
                        java.lang.Object r2 = r2.get()     // Catch: java.lang.Exception -> L52
                        if (r2 == 0) goto L34
                        com.quantummetric.instrument.internal.df r2 = com.quantummetric.ui.internal.df.this     // Catch: java.lang.Exception -> L52
                        com.quantummetric.ui.internal.df.c(r2, r1)     // Catch: java.lang.Exception -> L52
                        goto L18
                    L34:
                        java.util.Set r2 = r2     // Catch: java.lang.Exception -> L52
                        r2.add(r1)     // Catch: java.lang.Exception -> L52
                        goto L18
                    L3a:
                        java.util.Set r0 = r2     // Catch: java.lang.Exception -> L52
                        int r0 = r0.size()     // Catch: java.lang.Exception -> L52
                        if (r0 <= 0) goto L52
                        com.quantummetric.instrument.internal.df r0 = com.quantummetric.ui.internal.df.this     // Catch: java.lang.Exception -> L52
                        java.util.Set r0 = com.quantummetric.ui.internal.df.k(r0)     // Catch: java.lang.Exception -> L52
                        java.util.Set r1 = r2     // Catch: java.lang.Exception -> L52
                        r0.removeAll(r1)     // Catch: java.lang.Exception -> L52
                        java.util.Set r0 = r2     // Catch: java.lang.Exception -> L52
                        r0.clear()     // Catch: java.lang.Exception -> L52
                    L52:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.df.AnonymousClass36.run():void");
                }
            };
            int i2 = w;
            timer.scheduleAtFixedRate(timerTask, i2, i2);
        }
    }
}
