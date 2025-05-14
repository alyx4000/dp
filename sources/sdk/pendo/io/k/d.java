package sdk.pendo.io.k;

import external.sdk.pendo.io.com.appmattus.certificatetransparency.chaincleaner.CertificateChainCleaner;
import external.sdk.pendo.io.com.appmattus.certificatetransparency.chaincleaner.CertificateChainCleanerFactory;
import java.io.IOException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import sdk.pendo.io.b.d;
import sdk.pendo.io.b.e;
import sdk.pendo.io.m.b;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001Bu\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b*\u0010+J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\n0\u0002R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006,"}, d2 = {"Lsdk/pendo/io/k/d;", "", "", "Ljava/security/cert/X509Certificate;", "certificates", "Lsdk/pendo/io/b/e;", "a", "", "host", "", "Ljava/security/cert/Certificate;", "", "Lsdk/pendo/io/l/b;", "Ljava/util/Set;", "includeHosts", "b", "excludeHosts", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/chaincleaner/CertificateChainCleanerFactory;", "c", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/chaincleaner/CertificateChainCleanerFactory;", "certificateChainCleanerFactory", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/chaincleaner/CertificateChainCleaner;", "d", "Lkotlin/Lazy;", "getCleaner", "()Lcom/appmattus/certificatetransparency/chaincleaner/CertificateChainCleaner;", "cleaner", "Lsdk/pendo/io/d/a;", "Lsdk/pendo/io/m/b;", "e", "Lsdk/pendo/io/d/a;", "logListDataSource", "Lsdk/pendo/io/b/c;", "f", "Lsdk/pendo/io/b/c;", "policy", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lsdk/pendo/io/m/c;", "logListService", "Lsdk/pendo/io/c/a;", "diskCache", "<init>", "(Ljava/util/Set;Ljava/util/Set;Lcom/appmattus/certificatetransparency/chaincleaner/CertificateChainCleanerFactory;Ljavax/net/ssl/X509TrustManager;Lcom/appmattus/certificatetransparency/loglist/LogListService;Lcom/appmattus/certificatetransparency/datasource/DataSource;Lcom/appmattus/certificatetransparency/CTPolicy;Lcom/appmattus/certificatetransparency/cache/DiskCache;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Set<sdk.pendo.io.l.b> includeHosts;

    /* renamed from: b, reason: from kotlin metadata */
    private final Set<sdk.pendo.io.l.b> excludeHosts;

    /* renamed from: c, reason: from kotlin metadata */
    private final CertificateChainCleanerFactory certificateChainCleanerFactory;

    /* renamed from: d, reason: from kotlin metadata */
    private final Lazy cleaner;

    /* renamed from: e, reason: from kotlin metadata */
    private final sdk.pendo.io.d.a<sdk.pendo.io.m.b> logListDataSource;

    /* renamed from: f, reason: from kotlin metadata */
    private final sdk.pendo.io.b.c policy;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/chaincleaner/CertificateChainCleaner;", "a", "()Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/chaincleaner/CertificateChainCleaner;"}, k = 3, mv = {1, 6, 0})
    static final class a extends Lambda implements Function0<CertificateChainCleaner> {
        final /* synthetic */ X509TrustManager f;
        final /* synthetic */ d s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(X509TrustManager x509TrustManager, d dVar) {
            super(0);
            this.f = x509TrustManager;
            this.s = dVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CertificateChainCleaner invoke() {
            CertificateChainCleaner certificateChainCleaner;
            X509TrustManager x509TrustManager = this.f;
            if (x509TrustManager == null) {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                Intrinsics.checkNotNullExpressionValue(trustManagers, "getInstance(TrustManager…)\n        }.trustManagers");
                for (TrustManager trustManager : trustManagers) {
                    if (trustManager instanceof X509TrustManager) {
                        if (trustManager == null) {
                            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                        }
                        x509TrustManager = (X509TrustManager) trustManager;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
            CertificateChainCleanerFactory certificateChainCleanerFactory = this.s.certificateChainCleanerFactory;
            return (certificateChainCleanerFactory == null || (certificateChainCleaner = certificateChainCleanerFactory.get(x509TrustManager)) == null) ? CertificateChainCleaner.INSTANCE.get(x509TrustManager) : certificateChainCleaner;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lsdk/pendo/io/m/b;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.verifier.CertificateTransparencyBase$hasValidSignedCertificateTimestamp$result$1", f = "CertificateTransparencyBase.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super sdk.pendo.io.m.b>, Object> {
        int f;

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super sdk.pendo.io.m.b> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return d.this.new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                sdk.pendo.io.d.a aVar = d.this.logListDataSource;
                this.f = 1;
                obj = aVar.a(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public d(Set<sdk.pendo.io.l.b> includeHosts, Set<sdk.pendo.io.l.b> excludeHosts, CertificateChainCleanerFactory certificateChainCleanerFactory, X509TrustManager x509TrustManager, sdk.pendo.io.m.c cVar, sdk.pendo.io.d.a<sdk.pendo.io.m.b> aVar, sdk.pendo.io.b.c cVar2, sdk.pendo.io.c.a aVar2) {
        sdk.pendo.io.d.a<sdk.pendo.io.m.b> aVar3;
        sdk.pendo.io.l.b bVar;
        Intrinsics.checkNotNullParameter(includeHosts, "includeHosts");
        Intrinsics.checkNotNullParameter(excludeHosts, "excludeHosts");
        this.includeHosts = includeHosts;
        this.excludeHosts = excludeHosts;
        this.certificateChainCleanerFactory = certificateChainCleanerFactory;
        Iterator<T> it = includeHosts.iterator();
        do {
            boolean z = true;
            if (!it.hasNext()) {
                if (!(aVar == null || cVar == null)) {
                    throw new IllegalArgumentException("LogListService is ignored when overriding logListDataSource".toString());
                }
                if (aVar != null && aVar2 != null) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("DiskCache is ignored when overriding logListDataSource".toString());
                }
                this.cleaner = LazyKt.lazy(new a(x509TrustManager, this));
                if (aVar == null) {
                    sdk.pendo.io.m.a aVar4 = sdk.pendo.io.m.a.f1347a;
                    aVar3 = aVar4.a(cVar == null ? sdk.pendo.io.m.a.a(aVar4, null, null, 0L, x509TrustManager, 7, null) : cVar, aVar2);
                } else {
                    aVar3 = aVar;
                }
                this.logListDataSource = aVar3;
                this.policy = cVar2 == null ? new f() : cVar2;
                return;
            }
            bVar = (sdk.pendo.io.l.b) it.next();
            if (!(!bVar.getMatchAll())) {
                throw new IllegalArgumentException("Certificate transparency is enabled by default on all domain names".toString());
            }
        } while (!this.excludeHosts.contains(bVar));
        throw new IllegalArgumentException("Certificate transparency inclusions must not match exclude directly".toString());
    }

    private final boolean a(String host) {
        boolean z;
        boolean z2;
        Set<sdk.pendo.io.l.b> set = this.excludeHosts;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                if (((sdk.pendo.io.l.b) it.next()).a(host)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            return true;
        }
        Set<sdk.pendo.io.l.b> set2 = this.includeHosts;
        if (!(set2 instanceof Collection) || !set2.isEmpty()) {
            Iterator<T> it2 = set2.iterator();
            while (it2.hasNext()) {
                if (((sdk.pendo.io.l.b) it2.next()).a(host)) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        return z2;
    }

    private final CertificateChainCleaner a() {
        return (CertificateChainCleaner) this.cleaner.getValue();
    }

    private final sdk.pendo.io.b.e a(List<? extends X509Certificate> certificates) {
        sdk.pendo.io.m.b fVar;
        sdk.pendo.io.b.d dVar;
        Object runBlocking$default;
        try {
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new b(null), 1, null);
            fVar = (sdk.pendo.io.m.b) runBlocking$default;
        } catch (Exception e) {
            fVar = new sdk.pendo.io.f.f(e);
        }
        if (!(fVar instanceof b.C0193b)) {
            if (fVar instanceof b.a) {
                return new e.b.a((b.a) fVar);
            }
            if (fVar == null) {
                return new e.b.a(sdk.pendo.io.f.l.f1056a);
            }
            throw new NoWhenBranchMatchedException();
        }
        List<sdk.pendo.io.m.d> a2 = ((b.C0193b) fVar).a();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(a2, 10)), 16));
        for (sdk.pendo.io.m.d dVar2 : a2) {
            linkedHashMap.put(sdk.pendo.io.j.a.f1212a.a(dVar2.getId()), new i(dVar2));
        }
        X509Certificate x509Certificate = certificates.get(0);
        if (!sdk.pendo.io.j.b.a(x509Certificate)) {
            return e.b.c.b;
        }
        try {
            List<sdk.pendo.io.l.e> a3 = sdk.pendo.io.j.j.a(x509Certificate);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(a3, 10)), 16));
            for (Object obj : a3) {
                linkedHashMap2.put(sdk.pendo.io.j.a.f1212a.a(((sdk.pendo.io.l.e) obj).getId().getKeyId()), obj);
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
            for (Object obj2 : linkedHashMap2.entrySet()) {
                Object key = ((Map.Entry) obj2).getKey();
                Map.Entry entry = (Map.Entry) obj2;
                String str = (String) entry.getKey();
                sdk.pendo.io.l.e eVar = (sdk.pendo.io.l.e) entry.getValue();
                i iVar = (i) linkedHashMap.get(str);
                if (iVar == null || (dVar = iVar.a(eVar, certificates)) == null) {
                    dVar = d.a.f.f871a;
                }
                linkedHashMap3.put(key, dVar);
            }
            return this.policy.a(x509Certificate, linkedHashMap3);
        } catch (IOException e2) {
            return new e.b.C0086e(e2);
        }
    }

    public final sdk.pendo.io.b.e a(String host, List<? extends Certificate> certificates) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(certificates, "certificates");
        if (!a(host)) {
            return new e.c.a(host);
        }
        if (!certificates.isEmpty()) {
            CertificateChainCleaner a2 = a();
            ArrayList arrayList = new ArrayList();
            for (Object obj : certificates) {
                if (obj instanceof X509Certificate) {
                    arrayList.add(obj);
                }
            }
            List<X509Certificate> clean = a2.clean(arrayList, host);
            if (!clean.isEmpty()) {
                return a(clean);
            }
        }
        return e.b.C0085b.b;
    }
}
