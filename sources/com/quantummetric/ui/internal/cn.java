package com.quantummetric.ui.internal;

import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.ui.node.LayoutNode;

/* loaded from: classes5.dex */
final class cn extends co {
    int o;
    int p;
    int q;
    int r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;

    cn(LayoutNode layoutNode) {
        super(layoutNode);
        this.s = true;
        this.t = true;
        this.u = true;
        this.B = true;
    }

    final void a(int i) {
        int i2 = this.o;
        int i3 = this.p;
        int i4 = -i;
        if (this.t) {
            this.p = i4;
        } else {
            this.o = i4;
        }
        if (i2 == this.o && i3 == this.p) {
            return;
        }
        dk.a(Math.round(r4 - i2), Math.round(Math.round(this.p - i3)));
    }

    final void b(Object obj) {
        this.u = false;
        if (obj != null) {
            Object value = obj instanceof SnapshotMutableState ? ((SnapshotMutableState) obj).getValue() : null;
            if (value instanceof Integer) {
                a(((Integer) value).intValue());
            }
            this.q = this.o;
            this.r = this.p;
            this.s = true;
        }
    }
}
