package sdk.pendo.io.y4;

/* loaded from: classes4.dex */
public class t0 {
    public static String a(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 7 ? "UNKNOWN" : "tls13_hkdf_sm3" : "tls13_hkdf_sha384" : "tls13_hkdf_sha256" : "tls_prf_sha384" : "tls_prf_sha256" : "tls_prf_legacy" : "ssl_prf_legacy";
    }

    public static String b(int i) {
        return a(i) + "(" + i + ")";
    }
}
