package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.resource.bitmap.b;
import java.io.IOException;
import java.io.InputStream;
import sdk.pendo.io.i0.h;
import sdk.pendo.io.q.i;

/* loaded from: classes2.dex */
public class StreamBitmapDecoder implements i<InputStream, Bitmap> {
    private final sdk.pendo.io.u.a byteArrayPool;
    private final b downsampler;

    static class a implements b.InterfaceC0066b {

        /* renamed from: a, reason: collision with root package name */
        private final sdk.pendo.io.y.a f695a;
        private final sdk.pendo.io.i0.d b;

        a(sdk.pendo.io.y.a aVar, sdk.pendo.io.i0.d dVar) {
            this.f695a = aVar;
            this.b = dVar;
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.b.InterfaceC0066b
        public void a(sdk.pendo.io.u.b bVar, Bitmap bitmap) {
            IOException a2 = this.b.a();
            if (a2 != null) {
                if (bitmap == null) {
                    throw a2;
                }
                bVar.put(bitmap);
                throw a2;
            }
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.b.InterfaceC0066b
        public void a() {
            this.f695a.a();
        }
    }

    public StreamBitmapDecoder(b bVar, sdk.pendo.io.u.a aVar) {
        this.downsampler = bVar;
        this.byteArrayPool = aVar;
    }

    @Override // sdk.pendo.io.q.i
    public sdk.pendo.io.t.c<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) {
        boolean z;
        sdk.pendo.io.y.a aVar;
        if (inputStream instanceof sdk.pendo.io.y.a) {
            aVar = (sdk.pendo.io.y.a) inputStream;
            z = false;
        } else {
            z = true;
            aVar = new sdk.pendo.io.y.a(inputStream, this.byteArrayPool);
        }
        sdk.pendo.io.i0.d a2 = sdk.pendo.io.i0.d.a(aVar);
        try {
            return this.downsampler.a(new h(a2), i, i2, options, new a(aVar, a2));
        } finally {
            a2.b();
            if (z) {
                aVar.b();
            }
        }
    }

    @Override // sdk.pendo.io.q.i
    public boolean handles(InputStream inputStream, Options options) {
        return this.downsampler.a(inputStream);
    }
}
