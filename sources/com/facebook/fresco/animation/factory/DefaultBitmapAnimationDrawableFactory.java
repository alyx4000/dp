package com.facebook.fresco.animation.factory;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.fresco.animation.bitmap.BitmapAnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.fresco.animation.bitmap.cache.AnimationFrameCacheKey;
import com.facebook.fresco.animation.bitmap.cache.FrescoFpsCache;
import com.facebook.fresco.animation.bitmap.cache.FrescoFrameCache;
import com.facebook.fresco.animation.bitmap.cache.KeepLastFrameCache;
import com.facebook.fresco.animation.bitmap.cache.NoOpCache;
import com.facebook.fresco.animation.bitmap.preparation.BalancedAnimationStrategy;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.FixedNumberBitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.preparation.FrameLoaderStrategy;
import com.facebook.fresco.animation.bitmap.preparation.loadframe.FpsCompressorInfo;
import com.facebook.fresco.animation.bitmap.preparation.loadframe.LoadFrameTaskFactory;
import com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoaderFactory;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendAnimationInformation;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.KAnimatedDrawable2;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.options.ImageOptionsDrawableFactory;
import com.facebook.fresco.vito.options.RoundingOptions;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.AnimatedCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class DefaultBitmapAnimationDrawableFactory implements DrawableFactory, ImageOptionsDrawableFactory {
    public static final int CACHING_STRATEGY_FRESCO_CACHE = 1;
    public static final int CACHING_STRATEGY_FRESCO_CACHE_NO_REUSING = 2;
    public static final int CACHING_STRATEGY_KEEP_LAST_CACHE = 3;
    public static final int CACHING_STRATEGY_NO_CACHE = 0;
    private final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    private final Supplier<AnimatedCache> mAnimatedDrawableCache;
    private final Supplier<Integer> mAnimationFpsLimit;
    private final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    private final Supplier<Integer> mBalancedStrategyPreparationMs;
    private final Supplier<Integer> mCachingStrategySupplier;
    private final Supplier<Boolean> mDownscaleFrameToDrawableDimensions;
    private final ExecutorService mExecutorServiceForFramePreparing;
    private final MonotonicClock mMonotonicClock;
    private final Supplier<Integer> mNumberOfFramesToPrepareSupplier;
    private final PlatformBitmapFactory mPlatformBitmapFactory;
    private final ScheduledExecutorService mScheduledExecutorServiceForUiThread;
    private final Supplier<Boolean> mUseDeepEqualsForCacheKey;
    private final Supplier<Boolean> mUseNewBitmapRender;
    private final Supplier<Boolean> useRendererAnimatedDrawable = Suppliers.BOOLEAN_FALSE;

    public DefaultBitmapAnimationDrawableFactory(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, MonotonicClock monotonicClock, PlatformBitmapFactory platformBitmapFactory, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, Supplier<AnimatedCache> supplier, Supplier<Integer> supplier2, Supplier<Integer> supplier3, Supplier<Boolean> supplier4, Supplier<Boolean> supplier5, Supplier<Boolean> supplier6, Supplier<Integer> supplier7, Supplier<Integer> supplier8) {
        this.mAnimatedDrawableBackendProvider = animatedDrawableBackendProvider;
        this.mScheduledExecutorServiceForUiThread = scheduledExecutorService;
        this.mExecutorServiceForFramePreparing = executorService;
        this.mMonotonicClock = monotonicClock;
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBackingCache = countingMemoryCache;
        this.mCachingStrategySupplier = supplier2;
        this.mNumberOfFramesToPrepareSupplier = supplier3;
        this.mUseDeepEqualsForCacheKey = supplier4;
        this.mUseNewBitmapRender = supplier5;
        this.mAnimatedDrawableCache = supplier;
        this.mAnimationFpsLimit = supplier7;
        this.mBalancedStrategyPreparationMs = supplier8;
        this.mDownscaleFrameToDrawableDimensions = supplier6;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public boolean supportsImageType(CloseableImage closeableImage) {
        return closeableImage instanceof CloseableAnimatedImage;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public Drawable createDrawable(CloseableImage closeableImage) {
        CloseableAnimatedImage closeableAnimatedImage = (CloseableAnimatedImage) closeableImage;
        AnimatedImage image = closeableAnimatedImage.getImage();
        AnimationBackend createAnimationBackend = createAnimationBackend((AnimatedImageResult) Preconditions.checkNotNull(closeableAnimatedImage.getImageResult()), image != null ? image.getAnimatedBitmapConfig() : null, null);
        if (this.useRendererAnimatedDrawable.get().booleanValue()) {
            return new KAnimatedDrawable2(createAnimationBackend);
        }
        return new AnimatedDrawable2(createAnimationBackend);
    }

    @Override // com.facebook.fresco.vito.options.ImageOptionsDrawableFactory
    public Drawable createDrawable(Resources resources, CloseableImage closeableImage, ImageOptions imageOptions) {
        CloseableAnimatedImage closeableAnimatedImage = (CloseableAnimatedImage) closeableImage;
        AnimatedImage image = closeableAnimatedImage.getImage();
        AnimationBackend createAnimationBackend = createAnimationBackend((AnimatedImageResult) Preconditions.checkNotNull(closeableAnimatedImage.getImageResult()), image != null ? image.getAnimatedBitmapConfig() : null, imageOptions);
        if (this.useRendererAnimatedDrawable.get().booleanValue()) {
            return new KAnimatedDrawable2(createAnimationBackend);
        }
        return new AnimatedDrawable2(createAnimationBackend);
    }

    private AnimationBackend createAnimationBackend(AnimatedImageResult animatedImageResult, @Nullable Bitmap.Config config, @Nullable ImageOptions imageOptions) {
        BitmapFramePreparer bitmapFramePreparer;
        FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy;
        BitmapFramePreparationStrategy bitmapFramePreparationStrategy;
        AnimatedDrawableBackend createAnimatedDrawableBackend = createAnimatedDrawableBackend(animatedImageResult);
        AnimatedDrawableBackendAnimationInformation animatedDrawableBackendAnimationInformation = new AnimatedDrawableBackendAnimationInformation(createAnimatedDrawableBackend);
        BitmapFrameCache createBitmapFrameCache = createBitmapFrameCache(animatedImageResult);
        AnimatedDrawableBackendFrameRenderer animatedDrawableBackendFrameRenderer = new AnimatedDrawableBackendFrameRenderer(createBitmapFrameCache, createAnimatedDrawableBackend, this.mUseNewBitmapRender.get().booleanValue());
        int intValue = this.mNumberOfFramesToPrepareSupplier.get().intValue();
        if (intValue > 0) {
            fixedNumberBitmapFramePreparationStrategy = new FixedNumberBitmapFramePreparationStrategy(intValue);
            bitmapFramePreparer = createBitmapFramePreparer(animatedDrawableBackendFrameRenderer, config);
        } else {
            bitmapFramePreparer = null;
            fixedNumberBitmapFramePreparationStrategy = null;
        }
        RoundingOptions roundingOptions = imageOptions != null ? imageOptions.getRoundingOptions() : null;
        if (!this.mUseNewBitmapRender.get().booleanValue()) {
            bitmapFramePreparationStrategy = fixedNumberBitmapFramePreparationStrategy;
        } else if (this.mBalancedStrategyPreparationMs.get().intValue() != 0) {
            bitmapFramePreparationStrategy = new BalancedAnimationStrategy(animatedDrawableBackendAnimationInformation, this.mBalancedStrategyPreparationMs.get().intValue(), new LoadFrameTaskFactory(this.mPlatformBitmapFactory, animatedDrawableBackendFrameRenderer), createBitmapFrameCache, this.mDownscaleFrameToDrawableDimensions.get().booleanValue());
        } else {
            bitmapFramePreparationStrategy = new FrameLoaderStrategy(animatedImageResult.getSource(), animatedDrawableBackendAnimationInformation, animatedDrawableBackendFrameRenderer, new FrameLoaderFactory(this.mPlatformBitmapFactory, this.mAnimationFpsLimit.get().intValue()), this.mDownscaleFrameToDrawableDimensions.get().booleanValue());
        }
        return AnimationBackendDelegateWithInactivityCheck.createForBackend(new BitmapAnimationBackend(this.mPlatformBitmapFactory, createBitmapFrameCache, animatedDrawableBackendAnimationInformation, animatedDrawableBackendFrameRenderer, this.mUseNewBitmapRender.get().booleanValue(), bitmapFramePreparationStrategy, bitmapFramePreparer, roundingOptions), this.mMonotonicClock, this.mScheduledExecutorServiceForUiThread);
    }

    private BitmapFramePreparer createBitmapFramePreparer(BitmapFrameRenderer bitmapFrameRenderer, @Nullable Bitmap.Config config) {
        PlatformBitmapFactory platformBitmapFactory = this.mPlatformBitmapFactory;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        return new DefaultBitmapFramePreparer(platformBitmapFactory, bitmapFrameRenderer, config, this.mExecutorServiceForFramePreparing);
    }

    private AnimatedDrawableBackend createAnimatedDrawableBackend(AnimatedImageResult animatedImageResult) {
        AnimatedImage image = animatedImageResult.getImage();
        return this.mAnimatedDrawableBackendProvider.get(animatedImageResult, new Rect(0, 0, image.getWidth(), image.getHeight()));
    }

    private BitmapFrameCache createBitmapFrameCache(AnimatedImageResult animatedImageResult) {
        if (this.mUseNewBitmapRender.get().booleanValue()) {
            return new FrescoFpsCache(animatedImageResult, new FpsCompressorInfo(this.mAnimationFpsLimit.get().intValue()), this.mAnimatedDrawableCache.get());
        }
        int intValue = this.mCachingStrategySupplier.get().intValue();
        if (intValue == 1) {
            return new FrescoFrameCache(createAnimatedFrameCache(animatedImageResult), true);
        }
        if (intValue == 2) {
            return new FrescoFrameCache(createAnimatedFrameCache(animatedImageResult), false);
        }
        if (intValue == 3) {
            return new KeepLastFrameCache();
        }
        return new NoOpCache();
    }

    private AnimatedFrameCache createAnimatedFrameCache(AnimatedImageResult animatedImageResult) {
        return new AnimatedFrameCache(new AnimationFrameCacheKey(animatedImageResult.hashCode(), this.mUseDeepEqualsForCacheKey.get().booleanValue()), this.mBackingCache);
    }
}
