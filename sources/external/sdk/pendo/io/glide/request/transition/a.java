package external.sdk.pendo.io.glide.request.transition;

import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes2.dex */
public interface a<R> {

    /* renamed from: external.sdk.pendo.io.glide.request.transition.a$a, reason: collision with other inner class name */
    public interface InterfaceC0067a {
        Drawable getCurrentDrawable();

        View getView();

        void setDrawable(Drawable drawable);
    }

    boolean transition(R r, InterfaceC0067a interfaceC0067a);
}
