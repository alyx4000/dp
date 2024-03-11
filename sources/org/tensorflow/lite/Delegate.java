package org.tensorflow.lite;

import java.io.Closeable;

/* loaded from: classes6.dex */
public interface Delegate extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    default void close() {
    }

    long getNativeHandle();
}
