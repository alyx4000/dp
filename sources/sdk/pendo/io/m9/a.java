package sdk.pendo.io.m9;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.views.listener.FloatingListenerButton;

/* loaded from: classes6.dex */
public class a extends View {
    static final Interpolator c = new AccelerateInterpolator();

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f1403a;
    private FloatingListenerButton b;

    /* renamed from: sdk.pendo.io.m9.a$a, reason: collision with other inner class name */
    class C0198a implements Animator.AnimatorListener {
        C0198a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.setVisibility(8);
            a aVar = a.this;
            aVar.f1403a.removeView(aVar);
            FloatingListenerButton floatingListenerButton = a.this.b;
            if (floatingListenerButton != null) {
                floatingListenerButton.flashFinished();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public a(Context context) {
        super(context);
    }

    public a a(View view, FloatingListenerButton floatingListenerButton) {
        this.f1403a = (ViewGroup) view;
        this.b = floatingListenerButton;
        DisplayMetrics displayMetrics = PendoInternal.m().getResources().getDisplayMetrics();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(displayMetrics.widthPixels, displayMetrics.heightPixels);
        setAlpha(0.5f);
        setBackgroundColor(-1);
        this.f1403a.addView(this, layoutParams);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<a, Float>) View.ALPHA, 0.5f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, (Property<a, Float>) View.ALPHA, 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2);
        animatorSet.setInterpolator(c);
        animatorSet.setDuration(50L);
        animatorSet.addListener(new C0198a());
        animatorSet.start();
        return this;
    }
}
