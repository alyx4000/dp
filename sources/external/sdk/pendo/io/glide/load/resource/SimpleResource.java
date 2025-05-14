package external.sdk.pendo.io.glide.load.resource;

import sdk.pendo.io.i0.j;
import sdk.pendo.io.t.c;

/* loaded from: classes2.dex */
public class SimpleResource<T> implements c<T> {
    protected final T data;

    public SimpleResource(T t) {
        this.data = (T) j.a(t);
    }

    @Override // sdk.pendo.io.t.c
    public final T get() {
        return this.data;
    }

    @Override // sdk.pendo.io.t.c
    public Class<T> getResourceClass() {
        return (Class<T>) this.data.getClass();
    }

    @Override // sdk.pendo.io.t.c
    public final int getSize() {
        return 1;
    }

    @Override // sdk.pendo.io.t.c
    public void recycle() {
    }
}
