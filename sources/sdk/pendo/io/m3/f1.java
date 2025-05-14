package sdk.pendo.io.m3;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
class f1 extends InputStream {
    private final f0 f;
    private final boolean s;
    private d t0;
    private InputStream u0;
    private boolean A = true;
    private int f0 = 0;

    f1(f0 f0Var, boolean z) {
        this.f = f0Var;
        this.s = z;
    }

    private d a() {
        g a2 = this.f.a();
        if (a2 == null) {
            if (!this.s || this.f0 == 0) {
                return null;
            }
            throw new IOException("expected octet-aligned bitstring, but found padBits: " + this.f0);
        }
        if (!(a2 instanceof d)) {
            throw new IOException("unknown object encountered: " + a2.getClass());
        }
        if (this.f0 == 0) {
            return (d) a2;
        }
        throw new IOException("only the last nested bitstring can have padding");
    }

    int b() {
        return this.f0;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.u0 == null) {
            if (!this.A) {
                return -1;
            }
            d a2 = a();
            this.t0 = a2;
            if (a2 == null) {
                return -1;
            }
            this.A = false;
            this.u0 = a2.f();
        }
        while (true) {
            int read = this.u0.read();
            if (read >= 0) {
                return read;
            }
            this.f0 = this.t0.d();
            d a3 = a();
            this.t0 = a3;
            if (a3 == null) {
                this.u0 = null;
                return -1;
            }
            this.u0 = a3.f();
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (this.u0 == null) {
            if (!this.A) {
                return -1;
            }
            d a2 = a();
            this.t0 = a2;
            if (a2 == null) {
                return -1;
            }
            this.A = false;
            this.u0 = a2.f();
        }
        while (true) {
            int read = this.u0.read(bArr, i + i3, i2 - i3);
            if (read >= 0) {
                i3 += read;
                if (i3 == i2) {
                    return i3;
                }
            } else {
                this.f0 = this.t0.d();
                d a3 = a();
                this.t0 = a3;
                if (a3 == null) {
                    this.u0 = null;
                    if (i3 < 1) {
                        return -1;
                    }
                    return i3;
                }
                this.u0 = a3.f();
            }
        }
    }
}
