package com.google.firebase.inject;

/* loaded from: classes5.dex */
public interface Deferred<T> {

    public interface DeferredHandler<T> {
        void handle(Provider<T> provider);
    }

    void whenAvailable(DeferredHandler<T> deferredHandler);
}
