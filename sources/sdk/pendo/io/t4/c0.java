package sdk.pendo.io.t4;

import java.security.cert.CertPathBuilder;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIMatcher;
import javax.net.ssl.SNIServerName;
import sdk.pendo.io.t4.a0;

/* loaded from: classes6.dex */
abstract class c0 extends b0 {

    static class a<T> implements BiFunction<T, List<String>, String> {

        /* renamed from: a, reason: collision with root package name */
        private final sdk.pendo.io.r4.a<T> f1566a;

        a(sdk.pendo.io.r4.a<T> aVar) {
            this.f1566a = aVar;
        }

        @Override // java.util.function.BiFunction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(T t, List<String> list) {
            return this.f1566a.a(t, list);
        }

        sdk.pendo.io.r4.a<T> a() {
            return this.f1566a;
        }
    }

    static class b extends SNIMatcher {

        /* renamed from: a, reason: collision with root package name */
        private final sdk.pendo.io.r4.d f1567a;

        b(sdk.pendo.io.r4.d dVar) {
            super(dVar.a());
            this.f1567a = dVar;
        }

        sdk.pendo.io.r4.d a() {
            return this.f1567a;
        }

        @Override // javax.net.ssl.SNIMatcher
        public boolean matches(SNIServerName sNIServerName) {
            return this.f1567a.a(c0.a(sNIServerName));
        }
    }

    static class c<T> implements sdk.pendo.io.r4.a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final BiFunction<T, List<String>, String> f1568a;

        c(BiFunction<T, List<String>, String> biFunction) {
            this.f1568a = biFunction;
        }

        @Override // sdk.pendo.io.r4.a
        public String a(T t, List<String> list) {
            return this.f1568a.apply(t, list);
        }

        BiFunction<T, List<String>, String> a() {
            return this.f1568a;
        }
    }

    static class d extends sdk.pendo.io.r4.d {
        private final SNIMatcher b;

        d(SNIMatcher sNIMatcher) {
            super(sNIMatcher.getType());
            this.b = sNIMatcher;
        }

        @Override // sdk.pendo.io.r4.d
        public boolean a(sdk.pendo.io.r4.e eVar) {
            return this.b.matches(c0.a(eVar));
        }

        SNIMatcher b() {
            return this.b;
        }
    }

    static class e extends SNIServerName {
        e(int i, byte[] bArr) {
            super(i, bArr);
        }
    }

    static void a(CertPathBuilder certPathBuilder, PKIXBuilderParameters pKIXBuilderParameters, Map<X509Certificate, byte[]> map) {
        if (map.isEmpty()) {
            return;
        }
        List<PKIXCertPathChecker> certPathCheckers = pKIXBuilderParameters.getCertPathCheckers();
        PKIXRevocationChecker b2 = b(certPathCheckers);
        if (b2 != null) {
            Map<X509Certificate, byte[]> ocspResponses = b2.getOcspResponses();
            if (a((Map) ocspResponses, (Map) map) > 0) {
                b2.setOcspResponses(ocspResponses);
                pKIXBuilderParameters.setCertPathCheckers(certPathCheckers);
                return;
            }
            return;
        }
        if (pKIXBuilderParameters.isRevocationEnabled()) {
            PKIXRevocationChecker pKIXRevocationChecker = (PKIXRevocationChecker) certPathBuilder.getRevocationChecker();
            pKIXRevocationChecker.setOcspResponses(map);
            pKIXBuilderParameters.addCertPathChecker(pKIXRevocationChecker);
        }
    }

    static Object b(Collection<sdk.pendo.io.r4.d> collection) {
        return a(collection);
    }

    static List<SNIServerName> c(Collection<sdk.pendo.io.r4.e> collection) {
        if (collection == null || collection.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<sdk.pendo.io.r4.e> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    static Object d(Collection<sdk.pendo.io.r4.e> collection) {
        return c(collection);
    }

    static List<sdk.pendo.io.r4.d> e(Collection<SNIMatcher> collection) {
        if (collection == null || collection.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<SNIMatcher> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    static List<sdk.pendo.io.r4.e> f(Collection<SNIServerName> collection) {
        if (collection == null || collection.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<SNIServerName> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    static <T> BiFunction<T, List<String>, String> a(sdk.pendo.io.r4.a<T> aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar instanceof c ? ((c) aVar).a() : new a(aVar);
    }

    static PKIXRevocationChecker b(List<PKIXCertPathChecker> list) {
        for (PKIXCertPathChecker pKIXCertPathChecker : list) {
            if (pKIXCertPathChecker instanceof PKIXRevocationChecker) {
                return (PKIXRevocationChecker) pKIXCertPathChecker;
            }
        }
        return null;
    }

    static List<sdk.pendo.io.r4.e> c(Object obj) {
        return f((Collection<SNIServerName>) obj);
    }

    static SNIMatcher a(sdk.pendo.io.r4.d dVar) {
        if (dVar == null) {
            return null;
        }
        return dVar instanceof d ? ((d) dVar).b() : new b(dVar);
    }

    static List<sdk.pendo.io.r4.d> b(Object obj) {
        return e((Collection<SNIMatcher>) obj);
    }

    static List<SNIMatcher> a(Collection<sdk.pendo.io.r4.d> collection) {
        if (collection == null || collection.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<sdk.pendo.io.r4.d> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    static SNIServerName a(sdk.pendo.io.r4.e eVar) {
        if (eVar == null) {
            return null;
        }
        int b2 = eVar.b();
        byte[] a2 = eVar.a();
        return b2 != 0 ? new e(b2, a2) : new SNIHostName(a2);
    }

    static <T> sdk.pendo.io.r4.a<T> a(BiFunction<T, List<String>, String> biFunction) {
        if (biFunction == null) {
            return null;
        }
        return biFunction instanceof a ? ((a) biFunction).a() : new c(biFunction);
    }

    static sdk.pendo.io.r4.d a(SNIMatcher sNIMatcher) {
        if (sNIMatcher == null) {
            return null;
        }
        return sNIMatcher instanceof b ? ((b) sNIMatcher).a() : new d(sNIMatcher);
    }

    static sdk.pendo.io.r4.e a(SNIServerName sNIServerName) {
        if (sNIServerName == null) {
            return null;
        }
        int type = sNIServerName.getType();
        byte[] encoded = sNIServerName.getEncoded();
        return type != 0 ? new a0.a(type, encoded) : new sdk.pendo.io.r4.c(encoded);
    }

    static <K, V> int a(Map<K, V> map, Map<K, V> map2) {
        int i = 0;
        for (Map.Entry<K, V> entry : map2.entrySet()) {
            if (map.putIfAbsent(entry.getKey(), entry.getValue()) == null) {
                i++;
            }
        }
        return i;
    }
}
