package sdk.pendo.io.v2;

/* loaded from: classes4.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private String f1668a;
    private String b;
    private short c;
    private short d;
    private short e;
    private byte[] f;

    b(String str, short s, String str2, short s2, short s3) {
        this.f1668a = str;
        this.c = s;
        this.b = str2;
        this.d = s2;
        this.e = s3;
    }

    short a() {
        return this.e;
    }

    String b() {
        return this.f1668a;
    }

    String c() {
        return this.b;
    }

    int d() {
        return this.f.length + 8;
    }

    void a(byte[] bArr) {
        this.f = bArr;
    }

    int a(byte[] bArr, int i) {
        int a2 = c.a(1, bArr, c.a((int) this.d, bArr, c.a((int) this.c, bArr, c.a((int) this.e, bArr, i))));
        byte[] bArr2 = this.f;
        System.arraycopy(bArr2, 0, bArr, a2, bArr2.length);
        return a2 + this.f.length;
    }
}
