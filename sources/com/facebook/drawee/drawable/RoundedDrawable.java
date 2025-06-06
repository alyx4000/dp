package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class RoundedDrawable extends Drawable implements Rounded, TransformAwareDrawable {
    private final Drawable mDelegate;
    RectF mInsideBorderBounds;
    float[] mInsideBorderRadii;
    Matrix mInsideBorderTransform;
    Matrix mPrevInsideBorderTransform;
    private TransformCallback mTransformCallback;
    protected boolean mIsCircle = false;
    protected boolean mRadiiNonZero = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean mIsShaderTransformDirty = true;
    protected int mBorderColor = 0;
    protected final Path mBorderPath = new Path();
    private final float[] mCornerRadii = new float[8];
    final float[] mBorderRadii = new float[8];
    final RectF mRootBounds = new RectF();
    final RectF mPrevRootBounds = new RectF();
    final RectF mBitmapBounds = new RectF();
    final RectF mDrawableBounds = new RectF();
    final Matrix mBoundsTransform = new Matrix();
    final Matrix mPrevBoundsTransform = new Matrix();
    final Matrix mParentTransform = new Matrix();
    final Matrix mPrevParentTransform = new Matrix();
    final Matrix mInverseParentTransform = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mPadding = 0.0f;
    private boolean mScaleDownInsideBorders = false;
    private boolean mPaintFilterBitmap = false;
    private boolean mIsPathDirty = true;

    public void setRepeatEdgePixels(boolean z) {
    }

    RoundedDrawable(Drawable drawable) {
        this.mDelegate = drawable;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setCircle(boolean z) {
        this.mIsCircle = z;
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean isCircle() {
        return this.mIsCircle;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadius(float f) {
        Preconditions.checkState(f >= 0.0f);
        Arrays.fill(this.mCornerRadii, f);
        this.mRadiiNonZero = f != 0.0f;
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadii(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.mCornerRadii, 0.0f);
            this.mRadiiNonZero = false;
        } else {
            Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.mCornerRadii, 0, 8);
            this.mRadiiNonZero = false;
            for (int i = 0; i < 8; i++) {
                this.mRadiiNonZero |= fArr[i] > 0.0f;
            }
        }
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float[] getRadii() {
        return this.mCornerRadii;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setBorder(int i, float f) {
        if (this.mBorderColor == i && this.mBorderWidth == f) {
            return;
        }
        this.mBorderColor = i;
        this.mBorderWidth = f;
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public int getBorderColor() {
        return this.mBorderColor;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPadding(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.mIsPathDirty = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getPadding() {
        return this.mPadding;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setScaleDownInsideBorders(boolean z) {
        if (this.mScaleDownInsideBorders != z) {
            this.mScaleDownInsideBorders = z;
            this.mIsPathDirty = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getScaleDownInsideBorders() {
        return this.mScaleDownInsideBorders;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPaintFilterBitmap(boolean z) {
        if (this.mPaintFilterBitmap != z) {
            this.mPaintFilterBitmap = z;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getPaintFilterBitmap() {
        return this.mPaintFilterBitmap;
    }

    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public void setTransformCallback(TransformCallback transformCallback) {
        this.mTransformCallback = transformCallback;
    }

    protected void updateTransform() {
        Matrix matrix;
        TransformCallback transformCallback = this.mTransformCallback;
        if (transformCallback != null) {
            transformCallback.getTransform(this.mParentTransform);
            this.mTransformCallback.getRootBounds(this.mRootBounds);
        } else {
            this.mParentTransform.reset();
            this.mRootBounds.set(getBounds());
        }
        this.mBitmapBounds.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.mDrawableBounds.set(this.mDelegate.getBounds());
        this.mBoundsTransform.setRectToRect(this.mBitmapBounds, this.mDrawableBounds, Matrix.ScaleToFit.FILL);
        if (this.mScaleDownInsideBorders) {
            RectF rectF = this.mInsideBorderBounds;
            if (rectF == null) {
                this.mInsideBorderBounds = new RectF(this.mRootBounds);
            } else {
                rectF.set(this.mRootBounds);
            }
            RectF rectF2 = this.mInsideBorderBounds;
            float f = this.mBorderWidth;
            rectF2.inset(f, f);
            if (this.mInsideBorderTransform == null) {
                this.mInsideBorderTransform = new Matrix();
            }
            this.mInsideBorderTransform.setRectToRect(this.mRootBounds, this.mInsideBorderBounds, Matrix.ScaleToFit.FILL);
        } else {
            Matrix matrix2 = this.mInsideBorderTransform;
            if (matrix2 != null) {
                matrix2.reset();
            }
        }
        if (!this.mParentTransform.equals(this.mPrevParentTransform) || !this.mBoundsTransform.equals(this.mPrevBoundsTransform) || ((matrix = this.mInsideBorderTransform) != null && !matrix.equals(this.mPrevInsideBorderTransform))) {
            this.mIsShaderTransformDirty = true;
            this.mParentTransform.invert(this.mInverseParentTransform);
            this.mTransform.set(this.mParentTransform);
            if (this.mScaleDownInsideBorders) {
                this.mTransform.postConcat(this.mInsideBorderTransform);
            }
            this.mTransform.preConcat(this.mBoundsTransform);
            this.mPrevParentTransform.set(this.mParentTransform);
            this.mPrevBoundsTransform.set(this.mBoundsTransform);
            if (this.mScaleDownInsideBorders) {
                Matrix matrix3 = this.mPrevInsideBorderTransform;
                if (matrix3 == null) {
                    this.mPrevInsideBorderTransform = new Matrix(this.mInsideBorderTransform);
                } else {
                    matrix3.set(this.mInsideBorderTransform);
                }
            } else {
                Matrix matrix4 = this.mPrevInsideBorderTransform;
                if (matrix4 != null) {
                    matrix4.reset();
                }
            }
        }
        if (this.mRootBounds.equals(this.mPrevRootBounds)) {
            return;
        }
        this.mIsPathDirty = true;
        this.mPrevRootBounds.set(this.mRootBounds);
    }

    protected void updatePath() {
        float[] fArr;
        if (this.mIsPathDirty) {
            this.mBorderPath.reset();
            RectF rectF = this.mRootBounds;
            float f = this.mBorderWidth;
            rectF.inset(f / 2.0f, f / 2.0f);
            if (this.mIsCircle) {
                this.mBorderPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0f, Path.Direction.CW);
            } else {
                int i = 0;
                while (true) {
                    fArr = this.mBorderRadii;
                    if (i >= fArr.length) {
                        break;
                    }
                    fArr[i] = (this.mCornerRadii[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                    i++;
                }
                this.mBorderPath.addRoundRect(this.mRootBounds, fArr, Path.Direction.CW);
            }
            RectF rectF2 = this.mRootBounds;
            float f2 = this.mBorderWidth;
            rectF2.inset((-f2) / 2.0f, (-f2) / 2.0f);
            this.mPath.reset();
            float f3 = this.mPadding + (this.mScaleDownInsideBorders ? this.mBorderWidth : 0.0f);
            this.mRootBounds.inset(f3, f3);
            if (this.mIsCircle) {
                this.mPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0f, Path.Direction.CW);
            } else if (this.mScaleDownInsideBorders) {
                if (this.mInsideBorderRadii == null) {
                    this.mInsideBorderRadii = new float[8];
                }
                for (int i2 = 0; i2 < this.mBorderRadii.length; i2++) {
                    this.mInsideBorderRadii[i2] = this.mCornerRadii[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.mRootBounds, this.mInsideBorderRadii, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.mRootBounds, this.mCornerRadii, Path.Direction.CW);
            }
            float f4 = -f3;
            this.mRootBounds.inset(f4, f4);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.mIsPathDirty = false;
        }
    }

    boolean shouldRound() {
        return this.mIsCircle || this.mRadiiNonZero || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.mDelegate.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mDelegate.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mDelegate.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mDelegate.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, PorterDuff.Mode mode) {
        this.mDelegate.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mDelegate.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mDelegate.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.mDelegate.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mDelegate.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mDelegate.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("RoundedDrawable#draw");
        }
        this.mDelegate.draw(canvas);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }
}
