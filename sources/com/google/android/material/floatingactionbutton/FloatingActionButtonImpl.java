package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
class FloatingActionButtonImpl {
    static final int ANIM_STATE_HIDING = 1;
    static final int ANIM_STATE_NONE = 0;
    static final int ANIM_STATE_SHOWING = 2;
    static final long ELEVATION_ANIM_DELAY = 100;
    static final long ELEVATION_ANIM_DURATION = 100;
    private static final float HIDE_ICON_SCALE = 0.4f;
    private static final float HIDE_OPACITY = 0.0f;
    private static final float HIDE_SCALE = 0.4f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    private static final float SHOW_ICON_SCALE = 1.0f;
    private static final float SHOW_OPACITY = 1.0f;
    private static final float SHOW_SCALE = 1.0f;
    private static final float SPEC_HIDE_ICON_SCALE = 0.0f;
    private static final float SPEC_HIDE_SCALE = 0.0f;
    BorderDrawable borderDrawable;
    Drawable contentBackground;
    private Animator currentAnimator;
    float elevation;
    boolean ensureMinTouchTargetSize;
    private ArrayList<Animator.AnimatorListener> hideListeners;
    private MotionSpec hideMotionSpec;
    float hoveredFocusedTranslationZ;
    private int maxImageSize;
    int minTouchTargetSize;
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    float pressedTranslationZ;
    Drawable rippleDrawable;
    private float rotation;
    final ShadowViewDelegate shadowViewDelegate;
    ShapeAppearanceModel shapeAppearance;
    MaterialShapeDrawable shapeDrawable;
    private ArrayList<Animator.AnimatorListener> showListeners;
    private MotionSpec showMotionSpec;
    private final StateListAnimator stateListAnimator;
    private ArrayList<InternalTransformationCallback> transformationCallbacks;
    final FloatingActionButton view;
    static final TimeInterpolator ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    private static final int SHOW_ANIM_DURATION_ATTR = R.attr.motionDurationLong2;
    private static final int SHOW_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
    private static final int HIDE_ANIM_DURATION_ATTR = R.attr.motionDurationMedium1;
    private static final int HIDE_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedAccelerateInterpolator;
    static final int[] PRESSED_ENABLED_STATE_SET = {android.R.attr.state_pressed, android.R.attr.state_enabled};
    static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET = {android.R.attr.state_hovered, android.R.attr.state_focused, android.R.attr.state_enabled};
    static final int[] FOCUSED_ENABLED_STATE_SET = {android.R.attr.state_focused, android.R.attr.state_enabled};
    static final int[] HOVERED_ENABLED_STATE_SET = {android.R.attr.state_hovered, android.R.attr.state_enabled};
    static final int[] ENABLED_STATE_SET = {android.R.attr.state_enabled};
    static final int[] EMPTY_STATE_SET = new int[0];
    boolean shadowPaddingEnabled = true;
    private float imageMatrixScale = 1.0f;
    private int animState = 0;
    private final Rect tmpRect = new Rect();
    private final RectF tmpRectF1 = new RectF();
    private final RectF tmpRectF2 = new RectF();
    private final Matrix tmpMatrix = new Matrix();

    interface InternalTransformationCallback {
        void onScaleChanged();

        void onTranslationChanged();
    }

    interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    void onCompatShadowChanged() {
    }

    boolean requirePreDrawListener() {
        return true;
    }

    boolean shouldAddPadding() {
        return true;
    }

    FloatingActionButtonImpl(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        this.view = floatingActionButton;
        this.shadowViewDelegate = shadowViewDelegate;
        StateListAnimator stateListAnimator = new StateListAnimator();
        this.stateListAnimator = stateListAnimator;
        stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToPressedTranslationZAnimation()));
        stateListAnimator.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.addState(ENABLED_STATE_SET, createElevationAnimator(new ResetElevationAnimation()));
        stateListAnimator.addState(EMPTY_STATE_SET, createElevationAnimator(new DisabledElevationAnimation()));
        this.rotation = floatingActionButton.getRotation();
    }

    void initializeBackgroundDrawable(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        MaterialShapeDrawable createShapeDrawable = createShapeDrawable();
        this.shapeDrawable = createShapeDrawable;
        createShapeDrawable.setTintList(colorStateList);
        if (mode != null) {
            this.shapeDrawable.setTintMode(mode);
        }
        this.shapeDrawable.setShadowColor(-12303292);
        this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
        RippleDrawableCompat rippleDrawableCompat = new RippleDrawableCompat(this.shapeDrawable.getShapeAppearanceModel());
        rippleDrawableCompat.setTintList(RippleUtils.sanitizeRippleDrawableColor(colorStateList2));
        this.rippleDrawable = rippleDrawableCompat;
        this.contentBackground = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.shapeDrawable), rippleDrawableCompat});
    }

    void setBackgroundTintList(ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintList(colorStateList);
        }
        BorderDrawable borderDrawable = this.borderDrawable;
        if (borderDrawable != null) {
            borderDrawable.setBorderTint(colorStateList);
        }
    }

    void setBackgroundTintMode(PorterDuff.Mode mode) {
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintMode(mode);
        }
    }

    void setMinTouchTargetSize(int i) {
        this.minTouchTargetSize = i;
    }

    void setRippleColor(ColorStateList colorStateList) {
        Drawable drawable = this.rippleDrawable;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        }
    }

    final void setElevation(float f) {
        if (this.elevation != f) {
            this.elevation = f;
            onElevationsChanged(f, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
        }
    }

    float getElevation() {
        return this.elevation;
    }

    float getHoveredFocusedTranslationZ() {
        return this.hoveredFocusedTranslationZ;
    }

    float getPressedTranslationZ() {
        return this.pressedTranslationZ;
    }

    final void setHoveredFocusedTranslationZ(float f) {
        if (this.hoveredFocusedTranslationZ != f) {
            this.hoveredFocusedTranslationZ = f;
            onElevationsChanged(this.elevation, f, this.pressedTranslationZ);
        }
    }

    final void setPressedTranslationZ(float f) {
        if (this.pressedTranslationZ != f) {
            this.pressedTranslationZ = f;
            onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, f);
        }
    }

    final void setMaxImageSize(int i) {
        if (this.maxImageSize != i) {
            this.maxImageSize = i;
            updateImageMatrixScale();
        }
    }

    final void updateImageMatrixScale() {
        setImageMatrixScale(this.imageMatrixScale);
    }

    final void setImageMatrixScale(float f) {
        this.imageMatrixScale = f;
        Matrix matrix = this.tmpMatrix;
        calculateImageMatrixFromScale(f, matrix);
        this.view.setImageMatrix(matrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculateImageMatrixFromScale(float f, Matrix matrix) {
        matrix.reset();
        if (this.view.getDrawable() == null || this.maxImageSize == 0) {
            return;
        }
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i = this.maxImageSize;
        rectF2.set(0.0f, 0.0f, i, i);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i2 = this.maxImageSize;
        matrix.postScale(f, f, i2 / 2.0f, i2 / 2.0f);
    }

    final void setShapeAppearance(ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearance = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        Object obj = this.rippleDrawable;
        if (obj instanceof Shapeable) {
            ((Shapeable) obj).setShapeAppearanceModel(shapeAppearanceModel);
        }
        BorderDrawable borderDrawable = this.borderDrawable;
        if (borderDrawable != null) {
            borderDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    final ShapeAppearanceModel getShapeAppearance() {
        return this.shapeAppearance;
    }

    final MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    final void setShowMotionSpec(MotionSpec motionSpec) {
        this.showMotionSpec = motionSpec;
    }

    final MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    final void setHideMotionSpec(MotionSpec motionSpec) {
        this.hideMotionSpec = motionSpec;
    }

    final boolean shouldExpandBoundsForA11y() {
        return !this.ensureMinTouchTargetSize || this.view.getSizeDimension() >= this.minTouchTargetSize;
    }

    boolean getEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }

    void setEnsureMinTouchTargetSize(boolean z) {
        this.ensureMinTouchTargetSize = z;
    }

    void setShadowPaddingEnabled(boolean z) {
        this.shadowPaddingEnabled = z;
        updatePadding();
    }

    void onElevationsChanged(float f, float f2, float f3) {
        updatePadding();
        updateShapeElevation(f);
    }

    void updateShapeElevation(float f) {
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation(f);
        }
    }

    void onDrawableStateChanged(int[] iArr) {
        this.stateListAnimator.setState(iArr);
    }

    void jumpDrawableToCurrentState() {
        this.stateListAnimator.jumpToCurrentState();
    }

    void addOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        if (this.showListeners == null) {
            this.showListeners = new ArrayList<>();
        }
        this.showListeners.add(animatorListener);
    }

    void removeOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.showListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        if (this.hideListeners == null) {
            this.hideListeners = new ArrayList<>();
        }
        this.hideListeners.add(animatorListener);
    }

    public void removeOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.hideListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    void hide(final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z) {
        AnimatorSet createDefaultAnimator;
        if (isOrWillBeHidden()) {
            return;
        }
        Animator animator = this.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
        if (shouldAnimateVisibilityChange()) {
            MotionSpec motionSpec = this.hideMotionSpec;
            if (motionSpec != null) {
                createDefaultAnimator = createAnimator(motionSpec, 0.0f, 0.0f, 0.0f);
            } else {
                createDefaultAnimator = createDefaultAnimator(0.0f, 0.4f, 0.4f, HIDE_ANIM_DURATION_ATTR, HIDE_ANIM_EASING_ATTR);
            }
            createDefaultAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.1
                private boolean cancelled;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    FloatingActionButtonImpl.this.view.internalSetVisibility(0, z);
                    FloatingActionButtonImpl.this.animState = 1;
                    FloatingActionButtonImpl.this.currentAnimator = animator2;
                    this.cancelled = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator2) {
                    this.cancelled = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    FloatingActionButtonImpl.this.animState = 0;
                    FloatingActionButtonImpl.this.currentAnimator = null;
                    if (this.cancelled) {
                        return;
                    }
                    FloatingActionButton floatingActionButton = FloatingActionButtonImpl.this.view;
                    boolean z2 = z;
                    floatingActionButton.internalSetVisibility(z2 ? 8 : 4, z2);
                    InternalVisibilityChangedListener internalVisibilityChangedListener2 = internalVisibilityChangedListener;
                    if (internalVisibilityChangedListener2 != null) {
                        internalVisibilityChangedListener2.onHidden();
                    }
                }
            });
            ArrayList<Animator.AnimatorListener> arrayList = this.hideListeners;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    createDefaultAnimator.addListener(it.next());
                }
            }
            createDefaultAnimator.start();
            return;
        }
        this.view.internalSetVisibility(z ? 8 : 4, z);
        if (internalVisibilityChangedListener != null) {
            internalVisibilityChangedListener.onHidden();
        }
    }

    void show(final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z) {
        AnimatorSet createDefaultAnimator;
        if (isOrWillBeShown()) {
            return;
        }
        Animator animator = this.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
        boolean z2 = this.showMotionSpec == null;
        if (shouldAnimateVisibilityChange()) {
            if (this.view.getVisibility() != 0) {
                this.view.setAlpha(0.0f);
                this.view.setScaleY(z2 ? 0.4f : 0.0f);
                this.view.setScaleX(z2 ? 0.4f : 0.0f);
                setImageMatrixScale(z2 ? 0.4f : 0.0f);
            }
            MotionSpec motionSpec = this.showMotionSpec;
            if (motionSpec != null) {
                createDefaultAnimator = createAnimator(motionSpec, 1.0f, 1.0f, 1.0f);
            } else {
                createDefaultAnimator = createDefaultAnimator(1.0f, 1.0f, 1.0f, SHOW_ANIM_DURATION_ATTR, SHOW_ANIM_EASING_ATTR);
            }
            createDefaultAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    FloatingActionButtonImpl.this.view.internalSetVisibility(0, z);
                    FloatingActionButtonImpl.this.animState = 2;
                    FloatingActionButtonImpl.this.currentAnimator = animator2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    FloatingActionButtonImpl.this.animState = 0;
                    FloatingActionButtonImpl.this.currentAnimator = null;
                    InternalVisibilityChangedListener internalVisibilityChangedListener2 = internalVisibilityChangedListener;
                    if (internalVisibilityChangedListener2 != null) {
                        internalVisibilityChangedListener2.onShown();
                    }
                }
            });
            ArrayList<Animator.AnimatorListener> arrayList = this.showListeners;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    createDefaultAnimator.addListener(it.next());
                }
            }
            createDefaultAnimator.start();
            return;
        }
        this.view.internalSetVisibility(0, z);
        this.view.setAlpha(1.0f);
        this.view.setScaleY(1.0f);
        this.view.setScaleX(1.0f);
        setImageMatrixScale(1.0f);
        if (internalVisibilityChangedListener != null) {
            internalVisibilityChangedListener.onShown();
        }
    }

    private AnimatorSet createAnimator(MotionSpec motionSpec, float f, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.view, (Property<FloatingActionButton, Float>) View.ALPHA, f);
        motionSpec.getTiming(ViewProps.OPACITY).apply(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.view, (Property<FloatingActionButton, Float>) View.SCALE_X, f2);
        motionSpec.getTiming("scale").apply(ofFloat2);
        workAroundOreoBug(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.view, (Property<FloatingActionButton, Float>) View.SCALE_Y, f2);
        motionSpec.getTiming("scale").apply(ofFloat3);
        workAroundOreoBug(ofFloat3);
        arrayList.add(ofFloat3);
        calculateImageMatrixFromScale(f3, this.tmpMatrix);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.view, new ImageMatrixProperty(), new MatrixEvaluator() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.animation.MatrixEvaluator, android.animation.TypeEvaluator
            public Matrix evaluate(float f4, Matrix matrix, Matrix matrix2) {
                FloatingActionButtonImpl.this.imageMatrixScale = f4;
                return super.evaluate(f4, matrix, matrix2);
            }
        }, new Matrix(this.tmpMatrix));
        motionSpec.getTiming("iconScale").apply(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet createDefaultAnimator(final float f, final float f2, final float f3, int i, int i2) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        final float alpha = this.view.getAlpha();
        final float scaleX = this.view.getScaleX();
        final float scaleY = this.view.getScaleY();
        final float f4 = this.imageMatrixScale;
        final Matrix matrix = new Matrix(this.tmpMatrix);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FloatingActionButtonImpl.this.view.setAlpha(AnimationUtils.lerp(alpha, f, 0.0f, 0.2f, floatValue));
                FloatingActionButtonImpl.this.view.setScaleX(AnimationUtils.lerp(scaleX, f2, floatValue));
                FloatingActionButtonImpl.this.view.setScaleY(AnimationUtils.lerp(scaleY, f2, floatValue));
                FloatingActionButtonImpl.this.imageMatrixScale = AnimationUtils.lerp(f4, f3, floatValue);
                FloatingActionButtonImpl.this.calculateImageMatrixFromScale(AnimationUtils.lerp(f4, f3, floatValue), matrix);
                FloatingActionButtonImpl.this.view.setImageMatrix(matrix);
            }
        });
        arrayList.add(ofFloat);
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        animatorSet.setDuration(MotionUtils.resolveThemeDuration(this.view.getContext(), i, this.view.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(MotionUtils.resolveThemeInterpolator(this.view.getContext(), i2, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return animatorSet;
    }

    private void workAroundOreoBug(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new TypeEvaluator<Float>() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.5
            FloatEvaluator floatEvaluator = new FloatEvaluator();

            @Override // android.animation.TypeEvaluator
            public Float evaluate(float f, Float f2, Float f3) {
                float floatValue = this.floatEvaluator.evaluate(f, (Number) f2, (Number) f3).floatValue();
                if (floatValue < 0.1f) {
                    floatValue = 0.0f;
                }
                return Float.valueOf(floatValue);
            }
        });
    }

    void addTransformationCallback(InternalTransformationCallback internalTransformationCallback) {
        if (this.transformationCallbacks == null) {
            this.transformationCallbacks = new ArrayList<>();
        }
        this.transformationCallbacks.add(internalTransformationCallback);
    }

    void removeTransformationCallback(InternalTransformationCallback internalTransformationCallback) {
        ArrayList<InternalTransformationCallback> arrayList = this.transformationCallbacks;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(internalTransformationCallback);
    }

    void onTranslationChanged() {
        ArrayList<InternalTransformationCallback> arrayList = this.transformationCallbacks;
        if (arrayList != null) {
            Iterator<InternalTransformationCallback> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTranslationChanged();
            }
        }
    }

    void onScaleChanged() {
        ArrayList<InternalTransformationCallback> arrayList = this.transformationCallbacks;
        if (arrayList != null) {
            Iterator<InternalTransformationCallback> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onScaleChanged();
            }
        }
    }

    final Drawable getContentBackground() {
        return this.contentBackground;
    }

    final void updatePadding() {
        Rect rect = this.tmpRect;
        getPadding(rect);
        onPaddingUpdated(rect);
        this.shadowViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    void getPadding(Rect rect) {
        int sizeDimension = this.ensureMinTouchTargetSize ? (this.minTouchTargetSize - this.view.getSizeDimension()) / 2 : 0;
        int max = Math.max(sizeDimension, (int) Math.ceil(this.shadowPaddingEnabled ? getElevation() + this.pressedTranslationZ : 0.0f));
        int max2 = Math.max(sizeDimension, (int) Math.ceil(r1 * SHADOW_MULTIPLIER));
        rect.set(max, max2, max, max2);
    }

    void onPaddingUpdated(Rect rect) {
        Preconditions.checkNotNull(this.contentBackground, "Didn't initialize content background");
        if (shouldAddPadding()) {
            this.shadowViewDelegate.setBackgroundDrawable(new InsetDrawable(this.contentBackground, rect.left, rect.top, rect.right, rect.bottom));
        } else {
            this.shadowViewDelegate.setBackgroundDrawable(this.contentBackground);
        }
    }

    void onAttachedToWindow() {
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            MaterialShapeUtils.setParentAbsoluteElevation(this.view, materialShapeDrawable);
        }
        if (requirePreDrawListener()) {
            this.view.getViewTreeObserver().addOnPreDrawListener(getOrCreatePreDrawListener());
        }
    }

    void onDetachedFromWindow() {
        ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.preDrawListener;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.preDrawListener = null;
        }
    }

    void onPreDraw() {
        float rotation = this.view.getRotation();
        if (this.rotation != rotation) {
            this.rotation = rotation;
            updateFromViewRotation();
        }
    }

    private ViewTreeObserver.OnPreDrawListener getOrCreatePreDrawListener() {
        if (this.preDrawListener == null) {
            this.preDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.6
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    FloatingActionButtonImpl.this.onPreDraw();
                    return true;
                }
            };
        }
        return this.preDrawListener;
    }

    MaterialShapeDrawable createShapeDrawable() {
        return new MaterialShapeDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
    }

    boolean isOrWillBeShown() {
        return this.view.getVisibility() != 0 ? this.animState == 2 : this.animState != 1;
    }

    boolean isOrWillBeHidden() {
        return this.view.getVisibility() == 0 ? this.animState == 1 : this.animState != 2;
    }

    private ValueAnimator createElevationAnimator(ShadowAnimatorImpl shadowAnimatorImpl) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(shadowAnimatorImpl);
        valueAnimator.addUpdateListener(shadowAnimatorImpl);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private float shadowSizeEnd;
        private float shadowSizeStart;
        private boolean validValues;

        protected abstract float getTargetShadowSize();

        private ShadowAnimatorImpl() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.validValues) {
                this.shadowSizeStart = FloatingActionButtonImpl.this.shapeDrawable == null ? 0.0f : FloatingActionButtonImpl.this.shapeDrawable.getElevation();
                this.shadowSizeEnd = getTargetShadowSize();
                this.validValues = true;
            }
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            float f = this.shadowSizeStart;
            floatingActionButtonImpl.updateShapeElevation((int) (f + ((this.shadowSizeEnd - f) * valueAnimator.getAnimatedFraction())));
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FloatingActionButtonImpl.this.updateShapeElevation((int) this.shadowSizeEnd);
            this.validValues = false;
        }
    }

    private class ResetElevationAnimation extends ShadowAnimatorImpl {
        ResetElevationAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float getTargetShadowSize() {
            return FloatingActionButtonImpl.this.elevation;
        }
    }

    private class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToHoveredFocusedTranslationZAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float getTargetShadowSize() {
            return FloatingActionButtonImpl.this.elevation + FloatingActionButtonImpl.this.hoveredFocusedTranslationZ;
        }
    }

    private class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToPressedTranslationZAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float getTargetShadowSize() {
            return FloatingActionButtonImpl.this.elevation + FloatingActionButtonImpl.this.pressedTranslationZ;
        }
    }

    private class DisabledElevationAnimation extends ShadowAnimatorImpl {
        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float getTargetShadowSize() {
            return 0.0f;
        }

        DisabledElevationAnimation() {
            super();
        }
    }

    private boolean shouldAnimateVisibilityChange() {
        return ViewCompat.isLaidOut(this.view) && !this.view.isInEditMode();
    }

    void updateFromViewRotation() {
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShadowCompatRotation((int) this.rotation);
        }
    }
}
