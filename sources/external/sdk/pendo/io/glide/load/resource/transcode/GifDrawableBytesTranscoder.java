package external.sdk.pendo.io.glide.load.resource.transcode;

import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.resource.bytes.BytesResource;
import external.sdk.pendo.io.glide.load.resource.gif.GifDrawable;
import sdk.pendo.io.b0.a;
import sdk.pendo.io.t.c;

/* loaded from: classes2.dex */
public class GifDrawableBytesTranscoder implements a<GifDrawable, byte[]> {
    @Override // sdk.pendo.io.b0.a
    public c<byte[]> transcode(c<GifDrawable> cVar, Options options) {
        return new BytesResource(sdk.pendo.io.i0.a.b(cVar.get().getBuffer()));
    }
}
