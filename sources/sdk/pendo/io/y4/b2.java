package sdk.pendo.io.y4;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class b2 {
    public static void a(int i, byte[] bArr) {
        if (l3.g(bArr)) {
            throw new h2((short) 47);
        }
        if (i != 29 && i != 30 && bArr[0] != 4) {
            throw new h2((short) 47);
        }
    }

    public static boolean b(int i) {
        int i2 = l3.i(i);
        if (i2 == 24) {
            return true;
        }
        switch (i2) {
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                return true;
            default:
                return false;
        }
    }

    public static sdk.pendo.io.z4.o a(r1 r1Var, int i) {
        if (p0.a(i) >= 1) {
            return new sdk.pendo.io.z4.o(i);
        }
        throw new h2((short) 80);
    }

    public static int a(int i) {
        return b(i) ? 1 : 0;
    }

    public static sdk.pendo.io.z4.o a(r1 r1Var, InputStream inputStream) {
        int[] j;
        if (l3.g(inputStream) != 3) {
            throw new h2((short) 40);
        }
        int d = l3.d(inputStream);
        if (p0.n(d) && ((j = r1Var.d().j()) == null || sdk.pendo.io.d5.a.b(j, d))) {
            return new sdk.pendo.io.z4.o(d);
        }
        throw new h2((short) 47);
    }

    public static void a(sdk.pendo.io.z4.o oVar, OutputStream outputStream) {
        a(oVar.a(), outputStream);
    }

    public static void a(int i, OutputStream outputStream) {
        if (!p0.k(i)) {
            throw new h2((short) 80);
        }
        l3.a((short) 3, outputStream);
        l3.a(i);
        l3.a(i, outputStream);
    }
}
