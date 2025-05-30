package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BoundedLinkedHashSet;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.BitmapPrepareProducer;
import com.facebook.imagepipeline.producers.BitmapProbeProducer;
import com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.facebook.imagepipeline.producers.DelayProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.DiskCacheWriteProducer;
import com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.EncodedProbeProducer;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer;
import com.facebook.imagepipeline.producers.LocalExifThumbnailProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.LocalThumbnailBitmapProducer;
import com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.PartialDiskCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessorProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer;
import com.facebook.imagepipeline.producers.ResizeAndRotateProducer;
import com.facebook.imagepipeline.producers.SwallowResultProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThrottlingProducer;
import com.facebook.imagepipeline.producers.ThumbnailBranchProducer;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.producers.WebpTranscodeProducer;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;

/* loaded from: classes3.dex */
public class ProducerFactory {
    private static final int MAX_SIMULTANEOUS_REQUESTS = 5;
    protected AssetManager mAssetManager;
    protected final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
    protected boolean mBitmapPrepareToDrawForPrefetch;
    protected final int mBitmapPrepareToDrawMaxSizeBytes;
    protected final int mBitmapPrepareToDrawMinSizeBytes;
    protected final ByteArrayPool mByteArrayPool;
    protected final CacheKeyFactory mCacheKeyFactory;
    protected final CloseableReferenceFactory mCloseableReferenceFactory;
    protected ContentResolver mContentResolver;
    protected final boolean mDecodeCancellationEnabled;
    protected final BufferedDiskCache mDefaultBufferedDiskCache;
    protected final BoundedLinkedHashSet<CacheKey> mDiskCacheHistory;
    protected final boolean mDownsampleEnabled;
    protected final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    protected final BoundedLinkedHashSet<CacheKey> mEncodedMemoryCacheHistory;
    protected final ExecutorSupplier mExecutorSupplier;
    protected final ImageDecoder mImageDecoder;
    protected final boolean mKeepCancelledFetchAsLowPriority;
    protected final int mMaxBitmapSize;
    protected final PlatformBitmapFactory mPlatformBitmapFactory;
    protected final PooledByteBufferFactory mPooledByteBufferFactory;
    protected final ProgressiveJpegConfig mProgressiveJpegConfig;
    protected final boolean mResizeAndRotateEnabledForNetwork;
    protected Resources mResources;
    protected final BufferedDiskCache mSmallImageBufferedDiskCache;

    public ProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z4, int i3, CloseableReferenceFactory closeableReferenceFactory, boolean z5, int i4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.mByteArrayPool = byteArrayPool;
        this.mImageDecoder = imageDecoder;
        this.mProgressiveJpegConfig = progressiveJpegConfig;
        this.mDownsampleEnabled = z;
        this.mResizeAndRotateEnabledForNetwork = z2;
        this.mDecodeCancellationEnabled = z3;
        this.mExecutorSupplier = executorSupplier;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mBitmapMemoryCache = memoryCache;
        this.mEncodedMemoryCache = memoryCache2;
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mEncodedMemoryCacheHistory = new BoundedLinkedHashSet<>(i4);
        this.mDiskCacheHistory = new BoundedLinkedHashSet<>(i4);
        this.mBitmapPrepareToDrawMinSizeBytes = i;
        this.mBitmapPrepareToDrawMaxSizeBytes = i2;
        this.mBitmapPrepareToDrawForPrefetch = z4;
        this.mMaxBitmapSize = i3;
        this.mCloseableReferenceFactory = closeableReferenceFactory;
        this.mKeepCancelledFetchAsLowPriority = z5;
    }

    public static AddImageTransformMetaDataProducer newAddImageTransformMetaDataProducer(Producer<EncodedImage> producer) {
        return new AddImageTransformMetaDataProducer(producer);
    }

    public BitmapMemoryCacheGetProducer newBitmapMemoryCacheGetProducer(Producer<CloseableReference<CloseableImage>> producer) {
        return new BitmapMemoryCacheGetProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, producer);
    }

    public BitmapMemoryCacheKeyMultiplexProducer newBitmapMemoryCacheKeyMultiplexProducer(Producer<CloseableReference<CloseableImage>> producer) {
        return new BitmapMemoryCacheKeyMultiplexProducer(this.mCacheKeyFactory, producer);
    }

    public BitmapMemoryCacheProducer newBitmapMemoryCacheProducer(Producer<CloseableReference<CloseableImage>> producer) {
        return new BitmapMemoryCacheProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, producer);
    }

    public static BranchOnSeparateImagesProducer newBranchOnSeparateImagesProducer(Producer<EncodedImage> producer, Producer<EncodedImage> producer2) {
        return new BranchOnSeparateImagesProducer(producer, producer2);
    }

    public DataFetchProducer newDataFetchProducer() {
        return new DataFetchProducer(this.mPooledByteBufferFactory);
    }

    public DecodeProducer newDecodeProducer(Producer<EncodedImage> producer) {
        return new DecodeProducer(this.mByteArrayPool, this.mExecutorSupplier.getDecodeExecutor(), this.mImageDecoder, this.mProgressiveJpegConfig, this.mDownsampleEnabled, this.mResizeAndRotateEnabledForNetwork, this.mDecodeCancellationEnabled, producer, this.mMaxBitmapSize, this.mCloseableReferenceFactory, null, Suppliers.BOOLEAN_FALSE);
    }

    public DiskCacheReadProducer newDiskCacheReadProducer(Producer<EncodedImage> producer) {
        return new DiskCacheReadProducer(this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, producer);
    }

    public DiskCacheWriteProducer newDiskCacheWriteProducer(Producer<EncodedImage> producer) {
        return new DiskCacheWriteProducer(this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, producer);
    }

    public PartialDiskCacheProducer newPartialDiskCacheProducer(Producer<EncodedImage> producer) {
        return new PartialDiskCacheProducer(this.mDefaultBufferedDiskCache, this.mCacheKeyFactory, this.mPooledByteBufferFactory, this.mByteArrayPool, producer);
    }

    public EncodedCacheKeyMultiplexProducer newEncodedCacheKeyMultiplexProducer(Producer<EncodedImage> producer) {
        return new EncodedCacheKeyMultiplexProducer(this.mCacheKeyFactory, this.mKeepCancelledFetchAsLowPriority, producer);
    }

    public BitmapProbeProducer newBitmapProbeProducer(Producer<CloseableReference<CloseableImage>> producer) {
        return new BitmapProbeProducer(this.mEncodedMemoryCache, this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, this.mEncodedMemoryCacheHistory, this.mDiskCacheHistory, producer);
    }

    public EncodedProbeProducer newEncodedProbeProducer(Producer<EncodedImage> producer) {
        return new EncodedProbeProducer(this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, this.mEncodedMemoryCacheHistory, this.mDiskCacheHistory, producer);
    }

    public Producer<EncodedImage> newEncodedMemoryCacheProducer(Producer<EncodedImage> producer) {
        return new EncodedMemoryCacheProducer(this.mEncodedMemoryCache, this.mCacheKeyFactory, producer);
    }

    public LocalAssetFetchProducer newLocalAssetFetchProducer() {
        return new LocalAssetFetchProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mPooledByteBufferFactory, this.mAssetManager);
    }

    public LocalContentUriFetchProducer newLocalContentUriFetchProducer() {
        return new LocalContentUriFetchProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mPooledByteBufferFactory, this.mContentResolver);
    }

    public LocalContentUriThumbnailFetchProducer newLocalContentUriThumbnailFetchProducer() {
        return new LocalContentUriThumbnailFetchProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mPooledByteBufferFactory, this.mContentResolver);
    }

    public LocalExifThumbnailProducer newLocalExifThumbnailProducer() {
        return new LocalExifThumbnailProducer(this.mExecutorSupplier.forThumbnailProducer(), this.mPooledByteBufferFactory, this.mContentResolver);
    }

    public ThumbnailBranchProducer newThumbnailBranchProducer(ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        return new ThumbnailBranchProducer(thumbnailProducerArr);
    }

    public LocalFileFetchProducer newLocalFileFetchProducer() {
        return new LocalFileFetchProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mPooledByteBufferFactory);
    }

    public QualifiedResourceFetchProducer newQualifiedResourceFetchProducer() {
        return new QualifiedResourceFetchProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mPooledByteBufferFactory, this.mContentResolver);
    }

    public LocalResourceFetchProducer newLocalResourceFetchProducer() {
        return new LocalResourceFetchProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mPooledByteBufferFactory, this.mResources);
    }

    public LocalVideoThumbnailProducer newLocalVideoThumbnailProducer() {
        return new LocalVideoThumbnailProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mContentResolver);
    }

    public Producer<EncodedImage> newNetworkFetchProducer(NetworkFetcher networkFetcher) {
        return new NetworkFetchProducer(this.mPooledByteBufferFactory, this.mByteArrayPool, networkFetcher);
    }

    public PostprocessedBitmapMemoryCacheProducer newPostprocessorBitmapMemoryCacheProducer(Producer<CloseableReference<CloseableImage>> producer) {
        return new PostprocessedBitmapMemoryCacheProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, producer);
    }

    public PostprocessorProducer newPostprocessorProducer(Producer<CloseableReference<CloseableImage>> producer) {
        return new PostprocessorProducer(producer, this.mPlatformBitmapFactory, this.mExecutorSupplier.getBackgroundExecutor());
    }

    public ResizeAndRotateProducer newResizeAndRotateProducer(Producer<EncodedImage> producer, boolean z, ImageTranscoderFactory imageTranscoderFactory) {
        return new ResizeAndRotateProducer(this.mExecutorSupplier.getBackgroundExecutor(), this.mPooledByteBufferFactory, producer, z, imageTranscoderFactory);
    }

    public <T> SwallowResultProducer<T> newSwallowResultProducer(Producer<T> producer) {
        return new SwallowResultProducer<>(producer);
    }

    public <T> Producer<T> newBackgroundThreadHandoffProducer(Producer<T> producer, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        return new ThreadHandoffProducer(producer, threadHandoffProducerQueue);
    }

    public <T> ThrottlingProducer<T> newThrottlingProducer(Producer<T> producer) {
        return new ThrottlingProducer<>(5, this.mExecutorSupplier.getLightWeightBackgroundExecutor(), producer);
    }

    public WebpTranscodeProducer newWebpTranscodeProducer(Producer<EncodedImage> producer) {
        return new WebpTranscodeProducer(this.mExecutorSupplier.getBackgroundExecutor(), this.mPooledByteBufferFactory, producer);
    }

    public BitmapPrepareProducer newBitmapPrepareProducer(Producer<CloseableReference<CloseableImage>> producer) {
        return new BitmapPrepareProducer(producer, this.mBitmapPrepareToDrawMinSizeBytes, this.mBitmapPrepareToDrawMaxSizeBytes, this.mBitmapPrepareToDrawForPrefetch);
    }

    public DelayProducer newDelayProducer(Producer<CloseableReference<CloseableImage>> producer) {
        return new DelayProducer(producer, this.mExecutorSupplier.getBackgroundScheduledExecutorService());
    }

    public LocalThumbnailBitmapProducer newLocalThumbnailBitmapProducer() {
        return new LocalThumbnailBitmapProducer(this.mExecutorSupplier.getBackgroundExecutor(), this.mContentResolver);
    }
}
