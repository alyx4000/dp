package external.sdk.pendo.io.glide.load.model;

import android.util.Base64;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.data.a;
import external.sdk.pendo.io.glide.load.model.b;
import external.sdk.pendo.io.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class DataUrlLoader<Model, Data> implements external.sdk.pendo.io.glide.load.model.b<Model, Data> {
    private static final String BASE64_TAG = ";base64";
    private static final String DATA_SCHEME_IMAGE = "data:image";
    private final a<Data> dataDecoder;

    public static final class StreamFactory<Model> implements sdk.pendo.io.x.d<Model, InputStream> {
        private final a<InputStream> opener = new a();

        class a implements a<InputStream> {
            a() {
            }

            @Override // external.sdk.pendo.io.glide.load.model.DataUrlLoader.a
            public void a(InputStream inputStream) {
                inputStream.close();
            }

            @Override // external.sdk.pendo.io.glide.load.model.DataUrlLoader.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public InputStream a(String str) {
                if (!str.startsWith(DataUrlLoader.DATA_SCHEME_IMAGE)) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int indexOf = str.indexOf(44);
                if (indexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, indexOf).endsWith(DataUrlLoader.BASE64_TAG)) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }

            @Override // external.sdk.pendo.io.glide.load.model.DataUrlLoader.a
            public Class<InputStream> getDataClass() {
                return InputStream.class;
            }
        }

        @Override // sdk.pendo.io.x.d
        public external.sdk.pendo.io.glide.load.model.b<Model, InputStream> build(e eVar) {
            return new DataUrlLoader(this.opener);
        }

        public void teardown() {
        }
    }

    public interface a<Data> {
        Data a(String str);

        void a(Data data);

        Class<Data> getDataClass();
    }

    private static final class b<Data> implements external.sdk.pendo.io.glide.load.data.a<Data> {
        private Data A;
        private final String f;
        private final a<Data> s;

        b(String str, a<Data> aVar) {
            this.f = str;
            this.s = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cancel() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cleanup() {
            try {
                this.s.a((a<Data>) this.A);
            } catch (IOException unused) {
            }
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public Class<Data> getDataClass() {
            return this.s.getDataClass();
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public sdk.pendo.io.q.a getDataSource() {
            return sdk.pendo.io.q.a.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [Data, java.lang.Object] */
        @Override // external.sdk.pendo.io.glide.load.data.a
        public void loadData(sdk.pendo.io.o.b bVar, a.InterfaceC0055a<? super Data> interfaceC0055a) {
            try {
                Data a2 = this.s.a(this.f);
                this.A = a2;
                interfaceC0055a.a((a.InterfaceC0055a<? super Data>) a2);
            } catch (IllegalArgumentException e) {
                interfaceC0055a.a((Exception) e);
            }
        }
    }

    public DataUrlLoader(a<Data> aVar) {
        this.dataDecoder = aVar;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<Data> buildLoadData(Model model, int i, int i2, Options options) {
        return new b.a<>(new ObjectKey(model), new b(model.toString(), this.dataDecoder));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(Model model) {
        return model.toString().startsWith(DATA_SCHEME_IMAGE);
    }
}
