package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.math.BigInteger;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Fingerprint;
import org.bouncycastle.util.Strings;

/* loaded from: classes6.dex */
class GOSTUtil {
    GOSTUtil() {
    }

    private static String generateKeyFingerprint(BigInteger bigInteger, GOST3410Parameters gOST3410Parameters) {
        return new Fingerprint(Arrays.concatenate(bigInteger.toByteArray(), gOST3410Parameters.getP().toByteArray(), gOST3410Parameters.getA().toByteArray())).toString();
    }

    static String privateKeyToString(String str, BigInteger bigInteger, GOST3410Parameters gOST3410Parameters) {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        BigInteger modPow = gOST3410Parameters.getA().modPow(bigInteger, gOST3410Parameters.getP());
        stringBuffer.append(str);
        stringBuffer.append(" Private Key [").append(generateKeyFingerprint(modPow, gOST3410Parameters)).append("]").append(lineSeparator);
        stringBuffer.append("                  Y: ").append(modPow.toString(16)).append(lineSeparator);
        return stringBuffer.toString();
    }

    static String publicKeyToString(String str, BigInteger bigInteger, GOST3410Parameters gOST3410Parameters) {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append(str);
        stringBuffer.append(" Public Key [").append(generateKeyFingerprint(bigInteger, gOST3410Parameters)).append("]").append(lineSeparator);
        stringBuffer.append("                 Y: ").append(bigInteger.toString(16)).append(lineSeparator);
        return stringBuffer.toString();
    }
}
