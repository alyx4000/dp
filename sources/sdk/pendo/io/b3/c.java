package sdk.pendo.io.b3;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.extole.android.sdk.impl.http.HttpRequest;
import com.facebook.common.callercontext.ContextChain;
import io.sentry.SentryBaseEvent;
import io.sentry.protocol.Response;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.j3.d;
import sdk.pendo.io.k3.a0;
import sdk.pendo.io.k3.o;
import sdk.pendo.io.k3.y;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.c0;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.e0;
import sdk.pendo.io.w2.r;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u0005\u0012B'\u0012\u0006\u0010#\u001a\u00020\u001f\u0012\u0006\u0010(\u001a\u00020$\u0012\u0006\u0010-\u001a\u00020)\u0012\u0006\u00100\u001a\u00020.¢\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J9\u0010\u0005\u001a\u00028\u0000\"\n\b\u0000\u0010\u0018*\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0004R\u001a\u0010#\u001a\u00020\u001f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010(\u001a\u00020$8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010-\u001a\u00020)8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010*\u001a\u0004\b+\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010/R$\u00105\u001a\u00020\b2\u0006\u00101\u001a\u00020\b8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u0003\u00102\u001a\u0004\b3\u00104R$\u00108\u001a\u00020\b2\u0006\u00101\u001a\u00020\b8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b6\u00102\u001a\u0004\b7\u00104R\u001a\u0010>\u001a\u0002098\u0000X\u0080\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b?\u00104¨\u0006C"}, d2 = {"Lsdk/pendo/io/b3/c;", "", "Ljava/io/IOException;", "e", "", "a", "Lsdk/pendo/io/w2/b0;", SentryBaseEvent.JsonKeys.REQUEST, "", "duplex", "Lsdk/pendo/io/k3/y;", "d", "c", "o", "expectContinue", "Lsdk/pendo/io/w2/d0$a;", "Lsdk/pendo/io/w2/d0;", Response.TYPE, "b", "Lsdk/pendo/io/w2/e0;", "Lsdk/pendo/io/j3/d$d;", "l", ContextChain.TAG_PRODUCT, "m", ExifInterface.LONGITUDE_EAST, "", "bytesRead", "responseDone", "requestDone", "(JZZLjava/io/IOException;)Ljava/io/IOException;", "n", "Lsdk/pendo/io/b3/e;", "Lsdk/pendo/io/b3/e;", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/w2/r;", "Lsdk/pendo/io/w2/r;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "eventListener", "Lsdk/pendo/io/b3/d;", "Lsdk/pendo/io/b3/d;", "getFinder$okhttp", "()Lokhttp3/internal/connection/ExchangeFinder;", "finder", "Lsdk/pendo/io/c3/d;", "Lsdk/pendo/io/c3/d;", "codec", "<set-?>", "Z", "k", "()Z", "isDuplex", "f", ContextChain.TAG_INFRA, "hasFailure", "Lsdk/pendo/io/b3/f;", "g", "Lsdk/pendo/io/b3/f;", "getConnection$okhttp", "()Lokhttp3/internal/connection/RealConnection;", "connection", "j", "isCoalescedConnection", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;Lokhttp3/internal/connection/ExchangeFinder;Lokhttp3/internal/http/ExchangeCodec;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final e call;

    /* renamed from: b, reason: from kotlin metadata */
    private final r eventListener;

    /* renamed from: c, reason: from kotlin metadata */
    private final d finder;

    /* renamed from: d, reason: from kotlin metadata */
    private final sdk.pendo.io.c3.d codec;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean isDuplex;

    /* renamed from: f, reason: from kotlin metadata */
    private boolean hasFailure;

    /* renamed from: g, reason: from kotlin metadata */
    private final f connection;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u0005\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013¨\u0006\u001d"}, d2 = {"Lsdk/pendo/io/b3/c$a;", "Lsdk/pendo/io/k3/i;", "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, "e", "a", "(Ljava/io/IOException;)Ljava/io/IOException;", "Lsdk/pendo/io/k3/d;", "source", "", "byteCount", "", "flush", "close", "s", "J", "contentLength", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Z", "completed", "f0", "bytesReceived", "t0", "closed", "Lsdk/pendo/io/k3/y;", "delegate", "<init>", "(Lokhttp3/internal/connection/Exchange;Lokio/Sink;J)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    private final class a extends sdk.pendo.io.k3.i {

        /* renamed from: A, reason: from kotlin metadata */
        private boolean completed;

        /* renamed from: f0, reason: from kotlin metadata */
        private long bytesReceived;

        /* renamed from: s, reason: from kotlin metadata */
        private final long contentLength;

        /* renamed from: t0, reason: from kotlin metadata */
        private boolean closed;
        final /* synthetic */ c u0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, y delegate, long j) {
            super(delegate);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.u0 = cVar;
            this.contentLength = j;
        }

        private final <E extends IOException> E a(E e) {
            if (this.completed) {
                return e;
            }
            this.completed = true;
            return (E) this.u0.a(this.bytesReceived, false, true, e);
        }

        @Override // sdk.pendo.io.k3.i, sdk.pendo.io.k3.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j = this.contentLength;
            if (j != -1 && this.bytesReceived != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                a(null);
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // sdk.pendo.io.k3.i, sdk.pendo.io.k3.y, java.io.Flushable
        public void flush() {
            try {
                super.flush();
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // sdk.pendo.io.k3.i, sdk.pendo.io.k3.y
        public void a(sdk.pendo.io.k3.d source, long byteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            long j = this.contentLength;
            if (j != -1 && this.bytesReceived + byteCount > j) {
                throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + byteCount));
            }
            try {
                super.a(source, byteCount);
                this.bytesReceived += byteCount;
            } catch (IOException e) {
                throw a(e);
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J!\u0010\f\u001a\u00028\u0000\"\n\b\u0000\u0010\n*\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015¨\u0006\u001f"}, d2 = {"Lsdk/pendo/io/b3/c$b;", "Lsdk/pendo/io/k3/j;", "Lsdk/pendo/io/k3/d;", "sink", "", "byteCount", "c", "", "close", "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, "e", "a", "(Ljava/io/IOException;)Ljava/io/IOException;", "s", "J", "contentLength", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "bytesReceived", "", "f0", "Z", "invokeStartEvent", "t0", "completed", "u0", "closed", "Lsdk/pendo/io/k3/a0;", "delegate", "<init>", "(Lokhttp3/internal/connection/Exchange;Lokio/Source;J)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public final class b extends sdk.pendo.io.k3.j {

        /* renamed from: A, reason: from kotlin metadata */
        private long bytesReceived;

        /* renamed from: f0, reason: from kotlin metadata */
        private boolean invokeStartEvent;

        /* renamed from: s, reason: from kotlin metadata */
        private final long contentLength;

        /* renamed from: t0, reason: from kotlin metadata */
        private boolean completed;

        /* renamed from: u0, reason: from kotlin metadata */
        private boolean closed;
        final /* synthetic */ c v0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, a0 delegate, long j) {
            super(delegate);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.v0 = cVar;
            this.contentLength = j;
            this.invokeStartEvent = true;
            if (j == 0) {
                a(null);
            }
        }

        public final <E extends IOException> E a(E e) {
            if (this.completed) {
                return e;
            }
            this.completed = true;
            if (e == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                this.v0.getEventListener().f(this.v0.getCall());
            }
            return (E) this.v0.a(this.bytesReceived, true, false, e);
        }

        @Override // sdk.pendo.io.k3.j, sdk.pendo.io.k3.a0
        public long c(sdk.pendo.io.k3.d sink, long byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long c = getDelegate().c(sink, byteCount);
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.v0.getEventListener().f(this.v0.getCall());
                }
                if (c == -1) {
                    a(null);
                    return -1L;
                }
                long j = this.bytesReceived + c;
                long j2 = this.contentLength;
                if (j2 != -1 && j > j2) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j);
                }
                this.bytesReceived = j;
                if (j == j2) {
                    a(null);
                }
                return c;
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // sdk.pendo.io.k3.j, sdk.pendo.io.k3.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                a(null);
            } catch (IOException e) {
                throw a(e);
            }
        }
    }

    public c(e call, r eventListener, d finder, sdk.pendo.io.c3.d codec) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        Intrinsics.checkNotNullParameter(finder, "finder");
        Intrinsics.checkNotNullParameter(codec, "codec");
        this.call = call;
        this.eventListener = eventListener;
        this.finder = finder;
        this.codec = codec;
        this.connection = codec.getConnection();
    }

    public final <E extends IOException> E a(long bytesRead, boolean responseDone, boolean requestDone, E e) {
        if (e != null) {
            a(e);
        }
        if (requestDone) {
            r rVar = this.eventListener;
            e eVar = this.call;
            if (e != null) {
                rVar.b(eVar, e);
            } else {
                rVar.a(eVar, bytesRead);
            }
        }
        if (responseDone) {
            if (e != null) {
                this.eventListener.c(this.call, e);
            } else {
                this.eventListener.b(this.call, bytesRead);
            }
        }
        return (E) this.call.a(this, requestDone, responseDone, e);
    }

    public final void b() {
        this.codec.cancel();
        this.call.a(this, true, true, null);
    }

    public final void c() {
        try {
            this.codec.a();
        } catch (IOException e) {
            this.eventListener.b(this.call, e);
            a(e);
            throw e;
        }
    }

    public final void d() {
        try {
            this.codec.b();
        } catch (IOException e) {
            this.eventListener.b(this.call, e);
            a(e);
            throw e;
        }
    }

    /* renamed from: e, reason: from getter */
    public final e getCall() {
        return this.call;
    }

    /* renamed from: f, reason: from getter */
    public final f getConnection() {
        return this.connection;
    }

    /* renamed from: g, reason: from getter */
    public final r getEventListener() {
        return this.eventListener;
    }

    /* renamed from: h, reason: from getter */
    public final d getFinder() {
        return this.finder;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getHasFailure() {
        return this.hasFailure;
    }

    public final boolean j() {
        return !Intrinsics.areEqual(this.finder.getAddress().getUrl().getHost(), this.connection.getRoute().getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String().getUrl().getHost());
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsDuplex() {
        return this.isDuplex;
    }

    public final d.AbstractC0159d l() {
        this.call.p();
        return this.codec.getConnection().a(this);
    }

    public final void m() {
        this.codec.getConnection().m();
    }

    public final void n() {
        this.call.a(this, true, false, null);
    }

    public final void o() {
        this.eventListener.g(this.call);
    }

    public final void p() {
        a(-1L, true, true, null);
    }

    public final void a() {
        this.codec.cancel();
    }

    public final void b(d0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.eventListener.c(this.call, response);
    }

    public final y a(b0 request, boolean duplex) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.isDuplex = duplex;
        c0 body = request.getBody();
        Intrinsics.checkNotNull(body);
        long a2 = body.a();
        this.eventListener.d(this.call);
        return new a(this, this.codec.a(request, a2), a2);
    }

    public final e0 a(d0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            String a2 = d0.a(response, HttpRequest.HEADER_CONTENT_TYPE, null, 2, null);
            long b2 = this.codec.b(response);
            return new sdk.pendo.io.c3.h(a2, b2, o.a(new b(this, this.codec.a(response), b2)));
        } catch (IOException e) {
            this.eventListener.c(this.call, e);
            a(e);
            throw e;
        }
    }

    public final d0.a a(boolean expectContinue) {
        try {
            d0.a a2 = this.codec.a(expectContinue);
            if (a2 != null) {
                a2.a(this);
            }
            return a2;
        } catch (IOException e) {
            this.eventListener.c(this.call, e);
            a(e);
            throw e;
        }
    }

    private final void a(IOException e) {
        this.hasFailure = true;
        this.finder.a(e);
        this.codec.getConnection().a(this.call, e);
    }

    public final void a(b0 request) {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            this.eventListener.e(this.call);
            this.codec.a(request);
            this.eventListener.a(this.call, request);
        } catch (IOException e) {
            this.eventListener.b(this.call, e);
            a(e);
            throw e;
        }
    }
}
