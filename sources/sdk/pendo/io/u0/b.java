package sdk.pendo.io.u0;

import sdk.pendo.io.k1.j;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private sdk.pendo.io.v0.a f1638a = new sdk.pendo.io.v0.a(-1, null, true);

    public static byte[] d(String str) {
        return a().a(str);
    }

    public byte[] a(String str) {
        return this.f1638a.a(str);
    }

    public String b(String str) {
        return a(str, "UTF-8");
    }

    public String c(String str) {
        return b(str, "UTF-8");
    }

    public String a(String str, String str2) {
        return j.a(a(str), str2);
    }

    public String b(String str, String str2) {
        return a(j.a(str, str2));
    }

    public static String b(byte[] bArr) {
        return a().a(bArr);
    }

    public String a(byte[] bArr) {
        return this.f1638a.d(bArr);
    }

    private static b a() {
        return new b();
    }
}
