package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import sdk.pendo.io.i0.j;
import sdk.pendo.io.i0.k;

/* loaded from: classes2.dex */
public class BitmapResource implements sdk.pendo.io.t.c<Bitmap>, sdk.pendo.io.t.b {
    private final Bitmap bitmap;
    private final sdk.pendo.io.u.b bitmapPool;

    public BitmapResource(Bitmap bitmap, sdk.pendo.io.u.b bVar) {
        this.bitmap = (Bitmap) j.a(bitmap, "Bitmap must not be null");
        this.bitmapPool = (sdk.pendo.io.u.b) j.a(bVar, "BitmapPool must not be null");
    }

    public static BitmapResource obtain(Bitmap bitmap, sdk.pendo.io.u.b bVar) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bVar);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // sdk.pendo.io.t.c
    public Bitmap get() {
        return this.bitmap;
    }

    @Override // sdk.pendo.io.t.c
    public Class<Bitmap> getResourceClass() {
        return Bitmap.class;
    }

    @Override // sdk.pendo.io.t.c
    public int getSize() {
        return k.a(this.bitmap);
    }

    @Override // sdk.pendo.io.t.b
    public void initialize() {
        this.bitmap.prepareToDraw();
    }

    @Override // sdk.pendo.io.t.c
    public void recycle() {
        this.bitmapPool.put(this.bitmap);
    }
}
