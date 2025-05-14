package com.quantummetric.ui.internal;

import okio.Buffer;
import okio.Okio;
import org.brotli.dec.BrotliInputStream;

/* loaded from: classes5.dex */
final class n {
    n() {
    }

    static Buffer a(Buffer buffer) {
        Buffer buffer2 = new Buffer();
        try {
            buffer2.writeAll(Okio.source(new BrotliInputStream(buffer.inputStream())));
        } catch (Throwable unused) {
        }
        return buffer2;
    }
}
