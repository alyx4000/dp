package sdk.pendo.io.y4;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class a2 extends c {
    protected x1 c;
    protected sdk.pendo.io.z4.l d;
    protected sdk.pendo.io.z4.e e;

    public a2(int i, x1 x1Var) {
        this(i, x1Var, null);
    }

    private static int a(int i) {
        if (i == 11) {
            return i;
        }
        throw new IllegalArgumentException("unsupported key exchange algorithm");
    }

    @Override // sdk.pendo.io.y4.l2
    public sdk.pendo.io.z4.b0 b() {
        return this.e.b();
    }

    @Override // sdk.pendo.io.y4.l2
    public void e() {
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public short[] f() {
        return null;
    }

    @Override // sdk.pendo.io.y4.c
    public boolean h() {
        return true;
    }

    private a2(int i, x1 x1Var, sdk.pendo.io.z4.l lVar) {
        super(a(i));
        this.c = x1Var;
        this.d = lVar;
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(OutputStream outputStream) {
        l3.a(this.e.a(), outputStream);
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public void b(l lVar) {
        throw new h2((short) 10);
    }

    public a2(int i, sdk.pendo.io.z4.l lVar) {
        this(i, null, lVar);
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        z1.a(this.d, byteArrayOutputStream);
        sdk.pendo.io.z4.e a2 = this.b.b().a(this.d).a();
        this.e = a2;
        l3.a(a2.a(), (OutputStream) byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // sdk.pendo.io.y4.l2
    public void b(InputStream inputStream) {
        this.e.a(l3.a(inputStream, 1));
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(v1 v1Var) {
        throw new h2((short) 80);
    }

    @Override // sdk.pendo.io.y4.l2
    public void b(v1 v1Var) {
        throw new h2((short) 80);
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(l lVar) {
        throw new h2((short) 10);
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public void a(InputStream inputStream) {
        this.d = z1.a(this.b, this.c, inputStream);
        byte[] a2 = l3.a(inputStream, 1);
        sdk.pendo.io.z4.e a3 = this.b.b().a(this.d).a();
        this.e = a3;
        a3.a(a2);
    }
}
