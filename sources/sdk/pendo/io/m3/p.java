package sdk.pendo.io.m3;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;
import org.bouncycastle.asn1.BERTags;

/* loaded from: classes6.dex */
public class p extends FilterInputStream {
    private final byte[][] A;
    private final int f;
    private final boolean s;

    public p(InputStream inputStream, int i) {
        this(inputStream, i, false);
    }

    c a(h hVar) {
        int b = hVar.b();
        c[] cVarArr = new c[b];
        for (int i = 0; i != b; i++) {
            g a2 = hVar.a(i);
            if (!(a2 instanceof c)) {
                throw new j("unknown object encountered in constructed BIT STRING: " + a2.getClass());
            }
            cVarArr[i] = (c) a2;
        }
        return new u0(cVarArr);
    }

    w b(h hVar) {
        int b = hVar.b();
        w[] wVarArr = new w[b];
        for (int i = 0; i != b; i++) {
            g a2 = hVar.a(i);
            if (!(a2 instanceof w)) {
                throw new j("unknown object encountered in constructed OCTET STRING: " + a2.getClass());
            }
            wVarArr[i] = (w) a2;
        }
        return new x0(wVarArr);
    }

    h e() {
        a0 b = b();
        if (b == null) {
            return new h(0);
        }
        h hVar = new h();
        do {
            hVar.a(b);
            b = b();
        } while (b != null);
        return hVar;
    }

    public p(InputStream inputStream, int i, boolean z) {
        this(inputStream, i, z, new byte[11][]);
    }

    protected a0 a(int i, int i2, int i3) {
        q2 q2Var = new q2(this, i3, this.f);
        if ((i & BERTags.FLAGS) == 0) {
            return a(i2, q2Var, this.A);
        }
        int i4 = i & 192;
        if (i4 != 0) {
            return a(i4, i2, (i & 32) != 0, q2Var);
        }
        if (i2 == 3) {
            return a(b(q2Var));
        }
        if (i2 == 4) {
            return b(b(q2Var));
        }
        if (i2 == 8) {
            return i2.a(b(q2Var)).o();
        }
        if (i2 == 16) {
            return q2Var.b() < 1 ? i2.f1390a : this.s ? new u2(q2Var.e()) : i2.a(b(q2Var));
        }
        if (i2 == 17) {
            return i2.b(b(q2Var));
        }
        throw new IOException("unknown tag " + i2 + " encountered");
    }

    public a0 b() {
        int read = read();
        if (read <= 0) {
            if (read != 0) {
                return null;
            }
            throw new IOException("unexpected end-of-contents marker");
        }
        int a2 = a(this, read);
        int a3 = a();
        if (a3 >= 0) {
            try {
                return a(read, a2, a3);
            } catch (IllegalArgumentException e) {
                throw new j("corrupted stream detected", e);
            }
        }
        if ((read & 32) == 0) {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
        f0 f0Var = new f0(new s2(this, this.f), this.f, this.A);
        int i = read & 192;
        if (i != 0) {
            return f0Var.a(i, a2);
        }
        if (a2 == 3) {
            return v0.a(f0Var);
        }
        if (a2 == 4) {
            return y0.a(f0Var);
        }
        if (a2 == 8) {
            return l1.a(f0Var);
        }
        if (a2 == 16) {
            return a1.a(f0Var);
        }
        if (a2 == 17) {
            return c1.a(f0Var);
        }
        throw new IOException("unknown BER object encountered");
    }

    private p(InputStream inputStream, int i, boolean z, byte[][] bArr) {
        super(inputStream);
        this.f = i;
        this.s = z;
        this.A = bArr;
    }

    static a0 a(int i, q2 q2Var, byte[][] bArr) {
        switch (i) {
            case 1:
                return e.b(a(q2Var, bArr));
            case 2:
                return q.b(q2Var.e());
            case 3:
                return c.b(q2Var.e());
            case 4:
                return w.b(q2Var.e());
            case 5:
                return r.b(q2Var.e());
            case 6:
                return v.a(a(q2Var, bArr), true);
            case 7:
                return u.b(q2Var.e());
            case 8:
            case 9:
            case 11:
            case 14:
            case 15:
            case 16:
            case 17:
            case 29:
            default:
                throw new IOException("unknown tag " + i + " encountered");
            case 10:
                return i.a(a(q2Var, bArr), true);
            case 12:
                return m0.b(q2Var.e());
            case 13:
                return c0.a(q2Var.e(), false);
            case 18:
                return s.b(q2Var.e());
            case 19:
                return b0.b(q2Var.e());
            case 20:
                return h0.b(q2Var.e());
            case 21:
                return q0.b(q2Var.e());
            case 22:
                return o.b(q2Var.e());
            case 23:
                return l0.b(q2Var.e());
            case 24:
                return m.b(q2Var.e());
            case 25:
                return n.b(q2Var.e());
            case 26:
                return r0.b(q2Var.e());
            case 27:
                return l.b(q2Var.e());
            case 28:
                return n0.b(q2Var.e());
            case 30:
                return b.a(a(q2Var));
        }
    }

    h b(q2 q2Var) {
        int b = q2Var.b();
        return b < 1 ? new h(0) : new p(q2Var, b, this.s, this.A).e();
    }

    public p(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }

    private static char[] a(q2 q2Var) {
        int i;
        int b = q2Var.b();
        if ((b & 1) != 0) {
            throw new IOException("malformed BMPString encoding encountered");
        }
        int i2 = b / 2;
        char[] cArr = new char[i2];
        byte[] bArr = new byte[8];
        int i3 = 0;
        int i4 = 0;
        while (b >= 8) {
            if (sdk.pendo.io.f5.a.a(q2Var, bArr, 0, 8) != 8) {
                throw new EOFException("EOF encountered in middle of BMPString");
            }
            cArr[i4] = (char) ((bArr[0] << 8) | (bArr[1] & UByte.MAX_VALUE));
            cArr[i4 + 1] = (char) ((bArr[2] << 8) | (bArr[3] & UByte.MAX_VALUE));
            cArr[i4 + 2] = (char) ((bArr[4] << 8) | (bArr[5] & UByte.MAX_VALUE));
            cArr[i4 + 3] = (char) ((bArr[6] << 8) | (bArr[7] & UByte.MAX_VALUE));
            i4 += 4;
            b -= 8;
        }
        if (b > 0) {
            if (sdk.pendo.io.f5.a.a(q2Var, bArr, 0, b) != b) {
                throw new EOFException("EOF encountered in middle of BMPString");
            }
            while (true) {
                int i5 = i3 + 1;
                int i6 = i5 + 1;
                i = i4 + 1;
                cArr[i4] = (char) ((bArr[i3] << 8) | (bArr[i5] & UByte.MAX_VALUE));
                if (i6 >= b) {
                    break;
                }
                i3 = i6;
                i4 = i;
            }
            i4 = i;
        }
        if (q2Var.b() == 0 && i2 == i4) {
            return cArr;
        }
        throw new IllegalStateException();
    }

    public p(byte[] bArr, boolean z) {
        this(new ByteArrayInputStream(bArr), bArr.length, z);
    }

    private static byte[] a(q2 q2Var, byte[][] bArr) {
        int b = q2Var.b();
        if (b >= bArr.length) {
            return q2Var.e();
        }
        byte[] bArr2 = bArr[b];
        if (bArr2 == null) {
            bArr2 = new byte[b];
            bArr[b] = bArr2;
        }
        q2Var.a(bArr2);
        return bArr2;
    }

    protected int a() {
        return a((InputStream) this, this.f, false);
    }

    static int a(InputStream inputStream, int i, boolean z) {
        int read = inputStream.read();
        if ((read >>> 7) == 0) {
            return read;
        }
        if (128 == read) {
            return -1;
        }
        if (read < 0) {
            throw new EOFException("EOF found when length expected");
        }
        if (255 == read) {
            throw new IOException("invalid long form definite-length 0xFF");
        }
        int i2 = read & 127;
        int i3 = 0;
        int i4 = 0;
        do {
            int read2 = inputStream.read();
            if (read2 < 0) {
                throw new EOFException("EOF found reading length");
            }
            if ((i3 >>> 23) != 0) {
                throw new IOException("long form definite-length more than 31 bits");
            }
            i3 = (i3 << 8) + read2;
            i4++;
        } while (i4 < i2);
        if (i3 < i || z) {
            return i3;
        }
        throw new IOException("corrupted stream - out of bounds length found: " + i3 + " >= " + i);
    }

    static int a(InputStream inputStream, int i) {
        int i2 = i & 31;
        if (i2 != 31) {
            return i2;
        }
        int read = inputStream.read();
        if (read < 31) {
            if (read < 0) {
                throw new EOFException("EOF found inside tag value.");
            }
            throw new IOException("corrupted stream - high tag number < 31 found");
        }
        int i3 = read & 127;
        if (i3 == 0) {
            throw new IOException("corrupted stream - invalid high tag number found");
        }
        while ((read & 128) != 0) {
            if ((i3 >>> 24) != 0) {
                throw new IOException("Tag number more than 31 bits");
            }
            int i4 = i3 << 7;
            int read2 = inputStream.read();
            if (read2 < 0) {
                throw new EOFException("EOF found inside tag value.");
            }
            i3 = i4 | (read2 & 127);
            read = read2;
        }
        return i3;
    }

    a0 a(int i, int i2, boolean z, q2 q2Var) {
        return !z ? j0.a(i, i2, q2Var.e()) : j0.a(i, i2, b(q2Var));
    }
}
