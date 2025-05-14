package external.sdk.pendo.io.glide.load.data;

import external.sdk.pendo.io.glide.load.data.b;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class InputStreamRewinder implements b<InputStream> {
    private static final int MARK_READ_LIMIT = 5242880;
    private final sdk.pendo.io.y.a bufferedStream;

    public static final class Factory implements b.a<InputStream> {
        private final sdk.pendo.io.u.a byteArrayPool;

        public Factory(sdk.pendo.io.u.a aVar) {
            this.byteArrayPool = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.data.b.a
        public b<InputStream> build(InputStream inputStream) {
            return new InputStreamRewinder(inputStream, this.byteArrayPool);
        }

        @Override // external.sdk.pendo.io.glide.load.data.b.a
        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }
    }

    public InputStreamRewinder(InputStream inputStream, sdk.pendo.io.u.a aVar) {
        sdk.pendo.io.y.a aVar2 = new sdk.pendo.io.y.a(inputStream, aVar);
        this.bufferedStream = aVar2;
        aVar2.mark(MARK_READ_LIMIT);
    }

    @Override // external.sdk.pendo.io.glide.load.data.b
    public void cleanup() {
        this.bufferedStream.b();
    }

    public void fixMarkLimits() {
        this.bufferedStream.a();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // external.sdk.pendo.io.glide.load.data.b
    public InputStream rewindAndGet() {
        this.bufferedStream.reset();
        return this.bufferedStream;
    }
}
