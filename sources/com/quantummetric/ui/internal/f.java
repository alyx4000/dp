package com.quantummetric.ui.internal;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.quantummetric.ui.QuantumMetric;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
final class f extends dg {
    static List<String> A;

    f(View view) {
        super(view);
        if (A == null) {
            A = new ArrayList();
        }
        String a2 = a("alertTitle", view);
        String a3 = a("message", view);
        if (de.b(a2) && de.b(a3)) {
            return;
        }
        String str = a2 + "\n" + a3;
        if (de.a(str, A)) {
            return;
        }
        QuantumMetric.a(-23, str, new j[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038 A[Catch: Exception -> 0x0042, TRY_LEAVE, TryCatch #0 {Exception -> 0x0042, blocks: (B:3:0x0002, B:5:0x000a, B:7:0x0013, B:9:0x0029, B:11:0x002f, B:15:0x0038), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.lang.String r3, android.view.View r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            android.view.View r3 = r2.b(r3, r4)     // Catch: java.lang.Exception -> L42
            boolean r4 = r3 instanceof android.widget.TextView     // Catch: java.lang.Exception -> L42
            if (r4 == 0) goto L42
            r4 = r3
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch: java.lang.Exception -> L42
            java.lang.CharSequence r4 = r4.getText()     // Catch: java.lang.Exception -> L42
            if (r4 == 0) goto L42
            java.util.concurrent.ConcurrentHashMap r4 = com.quantummetric.ui.internal.df.a()     // Catch: java.lang.Exception -> L42
            int r1 = r3.hashCode()     // Catch: java.lang.Exception -> L42
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> L42
            java.lang.Object r4 = r4.get(r1)     // Catch: java.lang.Exception -> L42
            com.quantummetric.instrument.internal.da r4 = (com.quantummetric.ui.internal.da) r4     // Catch: java.lang.Exception -> L42
            boolean r1 = r4 instanceof com.quantummetric.ui.internal.cz     // Catch: java.lang.Exception -> L42
            if (r1 == 0) goto L35
            com.quantummetric.instrument.internal.cz r4 = (com.quantummetric.ui.internal.cz) r4     // Catch: java.lang.Exception -> L42
            boolean r1 = r4.o     // Catch: java.lang.Exception -> L42
            if (r1 != 0) goto L33
            boolean r4 = r4.p     // Catch: java.lang.Exception -> L42
            if (r4 == 0) goto L35
        L33:
            r4 = 1
            goto L36
        L35:
            r4 = 0
        L36:
            if (r4 != 0) goto L42
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch: java.lang.Exception -> L42
            java.lang.CharSequence r3 = r3.getText()     // Catch: java.lang.Exception -> L42
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Exception -> L42
        L42:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.f.a(java.lang.String, android.view.View):java.lang.String");
    }

    private View b(String str, View view) {
        View view2 = null;
        if (!(view instanceof ViewGroup)) {
            if (!(view instanceof TextView) || ((TextView) view).getText() == null || !de.a(view).equals(str)) {
                break;
            }
            return view;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount() || (view2 = b(str, viewGroup.getChildAt(i))) != null) {
                break;
            }
            i++;
        }
        return view2;
    }
}
