package external.sdk.pendo.io.glide.load.model.stream;

import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.data.HttpUrlFetcher;
import external.sdk.pendo.io.glide.load.model.GlideUrl;
import external.sdk.pendo.io.glide.load.model.b;
import external.sdk.pendo.io.glide.load.model.e;
import java.io.InputStream;
import sdk.pendo.io.q.g;
import sdk.pendo.io.x.c;
import sdk.pendo.io.x.d;

/* loaded from: classes2.dex */
public class HttpGlideUrlLoader implements b<GlideUrl, InputStream> {
    public static final g<Integer> TIMEOUT = g.a("external.sdk.pendo.io.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    private final c<GlideUrl, GlideUrl> modelCache;

    public static class Factory implements d<GlideUrl, InputStream> {
        private final c<GlideUrl, GlideUrl> modelCache = new c<>(500);

        @Override // sdk.pendo.io.x.d
        public b<GlideUrl, InputStream> build(e eVar) {
            return new HttpGlideUrlLoader(this.modelCache);
        }

        public void teardown() {
        }
    }

    public HttpGlideUrlLoader() {
        this(null);
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<InputStream> buildLoadData(GlideUrl glideUrl, int i, int i2, Options options) {
        c<GlideUrl, GlideUrl> cVar = this.modelCache;
        if (cVar != null) {
            GlideUrl a2 = cVar.a(glideUrl, 0, 0);
            if (a2 == null) {
                this.modelCache.a(glideUrl, 0, 0, glideUrl);
            } else {
                glideUrl = a2;
            }
        }
        return new b.a<>(glideUrl, new HttpUrlFetcher(glideUrl, ((Integer) options.get(TIMEOUT)).intValue()));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(GlideUrl glideUrl) {
        return true;
    }

    public HttpGlideUrlLoader(c<GlideUrl, GlideUrl> cVar) {
        this.modelCache = cVar;
    }
}
