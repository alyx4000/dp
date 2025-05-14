package sdk.pendo.io.y4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encoding;

/* loaded from: classes4.dex */
public class r0 {

    /* renamed from: a, reason: collision with root package name */
    protected Vector f1797a;
    protected sdk.pendo.io.e4.e b;

    public r0(Vector vector, sdk.pendo.io.e4.e eVar) {
        this.f1797a = vector;
        this.b = eVar;
    }

    public void a(OutputStream outputStream) {
        Vector vector = this.f1797a;
        if (vector == null || vector.isEmpty()) {
            l3.a(0, outputStream);
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i = 0; i < this.f1797a.size(); i++) {
                l3.a(((sdk.pendo.io.w3.c) this.f1797a.elementAt(i)).a(ASN1Encoding.DER), (OutputStream) byteArrayOutputStream);
            }
            l3.a(byteArrayOutputStream.size());
            l3.a(byteArrayOutputStream.size(), outputStream);
            sdk.pendo.io.f5.a.a(byteArrayOutputStream, outputStream);
        }
        sdk.pendo.io.e4.e eVar = this.b;
        if (eVar == null) {
            l3.a(0, outputStream);
            return;
        }
        byte[] a2 = eVar.a(ASN1Encoding.DER);
        l3.a(a2.length);
        l3.a(a2.length, outputStream);
        outputStream.write(a2);
    }

    public static r0 a(InputStream inputStream) {
        sdk.pendo.io.e4.e eVar;
        Vector vector = new Vector();
        byte[] b = l3.b(inputStream);
        if (b.length > 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b);
            do {
                byte[] a2 = l3.a(byteArrayInputStream, 1);
                sdk.pendo.io.w3.c a3 = sdk.pendo.io.w3.c.a(l3.h(a2));
                l3.a(a3, a2);
                vector.addElement(a3);
            } while (byteArrayInputStream.available() > 0);
        }
        byte[] b2 = l3.b(inputStream);
        if (b2.length > 0) {
            eVar = sdk.pendo.io.e4.e.a(l3.h(b2));
            l3.a(eVar, b2);
        } else {
            eVar = null;
        }
        return new r0(vector, eVar);
    }
}
