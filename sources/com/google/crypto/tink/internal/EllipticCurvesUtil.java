package com.google.crypto.tink.internal;

import androidx.exifinterface.media.ExifInterface;
import com.google.crypto.tink.subtle.Random;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECField;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

/* loaded from: classes5.dex */
public final class EllipticCurvesUtil {
    public static final ECParameterSpec NIST_P256_PARAMS = getNistP256Params();
    public static final ECParameterSpec NIST_P384_PARAMS = getNistP384Params();
    public static final ECParameterSpec NIST_P521_PARAMS = getNistP521Params();
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger THREE = BigInteger.valueOf(3);
    private static final BigInteger FOUR = BigInteger.valueOf(4);
    private static final BigInteger EIGHT = BigInteger.valueOf(8);

    private static ECParameterSpec getNistP256Params() {
        return getNistCurveSpec("115792089210356248762697446949407573530086143415290314195533631308867097853951", "115792089210356248762697446949407573529996955224135760342422259061068512044369", "5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", "6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", "4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5");
    }

    private static ECParameterSpec getNistP384Params() {
        return getNistCurveSpec("39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319", "39402006196394479212279040100143613805079739270465446667946905279627659399113263569398956308152294913554433653942643", "b3312fa7e23ee7e4988e056be3f82d19181d9c6efe8141120314088f5013875ac656398d8a2ed19d2a85c8edd3ec2aef", "aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", "3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f");
    }

    private static ECParameterSpec getNistP521Params() {
        return getNistCurveSpec("6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057151", "6864797660130609714981900799081393217269435300143305409394463459185543183397655394245057746333217197532963996371363321113864768612440380340372808892707005449", "051953eb9618e1c9a1f929a21a0b68540eea2da725b99b315f3b8b489918ef109e156193951ec7e937b1652c0bd3bb1bf073573df883d2c34f1ef451fd46b503f00", "c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", "11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650");
    }

    public static void checkPointOnCurve(ECPoint point, EllipticCurve ec) throws GeneralSecurityException {
        BigInteger modulus = getModulus(ec);
        BigInteger affineX = point.getAffineX();
        BigInteger affineY = point.getAffineY();
        if (affineX == null || affineY == null) {
            throw new GeneralSecurityException("point is at infinity");
        }
        if (affineX.signum() == -1 || affineX.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("x is out of range");
        }
        if (affineY.signum() == -1 || affineY.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("y is out of range");
        }
        if (!affineY.multiply(affineY).mod(modulus).equals(affineX.multiply(affineX).add(ec.getA()).multiply(affineX).add(ec.getB()).mod(modulus))) {
            throw new GeneralSecurityException("Point is not on curve");
        }
    }

    public static boolean isNistEcParameterSpec(ECParameterSpec spec) {
        return isSameEcParameterSpec(spec, NIST_P256_PARAMS) || isSameEcParameterSpec(spec, NIST_P384_PARAMS) || isSameEcParameterSpec(spec, NIST_P521_PARAMS);
    }

    public static boolean isSameEcParameterSpec(ECParameterSpec one, ECParameterSpec two) {
        return one.getCurve().equals(two.getCurve()) && one.getGenerator().equals(two.getGenerator()) && one.getOrder().equals(two.getOrder()) && one.getCofactor() == two.getCofactor();
    }

    public static BigInteger getModulus(EllipticCurve curve) throws GeneralSecurityException {
        ECField field = curve.getField();
        if (field instanceof ECFieldFp) {
            return ((ECFieldFp) field).getP();
        }
        throw new GeneralSecurityException("Only curves over prime order fields are supported");
    }

    private static ECParameterSpec getNistCurveSpec(String decimalP, String decimalN, String hexB, String hexGX, String hexGY) {
        BigInteger bigInteger = new BigInteger(decimalP);
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp(bigInteger), bigInteger.subtract(new BigInteger(ExifInterface.GPS_MEASUREMENT_3D)), new BigInteger(hexB, 16)), new ECPoint(new BigInteger(hexGX, 16), new BigInteger(hexGY, 16)), new BigInteger(decimalN), 1);
    }

    public static ECPoint multiplyByGenerator(BigInteger x, ECParameterSpec spec) throws GeneralSecurityException {
        if (!isNistEcParameterSpec(spec)) {
            throw new GeneralSecurityException("spec must be NIST P256, P384 or P521");
        }
        if (x.signum() != 1) {
            throw new GeneralSecurityException("k must be positive");
        }
        if (x.compareTo(spec.getOrder()) >= 0) {
            throw new GeneralSecurityException("k must be smaller than the order of the generator");
        }
        EllipticCurve curve = spec.getCurve();
        ECPoint generator = spec.getGenerator();
        checkPointOnCurve(generator, curve);
        BigInteger a2 = spec.getCurve().getA();
        BigInteger modulus = getModulus(curve);
        JacobianEcPoint jacobianEcPoint = toJacobianEcPoint(ECPoint.POINT_INFINITY, modulus);
        JacobianEcPoint jacobianEcPoint2 = toJacobianEcPoint(generator, modulus);
        for (int bitLength = x.bitLength(); bitLength >= 0; bitLength--) {
            if (x.testBit(bitLength)) {
                jacobianEcPoint = addJacobianPoints(jacobianEcPoint, jacobianEcPoint2, a2, modulus);
                jacobianEcPoint2 = doubleJacobianPoint(jacobianEcPoint2, a2, modulus);
            } else {
                jacobianEcPoint2 = addJacobianPoints(jacobianEcPoint, jacobianEcPoint2, a2, modulus);
                jacobianEcPoint = doubleJacobianPoint(jacobianEcPoint, a2, modulus);
            }
        }
        ECPoint eCPoint = jacobianEcPoint.toECPoint(modulus);
        checkPointOnCurve(eCPoint, curve);
        return eCPoint;
    }

    static class JacobianEcPoint {
        static final JacobianEcPoint INFINITY = new JacobianEcPoint(BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO);
        BigInteger x;
        BigInteger y;
        BigInteger z;

        JacobianEcPoint(BigInteger x, BigInteger y, BigInteger z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        boolean isInfinity() {
            return this.z.equals(BigInteger.ZERO);
        }

        ECPoint toECPoint(BigInteger modulus) {
            if (isInfinity()) {
                return ECPoint.POINT_INFINITY;
            }
            BigInteger modInverse = this.z.modInverse(modulus);
            BigInteger mod = modInverse.multiply(modInverse).mod(modulus);
            return new ECPoint(this.x.multiply(mod).mod(modulus), this.y.multiply(mod).mod(modulus).multiply(modInverse).mod(modulus));
        }
    }

    static JacobianEcPoint toJacobianEcPoint(ECPoint p, BigInteger modulus) {
        if (p.equals(ECPoint.POINT_INFINITY)) {
            return JacobianEcPoint.INFINITY;
        }
        BigInteger mod = new BigInteger(1, Random.randBytes((modulus.bitLength() + 8) / 8)).mod(modulus);
        BigInteger mod2 = mod.multiply(mod).mod(modulus);
        return new JacobianEcPoint(p.getAffineX().multiply(mod2).mod(modulus), p.getAffineY().multiply(mod2.multiply(mod).mod(modulus)).mod(modulus), mod);
    }

    static JacobianEcPoint doubleJacobianPoint(JacobianEcPoint p, BigInteger a2, BigInteger modulus) {
        if (p.y.equals(BigInteger.ZERO)) {
            return JacobianEcPoint.INFINITY;
        }
        BigInteger mod = p.x.multiply(p.x).mod(modulus);
        BigInteger mod2 = p.y.multiply(p.y).mod(modulus);
        BigInteger mod3 = mod2.multiply(mod2).mod(modulus);
        BigInteger mod4 = p.z.multiply(p.z).mod(modulus);
        BigInteger add = p.x.add(mod2);
        BigInteger subtract = add.multiply(add).mod(modulus).subtract(mod).subtract(mod3);
        BigInteger bigInteger = TWO;
        BigInteger multiply = subtract.multiply(bigInteger);
        BigInteger add2 = mod.multiply(THREE).add(a2.multiply(mod4).multiply(mod4).mod(modulus));
        BigInteger mod5 = add2.multiply(add2).mod(modulus).subtract(multiply.multiply(bigInteger)).mod(modulus);
        BigInteger mod6 = add2.multiply(multiply.subtract(mod5)).mod(modulus).subtract(mod3.multiply(EIGHT)).mod(modulus);
        BigInteger add3 = p.y.add(p.z);
        return new JacobianEcPoint(mod5, mod6, add3.multiply(add3).mod(modulus).subtract(mod2).subtract(mod4).mod(modulus));
    }

    static JacobianEcPoint addJacobianPoints(JacobianEcPoint p1, JacobianEcPoint p2, BigInteger a2, BigInteger modulus) {
        if (p1.isInfinity()) {
            return p2;
        }
        if (p2.isInfinity()) {
            return p1;
        }
        BigInteger mod = p1.z.multiply(p1.z).mod(modulus);
        BigInteger mod2 = p2.z.multiply(p2.z).mod(modulus);
        BigInteger mod3 = p1.x.multiply(mod2).mod(modulus);
        BigInteger mod4 = p2.x.multiply(mod).mod(modulus);
        BigInteger mod5 = p1.y.multiply(p2.z).mod(modulus).multiply(mod2).mod(modulus);
        BigInteger mod6 = p2.y.multiply(p1.z).mod(modulus).multiply(mod).mod(modulus);
        if (mod3.equals(mod4)) {
            if (!mod5.equals(mod6)) {
                return JacobianEcPoint.INFINITY;
            }
            return doubleJacobianPoint(p1, a2, modulus);
        }
        BigInteger mod7 = mod4.subtract(mod3).mod(modulus);
        BigInteger mod8 = mod7.multiply(FOUR).multiply(mod7).mod(modulus);
        BigInteger mod9 = mod7.multiply(mod8).mod(modulus);
        BigInteger subtract = mod6.subtract(mod5);
        BigInteger bigInteger = TWO;
        BigInteger mod10 = subtract.multiply(bigInteger).mod(modulus);
        BigInteger mod11 = mod3.multiply(mod8).mod(modulus);
        BigInteger mod12 = mod10.multiply(mod10).mod(modulus).subtract(mod9).subtract(mod11.multiply(bigInteger)).mod(modulus);
        BigInteger mod13 = mod10.multiply(mod11.subtract(mod12)).subtract(mod5.multiply(bigInteger).multiply(mod9)).mod(modulus);
        BigInteger add = p1.z.add(p2.z);
        return new JacobianEcPoint(mod12, mod13, add.multiply(add).mod(modulus).subtract(mod).subtract(mod2).multiply(mod7).mod(modulus));
    }

    private EllipticCurvesUtil() {
    }
}
