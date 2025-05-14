package sdk.pendo.io.y4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encoding;

/* loaded from: classes4.dex */
public class g2 {

    /* renamed from: a, reason: collision with root package name */
    public static final Integer f1779a = sdk.pendo.io.d5.d.b(16);
    public static final Integer b = sdk.pendo.io.d5.d.b(47);
    public static final Integer c = sdk.pendo.io.d5.d.b(19);
    public static final Integer d = sdk.pendo.io.d5.d.b(2);
    public static final Integer e = sdk.pendo.io.d5.d.b(27);
    public static final Integer f = sdk.pendo.io.d5.d.b(44);
    public static final Integer g = sdk.pendo.io.d5.d.b(42);
    public static final Integer h = sdk.pendo.io.d5.d.b(11);
    public static final Integer i = sdk.pendo.io.d5.d.b(22);
    public static final Integer j = sdk.pendo.io.d5.d.b(23);
    public static final Integer k = sdk.pendo.io.d5.d.b(15);
    public static final Integer l = sdk.pendo.io.d5.d.b(51);
    public static final Integer m = sdk.pendo.io.d5.d.b(1);
    public static final Integer n = sdk.pendo.io.d5.d.b(48);
    public static final Integer o = sdk.pendo.io.d5.d.b(21);
    public static final Integer p = sdk.pendo.io.d5.d.b(49);
    public static final Integer q = sdk.pendo.io.d5.d.b(41);
    public static final Integer r = sdk.pendo.io.d5.d.b(45);
    public static final Integer s = sdk.pendo.io.d5.d.b(28);
    public static final Integer t = sdk.pendo.io.d5.d.b(20);
    public static final Integer u = sdk.pendo.io.d5.d.b(0);
    public static final Integer v = sdk.pendo.io.d5.d.b(13);
    public static final Integer w = sdk.pendo.io.d5.d.b(50);
    public static final Integer x = sdk.pendo.io.d5.d.b(5);
    public static final Integer y = sdk.pendo.io.d5.d.b(17);
    public static final Integer z = sdk.pendo.io.d5.d.b(10);
    public static final Integer A = sdk.pendo.io.d5.d.b(43);
    public static final Integer B = sdk.pendo.io.d5.d.b(4);
    public static final Integer C = sdk.pendo.io.d5.d.b(3);

    public static v0 A(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, A);
        if (a2 == null) {
            return null;
        }
        return z(a2);
    }

    public static Vector B(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, C);
        if (a2 == null) {
            return null;
        }
        return B(a2);
    }

    public static boolean C(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, i);
        if (a2 == null) {
            return false;
        }
        return g(a2);
    }

    public static boolean D(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, j);
        if (a2 == null) {
            return false;
        }
        return h(a2);
    }

    public static boolean E(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, u);
        if (a2 == null) {
            return false;
        }
        return r(a2);
    }

    public static boolean F(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, B);
        if (a2 == null) {
            return false;
        }
        return A(a2);
    }

    public static void a(Hashtable hashtable, Vector vector) {
        hashtable.put(f1779a, a(vector));
    }

    public static void b(Hashtable hashtable, Vector vector) {
        hashtable.put(b, b(vector));
    }

    public static void c(Hashtable hashtable, Vector vector) {
        hashtable.put(l, c(vector));
    }

    public static void d(Hashtable hashtable, Vector vector) {
        hashtable.put(u, d(vector));
    }

    public static void e(Hashtable hashtable, Vector vector) {
        hashtable.put(w, e(vector));
    }

    public static void f(Hashtable hashtable, Vector vector) {
        hashtable.put(v, f(vector));
    }

    public static void g(Hashtable hashtable, Vector vector) {
        hashtable.put(y, g(vector));
    }

    public static void h(Hashtable hashtable, Vector vector) {
        hashtable.put(z, h(vector));
    }

    public static void i(Hashtable hashtable, Vector vector) {
        hashtable.put(C, i(vector));
    }

    public static byte[] j(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, f);
        if (a2 == null) {
            return null;
        }
        return e(a2);
    }

    public static Vector k(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, l);
        if (a2 == null) {
            return null;
        }
        return i(a2);
    }

    public static int l(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, l);
        if (a2 == null) {
            return -1;
        }
        return j(a2);
    }

    public static k0 m(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, l);
        if (a2 == null) {
            return null;
        }
        return k(a2);
    }

    public static short n(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, m);
        if (a2 == null) {
            return (short) -1;
        }
        return l(a2);
    }

    public static short[] o(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, r);
        if (a2 == null) {
            return null;
        }
        return m(a2);
    }

    public static int p(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, o);
        if (a2 == null) {
            return -1;
        }
        return n(a2);
    }

    public static s0 q(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, q);
        if (a2 == null) {
            return null;
        }
        return o(a2);
    }

    public static int r(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, q);
        if (a2 == null) {
            return -1;
        }
        return p(a2);
    }

    public static Vector s(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, u);
        if (a2 == null) {
            return null;
        }
        return q(a2);
    }

    public static Vector t(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, w);
        if (a2 == null) {
            return null;
        }
        return s(a2);
    }

    public static Vector u(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, v);
        if (a2 == null) {
            return null;
        }
        return t(a2);
    }

    public static p v(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, x);
        if (a2 == null) {
            return null;
        }
        return u(a2);
    }

    public static Vector w(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, y);
        if (a2 == null) {
            return null;
        }
        return v(a2);
    }

    public static int[] x(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, z);
        if (a2 == null) {
            return null;
        }
        return w(a2);
    }

    public static short[] y(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, h);
        if (a2 == null) {
            return null;
        }
        return x(a2);
    }

    public static v0[] z(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, A);
        if (a2 == null) {
            return null;
        }
        return y(a2);
    }

    public static boolean A(byte[] bArr) {
        return f(bArr);
    }

    public static Vector B(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        if (bArr.length < 2) {
            throw new h2((short) 50);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        if (l3.d(byteArrayInputStream) != bArr.length - 2) {
            throw new h2((short) 50);
        }
        Vector vector = new Vector();
        while (byteArrayInputStream.available() > 0) {
            vector.addElement(m3.a((InputStream) byteArrayInputStream));
        }
        return vector;
    }

    public static void a(Hashtable hashtable, u0 u0Var) {
        hashtable.put(f1779a, a(u0Var));
    }

    public static void b(Hashtable hashtable) {
        hashtable.put(j, c());
    }

    public static void c(Hashtable hashtable) {
        hashtable.put(u, d());
    }

    public static void d(Hashtable hashtable) {
        hashtable.put(B, e());
    }

    public static void e(Hashtable hashtable) {
        hashtable.put(C, f());
    }

    public static byte[] f(Vector vector) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l3.a(vector, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] g(Vector vector) {
        if (vector == null || vector.isEmpty()) {
            throw new h2((short) 80);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l3.a(0, (OutputStream) byteArrayOutputStream);
        for (int i2 = 0; i2 < vector.size(); i2++) {
            ((q) vector.elementAt(i2)).a(byteArrayOutputStream);
        }
        return a(byteArrayOutputStream);
    }

    public static byte[] h(Vector vector) {
        if (vector == null || vector.isEmpty()) {
            throw new h2((short) 80);
        }
        int size = vector.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = ((Integer) vector.elementAt(i2)).intValue();
        }
        return l3.a(iArr);
    }

    public static byte[] i(Vector vector) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l3.a(0, (OutputStream) byteArrayOutputStream);
        if (vector != null) {
            for (int i2 = 0; i2 < vector.size(); i2++) {
                ((m3) vector.elementAt(i2)).a((OutputStream) byteArrayOutputStream);
            }
        }
        return a(byteArrayOutputStream);
    }

    public static int j(byte[] bArr) {
        return l3.b(bArr);
    }

    public static k0 k(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        k0 a2 = k0.a(byteArrayInputStream);
        w2.a(byteArrayInputStream);
        return a2;
    }

    public static short l(byte[] bArr) {
        return l3.c(bArr);
    }

    public static short[] m(byte[] bArr) {
        short[] d2 = l3.d(bArr);
        if (d2.length >= 1) {
            return d2;
        }
        throw new h2((short) 50);
    }

    public static int n(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        int i2 = 0;
        for (byte b2 : bArr) {
            i2 |= b2;
        }
        if (i2 == 0) {
            return bArr.length;
        }
        throw new h2((short) 47);
    }

    public static s0 o(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        s0 a2 = s0.a(byteArrayInputStream);
        w2.a(byteArrayInputStream);
        return a2;
    }

    public static int p(byte[] bArr) {
        return l3.b(bArr);
    }

    public static Vector q(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        d1 a2 = d1.a(byteArrayInputStream);
        w2.a(byteArrayInputStream);
        return a2.a();
    }

    public static boolean r(byte[] bArr) {
        return f(bArr);
    }

    public static Vector s(byte[] bArr) {
        return t(bArr);
    }

    public static Vector t(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        Vector a2 = l3.a((InputStream) byteArrayInputStream);
        w2.a(byteArrayInputStream);
        return a2;
    }

    public static p u(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        p a2 = p.a(byteArrayInputStream);
        w2.a(byteArrayInputStream);
        return a2;
    }

    public static Vector v(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        if (bArr.length < 3) {
            throw new h2((short) 50);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        if (l3.d(byteArrayInputStream) != bArr.length - 2) {
            throw new h2((short) 50);
        }
        Vector vector = new Vector();
        while (byteArrayInputStream.available() > 0) {
            vector.add(q.a(byteArrayInputStream));
        }
        return vector;
    }

    public static int[] w(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        int d2 = l3.d(byteArrayInputStream);
        if (d2 < 2 || (d2 & 1) != 0) {
            throw new h2((short) 50);
        }
        int[] b2 = l3.b(d2 / 2, byteArrayInputStream);
        w2.a(byteArrayInputStream);
        return b2;
    }

    public static short[] x(byte[] bArr) {
        short[] d2 = l3.d(bArr);
        if (sdk.pendo.io.d5.a.b(d2, (short) 0)) {
            return d2;
        }
        throw new h2((short) 47);
    }

    public static v0[] y(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        if (bArr.length < 3 || bArr.length > 255 || (bArr.length & 1) == 0) {
            throw new h2((short) 50);
        }
        short d2 = l3.d(bArr, 0);
        if (d2 != bArr.length - 1) {
            throw new h2((short) 50);
        }
        int i2 = d2 / 2;
        v0[] v0VarArr = new v0[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            v0VarArr[i3] = l3.e(bArr, (i3 * 2) + 1);
        }
        return v0VarArr;
    }

    public static v0 z(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        if (bArr.length == 2) {
            return l3.e(bArr, 0);
        }
        throw new h2((short) 50);
    }

    public static void a(Hashtable hashtable, byte[] bArr) {
        hashtable.put(f, a(bArr));
    }

    public static void b(Hashtable hashtable, int i2) {
        hashtable.put(q, b(i2));
    }

    public static byte[] c() {
        return a();
    }

    public static byte[] d(Vector vector) {
        if (vector == null) {
            throw new h2((short) 80);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new d1(vector).a(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] e(Vector vector) {
        return f(vector);
    }

    public static byte[] f() {
        return a();
    }

    public static Vector g(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, f1779a);
        if (a2 == null) {
            return null;
        }
        return b(a2);
    }

    public static u0 h(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, f1779a);
        if (a2 == null) {
            return null;
        }
        return c(a2);
    }

    public static Vector i(Hashtable hashtable) {
        byte[] a2 = l3.a(hashtable, b);
        if (a2 == null) {
            return null;
        }
        return d(a2);
    }

    public static void a(Hashtable hashtable, Integer num) {
        hashtable.put(num, a());
    }

    public static void b(Hashtable hashtable, short[] sArr) {
        hashtable.put(h, b(sArr));
    }

    public static byte[] c(Vector vector) {
        if (vector == null || vector.isEmpty()) {
            return l3.d(0);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l3.a(0, (OutputStream) byteArrayOutputStream);
        for (int i2 = 0; i2 < vector.size(); i2++) {
            ((k0) vector.elementAt(i2)).a(byteArrayOutputStream);
        }
        return a(byteArrayOutputStream);
    }

    public static byte[] d() {
        return a();
    }

    public static byte[] e() {
        return a();
    }

    public static Hashtable f(Hashtable hashtable) {
        return hashtable == null ? new Hashtable() : hashtable;
    }

    public static boolean g(byte[] bArr) {
        return f(bArr);
    }

    public static boolean h(byte[] bArr) {
        return f(bArr);
    }

    public static Vector i(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        if (l3.d(byteArrayInputStream) != bArr.length - 2) {
            throw new h2((short) 50);
        }
        Vector vector = new Vector();
        while (byteArrayInputStream.available() > 0) {
            vector.addElement(k0.a(byteArrayInputStream));
        }
        return vector;
    }

    public static void a(Hashtable hashtable) {
        hashtable.put(i, b());
    }

    public static byte[] b(Vector vector) {
        if (vector == null || vector.isEmpty()) {
            throw new h2((short) 80);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l3.a(0, (OutputStream) byteArrayOutputStream);
        for (int i2 = 0; i2 < vector.size(); i2++) {
            l3.a(((sdk.pendo.io.c4.c) vector.elementAt(i2)).a(ASN1Encoding.DER), (OutputStream) byteArrayOutputStream);
        }
        return a(byteArrayOutputStream);
    }

    public static u0 c(byte[] bArr) {
        Vector b2 = b(bArr);
        if (b2.size() == 1) {
            return (u0) b2.elementAt(0);
        }
        throw new h2((short) 50);
    }

    public static Vector d(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        if (bArr.length < 5) {
            throw new h2((short) 50);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        if (l3.d(byteArrayInputStream) != bArr.length - 2) {
            throw new h2((short) 50);
        }
        Vector vector = new Vector();
        while (byteArrayInputStream.available() > 0) {
            byte[] a2 = l3.a(byteArrayInputStream, 1);
            sdk.pendo.io.c4.c a3 = sdk.pendo.io.c4.c.a(l3.h(a2));
            l3.a(a3, a2);
            vector.addElement(a3);
        }
        return vector;
    }

    public static byte[] e(byte[] bArr) {
        return l3.a(bArr, 1);
    }

    private static boolean f(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        if (bArr.length == 0) {
            return true;
        }
        throw new h2((short) 47);
    }

    public static void a(Hashtable hashtable, int i2) {
        hashtable.put(l, a(i2));
    }

    public static byte[] b() {
        return a();
    }

    public static void a(Hashtable hashtable, k0 k0Var) {
        hashtable.put(l, a(k0Var));
    }

    public static byte[] b(int i2) {
        return l3.d(i2);
    }

    public static void a(Hashtable hashtable, short s2) {
        hashtable.put(m, a(s2));
    }

    public static byte[] b(short[] sArr) {
        if (sArr == null || !sdk.pendo.io.d5.a.b(sArr, (short) 0)) {
            sArr = sdk.pendo.io.d5.a.c(sArr, (short) 0);
        }
        return l3.a(sArr);
    }

    public static void a(Hashtable hashtable, short[] sArr) {
        hashtable.put(r, a(sArr));
    }

    public static Vector b(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        if (l3.d(byteArrayInputStream) != bArr.length - 2) {
            throw new h2((short) 50);
        }
        Vector vector = new Vector();
        while (byteArrayInputStream.available() > 0) {
            vector.addElement(u0.a(byteArrayInputStream));
        }
        return vector;
    }

    public static void a(Hashtable hashtable, s0 s0Var) {
        hashtable.put(q, a(s0Var));
    }

    public static void a(Hashtable hashtable, p pVar) {
        hashtable.put(x, a(pVar));
    }

    public static void a(Hashtable hashtable, v0[] v0VarArr) {
        hashtable.put(A, a(v0VarArr));
    }

    public static void a(Hashtable hashtable, v0 v0Var) {
        hashtable.put(A, a(v0Var));
    }

    public static byte[] a(Vector vector) {
        if (vector == null || vector.size() < 1) {
            throw new h2((short) 80);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l3.a(0, (OutputStream) byteArrayOutputStream);
        for (int i2 = 0; i2 < vector.size(); i2++) {
            ((u0) vector.elementAt(i2)).a(byteArrayOutputStream);
        }
        return a(byteArrayOutputStream);
    }

    public static byte[] a(u0 u0Var) {
        Vector vector = new Vector();
        vector.addElement(u0Var);
        return a(vector);
    }

    public static byte[] a(byte[] bArr) {
        if (l3.g(bArr) || bArr.length >= 65536) {
            throw new h2((short) 80);
        }
        return l3.e(bArr);
    }

    public static byte[] a() {
        return l3.e;
    }

    public static byte[] a(int i2) {
        return l3.d(i2);
    }

    public static byte[] a(k0 k0Var) {
        if (k0Var == null) {
            throw new h2((short) 80);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        k0Var.a(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] a(short s2) {
        return l3.b(s2);
    }

    public static byte[] a(short[] sArr) {
        if (l3.b(sArr) || sArr.length > 255) {
            throw new h2((short) 80);
        }
        return l3.a(sArr);
    }

    public static byte[] a(s0 s0Var) {
        if (s0Var == null) {
            throw new h2((short) 80);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        s0Var.a(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] a(p pVar) {
        if (pVar == null) {
            throw new h2((short) 80);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        pVar.a(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] a(v0[] v0VarArr) {
        if (l3.b(v0VarArr) || v0VarArr.length > 127) {
            throw new h2((short) 80);
        }
        int length = v0VarArr.length;
        int i2 = length * 2;
        byte[] bArr = new byte[i2 + 1];
        l3.c(i2, bArr, 0);
        for (int i3 = 0; i3 < length; i3++) {
            l3.a(v0VarArr[i3], bArr, (i3 * 2) + 1);
        }
        return bArr;
    }

    public static byte[] a(v0 v0Var) {
        return l3.a(v0Var);
    }

    private static byte[] a(ByteArrayOutputStream byteArrayOutputStream) {
        int size = byteArrayOutputStream.size() - 2;
        l3.a(size);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        l3.a(size, byteArray, 0);
        return byteArray;
    }
}
