package sdk.pendo.io.j3;

import androidx.exifinterface.media.ExifInterface;
import com.iterable.iterableapi.IterableConstants;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import io.sentry.clientreport.DiscardedEvent;
import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;
import sdk.pendo.io.k3.d;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u000f\u0012\u0006\u0010\"\u001a\u00020\u000f\u0012\u0006\u0010&\u001a\u00020#¢\u0006\u0004\b;\u0010<J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0011R\u0014\u0010\"\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0011R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010.\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010\u0011R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0004\u0018\u0001038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0004\u0018\u0001078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006="}, d2 = {"Lsdk/pendo/io/j3/h;", "Ljava/io/Closeable;", "", "opcode", "Lsdk/pendo/io/k3/g;", IterableConstants.ITERABLE_IN_APP_LEGACY_PAYLOAD, "", "b", "c", ApiConstant.KEY_CODE, DiscardedEvent.JsonKeys.REASON, "a", "formatOpcode", "data", "close", "", "f", "Z", "isClient", "Lsdk/pendo/io/k3/e;", "s", "Lsdk/pendo/io/k3/e;", "getSink", "()Lokio/BufferedSink;", "sink", "Ljava/util/Random;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/Random;", "getRandom", "()Ljava/util/Random;", "random", "f0", "perMessageDeflate", "t0", "noContextTakeover", "", "u0", "J", "minimumDeflateSize", "Lsdk/pendo/io/k3/d;", "v0", "Lsdk/pendo/io/k3/d;", "messageBuffer", "w0", "sinkBuffer", "x0", "writerClosed", "Lsdk/pendo/io/j3/a;", "y0", "Lsdk/pendo/io/j3/a;", "messageDeflater", "", "z0", "[B", "maskKey", "Lsdk/pendo/io/k3/d$a;", "A0", "Lsdk/pendo/io/k3/d$a;", "maskCursor", "<init>", "(ZLokio/BufferedSink;Ljava/util/Random;ZZJ)V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class h implements Closeable {

    /* renamed from: A, reason: from kotlin metadata */
    private final Random random;

    /* renamed from: A0, reason: from kotlin metadata */
    private final d.a maskCursor;

    /* renamed from: f, reason: from kotlin metadata */
    private final boolean isClient;

    /* renamed from: f0, reason: from kotlin metadata */
    private final boolean perMessageDeflate;

    /* renamed from: s, reason: from kotlin metadata */
    private final sdk.pendo.io.k3.e sink;

    /* renamed from: t0, reason: from kotlin metadata */
    private final boolean noContextTakeover;

    /* renamed from: u0, reason: from kotlin metadata */
    private final long minimumDeflateSize;

    /* renamed from: v0, reason: from kotlin metadata */
    private final sdk.pendo.io.k3.d messageBuffer;

    /* renamed from: w0, reason: from kotlin metadata */
    private final sdk.pendo.io.k3.d sinkBuffer;

    /* renamed from: x0, reason: from kotlin metadata */
    private boolean writerClosed;

    /* renamed from: y0, reason: from kotlin metadata */
    private a messageDeflater;

    /* renamed from: z0, reason: from kotlin metadata */
    private final byte[] maskKey;

    public h(boolean z, sdk.pendo.io.k3.e sink, Random random, boolean z2, boolean z3, long j) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(random, "random");
        this.isClient = z;
        this.sink = sink;
        this.random = random;
        this.perMessageDeflate = z2;
        this.noContextTakeover = z3;
        this.minimumDeflateSize = j;
        this.messageBuffer = new sdk.pendo.io.k3.d();
        this.sinkBuffer = sink.getBufferField();
        this.maskKey = z ? new byte[4] : null;
        this.maskCursor = z ? new d.a() : null;
    }

    private final void b(int opcode, sdk.pendo.io.k3.g payload) {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int l = payload.l();
        if (!(((long) l) <= 125)) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        this.sinkBuffer.writeByte(opcode | 128);
        if (this.isClient) {
            this.sinkBuffer.writeByte(l | 128);
            Random random = this.random;
            byte[] bArr = this.maskKey;
            Intrinsics.checkNotNull(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.write(this.maskKey);
            if (l > 0) {
                long size = this.sinkBuffer.getSize();
                this.sinkBuffer.a(payload);
                sdk.pendo.io.k3.d dVar = this.sinkBuffer;
                d.a aVar = this.maskCursor;
                Intrinsics.checkNotNull(aVar);
                dVar.a(aVar);
                this.maskCursor.i(size);
                f.f1225a.a(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.writeByte(l);
            this.sinkBuffer.a(payload);
        }
        this.sink.flush();
    }

    public final void a(int code, sdk.pendo.io.k3.g reason) {
        sdk.pendo.io.k3.g gVar = sdk.pendo.io.k3.g.t0;
        if (code != 0 || reason != null) {
            if (code != 0) {
                f.f1225a.b(code);
            }
            sdk.pendo.io.k3.d dVar = new sdk.pendo.io.k3.d();
            dVar.writeShort(code);
            if (reason != null) {
                dVar.a(reason);
            }
            gVar = dVar.t();
        }
        try {
            b(8, gVar);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void c(int formatOpcode, sdk.pendo.io.k3.g data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        this.messageBuffer.a(data);
        int i = formatOpcode | 128;
        if (this.perMessageDeflate && data.l() >= this.minimumDeflateSize) {
            a aVar = this.messageDeflater;
            if (aVar == null) {
                aVar = new a(this.noContextTakeover);
                this.messageDeflater = aVar;
            }
            aVar.a(this.messageBuffer);
            i |= 64;
        }
        long size = this.messageBuffer.getSize();
        this.sinkBuffer.writeByte(i);
        int i2 = this.isClient ? 128 : 0;
        if (size <= 125) {
            this.sinkBuffer.writeByte(((int) size) | i2);
        } else if (size <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.sinkBuffer.writeByte(i2 | 126);
            this.sinkBuffer.writeShort((int) size);
        } else {
            this.sinkBuffer.writeByte(i2 | 127);
            this.sinkBuffer.m(size);
        }
        if (this.isClient) {
            Random random = this.random;
            byte[] bArr = this.maskKey;
            Intrinsics.checkNotNull(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.write(this.maskKey);
            if (size > 0) {
                sdk.pendo.io.k3.d dVar = this.messageBuffer;
                d.a aVar2 = this.maskCursor;
                Intrinsics.checkNotNull(aVar2);
                dVar.a(aVar2);
                this.maskCursor.i(0L);
                f.f1225a.a(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        this.sinkBuffer.a(this.messageBuffer, size);
        this.sink.f();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a aVar = this.messageDeflater;
        if (aVar != null) {
            aVar.close();
        }
    }

    public final void b(sdk.pendo.io.k3.g payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        b(9, payload);
    }

    public final void c(sdk.pendo.io.k3.g payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        b(10, payload);
    }
}
