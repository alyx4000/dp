package sdk.pendo.io.y4;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class w0 {

    /* renamed from: a, reason: collision with root package name */
    protected byte[] f1806a;
    protected long b;

    public w0(byte[] bArr, long j) {
        if (bArr == null) {
            throw new IllegalArgumentException("'identity' cannot be null");
        }
        if (bArr.length < 1 || !l3.o(bArr.length)) {
            throw new IllegalArgumentException("'identity' should have length from 1 to 65535");
        }
        if (!l3.c(j)) {
            throw new IllegalArgumentException("'obfuscatedTicketAge' should be a uint32");
        }
        this.f1806a = bArr;
        this.b = j;
    }

    public void a(OutputStream outputStream) {
        l3.a(this.f1806a, outputStream);
        l3.a(this.b, outputStream);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof w0)) {
            return false;
        }
        w0 w0Var = (w0) obj;
        return this.b == w0Var.b && sdk.pendo.io.d5.a.d(this.f1806a, w0Var.f1806a);
    }

    public int hashCode() {
        int b = sdk.pendo.io.d5.a.b(this.f1806a);
        long j = this.b;
        return (b ^ ((int) j)) ^ ((int) (j >>> 32));
    }

    public int a() {
        return this.f1806a.length + 6;
    }

    public static w0 a(InputStream inputStream) {
        return new w0(l3.a(inputStream, 1), l3.f(inputStream));
    }
}
