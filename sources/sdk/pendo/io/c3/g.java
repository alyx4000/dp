package sdk.pendo.io.c3;

import androidx.core.app.NotificationCompat;
import com.facebook.common.callercontext.ContextChain;
import io.sentry.SentryBaseEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.w;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0011\u001a\u00020\u0013\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+JM\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u0011\u001a\u00020\u00138\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010\b\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b%\u0010\u001c\u001a\u0004\b\u001d\u0010&R\u001a\u0010\t\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b'\u0010\u001c\u001a\u0004\b%\u0010&R\u001a\u0010\n\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b(\u0010\u001c\u001a\u0004\b(\u0010&R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001c¨\u0006,"}, d2 = {"Lsdk/pendo/io/c3/g;", "Lsdk/pendo/io/w2/w$a;", "", "index", "Lsdk/pendo/io/b3/c;", "exchange", "Lsdk/pendo/io/w2/b0;", SentryBaseEvent.JsonKeys.REQUEST, "connectTimeoutMillis", "readTimeoutMillis", "writeTimeoutMillis", "a", "(ILsdk/pendo/io/b3/c;Lsdk/pendo/io/w2/b0;III)Lsdk/pendo/io/c3/g;", "Lsdk/pendo/io/w2/j;", "b", ContextChain.TAG_INFRA, "Lsdk/pendo/io/w2/e;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/w2/d0;", "Lsdk/pendo/io/b3/e;", "Lsdk/pendo/io/b3/e;", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "", "Lsdk/pendo/io/w2/w;", "Ljava/util/List;", "interceptors", "c", "I", "d", "Lsdk/pendo/io/b3/c;", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "e", "Lsdk/pendo/io/w2/b0;", "getRequest$okhttp", "()Lokhttp3/Request;", "f", "()I", "g", "h", "calls", "<init>", "(Lokhttp3/internal/connection/RealCall;Ljava/util/List;ILokhttp3/internal/connection/Exchange;Lokhttp3/Request;III)V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class g implements w.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sdk.pendo.io.b3.e call;

    /* renamed from: b, reason: from kotlin metadata */
    private final List<w> interceptors;

    /* renamed from: c, reason: from kotlin metadata */
    private final int index;

    /* renamed from: d, reason: from kotlin metadata */
    private final sdk.pendo.io.b3.c exchange;

    /* renamed from: e, reason: from kotlin metadata */
    private final b0 request;

    /* renamed from: f, reason: from kotlin metadata */
    private final int connectTimeoutMillis;

    /* renamed from: g, reason: from kotlin metadata */
    private final int readTimeoutMillis;

    /* renamed from: h, reason: from kotlin metadata */
    private final int writeTimeoutMillis;

    /* renamed from: i, reason: from kotlin metadata */
    private int calls;

    /* JADX WARN: Multi-variable type inference failed */
    public g(sdk.pendo.io.b3.e call, List<? extends w> interceptors, int i, sdk.pendo.io.b3.c cVar, b0 request, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(request, "request");
        this.call = call;
        this.interceptors = interceptors;
        this.index = i;
        this.exchange = cVar;
        this.request = request;
        this.connectTimeoutMillis = i2;
        this.readTimeoutMillis = i3;
        this.writeTimeoutMillis = i4;
    }

    public final g a(int index, sdk.pendo.io.b3.c exchange, b0 request, int connectTimeoutMillis, int readTimeoutMillis, int writeTimeoutMillis) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new g(this.call, this.interceptors, index, exchange, request, connectTimeoutMillis, readTimeoutMillis, writeTimeoutMillis);
    }

    @Override // sdk.pendo.io.w2.w.a
    public sdk.pendo.io.w2.j b() {
        sdk.pendo.io.b3.c cVar = this.exchange;
        if (cVar != null) {
            return cVar.getConnection();
        }
        return null;
    }

    /* renamed from: c, reason: from getter */
    public final sdk.pendo.io.b3.e getCall() {
        return this.call;
    }

    @Override // sdk.pendo.io.w2.w.a
    public sdk.pendo.io.w2.e call() {
        return this.call;
    }

    /* renamed from: d, reason: from getter */
    public final int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    /* renamed from: e, reason: from getter */
    public final sdk.pendo.io.b3.c getExchange() {
        return this.exchange;
    }

    /* renamed from: f, reason: from getter */
    public final int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public final b0 g() {
        return this.request;
    }

    /* renamed from: h, reason: from getter */
    public final int getWriteTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    public int i() {
        return this.readTimeoutMillis;
    }

    public static /* synthetic */ g a(g gVar, int i, sdk.pendo.io.b3.c cVar, b0 b0Var, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = gVar.index;
        }
        if ((i5 & 2) != 0) {
            cVar = gVar.exchange;
        }
        sdk.pendo.io.b3.c cVar2 = cVar;
        if ((i5 & 4) != 0) {
            b0Var = gVar.request;
        }
        b0 b0Var2 = b0Var;
        if ((i5 & 8) != 0) {
            i2 = gVar.connectTimeoutMillis;
        }
        int i6 = i2;
        if ((i5 & 16) != 0) {
            i3 = gVar.readTimeoutMillis;
        }
        int i7 = i3;
        if ((i5 & 32) != 0) {
            i4 = gVar.writeTimeoutMillis;
        }
        return gVar.a(i, cVar2, b0Var2, i6, i7, i4);
    }

    @Override // sdk.pendo.io.w2.w.a
    public d0 a(b0 request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (!(this.index < this.interceptors.size())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.calls++;
        sdk.pendo.io.b3.c cVar = this.exchange;
        if (cVar != null) {
            if (!cVar.getFinder().a(request.i())) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port").toString());
            }
            if (!(this.calls == 1)) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once").toString());
            }
        }
        g a2 = a(this, this.index + 1, null, request, 0, 0, 0, 58, null);
        w wVar = this.interceptors.get(this.index);
        d0 a3 = wVar.a(a2);
        if (a3 == null) {
            throw new NullPointerException("interceptor " + wVar + " returned null");
        }
        if (this.exchange != null) {
            if (!(this.index + 1 >= this.interceptors.size() || a2.calls == 1)) {
                throw new IllegalStateException(("network interceptor " + wVar + " must call proceed() exactly once").toString());
            }
        }
        if (a3.b() != null) {
            return a3;
        }
        throw new IllegalStateException(("interceptor " + wVar + " returned a response with no body").toString());
    }

    @Override // sdk.pendo.io.w2.w.a
    /* renamed from: a, reason: from getter */
    public b0 getRequest() {
        return this.request;
    }
}
