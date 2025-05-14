package sdk.pendo.io.a5;

import org.bouncycastle.jcajce.spec.TLSKeyMaterialSpec;
import sdk.pendo.io.y4.a1;
import sdk.pendo.io.y4.v0;
import sdk.pendo.io.z4.b0;

/* loaded from: classes6.dex */
public class h {
    public static b0 a(a1 a1Var, b0 b0Var, String str, byte[] bArr, int i) {
        return b0Var.a(a1Var.t(), str, bArr, i);
    }

    public static boolean b(sdk.pendo.io.z4.j jVar) {
        return a(jVar.e());
    }

    public static boolean c(sdk.pendo.io.z4.j jVar) {
        return b(jVar.e());
    }

    public static boolean d(sdk.pendo.io.z4.j jVar) {
        return c(jVar.e());
    }

    public static byte[] a(sdk.pendo.io.z4.j jVar, int i) {
        a1 d = jVar.d();
        return a(d, d.q(), TLSKeyMaterialSpec.KEY_EXPANSION, sdk.pendo.io.d5.a.c(d.A(), d.f()), i).a();
    }

    public static boolean b(v0 v0Var) {
        return v0.f.d(v0Var.a());
    }

    public static boolean c(v0 v0Var) {
        return v0.g.d(v0Var.a());
    }

    public static boolean a(sdk.pendo.io.z4.j jVar) {
        return jVar.e().g();
    }

    public static boolean a(v0 v0Var) {
        return v0.e.d(v0Var.a());
    }
}
