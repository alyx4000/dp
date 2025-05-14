package com.socure.idplus.device.internal.common.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import com.iterable.iterableapi.IterableConstants;
import com.socure.docv.capturesdk.common.utils.Scanner;
import com.socure.idplus.device.error.SigmaDeviceError;
import com.socure.idplus.device.internal.thread.b;
import com.socure.idplus.device.internal.thread.c;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class a {
    public static boolean a(Context context, String value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(value, "value");
        PackageManager packageManager = context.getPackageManager();
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                Intrinsics.checkNotNullExpressionValue(packageManager.getPackageInfo(value, PackageManager.PackageInfoFlags.of(128L)), "getPackageInfo(...)");
            } else if (packageManager.getPackageInfo(value, 0) == null) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            a("Utils", String.valueOf(e.getMessage()));
            return false;
        }
    }

    public static String b(String otherValue) {
        StringBuilder sb;
        Intrinsics.checkNotNullParameter(otherValue, "otherValue");
        if (otherValue.length() > 20) {
            otherValue = otherValue.substring(0, 20);
            Intrinsics.checkNotNullExpressionValue(otherValue, "substring(...)");
            sb = new StringBuilder("other - ");
        } else {
            sb = new StringBuilder("other - ");
        }
        return sb.append(otherValue).toString();
    }

    public static String a(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        return IterableConstants.HEADER_SDK_AUTH_FORMAT + token;
    }

    public static final void b(Context context, b socureThread, int i, Function0 onSuccess, Function2 onError) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(socureThread, "$socureThread");
        Intrinsics.checkNotNullParameter(onSuccess, "$onSuccess");
        Intrinsics.checkNotNullParameter(onError, "$onError");
        a(context, socureThread, i + 1, onSuccess, onError);
    }

    public static boolean a() {
        Intrinsics.checkNotNullParameter("androidx.compose.ui.platform.ViewRootForTest", "className");
        try {
            Class.forName("androidx.compose.ui.platform.ViewRootForTest");
            return true;
        } catch (ClassNotFoundException e) {
            a("Utils", "Class androidx.compose.ui.platform.ViewRootForTest not found with exception: " + e.getMessage());
            return false;
        }
    }

    public static void a(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        try {
            Intrinsics.checkNotNullExpressionValue(DateTimeFormatter.ISO_INSTANT.format(Instant.now()), "format(...)");
        } catch (Throwable th) {
            Log.e(tag, "logSDK timeStamp error: " + th.getMessage());
        }
    }

    public static void a(final Context context, final b bVar, final int i, final Function0 function0, final Function2 function2) {
        NetworkCapabilities networkCapabilities;
        if (i < 3) {
            Object systemService = context.getSystemService("connectivity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null && (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3))) {
                Runnable runnable = new Runnable() { // from class: com.socure.idplus.device.internal.common.utils.a$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.a(Function0.this);
                    }
                };
                c cVar = (c) bVar;
                cVar.getClass();
                Intrinsics.checkNotNullParameter(runnable, "runnable");
                Handler handler = cVar.f615a;
                if (handler != null) {
                    handler.post(runnable);
                    return;
                }
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: com.socure.idplus.device.internal.common.utils.a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    a.b(context, bVar, i, function0, function2);
                }
            };
            long j = i * Scanner.CAMERA_SETUP_DELAY_MS;
            c cVar2 = (c) bVar;
            cVar2.getClass();
            Intrinsics.checkNotNullParameter(runnable2, "runnable");
            Handler handler2 = cVar2.f615a;
            if (handler2 != null) {
                handler2.postDelayed(runnable2, j);
                return;
            }
            return;
        }
        function2.invoke(SigmaDeviceError.NetworkConnectionError, "Network not available");
    }

    public static final void a(Function0 onSuccess) {
        Intrinsics.checkNotNullParameter(onSuccess, "$onSuccess");
        onSuccess.invoke();
    }
}
