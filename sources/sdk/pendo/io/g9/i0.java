package sdk.pendo.io.g9;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.R;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes6.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f1132a = new Object();
    private static volatile String b;

    public static synchronized Boolean a(Context context, int i) {
        synchronized (i0.class) {
            try {
                try {
                    Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        return Boolean.valueOf(bundle.getBoolean(context.getString(i)));
                    }
                } catch (Exception e) {
                    PendoLogger.e(e, e.getMessage(), new Object[0]);
                }
            } catch (PackageManager.NameNotFoundException e2) {
                PendoLogger.i(e2, e2.getMessage(), new Object[0]);
            }
            return Boolean.FALSE;
        }
    }

    public static boolean b(Context context) {
        return a(context, R.string.pnd_debug_log).booleanValue();
    }

    private static SharedPreferences c() {
        return PendoInternal.m().getSharedPreferences("insert_settings", 0);
    }

    public static String a(Context context) {
        return b(context, R.string.pnd_device_url);
    }

    private static SharedPreferences.Editor b() {
        return c().edit();
    }

    public static boolean c(Context context) {
        return a(context, R.string.pnd_write_backend_response_to_file).booleanValue();
    }

    public static String a(int i) {
        return g0.b().getString(i);
    }

    public static String b(Context context, int i) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                return bundle.getString(context.getString(i));
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            PendoLogger.i(e, e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static String a() {
        String str = b;
        if (str == null) {
            synchronized (f1132a) {
                str = b;
                if (str == null) {
                    str = a(R.string.pnd_sdk_version);
                    b = str;
                }
            }
        }
        return str;
    }

    public static void b(String str, String str2) {
        b().putString(str, str2).apply();
    }

    public static String a(String str, String str2) {
        return c().getString(str, str2);
    }
}
