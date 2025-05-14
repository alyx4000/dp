package sdk.pendo.io.g9;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import org.json.JSONArray;
import org.json.JSONException;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.n.c;

/* loaded from: classes6.dex */
public final class j {

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1133a;

        static {
            int[] iArr = new int[c.EnumC0200c.values().length];
            f1133a = iArr;
            try {
                iArr[c.EnumC0200c.INTEGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1133a[c.EnumC0200c.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Boolean a(String str, TextView textView) {
        Typeface b = str != null ? i.b(str) : null;
        if (b == null) {
            return Boolean.FALSE;
        }
        textView.setTypeface(b);
        return Boolean.TRUE;
    }

    public static String a(String str, sdk.pendo.io.n.c cVar, TextView textView) {
        int a2 = a(cVar);
        String a3 = a(str, a2);
        try {
            Typeface font = ResourcesCompat.getFont(PendoInternal.m(), PendoInternal.m().getResources().getIdentifier(a3, "font", PendoInternal.m().getPackageName()));
            if (font != null) {
                textView.setTypeface(font);
                return a3;
            }
        } catch (Resources.NotFoundException unused) {
            PendoLogger.d("Font not in resources", new Object[0]);
        }
        if (a3 == null) {
            return null;
        }
        textView.setTypeface(Typeface.create(a3, a2));
        return a3;
    }

    public static String a(String str, int i) {
        JSONArray jSONArray;
        String str2;
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException unused) {
            jSONArray = null;
        }
        if (str != null) {
            return str;
        }
        if (jSONArray == null) {
            return null;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                str2 = jSONArray.get(i2).toString();
            } catch (JSONException e) {
                PendoLogger.e(e, e.getMessage(), new Object[0]);
                str2 = null;
            }
            if (str2 == null) {
                return null;
            }
            if (Typeface.create(str2, i) != null) {
                return str2;
            }
        }
        return null;
    }

    public static sdk.pendo.io.s0.b a(Context context, int i, int i2, int i3, sdk.pendo.io.s0.a aVar) {
        return a(context, i, i2, aVar).a(i3);
    }

    public static sdk.pendo.io.s0.b a(Context context, int i, int i2, sdk.pendo.io.s0.a aVar) {
        return new sdk.pendo.io.s0.b(context, aVar).b(i2).c(i);
    }

    public static char a(String str) {
        return str.charAt(0);
    }

    public static sdk.pendo.io.s0.a a(char c, sdk.pendo.io.s0.a aVar) {
        sdk.pendo.io.j8.b a2 = sdk.pendo.io.j8.b.a(Character.valueOf(c));
        return a2 != null ? a2 : aVar;
    }

    public static int a(sdk.pendo.io.n.c cVar) {
        if (cVar != null) {
            int i = a.f1133a[cVar.b.ordinal()];
            if (i == 1) {
                return cVar.h();
            }
            if (i == 2) {
                String j = cVar.j();
                if ("bold".equals(j)) {
                    return 1;
                }
                if ("italic".equals(j)) {
                    return 2;
                }
                if ("bold_italic".equals(j)) {
                    return 3;
                }
            }
        }
        return 0;
    }
}
