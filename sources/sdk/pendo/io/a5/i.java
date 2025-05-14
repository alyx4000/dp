package sdk.pendo.io.a5;

import sdk.pendo.io.y4.h2;
import sdk.pendo.io.y4.l3;
import sdk.pendo.io.y4.v0;
import sdk.pendo.io.z4.n;
import sdk.pendo.io.z4.q;
import sdk.pendo.io.z4.s;

/* loaded from: classes6.dex */
public class i implements sdk.pendo.io.z4.g {

    /* renamed from: a, reason: collision with root package name */
    protected final sdk.pendo.io.z4.j f853a;
    protected final j b;
    protected final j c;

    public i(sdk.pendo.io.z4.j jVar, s sVar, s sVar2) {
        if (h.d(jVar)) {
            throw new h2((short) 80);
        }
        this.f853a = jVar;
        int c = sVar.c() + sVar2.c();
        byte[] a2 = h.a(jVar, c);
        sVar.a(a2, 0, sVar.c());
        int c2 = sVar.c() + 0;
        sVar2.a(a2, c2, sVar2.c());
        if (c2 + sVar2.c() != c) {
            throw new h2((short) 80);
        }
        if (jVar.f()) {
            this.c = new j(jVar, sVar2);
            this.b = new j(jVar, sVar);
        } else {
            this.c = new j(jVar, sVar);
            this.b = new j(jVar, sVar2);
        }
    }

    @Override // sdk.pendo.io.z4.g
    public n a(long j, short s, v0 v0Var, byte[] bArr, int i, int i2) {
        int size = this.b.getSize();
        if (i2 < size) {
            throw new h2((short) 50);
        }
        int i3 = i2 - size;
        if (!l3.a(size, this.b.a(j, s, bArr, i, i3), 0, bArr, i + i3)) {
            throw new h2((short) 20);
        }
        return new n(bArr, i, i3, s);
    }

    @Override // sdk.pendo.io.z4.g
    public boolean a() {
        return false;
    }

    @Override // sdk.pendo.io.z4.g
    public int b(int i) {
        return i - this.c.getSize();
    }

    @Override // sdk.pendo.io.z4.g
    public void c() {
        throw new h2((short) 80);
    }

    @Override // sdk.pendo.io.z4.g
    public q a(long j, short s, v0 v0Var, int i, byte[] bArr, int i2, int i3) {
        byte[] a2 = this.c.a(j, s, bArr, i2, i3);
        int i4 = i + i3;
        int length = a2.length + i4;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i2, bArr2, i, i3);
        System.arraycopy(a2, 0, bArr2, i4, a2.length);
        return new q(bArr2, 0, length, s);
    }

    @Override // sdk.pendo.io.z4.g
    public void b() {
        throw new h2((short) 80);
    }

    @Override // sdk.pendo.io.z4.g
    public int a(int i) {
        return i + this.c.getSize();
    }

    @Override // sdk.pendo.io.z4.g
    public int a(int i, int i2) {
        return i + this.c.getSize();
    }
}
