package com.quantummetric.ui.internal;

import android.view.View;
import androidx.compose.ui.node.LayoutNode;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
final class cq extends co {
    WeakReference<View> o;

    cq(LayoutNode layoutNode) {
        super(layoutNode);
    }

    @Override // com.quantummetric.ui.internal.co, com.quantummetric.ui.internal.c
    final void a(Object obj) {
        super.a(obj);
        if (ag.c(obj)) {
            Object b = by.b(((LayoutNode) obj).getMeasurePolicy(), "$this_run", "typedView");
            if (b instanceof View) {
                this.o = new WeakReference<>((View) b);
            }
        }
    }
}
