package sdk.pendo.io.network.interfaces;

import com.extole.android.sdk.impl.http.HttpRequest;
import com.facebook.react.animated.InterpolationAnimatedNode;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import sdk.pendo.io.c3.e;
import sdk.pendo.io.f3.h;
import sdk.pendo.io.k3.d;
import sdk.pendo.io.k3.f;
import sdk.pendo.io.k3.l;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.c0;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.e0;
import sdk.pendo.io.w2.j;
import sdk.pendo.io.w2.u;
import sdk.pendo.io.w2.w;
import sdk.pendo.io.w2.x;

/* loaded from: classes6.dex */
public final class HttpLoggingInterceptor implements w {
    private static final Charset d = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    private final Logger f1446a;
    private volatile Set<String> b;
    private volatile a c;

    public interface Logger {
        public static final Logger DEFAULT = new Logger() { // from class: sdk.pendo.io.network.interfaces.HttpLoggingInterceptor$Logger$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.network.interfaces.HttpLoggingInterceptor.Logger
            public final void log(String str) {
                h.b().a("Pendo::" + str, 4, (Throwable) null);
            }
        };

        void log(String str);
    }

    public enum a {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    private static boolean a(u uVar) {
        String a2 = uVar.a(HttpRequest.HEADER_CONTENT_ENCODING);
        return (a2 == null || a2.equalsIgnoreCase(InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY) || a2.equalsIgnoreCase(HttpRequest.ENCODING_GZIP)) ? false : true;
    }

    public HttpLoggingInterceptor(Logger logger) {
        this.b = Collections.emptySet();
        this.c = a.NONE;
        this.f1446a = logger;
    }

    @Override // sdk.pendo.io.w2.w
    public d0 a(w.a aVar) {
        Logger logger;
        String str;
        Long l;
        Logger logger2;
        StringBuilder append;
        StringBuilder append2;
        String str2;
        a aVar2 = this.c;
        b0 b0Var = aVar.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String();
        if (aVar2 == a.NONE) {
            return aVar.a(b0Var);
        }
        boolean z = aVar2 == a.BODY;
        boolean z2 = z || aVar2 == a.HEADERS;
        c0 body = b0Var.getBody();
        boolean z3 = body != null;
        j b = aVar.b();
        String str3 = "--> " + b0Var.getIo.sentry.protocol.Request.JsonKeys.METHOD java.lang.String() + ' ' + b0Var.i() + (b != null ? " " + b.a() : "");
        if (!z2 && z3) {
            str3 = str3 + " (" + body.a() + "-byte body)";
        }
        this.f1446a.log(str3);
        if (z2) {
            if (z3) {
                if (body.getExpo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer.AUDIO_ATTRIBUTES_CONTENT_TYPE_KEY java.lang.String() != null) {
                    this.f1446a.log("Content-Type: " + body.getExpo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer.AUDIO_ATTRIBUTES_CONTENT_TYPE_KEY java.lang.String());
                }
                if (body.a() != -1) {
                    this.f1446a.log("Content-Length: " + body.a());
                }
            }
            u headers = b0Var.getHeaders();
            int size = headers.size();
            int i = 0;
            while (i < size) {
                String a2 = headers.a(i);
                int i2 = size;
                if (!HttpRequest.HEADER_CONTENT_TYPE.equalsIgnoreCase(a2) && !HttpRequest.HEADER_CONTENT_LENGTH.equalsIgnoreCase(a2)) {
                    a(headers, i);
                }
                i++;
                size = i2;
            }
            if (z && z3) {
                if (a(b0Var.getHeaders())) {
                    logger2 = this.f1446a;
                    append2 = new StringBuilder("--> END ").append(b0Var.getIo.sentry.protocol.Request.JsonKeys.METHOD java.lang.String());
                    str2 = " (encoded body omitted)";
                } else if (body.c()) {
                    logger2 = this.f1446a;
                    append2 = new StringBuilder("--> END ").append(b0Var.getIo.sentry.protocol.Request.JsonKeys.METHOD java.lang.String());
                    str2 = " (duplex request body omitted)";
                } else {
                    d dVar = new d();
                    body.a(dVar);
                    Charset charset = d;
                    x xVar = body.getExpo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer.AUDIO_ATTRIBUTES_CONTENT_TYPE_KEY java.lang.String();
                    if (xVar != null) {
                        charset = xVar.a(charset);
                    }
                    this.f1446a.log("");
                    if (a(dVar)) {
                        this.f1446a.log(dVar.a(charset));
                        logger2 = this.f1446a;
                        append = new StringBuilder("--> END ").append(b0Var.getIo.sentry.protocol.Request.JsonKeys.METHOD java.lang.String()).append(" (").append(body.a()).append("-byte body)");
                    } else {
                        logger2 = this.f1446a;
                        append = new StringBuilder("--> END ").append(b0Var.getIo.sentry.protocol.Request.JsonKeys.METHOD java.lang.String()).append(" (binary ").append(body.a()).append("-byte body omitted)");
                    }
                }
                append = append2.append(str2);
            } else {
                logger2 = this.f1446a;
                append = new StringBuilder("--> END ").append(b0Var.getIo.sentry.protocol.Request.JsonKeys.METHOD java.lang.String());
            }
            logger2.log(append.toString());
        }
        long nanoTime = System.nanoTime();
        try {
            d0 a3 = aVar.a(b0Var);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            e0 b2 = a3.b();
            long contentLength = b2.getContentLength();
            this.f1446a.log("<-- " + a3.getCom.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String() + (a3.getMessage().isEmpty() ? "" : " " + a3.getMessage()) + ' ' + a3.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String().i() + " (" + millis + "ms" + (!z2 ? ", " + (contentLength != -1 ? contentLength + "-byte" : "unknown-length") + " body" : "") + ')');
            if (z2) {
                u headers2 = a3.getHeaders();
                int size2 = headers2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    a(headers2, i3);
                }
                if (!z || !e.a(a3)) {
                    logger = this.f1446a;
                    str = "<-- END HTTP";
                } else if (a(a3.getHeaders())) {
                    logger = this.f1446a;
                    str = "<-- END HTTP (encoded body omitted)";
                } else {
                    f source = b2.getSource();
                    source.a(Long.MAX_VALUE);
                    d bufferField = source.getBufferField();
                    if (HttpRequest.ENCODING_GZIP.equalsIgnoreCase(headers2.a(HttpRequest.HEADER_CONTENT_ENCODING))) {
                        l = Long.valueOf(bufferField.getSize());
                        l lVar = new l(bufferField.clone());
                        try {
                            bufferField = new d();
                            bufferField.a(lVar);
                            lVar.close();
                        } finally {
                        }
                    } else {
                        l = null;
                    }
                    Charset charset2 = d;
                    x s = b2.getS();
                    if (s != null) {
                        charset2 = s.a(charset2);
                    }
                    if (!a(bufferField)) {
                        this.f1446a.log("");
                        this.f1446a.log("<-- END HTTP (binary " + bufferField.getSize() + "-byte body omitted)");
                        return a3;
                    }
                    if (contentLength != 0) {
                        this.f1446a.log("");
                        this.f1446a.log(bufferField.clone().a(charset2));
                    }
                    if (l != null) {
                        this.f1446a.log("<-- END HTTP (" + bufferField.getSize() + "-byte, " + l + "-gzipped-byte body)");
                    } else {
                        logger = this.f1446a;
                        str = "<-- END HTTP (" + bufferField.getSize() + "-byte body)";
                    }
                }
                logger.log(str);
            }
            return a3;
        } catch (Exception e) {
            this.f1446a.log("<-- HTTP FAILED: " + e);
            throw e;
        }
    }

    static boolean a(d dVar) {
        try {
            d dVar2 = new d();
            dVar.a(dVar2, 0L, dVar.getSize() < 64 ? dVar.getSize() : 64L);
            for (int i = 0; i < 16; i++) {
                if (dVar2.i()) {
                    return true;
                }
                int x = dVar2.x();
                if (Character.isISOControl(x) && !Character.isWhitespace(x)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    private void a(u uVar, int i) {
        this.f1446a.log(uVar.a(i) + ": " + (this.b.contains(uVar.a(i)) ? "██" : uVar.b(i)));
    }

    public HttpLoggingInterceptor a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.c = aVar;
        return this;
    }
}
