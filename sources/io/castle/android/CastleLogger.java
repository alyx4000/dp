package io.castle.android;

import android.util.Log;

/* loaded from: classes2.dex */
public class CastleLogger {
    private static final String TAG = "Castle";

    public static void e(String str) {
        Log.e(TAG, str);
    }

    public static void e(String str, Throwable th) {
        Log.e(TAG, str, th);
    }

    public static void w(String str) {
        Log.e(TAG, str);
    }

    public static void d(String str) {
        if (Castle.configuration().debugLoggingEnabled()) {
            Log.d(TAG, str);
        }
    }

    public static void i(String str) {
        Log.i(TAG, str);
    }
}
