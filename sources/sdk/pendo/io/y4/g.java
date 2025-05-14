package sdk.pendo.io.y4;

/* loaded from: classes4.dex */
public class g {
    public static String a(short s) {
        if (s == 0) {
            return "close_notify";
        }
        if (s == 10) {
            return "unexpected_message";
        }
        if (s == 30) {
            return "decompression_failure";
        }
        if (s == 60) {
            return "export_restriction";
        }
        if (s == 80) {
            return "internal_error";
        }
        if (s == 86) {
            return "inappropriate_fallback";
        }
        if (s == 90) {
            return "user_canceled";
        }
        if (s == 100) {
            return "no_renegotiation";
        }
        if (s == 120) {
            return "no_application_protocol";
        }
        if (s == 70) {
            return "protocol_version";
        }
        if (s == 71) {
            return "insufficient_security";
        }
        switch (s) {
            case 20:
                return "bad_record_mac";
            case 21:
                return "decryption_failed";
            case 22:
                return "record_overflow";
            default:
                switch (s) {
                    case 40:
                        return "handshake_failure";
                    case 41:
                        return "no_certificate";
                    case 42:
                        return "bad_certificate";
                    case 43:
                        return "unsupported_certificate";
                    case 44:
                        return "certificate_revoked";
                    case 45:
                        return "certificate_expired";
                    case 46:
                        return "certificate_unknown";
                    case 47:
                        return "illegal_parameter";
                    case 48:
                        return "unknown_ca";
                    case 49:
                        return "access_denied";
                    case 50:
                        return "decode_error";
                    case 51:
                        return "decrypt_error";
                    default:
                        switch (s) {
                            case 109:
                                return "missing_extension";
                            case 110:
                                return "unsupported_extension";
                            case 111:
                                return "certificate_unobtainable";
                            case 112:
                                return "unrecognized_name";
                            case 113:
                                return "bad_certificate_status_response";
                            case 114:
                                return "bad_certificate_hash_value";
                            case 115:
                                return "unknown_psk_identity";
                            case 116:
                                return "certificate_required";
                            default:
                                return "UNKNOWN";
                        }
                }
        }
    }

    public static String b(short s) {
        return a(s) + "(" + ((int) s) + ")";
    }
}
