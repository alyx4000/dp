package sdk.pendo.io.g9;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.amplitude.reactnative.AndroidContextProvider;
import sdk.pendo.io.PendoInternal;

/* loaded from: classes6.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f1130a = new Object();
    private static volatile Resources b;

    public static String a(int i) {
        return i != 1 ? i != 2 ? "Undefined" : "Landscape" : "Portrait";
    }

    private static String a(String str) {
        int i;
        int indexOf = str.indexOf("/");
        return (indexOf == -1 || (i = indexOf + 1) >= str.length()) ? str : str.substring(i);
    }

    public static int b(String str) {
        String a2 = a(str);
        if (str.startsWith("android:id")) {
            int identifier = Resources.getSystem().getIdentifier(a2, "id", AndroidContextProvider.OS_NAME);
            if (identifier != 0) {
                return identifier;
            }
            return -1;
        }
        int identifier2 = b().getIdentifier(a2, "id", PendoInternal.m().getPackageName());
        if (identifier2 != 0) {
            return identifier2;
        }
        return -1;
    }

    public static String a(Bitmap bitmap) {
        return q0.a(Bitmap.CompressFormat.JPEG, 10, bitmap);
    }

    public static Resources b() {
        Resources resources = b;
        if (resources == null) {
            synchronized (f1130a) {
                resources = b;
                if (resources == null) {
                    resources = PendoInternal.m().getResources();
                    b = resources;
                }
            }
        }
        return resources;
    }

    public static String a() {
        Context m = PendoInternal.m();
        return (m == null || m.getResources() == null || m.getResources().getConfiguration() == null || m.getResources().getConfiguration().locale == null) ? "" : m.getResources().getConfiguration().locale.toString();
    }

    public static boolean a(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if ((str != null && str2 == null) || (str == null && str2 != null)) {
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        if (a(str).equals(a(str2))) {
            return (str.contains(":id/") && str2.contains(":id/")) ? false : true;
        }
        return false;
    }
}
