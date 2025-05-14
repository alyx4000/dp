package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.request.transition.BitmapTransitionFactory;
import external.sdk.pendo.io.glide.request.transition.DrawableCrossFadeFactory;

/* loaded from: classes2.dex */
public final class BitmapTransitionOptions extends external.sdk.pendo.io.glide.d<BitmapTransitionOptions, Bitmap> {
    public static BitmapTransitionOptions with(sdk.pendo.io.g0.a<Bitmap> aVar) {
        return new BitmapTransitionOptions().transition(aVar);
    }

    public static BitmapTransitionOptions withCrossFade() {
        return new BitmapTransitionOptions().crossFade();
    }

    public static BitmapTransitionOptions withWrapped(sdk.pendo.io.g0.a<Drawable> aVar) {
        return new BitmapTransitionOptions().transitionUsing(aVar);
    }

    public BitmapTransitionOptions crossFade() {
        return crossFade(new DrawableCrossFadeFactory.a());
    }

    public BitmapTransitionOptions transitionUsing(sdk.pendo.io.g0.a<Drawable> aVar) {
        return transition(new BitmapTransitionFactory(aVar));
    }

    public static BitmapTransitionOptions withCrossFade(int i) {
        return new BitmapTransitionOptions().crossFade(i);
    }

    public BitmapTransitionOptions crossFade(int i) {
        return crossFade(new DrawableCrossFadeFactory.a(i));
    }

    public static BitmapTransitionOptions withCrossFade(DrawableCrossFadeFactory.a aVar) {
        return new BitmapTransitionOptions().crossFade(aVar);
    }

    public BitmapTransitionOptions crossFade(DrawableCrossFadeFactory.a aVar) {
        return transitionUsing(aVar.a());
    }

    public static BitmapTransitionOptions withCrossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return new BitmapTransitionOptions().crossFade(drawableCrossFadeFactory);
    }

    public BitmapTransitionOptions crossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return transitionUsing(drawableCrossFadeFactory);
    }
}
