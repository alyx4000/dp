package external.sdk.pendo.io.glide.load.model;

import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.data.a;
import external.sdk.pendo.io.glide.load.model.b;
import external.sdk.pendo.io.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class ByteArrayLoader<Data> implements external.sdk.pendo.io.glide.load.model.b<byte[], Data> {
    private final a<Data> converter;

    public static class ByteBufferFactory implements sdk.pendo.io.x.d<byte[], ByteBuffer> {

        class a implements a<ByteBuffer> {
            a() {
            }

            @Override // external.sdk.pendo.io.glide.load.model.ByteArrayLoader.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ByteBuffer a(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }

            @Override // external.sdk.pendo.io.glide.load.model.ByteArrayLoader.a
            public Class<ByteBuffer> getDataClass() {
                return ByteBuffer.class;
            }
        }

        @Override // sdk.pendo.io.x.d
        public external.sdk.pendo.io.glide.load.model.b<byte[], ByteBuffer> build(e eVar) {
            return new ByteArrayLoader(new a());
        }

        public void teardown() {
        }
    }

    public static class StreamFactory implements sdk.pendo.io.x.d<byte[], InputStream> {

        class a implements a<InputStream> {
            a() {
            }

            @Override // external.sdk.pendo.io.glide.load.model.ByteArrayLoader.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public InputStream a(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }

            @Override // external.sdk.pendo.io.glide.load.model.ByteArrayLoader.a
            public Class<InputStream> getDataClass() {
                return InputStream.class;
            }
        }

        @Override // sdk.pendo.io.x.d
        public external.sdk.pendo.io.glide.load.model.b<byte[], InputStream> build(e eVar) {
            return new ByteArrayLoader(new a());
        }

        public void teardown() {
        }
    }

    public interface a<Data> {
        Data a(byte[] bArr);

        Class<Data> getDataClass();
    }

    private static class b<Data> implements external.sdk.pendo.io.glide.load.data.a<Data> {
        private final byte[] f;
        private final a<Data> s;

        b(byte[] bArr, a<Data> aVar) {
            this.f = bArr;
            this.s = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cancel() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cleanup() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public Class<Data> getDataClass() {
            return this.s.getDataClass();
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public sdk.pendo.io.q.a getDataSource() {
            return sdk.pendo.io.q.a.LOCAL;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void loadData(sdk.pendo.io.o.b bVar, a.InterfaceC0055a<? super Data> interfaceC0055a) {
            interfaceC0055a.a((a.InterfaceC0055a<? super Data>) this.s.a(this.f));
        }
    }

    public ByteArrayLoader(a<Data> aVar) {
        this.converter = aVar;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(byte[] bArr) {
        return true;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<Data> buildLoadData(byte[] bArr, int i, int i2, Options options) {
        return new b.a<>(new ObjectKey(bArr), new b(bArr, this.converter));
    }
}
