package sdk.pendo.io.y4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    protected short f1795a;
    protected Object b;

    public q(short s, Object obj) {
        if (!a(s, obj)) {
            throw new IllegalArgumentException("'request' is not an instance of the correct type");
        }
        this.f1795a = s;
        this.b = obj;
    }

    public void a(OutputStream outputStream) {
        l3.a(this.f1795a, outputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        short s = this.f1795a;
        if (s != 1 && s != 2) {
            throw new h2((short) 80);
        }
        ((r0) this.b).a(byteArrayOutputStream);
        l3.a(byteArrayOutputStream.toByteArray(), outputStream);
    }

    protected static boolean a(short s, Object obj) {
        if (s == 1 || s == 2) {
            return obj instanceof r0;
        }
        throw new IllegalArgumentException("'statusType' is an unsupported CertificateStatusType");
    }

    public static q a(InputStream inputStream) {
        short g = l3.g(inputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(l3.b(inputStream));
        if (g != 1 && g != 2) {
            throw new h2((short) 50);
        }
        r0 a2 = r0.a(byteArrayInputStream);
        w2.a(byteArrayInputStream);
        return new q(g, a2);
    }
}
