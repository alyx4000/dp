package sdk.pendo.io.y4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/* loaded from: classes4.dex */
public class d1 {

    /* renamed from: a, reason: collision with root package name */
    protected Vector f1773a;

    public d1(Vector vector) {
        if (vector == null) {
            throw new NullPointerException("'serverNameList' cannot be null");
        }
        this.f1773a = vector;
    }

    private static short[] a(short[] sArr, short s) {
        if (sdk.pendo.io.d5.a.b(sArr, s)) {
            return null;
        }
        return sdk.pendo.io.d5.a.a(sArr, s);
    }

    public void a(OutputStream outputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        short[] sArr = l3.f;
        for (int i = 0; i < this.f1773a.size(); i++) {
            c1 c1Var = (c1) this.f1773a.elementAt(i);
            sArr = a(sArr, c1Var.b());
            if (sArr == null) {
                throw new h2((short) 80);
            }
            c1Var.a(byteArrayOutputStream);
        }
        l3.a(byteArrayOutputStream.size());
        l3.a(byteArrayOutputStream.size(), outputStream);
        sdk.pendo.io.f5.a.a(byteArrayOutputStream, outputStream);
    }

    public Vector a() {
        return this.f1773a;
    }

    public static d1 a(InputStream inputStream) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(l3.a(inputStream, 1));
        short[] sArr = l3.f;
        Vector vector = new Vector();
        while (byteArrayInputStream.available() > 0) {
            c1 a2 = c1.a(byteArrayInputStream);
            sArr = a(sArr, a2.b());
            if (sArr == null) {
                throw new h2((short) 47);
            }
            vector.addElement(a2);
        }
        return new d1(vector);
    }
}
