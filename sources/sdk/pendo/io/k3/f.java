package sdk.pendo.io.k3;

import com.extole.android.sdk.impl.http.HttpRequest;
import com.facebook.common.callercontext.ContextChain;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\u0005H&J\b\u0010\u0011\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H&J\b\u0010\u0018\u001a\u00020\u0017H&J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0017H&J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001eH&J\b\u0010 \u001a\u00020\u001fH&J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020#H&J\b\u0010&\u001a\u00020%H&R\u0014\u0010)\u001a\u00020\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(\u0082\u0001\u0002\u001c*ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006+À\u0006\u0001"}, d2 = {"Lsdk/pendo/io/k3/f;", "Lsdk/pendo/io/k3/a0;", "Ljava/nio/channels/ReadableByteChannel;", "", ContextChain.TAG_INFRA, "", "byteCount", "", "f", "a", "", "readByte", "", "readShort", "", "readInt", "readLong", "k", "skip", "Lsdk/pendo/io/k3/g;", "c", "Lsdk/pendo/io/k3/r;", "options", "", "h", "d", "sink", "readFully", "Lsdk/pendo/io/k3/d;", "b", "Lsdk/pendo/io/k3/y;", "", "g", "limit", "e", "Ljava/nio/charset/Charset;", HttpRequest.PARAM_CHARSET, "Ljava/io/InputStream;", "l", "getBuffer", "()Lokio/Buffer;", "buffer", "Lsdk/pendo/io/k3/u;", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public interface f extends a0, ReadableByteChannel {
    int a(r options);

    long a(y sink);

    String a(Charset charset);

    boolean a(long byteCount);

    void b(d sink, long byteCount);

    d c();

    g c(long byteCount);

    byte[] d(long byteCount);

    String e(long limit);

    void f(long byteCount);

    String g();

    byte[] h();

    boolean i();

    long k();

    InputStream l();

    byte readByte();

    void readFully(byte[] sink);

    int readInt();

    long readLong();

    short readShort();

    void skip(long byteCount);
}
