package sdk.pendo.io.g3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import sdk.pendo.io.g3.j;
import sdk.pendo.io.w2.a0;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0003B\u0017\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\r¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001c\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011R\u001c\u0010\u0015\u001a\n \u0013*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0017\u001a\n \u0013*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u001c\u0010\u0019\u001a\n \u0013*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0011¨\u0006\u001d"}, d2 = {"Lsdk/pendo/io/g3/f;", "Lsdk/pendo/io/g3/k;", "", "a", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lsdk/pendo/io/w2/a0;", "protocols", "", "b", "Ljava/lang/Class;", "Ljava/lang/Class;", "sslSocketClass", "Ljava/lang/reflect/Method;", "Ljava/lang/reflect/Method;", "setUseSessionTickets", "kotlin.jvm.PlatformType", "c", "setHostname", "d", "getAlpnSelectedProtocol", "e", "setAlpnProtocols", "<init>", "(Ljava/lang/Class;)V", "f", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public class f implements k {

    /* renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final j.a g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Class<? super SSLSocket> sslSocketClass;

    /* renamed from: b, reason: from kotlin metadata */
    private final Method setUseSessionTickets;

    /* renamed from: c, reason: from kotlin metadata */
    private final Method setHostname;

    /* renamed from: d, reason: from kotlin metadata */
    private final Method getAlpnSelectedProtocol;

    /* renamed from: e, reason: from kotlin metadata */
    private final Method setAlpnProtocols;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/g3/f$a;", "", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "actualSSLSocketClass", "Lsdk/pendo/io/g3/f;", "a", "", "packageName", "Lsdk/pendo/io/g3/j$a;", "playProviderFactory", "Lsdk/pendo/io/g3/j$a;", "getPlayProviderFactory", "()Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.g3.f$a, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"sdk/pendo/io/g3/f$a$a", "Lsdk/pendo/io/g3/j$a;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "a", "Lsdk/pendo/io/g3/k;", "b", "okhttp"}, k = 1, mv = {1, 8, 0})
        /* renamed from: sdk.pendo.io.g3.f$a$a, reason: collision with other inner class name */
        public static final class C0144a implements j.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f1111a;

            C0144a(String str) {
                this.f1111a = str;
            }

            @Override // sdk.pendo.io.g3.j.a
            public boolean a(SSLSocket sslSocket) {
                Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
                String name = sslSocket.getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name, "sslSocket.javaClass.name");
                return StringsKt.startsWith$default(name, this.f1111a + '.', false, 2, (Object) null);
            }

            @Override // sdk.pendo.io.g3.j.a
            public k b(SSLSocket sslSocket) {
                Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
                return f.INSTANCE.a((Class<? super SSLSocket>) sslSocket.getClass());
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final f a(Class<? super SSLSocket> actualSSLSocketClass) {
            Class<? super SSLSocket> cls = actualSSLSocketClass;
            while (cls != null && !Intrinsics.areEqual(cls.getSimpleName(), "OpenSSLSocketImpl")) {
                cls = cls.getSuperclass();
                if (cls == null) {
                    throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + actualSSLSocketClass);
                }
            }
            Intrinsics.checkNotNull(cls);
            return new f(cls);
        }

        public final j.a a(String packageName) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            return new C0144a(packageName);
        }

        public final j.a a() {
            return f.g;
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        g = companion.a("com.google.android.gms.org.conscrypt");
    }

    public f(Class<? super SSLSocket> sslSocketClass) {
        Intrinsics.checkNotNullParameter(sslSocketClass, "sslSocketClass");
        this.sslSocketClass = sslSocketClass;
        Method declaredMethod = sslSocketClass.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        Intrinsics.checkNotNullExpressionValue(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.setUseSessionTickets = declaredMethod;
        this.setHostname = sslSocketClass.getMethod("setHostname", String.class);
        this.getAlpnSelectedProtocol = sslSocketClass.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.setAlpnProtocols = sslSocketClass.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // sdk.pendo.io.g3.k
    public void a(SSLSocket sslSocket, String hostname, List<? extends a0> protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        if (a(sslSocket)) {
            try {
                this.setUseSessionTickets.invoke(sslSocket, Boolean.TRUE);
                if (hostname != null) {
                    this.setHostname.invoke(sslSocket, hostname);
                }
                this.setAlpnProtocols.invoke(sslSocket, sdk.pendo.io.f3.h.INSTANCE.b(protocols));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    @Override // sdk.pendo.io.g3.k
    public boolean a() {
        return sdk.pendo.io.f3.b.INSTANCE.b();
    }

    @Override // sdk.pendo.io.g3.k
    public String b(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        if (!a(sslSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.getAlpnSelectedProtocol.invoke(sslSocket, new Object[0]);
            if (bArr != null) {
                return new String(bArr, Charsets.UTF_8);
            }
            return null;
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if ((cause instanceof NullPointerException) && Intrinsics.areEqual(((NullPointerException) cause).getMessage(), "ssl == null")) {
                return null;
            }
            throw new AssertionError(e2);
        }
    }

    @Override // sdk.pendo.io.g3.k
    public boolean a(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return this.sslSocketClass.isInstance(sslSocket);
    }
}
