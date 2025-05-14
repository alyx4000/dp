package sdk.pendo.io.m3;

import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes6.dex */
public class i extends a0 {
    static final o0 A = new a(i.class, 10);
    private static final i[] f0 = new i[12];
    private final byte[] f;
    private final int s;

    static class a extends o0 {
        a(Class cls, int i) {
            super(cls, i);
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(s1 s1Var) {
            return i.a(s1Var.k(), false);
        }
    }

    i(byte[] bArr, boolean z) {
        if (q.c(bArr)) {
            throw new IllegalArgumentException("malformed enumerated");
        }
        if ((bArr[0] & ByteCompanionObject.MIN_VALUE) != 0) {
            throw new IllegalArgumentException("enumerated must be non-negative");
        }
        this.f = z ? sdk.pendo.io.d5.a.a(bArr) : bArr;
        this.s = q.d(bArr);
    }

    @Override // sdk.pendo.io.m3.a0
    boolean a(a0 a0Var) {
        if (a0Var instanceof i) {
            return sdk.pendo.io.d5.a.a(this.f, ((i) a0Var).f);
        }
        return false;
    }

    @Override // sdk.pendo.io.m3.a0
    boolean h() {
        return false;
    }

    @Override // sdk.pendo.io.m3.a0, sdk.pendo.io.m3.t
    public int hashCode() {
        return sdk.pendo.io.d5.a.b(this.f);
    }

    static i a(byte[] bArr, boolean z) {
        if (bArr.length > 1) {
            return new i(bArr, z);
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("ENUMERATED has zero length");
        }
        int i = bArr[0] & UByte.MAX_VALUE;
        i[] iVarArr = f0;
        if (i >= iVarArr.length) {
            return new i(bArr, z);
        }
        i iVar = iVarArr[i];
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(bArr, z);
        iVarArr[i] = iVar2;
        return iVar2;
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        yVar.a(z, 10, this.f);
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        return y.a(z, this.f.length);
    }

    public static i a(Object obj) {
        if (obj == null || (obj instanceof i)) {
            return (i) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (i) A.a((byte[]) obj);
        } catch (Exception e) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
        }
    }
}
