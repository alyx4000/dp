package external.sdk.pendo.io.yoyo.sliders;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* loaded from: classes2.dex */
public class SlideInLeftAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(view, "translationX", -(((ViewGroup) view.getParent()).getWidth() - view.getLeft()), 0.0f));
    }
}
