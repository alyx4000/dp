package org.apache.commons.lang3.concurrent;

/* loaded from: classes6.dex */
public interface CircuitBreaker<T> {
    boolean checkState();

    void close();

    boolean incrementAndCheckState(T t);

    boolean isClosed();

    boolean isOpen();

    void open();
}
