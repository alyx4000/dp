package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class ScalingUtils {

    public interface ScaleType {
        public static final ScaleType FIT_XY = ScaleTypeFitXY.INSTANCE;
        public static final ScaleType FIT_X = ScaleTypeFitX.INSTANCE;
        public static final ScaleType FIT_Y = ScaleTypeFitY.INSTANCE;
        public static final ScaleType FIT_START = ScaleTypeFitStart.INSTANCE;
        public static final ScaleType FIT_CENTER = ScaleTypeFitCenter.INSTANCE;
        public static final ScaleType FIT_END = ScaleTypeFitEnd.INSTANCE;
        public static final ScaleType CENTER = ScaleTypeCenter.INSTANCE;
        public static final ScaleType CENTER_INSIDE = ScaleTypeCenterInside.INSTANCE;
        public static final ScaleType CENTER_CROP = ScaleTypeCenterCrop.INSTANCE;
        public static final ScaleType FOCUS_CROP = ScaleTypeFocusCrop.INSTANCE;
        public static final ScaleType FIT_BOTTOM_START = ScaleTypeFitBottomStart.INSTANCE;

        Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2);
    }

    public interface StatefulScaleType {
        Object getState();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static ScaleTypeDrawable getActiveScaleTypeDrawable(@Nullable Drawable drawable) {
        if (drawable == 0) {
            return null;
        }
        if (drawable instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) drawable;
        }
        if (drawable instanceof DrawableParent) {
            return getActiveScaleTypeDrawable(((DrawableParent) drawable).getDrawable());
        }
        if (drawable instanceof ArrayDrawable) {
            ArrayDrawable arrayDrawable = (ArrayDrawable) drawable;
            int numberOfLayers = arrayDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                ScaleTypeDrawable activeScaleTypeDrawable = getActiveScaleTypeDrawable(arrayDrawable.getDrawable(i));
                if (activeScaleTypeDrawable != null) {
                    return activeScaleTypeDrawable;
                }
            }
        }
        return null;
    }

    /* renamed from: com.facebook.drawee.drawable.ScalingUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Nullable
    public static ScaleType convertFromImageViewScaleType(ImageView.ScaleType scaleType) {
        switch (AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[scaleType.ordinal()]) {
            case 1:
                return ScaleType.CENTER;
            case 2:
                return ScaleType.CENTER_CROP;
            case 3:
                return ScaleType.CENTER_INSIDE;
            case 4:
                return ScaleType.FIT_CENTER;
            case 5:
                return ScaleType.FIT_START;
            case 6:
                return ScaleType.FIT_END;
            case 7:
                return ScaleType.FIT_XY;
            default:
                return null;
        }
    }

    public static abstract class AbstractScaleType implements ScaleType {
        public abstract void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4);

        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
            getTransformImpl(matrix, rect, i, i2, f, f2, rect.width() / i, rect.height() / i2);
            return matrix;
        }
    }

    private static class ScaleTypeFitXY extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitXY();

        public String toString() {
            return "fit_xy";
        }

        private ScaleTypeFitXY() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float f5 = rect.left;
            float f6 = rect.top;
            matrix.setScale(f3, f4);
            matrix.postTranslate((int) (f5 + 0.5f), (int) (f6 + 0.5f));
        }
    }

    private static class ScaleTypeFitStart extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitStart();

        public String toString() {
            return "fit_start";
        }

        private ScaleTypeFitStart() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float min = Math.min(f3, f4);
            float f5 = rect.left;
            float f6 = rect.top;
            matrix.setScale(min, min);
            matrix.postTranslate((int) (f5 + 0.5f), (int) (f6 + 0.5f));
        }
    }

    private static class ScaleTypeFitBottomStart extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitBottomStart();

        public String toString() {
            return "fit_bottom_start";
        }

        private ScaleTypeFitBottomStart() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float min = Math.min(f3, f4);
            float f5 = rect.left;
            float height = rect.top + (rect.height() - (i2 * min));
            matrix.setScale(min, min);
            matrix.postTranslate((int) (f5 + 0.5f), (int) (height + 0.5f));
        }
    }

    private static class ScaleTypeFitCenter extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitCenter();

        public String toString() {
            return "fit_center";
        }

        private ScaleTypeFitCenter() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float min = Math.min(f3, f4);
            float width = rect.left + ((rect.width() - (i * min)) * 0.5f);
            float height = rect.top + ((rect.height() - (i2 * min)) * 0.5f);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (width + 0.5f), (int) (height + 0.5f));
        }
    }

    private static class ScaleTypeFitEnd extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitEnd();

        public String toString() {
            return "fit_end";
        }

        private ScaleTypeFitEnd() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float min = Math.min(f3, f4);
            float width = rect.left + (rect.width() - (i * min));
            float height = rect.top + (rect.height() - (i2 * min));
            matrix.setScale(min, min);
            matrix.postTranslate((int) (width + 0.5f), (int) (height + 0.5f));
        }
    }

    private static class ScaleTypeCenter extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeCenter();

        public String toString() {
            return "center";
        }

        private ScaleTypeCenter() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            matrix.setTranslate((int) (rect.left + ((rect.width() - i) * 0.5f) + 0.5f), (int) (rect.top + ((rect.height() - i2) * 0.5f) + 0.5f));
        }
    }

    private static class ScaleTypeCenterInside extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeCenterInside();

        public String toString() {
            return "center_inside";
        }

        private ScaleTypeCenterInside() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float min = Math.min(Math.min(f3, f4), 1.0f);
            float width = rect.left + ((rect.width() - (i * min)) * 0.5f);
            float height = rect.top + ((rect.height() - (i2 * min)) * 0.5f);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (width + 0.5f), (int) (height + 0.5f));
        }
    }

    private static class ScaleTypeCenterCrop extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeCenterCrop();

        public String toString() {
            return "center_crop";
        }

        private ScaleTypeCenterCrop() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float height;
            float f5;
            if (f4 > f3) {
                f5 = rect.left + ((rect.width() - (i * f4)) * 0.5f);
                height = rect.top;
                f3 = f4;
            } else {
                float f6 = rect.left;
                height = ((rect.height() - (i2 * f3)) * 0.5f) + rect.top;
                f5 = f6;
            }
            matrix.setScale(f3, f3);
            matrix.postTranslate((int) (f5 + 0.5f), (int) (height + 0.5f));
        }
    }

    private static class ScaleTypeFocusCrop extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFocusCrop();

        public String toString() {
            return "focus_crop";
        }

        private ScaleTypeFocusCrop() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float f5;
            float max;
            if (f4 > f3) {
                float f6 = i * f4;
                f5 = rect.left + Math.max(Math.min((rect.width() * 0.5f) - (f * f6), 0.0f), rect.width() - f6);
                max = rect.top;
                f3 = f4;
            } else {
                f5 = rect.left;
                float f7 = i2 * f3;
                max = Math.max(Math.min((rect.height() * 0.5f) - (f2 * f7), 0.0f), rect.height() - f7) + rect.top;
            }
            matrix.setScale(f3, f3);
            matrix.postTranslate((int) (f5 + 0.5f), (int) (max + 0.5f));
        }
    }

    private static class ScaleTypeFitX extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitX();

        public String toString() {
            return "fit_x";
        }

        private ScaleTypeFitX() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float f5 = rect.left;
            float height = rect.top + ((rect.height() - (i2 * f3)) * 0.5f);
            matrix.setScale(f3, f3);
            matrix.postTranslate((int) (f5 + 0.5f), (int) (height + 0.5f));
        }
    }

    private static class ScaleTypeFitY extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitY();

        public String toString() {
            return "fit_y";
        }

        private ScaleTypeFitY() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float width = rect.left + ((rect.width() - (i * f4)) * 0.5f);
            float f5 = rect.top;
            matrix.setScale(f4, f4);
            matrix.postTranslate((int) (width + 0.5f), (int) (f5 + 0.5f));
        }
    }

    public static class InterpolatingScaleType implements ScaleType, StatefulScaleType {

        @Nullable
        private final Rect mBoundsFrom;

        @Nullable
        private final Rect mBoundsTo;

        @Nullable
        private final PointF mFocusPointFrom;

        @Nullable
        private final PointF mFocusPointTo;
        private float mInterpolatingValue;
        private final float[] mMatrixValuesFrom;
        private final float[] mMatrixValuesInterpolated;
        private final float[] mMatrixValuesTo;
        private final ScaleType mScaleTypeFrom;
        private final ScaleType mScaleTypeTo;

        public InterpolatingScaleType(ScaleType scaleType, ScaleType scaleType2, @Nullable Rect rect, @Nullable Rect rect2, @Nullable PointF pointF, @Nullable PointF pointF2) {
            this.mMatrixValuesFrom = new float[9];
            this.mMatrixValuesTo = new float[9];
            this.mMatrixValuesInterpolated = new float[9];
            this.mScaleTypeFrom = scaleType;
            this.mScaleTypeTo = scaleType2;
            this.mBoundsFrom = rect;
            this.mBoundsTo = rect2;
            this.mFocusPointFrom = pointF;
            this.mFocusPointTo = pointF2;
        }

        public InterpolatingScaleType(ScaleType scaleType, ScaleType scaleType2, @Nullable Rect rect, @Nullable Rect rect2) {
            this(scaleType, scaleType2, rect, rect2, null, null);
        }

        public InterpolatingScaleType(ScaleType scaleType, ScaleType scaleType2) {
            this(scaleType, scaleType2, null, null);
        }

        public ScaleType getScaleTypeFrom() {
            return this.mScaleTypeFrom;
        }

        public ScaleType getScaleTypeTo() {
            return this.mScaleTypeTo;
        }

        @Nullable
        public Rect getBoundsFrom() {
            return this.mBoundsFrom;
        }

        @Nullable
        public Rect getBoundsTo() {
            return this.mBoundsTo;
        }

        @Nullable
        public PointF getFocusPointFrom() {
            return this.mFocusPointFrom;
        }

        @Nullable
        public PointF getFocusPointTo() {
            return this.mFocusPointTo;
        }

        public void setValue(float f) {
            this.mInterpolatingValue = f;
        }

        public float getValue() {
            return this.mInterpolatingValue;
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.StatefulScaleType
        public Object getState() {
            return Float.valueOf(this.mInterpolatingValue);
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
            Rect rect2 = this.mBoundsFrom;
            Rect rect3 = rect2 != null ? rect2 : rect;
            Rect rect4 = this.mBoundsTo;
            Rect rect5 = rect4 != null ? rect4 : rect;
            ScaleType scaleType = this.mScaleTypeFrom;
            PointF pointF = this.mFocusPointFrom;
            float f3 = pointF == null ? f : pointF.x;
            PointF pointF2 = this.mFocusPointFrom;
            scaleType.getTransform(matrix, rect3, i, i2, f3, pointF2 == null ? f2 : pointF2.y);
            matrix.getValues(this.mMatrixValuesFrom);
            ScaleType scaleType2 = this.mScaleTypeTo;
            PointF pointF3 = this.mFocusPointTo;
            float f4 = pointF3 == null ? f : pointF3.x;
            PointF pointF4 = this.mFocusPointTo;
            scaleType2.getTransform(matrix, rect5, i, i2, f4, pointF4 == null ? f2 : pointF4.y);
            matrix.getValues(this.mMatrixValuesTo);
            for (int i3 = 0; i3 < 9; i3++) {
                float[] fArr = this.mMatrixValuesInterpolated;
                float f5 = this.mMatrixValuesFrom[i3];
                float f6 = this.mInterpolatingValue;
                fArr[i3] = (f5 * (1.0f - f6)) + (this.mMatrixValuesTo[i3] * f6);
            }
            matrix.setValues(this.mMatrixValuesInterpolated);
            return matrix;
        }

        public String toString() {
            return String.format("InterpolatingScaleType(%s (%s) -> %s (%s))", String.valueOf(this.mScaleTypeFrom), String.valueOf(this.mFocusPointFrom), String.valueOf(this.mScaleTypeTo), String.valueOf(this.mFocusPointTo));
        }
    }
}
