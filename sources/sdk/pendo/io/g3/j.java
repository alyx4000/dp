package sdk.pendo.io.g3;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.w2.a0;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u0006\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0011¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/g3/j;", "Lsdk/pendo/io/g3/k;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "c", "", "a", "", "hostname", "", "Lsdk/pendo/io/w2/a0;", "protocols", "", "b", "Lsdk/pendo/io/g3/j$a;", "Lsdk/pendo/io/g3/j$a;", "socketAdapterFactory", "Lsdk/pendo/io/g3/k;", "delegate", "<init>", "(Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class j implements k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a socketAdapterFactory;

    /* renamed from: b, reason: from kotlin metadata */
    private k delegate;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lsdk/pendo/io/g3/j$a;", "", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "a", "Lsdk/pendo/io/g3/k;", "b", "okhttp"}, k = 1, mv = {1, 8, 0})
    public interface a {
        boolean a(SSLSocket sslSocket);

        k b(SSLSocket sslSocket);
    }

    public j(a socketAdapterFactory) {
        Intrinsics.checkNotNullParameter(socketAdapterFactory, "socketAdapterFactory");
        this.socketAdapterFactory = socketAdapterFactory;
    }

    private final synchronized k c(SSLSocket sslSocket) {
        if (this.delegate == null && this.socketAdapterFactory.a(sslSocket)) {
            this.delegate = this.socketAdapterFactory.b(sslSocket);
        }
        return this.delegate;
    }

    @Override // sdk.pendo.io.g3.k
    public void a(SSLSocket sslSocket, String hostname, List<? extends a0> protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        k c = c(sslSocket);
        if (c != null) {
            c.a(sslSocket, hostname, protocols);
        }
    }

    @Override // sdk.pendo.io.g3.k
    public boolean a() {
        return true;
    }

    @Override // sdk.pendo.io.g3.k
    public String b(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        k c = c(sslSocket);
        if (c != null) {
            return c.b(sslSocket);
        }
        return null;
    }

    @Override // sdk.pendo.io.g3.k
    public boolean a(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return this.socketAdapterFactory.a(sslSocket);
    }
}
