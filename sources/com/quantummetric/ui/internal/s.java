package com.quantummetric.ui.internal;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.node.LayoutNode;
import com.quantummetric.ui.QuantumMetric;
import com.quantummetric.ui.internal.bp.AnonymousClass2;
import com.quantummetric.ui.internal.bp.AnonymousClass3;
import com.quantummetric.ui.internal.co;
import com.socure.docv.capturesdk.common.utils.Scanner;
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
import org.json.JSONObject;

/* loaded from: classes5.dex */
final class s {
    private static s d = null;
    private static boolean e = true;

    /* renamed from: a, reason: collision with root package name */
    boolean f267a;
    boolean b;
    final ConcurrentHashMap<Integer, com.quantummetric.ui.internal.c> c;
    private Set<c> f;
    private Timer g;

    static class a implements h<Object> {

        /* renamed from: a, reason: collision with root package name */
        private cn f278a;
        private int b;

        a(cn cnVar, int i) {
            this.f278a = cnVar;
            this.b = i;
        }

        @Override // com.quantummetric.ui.internal.h
        public final void a(Object obj) {
            boolean z = obj instanceof Integer;
            if (z) {
                this.f278a.a(((Integer) obj).intValue());
            } else if (obj.getClass().getSimpleName().equals("LazyListMeasureResult")) {
                Object a2 = by.a(obj);
                if (a2 instanceof Float) {
                    cn cnVar = this.f278a;
                    int round = Math.round(((Float) a2).floatValue());
                    int i = cnVar.t ? 0 : round;
                    if (!cnVar.t) {
                        round = 0;
                    }
                    cnVar.o += i;
                    cnVar.p += round;
                    dk.a(i, round);
                }
            }
            final s a3 = s.a();
            final cn cnVar2 = this.f278a;
            final int i2 = this.b;
            if (cnVar2.s) {
                cnVar2.s = false;
                cl.a(new Runnable() { // from class: com.quantummetric.instrument.internal.s.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        cn cnVar3 = cnVar2;
                        cnVar3.q = cnVar3.o;
                        cnVar3.r = cnVar3.p;
                        cnVar3.s = true;
                        com.quantummetric.ui.internal.a.b(com.quantummetric.ui.internal.a.e(i2), -de.b(cnVar2.o), -de.b(cnVar2.p));
                    }
                }, 70);
            }
            if (this.f278a.w && z && ((Integer) obj).intValue() == 0) {
                s.b(s.a(), this.f278a);
            }
        }
    }

    static class b implements h<Object> {

        /* renamed from: a, reason: collision with root package name */
        private final cn f279a;

        b(cn cnVar) {
            this.f279a = cnVar;
        }

        @Override // com.quantummetric.ui.internal.h
        public final void a(Object obj) {
            if ((obj instanceof Boolean) && !((Boolean) obj).booleanValue()) {
                s.b(s.a(), this.f279a);
            }
        }
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        LayoutNode f280a;
        int b;
        HashMap<String, Object> c;
        private final int d;

        c(LayoutNode layoutNode, int i) {
            this.f280a = layoutNode;
            this.b = i;
            this.d = layoutNode.hashCode();
        }

        public final boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            return (obj instanceof c) && ((c) obj).f280a == this.f280a;
        }

        public final int hashCode() {
            return this.d * 31;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    static final class d {

        /* renamed from: a, reason: collision with root package name */
        public static final int f281a = 1;
        public static final int b = 2;
        private static final /* synthetic */ int[] c = {1, 2};

        public static int[] values$6b0626f1() {
            return (int[]) c.clone();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private s(android.view.View r3, org.json.JSONObject r4) {
        /*
            r2 = this;
            r2.<init>()
            java.lang.String r0 = "enabled"
            r1 = 1
            boolean r0 = r4.optBoolean(r0, r1)
            if (r0 == 0) goto L16
            com.quantummetric.instrument.internal.y r0 = com.quantummetric.ui.QuantumMetric.f9a
            boolean r0 = com.quantummetric.ui.internal.y.a(r4, r1)
            if (r0 == 0) goto L16
            r0 = r1
            goto L17
        L16:
            r0 = 0
        L17:
            com.quantummetric.ui.internal.s.e = r0
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            r2.c = r0
            boolean r0 = com.quantummetric.ui.internal.s.e
            if (r0 == 0) goto L4a
            com.quantummetric.instrument.internal.bx r3 = b(r3)
            boolean r3 = r3.f146a
            r2.f267a = r3
            java.lang.String r3 = "scroll_capture"
            boolean r3 = r4.optBoolean(r3, r1)
            r2.b = r3
            com.quantummetric.instrument.internal.s$1 r3 = new com.quantummetric.instrument.internal.s$1
            r3.<init>()
            com.quantummetric.instrument.internal.ak r4 = com.quantummetric.ui.internal.ak.a()
            java.lang.Object r0 = com.quantummetric.ui.internal.ak.f49a
            monitor-enter(r0)
            java.util.HashSet<com.quantummetric.instrument.internal.h<com.quantummetric.instrument.internal.ak$a>> r4 = r4.b     // Catch: java.lang.Throwable -> L47
            r4.add(r3)     // Catch: java.lang.Throwable -> L47
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L47
            return
        L47:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.s.<init>(android.view.View, org.json.JSONObject):void");
    }

    private static int a(LayoutNode layoutNode, LayoutNode layoutNode2) {
        if (layoutNode != null && layoutNode2 != null) {
            List asMutableList = layoutNode2.getZSortedChildren().asMutableList();
            for (int i = 0; i < asMutableList.size(); i++) {
                if (asMutableList.get(i) == layoutNode) {
                    return i;
                }
            }
        }
        return -1;
    }

    static Rect a(LayoutCoordinates layoutCoordinates, boolean z) {
        try {
            return z ? LayoutCoordinatesKt.boundsInWindow(layoutCoordinates) : LayoutCoordinatesKt.boundsInParent(layoutCoordinates);
        } catch (Throwable unused) {
            return null;
        }
    }

    static LayoutNode a(LayoutNode layoutNode) {
        return layoutNode.getParent$ui_release();
    }

    static s a() {
        if (d == null) {
            d = new s(null, new JSONObject());
        }
        return d;
    }

    private void a(int i) {
        com.quantummetric.ui.internal.c remove;
        LayoutNode layoutNode;
        if (!this.f267a || (remove = this.c.remove(Integer.valueOf(i))) == null || (layoutNode = ((co) remove).x.get()) == null) {
            return;
        }
        layoutNode.hashCode();
    }

    static void a(View view) {
        if (QuantumMetric.f9a != null) {
            s sVar = d;
            if (sVar != null) {
                if (sVar.f267a) {
                    b(view);
                }
            } else {
                JSONObject optJSONObject = QuantumMetric.f9a.optJSONObject("jetpack");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                s sVar2 = new s(view, optJSONObject);
                d = sVar2;
                sVar2.f = Collections.newSetFromMap(new ConcurrentHashMap());
            }
        }
    }

    private void a(LayoutNode layoutNode, cn cnVar) {
        com.quantummetric.ui.internal.c cVar = this.c.get(Integer.valueOf(layoutNode.hashCode()));
        co coVar = cVar instanceof co ? (co) cVar : null;
        if (layoutNode.isAttached() && coVar != null && coVar.c(layoutNode)) {
            Rect a2 = layoutNode.isAttached() ? a(layoutNode.getCoordinates(), false) : null;
            if (a2 != null) {
                coVar.a(a2);
                if (coVar.E > 0) {
                    List modifierInfo = layoutNode.getModifierInfo();
                    if (modifierInfo.size() > 0) {
                        a2 = a(((ModifierInfo) modifierInfo.get(0)).getCoordinates(), false);
                    }
                }
                com.quantummetric.ui.internal.a.b(com.quantummetric.ui.internal.a.d(layoutNode.hashCode()), -de.b(a2.getLeft() - cnVar.q), -de.b(a2.getTop() - cnVar.r));
            }
        }
    }

    static /* synthetic */ void a(s sVar, final LayoutNode layoutNode, final co coVar, Bitmap bitmap) {
        bp bpVar = new bp(bz.a(), null);
        h<String> hVar = new h<String>() { // from class: com.quantummetric.instrument.internal.s.9
            @Override // com.quantummetric.ui.internal.h
            public final /* synthetic */ void a(String str) {
                String str2 = str;
                if (de.b(str2)) {
                    return;
                }
                coVar.m = str2;
                String str3 = com.quantummetric.ui.internal.a.e(layoutNode.hashCode()) + " 0";
                com.quantummetric.ui.internal.a.a(str3, "src", str2);
                com.quantummetric.ui.internal.a.d(str3);
            }
        };
        bpVar.b++;
        bpVar.f126a.a(bitmap, coVar, bpVar.new AnonymousClass2(hVar));
    }

    static /* synthetic */ void a(s sVar, cn cnVar) {
        LayoutNode layoutNode = cnVar.x.get();
        if (layoutNode != null) {
            for (LayoutNode layoutNode2 : layoutNode.getZSortedChildren().asMutableList()) {
                if (layoutNode2 != null && layoutNode2.getMeasurePolicy().getClass().getName().contains("ErrorMeasurePolicy")) {
                    Iterator it = layoutNode2.getZSortedChildren().asMutableList().iterator();
                    while (it.hasNext()) {
                        sVar.a((LayoutNode) it.next(), cnVar);
                    }
                } else {
                    sVar.a(layoutNode2, cnVar);
                }
            }
        }
    }

    static /* synthetic */ void a(s sVar, final c cVar) {
        final LayoutNode layoutNode = cVar.f280a;
        if (!layoutNode.isAttached()) {
            sVar.f.remove(cVar);
            return;
        }
        if (cVar.b == d.f281a) {
            if (c(layoutNode)) {
                sVar.f.remove(cVar);
                final LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                final int a2 = a(layoutNode, parent$ui_release);
                cl.c(new Runnable() { // from class: com.quantummetric.instrument.internal.s.7
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.this.a(layoutNode, parent$ui_release, a2);
                    }
                });
                return;
            }
            return;
        }
        Object obj = cVar.c != null ? cVar.c.get("COUNTER") : null;
        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        cl.c(new Runnable() { // from class: com.quantummetric.instrument.internal.s.8
            @Override // java.lang.Runnable
            public final void run() {
                Bitmap a3;
                c cVar2 = cVar;
                Object obj2 = cVar2.c != null ? cVar2.c.get("PAINTER_MODIFIER") : null;
                if (!(obj2 instanceof Modifier) || (a3 = bi.a(layoutNode, (Modifier) obj2, false)) == null) {
                    return;
                }
                com.quantummetric.ui.internal.c cVar3 = s.this.c.get(Integer.valueOf(layoutNode.hashCode()));
                co coVar = cVar3 instanceof co ? (co) cVar3 : null;
                if (coVar != null) {
                    s.a(s.this, layoutNode, coVar, a3);
                    s.this.f.remove(cVar);
                }
            }
        });
        if (intValue >= 2) {
            sVar.f.remove(cVar);
            return;
        }
        Integer valueOf = Integer.valueOf(intValue + 1);
        if (cVar.c == null) {
            cVar.c = new HashMap<>();
        }
        cVar.c.put("COUNTER", valueOf);
    }

    static /* synthetic */ void a(s sVar, t tVar) {
        LayoutNode layoutNode = tVar.A.get();
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        int a2 = a(layoutNode, parent$ui_release);
        if (parent$ui_release == null || a2 < 0) {
            return;
        }
        com.quantummetric.ui.internal.a.a(tVar, a2, sVar.g(parent$ui_release));
    }

    static /* synthetic */ void a(u uVar) {
        cp cpVar = (cp) uVar.e;
        com.quantummetric.ui.internal.a.a(com.quantummetric.ui.internal.a.d(uVar.f), cj.a(cpVar, uVar.F), cpVar.s);
        dk.d();
    }

    private static boolean a(float f, float f2, Rect rect) {
        return rect != null && rect.getLeft() <= f && rect.getRight() >= f && rect.getTop() <= f2 && rect.getBottom() >= f2;
    }

    private static bx b(View view) {
        Composition composition;
        bx bxVar = new bx();
        if (view != null) {
            try {
                SparseArray sparseArray = (SparseArray) by.b(view, View.class, "mKeyedTags");
                if (sparseArray != null) {
                    int size = sparseArray.size();
                    for (int i = 0; i < size; i++) {
                        Object valueAt = sparseArray.valueAt(i);
                        if (valueAt instanceof Composition) {
                            composition = (Composition) valueAt;
                            break;
                        }
                    }
                }
                composition = null;
                Object b2 = by.b(bx.a(composition), "parentContext");
                if (b2 instanceof Recomposer) {
                    bxVar.a((Recomposer) b2);
                }
            } catch (Throwable unused) {
            }
        }
        return bxVar;
    }

    static /* synthetic */ void b(s sVar, final cn cnVar) {
        cl.a(new Runnable() { // from class: com.quantummetric.instrument.internal.s.5
            @Override // java.lang.Runnable
            public final void run() {
                s.a(s.a(), cnVar);
            }
        }, 70);
    }

    static /* synthetic */ void b(s sVar, final t tVar) {
        cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.s.2
            @Override // java.lang.Runnable
            public final void run() {
                String d2 = com.quantummetric.ui.internal.a.d(tVar.f);
                com.quantummetric.ui.internal.a.a(d2, new di(tVar).a().toString());
                if (tVar instanceof u) {
                    ar arVar = new ar();
                    ((u) tVar).f(arVar);
                    com.quantummetric.ui.internal.a.a(d2 + "-text", arVar.toString());
                }
                if (tVar.E != null) {
                    HashMap hashMap = new HashMap();
                    bh bhVar = tVar.E;
                    while (true) {
                        if (bhVar.d) {
                            ar arVar2 = new ar();
                            di.a(arVar2, bhVar);
                            hashMap.put(bhVar.k(), arVar2.toString());
                        }
                        if (bhVar.f109a == null) {
                            break;
                        } else {
                            bhVar = bhVar.f109a;
                        }
                    }
                    if (hashMap.size() > 0) {
                        for (Map.Entry entry : hashMap.entrySet()) {
                            com.quantummetric.ui.internal.a.a((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                }
            }
        });
    }

    static boolean b() {
        return e;
    }

    static /* synthetic */ Timer c(s sVar) {
        sVar.g = null;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
    
        if ((r4 != null && r4.getMeasurePolicy().getClass().getName().contains("ErrorMeasurePolicy")) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean c(androidx.compose.ui.node.LayoutNode r4) {
        /*
            androidx.compose.ui.node.LayoutNode$LayoutState r0 = r4.getLayoutState$ui_release()
            java.lang.String r0 = r0.toString()
            boolean r1 = r4.isPlaced()
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L2b
            if (r4 == 0) goto L28
            androidx.compose.ui.layout.MeasurePolicy r4 = r4.getMeasurePolicy()
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            java.lang.String r1 = "ErrorMeasurePolicy"
            boolean r4 = r4.contains(r1)
            if (r4 == 0) goto L28
            r4 = r3
            goto L29
        L28:
            r4 = r2
        L29:
            if (r4 == 0) goto L3c
        L2b:
            java.lang.String r4 = "Ready"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L3d
            java.lang.String r4 = "Idle"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L3c
            goto L3d
        L3c:
            return r2
        L3d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.s.c(androidx.compose.ui.node.LayoutNode):boolean");
    }

    static boolean d(LayoutNode layoutNode) {
        return layoutNode != null && layoutNode.getMeasurePolicy().getClass().getName().contains("ErrorMeasurePolicy");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(LayoutNode layoutNode) {
        if (layoutNode == null) {
            return false;
        }
        com.quantummetric.ui.internal.c cVar = this.c.get(Integer.valueOf(layoutNode.hashCode()));
        return (cVar instanceof co) && !((co) cVar).F;
    }

    private void f(LayoutNode layoutNode) {
        a(layoutNode.hashCode());
        for (LayoutNode layoutNode2 : layoutNode.getZSortedChildren().asMutableList()) {
            if (layoutNode2 != null) {
                f(layoutNode2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g(LayoutNode layoutNode) {
        int hashCode = layoutNode.hashCode();
        com.quantummetric.ui.internal.c cVar = this.c.get(Integer.valueOf(hashCode));
        co coVar = cVar instanceof co ? (co) cVar : null;
        String e2 = com.quantummetric.ui.internal.a.e(hashCode);
        if (coVar == null || (coVar instanceof cn)) {
            return e2;
        }
        return coVar.E > 0 ? e2 + "-" + coVar.E : e2;
    }

    final co a(LayoutNode layoutNode, float f, float f2) {
        if (layoutNode == null || !layoutNode.isAttached()) {
            return null;
        }
        boolean contains = layoutNode.getMeasurePolicy().toString().contains("ErrorMeasurePolicy");
        if (!contains) {
            if (!a(f, f2, layoutNode.isAttached() ? a(layoutNode.getCoordinates(), true) : null)) {
                return null;
            }
        }
        List asMutableList = layoutNode.getZSortedChildren().asMutableList();
        co coVar = null;
        for (int size = asMutableList.size() - 1; size >= 0; size--) {
            coVar = a((LayoutNode) asMutableList.get(size), f, f2);
            if (coVar != null) {
                break;
            }
        }
        if (coVar == null && !contains) {
            com.quantummetric.ui.internal.c cVar = this.c.get(Integer.valueOf(layoutNode.hashCode()));
            co coVar2 = cVar instanceof co ? (co) cVar : null;
            if (coVar2 != null && coVar2.B) {
                return coVar2;
            }
        }
        return coVar;
    }

    final c a(LayoutNode layoutNode, int i) {
        c cVar = new c(layoutNode, i);
        this.f.add(cVar);
        if (this.g == null) {
            Timer timer = new Timer(true);
            this.g = timer;
            timer.scheduleAtFixedRate(new TimerTask() { // from class: com.quantummetric.instrument.internal.s.6
                /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
                @Override // java.util.TimerTask, java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void run() {
                    /*
                        r3 = this;
                        com.quantummetric.instrument.internal.s r0 = com.quantummetric.ui.internal.s.this     // Catch: java.lang.Throwable -> L49
                        java.util.Set r0 = com.quantummetric.ui.internal.s.a(r0)     // Catch: java.lang.Throwable -> L49
                        java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L49
                    La:
                        boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L49
                        if (r1 == 0) goto L1c
                        java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L49
                        com.quantummetric.instrument.internal.s$c r1 = (com.quantummetric.instrument.internal.s.c) r1     // Catch: java.lang.Throwable -> L49
                        com.quantummetric.instrument.internal.s r2 = com.quantummetric.ui.internal.s.this     // Catch: java.lang.Throwable -> L49
                        com.quantummetric.ui.internal.s.a(r2, r1)     // Catch: java.lang.Throwable -> L49
                        goto La
                    L1c:
                        com.quantummetric.instrument.internal.e r0 = com.quantummetric.ui.internal.e.a()     // Catch: java.lang.Throwable -> L49
                        boolean r0 = r0.e     // Catch: java.lang.Throwable -> L49
                        if (r0 == 0) goto L32
                        boolean r0 = com.quantummetric.ui.internal.cd.f161a     // Catch: java.lang.Throwable -> L49
                        if (r0 != 0) goto L2f
                        com.quantummetric.instrument.internal.bu r0 = com.quantummetric.ui.QuantumMetric.b     // Catch: java.lang.Throwable -> L49
                        if (r0 != 0) goto L2d
                        goto L2f
                    L2d:
                        r0 = 0
                        goto L30
                    L2f:
                        r0 = 1
                    L30:
                        if (r0 == 0) goto L49
                    L32:
                        com.quantummetric.instrument.internal.s r0 = com.quantummetric.ui.internal.s.this     // Catch: java.lang.Throwable -> L49
                        java.util.Timer r0 = com.quantummetric.ui.internal.s.b(r0)     // Catch: java.lang.Throwable -> L49
                        r0.cancel()     // Catch: java.lang.Throwable -> L49
                        com.quantummetric.instrument.internal.s r0 = com.quantummetric.ui.internal.s.this     // Catch: java.lang.Throwable -> L49
                        com.quantummetric.ui.internal.s.c(r0)     // Catch: java.lang.Throwable -> L49
                        com.quantummetric.instrument.internal.s r0 = com.quantummetric.ui.internal.s.this     // Catch: java.lang.Throwable -> L49
                        java.util.Set r0 = com.quantummetric.ui.internal.s.a(r0)     // Catch: java.lang.Throwable -> L49
                        r0.clear()     // Catch: java.lang.Throwable -> L49
                    L49:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.s.AnonymousClass6.run():void");
                }
            }, Scanner.CAMERA_SETUP_DELAY_MS, Scanner.CAMERA_SETUP_DELAY_MS);
        }
        return cVar;
    }

    final void a(final LayoutNode layoutNode, final LayoutNode layoutNode2, final int i) {
        if (layoutNode == null || layoutNode2 == null) {
            return;
        }
        boolean z = false;
        if (cd.f161a || QuantumMetric.b == null) {
            return;
        }
        if (layoutNode2 != null && layoutNode2.getMeasurePolicy().getClass().getName().contains("ErrorMeasurePolicy")) {
            layoutNode2 = layoutNode.getParent$ui_release();
            i = a(layoutNode, layoutNode2);
        }
        if (i >= 0 && layoutNode.isAttached() && !e(layoutNode)) {
            z = true;
        }
        boolean e2 = e(layoutNode2);
        if (z && !e2) {
            LayoutNode parent$ui_release = layoutNode2.getParent$ui_release();
            a(layoutNode2, parent$ui_release, a(layoutNode2, parent$ui_release));
        }
        if (z && e2) {
            cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.s.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (s.this.e(layoutNode)) {
                        return;
                    }
                    com.quantummetric.ui.internal.a.a(layoutNode, s.this.g(layoutNode2), i, (o<di>) null);
                }
            }, 500);
        }
    }

    final void a(t tVar) {
        if ((tVar instanceof t) && this.f267a) {
            this.c.put(Integer.valueOf(tVar.f), tVar.e);
        }
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [V, com.quantummetric.instrument.internal.t] */
    final void a(HashSet<LayoutNode> hashSet) {
        HashSet hashSet2 = new HashSet();
        Iterator<LayoutNode> it = hashSet.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.quantummetric.ui.internal.c cVar = this.c.get(Integer.valueOf(it.next().hashCode()));
            co coVar = cVar instanceof co ? (co) cVar : null;
            if (coVar != null && coVar.D != co.a.b) {
                coVar.D = co.a.b;
                hashSet2.add(coVar);
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            co coVar2 = (co) it2.next();
            coVar2.D = co.a.f174a;
            LayoutNode layoutNode = coVar2.x.get();
            if (layoutNode != null && layoutNode.isAttached() && coVar2.b(layoutNode)) {
                final int i = coVar2 instanceof cp ? ((cp) coVar2).o : 0;
                final ap apVar = new ap();
                bp bpVar = new bp(bz.a(), new dc() { // from class: com.quantummetric.instrument.internal.s.10
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.quantummetric.ui.internal.dc
                    public final void a() {
                        t tVar = (t) apVar.f61a;
                        if (tVar == null) {
                            return;
                        }
                        if (tVar instanceof u) {
                            cp cpVar = (cp) tVar.e;
                            if (i != cpVar.o) {
                                s.a(s.this, tVar);
                                if (!cpVar.q || cpVar.o == 0) {
                                    return;
                                }
                                s.a((u) tVar);
                                return;
                            }
                        }
                        s.b(s.this, tVar);
                    }
                });
                ?? a2 = dh.a(layoutNode, null, bpVar, true);
                a2.s();
                apVar.f61a = a2;
                bpVar.d = true;
                bpVar.a(false);
                if (!bpVar.e) {
                    cl.a(bpVar.new AnonymousClass3(), 50);
                }
            }
        }
    }

    final void a(List<LayoutNode> list) {
        LayoutNode next;
        while (true) {
            Iterator<LayoutNode> it = list.iterator();
            while (it.hasNext()) {
                next = it.next();
                boolean z = true;
                if (next != null && next.getMeasurePolicy().getClass().getName().contains("ErrorMeasurePolicy")) {
                    break;
                }
                int hashCode = next.hashCode();
                if (!cd.f161a && QuantumMetric.b != null) {
                    z = false;
                }
                if (!z && e(next)) {
                    com.quantummetric.ui.internal.a.c(com.quantummetric.ui.internal.a.d(hashCode));
                    f(next);
                }
            }
            return;
            list = next.getZSortedChildren().asMutableList();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021 A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x001b, B:9:0x0021, B:11:0x0025), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final boolean a(com.quantummetric.ui.internal.t r5, androidx.compose.ui.node.LayoutNode r6) {
        /*
            r4 = this;
            r0 = 0
            androidx.compose.ui.node.LayoutNode r6 = r6.getParent$ui_release()     // Catch: java.lang.Throwable -> L3e
            if (r6 == 0) goto L1e
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.quantummetric.instrument.internal.c> r1 = r4.c     // Catch: java.lang.Throwable -> L3e
            int r6 = r6.hashCode()     // Catch: java.lang.Throwable -> L3e
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r6 = r1.get(r6)     // Catch: java.lang.Throwable -> L3e
            com.quantummetric.instrument.internal.c r6 = (com.quantummetric.ui.internal.c) r6     // Catch: java.lang.Throwable -> L3e
            boolean r1 = r6 instanceof com.quantummetric.ui.internal.cn     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L1e
            com.quantummetric.instrument.internal.cn r6 = (com.quantummetric.ui.internal.cn) r6     // Catch: java.lang.Throwable -> L3e
            goto L1f
        L1e:
            r6 = 0
        L1f:
            if (r6 == 0) goto L3e
            boolean r1 = r6.u     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L3d
            int r1 = r5.i     // Catch: java.lang.Throwable -> L3e
            int r2 = r6.q     // Catch: java.lang.Throwable -> L3e
            double r2 = (double) r2     // Catch: java.lang.Throwable -> L3e
            int r2 = com.quantummetric.ui.internal.de.b(r2)     // Catch: java.lang.Throwable -> L3e
            int r1 = r1 - r2
            r5.i = r1     // Catch: java.lang.Throwable -> L3e
            int r1 = r5.h     // Catch: java.lang.Throwable -> L3e
            int r6 = r6.r     // Catch: java.lang.Throwable -> L3e
            double r2 = (double) r6     // Catch: java.lang.Throwable -> L3e
            int r6 = com.quantummetric.ui.internal.de.b(r2)     // Catch: java.lang.Throwable -> L3e
            int r1 = r1 - r6
            r5.h = r1     // Catch: java.lang.Throwable -> L3e
        L3d:
            r0 = 1
        L3e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.s.a(com.quantummetric.instrument.internal.t, androidx.compose.ui.node.LayoutNode):boolean");
    }

    final co b(LayoutNode layoutNode) {
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (parent$ui_release == null) {
            return null;
        }
        com.quantummetric.ui.internal.c cVar = this.c.get(Integer.valueOf(parent$ui_release.hashCode()));
        if (cVar instanceof co) {
            return (co) cVar;
        }
        return null;
    }
}
