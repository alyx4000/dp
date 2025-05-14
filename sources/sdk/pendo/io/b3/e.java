package sdk.pendo.io.b3;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import io.sentry.ProfilingTraceData;
import io.sentry.SentryBaseEvent;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.p;
import sdk.pendo.io.w2.r;
import sdk.pendo.io.w2.v;
import sdk.pendo.io.w2.z;

@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b *\u0001J\u0018\u00002\u00020\u0001:\u0002\u0007\u0014B\u001f\u0012\u0006\u00105\u001a\u000200\u0012\u0006\u0010:\u001a\u00020\u0010\u0012\u0006\u0010?\u001a\u00020\u0012¢\u0006\u0004\bt\u0010uJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J#\u0010\u0007\u001a\u00028\u0000\"\n\b\u0000\u0010\u0005*\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0005*\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\bJ\u0010\u0010\u0007\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\b\u0010\u0007\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u000f\u0010\u0017\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0012J\u0017\u0010\u0007\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0000¢\u0006\u0004\b\u0007\u0010\u001eJ\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fJ\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0014\u0010\bJ\u0011\u0010\"\u001a\u0004\u0018\u00010!H\u0000¢\u0006\u0004\b\"\u0010#J\u0006\u0010$\u001a\u00020\u0002J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0007\u0010&J\u0006\u0010'\u001a\u00020\u0012J\u000f\u0010(\u001a\u00020\rH\u0000¢\u0006\u0004\b(\u0010)J;\u0010/\u001a\u00028\u0000\"\n\b\u0000\u0010\u0005*\u0004\u0018\u00010\u00042\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00028\u0000H\u0000¢\u0006\u0004\b-\u0010.R\u0017\u00105\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0017\u0010:\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0017\u0010?\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001a\u0010I\u001a\u00020D8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR(\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010Z\u001a\u0004\u0018\u00010\u001f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u0016\u0010`\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010<R(\u0010e\u001a\u0004\u0018\u00010\u001d2\b\u0010Z\u001a\u0004\u0018\u00010\u001d8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u0016\u0010g\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010<R\u0016\u0010i\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010<R\u0016\u0010k\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010<R\u0016\u0010m\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010<R\u0018\u0010*\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010bR$\u0010s\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010\\\u001a\u0004\bp\u0010^\"\u0004\bq\u0010r¨\u0006v"}, d2 = {"Lsdk/pendo/io/b3/e;", "Lsdk/pendo/io/w2/e;", "", "c", "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, "e", "a", "(Ljava/io/IOException;)Ljava/io/IOException;", "cause", "Lsdk/pendo/io/w2/v;", "url", "Lsdk/pendo/io/w2/a;", "", "q", "d", "Lsdk/pendo/io/w2/b0;", "cancel", "", "Lsdk/pendo/io/w2/d0;", "b", "Lsdk/pendo/io/w2/f;", "responseCallback", "l", "()Lsdk/pendo/io/w2/d0;", SentryBaseEvent.JsonKeys.REQUEST, "newExchangeFinder", "Lsdk/pendo/io/c3/g;", "chain", "Lsdk/pendo/io/b3/c;", "(Lsdk/pendo/io/c3/g;)Lsdk/pendo/io/b3/c;", "Lsdk/pendo/io/b3/f;", "connection", "Ljava/net/Socket;", "n", "()Ljava/net/Socket;", ContextChain.TAG_PRODUCT, "closeExchange", "(Z)V", "o", "m", "()Ljava/lang/String;", "exchange", "requestDone", "responseDone", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "messageDone", "Lsdk/pendo/io/w2/z;", "f", "Lsdk/pendo/io/w2/z;", "getClient", "()Lokhttp3/OkHttpClient;", "client", "s", "Lsdk/pendo/io/w2/b0;", "getOriginalRequest", "()Lokhttp3/Request;", "originalRequest", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Z", ContextChain.TAG_INFRA, "()Z", "forWebSocket", "Lsdk/pendo/io/b3/g;", "f0", "Lsdk/pendo/io/b3/g;", "connectionPool", "Lsdk/pendo/io/w2/r;", "t0", "Lsdk/pendo/io/w2/r;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "eventListener", "sdk/pendo/io/b3/e$c", "u0", "Lsdk/pendo/io/b3/e$c;", ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, "Ljava/util/concurrent/atomic/AtomicBoolean;", "v0", "Ljava/util/concurrent/atomic/AtomicBoolean;", "executed", "", "w0", "Ljava/lang/Object;", "callStackTrace", "Lsdk/pendo/io/b3/d;", "x0", "Lsdk/pendo/io/b3/d;", "exchangeFinder", "<set-?>", "y0", "Lsdk/pendo/io/b3/f;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "z0", "timeoutEarlyExit", "A0", "Lsdk/pendo/io/b3/c;", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "interceptorScopedExchange", "B0", "requestBodyOpen", "C0", "responseBodyOpen", "D0", "expectMoreExchanges", "E0", "canceled", "F0", "G0", "getConnectionToCancel", "setConnectionToCancel", "(Lokhttp3/internal/connection/RealConnection;)V", "connectionToCancel", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class e implements sdk.pendo.io.w2.e {

    /* renamed from: A, reason: from kotlin metadata */
    private final boolean forWebSocket;

    /* renamed from: A0, reason: from kotlin metadata */
    private sdk.pendo.io.b3.c interceptorScopedExchange;

    /* renamed from: B0, reason: from kotlin metadata */
    private boolean requestBodyOpen;

    /* renamed from: C0, reason: from kotlin metadata */
    private boolean responseBodyOpen;

    /* renamed from: D0, reason: from kotlin metadata */
    private boolean expectMoreExchanges;

    /* renamed from: E0, reason: from kotlin metadata */
    private volatile boolean canceled;

    /* renamed from: F0, reason: from kotlin metadata */
    private volatile sdk.pendo.io.b3.c exchange;

    /* renamed from: G0, reason: from kotlin metadata */
    private volatile f connectionToCancel;

    /* renamed from: f, reason: from kotlin metadata */
    private final z client;

    /* renamed from: f0, reason: from kotlin metadata */
    private final g connectionPool;

    /* renamed from: s, reason: from kotlin metadata */
    private final b0 originalRequest;

    /* renamed from: t0, reason: from kotlin metadata */
    private final r eventListener;

    /* renamed from: u0, reason: from kotlin metadata */
    private final c timeout;

    /* renamed from: v0, reason: from kotlin metadata */
    private final AtomicBoolean executed;

    /* renamed from: w0, reason: from kotlin metadata */
    private Object callStackTrace;

    /* renamed from: x0, reason: from kotlin metadata */
    private d exchangeFinder;

    /* renamed from: y0, reason: from kotlin metadata */
    private f connection;

    /* renamed from: z0, reason: from kotlin metadata */
    private boolean timeoutEarlyExit;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u00060\u0000R\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR$\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001e\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lsdk/pendo/io/b3/e$a;", "Ljava/lang/Runnable;", "Lsdk/pendo/io/b3/e;", "other", "", "a", "Ljava/util/concurrent/ExecutorService;", "executorService", "run", "Lsdk/pendo/io/w2/f;", "f", "Lsdk/pendo/io/w2/f;", "responseCallback", "Ljava/util/concurrent/atomic/AtomicInteger;", "<set-?>", "s", "Ljava/util/concurrent/atomic/AtomicInteger;", "b", "()Ljava/util/concurrent/atomic/AtomicInteger;", "callsPerHost", "", "c", "()Ljava/lang/String;", "host", "getCall", "()Lokhttp3/internal/connection/RealCall;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/w2/b0;", "getRequest", "()Lokhttp3/Request;", SentryBaseEvent.JsonKeys.REQUEST, "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/Callback;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public final class a implements Runnable {
        final /* synthetic */ e A;

        /* renamed from: f, reason: from kotlin metadata */
        private final sdk.pendo.io.w2.f responseCallback;

        /* renamed from: s, reason: from kotlin metadata */
        private volatile AtomicInteger callsPerHost;

        public a(e eVar, sdk.pendo.io.w2.f responseCallback) {
            Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
            this.A = eVar;
            this.responseCallback = responseCallback;
            this.callsPerHost = new AtomicInteger(0);
        }

        public final void a(ExecutorService executorService) {
            Intrinsics.checkNotNullParameter(executorService, "executorService");
            p dispatcher = this.A.getClient().getDispatcher();
            if (sdk.pendo.io.x2.b.h && Thread.holdsLock(dispatcher)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + dispatcher);
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    this.A.b(interruptedIOException);
                    this.responseCallback.a(this.A, interruptedIOException);
                    this.A.getClient().getDispatcher().b(this);
                }
            } catch (Throwable th) {
                this.A.getClient().getDispatcher().b(this);
                throw th;
            }
        }

        /* renamed from: b, reason: from getter */
        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        public final String c() {
            return this.A.k().i().getHost();
        }

        @Override // java.lang.Runnable
        public void run() {
            z client;
            String str = "OkHttp " + this.A.m();
            e eVar = this.A;
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            currentThread.setName(str);
            try {
                eVar.timeout.l();
                boolean z = false;
                try {
                    try {
                    } catch (IOException e) {
                        e = e;
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        this.responseCallback.a(eVar, eVar.l());
                        client = eVar.getClient();
                    } catch (IOException e2) {
                        e = e2;
                        z = true;
                        if (z) {
                            sdk.pendo.io.f3.h.INSTANCE.d().a("Callback failure for " + eVar.q(), 4, e);
                        } else {
                            this.responseCallback.a(eVar, e);
                        }
                        client = eVar.getClient();
                        client.getDispatcher().b(this);
                    } catch (Throwable th2) {
                        th = th2;
                        z = true;
                        eVar.cancel();
                        if (!z) {
                            IOException iOException = new IOException("canceled due to " + th);
                            ExceptionsKt.addSuppressed(iOException, th);
                            this.responseCallback.a(eVar, iOException);
                        }
                        throw th;
                    }
                    client.getDispatcher().b(this);
                } catch (Throwable th3) {
                    eVar.getClient().getDispatcher().b(this);
                    throw th3;
                }
            } finally {
                currentThread.setName(name);
            }
        }

        /* renamed from: a, reason: from getter */
        public final e getA() {
            return this.A;
        }

        public final void a(a other) {
            Intrinsics.checkNotNullParameter(other, "other");
            this.callsPerHost = other.callsPerHost;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/b3/e$b;", "Ljava/lang/ref/WeakReference;", "Lsdk/pendo/io/b3/e;", "", "a", "Ljava/lang/Object;", "()Ljava/lang/Object;", "callStackTrace", "referent", "<init>", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class b extends WeakReference<e> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Object callStackTrace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e referent, Object obj) {
            super(referent);
            Intrinsics.checkNotNullParameter(referent, "referent");
            this.callStackTrace = obj;
        }

        /* renamed from: a, reason: from getter */
        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\u0004"}, d2 = {"sdk/pendo/io/b3/e$c", "Lsdk/pendo/io/k3/c;", "", "n", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class c extends sdk.pendo.io.k3.c {
        c() {
        }

        @Override // sdk.pendo.io.k3.c
        protected void n() {
            e.this.cancel();
        }
    }

    public e(z client, b0 originalRequest, boolean z) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        this.client = client;
        this.originalRequest = originalRequest;
        this.forWebSocket = z;
        this.connectionPool = client.getConnectionPool().getDelegate();
        this.eventListener = client.getEventListenerFactory().a(this);
        c cVar = new c();
        cVar.a(client.getCallTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = cVar;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
    }

    private final void c() {
        this.callStackTrace = sdk.pendo.io.f3.h.INSTANCE.d().a("response.body().close()");
        this.eventListener.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String q() {
        return (getCanceled() ? "canceled " : "") + (this.forWebSocket ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + m();
    }

    @Override // sdk.pendo.io.w2.e
    public void cancel() {
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        sdk.pendo.io.b3.c cVar = this.exchange;
        if (cVar != null) {
            cVar.a();
        }
        f fVar = this.connectionToCancel;
        if (fVar != null) {
            fVar.d();
        }
        this.eventListener.c(this);
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public e clone() {
        return new e(this.client, this.originalRequest, this.forWebSocket);
    }

    @Override // sdk.pendo.io.w2.e
    /* renamed from: e, reason: from getter */
    public boolean getCanceled() {
        return this.canceled;
    }

    /* renamed from: f, reason: from getter */
    public final z getClient() {
        return this.client;
    }

    /* renamed from: g, reason: from getter */
    public final f getConnection() {
        return this.connection;
    }

    /* renamed from: h, reason: from getter */
    public final r getEventListener() {
        return this.eventListener;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    /* renamed from: j, reason: from getter */
    public final sdk.pendo.io.b3.c getInterceptorScopedExchange() {
        return this.interceptorScopedExchange;
    }

    public final b0 k() {
        return this.originalRequest;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final sdk.pendo.io.w2.d0 l() {
        /*
            r12 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            sdk.pendo.io.w2.z r0 = r12.client
            java.util.List r0 = r0.v()
            kotlin.collections.CollectionsKt.addAll(r2, r0)
            sdk.pendo.io.c3.j r0 = new sdk.pendo.io.c3.j
            sdk.pendo.io.w2.z r1 = r12.client
            r0.<init>(r1)
            r2.add(r0)
            sdk.pendo.io.c3.a r0 = new sdk.pendo.io.c3.a
            sdk.pendo.io.w2.z r1 = r12.client
            sdk.pendo.io.w2.n r1 = r1.getCookieJar()
            r0.<init>(r1)
            r2.add(r0)
            sdk.pendo.io.z2.a r0 = new sdk.pendo.io.z2.a
            sdk.pendo.io.w2.z r1 = r12.client
            r1.g()
            r9 = 0
            r0.<init>(r9)
            r2.add(r0)
            sdk.pendo.io.b3.a r0 = sdk.pendo.io.b3.a.f886a
            r2.add(r0)
            boolean r0 = r12.forWebSocket
            if (r0 != 0) goto L46
            sdk.pendo.io.w2.z r0 = r12.client
            java.util.List r0 = r0.x()
            kotlin.collections.CollectionsKt.addAll(r2, r0)
        L46:
            sdk.pendo.io.c3.b r0 = new sdk.pendo.io.c3.b
            boolean r1 = r12.forWebSocket
            r0.<init>(r1)
            r2.add(r0)
            sdk.pendo.io.c3.g r10 = new sdk.pendo.io.c3.g
            sdk.pendo.io.w2.b0 r5 = r12.originalRequest
            sdk.pendo.io.w2.z r0 = r12.client
            int r6 = r0.getConnectTimeoutMillis()
            sdk.pendo.io.w2.z r0 = r12.client
            int r7 = r0.getReadTimeoutMillis()
            sdk.pendo.io.w2.z r0 = r12.client
            int r8 = r0.getWriteTimeoutMillis()
            r3 = 0
            r4 = 0
            r0 = r10
            r1 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            sdk.pendo.io.w2.b0 r1 = r12.originalRequest     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
            sdk.pendo.io.w2.d0 r1 = r10.a(r1)     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
            boolean r2 = r12.getCanceled()     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
            if (r2 != 0) goto L7e
            r12.b(r9)
            return r1
        L7e:
            sdk.pendo.io.x2.b.a(r1)     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
            java.lang.String r2 = "Canceled"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
            throw r1     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
        L89:
            r1 = move-exception
            goto L9b
        L8b:
            r0 = move-exception
            r1 = 1
            java.io.IOException r0 = r12.b(r0)     // Catch: java.lang.Throwable -> L97
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Throwable"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r2)     // Catch: java.lang.Throwable -> L97
            throw r0     // Catch: java.lang.Throwable -> L97
        L97:
            r0 = move-exception
            r11 = r1
            r1 = r0
            r0 = r11
        L9b:
            if (r0 != 0) goto La0
            r12.b(r9)
        La0:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.b3.e.l():sdk.pendo.io.w2.d0");
    }

    public final String m() {
        return this.originalRequest.i().n();
    }

    public final Socket n() {
        f fVar = this.connection;
        Intrinsics.checkNotNull(fVar);
        if (sdk.pendo.io.x2.b.h && !Thread.holdsLock(fVar)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + fVar);
        }
        List<Reference<e>> f = fVar.f();
        Iterator<Reference<e>> it = f.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (Intrinsics.areEqual(it.next().get(), this)) {
                break;
            }
            i++;
        }
        if (!(i != -1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        f.remove(i);
        this.connection = null;
        if (f.isEmpty()) {
            fVar.a(System.nanoTime());
            if (this.connectionPool.a(fVar)) {
                return fVar.c();
            }
        }
        return null;
    }

    public final boolean o() {
        d dVar = this.exchangeFinder;
        Intrinsics.checkNotNull(dVar);
        return dVar.b();
    }

    public final void p() {
        if (!(!this.timeoutEarlyExit)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.timeoutEarlyExit = true;
        this.timeout.m();
    }

    private final <E extends IOException> E c(E cause) {
        if (this.timeoutEarlyExit || !this.timeout.m()) {
            return cause;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT);
        if (cause != null) {
            interruptedIOException.initCause(cause);
        }
        return interruptedIOException;
    }

    public final void a(f connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (sdk.pendo.io.x2.b.h && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        if (!(this.connection == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.connection = connection;
        connection.f().add(new b(this, this.callStackTrace));
    }

    @Override // sdk.pendo.io.w2.e
    public d0 b() {
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        this.timeout.l();
        c();
        try {
            this.client.getDispatcher().a(this);
            return l();
        } finally {
            this.client.getDispatcher().b(this);
        }
    }

    private final <E extends IOException> E a(E e) {
        Socket n;
        boolean z = sdk.pendo.io.x2.b.h;
        if (z && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        f fVar = this.connection;
        if (fVar != null) {
            if (z && Thread.holdsLock(fVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + fVar);
            }
            synchronized (fVar) {
                n = n();
            }
            if (this.connection == null) {
                if (n != null) {
                    sdk.pendo.io.x2.b.a(n);
                }
                this.eventListener.b(this, fVar);
            } else {
                if (!(n == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        E e2 = (E) c(e);
        if (e != null) {
            r rVar = this.eventListener;
            Intrinsics.checkNotNull(e2);
            rVar.a(this, e2);
        } else {
            this.eventListener.a(this);
        }
        return e2;
    }

    public final IOException b(IOException e) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.expectMoreExchanges) {
                this.expectMoreExchanges = false;
                if (!this.requestBodyOpen && !this.responseBodyOpen) {
                    z = true;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return z ? a((e) e) : e;
    }

    private final sdk.pendo.io.w2.a a(v url) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        sdk.pendo.io.w2.g gVar;
        if (url.getIsHttps()) {
            sSLSocketFactory = this.client.H();
            hostnameVerifier = this.client.getHostnameVerifier();
            gVar = this.client.getCertificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            gVar = null;
        }
        return new sdk.pendo.io.w2.a(url.getHost(), url.getPort(), this.client.getDns(), this.client.getSocketFactory(), sSLSocketFactory, hostnameVerifier, gVar, this.client.getProxyAuthenticator(), this.client.getProxy(), this.client.A(), this.client.m(), this.client.getProxySelector());
    }

    public final void b(f fVar) {
        this.connectionToCancel = fVar;
    }

    @Override // sdk.pendo.io.w2.e
    public void a(sdk.pendo.io.w2.f responseCallback) {
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        c();
        this.client.getDispatcher().a(new a(this, responseCallback));
    }

    public final void a(b0 request, boolean newExchangeFinder) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (!(this.interceptorScopedExchange == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        synchronized (this) {
            if (!(!this.responseBodyOpen)) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            }
            if (!(!this.requestBodyOpen)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        if (newExchangeFinder) {
            this.exchangeFinder = new d(this.connectionPool, a(request.i()), this, this.eventListener);
        }
    }

    public final void a(boolean closeExchange) {
        sdk.pendo.io.b3.c cVar;
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        if (closeExchange && (cVar = this.exchange) != null) {
            cVar.b();
        }
        this.interceptorScopedExchange = null;
    }

    public final sdk.pendo.io.b3.c a(sdk.pendo.io.c3.g chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            }
            if (!(!this.responseBodyOpen)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(!this.requestBodyOpen)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        d dVar = this.exchangeFinder;
        Intrinsics.checkNotNull(dVar);
        sdk.pendo.io.b3.c cVar = new sdk.pendo.io.b3.c(this, this.eventListener, dVar, dVar.a(this.client, chain));
        this.interceptorScopedExchange = cVar;
        this.exchange = cVar;
        synchronized (this) {
            this.requestBodyOpen = true;
            this.responseBodyOpen = true;
            Unit unit2 = Unit.INSTANCE;
        }
        if (this.canceled) {
            throw new IOException("Canceled");
        }
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:44:0x0012, B:12:0x0021, B:14:0x0025, B:15:0x0027, B:17:0x002c, B:21:0x0035, B:23:0x0039, B:27:0x0042, B:9:0x001b), top: B:43:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0025 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:44:0x0012, B:12:0x0021, B:14:0x0025, B:15:0x0027, B:17:0x002c, B:21:0x0035, B:23:0x0039, B:27:0x0042, B:9:0x001b), top: B:43:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <E extends java.io.IOException> E a(sdk.pendo.io.b3.c r2, boolean r3, boolean r4, E r5) {
        /*
            r1 = this;
            java.lang.String r0 = "exchange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            sdk.pendo.io.b3.c r0 = r1.exchange
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r0)
            if (r2 != 0) goto Le
            return r5
        Le:
            monitor-enter(r1)
            r2 = 0
            if (r3 == 0) goto L19
            boolean r0 = r1.requestBodyOpen     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L1f
            goto L19
        L17:
            r2 = move-exception
            goto L59
        L19:
            if (r4 == 0) goto L41
            boolean r0 = r1.responseBodyOpen     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L41
        L1f:
            if (r3 == 0) goto L23
            r1.requestBodyOpen = r2     // Catch: java.lang.Throwable -> L17
        L23:
            if (r4 == 0) goto L27
            r1.responseBodyOpen = r2     // Catch: java.lang.Throwable -> L17
        L27:
            boolean r3 = r1.requestBodyOpen     // Catch: java.lang.Throwable -> L17
            r4 = 1
            if (r3 != 0) goto L32
            boolean r0 = r1.responseBodyOpen     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L32
            r0 = r4
            goto L33
        L32:
            r0 = r2
        L33:
            if (r3 != 0) goto L3e
            boolean r3 = r1.responseBodyOpen     // Catch: java.lang.Throwable -> L17
            if (r3 != 0) goto L3e
            boolean r3 = r1.expectMoreExchanges     // Catch: java.lang.Throwable -> L17
            if (r3 != 0) goto L3e
            r2 = r4
        L3e:
            r3 = r2
            r2 = r0
            goto L42
        L41:
            r3 = r2
        L42:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L17
            monitor-exit(r1)
            if (r2 == 0) goto L51
            r2 = 0
            r1.exchange = r2
            sdk.pendo.io.b3.f r2 = r1.connection
            if (r2 == 0) goto L51
            r2.j()
        L51:
            if (r3 == 0) goto L58
            java.io.IOException r2 = r1.a(r5)
            return r2
        L58:
            return r5
        L59:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.b3.e.a(sdk.pendo.io.b3.c, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    @Override // sdk.pendo.io.w2.e
    /* renamed from: a, reason: from getter */
    public b0 getOriginalRequest() {
        return this.originalRequest;
    }
}
