package external.sdk.pendo.io.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.iterable.iterableapi.IterableConstants;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.model.b;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

/* loaded from: classes2.dex */
public class ResourceLoader<Data> implements b<Integer, Data> {
    private static final String TAG = "ResourceLoader";
    private final Resources resources;
    private final b<Uri, Data> uriLoader;

    public static final class AssetFileDescriptorFactory implements sdk.pendo.io.x.d<Integer, AssetFileDescriptor> {
        private final Resources resources;

        public AssetFileDescriptorFactory(Resources resources) {
            this.resources = resources;
        }

        @Override // sdk.pendo.io.x.d
        public b<Integer, AssetFileDescriptor> build(e eVar) {
            return new ResourceLoader(this.resources, eVar.a(Uri.class, AssetFileDescriptor.class));
        }

        public void teardown() {
        }
    }

    public static class FileDescriptorFactory implements sdk.pendo.io.x.d<Integer, ParcelFileDescriptor> {
        private final Resources resources;

        public FileDescriptorFactory(Resources resources) {
            this.resources = resources;
        }

        @Override // sdk.pendo.io.x.d
        public b<Integer, ParcelFileDescriptor> build(e eVar) {
            return new ResourceLoader(this.resources, eVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        public void teardown() {
        }
    }

    public static class StreamFactory implements sdk.pendo.io.x.d<Integer, InputStream> {
        private final Resources resources;

        public StreamFactory(Resources resources) {
            this.resources = resources;
        }

        @Override // sdk.pendo.io.x.d
        public b<Integer, InputStream> build(e eVar) {
            return new ResourceLoader(this.resources, eVar.a(Uri.class, InputStream.class));
        }

        public void teardown() {
        }
    }

    public static class UriFactory implements sdk.pendo.io.x.d<Integer, Uri> {
        private final Resources resources;

        public UriFactory(Resources resources) {
            this.resources = resources;
        }

        @Override // sdk.pendo.io.x.d
        public b<Integer, Uri> build(e eVar) {
            return new ResourceLoader(this.resources, UnitModelLoader.getInstance());
        }

        public void teardown() {
        }
    }

    public ResourceLoader(Resources resources, b<Uri, Data> bVar) {
        this.resources = resources;
        this.uriLoader = bVar;
    }

    private Uri getResourceUri(Integer num) {
        try {
            return Uri.parse(IterableConstants.ANDROID_RESOURCE_PATH + this.resources.getResourcePackageName(num.intValue()) + IOUtils.DIR_SEPARATOR_UNIX + this.resources.getResourceTypeName(num.intValue()) + IOUtils.DIR_SEPARATOR_UNIX + this.resources.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (!Log.isLoggable(TAG, 5)) {
                return null;
            }
            Log.w(TAG, "Received invalid resource id: " + num, e);
            return null;
        }
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<Data> buildLoadData(Integer num, int i, int i2, Options options) {
        Uri resourceUri = getResourceUri(num);
        if (resourceUri == null) {
            return null;
        }
        return this.uriLoader.buildLoadData(resourceUri, i, i2, options);
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(Integer num) {
        return true;
    }
}
