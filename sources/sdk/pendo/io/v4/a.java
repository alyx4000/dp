package sdk.pendo.io.v4;

import java.math.BigInteger;

/* loaded from: classes4.dex */
public class a {
    public static boolean a(c cVar) {
        return a(cVar.e());
    }

    public static boolean b(c cVar) {
        return b(cVar.e());
    }

    public static boolean a(sdk.pendo.io.w4.a aVar) {
        return aVar.a() > 1 && aVar.b().equals(b.c) && (aVar instanceof sdk.pendo.io.w4.f);
    }

    public static boolean b(sdk.pendo.io.w4.a aVar) {
        return aVar.a() == 1;
    }

    public static void a(d[] dVarArr, int i, int i2, d dVar) {
        d[] dVarArr2 = new d[i2];
        int i3 = 0;
        dVarArr2[0] = dVarArr[i];
        while (true) {
            i3++;
            if (i3 >= i2) {
                break;
            } else {
                dVarArr2[i3] = dVarArr2[i3 - 1].c(dVarArr[i + i3]);
            }
        }
        int i4 = i3 - 1;
        if (dVar != null) {
            dVarArr2[i4] = dVarArr2[i4].c(dVar);
        }
        d e = dVarArr2[i4].e();
        while (i4 > 0) {
            int i5 = i4 - 1;
            int i6 = i4 + i;
            d dVar2 = dVarArr[i6];
            dVarArr[i6] = dVarArr2[i5].c(e);
            e = e.c(dVar2);
            i4 = i5;
        }
        dVarArr[i] = e;
    }

    public static e a(e eVar, BigInteger bigInteger) {
        BigInteger abs = bigInteger.abs();
        e g = eVar.e().g();
        int bitLength = abs.bitLength();
        if (bitLength > 0) {
            if (abs.testBit(0)) {
                g = eVar;
            }
            for (int i = 1; i < bitLength; i++) {
                eVar = eVar.r();
                if (abs.testBit(i)) {
                    g = g.a(eVar);
                }
            }
        }
        return bigInteger.signum() < 0 ? g.n() : g;
    }
}
