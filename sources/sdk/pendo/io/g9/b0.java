package sdk.pendo.io.g9;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;
import sdk.pendo.io.PendoInternal;

/* loaded from: classes6.dex */
public class b0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f1123a = new Object();

    public static void a(String str, String str2) {
        synchronized (f1123a) {
            if (str2 != null) {
                SharedPreferences a2 = a(str);
                if (a2 != null) {
                    a2.edit().remove(str2).apply();
                }
            }
        }
    }

    public static Set<String> b(String str, String str2) {
        synchronized (f1123a) {
            SharedPreferences a2 = a(str);
            if (a2 == null) {
                return null;
            }
            return a2.getStringSet(str2, null);
        }
    }

    public static SharedPreferences a(String str) {
        Context m = PendoInternal.m();
        synchronized (f1123a) {
            try {
                if (m == null) {
                    return null;
                }
                return m.getSharedPreferences(str, 0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(String str, String str2, int i) {
        synchronized (f1123a) {
            SharedPreferences a2 = a(str);
            if (a2 != null) {
                a2.edit().putInt(str2, i).commit();
            }
        }
    }

    public static void a(String str, String str2, String str3, boolean z) {
        synchronized (f1123a) {
            SharedPreferences a2 = a(str);
            if (a2 != null && (z || !a2.contains(str2))) {
                a2.edit().putString(str2, str3).commit();
            }
        }
    }

    public static void a(String str, String str2, Set<String> set, boolean z) {
        synchronized (f1123a) {
            SharedPreferences a2 = a(str);
            if (a2 != null && (z || !a2.contains(str2))) {
                a2.edit().putStringSet(str2, set).apply();
            }
        }
    }
}
