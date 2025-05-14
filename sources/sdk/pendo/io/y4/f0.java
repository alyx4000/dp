package sdk.pendo.io.y4;

import java.io.ByteArrayInputStream;

/* loaded from: classes4.dex */
public class f0 extends ByteArrayInputStream {
    f0(byte[] bArr, int i, int i2) {
        super(bArr, i, i2);
    }

    public void a(sdk.pendo.io.z4.t tVar) {
        byte[] bArr = ((ByteArrayInputStream) this).buf;
        int i = ((ByteArrayInputStream) this).mark;
        tVar.b(bArr, i, ((ByteArrayInputStream) this).count - i);
    }

    void b(sdk.pendo.io.z4.t tVar, int i) {
        tVar.b(((ByteArrayInputStream) this).buf, ((ByteArrayInputStream) this).count - i, i);
    }

    @Override // java.io.ByteArrayInputStream, java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.ByteArrayInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    void a(sdk.pendo.io.z4.t tVar, int i) {
        byte[] bArr = ((ByteArrayInputStream) this).buf;
        int i2 = ((ByteArrayInputStream) this).mark;
        tVar.b(bArr, i2, (((ByteArrayInputStream) this).count - i2) - i);
    }
}
