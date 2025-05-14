package sdk.pendo.io.c1;

import sdk.pendo.io.k1.j;

/* loaded from: classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private sdk.pendo.io.u0.b f943a = new sdk.pendo.io.u0.b();
    private c b;

    public d(String str) {
        this.b = b.a(str);
    }

    byte[] a(String str) {
        return a(this.f943a.a(str));
    }

    public byte[] a(byte[] bArr, int i, String str, String str2, String str3) {
        return this.b.a(bArr, i, sdk.pendo.io.k1.a.a(a(j.b(str)), a(str2), a(str3), sdk.pendo.io.k1.a.c(i), sdk.pendo.io.k1.a.f1251a));
    }

    byte[] a(byte[] bArr) {
        if (bArr == null) {
            bArr = sdk.pendo.io.k1.a.f1251a;
        }
        return sdk.pendo.io.k1.a.a(sdk.pendo.io.k1.a.c(bArr.length), bArr);
    }
}
