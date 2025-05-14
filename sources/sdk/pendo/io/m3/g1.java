package sdk.pendo.io.m3;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
class g1 extends InputStream {
    private InputStream A;
    private final f0 f;
    private boolean s = true;

    g1(f0 f0Var) {
        this.f = f0Var;
    }

    private x a() {
        g a2 = this.f.a();
        if (a2 == null) {
            return null;
        }
        if (a2 instanceof x) {
            return (x) a2;
        }
        throw new IOException("unknown object encountered: " + a2.getClass());
    }

    @Override // java.io.InputStream
    public int read() {
        x a2;
        if (this.A == null) {
            if (!this.s || (a2 = a()) == null) {
                return -1;
            }
            this.s = false;
            this.A = a2.a();
        }
        while (true) {
            int read = this.A.read();
            if (read >= 0) {
                return read;
            }
            x a3 = a();
            if (a3 == null) {
                this.A = null;
                return -1;
            }
            this.A = a3.a();
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        x a2;
        int i3 = 0;
        if (this.A == null) {
            if (!this.s || (a2 = a()) == null) {
                return -1;
            }
            this.s = false;
            this.A = a2.a();
        }
        while (true) {
            int read = this.A.read(bArr, i + i3, i2 - i3);
            if (read >= 0) {
                i3 += read;
                if (i3 == i2) {
                    return i3;
                }
            } else {
                x a3 = a();
                if (a3 == null) {
                    this.A = null;
                    if (i3 < 1) {
                        return -1;
                    }
                    return i3;
                }
                this.A = a3.a();
            }
        }
    }
}
