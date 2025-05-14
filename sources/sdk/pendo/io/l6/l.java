package sdk.pendo.io.l6;

import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public final class l<T> extends sdk.pendo.io.x5.j<T> {
    final Callable<? extends Throwable> f;

    public l(Callable<? extends Throwable> callable) {
        this.f = callable;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super T> oVar) {
        try {
            th = (Throwable) sdk.pendo.io.f6.b.a(this.f.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            sdk.pendo.io.c6.b.b(th);
        }
        sdk.pendo.io.e6.c.a(th, oVar);
    }
}
