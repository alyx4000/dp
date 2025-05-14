package external.sdk.pendo.io.yoyo.zooming_exits;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* loaded from: classes2.dex */
public class ZoomOutRightAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    protected void prepare(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f, 0.0f), ObjectAnimator.ofFloat(view, ViewProps.SCALE_X, 1.0f, 0.475f, 0.1f), ObjectAnimator.ofFloat(view, ViewProps.SCALE_Y, 1.0f, 0.475f, 0.1f), ObjectAnimator.ofFloat(view, "translationX", 0.0f, -42.0f, viewGroup.getWidth() - viewGroup.getLeft()));
    }
}
