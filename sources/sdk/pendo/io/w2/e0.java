package sdk.pendo.io.w2;

import com.facebook.common.callercontext.ContextChain;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00142\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0006\u0010\t\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\nH&J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u00020\u0010H\u0016¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/w2/e0;", "Ljava/io/Closeable;", "Ljava/nio/charset/Charset;", "e", "Lsdk/pendo/io/w2/x;", "n", "", "m", "Ljava/io/InputStream;", "a", "Lsdk/pendo/io/k3/f;", "o", "", "b", "", ContextChain.TAG_PRODUCT, "", "close", "<init>", "()V", "f", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public abstract class e0 implements Closeable {

    /* renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u0006\u001a\u00020\u0005*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\tJ)\u0010\u0006\u001a\u00020\u0005*\u00020\n2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0006\u0010\rJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0007J\"\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\nH\u0007¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/w2/e0$a;", "", "", "Lsdk/pendo/io/w2/x;", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_CONTENT_TYPE_KEY, "Lsdk/pendo/io/w2/e0;", "a", "(Ljava/lang/String;Lsdk/pendo/io/w2/x;)Lsdk/pendo/io/w2/e0;", "", "([BLsdk/pendo/io/w2/x;)Lsdk/pendo/io/w2/e0;", "Lsdk/pendo/io/k3/f;", "", "contentLength", "(Lsdk/pendo/io/k3/f;Lsdk/pendo/io/w2/x;J)Lsdk/pendo/io/w2/e0;", "content", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.w2.e0$a, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"sdk/pendo/io/w2/e0$a$a", "Lsdk/pendo/io/w2/e0;", "Lsdk/pendo/io/w2/x;", "n", "", "m", "Lsdk/pendo/io/k3/f;", "o", "okhttp"}, k = 1, mv = {1, 8, 0})
        /* renamed from: sdk.pendo.io.w2.e0$a$a, reason: collision with other inner class name */
        public static final class C0261a extends e0 {
            final /* synthetic */ long A;
            final /* synthetic */ sdk.pendo.io.k3.f f0;
            final /* synthetic */ x s;

            C0261a(x xVar, long j, sdk.pendo.io.k3.f fVar) {
                this.s = xVar;
                this.A = j;
                this.f0 = fVar;
            }

            @Override // sdk.pendo.io.w2.e0
            /* renamed from: m, reason: from getter */
            public long getA() {
                return this.A;
            }

            @Override // sdk.pendo.io.w2.e0
            /* renamed from: n, reason: from getter */
            public x getS() {
                return this.s;
            }

            @Override // sdk.pendo.io.w2.e0
            /* renamed from: o, reason: from getter */
            public sdk.pendo.io.k3.f getF0() {
                return this.f0;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final e0 a(String str, x xVar) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Charset charset = Charsets.UTF_8;
            if (xVar != null && (charset = x.a(xVar, null, 1, null)) == null) {
                charset = Charsets.UTF_8;
                xVar = x.INSTANCE.b(xVar + "; charset=utf-8");
            }
            sdk.pendo.io.k3.d a2 = new sdk.pendo.io.k3.d().a(str, charset);
            return a(a2, xVar, a2.getSize());
        }

        @JvmStatic
        public final e0 a(sdk.pendo.io.k3.f fVar, x xVar, long j) {
            Intrinsics.checkNotNullParameter(fVar, "<this>");
            return new C0261a(xVar, j, fVar);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"external.sdk.pendo.io.okhttp3.ResponseBody.Companion.asResponseBody"}))
        @JvmStatic
        public final e0 a(x contentType, long contentLength, sdk.pendo.io.k3.f content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return a(content, contentType, contentLength);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"external.sdk.pendo.io.okhttp3.ResponseBody.Companion.toResponseBody"}))
        @JvmStatic
        public final e0 a(x contentType, String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return a(content, contentType);
        }

        @JvmStatic
        public final e0 a(byte[] bArr, x xVar) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            return a(new sdk.pendo.io.k3.d().write(bArr), xVar, bArr.length);
        }

        public static /* synthetic */ e0 a(Companion companion, byte[] bArr, x xVar, int i, Object obj) {
            if ((i & 1) != 0) {
                xVar = null;
            }
            return companion.a(bArr, xVar);
        }
    }

    private final Charset e() {
        Charset a2;
        x s = getS();
        return (s == null || (a2 = s.a(Charsets.UTF_8)) == null) ? Charsets.UTF_8 : a2;
    }

    public final InputStream a() {
        return getF0().l();
    }

    public final byte[] b() {
        long a2 = getA();
        if (a2 > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + a2);
        }
        sdk.pendo.io.k3.f f0 = getF0();
        try {
            byte[] h = f0.h();
            CloseableKt.closeFinally(f0, null);
            int length = h.length;
            if (a2 == -1 || a2 == length) {
                return h;
            }
            throw new IOException("Content-Length (" + a2 + ") and stream length (" + length + ") disagree");
        } finally {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        sdk.pendo.io.x2.b.a((Closeable) getF0());
    }

    /* renamed from: m */
    public abstract long getA();

    /* renamed from: n */
    public abstract x getS();

    /* renamed from: o */
    public abstract sdk.pendo.io.k3.f getF0();

    public final String p() {
        sdk.pendo.io.k3.f f0 = getF0();
        try {
            String a2 = f0.a(sdk.pendo.io.x2.b.a(f0, e()));
            CloseableKt.closeFinally(f0, null);
            return a2;
        } finally {
        }
    }

    @JvmStatic
    public static final e0 a(String str, x xVar) {
        return INSTANCE.a(str, xVar);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"external.sdk.pendo.io.okhttp3.ResponseBody.Companion.asResponseBody"}))
    @JvmStatic
    public static final e0 a(x xVar, long j, sdk.pendo.io.k3.f fVar) {
        return INSTANCE.a(xVar, j, fVar);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"external.sdk.pendo.io.okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public static final e0 a(x xVar, String str) {
        return INSTANCE.a(xVar, str);
    }
}
