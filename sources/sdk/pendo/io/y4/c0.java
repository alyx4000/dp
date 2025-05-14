package sdk.pendo.io.y4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
class c0 extends ByteArrayOutputStream {
    c0() {
    }

    void a(OutputStream outputStream) {
        sdk.pendo.io.f5.a.a(new ByteArrayInputStream(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count), outputStream);
    }

    void a(sdk.pendo.io.z4.t tVar) {
        tVar.b(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
    }
}
