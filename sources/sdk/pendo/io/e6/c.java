package sdk.pendo.io.e6;

import sdk.pendo.io.x5.h;
import sdk.pendo.io.x5.o;

/* loaded from: classes6.dex */
public enum c implements sdk.pendo.io.g6.b<Object> {
    INSTANCE,
    NEVER;

    public static void a(h<?> hVar) {
        hVar.onSubscribe(INSTANCE);
        hVar.onComplete();
    }

    @Override // sdk.pendo.io.g6.c
    public int a(int i) {
        return i & 2;
    }

    @Override // sdk.pendo.io.g6.g
    public void clear() {
    }

    @Override // sdk.pendo.io.b6.b
    public void dispose() {
    }

    @Override // sdk.pendo.io.g6.g
    public boolean isEmpty() {
        return true;
    }

    @Override // sdk.pendo.io.g6.g
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // sdk.pendo.io.g6.g
    public Object poll() {
        return null;
    }

    public static void a(o<?> oVar) {
        oVar.onSubscribe(INSTANCE);
        oVar.onComplete();
    }

    public static void a(Throwable th, o<?> oVar) {
        oVar.onSubscribe(INSTANCE);
        oVar.onError(th);
    }

    @Override // sdk.pendo.io.b6.b
    public boolean a() {
        return this == INSTANCE;
    }
}
