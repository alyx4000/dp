package com.iterable.iterableapi;

import android.util.Log;

/* loaded from: classes5.dex */
public class IterableLogger {
    public static void d(String str, String str2) {
        if (isLoggableLevel(3)) {
            Log.d(str, " 💚 " + str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (isLoggableLevel(3)) {
            Log.d(str, " 💚 " + str2, th);
        }
    }

    public static void v(String str, String str2) {
        if (isLoggableLevel(2)) {
            Log.v(str, " 💛 " + str2);
        }
    }

    public static void w(String str, String str2) {
        if (isLoggableLevel(5)) {
            Log.w(str, " 🧡️ " + str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (isLoggableLevel(5)) {
            Log.w(str, " 🧡 " + str2, th);
        }
    }

    public static void e(String str, String str2) {
        if (isLoggableLevel(6)) {
            Log.e(str, " ❤️ " + str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (isLoggableLevel(6)) {
            Log.e(str, " ❤️ " + str2, th);
        }
    }

    public static void printInfo() {
        try {
            v("Iterable Call", Thread.currentThread().getStackTrace()[3].getFileName() + " => " + Thread.currentThread().getStackTrace()[3].getClassName() + " => " + Thread.currentThread().getStackTrace()[3].getMethodName() + " => Line #" + Thread.currentThread().getStackTrace()[3].getLineNumber());
        } catch (Exception unused) {
            e("Iterable Call", "Couldn't print info");
        }
    }

    private static boolean isLoggableLevel(int i) {
        return i >= getLogLevel();
    }

    private static int getLogLevel() {
        if (IterableApi.sharedInstance == null) {
            return 6;
        }
        if (IterableApi.sharedInstance.getDebugMode()) {
            return 2;
        }
        return IterableApi.sharedInstance.config.logLevel;
    }
}
