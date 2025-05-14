package external.sdk.pendo.io.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.d;
import external.sdk.pendo.io.glide.request.transition.DrawableCrossFadeFactory;

/* loaded from: classes2.dex */
public final class DrawableTransitionOptions extends d<DrawableTransitionOptions, Drawable> {
    public static DrawableTransitionOptions with(sdk.pendo.io.g0.a<Drawable> aVar) {
        return new DrawableTransitionOptions().transition(aVar);
    }

    public static DrawableTransitionOptions withCrossFade() {
        return new DrawableTransitionOptions().crossFade();
    }

    public DrawableTransitionOptions crossFade() {
        return crossFade(new DrawableCrossFadeFactory.a());
    }

    public static DrawableTransitionOptions withCrossFade(int i) {
        return new DrawableTransitionOptions().crossFade(i);
    }

    public DrawableTransitionOptions crossFade(int i) {
        return crossFade(new DrawableCrossFadeFactory.a(i));
    }

    public static DrawableTransitionOptions withCrossFade(DrawableCrossFadeFactory.a aVar) {
        return new DrawableTransitionOptions().crossFade(aVar);
    }

    public DrawableTransitionOptions crossFade(DrawableCrossFadeFactory.a aVar) {
        return crossFade(aVar.a());
    }

    public static DrawableTransitionOptions withCrossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return new DrawableTransitionOptions().crossFade(drawableCrossFadeFactory);
    }

    public DrawableTransitionOptions crossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return transition(drawableCrossFadeFactory);
    }
}
