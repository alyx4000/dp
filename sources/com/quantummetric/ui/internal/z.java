package com.quantummetric.ui.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import com.quantummetric.ui.QuantumMetric;

/* loaded from: classes5.dex */
final class z {

    /* renamed from: a, reason: collision with root package name */
    ConnectivityManager f285a;
    AnonymousClass1 b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.net.ConnectivityManager$NetworkCallback, com.quantummetric.instrument.internal.z$1] */
    z() {
        Context f = de.f();
        if (f == null || !de.a(f, "android.permission.ACCESS_NETWORK_STATE")) {
            QuantumMetric.a(-53, "UNKNOWN", new j[0]);
            return;
        }
        this.f285a = (ConnectivityManager) f.getSystemService("connectivity");
        ?? r0 = new ConnectivityManager.NetworkCallback() { // from class: com.quantummetric.instrument.internal.z.1
            /* JADX WARN: Removed duplicated region for block: B:14:0x0021 A[Catch: Exception -> 0x0055, TryCatch #0 {Exception -> 0x0055, blocks: (B:3:0x0005, B:5:0x000b, B:7:0x0011, B:9:0x0017, B:14:0x0021, B:16:0x0031, B:18:0x0037, B:20:0x003d, B:23:0x0046, B:26:0x004e), top: B:2:0x0005 }] */
            /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
            @Override // android.net.ConnectivityManager.NetworkCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void onAvailable(android.net.Network r6) {
                /*
                    r5 = this;
                    java.lang.String r0 = "android.permission.ACCESS_NETWORK_STATE"
                    super.onAvailable(r6)
                    android.content.Context r6 = com.quantummetric.ui.internal.de.f()     // Catch: java.lang.Exception -> L55
                    if (r6 == 0) goto L55
                    boolean r1 = com.quantummetric.ui.internal.de.a(r6, r0)     // Catch: java.lang.Exception -> L55
                    if (r1 == 0) goto L55
                    boolean r1 = com.quantummetric.ui.internal.cd.f161a     // Catch: java.lang.Exception -> L55
                    r2 = 1
                    r3 = 0
                    if (r1 != 0) goto L1e
                    com.quantummetric.instrument.internal.bu r1 = com.quantummetric.ui.QuantumMetric.b     // Catch: java.lang.Exception -> L55
                    if (r1 != 0) goto L1c
                    goto L1e
                L1c:
                    r1 = r3
                    goto L1f
                L1e:
                    r1 = r2
                L1f:
                    if (r1 != 0) goto L55
                    java.lang.String r1 = "UNKNOWN"
                    java.lang.String r4 = "connectivity"
                    java.lang.Object r4 = r6.getSystemService(r4)     // Catch: java.lang.Exception -> L55
                    android.net.ConnectivityManager r4 = (android.net.ConnectivityManager) r4     // Catch: java.lang.Exception -> L55
                    boolean r6 = com.quantummetric.ui.internal.de.a(r6, r0)     // Catch: java.lang.Exception -> L55
                    if (r6 == 0) goto L4e
                    android.net.Network r6 = r4.getActiveNetwork()     // Catch: java.lang.Exception -> L55
                    if (r6 == 0) goto L4e
                    android.net.NetworkCapabilities r6 = r4.getNetworkCapabilities(r6)     // Catch: java.lang.Exception -> L55
                    if (r6 == 0) goto L4e
                    boolean r0 = r6.hasTransport(r2)     // Catch: java.lang.Exception -> L55
                    if (r0 == 0) goto L46
                    java.lang.String r1 = "WIFI"
                    goto L4e
                L46:
                    boolean r6 = r6.hasTransport(r3)     // Catch: java.lang.Exception -> L55
                    if (r6 == 0) goto L4e
                    java.lang.String r1 = "MOBILE"
                L4e:
                    com.quantummetric.instrument.internal.j[] r6 = new com.quantummetric.ui.internal.j[r3]     // Catch: java.lang.Exception -> L55
                    r0 = -53
                    com.quantummetric.ui.QuantumMetric.a(r0, r1, r6)     // Catch: java.lang.Exception -> L55
                L55:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.z.AnonymousClass1.onAvailable(android.net.Network):void");
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                super.onLost(network);
            }
        };
        this.b = r0;
        this.f285a.registerDefaultNetworkCallback(r0);
    }
}
