package external.sdk.pendo.io.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import external.sdk.pendo.io.glide.load.data.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class ThumbFetcher implements external.sdk.pendo.io.glide.load.data.a<InputStream> {
    private static final String TAG = "MediaStoreThumbFetcher";
    private InputStream inputStream;
    private final Uri mediaStoreImageUri;
    private final c opener;

    static class a implements external.sdk.pendo.io.glide.load.data.mediastore.b {
        private static final String[] b = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f639a;

        a(ContentResolver contentResolver) {
            this.f639a = contentResolver;
        }

        @Override // external.sdk.pendo.io.glide.load.data.mediastore.b
        public Cursor a(Uri uri) {
            return this.f639a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    static class b implements external.sdk.pendo.io.glide.load.data.mediastore.b {
        private static final String[] b = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f640a;

        b(ContentResolver contentResolver) {
            this.f640a = contentResolver;
        }

        @Override // external.sdk.pendo.io.glide.load.data.mediastore.b
        public Cursor a(Uri uri) {
            return this.f640a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    ThumbFetcher(Uri uri, c cVar) {
        this.mediaStoreImageUri = uri;
        this.opener = cVar;
    }

    private static ThumbFetcher build(Context context, Uri uri, external.sdk.pendo.io.glide.load.data.mediastore.b bVar) {
        return new ThumbFetcher(uri, new c(external.sdk.pendo.io.glide.a.a(context).g().a(), bVar, external.sdk.pendo.io.glide.a.a(context).b(), context.getContentResolver()));
    }

    public static ThumbFetcher buildImageFetcher(Context context, Uri uri) {
        return build(context, uri, new a(context.getContentResolver()));
    }

    public static ThumbFetcher buildVideoFetcher(Context context, Uri uri) {
        return build(context, uri, new b(context.getContentResolver()));
    }

    private InputStream openThumbInputStream() {
        InputStream c = this.opener.c(this.mediaStoreImageUri);
        int a2 = c != null ? this.opener.a(this.mediaStoreImageUri) : -1;
        return a2 != -1 ? new sdk.pendo.io.r.b(c, a2) : c;
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public void cancel() {
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public void cleanup() {
        InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public sdk.pendo.io.q.a getDataSource() {
        return sdk.pendo.io.q.a.LOCAL;
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public void loadData(sdk.pendo.io.o.b bVar, a.InterfaceC0055a<? super InputStream> interfaceC0055a) {
        try {
            InputStream openThumbInputStream = openThumbInputStream();
            this.inputStream = openThumbInputStream;
            interfaceC0055a.a((a.InterfaceC0055a<? super InputStream>) openThumbInputStream);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to find thumbnail file", e);
            }
            interfaceC0055a.a((Exception) e);
        }
    }
}
