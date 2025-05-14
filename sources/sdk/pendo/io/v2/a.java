package sdk.pendo.io.v2;

/* loaded from: classes4.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private short f1667a;
    private short b;
    private short c;
    private boolean d = false;
    private short e;
    private short f;
    private short g;
    private int h;

    a(short s, short s2, short s3) {
        this.f1667a = s;
        this.b = s2;
        this.c = s3;
    }

    int a() {
        return !this.d ? 8 : 16;
    }

    int a(byte[] bArr, int i) {
        int i2;
        int a2 = c.a((int) this.b, bArr, c.a((int) this.f1667a, bArr, c.a((int) this.c, bArr, i)));
        if (this.d) {
            a2 = c.a((int) this.g, bArr, c.a((int) this.f, bArr, c.a((int) this.e, bArr, c.a(1, bArr, a2))));
            i2 = this.h;
        } else {
            i2 = 0;
        }
        return c.a(i2, bArr, a2);
    }
}
