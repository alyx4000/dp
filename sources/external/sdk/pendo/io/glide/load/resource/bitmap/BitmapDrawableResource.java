package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import external.sdk.pendo.io.glide.load.resource.drawable.DrawableResource;
import sdk.pendo.io.i0.k;

/* loaded from: classes2.dex */
public class BitmapDrawableResource extends DrawableResource<BitmapDrawable> {
    private final sdk.pendo.io.u.b bitmapPool;

    public BitmapDrawableResource(BitmapDrawable bitmapDrawable, sdk.pendo.io.u.b bVar) {
        super(bitmapDrawable);
        this.bitmapPool = bVar;
    }

    @Override // external.sdk.pendo.io.glide.load.resource.drawable.DrawableResource, sdk.pendo.io.t.c
    public Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    @Override // external.sdk.pendo.io.glide.load.resource.drawable.DrawableResource, sdk.pendo.io.t.c
    public int getSize() {
        return k.a(((BitmapDrawable) this.drawable).getBitmap());
    }

    @Override // external.sdk.pendo.io.glide.load.resource.drawable.DrawableResource, sdk.pendo.io.t.b
    public void initialize() {
        ((BitmapDrawable) this.drawable).getBitmap().prepareToDraw();
    }

    @Override // external.sdk.pendo.io.glide.load.resource.drawable.DrawableResource, sdk.pendo.io.t.c
    public void recycle() {
        this.bitmapPool.put(((BitmapDrawable) this.drawable).getBitmap());
    }
}
