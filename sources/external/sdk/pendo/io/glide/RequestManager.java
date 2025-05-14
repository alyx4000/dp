package external.sdk.pendo.io.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import external.sdk.pendo.io.glide.load.resource.gif.GifDrawable;
import external.sdk.pendo.io.glide.manager.ConnectivityMonitor;
import external.sdk.pendo.io.glide.manager.TargetTracker;
import external.sdk.pendo.io.glide.request.RequestOptions;
import external.sdk.pendo.io.glide.request.target.CustomViewTarget;
import external.sdk.pendo.io.glide.request.target.Target;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import sdk.pendo.io.c0.h;
import sdk.pendo.io.c0.i;
import sdk.pendo.io.c0.l;
import sdk.pendo.io.c0.m;
import sdk.pendo.io.i0.k;

/* loaded from: classes2.dex */
public class RequestManager implements ComponentCallbacks2, i {
    private static final RequestOptions DECODE_TYPE_BITMAP = RequestOptions.decodeTypeOf(Bitmap.class).lock();
    private static final RequestOptions DECODE_TYPE_GIF = RequestOptions.decodeTypeOf(GifDrawable.class).lock();
    private static final RequestOptions DOWNLOAD_ONLY_OPTIONS = RequestOptions.diskCacheStrategyOf(sdk.pendo.io.t.a.c).priority(sdk.pendo.io.o.b.LOW).skipMemoryCache(true);
    private final Runnable addSelfToLifecycle;
    private final ConnectivityMonitor connectivityMonitor;
    protected final Context context;
    private final CopyOnWriteArrayList<sdk.pendo.io.e0.b<Object>> defaultRequestListeners;
    protected final external.sdk.pendo.io.glide.a glide;
    final h lifecycle;
    private boolean pauseAllRequestsOnTrimMemoryModerate;
    private RequestOptions requestOptions;
    private final m requestTracker;
    private final TargetTracker targetTracker;
    private final l treeNode;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RequestManager requestManager = RequestManager.this;
            requestManager.lifecycle.a(requestManager);
        }
    }

    private static class b extends CustomViewTarget<View, Object> {
        b(View view) {
            super(view);
        }

        @Override // external.sdk.pendo.io.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
        }

        @Override // external.sdk.pendo.io.glide.request.target.CustomViewTarget
        protected void onResourceCleared(Drawable drawable) {
        }

        @Override // external.sdk.pendo.io.glide.request.target.Target
        public void onResourceReady(Object obj, external.sdk.pendo.io.glide.request.transition.a<? super Object> aVar) {
        }
    }

    private class c implements ConnectivityMonitor.a {

        /* renamed from: a, reason: collision with root package name */
        private final m f623a;

        c(m mVar) {
            this.f623a = mVar;
        }

        @Override // external.sdk.pendo.io.glide.manager.ConnectivityMonitor.a
        public void a(boolean z) {
            if (z) {
                synchronized (RequestManager.this) {
                    this.f623a.e();
                }
            }
        }
    }

    public RequestManager(external.sdk.pendo.io.glide.a aVar, h hVar, l lVar, Context context) {
        this(aVar, hVar, lVar, new m(), aVar.d(), context);
    }

    private void untrackOrDelegate(Target<?> target) {
        boolean untrack = untrack(target);
        sdk.pendo.io.e0.a request = target.getRequest();
        if (untrack || this.glide.a(target) || request == null) {
            return;
        }
        target.setRequest(null);
        request.clear();
    }

    private synchronized void updateRequestOptions(RequestOptions requestOptions) {
        this.requestOptions = this.requestOptions.apply(requestOptions);
    }

    public RequestManager addDefaultRequestListener(sdk.pendo.io.e0.b<Object> bVar) {
        this.defaultRequestListeners.add(bVar);
        return this;
    }

    public synchronized RequestManager applyDefaultRequestOptions(RequestOptions requestOptions) {
        updateRequestOptions(requestOptions);
        return this;
    }

    public <ResourceType> RequestBuilder<ResourceType> as(Class<ResourceType> cls) {
        return new RequestBuilder<>(this.glide, this, cls, this.context);
    }

    public RequestBuilder<Bitmap> asBitmap() {
        return as(Bitmap.class).apply((external.sdk.pendo.io.glide.request.a<?>) DECODE_TYPE_BITMAP);
    }

    public RequestBuilder<Drawable> asDrawable() {
        return as(Drawable.class);
    }

    public RequestBuilder<File> asFile() {
        return as(File.class).apply((external.sdk.pendo.io.glide.request.a<?>) RequestOptions.skipMemoryCacheOf(true));
    }

    public RequestBuilder<GifDrawable> asGif() {
        return as(GifDrawable.class).apply((external.sdk.pendo.io.glide.request.a<?>) DECODE_TYPE_GIF);
    }

    public void clear(View view) {
        clear(new b(view));
    }

    public RequestBuilder<File> download(Object obj) {
        return downloadOnly().m1084load(obj);
    }

    public RequestBuilder<File> downloadOnly() {
        return as(File.class).apply((external.sdk.pendo.io.glide.request.a<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    List<sdk.pendo.io.e0.b<Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    synchronized RequestOptions getDefaultRequestOptions() {
        return this.requestOptions;
    }

    <T> d<?, T> getDefaultTransitionOptions(Class<T> cls) {
        return this.glide.f().a(cls);
    }

    public synchronized boolean isPaused() {
        return this.requestTracker.b();
    }

    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m1088load(Bitmap bitmap) {
        return asDrawable().m1079load(bitmap);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // sdk.pendo.io.c0.i
    public synchronized void onDestroy() {
        this.targetTracker.onDestroy();
        Iterator<Target<?>> it = this.targetTracker.getAll().iterator();
        while (it.hasNext()) {
            clear(it.next());
        }
        this.targetTracker.clear();
        this.requestTracker.a();
        this.lifecycle.b(this);
        this.lifecycle.b(this.connectivityMonitor);
        k.b(this.addSelfToLifecycle);
        this.glide.b(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // sdk.pendo.io.c0.i
    public synchronized void onStart() {
        resumeRequests();
        this.targetTracker.onStart();
    }

    @Override // sdk.pendo.io.c0.i
    public synchronized void onStop() {
        pauseRequests();
        this.targetTracker.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 60 && this.pauseAllRequestsOnTrimMemoryModerate) {
            pauseAllRequestsRecursive();
        }
    }

    public synchronized void pauseAllRequests() {
        this.requestTracker.c();
    }

    public synchronized void pauseAllRequestsRecursive() {
        pauseAllRequests();
        Iterator<RequestManager> it = this.treeNode.a().iterator();
        while (it.hasNext()) {
            it.next().pauseAllRequests();
        }
    }

    public synchronized void pauseRequests() {
        this.requestTracker.d();
    }

    public synchronized void pauseRequestsRecursive() {
        pauseRequests();
        Iterator<RequestManager> it = this.treeNode.a().iterator();
        while (it.hasNext()) {
            it.next().pauseRequests();
        }
    }

    public synchronized void resumeRequests() {
        this.requestTracker.f();
    }

    public synchronized void resumeRequestsRecursive() {
        k.b();
        resumeRequests();
        Iterator<RequestManager> it = this.treeNode.a().iterator();
        while (it.hasNext()) {
            it.next().resumeRequests();
        }
    }

    public synchronized RequestManager setDefaultRequestOptions(RequestOptions requestOptions) {
        setRequestOptions(requestOptions);
        return this;
    }

    public void setPauseAllRequestsOnTrimMemoryModerate(boolean z) {
        this.pauseAllRequestsOnTrimMemoryModerate = z;
    }

    protected synchronized void setRequestOptions(RequestOptions requestOptions) {
        this.requestOptions = requestOptions.mo1078clone().autoClone();
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + "}";
    }

    synchronized void track(Target<?> target, sdk.pendo.io.e0.a aVar) {
        this.targetTracker.track(target);
        this.requestTracker.b(aVar);
    }

    synchronized boolean untrack(Target<?> target) {
        sdk.pendo.io.e0.a request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.requestTracker.a(request)) {
            return false;
        }
        this.targetTracker.untrack(target);
        target.setRequest(null);
        return true;
    }

    RequestManager(external.sdk.pendo.io.glide.a aVar, h hVar, l lVar, m mVar, external.sdk.pendo.io.glide.manager.a aVar2, Context context) {
        this.targetTracker = new TargetTracker();
        a aVar3 = new a();
        this.addSelfToLifecycle = aVar3;
        this.glide = aVar;
        this.lifecycle = hVar;
        this.treeNode = lVar;
        this.requestTracker = mVar;
        this.context = context;
        ConnectivityMonitor build = aVar2.build(context.getApplicationContext(), new c(mVar));
        this.connectivityMonitor = build;
        if (k.d()) {
            k.a(aVar3);
        } else {
            hVar.a(this);
        }
        hVar.a(build);
        this.defaultRequestListeners = new CopyOnWriteArrayList<>(aVar.f().b());
        setRequestOptions(aVar.f().c());
        aVar.a(this);
    }

    public void clear(Target<?> target) {
        if (target == null) {
            return;
        }
        untrackOrDelegate(target);
    }

    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m1089load(Drawable drawable) {
        return asDrawable().m1080load(drawable);
    }

    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m1090load(Uri uri) {
        return asDrawable().m1081load(uri);
    }

    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m1091load(File file) {
        return asDrawable().m1082load(file);
    }

    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m1092load(Integer num) {
        return asDrawable().m1083load(num);
    }

    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m1093load(Object obj) {
        return asDrawable().m1084load(obj);
    }

    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m1094load(String str) {
        return asDrawable().m1085load(str);
    }

    @Deprecated
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m1095load(URL url) {
        return asDrawable().m1086load(url);
    }

    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m1096load(byte[] bArr) {
        return asDrawable().m1087load(bArr);
    }
}
