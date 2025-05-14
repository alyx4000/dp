package sdk.pendo.io.d3;

import io.sentry.ProfilingTraceData;
import io.sentry.SentryBaseEvent;
import io.sentry.SentryEnvelopeItemHeader;
import io.sentry.protocol.Response;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;
import sdk.pendo.io.c3.d;
import sdk.pendo.io.c3.i;
import sdk.pendo.io.k3.a0;
import sdk.pendo.io.k3.b0;
import sdk.pendo.io.k3.k;
import sdk.pendo.io.k3.y;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.n;
import sdk.pendo.io.w2.u;
import sdk.pendo.io.w2.v;
import sdk.pendo.io.w2.z;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 :2\u00020\u0001:\u0007\b\u0015&\u0003\u0004\u000b2B)\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010$\u001a\u00020 \u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010+\u001a\u00020)¢\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\b\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\b\u001a\u00020\u000eH\u0016J\u0016\u0010\b\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018J\u0012\u0010\b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u000e\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001eR\u001a\u0010$\u001a\u00020 8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010*R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010-R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00105\u001a\u00020\u001a*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0018\u00105\u001a\u00020\u001a*\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00107¨\u0006;"}, d2 = {"Lsdk/pendo/io/d3/b;", "Lsdk/pendo/io/c3/d;", "Lsdk/pendo/io/k3/y;", "d", "e", "", SentryEnvelopeItemHeader.JsonKeys.LENGTH, "Lsdk/pendo/io/k3/a0;", "a", "Lsdk/pendo/io/w2/v;", "url", "f", "Lsdk/pendo/io/k3/k;", ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, "", "Lsdk/pendo/io/w2/b0;", SentryBaseEvent.JsonKeys.REQUEST, "contentLength", "cancel", "Lsdk/pendo/io/w2/d0;", Response.TYPE, "b", "Lsdk/pendo/io/w2/u;", "headers", "", "requestLine", "", "expectContinue", "Lsdk/pendo/io/w2/d0$a;", "Lsdk/pendo/io/w2/z;", "Lsdk/pendo/io/w2/z;", "client", "Lsdk/pendo/io/b3/f;", "Lsdk/pendo/io/b3/f;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "connection", "Lsdk/pendo/io/k3/f;", "c", "Lsdk/pendo/io/k3/f;", "source", "Lsdk/pendo/io/k3/e;", "Lsdk/pendo/io/k3/e;", "sink", "", "I", "state", "Lsdk/pendo/io/d3/a;", "Lsdk/pendo/io/d3/a;", "headersReader", "g", "Lsdk/pendo/io/w2/u;", "trailers", "isChunked", "(Lokhttp3/Request;)Z", "(Lokhttp3/Response;)Z", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lokio/BufferedSource;Lokio/BufferedSink;)V", "h", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final z client;

    /* renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.b3.f connection;

    /* renamed from: c, reason: from kotlin metadata */
    private final sdk.pendo.io.k3.f source;

    /* renamed from: d, reason: from kotlin metadata */
    private final sdk.pendo.io.k3.e sink;

    /* renamed from: e, reason: from kotlin metadata */
    private int state;

    /* renamed from: f, reason: from kotlin metadata */
    private final sdk.pendo.io.d3.a headersReader;

    /* renamed from: g, reason: from kotlin metadata */
    private u trailers;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b¢\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\n\u001a\u00020\tR\u001a\u0010\u0010\u001a\u00020\u000b8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0014\u0010\u0016¨\u0006\u001a"}, d2 = {"Lsdk/pendo/io/d3/b$a;", "Lsdk/pendo/io/k3/a0;", "Lsdk/pendo/io/k3/b0;", "d", "Lsdk/pendo/io/k3/d;", "sink", "", "byteCount", "c", "", "b", "Lsdk/pendo/io/k3/k;", "f", "Lsdk/pendo/io/k3/k;", "getTimeout", "()Lokio/ForwardingTimeout;", ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, "", "s", "Z", "a", "()Z", "(Z)V", "closed", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    private abstract class a implements a0 {

        /* renamed from: f, reason: from kotlin metadata */
        private final k timeout;

        /* renamed from: s, reason: from kotlin metadata */
        private boolean closed;

        public a() {
            this.timeout = new k(b.this.source.getTimeout());
        }

        /* renamed from: a, reason: from getter */
        protected final boolean getClosed() {
            return this.closed;
        }

        public final void b() {
            if (b.this.state == 6) {
                return;
            }
            if (b.this.state != 5) {
                throw new IllegalStateException("state: " + b.this.state);
            }
            b.this.a(this.timeout);
            b.this.state = 6;
        }

        @Override // sdk.pendo.io.k3.a0
        public long c(sdk.pendo.io.k3.d sink, long byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            try {
                return b.this.source.c(sink, byteCount);
            } catch (IOException e) {
                b.this.getConnection().m();
                b();
                throw e;
            }
        }

        @Override // sdk.pendo.io.k3.a0
        /* renamed from: d */
        public b0 getTimeout() {
            return this.timeout;
        }

        protected final void a(boolean z) {
            this.closed = z;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/d3/b$b;", "Lsdk/pendo/io/k3/y;", "Lsdk/pendo/io/k3/b0;", "d", "Lsdk/pendo/io/k3/d;", "source", "", "byteCount", "", "a", "flush", "close", "Lsdk/pendo/io/k3/k;", "f", "Lsdk/pendo/io/k3/k;", ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, "", "s", "Z", "closed", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.d3.b$b, reason: collision with other inner class name */
    private final class C0111b implements y {

        /* renamed from: f, reason: from kotlin metadata */
        private final k timeout;

        /* renamed from: s, reason: from kotlin metadata */
        private boolean closed;

        public C0111b() {
            this.timeout = new k(b.this.sink.getTimeout());
        }

        @Override // sdk.pendo.io.k3.y
        public void a(sdk.pendo.io.k3.d source, long byteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            if (byteCount == 0) {
                return;
            }
            b.this.sink.b(byteCount);
            b.this.sink.a(IOUtils.LINE_SEPARATOR_WINDOWS);
            b.this.sink.a(source, byteCount);
            b.this.sink.a(IOUtils.LINE_SEPARATOR_WINDOWS);
        }

        @Override // sdk.pendo.io.k3.y, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            b.this.sink.a("0\r\n\r\n");
            b.this.a(this.timeout);
            b.this.state = 3;
        }

        @Override // sdk.pendo.io.k3.y
        /* renamed from: d */
        public b0 getTimeout() {
            return this.timeout;
        }

        @Override // sdk.pendo.io.k3.y, java.io.Flushable
        public synchronized void flush() {
            if (this.closed) {
                return;
            }
            b.this.sink.flush();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/d3/b$c;", "Lsdk/pendo/io/d3/b$a;", "Lsdk/pendo/io/d3/b;", "", "e", "Lsdk/pendo/io/k3/d;", "sink", "", "byteCount", "c", "close", "Lsdk/pendo/io/w2/v;", "f0", "Lsdk/pendo/io/w2/v;", "url", "t0", "J", "bytesRemainingInChunk", "", "u0", "Z", "hasMoreChunks", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;Lokhttp3/HttpUrl;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    private final class c extends a {

        /* renamed from: f0, reason: from kotlin metadata */
        private final v url;

        /* renamed from: t0, reason: from kotlin metadata */
        private long bytesRemainingInChunk;

        /* renamed from: u0, reason: from kotlin metadata */
        private boolean hasMoreChunks;
        final /* synthetic */ b v0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, v url) {
            super();
            Intrinsics.checkNotNullParameter(url, "url");
            this.v0 = bVar;
            this.url = url;
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
        }

        private final void e() {
            if (this.bytesRemainingInChunk != -1) {
                this.v0.source.g();
            }
            try {
                this.bytesRemainingInChunk = this.v0.source.k();
                String obj = StringsKt.trim((CharSequence) this.v0.source.g()).toString();
                if (this.bytesRemainingInChunk >= 0) {
                    if (!(obj.length() > 0) || StringsKt.startsWith$default(obj, ";", false, 2, (Object) null)) {
                        if (this.bytesRemainingInChunk == 0) {
                            this.hasMoreChunks = false;
                            b bVar = this.v0;
                            bVar.trailers = bVar.headersReader.a();
                            z zVar = this.v0.client;
                            Intrinsics.checkNotNull(zVar);
                            n cookieJar = zVar.getCookieJar();
                            v vVar = this.url;
                            u uVar = this.v0.trailers;
                            Intrinsics.checkNotNull(uVar);
                            sdk.pendo.io.c3.e.a(cookieJar, vVar, uVar);
                            b();
                            return;
                        }
                        return;
                    }
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + obj + Typography.quote);
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // sdk.pendo.io.d3.b.a, sdk.pendo.io.k3.a0
        public long c(sdk.pendo.io.k3.d sink, long byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!(byteCount >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            if (!(!getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.hasMoreChunks) {
                return -1L;
            }
            long j = this.bytesRemainingInChunk;
            if (j == 0 || j == -1) {
                e();
                if (!this.hasMoreChunks) {
                    return -1L;
                }
            }
            long c = super.c(sink, Math.min(byteCount, this.bytesRemainingInChunk));
            if (c != -1) {
                this.bytesRemainingInChunk -= c;
                return c;
            }
            this.v0.getConnection().m();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            b();
            throw protocolException;
        }

        @Override // sdk.pendo.io.k3.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.hasMoreChunks && !sdk.pendo.io.x2.b.a(this, 100, TimeUnit.MILLISECONDS)) {
                this.v0.getConnection().m();
                b();
            }
            a(true);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/d3/b$e;", "Lsdk/pendo/io/d3/b$a;", "Lsdk/pendo/io/d3/b;", "Lsdk/pendo/io/k3/d;", "sink", "", "byteCount", "c", "", "close", "f0", "J", "bytesRemaining", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;J)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    private final class e extends a {

        /* renamed from: f0, reason: from kotlin metadata */
        private long bytesRemaining;

        public e(long j) {
            super();
            this.bytesRemaining = j;
            if (j == 0) {
                b();
            }
        }

        @Override // sdk.pendo.io.d3.b.a, sdk.pendo.io.k3.a0
        public long c(sdk.pendo.io.k3.d sink, long byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!(byteCount >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            if (!(!getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            long j = this.bytesRemaining;
            if (j == 0) {
                return -1L;
            }
            long c = super.c(sink, Math.min(j, byteCount));
            if (c == -1) {
                b.this.getConnection().m();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                b();
                throw protocolException;
            }
            long j2 = this.bytesRemaining - c;
            this.bytesRemaining = j2;
            if (j2 == 0) {
                b();
            }
            return c;
        }

        @Override // sdk.pendo.io.k3.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.bytesRemaining != 0 && !sdk.pendo.io.x2.b.a(this, 100, TimeUnit.MILLISECONDS)) {
                b.this.getConnection().m();
                b();
            }
            a(true);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/d3/b$f;", "Lsdk/pendo/io/k3/y;", "Lsdk/pendo/io/k3/b0;", "d", "Lsdk/pendo/io/k3/d;", "source", "", "byteCount", "", "a", "flush", "close", "Lsdk/pendo/io/k3/k;", "f", "Lsdk/pendo/io/k3/k;", ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, "", "s", "Z", "closed", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    private final class f implements y {

        /* renamed from: f, reason: from kotlin metadata */
        private final k timeout;

        /* renamed from: s, reason: from kotlin metadata */
        private boolean closed;

        public f() {
            this.timeout = new k(b.this.sink.getTimeout());
        }

        @Override // sdk.pendo.io.k3.y
        public void a(sdk.pendo.io.k3.d source, long byteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            sdk.pendo.io.x2.b.a(source.getSize(), 0L, byteCount);
            b.this.sink.a(source, byteCount);
        }

        @Override // sdk.pendo.io.k3.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            b.this.a(this.timeout);
            b.this.state = 3;
        }

        @Override // sdk.pendo.io.k3.y
        /* renamed from: d */
        public b0 getTimeout() {
            return this.timeout;
        }

        @Override // sdk.pendo.io.k3.y, java.io.Flushable
        public void flush() {
            if (this.closed) {
                return;
            }
            b.this.sink.flush();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/d3/b$g;", "Lsdk/pendo/io/d3/b$a;", "Lsdk/pendo/io/d3/b;", "Lsdk/pendo/io/k3/d;", "sink", "", "byteCount", "c", "", "close", "", "f0", "Z", "inputExhausted", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    private final class g extends a {

        /* renamed from: f0, reason: from kotlin metadata */
        private boolean inputExhausted;

        public g() {
            super();
        }

        @Override // sdk.pendo.io.d3.b.a, sdk.pendo.io.k3.a0
        public long c(sdk.pendo.io.k3.d sink, long byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!(byteCount >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            if (!(!getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.inputExhausted) {
                return -1L;
            }
            long c = super.c(sink, byteCount);
            if (c != -1) {
                return c;
            }
            this.inputExhausted = true;
            b();
            return -1L;
        }

        @Override // sdk.pendo.io.k3.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (!this.inputExhausted) {
                b();
            }
            a(true);
        }
    }

    public b(z zVar, sdk.pendo.io.b3.f connection, sdk.pendo.io.k3.f source, sdk.pendo.io.k3.e sink) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.client = zVar;
        this.connection = connection;
        this.source = source;
        this.sink = sink;
        this.headersReader = new sdk.pendo.io.d3.a(source);
    }

    @Override // sdk.pendo.io.c3.d
    public void cancel() {
        getConnection().d();
    }

    private final y d() {
        if (!(this.state == 1)) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 2;
        return new C0111b();
    }

    private final y e() {
        if (!(this.state == 1)) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 2;
        return new f();
    }

    private final a0 f() {
        if (!(this.state == 4)) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 5;
        getConnection().m();
        return new g();
    }

    @Override // sdk.pendo.io.c3.d
    public void b() {
        this.sink.flush();
    }

    @Override // sdk.pendo.io.c3.d
    /* renamed from: c, reason: from getter */
    public sdk.pendo.io.b3.f getConnection() {
        return this.connection;
    }

    private final boolean b(sdk.pendo.io.w2.b0 b0Var) {
        return StringsKt.equals("chunked", b0Var.a("Transfer-Encoding"), true);
    }

    private final boolean c(d0 d0Var) {
        return StringsKt.equals("chunked", d0.a(d0Var, "Transfer-Encoding", null, 2, null), true);
    }

    public final void d(d0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        long a2 = sdk.pendo.io.x2.b.a(response);
        if (a2 == -1) {
            return;
        }
        a0 a3 = a(a2);
        sdk.pendo.io.x2.b.b(a3, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        a3.close();
    }

    @Override // sdk.pendo.io.c3.d
    public long b(d0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!sdk.pendo.io.c3.e.b(response)) {
            return 0L;
        }
        if (c(response)) {
            return -1L;
        }
        return sdk.pendo.io.x2.b.a(response);
    }

    @Override // sdk.pendo.io.c3.d
    public y a(sdk.pendo.io.w2.b0 request, long contentLength) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (request.getBody() != null && request.getBody().c()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (b(request)) {
            return d();
        }
        if (contentLength != -1) {
            return e();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(k timeout) {
        b0 delegate = timeout.getDelegate();
        timeout.a(b0.e);
        delegate.a();
        delegate.b();
    }

    @Override // sdk.pendo.io.c3.d
    public void a() {
        this.sink.flush();
    }

    private final a0 a(v url) {
        if (!(this.state == 4)) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 5;
        return new c(this, url);
    }

    private final a0 a(long length) {
        if (!(this.state == 4)) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 5;
        return new e(length);
    }

    @Override // sdk.pendo.io.c3.d
    public a0 a(d0 response) {
        long a2;
        Intrinsics.checkNotNullParameter(response, "response");
        if (!sdk.pendo.io.c3.e.b(response)) {
            a2 = 0;
        } else {
            if (c(response)) {
                return a(response.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String().i());
            }
            a2 = sdk.pendo.io.x2.b.a(response);
            if (a2 == -1) {
                return f();
            }
        }
        return a(a2);
    }

    @Override // sdk.pendo.io.c3.d
    public d0.a a(boolean expectContinue) {
        int i = this.state;
        boolean z = false;
        if (!(i == 1 || i == 2 || i == 3)) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        try {
            sdk.pendo.io.c3.k a2 = sdk.pendo.io.c3.k.INSTANCE.a(this.headersReader.b());
            d0.a a3 = new d0.a().a(a2.protocol).a(a2.com.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String).a(a2.message).a(this.headersReader.a());
            if (expectContinue && a2.com.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String == 100) {
                return null;
            }
            int i2 = a2.com.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String;
            if (i2 != 100) {
                if (102 <= i2 && i2 < 200) {
                    z = true;
                }
                if (!z) {
                    this.state = 4;
                    return a3;
                }
            }
            this.state = 3;
            return a3;
        } catch (EOFException e2) {
            throw new IOException("unexpected end of stream on " + getConnection().getRoute().getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String().getUrl().n(), e2);
        }
    }

    public final void a(u headers, String requestLine) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(requestLine, "requestLine");
        if (!(this.state == 0)) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.sink.a(requestLine).a(IOUtils.LINE_SEPARATOR_WINDOWS);
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.sink.a(headers.a(i)).a(": ").a(headers.b(i)).a(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        this.sink.a(IOUtils.LINE_SEPARATOR_WINDOWS);
        this.state = 1;
    }

    @Override // sdk.pendo.io.c3.d
    public void a(sdk.pendo.io.w2.b0 request) {
        Intrinsics.checkNotNullParameter(request, "request");
        i iVar = i.f951a;
        Proxy.Type type = getConnection().getRoute().getProxy().type();
        Intrinsics.checkNotNullExpressionValue(type, "connection.route().proxy.type()");
        a(request.getHeaders(), iVar.a(request, type));
    }
}
