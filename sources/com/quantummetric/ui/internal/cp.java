package com.quantummetric.ui.internal;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsModifier;
import com.quantummetric.ui.internal.cj;

/* loaded from: classes5.dex */
final class cp extends co implements cj.b {
    int o;
    short[] p;
    boolean q;
    boolean r;
    boolean s;
    private boolean t;
    private boolean u;
    private boolean v;

    cp(LayoutNode layoutNode) {
        super(layoutNode);
        this.o = 0;
        this.p = new short[2];
    }

    static boolean a(String str) {
        return de.b(str, "TextController", "TextAnnotatedStringElement", "TextStringSimpleElement") || str.contains("CoreTextField");
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final void a(ar arVar) {
    }

    @Override // com.quantummetric.ui.internal.co, com.quantummetric.ui.internal.c
    final void a(Object obj) {
        super.a(obj);
        if (this.v || !(obj instanceof LayoutNode)) {
            return;
        }
        LayoutNode layoutNode = (LayoutNode) obj;
        boolean contains = layoutNode.getMeasurePolicy().toString().contains("CoreTextField");
        this.q = contains;
        if (contains) {
            if (cu.f176a == null) {
                cu.f176a = new cu();
            }
            this.v = cu.f176a.b.contains(Integer.valueOf(layoutNode.hashCode()));
        }
        if (this.v) {
            cj.a((cj.b) this, true, false, false);
        }
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final void a(boolean z) {
        this.r = z;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final boolean a() {
        return this.r;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final void b(boolean z) {
        this.s = z;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final boolean b() {
        return this.s;
    }

    @Override // com.quantummetric.ui.internal.co
    protected final boolean b(Modifier modifier) {
        boolean b = super.b(modifier);
        if (b) {
            return b;
        }
        return (modifier instanceof SemanticsModifier) || a(modifier.getClass().getSimpleName());
    }

    @Override // com.quantummetric.ui.internal.co
    protected final boolean b(LayoutNode layoutNode) {
        return this.q || super.b(layoutNode);
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final boolean c() {
        return this.t;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final void d() {
        this.t = true;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final boolean e() {
        return this.u;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final void f() {
        this.u = true;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final boolean g() {
        return false;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final Object h() {
        return this.x.get();
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final short[] i() {
        return this.p;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final boolean j() {
        return this.q;
    }
}
