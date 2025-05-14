package external.sdk.pendo.io.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.model.b;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class StringLoader<Data> implements b<String, Data> {
    private final b<Uri, Data> uriLoader;

    public static final class AssetFileDescriptorFactory implements sdk.pendo.io.x.d<String, AssetFileDescriptor> {
        @Override // sdk.pendo.io.x.d
        public b<String, AssetFileDescriptor> build(e eVar) {
            return new StringLoader(eVar.a(Uri.class, AssetFileDescriptor.class));
        }

        public void teardown() {
        }
    }

    public static class FileDescriptorFactory implements sdk.pendo.io.x.d<String, ParcelFileDescriptor> {
        @Override // sdk.pendo.io.x.d
        public b<String, ParcelFileDescriptor> build(e eVar) {
            return new StringLoader(eVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        public void teardown() {
        }
    }

    public static class StreamFactory implements sdk.pendo.io.x.d<String, InputStream> {
        @Override // sdk.pendo.io.x.d
        public b<String, InputStream> build(e eVar) {
            return new StringLoader(eVar.a(Uri.class, InputStream.class));
        }

        public void teardown() {
        }
    }

    public StringLoader(b<Uri, Data> bVar) {
        this.uriLoader = bVar;
    }

    private static Uri parseUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) != '/') {
            Uri parse = Uri.parse(str);
            if (parse.getScheme() != null) {
                return parse;
            }
        }
        return toFileUri(str);
    }

    private static Uri toFileUri(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(String str) {
        return true;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<Data> buildLoadData(String str, int i, int i2, Options options) {
        Uri parseUri = parseUri(str);
        if (parseUri == null || !this.uriLoader.handles(parseUri)) {
            return null;
        }
        return this.uriLoader.buildLoadData(parseUri, i, i2, options);
    }
}
