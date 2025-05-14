package sdk.pendo.io.b3;

import androidx.core.app.NotificationCompat;
import com.facebook.common.callercontext.ContextChain;
import io.sentry.SentryLockReason;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.b3.j;
import sdk.pendo.io.e3.n;
import sdk.pendo.io.w2.f0;
import sdk.pendo.io.w2.r;
import sdk.pendo.io.w2.v;
import sdk.pendo.io.w2.z;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020!\u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b9\u0010:J8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0016\u0010\u000b\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u000b\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\u001a\u0010 \u001a\u00020\u001c8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00100R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00100R\u0018\u00108\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006;"}, d2 = {"Lsdk/pendo/io/b3/d;", "", "", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "", "connectionRetryEnabled", "doExtensiveHealthChecks", "Lsdk/pendo/io/b3/f;", "a", "Lsdk/pendo/io/w2/f0;", "c", "Lsdk/pendo/io/w2/z;", "client", "Lsdk/pendo/io/c3/g;", "chain", "Lsdk/pendo/io/c3/d;", "Ljava/io/IOException;", "e", "", "b", "Lsdk/pendo/io/w2/v;", "url", "Lsdk/pendo/io/b3/g;", "Lsdk/pendo/io/b3/g;", "connectionPool", "Lsdk/pendo/io/w2/a;", "Lsdk/pendo/io/w2/a;", "getAddress$okhttp", "()Lokhttp3/Address;", SentryLockReason.JsonKeys.ADDRESS, "Lsdk/pendo/io/b3/e;", "Lsdk/pendo/io/b3/e;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/w2/r;", "d", "Lsdk/pendo/io/w2/r;", "eventListener", "Lsdk/pendo/io/b3/j$b;", "Lsdk/pendo/io/b3/j$b;", "routeSelection", "Lsdk/pendo/io/b3/j;", "f", "Lsdk/pendo/io/b3/j;", "routeSelector", "g", "I", "refusedStreamCount", "h", "connectionShutdownCount", ContextChain.TAG_INFRA, "otherFailureCount", "j", "Lsdk/pendo/io/w2/f0;", "nextRouteToTry", "<init>", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final g connectionPool;

    /* renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.w2.a address;

    /* renamed from: c, reason: from kotlin metadata */
    private final e call;

    /* renamed from: d, reason: from kotlin metadata */
    private final r eventListener;

    /* renamed from: e, reason: from kotlin metadata */
    private j.b routeSelection;

    /* renamed from: f, reason: from kotlin metadata */
    private j routeSelector;

    /* renamed from: g, reason: from kotlin metadata */
    private int refusedStreamCount;

    /* renamed from: h, reason: from kotlin metadata */
    private int connectionShutdownCount;

    /* renamed from: i, reason: from kotlin metadata */
    private int otherFailureCount;

    /* renamed from: j, reason: from kotlin metadata */
    private f0 nextRouteToTry;

    public d(g connectionPool, sdk.pendo.io.w2.a address, e call, r eventListener) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
    }

    private final f0 c() {
        f connection;
        if (this.refusedStreamCount > 1 || this.connectionShutdownCount > 1 || this.otherFailureCount > 0 || (connection = this.call.getConnection()) == null) {
            return null;
        }
        synchronized (connection) {
            if (connection.getRouteFailureCount() != 0) {
                return null;
            }
            if (sdk.pendo.io.x2.b.a(connection.getRoute().getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String().getUrl(), this.address.getUrl())) {
                return connection.getRoute();
            }
            return null;
        }
    }

    public final sdk.pendo.io.c3.d a(z client, sdk.pendo.io.c3.g chain) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        try {
            return a(chain.getConnectTimeoutMillis(), chain.getReadTimeoutMillis(), chain.getWriteTimeoutMillis(), client.getPingIntervalMillis(), client.getRetryOnConnectionFailure(), !Intrinsics.areEqual(chain.g().getIo.sentry.protocol.Request.JsonKeys.METHOD java.lang.String(), "GET")).a(client, chain);
        } catch (IOException e) {
            a(e);
            throw new i(e);
        } catch (i e2) {
            a(e2.getLastConnectException());
            throw e2;
        }
    }

    public final boolean b() {
        j jVar;
        boolean z = false;
        if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
            return false;
        }
        if (this.nextRouteToTry != null) {
            return true;
        }
        f0 c = c();
        if (c != null) {
            this.nextRouteToTry = c;
            return true;
        }
        j.b bVar = this.routeSelection;
        if (bVar != null && bVar.b()) {
            z = true;
        }
        if (z || (jVar = this.routeSelector) == null) {
            return true;
        }
        return jVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final sdk.pendo.io.b3.f a(int r15, int r16, int r17, int r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.b3.d.a(int, int, int, int, boolean):sdk.pendo.io.b3.f");
    }

    private final f a(int connectTimeout, int readTimeout, int writeTimeout, int pingIntervalMillis, boolean connectionRetryEnabled, boolean doExtensiveHealthChecks) {
        while (true) {
            f a2 = a(connectTimeout, readTimeout, writeTimeout, pingIntervalMillis, connectionRetryEnabled);
            if (a2.a(doExtensiveHealthChecks)) {
                return a2;
            }
            a2.m();
            if (this.nextRouteToTry == null) {
                j.b bVar = this.routeSelection;
                if (bVar != null ? bVar.b() : true) {
                    continue;
                } else {
                    j jVar = this.routeSelector;
                    if (!(jVar != null ? jVar.a() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
    }

    /* renamed from: a, reason: from getter */
    public final sdk.pendo.io.w2.a getAddress() {
        return this.address;
    }

    public final boolean a(v url) {
        Intrinsics.checkNotNullParameter(url, "url");
        v url2 = this.address.getUrl();
        return url.getPort() == url2.getPort() && Intrinsics.areEqual(url.getHost(), url2.getHost());
    }

    public final void a(IOException e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.nextRouteToTry = null;
        if ((e instanceof n) && ((n) e).errorCode == sdk.pendo.io.e3.b.REFUSED_STREAM) {
            this.refusedStreamCount++;
        } else if (e instanceof sdk.pendo.io.e3.a) {
            this.connectionShutdownCount++;
        } else {
            this.otherFailureCount++;
        }
    }
}
