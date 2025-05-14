package external.sdk.pendo.io.glide.load.model;

import android.util.Log;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.data.a;
import external.sdk.pendo.io.glide.load.model.b;
import external.sdk.pendo.io.glide.signature.ObjectKey;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class ByteBufferFileLoader implements b<File, ByteBuffer> {
    private static final String TAG = "ByteBufferFileLoader";

    public static class Factory implements sdk.pendo.io.x.d<File, ByteBuffer> {
        @Override // sdk.pendo.io.x.d
        public b<File, ByteBuffer> build(e eVar) {
            return new ByteBufferFileLoader();
        }

        public void teardown() {
        }
    }

    private static final class a implements external.sdk.pendo.io.glide.load.data.a<ByteBuffer> {
        private final File f;

        a(File file) {
            this.f = file;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cancel() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cleanup() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public Class<ByteBuffer> getDataClass() {
            return ByteBuffer.class;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public sdk.pendo.io.q.a getDataSource() {
            return sdk.pendo.io.q.a.LOCAL;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void loadData(sdk.pendo.io.o.b bVar, a.InterfaceC0055a<? super ByteBuffer> interfaceC0055a) {
            try {
                interfaceC0055a.a((a.InterfaceC0055a<? super ByteBuffer>) sdk.pendo.io.i0.a.a(this.f));
            } catch (IOException e) {
                if (Log.isLoggable(ByteBufferFileLoader.TAG, 3)) {
                    Log.d(ByteBufferFileLoader.TAG, "Failed to obtain ByteBuffer for file", e);
                }
                interfaceC0055a.a((Exception) e);
            }
        }
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<ByteBuffer> buildLoadData(File file, int i, int i2, Options options) {
        return new b.a<>(new ObjectKey(file), new a(file));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(File file) {
        return true;
    }
}
