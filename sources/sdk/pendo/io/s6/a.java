package sdk.pendo.io.s6;

import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.q6.f;
import sdk.pendo.io.x5.o;

/* loaded from: classes6.dex */
public abstract class a<T> implements o<T>, sdk.pendo.io.b6.b {
    final AtomicReference<sdk.pendo.io.b6.b> f = new AtomicReference<>();

    @Override // sdk.pendo.io.b6.b
    public final boolean a() {
        return this.f.get() == sdk.pendo.io.e6.b.DISPOSED;
    }

    protected void b() {
    }

    @Override // sdk.pendo.io.b6.b
    public final void dispose() {
        sdk.pendo.io.e6.b.a(this.f);
    }

    @Override // sdk.pendo.io.x5.o
    public final void onSubscribe(sdk.pendo.io.b6.b bVar) {
        if (f.a(this.f, bVar, getClass())) {
            b();
        }
    }
}
