package sdk.pendo.io.u;

import android.graphics.Bitmap;

/* loaded from: classes3.dex */
public interface b {
    void clearMemory();

    Bitmap get(int i, int i2, Bitmap.Config config);

    Bitmap getDirty(int i, int i2, Bitmap.Config config);

    void put(Bitmap bitmap);

    void trimMemory(int i);
}
