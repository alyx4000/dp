package com.quantummetric.ui.internal;

import android.graphics.Bitmap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.node.LayoutNode;
import com.quantummetric.ui.internal.bp.AnonymousClass2;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes5.dex */
class t extends b {
    WeakReference<LayoutNode> A;
    WeakReference<Bitmap> B;
    boolean C;
    boolean D;
    bh E;
    private List<ModifierInfo> F;

    t(LayoutNode layoutNode) {
        this.A = new WeakReference<>(layoutNode);
        this.C = b(layoutNode);
        this.F = layoutNode.getModifierInfo();
        this.f = layoutNode.hashCode();
        String[] split = layoutNode.getMeasurePolicy().toString().split("\\.");
        this.g = split[split.length - 1].split("@|(\\$)")[0];
        boolean z = layoutNode.getZSortedChildren().asMutableList().size() > 0;
        this.z = z;
        if (z) {
            this.s = true;
        }
        this.n = 1.0f;
    }

    static int a(Rect rect) {
        return (int) ((((((rect.getLeft() * 31.0f) + rect.getTop()) * 31.0f) + rect.getRight()) * 31.0f) + rect.getBottom());
    }

    static t a(co coVar, boolean z) {
        LayoutNode layoutNode;
        t tVar = null;
        if (coVar != null && (layoutNode = coVar.x.get()) != null) {
            if (coVar instanceof cp) {
                tVar = new u(layoutNode);
            } else if (coVar instanceof cn) {
                tVar = new r(layoutNode);
            } else if (coVar instanceof cq) {
                tVar = new w(layoutNode);
            }
            if (tVar == null) {
                tVar = new t(layoutNode);
            }
            tVar.e = coVar;
            tVar.D = z;
            tVar.j();
            tVar.m();
            tVar.d = coVar.m;
        }
        return tVar;
    }

    private String a(b bVar, int i) {
        String b = i == 0 ? b(bVar) : "";
        if (!de.b(b) || bVar.c == null) {
            return b;
        }
        for (b bVar2 : bVar.c) {
            String b2 = b(bVar2);
            if (bVar2 instanceof u) {
                b2 = ((u) bVar2).F;
                if (!de.b(b2)) {
                    return b2;
                }
            }
            if (!de.b(b2) || i >= 2) {
                b = b2;
            } else {
                b = a(bVar2, i);
                i++;
            }
        }
        return b;
    }

    private void a(LayoutNode layoutNode) {
        s.a();
        LayoutNode a2 = s.a(layoutNode);
        s.a();
        if (s.d(a2)) {
            Object b = by.b(layoutNode, "placeOrder");
            if (b instanceof Integer) {
                Integer num = (Integer) b;
                if (num.intValue() != Integer.MAX_VALUE) {
                    this.m = num.intValue();
                }
            }
        }
    }

    private static String b(b bVar) {
        if (bVar instanceof u) {
            cp cpVar = (cp) bVar.e;
            String str = ((u) bVar).F;
            if (!cpVar.r && !cpVar.s) {
                return str;
            }
        }
        return null;
    }

    private static boolean b(LayoutNode layoutNode) {
        try {
            return ((Boolean) by.b(layoutNode, LayoutNode.class, "isVirtual")).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private void t() {
        try {
            co coVar = (co) this.e;
            coVar.C.clear();
            int[] iArr = {0, 0};
            bh bhVar = null;
            boolean z = false;
            for (ModifierInfo modifierInfo : this.F) {
                Modifier modifier = modifierInfo.getModifier();
                LayoutCoordinates coordinates = modifierInfo.getCoordinates();
                s.a();
                int a2 = a(s.a(coordinates, false));
                if (bhVar == null) {
                    bhVar = new bh(coordinates);
                    this.E = bhVar;
                    iArr[0] = iArr[0] + bhVar.g;
                    iArr[1] = iArr[1] + bhVar.h;
                } else if (bhVar.c != a2) {
                    bhVar.f109a = new bh(coordinates, iArr);
                }
                if (bhVar.f109a != null) {
                    bhVar = bhVar.f109a;
                    iArr[0] = iArr[0] + bhVar.g;
                    iArr[1] = iArr[1] + bhVar.h;
                }
                try {
                    bi.a(this, bhVar, modifier);
                } catch (Throwable unused) {
                }
                coVar.a(modifier);
                if (bhVar.l != 0) {
                    iArr[0] = iArr[0] + bhVar.l;
                    iArr[1] = iArr[1] + bhVar.l;
                }
                if (modifier.getClass().getSimpleName().equals("SlideModifier")) {
                    z = true;
                }
            }
            if (!z) {
                LayoutCoordinates coordinates2 = this.A.get().getCoordinates();
                if (bhVar != null) {
                    int i = bhVar.c;
                    s.a();
                    if (i != a(s.a(coordinates2, false))) {
                        bhVar.f109a = new bh(coordinates2, iArr);
                    }
                }
            }
            bh bhVar2 = this.E;
            if (bhVar2 != null) {
                co coVar2 = (co) this.e;
                if (!this.D) {
                    coVar2.E = 0;
                }
                bhVar2.a(0, this);
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // com.quantummetric.ui.internal.b
    void a(ar arVar) {
        boolean z = y.e && !this.e.e;
        if (this.w && !this.e.b && !z) {
            d(arVar);
        }
        if (this.e instanceof co) {
            co coVar = (co) this.e;
            if (!coVar.B || coVar.b || coVar.d || z) {
                return;
            }
            coVar.A = a(this, 0);
            de.b(coVar.A);
        }
    }

    protected final void a(bp bpVar) {
        WeakReference<Bitmap> weakReference = this.B;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        Bitmap bitmap = this.B.get();
        this.w = true;
        h<String> hVar = new h<String>() { // from class: com.quantummetric.instrument.internal.t.1
            @Override // com.quantummetric.ui.internal.h
            public final /* bridge */ /* synthetic */ void a(String str) {
                t.this.a(str);
            }
        };
        co coVar = (co) this.e;
        bpVar.b++;
        bpVar.f126a.a(bitmap, coVar, bpVar.new AnonymousClass2(hVar));
    }

    @Override // com.quantummetric.ui.internal.b
    protected final void b(ar arVar) {
        bh bhVar = this.E;
        if (bhVar == null) {
            return;
        }
        while (true) {
            if (bhVar.d) {
                String k = bhVar.k();
                arVar.a((ar) "<div style=\"");
                di.a(arVar, bhVar);
                arVar.a((ar) "\" id=\"").a((ar) k);
                if (bhVar.m) {
                    arVar.a((ar) "\" class=\"");
                    new ac().a(arVar, bhVar);
                }
                arVar.a((ar) "\">");
            }
            if (bhVar.f109a == null) {
                return;
            } else {
                bhVar = bhVar.f109a;
            }
        }
    }

    @Override // com.quantummetric.ui.internal.b
    protected final void c(ar arVar) {
        bh bhVar = this.E;
        if (bhVar != null) {
            if (bhVar.d) {
                arVar.a((ar) "</div>");
            }
            if (bhVar.f109a != null) {
                do {
                    bhVar = bhVar.f109a;
                    if (bhVar.d) {
                        arVar.a((ar) "</div>");
                    }
                } while (bhVar.f109a != null);
            }
        }
    }

    @Override // com.quantummetric.ui.internal.b
    final void j() {
        LayoutNode layoutNode = this.A.get();
        s.a();
        Rect a2 = layoutNode.isAttached() ? s.a(layoutNode.getCoordinates(), false) : null;
        if (layoutNode == null || !layoutNode.isAttached() || a2 == null) {
            return;
        }
        ((co) this.e).a(a2);
        t();
        k();
    }

    @Override // com.quantummetric.ui.internal.b
    final void k() {
        LayoutNode layoutNode = this.A.get();
        if (this.E == null) {
            this.E = new bh(layoutNode.getCoordinates());
        }
        this.i = this.E.g;
        this.h = this.E.h;
        if (!this.C && !s.a().a(this, layoutNode)) {
            a(layoutNode);
        }
        this.j = this.E.e;
        this.k = this.E.f;
    }
}
