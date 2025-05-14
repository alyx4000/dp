package com.quantummetric.ui.internal;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* loaded from: classes5.dex */
final class be implements ComponentCallbacks2 {
    be() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0074 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0056  */
    @Override // android.content.ComponentCallbacks2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onTrimMemory(int r7) {
        /*
            r6 = this;
            com.quantummetric.instrument.internal.bu r0 = com.quantummetric.ui.QuantumMetric.b
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L8
            r0 = r2
            goto L9
        L8:
            r0 = r1
        L9:
            if (r0 != 0) goto L7b
            com.quantummetric.instrument.internal.y r0 = com.quantummetric.ui.QuantumMetric.f9a
            if (r0 == 0) goto L7b
            com.quantummetric.instrument.internal.y r0 = com.quantummetric.ui.QuantumMetric.f9a     // Catch: java.lang.Exception -> L26
            java.lang.String r3 = "memory_management"
            org.json.JSONObject r0 = r0.optJSONObject(r3)     // Catch: java.lang.Exception -> L26
            if (r0 == 0) goto L26
            java.lang.String r3 = "ignore_memory_warnings"
            boolean r3 = r0.optBoolean(r3)     // Catch: java.lang.Exception -> L26
            java.lang.String r4 = "ignore_background_warnings"
            boolean r0 = r0.optBoolean(r4, r2)     // Catch: java.lang.Exception -> L27
            goto L28
        L26:
            r3 = r1
        L27:
            r0 = r2
        L28:
            r4 = 5
            if (r7 == r4) goto L56
            r4 = 10
            if (r7 == r4) goto L52
            r4 = 15
            if (r7 == r4) goto L4e
            r4 = 60
            r5 = 0
            if (r7 == r4) goto L48
            r4 = 80
            if (r7 == r4) goto L3d
            goto L4c
        L3d:
            if (r3 != 0) goto L42
            if (r0 != 0) goto L42
            goto L43
        L42:
            r2 = r1
        L43:
            if (r0 != 0) goto L59
            java.lang.String r5 = "Background - Critical"
            goto L59
        L48:
            if (r0 != 0) goto L4c
            java.lang.String r5 = "Background - Moderate"
        L4c:
            r2 = r1
            goto L59
        L4e:
            r2 = r2 ^ r3
            java.lang.String r5 = "Non-Expendable - Critical"
            goto L59
        L52:
            r2 = r2 ^ r3
            java.lang.String r5 = "Non-Expendable - Low"
            goto L59
        L56:
            java.lang.String r5 = "Non-Expendable - Moderate"
            goto L4c
        L59:
            boolean r7 = com.quantummetric.ui.internal.de.b(r5)
            if (r7 != 0) goto L70
            java.lang.String r7 = "Trim Memory Request Received: "
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r7 = r7.concat(r0)
            com.quantummetric.instrument.internal.j[] r0 = new com.quantummetric.ui.internal.j[r1]
            r1 = -34
            com.quantummetric.ui.QuantumMetric.a(r1, r7, r0)
        L70:
            boolean r7 = com.quantummetric.ui.internal.cd.f161a
            if (r7 != 0) goto L7b
            if (r2 == 0) goto L7b
            java.lang.String r7 = "Trim memory request received. Stopping Quantum Metric SDK"
            com.quantummetric.ui.QuantumMetric.a(r7)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.be.onTrimMemory(int):void");
    }
}
