package sdk.pendo.io.i8;

import android.util.Log;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\u0003B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/i8/e;", "", "Ljava/lang/Thread$UncaughtExceptionHandler;", "a", "Ljava/lang/Thread$UncaughtExceptionHandler;", "mDefaultUncaughtExceptionHandler", "b", "mCaughtExceptionHandler", "Lsdk/pendo/io/d6/e;", "", "consumer", "<init>", "(Lsdk/pendo/io/d6/e;)V", "c", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Thread.UncaughtExceptionHandler mDefaultUncaughtExceptionHandler;

    /* renamed from: b, reason: from kotlin metadata */
    private final Thread.UncaughtExceptionHandler mCaughtExceptionHandler;

    public e(sdk.pendo.io.d6.e<Throwable> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        this.mDefaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = new Thread.UncaughtExceptionHandler() { // from class: sdk.pendo.io.i8.e$$ExternalSyntheticLambda0
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                e.a(e.this, thread, th);
            }
        };
        this.mCaughtExceptionHandler = uncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        sdk.pendo.io.t6.a.a(consumer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(e this$0, Thread thread, Throwable th) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.e("PendoExceptionHandler", "PossibleCrash_androidX " + th.getMessage());
        sdk.pendo.io.g9.d.a(th, (String) null, "PossibleCrash_androidX");
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this$0.mDefaultUncaughtExceptionHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
