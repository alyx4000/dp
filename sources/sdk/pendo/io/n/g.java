package sdk.pendo.io.n;

import android.graphics.Color;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import sdk.pendo.io.n.c;

/* loaded from: classes6.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static String f1410a = "paddingLeft";
    private static String b = "paddingRight";
    private static String c = "paddingTop";
    private static String d = "paddingBottom";
    private static String e = "0x";
    private static String f = "#";
    private static int g = 9;
    private static Map<String, c.b> h = new a();

    class a extends HashMap<String, c.b> {
        a() {
            put(g.f1410a, c.b.PADDING_LEFT);
            put(g.b, c.b.PADDING_RIGHT);
            put(g.c, c.b.PADDING_TOP);
            put(g.d, c.b.PADDING_BOTTOM);
        }
    }

    private static String a(String str) {
        if (!str.startsWith(f)) {
            return str;
        }
        return (f + str.substring(7)) + str.substring(1, 7);
    }

    public static int b(String str) {
        if (str.startsWith(e)) {
            return (int) Long.parseLong(str.substring(2), 16);
        }
        if (str.length() == g) {
            str = a(str);
        }
        return Color.parseColor(str);
    }

    public static c.b c(String str) {
        c.b bVar = h.get(str);
        return bVar == null ? c.b.valueOf(str.toUpperCase(Locale.US).trim()) : bVar;
    }

    public static c.EnumC0200c d(String str) {
        return c.EnumC0200c.valueOf(str.toUpperCase(Locale.US).trim());
    }
}
