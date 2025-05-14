package com.quantummetric.ui.internal;

/* loaded from: classes5.dex */
final class aa {
    static boolean A = false;
    static boolean B = false;
    static boolean C = false;
    static boolean D = false;
    static boolean E = false;
    static int F = 0;
    static int G = 0;
    static String H = "multiple";
    static String I = "once";
    static String J = "unique";
    static String K = "trigger";
    static String L = "get_value";
    static String M = "--bc";
    static String N = "color";
    static String O = "font-size";
    static String P = "--fs";
    static String Q = "font-weight";
    static String R = "bold";
    static String S = "font-style";
    static String T = "italic";
    static String U = "text-decoration";
    static String V = "line-through";
    static String W = "underline";
    static String X = "padding-right";
    static String Y = "padding-top";
    static String Z = "padding-left";

    /* renamed from: a, reason: collision with root package name */
    static String f21a = "QTM_SID";
    static String aa = "padding-bottom";
    static String ab = "hidden";
    static String ac = "--h";
    static String ad = "--w";
    static String ae = "height";
    static String af = "width";
    static String ag = "left";
    static String ah = "top";
    static String ai = "--br";
    static String aj = "--d";
    static String ak = "--z";
    static String al = "z-index";
    static String b = "QTM_UID";
    static boolean c = false;
    static boolean d = false;
    static String e = null;
    static String f = "px";
    static String g = "*****";
    static String h = "";
    static boolean i = true;
    static boolean j = false;
    static boolean k = false;
    static boolean l = false;
    static boolean m = false;
    static boolean n = false;
    static boolean o = true;
    static int p = 0;
    static int q = 0;
    static int r = 1291845632;
    static boolean s = false;
    static boolean t = false;
    static boolean u = true;
    static boolean v = true;
    static boolean w = true;
    static boolean x = true;
    static boolean y = false;
    static boolean z = true;

    static String a(String str) {
        return String.format("i.QMRLImageHashCache-%1$s", str);
    }

    static String a(String str, boolean z2) {
        String str2 = h;
        if (!de.b(str2)) {
            return str2;
        }
        if (z2) {
            str = str + "-test";
        }
        return String.format("https://cdn.quantummetric.com/qmobilescripts/android/%1$s.json", str);
    }

    static String b(String str) {
        return String.format("i.QMException-%1$s", str);
    }

    static String c(String str) {
        return String.format("i.QMFontHashCache-%1$s", str);
    }

    static String d(String str) {
        return str + "-testdata";
    }

    static String e(String str) {
        return "QMUser-".concat(String.valueOf(str));
    }

    static String f(String str) {
        return String.format("i.QMConfig-%1$s", str);
    }
}
