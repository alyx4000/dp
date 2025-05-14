package sdk.pendo.io.y4;

/* loaded from: classes4.dex */
public class h1 {
    public static short a(short s) {
        if (s == 64) {
            return (short) 67;
        }
        if (s == 65) {
            return (short) 68;
        }
        switch (s) {
            case 1:
            case 4:
            case 5:
            case 6:
            case 9:
            case 10:
            case 11:
                return (short) 1;
            case 2:
                return (short) 2;
            case 3:
            case 7:
            case 8:
                return (short) 64;
            default:
                return (short) -1;
        }
    }

    public static String b(short s) {
        if (s == 64) {
            return "gostr34102012_256";
        }
        if (s == 65) {
            return "gostr34102012_512";
        }
        switch (s) {
            case 0:
                return "anonymous";
            case 1:
                return "rsa";
            case 2:
                return "dsa";
            case 3:
                return "ecdsa";
            case 4:
                return "rsa_pss_rsae_sha256";
            case 5:
                return "rsa_pss_rsae_sha384";
            case 6:
                return "rsa_pss_rsae_sha512";
            case 7:
                return "ed25519";
            case 8:
                return "ed448";
            case 9:
                return "rsa_pss_pss_sha256";
            case 10:
                return "rsa_pss_pss_sha384";
            case 11:
                return "rsa_pss_pss_sha512";
            default:
                switch (s) {
                    case 26:
                        return "ecdsa_brainpoolP256r1tls13_sha256";
                    case 27:
                        return "ecdsa_brainpoolP384r1tls13_sha384";
                    case 28:
                        return "ecdsa_brainpoolP512r1tls13_sha512";
                    default:
                        return "UNKNOWN";
                }
        }
    }

    public static String c(short s) {
        return b(s) + "(" + ((int) s) + ")";
    }
}
