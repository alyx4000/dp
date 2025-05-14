package sdk.pendo.io.e6;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class f extends AtomicReference<sdk.pendo.io.b6.b> implements sdk.pendo.io.b6.b {
    public f() {
    }

    public f(sdk.pendo.io.b6.b bVar) {
        lazySet(bVar);
    }

    @Override // sdk.pendo.io.b6.b
    public boolean a() {
        return b.a(get());
    }

    public boolean b(sdk.pendo.io.b6.b bVar) {
        return b.b(this, bVar);
    }

    @Override // sdk.pendo.io.b6.b
    public void dispose() {
        b.a((AtomicReference<sdk.pendo.io.b6.b>) this);
    }

    public boolean a(sdk.pendo.io.b6.b bVar) {
        return b.a((AtomicReference<sdk.pendo.io.b6.b>) this, bVar);
    }
}
