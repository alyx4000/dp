package external.sdk.pendo.io.yoyo.zooming_entrances;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* loaded from: classes2.dex */
public class ZoomInAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        view.setPivotX(((ViewGroup) view.getParent()).getMeasuredWidth() / 2.0f);
        view.setPivotY(((ViewGroup) view.getParent()).getMeasuredHeight() / 2.0f);
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, ViewProps.SCALE_X, 0.4f, 0.6f, 1.0f), ObjectAnimator.ofFloat(view, ViewProps.SCALE_Y, 0.4f, 0.6f, 1.0f), ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f, 1.0f));
    }
}
