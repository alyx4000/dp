package external.sdk.pendo.io.glide.request.target;

import android.graphics.drawable.Drawable;
import sdk.pendo.io.e0.a;
import sdk.pendo.io.f0.c;
import sdk.pendo.io.i0.k;

/* loaded from: classes2.dex */
public abstract class CustomTarget<T> implements Target<T> {
    private final int height;
    private a request;
    private final int width;

    public CustomTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public final a getRequest() {
        return this.request;
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public final void getSize(c cVar) {
        cVar.onSizeReady(this.width, this.height);
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target, sdk.pendo.io.c0.i
    public void onDestroy() {
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
    public final void removeCallback(c cVar) {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public final void setRequest(a aVar) {
        this.request = aVar;
    }

    public CustomTarget(int i, int i2) {
        if (!k.b(i, i2)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i + " and height: " + i2);
        }
        this.width = i;
        this.height = i2;
    }
}
