package sdk.pendo.io.y4;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class e2 extends c {
    protected sdk.pendo.io.z4.o c;
    protected sdk.pendo.io.z4.e d;

    public e2(int i) {
        this(i, null);
    }

    private static int a(int i) {
        if (i == 20) {
            return i;
        }
        throw new IllegalArgumentException("unsupported key exchange algorithm");
    }

    protected void b(OutputStream outputStream) {
        l3.c(this.d.a(), outputStream);
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

    public e2(int i, sdk.pendo.io.z4.o oVar) {
        super(a(i));
        this.c = oVar;
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(OutputStream outputStream) {
        b(outputStream);
    }

    @Override // sdk.pendo.io.y4.l2
    public sdk.pendo.io.z4.b0 b() {
        return this.d.b();
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b2.a(this.c, byteArrayOutputStream);
        this.d = this.b.b().a(this.c).a();
        b(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // sdk.pendo.io.y4.c, sdk.pendo.io.y4.l2
    public void b(l lVar) {
        throw new h2((short) 10);
    }

    @Override // sdk.pendo.io.y4.l2
    public void a(v1 v1Var) {
        throw new h2((short) 80);
    }

    @Override // sdk.pendo.io.y4.l2
    public void b(InputStream inputStream) {
        a(l3.c(inputStream, 1));
    }

    protected void a(byte[] bArr) {
        b2.a(this.c.a(), bArr);
        this.d.a(bArr);
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
        this.c = b2.a(this.b, inputStream);
        byte[] c = l3.c(inputStream, 1);
        this.d = this.b.b().a(this.c).a();
        a(c);
    }
}
