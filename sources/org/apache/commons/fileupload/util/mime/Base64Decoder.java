package org.apache.commons.fileupload.util.mime;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.UByte;
import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes6.dex */
final class Base64Decoder {
    private static final int INPUT_BYTES_PER_CHUNK = 4;
    private static final int INVALID_BYTE = -1;
    private static final int MASK_BYTE_UNSIGNED = 255;
    private static final byte PADDING = 61;
    private static final int PAD_BYTE = -2;
    private static final byte[] ENCODING_TABLE = {BuiltinOptions.FloorDivOptions, BuiltinOptions.SquareOptions, BuiltinOptions.ZerosLikeOptions, BuiltinOptions.FillOptions, BuiltinOptions.BidirectionalSequenceLSTMOptions, BuiltinOptions.BidirectionalSequenceRNNOptions, BuiltinOptions.UnidirectionalSequenceLSTMOptions, BuiltinOptions.FloorModOptions, BuiltinOptions.RangeOptions, BuiltinOptions.ResizeNearestNeighborOptions, BuiltinOptions.LeakyReluOptions, BuiltinOptions.SquaredDifferenceOptions, BuiltinOptions.MirrorPadOptions, BuiltinOptions.AbsOptions, BuiltinOptions.SplitVOptions, BuiltinOptions.UniqueOptions, BuiltinOptions.ReverseV2Options, BuiltinOptions.AddNOptions, BuiltinOptions.GatherNdOptions, BuiltinOptions.CosOptions, BuiltinOptions.WhereOptions, BuiltinOptions.RankOptions, BuiltinOptions.ReverseSequenceOptions, BuiltinOptions.MatrixDiagOptions, BuiltinOptions.QuantizeOptions, BuiltinOptions.MatrixSetDiagOptions, BuiltinOptions.ScatterNdOptions, BuiltinOptions.SelectV2Options, BuiltinOptions.DensifyOptions, BuiltinOptions.SegmentSumOptions, BuiltinOptions.BatchMatMulOptions, BuiltinOptions.CumsumOptions, BuiltinOptions.CallOnceOptions, BuiltinOptions.BroadcastToOptions, BuiltinOptions.Rfft2dOptions, BuiltinOptions.Conv3DOptions, BuiltinOptions.HashtableOptions, BuiltinOptions.HashtableFindOptions, BuiltinOptions.HashtableImportOptions, BuiltinOptions.HashtableSizeOptions, BuiltinOptions.VarHandleOptions, BuiltinOptions.ReadVariableOptions, BuiltinOptions.AssignVariableOptions, BuiltinOptions.RandomOptions, BuiltinOptions.BucketizeOptions, BuiltinOptions.GeluOptions, BuiltinOptions.DynamicUpdateSliceOptions, BuiltinOptions.UnsortedSegmentProdOptions, BuiltinOptions.UnsortedSegmentMaxOptions, BuiltinOptions.UnsortedSegmentMinOptions, BuiltinOptions.UnsortedSegmentSumOptions, BuiltinOptions.ATan2Options, BuiltinOptions.SliceOptions, BuiltinOptions.TransposeConvOptions, BuiltinOptions.SparseToDenseOptions, BuiltinOptions.TileOptions, BuiltinOptions.ExpandDimsOptions, BuiltinOptions.EqualOptions, BuiltinOptions.NotEqualOptions, BuiltinOptions.ShapeOptions, BuiltinOptions.PowOptions, BuiltinOptions.ArgMinOptions, BuiltinOptions.PadV2Options, BuiltinOptions.SelectOptions};
    private static final byte[] DECODING_TABLE = new byte[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = DECODING_TABLE;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            byte[] bArr2 = ENCODING_TABLE;
            if (i < bArr2.length) {
                DECODING_TABLE[bArr2[i]] = (byte) i;
                i++;
            } else {
                DECODING_TABLE[61] = -2;
                return;
            }
        }
    }

    private Base64Decoder() {
    }

    public static int decode(byte[] bArr, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[4];
        int i = 0;
        int i2 = 0;
        for (byte b : bArr) {
            byte b2 = DECODING_TABLE[b & UByte.MAX_VALUE];
            if (b2 != -1) {
                int i3 = i + 1;
                bArr2[i] = b2;
                if (i3 == 4) {
                    byte b3 = bArr2[0];
                    byte b4 = bArr2[1];
                    byte b5 = bArr2[2];
                    byte b6 = bArr2[3];
                    if (b3 == -2 || b4 == -2) {
                        throw new IOException("Invalid Base64 input: incorrect padding, first two bytes cannot be padding");
                    }
                    outputStream.write((b3 << 2) | (b4 >> 4));
                    i2++;
                    if (b5 != -2) {
                        outputStream.write((b4 << 4) | (b5 >> 2));
                        i2++;
                        if (b6 != -2) {
                            outputStream.write((b5 << 6) | b6);
                            i2++;
                        }
                    } else if (b6 != -2) {
                        throw new IOException("Invalid Base64 input: incorrect padding, 4th byte must be padding if 3rd byte is");
                    }
                    i = 0;
                } else {
                    i = i3;
                }
            }
        }
        if (i == 0) {
            return i2;
        }
        throw new IOException("Invalid Base64 input: truncated");
    }
}
