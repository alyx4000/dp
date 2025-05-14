package external.sdk.pendo.io.yoyo.rotating_entrances;

import android.animation.ObjectAnimator;
import android.view.View;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* loaded from: classes2.dex */
public class RotateInAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    public void prepare(View view) {
        getAnimatorAgent().playTogether(ObjectAnimator.ofFloat(view, ViewProps.ROTATION, -200.0f, 0.0f), ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f));
    }
}
