package com.quantummetric.ui.internal;

import android.util.Log;
import com.quantummetric.ui.QuantumMetric;
import com.quantummetric.ui.internal.ak;

/* loaded from: classes5.dex */
public final class cd {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f161a;

    public static void a(boolean z) {
        b(z);
        boolean z2 = z && !f161a;
        boolean z3 = ((QuantumMetric.b == null) || z || !f161a) ? false : true;
        f161a = z;
        if (z2) {
            ak.a().a(ak.a.SDK_PAUSE);
        } else if (z3) {
            ak.a().a(ak.a.SDK_RESUME);
        }
    }

    private static void b(boolean z) {
        String str = z ? "pause" : "resume";
        if (QuantumMetric.b == null) {
            Log.e("QM Native SDK", "QM is not initialized, cannot call ".concat(str));
        } else if (f161a == z) {
            Log.e("QM Native SDK", "QM is already " + str + "d, no need to call " + str);
        }
    }
}
