package sdk.pendo.io.p6;

import java.util.concurrent.atomic.AtomicInteger;
import sdk.pendo.io.g6.d;

/* loaded from: classes6.dex */
public abstract class a<T> extends AtomicInteger implements d<T> {
    @Override // sdk.pendo.io.g6.g
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
