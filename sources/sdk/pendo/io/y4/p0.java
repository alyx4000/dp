package sdk.pendo.io.y4;

import androidx.core.view.InputDeviceCompat;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import external.sdk.pendo.io.mozilla.javascript.Token;
import javax.servlet.http.HttpServletResponse;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.jcajce.spec.XDHParameterSpec;

/* loaded from: classes4.dex */
public class p0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f1794a = {"sect163k1", "sect163r1", "sect163r2", "sect193r1", "sect193r2", "sect233k1", "sect233r1", "sect239k1", "sect283k1", "sect283r1", "sect409k1", "sect409r1", "sect571k1", "sect571r1", "secp160k1", "secp160r1", "secp160r2", "secp192k1", "secp192r1", "secp224k1", "secp224r1", "secp256k1", "secp256r1", "secp384r1", "secp521r1", "brainpoolP256r1", "brainpoolP384r1", "brainpoolP512r1", XDHParameterSpec.X25519, XDHParameterSpec.X448, "brainpoolP256r1", "brainpoolP384r1", "brainpoolP512r1", "Tc26-Gost-3410-12-256-paramSetA", "GostR3410-2001-CryptoPro-A", "GostR3410-2001-CryptoPro-B", "GostR3410-2001-CryptoPro-C", "Tc26-Gost-3410-12-512-paramSetA", "Tc26-Gost-3410-12-512-paramSetB", "Tc26-Gost-3410-12-512-paramSetC", "sm2p256v1"};
    private static final String[] b = {"ffdhe2048", "ffdhe3072", "ffdhe4096", "ffdhe6144", "ffdhe8192"};

    public static int a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
                return Token.GENEXPR;
            case 4:
            case 5:
                return 193;
            case 6:
            case 7:
                return 233;
            case 8:
                return 239;
            case 9:
            case 10:
                return 283;
            case 11:
            case 12:
                return HttpServletResponse.SC_CONFLICT;
            case 13:
            case 14:
                return 571;
            case 15:
            case 16:
            case 17:
                return 160;
            case 18:
            case 19:
                return 192;
            case 20:
            case 21:
                return BERTags.FLAGS;
            case 22:
            case 23:
            case 26:
            case 31:
            case 34:
            case 35:
            case 36:
            case 37:
            case 41:
                return 256;
            case 24:
            case 27:
            case 32:
                return BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
            case 25:
                return 521;
            case 28:
            case 33:
            case 38:
            case 39:
            case 40:
                return 512;
            case 29:
                return 252;
            case 30:
                return 446;
            default:
                return 0;
        }
    }

    public static boolean a(int i, v0 v0Var) {
        if (l3.e(v0Var)) {
            if ((i >= 1 && i <= 22) || ((i >= 26 && i <= 28) || ((i >= 34 && i <= 40) || (i >= 65281 && i <= 65282)))) {
                return false;
            }
        } else if ((i >= 31 && i <= 33) || i == 41) {
            return false;
        }
        return j(i);
    }

    public static String b(int i) {
        if (k(i)) {
            return f1794a[i - 1];
        }
        return null;
    }

    public static int c(int i) {
        switch (i) {
            case 256:
                return 2048;
            case InputDeviceCompat.SOURCE_KEYBOARD /* 257 */:
                return 3072;
            case 258:
                return 4096;
            case 259:
                return 6144;
            case 260:
                return 8192;
            default:
                return 0;
        }
    }

    public static String d(int i) {
        if (l(i)) {
            return b[i + InputDeviceCompat.SOURCE_ANY];
        }
        return null;
    }

    public static String e(int i) {
        if (i(i)) {
            return "PRIVATE";
        }
        if (i == 65281) {
            return "arbitrary_explicit_prime_curves";
        }
        if (i == 65282) {
            return "arbitrary_explicit_char2_curves";
        }
        switch (i) {
            case 29:
                return "x25519";
            case 30:
                return "x448";
            case 31:
                return "brainpoolP256r1tls13";
            case 32:
                return "brainpoolP384r1tls13";
            case 33:
                return "brainpoolP512r1tls13";
            case 34:
                return "GC256A";
            case 35:
                return "GC256B";
            case 36:
                return "GC256C";
            case 37:
                return "GC256D";
            case 38:
                return "GC512A";
            case 39:
                return "GC512B";
            case 40:
                return "GC512C";
            case 41:
                return "curveSM2";
            default:
                String f = f(i);
                return f != null ? f : "UNKNOWN";
        }
    }

    public static String f(int i) {
        String b2 = b(i);
        if (b2 != null) {
            return b2;
        }
        String d = d(i);
        if (d != null) {
            return d;
        }
        return null;
    }

    public static String g(int i) {
        return e(i) + "(" + i + ")";
    }

    public static boolean h(int i) {
        return (i >= 1 && i <= 14) || i == 65282;
    }

    public static boolean i(int i) {
        return (i >>> 2) == 127 || (i >>> 8) == 254;
    }

    public static boolean j(int i) {
        return m(i) || i(i) || (i >= 65281 && i <= 65282);
    }

    public static boolean k(int i) {
        return i >= 1 && i <= 41;
    }

    public static boolean l(int i) {
        return i >= 256 && i <= 260;
    }

    public static boolean m(int i) {
        return k(i) || l(i);
    }

    public static boolean n(int i) {
        return k(i);
    }

    public static boolean o(int i) {
        return k(i) && !p(i);
    }

    public static boolean p(int i) {
        return i >= 29 && i <= 30;
    }
}
