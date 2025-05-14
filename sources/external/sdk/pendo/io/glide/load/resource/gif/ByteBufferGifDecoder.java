package external.sdk.pendo.io.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import external.sdk.pendo.io.glide.gifdecoder.StandardGifDecoder;
import external.sdk.pendo.io.glide.gifdecoder.a;
import external.sdk.pendo.io.glide.gifdecoder.c;
import external.sdk.pendo.io.glide.gifdecoder.d;
import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.resource.UnitTransformation;
import io.sentry.protocol.ViewHierarchyNode;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
import sdk.pendo.io.i0.f;
import sdk.pendo.io.i0.k;
import sdk.pendo.io.q.i;

/* loaded from: classes2.dex */
public class ByteBufferGifDecoder implements i<ByteBuffer, GifDrawable> {
    private static final a GIF_DECODER_FACTORY = new a();
    private static final b PARSER_POOL = new b();
    private static final String TAG = "BufferGifDecoder";
    private final Context context;
    private final a gifDecoderFactory;
    private final b parserPool;
    private final List<ImageHeaderParser> parsers;
    private final GifBitmapProvider provider;

    static class a {
        a() {
        }

        external.sdk.pendo.io.glide.gifdecoder.a a(a.InterfaceC0053a interfaceC0053a, c cVar, ByteBuffer byteBuffer, int i) {
            return new StandardGifDecoder(interfaceC0053a, cVar, byteBuffer, i);
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Queue<d> f702a = k.a(0);

        b() {
        }

        synchronized d a(ByteBuffer byteBuffer) {
            d poll;
            poll = this.f702a.poll();
            if (poll == null) {
                poll = new d();
            }
            return poll.a(byteBuffer);
        }

        synchronized void a(d dVar) {
            dVar.a();
            this.f702a.offer(dVar);
        }
    }

    public ByteBufferGifDecoder(Context context) {
        this(context, external.sdk.pendo.io.glide.a.a(context).g().a(), external.sdk.pendo.io.glide.a.a(context).c(), external.sdk.pendo.io.glide.a.a(context).b());
    }

    private GifDrawableResource decode(ByteBuffer byteBuffer, int i, int i2, d dVar, Options options) {
        long a2 = f.a();
        try {
            c c = dVar.c();
            if (c.b() > 0 && c.c() == 0) {
                Bitmap.Config config = options.get(sdk.pendo.io.a0.a.f835a) == sdk.pendo.io.q.b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                external.sdk.pendo.io.glide.gifdecoder.a a3 = this.gifDecoderFactory.a(this.provider, c, byteBuffer, getSampleSize(c, i, i2));
                a3.setDefaultBitmapConfig(config);
                a3.advance();
                Bitmap nextFrame = a3.getNextFrame();
                if (nextFrame == null) {
                    return null;
                }
                GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(this.context, a3, UnitTransformation.get(), i, i2, nextFrame));
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Decoded GIF from stream in " + f.a(a2));
                }
                return gifDrawableResource;
            }
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Decoded GIF from stream in " + f.a(a2));
            }
            return null;
        } finally {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Decoded GIF from stream in " + f.a(a2));
            }
        }
    }

    private static int getSampleSize(c cVar, int i, int i2) {
        int min = Math.min(cVar.a() / i2, cVar.d() / i);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable(TAG, 2) && max > 1) {
            Log.v(TAG, "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + ViewHierarchyNode.JsonKeys.X + i2 + "], actual dimens: [" + cVar.d() + ViewHierarchyNode.JsonKeys.X + cVar.a() + "]");
        }
        return max;
    }

    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, sdk.pendo.io.u.b bVar, sdk.pendo.io.u.a aVar) {
        this(context, list, bVar, aVar, PARSER_POOL, GIF_DECODER_FACTORY);
    }

    @Override // sdk.pendo.io.q.i
    public GifDrawableResource decode(ByteBuffer byteBuffer, int i, int i2, Options options) {
        d a2 = this.parserPool.a(byteBuffer);
        try {
            return decode(byteBuffer, i, i2, a2, options);
        } finally {
            this.parserPool.a(a2);
        }
    }

    @Override // sdk.pendo.io.q.i
    public boolean handles(ByteBuffer byteBuffer, Options options) {
        return !((Boolean) options.get(sdk.pendo.io.a0.a.b)).booleanValue() && external.sdk.pendo.io.glide.load.a.a(this.parsers, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, sdk.pendo.io.u.b bVar, sdk.pendo.io.u.a aVar, b bVar2, a aVar2) {
        this.context = context.getApplicationContext();
        this.parsers = list;
        this.gifDecoderFactory = aVar2;
        this.provider = new GifBitmapProvider(bVar, aVar);
        this.parserPool = bVar2;
    }
}
