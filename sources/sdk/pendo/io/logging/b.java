package sdk.pendo.io.logging;

import io.sentry.protocol.SentryThread;
import io.sentry.protocol.ViewHierarchyNode;
import java.io.File;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.j9.b;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J,\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0005\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/logging/b;", "Lsdk/pendo/io/logging/PendoLogger$w;", "Ljava/lang/StackTraceElement;", "element", "", "a", "", SentryThread.JsonKeys.PRIORITY, ViewHierarchyNode.JsonKeys.TAG, "message", "", "t", "", "text", "Lsdk/pendo/io/j9/a;", "b", "Lsdk/pendo/io/j9/a;", "getFile", "()Lsdk/pendo/io/j9/a;", "file", "fileName", "Ljava/io/File;", "fileLocation", "Lsdk/pendo/io/j9/b$d;", "openMode", "<init>", "(Ljava/lang/String;Ljava/io/File;Lsdk/pendo/io/j9/b$d;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class b extends PendoLogger.w {

    /* renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.j9.a file;

    public b(String fileName, File fileLocation, b.d openMode) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(fileLocation, "fileLocation");
        Intrinsics.checkNotNullParameter(openMode, "openMode");
        this.file = sdk.pendo.io.j9.b.a(sdk.pendo.io.j9.b.INSTANCE.a(), fileName, fileLocation, openMode, false, 8, null);
    }

    @Override // sdk.pendo.io.logging.PendoLogger.w
    public String a(StackTraceElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        String className = element.getClassName();
        String methodName = element.getMethodName();
        int lineNumber = element.getLineNumber();
        Matcher matcher = PendoLogger.ANONYMOUS_CLASS.matcher(className);
        if (matcher.find()) {
            className = matcher.replaceAll("");
        }
        Intrinsics.checkNotNull(className);
        Intrinsics.checkNotNull(className);
        String substring = className.substring(StringsKt.lastIndexOf$default((CharSequence) className, '.', 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return "Pendo::" + substring + ":" + methodName + "():" + Integer.toString(lineNumber) + ":";
    }

    @Override // sdk.pendo.io.logging.PendoLogger.w, sdk.pendo.io.logging.PendoLogger.x
    public void a(int priority, String tag, String message, Throwable t) {
        StringBuilder append;
        Intrinsics.checkNotNullParameter(message, "message");
        if (priority == 7) {
            append = new StringBuilder("{tag: \"").append(tag).append("\", message: \"").append(message).append("\", t:\"").append(t != null ? t.getStackTrace() : null);
        } else {
            append = new StringBuilder("{priority: \"").append(priority).append("\", tag: \"").append(tag).append("\", message: \"").append(message).append("\", t:\"").append(t != null ? t.getStackTrace() : null);
        }
        a(append.append("\"}\n").toString());
    }

    public final void a(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        sdk.pendo.io.j9.a aVar = this.file;
        if (aVar != null) {
            aVar.a(text);
        }
    }
}
