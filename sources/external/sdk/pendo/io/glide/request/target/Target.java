package external.sdk.pendo.io.glide.request.target;

import android.graphics.drawable.Drawable;
import sdk.pendo.io.c0.i;
import sdk.pendo.io.e0.a;
import sdk.pendo.io.f0.c;

/* loaded from: classes2.dex */
public interface Target<R> extends i {
    public static final int SIZE_ORIGINAL = Integer.MIN_VALUE;

    a getRequest();

    void getSize(c cVar);

    @Override // sdk.pendo.io.c0.i
    /* synthetic */ void onDestroy();

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(R r, external.sdk.pendo.io.glide.request.transition.a<? super R> aVar);

    @Override // sdk.pendo.io.c0.i
    /* synthetic */ void onStart();

    @Override // sdk.pendo.io.c0.i
    /* synthetic */ void onStop();

    void removeCallback(c cVar);

    void setRequest(a aVar);
}
