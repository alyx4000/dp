package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
public interface CaptureProcessor {
    default void close() {
    }

    void onOutputSurface(Surface surface, int i);

    void onResolutionUpdate(Size size);

    void process(ImageProxyBundle imageProxyBundle);

    default ListenableFuture<Void> getCloseFuture() {
        return Futures.immediateFuture(null);
    }
}
