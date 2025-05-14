package external.sdk.pendo.io.glide;

import external.sdk.pendo.io.glide.d;
import external.sdk.pendo.io.glide.request.transition.NoTransition;
import external.sdk.pendo.io.glide.request.transition.ViewAnimationFactory;
import external.sdk.pendo.io.glide.request.transition.ViewPropertyAnimationFactory;
import external.sdk.pendo.io.glide.request.transition.ViewPropertyTransition;
import sdk.pendo.io.i0.j;

/* loaded from: classes2.dex */
public abstract class d<CHILD extends d<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    private sdk.pendo.io.g0.a<? super TranscodeType> transitionFactory = NoTransition.getFactory();

    private CHILD self() {
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final CHILD m1097clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final CHILD dontTransition() {
        return transition(NoTransition.getFactory());
    }

    final sdk.pendo.io.g0.a<? super TranscodeType> getTransitionFactory() {
        return this.transitionFactory;
    }

    public final CHILD transition(int i) {
        return transition(new ViewAnimationFactory(i));
    }

    public final CHILD transition(ViewPropertyTransition.Animator animator) {
        return transition(new ViewPropertyAnimationFactory(animator));
    }

    public final CHILD transition(sdk.pendo.io.g0.a<? super TranscodeType> aVar) {
        this.transitionFactory = (sdk.pendo.io.g0.a) j.a(aVar);
        return self();
    }
}
