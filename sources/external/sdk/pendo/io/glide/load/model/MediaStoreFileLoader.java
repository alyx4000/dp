package external.sdk.pendo.io.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.data.a;
import external.sdk.pendo.io.glide.load.model.b;
import external.sdk.pendo.io.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes2.dex */
public final class MediaStoreFileLoader implements b<Uri, File> {
    private final Context context;

    public static final class Factory implements sdk.pendo.io.x.d<Uri, File> {
        private final Context context;

        public Factory(Context context) {
            this.context = context;
        }

        @Override // sdk.pendo.io.x.d
        public b<Uri, File> build(e eVar) {
            return new MediaStoreFileLoader(this.context);
        }

        public void teardown() {
        }
    }

    private static class a implements external.sdk.pendo.io.glide.load.data.a<File> {
        private static final String[] A = {"_data"};
        private final Context f;
        private final Uri s;

        a(Context context, Uri uri) {
            this.f = context;
            this.s = uri;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cancel() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cleanup() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public Class<File> getDataClass() {
            return File.class;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public sdk.pendo.io.q.a getDataSource() {
            return sdk.pendo.io.q.a.LOCAL;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void loadData(sdk.pendo.io.o.b bVar, a.InterfaceC0055a<? super File> interfaceC0055a) {
            Cursor query = this.f.getContentResolver().query(this.s, A, null, null, null);
            if (query != null) {
                try {
                    r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(r0)) {
                interfaceC0055a.a((Exception) new FileNotFoundException("Failed to find file path for: " + this.s));
            } else {
                interfaceC0055a.a((a.InterfaceC0055a<? super File>) new File(r0));
            }
        }
    }

    public MediaStoreFileLoader(Context context) {
        this.context = context;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<File> buildLoadData(Uri uri, int i, int i2, Options options) {
        return new b.a<>(new ObjectKey(uri), new a(this.context, uri));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(Uri uri) {
        return sdk.pendo.io.s.a.b(uri);
    }
}
