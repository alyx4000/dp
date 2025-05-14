package sdk.pendo.io.y4;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes4.dex */
public class b1 {
    private static final byte[] f = {-49, BuiltinOptions.ExpOptions, -83, BuiltinOptions.GeluOptions, -27, -102, BuiltinOptions.ScatterNdOptions, 17, -66, BuiltinOptions.DivOptions, -116, 2, BuiltinOptions.SqueezeOptions, BuiltinOptions.BatchMatMulOptions, -72, -111, -62, -94, 17, BuiltinOptions.PadOptions, BuiltinOptions.ATan2Options, -69, -116, BuiltinOptions.DepthToSpaceOptions, 7, -98, 9, -30, -56, -88, BuiltinOptions.TileOptions, -100};

    /* renamed from: a, reason: collision with root package name */
    private final v0 f1768a;
    private final byte[] b;
    private final byte[] c;
    private final int d;
    private final Hashtable e;

    public b1(v0 v0Var, byte[] bArr, byte[] bArr2, int i, Hashtable hashtable) {
        this.f1768a = v0Var;
        this.b = bArr;
        this.c = bArr2;
        this.d = i;
        this.e = hashtable;
    }

    public void a(r1 r1Var, OutputStream outputStream) {
        l3.a(this.f1768a, outputStream);
        outputStream.write(this.b);
        l3.c(this.c, outputStream);
        l3.a(this.d, outputStream);
        l3.a((short) 0, outputStream);
        w2.a(outputStream, this.e);
    }

    public Hashtable b() {
        return this.e;
    }

    public byte[] c() {
        return this.b;
    }

    public byte[] d() {
        return this.c;
    }

    public v0 e() {
        return this.f1768a;
    }

    public boolean f() {
        return sdk.pendo.io.d5.a.a(f, this.b);
    }

    public b1(byte[] bArr, int i, Hashtable hashtable) {
        this(v0.f, sdk.pendo.io.d5.a.a(f), bArr, i, hashtable);
    }

    public int a() {
        return this.d;
    }

    public static b1 a(ByteArrayInputStream byteArrayInputStream) {
        v0 h = l3.h(byteArrayInputStream);
        byte[] a2 = l3.a(32, byteArrayInputStream);
        byte[] a3 = l3.a(byteArrayInputStream, 0, 32);
        int d = l3.d(byteArrayInputStream);
        if (l3.g(byteArrayInputStream) == 0) {
            return new b1(h, a2, a3, d, w2.d(byteArrayInputStream));
        }
        throw new h2((short) 47);
    }
}
