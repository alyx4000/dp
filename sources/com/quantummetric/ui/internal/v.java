package com.quantummetric.ui.internal;

import android.view.View;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidComposeView;

/* loaded from: classes5.dex */
final class v extends dg {
    public v(View view) {
        super(view);
    }

    static LayoutNode a(View view) {
        try {
            if (ag.m(view)) {
                return ((AndroidComposeView) view).getRoot();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
