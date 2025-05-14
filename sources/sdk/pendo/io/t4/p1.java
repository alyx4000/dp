package sdk.pendo.io.t4;

import java.net.Socket;
import java.security.KeyStore;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLEngine;
import sdk.pendo.io.t4.o1;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
class p1 extends sdk.pendo.io.r4.j {
    private static final Logger d = Logger.getLogger(p1.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final boolean f1600a;
    private final sdk.pendo.io.p4.b b;
    private final Map<String, a> c;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f1601a;
        private final PrivateKey b;
        private final X509Certificate[] c;

        a(String str, PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
            this.f1601a = str;
            this.b = privateKey;
            this.c = x509CertificateArr;
        }
    }

    private static final class b implements Comparable<b> {
        static final o1.e f0 = o1.e.MISMATCH_SNI;
        static final b t0 = new b(o1.e.NONE, Integer.MAX_VALUE, null);
        final a A;
        final o1.e f;
        final int s;

        b(o1.e eVar, int i, a aVar) {
            this.f = eVar;
            this.s = i;
            this.A = aVar;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            boolean b = b();
            if (b != bVar.b()) {
                return b ? -1 : 1;
            }
            int i = this.s;
            int i2 = bVar.s;
            return i != i2 ? i < i2 ? -1 : 1 : this.f.compareTo(bVar.f);
        }

        boolean b() {
            return this.f.compareTo(f0) < 0;
        }

        boolean a() {
            return o1.e.OK == this.f && this.s == 0;
        }
    }

    p1(boolean z, sdk.pendo.io.p4.b bVar, KeyStore keyStore, char[] cArr) {
        this.f1600a = z;
        this.b = bVar;
        this.c = a(keyStore, cArr);
    }

    private static List<b> a(List<b> list, b bVar) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(bVar);
        return list;
    }

    private String[] c(List<String> list, Principal[] principalArr, x1 x1Var, boolean z) {
        if (this.c.isEmpty() || list.isEmpty()) {
            return null;
        }
        int size = list.size();
        Set<Principal> a2 = o1.a(principalArr);
        sdk.pendo.io.s4.a a3 = x1.a(x1Var, true);
        Date date = new Date();
        String a4 = o1.a(x1Var, z);
        Iterator<a> it = this.c.values().iterator();
        List<b> list2 = null;
        while (it.hasNext()) {
            List<b> list3 = list2;
            b a5 = a(it.next(), list, size, a2, a3, z, date, a4);
            list2 = a5.compareTo(b.t0) < 0 ? a(list3, a5) : list3;
        }
        List<b> list4 = list2;
        if (list4 == null || list4.isEmpty()) {
            return null;
        }
        Collections.sort(list4);
        return a(list4);
    }

    private b d(List<String> list, Principal[] principalArr, x1 x1Var, boolean z) {
        b bVar = b.t0;
        if (this.c.isEmpty() || list.isEmpty()) {
            return bVar;
        }
        int size = list.size();
        Set<Principal> a2 = o1.a(principalArr);
        sdk.pendo.io.s4.a a3 = x1.a(x1Var, true);
        Date date = new Date();
        String a4 = o1.a(x1Var, z);
        Iterator<a> it = this.c.values().iterator();
        b bVar2 = bVar;
        int i = size;
        while (it.hasNext()) {
            int i2 = i;
            b bVar3 = bVar2;
            bVar2 = a(it.next(), list, i, a2, a3, z, date, a4);
            if (bVar2.compareTo(bVar3) >= 0) {
                i = i2;
                bVar2 = bVar3;
            } else {
                if (bVar2.a()) {
                    return bVar2;
                }
                if (bVar2.b()) {
                    i = Math.min(i2, bVar2.s + 1);
                } else {
                    i = i2;
                }
            }
        }
        return bVar2;
    }

    @Override // sdk.pendo.io.r4.j
    public sdk.pendo.io.r4.l b(String[] strArr, Principal[] principalArr, SSLEngine sSLEngine) {
        return b(o1.a(strArr), principalArr, x1.a(sSLEngine), true);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseClientAlias(String[] strArr, Principal[] principalArr, Socket socket) {
        return a(o1.a(strArr), principalArr, x1.a(socket), false);
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineClientAlias(String[] strArr, Principal[] principalArr, SSLEngine sSLEngine) {
        return a(o1.a(strArr), principalArr, x1.a(sSLEngine), false);
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineServerAlias(String str, Principal[] principalArr, SSLEngine sSLEngine) {
        return a(o1.a(str), principalArr, x1.a(sSLEngine), true);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseServerAlias(String str, Principal[] principalArr, Socket socket) {
        return a(o1.a(str), principalArr, x1.a(socket), true);
    }

    @Override // javax.net.ssl.X509KeyManager
    public X509Certificate[] getCertificateChain(String str) {
        a a2 = a(str);
        if (a2 == null) {
            return null;
        }
        return (X509Certificate[]) a2.c.clone();
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getClientAliases(String str, Principal[] principalArr) {
        return c(o1.a(str), principalArr, null, false);
    }

    @Override // javax.net.ssl.X509KeyManager
    public PrivateKey getPrivateKey(String str) {
        a a2 = a(str);
        if (a2 == null) {
            return null;
        }
        return a2.b;
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getServerAliases(String str, Principal[] principalArr) {
        return c(o1.a(str), principalArr, null, true);
    }

    private String a(List<String> list, Principal[] principalArr, x1 x1Var, boolean z) {
        b d2 = d(list, principalArr, x1Var, z);
        if (d2.compareTo(b.t0) >= 0) {
            d.fine("No matching key found");
            return null;
        }
        String str = list.get(d2.s);
        String a2 = a(d2);
        Logger logger = d;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("Found matching key of type: " + str + ", returning alias: " + a2);
        }
        return a2;
    }

    private sdk.pendo.io.r4.l b(List<String> list, Principal[] principalArr, x1 x1Var, boolean z) {
        String str;
        sdk.pendo.io.r4.l a2;
        b d2 = d(list, principalArr, x1Var, z);
        if (d2.compareTo(b.t0) >= 0 || (a2 = a((str = list.get(d2.s)), d2.A)) == null) {
            d.fine("No matching key found");
            return null;
        }
        Logger logger = d;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("Found matching key of type: " + str + ", from alias: " + a(d2));
        }
        return a2;
    }

    @Override // sdk.pendo.io.r4.j
    public sdk.pendo.io.r4.l a(String[] strArr, Principal[] principalArr, Socket socket) {
        return b(o1.a(strArr), principalArr, x1.a(socket), false);
    }

    @Override // sdk.pendo.io.r4.j
    public sdk.pendo.io.r4.l b(String[] strArr, Principal[] principalArr, Socket socket) {
        return b(o1.a(strArr), principalArr, x1.a(socket), true);
    }

    @Override // sdk.pendo.io.r4.j
    public sdk.pendo.io.r4.l a(String[] strArr, Principal[] principalArr, SSLEngine sSLEngine) {
        return b(o1.a(strArr), principalArr, x1.a(sSLEngine), false);
    }

    private sdk.pendo.io.r4.l a(String str, a aVar) {
        if (aVar == null) {
            return null;
        }
        return new n1(str, aVar.b, aVar.c);
    }

    private static String a(b bVar) {
        return bVar.A.f1601a;
    }

    private static String[] a(List<b> list) {
        String[] strArr = new String[list.size()];
        Iterator<b> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = a(it.next());
            i++;
        }
        return strArr;
    }

    private a a(String str) {
        if (str == null) {
            return null;
        }
        return this.c.get(str);
    }

    @Override // sdk.pendo.io.r4.j
    protected sdk.pendo.io.r4.l a(String str, String str2) {
        return a(str, a(str2));
    }

    private b a(a aVar, List<String> list, int i, Set<Principal> set, sdk.pendo.io.s4.a aVar2, boolean z, Date date, String str) {
        o1.e a2;
        X509Certificate[] x509CertificateArr = aVar.c;
        int a3 = o1.a(list, i, set, aVar2, z, x509CertificateArr);
        return (a3 < 0 || o1.e.NONE == (a2 = o1.a(this.f1600a, this.b, list, aVar2, z, date, str, x509CertificateArr, a3))) ? b.t0 : new b(a2, a3, aVar);
    }

    private static Map<String, a> a(KeyStore keyStore, char[] cArr) {
        PrivateKey privateKey;
        HashMap hashMap = new HashMap(4);
        if (keyStore != null) {
            Enumeration<String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                String nextElement = aliases.nextElement();
                if (keyStore.entryInstanceOf(nextElement, KeyStore.PrivateKeyEntry.class) && (privateKey = (PrivateKey) keyStore.getKey(nextElement, cArr)) != null) {
                    X509Certificate[] a2 = a0.a(keyStore.getCertificateChain(nextElement));
                    if (!l3.b(a2)) {
                        hashMap.put(nextElement, new a(nextElement, privateKey, a2));
                    }
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
