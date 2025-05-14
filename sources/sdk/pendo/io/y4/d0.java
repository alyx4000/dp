package sdk.pendo.io.y4;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    private final i1 f1772a;
    private final byte[] b;

    public d0(i1 i1Var, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'signature' cannot be null");
        }
        this.f1772a = i1Var;
        this.b = bArr;
    }

    public void a(OutputStream outputStream) {
        i1 i1Var = this.f1772a;
        if (i1Var != null) {
            i1Var.a(outputStream);
        }
        l3.a(this.b, outputStream);
    }

    public byte[] b() {
        return this.b;
    }

    public i1 a() {
        return this.f1772a;
    }

    public static d0 a(r1 r1Var, InputStream inputStream) {
        i1 i1Var;
        if (l3.c(r1Var)) {
            i1Var = i1.a(inputStream);
            if (i1Var.b() == 0) {
                throw new h2((short) 47);
            }
        } else {
            i1Var = null;
        }
        return new d0(i1Var, l3.b(inputStream));
    }
}
