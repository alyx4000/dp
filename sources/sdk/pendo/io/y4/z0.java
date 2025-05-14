package sdk.pendo.io.y4;

import java.io.InputStream;
import java.io.OutputStream;
import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes4.dex */
class z0 {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f1814a = {BuiltinOptions.ZerosLikeOptions, BuiltinOptions.SquaredDifferenceOptions, BuiltinOptions.AbsOptions, BuiltinOptions.CosOptions};
    private static final byte[] b = {BuiltinOptions.GatherNdOptions, BuiltinOptions.AddNOptions, BuiltinOptions.RankOptions, BuiltinOptions.AddNOptions};
    private static final byte[] c = a(BuiltinOptions.NotEqualOptions, 48);
    private static final byte[] d = a(BuiltinOptions.IfOptions, 48);

    static byte[] a(j2 j2Var, boolean z) {
        sdk.pendo.io.z4.t f = j2Var.f();
        byte[] bArr = z ? b : f1814a;
        f.b(bArr, 0, bArr.length);
        return f.c();
    }

    static void a(r1 r1Var, sdk.pendo.io.z4.t tVar, sdk.pendo.io.z4.t tVar2) {
        byte[] a2 = r1Var.b().a(r1Var.d().q()).a();
        a(a2, tVar, 48);
        a(a2, tVar2, 40);
    }

    private static void a(byte[] bArr, sdk.pendo.io.z4.t tVar, int i) {
        tVar.b(bArr, 0, bArr.length);
        tVar.b(c, 0, i);
        byte[] c2 = tVar.c();
        tVar.b(bArr, 0, bArr.length);
        tVar.b(d, 0, i);
        tVar.b(c2, 0, c2.length);
    }

    private static byte[] a(byte b2, int i) {
        byte[] bArr = new byte[i];
        sdk.pendo.io.d5.a.a(bArr, b2);
        return bArr;
    }

    static byte[] a(InputStream inputStream) {
        return sdk.pendo.io.f5.a.a(inputStream);
    }

    static void a(byte[] bArr, OutputStream outputStream) {
        outputStream.write(bArr);
    }
}
