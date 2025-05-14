package sdk.pendo.io.y4;

import com.facebook.react.uimanager.ViewProps;
import io.sentry.SentryBaseEvent;

/* loaded from: classes4.dex */
public class e0 {
    public static String a(int i) {
        if (i == 27) {
            return "compress_certificate";
        }
        if (i == 28) {
            return "record_size_limit";
        }
        if (i == 35) {
            return "session_ticket";
        }
        if (i == 65281) {
            return "renegotiation_info";
        }
        switch (i) {
            case 0:
                return SentryBaseEvent.JsonKeys.SERVER_NAME;
            case 1:
                return "max_fragment_length";
            case 2:
                return "client_certificate_url";
            case 3:
                return "trusted_ca_keys";
            case 4:
                return "truncated_hmac";
            case 5:
                return "status_request";
            case 6:
                return "user_mapping";
            case 7:
                return "client_authz";
            case 8:
                return "server_authz";
            case 9:
                return "cert_type";
            case 10:
                return "supported_groups";
            case 11:
                return "ec_point_formats";
            case 12:
                return "srp";
            case 13:
                return "signature_algorithms";
            case 14:
                return "use_srtp";
            case 15:
                return "heartbeat";
            case 16:
                return "application_layer_protocol_negotiation";
            case 17:
                return "status_request_v2";
            case 18:
                return "signed_certificate_timestamp";
            case 19:
                return "client_certificate_type";
            case 20:
                return "server_certificate_type";
            case 21:
                return ViewProps.PADDING;
            case 22:
                return "encrypt_then_mac";
            case 23:
                return "extended_master_secret";
            case 24:
                return "token_binding";
            case 25:
                return "cached_info";
            default:
                switch (i) {
                    case 41:
                        return "pre_shared_key";
                    case 42:
                        return "early_data";
                    case 43:
                        return "supported_versions";
                    case 44:
                        return "cookie";
                    case 45:
                        return "psk_key_exchange_modes";
                    default:
                        switch (i) {
                            case 47:
                                return "certificate_authorities";
                            case 48:
                                return "oid_filters";
                            case 49:
                                return "post_handshake_auth";
                            case 50:
                                return "signature_algorithms_cert";
                            case 51:
                                return "key_share";
                            default:
                                return "UNKNOWN";
                        }
                }
        }
    }

    public static String b(int i) {
        return a(i) + "(" + i + ")";
    }

    public static boolean c(int i) {
        if (i == 27 || i == 28 || i == 35 || i == 65281) {
            return true;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                return true;
            default:
                switch (i) {
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                        return true;
                    default:
                        switch (i) {
                            case 47:
                            case 48:
                            case 49:
                            case 50:
                            case 51:
                                return true;
                            default:
                                return false;
                        }
                }
        }
    }
}
