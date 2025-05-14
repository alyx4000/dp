package sdk.pendo.io.y4;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class q0 {

    /* renamed from: a, reason: collision with root package name */
    protected long f1796a;
    protected byte[] b;

    public q0(long j, byte[] bArr) {
        this.f1796a = j;
        this.b = bArr;
    }

    public void a(OutputStream outputStream) {
        l3.a(this.f1796a, outputStream);
        l3.a(this.b, outputStream);
    }

    public static q0 a(InputStream inputStream) {
        return new q0(l3.f(inputStream), l3.b(inputStream));
    }
}
