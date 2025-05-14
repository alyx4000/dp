package sdk.pendo.io.m;

import android.support.v4.media.session.PlaybackStateCompat;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import sdk.pendo.io.f.g;
import sdk.pendo.io.f.i;
import sdk.pendo.io.j.f;
import sdk.pendo.io.m.e;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.d;
import sdk.pendo.io.w2.v;
import sdk.pendo.io.w2.z;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J2\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/m/a;", "", "", "baseUrl", "Lsdk/pendo/io/w2/z;", "okHttpClient", "", "networkTimeoutSeconds", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lsdk/pendo/io/m/c;", "a", "logListService", "Lsdk/pendo/io/c/a;", "diskCache", "Lsdk/pendo/io/d/a;", "Lsdk/pendo/io/m/b;", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1347a = new a();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lsdk/pendo/io/m/a$a;", "Lsdk/pendo/io/f/c;", "Lsdk/pendo/io/m/e;", "value", "", "isValid", "(Lcom/appmattus/certificatetransparency/loglist/RawLogListResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    /* renamed from: sdk.pendo.io.m.a$a, reason: collision with other inner class name */
    private static final class C0192a extends sdk.pendo.io.f.c<e> {
        @Override // sdk.pendo.io.d.a
        public /* bridge */ /* synthetic */ Object a(Object obj, Continuation continuation) {
            return a((e) obj, (Continuation<? super Boolean>) continuation);
        }

        public Object a(e eVar, Continuation<? super Boolean> continuation) {
            return Boxing.boxBoolean(eVar instanceof e.b);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lsdk/pendo/io/m/e;", "it", "Lsdk/pendo/io/m/b;", "a", "(Lsdk/pendo/io/m/e;)Lsdk/pendo/io/m/b;"}, k = 3, mv = {1, 6, 0})
    static final class b extends Lambda implements Function1<e, sdk.pendo.io.m.b> {
        final /* synthetic */ sdk.pendo.io.h.d f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(sdk.pendo.io.h.d dVar) {
            super(1);
            this.f = dVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final sdk.pendo.io.m.b invoke(e it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return this.f.a(it);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0007\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"sdk/pendo/io/m/a$c", "Lsdk/pendo/io/m/c;", "", "pathSegment", "", "maxSize", "", "a", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static final class c implements sdk.pendo.io.m.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1348a;
        final /* synthetic */ z b;

        c(String str, z zVar) {
            this.f1348a = str;
            this.b = zVar;
        }

        private final Object a(String str, long j, Continuation<? super byte[]> continuation) {
            return sdk.pendo.io.f.a.a(this.b.a(new b0.a().a(v.INSTANCE.b(this.f1348a).j().a(str).a()).a(new d.a().b().c().a()).a("Max-Size", String.valueOf(j)).a()), continuation);
        }

        @Override // sdk.pendo.io.m.c
        public Object b(Continuation<? super byte[]> continuation) {
            return a("log_list.json", 1048576L, continuation);
        }

        @Override // sdk.pendo.io.m.c
        public Object c(Continuation<? super byte[]> continuation) {
            return a("log_list.zip", PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, continuation);
        }

        @Override // sdk.pendo.io.m.c
        public Object a(Continuation<? super byte[]> continuation) {
            return a("log_list.sig", 512L, continuation);
        }
    }

    private a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final sdk.pendo.io.d.a<sdk.pendo.io.m.b> a(sdk.pendo.io.m.c logListService, sdk.pendo.io.c.a diskCache) {
        sdk.pendo.io.d.a a2;
        Intrinsics.checkNotNullParameter(logListService, "logListService");
        sdk.pendo.io.h.d dVar = new sdk.pendo.io.h.d(null, null, 3, null);
        sdk.pendo.io.d.a c0192a = new C0192a();
        if (diskCache != null && (a2 = c0192a.a(diskCache)) != null) {
            c0192a = a2;
        }
        return c0192a.a(new i(logListService)).a(new g(logListService)).a(new b(dVar)).a();
    }

    public final sdk.pendo.io.m.c a(String baseUrl, z okHttpClient, long networkTimeoutSeconds, X509TrustManager trustManager) {
        z.a aVar;
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        if (okHttpClient == null || (aVar = okHttpClient.y()) == null) {
            aVar = new z.a();
        }
        if (trustManager != null) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("SSL");
                Intrinsics.checkNotNullExpressionValue(sSLContext, "getInstance(\"SSL\")");
                sSLContext.init(null, new X509TrustManager[]{trustManager}, new SecureRandom());
                SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
                Intrinsics.checkNotNullExpressionValue(socketFactory, "sslContext.socketFactory");
                aVar.a(socketFactory, trustManager);
            } catch (KeyManagementException unused) {
                throw new IllegalStateException("Unable to create an SSLContext");
            } catch (NoSuchAlgorithmException unused2) {
                throw new IllegalStateException("Unable to create an SSLContext");
            }
        }
        aVar.a(new f());
        TimeUnit timeUnit = TimeUnit.SECONDS;
        aVar.a(networkTimeoutSeconds, timeUnit);
        aVar.b(networkTimeoutSeconds, timeUnit);
        aVar.c(networkTimeoutSeconds, timeUnit);
        aVar.a((sdk.pendo.io.w2.c) null);
        return new c(baseUrl, aVar.a());
    }

    public static /* synthetic */ sdk.pendo.io.m.c a(a aVar, String str, z zVar, long j, X509TrustManager x509TrustManager, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "https://www.gstatic.com/ct/log_list/v3/";
        }
        z zVar2 = (i & 2) != 0 ? null : zVar;
        if ((i & 4) != 0) {
            j = 30;
        }
        return aVar.a(str, zVar2, j, (i & 8) == 0 ? x509TrustManager : null);
    }
}
