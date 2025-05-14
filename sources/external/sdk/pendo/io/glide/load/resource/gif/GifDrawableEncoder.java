package external.sdk.pendo.io.glide.load.resource.gif;

import android.util.Log;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.ResourceEncoder;
import java.io.File;
import java.io.IOException;
import sdk.pendo.io.i0.a;
import sdk.pendo.io.q.c;

/* loaded from: classes2.dex */
public class GifDrawableEncoder implements ResourceEncoder<GifDrawable> {
    private static final String TAG = "GifEncoder";

    @Override // external.sdk.pendo.io.glide.load.ResourceEncoder
    public c getEncodeStrategy(Options options) {
        return c.SOURCE;
    }

    @Override // external.sdk.pendo.io.glide.load.ResourceEncoder, sdk.pendo.io.q.d
    public boolean encode(sdk.pendo.io.t.c<GifDrawable> cVar, File file, Options options) {
        try {
            a.a(cVar.get().getBuffer(), file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Failed to encode GIF drawable data", e);
            }
            return false;
        }
    }
}
