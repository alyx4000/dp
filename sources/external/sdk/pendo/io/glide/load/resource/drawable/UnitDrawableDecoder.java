package external.sdk.pendo.io.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.load.Options;
import sdk.pendo.io.q.i;
import sdk.pendo.io.t.c;

/* loaded from: classes2.dex */
public class UnitDrawableDecoder implements i<Drawable, Drawable> {
    @Override // sdk.pendo.io.q.i
    public c<Drawable> decode(Drawable drawable, int i, int i2, Options options) {
        return a.a(drawable);
    }

    @Override // sdk.pendo.io.q.i
    public boolean handles(Drawable drawable, Options options) {
        return true;
    }
}
