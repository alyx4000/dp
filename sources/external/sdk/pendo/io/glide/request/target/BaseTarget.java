package external.sdk.pendo.io.glide.request.target;

import android.graphics.drawable.Drawable;
import sdk.pendo.io.e0.a;

@Deprecated
/* loaded from: classes2.dex */
public abstract class BaseTarget<Z> implements Target<Z> {
    private a request;

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public a getRequest() {
        return this.request;
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target, sdk.pendo.io.c0.i
    public void onDestroy() {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target, sdk.pendo.io.c0.i
    public void onStart() {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target, sdk.pendo.io.c0.i
    public void onStop() {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void setRequest(a aVar) {
        this.request = aVar;
    }
}
