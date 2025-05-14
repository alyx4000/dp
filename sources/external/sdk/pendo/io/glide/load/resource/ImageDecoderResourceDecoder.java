package external.sdk.pendo.io.glide.load.resource;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.resource.bitmap.d;
import io.sentry.protocol.ViewHierarchyNode;
import sdk.pendo.io.q.b;
import sdk.pendo.io.q.g;
import sdk.pendo.io.q.h;
import sdk.pendo.io.q.i;
import sdk.pendo.io.t.c;

/* loaded from: classes2.dex */
public abstract class ImageDecoderResourceDecoder<T> implements i<ImageDecoder.Source, T> {
    private static final String TAG = "ImageDecoder";
    final d hardwareConfigState = d.b();

    class a implements ImageDecoder.OnHeaderDecodedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f690a;
        final /* synthetic */ int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ b d;
        final /* synthetic */ external.sdk.pendo.io.glide.load.resource.bitmap.a e;
        final /* synthetic */ h f;

        /* renamed from: external.sdk.pendo.io.glide.load.resource.ImageDecoderResourceDecoder$a$a, reason: collision with other inner class name */
        class C0064a implements ImageDecoder.OnPartialImageListener {
            C0064a() {
            }

            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        a(int i, int i2, boolean z, b bVar, external.sdk.pendo.io.glide.load.resource.bitmap.a aVar, h hVar) {
            this.f690a = i;
            this.b = i2;
            this.c = z;
            this.d = bVar;
            this.e = aVar;
            this.f = hVar;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            ColorSpace.Named named;
            boolean z = false;
            if (ImageDecoderResourceDecoder.this.hardwareConfigState.a(this.f690a, this.b, this.c, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.d == b.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C0064a());
            Size size = imageInfo.getSize();
            int i = this.f690a;
            if (i == Integer.MIN_VALUE) {
                i = size.getWidth();
            }
            int i2 = this.b;
            if (i2 == Integer.MIN_VALUE) {
                i2 = size.getHeight();
            }
            float b = this.e.b(size.getWidth(), size.getHeight(), i, i2);
            int round = Math.round(size.getWidth() * b);
            int round2 = Math.round(size.getHeight() * b);
            if (Log.isLoggable(ImageDecoderResourceDecoder.TAG, 2)) {
                Log.v(ImageDecoderResourceDecoder.TAG, "Resizing from [" + size.getWidth() + ViewHierarchyNode.JsonKeys.X + size.getHeight() + "] to [" + round + ViewHierarchyNode.JsonKeys.X + round2 + "] scaleFactor: " + b);
            }
            imageDecoder.setTargetSize(round, round2);
            if (Build.VERSION.SDK_INT >= 28) {
                if (this.f == h.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                    z = true;
                }
                if (z) {
                    named = ColorSpace.Named.DISPLAY_P3;
                    imageDecoder.setTargetColorSpace(ColorSpace.get(named));
                }
            }
            named = ColorSpace.Named.SRGB;
            imageDecoder.setTargetColorSpace(ColorSpace.get(named));
        }
    }

    protected abstract c<T> decode(ImageDecoder.Source source, int i, int i2, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener);

    @Override // sdk.pendo.io.q.i
    public final c<T> decode(ImageDecoder.Source source, int i, int i2, Options options) {
        b bVar = (b) options.get(external.sdk.pendo.io.glide.load.resource.bitmap.b.f);
        external.sdk.pendo.io.glide.load.resource.bitmap.a aVar = (external.sdk.pendo.io.glide.load.resource.bitmap.a) options.get(external.sdk.pendo.io.glide.load.resource.bitmap.a.h);
        g<Boolean> gVar = external.sdk.pendo.io.glide.load.resource.bitmap.b.j;
        return decode(source, i, i2, new a(i, i2, options.get(gVar) != null && ((Boolean) options.get(gVar)).booleanValue(), bVar, aVar, (h) options.get(external.sdk.pendo.io.glide.load.resource.bitmap.b.g)));
    }

    @Override // sdk.pendo.io.q.i
    public final boolean handles(ImageDecoder.Source source, Options options) {
        return true;
    }
}
