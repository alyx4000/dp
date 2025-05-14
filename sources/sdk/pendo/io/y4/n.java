package sdk.pendo.io.y4;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encoding;

/* loaded from: classes4.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    protected final byte[] f1790a;
    protected final short[] b;
    protected final Vector c;
    protected final Vector d;
    protected final Vector e;

    public n(byte[] bArr, Vector vector, Vector vector2, Vector vector3) {
        this(bArr, null, a(vector, (short) 80), vector2, vector3);
    }

    private static Vector a(Vector vector, short s) {
        if (vector != null) {
            return vector;
        }
        throw new h2(s, "'signature_algorithms' is required");
    }

    public byte[] b() {
        return l3.a(this.f1790a);
    }

    public short[] c() {
        return this.b;
    }

    public Vector d() {
        return this.c;
    }

    public Vector e() {
        return this.d;
    }

    private n(byte[] bArr, short[] sArr, Vector vector, Vector vector2, Vector vector3) {
        if (bArr != null && !l3.q(bArr.length)) {
            throw new IllegalArgumentException("'certificateRequestContext' cannot be longer than 255");
        }
        if (sArr != null && (sArr.length < 1 || !l3.q(sArr.length))) {
            throw new IllegalArgumentException("'certificateTypes' should have length from 1 to 255");
        }
        this.f1790a = l3.a(bArr);
        this.b = sArr;
        this.c = vector;
        this.d = vector2;
        this.e = vector3;
    }

    public void a(r1 r1Var, OutputStream outputStream) {
        v0 a2 = r1Var.a();
        boolean d = l3.d(a2);
        boolean e = l3.e(a2);
        byte[] bArr = this.f1790a;
        if (e == (bArr != null)) {
            short[] sArr = this.b;
            if (e == (sArr == null)) {
                if (d == (this.c != null) && (e || this.d == null)) {
                    if (e) {
                        l3.c(bArr, outputStream);
                        Hashtable hashtable = new Hashtable();
                        g2.f(hashtable, this.c);
                        Vector vector = this.d;
                        if (vector != null) {
                            g2.e(hashtable, vector);
                        }
                        Vector vector2 = this.e;
                        if (vector2 != null) {
                            g2.b(hashtable, vector2);
                        }
                        l3.a(w2.a(hashtable), outputStream);
                        return;
                    }
                    l3.b(sArr, outputStream);
                    if (d) {
                        l3.a(this.c, outputStream);
                    }
                    Vector vector3 = this.e;
                    if (vector3 == null || vector3.isEmpty()) {
                        l3.a(0, outputStream);
                        return;
                    }
                    Vector vector4 = new Vector(this.e.size());
                    int i = 0;
                    for (int i2 = 0; i2 < this.e.size(); i2++) {
                        byte[] a3 = ((sdk.pendo.io.c4.c) this.e.elementAt(i2)).a(ASN1Encoding.DER);
                        vector4.addElement(a3);
                        i += a3.length + 2;
                    }
                    l3.a(i);
                    l3.a(i, outputStream);
                    for (int i3 = 0; i3 < vector4.size(); i3++) {
                        l3.a((byte[]) vector4.elementAt(i3), outputStream);
                    }
                    return;
                }
            }
        }
        throw new IllegalStateException();
    }

    public n(short[] sArr, Vector vector, Vector vector2) {
        this(null, sArr, vector, null, vector2);
    }

    public Vector a() {
        return this.e;
    }

    public boolean a(byte[] bArr) {
        return sdk.pendo.io.d5.a.a(this.f1790a, bArr);
    }

    public static n a(r1 r1Var, InputStream inputStream) {
        v0 a2 = r1Var.a();
        if (l3.e(a2)) {
            byte[] c = l3.c(inputStream);
            Hashtable a3 = w2.a(13, l3.b(inputStream));
            return new n(c, a(g2.u(a3), (short) 109), g2.t(a3), g2.i(a3));
        }
        boolean d = l3.d(a2);
        short[] d2 = l3.d(inputStream, 1);
        Vector vector = null;
        Vector a4 = d ? l3.a(inputStream) : null;
        byte[] b = l3.b(inputStream);
        if (b.length > 0) {
            Vector vector2 = new Vector();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b);
            do {
                byte[] a5 = l3.a(byteArrayInputStream, 1);
                sdk.pendo.io.c4.c a6 = sdk.pendo.io.c4.c.a(l3.h(a5));
                l3.a(a6, a5);
                vector2.addElement(a6);
            } while (byteArrayInputStream.available() > 0);
            vector = vector2;
        }
        return new n(d2, a4, vector);
    }
}
