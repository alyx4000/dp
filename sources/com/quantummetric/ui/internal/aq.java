package com.quantummetric.ui.internal;

import com.quantummetric.ui.QuantumMetric;
import com.quantummetric.ui.internal.as;
import java.util.Timer;
import org.json.JSONObject;

/* loaded from: classes5.dex */
final class aq {

    /* renamed from: a, reason: collision with root package name */
    static aq f62a;
    boolean b;
    Timer d;
    int c = 10;
    final o<as.a> e = new o<as.a>() { // from class: com.quantummetric.instrument.internal.aq.1
        @Override // com.quantummetric.ui.internal.o
        public final /* synthetic */ void a(as.a aVar) {
            boolean z;
            bu k;
            as.a aVar2 = aVar;
            if (aVar2 != null) {
                try {
                    if (de.b(aVar2.b)) {
                        return;
                    }
                    if (!cd.f161a && QuantumMetric.b != null) {
                        z = false;
                        if (!z || QuantumMetric.f9a == null) {
                        }
                        if (QuantumMetric.f9a.toString().equals(new JSONObject(aVar2.b).toString()) || (k = de.k()) == null) {
                            return;
                        }
                        k.a(true);
                        return;
                    }
                    z = true;
                    if (z) {
                    }
                } catch (Exception unused) {
                }
            }
        }
    };

    aq() {
    }
}
