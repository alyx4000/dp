package sdk.pendo.io.g9;

import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes6.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f1139a = Charset.forName("UTF-8");
    private static final char[] b = "0123456789ABCDEF".toCharArray();

    public interface a<T> {
        boolean test(T t);
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & UByte.MAX_VALUE;
            int i3 = i * 2;
            char[] cArr2 = b;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public static String b(byte[] bArr) {
        return new String(bArr, f1139a);
    }

    public static boolean c(String str) {
        return i(str) != null;
    }

    public static boolean d(String str) {
        try {
            new JSONArray(str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public static boolean e(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public static boolean f(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x00d9, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x00ed, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean g(java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.g9.m0.g(java.lang.String):boolean");
    }

    public static String h(String str) {
        return str == null ? "" : str;
    }

    public static Integer i(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String a(String str) {
        return new String(Base64.decode(str.getBytes(), 0), StandardCharsets.UTF_8);
    }

    public static String b(String str) {
        return Base64.encodeToString(a((CharSequence) str).toString().getBytes(Charset.forName("UTF-8")), 10);
    }

    public static float a(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    public static <T> boolean a(List<T> list, a<T> aVar) {
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (aVar.test(t)) {
                arrayList.add(t);
            }
        }
        return list.removeAll(arrayList);
    }

    public static List<String> a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            arrayList.add(cls.getName());
        }
        return arrayList;
    }

    public static boolean a(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean a(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement.toString().contains("sdk.pendo.io")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static JSONArray a(List<? extends Object> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<? extends Object> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toString());
        }
        return jSONArray;
    }

    public static String a(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                sb.append(entry.getKey()).append(":").append(entry.getValue() != null ? entry.getValue().toString() : "null").append("\n");
            }
        }
        return sb.toString();
    }

    public static String a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append(stackTraceElement.toString()).append("\n");
        }
        return sb.toString();
    }

    public static String a(List<String> list, String str) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return String.join(str, list);
    }

    public static CharSequence a(CharSequence charSequence) {
        return charSequence.length() > 256 ? charSequence.subSequence(0, 256) : charSequence;
    }

    public static String a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            if (m.f1138a.b(str).equals(str2)) {
                return str;
            }
            return null;
        } catch (Exception e) {
            PendoLogger.e(e, "Exception in Utils class at verifyIntegrity()", new Object[0]);
            return null;
        }
    }
}
