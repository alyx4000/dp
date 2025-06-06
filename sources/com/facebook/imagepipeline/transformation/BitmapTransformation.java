package com.facebook.imagepipeline.transformation;

import android.graphics.Bitmap;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* compiled from: BitmapTransformation.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/facebook/imagepipeline/transformation/BitmapTransformation;", "", "modifiesTransparency", "", ViewProps.TRANSFORM, "", "bitmap", "Landroid/graphics/Bitmap;", "imagepipeline-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface BitmapTransformation {
    boolean modifiesTransparency();

    void transform(Bitmap bitmap);
}
