package external.sdk.pendo.io.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import io.sentry.protocol.ViewHierarchyNode;
import sdk.pendo.io.i0.k;

/* loaded from: classes2.dex */
class b implements e {

    /* renamed from: a, reason: collision with root package name */
    private final C0058b f653a = new C0058b();
    private final d<a, Bitmap> b = new d<>();

    static class a implements f {

        /* renamed from: a, reason: collision with root package name */
        private final C0058b f654a;
        private int b;
        private int c;
        private Bitmap.Config d;

        public a(C0058b c0058b) {
            this.f654a = c0058b;
        }

        public void a(int i, int i2, Bitmap.Config config) {
            this.b = i;
            this.c = i2;
            this.d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && this.c == aVar.c && this.d == aVar.d;
        }

        public int hashCode() {
            int i = ((this.b * 31) + this.c) * 31;
            Bitmap.Config config = this.d;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return b.a(this.b, this.c, this.d);
        }

        @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.f
        public void a() {
            this.f654a.a(this);
        }
    }

    /* renamed from: external.sdk.pendo.io.glide.load.engine.bitmap_recycle.b$b, reason: collision with other inner class name */
    static class C0058b extends c<a> {
        C0058b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        a a(int i, int i2, Bitmap.Config config) {
            a b = b();
            b.a(i, i2, config);
            return b;
        }
    }

    b() {
    }

    static String a(int i, int i2, Bitmap.Config config) {
        return "[" + i + ViewHierarchyNode.JsonKeys.X + i2 + "], " + config;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        return this.b.a((d<a, Bitmap>) this.f653a.a(i, i2, config));
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public int getSize(Bitmap bitmap) {
        return k.a(bitmap);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public String logBitmap(int i, int i2, Bitmap.Config config) {
        return a(i, i2, config);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public void put(Bitmap bitmap) {
        this.b.a(this.f653a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public Bitmap removeLast() {
        return this.b.a();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.b;
    }

    private static String a(Bitmap bitmap) {
        return a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public String logBitmap(Bitmap bitmap) {
        return a(bitmap);
    }
}
