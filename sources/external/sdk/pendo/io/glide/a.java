package external.sdk.pendo.io.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import external.sdk.pendo.io.glide.GlideBuilder;
import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import external.sdk.pendo.io.glide.load.ResourceEncoder;
import external.sdk.pendo.io.glide.load.data.InputStreamRewinder;
import external.sdk.pendo.io.glide.load.data.ParcelFileDescriptorRewinder;
import external.sdk.pendo.io.glide.load.data.b;
import external.sdk.pendo.io.glide.load.engine.Engine;
import external.sdk.pendo.io.glide.load.model.AssetUriLoader;
import external.sdk.pendo.io.glide.load.model.ByteArrayLoader;
import external.sdk.pendo.io.glide.load.model.ByteBufferEncoder;
import external.sdk.pendo.io.glide.load.model.ByteBufferFileLoader;
import external.sdk.pendo.io.glide.load.model.DataUrlLoader;
import external.sdk.pendo.io.glide.load.model.FileLoader;
import external.sdk.pendo.io.glide.load.model.GlideUrl;
import external.sdk.pendo.io.glide.load.model.MediaStoreFileLoader;
import external.sdk.pendo.io.glide.load.model.ResourceLoader;
import external.sdk.pendo.io.glide.load.model.StreamEncoder;
import external.sdk.pendo.io.glide.load.model.StringLoader;
import external.sdk.pendo.io.glide.load.model.UnitModelLoader;
import external.sdk.pendo.io.glide.load.model.UriLoader;
import external.sdk.pendo.io.glide.load.model.UrlUriLoader;
import external.sdk.pendo.io.glide.load.model.stream.HttpGlideUrlLoader;
import external.sdk.pendo.io.glide.load.model.stream.MediaStoreImageThumbLoader;
import external.sdk.pendo.io.glide.load.model.stream.MediaStoreVideoThumbLoader;
import external.sdk.pendo.io.glide.load.model.stream.QMediaStoreUriLoader;
import external.sdk.pendo.io.glide.load.model.stream.UrlLoader;
import external.sdk.pendo.io.glide.load.resource.bitmap.BitmapDrawableDecoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.BitmapDrawableEncoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.BitmapEncoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser;
import external.sdk.pendo.io.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import external.sdk.pendo.io.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.ResourceBitmapDecoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.StreamBitmapDecoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.UnitBitmapDecoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.VideoDecoder;
import external.sdk.pendo.io.glide.load.resource.bytes.ByteBufferRewinder;
import external.sdk.pendo.io.glide.load.resource.drawable.ResourceDrawableDecoder;
import external.sdk.pendo.io.glide.load.resource.drawable.UnitDrawableDecoder;
import external.sdk.pendo.io.glide.load.resource.file.FileDecoder;
import external.sdk.pendo.io.glide.load.resource.gif.ByteBufferGifDecoder;
import external.sdk.pendo.io.glide.load.resource.gif.GifDrawable;
import external.sdk.pendo.io.glide.load.resource.gif.GifDrawableEncoder;
import external.sdk.pendo.io.glide.load.resource.gif.GifFrameResourceDecoder;
import external.sdk.pendo.io.glide.load.resource.gif.StreamGifDecoder;
import external.sdk.pendo.io.glide.load.resource.transcode.BitmapBytesTranscoder;
import external.sdk.pendo.io.glide.load.resource.transcode.BitmapDrawableTranscoder;
import external.sdk.pendo.io.glide.load.resource.transcode.DrawableBytesTranscoder;
import external.sdk.pendo.io.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import external.sdk.pendo.io.glide.module.GlideModule;
import external.sdk.pendo.io.glide.request.RequestOptions;
import external.sdk.pendo.io.glide.request.target.Target;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import sdk.pendo.io.c0.k;
import sdk.pendo.io.i0.j;
import sdk.pendo.io.q.i;

/* loaded from: classes2.dex */
public class a implements ComponentCallbacks2 {
    private static volatile a l;
    private static volatile boolean m;

    /* renamed from: a, reason: collision with root package name */
    private final Engine f624a;
    private final sdk.pendo.io.u.b b;
    private final external.sdk.pendo.io.glide.load.engine.cache.c c;
    private final b d;
    private final Registry e;
    private final sdk.pendo.io.u.a f;
    private final k g;
    private final external.sdk.pendo.io.glide.manager.a h;
    private final InterfaceC0052a j;
    private final List<RequestManager> i = new ArrayList();
    private sdk.pendo.io.o.a k = sdk.pendo.io.o.a.NORMAL;

    /* renamed from: external.sdk.pendo.io.glide.a$a, reason: collision with other inner class name */
    public interface InterfaceC0052a {
        RequestOptions build();
    }

    a(Context context, Engine engine, external.sdk.pendo.io.glide.load.engine.cache.c cVar, sdk.pendo.io.u.b bVar, sdk.pendo.io.u.a aVar, k kVar, external.sdk.pendo.io.glide.manager.a aVar2, int i, InterfaceC0052a interfaceC0052a, Map<Class<?>, d<?, ?>> map, List<sdk.pendo.io.e0.b<Object>> list, c cVar2) {
        i byteBufferBitmapDecoder;
        i streamBitmapDecoder;
        this.f624a = engine;
        this.b = bVar;
        this.f = aVar;
        this.c = cVar;
        this.g = kVar;
        this.h = aVar2;
        this.j = interfaceC0052a;
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.e = registry;
        registry.a((ImageHeaderParser) new DefaultImageHeaderParser());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 27) {
            registry.a((ImageHeaderParser) new ExifInterfaceImageHeaderParser());
        }
        List<ImageHeaderParser> a2 = registry.a();
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context, a2, bVar, aVar);
        i<ParcelFileDescriptor, Bitmap> parcel = VideoDecoder.parcel(bVar);
        external.sdk.pendo.io.glide.load.resource.bitmap.b bVar2 = new external.sdk.pendo.io.glide.load.resource.bitmap.b(registry.a(), resources.getDisplayMetrics(), bVar, aVar);
        if (!cVar2.a(GlideBuilder.b.class) || i2 < 28) {
            byteBufferBitmapDecoder = new ByteBufferBitmapDecoder(bVar2);
            streamBitmapDecoder = new StreamBitmapDecoder(bVar2, aVar);
        } else {
            streamBitmapDecoder = new InputStreamBitmapImageDecoderResourceDecoder();
            byteBufferBitmapDecoder = new ByteBufferBitmapImageDecoderResourceDecoder();
        }
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context);
        ResourceLoader.StreamFactory streamFactory = new ResourceLoader.StreamFactory(resources);
        ResourceLoader.UriFactory uriFactory = new ResourceLoader.UriFactory(resources);
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory = new ResourceLoader.FileDescriptorFactory(resources);
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory(resources);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(aVar);
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        registry.a(ByteBuffer.class, new ByteBufferEncoder()).a(InputStream.class, new StreamEncoder(aVar)).a(com.bumptech.glide.Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, byteBufferBitmapDecoder).a(com.bumptech.glide.Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, streamBitmapDecoder);
        if (ParcelFileDescriptorRewinder.isSupported()) {
            registry.a(com.bumptech.glide.Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, new ParcelFileDescriptorBitmapDecoder(bVar2));
        }
        registry.a(com.bumptech.glide.Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, parcel).a(com.bumptech.glide.Registry.BUCKET_BITMAP, AssetFileDescriptor.class, Bitmap.class, VideoDecoder.asset(bVar)).a(Bitmap.class, Bitmap.class, UnitModelLoader.Factory.getInstance()).a(com.bumptech.glide.Registry.BUCKET_BITMAP, Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).a(Bitmap.class, (ResourceEncoder) bitmapEncoder).a(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, byteBufferBitmapDecoder)).a(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, streamBitmapDecoder)).a(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, parcel)).a(BitmapDrawable.class, (ResourceEncoder) new BitmapDrawableEncoder(bVar, bitmapEncoder)).a("Gif", InputStream.class, GifDrawable.class, new StreamGifDecoder(a2, byteBufferGifDecoder, aVar)).a("Gif", ByteBuffer.class, GifDrawable.class, byteBufferGifDecoder).a(GifDrawable.class, (ResourceEncoder) new GifDrawableEncoder()).a(external.sdk.pendo.io.glide.gifdecoder.a.class, external.sdk.pendo.io.glide.gifdecoder.a.class, UnitModelLoader.Factory.getInstance()).a(com.bumptech.glide.Registry.BUCKET_BITMAP, external.sdk.pendo.io.glide.gifdecoder.a.class, Bitmap.class, new GifFrameResourceDecoder(bVar)).a(Uri.class, Drawable.class, resourceDrawableDecoder).a(Uri.class, Bitmap.class, new ResourceBitmapDecoder(resourceDrawableDecoder, bVar)).a((b.a<?>) new ByteBufferRewinder.Factory()).a(File.class, ByteBuffer.class, new ByteBufferFileLoader.Factory()).a(File.class, InputStream.class, new FileLoader.StreamFactory()).a(File.class, File.class, new FileDecoder()).a(File.class, ParcelFileDescriptor.class, new FileLoader.FileDescriptorFactory()).a(File.class, File.class, UnitModelLoader.Factory.getInstance()).a((b.a<?>) new InputStreamRewinder.Factory(aVar));
        if (ParcelFileDescriptorRewinder.isSupported()) {
            registry.a((b.a<?>) new ParcelFileDescriptorRewinder.Factory());
        }
        Class cls = Integer.TYPE;
        registry.a(cls, InputStream.class, streamFactory).a(cls, ParcelFileDescriptor.class, fileDescriptorFactory).a(Integer.class, InputStream.class, streamFactory).a(Integer.class, ParcelFileDescriptor.class, fileDescriptorFactory).a(Integer.class, Uri.class, uriFactory).a(cls, AssetFileDescriptor.class, assetFileDescriptorFactory).a(Integer.class, AssetFileDescriptor.class, assetFileDescriptorFactory).a(cls, Uri.class, uriFactory).a(String.class, InputStream.class, new DataUrlLoader.StreamFactory()).a(Uri.class, InputStream.class, new DataUrlLoader.StreamFactory()).a(String.class, InputStream.class, new StringLoader.StreamFactory()).a(String.class, ParcelFileDescriptor.class, new StringLoader.FileDescriptorFactory()).a(String.class, AssetFileDescriptor.class, new StringLoader.AssetFileDescriptorFactory()).a(Uri.class, InputStream.class, new AssetUriLoader.StreamFactory(context.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new AssetUriLoader.FileDescriptorFactory(context.getAssets())).a(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.Factory(context)).a(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.Factory(context));
        if (i2 >= 29) {
            registry.a(Uri.class, InputStream.class, new QMediaStoreUriLoader.InputStreamFactory(context));
            registry.a(Uri.class, ParcelFileDescriptor.class, new QMediaStoreUriLoader.FileDescriptorFactory(context));
        }
        registry.a(Uri.class, InputStream.class, new UriLoader.StreamFactory(contentResolver)).a(Uri.class, ParcelFileDescriptor.class, new UriLoader.FileDescriptorFactory(contentResolver)).a(Uri.class, AssetFileDescriptor.class, new UriLoader.AssetFileDescriptorFactory(contentResolver)).a(Uri.class, InputStream.class, new UrlUriLoader.StreamFactory()).a(URL.class, InputStream.class, new UrlLoader.StreamFactory()).a(Uri.class, File.class, new MediaStoreFileLoader.Factory(context)).a(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.Factory()).a(byte[].class, ByteBuffer.class, new ByteArrayLoader.ByteBufferFactory()).a(byte[].class, InputStream.class, new ByteArrayLoader.StreamFactory()).a(Uri.class, Uri.class, UnitModelLoader.Factory.getInstance()).a(Drawable.class, Drawable.class, UnitModelLoader.Factory.getInstance()).a(Drawable.class, Drawable.class, new UnitDrawableDecoder()).a(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(resources)).a(Bitmap.class, byte[].class, bitmapBytesTranscoder).a(Drawable.class, byte[].class, new DrawableBytesTranscoder(bVar, bitmapBytesTranscoder, gifDrawableBytesTranscoder)).a(GifDrawable.class, byte[].class, gifDrawableBytesTranscoder);
        i<ByteBuffer, Bitmap> byteBuffer = VideoDecoder.byteBuffer(bVar);
        registry.a(ByteBuffer.class, Bitmap.class, byteBuffer);
        registry.a(ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, byteBuffer));
        this.d = new b(context, aVar, registry, new sdk.pendo.io.f0.b(), interfaceC0052a, map, list, engine, cVar2, i);
    }

    private static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (m) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        m = true;
        b(context, generatedAppGlideModule);
        m = false;
    }

    private static void a(Exception exc) {
    }

    private static GeneratedAppGlideModule b(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("external.sdk.pendo.io.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e) {
            e = e;
            a(e);
            return null;
        } catch (InstantiationException e2) {
            e = e2;
            a(e);
            return null;
        } catch (NoSuchMethodException e3) {
            e = e3;
            a(e);
            return null;
        } catch (InvocationTargetException e4) {
            e = e4;
            a(e);
            return null;
        }
    }

    public sdk.pendo.io.u.b c() {
        return this.b;
    }

    external.sdk.pendo.io.glide.manager.a d() {
        return this.h;
    }

    public Context e() {
        return this.d.getBaseContext();
    }

    b f() {
        return this.d;
    }

    public Registry g() {
        return this.e;
    }

    public k h() {
        return this.g;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        a();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        a(i);
    }

    private static k c(Context context) {
        j.a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).h();
    }

    public static RequestManager d(Context context) {
        return c(context).b(context);
    }

    public void a() {
        sdk.pendo.io.i0.k.b();
        this.c.clearMemory();
        this.b.clearMemory();
        this.f.clearMemory();
    }

    public sdk.pendo.io.u.a b() {
        return this.f;
    }

    public static a a(Context context) {
        if (l == null) {
            GeneratedAppGlideModule b = b(context.getApplicationContext());
            synchronized (a.class) {
                if (l == null) {
                    a(context, b);
                }
            }
        }
        return l;
    }

    private static void b(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        a(context, new GlideBuilder(), generatedAppGlideModule);
    }

    private static void a(Context context, GlideBuilder glideBuilder, GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<GlideModule> emptyList = Collections.emptyList();
        if (generatedAppGlideModule != null && !generatedAppGlideModule.a().isEmpty()) {
            Set<Class<?>> a2 = generatedAppGlideModule.a();
            Iterator it = emptyList.iterator();
            while (it.hasNext()) {
                GlideModule glideModule = (GlideModule) it.next();
                if (a2.contains(glideModule.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + glideModule);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator it2 = emptyList.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + ((GlideModule) it2.next()).getClass());
            }
        }
        glideBuilder.a(generatedAppGlideModule != null ? generatedAppGlideModule.b() : null);
        Iterator it3 = emptyList.iterator();
        while (it3.hasNext()) {
            ((GlideModule) it3.next()).applyOptions(applicationContext, glideBuilder);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.applyOptions(applicationContext, glideBuilder);
        }
        a a3 = glideBuilder.a(applicationContext);
        for (GlideModule glideModule2 : emptyList) {
            try {
                glideModule2.registerComponents(applicationContext, a3, a3.e);
            } catch (AbstractMethodError e) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + glideModule2.getClass().getName(), e);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.registerComponents(applicationContext, a3, a3.e);
        }
        applicationContext.registerComponentCallbacks(a3);
        l = a3;
    }

    void b(RequestManager requestManager) {
        synchronized (this.i) {
            if (!this.i.contains(requestManager)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            this.i.remove(requestManager);
        }
    }

    void a(RequestManager requestManager) {
        synchronized (this.i) {
            if (this.i.contains(requestManager)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            this.i.add(requestManager);
        }
    }

    boolean a(Target<?> target) {
        synchronized (this.i) {
            Iterator<RequestManager> it = this.i.iterator();
            while (it.hasNext()) {
                if (it.next().untrack(target)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void a(int i) {
        sdk.pendo.io.i0.k.b();
        synchronized (this.i) {
            Iterator<RequestManager> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().onTrimMemory(i);
            }
        }
        this.c.trimMemory(i);
        this.b.trimMemory(i);
        this.f.trimMemory(i);
    }

    public static RequestManager a(View view) {
        return c(view.getContext()).a(view);
    }
}
