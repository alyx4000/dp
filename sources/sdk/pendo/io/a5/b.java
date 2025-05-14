package sdk.pendo.io.a5;

import sdk.pendo.io.z4.b0;
import sdk.pendo.io.z4.r;
import sdk.pendo.io.z4.s;

/* loaded from: classes6.dex */
public abstract class b implements b0 {

    /* renamed from: a, reason: collision with root package name */
    protected byte[] f849a;

    protected b(byte[] bArr) {
        this.f849a = bArr;
    }

    @Override // sdk.pendo.io.z4.b0
    public synchronized byte[] a(int i, byte[] bArr, int i2, int i3) {
        s b;
        c();
        b = e().b(i);
        byte[] bArr2 = this.f849a;
        b.a(bArr2, 0, bArr2.length);
        b.b(bArr, i2, i3);
        return b.b();
    }

    @Override // sdk.pendo.io.z4.b0
    public synchronized boolean b() {
        return this.f849a != null;
    }

    protected void c() {
        if (this.f849a == null) {
            throw new IllegalStateException("Secret has already been extracted or destroyed");
        }
    }

    synchronized byte[] d() {
        return sdk.pendo.io.d5.a.a(this.f849a);
    }

    @Override // sdk.pendo.io.z4.b0
    public synchronized void destroy() {
        byte[] bArr = this.f849a;
        if (bArr != null) {
            sdk.pendo.io.d5.a.a(bArr, (byte) 0);
            this.f849a = null;
        }
    }

    protected abstract a e();

    protected static byte[] a(b bVar) {
        return bVar.d();
    }

    @Override // sdk.pendo.io.z4.b0
    public synchronized byte[] a(r rVar) {
        byte[] bArr;
        c();
        bArr = this.f849a;
        return rVar.a(bArr, 0, bArr.length);
    }

    @Override // sdk.pendo.io.z4.b0
    public synchronized byte[] a() {
        byte[] bArr;
        c();
        bArr = this.f849a;
        this.f849a = null;
        return bArr;
    }
}
