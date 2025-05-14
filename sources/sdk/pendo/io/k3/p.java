package sdk.pendo.io.k3;

import io.sentry.SentryEvent;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0002\u001a\u00020\u0004*\u00020\u0003\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0003\u001a%\u0010\n\u001a\u00020\u0004*\u00020\u00062\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\f\u001a\u00020\u0001*\u00020\u00062\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\b¢\u0006\u0004\b\f\u0010\r\"\u001c\u0010\u0011\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0010\"\u001c\u0010\u0016\u001a\u00020\u0014*\u00060\u0012j\u0002`\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0015¨\u0006\u0017"}, d2 = {"Ljava/io/InputStream;", "Lsdk/pendo/io/k3/a0;", "a", "Ljava/net/Socket;", "Lsdk/pendo/io/k3/y;", "b", "Ljava/nio/file/Path;", "", "Ljava/nio/file/OpenOption;", "options", "sink", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "source", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "Ljava/util/logging/Logger;", SentryEvent.JsonKeys.LOGGER, "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "", "(Ljava/lang/AssertionError;)Z", "isAndroidGetsocknameError", "external.sdk.pendo.io.okio"}, k = 5, mv = {1, 9, 0}, xs = "external/sdk/pendo/io/okio/Okio")
/* loaded from: classes6.dex */
final /* synthetic */ class p {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f1287a = Logger.getLogger("external.sdk.pendo.io.okio.Okio");

    public static final a0 b(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        z zVar = new z(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        return zVar.a(new n(inputStream, zVar));
    }

    public static final boolean a(AssertionError assertionError) {
        Intrinsics.checkNotNullParameter(assertionError, "<this>");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? StringsKt.contains$default((CharSequence) message, (CharSequence) "getsockname failed", false, 2, (Object) null) : false;
    }

    public static final y a(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        z zVar = new z(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "getOutputStream(...)");
        return zVar.a(new s(outputStream, zVar));
    }

    public static final a0 a(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        return new n(inputStream, new b0());
    }
}
