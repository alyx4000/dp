package external.sdk.pendo.io.glide.load.resource.gif;

import android.util.Log;
import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import external.sdk.pendo.io.glide.load.Options;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import sdk.pendo.io.q.i;
import sdk.pendo.io.t.c;
import sdk.pendo.io.u.a;

/* loaded from: classes2.dex */
public class StreamGifDecoder implements i<InputStream, GifDrawable> {
    private static final String TAG = "StreamGifDecoder";
    private final a byteArrayPool;
    private final i<ByteBuffer, GifDrawable> byteBufferDecoder;
    private final List<ImageHeaderParser> parsers;

    public StreamGifDecoder(List<ImageHeaderParser> list, i<ByteBuffer, GifDrawable> iVar, a aVar) {
        this.parsers = list;
        this.byteBufferDecoder = iVar;
        this.byteArrayPool = aVar;
    }

    private static byte[] inputStreamToBytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            if (!Log.isLoggable(TAG, 5)) {
                return null;
            }
            Log.w(TAG, "Error reading data from stream", e);
            return null;
        }
    }

    @Override // sdk.pendo.io.q.i
    public c<GifDrawable> decode(InputStream inputStream, int i, int i2, Options options) {
        byte[] inputStreamToBytes = inputStreamToBytes(inputStream);
        if (inputStreamToBytes == null) {
            return null;
        }
        return this.byteBufferDecoder.decode(ByteBuffer.wrap(inputStreamToBytes), i, i2, options);
    }

    @Override // sdk.pendo.io.q.i
    public boolean handles(InputStream inputStream, Options options) {
        return !((Boolean) options.get(sdk.pendo.io.a0.a.b)).booleanValue() && external.sdk.pendo.io.glide.load.a.b(this.parsers, inputStream, this.byteArrayPool) == ImageHeaderParser.ImageType.GIF;
    }
}
