package external.sdk.pendo.io.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import external.sdk.pendo.io.glide.request.transition.ViewTransition;

/* loaded from: classes2.dex */
public class ViewAnimationFactory<R> implements sdk.pendo.io.g0.a<R> {
    private external.sdk.pendo.io.glide.request.transition.a<R> transition;
    private final ViewTransition.a viewTransitionAnimationFactory;

    private static class a implements ViewTransition.a {

        /* renamed from: a, reason: collision with root package name */
        private final Animation f715a;

        a(Animation animation) {
            this.f715a = animation;
        }

        @Override // external.sdk.pendo.io.glide.request.transition.ViewTransition.a
        public Animation a(Context context) {
            return this.f715a;
        }
    }

    private static class b implements ViewTransition.a {

        /* renamed from: a, reason: collision with root package name */
        private final int f716a;

        b(int i) {
            this.f716a = i;
        }

        @Override // external.sdk.pendo.io.glide.request.transition.ViewTransition.a
        public Animation a(Context context) {
            return AnimationUtils.loadAnimation(context, this.f716a);
        }
    }

    public ViewAnimationFactory(int i) {
        this(new b(i));
    }

    @Override // sdk.pendo.io.g0.a
    public external.sdk.pendo.io.glide.request.transition.a<R> build(sdk.pendo.io.q.a aVar, boolean z) {
        if (aVar == sdk.pendo.io.q.a.MEMORY_CACHE || !z) {
            return NoTransition.get();
        }
        if (this.transition == null) {
            this.transition = new ViewTransition(this.viewTransitionAnimationFactory);
        }
        return this.transition;
    }

    public ViewAnimationFactory(Animation animation) {
        this(new a(animation));
    }

    ViewAnimationFactory(ViewTransition.a aVar) {
        this.viewTransitionAnimationFactory = aVar;
    }
}
