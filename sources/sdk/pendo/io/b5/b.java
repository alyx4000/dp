package sdk.pendo.io.b5;

import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.interfaces.ECKey;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;
import sdk.pendo.io.v4.c;

/* loaded from: classes6.dex */
class b {
    static sdk.pendo.io.v4.c a(EllipticCurve ellipticCurve, BigInteger bigInteger, int i) {
        ECField field = ellipticCurve.getField();
        BigInteger a2 = ellipticCurve.getA();
        BigInteger b = ellipticCurve.getB();
        if (field instanceof ECFieldFp) {
            return new c.d(((ECFieldFp) field).getP(), a2, b, bigInteger, BigInteger.valueOf(i));
        }
        ECFieldF2m eCFieldF2m = (ECFieldF2m) field;
        int m = eCFieldF2m.getM();
        int[] a3 = a(eCFieldF2m.getMidTermsOfReductionPolynomial());
        return new c.C0248c(m, a3[0], a3[1], a3[2], a2, b, bigInteger, BigInteger.valueOf(i));
    }

    static ECParameterSpec b(h hVar, String str) {
        return b(hVar, a(str));
    }

    static boolean c(h hVar, String str) {
        return str != null && a(hVar, new ECGenParameterSpec(str));
    }

    static int[] a(int[] iArr) {
        int i;
        int[] iArr2 = new int[3];
        if (iArr.length == 1) {
            iArr2[0] = iArr[0];
        } else {
            if (iArr.length != 3) {
                throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
            }
            int i2 = iArr[0];
            int i3 = iArr[1];
            if (i2 >= i3 || i2 >= (i = iArr[2])) {
                int i4 = iArr[2];
                if (i3 < i4) {
                    iArr2[0] = i3;
                    int i5 = iArr[0];
                    if (i5 < i4) {
                        iArr2[1] = i5;
                        iArr2[2] = i4;
                    } else {
                        iArr2[1] = i4;
                        iArr2[2] = i5;
                    }
                } else {
                    iArr2[0] = i4;
                    int i6 = iArr[0];
                    if (i6 < i3) {
                        iArr2[1] = i6;
                        iArr2[2] = iArr[1];
                    } else {
                        iArr2[1] = i3;
                        iArr2[2] = i6;
                    }
                }
            } else {
                iArr2[0] = i2;
                if (i3 < i) {
                    iArr2[1] = i3;
                    iArr2[2] = i;
                } else {
                    iArr2[1] = i;
                    iArr2[2] = iArr[1];
                }
            }
        }
        return iArr2;
    }

    static ECParameterSpec b(h hVar, AlgorithmParameterSpec algorithmParameterSpec) {
        try {
            KeyPairGenerator a2 = hVar.g().a("EC");
            a2.initialize(algorithmParameterSpec, hVar.h());
            try {
                AlgorithmParameters e = hVar.g().e("EC");
                e.init(algorithmParameterSpec);
                ECParameterSpec eCParameterSpec = (ECParameterSpec) e.getParameterSpec(ECParameterSpec.class);
                if (eCParameterSpec != null) {
                    return eCParameterSpec;
                }
            } catch (AssertionError | Exception unused) {
            }
            return ((ECKey) a2.generateKeyPair().getPrivate()).getParams();
        } catch (AssertionError | Exception unused2) {
            return null;
        }
    }

    static AlgorithmParameterSpec a(String str) {
        return new ECGenParameterSpec(str);
    }

    static AlgorithmParameters a(h hVar, String str) {
        return a(hVar, (AlgorithmParameterSpec) new ECGenParameterSpec(str));
    }

    static AlgorithmParameters a(h hVar, AlgorithmParameterSpec algorithmParameterSpec) {
        try {
            AlgorithmParameters e = hVar.g().e("EC");
            e.init(algorithmParameterSpec);
            if (((ECParameterSpec) e.getParameterSpec(ECParameterSpec.class)) != null) {
                return e;
            }
            return null;
        } catch (AssertionError | Exception unused) {
            return null;
        }
    }

    static boolean a(h hVar, ECGenParameterSpec eCGenParameterSpec) {
        return b(hVar, eCGenParameterSpec) != null;
    }

    static boolean a(PrivateKey privateKey) {
        return (privateKey instanceof ECPrivateKey) || "EC".equalsIgnoreCase(privateKey.getAlgorithm());
    }
}
