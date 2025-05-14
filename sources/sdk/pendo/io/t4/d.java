package sdk.pendo.io.t4;

import expo.modules.securestore.encryptors.AESEncryptor;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private final int f1569a;
    private final String b;
    private final boolean c;
    private final Set<String> d;
    private final Set<String> e;

    private d(int i, String str, boolean z, Set<String> set, Set<String> set2) {
        this.f1569a = i;
        this.b = str;
        this.c = z;
        this.d = set;
        this.e = set2;
    }

    private static void a(Set<String> set, String... strArr) {
        for (String str : strArr) {
            set.add(str);
        }
    }

    private static void b(Set<String> set, int i) {
        if (i == 4) {
            a(set, "SHA256", "SHA-256", "HmacSHA256");
        } else if (i == 5) {
            a(set, "SHA384", "SHA-384", "HmacSHA384");
        } else {
            if (i != 7) {
                throw new IllegalArgumentException();
            }
            a(set, "SM3", "HmacSM3");
        }
    }

    private static void c(Set<String> set, int i) {
        if (i != 0) {
            if (i == 1) {
                a(set, "RSA");
                return;
            }
            if (i == 3) {
                a(set, "DSA", "DSS", "DH", "DHE", "DiffieHellman", "DHE_DSS");
                return;
            }
            if (i == 5) {
                a(set, "RSA", "DH", "DHE", "DiffieHellman", "DHE_RSA");
                return;
            }
            if (i != 11) {
                if (i == 17) {
                    a(set, "ECDHE", "ECDSA", "ECDHE_ECDSA");
                } else if (i == 19) {
                    a(set, "ECDHE", "RSA", "ECDHE_RSA");
                } else if (i != 20) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    private static void d(Set<String> set, int i) {
        if (i == 0) {
            a(set, "K_NULL");
            return;
        }
        if (i == 1 || i == 3 || i == 5) {
            return;
        }
        if (i == 11) {
            a(set, "ANON", "DH", "DiffieHellman", "DH_ANON");
        } else {
            if (i == 17 || i == 19) {
                return;
            }
            if (i != 20) {
                throw new IllegalArgumentException();
            }
            a(set, "ANON", "ECDH", "ECDH_ANON");
        }
    }

    boolean e() {
        return this.c;
    }

    private static void a(Set<String> set, int i) {
        String str;
        set.addAll(x.b.a(b(i)));
        if (i != 0) {
            switch (i) {
                case 7:
                    str = "3DES_EDE_CBC";
                    break;
                case 8:
                    str = "AES_128_CBC";
                    break;
                case 9:
                    str = "AES_256_CBC";
                    break;
                case 10:
                    str = "AES_128_GCM";
                    break;
                case 11:
                    str = "AES_256_GCM";
                    break;
                case 12:
                    str = "CAMELLIA_128_CBC";
                    break;
                case 13:
                    str = "CAMELLIA_256_CBC";
                    break;
                default:
                    switch (i) {
                        case 15:
                            str = "AES_128_CCM";
                            break;
                        case 16:
                            str = "AES_128_CCM_8";
                            break;
                        case 17:
                            str = "AES_256_CCM";
                            break;
                        case 18:
                            str = "AES_256_CCM_8";
                            break;
                        case 19:
                            str = "CAMELLIA_128_GCM";
                            break;
                        case 20:
                            str = "CAMELLIA_256_GCM";
                            break;
                        case 21:
                            return;
                        case 22:
                            str = "ARIA_128_CBC";
                            break;
                        case 23:
                            str = "ARIA_256_CBC";
                            break;
                        case 24:
                            str = "ARIA_128_GCM";
                            break;
                        case 25:
                            str = "ARIA_256_GCM";
                            break;
                        case 26:
                            str = "SM4_CCM";
                            break;
                        case 27:
                            str = "SM4_GCM";
                            break;
                        case 28:
                            str = "SM4_CBC";
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
            }
        } else {
            str = "C_NULL";
        }
        set.add(str);
    }

    public Set<String> b() {
        return this.d;
    }

    public Set<String> c() {
        return this.e;
    }

    public String d() {
        return this.b;
    }

    private static void a(Set<String> set, int i, int i2) {
        if (i2 == 0) {
            if (2 != i) {
                a(set, "M_NULL");
            }
        } else {
            if (i2 == 1) {
                a(set, MessageDigestAlgorithms.MD5, "HmacMD5");
                return;
            }
            if (i2 == 2) {
                a(set, "SHA1", "SHA-1", "HmacSHA1");
            } else if (i2 == 3) {
                a(set, "SHA256", "SHA-256", "HmacSHA256");
            } else {
                if (i2 != 4) {
                    throw new IllegalArgumentException();
                }
                a(set, "SHA384", "SHA-384", "HmacSHA384");
            }
        }
    }

    private static String b(int i) {
        if (i == 0) {
            return "NULL";
        }
        switch (i) {
            case 7:
                return "DESede/CBC/NoPadding";
            case 8:
            case 9:
                return "AES/CBC/NoPadding";
            case 10:
            case 11:
                return AESEncryptor.AES_CIPHER;
            case 12:
            case 13:
                return "Camellia/CBC/NoPadding";
            default:
                switch (i) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        return "AES/CCM/NoPadding";
                    case 19:
                    case 20:
                        return "Camellia/GCM/NoPadding";
                    case 21:
                        return "ChaCha20-Poly1305";
                    case 22:
                    case 23:
                        return "ARIA/CBC/NoPadding";
                    case 24:
                    case 25:
                        return "ARIA/GCM/NoPadding";
                    case 26:
                        return "SM4/CCM/NoPadding";
                    case 27:
                        return "SM4/GCM/NoPadding";
                    case 28:
                        return "SM4/CBC/NoPadding";
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    static d a(int i, String str) {
        if (!str.startsWith("TLS_")) {
            throw new IllegalArgumentException();
        }
        int f = l3.f(i);
        int g = l3.g(f);
        int a2 = a(i);
        int i2 = l3.i(i);
        int k = l3.k(i);
        HashSet hashSet = new HashSet();
        c(hashSet, i2);
        HashSet hashSet2 = new HashSet(hashSet);
        d(hashSet2, i2);
        a(hashSet2, f);
        b(hashSet2, a2);
        a(hashSet2, g, k);
        return new d(i, str, i2 == 0, Collections.unmodifiableSet(hashSet2), Collections.unmodifiableSet(hashSet));
    }

    public int a() {
        return this.f1569a;
    }

    private static int a(int i) {
        switch (i) {
            case 2:
            case 10:
            case 19:
            case 22:
            case 47:
            case 50:
            case 51:
            case 53:
            case 56:
            case 57:
            case 59:
            case 60:
            case 61:
            case 64:
            case 65:
            case 68:
            case 69:
            case 103:
            case 106:
            case 107:
            case 132:
            case 135:
            case 136:
            case 156:
            case 158:
            case Token.COMMENT /* 162 */:
            case 186:
            case 189:
            case 190:
            case 192:
            case 195:
            case 196:
            case 4865:
            case 4867:
            case 4868:
            case 4869:
            case 49158:
            case 49160:
            case 49161:
            case 49162:
            case 49168:
            case 49170:
            case 49171:
            case 49172:
            case 49187:
            case 49191:
            case 49195:
            case 49199:
            case 49212:
            case 49218:
            case 49220:
            case 49224:
            case 49228:
            case 49232:
            case 49234:
            case 49238:
            case 49244:
            case 49248:
            case 49266:
            case 49270:
            case 49274:
            case 49276:
            case 49280:
            case 49286:
            case 49290:
            case 49308:
            case 49309:
            case 49310:
            case 49311:
            case 49312:
            case 49313:
            case 49314:
            case 49315:
            case 49324:
            case 49325:
            case 49326:
            case 49327:
            case 52392:
            case 52393:
            case 52394:
                return 4;
            case 157:
            case Token.LETEXPR /* 159 */:
            case Token.GENEXPR /* 163 */:
            case 4866:
            case 49188:
            case 49192:
            case 49196:
            case 49200:
            case 49213:
            case 49219:
            case 49221:
            case 49225:
            case 49229:
            case 49233:
            case 49235:
            case 49239:
            case 49245:
            case 49249:
            case 49267:
            case 49271:
            case 49275:
            case 49277:
            case 49281:
            case 49287:
            case 49291:
                return 5;
            case 198:
            case 199:
                return 7;
            default:
                throw new IllegalArgumentException();
        }
    }
}
