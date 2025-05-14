package sdk.pendo.io.z4;

import java.io.OutputStream;

/* loaded from: classes4.dex */
public class u extends OutputStream {
    protected t f;

    public u(t tVar) {
        this.f = tVar;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f.b(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f.b(bArr, i, i2);
    }
}
