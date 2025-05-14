package com.quantummetric.ui.internal;

import android.view.View;
import androidx.compose.ui.node.LayoutNode;

/* loaded from: classes5.dex */
final class w extends t {
    w(LayoutNode layoutNode) {
        super(layoutNode);
    }

    final View t() {
        cq cqVar = (cq) this.e;
        View view = (cqVar.o == null || cqVar.o.get() == null) ? null : cqVar.o.get();
        if (view != null) {
            this.z = true;
            this.s = true;
        }
        return view;
    }
}
