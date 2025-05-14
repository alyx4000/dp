package sdk.pendo.io.g9;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.network.responses.converters.gson.PendoGsonRequestBodyConverter;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000b\u0010\u000e¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/g9/a;", "", "", "content", "Lsdk/pendo/io/w2/c0;", "a", "", "statusCode", "", "errorString", "", "b", "Lsdk/pendo/io/w2/e0;", "responseBody", "Ljava/lang/String;", "TAG", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1122a = new a();

    /* renamed from: b, reason: from kotlin metadata */
    private static final String TAG = "APIUtils";

    private a() {
    }

    public final sdk.pendo.io.w2.c0 a(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return sdk.pendo.io.w2.c0.INSTANCE.a(content, PendoGsonRequestBodyConverter.JSON_MEDIA_TYPE);
    }

    public final boolean a(int statusCode) {
        return statusCode == 451 || statusCode == 500 || statusCode == 401 || statusCode == 403 || statusCode == 406 || statusCode == 301;
    }

    public final void b(String errorString) {
        Intrinsics.checkNotNullParameter(errorString, "errorString");
        PendoLogger.d("Socket Error: " + errorString, new Object[0]);
    }

    public final String a(sdk.pendo.io.w2.e0 responseBody) {
        if (responseBody != null) {
            sdk.pendo.io.k3.f source = responseBody.getSource();
            source.a(Long.MAX_VALUE);
            sdk.pendo.io.k3.d c = source.c();
            sdk.pendo.io.w2.x s = responseBody.getS();
            if (s != null) {
                try {
                    Charset a2 = s.a(Charset.forName("UTF-8"));
                    if (responseBody.getContentLength() != 0 && a2 != null) {
                        return c.clone().a(a2);
                    }
                } catch (UnsupportedCharsetException unused) {
                    PendoLogger.d("Couldn't decode the response body; charset is likely malformed.", new Object[0]);
                }
            }
        }
        return "";
    }
}
