package external.sdk.pendo.io.yoyo.flippers;

import android.animation.ObjectAnimator;
import android.view.View;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* loaded from: classes2.dex */
public class FlipOutYAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "rotationY", 0.0f, 90.0f), ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f));
    }
}
