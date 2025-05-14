package external.sdk.pendo.io.yoyo.rotating_entrances;

import android.animation.ObjectAnimator;
import android.view.View;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* loaded from: classes2.dex */
public class RotateInDownLeftAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        float paddingLeft = view.getPaddingLeft();
        float height = view.getHeight() - view.getPaddingBottom();
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, ViewProps.ROTATION, -90.0f, 0.0f), ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(view, "pivotX", paddingLeft, paddingLeft), ObjectAnimator.ofFloat(view, "pivotY", height, height));
    }
}
