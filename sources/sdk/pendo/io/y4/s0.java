package sdk.pendo.io.y4;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/* loaded from: classes4.dex */
public class s0 {

    /* renamed from: a, reason: collision with root package name */
    protected final Vector f1799a;
    protected final Vector b;
    protected final int c;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        final q2[] f1800a;
        final short[] b;
        final sdk.pendo.io.z4.b0[] c;
        final int d;

        a(q2[] q2VarArr, short[] sArr, sdk.pendo.io.z4.b0[] b0VarArr, int i) {
            this.f1800a = q2VarArr;
            this.b = sArr;
            this.c = b0VarArr;
            this.d = i;
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        final int f1801a;
        final q2 b;
        final short[] c;
        final sdk.pendo.io.z4.b0 d;

        b(int i, q2 q2Var, short[] sArr, sdk.pendo.io.z4.b0 b0Var) {
            this.f1801a = i;
            this.b = q2Var;
            this.c = sArr;
            this.d = b0Var;
        }
    }

    public s0(Vector vector) {
        this(vector, null, -1);
    }

    public void a(OutputStream outputStream) {
        int i = 0;
        for (int i2 = 0; i2 < this.f1799a.size(); i2++) {
            i += ((w0) this.f1799a.elementAt(i2)).a();
        }
        l3.a(i);
        l3.a(i, outputStream);
        for (int i3 = 0; i3 < this.f1799a.size(); i3++) {
            ((w0) this.f1799a.elementAt(i3)).a(outputStream);
        }
        if (this.b != null) {
            int i4 = 0;
            for (int i5 = 0; i5 < this.b.size(); i5++) {
                i4 += ((byte[]) this.b.elementAt(i5)).length + 1;
            }
            l3.a(i4);
            l3.a(i4, outputStream);
            for (int i6 = 0; i6 < this.b.size(); i6++) {
                l3.c((byte[]) this.b.elementAt(i6), outputStream);
            }
        }
    }

    public int b() {
        return this.c;
    }

    public Vector c() {
        return this.f1799a;
    }

    private s0(Vector vector, Vector vector2, int i) {
        if (vector == null || vector.isEmpty()) {
            throw new IllegalArgumentException("'identities' cannot be null or empty");
        }
        if (vector2 != null && vector.size() != vector2.size()) {
            throw new IllegalArgumentException("'binders' must be the same length as 'identities' (or null)");
        }
        if ((vector2 != null) != (i >= 0)) {
            throw new IllegalArgumentException("'bindersSize' must be >= 0 iff 'binders' are present");
        }
        this.f1799a = vector;
        this.b = vector2;
        this.c = i;
    }

    static void a(OutputStream outputStream, sdk.pendo.io.z4.h hVar, j2 j2Var, a aVar) {
        q2[] q2VarArr = aVar.f1800a;
        sdk.pendo.io.z4.b0[] b0VarArr = aVar.c;
        int i = aVar.d - 2;
        l3.a(i);
        l3.a(i, outputStream);
        int i2 = 0;
        for (int i3 = 0; i3 < q2VarArr.length; i3++) {
            q2 q2Var = q2VarArr[i3];
            sdk.pendo.io.z4.b0 b0Var = b0VarArr[i3];
            int b2 = sdk.pendo.io.z4.k.b(q2Var.a());
            sdk.pendo.io.z4.t d = hVar.d(b2);
            j2Var.a(new sdk.pendo.io.z4.u(d));
            byte[] a2 = l3.a(hVar, true, b2, b0Var, d.c());
            i2 += a2.length + 1;
            l3.c(a2, outputStream);
        }
        if (i != i2) {
            throw new h2((short) 80);
        }
    }

    public Vector a() {
        return this.b;
    }

    static int a(q2[] q2VarArr) {
        int i = 0;
        for (q2 q2Var : q2VarArr) {
            i += sdk.pendo.io.z4.k.d(sdk.pendo.io.z4.k.b(q2Var.a())) + 1;
        }
        l3.a(i);
        return i + 2;
    }

    public int a(w0 w0Var) {
        int size = this.f1799a.size();
        for (int i = 0; i < size; i++) {
            if (w0Var.equals(this.f1799a.elementAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public static s0 a(InputStream inputStream) {
        Vector vector = new Vector();
        int d = l3.d(inputStream);
        if (d < 7) {
            throw new h2((short) 50);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(l3.a(d, inputStream));
        do {
            vector.add(w0.a(byteArrayInputStream));
        } while (byteArrayInputStream.available() > 0);
        Vector vector2 = new Vector();
        int d2 = l3.d(inputStream);
        if (d2 < 33) {
            throw new h2((short) 50);
        }
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(l3.a(d2, inputStream));
        do {
            vector2.add(l3.c(byteArrayInputStream2, 32));
        } while (byteArrayInputStream2.available() > 0);
        return new s0(vector, vector2, d2 + 2);
    }
}
