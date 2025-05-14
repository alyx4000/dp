package com.quantummetric.ui.internal;

import android.view.View;
import com.quantummetric.ui.internal.ax.AnonymousClass5;

/* loaded from: classes5.dex */
final class db extends da {
    ax o;
    boolean p;

    db(View view) {
        super(view);
        this.o = ax.a(view);
    }

    final void a(ax axVar) {
        if (this.o != null || axVar == null) {
            return;
        }
        this.o = axVar;
        if (this.p) {
            this.p = false;
            cl.c(axVar.new AnonymousClass5());
        }
    }
}
