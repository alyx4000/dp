package com.quantummetric.ui.internal;

import android.view.View;
import com.facebook.react.views.view.ReactViewGroup;

/* loaded from: classes5.dex */
final class bw extends dg {
    bw(View view) {
        super(view);
    }

    @Override // com.quantummetric.ui.internal.dg, com.quantummetric.ui.internal.b
    public final void j() {
        super.j();
        View view = this.F.get();
        try {
            if (aa.v && ag.l(view)) {
                this.s = this.s && aa.ab.equals((String) ReactViewGroup.class.getDeclaredMethod("getOverflow", new Class[0]).invoke(view, new Object[0]));
            }
        } catch (Throwable unused) {
        }
        if (!ag.c(this.g) || view == null) {
            return;
        }
        try {
            if (this.e == null || this.e.b) {
                return;
            }
            if (((Boolean) view.getClass().getDeclaredMethod("mask", new Class[0]).invoke(view, new Object[0])).booleanValue()) {
                this.e.b = true;
            } else if (((Boolean) view.getClass().getDeclaredMethod("encrypt", new Class[0]).invoke(view, new Object[0])).booleanValue()) {
                this.e.d = true;
            } else if (((Boolean) view.getClass().getDeclaredMethod("unmask", new Class[0]).invoke(view, new Object[0])).booleanValue()) {
                this.e.e = true;
            }
        } catch (Throwable unused2) {
        }
    }
}
