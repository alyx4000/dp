package sdk.pendo.io.m3;

import java.io.IOException;
import java.util.Iterator;
import kotlin.UByte;
import okhttp3.HttpUrl;
import org.bouncycastle.asn1.ASN1Encoding;
import sdk.pendo.io.d5.a;

/* loaded from: classes6.dex */
public abstract class e0 extends a0 implements Iterable {
    static final o0 A = new a(e0.class, 17);
    protected final g[] f;
    protected final boolean s;

    static class a extends o0 {
        a(Class cls, int i) {
            super(cls, i);
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(d0 d0Var) {
            return d0Var.q();
        }
    }

    protected e0() {
        this.f = h.d;
        this.s = true;
    }

    @Override // sdk.pendo.io.m3.a0
    boolean a(a0 a0Var) {
        if (!(a0Var instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) a0Var;
        int size = size();
        if (e0Var.size() != size) {
            return false;
        }
        x1 x1Var = (x1) i();
        x1 x1Var2 = (x1) e0Var.i();
        for (int i = 0; i < size; i++) {
            a0 b = x1Var.f[i].b();
            a0 b2 = x1Var2.f[i].b();
            if (b != b2 && !b.a(b2)) {
                return false;
            }
        }
        return true;
    }

    @Override // sdk.pendo.io.m3.a0
    boolean h() {
        return true;
    }

    @Override // sdk.pendo.io.m3.a0, sdk.pendo.io.m3.t
    public int hashCode() {
        int length = this.f.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i += this.f[length].b().hashCode();
        }
    }

    @Override // sdk.pendo.io.m3.a0
    a0 i() {
        g[] gVarArr;
        if (this.s) {
            gVarArr = this.f;
        } else {
            gVarArr = (g[]) this.f.clone();
            a(gVarArr);
        }
        return new x1(true, gVarArr);
    }

    @Override // java.lang.Iterable
    public Iterator<g> iterator() {
        return new a.C0112a(k());
    }

    @Override // sdk.pendo.io.m3.a0
    a0 j() {
        return new m2(this.s, this.f);
    }

    public g[] k() {
        return h.a(this.f);
    }

    public int size() {
        return this.f.length;
    }

    public String toString() {
        int size = size();
        if (size == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuffer stringBuffer = new StringBuffer("[");
        int i = 0;
        while (true) {
            stringBuffer.append(this.f[i]);
            i++;
            if (i >= size) {
                stringBuffer.append(']');
                return stringBuffer.toString();
            }
            stringBuffer.append(", ");
        }
    }

    protected e0(h hVar, boolean z) {
        g[] c;
        if (hVar == null) {
            throw new NullPointerException("'elementVector' cannot be null");
        }
        if (!z || hVar.b() < 2) {
            c = hVar.c();
        } else {
            c = hVar.a();
            a(c);
        }
        this.f = c;
        this.s = z || c.length < 2;
    }

    private static byte[] a(g gVar) {
        try {
            return gVar.b().a(ASN1Encoding.DER);
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    e0(boolean z, g[] gVarArr) {
        this.f = gVarArr;
        this.s = z || gVarArr.length < 2;
    }

    public static e0 a(Object obj) {
        if (obj == null || (obj instanceof e0)) {
            return (e0) obj;
        }
        if (obj instanceof g) {
            a0 b = ((g) obj).b();
            if (b instanceof e0) {
                return (e0) b;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (e0) A.a((byte[]) obj);
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct set from byte[]: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    public static e0 a(j0 j0Var, boolean z) {
        return (e0) A.a(j0Var, z);
    }

    public g a(int i) {
        return this.f[i];
    }

    private static boolean a(byte[] bArr, byte[] bArr2) {
        int i = bArr[0] & (-33);
        int i2 = bArr2[0] & (-33);
        if (i != i2) {
            return i < i2;
        }
        int min = Math.min(bArr.length, bArr2.length) - 1;
        for (int i3 = 1; i3 < min; i3++) {
            byte b = bArr[i3];
            byte b2 = bArr2[i3];
            if (b != b2) {
                return (b & UByte.MAX_VALUE) < (b2 & UByte.MAX_VALUE);
            }
        }
        return (bArr[min] & UByte.MAX_VALUE) <= (bArr2[min] & UByte.MAX_VALUE);
    }

    private static void a(g[] gVarArr) {
        int length = gVarArr.length;
        if (length < 2) {
            return;
        }
        g gVar = gVarArr[0];
        g gVar2 = gVarArr[1];
        byte[] a2 = a(gVar);
        byte[] a3 = a(gVar2);
        if (a(a3, a2)) {
            gVar2 = gVar;
            gVar = gVar2;
            a3 = a2;
            a2 = a3;
        }
        for (int i = 2; i < length; i++) {
            g gVar3 = gVarArr[i];
            byte[] a4 = a(gVar3);
            if (a(a3, a4)) {
                gVarArr[i - 2] = gVar;
                gVar = gVar2;
                a2 = a3;
                gVar2 = gVar3;
                a3 = a4;
            } else if (a(a2, a4)) {
                gVarArr[i - 2] = gVar;
                gVar = gVar3;
                a2 = a4;
            } else {
                int i2 = i - 1;
                while (true) {
                    i2--;
                    if (i2 <= 0) {
                        break;
                    }
                    g gVar4 = gVarArr[i2 - 1];
                    if (a(a(gVar4), a4)) {
                        break;
                    } else {
                        gVarArr[i2] = gVar4;
                    }
                }
                gVarArr[i2] = gVar3;
            }
        }
        gVarArr[length - 2] = gVar;
        gVarArr[length - 1] = gVar2;
    }
}
