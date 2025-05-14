package sdk.pendo.io.y4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;

/* loaded from: classes4.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private final v0 f1798a;
    private final byte[] b;
    private final byte[] c;
    private final byte[] d;
    private final int[] e;
    private final Hashtable f;
    private final int g;

    public s(v0 v0Var, byte[] bArr, byte[] bArr2, byte[] bArr3, int[] iArr, Hashtable hashtable, int i) {
        this.f1798a = v0Var;
        this.b = bArr;
        this.c = bArr2;
        this.d = bArr3;
        this.e = iArr;
        this.f = hashtable;
        this.g = i;
    }

    public void a(r1 r1Var, OutputStream outputStream) {
        if (this.g < 0) {
            throw new h2((short) 80);
        }
        l3.a(this.f1798a, outputStream);
        outputStream.write(this.b);
        l3.c(this.c, outputStream);
        byte[] bArr = this.d;
        if (bArr != null) {
            l3.c(bArr, outputStream);
        }
        l3.b(this.e, outputStream);
        l3.b(new short[]{0}, outputStream);
        w2.a(outputStream, this.f, this.g);
    }

    public int[] b() {
        return this.e;
    }

    public Hashtable c() {
        return this.f;
    }

    public byte[] d() {
        return this.b;
    }

    public byte[] e() {
        return this.c;
    }

    public v0 f() {
        return this.f1798a;
    }

    public static s b(ByteArrayInputStream byteArrayInputStream, OutputStream outputStream) {
        try {
            return a(byteArrayInputStream, outputStream);
        } catch (h2 e) {
            throw e;
        } catch (IOException e2) {
            throw new h2((short) 50, (Throwable) e2);
        }
    }

    public int a() {
        return this.g;
    }

    private static s a(ByteArrayInputStream byteArrayInputStream, OutputStream outputStream) {
        byte[] bArr;
        Hashtable hashtable;
        InputStream bVar = outputStream != null ? new sdk.pendo.io.f5.b(byteArrayInputStream, outputStream) : byteArrayInputStream;
        v0 h = l3.h(bVar);
        byte[] a2 = l3.a(32, bVar);
        byte[] a3 = l3.a(bVar, 0, 32);
        if (outputStream != null) {
            bArr = l3.a(byteArrayInputStream, 0, v0.i.d(h) ? 255 : 32);
        } else {
            bArr = null;
        }
        int d = l3.d(bVar);
        if (d < 2 || (d & 1) != 0 || byteArrayInputStream.available() < d) {
            throw new h2((short) 50);
        }
        int[] b = l3.b(d / 2, bVar);
        if (!sdk.pendo.io.d5.a.b(l3.d(bVar, 1), (short) 0)) {
            throw new h2((short) 40);
        }
        if (byteArrayInputStream.available() > 0) {
            byte[] b2 = l3.b(bVar);
            w2.a(byteArrayInputStream);
            hashtable = w2.d(b2);
        } else {
            hashtable = null;
        }
        return new s(h, a2, a3, bArr, b, hashtable, -1);
    }
}
