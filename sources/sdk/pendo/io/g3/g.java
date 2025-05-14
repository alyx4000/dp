package sdk.pendo.io.g3;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.g3.j;
import sdk.pendo.io.w2.a0;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/g3/g;", "Lsdk/pendo/io/g3/k;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "a", "", "b", "hostname", "", "Lsdk/pendo/io/w2/a0;", "protocols", "", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class g implements k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final j.a b = new a();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"sdk/pendo/io/g3/g$a", "Lsdk/pendo/io/g3/j$a;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "a", "Lsdk/pendo/io/g3/k;", "b", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a implements j.a {
        a() {
        }

        @Override // sdk.pendo.io.g3.j.a
        public boolean a(SSLSocket sslSocket) {
            Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
            return sdk.pendo.io.f3.c.INSTANCE.b() && (sslSocket instanceof sdk.pendo.io.r4.i);
        }

        @Override // sdk.pendo.io.g3.j.a
        public k b(SSLSocket sslSocket) {
            Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
            return new g();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lsdk/pendo/io/g3/g$b;", "", "Lsdk/pendo/io/g3/j$a;", "factory", "Lsdk/pendo/io/g3/j$a;", "getFactory", "()Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.g3.g$b, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final j.a a() {
            return g.b;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // sdk.pendo.io.g3.k
    public void a(SSLSocket sslSocket, String hostname, List<? extends a0> protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        if (a(sslSocket)) {
            sdk.pendo.io.r4.i iVar = (sdk.pendo.io.r4.i) sslSocket;
            sdk.pendo.io.r4.h parameters = iVar.getParameters();
            parameters.a((String[]) sdk.pendo.io.f3.h.INSTANCE.a(protocols).toArray(new String[0]));
            iVar.a(parameters);
        }
    }

    @Override // sdk.pendo.io.g3.k
    public boolean a() {
        return sdk.pendo.io.f3.c.INSTANCE.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // sdk.pendo.io.g3.k
    public String b(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        String applicationProtocol = ((sdk.pendo.io.r4.i) sslSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : Intrinsics.areEqual(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // sdk.pendo.io.g3.k
    public boolean a(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return sslSocket instanceof sdk.pendo.io.r4.i;
    }
}
