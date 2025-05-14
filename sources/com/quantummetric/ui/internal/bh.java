package com.quantummetric.ui.internal;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import com.facebook.react.uimanager.ViewProps;

/* loaded from: classes5.dex */
final class bh implements ch {

    /* renamed from: a, reason: collision with root package name */
    bh f109a;
    boolean b;
    int c;
    boolean d;
    int e;
    int f;
    int g;
    int h;
    int i;
    float j;
    float k;
    int l;
    boolean m;
    ar n;
    private int o;
    private int p;

    bh(Rect rect, int[] iArr) {
        this.j = 1.0f;
        if (rect != null) {
            this.g = de.b(rect.getLeft());
            this.h = de.b(rect.getTop());
            this.e = de.b(rect.getRight() - rect.getLeft());
            this.f = de.b(rect.getBottom() - rect.getTop());
            this.c = t.a(rect);
            if (iArr != null) {
                this.g -= iArr[0];
                this.h -= iArr[1];
            }
        }
    }

    bh(LayoutCoordinates layoutCoordinates) {
        this(layoutCoordinates, (int[]) null);
        this.b = true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    bh(LayoutCoordinates layoutCoordinates, int[] iArr) {
        this(s.a(layoutCoordinates, false), iArr);
        s.a();
    }

    private boolean l() {
        if (this.j == 1.0f && this.g + this.h + this.i + this.k == 0.0f) {
            ar arVar = this.n;
            if (arVar != null) {
                if (arVar.f65a.length() == 0) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.quantummetric.ui.internal.ch
    public final int a() {
        return this.e;
    }

    @Override // com.quantummetric.ui.internal.ch
    public final void a(float f) {
        this.k = f;
    }

    final void a(int i, t tVar) {
        bh bhVar = this;
        while (true) {
            co coVar = (co) tVar.e;
            boolean z = (bhVar.b || bhVar.l()) ? false : true;
            bhVar.d = z;
            if (z) {
                if (!(tVar instanceof r)) {
                    tVar.s = false;
                }
                i++;
                bhVar.o = i;
                if (!tVar.D) {
                    coVar.E = i;
                }
                bhVar.p = coVar.x.get().hashCode();
            }
            bh bhVar2 = bhVar.f109a;
            if (bhVar2 == null) {
                bhVar.m = true;
                return;
            }
            bhVar = bhVar2;
        }
    }

    @Override // com.quantummetric.ui.internal.ch
    public final int b() {
        return this.f;
    }

    @Override // com.quantummetric.ui.internal.ch
    public final int c() {
        return this.h;
    }

    @Override // com.quantummetric.ui.internal.ch
    public final int d() {
        return this.g;
    }

    @Override // com.quantummetric.ui.internal.ch
    public final int e() {
        return this.i;
    }

    @Override // com.quantummetric.ui.internal.ch
    public final float f() {
        return this.j;
    }

    @Override // com.quantummetric.ui.internal.ch
    public final float g() {
        return this.k;
    }

    @Override // com.quantummetric.ui.internal.ch
    public final ar h() {
        if (this.n == null) {
            this.n = new ar();
        }
        return this.n;
    }

    @Override // com.quantummetric.ui.internal.ch
    public final boolean i() {
        return this.m;
    }

    final void j() {
        if (this.n == null) {
            this.n = new ar();
        }
        ar arVar = this.n;
        if (arVar.f65a.lastIndexOf(ViewProps.OVERFLOW) != -1) {
            return;
        }
        arVar.f65a.append(ViewProps.OVERFLOW).append(":").append((Object) ViewProps.HIDDEN).append(";");
    }

    final String k() {
        return a.d(this.p) + "-" + this.o;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[" + this.g + "," + this.h + ";w=" + this.e + "h=" + this.f + ";emp=" + l() + ";root=" + this.b);
        bh bhVar = this.f109a;
        if (bhVar != null) {
            sb.append(bhVar);
        }
        sb.append("]");
        return sb.toString();
    }
}
