package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArtBitmapFactory.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/imagepipeline/bitmaps/ArtBitmapFactory;", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "bitmapPool", "Lcom/facebook/imagepipeline/memory/BitmapPool;", "closeableReferenceFactory", "Lcom/facebook/imagepipeline/core/CloseableReferenceFactory;", "(Lcom/facebook/imagepipeline/memory/BitmapPool;Lcom/facebook/imagepipeline/core/CloseableReferenceFactory;)V", "createBitmapInternal", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "width", "", "height", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArtBitmapFactory extends PlatformBitmapFactory {
    private final BitmapPool bitmapPool;
    private final CloseableReferenceFactory closeableReferenceFactory;

    public ArtBitmapFactory(BitmapPool bitmapPool, CloseableReferenceFactory closeableReferenceFactory) {
        Intrinsics.checkNotNullParameter(bitmapPool, "bitmapPool");
        Intrinsics.checkNotNullParameter(closeableReferenceFactory, "closeableReferenceFactory");
        this.bitmapPool = bitmapPool;
        this.closeableReferenceFactory = closeableReferenceFactory;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public CloseableReference<Bitmap> createBitmapInternal(int width, int height, Bitmap.Config bitmapConfig) {
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        Bitmap bitmap = this.bitmapPool.get(BitmapUtil.getSizeInByteForBitmap(width, height, bitmapConfig));
        if (!(bitmap.getAllocationByteCount() >= (width * height) * BitmapUtil.getPixelSizeForBitmapConfig(bitmapConfig))) {
            throw new IllegalStateException("Check failed.".toString());
        }
        bitmap.reconfigure(width, height, bitmapConfig);
        CloseableReference<Bitmap> create = this.closeableReferenceFactory.create(bitmap, this.bitmapPool);
        Intrinsics.checkNotNullExpressionValue(create, "closeableReferenceFactor…reate(bitmap, bitmapPool)");
        return create;
    }
}
