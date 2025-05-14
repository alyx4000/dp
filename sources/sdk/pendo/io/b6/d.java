package sdk.pendo.io.b6;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
abstract class d<T> extends AtomicReference<T> implements b {
    d(T t) {
        super(sdk.pendo.io.f6.b.a((Object) t, "value is null"));
    }

    protected abstract void a(T t);

    @Override // sdk.pendo.io.b6.b
    public final boolean a() {
        return get() == null;
    }

    @Override // sdk.pendo.io.b6.b
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        a(andSet);
    }
}
