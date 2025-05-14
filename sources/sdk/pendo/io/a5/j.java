package sdk.pendo.io.a5;

import sdk.pendo.io.y4.l3;
import sdk.pendo.io.y4.v0;
import sdk.pendo.io.z4.s;
import sdk.pendo.io.z4.v;

/* loaded from: classes6.dex */
public class j implements k {

    /* renamed from: a, reason: collision with root package name */
    protected final sdk.pendo.io.z4.j f854a;
    protected final s b;
    protected final int c;
    protected final int d;
    protected final int e;

    public j(sdk.pendo.io.z4.j jVar, s sVar) {
        this.f854a = jVar;
        this.b = sVar;
        this.e = a(jVar, sVar);
        int a2 = sVar.a();
        this.c = a2;
        if (h.a(jVar) && sVar.c() == 20) {
            this.d = 4;
        } else {
            this.d = a2 / 8;
        }
    }

    @Override // sdk.pendo.io.a5.k
    public byte[] a(long j, short s, byte[] bArr, int i, int i2) {
        v0 e = this.f854a.e();
        boolean g = e.g();
        int i3 = g ? 11 : 13;
        byte[] bArr2 = new byte[i3];
        l3.a(j, bArr2, 0);
        l3.a(s, bArr2, 8);
        if (!g) {
            l3.a(e, bArr2, 9);
        }
        l3.a(i2, bArr2, i3 - 2);
        this.b.b(bArr2, 0, i3);
        this.b.b(bArr, i, i2);
        return a(this.b.b());
    }

    @Override // sdk.pendo.io.a5.k
    public int getSize() {
        return this.e;
    }

    @Override // sdk.pendo.io.a5.k
    public byte[] a(long j, short s, byte[] bArr, int i, int i2, int i3, byte[] bArr2) {
        byte[] a2 = a(j, s, bArr, i, i2);
        int i4 = h.a(this.f854a) ? 11 : 13;
        int a3 = a(i3 + i4) - a(i4 + i2);
        while (true) {
            a3--;
            if (a3 < 0) {
                this.b.b(bArr2, 0, 1);
                this.b.reset();
                return a2;
            }
            this.b.b(bArr2, 0, this.c);
        }
    }

    protected int a(int i) {
        return (i + this.d) / this.c;
    }

    protected static int a(sdk.pendo.io.z4.j jVar, v vVar) {
        int c = vVar.c();
        return jVar.d().Q() ? Math.min(c, 10) : c;
    }

    protected byte[] a(byte[] bArr) {
        int length = bArr.length;
        int i = this.e;
        return length <= i ? bArr : sdk.pendo.io.d5.a.a(bArr, i);
    }
}
