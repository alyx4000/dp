package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import external.sdk.pendo.io.glide.load.Options;
import sdk.pendo.io.i0.k;
import sdk.pendo.io.q.i;

/* loaded from: classes2.dex */
public final class UnitBitmapDecoder implements i<Bitmap, Bitmap> {

    private static final class a implements sdk.pendo.io.t.c<Bitmap> {
        private final Bitmap f;

        a(Bitmap bitmap) {
            this.f = bitmap;
        }

        @Override // sdk.pendo.io.t.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.f;
        }

        @Override // sdk.pendo.io.t.c
        public Class<Bitmap> getResourceClass() {
            return Bitmap.class;
        }

        @Override // sdk.pendo.io.t.c
        public int getSize() {
            return k.a(this.f);
        }

        @Override // sdk.pendo.io.t.c
        public void recycle() {
        }
    }

    @Override // sdk.pendo.io.q.i
    public sdk.pendo.io.t.c<Bitmap> decode(Bitmap bitmap, int i, int i2, Options options) {
        return new a(bitmap);
    }

    @Override // sdk.pendo.io.q.i
    public boolean handles(Bitmap bitmap, Options options) {
        return true;
    }
}
