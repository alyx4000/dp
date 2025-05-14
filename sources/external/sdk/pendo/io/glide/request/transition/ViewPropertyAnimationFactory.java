package external.sdk.pendo.io.glide.request.transition;

import external.sdk.pendo.io.glide.request.transition.ViewPropertyTransition;

/* loaded from: classes2.dex */
public class ViewPropertyAnimationFactory<R> implements sdk.pendo.io.g0.a<R> {
    private ViewPropertyTransition<R> animation;
    private final ViewPropertyTransition.Animator animator;

    public ViewPropertyAnimationFactory(ViewPropertyTransition.Animator animator) {
        this.animator = animator;
    }

    @Override // sdk.pendo.io.g0.a
    public a<R> build(sdk.pendo.io.q.a aVar, boolean z) {
        if (aVar == sdk.pendo.io.q.a.MEMORY_CACHE || !z) {
            return NoTransition.get();
        }
        if (this.animation == null) {
            this.animation = new ViewPropertyTransition<>(this.animator);
        }
        return this.animation;
    }
}
