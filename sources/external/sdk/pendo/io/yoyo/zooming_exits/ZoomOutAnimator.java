package external.sdk.pendo.io.yoyo.zooming_exits;

import android.animation.ObjectAnimator;
import android.view.View;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* loaded from: classes2.dex */
public class ZoomOutAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    protected void prepare(View view) {
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.5f, 0.0f), ObjectAnimator.ofFloat(view, ViewProps.SCALE_X, 1.0f, 0.6f, 0.4f), ObjectAnimator.ofFloat(view, ViewProps.SCALE_Y, 1.0f, 0.6f, 0.4f));
    }
}
