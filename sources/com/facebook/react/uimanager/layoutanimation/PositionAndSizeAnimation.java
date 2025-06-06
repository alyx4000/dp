package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: classes3.dex */
class PositionAndSizeAnimation extends Animation implements LayoutHandlingAnimation {
    private int mDeltaHeight;
    private int mDeltaWidth;
    private float mDeltaX;
    private float mDeltaY;
    private int mStartHeight;
    private int mStartWidth;
    private float mStartX;
    private float mStartY;
    private final View mView;

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return true;
    }

    public PositionAndSizeAnimation(View view, int i, int i2, int i3, int i4) {
        this.mView = view;
        calculateAnimation(i, i2, i3, i4);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.mStartX + (this.mDeltaX * f);
        float f3 = this.mStartY + (this.mDeltaY * f);
        this.mView.layout(Math.round(f2), Math.round(f3), Math.round(f2 + this.mStartWidth + (this.mDeltaWidth * f)), Math.round(f3 + this.mStartHeight + (this.mDeltaHeight * f)));
    }

    @Override // com.facebook.react.uimanager.layoutanimation.LayoutHandlingAnimation
    public void onLayoutUpdate(int i, int i2, int i3, int i4) {
        calculateAnimation(i, i2, i3, i4);
    }

    private void calculateAnimation(int i, int i2, int i3, int i4) {
        this.mStartX = this.mView.getX() - this.mView.getTranslationX();
        this.mStartY = this.mView.getY() - this.mView.getTranslationY();
        this.mStartWidth = this.mView.getWidth();
        int height = this.mView.getHeight();
        this.mStartHeight = height;
        this.mDeltaX = i - this.mStartX;
        this.mDeltaY = i2 - this.mStartY;
        this.mDeltaWidth = i3 - this.mStartWidth;
        this.mDeltaHeight = i4 - height;
    }
}
