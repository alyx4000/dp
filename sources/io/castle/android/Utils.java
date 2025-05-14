package io.castle.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.castle.android.api.model.CustomEvent;
import io.castle.android.api.model.Event;
import io.castle.android.api.model.ScreenEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class Utils {
    private static SimpleDateFormat formatter;
    private static Gson gson;

    private static String formatDate(Date date) {
        if (formatter == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", new Locale("en", "US", "POSIX"));
            formatter = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }
        return formatter.format(date);
    }

    public static String getTimestamp() {
        return formatDate(new Date());
    }

    public static Gson getGsonInstance() {
        if (gson == null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            EventAdapter eventAdapter = new EventAdapter();
            gsonBuilder.registerTypeAdapter(Event.class, eventAdapter);
            gsonBuilder.registerTypeAdapter(CustomEvent.class, eventAdapter);
            gsonBuilder.registerTypeAdapter(ScreenEvent.class, eventAdapter);
            gson = gsonBuilder.create();
        }
        return gson;
    }

    private static PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            throw new AssertionError("Package not found: " + context.getPackageName());
        }
    }

    private static ApplicationInfo getApplicationInfo(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            throw new AssertionError("Package not found: " + context.getPackageName());
        }
    }

    static String getApplicationName(Context context) {
        return (String) context.getPackageManager().getApplicationLabel(getApplicationInfo(context));
    }

    static String getApplicationVersion(Context context) {
        return getPackageInfo(context).versionName;
    }

    static int getApplicationVersionCode(Context context) {
        return getPackageInfo(context).versionCode;
    }

    static String sanitizeHeader(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\t' || (charAt > 31 && charAt < 127)) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    static boolean isWellformedJwtToken(String str) {
        return (str == null || str.isEmpty() || !str.contains("")) ? false : true;
    }
}
