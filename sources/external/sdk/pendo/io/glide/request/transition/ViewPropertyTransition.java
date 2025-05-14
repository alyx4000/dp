package external.sdk.pendo.io.glide.request.transition;

import android.view.View;
import external.sdk.pendo.io.glide.request.transition.a;

/* loaded from: classes2.dex */
public class ViewPropertyTransition<R> implements a<R> {
    private final Animator animator;

    public interface Animator {
        void a(View view);
    }

    public ViewPropertyTransition(Animator animator) {
        this.animator = animator;
    }

    @Override // external.sdk.pendo.io.glide.request.transition.a
    public boolean transition(R r, a.InterfaceC0067a interfaceC0067a) {
        if (interfaceC0067a.getView() == null) {
            return false;
        }
        this.animator.a(interfaceC0067a.getView());
        return false;
    }
}
