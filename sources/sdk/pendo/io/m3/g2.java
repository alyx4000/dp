package sdk.pendo.io.m3;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class g2 implements d {
    private final q2 f;
    private int s = 0;

    g2(q2 q2Var) {
        this.f = q2Var;
    }

    private InputStream a(boolean z) {
        int b = this.f.b();
        if (b < 1) {
            throw new IllegalStateException("content octets cannot be empty");
        }
        int read = this.f.read();
        this.s = read;
        if (read > 0) {
            if (b < 2) {
                throw new IllegalStateException("zero length data with non-zero pad bits");
            }
            if (read > 7) {
                throw new IllegalStateException("pad bits cannot be greater than 7 or less than 0");
            }
            if (z) {
                throw new IOException("expected octet-aligned bitstring, but found padBits: " + this.s);
            }
        }
        return this.f;
    }

    @Override // sdk.pendo.io.m3.g
    public a0 b() {
        try {
            return e();
        } catch (IOException e) {
            throw new z("IOException converting stream to byte array: " + e.getMessage(), e);
        }
    }

    @Override // sdk.pendo.io.m3.d
    public int d() {
        return this.s;
    }

    @Override // sdk.pendo.io.m3.r2
    public a0 e() {
        return c.b(this.f.e());
    }

    @Override // sdk.pendo.io.m3.d
    public InputStream f() {
        return a(false);
    }
}
