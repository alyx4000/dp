package external.sdk.pendo.io.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import external.sdk.pendo.io.glide.GlideBuilder;
import external.sdk.pendo.io.glide.load.engine.Engine;
import external.sdk.pendo.io.glide.load.engine.n;
import external.sdk.pendo.io.glide.request.target.Target;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import sdk.pendo.io.f0.c;
import sdk.pendo.io.i0.f;
import sdk.pendo.io.i0.k;

/* loaded from: classes2.dex */
public final class SingleRequest<R> implements sdk.pendo.io.e0.a, c, sdk.pendo.io.e0.c {
    private static final String GLIDE_TAG = "Glide";
    private final sdk.pendo.io.g0.a<? super R> animationFactory;
    private final Executor callbackExecutor;
    private final Context context;
    private volatile Engine engine;
    private Drawable errorDrawable;
    private Drawable fallbackDrawable;
    private final external.sdk.pendo.io.glide.b glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private Engine.d loadStatus;
    private final Object model;
    private final int overrideHeight;
    private final int overrideWidth;
    private Drawable placeholderDrawable;
    private final sdk.pendo.io.o.b priority;
    private final b requestCoordinator;
    private final List<sdk.pendo.io.e0.b<R>> requestListeners;
    private final Object requestLock;
    private final external.sdk.pendo.io.glide.request.a<?> requestOptions;
    private RuntimeException requestOrigin;
    private sdk.pendo.io.t.c<R> resource;
    private long startTime;
    private final sdk.pendo.io.j0.c stateVerifier;
    private a status;
    private final String tag;
    private final Target<R> target;
    private final sdk.pendo.io.e0.b<R> targetListener;
    private final Class<R> transcodeClass;
    private int width;
    private static final String TAG = "Request";
    private static final boolean IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);

    private enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private SingleRequest(Context context, external.sdk.pendo.io.glide.b bVar, Object obj, Object obj2, Class<R> cls, external.sdk.pendo.io.glide.request.a<?> aVar, int i, int i2, sdk.pendo.io.o.b bVar2, Target<R> target, sdk.pendo.io.e0.b<R> bVar3, List<sdk.pendo.io.e0.b<R>> list, b bVar4, Engine engine, sdk.pendo.io.g0.a<? super R> aVar2, Executor executor) {
        this.tag = IS_VERBOSE_LOGGABLE ? String.valueOf(super.hashCode()) : null;
        this.stateVerifier = sdk.pendo.io.j0.c.a();
        this.requestLock = obj;
        this.context = context;
        this.glideContext = bVar;
        this.model = obj2;
        this.transcodeClass = cls;
        this.requestOptions = aVar;
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.priority = bVar2;
        this.target = target;
        this.targetListener = bVar3;
        this.requestListeners = list;
        this.requestCoordinator = bVar4;
        this.engine = engine;
        this.animationFactory = aVar2;
        this.callbackExecutor = executor;
        this.status = a.PENDING;
        if (this.requestOrigin == null && bVar.e().a(GlideBuilder.LogRequestOrigins.class)) {
            this.requestOrigin = new RuntimeException("Glide request origin trace");
        }
    }

    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean canNotifyCleared() {
        b bVar = this.requestCoordinator;
        return bVar == null || bVar.canNotifyCleared(this);
    }

    private boolean canNotifyStatusChanged() {
        b bVar = this.requestCoordinator;
        return bVar == null || bVar.canNotifyStatusChanged(this);
    }

    private boolean canSetResource() {
        b bVar = this.requestCoordinator;
        return bVar == null || bVar.canSetImage(this);
    }

    private void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.b();
        this.target.removeCallback(this);
        Engine.d dVar = this.loadStatus;
        if (dVar != null) {
            dVar.a();
            this.loadStatus = null;
        }
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            Drawable errorPlaceholder = this.requestOptions.getErrorPlaceholder();
            this.errorDrawable = errorPlaceholder;
            if (errorPlaceholder == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            Drawable fallbackDrawable = this.requestOptions.getFallbackDrawable();
            this.fallbackDrawable = fallbackDrawable;
            if (fallbackDrawable == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            Drawable placeholderDrawable = this.requestOptions.getPlaceholderDrawable();
            this.placeholderDrawable = placeholderDrawable;
            if (placeholderDrawable == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    private boolean isFirstReadyResource() {
        b bVar = this.requestCoordinator;
        return bVar == null || !bVar.getRoot().isAnyResourceSet();
    }

    private Drawable loadDrawable(int i) {
        return sdk.pendo.io.z.a.a(this.glideContext, i, this.requestOptions.getTheme() != null ? this.requestOptions.getTheme() : this.context.getTheme());
    }

    private void logV(String str) {
        Log.v(TAG, str + " this: " + this.tag);
    }

    private static int maybeApplySizeMultiplier(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * i);
    }

    private void notifyLoadFailed() {
        b bVar = this.requestCoordinator;
        if (bVar != null) {
            bVar.onRequestFailed(this);
        }
    }

    private void notifyLoadSuccess() {
        b bVar = this.requestCoordinator;
        if (bVar != null) {
            bVar.onRequestSuccess(this);
        }
    }

    public static <R> SingleRequest<R> obtain(Context context, external.sdk.pendo.io.glide.b bVar, Object obj, Object obj2, Class<R> cls, external.sdk.pendo.io.glide.request.a<?> aVar, int i, int i2, sdk.pendo.io.o.b bVar2, Target<R> target, sdk.pendo.io.e0.b<R> bVar3, List<sdk.pendo.io.e0.b<R>> list, b bVar4, Engine engine, sdk.pendo.io.g0.a<? super R> aVar2, Executor executor) {
        return new SingleRequest<>(context, bVar, obj, obj2, cls, aVar, i, i2, bVar2, target, bVar3, list, bVar4, engine, aVar2, executor);
    }

    private void onResourceReady(sdk.pendo.io.t.c<R> cVar, R r, sdk.pendo.io.q.a aVar, boolean z) {
        boolean z2;
        boolean isFirstReadyResource = isFirstReadyResource();
        this.status = a.COMPLETE;
        this.resource = cVar;
        if (this.glideContext.f() <= 3) {
            Log.d(GLIDE_TAG, "Finished loading " + r.getClass().getSimpleName() + " from " + aVar + " for " + this.model + " with size [" + this.width + ViewHierarchyNode.JsonKeys.X + this.height + "] in " + f.a(this.startTime) + " ms");
        }
        boolean z3 = true;
        this.isCallingCallbacks = true;
        try {
            List<sdk.pendo.io.e0.b<R>> list = this.requestListeners;
            if (list != null) {
                Iterator<sdk.pendo.io.e0.b<R>> it = list.iterator();
                z2 = false;
                while (it.hasNext()) {
                    z2 |= it.next().onResourceReady(r, this.model, this.target, aVar, isFirstReadyResource);
                }
            } else {
                z2 = false;
            }
            sdk.pendo.io.e0.b<R> bVar = this.targetListener;
            if (bVar == null || !bVar.onResourceReady(r, this.model, this.target, aVar, isFirstReadyResource)) {
                z3 = false;
            }
            if (!(z3 | z2)) {
                this.target.onResourceReady(r, this.animationFactory.build(aVar, isFirstReadyResource));
            }
            this.isCallingCallbacks = false;
            notifyLoadSuccess();
        } catch (Throwable th) {
            this.isCallingCallbacks = false;
            throw th;
        }
    }

    private void setErrorPlaceholder() {
        if (canNotifyStatusChanged()) {
            Drawable fallbackDrawable = this.model == null ? getFallbackDrawable() : null;
            if (fallbackDrawable == null) {
                fallbackDrawable = getErrorDrawable();
            }
            if (fallbackDrawable == null) {
                fallbackDrawable = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(fallbackDrawable);
        }
    }

    @Override // sdk.pendo.io.e0.a
    public void begin() {
        synchronized (this.requestLock) {
            assertNotCallingCallbacks();
            this.stateVerifier.b();
            this.startTime = f.a();
            if (this.model == null) {
                if (k.b(this.overrideWidth, this.overrideHeight)) {
                    this.width = this.overrideWidth;
                    this.height = this.overrideHeight;
                }
                onLoadFailed(new n("Received null model"), getFallbackDrawable() == null ? 5 : 3);
                return;
            }
            a aVar = this.status;
            a aVar2 = a.RUNNING;
            if (aVar == aVar2) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (aVar == a.COMPLETE) {
                onResourceReady(this.resource, sdk.pendo.io.q.a.MEMORY_CACHE, false);
                return;
            }
            a aVar3 = a.WAITING_FOR_SIZE;
            this.status = aVar3;
            if (k.b(this.overrideWidth, this.overrideHeight)) {
                onSizeReady(this.overrideWidth, this.overrideHeight);
            } else {
                this.target.getSize(this);
            }
            a aVar4 = this.status;
            if ((aVar4 == aVar2 || aVar4 == aVar3) && canNotifyStatusChanged()) {
                this.target.onLoadStarted(getPlaceholderDrawable());
            }
            if (IS_VERBOSE_LOGGABLE) {
                logV("finished run method in " + f.a(this.startTime));
            }
        }
    }

    @Override // sdk.pendo.io.e0.a
    public void clear() {
        synchronized (this.requestLock) {
            assertNotCallingCallbacks();
            this.stateVerifier.b();
            a aVar = this.status;
            a aVar2 = a.CLEARED;
            if (aVar == aVar2) {
                return;
            }
            cancel();
            sdk.pendo.io.t.c<R> cVar = this.resource;
            if (cVar != null) {
                this.resource = null;
            } else {
                cVar = null;
            }
            if (canNotifyCleared()) {
                this.target.onLoadCleared(getPlaceholderDrawable());
            }
            this.status = aVar2;
            if (cVar != null) {
                this.engine.release(cVar);
            }
        }
    }

    @Override // sdk.pendo.io.e0.c
    public Object getLock() {
        this.stateVerifier.b();
        return this.requestLock;
    }

    @Override // sdk.pendo.io.e0.a
    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == a.COMPLETE;
        }
        return z;
    }

    @Override // sdk.pendo.io.e0.a
    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == a.CLEARED;
        }
        return z;
    }

    @Override // sdk.pendo.io.e0.a
    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == a.COMPLETE;
        }
        return z;
    }

    @Override // sdk.pendo.io.e0.a
    public boolean isEquivalentTo(sdk.pendo.io.e0.a aVar) {
        int i;
        int i2;
        Object obj;
        Class<R> cls;
        external.sdk.pendo.io.glide.request.a<?> aVar2;
        sdk.pendo.io.o.b bVar;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class<R> cls2;
        external.sdk.pendo.io.glide.request.a<?> aVar3;
        sdk.pendo.io.o.b bVar2;
        int size2;
        if (!(aVar instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.requestLock) {
            i = this.overrideWidth;
            i2 = this.overrideHeight;
            obj = this.model;
            cls = this.transcodeClass;
            aVar2 = this.requestOptions;
            bVar = this.priority;
            List<sdk.pendo.io.e0.b<R>> list = this.requestListeners;
            size = list != null ? list.size() : 0;
        }
        SingleRequest singleRequest = (SingleRequest) aVar;
        synchronized (singleRequest.requestLock) {
            i3 = singleRequest.overrideWidth;
            i4 = singleRequest.overrideHeight;
            obj2 = singleRequest.model;
            cls2 = singleRequest.transcodeClass;
            aVar3 = singleRequest.requestOptions;
            bVar2 = singleRequest.priority;
            List<sdk.pendo.io.e0.b<R>> list2 = singleRequest.requestListeners;
            size2 = list2 != null ? list2.size() : 0;
        }
        return i == i3 && i2 == i4 && k.a(obj, obj2) && cls.equals(cls2) && aVar2.equals(aVar3) && bVar == bVar2 && size == size2;
    }

    @Override // sdk.pendo.io.e0.a
    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            a aVar = this.status;
            z = aVar == a.RUNNING || aVar == a.WAITING_FOR_SIZE;
        }
        return z;
    }

    @Override // sdk.pendo.io.e0.c
    public void onLoadFailed(n nVar) {
        onLoadFailed(nVar, 5);
    }

    @Override // sdk.pendo.io.f0.c
    public void onSizeReady(int i, int i2) {
        Object obj;
        this.stateVerifier.b();
        Object obj2 = this.requestLock;
        synchronized (obj2) {
            try {
                try {
                    boolean z = IS_VERBOSE_LOGGABLE;
                    if (z) {
                        logV("Got onSizeReady in " + f.a(this.startTime));
                    }
                    if (this.status == a.WAITING_FOR_SIZE) {
                        a aVar = a.RUNNING;
                        this.status = aVar;
                        float sizeMultiplier = this.requestOptions.getSizeMultiplier();
                        this.width = maybeApplySizeMultiplier(i, sizeMultiplier);
                        this.height = maybeApplySizeMultiplier(i2, sizeMultiplier);
                        if (z) {
                            logV("finished setup for calling load in " + f.a(this.startTime));
                        }
                        obj = obj2;
                        try {
                            this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this, this.callbackExecutor);
                            if (this.status != aVar) {
                                this.loadStatus = null;
                            }
                            if (z) {
                                logV("finished onSizeReady in " + f.a(this.startTime));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obj = obj2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    @Override // sdk.pendo.io.e0.a
    public void pause() {
        synchronized (this.requestLock) {
            if (isRunning()) {
                clear();
            }
        }
    }

    private void onLoadFailed(n nVar, int i) {
        boolean z;
        this.stateVerifier.b();
        synchronized (this.requestLock) {
            nVar.a(this.requestOrigin);
            int f = this.glideContext.f();
            if (f <= i) {
                Log.w(GLIDE_TAG, "Load failed for " + this.model + " with size [" + this.width + ViewHierarchyNode.JsonKeys.X + this.height + "]", nVar);
                if (f <= 4) {
                    nVar.a(GLIDE_TAG);
                }
            }
            this.loadStatus = null;
            this.status = a.FAILED;
            boolean z2 = true;
            this.isCallingCallbacks = true;
            try {
                List<sdk.pendo.io.e0.b<R>> list = this.requestListeners;
                if (list != null) {
                    Iterator<sdk.pendo.io.e0.b<R>> it = list.iterator();
                    z = false;
                    while (it.hasNext()) {
                        z |= it.next().onLoadFailed(nVar, this.model, this.target, isFirstReadyResource());
                    }
                } else {
                    z = false;
                }
                sdk.pendo.io.e0.b<R> bVar = this.targetListener;
                if (bVar == null || !bVar.onLoadFailed(nVar, this.model, this.target, isFirstReadyResource())) {
                    z2 = false;
                }
                if (!(z | z2)) {
                    setErrorPlaceholder();
                }
                this.isCallingCallbacks = false;
                notifyLoadFailed();
            } catch (Throwable th) {
                this.isCallingCallbacks = false;
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // sdk.pendo.io.e0.c
    public void onResourceReady(sdk.pendo.io.t.c<?> cVar, sdk.pendo.io.q.a aVar, boolean z) {
        this.stateVerifier.b();
        sdk.pendo.io.t.c<?> cVar2 = null;
        try {
            synchronized (this.requestLock) {
                try {
                    this.loadStatus = null;
                    if (cVar == null) {
                        onLoadFailed(new n("Expected to receive a Resource<R> with an object of " + this.transcodeClass + " inside, but instead got null."));
                        return;
                    }
                    Object obj = cVar.get();
                    try {
                        if (obj != null && this.transcodeClass.isAssignableFrom(obj.getClass())) {
                            if (canSetResource()) {
                                onResourceReady(cVar, obj, aVar, z);
                                return;
                            }
                            this.resource = null;
                            this.status = a.COMPLETE;
                            this.engine.release(cVar);
                        }
                        this.resource = null;
                        onLoadFailed(new n("Expected to receive an object of " + this.transcodeClass + " but instead got " + (obj != null ? obj.getClass() : "") + "{" + obj + "} inside Resource{" + cVar + "}." + (obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.")));
                        this.engine.release(cVar);
                    } catch (Throwable th) {
                        cVar2 = cVar;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (cVar2 != null) {
                this.engine.release(cVar2);
            }
            throw th3;
        }
    }
}
