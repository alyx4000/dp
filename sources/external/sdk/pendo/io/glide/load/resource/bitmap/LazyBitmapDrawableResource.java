package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import sdk.pendo.io.i0.j;

/* loaded from: classes2.dex */
public final class LazyBitmapDrawableResource implements sdk.pendo.io.t.c<BitmapDrawable>, sdk.pendo.io.t.b {
    private final sdk.pendo.io.t.c<Bitmap> bitmapResource;
    private final Resources resources;

    private LazyBitmapDrawableResource(Resources resources, sdk.pendo.io.t.c<Bitmap> cVar) {
        this.resources = (Resources) j.a(resources);
        this.bitmapResource = (sdk.pendo.io.t.c) j.a(cVar);
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Context context, Bitmap bitmap) {
        return (LazyBitmapDrawableResource) obtain(context.getResources(), BitmapResource.obtain(bitmap, external.sdk.pendo.io.glide.a.a(context).c()));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // sdk.pendo.io.t.c
    public BitmapDrawable get() {
        return new BitmapDrawable(this.resources, this.bitmapResource.get());
    }

    @Override // sdk.pendo.io.t.c
    public Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    @Override // sdk.pendo.io.t.c
    public int getSize() {
        return this.bitmapResource.getSize();
    }

    @Override // sdk.pendo.io.t.b
    public void initialize() {
        sdk.pendo.io.t.c<Bitmap> cVar = this.bitmapResource;
        if (cVar instanceof sdk.pendo.io.t.b) {
            ((sdk.pendo.io.t.b) cVar).initialize();
        }
    }

    @Override // sdk.pendo.io.t.c
    public void recycle() {
        this.bitmapResource.recycle();
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Resources resources, sdk.pendo.io.u.b bVar, Bitmap bitmap) {
        return (LazyBitmapDrawableResource) obtain(resources, BitmapResource.obtain(bitmap, bVar));
    }

    public static sdk.pendo.io.t.c<BitmapDrawable> obtain(Resources resources, sdk.pendo.io.t.c<Bitmap> cVar) {
        if (cVar == null) {
            return null;
        }
        return new LazyBitmapDrawableResource(resources, cVar);
    }
}
