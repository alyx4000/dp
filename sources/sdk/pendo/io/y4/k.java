package sdk.pendo.io.y4;

import java.io.OutputStream;

/* loaded from: classes4.dex */
public class k extends OutputStream {
    private i f = new i();

    public i a() {
        return this.f;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f.a(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f.a(bArr, i, i2);
    }
}
