package sdk.pendo.io.y4;

/* loaded from: classes4.dex */
public class h {
    public static String a(short s) {
        return s != 1 ? s != 2 ? "UNKNOWN" : "fatal" : "warning";
    }

    public static String b(short s) {
        return a(s) + "(" + ((int) s) + ")";
    }
}
