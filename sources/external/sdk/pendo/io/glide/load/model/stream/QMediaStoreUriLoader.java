package external.sdk.pendo.io.glide.load.model.stream;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.data.a;
import external.sdk.pendo.io.glide.load.model.b;
import external.sdk.pendo.io.glide.load.model.e;
import external.sdk.pendo.io.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import sdk.pendo.io.x.d;

/* loaded from: classes2.dex */
public final class QMediaStoreUriLoader<DataT> implements external.sdk.pendo.io.glide.load.model.b<Uri, DataT> {
    private final Context context;
    private final Class<DataT> dataClass;
    private final external.sdk.pendo.io.glide.load.model.b<File, DataT> fileDelegate;
    private final external.sdk.pendo.io.glide.load.model.b<Uri, DataT> uriDelegate;

    public static final class FileDescriptorFactory extends a<ParcelFileDescriptor> {
        public FileDescriptorFactory(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    public static final class InputStreamFactory extends a<InputStream> {
        public InputStreamFactory(Context context) {
            super(context, InputStream.class);
        }
    }

    private static abstract class a<DataT> implements d<Uri, DataT> {
        private final Context context;
        private final Class<DataT> dataClass;

        a(Context context, Class<DataT> cls) {
            this.context = context;
            this.dataClass = cls;
        }

        @Override // sdk.pendo.io.x.d
        public final external.sdk.pendo.io.glide.load.model.b<Uri, DataT> build(e eVar) {
            return new QMediaStoreUriLoader(this.context, eVar.a(File.class, this.dataClass), eVar.a(Uri.class, this.dataClass), this.dataClass);
        }

        public final void teardown() {
        }
    }

    private static final class b<DataT> implements external.sdk.pendo.io.glide.load.data.a<DataT> {
        private static final String[] z0 = {"_data"};
        private final external.sdk.pendo.io.glide.load.model.b<Uri, DataT> A;
        private final Context f;
        private final Uri f0;
        private final external.sdk.pendo.io.glide.load.model.b<File, DataT> s;
        private final int t0;
        private final int u0;
        private final Options v0;
        private final Class<DataT> w0;
        private volatile boolean x0;
        private volatile external.sdk.pendo.io.glide.load.data.a<DataT> y0;

        b(Context context, external.sdk.pendo.io.glide.load.model.b<File, DataT> bVar, external.sdk.pendo.io.glide.load.model.b<Uri, DataT> bVar2, Uri uri, int i, int i2, Options options, Class<DataT> cls) {
            this.f = context.getApplicationContext();
            this.s = bVar;
            this.A = bVar2;
            this.f0 = uri;
            this.t0 = i;
            this.u0 = i2;
            this.v0 = options;
            this.w0 = cls;
        }

        private b.a<DataT> a() {
            if (Environment.isExternalStorageLegacy()) {
                return this.s.buildLoadData(a(this.f0), this.t0, this.u0, this.v0);
            }
            return this.A.buildLoadData(c() ? MediaStore.setRequireOriginal(this.f0) : this.f0, this.t0, this.u0, this.v0);
        }

        private external.sdk.pendo.io.glide.load.data.a<DataT> b() {
            b.a<DataT> a2 = a();
            if (a2 != null) {
                return a2.c;
            }
            return null;
        }

        private boolean c() {
            return this.f.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cancel() {
            this.x0 = true;
            external.sdk.pendo.io.glide.load.data.a<DataT> aVar = this.y0;
            if (aVar != null) {
                aVar.cancel();
            }
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cleanup() {
            external.sdk.pendo.io.glide.load.data.a<DataT> aVar = this.y0;
            if (aVar != null) {
                aVar.cleanup();
            }
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public Class<DataT> getDataClass() {
            return this.w0;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public sdk.pendo.io.q.a getDataSource() {
            return sdk.pendo.io.q.a.LOCAL;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void loadData(sdk.pendo.io.o.b bVar, a.InterfaceC0055a<? super DataT> interfaceC0055a) {
            try {
                external.sdk.pendo.io.glide.load.data.a<DataT> b = b();
                if (b == null) {
                    interfaceC0055a.a((Exception) new IllegalArgumentException("Failed to build fetcher for: " + this.f0));
                    return;
                }
                this.y0 = b;
                if (this.x0) {
                    cancel();
                } else {
                    b.loadData(bVar, interfaceC0055a);
                }
            } catch (FileNotFoundException e) {
                interfaceC0055a.a((Exception) e);
            }
        }

        private File a(Uri uri) {
            Cursor cursor = null;
            try {
                Cursor query = this.f.getContentResolver().query(uri, z0, null, null, null);
                if (query == null || !query.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                if (TextUtils.isEmpty(string)) {
                    throw new FileNotFoundException("File path was empty in media store for: " + uri);
                }
                File file = new File(string);
                query.close();
                return file;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    QMediaStoreUriLoader(Context context, external.sdk.pendo.io.glide.load.model.b<File, DataT> bVar, external.sdk.pendo.io.glide.load.model.b<Uri, DataT> bVar2, Class<DataT> cls) {
        this.context = context.getApplicationContext();
        this.fileDelegate = bVar;
        this.uriDelegate = bVar2;
        this.dataClass = cls;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<DataT> buildLoadData(Uri uri, int i, int i2, Options options) {
        return new b.a<>(new ObjectKey(uri), new b(this.context, this.fileDelegate, this.uriDelegate, uri, i, i2, options, this.dataClass));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && sdk.pendo.io.s.a.b(uri);
    }
}
