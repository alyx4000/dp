package sdk.pendo.io.i0;

import android.os.SystemClock;

/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final double f1174a = 1.0d / Math.pow(10.0d, 6.0d);

    public static double a(long j) {
        return (a() - j) * f1174a;
    }

    public static long a() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
