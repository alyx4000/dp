package sdk.pendo.io.y4;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Vector;

/* loaded from: classes4.dex */
public class l {
    private static final sdk.pendo.io.z4.f[] c;
    private static final m[] d;
    public static final l e;
    public static final l f;

    /* renamed from: a, reason: collision with root package name */
    protected final byte[] f1785a;
    protected final m[] b;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f1786a = Integer.MAX_VALUE;

        public int a() {
            return this.f1786a;
        }

        public a a(int i) {
            this.f1786a = i;
            return this;
        }
    }

    static {
        sdk.pendo.io.z4.f[] fVarArr = new sdk.pendo.io.z4.f[0];
        c = fVarArr;
        m[] mVarArr = new m[0];
        d = mVarArr;
        e = new l(fVarArr);
        f = new l(l3.e, mVarArr);
    }

    public l(byte[] bArr, m[] mVarArr) {
        if (bArr != null && !l3.q(bArr.length)) {
            throw new IllegalArgumentException("'certificateRequestContext' cannot be longer than 255");
        }
        if (l3.a((Object[]) mVarArr)) {
            throw new NullPointerException("'certificateEntryList' cannot be null or contain any nulls");
        }
        this.f1785a = l3.a(bArr);
        this.b = mVarArr;
    }

    protected static void a(r1 r1Var, sdk.pendo.io.z4.f fVar, byte[] bArr, OutputStream outputStream) {
        byte[] a2 = l3.a(r1Var, fVar, bArr);
        if (a2 == null || a2.length <= 0) {
            return;
        }
        outputStream.write(a2);
    }

    public short b() {
        return (short) 0;
    }

    public int c() {
        return this.b.length;
    }

    public boolean d() {
        return this.b.length == 0;
    }

    public l(sdk.pendo.io.z4.f[] fVarArr) {
        this(null, a(fVarArr));
    }

    private static m[] a(sdk.pendo.io.z4.f[] fVarArr) {
        if (l3.a((Object[]) fVarArr)) {
            throw new NullPointerException("'certificateList' cannot be null or contain any nulls");
        }
        int length = fVarArr.length;
        m[] mVarArr = new m[length];
        for (int i = 0; i < length; i++) {
            mVarArr[i] = new m(fVarArr[i], null);
        }
        return mVarArr;
    }

    public void a(r1 r1Var, OutputStream outputStream, OutputStream outputStream2) {
        boolean d2 = l3.d(r1Var);
        byte[] bArr = this.f1785a;
        if ((bArr != null) != d2) {
            throw new IllegalStateException();
        }
        if (d2) {
            l3.c(bArr, outputStream);
        }
        int length = this.b.length;
        Vector vector = new Vector(length);
        Vector vector2 = d2 ? new Vector(length) : null;
        long j = 0;
        for (int i = 0; i < length; i++) {
            m mVar = this.b[i];
            sdk.pendo.io.z4.f a2 = mVar.a();
            byte[] encoded = a2.getEncoded();
            if (i == 0 && outputStream2 != null) {
                a(r1Var, a2, encoded, outputStream2);
            }
            vector.addElement(encoded);
            j = j + encoded.length + 3;
            if (d2) {
                Hashtable b = mVar.b();
                vector2.addElement(b == null ? l3.e : w2.a(b));
                j = j + r8.length + 2;
            }
        }
        l3.a(j);
        l3.b((int) j, outputStream);
        for (int i2 = 0; i2 < length; i2++) {
            l3.b((byte[]) vector.elementAt(i2), outputStream);
            if (d2) {
                l3.a((byte[]) vector2.elementAt(i2), outputStream);
            }
        }
    }

    public sdk.pendo.io.z4.f a(int i) {
        return this.b[i].a();
    }

    public byte[] a() {
        return l3.a(this.f1785a);
    }

    public static l a(a aVar, r1 r1Var, InputStream inputStream, OutputStream outputStream) {
        boolean e2 = l3.e(r1Var.h().s());
        byte[] c2 = e2 ? l3.c(inputStream) : null;
        int e3 = l3.e(inputStream);
        if (e3 == 0) {
            return !e2 ? e : c2.length < 1 ? f : new l(c2, d);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(l3.a(e3, inputStream));
        sdk.pendo.io.z4.h b = r1Var.b();
        int max = Math.max(1, aVar.a());
        Vector vector = new Vector();
        while (byteArrayInputStream.available() > 0) {
            if (vector.size() >= max) {
                throw new h2((short) 80, "Certificate chain longer than maximum (" + max + ")");
            }
            byte[] b2 = l3.b(byteArrayInputStream, 1);
            sdk.pendo.io.z4.f a2 = b.a(b2);
            if (vector.isEmpty() && outputStream != null) {
                a(r1Var, a2, b2, outputStream);
            }
            vector.addElement(new m(a2, e2 ? w2.a(11, l3.b(byteArrayInputStream)) : null));
        }
        m[] mVarArr = new m[vector.size()];
        for (int i = 0; i < vector.size(); i++) {
            mVarArr[i] = (m) vector.elementAt(i);
        }
        return new l(c2, mVarArr);
    }
}
