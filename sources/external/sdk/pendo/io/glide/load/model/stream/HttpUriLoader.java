package external.sdk.pendo.io.glide.load.model.stream;

import external.sdk.pendo.io.glide.load.model.GlideUrl;
import external.sdk.pendo.io.glide.load.model.UrlUriLoader;
import external.sdk.pendo.io.glide.load.model.b;
import java.io.InputStream;

@Deprecated
/* loaded from: classes2.dex */
public class HttpUriLoader extends UrlUriLoader<InputStream> {

    @Deprecated
    public static class Factory extends UrlUriLoader.StreamFactory {
    }

    public HttpUriLoader(b<GlideUrl, InputStream> bVar) {
        super(bVar);
    }
}
