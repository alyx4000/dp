package sdk.pendo.io.y4;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    protected short f1793a;
    protected Object b;

    public p(short s, Object obj) {
        if (!a(s, obj)) {
            throw new IllegalArgumentException("'request' is not an instance of the correct type");
        }
        this.f1793a = s;
        this.b = obj;
    }

    public void a(OutputStream outputStream) {
        l3.a(this.f1793a, outputStream);
        if (this.f1793a != 1) {
            throw new h2((short) 80);
        }
        ((r0) this.b).a(outputStream);
    }

    protected static boolean a(short s, Object obj) {
        if (s == 1) {
            return obj instanceof r0;
        }
        throw new IllegalArgumentException("'statusType' is an unsupported CertificateStatusType");
    }

    public static p a(InputStream inputStream) {
        short g = l3.g(inputStream);
        if (g == 1) {
            return new p(g, r0.a(inputStream));
        }
        throw new h2((short) 50);
    }
}
