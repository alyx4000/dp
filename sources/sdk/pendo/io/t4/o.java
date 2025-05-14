package sdk.pendo.io.t4;

import androidx.core.view.InputDeviceCompat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes6.dex */
abstract class o {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f1594a = i0.b("external.sdk.pendo.io.org.bouncycastle.jsse.fips.allowRSAKeyExchange", true);
    private static final Set<String> b = a();
    private static final Set<String> c = b();

    private static Set<String> a() {
        HashSet hashSet = new HashSet();
        hashSet.add("TLS_AES_128_CCM_8_SHA256");
        hashSet.add("TLS_AES_128_CCM_SHA256");
        hashSet.add("TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
        hashSet.add("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
        hashSet.add("TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
        hashSet.add("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
        hashSet.add("TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
        hashSet.add("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
        hashSet.add("TLS_DHE_RSA_WITH_AES_128_CCM");
        hashSet.add("TLS_DHE_RSA_WITH_AES_128_CCM_8");
        hashSet.add("TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
        hashSet.add("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
        hashSet.add("TLS_DHE_RSA_WITH_AES_256_CCM");
        hashSet.add("TLS_DHE_RSA_WITH_AES_256_CCM_8");
        hashSet.add("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
        hashSet.add("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
        hashSet.add("TLS_ECDHE_ECDSA_WITH_AES_128_CCM");
        hashSet.add("TLS_ECDHE_ECDSA_WITH_AES_128_CCM_8");
        hashSet.add("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
        hashSet.add("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
        hashSet.add("TLS_ECDHE_ECDSA_WITH_AES_256_CCM");
        hashSet.add("TLS_ECDHE_ECDSA_WITH_AES_256_CCM_8");
        hashSet.add("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
        hashSet.add("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
        hashSet.add("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
        hashSet.add("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
        if (f1594a) {
            hashSet.add("TLS_RSA_WITH_AES_128_CBC_SHA");
            hashSet.add("TLS_RSA_WITH_AES_128_CBC_SHA256");
            hashSet.add("TLS_RSA_WITH_AES_128_CCM");
            hashSet.add("TLS_RSA_WITH_AES_128_CCM_8");
            hashSet.add("TLS_RSA_WITH_AES_256_CBC_SHA");
            hashSet.add("TLS_RSA_WITH_AES_256_CBC_SHA256");
            hashSet.add("TLS_RSA_WITH_AES_256_CCM");
            hashSet.add("TLS_RSA_WITH_AES_256_CCM_8");
        }
        return Collections.unmodifiableSet(hashSet);
    }

    static boolean a(int i) {
        switch (i) {
            case 23:
            case 24:
            case 25:
                return true;
            default:
                switch (i) {
                    case 256:
                    case InputDeviceCompat.SOURCE_KEYBOARD /* 257 */:
                    case 258:
                    case 259:
                    case 260:
                        return true;
                    default:
                        return false;
                }
        }
    }

    private static Set<String> b() {
        HashSet hashSet = new HashSet();
        hashSet.add("TLSv1");
        hashSet.add("TLSv1.1");
        hashSet.add("TLSv1.2");
        hashSet.add("TLSv1.3");
        return Collections.unmodifiableSet(hashSet);
    }

    static boolean b(int i) {
        switch (i) {
            case InputDeviceCompat.SOURCE_DPAD /* 513 */:
            case 514:
            case 515:
            case 769:
            case 770:
            case 771:
            case InputDeviceCompat.SOURCE_GAMEPAD /* 1025 */:
            case 1026:
            case 1027:
            case 1281:
            case 1283:
            case 1537:
            case 1539:
            case 2052:
            case 2053:
            case 2054:
            case 2057:
            case 2058:
            case 2059:
                return true;
            default:
                return false;
        }
    }

    static boolean a(String str) {
        return str != null && b.contains(str);
    }

    static boolean b(String str) {
        return str != null && c.contains(str);
    }

    static void a(Collection<String> collection) {
        collection.retainAll(b);
    }

    static void b(Collection<String> collection) {
        collection.retainAll(c);
    }
}
