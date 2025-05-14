package com.quantummetric.ui.internal;

import androidx.compose.ui.node.LayoutNode;

/* loaded from: classes5.dex */
final class r extends t {
    r(LayoutNode layoutNode) {
        super(layoutNode);
    }

    @Override // com.quantummetric.ui.internal.t, com.quantummetric.ui.internal.b
    final void a(ar arVar) {
        super.a(arVar);
        a.f(this.f);
        arVar.a((ar) "<div id=\"").a((ar) a.e(this.f)).a((ar) "\" style=\"");
        if (this.e instanceof cn) {
            cn cnVar = (cn) this.e;
            String str = aa.ag;
            arVar.f65a.append(str).append(":").append(Integer.valueOf(de.b(cnVar.o))).append(aa.f).append(";");
            String str2 = aa.ah;
            arVar.f65a.append(str2).append(":").append(Integer.valueOf(de.b(cnVar.p))).append(aa.f).append(";");
        }
        arVar.a((ar) "\" class=\"s\">");
    }
}
