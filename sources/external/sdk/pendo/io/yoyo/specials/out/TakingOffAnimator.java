package external.sdk.pendo.io.yoyo.specials.out;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.daimajia.Glider;
import external.sdk.pendo.io.daimajia.Skill;
import external.sdk.pendo.io.yoyo.BaseViewAnimator;

/* loaded from: classes2.dex */
public class TakingOffAnimator extends BaseViewAnimator {
    @Override // external.sdk.pendo.io.yoyo.BaseViewAnimator
    protected void prepare(View view) {
        AnimatorSet animatorAgent = getAnimatorAgent();
        Skill skill = Skill.QuintEaseOut;
        animatorAgent.playTogether(Glider.glide(skill, getDuration(), ObjectAnimator.ofFloat(view, ViewProps.SCALE_X, 1.0f, 1.5f)), Glider.glide(skill, getDuration(), ObjectAnimator.ofFloat(view, ViewProps.SCALE_Y, 1.0f, 1.5f)), Glider.glide(skill, getDuration(), ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f)));
    }
}
