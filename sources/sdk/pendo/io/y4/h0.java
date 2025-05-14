package sdk.pendo.io.y4;

/* loaded from: classes4.dex */
public class h0 {
    public static String a(short s) {
        if (s == 8) {
            return "encrypted_extensions";
        }
        if (s == 254) {
            return "message_hash";
        }
        switch (s) {
            case 0:
                return "hello_request";
            case 1:
                return "client_hello";
            case 2:
                return "server_hello";
            case 3:
                return "hello_verify_request";
            case 4:
                return "new_session_ticket";
            case 5:
                return "end_of_early_data";
            case 6:
                return "hello_retry_request";
            default:
                switch (s) {
                    case 11:
                        return "certificate";
                    case 12:
                        return "server_key_exchange";
                    case 13:
                        return "certificate_request";
                    case 14:
                        return "server_hello_done";
                    case 15:
                        return "certificate_verify";
                    case 16:
                        return "client_key_exchange";
                    default:
                        switch (s) {
                            case 20:
                                return "finished";
                            case 21:
                                return "certificate_url";
                            case 22:
                                return "certificate_status";
                            case 23:
                                return "supplemental_data";
                            case 24:
                                return "key_update";
                            case 25:
                                return "compressed_certificate";
                            default:
                                return "UNKNOWN";
                        }
                }
        }
    }

    public static String b(short s) {
        return a(s) + "(" + ((int) s) + ")";
    }

    public static boolean c(short s) {
        if (s == 8 || s == 254) {
            return true;
        }
        switch (s) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            default:
                switch (s) {
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                        return true;
                    default:
                        switch (s) {
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                                return true;
                            default:
                                return false;
                        }
                }
        }
    }
}
