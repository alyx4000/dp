package external.sdk.pendo.io.glide.load.model;

import android.util.Log;
import external.sdk.pendo.io.glide.load.Options;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class ByteBufferEncoder implements sdk.pendo.io.q.d<ByteBuffer> {
    private static final String TAG = "ByteBufferEncoder";

    @Override // sdk.pendo.io.q.d
    public boolean encode(ByteBuffer byteBuffer, File file, Options options) {
        try {
            sdk.pendo.io.i0.a.a(byteBuffer, file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to write data", e);
            }
            return false;
        }
    }
}
