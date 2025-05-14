package external.sdk.pendo.io.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.data.a;
import external.sdk.pendo.io.glide.load.model.b;
import external.sdk.pendo.io.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class FileLoader<Data> implements external.sdk.pendo.io.glide.load.model.b<File, Data> {
    private static final String TAG = "FileLoader";
    private final b<Data> fileOpener;

    public static class Factory<Data> implements sdk.pendo.io.x.d<File, Data> {
        private final b<Data> opener;

        public Factory(b<Data> bVar) {
            this.opener = bVar;
        }

        @Override // sdk.pendo.io.x.d
        public final external.sdk.pendo.io.glide.load.model.b<File, Data> build(e eVar) {
            return new FileLoader(this.opener);
        }

        public final void teardown() {
        }
    }

    public static class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {

        class a implements b<ParcelFileDescriptor> {
            a() {
            }

            @Override // external.sdk.pendo.io.glide.load.model.FileLoader.b
            public void a(ParcelFileDescriptor parcelFileDescriptor) {
                parcelFileDescriptor.close();
            }

            @Override // external.sdk.pendo.io.glide.load.model.FileLoader.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ParcelFileDescriptor a(File file) {
                return ParcelFileDescriptor.open(file, 268435456);
            }

            @Override // external.sdk.pendo.io.glide.load.model.FileLoader.b
            public Class<ParcelFileDescriptor> getDataClass() {
                return ParcelFileDescriptor.class;
            }
        }

        public FileDescriptorFactory() {
            super(new a());
        }
    }

    public static class StreamFactory extends Factory<InputStream> {

        class a implements b<InputStream> {
            a() {
            }

            @Override // external.sdk.pendo.io.glide.load.model.FileLoader.b
            public void a(InputStream inputStream) {
                inputStream.close();
            }

            @Override // external.sdk.pendo.io.glide.load.model.FileLoader.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public InputStream a(File file) {
                return new FileInputStream(file);
            }

            @Override // external.sdk.pendo.io.glide.load.model.FileLoader.b
            public Class<InputStream> getDataClass() {
                return InputStream.class;
            }
        }

        public StreamFactory() {
            super(new a());
        }
    }

    private static final class a<Data> implements external.sdk.pendo.io.glide.load.data.a<Data> {
        private Data A;
        private final File f;
        private final b<Data> s;

        a(File file, b<Data> bVar) {
            this.f = file;
            this.s = bVar;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cancel() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cleanup() {
            Data data = this.A;
            if (data != null) {
                try {
                    this.s.a((b<Data>) data);
                } catch (IOException unused) {
                }
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

        /* JADX WARN: Type inference failed for: r3v3, types: [Data, java.lang.Object] */
        @Override // external.sdk.pendo.io.glide.load.data.a
        public void loadData(sdk.pendo.io.o.b bVar, a.InterfaceC0055a<? super Data> interfaceC0055a) {
            try {
                Data a2 = this.s.a(this.f);
                this.A = a2;
                interfaceC0055a.a((a.InterfaceC0055a<? super Data>) a2);
            } catch (FileNotFoundException e) {
                if (Log.isLoggable(FileLoader.TAG, 3)) {
                    Log.d(FileLoader.TAG, "Failed to open file", e);
                }
                interfaceC0055a.a((Exception) e);
            }
        }
    }

    public interface b<Data> {
        Data a(File file);

        void a(Data data);

        Class<Data> getDataClass();
    }

    public FileLoader(b<Data> bVar) {
        this.fileOpener = bVar;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<Data> buildLoadData(File file, int i, int i2, Options options) {
        return new b.a<>(new ObjectKey(file), new a(file, this.fileOpener));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(File file) {
        return true;
    }
}
