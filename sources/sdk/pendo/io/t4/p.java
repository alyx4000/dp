package sdk.pendo.io.t4;

import androidx.webkit.ProxyConfig;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes6.dex */
class p {
    static void a(String str, X509Certificate x509Certificate, boolean z) {
        if (str == null) {
            throw new CertificateException("No hostname specified for HTTPS endpoint ID check");
        }
        if (sdk.pendo.io.d5.c.a(str)) {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames != null) {
                for (List<?> list : subjectAlternativeNames) {
                    if (7 == ((Integer) list.get(0)).intValue()) {
                        String str2 = (String) list.get(1);
                        if (str.equalsIgnoreCase(str2)) {
                            return;
                        }
                        try {
                            if (InetAddress.getByName(str).equals(InetAddress.getByName(str2))) {
                                return;
                            }
                        } catch (SecurityException | UnknownHostException unused) {
                            continue;
                        }
                    }
                }
            }
            throw new CertificateException("No subject alternative name found matching IP address " + str);
        }
        if (!a(str)) {
            throw new CertificateException("Invalid hostname specified for HTTPS endpoint ID check");
        }
        Collection<List<?>> subjectAlternativeNames2 = x509Certificate.getSubjectAlternativeNames();
        if (subjectAlternativeNames2 != null) {
            boolean z2 = false;
            for (List<?> list2 : subjectAlternativeNames2) {
                if (2 == ((Integer) list2.get(0)).intValue()) {
                    if (a(str, (String) list2.get(1), z)) {
                        return;
                    } else {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                throw new CertificateException("No subject alternative name found matching domain name " + str);
            }
        }
        sdk.pendo.io.m3.g a2 = a(x509Certificate.getSubjectX500Principal());
        if (!(a2 instanceof sdk.pendo.io.m3.g0) || !a(str, ((sdk.pendo.io.m3.g0) a2).c(), z)) {
            throw new CertificateException("No name found matching " + str);
        }
    }

    private static boolean b(String str, String str2) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        StringTokenizer stringTokenizer2 = new StringTokenizer(str2, ".");
        if (stringTokenizer.countTokens() != stringTokenizer2.countTokens()) {
            return false;
        }
        while (stringTokenizer.hasMoreTokens()) {
            if (!a(stringTokenizer.nextToken(), stringTokenizer2.nextToken())) {
                return false;
            }
        }
        return true;
    }

    private static boolean c(String str, String str2) {
        String a2 = a(str, 0);
        String a3 = a(str2, 0);
        if (a(a2, a3)) {
            return str.substring(a2.length()).equals(str2.substring(a3.length()));
        }
        return false;
    }

    private static sdk.pendo.io.m3.a0 a(X500Principal x500Principal) {
        if (x500Principal == null) {
            return null;
        }
        sdk.pendo.io.c4.b[] h = sdk.pendo.io.c4.c.a(x500Principal.getEncoded()).h();
        for (int length = h.length - 1; length >= 0; length--) {
            for (sdk.pendo.io.c4.a aVar : h[length].i()) {
                if (sdk.pendo.io.d4.b.g.b(aVar.h())) {
                    return aVar.i().b();
                }
            }
        }
        return null;
    }

    private static boolean b(String str) {
        int lastIndexOf = str.lastIndexOf(42);
        return lastIndexOf < 0 || !(str.equals(ProxyConfig.MATCH_ALL_SCHEMES) || str.equals("*.") || str.indexOf(46, lastIndexOf + 1) < 0);
    }

    private static String a(String str, int i) {
        int indexOf = str.indexOf(46, i);
        if (indexOf < 0) {
            indexOf = str.length();
        }
        return str.substring(i, indexOf);
    }

    private static boolean a(String str) {
        try {
            new sdk.pendo.io.r4.c(str);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    private static boolean a(String str, String str2) {
        int indexOf = str2.indexOf(42);
        if (indexOf < 0) {
            return str.equals(str2);
        }
        int i = 0;
        int i2 = 0;
        do {
            String substring = str2.substring(i, indexOf);
            int indexOf2 = str.indexOf(substring, i2);
            if (indexOf2 < 0 || (i == 0 && indexOf2 > 0)) {
                return false;
            }
            i2 = indexOf2 + substring.length();
            i = indexOf + 1;
            indexOf = str2.indexOf(42, i);
        } while (indexOf >= 0);
        return str.substring(i2).endsWith(str2.substring(i));
    }

    private static boolean a(String str, String str2, boolean z) {
        try {
            String d = q.d(q.b(str, 0), 0);
            String d2 = q.d(q.b(str2, 0), 0);
            if (!b(d2) || !a(d2.replace('*', 'z'))) {
                return false;
            }
            Locale locale = Locale.ENGLISH;
            String lowerCase = d.toLowerCase(locale);
            String lowerCase2 = d2.toLowerCase(locale);
            return z ? b(lowerCase, lowerCase2) : c(lowerCase, lowerCase2);
        } catch (RuntimeException unused) {
            return false;
        }
    }
}
