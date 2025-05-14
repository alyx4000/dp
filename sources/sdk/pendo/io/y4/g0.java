package sdk.pendo.io.y4;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
class g0 extends ByteArrayOutputStream {
    g0(short s) {
        this(s, 60);
    }

    static int a(int i) {
        return i + 4;
    }

    g0(short s, int i) {
        super(a(i));
        l3.a(s);
        l3.a(s, (OutputStream) this);
        ((ByteArrayOutputStream) this).count += 3;
    }

    void a(j2 j2Var, int i) {
        int i2 = (((ByteArrayOutputStream) this).count - 4) + i;
        l3.b(i2);
        l3.b(i2, ((ByteArrayOutputStream) this).buf, 1);
        j2Var.b(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
    }

    void a(w2 w2Var) {
        int i = ((ByteArrayOutputStream) this).count - 4;
        l3.b(i);
        l3.b(i, ((ByteArrayOutputStream) this).buf, 1);
        w2Var.h(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
        ((ByteArrayOutputStream) this).buf = null;
    }

    static void a(w2 w2Var, short s, byte[] bArr) {
        g0 g0Var = new g0(s, bArr.length);
        g0Var.write(bArr);
        g0Var.a(w2Var);
    }

    void a(p1 p1Var, j2 j2Var, int i) {
        if (i > 0) {
            j2Var.b(((ByteArrayOutputStream) this).buf, ((ByteArrayOutputStream) this).count - i, i);
        }
        p1Var.h(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
        ((ByteArrayOutputStream) this).buf = null;
    }
}
