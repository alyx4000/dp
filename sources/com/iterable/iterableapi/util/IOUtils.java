package com.iterable.iterableapi.util;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class IOUtils {
    private IOUtils() {
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
