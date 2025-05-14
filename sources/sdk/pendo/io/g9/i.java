package sdk.pendo.io.g9;

import android.graphics.Typeface;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import sdk.pendo.io.PendoInternal;

/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final File f1131a = new File("/system/etc/fonts.xml");
    private static final File b = new File("/system/etc/system_fonts.xml");
    private static ArrayList<String> c = new ArrayList<>();
    private static ArrayList<String> d = new ArrayList<>();
    private static ArrayList<String> e = new ArrayList<>();
    private static boolean f = false;

    public static boolean a(String str) {
        try {
            String[] list = PendoInternal.m().getAssets().list("fonts");
            if (list.length <= 0) {
                return true;
            }
            for (String str2 : list) {
                if ((str2.endsWith(".ttf") || str2.endsWith(".otf") || str2.endsWith(".ttc")) && !e.contains(str)) {
                    e.add("fonts/" + str2);
                }
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static Typeface b(String str) {
        String str2;
        if (e.size() == 0 && !f) {
            f = true;
            a("");
        }
        for (int i = 0; i < e.size(); i++) {
            String[] split = e.get(i).split("/");
            String str3 = split[split.length - 1];
            if (str3.equals(str + ".ttf") || str3.equals(str + ".otf") || str3.equals(str + ".ttc")) {
                str2 = e.get(i);
                break;
            }
        }
        str2 = "";
        if (str2.equals("")) {
            return null;
        }
        return Typeface.createFromAsset(PendoInternal.m().getAssets(), str2);
    }
}
