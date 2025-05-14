package sdk.pendo.io.y4;

/* loaded from: classes4.dex */
public class u {
    public static String a(short s) {
        switch (s) {
            case 20:
                return "change_cipher_spec";
            case 21:
                return "alert";
            case 22:
                return "handshake";
            case 23:
                return "application_data";
            case 24:
                return "heartbeat";
            default:
                return "UNKNOWN";
        }
    }

    public static String b(short s) {
        return a(s) + "(" + ((int) s) + ")";
    }
}
