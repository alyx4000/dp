package sdk.pendo.io.m3;

import kotlin.UByte;

/* loaded from: classes6.dex */
public class j1 extends c {
    public j1(byte[] bArr) {
        this(bArr, 0);
    }

    public static j1 a(c cVar) {
        return (j1) cVar.i();
    }

    public static j1 b(Object obj) {
        if (obj == null || (obj instanceof j1)) {
            return (j1) obj;
        }
        if (obj instanceof c) {
            return a((c) obj);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return a((c) a0.a((byte[]) obj));
        } catch (Exception e) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
        }
    }

    @Override // sdk.pendo.io.m3.a0
    boolean h() {
        return false;
    }

    @Override // sdk.pendo.io.m3.c, sdk.pendo.io.m3.a0
    a0 i() {
        return this;
    }

    @Override // sdk.pendo.io.m3.c, sdk.pendo.io.m3.a0
    a0 j() {
        return this;
    }

    public j1(byte[] bArr, int i) {
        super(bArr, i);
    }

    public static j1 b(j0 j0Var, boolean z) {
        a0 l = j0Var.l();
        return (z || (l instanceof j1)) ? b((Object) l) : a(w.a((Object) l));
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        byte[] bArr = this.f;
        int i = bArr[0] & UByte.MAX_VALUE;
        int length = bArr.length - 1;
        byte b = bArr[length];
        byte b2 = (byte) ((255 << i) & b);
        if (b == b2) {
            yVar.a(z, 3, bArr);
        } else {
            yVar.a(z, 3, bArr, 0, length, b2);
        }
    }

    j1(byte[] bArr, boolean z) {
        super(bArr, z);
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        return y.a(z, this.f.length);
    }

    static j1 a(w wVar) {
        return new j1(wVar.k(), true);
    }
}
