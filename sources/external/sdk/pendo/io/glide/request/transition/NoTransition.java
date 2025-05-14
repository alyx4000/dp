package external.sdk.pendo.io.glide.request.transition;

import external.sdk.pendo.io.glide.request.transition.a;

/* loaded from: classes2.dex */
public class NoTransition<R> implements a<R> {
    static final NoTransition<?> NO_ANIMATION = new NoTransition<>();
    private static final sdk.pendo.io.g0.a<?> NO_ANIMATION_FACTORY = new NoAnimationFactory();

    public static class NoAnimationFactory<R> implements sdk.pendo.io.g0.a<R> {
        @Override // sdk.pendo.io.g0.a
        public a<R> build(sdk.pendo.io.q.a aVar, boolean z) {
            return NoTransition.NO_ANIMATION;
        }
    }

    public static <R> a<R> get() {
        return NO_ANIMATION;
    }

    public static <R> sdk.pendo.io.g0.a<R> getFactory() {
        return (sdk.pendo.io.g0.a<R>) NO_ANIMATION_FACTORY;
    }

    @Override // external.sdk.pendo.io.glide.request.transition.a
    public boolean transition(Object obj, a.InterfaceC0067a interfaceC0067a) {
        return false;
    }
}
