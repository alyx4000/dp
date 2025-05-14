package external.sdk.pendo.io.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import external.sdk.pendo.io.glide.request.transition.a;

/* loaded from: classes2.dex */
public class ViewTransition<R> implements external.sdk.pendo.io.glide.request.transition.a<R> {
    private final a viewTransitionAnimationFactory;

    interface a {
        Animation a(Context context);
    }

    ViewTransition(a aVar) {
        this.viewTransitionAnimationFactory = aVar;
    }

    @Override // external.sdk.pendo.io.glide.request.transition.a
    public boolean transition(R r, a.InterfaceC0067a interfaceC0067a) {
        View view = interfaceC0067a.getView();
        if (view == null) {
            return false;
        }
        view.clearAnimation();
        view.startAnimation(this.viewTransitionAnimationFactory.a(view.getContext()));
        return false;
    }
}
