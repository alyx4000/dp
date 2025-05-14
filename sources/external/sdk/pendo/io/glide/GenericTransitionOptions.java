package external.sdk.pendo.io.glide;

import external.sdk.pendo.io.glide.request.transition.ViewPropertyTransition;

/* loaded from: classes2.dex */
public final class GenericTransitionOptions<TranscodeType> extends d<GenericTransitionOptions<TranscodeType>, TranscodeType> {
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(int i) {
        return new GenericTransitionOptions().transition(i);
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> withNoTransition() {
        return new GenericTransitionOptions().dontTransition();
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(ViewPropertyTransition.Animator animator) {
        return new GenericTransitionOptions().transition(animator);
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(sdk.pendo.io.g0.a<? super TranscodeType> aVar) {
        return new GenericTransitionOptions().transition(aVar);
    }
}
