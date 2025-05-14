package com.quantummetric.ui.internal;

import android.view.View;

/* loaded from: classes5.dex */
final class ci extends dg {
    ci(View view) {
        super(view);
    }

    @Override // com.quantummetric.ui.internal.dg, com.quantummetric.ui.internal.b
    public final void a(ar arVar) {
        if (this.e != null) {
            cy cyVar = (cy) this.e;
            String str = cyVar.o;
            if (!de.b(str)) {
                if (y.e && !this.e.e) {
                    str = de.h(str);
                }
                arVar.a((ar) "<span style=\"").a((ar) cyVar.b()).a((ar) "\">").a((ar) str).a((ar) "</span>");
            }
            super.a(arVar);
        }
    }
}
