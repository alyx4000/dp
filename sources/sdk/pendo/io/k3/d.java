package sdk.pendo.io.k3;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.exifinterface.media.ExifInterface;
import com.extole.android.sdk.impl.http.HttpRequest;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.iterable.iterableapi.IterableConstants;
import io.sentry.protocol.ViewHierarchyNode;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Typography;
import okhttp3.internal.connection.RealConnection;
import okio.Utf8;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.tensorflow.lite.schema.BuiltinOptions;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u000fB\u0007¢\u0006\u0004\bc\u0010dJ\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0000H\u0016J\b\u0010\b\u001a\u00020\u0000H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u0014\u001a\u00020\u000bJ\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u000bH\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020%H\u0016J\u0018\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020*H\u0016J\u0010\u0010\n\u001a\u00020*2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0016J\u0018\u0010\u000f\u001a\u00020*2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020*H\u0016J\u0010\u00100\u001a\u00020*2\u0006\u0010/\u001a\u00020\u000bH\u0016J\b\u00101\u001a\u00020\u001cH\u0016J\b\u0010\u0018\u001a\u000202H\u0016J\u0010\u00103\u001a\u0002022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u00104\u001a\u00020\r2\u0006\u0010'\u001a\u000202H\u0016J \u00105\u001a\u00020\u001c2\u0006\u0010'\u001a\u0002022\u0006\u0010\u0013\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u001cH\u0016J\u0010\u00105\u001a\u00020\u001c2\u0006\u0010'\u001a\u000206H\u0016J\u0006\u00107\u001a\u00020\rJ\u0010\u00108\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020\u00002\u0006\u00109\u001a\u00020\"H\u0016J\u0010\u0010(\u001a\u00020\u00002\u0006\u0010:\u001a\u00020*H\u0016J \u0010\u000f\u001a\u00020\u00002\u0006\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u001cH\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u001cH\u0016J\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010:\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0016J(\u0010\u000f\u001a\u00020\u00002\u0006\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020,H\u0016J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010>\u001a\u000202H\u0016J \u0010\u000f\u001a\u00020\u00002\u0006\u0010>\u001a\u0002022\u0006\u0010\u0013\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u001cH\u0016J\u0010\u0010?\u001a\u00020\u001c2\u0006\u0010>\u001a\u000206H\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020@H\u0016J\u0010\u0010$\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u001cH\u0016J\u0010\u00100\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u001cH\u0016J\u0010\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u001cH\u0016J\u0010\u00107\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0010\u0010!\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0017\u0010(\u001a\u00020B2\u0006\u0010A\u001a\u00020\u001cH\u0000¢\u0006\u0004\b(\u0010CJ\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010>\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u000f\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000bH\u0016J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\"H\u0016J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\"2\u0006\u0010D\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\"H\u0016J(\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\"2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u001cH\u0016J\b\u0010I\u001a\u00020\rH\u0016J\b\u0010J\u001a\u00020\tH\u0016J\b\u0010K\u001a\u00020\rH\u0016J\b\u00103\u001a\u00020LH\u0016J\u0013\u0010O\u001a\u00020\t2\b\u0010N\u001a\u0004\u0018\u00010MH\u0096\u0002J\b\u0010P\u001a\u00020\u001cH\u0016J\b\u0010Q\u001a\u00020*H\u0016J\u0006\u0010R\u001a\u00020\u0000J\b\u0010S\u001a\u00020\u0000H\u0016J\u0006\u0010T\u001a\u00020\"J\u000e\u0010\u000f\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\u001cJ\u0012\u0010\u000f\u001a\u00020U2\b\b\u0002\u0010V\u001a\u00020UH\u0007R\u0018\u0010X\u001a\u0004\u0018\u00010B8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010WR*\u0010_\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\u000b8G@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0014\u0010b\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010a¨\u0006e"}, d2 = {"Lsdk/pendo/io/k3/d;", "Lsdk/pendo/io/k3/f;", "Lsdk/pendo/io/k3/e;", "", "Ljava/nio/channels/ByteChannel;", "Ljava/io/OutputStream;", "s", "r", "q", "", ContextChain.TAG_INFRA, "", "byteCount", "", "f", "a", "Ljava/io/InputStream;", "l", "out", "offset", "o", "", "readByte", "pos", "h", "(J)B", "", "readShort", "", "readInt", "readLong", "v", "u", "k", "Lsdk/pendo/io/k3/g;", "t", "c", "Lsdk/pendo/io/k3/r;", "options", "sink", "b", "Lsdk/pendo/io/k3/y;", "", "w", "Ljava/nio/charset/Charset;", HttpRequest.PARAM_CHARSET, "g", "limit", "e", ViewHierarchyNode.JsonKeys.X, "", "d", "readFully", IterableConstants.ITERABLE_IN_APP_READ, "Ljava/nio/ByteBuffer;", "m", "skip", "byteString", "string", "beginIndex", "endIndex", "codePoint", "source", "write", "Lsdk/pendo/io/k3/a0;", "minimumCapacity", "Lsdk/pendo/io/k3/v;", "(I)Lsdk/pendo/io/k3/v;", "fromIndex", "toIndex", "targetBytes", "bytes", "bytesOffset", "flush", "isOpen", "close", "Lsdk/pendo/io/k3/b0;", "", "other", "equals", "hashCode", "toString", ContextChain.TAG_PRODUCT, "n", "z", "Lsdk/pendo/io/k3/d$a;", "unsafeCursor", "Lsdk/pendo/io/k3/v;", "head", "<set-?>", "J", ViewHierarchyNode.JsonKeys.Y, "()J", "j", "(J)V", "size", "getBuffer", "()Lokio/Buffer;", "buffer", "<init>", "()V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class d implements f, e, Cloneable, ByteChannel {

    /* renamed from: f, reason: from kotlin metadata */
    public v head;

    /* renamed from: s, reason: from kotlin metadata */
    private long size;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\b\u0010\n\u001a\u00020\tH\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b$\u0010\"¨\u0006("}, d2 = {"Lsdk/pendo/io/k3/d$a;", "Ljava/io/Closeable;", "", "b", "", "offset", ContextChain.TAG_INFRA, "newSize", "h", "", "close", "Lsdk/pendo/io/k3/d;", "f", "Lsdk/pendo/io/k3/d;", "buffer", "", "s", "Z", "readWrite", "Lsdk/pendo/io/k3/v;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lsdk/pendo/io/k3/v;", "getSegment$okio", "()Lokio/Segment;", "setSegment$okio", "(Lokio/Segment;)V", "segment", "f0", "J", "", "t0", "[B", "data", "u0", "I", ViewProps.START, "v0", ViewProps.END, "<init>", "()V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    public static final class a implements Closeable {

        /* renamed from: A, reason: from kotlin metadata */
        private v segment;

        /* renamed from: f, reason: from kotlin metadata */
        public d buffer;

        /* renamed from: s, reason: from kotlin metadata */
        public boolean readWrite;

        /* renamed from: t0, reason: from kotlin metadata */
        public byte[] data;

        /* renamed from: f0, reason: from kotlin metadata */
        public long offset = -1;

        /* renamed from: u0, reason: from kotlin metadata */
        public int start = -1;

        /* renamed from: v0, reason: from kotlin metadata */
        public int end = -1;

        /* renamed from: a, reason: from getter */
        public final v getSegment() {
            return this.segment;
        }

        public final int b() {
            long j = this.offset;
            d dVar = this.buffer;
            Intrinsics.checkNotNull(dVar);
            if (!(j != dVar.getSize())) {
                throw new IllegalStateException("no more bytes".toString());
            }
            long j2 = this.offset;
            return i(j2 == -1 ? 0L : j2 + (this.end - this.start));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!(this.buffer != null)) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.buffer = null;
            a(null);
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long h(long newSize) {
            d dVar = this.buffer;
            if (dVar == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            long size = dVar.getSize();
            int i = 1;
            if (newSize <= size) {
                if (!(newSize >= 0)) {
                    throw new IllegalArgumentException(("newSize < 0: " + newSize).toString());
                }
                long j = size - newSize;
                while (true) {
                    if (j <= 0) {
                        break;
                    }
                    v vVar = dVar.head;
                    Intrinsics.checkNotNull(vVar);
                    v vVar2 = vVar.prev;
                    Intrinsics.checkNotNull(vVar2);
                    int i2 = vVar2.limit;
                    long j2 = i2 - vVar2.pos;
                    if (j2 > j) {
                        vVar2.limit = i2 - ((int) j);
                        break;
                    }
                    dVar.head = vVar2.b();
                    w.a(vVar2);
                    j -= j2;
                }
                a(null);
                this.offset = newSize;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (newSize > size) {
                long j3 = newSize - size;
                boolean z = true;
                while (j3 > 0) {
                    v b = dVar.b(i);
                    int min = (int) Math.min(j3, 8192 - b.limit);
                    b.limit += min;
                    j3 -= min;
                    if (z) {
                        a(b);
                        this.offset = size;
                        this.data = b.data;
                        int i3 = b.limit;
                        this.start = i3 - min;
                        this.end = i3;
                        z = false;
                    }
                    i = 1;
                }
            }
            dVar.j(newSize);
            return size;
        }

        public final int i(long offset) {
            v vVar;
            d dVar = this.buffer;
            if (dVar == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (offset < -1 || offset > dVar.getSize()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + offset + " > size=" + dVar.getSize());
            }
            if (offset == -1 || offset == dVar.getSize()) {
                a(null);
                this.offset = offset;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            }
            long size = dVar.getSize();
            v vVar2 = dVar.head;
            long j = 0;
            if (getSegment() != null) {
                long j2 = this.offset;
                int i = this.start;
                Intrinsics.checkNotNull(getSegment());
                long j3 = j2 - (i - r9.pos);
                if (j3 > offset) {
                    vVar = vVar2;
                    vVar2 = getSegment();
                    size = j3;
                } else {
                    vVar = getSegment();
                    j = j3;
                }
            } else {
                vVar = vVar2;
            }
            if (size - offset > offset - j) {
                while (true) {
                    Intrinsics.checkNotNull(vVar);
                    long j4 = (vVar.limit - vVar.pos) + j;
                    if (offset < j4) {
                        break;
                    }
                    vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                    j = j4;
                }
            } else {
                while (size > offset) {
                    Intrinsics.checkNotNull(vVar2);
                    vVar2 = vVar2.prev;
                    Intrinsics.checkNotNull(vVar2);
                    size -= vVar2.limit - vVar2.pos;
                }
                j = size;
                vVar = vVar2;
            }
            if (this.readWrite) {
                Intrinsics.checkNotNull(vVar);
                if (vVar.shared) {
                    v d = vVar.d();
                    if (dVar.head == vVar) {
                        dVar.head = d;
                    }
                    vVar = vVar.a(d);
                    v vVar3 = vVar.prev;
                    Intrinsics.checkNotNull(vVar3);
                    vVar3.b();
                }
            }
            a(vVar);
            this.offset = offset;
            Intrinsics.checkNotNull(vVar);
            this.data = vVar.data;
            int i2 = vVar.pos + ((int) (offset - j));
            this.start = i2;
            int i3 = vVar.limit;
            this.end = i3;
            return i3 - i2;
        }

        public final void a(v vVar) {
            this.segment = vVar;
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"sdk/pendo/io/k3/d$b", "Ljava/io/InputStream;", "", IterableConstants.ITERABLE_IN_APP_READ, "", "sink", "offset", "byteCount", "available", "", "close", "", "toString", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    public static final class b extends InputStream {
        b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(d.this.getSize(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (d.this.getSize() > 0) {
                return d.this.readByte() & UByte.MAX_VALUE;
            }
            return -1;
        }

        public String toString() {
            return d.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] sink, int offset, int byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return d.this.read(sink, offset, byteCount);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"sdk/pendo/io/k3/d$c", "Ljava/io/OutputStream;", "", "b", "", "write", "", "data", "offset", "byteCount", "flush", "close", "", "toString", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    public static final class c extends OutputStream {
        c() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return d.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int b) {
            d.this.writeByte(b);
        }

        @Override // java.io.OutputStream
        public void write(byte[] data, int offset, int byteCount) {
            Intrinsics.checkNotNullParameter(data, "data");
            d.this.write(data, offset, byteCount);
        }
    }

    public final d a(d out, long offset, long byteCount) {
        Intrinsics.checkNotNullParameter(out, "out");
        sdk.pendo.io.k3.b.a(getSize(), offset, byteCount);
        if (byteCount != 0) {
            out.j(out.getSize() + byteCount);
            v vVar = this.head;
            while (true) {
                Intrinsics.checkNotNull(vVar);
                long j = vVar.limit - vVar.pos;
                if (offset < j) {
                    break;
                }
                offset -= j;
                vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
            }
            while (byteCount > 0) {
                Intrinsics.checkNotNull(vVar);
                v c2 = vVar.c();
                int i = c2.pos + ((int) offset);
                c2.pos = i;
                c2.limit = Math.min(i + ((int) byteCount), c2.limit);
                v vVar2 = out.head;
                if (vVar2 == null) {
                    c2.prev = c2;
                    c2.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String = c2;
                    out.head = c2;
                } else {
                    Intrinsics.checkNotNull(vVar2);
                    v vVar3 = vVar2.prev;
                    Intrinsics.checkNotNull(vVar3);
                    vVar3.a(c2);
                }
                byteCount -= c2.limit - c2.pos;
                vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                offset = 0;
            }
        }
        return this;
    }

    public long b(g targetBytes) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        return a(targetBytes, 0L);
    }

    @Override // sdk.pendo.io.k3.f, sdk.pendo.io.k3.e
    public d c() {
        return this;
    }

    @Override // sdk.pendo.io.k3.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // sdk.pendo.io.k3.f
    public byte[] d(long byteCount) {
        if (!(byteCount >= 0 && byteCount <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (getSize() < byteCount) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) byteCount];
        readFully(bArr);
        return bArr;
    }

    @Override // sdk.pendo.io.k3.f
    public String e(long limit) {
        if (!(limit >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + limit).toString());
        }
        long j = limit != Long.MAX_VALUE ? limit + 1 : Long.MAX_VALUE;
        long a2 = a((byte) 10, 0L, j);
        if (a2 != -1) {
            return sdk.pendo.io.l3.a.a(this, a2);
        }
        if (j < getSize() && h(j - 1) == 13 && h(j) == 10) {
            return sdk.pendo.io.l3.a.a(this, j);
        }
        d dVar = new d();
        a(dVar, 0L, Math.min(32, getSize()));
        throw new EOFException("\\n not found: limit=" + Math.min(getSize(), limit) + " content=" + dVar.t().h() + Typography.ellipsis);
    }

    public boolean equals(Object other) {
        if (this != other) {
            if (other instanceof d) {
                d dVar = (d) other;
                if (getSize() == dVar.getSize()) {
                    if (getSize() != 0) {
                        v vVar = this.head;
                        Intrinsics.checkNotNull(vVar);
                        v vVar2 = dVar.head;
                        Intrinsics.checkNotNull(vVar2);
                        int i = vVar.pos;
                        int i2 = vVar2.pos;
                        long j = 0;
                        while (j < getSize()) {
                            long min = Math.min(vVar.limit - i, vVar2.limit - i2);
                            long j2 = 0;
                            while (j2 < min) {
                                int i3 = i + 1;
                                int i4 = i2 + 1;
                                if (vVar.data[i] == vVar2.data[i2]) {
                                    j2++;
                                    i = i3;
                                    i2 = i4;
                                }
                            }
                            if (i == vVar.limit) {
                                vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                                Intrinsics.checkNotNull(vVar);
                                i = vVar.pos;
                            }
                            if (i2 == vVar2.limit) {
                                vVar2 = vVar2.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                                Intrinsics.checkNotNull(vVar2);
                                i2 = vVar2.pos;
                            }
                            j += min;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // sdk.pendo.io.k3.e, sdk.pendo.io.k3.y, java.io.Flushable
    public void flush() {
    }

    @Override // sdk.pendo.io.k3.f
    public String g() {
        return e(Long.MAX_VALUE);
    }

    public final byte h(long pos) {
        sdk.pendo.io.k3.b.a(getSize(), pos, 1L);
        v vVar = this.head;
        if (vVar == null) {
            Intrinsics.checkNotNull(null);
            throw null;
        }
        if (getSize() - pos < pos) {
            long size = getSize();
            while (size > pos) {
                vVar = vVar.prev;
                Intrinsics.checkNotNull(vVar);
                size -= vVar.limit - vVar.pos;
            }
            Intrinsics.checkNotNull(vVar);
            return vVar.data[(int) ((vVar.pos + pos) - size)];
        }
        long j = 0;
        while (true) {
            long j2 = (vVar.limit - vVar.pos) + j;
            if (j2 > pos) {
                Intrinsics.checkNotNull(vVar);
                return vVar.data[(int) ((vVar.pos + pos) - j)];
            }
            vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
            Intrinsics.checkNotNull(vVar);
            j = j2;
        }
    }

    public int hashCode() {
        v vVar = this.head;
        if (vVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = vVar.limit;
            for (int i3 = vVar.pos; i3 < i2; i3++) {
                i = (i * 31) + vVar.data[i3];
            }
            vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
            Intrinsics.checkNotNull(vVar);
        } while (vVar != this.head);
        return i;
    }

    @Override // sdk.pendo.io.k3.f
    public boolean i() {
        return this.size == 0;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a6 A[EDGE_INSN: B:41:0x00a6->B:38:0x00a6 BREAK  A[LOOP:0: B:4:0x000d->B:40:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009e  */
    @Override // sdk.pendo.io.k3.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long k() {
        /*
            r14 = this;
            long r0 = r14.getSize()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lb0
            r0 = 0
            r1 = r0
            r4 = r2
        Ld:
            sdk.pendo.io.k3.v r6 = r14.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L18:
            if (r8 >= r9) goto L92
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L27
            r11 = 57
            if (r10 > r11) goto L27
            int r11 = r10 + (-48)
            goto L3f
        L27:
            r11 = 97
            if (r10 < r11) goto L34
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L34
            int r11 = r10 + (-97)
        L31:
            int r11 = r11 + 10
            goto L3f
        L34:
            r11 = 65
            if (r10 < r11) goto L75
            r11 = 70
            if (r10 > r11) goto L75
            int r11 = r10 + (-65)
            goto L31
        L3f:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L4f
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L4f:
            sdk.pendo.io.k3.d r0 = new sdk.pendo.io.k3.d
            r0.<init>()
            sdk.pendo.io.k3.d r0 = r0.b(r4)
            sdk.pendo.io.k3.d r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Number too large: "
            r2.<init>(r3)
            java.lang.String r0 = r0.w()
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L75:
            if (r0 == 0) goto L79
            r1 = 1
            goto L92
        L79:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.<init>(r2)
            java.lang.String r2 = sdk.pendo.io.k3.b.a(r10)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L92:
            if (r8 != r9) goto L9e
            sdk.pendo.io.k3.v r7 = r6.b()
            r14.head = r7
            sdk.pendo.io.k3.w.a(r6)
            goto La0
        L9e:
            r6.pos = r8
        La0:
            if (r1 != 0) goto La6
            sdk.pendo.io.k3.v r6 = r14.head
            if (r6 != 0) goto Ld
        La6:
            long r1 = r14.getSize()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.j(r1)
            return r4
        Lb0:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.k3.d.k():long");
    }

    @Override // sdk.pendo.io.k3.f
    public InputStream l() {
        return new b();
    }

    public final void m() {
        skip(getSize());
    }

    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public d clone() {
        return p();
    }

    public final long o() {
        long size = getSize();
        if (size == 0) {
            return 0L;
        }
        v vVar = this.head;
        Intrinsics.checkNotNull(vVar);
        v vVar2 = vVar.prev;
        Intrinsics.checkNotNull(vVar2);
        return (vVar2.limit >= 8192 || !vVar2.owner) ? size : size - (r3 - vVar2.pos);
    }

    public final d p() {
        d dVar = new d();
        if (getSize() != 0) {
            v vVar = this.head;
            Intrinsics.checkNotNull(vVar);
            v c2 = vVar.c();
            dVar.head = c2;
            c2.prev = c2;
            c2.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String = c2;
            for (v vVar2 = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String; vVar2 != vVar; vVar2 = vVar2.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String) {
                v vVar3 = c2.prev;
                Intrinsics.checkNotNull(vVar3);
                Intrinsics.checkNotNull(vVar2);
                vVar3.a(vVar2.c());
            }
            dVar.j(getSize());
        }
        return dVar;
    }

    @Override // sdk.pendo.io.k3.e
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public d f() {
        return this;
    }

    @Override // sdk.pendo.io.k3.e
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public d j() {
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        v vVar = this.head;
        if (vVar == null) {
            return -1;
        }
        int min = Math.min(sink.remaining(), vVar.limit - vVar.pos);
        sink.put(vVar.data, vVar.pos, min);
        int i = vVar.pos + min;
        vVar.pos = i;
        this.size -= min;
        if (i == vVar.limit) {
            this.head = vVar.b();
            w.a(vVar);
        }
        return min;
    }

    @Override // sdk.pendo.io.k3.f
    public byte readByte() {
        if (getSize() == 0) {
            throw new EOFException();
        }
        v vVar = this.head;
        Intrinsics.checkNotNull(vVar);
        int i = vVar.pos;
        int i2 = vVar.limit;
        int i3 = i + 1;
        byte b2 = vVar.data[i];
        j(getSize() - 1);
        if (i3 == i2) {
            this.head = vVar.b();
            w.a(vVar);
        } else {
            vVar.pos = i3;
        }
        return b2;
    }

    @Override // sdk.pendo.io.k3.f
    public void readFully(byte[] sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        int i = 0;
        while (i < sink.length) {
            int read = read(sink, i, sink.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    @Override // sdk.pendo.io.k3.f
    public int readInt() {
        if (getSize() < 4) {
            throw new EOFException();
        }
        v vVar = this.head;
        Intrinsics.checkNotNull(vVar);
        int i = vVar.pos;
        int i2 = vVar.limit;
        if (i2 - i < 4) {
            return ((readByte() & UByte.MAX_VALUE) << 24) | ((readByte() & UByte.MAX_VALUE) << 16) | ((readByte() & UByte.MAX_VALUE) << 8) | (readByte() & UByte.MAX_VALUE);
        }
        byte[] bArr = vVar.data;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i3] & UByte.MAX_VALUE) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & UByte.MAX_VALUE) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & UByte.MAX_VALUE);
        j(getSize() - 4);
        if (i8 == i2) {
            this.head = vVar.b();
            w.a(vVar);
        } else {
            vVar.pos = i8;
        }
        return i9;
    }

    @Override // sdk.pendo.io.k3.f
    public long readLong() {
        if (getSize() < 8) {
            throw new EOFException();
        }
        v vVar = this.head;
        Intrinsics.checkNotNull(vVar);
        int i = vVar.pos;
        int i2 = vVar.limit;
        if (i2 - i < 8) {
            return ((readInt() & BodyPartID.bodyIdMax) << 32) | (BodyPartID.bodyIdMax & readInt());
        }
        byte[] bArr = vVar.data;
        long j = (bArr[i] & 255) << 56;
        int i3 = i + 1 + 1 + 1;
        long j2 = j | ((bArr[r7] & 255) << 48) | ((bArr[r1] & 255) << 40);
        long j3 = j2 | ((bArr[i3] & 255) << 32) | ((bArr[r1] & 255) << 24);
        long j4 = j3 | ((bArr[r8] & 255) << 16);
        long j5 = j4 | ((bArr[r1] & 255) << 8);
        int i4 = i3 + 1 + 1 + 1 + 1 + 1;
        long j6 = j5 | (bArr[r8] & 255);
        j(getSize() - 8);
        if (i4 == i2) {
            this.head = vVar.b();
            w.a(vVar);
        } else {
            vVar.pos = i4;
        }
        return j6;
    }

    @Override // sdk.pendo.io.k3.f
    public short readShort() {
        if (getSize() < 2) {
            throw new EOFException();
        }
        v vVar = this.head;
        Intrinsics.checkNotNull(vVar);
        int i = vVar.pos;
        int i2 = vVar.limit;
        if (i2 - i < 2) {
            return (short) (((readByte() & UByte.MAX_VALUE) << 8) | (readByte() & UByte.MAX_VALUE));
        }
        byte[] bArr = vVar.data;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & UByte.MAX_VALUE) << 8) | (bArr[i3] & UByte.MAX_VALUE);
        j(getSize() - 2);
        if (i4 == i2) {
            this.head = vVar.b();
            w.a(vVar);
        } else {
            vVar.pos = i4;
        }
        return (short) i5;
    }

    public OutputStream s() {
        return new c();
    }

    @Override // sdk.pendo.io.k3.f
    public void skip(long byteCount) {
        while (byteCount > 0) {
            v vVar = this.head;
            if (vVar == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(byteCount, vVar.limit - vVar.pos);
            long j = min;
            j(getSize() - j);
            byteCount -= j;
            int i = vVar.pos + min;
            vVar.pos = i;
            if (i == vVar.limit) {
                this.head = vVar.b();
                w.a(vVar);
            }
        }
    }

    public g t() {
        return c(getSize());
    }

    public String toString() {
        return z().toString();
    }

    public int u() {
        return sdk.pendo.io.k3.b.a(readInt());
    }

    public short v() {
        return sdk.pendo.io.k3.b.a(readShort());
    }

    public String w() {
        return a(this.size, Charsets.UTF_8);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        int remaining = source.remaining();
        int i = remaining;
        while (i > 0) {
            v b2 = b(1);
            int min = Math.min(i, 8192 - b2.limit);
            source.get(b2.data, b2.limit, min);
            i -= min;
            b2.limit += min;
        }
        this.size += remaining;
        return remaining;
    }

    public int x() {
        int i;
        int i2;
        int i3;
        if (getSize() == 0) {
            throw new EOFException();
        }
        byte h = h(0L);
        boolean z = false;
        if ((h & ByteCompanionObject.MIN_VALUE) == 0) {
            i = h & ByteCompanionObject.MAX_VALUE;
            i3 = 0;
            i2 = 1;
        } else if ((h & 224) == 192) {
            i = h & BuiltinOptions.SequenceRNNOptions;
            i2 = 2;
            i3 = 128;
        } else if ((h & 240) == 224) {
            i = h & 15;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((h & 248) != 240) {
                skip(1L);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i = h & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (getSize() < j) {
            throw new EOFException("size < " + i2 + ": " + getSize() + " (to read code point prefixed 0x" + sdk.pendo.io.k3.b.a(h) + ')');
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte h2 = h(j2);
            if ((h2 & 192) != 128) {
                skip(j2);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i = (i << 6) | (h2 & 63);
        }
        skip(j);
        if (i > 1114111) {
            return Utf8.REPLACEMENT_CODE_POINT;
        }
        if (55296 <= i && i < 57344) {
            z = true;
        }
        return (!z && i >= i3) ? i : Utf8.REPLACEMENT_CODE_POINT;
    }

    /* renamed from: y, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    public final g z() {
        if (getSize() <= 2147483647L) {
            return a((int) getSize());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + getSize()).toString());
    }

    public long a(byte b2, long fromIndex, long toIndex) {
        v vVar;
        int i;
        long j = 0;
        if (!(0 <= fromIndex && fromIndex <= toIndex)) {
            throw new IllegalArgumentException(("size=" + getSize() + " fromIndex=" + fromIndex + " toIndex=" + toIndex).toString());
        }
        if (toIndex > getSize()) {
            toIndex = getSize();
        }
        if (fromIndex != toIndex && (vVar = this.head) != null) {
            if (getSize() - fromIndex < fromIndex) {
                j = getSize();
                while (j > fromIndex) {
                    vVar = vVar.prev;
                    Intrinsics.checkNotNull(vVar);
                    j -= vVar.limit - vVar.pos;
                }
                while (j < toIndex) {
                    byte[] bArr = vVar.data;
                    int min = (int) Math.min(vVar.limit, (vVar.pos + toIndex) - j);
                    i = (int) ((vVar.pos + fromIndex) - j);
                    while (i < min) {
                        if (bArr[i] == b2) {
                            return (i - vVar.pos) + j;
                        }
                        i++;
                    }
                    j += vVar.limit - vVar.pos;
                    vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                    Intrinsics.checkNotNull(vVar);
                    fromIndex = j;
                }
            } else {
                while (true) {
                    long j2 = (vVar.limit - vVar.pos) + j;
                    if (j2 > fromIndex) {
                        break;
                    }
                    vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                    Intrinsics.checkNotNull(vVar);
                    j = j2;
                }
                while (j < toIndex) {
                    byte[] bArr2 = vVar.data;
                    int min2 = (int) Math.min(vVar.limit, (vVar.pos + toIndex) - j);
                    i = (int) ((vVar.pos + fromIndex) - j);
                    while (i < min2) {
                        if (bArr2[i] == b2) {
                            return (i - vVar.pos) + j;
                        }
                        i++;
                    }
                    j += vVar.limit - vVar.pos;
                    vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                    Intrinsics.checkNotNull(vVar);
                    fromIndex = j;
                }
            }
        }
        return -1L;
    }

    @Override // sdk.pendo.io.k3.f
    public void b(d sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (getSize() >= byteCount) {
            sink.a(this, byteCount);
        } else {
            sink.a(this, getSize());
            throw new EOFException();
        }
    }

    @Override // sdk.pendo.io.k3.a0
    public long c(d sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (getSize() == 0) {
            return -1L;
        }
        if (byteCount > getSize()) {
            byteCount = getSize();
        }
        sink.a(this, byteCount);
        return byteCount;
    }

    @Override // sdk.pendo.io.k3.a0
    public b0 d() {
        return b0.e;
    }

    @Override // sdk.pendo.io.k3.e
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public d writeShort(int s) {
        v b2 = b(2);
        byte[] bArr = b2.data;
        int i = b2.limit;
        int i2 = i + 1;
        bArr[i] = (byte) ((s >>> 8) & 255);
        bArr[i2] = (byte) (s & 255);
        b2.limit = i2 + 1;
        j(getSize() + 2);
        return this;
    }

    @Override // sdk.pendo.io.k3.f
    public void f(long byteCount) {
        if (this.size < byteCount) {
            throw new EOFException();
        }
    }

    @Override // sdk.pendo.io.k3.f
    public byte[] h() {
        return d(getSize());
    }

    public String i(long byteCount) {
        return a(byteCount, Charsets.UTF_8);
    }

    public final void j(long j) {
        this.size = j;
    }

    @Override // sdk.pendo.io.k3.e
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public d g(long v) {
        boolean z;
        if (v == 0) {
            return writeByte(48);
        }
        int i = 1;
        if (v < 0) {
            v = -v;
            if (v < 0) {
                return a("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (v >= 100000000) {
            i = v < 1000000000000L ? v < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? v < 1000000000 ? 9 : 10 : v < 100000000000L ? 11 : 12 : v < 1000000000000000L ? v < 10000000000000L ? 13 : v < 100000000000000L ? 14 : 15 : v < 100000000000000000L ? v < 10000000000000000L ? 16 : 17 : v < 1000000000000000000L ? 18 : 19;
        } else if (v >= DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM) {
            i = v < 1000000 ? v < 100000 ? 5 : 6 : v < 10000000 ? 7 : 8;
        } else if (v >= 100) {
            i = v < 1000 ? 3 : 4;
        } else if (v >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        v b2 = b(i);
        byte[] bArr = b2.data;
        int i2 = b2.limit + i;
        while (v != 0) {
            long j = 10;
            i2--;
            bArr[i2] = sdk.pendo.io.l3.a.a()[(int) (v % j)];
            v /= j;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        b2.limit += i;
        j(getSize() + i);
        return this;
    }

    @Override // sdk.pendo.io.k3.e
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public d b(long v) {
        if (v == 0) {
            return writeByte(48);
        }
        long j = (v >>> 1) | v;
        long j2 = j | (j >>> 2);
        long j3 = j2 | (j2 >>> 4);
        long j4 = j3 | (j3 >>> 8);
        long j5 = j4 | (j4 >>> 16);
        long j6 = j5 | (j5 >>> 32);
        long j7 = j6 - ((j6 >>> 1) & 6148914691236517205L);
        long j8 = ((j7 >>> 2) & 3689348814741910323L) + (j7 & 3689348814741910323L);
        long j9 = ((j8 >>> 4) + j8) & 1085102592571150095L;
        long j10 = j9 + (j9 >>> 8);
        long j11 = j10 + (j10 >>> 16);
        int i = (int) ((((j11 & 63) + ((j11 >>> 32) & 63)) + 3) / 4);
        v b2 = b(i);
        byte[] bArr = b2.data;
        int i2 = b2.limit;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = sdk.pendo.io.l3.a.a()[(int) (15 & v)];
            v >>>= 4;
        }
        b2.limit += i;
        j(getSize() + i);
        return this;
    }

    public d m(long v) {
        v b2 = b(8);
        byte[] bArr = b2.data;
        int i = b2.limit;
        int i2 = i + 1;
        bArr[i] = (byte) ((v >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((v >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((v >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((v >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((v >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((v >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((v >>> 8) & 255);
        bArr[i8] = (byte) (v & 255);
        b2.limit = i8 + 1;
        j(getSize() + 8);
        return this;
    }

    public int read(byte[] sink, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        sdk.pendo.io.k3.b.a(sink.length, offset, byteCount);
        v vVar = this.head;
        if (vVar == null) {
            return -1;
        }
        int min = Math.min(byteCount, vVar.limit - vVar.pos);
        byte[] bArr = vVar.data;
        int i = vVar.pos;
        ArraysKt.copyInto(bArr, sink, offset, i, i + min);
        vVar.pos += min;
        j(getSize() - min);
        if (vVar.pos == vVar.limit) {
            this.head = vVar.b();
            w.a(vVar);
        }
        return min;
    }

    public long a(g targetBytes, long fromIndex) {
        int i;
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        long j = 0;
        if (!(fromIndex >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + fromIndex).toString());
        }
        v vVar = this.head;
        if (vVar != null) {
            if (getSize() - fromIndex < fromIndex) {
                j = getSize();
                while (j > fromIndex) {
                    vVar = vVar.prev;
                    Intrinsics.checkNotNull(vVar);
                    j -= vVar.limit - vVar.pos;
                }
                if (targetBytes.l() == 2) {
                    byte a2 = targetBytes.a(0);
                    byte a3 = targetBytes.a(1);
                    while (j < getSize()) {
                        byte[] bArr = vVar.data;
                        i = (int) ((vVar.pos + fromIndex) - j);
                        int i2 = vVar.limit;
                        while (i < i2) {
                            byte b2 = bArr[i];
                            if (b2 != a2 && b2 != a3) {
                                i++;
                            }
                            return (i - vVar.pos) + j;
                        }
                        j += vVar.limit - vVar.pos;
                        vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                        Intrinsics.checkNotNull(vVar);
                        fromIndex = j;
                    }
                } else {
                    byte[] i3 = targetBytes.i();
                    while (j < getSize()) {
                        byte[] bArr2 = vVar.data;
                        i = (int) ((vVar.pos + fromIndex) - j);
                        int i4 = vVar.limit;
                        while (i < i4) {
                            byte b3 = bArr2[i];
                            for (byte b4 : i3) {
                                if (b3 == b4) {
                                    return (i - vVar.pos) + j;
                                }
                            }
                            i++;
                        }
                        j += vVar.limit - vVar.pos;
                        vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                        Intrinsics.checkNotNull(vVar);
                        fromIndex = j;
                    }
                }
            } else {
                while (true) {
                    long j2 = (vVar.limit - vVar.pos) + j;
                    if (j2 > fromIndex) {
                        break;
                    }
                    vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                    Intrinsics.checkNotNull(vVar);
                    j = j2;
                }
                if (targetBytes.l() == 2) {
                    byte a4 = targetBytes.a(0);
                    byte a5 = targetBytes.a(1);
                    while (j < getSize()) {
                        byte[] bArr3 = vVar.data;
                        i = (int) ((vVar.pos + fromIndex) - j);
                        int i5 = vVar.limit;
                        while (i < i5) {
                            byte b5 = bArr3[i];
                            if (b5 != a4 && b5 != a5) {
                                i++;
                            }
                            return (i - vVar.pos) + j;
                        }
                        j += vVar.limit - vVar.pos;
                        vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                        Intrinsics.checkNotNull(vVar);
                        fromIndex = j;
                    }
                } else {
                    byte[] i6 = targetBytes.i();
                    while (j < getSize()) {
                        byte[] bArr4 = vVar.data;
                        i = (int) ((vVar.pos + fromIndex) - j);
                        int i7 = vVar.limit;
                        while (i < i7) {
                            byte b6 = bArr4[i];
                            for (byte b7 : i6) {
                                if (b6 == b7) {
                                    return (i - vVar.pos) + j;
                                }
                            }
                            i++;
                        }
                        j += vVar.limit - vVar.pos;
                        vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                        Intrinsics.checkNotNull(vVar);
                        fromIndex = j;
                    }
                }
            }
        }
        return -1L;
    }

    public final v b(int minimumCapacity) {
        if (!(minimumCapacity >= 1 && minimumCapacity <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        v vVar = this.head;
        if (vVar != null) {
            Intrinsics.checkNotNull(vVar);
            v vVar2 = vVar.prev;
            Intrinsics.checkNotNull(vVar2);
            return (vVar2.limit + minimumCapacity > 8192 || !vVar2.owner) ? vVar2.a(w.b()) : vVar2;
        }
        v b2 = w.b();
        this.head = b2;
        b2.prev = b2;
        b2.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String = b2;
        return b2;
    }

    @Override // sdk.pendo.io.k3.f
    public g c(long byteCount) {
        if (!(byteCount >= 0 && byteCount <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (getSize() < byteCount) {
            throw new EOFException();
        }
        if (byteCount < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            return new g(d(byteCount));
        }
        g a2 = a((int) byteCount);
        skip(byteCount);
        return a2;
    }

    @Override // sdk.pendo.io.k3.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public d writeInt(int i) {
        v b2 = b(4);
        byte[] bArr = b2.data;
        int i2 = b2.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        b2.limit = i5 + 1;
        j(getSize() + 4);
        return this;
    }

    public d f(int codePoint) {
        long size;
        long j;
        if (codePoint < 128) {
            writeByte(codePoint);
        } else {
            if (codePoint < 2048) {
                v b2 = b(2);
                byte[] bArr = b2.data;
                int i = b2.limit;
                bArr[i] = (byte) ((codePoint >> 6) | 192);
                bArr[i + 1] = (byte) ((codePoint & 63) | 128);
                b2.limit = i + 2;
                size = getSize();
                j = 2;
            } else {
                if (55296 <= codePoint && codePoint < 57344) {
                    writeByte(63);
                } else if (codePoint < 65536) {
                    v b3 = b(3);
                    byte[] bArr2 = b3.data;
                    int i2 = b3.limit;
                    bArr2[i2] = (byte) ((codePoint >> 12) | BERTags.FLAGS);
                    bArr2[i2 + 1] = (byte) (((codePoint >> 6) & 63) | 128);
                    bArr2[i2 + 2] = (byte) ((codePoint & 63) | 128);
                    b3.limit = i2 + 3;
                    size = getSize();
                    j = 3;
                } else {
                    if (codePoint > 1114111) {
                        throw new IllegalArgumentException("Unexpected code point: 0x" + sdk.pendo.io.k3.b.b(codePoint));
                    }
                    v b4 = b(4);
                    byte[] bArr3 = b4.data;
                    int i3 = b4.limit;
                    bArr3[i3] = (byte) ((codePoint >> 18) | 240);
                    bArr3[i3 + 1] = (byte) (((codePoint >> 12) & 63) | 128);
                    bArr3[i3 + 2] = (byte) (((codePoint >> 6) & 63) | 128);
                    bArr3[i3 + 3] = (byte) ((codePoint & 63) | 128);
                    b4.limit = i3 + 4;
                    size = getSize();
                    j = 4;
                }
            }
            j(size + j);
        }
        return this;
    }

    public boolean a(long offset, g bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return a(offset, bytes, 0, bytes.l());
    }

    @Override // sdk.pendo.io.k3.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d a(g byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.a(this, 0, byteString.l());
        return this;
    }

    public boolean a(long offset, g bytes, int bytesOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (offset < 0 || bytesOffset < 0 || byteCount < 0 || getSize() - offset < byteCount || bytes.l() - bytesOffset < byteCount) {
            return false;
        }
        for (int i = 0; i < byteCount; i++) {
            if (h(i + offset) != bytes.a(bytesOffset + i)) {
                return false;
            }
        }
        return true;
    }

    @Override // sdk.pendo.io.k3.e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d a(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return a(string, 0, string.length());
    }

    @Override // sdk.pendo.io.k3.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d writeByte(int b2) {
        v b3 = b(1);
        byte[] bArr = b3.data;
        int i = b3.limit;
        b3.limit = i + 1;
        bArr[i] = (byte) b2;
        j(getSize() + 1);
        return this;
    }

    @Override // sdk.pendo.io.k3.f
    public long a(y sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long size = getSize();
        if (size > 0) {
            sink.a(this, size);
        }
        return size;
    }

    public final a a(a unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return sdk.pendo.io.l3.a.a(this, unsafeCursor);
    }

    public static /* synthetic */ a a(d dVar, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = sdk.pendo.io.k3.b.b();
        }
        return dVar.a(aVar);
    }

    public String a(long byteCount, Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (!(byteCount >= 0 && byteCount <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (this.size < byteCount) {
            throw new EOFException();
        }
        if (byteCount == 0) {
            return "";
        }
        v vVar = this.head;
        Intrinsics.checkNotNull(vVar);
        int i = vVar.pos;
        if (i + byteCount > vVar.limit) {
            return new String(d(byteCount), charset);
        }
        int i2 = (int) byteCount;
        String str = new String(vVar.data, i, i2, charset);
        int i3 = vVar.pos + i2;
        vVar.pos = i3;
        this.size -= byteCount;
        if (i3 == vVar.limit) {
            this.head = vVar.b();
            w.a(vVar);
        }
        return str;
    }

    @Override // sdk.pendo.io.k3.f
    public String a(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return a(this.size, charset);
    }

    @Override // sdk.pendo.io.k3.f
    public boolean a(long byteCount) {
        return this.size >= byteCount;
    }

    @Override // sdk.pendo.io.k3.f
    public int a(r options) {
        Intrinsics.checkNotNullParameter(options, "options");
        int a2 = sdk.pendo.io.l3.a.a(this, options, false, 2, null);
        if (a2 == -1) {
            return -1;
        }
        skip(options.getByteStrings()[a2].l());
        return a2;
    }

    public final g a(int byteCount) {
        if (byteCount == 0) {
            return g.t0;
        }
        sdk.pendo.io.k3.b.a(getSize(), 0L, byteCount);
        v vVar = this.head;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < byteCount) {
            Intrinsics.checkNotNull(vVar);
            int i4 = vVar.limit;
            int i5 = vVar.pos;
            if (i4 == i5) {
                throw new AssertionError("s.limit == s.pos");
            }
            i2 += i4 - i5;
            i3++;
            vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
        }
        byte[][] bArr = new byte[i3][];
        int[] iArr = new int[i3 * 2];
        v vVar2 = this.head;
        int i6 = 0;
        while (i < byteCount) {
            Intrinsics.checkNotNull(vVar2);
            bArr[i6] = vVar2.data;
            i += vVar2.limit - vVar2.pos;
            iArr[i6] = Math.min(i, byteCount);
            iArr[i6 + i3] = vVar2.pos;
            vVar2.shared = true;
            i6++;
            vVar2 = vVar2.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
        }
        return new x(bArr, iArr);
    }

    @Override // sdk.pendo.io.k3.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d write(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return write(source, 0, source.length);
    }

    @Override // sdk.pendo.io.k3.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d write(byte[] source, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = byteCount;
        sdk.pendo.io.k3.b.a(source.length, offset, j);
        int i = byteCount + offset;
        while (offset < i) {
            v b2 = b(1);
            int min = Math.min(i - offset, 8192 - b2.limit);
            int i2 = offset + min;
            ArraysKt.copyInto(source, b2.data, b2.limit, offset, i2);
            b2.limit += min;
            offset = i2;
        }
        j(getSize() + j);
        return this;
    }

    @Override // sdk.pendo.io.k3.y
    public void a(d source, long byteCount) {
        v vVar;
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(source != this)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        sdk.pendo.io.k3.b.a(source.getSize(), 0L, byteCount);
        while (byteCount > 0) {
            v vVar2 = source.head;
            Intrinsics.checkNotNull(vVar2);
            int i = vVar2.limit;
            Intrinsics.checkNotNull(source.head);
            if (byteCount < i - r2.pos) {
                v vVar3 = this.head;
                if (vVar3 != null) {
                    Intrinsics.checkNotNull(vVar3);
                    vVar = vVar3.prev;
                } else {
                    vVar = null;
                }
                if (vVar != null && vVar.owner) {
                    if ((vVar.limit + byteCount) - (vVar.shared ? 0 : vVar.pos) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        v vVar4 = source.head;
                        Intrinsics.checkNotNull(vVar4);
                        vVar4.a(vVar, (int) byteCount);
                        source.j(source.getSize() - byteCount);
                        j(getSize() + byteCount);
                        return;
                    }
                }
                v vVar5 = source.head;
                Intrinsics.checkNotNull(vVar5);
                source.head = vVar5.a((int) byteCount);
            }
            v vVar6 = source.head;
            Intrinsics.checkNotNull(vVar6);
            long j = vVar6.limit - vVar6.pos;
            source.head = vVar6.b();
            v vVar7 = this.head;
            if (vVar7 == null) {
                this.head = vVar6;
                vVar6.prev = vVar6;
                vVar6.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String = vVar6;
            } else {
                Intrinsics.checkNotNull(vVar7);
                v vVar8 = vVar7.prev;
                Intrinsics.checkNotNull(vVar8);
                vVar8.a(vVar6).a();
            }
            source.j(source.getSize() - j);
            j(getSize() + j);
            byteCount -= j;
        }
    }

    public long a(a0 source) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long c2 = source.c(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (c2 == -1) {
                return j;
            }
            j += c2;
        }
    }

    public d a(String string, int beginIndex, int endIndex, Charset charset) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + beginIndex).toString());
        }
        if (!(endIndex >= beginIndex)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
        }
        if (!(endIndex <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + string.length()).toString());
        }
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            return a(string, beginIndex, endIndex);
        }
        String substring = string.substring(beginIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] bytes = substring.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return write(bytes, 0, bytes.length);
    }

    public d a(String string, Charset charset) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return a(string, 0, string.length(), charset);
    }

    public d a(String string, int beginIndex, int endIndex) {
        char charAt;
        long size;
        long j;
        Intrinsics.checkNotNullParameter(string, "string");
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + beginIndex).toString());
        }
        if (!(endIndex >= beginIndex)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
        }
        if (!(endIndex <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + string.length()).toString());
        }
        while (beginIndex < endIndex) {
            char charAt2 = string.charAt(beginIndex);
            if (charAt2 < 128) {
                v b2 = b(1);
                byte[] bArr = b2.data;
                int i = b2.limit - beginIndex;
                int min = Math.min(endIndex, 8192 - i);
                int i2 = beginIndex + 1;
                bArr[beginIndex + i] = (byte) charAt2;
                while (true) {
                    beginIndex = i2;
                    if (beginIndex >= min || (charAt = string.charAt(beginIndex)) >= 128) {
                        break;
                    }
                    i2 = beginIndex + 1;
                    bArr[beginIndex + i] = (byte) charAt;
                }
                int i3 = b2.limit;
                int i4 = (i + beginIndex) - i3;
                b2.limit = i3 + i4;
                j(getSize() + i4);
            } else {
                if (charAt2 < 2048) {
                    v b3 = b(2);
                    byte[] bArr2 = b3.data;
                    int i5 = b3.limit;
                    bArr2[i5] = (byte) ((charAt2 >> 6) | 192);
                    bArr2[i5 + 1] = (byte) ((charAt2 & '?') | 128);
                    b3.limit = i5 + 2;
                    size = getSize();
                    j = 2;
                } else if (charAt2 < 55296 || charAt2 > 57343) {
                    v b4 = b(3);
                    byte[] bArr3 = b4.data;
                    int i6 = b4.limit;
                    bArr3[i6] = (byte) ((charAt2 >> '\f') | BERTags.FLAGS);
                    bArr3[i6 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                    bArr3[i6 + 2] = (byte) ((charAt2 & '?') | 128);
                    b4.limit = i6 + 3;
                    size = getSize();
                    j = 3;
                } else {
                    int i7 = beginIndex + 1;
                    char charAt3 = i7 < endIndex ? string.charAt(i7) : (char) 0;
                    if (charAt2 <= 56319) {
                        if (56320 <= charAt3 && charAt3 < 57344) {
                            int i8 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 65536;
                            v b5 = b(4);
                            byte[] bArr4 = b5.data;
                            int i9 = b5.limit;
                            bArr4[i9] = (byte) ((i8 >> 18) | 240);
                            bArr4[i9 + 1] = (byte) (((i8 >> 12) & 63) | 128);
                            bArr4[i9 + 2] = (byte) (((i8 >> 6) & 63) | 128);
                            bArr4[i9 + 3] = (byte) ((i8 & 63) | 128);
                            b5.limit = i9 + 4;
                            j(getSize() + 4);
                            beginIndex += 2;
                        }
                    }
                    writeByte(63);
                    beginIndex = i7;
                }
                j(size + j);
                beginIndex++;
            }
        }
        return this;
    }
}
