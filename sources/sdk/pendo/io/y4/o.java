package sdk.pendo.io.y4;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encoding;

/* loaded from: classes4.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    protected short f1791a;
    protected Object b;

    public o(short s, Object obj) {
        if (!a(s, obj)) {
            throw new IllegalArgumentException("'response' is not an instance of the correct type");
        }
        this.f1791a = s;
        this.b = obj;
    }

    public void a(OutputStream outputStream) {
        l3.a(this.f1791a, outputStream);
        short s = this.f1791a;
        if (s == 1) {
            l3.b(((sdk.pendo.io.w3.a) this.b).a(ASN1Encoding.DER), outputStream);
            return;
        }
        if (s != 2) {
            throw new h2((short) 80);
        }
        Vector vector = (Vector) this.b;
        int size = vector.size();
        Vector vector2 = new Vector(size);
        long j = 0;
        for (int i = 0; i < size; i++) {
            sdk.pendo.io.w3.a aVar = (sdk.pendo.io.w3.a) vector.elementAt(i);
            if (aVar == null) {
                vector2.addElement(l3.e);
            } else {
                vector2.addElement(aVar.a(ASN1Encoding.DER));
                j += r8.length;
            }
            j += 3;
        }
        l3.a(j);
        l3.b((int) j, outputStream);
        for (int i2 = 0; i2 < size; i2++) {
            l3.b((byte[]) vector2.elementAt(i2), outputStream);
        }
    }

    public Vector b() {
        if (a((short) 2, this.b)) {
            return (Vector) this.b;
        }
        throw new IllegalStateException("'response' is not an OCSPResponseList");
    }

    public short c() {
        return this.f1791a;
    }

    public sdk.pendo.io.w3.a a() {
        if (a((short) 1, this.b)) {
            return (sdk.pendo.io.w3.a) this.b;
        }
        throw new IllegalStateException("'response' is not an OCSPResponse");
    }

    protected static boolean a(short s, Object obj) {
        if (s == 1) {
            return obj instanceof sdk.pendo.io.w3.a;
        }
        if (s == 2) {
            return a(obj);
        }
        throw new IllegalArgumentException("'statusType' is an unsupported CertificateStatusType");
    }

    protected static boolean a(Object obj) {
        Vector vector;
        int size;
        if (!(obj instanceof Vector) || (size = (vector = (Vector) obj).size()) < 1) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            Object elementAt = vector.elementAt(i);
            if (elementAt != null && !(elementAt instanceof sdk.pendo.io.w3.a)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static o a(r1 r1Var, InputStream inputStream) {
        sdk.pendo.io.w3.a aVar;
        a1 d = r1Var.d();
        l x = d.x();
        if (x == null || x.d() || x.b() != 0) {
            throw new h2((short) 80);
        }
        int c = x.c();
        int G = d.G();
        short g = l3.g(inputStream);
        if (g == 1) {
            a(1, G);
            aVar = a(l3.b(inputStream, 1));
        } else {
            if (g != 2) {
                throw new h2((short) 50);
            }
            a(2, G);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(l3.b(inputStream, 1));
            Vector vector = new Vector();
            while (byteArrayInputStream.available() > 0) {
                if (vector.size() >= c) {
                    throw new h2((short) 47);
                }
                int e = l3.e(byteArrayInputStream);
                vector.addElement(e < 1 ? null : a(l3.a(e, byteArrayInputStream)));
            }
            vector.trimToSize();
            aVar = vector;
        }
        return new o(g, aVar);
    }

    protected static sdk.pendo.io.w3.a a(byte[] bArr) {
        sdk.pendo.io.w3.a a2 = sdk.pendo.io.w3.a.a(l3.h(bArr));
        l3.a(a2, bArr);
        return a2;
    }

    protected static void a(int i, int i2) {
        if (i2 < i) {
            throw new h2((short) 50);
        }
    }
}
