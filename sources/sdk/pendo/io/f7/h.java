package sdk.pendo.io.f7;

import android.view.View;
import sdk.pendo.io.x5.k;
import sdk.pendo.io.x5.l;

/* loaded from: classes6.dex */
final class h implements l<Object> {
    static final Object b = new Object();

    /* renamed from: a, reason: collision with root package name */
    final View f1087a;

    class a extends sdk.pendo.io.y5.a implements View.OnAttachStateChangeListener {
        final k<Object> s;

        public a(k<Object> kVar) {
            this.s = kVar;
        }

        @Override // sdk.pendo.io.y5.a
        protected void b() {
            h.this.f1087a.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.s.onNext(h.b);
        }
    }

    public h(View view) {
        this.f1087a = view;
    }

    @Override // sdk.pendo.io.x5.l
    public void a(k<Object> kVar) {
        sdk.pendo.io.y5.a.c();
        a aVar = new a(kVar);
        kVar.a(aVar);
        this.f1087a.addOnAttachStateChangeListener(aVar);
    }
}
