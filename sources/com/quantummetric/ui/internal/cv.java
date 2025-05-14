package com.quantummetric.ui.internal;

import android.view.View;
import com.quantummetric.ui.QuantumMetric;

/* loaded from: classes5.dex */
final class cv extends da {
    private String o;

    cv(View view) {
        super(view);
        String b = b(view);
        this.o = b;
        if (de.b(b)) {
            return;
        }
        QuantumMetric.a(-35, this.o, new j[0]);
        if (af.f26a == null) {
            af.f26a = new af();
        }
        af.f26a.a(this.o);
    }

    static String b(View view) {
        try {
            return (String) by.a(view, "componentName");
        } catch (Exception unused) {
            return "";
        }
    }
}
