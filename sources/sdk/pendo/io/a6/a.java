package sdk.pendo.io.a6;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final p f855a = sdk.pendo.io.z5.a.b(new CallableC0080a());

    /* renamed from: sdk.pendo.io.a6.a$a, reason: collision with other inner class name */
    class CallableC0080a implements Callable<p> {
        CallableC0080a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p call() {
            return b.f856a;
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final p f856a = new sdk.pendo.io.a6.b(new Handler(Looper.getMainLooper()), false);
    }

    public static p a() {
        return sdk.pendo.io.z5.a.a(f855a);
    }
}
