package external.sdk.pendo.io.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import external.sdk.pendo.io.glide.request.ErrorRequestCoordinator;
import external.sdk.pendo.io.glide.request.FutureTarget;
import external.sdk.pendo.io.glide.request.RequestFutureTarget;
import external.sdk.pendo.io.glide.request.RequestOptions;
import external.sdk.pendo.io.glide.request.SingleRequest;
import external.sdk.pendo.io.glide.request.ThumbnailRequestCoordinator;
import external.sdk.pendo.io.glide.request.target.PreloadTarget;
import external.sdk.pendo.io.glide.request.target.Target;
import external.sdk.pendo.io.glide.request.target.ViewTarget;
import external.sdk.pendo.io.glide.signature.AndroidResourceSignature;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import sdk.pendo.io.i0.e;
import sdk.pendo.io.i0.j;
import sdk.pendo.io.i0.k;

/* loaded from: classes2.dex */
public class RequestBuilder<TranscodeType> extends external.sdk.pendo.io.glide.request.a<RequestBuilder<TranscodeType>> {
    protected static final RequestOptions DOWNLOAD_ONLY_OPTIONS = new RequestOptions().diskCacheStrategy(sdk.pendo.io.t.a.c).priority(sdk.pendo.io.o.b.LOW).skipMemoryCache(true);
    private final Context context;
    private RequestBuilder<TranscodeType> errorBuilder;
    private final external.sdk.pendo.io.glide.a glide;
    private final b glideContext;
    private boolean isDefaultTransitionOptionsSet;
    private boolean isModelSet;
    private boolean isThumbnailBuilt;
    private Object model;
    private List<sdk.pendo.io.e0.b<TranscodeType>> requestListeners;
    private final RequestManager requestManager;
    private Float thumbSizeMultiplier;
    private RequestBuilder<TranscodeType> thumbnailBuilder;
    private final Class<TranscodeType> transcodeClass;
    private d<?, ? super TranscodeType> transitionOptions;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f622a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[sdk.pendo.io.o.b.values().length];
            b = iArr;
            try {
                iArr[sdk.pendo.io.o.b.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[sdk.pendo.io.o.b.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[sdk.pendo.io.o.b.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[sdk.pendo.io.o.b.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f622a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f622a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f622a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f622a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f622a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f622a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f622a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f622a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    protected RequestBuilder(external.sdk.pendo.io.glide.a aVar, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        this.isDefaultTransitionOptionsSet = true;
        this.glide = aVar;
        this.requestManager = requestManager;
        this.transcodeClass = cls;
        this.context = context;
        this.transitionOptions = requestManager.getDefaultTransitionOptions(cls);
        this.glideContext = aVar.f();
        initRequestListeners(requestManager.getDefaultRequestListeners());
        apply((external.sdk.pendo.io.glide.request.a<?>) requestManager.getDefaultRequestOptions());
    }

    private sdk.pendo.io.e0.a buildRequest(Target<TranscodeType> target, sdk.pendo.io.e0.b<TranscodeType> bVar, external.sdk.pendo.io.glide.request.a<?> aVar, Executor executor) {
        return buildRequestRecursive(new Object(), target, bVar, null, this.transitionOptions, aVar.getPriority(), aVar.getOverrideWidth(), aVar.getOverrideHeight(), aVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private sdk.pendo.io.e0.a buildRequestRecursive(Object obj, Target<TranscodeType> target, sdk.pendo.io.e0.b<TranscodeType> bVar, external.sdk.pendo.io.glide.request.b bVar2, d<?, ? super TranscodeType> dVar, sdk.pendo.io.o.b bVar3, int i, int i2, external.sdk.pendo.io.glide.request.a<?> aVar, Executor executor) {
        external.sdk.pendo.io.glide.request.b bVar4;
        external.sdk.pendo.io.glide.request.b bVar5;
        if (this.errorBuilder != null) {
            bVar5 = new ErrorRequestCoordinator(obj, bVar2);
            bVar4 = bVar5;
        } else {
            bVar4 = null;
            bVar5 = bVar2;
        }
        sdk.pendo.io.e0.a buildThumbnailRequestRecursive = buildThumbnailRequestRecursive(obj, target, bVar, bVar5, dVar, bVar3, i, i2, aVar, executor);
        if (bVar4 == null) {
            return buildThumbnailRequestRecursive;
        }
        int overrideWidth = this.errorBuilder.getOverrideWidth();
        int overrideHeight = this.errorBuilder.getOverrideHeight();
        if (k.b(i, i2) && !this.errorBuilder.isValidOverride()) {
            overrideWidth = aVar.getOverrideWidth();
            overrideHeight = aVar.getOverrideHeight();
        }
        RequestBuilder<TranscodeType> requestBuilder = this.errorBuilder;
        ErrorRequestCoordinator errorRequestCoordinator = bVar4;
        errorRequestCoordinator.setRequests(buildThumbnailRequestRecursive, requestBuilder.buildRequestRecursive(obj, target, bVar, errorRequestCoordinator, requestBuilder.transitionOptions, requestBuilder.getPriority(), overrideWidth, overrideHeight, this.errorBuilder, executor));
        return errorRequestCoordinator;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [external.sdk.pendo.io.glide.request.a] */
    private sdk.pendo.io.e0.a buildThumbnailRequestRecursive(Object obj, Target<TranscodeType> target, sdk.pendo.io.e0.b<TranscodeType> bVar, external.sdk.pendo.io.glide.request.b bVar2, d<?, ? super TranscodeType> dVar, sdk.pendo.io.o.b bVar3, int i, int i2, external.sdk.pendo.io.glide.request.a<?> aVar, Executor executor) {
        RequestBuilder<TranscodeType> requestBuilder = this.thumbnailBuilder;
        if (requestBuilder == null) {
            if (this.thumbSizeMultiplier == null) {
                return obtainRequest(obj, target, bVar, aVar, bVar2, dVar, bVar3, i, i2, executor);
            }
            ThumbnailRequestCoordinator thumbnailRequestCoordinator = new ThumbnailRequestCoordinator(obj, bVar2);
            thumbnailRequestCoordinator.setRequests(obtainRequest(obj, target, bVar, aVar, thumbnailRequestCoordinator, dVar, bVar3, i, i2, executor), obtainRequest(obj, target, bVar, aVar.mo1078clone().sizeMultiplier(this.thumbSizeMultiplier.floatValue()), thumbnailRequestCoordinator, dVar, getThumbnailPriority(bVar3), i, i2, executor));
            return thumbnailRequestCoordinator;
        }
        if (this.isThumbnailBuilt) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        d<?, ? super TranscodeType> dVar2 = requestBuilder.isDefaultTransitionOptionsSet ? dVar : requestBuilder.transitionOptions;
        sdk.pendo.io.o.b priority = requestBuilder.isPrioritySet() ? this.thumbnailBuilder.getPriority() : getThumbnailPriority(bVar3);
        int overrideWidth = this.thumbnailBuilder.getOverrideWidth();
        int overrideHeight = this.thumbnailBuilder.getOverrideHeight();
        if (k.b(i, i2) && !this.thumbnailBuilder.isValidOverride()) {
            overrideWidth = aVar.getOverrideWidth();
            overrideHeight = aVar.getOverrideHeight();
        }
        ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = new ThumbnailRequestCoordinator(obj, bVar2);
        sdk.pendo.io.e0.a obtainRequest = obtainRequest(obj, target, bVar, aVar, thumbnailRequestCoordinator2, dVar, bVar3, i, i2, executor);
        this.isThumbnailBuilt = true;
        RequestBuilder<TranscodeType> requestBuilder2 = this.thumbnailBuilder;
        sdk.pendo.io.e0.a buildRequestRecursive = requestBuilder2.buildRequestRecursive(obj, target, bVar, thumbnailRequestCoordinator2, dVar2, priority, overrideWidth, overrideHeight, requestBuilder2, executor);
        this.isThumbnailBuilt = false;
        thumbnailRequestCoordinator2.setRequests(obtainRequest, buildRequestRecursive);
        return thumbnailRequestCoordinator2;
    }

    private RequestBuilder<TranscodeType> cloneWithNullErrorAndThumbnail() {
        return mo1078clone().error((RequestBuilder) null).thumbnail((RequestBuilder) null);
    }

    private sdk.pendo.io.o.b getThumbnailPriority(sdk.pendo.io.o.b bVar) {
        int i = a.b[bVar.ordinal()];
        if (i == 1) {
            return sdk.pendo.io.o.b.NORMAL;
        }
        if (i == 2) {
            return sdk.pendo.io.o.b.HIGH;
        }
        if (i == 3 || i == 4) {
            return sdk.pendo.io.o.b.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + getPriority());
    }

    private void initRequestListeners(List<sdk.pendo.io.e0.b<Object>> list) {
        Iterator<sdk.pendo.io.e0.b<Object>> it = list.iterator();
        while (it.hasNext()) {
            addListener((sdk.pendo.io.e0.b) it.next());
        }
    }

    private boolean isSkipMemoryCacheWithCompletePreviousRequest(external.sdk.pendo.io.glide.request.a<?> aVar, sdk.pendo.io.e0.a aVar2) {
        return !aVar.isMemoryCacheable() && aVar2.isComplete();
    }

    private RequestBuilder<TranscodeType> loadGeneric(Object obj) {
        if (isAutoCloneEnabled()) {
            return mo1078clone().loadGeneric(obj);
        }
        this.model = obj;
        this.isModelSet = true;
        return selfOrThrowIfLocked();
    }

    private sdk.pendo.io.e0.a obtainRequest(Object obj, Target<TranscodeType> target, sdk.pendo.io.e0.b<TranscodeType> bVar, external.sdk.pendo.io.glide.request.a<?> aVar, external.sdk.pendo.io.glide.request.b bVar2, d<?, ? super TranscodeType> dVar, sdk.pendo.io.o.b bVar3, int i, int i2, Executor executor) {
        Context context = this.context;
        b bVar4 = this.glideContext;
        return SingleRequest.obtain(context, bVar4, obj, this.model, this.transcodeClass, aVar, i, i2, bVar3, target, bVar, this.requestListeners, bVar2, bVar4.d(), dVar.getTransitionFactory(), executor);
    }

    public RequestBuilder<TranscodeType> addListener(sdk.pendo.io.e0.b<TranscodeType> bVar) {
        if (isAutoCloneEnabled()) {
            return mo1078clone().addListener(bVar);
        }
        if (bVar != null) {
            if (this.requestListeners == null) {
                this.requestListeners = new ArrayList();
            }
            this.requestListeners.add(bVar);
        }
        return selfOrThrowIfLocked();
    }

    @Override // external.sdk.pendo.io.glide.request.a
    public RequestBuilder<TranscodeType> apply(external.sdk.pendo.io.glide.request.a<?> aVar) {
        j.a(aVar);
        return (RequestBuilder) super.apply(aVar);
    }

    @Override // external.sdk.pendo.io.glide.request.a
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> mo1078clone() {
        RequestBuilder<TranscodeType> requestBuilder = (RequestBuilder) super.mo1078clone();
        requestBuilder.transitionOptions = (d<?, ? super TranscodeType>) requestBuilder.transitionOptions.m1097clone();
        if (requestBuilder.requestListeners != null) {
            requestBuilder.requestListeners = new ArrayList(requestBuilder.requestListeners);
        }
        RequestBuilder<TranscodeType> requestBuilder2 = requestBuilder.thumbnailBuilder;
        if (requestBuilder2 != null) {
            requestBuilder.thumbnailBuilder = requestBuilder2.mo1078clone();
        }
        RequestBuilder<TranscodeType> requestBuilder3 = requestBuilder.errorBuilder;
        if (requestBuilder3 != null) {
            requestBuilder.errorBuilder = requestBuilder3.mo1078clone();
        }
        return requestBuilder;
    }

    @Deprecated
    public FutureTarget<File> downloadOnly(int i, int i2) {
        return getDownloadOnlyRequest().submit(i, i2);
    }

    public RequestBuilder<TranscodeType> error(RequestBuilder<TranscodeType> requestBuilder) {
        if (isAutoCloneEnabled()) {
            return mo1078clone().error((RequestBuilder) requestBuilder);
        }
        this.errorBuilder = requestBuilder;
        return selfOrThrowIfLocked();
    }

    protected RequestBuilder<File> getDownloadOnlyRequest() {
        return new RequestBuilder(File.class, this).apply((external.sdk.pendo.io.glide.request.a<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    @Deprecated
    public FutureTarget<TranscodeType> into(int i, int i2) {
        return submit(i, i2);
    }

    public RequestBuilder<TranscodeType> listener(sdk.pendo.io.e0.b<TranscodeType> bVar) {
        if (isAutoCloneEnabled()) {
            return mo1078clone().listener(bVar);
        }
        this.requestListeners = null;
        return addListener(bVar);
    }

    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> m1079load(Bitmap bitmap) {
        return loadGeneric(bitmap).apply((external.sdk.pendo.io.glide.request.a<?>) RequestOptions.diskCacheStrategyOf(sdk.pendo.io.t.a.b));
    }

    public Target<TranscodeType> preload() {
        return preload(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public FutureTarget<TranscodeType> submit() {
        return submit(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public RequestBuilder<TranscodeType> thumbnail(float f) {
        if (isAutoCloneEnabled()) {
            return mo1078clone().thumbnail(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.thumbSizeMultiplier = Float.valueOf(f);
        return selfOrThrowIfLocked();
    }

    public RequestBuilder<TranscodeType> transition(d<?, ? super TranscodeType> dVar) {
        if (isAutoCloneEnabled()) {
            return mo1078clone().transition(dVar);
        }
        this.transitionOptions = (d) j.a(dVar);
        this.isDefaultTransitionOptionsSet = false;
        return selfOrThrowIfLocked();
    }

    protected RequestBuilder(Class<TranscodeType> cls, RequestBuilder<?> requestBuilder) {
        this(requestBuilder.glide, requestBuilder.requestManager, cls, requestBuilder.context);
        this.model = requestBuilder.model;
        this.isModelSet = requestBuilder.isModelSet;
        apply((external.sdk.pendo.io.glide.request.a<?>) requestBuilder);
    }

    @Override // external.sdk.pendo.io.glide.request.a
    public /* bridge */ /* synthetic */ external.sdk.pendo.io.glide.request.a apply(external.sdk.pendo.io.glide.request.a aVar) {
        return apply((external.sdk.pendo.io.glide.request.a<?>) aVar);
    }

    @Deprecated
    public <Y extends Target<File>> Y downloadOnly(Y y) {
        return (Y) getDownloadOnlyRequest().into((RequestBuilder<File>) y);
    }

    public RequestBuilder<TranscodeType> error(Object obj) {
        return error((RequestBuilder) (obj == null ? null : cloneWithNullErrorAndThumbnail().m1084load(obj)));
    }

    public <Y extends Target<TranscodeType>> Y into(Y y) {
        return (Y) into(y, null, e.b());
    }

    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> m1080load(Drawable drawable) {
        return loadGeneric(drawable).apply((external.sdk.pendo.io.glide.request.a<?>) RequestOptions.diskCacheStrategyOf(sdk.pendo.io.t.a.b));
    }

    public Target<TranscodeType> preload(int i, int i2) {
        return into((RequestBuilder<TranscodeType>) PreloadTarget.obtain(this.requestManager, i, i2));
    }

    public FutureTarget<TranscodeType> submit(int i, int i2) {
        RequestFutureTarget requestFutureTarget = new RequestFutureTarget(i, i2);
        return (FutureTarget) into(requestFutureTarget, requestFutureTarget, e.a());
    }

    public RequestBuilder<TranscodeType> thumbnail(RequestBuilder<TranscodeType> requestBuilder) {
        if (isAutoCloneEnabled()) {
            return mo1078clone().thumbnail(requestBuilder);
        }
        this.thumbnailBuilder = requestBuilder;
        return selfOrThrowIfLocked();
    }

    private <Y extends Target<TranscodeType>> Y into(Y y, sdk.pendo.io.e0.b<TranscodeType> bVar, external.sdk.pendo.io.glide.request.a<?> aVar, Executor executor) {
        j.a(y);
        if (!this.isModelSet) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        sdk.pendo.io.e0.a buildRequest = buildRequest(y, bVar, aVar, executor);
        sdk.pendo.io.e0.a request = y.getRequest();
        if (buildRequest.isEquivalentTo(request) && !isSkipMemoryCacheWithCompletePreviousRequest(aVar, request)) {
            if (!((sdk.pendo.io.e0.a) j.a(request)).isRunning()) {
                request.begin();
            }
            return y;
        }
        this.requestManager.clear((Target<?>) y);
        y.setRequest(buildRequest);
        this.requestManager.track(y, buildRequest);
        return y;
    }

    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> m1081load(Uri uri) {
        return loadGeneric(uri);
    }

    public RequestBuilder<TranscodeType> thumbnail(List<RequestBuilder<TranscodeType>> list) {
        RequestBuilder<TranscodeType> requestBuilder = null;
        if (list == null || list.isEmpty()) {
            return thumbnail((RequestBuilder) null);
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            RequestBuilder<TranscodeType> requestBuilder2 = list.get(size);
            if (requestBuilder2 != null) {
                requestBuilder = requestBuilder == null ? requestBuilder2 : requestBuilder2.thumbnail(requestBuilder);
            }
        }
        return thumbnail(requestBuilder);
    }

    <Y extends Target<TranscodeType>> Y into(Y y, sdk.pendo.io.e0.b<TranscodeType> bVar, Executor executor) {
        return (Y) into(y, bVar, this, executor);
    }

    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> m1082load(File file) {
        return loadGeneric(file);
    }

    public RequestBuilder<TranscodeType> thumbnail(RequestBuilder<TranscodeType>... requestBuilderArr) {
        return (requestBuilderArr == null || requestBuilderArr.length == 0) ? thumbnail((RequestBuilder) null) : thumbnail(Arrays.asList(requestBuilderArr));
    }

    public ViewTarget<ImageView, TranscodeType> into(ImageView imageView) {
        RequestBuilder<TranscodeType> requestBuilder;
        k.b();
        j.a(imageView);
        if (!isTransformationSet() && isTransformationAllowed() && imageView.getScaleType() != null) {
            switch (a.f622a[imageView.getScaleType().ordinal()]) {
                case 1:
                    requestBuilder = mo1078clone().optionalCenterCrop();
                    break;
                case 2:
                case 6:
                    requestBuilder = mo1078clone().optionalCenterInside();
                    break;
                case 3:
                case 4:
                case 5:
                    requestBuilder = mo1078clone().optionalFitCenter();
                    break;
            }
            return (ViewTarget) into(this.glideContext.a(imageView, this.transcodeClass), null, requestBuilder, e.b());
        }
        requestBuilder = this;
        return (ViewTarget) into(this.glideContext.a(imageView, this.transcodeClass), null, requestBuilder, e.b());
    }

    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> m1083load(Integer num) {
        return loadGeneric(num).apply((external.sdk.pendo.io.glide.request.a<?>) RequestOptions.signatureOf(AndroidResourceSignature.obtain(this.context)));
    }

    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> m1084load(Object obj) {
        return loadGeneric(obj);
    }

    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> m1085load(String str) {
        return loadGeneric(str);
    }

    @Deprecated
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> m1086load(URL url) {
        return loadGeneric(url);
    }

    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> m1087load(byte[] bArr) {
        RequestBuilder<TranscodeType> loadGeneric = loadGeneric(bArr);
        if (!loadGeneric.isDiskCacheStrategySet()) {
            loadGeneric = loadGeneric.apply((external.sdk.pendo.io.glide.request.a<?>) RequestOptions.diskCacheStrategyOf(sdk.pendo.io.t.a.b));
        }
        return !loadGeneric.isSkipMemoryCacheSet() ? loadGeneric.apply((external.sdk.pendo.io.glide.request.a<?>) RequestOptions.skipMemoryCacheOf(true)) : loadGeneric;
    }
}
