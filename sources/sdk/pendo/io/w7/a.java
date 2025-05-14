package sdk.pendo.io.w7;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static char[] f1740a;
    private static int b;
    private static int c;
    private static String d;
    private static Map<Character, Integer> e;

    static {
        char[] charArray = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_".toCharArray();
        f1740a = charArray;
        b = charArray.length;
        c = 0;
        e = new HashMap(b);
        for (int i = 0; i < b; i++) {
            e.put(Character.valueOf(f1740a[i]), Integer.valueOf(i));
        }
    }

    public static String a(long j) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.insert(0, f1740a[(int) (j % b)]);
            j /= b;
        } while (j > 0);
        return sb.toString();
    }

    public static String a() {
        String a2 = a(new Date().getTime());
        if (!a2.equals(d)) {
            c = 0;
            d = a2;
            return a2;
        }
        StringBuilder append = new StringBuilder().append(a2).append(".");
        int i = c;
        c = i + 1;
        return append.append(a(i)).toString();
    }
}
