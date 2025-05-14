package com.quantummetric.ui.internal;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes5.dex */
class co extends c {
    boolean B;
    int E;
    boolean F;
    private float o;
    private float p;
    private int q;
    private int r;
    WeakReference<LayoutNode> x;
    String y = "";
    String z = "";
    String A = "";
    int D = a.f174a;
    HashSet<Integer> C = new HashSet<>();

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f174a = 1;
        public static final int b = 2;
        private static final /* synthetic */ int[] c = {1, 2};

        public static int[] values$35071be1() {
            return (int[]) c.clone();
        }
    }

    co(LayoutNode layoutNode) {
        this.x = new WeakReference<>(layoutNode);
        a((Object) layoutNode);
    }

    static co a(LayoutNode layoutNode) {
        co coVar;
        boolean z;
        String obj = layoutNode.getMeasurePolicy().toString();
        if (!cp.a(obj)) {
            if (!obj.contains("AndroidViewHolder")) {
                Iterator it = layoutNode.getModifierInfo().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        coVar = null;
                        break;
                    }
                    ModifierInfo modifierInfo = (ModifierInfo) it.next();
                    if (cp.a(modifierInfo.getModifier().getClass().getSimpleName())) {
                        coVar = new cp(layoutNode);
                        break;
                    }
                    SemanticsModifier modifier = modifierInfo.getModifier();
                    boolean z2 = false;
                    if (modifier instanceof SemanticsModifier) {
                        Iterator it2 = modifier.getSemanticsConfiguration().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = false;
                                break;
                            }
                            if (((SemanticsPropertyKey) ((Map.Entry) it2.next()).getKey()).toString().contains("ScrollAxisRange")) {
                                z = true;
                                break;
                            }
                        }
                        if (z) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        coVar = new cn(layoutNode);
                        break;
                    }
                }
            } else {
                coVar = new cq(layoutNode);
            }
        } else {
            coVar = new cp(layoutNode);
        }
        return coVar == null ? new co(layoutNode) : coVar;
    }

    final void a(Modifier modifier) {
        if (b(modifier)) {
            this.C.add(Integer.valueOf(modifier.hashCode()));
        }
    }

    final void a(Rect rect) {
        this.o = rect.getLeft();
        this.p = rect.getTop();
        this.q = (int) (rect.getRight() - rect.getLeft());
        this.r = (int) (rect.getBottom() - rect.getTop());
    }

    @Override // com.quantummetric.ui.internal.c
    void a(Object obj) {
        this.F = false;
    }

    @Override // com.quantummetric.ui.internal.c
    final String a_() {
        return this.y;
    }

    protected boolean b(Modifier modifier) {
        boolean z;
        String simpleName = modifier.getClass().getSimpleName();
        if (simpleName.equals("DrawBehindElement")) {
            Object a2 = bi.a(by.b(modifier, "onDraw"));
            if ((a2 instanceof Float) && ((Float) a2).floatValue() >= 0.0f) {
                z = true;
                return !de.a(simpleName, "Background", "BackgroundElement", "DrawContentCacheModifier", "BorderModifierNodeElement", "PainterModifier", "PainterElement") || z;
            }
        }
        z = false;
        if (de.a(simpleName, "Background", "BackgroundElement", "DrawContentCacheModifier", "BorderModifierNodeElement", "PainterModifier", "PainterElement")) {
        }
    }

    protected boolean b(LayoutNode layoutNode) {
        if (layoutNode.isAttached()) {
            if (!c(layoutNode)) {
                Iterator it = layoutNode.getModifierInfo().iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Modifier modifier = ((ModifierInfo) it.next()).getModifier();
                    if (b(modifier)) {
                        if (!this.C.contains(Integer.valueOf(modifier.hashCode()))) {
                            z = true;
                        }
                    } else if (modifier instanceof SemanticsModifier) {
                        bi.a((t) null, this, modifier);
                    }
                }
                if (z) {
                }
            }
            return true;
        }
        return false;
    }

    final boolean c(LayoutNode layoutNode) {
        s.a();
        Rect a2 = layoutNode.isAttached() ? s.a(layoutNode.getCoordinates(), false) : null;
        if (a2 == null) {
            return false;
        }
        boolean z = (this.q == ((int) (a2.getRight() - a2.getLeft())) && this.r == ((int) (a2.getBottom() - a2.getTop()))) ? false : true;
        return !z ? (this.o == a2.getLeft() && this.p == a2.getTop()) ? false : true : z;
    }
}
