package external.sdk.pendo.io.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.request.transition.a;

/* loaded from: classes2.dex */
public abstract class BitmapContainerTransitionFactory<R> implements sdk.pendo.io.g0.a<R> {
    private final sdk.pendo.io.g0.a<Drawable> realFactory;

    private final class a implements external.sdk.pendo.io.glide.request.transition.a<R> {

        /* renamed from: a, reason: collision with root package name */
        private final external.sdk.pendo.io.glide.request.transition.a<Drawable> f713a;

        a(external.sdk.pendo.io.glide.request.transition.a<Drawable> aVar) {
            this.f713a = aVar;
        }

        @Override // external.sdk.pendo.io.glide.request.transition.a
        public boolean transition(R r, a.InterfaceC0067a interfaceC0067a) {
            return this.f713a.transition(new BitmapDrawable(interfaceC0067a.getView().getResources(), BitmapContainerTransitionFactory.this.getBitmap(r)), interfaceC0067a);
        }
    }

    public BitmapContainerTransitionFactory(sdk.pendo.io.g0.a<Drawable> aVar) {
        this.realFactory = aVar;
    }

    @Override // sdk.pendo.io.g0.a
    public external.sdk.pendo.io.glide.request.transition.a<R> build(sdk.pendo.io.q.a aVar, boolean z) {
        return new a(this.realFactory.build(aVar, z));
    }

    protected abstract Bitmap getBitmap(R r);
}
