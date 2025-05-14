package external.sdk.pendo.io.glide.request.transition;

import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public class DrawableCrossFadeFactory implements sdk.pendo.io.g0.a<Drawable> {
    private final int duration;
    private final boolean isCrossFadeEnabled;
    private DrawableCrossFadeTransition resourceTransition;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f714a;
        private boolean b;

        public a() {
            this(300);
        }

        public DrawableCrossFadeFactory a() {
            return new DrawableCrossFadeFactory(this.f714a, this.b);
        }

        public a(int i) {
            this.f714a = i;
        }
    }

    protected DrawableCrossFadeFactory(int i, boolean z) {
        this.duration = i;
        this.isCrossFadeEnabled = z;
    }

    private external.sdk.pendo.io.glide.request.transition.a<Drawable> getResourceTransition() {
        if (this.resourceTransition == null) {
            this.resourceTransition = new DrawableCrossFadeTransition(this.duration, this.isCrossFadeEnabled);
        }
        return this.resourceTransition;
    }

    @Override // sdk.pendo.io.g0.a
    public external.sdk.pendo.io.glide.request.transition.a<Drawable> build(sdk.pendo.io.q.a aVar, boolean z) {
        return aVar == sdk.pendo.io.q.a.MEMORY_CACHE ? NoTransition.get() : getResourceTransition();
    }
}
