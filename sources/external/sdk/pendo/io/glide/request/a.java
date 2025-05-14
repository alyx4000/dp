package external.sdk.pendo.io.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.load.MultiTransformation;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.Transformation;
import external.sdk.pendo.io.glide.load.model.stream.HttpGlideUrlLoader;
import external.sdk.pendo.io.glide.load.resource.bitmap.BitmapEncoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.CenterCrop;
import external.sdk.pendo.io.glide.load.resource.bitmap.CenterInside;
import external.sdk.pendo.io.glide.load.resource.bitmap.CircleCrop;
import external.sdk.pendo.io.glide.load.resource.bitmap.DrawableTransformation;
import external.sdk.pendo.io.glide.load.resource.bitmap.FitCenter;
import external.sdk.pendo.io.glide.load.resource.bitmap.VideoDecoder;
import external.sdk.pendo.io.glide.load.resource.gif.GifDrawable;
import external.sdk.pendo.io.glide.load.resource.gif.GifDrawableTransformation;
import external.sdk.pendo.io.glide.request.a;
import external.sdk.pendo.io.glide.signature.EmptySignature;
import java.util.Map;
import sdk.pendo.io.i0.j;
import sdk.pendo.io.i0.k;
import sdk.pendo.io.q.f;
import sdk.pendo.io.q.g;

/* loaded from: classes2.dex */
public abstract class a<T extends a<T>> implements Cloneable {
    private static final int DISK_CACHE_STRATEGY = 4;
    private static final int ERROR_ID = 32;
    private static final int ERROR_PLACEHOLDER = 16;
    private static final int FALLBACK = 8192;
    private static final int FALLBACK_ID = 16384;
    private static final int IS_CACHEABLE = 256;
    private static final int ONLY_RETRIEVE_FROM_CACHE = 524288;
    private static final int OVERRIDE = 512;
    private static final int PLACEHOLDER = 64;
    private static final int PLACEHOLDER_ID = 128;
    private static final int PRIORITY = 8;
    private static final int RESOURCE_CLASS = 4096;
    private static final int SIGNATURE = 1024;
    private static final int SIZE_MULTIPLIER = 2;
    private static final int THEME = 32768;
    private static final int TRANSFORMATION = 2048;
    private static final int TRANSFORMATION_ALLOWED = 65536;
    private static final int TRANSFORMATION_REQUIRED = 131072;
    private static final int UNSET = -1;
    private static final int USE_ANIMATION_POOL = 1048576;
    private static final int USE_UNLIMITED_SOURCE_GENERATORS_POOL = 262144;
    private int errorId;
    private Drawable errorPlaceholder;
    private Drawable fallbackDrawable;
    private int fallbackId;
    private int fields;
    private boolean isAutoCloneEnabled;
    private boolean isLocked;
    private boolean isTransformationRequired;
    private boolean onlyRetrieveFromCache;
    private Drawable placeholderDrawable;
    private int placeholderId;
    private Resources.Theme theme;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorsPool;
    private float sizeMultiplier = 1.0f;
    private sdk.pendo.io.t.a diskCacheStrategy = sdk.pendo.io.t.a.e;
    private sdk.pendo.io.o.b priority = sdk.pendo.io.o.b.NORMAL;
    private boolean isCacheable = true;
    private int overrideHeight = -1;
    private int overrideWidth = -1;
    private f signature = EmptySignature.obtain();
    private boolean isTransformationAllowed = true;
    private Options options = new Options();
    private Map<Class<?>, Transformation<?>> transformations = new sdk.pendo.io.i0.b();
    private Class<?> resourceClass = Object.class;
    private boolean isScaleOnlyOrNoTransform = true;

    private boolean isSet(int i) {
        return isSet(this.fields, i);
    }

    private static boolean isSet(int i, int i2) {
        return (i & i2) != 0;
    }

    private T optionalScaleOnlyTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a aVar, Transformation<Bitmap> transformation) {
        return scaleOnlyTransform(aVar, transformation, false);
    }

    private T scaleOnlyTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a aVar, Transformation<Bitmap> transformation) {
        return scaleOnlyTransform(aVar, transformation, true);
    }

    private T self() {
        return this;
    }

    public T apply(a<?> aVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().apply(aVar);
        }
        if (isSet(aVar.fields, 2)) {
            this.sizeMultiplier = aVar.sizeMultiplier;
        }
        if (isSet(aVar.fields, 262144)) {
            this.useUnlimitedSourceGeneratorsPool = aVar.useUnlimitedSourceGeneratorsPool;
        }
        if (isSet(aVar.fields, 1048576)) {
            this.useAnimationPool = aVar.useAnimationPool;
        }
        if (isSet(aVar.fields, 4)) {
            this.diskCacheStrategy = aVar.diskCacheStrategy;
        }
        if (isSet(aVar.fields, 8)) {
            this.priority = aVar.priority;
        }
        if (isSet(aVar.fields, 16)) {
            this.errorPlaceholder = aVar.errorPlaceholder;
            this.errorId = 0;
            this.fields &= -33;
        }
        if (isSet(aVar.fields, 32)) {
            this.errorId = aVar.errorId;
            this.errorPlaceholder = null;
            this.fields &= -17;
        }
        if (isSet(aVar.fields, 64)) {
            this.placeholderDrawable = aVar.placeholderDrawable;
            this.placeholderId = 0;
            this.fields &= -129;
        }
        if (isSet(aVar.fields, 128)) {
            this.placeholderId = aVar.placeholderId;
            this.placeholderDrawable = null;
            this.fields &= -65;
        }
        if (isSet(aVar.fields, 256)) {
            this.isCacheable = aVar.isCacheable;
        }
        if (isSet(aVar.fields, 512)) {
            this.overrideWidth = aVar.overrideWidth;
            this.overrideHeight = aVar.overrideHeight;
        }
        if (isSet(aVar.fields, 1024)) {
            this.signature = aVar.signature;
        }
        if (isSet(aVar.fields, 4096)) {
            this.resourceClass = aVar.resourceClass;
        }
        if (isSet(aVar.fields, 8192)) {
            this.fallbackDrawable = aVar.fallbackDrawable;
            this.fallbackId = 0;
            this.fields &= -16385;
        }
        if (isSet(aVar.fields, 16384)) {
            this.fallbackId = aVar.fallbackId;
            this.fallbackDrawable = null;
            this.fields &= -8193;
        }
        if (isSet(aVar.fields, 32768)) {
            this.theme = aVar.theme;
        }
        if (isSet(aVar.fields, 65536)) {
            this.isTransformationAllowed = aVar.isTransformationAllowed;
        }
        if (isSet(aVar.fields, 131072)) {
            this.isTransformationRequired = aVar.isTransformationRequired;
        }
        if (isSet(aVar.fields, 2048)) {
            this.transformations.putAll(aVar.transformations);
            this.isScaleOnlyOrNoTransform = aVar.isScaleOnlyOrNoTransform;
        }
        if (isSet(aVar.fields, 524288)) {
            this.onlyRetrieveFromCache = aVar.onlyRetrieveFromCache;
        }
        if (!this.isTransformationAllowed) {
            this.transformations.clear();
            int i = this.fields & (-2049);
            this.isTransformationRequired = false;
            this.fields = i & (-131073);
            this.isScaleOnlyOrNoTransform = true;
        }
        this.fields |= aVar.fields;
        this.options.putAll(aVar.options);
        return selfOrThrowIfLocked();
    }

    public T autoClone() {
        if (this.isLocked && !this.isAutoCloneEnabled) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.isAutoCloneEnabled = true;
        return lock();
    }

    public T centerCrop() {
        return transform(external.sdk.pendo.io.glide.load.resource.bitmap.a.e, new CenterCrop());
    }

    public T centerInside() {
        return scaleOnlyTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a.d, new CenterInside());
    }

    public T circleCrop() {
        return transform(external.sdk.pendo.io.glide.load.resource.bitmap.a.d, new CircleCrop());
    }

    @Override // 
    /* renamed from: clone */
    public T mo1078clone() {
        try {
            T t = (T) super.clone();
            Options options = new Options();
            t.options = options;
            options.putAll(this.options);
            sdk.pendo.io.i0.b bVar = new sdk.pendo.io.i0.b();
            t.transformations = bVar;
            bVar.putAll(this.transformations);
            t.isLocked = false;
            t.isAutoCloneEnabled = false;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public T decode(Class<?> cls) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().decode(cls);
        }
        this.resourceClass = (Class) j.a(cls);
        this.fields |= 4096;
        return selfOrThrowIfLocked();
    }

    public T disallowHardwareConfig() {
        return set(external.sdk.pendo.io.glide.load.resource.bitmap.b.j, Boolean.FALSE);
    }

    public T diskCacheStrategy(sdk.pendo.io.t.a aVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().diskCacheStrategy(aVar);
        }
        this.diskCacheStrategy = (sdk.pendo.io.t.a) j.a(aVar);
        this.fields |= 4;
        return selfOrThrowIfLocked();
    }

    public T dontAnimate() {
        return set(sdk.pendo.io.a0.a.b, Boolean.TRUE);
    }

    public T dontTransform() {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().dontTransform();
        }
        this.transformations.clear();
        int i = this.fields & (-2049);
        this.isTransformationRequired = false;
        this.isTransformationAllowed = false;
        this.fields = (i & (-131073)) | 65536;
        this.isScaleOnlyOrNoTransform = true;
        return selfOrThrowIfLocked();
    }

    public T downsample(external.sdk.pendo.io.glide.load.resource.bitmap.a aVar) {
        return set(external.sdk.pendo.io.glide.load.resource.bitmap.a.h, j.a(aVar));
    }

    public T encodeFormat(Bitmap.CompressFormat compressFormat) {
        return set(BitmapEncoder.COMPRESSION_FORMAT, j.a(compressFormat));
    }

    public T encodeQuality(int i) {
        return set(BitmapEncoder.COMPRESSION_QUALITY, Integer.valueOf(i));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(aVar.sizeMultiplier, this.sizeMultiplier) == 0 && this.errorId == aVar.errorId && k.b(this.errorPlaceholder, aVar.errorPlaceholder) && this.placeholderId == aVar.placeholderId && k.b(this.placeholderDrawable, aVar.placeholderDrawable) && this.fallbackId == aVar.fallbackId && k.b(this.fallbackDrawable, aVar.fallbackDrawable) && this.isCacheable == aVar.isCacheable && this.overrideHeight == aVar.overrideHeight && this.overrideWidth == aVar.overrideWidth && this.isTransformationRequired == aVar.isTransformationRequired && this.isTransformationAllowed == aVar.isTransformationAllowed && this.useUnlimitedSourceGeneratorsPool == aVar.useUnlimitedSourceGeneratorsPool && this.onlyRetrieveFromCache == aVar.onlyRetrieveFromCache && this.diskCacheStrategy.equals(aVar.diskCacheStrategy) && this.priority == aVar.priority && this.options.equals(aVar.options) && this.transformations.equals(aVar.transformations) && this.resourceClass.equals(aVar.resourceClass) && k.b(this.signature, aVar.signature) && k.b(this.theme, aVar.theme);
    }

    public T error(int i) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().error(i);
        }
        this.errorId = i;
        int i2 = this.fields | 32;
        this.errorPlaceholder = null;
        this.fields = i2 & (-17);
        return selfOrThrowIfLocked();
    }

    public T fallback(int i) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().fallback(i);
        }
        this.fallbackId = i;
        int i2 = this.fields | 16384;
        this.fallbackDrawable = null;
        this.fields = i2 & (-8193);
        return selfOrThrowIfLocked();
    }

    public T fitCenter() {
        return scaleOnlyTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a.c, new FitCenter());
    }

    public T format(sdk.pendo.io.q.b bVar) {
        j.a(bVar);
        return (T) set(external.sdk.pendo.io.glide.load.resource.bitmap.b.f, bVar).set(sdk.pendo.io.a0.a.f835a, bVar);
    }

    public T frame(long j) {
        return set(VideoDecoder.TARGET_FRAME, Long.valueOf(j));
    }

    public final sdk.pendo.io.t.a getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public final int getErrorId() {
        return this.errorId;
    }

    public final Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    public final Drawable getFallbackDrawable() {
        return this.fallbackDrawable;
    }

    public final int getFallbackId() {
        return this.fallbackId;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    public final Options getOptions() {
        return this.options;
    }

    public final int getOverrideHeight() {
        return this.overrideHeight;
    }

    public final int getOverrideWidth() {
        return this.overrideWidth;
    }

    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public final int getPlaceholderId() {
        return this.placeholderId;
    }

    public final sdk.pendo.io.o.b getPriority() {
        return this.priority;
    }

    public final Class<?> getResourceClass() {
        return this.resourceClass;
    }

    public final f getSignature() {
        return this.signature;
    }

    public final float getSizeMultiplier() {
        return this.sizeMultiplier;
    }

    public final Resources.Theme getTheme() {
        return this.theme;
    }

    public final Map<Class<?>, Transformation<?>> getTransformations() {
        return this.transformations;
    }

    public final boolean getUseAnimationPool() {
        return this.useAnimationPool;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.useUnlimitedSourceGeneratorsPool;
    }

    public int hashCode() {
        return k.a(this.theme, k.a(this.signature, k.a(this.resourceClass, k.a(this.transformations, k.a(this.options, k.a(this.priority, k.a(this.diskCacheStrategy, k.a(this.onlyRetrieveFromCache, k.a(this.useUnlimitedSourceGeneratorsPool, k.a(this.isTransformationAllowed, k.a(this.isTransformationRequired, k.a(this.overrideWidth, k.a(this.overrideHeight, k.a(this.isCacheable, k.a(this.fallbackDrawable, k.a(this.fallbackId, k.a(this.placeholderDrawable, k.a(this.placeholderId, k.a(this.errorPlaceholder, k.a(this.errorId, k.a(this.sizeMultiplier)))))))))))))))))))));
    }

    protected final boolean isAutoCloneEnabled() {
        return this.isAutoCloneEnabled;
    }

    public final boolean isDiskCacheStrategySet() {
        return isSet(4);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public final boolean isMemoryCacheable() {
        return this.isCacheable;
    }

    public final boolean isPrioritySet() {
        return isSet(8);
    }

    boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    public final boolean isSkipMemoryCacheSet() {
        return isSet(256);
    }

    public final boolean isTransformationAllowed() {
        return this.isTransformationAllowed;
    }

    public final boolean isTransformationRequired() {
        return this.isTransformationRequired;
    }

    public final boolean isTransformationSet() {
        return isSet(2048);
    }

    public final boolean isValidOverride() {
        return k.b(this.overrideWidth, this.overrideHeight);
    }

    public T lock() {
        this.isLocked = true;
        return self();
    }

    public T onlyRetrieveFromCache(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().onlyRetrieveFromCache(z);
        }
        this.onlyRetrieveFromCache = z;
        this.fields |= 524288;
        return selfOrThrowIfLocked();
    }

    public T optionalCenterCrop() {
        return optionalTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a.e, new CenterCrop());
    }

    public T optionalCenterInside() {
        return optionalScaleOnlyTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a.d, new CenterInside());
    }

    public T optionalCircleCrop() {
        return optionalTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a.e, new CircleCrop());
    }

    public T optionalFitCenter() {
        return optionalScaleOnlyTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a.c, new FitCenter());
    }

    public T optionalTransform(Transformation<Bitmap> transformation) {
        return transform(transformation, false);
    }

    public T override(int i) {
        return override(i, i);
    }

    public T placeholder(int i) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().placeholder(i);
        }
        this.placeholderId = i;
        int i2 = this.fields | 128;
        this.placeholderDrawable = null;
        this.fields = i2 & (-65);
        return selfOrThrowIfLocked();
    }

    public T priority(sdk.pendo.io.o.b bVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().priority(bVar);
        }
        this.priority = (sdk.pendo.io.o.b) j.a(bVar);
        this.fields |= 8;
        return selfOrThrowIfLocked();
    }

    protected final T selfOrThrowIfLocked() {
        if (this.isLocked) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return self();
    }

    public <Y> T set(g<Y> gVar, Y y) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().set(gVar, y);
        }
        j.a(gVar);
        j.a(y);
        this.options.set(gVar, y);
        return selfOrThrowIfLocked();
    }

    public T signature(f fVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().signature(fVar);
        }
        this.signature = (f) j.a(fVar);
        this.fields |= 1024;
        return selfOrThrowIfLocked();
    }

    public T sizeMultiplier(float f) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().sizeMultiplier(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.sizeMultiplier = f;
        this.fields |= 2;
        return selfOrThrowIfLocked();
    }

    public T skipMemoryCache(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().skipMemoryCache(true);
        }
        this.isCacheable = !z;
        this.fields |= 256;
        return selfOrThrowIfLocked();
    }

    public T theme(Resources.Theme theme) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().theme(theme);
        }
        this.theme = theme;
        this.fields |= 32768;
        return selfOrThrowIfLocked();
    }

    public T timeout(int i) {
        return set(HttpGlideUrlLoader.TIMEOUT, Integer.valueOf(i));
    }

    public T transform(Transformation<Bitmap> transformation) {
        return transform(transformation, true);
    }

    @Deprecated
    public T transforms(Transformation<Bitmap>... transformationArr) {
        return transform((Transformation<Bitmap>) new MultiTransformation(transformationArr), true);
    }

    public T useAnimationPool(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().useAnimationPool(z);
        }
        this.useAnimationPool = z;
        this.fields |= 1048576;
        return selfOrThrowIfLocked();
    }

    public T useUnlimitedSourceGeneratorsPool(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().useUnlimitedSourceGeneratorsPool(z);
        }
        this.useUnlimitedSourceGeneratorsPool = z;
        this.fields |= 262144;
        return selfOrThrowIfLocked();
    }

    private T scaleOnlyTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a aVar, Transformation<Bitmap> transformation, boolean z) {
        T transform = z ? transform(aVar, transformation) : optionalTransform(aVar, transformation);
        transform.isScaleOnlyOrNoTransform = true;
        return transform;
    }

    public T error(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().error(drawable);
        }
        this.errorPlaceholder = drawable;
        int i = this.fields | 16;
        this.errorId = 0;
        this.fields = i & (-33);
        return selfOrThrowIfLocked();
    }

    public T fallback(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().fallback(drawable);
        }
        this.fallbackDrawable = drawable;
        int i = this.fields | 8192;
        this.fallbackId = 0;
        this.fields = i & (-16385);
        return selfOrThrowIfLocked();
    }

    final T optionalTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a aVar, Transformation<Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().optionalTransform(aVar, transformation);
        }
        downsample(aVar);
        return transform(transformation, false);
    }

    public T override(int i, int i2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().override(i, i2);
        }
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.fields |= 512;
        return selfOrThrowIfLocked();
    }

    public T placeholder(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().placeholder(drawable);
        }
        this.placeholderDrawable = drawable;
        int i = this.fields | 64;
        this.placeholderId = 0;
        this.fields = i & (-129);
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Multi-variable type inference failed */
    T transform(Transformation<Bitmap> transformation, boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().transform(transformation, z);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z);
        transform(Bitmap.class, transformation, z);
        transform(Drawable.class, drawableTransformation, z);
        transform(BitmapDrawable.class, drawableTransformation.asBitmapDrawable(), z);
        transform(GifDrawable.class, new GifDrawableTransformation(transformation), z);
        return selfOrThrowIfLocked();
    }

    public <Y> T optionalTransform(Class<Y> cls, Transformation<Y> transformation) {
        return transform(cls, transformation, false);
    }

    final T transform(external.sdk.pendo.io.glide.load.resource.bitmap.a aVar, Transformation<Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().transform(aVar, transformation);
        }
        downsample(aVar);
        return transform(transformation);
    }

    public <Y> T transform(Class<Y> cls, Transformation<Y> transformation) {
        return transform(cls, transformation, true);
    }

    <Y> T transform(Class<Y> cls, Transformation<Y> transformation, boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo1078clone().transform(cls, transformation, z);
        }
        j.a(cls);
        j.a(transformation);
        this.transformations.put(cls, transformation);
        int i = this.fields | 2048;
        this.isTransformationAllowed = true;
        int i2 = i | 65536;
        this.fields = i2;
        this.isScaleOnlyOrNoTransform = false;
        if (z) {
            this.fields = i2 | 131072;
            this.isTransformationRequired = true;
        }
        return selfOrThrowIfLocked();
    }

    public T transform(Transformation<Bitmap>... transformationArr) {
        return transformationArr.length > 1 ? transform((Transformation<Bitmap>) new MultiTransformation(transformationArr), true) : transformationArr.length == 1 ? transform(transformationArr[0]) : selfOrThrowIfLocked();
    }
}
