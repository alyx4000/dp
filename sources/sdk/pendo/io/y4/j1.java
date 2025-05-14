package sdk.pendo.io.y4;

/* loaded from: classes4.dex */
public class j1 {
    public static int a(i1 i1Var) {
        i1Var.getClass();
        return a(i1Var.a(), i1Var.b());
    }

    public static int a(short s, short s2) {
        return ((s & 255) << 8) | (s2 & 255);
    }

    public static short b(int i) {
        return (short) ((i >>> 8) & 255);
    }

    public static String c(int i) {
        if (i == 513) {
            return "rsa_pkcs1_sha1";
        }
        if (i == 515) {
            return "ecdsa_sha1";
        }
        if (i == 1025) {
            return "rsa_pkcs1_sha256";
        }
        if (i == 1027) {
            return "ecdsa_secp256r1_sha256";
        }
        if (i == 1281) {
            return "rsa_pkcs1_sha384";
        }
        if (i == 1283) {
            return "ecdsa_secp384r1_sha384";
        }
        if (i == 1537) {
            return "rsa_pkcs1_sha512";
        }
        if (i == 1539) {
            return "ecdsa_secp521r1_sha512";
        }
        if (i == 1800) {
            return "sm2sig_sm3";
        }
        switch (i) {
            case 2052:
                return "rsa_pss_rsae_sha256";
            case 2053:
                return "rsa_pss_rsae_sha384";
            case 2054:
                return "rsa_pss_rsae_sha512";
            case 2055:
                return "ed25519";
            case 2056:
                return "ed448";
            case 2057:
                return "rsa_pss_pss_sha256";
            case 2058:
                return "rsa_pss_pss_sha384";
            case 2059:
                return "rsa_pss_pss_sha512";
            default:
                switch (i) {
                    case 2074:
                        return "ecdsa_brainpoolP256r1tls13_sha256";
                    case 2075:
                        return "ecdsa_brainpoolP384r1tls13_sha384";
                    case 2076:
                        return "ecdsa_brainpoolP512r1tls13_sha512";
                    default:
                        return "UNKNOWN";
                }
        }
    }

    public static int d(int i) {
        if (i == 1027) {
            return 23;
        }
        if (i == 1283) {
            return 24;
        }
        if (i == 1539) {
            return 25;
        }
        if (i == 1800) {
            return 41;
        }
        switch (i) {
            case 2074:
                return 31;
            case 2075:
                return 32;
            case 2076:
                return 33;
            default:
                return -1;
        }
    }

    public static short e(int i) {
        return (short) (i & 255);
    }

    public static i1 f(int i) {
        return i1.b(b(i), e(i));
    }

    public static boolean g(int i) {
        switch (i) {
            case 2074:
            case 2075:
            case 2076:
                break;
            default:
                if (3 == e(i)) {
                }
                break;
        }
        return true;
    }

    public static boolean h(int i) {
        switch (i) {
            case 2052:
            case 2053:
            case 2054:
            case 2057:
            case 2058:
            case 2059:
                return true;
            case 2055:
            case 2056:
            default:
                return false;
        }
    }

    public static int a(int i) {
        if (i == 1800) {
            return 7;
        }
        switch (i) {
            case 2052:
            case 2057:
                return 4;
            case 2053:
            case 2058:
                return 5;
            case 2054:
            case 2059:
                return 6;
            case 2055:
            case 2056:
                return -1;
            default:
                switch (i) {
                    case 2074:
                        return 4;
                    case 2075:
                        return 5;
                    case 2076:
                        return 6;
                    default:
                        short b = b(i);
                        if (8 == b || !i0.d(b)) {
                            return -1;
                        }
                        return sdk.pendo.io.z4.k.a(b);
                }
        }
    }
}
