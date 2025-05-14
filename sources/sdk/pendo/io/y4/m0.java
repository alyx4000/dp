package sdk.pendo.io.y4;

/* loaded from: classes4.dex */
public class m0 {
    public static String a(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "UNKNOWN" : "hmac_sha512" : "hmac_sha384" : "hmac_sha256" : "hmac_sha1" : "hmac_md5" : "null";
    }

    public static String b(int i) {
        return a(i) + "(" + i + ")";
    }
}
