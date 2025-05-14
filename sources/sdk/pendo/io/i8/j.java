package sdk.pendo.io.i8;

import java.io.IOException;
import java.net.SocketException;
import kotlin.Metadata;
import sdk.pendo.io.g9.m0;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"Lsdk/pendo/io/i8/j;", "Lsdk/pendo/io/d6/e;", "", "e", "", "a", "<init>", "()V", "f", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class j implements sdk.pendo.io.d6.e<Throwable> {
    @Override // sdk.pendo.io.d6.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(Throwable e) {
        Throwable th;
        Throwable cause;
        if (m0.a(e)) {
            PendoLogger.i("Throwable passed to RxJavaPlugins error handler", new Object[0]);
            if (e == null || (th = e.getCause()) == null) {
                th = e;
            }
            if ((th instanceof d) && (cause = ((d) th).getCause()) != null) {
                PendoLogger.e("RxJavaPlugins error handler: Exception thrown by app, Pendo is rethrowing it - " + th, new Object[0]);
                throw cause;
            }
            if (e instanceof sdk.pendo.io.c6.f) {
                PendoLogger.w("RxJavaPlugins error handler: UndeliverableException. Will not crash " + th, new Object[0]);
                return;
            }
            if (e instanceof SocketException ? true : e instanceof IOException) {
                PendoLogger.d("RxJavaPlugins error handler: IOException or SocketException, " + th + ". Will not crash", new Object[0]);
            } else if (e instanceof InterruptedException) {
                PendoLogger.d("RxJavaPlugins error handler: InterruptedException, " + th + ". Will not crash", new Object[0]);
            } else {
                PendoLogger.e(e, "RxJavaPlugins error handler: " + th + ". Will not crash, but will be reported", new Object[0]);
            }
        }
    }
}
