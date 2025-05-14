package sdk.pendo.io.y4;

import androidx.core.view.InputDeviceCompat;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class z1 {
    public static sdk.pendo.io.z4.l a(r1 r1Var, int i) {
        if (i < 0 || p0.c(i) < 1) {
            return null;
        }
        return new sdk.pendo.io.z4.l(i, l3.d(r1Var));
    }

    public static sdk.pendo.io.z4.a b(int i) {
        switch (i) {
            case 256:
                return sdk.pendo.io.z4.b.t;
            case InputDeviceCompat.SOURCE_KEYBOARD /* 257 */:
                return sdk.pendo.io.z4.b.v;
            case 258:
                return sdk.pendo.io.z4.b.x;
            case 259:
                return sdk.pendo.io.z4.b.z;
            case 260:
                return sdk.pendo.io.z4.b.B;
            default:
                return null;
        }
    }

    public static boolean c(int i) {
        int i2 = l3.i(i);
        return i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 14;
    }

    public static sdk.pendo.io.z4.a a(sdk.pendo.io.z4.l lVar) {
        int b = lVar.b();
        return b >= 0 ? b(b) : lVar.a();
    }

    public static sdk.pendo.io.z4.a b(BigInteger bigInteger, BigInteger bigInteger2) {
        sdk.pendo.io.z4.a[] aVarArr = {sdk.pendo.io.z4.b.t, sdk.pendo.io.z4.b.v, sdk.pendo.io.z4.b.x, sdk.pendo.io.z4.b.z, sdk.pendo.io.z4.b.B, sdk.pendo.io.z4.b.d, sdk.pendo.io.z4.b.f, sdk.pendo.io.z4.b.h, sdk.pendo.io.z4.b.j, sdk.pendo.io.z4.b.l, sdk.pendo.io.z4.b.n, sdk.pendo.io.z4.b.q, sdk.pendo.io.z4.b.r};
        for (int i = 0; i < 13; i++) {
            sdk.pendo.io.z4.a aVar = aVarArr[i];
            if (aVar != null && aVar.c().equals(bigInteger) && aVar.a().equals(bigInteger2)) {
                return aVar;
            }
        }
        return null;
    }

    public static int a(int i) {
        return c(i) ? 1 : 0;
    }

    public static int a(BigInteger bigInteger, BigInteger bigInteger2) {
        int[] iArr = {256, InputDeviceCompat.SOURCE_KEYBOARD, 258, 259, 260};
        for (int i = 0; i < 5; i++) {
            int i2 = iArr[i];
            sdk.pendo.io.z4.a b = b(i2);
            if (b != null && b.c().equals(bigInteger) && b.a().equals(bigInteger2)) {
                return i2;
            }
        }
        return -1;
    }

    public static BigInteger a(InputStream inputStream) {
        return new BigInteger(1, l3.a(inputStream, 1));
    }

    public static sdk.pendo.io.z4.l a(r1 r1Var, x1 x1Var, InputStream inputStream) {
        BigInteger a2 = a(inputStream);
        BigInteger a3 = a(inputStream);
        int a4 = a(a2, a3);
        if (a4 >= 0) {
            int[] j = r1Var.d().j();
            if (j == null || sdk.pendo.io.d5.a.b(j, a4)) {
                return new sdk.pendo.io.z4.l(a4, false);
            }
            throw new h2((short) 47);
        }
        sdk.pendo.io.z4.a b = b(a2, a3);
        if (b == null) {
            b = new sdk.pendo.io.z4.a(a2, null, a3, 0);
        }
        if (x1Var.a(b)) {
            return new sdk.pendo.io.z4.l(b);
        }
        throw new h2((short) 71);
    }

    public static void a(sdk.pendo.io.z4.l lVar, OutputStream outputStream) {
        sdk.pendo.io.z4.a a2 = a(lVar);
        a(a2.c(), outputStream);
        a(a2.a(), outputStream);
    }

    public static void a(BigInteger bigInteger, OutputStream outputStream) {
        l3.a(sdk.pendo.io.d5.b.a(bigInteger), outputStream);
    }
}
