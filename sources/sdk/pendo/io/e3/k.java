package sdk.pendo.io.e3;

import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import expo.modules.updates.codesigning.CodeSigningAlgorithmKt;
import io.sentry.protocol.ViewHierarchyNode;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.tensorflow.lite.schema.BuiltinOptions;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lsdk/pendo/io/e3/k;", "", "", "symbol", ApiConstant.KEY_CODE, "codeBitCount", "", "a", "Lsdk/pendo/io/k3/g;", "source", "Lsdk/pendo/io/k3/e;", "sink", "bytes", "Lsdk/pendo/io/k3/f;", "", "byteCount", "", "b", "[I", "CODES", "", "c", "[B", "CODE_BIT_COUNTS", "Lsdk/pendo/io/e3/k$a;", "d", "Lsdk/pendo/io/e3/k$a;", CodeSigningAlgorithmKt.CODE_SIGNING_METADATA_DEFAULT_KEY_ID, "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f1020a = new k();

    /* renamed from: b, reason: from kotlin metadata */
    private static final int[] CODES = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 4090, 8185, 21, 248, 2042, PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, 249, 2043, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, PointerIconCompat.TYPE_GRAB, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: c, reason: from kotlin metadata */
    private static final byte[] CODE_BIT_COUNTS = {13, BuiltinOptions.GatherOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.BatchToSpaceNDOptions, BuiltinOptions.SqueezeOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SqueezeOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SqueezeOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, BuiltinOptions.SubOptions, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, BuiltinOptions.SpaceToDepthOptions, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, BuiltinOptions.SubOptions, BuiltinOptions.EmbeddingLookupSparseOptions, BuiltinOptions.PadOptions, BuiltinOptions.EmbeddingLookupSparseOptions, BuiltinOptions.EmbeddingLookupSparseOptions, BuiltinOptions.PadOptions, BuiltinOptions.PadOptions, BuiltinOptions.PadOptions, BuiltinOptions.GatherOptions, BuiltinOptions.PadOptions, BuiltinOptions.GatherOptions, BuiltinOptions.GatherOptions, BuiltinOptions.GatherOptions, BuiltinOptions.GatherOptions, BuiltinOptions.GatherOptions, BuiltinOptions.BatchToSpaceNDOptions, BuiltinOptions.GatherOptions, BuiltinOptions.BatchToSpaceNDOptions, BuiltinOptions.BatchToSpaceNDOptions, BuiltinOptions.PadOptions, BuiltinOptions.GatherOptions, BuiltinOptions.BatchToSpaceNDOptions, BuiltinOptions.GatherOptions, BuiltinOptions.GatherOptions, BuiltinOptions.GatherOptions, BuiltinOptions.GatherOptions, BuiltinOptions.MulOptions, BuiltinOptions.PadOptions, BuiltinOptions.GatherOptions, BuiltinOptions.PadOptions, BuiltinOptions.GatherOptions, BuiltinOptions.GatherOptions, BuiltinOptions.BatchToSpaceNDOptions, BuiltinOptions.PadOptions, BuiltinOptions.MulOptions, BuiltinOptions.EmbeddingLookupSparseOptions, BuiltinOptions.PadOptions, BuiltinOptions.PadOptions, BuiltinOptions.GatherOptions, BuiltinOptions.GatherOptions, BuiltinOptions.MulOptions, BuiltinOptions.GatherOptions, BuiltinOptions.PadOptions, BuiltinOptions.PadOptions, BuiltinOptions.BatchToSpaceNDOptions, BuiltinOptions.MulOptions, BuiltinOptions.PadOptions, BuiltinOptions.GatherOptions, BuiltinOptions.GatherOptions, BuiltinOptions.MulOptions, BuiltinOptions.MulOptions, BuiltinOptions.PadOptions, BuiltinOptions.MulOptions, BuiltinOptions.GatherOptions, BuiltinOptions.PadOptions, BuiltinOptions.GatherOptions, BuiltinOptions.GatherOptions, BuiltinOptions.EmbeddingLookupSparseOptions, BuiltinOptions.PadOptions, BuiltinOptions.PadOptions, BuiltinOptions.PadOptions, BuiltinOptions.GatherOptions, BuiltinOptions.PadOptions, BuiltinOptions.PadOptions, BuiltinOptions.GatherOptions, BuiltinOptions.TransposeOptions, BuiltinOptions.TransposeOptions, BuiltinOptions.EmbeddingLookupSparseOptions, BuiltinOptions.SpaceToDepthOptions, BuiltinOptions.PadOptions, BuiltinOptions.GatherOptions, BuiltinOptions.PadOptions, BuiltinOptions.SpaceToBatchNDOptions, BuiltinOptions.TransposeOptions, BuiltinOptions.TransposeOptions, BuiltinOptions.TransposeOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.TransposeOptions, BuiltinOptions.BatchToSpaceNDOptions, BuiltinOptions.SpaceToBatchNDOptions, BuiltinOptions.SpaceToDepthOptions, BuiltinOptions.MulOptions, BuiltinOptions.TransposeOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.TransposeOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.BatchToSpaceNDOptions, BuiltinOptions.MulOptions, BuiltinOptions.MulOptions, BuiltinOptions.TransposeOptions, BuiltinOptions.TransposeOptions, BuiltinOptions.SubOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.EmbeddingLookupSparseOptions, BuiltinOptions.BatchToSpaceNDOptions, BuiltinOptions.EmbeddingLookupSparseOptions, BuiltinOptions.MulOptions, BuiltinOptions.PadOptions, BuiltinOptions.MulOptions, BuiltinOptions.MulOptions, BuiltinOptions.GatherOptions, BuiltinOptions.PadOptions, BuiltinOptions.PadOptions, BuiltinOptions.SpaceToBatchNDOptions, BuiltinOptions.SpaceToBatchNDOptions, BuiltinOptions.BatchToSpaceNDOptions, BuiltinOptions.BatchToSpaceNDOptions, BuiltinOptions.TransposeOptions, BuiltinOptions.GatherOptions, BuiltinOptions.TransposeOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.TransposeOptions, BuiltinOptions.TransposeOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.SubOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.TransposeOptions};

    /* renamed from: d, reason: from kotlin metadata */
    private static final a root = new a();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u000f\u0010\u0010B\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0012R!\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/e3/k$a;", "", "", "a", "[Lsdk/pendo/io/e3/k$a;", "getChildren", "()[Lokhttp3/internal/http2/Huffman$Node;", ViewHierarchyNode.JsonKeys.CHILDREN, "", "b", "I", "()I", "symbol", "c", "terminalBitCount", "<init>", "()V", "bits", "(II)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    private static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final a[] children;

        /* renamed from: b, reason: from kotlin metadata */
        private final int symbol;

        /* renamed from: c, reason: from kotlin metadata */
        private final int terminalBitCount;

        public a() {
            this.children = new a[256];
            this.symbol = 0;
            this.terminalBitCount = 0;
        }

        /* renamed from: a, reason: from getter */
        public final a[] getChildren() {
            return this.children;
        }

        /* renamed from: b, reason: from getter */
        public final int getSymbol() {
            return this.symbol;
        }

        /* renamed from: c, reason: from getter */
        public final int getTerminalBitCount() {
            return this.terminalBitCount;
        }

        public a(int i, int i2) {
            this.children = null;
            this.symbol = i;
            int i3 = i2 & 7;
            this.terminalBitCount = i3 == 0 ? 8 : i3;
        }
    }

    static {
        for (int i = 0; i < 256; i++) {
            f1020a.a(i, CODES[i], CODE_BIT_COUNTS[i]);
        }
    }

    private k() {
    }

    private final void a(int symbol, int code, int codeBitCount) {
        a aVar = new a(symbol, codeBitCount);
        a aVar2 = root;
        while (codeBitCount > 8) {
            codeBitCount -= 8;
            int i = (code >>> codeBitCount) & 255;
            a[] children = aVar2.getChildren();
            Intrinsics.checkNotNull(children);
            a aVar3 = children[i];
            if (aVar3 == null) {
                aVar3 = new a();
                children[i] = aVar3;
            }
            aVar2 = aVar3;
        }
        int i2 = 8 - codeBitCount;
        int i3 = (code << i2) & 255;
        a[] children2 = aVar2.getChildren();
        Intrinsics.checkNotNull(children2);
        ArraysKt.fill(children2, aVar, i3, (1 << i2) + i3);
    }

    public final void a(sdk.pendo.io.k3.f source, long byteCount, sdk.pendo.io.k3.e sink) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        a aVar = root;
        int i = 0;
        int i2 = 0;
        for (long j = 0; j < byteCount; j++) {
            i = (i << 8) | sdk.pendo.io.x2.b.a(source.readByte(), 255);
            i2 += 8;
            while (i2 >= 8) {
                a[] children = aVar.getChildren();
                Intrinsics.checkNotNull(children);
                aVar = children[(i >>> (i2 - 8)) & 255];
                Intrinsics.checkNotNull(aVar);
                if (aVar.getChildren() == null) {
                    sink.writeByte(aVar.getSymbol());
                    i2 -= aVar.getTerminalBitCount();
                    aVar = root;
                } else {
                    i2 -= 8;
                }
            }
        }
        while (i2 > 0) {
            a[] children2 = aVar.getChildren();
            Intrinsics.checkNotNull(children2);
            a aVar2 = children2[(i << (8 - i2)) & 255];
            Intrinsics.checkNotNull(aVar2);
            if (aVar2.getChildren() != null || aVar2.getTerminalBitCount() > i2) {
                return;
            }
            sink.writeByte(aVar2.getSymbol());
            i2 -= aVar2.getTerminalBitCount();
            aVar = root;
        }
    }

    public final void a(sdk.pendo.io.k3.g source, sdk.pendo.io.k3.e sink) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        int l = source.l();
        long j = 0;
        int i = 0;
        for (int i2 = 0; i2 < l; i2++) {
            int a2 = sdk.pendo.io.x2.b.a(source.a(i2), 255);
            int i3 = CODES[a2];
            byte b = CODE_BIT_COUNTS[a2];
            j = (j << b) | i3;
            i += b;
            while (i >= 8) {
                i -= 8;
                sink.writeByte((int) (j >> i));
            }
        }
        if (i > 0) {
            sink.writeByte((int) ((j << (8 - i)) | (255 >>> i)));
        }
    }

    public final int a(sdk.pendo.io.k3.g bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        long j = 0;
        for (int i = 0; i < bytes.l(); i++) {
            j += CODE_BIT_COUNTS[sdk.pendo.io.x2.b.a(bytes.a(i), 255)];
        }
        return (int) ((j + 7) >> 3);
    }
}
