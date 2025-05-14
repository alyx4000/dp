package com.quantummetric.ui.internal;

import android.view.View;
import android.widget.AbsListView;
import com.quantummetric.ui.internal.k;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
class cx extends da {
    WeakReference<View> A;
    private k.a o;
    int s;
    int t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    boolean z;

    cx(View view) {
        super(view);
        boolean z = false;
        this.s = 0;
        this.t = 0;
        this.x = true;
        if (k.f262a == null) {
            k.f262a = new k();
        }
        this.o = k.f262a.a(view, k.c.f264a);
        if (cc.A && (cc.B || (!ag.a(view) && !(view instanceof AbsListView)))) {
            z = true;
        }
        this.z = z;
        if (cc.c(view)) {
            b(view);
        }
    }

    void a(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return;
        }
        this.s += i;
        this.t += i2;
        dk.a(i, i2);
        k.a aVar = this.o;
        if (aVar == null || aVar.g == null) {
            return;
        }
        aVar.g.a();
    }

    final boolean b(View view) {
        if (view == null) {
            return false;
        }
        if (this.s == view.getScrollX() && this.t == view.getScrollY()) {
            return false;
        }
        int i = this.s;
        int i2 = this.t;
        this.s = view.getScrollX();
        int scrollY = view.getScrollY();
        this.t = scrollY;
        dk.a(this.s - i, scrollY - i2);
        k.a aVar = this.o;
        if (aVar == null || aVar.g == null) {
            return true;
        }
        aVar.g.a();
        return true;
    }
}
