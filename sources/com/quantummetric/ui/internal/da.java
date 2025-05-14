package com.quantummetric.ui.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
class da extends c {
    WeakReference<View> B;
    i E;
    int D = -1;
    WeakReference<Drawable> C = new WeakReference<>(null);

    da(View view) {
        a((Object) view);
        if (aa.o) {
            this.E = i.a(view);
        }
    }

    static da c(View view) {
        return view instanceof ImageView ? new cs(view) : view instanceof TextView ? new cz(view) : ag.a(view) ? new cw(view) : cc.a(view) ? new cx(view) : ag.c(view) ? new cy(view) : view instanceof WebView ? new db(view) : ae.a(view) ? new cr(view) : view instanceof ProgressBar ? new ct(view) : ag.g(view) ? new cv(view) : new da(view);
    }

    @Override // com.quantummetric.ui.internal.c
    void a(Object obj) {
        if (obj instanceof View) {
            View view = (View) obj;
            this.B = new WeakReference<>(view);
            this.f157a = view.getVisibility() != 0;
            this.g = view.getAlpha();
            this.h = view.getTranslationX();
            this.i = view.getTranslationY();
            if (!df.f || this.g != 0.0f) {
                if (!df.g) {
                    return;
                }
                if (this.h == 0.0f && this.i == 0.0f) {
                    return;
                }
            }
            df.a(this);
        }
    }

    boolean a(View view) {
        return (this.f157a == (view.getVisibility() != 0) && this.g == view.getAlpha() && this.h == view.getTranslationX() && this.i == view.getTranslationY()) ? false : true;
    }

    @Override // com.quantummetric.ui.internal.c
    final String a_() {
        return de.a(this.B.get());
    }

    final boolean n() {
        if (this.C.get() instanceof ah) {
            ah ahVar = (ah) this.C.get();
            if (ahVar.d != null) {
                return ahVar.d.c;
            }
        }
        return false;
    }
}
