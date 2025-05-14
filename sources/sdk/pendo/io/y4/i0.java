package sdk.pendo.io.y4;

/* loaded from: classes4.dex */
public class i0 {
    public static String a(short s) {
        switch (s) {
            case 0:
                return "none";
            case 1:
                return "md5";
            case 2:
                return "sha1";
            case 3:
                return "sha224";
            case 4:
                return "sha256";
            case 5:
                return "sha384";
            case 6:
                return "sha512";
            case 7:
            default:
                return "UNKNOWN";
            case 8:
                return "Intrinsic";
        }
    }

    public static int b(short s) {
        switch (s) {
            case 1:
                return 16;
            case 2:
                return 20;
            case 3:
                return 28;
            case 4:
                return 32;
            case 5:
                return 48;
            case 6:
                return 64;
            default:
                return -1;
        }
    }

    public static String c(short s) {
        return a(s) + "(" + ((int) s) + ")";
    }

    public static boolean d(short s) {
        switch (s) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
                return true;
            case 7:
            default:
                return false;
        }
    }
}
