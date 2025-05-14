package sdk.pendo.io.w2;

import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\f\u0010\rJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/w2/c0;", "", "Lsdk/pendo/io/w2/x;", "b", "", "a", "Lsdk/pendo/io/k3/e;", "sink", "", "", "c", "d", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public abstract class c0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u0006\u001a\u00020\u0005*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\tJ3\u0010\u0006\u001a\u00020\u0005*\u00020\n2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0006\u0010\u000eJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0007J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\bH\u0007J.\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0007¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/w2/c0$a;", "", "", "Lsdk/pendo/io/w2/x;", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_CONTENT_TYPE_KEY, "Lsdk/pendo/io/w2/c0;", "a", "(Ljava/lang/String;Lsdk/pendo/io/w2/x;)Lsdk/pendo/io/w2/c0;", "Lsdk/pendo/io/k3/g;", "(Lsdk/pendo/io/k3/g;Lsdk/pendo/io/w2/x;)Lsdk/pendo/io/w2/c0;", "", "", "offset", "byteCount", "([BLsdk/pendo/io/w2/x;II)Lsdk/pendo/io/w2/c0;", "content", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.w2.c0$a, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"sdk/pendo/io/w2/c0$a$a", "Lsdk/pendo/io/w2/c0;", "Lsdk/pendo/io/w2/x;", "b", "", "a", "Lsdk/pendo/io/k3/e;", "sink", "", "okhttp"}, k = 1, mv = {1, 8, 0})
        /* renamed from: sdk.pendo.io.w2.c0$a$a, reason: collision with other inner class name */
        public static final class C0260a extends c0 {
            final /* synthetic */ x b;
            final /* synthetic */ sdk.pendo.io.k3.g c;

            C0260a(x xVar, sdk.pendo.io.k3.g gVar) {
                this.b = xVar;
                this.c = gVar;
            }

            @Override // sdk.pendo.io.w2.c0
            public long a() {
                return this.c.l();
            }

            @Override // sdk.pendo.io.w2.c0
            /* renamed from: b, reason: from getter */
            public x getB() {
                return this.b;
            }

            @Override // sdk.pendo.io.w2.c0
            public void a(sdk.pendo.io.k3.e sink) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                sink.a(this.c);
            }
        }

        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"sdk/pendo/io/w2/c0$a$b", "Lsdk/pendo/io/w2/c0;", "Lsdk/pendo/io/w2/x;", "b", "", "a", "Lsdk/pendo/io/k3/e;", "sink", "", "okhttp"}, k = 1, mv = {1, 8, 0})
        /* renamed from: sdk.pendo.io.w2.c0$a$b */
        public static final class b extends c0 {
            final /* synthetic */ x b;
            final /* synthetic */ int c;
            final /* synthetic */ byte[] d;
            final /* synthetic */ int e;

            b(x xVar, int i, byte[] bArr, int i2) {
                this.b = xVar;
                this.c = i;
                this.d = bArr;
                this.e = i2;
            }

            @Override // sdk.pendo.io.w2.c0
            public long a() {
                return this.c;
            }

            @Override // sdk.pendo.io.w2.c0
            /* renamed from: b, reason: from getter */
            public x getB() {
                return this.b;
            }

            @Override // sdk.pendo.io.w2.c0
            public void a(sdk.pendo.io.k3.e sink) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                sink.write(this.d, this.e, this.c);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final c0 a(String str, x xVar) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Charset charset = Charsets.UTF_8;
            if (xVar != null && (charset = x.a(xVar, null, 1, null)) == null) {
                charset = Charsets.UTF_8;
                xVar = x.INSTANCE.b(xVar + "; charset=utf-8");
            }
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return a(bytes, xVar, 0, bytes.length);
        }

        @JvmStatic
        public final c0 a(sdk.pendo.io.k3.g gVar, x xVar) {
            Intrinsics.checkNotNullParameter(gVar, "<this>");
            return new C0260a(xVar, gVar);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"external.sdk.pendo.io.okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        public final c0 a(x contentType, String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return a(content, contentType);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"external.sdk.pendo.io.okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        public final c0 a(x contentType, sdk.pendo.io.k3.g content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return a(content, contentType);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"external.sdk.pendo.io.okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        public final c0 a(x xVar, byte[] content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return a(this, xVar, content, 0, 0, 12, (Object) null);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"external.sdk.pendo.io.okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        public final c0 a(x contentType, byte[] content, int offset, int byteCount) {
            Intrinsics.checkNotNullParameter(content, "content");
            return a(content, contentType, offset, byteCount);
        }

        @JvmStatic
        public final c0 a(byte[] bArr, x xVar, int i, int i2) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            sdk.pendo.io.x2.b.a(bArr.length, i, i2);
            return new b(xVar, i2, bArr, i);
        }

        public static /* synthetic */ c0 a(Companion companion, x xVar, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            return companion.a(xVar, bArr, i, i2);
        }

        public static /* synthetic */ c0 a(Companion companion, byte[] bArr, x xVar, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                xVar = null;
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return companion.a(bArr, xVar, i, i2);
        }
    }

    public long a() {
        return -1L;
    }

    public abstract void a(sdk.pendo.io.k3.e sink);

    /* renamed from: b */
    public abstract x getB();

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"external.sdk.pendo.io.okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final c0 a(x xVar, String str) {
        return INSTANCE.a(xVar, str);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"external.sdk.pendo.io.okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final c0 a(x xVar, sdk.pendo.io.k3.g gVar) {
        return INSTANCE.a(xVar, gVar);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"external.sdk.pendo.io.okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final c0 a(x xVar, byte[] bArr) {
        return INSTANCE.a(xVar, bArr);
    }
}
