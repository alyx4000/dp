package sdk.pendo.io.f3;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import io.sentry.SentryLockReason;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.g3.i;
import sdk.pendo.io.g3.j;
import sdk.pendo.io.g3.k;
import sdk.pendo.io.g3.l;
import sdk.pendo.io.w2.a0;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 &2\u00020\u0001:\u0002\t\u0012B\u0007¢\u0006\u0004\b$\u0010%J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J-\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0011\u0010\u0011\u001a\r\u0012\t\u0012\u00070\u000f¢\u0006\u0002\b\u00100\u000eH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0012\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\t\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u0012\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lsdk/pendo/io/f3/b;", "Lsdk/pendo/io/f3/h;", "Ljava/net/Socket;", "socket", "Ljava/net/InetSocketAddress;", SentryLockReason.JsonKeys.ADDRESS, "", "connectTimeout", "", "a", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lsdk/pendo/io/w2/a0;", "Lkotlin/jvm/JvmSuppressWildcards;", "protocols", "b", "closer", "", "message", "stackTrace", "", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lsdk/pendo/io/i3/c;", "Lsdk/pendo/io/i3/e;", "Lsdk/pendo/io/g3/k;", "d", "Ljava/util/List;", "socketAdapters", "Lsdk/pendo/io/g3/h;", "e", "Lsdk/pendo/io/g3/h;", "closeGuard", "<init>", "()V", "f", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class b extends h {

    /* renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean g;

    /* renamed from: d, reason: from kotlin metadata */
    private final List<k> socketAdapters;

    /* renamed from: e, reason: from kotlin metadata */
    private final sdk.pendo.io.g3.h closeGuard;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/f3/b$a;", "", "Lsdk/pendo/io/f3/h;", "a", "", "isSupported", "Z", "b", "()Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.f3.b$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a() {
            if (b()) {
                return new b();
            }
            return null;
        }

        public final boolean b() {
            return b.g;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/f3/b$b;", "Lsdk/pendo/io/i3/e;", "Ljava/security/cert/X509Certificate;", "cert", "a", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Ljava/lang/reflect/Method;", "b", "Ljava/lang/reflect/Method;", "findByIssuerAndSignatureMethod", "<init>", "(Ljavax/net/ssl/X509TrustManager;Ljava/lang/reflect/Method;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.f3.b$b, reason: collision with other inner class name */
    public static final /* data */ class C0134b implements sdk.pendo.io.i3.e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final X509TrustManager trustManager;

        /* renamed from: b, reason: from kotlin metadata */
        private final Method findByIssuerAndSignatureMethod;

        public C0134b(X509TrustManager trustManager, Method findByIssuerAndSignatureMethod) {
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            Intrinsics.checkNotNullParameter(findByIssuerAndSignatureMethod, "findByIssuerAndSignatureMethod");
            this.trustManager = trustManager;
            this.findByIssuerAndSignatureMethod = findByIssuerAndSignatureMethod;
        }

        @Override // sdk.pendo.io.i3.e
        public X509Certificate a(X509Certificate cert) {
            Intrinsics.checkNotNullParameter(cert, "cert");
            try {
                Object invoke = this.findByIssuerAndSignatureMethod.invoke(this.trustManager, cert);
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type java.security.cert.TrustAnchor");
                return ((TrustAnchor) invoke).getTrustedCert();
            } catch (IllegalAccessException e) {
                throw new AssertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof C0134b)) {
                return false;
            }
            C0134b c0134b = (C0134b) other;
            return Intrinsics.areEqual(this.trustManager, c0134b.trustManager) && Intrinsics.areEqual(this.findByIssuerAndSignatureMethod, c0134b.findByIssuerAndSignatureMethod);
        }

        public int hashCode() {
            return (this.trustManager.hashCode() * 31) + this.findByIssuerAndSignatureMethod.hashCode();
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.trustManager + ", findByIssuerAndSignatureMethod=" + this.findByIssuerAndSignatureMethod + ')';
        }
    }

    static {
        g = h.INSTANCE.e() && Build.VERSION.SDK_INT < 30;
    }

    public b() {
        List listOfNotNull = CollectionsKt.listOfNotNull((Object[]) new k[]{l.Companion.a(l.INSTANCE, null, 1, null), new j(sdk.pendo.io.g3.f.INSTANCE.a()), new j(i.INSTANCE.a()), new j(sdk.pendo.io.g3.g.INSTANCE.a())});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listOfNotNull) {
            if (((k) obj).a()) {
                arrayList.add(obj);
            }
        }
        this.socketAdapters = arrayList;
        this.closeGuard = sdk.pendo.io.g3.h.INSTANCE.a();
    }

    @Override // sdk.pendo.io.f3.h
    public sdk.pendo.io.i3.c a(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        sdk.pendo.io.g3.b a2 = sdk.pendo.io.g3.b.INSTANCE.a(trustManager);
        return a2 != null ? a2 : super.a(trustManager);
    }

    @Override // sdk.pendo.io.f3.h
    public sdk.pendo.io.i3.e b(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        try {
            Method method = trustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            method.setAccessible(true);
            Intrinsics.checkNotNullExpressionValue(method, "method");
            return new C0134b(trustManager, method);
        } catch (NoSuchMethodException unused) {
            return super.b(trustManager);
        }
    }

    @Override // sdk.pendo.io.f3.h
    public void a(SSLSocket sslSocket, String hostname, List<a0> protocols) {
        Object obj;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Iterator<T> it = this.socketAdapters.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((k) obj).a(sslSocket)) {
                    break;
                }
            }
        }
        k kVar = (k) obj;
        if (kVar != null) {
            kVar.a(sslSocket, hostname, protocols);
        }
    }

    @Override // sdk.pendo.io.f3.h
    public String b(SSLSocket sslSocket) {
        Object obj;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Iterator<T> it = this.socketAdapters.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((k) obj).a(sslSocket)) {
                break;
            }
        }
        k kVar = (k) obj;
        if (kVar != null) {
            return kVar.b(sslSocket);
        }
        return null;
    }

    @Override // sdk.pendo.io.f3.h
    public void a(Socket socket, InetSocketAddress address, int connectTimeout) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(address, "address");
        try {
            socket.connect(address, connectTimeout);
        } catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e;
            }
            throw new IOException("Exception in connect", e);
        }
    }

    @Override // sdk.pendo.io.f3.h
    public boolean b(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }

    @Override // sdk.pendo.io.f3.h
    public Object a(String closer) {
        Intrinsics.checkNotNullParameter(closer, "closer");
        return this.closeGuard.a(closer);
    }

    @Override // sdk.pendo.io.f3.h
    public void a(String message, Object stackTrace) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.closeGuard.a(stackTrace)) {
            return;
        }
        h.a(this, message, 5, null, 4, null);
    }
}
