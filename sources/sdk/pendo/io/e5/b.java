package sdk.pendo.io.e5;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.UByte;
import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes6.dex */
public class b implements d {

    /* renamed from: a, reason: collision with root package name */
    protected final byte[] f1028a = {BuiltinOptions.FloorDivOptions, BuiltinOptions.SquareOptions, BuiltinOptions.ZerosLikeOptions, BuiltinOptions.FillOptions, BuiltinOptions.BidirectionalSequenceLSTMOptions, BuiltinOptions.BidirectionalSequenceRNNOptions, BuiltinOptions.UnidirectionalSequenceLSTMOptions, BuiltinOptions.FloorModOptions, BuiltinOptions.RangeOptions, BuiltinOptions.ResizeNearestNeighborOptions, BuiltinOptions.LeakyReluOptions, BuiltinOptions.SquaredDifferenceOptions, BuiltinOptions.MirrorPadOptions, BuiltinOptions.AbsOptions, BuiltinOptions.SplitVOptions, BuiltinOptions.UniqueOptions, BuiltinOptions.ReverseV2Options, BuiltinOptions.AddNOptions, BuiltinOptions.GatherNdOptions, BuiltinOptions.CosOptions, BuiltinOptions.WhereOptions, BuiltinOptions.RankOptions, BuiltinOptions.ReverseSequenceOptions, BuiltinOptions.MatrixDiagOptions, BuiltinOptions.QuantizeOptions, BuiltinOptions.MatrixSetDiagOptions, BuiltinOptions.ScatterNdOptions, BuiltinOptions.SelectV2Options, BuiltinOptions.DensifyOptions, BuiltinOptions.SegmentSumOptions, BuiltinOptions.BatchMatMulOptions, BuiltinOptions.CumsumOptions, BuiltinOptions.CallOnceOptions, BuiltinOptions.BroadcastToOptions, BuiltinOptions.Rfft2dOptions, BuiltinOptions.Conv3DOptions, BuiltinOptions.HashtableOptions, BuiltinOptions.HashtableFindOptions, BuiltinOptions.HashtableImportOptions, BuiltinOptions.HashtableSizeOptions, BuiltinOptions.VarHandleOptions, BuiltinOptions.ReadVariableOptions, BuiltinOptions.AssignVariableOptions, BuiltinOptions.RandomOptions, BuiltinOptions.BucketizeOptions, BuiltinOptions.GeluOptions, BuiltinOptions.DynamicUpdateSliceOptions, BuiltinOptions.UnsortedSegmentProdOptions, BuiltinOptions.UnsortedSegmentMaxOptions, BuiltinOptions.UnsortedSegmentMinOptions, BuiltinOptions.UnsortedSegmentSumOptions, BuiltinOptions.ATan2Options, BuiltinOptions.SliceOptions, BuiltinOptions.TransposeConvOptions, BuiltinOptions.SparseToDenseOptions, BuiltinOptions.TileOptions, BuiltinOptions.ExpandDimsOptions, BuiltinOptions.EqualOptions, BuiltinOptions.NotEqualOptions, BuiltinOptions.ShapeOptions, BuiltinOptions.PowOptions, BuiltinOptions.ArgMinOptions, BuiltinOptions.PadV2Options, BuiltinOptions.SelectOptions};
    protected byte b = 61;
    protected final byte[] c = new byte[128];

    public b() {
        a();
    }

    private boolean a(char c) {
        return c == '\n' || c == '\r' || c == '\t' || c == ' ';
    }

    @Override // sdk.pendo.io.e5.d
    public int a(String str, OutputStream outputStream) {
        byte[] bArr = new byte[54];
        int length = str.length();
        while (length > 0 && a(str.charAt(length - 1))) {
            length--;
        }
        if (length == 0) {
            return 0;
        }
        int i = length;
        int i2 = 0;
        while (i > 0 && i2 != 4) {
            if (!a(str.charAt(i - 1))) {
                i2++;
            }
            i--;
        }
        int a2 = a(str, 0, i);
        int i3 = 0;
        int i4 = 0;
        while (a2 < i) {
            int i5 = a2 + 1;
            byte b = this.c[str.charAt(a2)];
            int a3 = a(str, i5, i);
            int i6 = a3 + 1;
            byte b2 = this.c[str.charAt(a3)];
            int a4 = a(str, i6, i);
            int i7 = a4 + 1;
            byte b3 = this.c[str.charAt(a4)];
            int a5 = a(str, i7, i);
            int i8 = a5 + 1;
            byte b4 = this.c[str.charAt(a5)];
            if ((b | b2 | b3 | b4) < 0) {
                throw new IOException("invalid characters encountered in base64 data");
            }
            int i9 = i3 + 1;
            bArr[i3] = (byte) ((b << 2) | (b2 >> 4));
            int i10 = i9 + 1;
            bArr[i9] = (byte) ((b2 << 4) | (b3 >> 2));
            i3 = i10 + 1;
            bArr[i10] = (byte) ((b3 << 6) | b4);
            i4 += 3;
            if (i3 == 54) {
                outputStream.write(bArr);
                i3 = 0;
            }
            a2 = a(str, i8, i);
        }
        if (i3 > 0) {
            outputStream.write(bArr, 0, i3);
        }
        int a6 = a(str, a2, length);
        int a7 = a(str, a6 + 1, length);
        int a8 = a(str, a7 + 1, length);
        return i4 + a(outputStream, str.charAt(a6), str.charAt(a7), str.charAt(a8), str.charAt(a(str, a8 + 1, length)));
    }

    private int a(OutputStream outputStream, char c, char c2, char c3, char c4) {
        char c5 = this.b;
        if (c3 == c5) {
            if (c4 != c5) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            byte[] bArr = this.c;
            byte b = bArr[c];
            byte b2 = bArr[c2];
            if ((b | b2) < 0) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            outputStream.write((b << 2) | (b2 >> 4));
            return 1;
        }
        if (c4 == c5) {
            byte[] bArr2 = this.c;
            byte b3 = bArr2[c];
            byte b4 = bArr2[c2];
            byte b5 = bArr2[c3];
            if ((b3 | b4 | b5) < 0) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            outputStream.write((b3 << 2) | (b4 >> 4));
            outputStream.write((b4 << 4) | (b5 >> 2));
            return 2;
        }
        byte[] bArr3 = this.c;
        byte b6 = bArr3[c];
        byte b7 = bArr3[c2];
        byte b8 = bArr3[c3];
        byte b9 = bArr3[c4];
        if ((b6 | b7 | b8 | b9) < 0) {
            throw new IOException("invalid characters encountered at end of base64 data");
        }
        outputStream.write((b6 << 2) | (b7 >> 4));
        outputStream.write((b7 << 4) | (b8 >> 2));
        outputStream.write((b8 << 6) | b9);
        return 3;
    }

    @Override // sdk.pendo.io.e5.d
    public int a(byte[] bArr, int i, int i2, OutputStream outputStream) {
        if (i2 < 0) {
            return 0;
        }
        byte[] bArr2 = new byte[72];
        int i3 = i2;
        while (i3 > 0) {
            int min = Math.min(54, i3);
            outputStream.write(bArr2, 0, a(bArr, i, min, bArr2, 0));
            i += min;
            i3 -= min;
        }
        return ((i2 + 2) / 3) * 4;
    }

    public int a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = (i + i2) - 2;
        int i5 = i;
        int i6 = i3;
        while (i5 < i4) {
            int i7 = i5 + 1;
            byte b = bArr[i5];
            int i8 = i7 + 1;
            int i9 = bArr[i7] & UByte.MAX_VALUE;
            int i10 = i8 + 1;
            int i11 = bArr[i8] & UByte.MAX_VALUE;
            int i12 = i6 + 1;
            byte[] bArr3 = this.f1028a;
            bArr2[i6] = bArr3[(b >>> 2) & 63];
            int i13 = i12 + 1;
            bArr2[i12] = bArr3[((b << 4) | (i9 >>> 4)) & 63];
            int i14 = i13 + 1;
            bArr2[i13] = bArr3[((i9 << 2) | (i11 >>> 6)) & 63];
            i6 = i14 + 1;
            bArr2[i14] = bArr3[i11 & 63];
            i5 = i10;
        }
        int i15 = i2 - (i5 - i);
        if (i15 == 1) {
            int i16 = bArr[i5] & UByte.MAX_VALUE;
            int i17 = i6 + 1;
            byte[] bArr4 = this.f1028a;
            bArr2[i6] = bArr4[(i16 >>> 2) & 63];
            int i18 = i17 + 1;
            bArr2[i17] = bArr4[(i16 << 4) & 63];
            int i19 = i18 + 1;
            byte b2 = this.b;
            bArr2[i18] = b2;
            i6 = i19 + 1;
            bArr2[i19] = b2;
        } else if (i15 == 2) {
            int i20 = bArr[i5] & UByte.MAX_VALUE;
            int i21 = bArr[i5 + 1] & UByte.MAX_VALUE;
            int i22 = i6 + 1;
            byte[] bArr5 = this.f1028a;
            bArr2[i6] = bArr5[(i20 >>> 2) & 63];
            int i23 = i22 + 1;
            bArr2[i22] = bArr5[((i20 << 4) | (i21 >>> 4)) & 63];
            int i24 = i23 + 1;
            bArr2[i23] = bArr5[(i21 << 2) & 63];
            i6 = i24 + 1;
            bArr2[i24] = this.b;
        }
        return i6 - i3;
    }

    @Override // sdk.pendo.io.e5.d
    public int a(int i) {
        return ((i + 2) / 3) * 4;
    }

    protected void a() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.c;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            byte[] bArr2 = this.f1028a;
            if (i >= bArr2.length) {
                return;
            }
            this.c[bArr2[i]] = (byte) i;
            i++;
        }
    }

    private int a(String str, int i, int i2) {
        while (i < i2 && a(str.charAt(i))) {
            i++;
        }
        return i;
    }
}
