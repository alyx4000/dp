package sdk.pendo.io.j3;

import androidx.exifinterface.media.ExifInterface;
import com.iterable.iterableapi.IterableConstants;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import io.sentry.clientreport.DiscardedEvent;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.k3.d;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\bB/\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\u0006\u0010\u001b\u001a\u00020\n¢\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\fR\u0014\u0010\u001b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\fR\u0016\u0010\u001d\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\fR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\fR\u0016\u0010)\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\fR\u0016\u0010+\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\fR\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00101\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010.R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0004\u0018\u0001068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u0004\u0018\u00010:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006@"}, d2 = {"Lsdk/pendo/io/j3/g;", "Ljava/io/Closeable;", "", "e", "b", "n", "o", "m", "a", "close", "", "f", "Z", "isClient", "Lsdk/pendo/io/k3/f;", "s", "Lsdk/pendo/io/k3/f;", "getSource", "()Lokio/BufferedSource;", "source", "Lsdk/pendo/io/j3/g$a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lsdk/pendo/io/j3/g$a;", "frameCallback", "f0", "perMessageDeflate", "t0", "noContextTakeover", "u0", "closed", "", "v0", "I", "opcode", "", "w0", "J", "frameLength", "x0", "isFinalFrame", "y0", "isControlFrame", "z0", "readingCompressedMessage", "Lsdk/pendo/io/k3/d;", "A0", "Lsdk/pendo/io/k3/d;", "controlFrameBuffer", "B0", "messageFrameBuffer", "Lsdk/pendo/io/j3/c;", "C0", "Lsdk/pendo/io/j3/c;", "messageInflater", "", "D0", "[B", "maskKey", "Lsdk/pendo/io/k3/d$a;", "E0", "Lsdk/pendo/io/k3/d$a;", "maskCursor", "<init>", "(ZLokio/BufferedSource;Lokhttp3/internal/ws/WebSocketReader$FrameCallback;ZZ)V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class g implements Closeable {

    /* renamed from: A, reason: from kotlin metadata */
    private final a frameCallback;

    /* renamed from: A0, reason: from kotlin metadata */
    private final sdk.pendo.io.k3.d controlFrameBuffer;

    /* renamed from: B0, reason: from kotlin metadata */
    private final sdk.pendo.io.k3.d messageFrameBuffer;

    /* renamed from: C0, reason: from kotlin metadata */
    private c messageInflater;

    /* renamed from: D0, reason: from kotlin metadata */
    private final byte[] maskKey;

    /* renamed from: E0, reason: from kotlin metadata */
    private final d.a maskCursor;

    /* renamed from: f, reason: from kotlin metadata */
    private final boolean isClient;

    /* renamed from: f0, reason: from kotlin metadata */
    private final boolean perMessageDeflate;

    /* renamed from: s, reason: from kotlin metadata */
    private final sdk.pendo.io.k3.f source;

    /* renamed from: t0, reason: from kotlin metadata */
    private final boolean noContextTakeover;

    /* renamed from: u0, reason: from kotlin metadata */
    private boolean closed;

    /* renamed from: v0, reason: from kotlin metadata */
    private int opcode;

    /* renamed from: w0, reason: from kotlin metadata */
    private long frameLength;

    /* renamed from: x0, reason: from kotlin metadata */
    private boolean isFinalFrame;

    /* renamed from: y0, reason: from kotlin metadata */
    private boolean isControlFrame;

    /* renamed from: z0, reason: from kotlin metadata */
    private boolean readingCompressedMessage;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H&J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H&¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/j3/g$a;", "", "", "text", "", "b", "Lsdk/pendo/io/k3/g;", "bytes", "a", IterableConstants.ITERABLE_IN_APP_LEGACY_PAYLOAD, "d", "", ApiConstant.KEY_CODE, DiscardedEvent.JsonKeys.REASON, "okhttp"}, k = 1, mv = {1, 8, 0})
    public interface a {
        void a(sdk.pendo.io.k3.g bytes);

        void b(int code, String reason);

        void b(String text);

        void b(sdk.pendo.io.k3.g payload);

        void d(sdk.pendo.io.k3.g payload);
    }

    public g(boolean z, sdk.pendo.io.k3.f source, a frameCallback, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(frameCallback, "frameCallback");
        this.isClient = z;
        this.source = source;
        this.frameCallback = frameCallback;
        this.perMessageDeflate = z2;
        this.noContextTakeover = z3;
        this.controlFrameBuffer = new sdk.pendo.io.k3.d();
        this.messageFrameBuffer = new sdk.pendo.io.k3.d();
        this.maskKey = z ? null : new byte[4];
        this.maskCursor = z ? null : new d.a();
    }

    private final void b() {
        short s;
        String str;
        long j = this.frameLength;
        if (j > 0) {
            this.source.b(this.controlFrameBuffer, j);
            if (!this.isClient) {
                sdk.pendo.io.k3.d dVar = this.controlFrameBuffer;
                d.a aVar = this.maskCursor;
                Intrinsics.checkNotNull(aVar);
                dVar.a(aVar);
                this.maskCursor.i(0L);
                f fVar = f.f1225a;
                d.a aVar2 = this.maskCursor;
                byte[] bArr = this.maskKey;
                Intrinsics.checkNotNull(bArr);
                fVar.a(aVar2, bArr);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                long size = this.controlFrameBuffer.getSize();
                if (size == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (size != 0) {
                    s = this.controlFrameBuffer.readShort();
                    str = this.controlFrameBuffer.w();
                    String a2 = f.f1225a.a(s);
                    if (a2 != null) {
                        throw new ProtocolException(a2);
                    }
                } else {
                    s = 1005;
                    str = "";
                }
                this.frameCallback.b(s, str);
                this.closed = true;
                return;
            case 9:
                this.frameCallback.d(this.controlFrameBuffer.t());
                return;
            case 10:
                this.frameCallback.b(this.controlFrameBuffer.t());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + sdk.pendo.io.x2.b.a(this.opcode));
        }
    }

    private final void e() {
        boolean z;
        if (this.closed) {
            throw new IOException("closed");
        }
        long timeoutNanos = this.source.getTimeout().getTimeoutNanos();
        this.source.getTimeout().b();
        try {
            int a2 = sdk.pendo.io.x2.b.a(this.source.readByte(), 255);
            this.source.getTimeout().a(timeoutNanos, TimeUnit.NANOSECONDS);
            int i = a2 & 15;
            this.opcode = i;
            boolean z2 = (a2 & 128) != 0;
            this.isFinalFrame = z2;
            boolean z3 = (a2 & 8) != 0;
            this.isControlFrame = z3;
            if (z3 && !z2) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z4 = (a2 & 64) != 0;
            if (i == 1 || i == 2) {
                if (!z4) {
                    z = false;
                } else {
                    if (!this.perMessageDeflate) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z = true;
                }
                this.readingCompressedMessage = z;
            } else if (z4) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((a2 & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((a2 & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            int a3 = sdk.pendo.io.x2.b.a(this.source.readByte(), 255);
            boolean z5 = (a3 & 128) != 0;
            if (z5 == this.isClient) {
                throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j = a3 & 127;
            this.frameLength = j;
            if (j == 126) {
                this.frameLength = sdk.pendo.io.x2.b.a(this.source.readShort(), 65535);
            } else if (j == 127) {
                long readLong = this.source.readLong();
                this.frameLength = readLong;
                if (readLong < 0) {
                    throw new ProtocolException("Frame length 0x" + sdk.pendo.io.x2.b.a(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z5) {
                sdk.pendo.io.k3.f fVar = this.source;
                byte[] bArr = this.maskKey;
                Intrinsics.checkNotNull(bArr);
                fVar.readFully(bArr);
            }
        } catch (Throwable th) {
            this.source.getTimeout().a(timeoutNanos, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private final void m() {
        while (!this.closed) {
            long j = this.frameLength;
            if (j > 0) {
                this.source.b(this.messageFrameBuffer, j);
                if (!this.isClient) {
                    sdk.pendo.io.k3.d dVar = this.messageFrameBuffer;
                    d.a aVar = this.maskCursor;
                    Intrinsics.checkNotNull(aVar);
                    dVar.a(aVar);
                    this.maskCursor.i(this.messageFrameBuffer.getSize() - this.frameLength);
                    f fVar = f.f1225a;
                    d.a aVar2 = this.maskCursor;
                    byte[] bArr = this.maskKey;
                    Intrinsics.checkNotNull(bArr);
                    fVar.a(aVar2, bArr);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            o();
            if (this.opcode != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + sdk.pendo.io.x2.b.a(this.opcode));
            }
        }
        throw new IOException("closed");
    }

    private final void n() {
        int i = this.opcode;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Unknown opcode: " + sdk.pendo.io.x2.b.a(i));
        }
        m();
        if (this.readingCompressedMessage) {
            c cVar = this.messageInflater;
            if (cVar == null) {
                cVar = new c(this.noContextTakeover);
                this.messageInflater = cVar;
            }
            cVar.a(this.messageFrameBuffer);
        }
        if (i == 1) {
            this.frameCallback.b(this.messageFrameBuffer.w());
        } else {
            this.frameCallback.a(this.messageFrameBuffer.t());
        }
    }

    private final void o() {
        while (!this.closed) {
            e();
            if (!this.isControlFrame) {
                return;
            } else {
                b();
            }
        }
    }

    public final void a() {
        e();
        if (this.isControlFrame) {
            b();
        } else {
            n();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c cVar = this.messageInflater;
        if (cVar != null) {
            cVar.close();
        }
    }
}
