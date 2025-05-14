package com.quantummetric.ui.internal;

import androidx.compose.runtime.AbstractApplier;
import androidx.compose.runtime.Applier;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.UiApplier;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes5.dex */
final class dd extends AbstractApplier<LayoutNode> {

    /* renamed from: a, reason: collision with root package name */
    private static Method f178a;
    private final UiApplier b;
    private final HashSet<LayoutNode> c;
    private boolean d;

    private dd(UiApplier uiApplier) {
        super((LayoutNode) uiApplier.getRoot());
        this.b = uiApplier;
        this.c = new HashSet<>();
    }

    static AbstractApplier<?> a(Applier<?> applier) {
        if (applier instanceof UiApplier) {
            return new dd((UiApplier) applier);
        }
        return null;
    }

    static /* synthetic */ boolean a(dd ddVar) {
        ddVar.d = false;
        return false;
    }

    public final /* synthetic */ void down(Object obj) {
        LayoutNode layoutNode = (LayoutNode) obj;
        UiApplier uiApplier = this.b;
        if (uiApplier != null) {
            uiApplier.down(layoutNode);
            try {
                LayoutNode layoutNode2 = (LayoutNode) this.b.getCurrent();
                if (layoutNode2.isAttached()) {
                    this.c.add(layoutNode2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final /* bridge */ /* synthetic */ Object getCurrent() {
        UiApplier uiApplier = this.b;
        if (uiApplier != null) {
            return (LayoutNode) uiApplier.getCurrent();
        }
        return null;
    }

    public final /* synthetic */ void insertBottomUp(int i, Object obj) {
        LayoutNode layoutNode = (LayoutNode) obj;
        UiApplier uiApplier = this.b;
        if (uiApplier != null) {
            uiApplier.insertBottomUp(i, layoutNode);
            s.a().a(layoutNode, (LayoutNode) this.b.getCurrent(), i);
        }
    }

    public final /* bridge */ /* synthetic */ void insertTopDown(int i, Object obj) {
        LayoutNode layoutNode = (LayoutNode) obj;
        UiApplier uiApplier = this.b;
        if (uiApplier != null) {
            uiApplier.insertTopDown(i, layoutNode);
        }
    }

    public final void move(int i, int i2, int i3) {
        UiApplier uiApplier = this.b;
        if (uiApplier != null) {
            uiApplier.move(i, i2, i3);
        }
    }

    public final void onBeginChanges() {
        UiApplier uiApplier = this.b;
        if (uiApplier != null) {
            uiApplier.onBeginChanges();
        }
    }

    protected final void onClear() {
        try {
            List<LayoutNode> foldedChildren$ui_release = ((LayoutNode) getRoot()).getFoldedChildren$ui_release();
            if (f178a == null) {
                Method declaredMethod = this.b.getClass().getDeclaredMethod("onClear", new Class[0]);
                f178a = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            s.a().a(foldedChildren$ui_release);
            f178a.invoke(this.b, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public final void onEndChanges() {
        UiApplier uiApplier = this.b;
        if (uiApplier != null) {
            uiApplier.onEndChanges();
            if (this.c.size() <= 0 || this.d) {
                return;
            }
            this.d = true;
            cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.dd.1
                @Override // java.lang.Runnable
                public final void run() {
                    dd.a(dd.this);
                    s.a().a(dd.this.c);
                    dd.this.c.clear();
                }
            }, 200);
        }
    }

    public final void remove(int i, int i2) {
        if (this.b != null) {
            ArrayList arrayList = new ArrayList(i2);
            try {
                List foldedChildren$ui_release = ((LayoutNode) this.b.getCurrent()).getFoldedChildren$ui_release();
                for (int i3 = i; i3 < i + i2; i3++) {
                    if (foldedChildren$ui_release.size() > i) {
                        arrayList.add((LayoutNode) foldedChildren$ui_release.get(i3));
                    }
                }
            } catch (Throwable unused) {
            }
            this.b.remove(i, i2);
            s.a().a(arrayList);
        }
    }

    public final void up() {
        UiApplier uiApplier = this.b;
        if (uiApplier != null) {
            uiApplier.up();
        }
    }
}
