package com.quantummetric.ui.internal;

import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.TextStyle;
import com.quantummetric.ui.internal.bd;
import com.quantummetric.ui.internal.cj;
import com.quantummetric.ui.internal.ck;

/* loaded from: classes5.dex */
final class u extends t implements cj.a {
    String F;
    TextDelegate G;
    Object H;
    int I;
    private float J;

    u(LayoutNode layoutNode) {
        super(layoutNode);
    }

    @Override // com.quantummetric.ui.internal.t, com.quantummetric.ui.internal.b
    final void a(ar arVar) {
        super.a(arVar);
        cj.a((b) this, arVar);
    }

    final void b(float f) {
        this.J = f;
        if (Float.isNaN(f)) {
            this.J = 14.0f;
        }
        this.J = de.a(this.J);
    }

    public final void b(String str) {
        if (de.b(str) || !(this.e instanceof cp)) {
            return;
        }
        cp cpVar = (cp) this.e;
        if (str.equals("Left") || str.equals("Start")) {
            cpVar.p[1] = 0;
        }
        if (str.equals("Center")) {
            cpVar.p[1] = 1;
        } else if (str.equals("Right") || str.equals("End")) {
            cpVar.p[1] = 2;
        }
    }

    @Override // com.quantummetric.instrument.internal.cj.a
    public final ar f(ar arVar) {
        return cj.a((cj.a) this, arVar);
    }

    @Override // com.quantummetric.instrument.internal.cj.a
    public final void g(ar arVar) {
        if (this.e instanceof cj.b) {
            cj.a(this.F, (cj.b) this.e, arVar, (ck.a) null);
        }
    }

    @Override // com.quantummetric.ui.internal.b
    public final void m() {
        TextDelegate textDelegate;
        super.m();
        cp cpVar = (cp) this.e;
        if (!de.b(cpVar.y)) {
            bd.b bVar = bd.a().e.get(cpVar.y);
            if (bVar != null) {
                cpVar.a(bVar.i, false, bVar.g, bVar.h);
            }
        }
        if (cpVar.q && this.G == null) {
            LayoutNode layoutNode = this.A.get();
            if (layoutNode != null) {
                Object b = by.b(layoutNode.getMeasurePolicy(), "$state", "textDelegate");
                if (b instanceof TextDelegate) {
                    textDelegate = (TextDelegate) b;
                    this.G = textDelegate;
                }
            }
            textDelegate = null;
            this.G = textDelegate;
        }
        TextDelegate textDelegate2 = this.G;
        if (textDelegate2 != null) {
            if (textDelegate2.getText() != null) {
                this.F = this.G.getText().toString();
            }
            az.a(this, this.G.getStyle());
        } else {
            Object obj = this.H;
            if (obj != null) {
                Object b2 = by.b(obj, "text");
                if (b2 != null) {
                    this.F = b2.toString();
                }
                Object b3 = by.b(this.H, "style");
                if (b3 instanceof TextStyle) {
                    az.a(this, (TextStyle) b3);
                }
                Object b4 = by.b(this.H, "color");
                if (b4 != null) {
                    Integer valueOf = ag.e(b4) ? Integer.valueOf(ColorKt.toArgb-8_81llA(((ColorProducer) b4).invoke-0d7_KjU())) : null;
                    if (valueOf != null) {
                        this.I = valueOf.intValue();
                    }
                }
            }
        }
        String str = this.F;
        if (str != null) {
            cpVar.o = de.i(str);
            cj.b(cpVar, str);
        }
    }

    @Override // com.quantummetric.instrument.internal.cj.a
    public final int t() {
        return this.I;
    }

    @Override // com.quantummetric.instrument.internal.cj.a
    public final float u() {
        return this.J;
    }

    @Override // com.quantummetric.instrument.internal.cj.a
    public final String v() {
        return this.F;
    }
}
