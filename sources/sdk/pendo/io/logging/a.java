package sdk.pendo.io.logging;

import androidx.exifinterface.media.ExifInterface;
import java.util.regex.Matcher;
import javax.net.ssl.SSLPeerUnverifiedException;
import sdk.pendo.io.c8.d;
import sdk.pendo.io.g9.d;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes6.dex */
public class a extends PendoLogger.w {
    private void g(String str, Object... objArr) {
        if (sdk.pendo.io.p8.a.d().f()) {
            d.a(d.b.ERROR_REASON_CONFIGURATION, str, objArr);
        }
    }

    @Override // sdk.pendo.io.logging.PendoLogger.w
    protected final String a(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        int lineNumber = stackTraceElement.getLineNumber();
        Matcher matcher = PendoLogger.ANONYMOUS_CLASS.matcher(className);
        if (matcher.find()) {
            className = matcher.replaceAll("");
        }
        return "Pendo::" + className.substring(className.lastIndexOf(46) + 1) + ":" + methodName + "():" + Integer.toString(lineNumber) + ":";
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void b(String str, Object... objArr) {
        super.b(null, str, objArr);
        sdk.pendo.io.o8.b.b().a(str, ExifInterface.LONGITUDE_EAST);
        g(str, objArr);
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void c(String str, Object... objArr) {
        super.c(null, str, objArr);
        sdk.pendo.io.o8.b.b().a(str, "I");
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void e(String str, Object... objArr) {
        super.e(null, str, objArr);
        sdk.pendo.io.o8.b.b().a(str, ExifInterface.LONGITUDE_WEST);
    }

    private void g(Throwable th, String str, Object... objArr) {
        if (th instanceof SSLPeerUnverifiedException) {
            PendoLogger.d("Cannot send SSLPeerUnverifiedException to server yet.", new Object[0]);
        } else if (sdk.pendo.io.p8.a.d().f()) {
            sdk.pendo.io.g9.d.a(th, (objArr == null || objArr.length <= 0) ? null : objArr[0].toString(), str);
        }
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void a(String str, Object... objArr) {
        super.a((Throwable) null, str, objArr);
        sdk.pendo.io.o8.b.b().a(str, "D");
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void b(Throwable th) {
        super.b(th);
        g(th, th.getMessage(), new Object[0]);
        sdk.pendo.io.o8.b.b().a(th.getMessage(), ExifInterface.LONGITUDE_EAST, th.toString());
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void c(Throwable th, String str, Object... objArr) {
        super.c(th, str, objArr);
        sdk.pendo.io.o8.b.b().a(str, "I", th.toString());
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void e(Throwable th, String str, Object... objArr) {
        super.e(th, str, objArr);
        sdk.pendo.io.o8.b.b().a(str, ExifInterface.LONGITUDE_WEST, th.toString());
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void a(Throwable th, String str, Object... objArr) {
        super.a(th, str, objArr);
        sdk.pendo.io.o8.b.b().a(str, "D", th.toString());
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void b(Throwable th, String str, Object... objArr) {
        super.b(th, str, objArr);
        sdk.pendo.io.o8.b.b().a(str, ExifInterface.LONGITUDE_EAST, th.toString());
        g(th, str, objArr);
    }
}
