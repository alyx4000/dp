package sdk.pendo.io.k3;

import com.facebook.common.callercontext.ContextChain;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\tH&J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\tH&J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\tH&J\u0010\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0018\u001a\u00020\u0017H&J\b\u0010\u0019\u001a\u00020\u0000H&J\b\u0010\u001a\u001a\u00020\u0000H&R\u0014\u0010\u001e\u001a\u00020\u001b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u0082\u0001\u0002\u001b\u001fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006 À\u0006\u0001"}, d2 = {"Lsdk/pendo/io/k3/e;", "Lsdk/pendo/io/k3/y;", "Ljava/nio/channels/WritableByteChannel;", "Lsdk/pendo/io/k3/g;", "byteString", "a", "", "source", "write", "", "offset", "byteCount", "", "string", "b", "writeByte", "s", "writeShort", ContextChain.TAG_INFRA, "writeInt", "", "v", "g", "", "flush", "f", "j", "Lsdk/pendo/io/k3/d;", "getBuffer", "()Lokio/Buffer;", "buffer", "Lsdk/pendo/io/k3/t;", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public interface e extends y, WritableByteChannel {
    e a(String string);

    e a(g byteString);

    e b(long v);

    d c();

    e f();

    @Override // sdk.pendo.io.k3.y, java.io.Flushable
    void flush();

    e g(long v);

    e j();

    e write(byte[] source);

    e write(byte[] source, int offset, int byteCount);

    e writeByte(int b);

    e writeInt(int i);

    e writeShort(int s);
}
