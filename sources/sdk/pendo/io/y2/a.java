package sdk.pendo.io.y2;

import io.sentry.protocol.Response;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.w2.b;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.f0;
import sdk.pendo.io.w2.h;
import sdk.pendo.io.w2.o;
import sdk.pendo.io.w2.q;
import sdk.pendo.io.w2.v;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\b\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/y2/a;", "Lsdk/pendo/io/w2/b;", "Ljava/net/Proxy;", "Lsdk/pendo/io/w2/v;", "url", "Lsdk/pendo/io/w2/q;", "dns", "Ljava/net/InetAddress;", "a", "Lsdk/pendo/io/w2/f0;", "route", "Lsdk/pendo/io/w2/d0;", Response.TYPE, "Lsdk/pendo/io/w2/b0;", "d", "Lsdk/pendo/io/w2/q;", "defaultDns", "<init>", "(Lokhttp3/Dns;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class a implements b {

    /* renamed from: d, reason: from kotlin metadata */
    private final q defaultDns;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: sdk.pendo.io.y2.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0271a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1763a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f1763a = iArr;
        }
    }

    public a(q defaultDns) {
        Intrinsics.checkNotNullParameter(defaultDns, "defaultDns");
        this.defaultDns = defaultDns;
    }

    @Override // sdk.pendo.io.w2.b
    public b0 a(f0 route, d0 response) {
        Proxy proxy;
        q qVar;
        PasswordAuthentication requestPasswordAuthentication;
        sdk.pendo.io.w2.a aVar;
        Intrinsics.checkNotNullParameter(response, "response");
        List<h> n = response.n();
        b0 b0Var = response.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String();
        v i = b0Var.i();
        boolean z = response.getCom.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String() == 407;
        if (route == null || (proxy = route.getProxy()) == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (h hVar : n) {
            if (StringsKt.equals("Basic", hVar.getScheme(), true)) {
                if (route == null || (aVar = route.getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String()) == null || (qVar = aVar.getDns()) == null) {
                    qVar = this.defaultDns;
                }
                if (z) {
                    SocketAddress address = proxy.address();
                    Intrinsics.checkNotNull(address, "null cannot be cast to non-null type java.net.InetSocketAddress");
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                    String hostName = inetSocketAddress.getHostName();
                    Intrinsics.checkNotNullExpressionValue(proxy, "proxy");
                    requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, a(proxy, i, qVar), inetSocketAddress.getPort(), i.getScheme(), hVar.b(), hVar.getScheme(), i.q(), Authenticator.RequestorType.PROXY);
                } else {
                    String host = i.getHost();
                    Intrinsics.checkNotNullExpressionValue(proxy, "proxy");
                    requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(host, a(proxy, i, qVar), i.getPort(), i.getScheme(), hVar.b(), hVar.getScheme(), i.q(), Authenticator.RequestorType.SERVER);
                }
                if (requestPasswordAuthentication != null) {
                    String str = z ? "Proxy-Authorization" : "Authorization";
                    String userName = requestPasswordAuthentication.getUserName();
                    Intrinsics.checkNotNullExpressionValue(userName, "auth.userName");
                    char[] password = requestPasswordAuthentication.getPassword();
                    Intrinsics.checkNotNullExpressionValue(password, "auth.password");
                    return b0Var.h().b(str, o.a(userName, new String(password), hVar.a())).a();
                }
            }
        }
        return null;
    }

    public /* synthetic */ a(q qVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? q.b : qVar);
    }

    private final InetAddress a(Proxy proxy, v vVar, q qVar) {
        Proxy.Type type = proxy.type();
        if ((type == null ? -1 : C0271a.f1763a[type.ordinal()]) == 1) {
            return (InetAddress) CollectionsKt.first((List) qVar.a(vVar.getHost()));
        }
        SocketAddress address = proxy.address();
        Intrinsics.checkNotNull(address, "null cannot be cast to non-null type java.net.InetSocketAddress");
        InetAddress address2 = ((InetSocketAddress) address).getAddress();
        Intrinsics.checkNotNullExpressionValue(address2, "address() as InetSocketAddress).address");
        return address2;
    }
}
