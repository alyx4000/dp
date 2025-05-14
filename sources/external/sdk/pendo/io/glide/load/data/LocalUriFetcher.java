package external.sdk.pendo.io.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import external.sdk.pendo.io.glide.load.data.a;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class LocalUriFetcher<T> implements a<T> {
    private static final String TAG = "LocalUriFetcher";
    private final ContentResolver contentResolver;
    private T data;
    private final Uri uri;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this.contentResolver = contentResolver;
        this.uri = uri;
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public void cancel() {
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public void cleanup() {
        T t = this.data;
        if (t != null) {
            try {
                close(t);
            } catch (IOException unused) {
            }
        }
    }

    protected abstract void close(T t);

    @Override // external.sdk.pendo.io.glide.load.data.a
    public abstract /* synthetic */ Class getDataClass();

    @Override // external.sdk.pendo.io.glide.load.data.a
    public sdk.pendo.io.q.a getDataSource() {
        return sdk.pendo.io.q.a.LOCAL;
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public final void loadData(sdk.pendo.io.o.b bVar, a.InterfaceC0055a<? super T> interfaceC0055a) {
        try {
            T loadResource = loadResource(this.uri, this.contentResolver);
            this.data = loadResource;
            interfaceC0055a.a((a.InterfaceC0055a<? super T>) loadResource);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to open Uri", e);
            }
            interfaceC0055a.a((Exception) e);
        }
    }

    protected abstract T loadResource(Uri uri, ContentResolver contentResolver);
}
