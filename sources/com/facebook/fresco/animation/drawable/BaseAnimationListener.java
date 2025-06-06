package com.facebook.fresco.animation.drawable;

import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.drawable.AnimationListener;
import com.iterable.iterableapi.IterableConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseAnimationListener.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"Lcom/facebook/fresco/animation/drawable/BaseAnimationListener;", "Lcom/facebook/fresco/animation/drawable/AnimationListener;", "()V", "onAnimationFrame", "", IterableConstants.ICON_FOLDER_IDENTIFIER, "Landroid/graphics/drawable/Drawable;", "frameNumber", "", "onAnimationRepeat", "onAnimationReset", "onAnimationStart", "onAnimationStop", "animated-drawable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public class BaseAnimationListener implements AnimationListener {
    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public void onAnimationFrame(Drawable drawable, int frameNumber) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public void onAnimationRepeat(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public void onAnimationReset(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public void onAnimationStart(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public void onAnimationStop(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public void onAnimationLoaded() {
        AnimationListener.DefaultImpls.onAnimationLoaded(this);
    }
}
