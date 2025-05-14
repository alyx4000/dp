package sdk.pendo.io.b5;

import org.tensorflow.lite.schema.BuiltinOptions;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
class f implements sdk.pendo.io.z4.s {
    private static final byte[] f = a(BuiltinOptions.NotEqualOptions, 48);
    private static final byte[] g = a(BuiltinOptions.IfOptions, 48);

    /* renamed from: a, reason: collision with root package name */
    private sdk.pendo.io.z4.t f904a;
    private final int b;
    private final int c;
    private int d;
    private byte[] e;

    f(sdk.pendo.io.z4.t tVar, int i, int i2) {
        this.f904a = tVar;
        this.b = i;
        this.c = i2;
        this.d = i == 20 ? 40 : 48;
    }

    private static byte[] a(byte b, int i) {
        byte[] bArr = new byte[i];
        sdk.pendo.io.d5.a.a(bArr, b);
        return bArr;
    }

    @Override // sdk.pendo.io.z4.v
    public byte[] b() {
        byte[] c = this.f904a.c();
        sdk.pendo.io.z4.t tVar = this.f904a;
        byte[] bArr = this.e;
        tVar.b(bArr, 0, bArr.length);
        this.f904a.b(g, 0, this.d);
        this.f904a.b(c, 0, c.length);
        byte[] c2 = this.f904a.c();
        reset();
        return c2;
    }

    @Override // sdk.pendo.io.z4.v
    public int c() {
        return this.b;
    }

    @Override // sdk.pendo.io.z4.v
    public void reset() {
        this.f904a.reset();
        sdk.pendo.io.z4.t tVar = this.f904a;
        byte[] bArr = this.e;
        tVar.b(bArr, 0, bArr.length);
        this.f904a.b(f, 0, this.d);
    }

    @Override // sdk.pendo.io.z4.s
    public int a() {
        return this.c;
    }

    @Override // sdk.pendo.io.z4.v
    public void b(byte[] bArr, int i, int i2) {
        this.f904a.b(bArr, i, i2);
    }

    @Override // sdk.pendo.io.z4.v
    public void a(byte[] bArr, int i, int i2) {
        this.e = l3.a(bArr, i, i2 + i);
        reset();
    }
}
