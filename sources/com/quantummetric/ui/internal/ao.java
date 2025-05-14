package com.quantummetric.ui.internal;

import android.app.ActivityManager;
import android.content.Context;
import com.quantummetric.ui.QuantumMetric;
import io.sentry.protocol.SentryThread;
import org.json.JSONObject;

/* loaded from: classes5.dex */
final class ao {

    /* renamed from: a, reason: collision with root package name */
    static ao f58a;
    a b;
    ActivityManager c;
    volatile int d;

    static class a extends Thread {
        private volatile boolean b;
        private boolean c;
        private boolean d;
        private long e;
        private int f;
        private boolean h;
        private boolean i;

        /* renamed from: a, reason: collision with root package name */
        private volatile long f59a = -1;
        private int g = 1;
        private int j = 0;
        private final AnonymousClass1 k = new Runnable() { // from class: com.quantummetric.instrument.internal.ao.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.f59a = System.currentTimeMillis();
            }
        };

        /* JADX WARN: Type inference failed for: r0v2, types: [com.quantummetric.instrument.internal.ao$a$1] */
        a() {
            this.b = false;
            this.f = 3;
            this.h = true;
            this.i = true;
            if (QuantumMetric.f9a == null) {
                this.b = true;
                return;
            }
            JSONObject optJSONObject = QuantumMetric.f9a.optJSONObject("fui");
            if (optJSONObject != null) {
                this.f = optJSONObject.optInt("interval_sec", this.f);
                this.h = optJSONObject.optBoolean("ignore_debugger", this.h);
                this.i = optJSONObject.optBoolean(SentryThread.JsonKeys.MAIN, this.i);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x005c A[Catch: Exception -> 0x012d, TryCatch #0 {Exception -> 0x012d, blocks: (B:3:0x0003, B:5:0x0015, B:7:0x001a, B:9:0x001f, B:14:0x0029, B:16:0x002d, B:18:0x0035, B:20:0x0040, B:22:0x0044, B:25:0x0056, B:27:0x005c, B:29:0x0066, B:30:0x006a, B:32:0x0070, B:35:0x007a, B:38:0x0082, B:40:0x0086, B:42:0x008c, B:45:0x0095, B:48:0x009b, B:51:0x00ab, B:61:0x00b3, B:62:0x00b8, B:63:0x00b6, B:64:0x00be, B:66:0x00c4, B:68:0x00c8, B:70:0x00ce, B:73:0x00d7, B:77:0x00df, B:79:0x00eb, B:80:0x00fb, B:82:0x0106, B:91:0x0124, B:93:0x0129, B:98:0x0127, B:100:0x0053), top: B:2:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00ab A[Catch: Exception -> 0x012d, TryCatch #0 {Exception -> 0x012d, blocks: (B:3:0x0003, B:5:0x0015, B:7:0x001a, B:9:0x001f, B:14:0x0029, B:16:0x002d, B:18:0x0035, B:20:0x0040, B:22:0x0044, B:25:0x0056, B:27:0x005c, B:29:0x0066, B:30:0x006a, B:32:0x0070, B:35:0x007a, B:38:0x0082, B:40:0x0086, B:42:0x008c, B:45:0x0095, B:48:0x009b, B:51:0x00ab, B:61:0x00b3, B:62:0x00b8, B:63:0x00b6, B:64:0x00be, B:66:0x00c4, B:68:0x00c8, B:70:0x00ce, B:73:0x00d7, B:77:0x00df, B:79:0x00eb, B:80:0x00fb, B:82:0x0106, B:91:0x0124, B:93:0x0129, B:98:0x0127, B:100:0x0053), top: B:2:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x00c4 A[Catch: Exception -> 0x012d, TryCatch #0 {Exception -> 0x012d, blocks: (B:3:0x0003, B:5:0x0015, B:7:0x001a, B:9:0x001f, B:14:0x0029, B:16:0x002d, B:18:0x0035, B:20:0x0040, B:22:0x0044, B:25:0x0056, B:27:0x005c, B:29:0x0066, B:30:0x006a, B:32:0x0070, B:35:0x007a, B:38:0x0082, B:40:0x0086, B:42:0x008c, B:45:0x0095, B:48:0x009b, B:51:0x00ab, B:61:0x00b3, B:62:0x00b8, B:63:0x00b6, B:64:0x00be, B:66:0x00c4, B:68:0x00c8, B:70:0x00ce, B:73:0x00d7, B:77:0x00df, B:79:0x00eb, B:80:0x00fb, B:82:0x0106, B:91:0x0124, B:93:0x0129, B:98:0x0127, B:100:0x0053), top: B:2:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0127 A[Catch: Exception -> 0x012d, TryCatch #0 {Exception -> 0x012d, blocks: (B:3:0x0003, B:5:0x0015, B:7:0x001a, B:9:0x001f, B:14:0x0029, B:16:0x002d, B:18:0x0035, B:20:0x0040, B:22:0x0044, B:25:0x0056, B:27:0x005c, B:29:0x0066, B:30:0x006a, B:32:0x0070, B:35:0x007a, B:38:0x0082, B:40:0x0086, B:42:0x008c, B:45:0x0095, B:48:0x009b, B:51:0x00ab, B:61:0x00b3, B:62:0x00b8, B:63:0x00b6, B:64:0x00be, B:66:0x00c4, B:68:0x00c8, B:70:0x00ce, B:73:0x00d7, B:77:0x00df, B:79:0x00eb, B:80:0x00fb, B:82:0x0106, B:91:0x0124, B:93:0x0129, B:98:0x0127, B:100:0x0053), top: B:2:0x0003 }] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 302
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.instrument.internal.ao.a.run():void");
        }
    }

    ao() {
    }

    static ao a() {
        if (f58a == null) {
            f58a = new ao();
            try {
                Context f = de.f();
                if (f != null) {
                    f58a.c = (ActivityManager) f.getSystemService("activity");
                }
            } catch (Exception unused) {
            }
        }
        return f58a;
    }
}
