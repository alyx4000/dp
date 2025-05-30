package org.bouncycastle.crypto.engines;

import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;
import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes6.dex */
public class DSTU7624Engine implements BlockCipher {
    private static final int ROUNDS_128 = 10;
    private static final int ROUNDS_256 = 14;
    private static final int ROUNDS_512 = 18;
    private static final byte[] S0 = {-88, BuiltinOptions.ZerosLikeOptions, BuiltinOptions.NonMaxSuppressionV4Options, 6, BuiltinOptions.HashtableOptions, BuiltinOptions.DynamicUpdateSliceOptions, BuiltinOptions.HashtableFindOptions, BuiltinOptions.QuantizeOptions, BuiltinOptions.AssignVariableOptions, -33, -121, -107, BuiltinOptions.GatherOptions, -16, -40, 9, BuiltinOptions.HashtableImportOptions, -13, BuiltinOptions.DivOptions, -53, -55, BuiltinOptions.MirrorPadOptions, BuiltinOptions.GreaterOptions, -81, BuiltinOptions.UnsortedSegmentSumOptions, -32, -105, -3, BuiltinOptions.VarHandleOptions, BuiltinOptions.LeakyReluOptions, BuiltinOptions.BidirectionalSequenceLSTMOptions, BuiltinOptions.ArgMinOptions, BuiltinOptions.LogicalAndOptions, -35, -93, BuiltinOptions.SplitVOptions, -76, -74, -102, 14, BuiltinOptions.SequenceRNNOptions, -65, BuiltinOptions.MulOptions, -31, BuiltinOptions.RangeOptions, -46, -109, -58, -110, BuiltinOptions.RandomOptions, -98, BuiltinOptions.ScatterNdOptions, -47, BuiltinOptions.DensifyOptions, -6, -18, -12, BuiltinOptions.SpaceToBatchNDOptions, -43, -83, BuiltinOptions.MatrixDiagOptions, -92, -69, -95, -36, -14, -125, BuiltinOptions.ShapeOptions, BuiltinOptions.SquareOptions, -28, BuiltinOptions.ATan2Options, BuiltinOptions.SparseToDenseOptions, -100, -52, -85, BuiltinOptions.ResizeNearestNeighborOptions, -113, BuiltinOptions.HashtableSizeOptions, 4, BuiltinOptions.MaximumMinimumOptions, BuiltinOptions.LessEqualOptions, -25, -30, BuiltinOptions.MatrixSetDiagOptions, -106, BuiltinOptions.PadOptions, BuiltinOptions.SplitOptions, BuiltinOptions.PadV2Options, -62, BuiltinOptions.BatchMatMulOptions, BuiltinOptions.CumsumOptions, 15, PSSSigner.TRAILER_IMPLICIT, -87, BuiltinOptions.UnidirectionalSequenceLSTMOptions, BuiltinOptions.FloorDivOptions, BuiltinOptions.ExpandDimsOptions, BuiltinOptions.FloorModOptions, -4, -73, BuiltinOptions.Conv3DOptions, -120, -91, BuiltinOptions.GatherNdOptions, -122, -7, BuiltinOptions.HardSwishOptions, -37, BuiltinOptions.PowOptions, BuiltinOptions.SignOptions, -61, BuiltinOptions.SqueezeOptions, BuiltinOptions.TopKV2Options, BuiltinOptions.TileOptions, BuiltinOptions.LogSoftmaxOptions, BuiltinOptions.ArgMaxOptions, BuiltinOptions.NotEqualOptions, -57, -78, BuiltinOptions.PackOptions, -114, BuiltinOptions.UnsortedSegmentMaxOptions, -70, -11, BuiltinOptions.EmbeddingLookupSparseOptions, -97, 8, BuiltinOptions.WhereOptions, -101, BuiltinOptions.SquaredDifferenceOptions, -2, BuiltinOptions.NonMaxSuppressionV5Options, BuiltinOptions.IfOptions, -38, BuiltinOptions.BatchToSpaceNDOptions, BuiltinOptions.BidirectionalSequenceRNNOptions, -51, 125, BuiltinOptions.ExpOptions, -80, 63, BuiltinOptions.ReducerOptions, -119, -1, -21, -124, BuiltinOptions.Rfft2dOptions, BuiltinOptions.FakeQuantOptions, -99, -41, -45, BuiltinOptions.ReadVariableOptions, BuiltinOptions.CallOnceOptions, BuiltinOptions.UnpackOptions, -75, -34, BuiltinOptions.WhileOptions, BuiltinOptions.SliceOptions, -111, -79, BuiltinOptions.UnsortedSegmentMinOptions, 17, 1, -27, 0, BuiltinOptions.BroadcastToOptions, -104, -96, -59, 2, -90, BuiltinOptions.GeluOptions, 45, 11, -94, BuiltinOptions.UnsortedSegmentProdOptions, -77, -66, -50, -67, -82, -23, -118, BuiltinOptions.TransposeConvOptions, BuiltinOptions.SubOptions, -20, -15, -103, -108, -86, -10, BuiltinOptions.DequantizeOptions, BuiltinOptions.SelectOptions, -17, -24, -116, BuiltinOptions.EqualOptions, 3, -44, ByteCompanionObject.MAX_VALUE, -5, 5, -63, BuiltinOptions.DepthToSpaceOptions, -112, BuiltinOptions.StridedSliceOptions, 61, -126, -9, -22, 10, 13, 126, -8, BuiltinOptions.UniqueOptions, BuiltinOptions.TransposeOptions, -60, 7, BuiltinOptions.ReverseSequenceOptions, -72, BuiltinOptions.LogicalOrOptions, BuiltinOptions.SelectV2Options, -29, -56, -84, BuiltinOptions.AddNOptions, BuiltinOptions.SegmentSumOptions, 16, -48, -39, BuiltinOptions.SpaceToDepthOptions, 12, BuiltinOptions.SkipGramOptions, BuiltinOptions.LessOptions, BuiltinOptions.ReverseV2Options, -71, -49, -42, BuiltinOptions.BucketizeOptions, -115, -127, BuiltinOptions.CosOptions, -64, -19, BuiltinOptions.AbsOptions, BuiltinOptions.FillOptions, -89, BuiltinOptions.NegOptions, -123, BuiltinOptions.CastOptions, -26, -54, 124, -117, BuiltinOptions.RankOptions, ByteCompanionObject.MIN_VALUE};
    private static final byte[] S1 = {-50, -69, -21, -110, -22, -53, BuiltinOptions.SpaceToDepthOptions, -63, -23, BuiltinOptions.FakeQuantOptions, -42, -78, -46, -112, BuiltinOptions.GatherOptions, -8, BuiltinOptions.SquareOptions, BuiltinOptions.MulOptions, BuiltinOptions.RankOptions, -76, BuiltinOptions.BatchMatMulOptions, BuiltinOptions.SubOptions, -120, BuiltinOptions.ZerosLikeOptions, -59, BuiltinOptions.IfOptions, BuiltinOptions.NotEqualOptions, -70, -11, BuiltinOptions.ReverseSequenceOptions, BuiltinOptions.CallOnceOptions, -115, BuiltinOptions.TransposeConvOptions, -10, BuiltinOptions.SegmentSumOptions, BuiltinOptions.MatrixDiagOptions, -98, -12, BuiltinOptions.TopKV2Options, -86, BuiltinOptions.DynamicUpdateSliceOptions, 15, 2, -79, -33, BuiltinOptions.HashtableImportOptions, BuiltinOptions.BucketizeOptions, BuiltinOptions.MirrorPadOptions, 124, BuiltinOptions.DequantizeOptions, BuiltinOptions.LessEqualOptions, -9, 8, BuiltinOptions.WhileOptions, BuiltinOptions.FillOptions, BuiltinOptions.LogicalAndOptions, -97, BuiltinOptions.EmbeddingLookupSparseOptions, -56, -82, BuiltinOptions.CosOptions, 16, -40, PSSSigner.TRAILER_IMPLICIT, BuiltinOptions.TransposeOptions, BuiltinOptions.HashtableOptions, BuiltinOptions.Rfft2dOptions, -13, -67, BuiltinOptions.TileOptions, -85, -6, -47, -101, BuiltinOptions.BroadcastToOptions, BuiltinOptions.AbsOptions, BuiltinOptions.PadOptions, -107, -111, -18, BuiltinOptions.SquaredDifferenceOptions, BuiltinOptions.DensifyOptions, -114, BuiltinOptions.HardSwishOptions, -52, BuiltinOptions.LogicalOrOptions, BuiltinOptions.SpaceToBatchNDOptions, -95, -127, BuiltinOptions.RangeOptions, BuiltinOptions.SignOptions, -39, BuiltinOptions.VarHandleOptions, BuiltinOptions.ShapeOptions, BuiltinOptions.NonMaxSuppressionV5Options, -54, -25, BuiltinOptions.PadV2Options, BuiltinOptions.FloorModOptions, -3, -106, BuiltinOptions.BidirectionalSequenceLSTMOptions, -4, BuiltinOptions.FloorDivOptions, BuiltinOptions.SkipGramOptions, 13, BuiltinOptions.UnsortedSegmentSumOptions, -27, -119, -116, -29, BuiltinOptions.StridedSliceOptions, BuiltinOptions.SliceOptions, -36, -73, BuiltinOptions.HashtableFindOptions, BuiltinOptions.ResizeNearestNeighborOptions, -75, 63, -105, -44, BuiltinOptions.SelectV2Options, 45, 6, -92, -91, -125, BuiltinOptions.NonMaxSuppressionV4Options, BuiltinOptions.NegOptions, -38, -55, 0, 126, -94, BuiltinOptions.WhereOptions, -65, 17, -43, -100, -49, 14, 10, 61, BuiltinOptions.ReverseV2Options, 125, -109, BuiltinOptions.ReducerOptions, -2, -60, BuiltinOptions.UnidirectionalSequenceLSTMOptions, 9, -122, 11, -113, -99, BuiltinOptions.Conv3DOptions, 7, -71, -80, -104, BuiltinOptions.BatchToSpaceNDOptions, BuiltinOptions.SparseToDenseOptions, BuiltinOptions.AssignVariableOptions, BuiltinOptions.LeakyReluOptions, -17, BuiltinOptions.PackOptions, BuiltinOptions.ReadVariableOptions, -96, -28, BuiltinOptions.UnpackOptions, -1, -61, -87, -26, BuiltinOptions.UnsortedSegmentMinOptions, -7, -117, BuiltinOptions.BidirectionalSequenceRNNOptions, ByteCompanionObject.MIN_VALUE, BuiltinOptions.SqueezeOptions, BuiltinOptions.PowOptions, -31, -72, -88, -32, 12, BuiltinOptions.SplitOptions, BuiltinOptions.UnsortedSegmentProdOptions, BuiltinOptions.DivOptions, BuiltinOptions.CastOptions, BuiltinOptions.LogSoftmaxOptions, 5, -15, BuiltinOptions.HashtableSizeOptions, -108, BuiltinOptions.ArgMaxOptions, -102, -124, -24, -93, BuiltinOptions.SplitVOptions, BuiltinOptions.UnsortedSegmentMaxOptions, -45, -123, -30, BuiltinOptions.AddNOptions, -14, -126, BuiltinOptions.UniqueOptions, BuiltinOptions.ATan2Options, BuiltinOptions.SelectOptions, BuiltinOptions.GeluOptions, BuiltinOptions.GatherNdOptions, -77, BuiltinOptions.ScatterNdOptions, -81, BuiltinOptions.ArgMinOptions, BuiltinOptions.EqualOptions, -34, -51, BuiltinOptions.SequenceRNNOptions, -103, -84, -83, BuiltinOptions.RandomOptions, BuiltinOptions.GreaterOptions, -35, -48, -121, -66, BuiltinOptions.DepthToSpaceOptions, -90, -20, 4, -58, 3, BuiltinOptions.ExpandDimsOptions, -5, -37, BuiltinOptions.QuantizeOptions, -74, -62, 1, -16, BuiltinOptions.MatrixSetDiagOptions, -19, -89, BuiltinOptions.CumsumOptions, BuiltinOptions.ExpOptions, ByteCompanionObject.MAX_VALUE, -118, BuiltinOptions.MaximumMinimumOptions, -57, -64, BuiltinOptions.LessOptions, -41};
    private static final byte[] S2 = {-109, -39, -102, -75, -104, BuiltinOptions.TopKV2Options, BuiltinOptions.BidirectionalSequenceLSTMOptions, -4, -70, BuiltinOptions.Conv3DOptions, -33, 2, -97, -36, BuiltinOptions.ReverseV2Options, BuiltinOptions.QuantizeOptions, BuiltinOptions.ResizeNearestNeighborOptions, BuiltinOptions.GatherOptions, BuiltinOptions.PadV2Options, -62, -108, -12, -69, -93, BuiltinOptions.SelectV2Options, -28, BuiltinOptions.AssignVariableOptions, -44, -51, BuiltinOptions.ReadVariableOptions, BuiltinOptions.PadOptions, -31, BuiltinOptions.RangeOptions, BuiltinOptions.LogicalOrOptions, -64, -40, BuiltinOptions.IfOptions, -101, -83, -123, BuiltinOptions.GatherNdOptions, -95, BuiltinOptions.ATan2Options, -56, 45, -32, -47, BuiltinOptions.RandomOptions, -90, BuiltinOptions.GreaterOptions, -60, -29, BuiltinOptions.UnsortedSegmentProdOptions, BuiltinOptions.UnsortedSegmentMinOptions, -73, -76, 9, BuiltinOptions.PackOptions, 14, BuiltinOptions.FloorDivOptions, BuiltinOptions.SquaredDifferenceOptions, -34, -78, -112, BuiltinOptions.CastOptions, -91, -41, 3, 17, 0, -61, BuiltinOptions.LessEqualOptions, -110, -17, BuiltinOptions.AbsOptions, BuiltinOptions.SkipGramOptions, -99, 125, -53, BuiltinOptions.EqualOptions, 16, -43, BuiltinOptions.SplitVOptions, -98, BuiltinOptions.MirrorPadOptions, -87, BuiltinOptions.WhereOptions, -58, -48, BuiltinOptions.SignOptions, BuiltinOptions.BatchToSpaceNDOptions, -105, -45, BuiltinOptions.NotEqualOptions, -26, BuiltinOptions.FloorModOptions, BuiltinOptions.RankOptions, -127, -113, BuiltinOptions.UnsortedSegmentMaxOptions, -52, -100, -71, -30, -84, -72, BuiltinOptions.SelectOptions, BuiltinOptions.MulOptions, -92, 124, -38, BuiltinOptions.PowOptions, BuiltinOptions.SqueezeOptions, 11, 5, -42, BuiltinOptions.EmbeddingLookupSparseOptions, BuiltinOptions.HashtableSizeOptions, BuiltinOptions.HashtableFindOptions, 126, BuiltinOptions.CumsumOptions, -3, -79, -27, BuiltinOptions.NonMaxSuppressionV5Options, -81, BuiltinOptions.DepthToSpaceOptions, BuiltinOptions.TileOptions, -121, -55, -16, BuiltinOptions.WhileOptions, BuiltinOptions.HashtableImportOptions, 63, -120, -115, -57, -9, BuiltinOptions.DivOptions, -23, -20, -19, ByteCompanionObject.MIN_VALUE, BuiltinOptions.LessOptions, BuiltinOptions.MaximumMinimumOptions, -49, -103, -88, BuiltinOptions.UniqueOptions, 15, BuiltinOptions.ShapeOptions, BuiltinOptions.LogSoftmaxOptions, BuiltinOptions.ArgMaxOptions, BuiltinOptions.SliceOptions, -107, -46, BuiltinOptions.LogicalAndOptions, BuiltinOptions.HardSwishOptions, BuiltinOptions.UnpackOptions, -125, -77, BuiltinOptions.Rfft2dOptions, BuiltinOptions.ReverseSequenceOptions, BuiltinOptions.SequenceRNNOptions, 7, BuiltinOptions.SubOptions, -118, PSSSigner.TRAILER_IMPLICIT, BuiltinOptions.StridedSliceOptions, -21, -50, -114, -85, -18, BuiltinOptions.TransposeConvOptions, -94, BuiltinOptions.BucketizeOptions, -7, -54, BuiltinOptions.FakeQuantOptions, BuiltinOptions.TransposeOptions, -5, 13, -63, -2, -6, -14, BuiltinOptions.VarHandleOptions, -67, -106, -35, BuiltinOptions.ZerosLikeOptions, BuiltinOptions.AddNOptions, -74, 8, -13, -82, -66, BuiltinOptions.SpaceToBatchNDOptions, -119, BuiltinOptions.SparseToDenseOptions, BuiltinOptions.DequantizeOptions, -80, -22, BuiltinOptions.LeakyReluOptions, BuiltinOptions.SegmentSumOptions, -124, -126, BuiltinOptions.HashtableOptions, -11, BuiltinOptions.UnsortedSegmentSumOptions, -65, 1, BuiltinOptions.NonMaxSuppressionV4Options, BuiltinOptions.DynamicUpdateSliceOptions, BuiltinOptions.DensifyOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.SplitOptions, 61, BuiltinOptions.BroadcastToOptions, BuiltinOptions.NegOptions, BuiltinOptions.BatchMatMulOptions, -24, -111, -10, -1, BuiltinOptions.SpaceToDepthOptions, BuiltinOptions.MatrixDiagOptions, -15, BuiltinOptions.UnidirectionalSequenceLSTMOptions, 10, ByteCompanionObject.MAX_VALUE, -59, -89, -25, BuiltinOptions.ScatterNdOptions, BuiltinOptions.MatrixSetDiagOptions, 6, BuiltinOptions.BidirectionalSequenceRNNOptions, BuiltinOptions.FillOptions, BuiltinOptions.SquareOptions, 4, -96, -37, BuiltinOptions.ArgMinOptions, -122, BuiltinOptions.CosOptions, -86, -116, BuiltinOptions.ExpandDimsOptions, BuiltinOptions.ExpOptions, -117, -8, 12, BuiltinOptions.GeluOptions, BuiltinOptions.CallOnceOptions};
    private static final byte[] S3 = {BuiltinOptions.BroadcastToOptions, -115, -54, BuiltinOptions.MirrorPadOptions, BuiltinOptions.BucketizeOptions, BuiltinOptions.LeakyReluOptions, BuiltinOptions.AbsOptions, BuiltinOptions.NegOptions, -44, BuiltinOptions.AddNOptions, BuiltinOptions.DequantizeOptions, -77, BuiltinOptions.CosOptions, BuiltinOptions.SqueezeOptions, BuiltinOptions.SpaceToBatchNDOptions, BuiltinOptions.SequenceRNNOptions, BuiltinOptions.TopKV2Options, 3, BuiltinOptions.BidirectionalSequenceRNNOptions, 61, 45, BuiltinOptions.ResizeNearestNeighborOptions, BuiltinOptions.GatherNdOptions, -125, BuiltinOptions.SpaceToDepthOptions, -118, -73, -43, BuiltinOptions.CastOptions, BuiltinOptions.UnsortedSegmentSumOptions, -11, -67, BuiltinOptions.MatrixDiagOptions, BuiltinOptions.SelectOptions, 13, 2, -19, BuiltinOptions.ReverseV2Options, -98, 17, -14, BuiltinOptions.LogicalAndOptions, BuiltinOptions.WhereOptions, BuiltinOptions.DepthToSpaceOptions, -47, BuiltinOptions.PadOptions, BuiltinOptions.LogicalOrOptions, BuiltinOptions.CumsumOptions, BuiltinOptions.ReadVariableOptions, BuiltinOptions.WhileOptions, -13, BuiltinOptions.BidirectionalSequenceLSTMOptions, BuiltinOptions.UnpackOptions, -52, -24, -108, BuiltinOptions.RankOptions, 8, -50, BuiltinOptions.TransposeOptions, BuiltinOptions.FakeQuantOptions, -46, -31, -33, -75, BuiltinOptions.PowOptions, BuiltinOptions.HashtableSizeOptions, 14, -27, -12, -7, -122, -23, BuiltinOptions.SplitVOptions, -42, -123, BuiltinOptions.SplitOptions, -49, BuiltinOptions.SparseToDenseOptions, -103, BuiltinOptions.TransposeConvOptions, BuiltinOptions.EmbeddingLookupSparseOptions, -82, -18, -56, BuiltinOptions.FloorModOptions, -45, BuiltinOptions.SliceOptions, -95, -110, BuiltinOptions.FloorDivOptions, -79, BuiltinOptions.BatchToSpaceNDOptions, -60, BuiltinOptions.GreaterOptions, BuiltinOptions.AssignVariableOptions, BuiltinOptions.RandomOptions, BuiltinOptions.FillOptions, BuiltinOptions.MulOptions, -3, BuiltinOptions.ShapeOptions, -66, BuiltinOptions.NonMaxSuppressionV4Options, -86, -101, -120, -40, -85, -119, -100, -6, BuiltinOptions.NonMaxSuppressionV5Options, -22, PSSSigner.TRAILER_IMPLICIT, BuiltinOptions.SelectV2Options, 12, BuiltinOptions.LogSoftmaxOptions, -90, -88, -20, BuiltinOptions.CallOnceOptions, BuiltinOptions.StridedSliceOptions, -37, 124, BuiltinOptions.ArgMaxOptions, -35, -84, BuiltinOptions.HardSwishOptions, BuiltinOptions.ExpandDimsOptions, 126, 16, -15, BuiltinOptions.SignOptions, -113, BuiltinOptions.DensifyOptions, -96, 5, -102, BuiltinOptions.ZerosLikeOptions, BuiltinOptions.UnsortedSegmentMaxOptions, BuiltinOptions.ExpOptions, -65, BuiltinOptions.MaximumMinimumOptions, 9, -61, -97, -74, -41, BuiltinOptions.LessOptions, -62, -21, -64, -92, -117, -116, BuiltinOptions.DivOptions, -5, -1, -63, -78, -105, BuiltinOptions.LessEqualOptions, -8, BuiltinOptions.BatchMatMulOptions, -10, BuiltinOptions.DynamicUpdateSliceOptions, 7, 4, BuiltinOptions.RangeOptions, BuiltinOptions.TileOptions, -28, -39, -71, -48, BuiltinOptions.SquareOptions, -57, BuiltinOptions.HashtableFindOptions, -112, 0, -114, BuiltinOptions.VarHandleOptions, BuiltinOptions.UniqueOptions, 1, -59, -38, BuiltinOptions.UnidirectionalSequenceLSTMOptions, 63, -51, BuiltinOptions.Rfft2dOptions, -94, -30, BuiltinOptions.ATan2Options, -89, -58, -109, 15, 10, 6, -26, BuiltinOptions.PadV2Options, -106, -93, BuiltinOptions.SubOptions, -81, BuiltinOptions.Conv3DOptions, BuiltinOptions.SkipGramOptions, -124, BuiltinOptions.ArgMinOptions, -25, -80, -126, -9, -2, -99, -121, BuiltinOptions.IfOptions, -127, BuiltinOptions.EqualOptions, -34, -76, -91, -4, ByteCompanionObject.MIN_VALUE, -17, -53, -69, BuiltinOptions.HashtableOptions, BuiltinOptions.UnsortedSegmentProdOptions, -70, BuiltinOptions.MatrixSetDiagOptions, 125, BuiltinOptions.UnsortedSegmentMinOptions, 11, -107, -29, -83, BuiltinOptions.GeluOptions, -104, BuiltinOptions.PackOptions, BuiltinOptions.NotEqualOptions, BuiltinOptions.SegmentSumOptions, BuiltinOptions.HashtableImportOptions, -36, -16, BuiltinOptions.QuantizeOptions, -87, BuiltinOptions.SquaredDifferenceOptions, BuiltinOptions.GatherOptions, ByteCompanionObject.MAX_VALUE, -111, -72, -55, BuiltinOptions.ReverseSequenceOptions, BuiltinOptions.ReducerOptions, -32, BuiltinOptions.ScatterNdOptions};
    private static final byte[] T0 = {-92, -94, -87, -59, BuiltinOptions.AbsOptions, -55, 3, -39, 126, 15, -46, -83, -25, -45, BuiltinOptions.MaximumMinimumOptions, BuiltinOptions.HardSwishOptions, -29, -95, -24, -26, 124, BuiltinOptions.NegOptions, BuiltinOptions.WhereOptions, 12, -122, BuiltinOptions.ArgMinOptions, -41, -115, -72, BuiltinOptions.SkipGramOptions, BuiltinOptions.VarHandleOptions, BuiltinOptions.ArgMaxOptions, -51, -118, BuiltinOptions.ReadVariableOptions, BuiltinOptions.RankOptions, BuiltinOptions.RandomOptions, -7, -65, BuiltinOptions.SplitVOptions, BuiltinOptions.BucketizeOptions, -23, -9, BuiltinOptions.ReverseSequenceOptions, BuiltinOptions.PadOptions, -84, BuiltinOptions.UniqueOptions, -64, -99, -73, BuiltinOptions.UnidirectionalSequenceLSTMOptions, BuiltinOptions.AssignVariableOptions, BuiltinOptions.NonMaxSuppressionV5Options, -60, BuiltinOptions.GeluOptions, BuiltinOptions.ZerosLikeOptions, BuiltinOptions.HashtableFindOptions, BuiltinOptions.SequenceRNNOptions, -109, BuiltinOptions.UnsortedSegmentMaxOptions, -36, -50, BuiltinOptions.StridedSliceOptions, -116, -103, BuiltinOptions.NonMaxSuppressionV4Options, BuiltinOptions.FillOptions, 1, -11, BuiltinOptions.SqueezeOptions, -121, BuiltinOptions.DepthToSpaceOptions, BuiltinOptions.ScatterNdOptions, BuiltinOptions.GreaterOptions, BuiltinOptions.LeakyReluOptions, BuiltinOptions.DivOptions, -127, BuiltinOptions.MulOptions, -12, BuiltinOptions.SplitOptions, -42, -22, -31, BuiltinOptions.CallOnceOptions, -15, ByteCompanionObject.MAX_VALUE, -2, -38, BuiltinOptions.LogicalOrOptions, 7, BuiltinOptions.GatherNdOptions, BuiltinOptions.Conv3DOptions, -124, -100, -53, 2, -125, BuiltinOptions.TileOptions, -35, BuiltinOptions.EqualOptions, -30, BuiltinOptions.QuantizeOptions, BuiltinOptions.MatrixSetDiagOptions, -104, -91, -110, BuiltinOptions.SegmentSumOptions, 4, 6, 16, BuiltinOptions.MirrorPadOptions, BuiltinOptions.SubOptions, -105, 8, BuiltinOptions.TransposeConvOptions, -18, -85, 5, -81, BuiltinOptions.UnsortedSegmentSumOptions, -96, BuiltinOptions.BatchToSpaceNDOptions, BuiltinOptions.BidirectionalSequenceRNNOptions, BuiltinOptions.HashtableImportOptions, -4, -119, -44, -57, -1, -16, -49, BuiltinOptions.SquareOptions, -111, -8, BuiltinOptions.BroadcastToOptions, 10, BuiltinOptions.BatchMatMulOptions, -114, -74, -3, -61, -17, BuiltinOptions.UnsortedSegmentMinOptions, BuiltinOptions.SquaredDifferenceOptions, -52, -98, BuiltinOptions.SliceOptions, BuiltinOptions.LessEqualOptions, PSSSigner.TRAILER_IMPLICIT, 11, BuiltinOptions.CosOptions, BuiltinOptions.TransposeOptions, -90, -69, BuiltinOptions.DequantizeOptions, ByteCompanionObject.MIN_VALUE, BuiltinOptions.FloorModOptions, -108, BuiltinOptions.SparseToDenseOptions, 125, -89, 63, -82, BuiltinOptions.TopKV2Options, 61, BuiltinOptions.CumsumOptions, -86, -10, 0, BuiltinOptions.WhileOptions, -67, BuiltinOptions.ResizeNearestNeighborOptions, -32, BuiltinOptions.PackOptions, -76, BuiltinOptions.GatherOptions, -117, -97, BuiltinOptions.UnsortedSegmentProdOptions, -80, BuiltinOptions.LogSoftmaxOptions, -102, BuiltinOptions.CastOptions, BuiltinOptions.DensifyOptions, -37, -21, BuiltinOptions.ATan2Options, BuiltinOptions.LogicalAndOptions, BuiltinOptions.IfOptions, -77, -79, BuiltinOptions.LessOptions, -14, -54, BuiltinOptions.MatrixDiagOptions, BuiltinOptions.HashtableSizeOptions, -40, -88, BuiltinOptions.SelectOptions, BuiltinOptions.DynamicUpdateSliceOptions, -33, BuiltinOptions.EmbeddingLookupSparseOptions, -5, BuiltinOptions.SpaceToDepthOptions, BuiltinOptions.RangeOptions, -120, -78, -20, -28, BuiltinOptions.ExpandDimsOptions, 45, -106, -58, BuiltinOptions.FakeQuantOptions, -19, -107, 14, -27, -123, BuiltinOptions.HashtableOptions, BuiltinOptions.UnpackOptions, BuiltinOptions.ExpOptions, -101, 9, BuiltinOptions.SpaceToBatchNDOptions, BuiltinOptions.PadV2Options, BuiltinOptions.AddNOptions, -34, BuiltinOptions.BidirectionalSequenceLSTMOptions, -93, -6, BuiltinOptions.ReverseV2Options, -62, -75, -47, -112, -71, -13, BuiltinOptions.ShapeOptions, -63, 13, -70, BuiltinOptions.FloorDivOptions, 17, BuiltinOptions.PowOptions, BuiltinOptions.SignOptions, -66, -48, -43, BuiltinOptions.Rfft2dOptions, BuiltinOptions.NotEqualOptions, -56, BuiltinOptions.SelectV2Options, BuiltinOptions.ReducerOptions, -126, -113};
    private static final byte[] T1 = {-125, -14, BuiltinOptions.NegOptions, -21, -23, -65, BuiltinOptions.SignOptions, -100, BuiltinOptions.ExpandDimsOptions, -106, -115, -104, -71, BuiltinOptions.Rfft2dOptions, -116, BuiltinOptions.LessOptions, 61, -120, BuiltinOptions.BroadcastToOptions, 6, BuiltinOptions.ArgMinOptions, 17, BuiltinOptions.SquaredDifferenceOptions, 14, -96, BuiltinOptions.RankOptions, BuiltinOptions.UnpackOptions, -110, BuiltinOptions.MulOptions, PSSSigner.TRAILER_IMPLICIT, -77, -36, BuiltinOptions.VarHandleOptions, -8, BuiltinOptions.DequantizeOptions, -70, -66, -67, BuiltinOptions.TransposeConvOptions, -5, -61, -2, ByteCompanionObject.MIN_VALUE, BuiltinOptions.ScatterNdOptions, -31, BuiltinOptions.ATan2Options, BuiltinOptions.SparseToDenseOptions, -46, BuiltinOptions.ReadVariableOptions, BuiltinOptions.StridedSliceOptions, -95, BuiltinOptions.BidirectionalSequenceLSTMOptions, -20, -39, BuiltinOptions.TransposeOptions, BuiltinOptions.WhileOptions, -76, -40, 9, -91, BuiltinOptions.WhereOptions, -114, BuiltinOptions.ShapeOptions, BuiltinOptions.UnsortedSegmentProdOptions, -87, BuiltinOptions.CallOnceOptions, 16, BuiltinOptions.GatherOptions, BuiltinOptions.NotEqualOptions, BuiltinOptions.BatchMatMulOptions, -79, -107, BuiltinOptions.SelectV2Options, BuiltinOptions.QuantizeOptions, BuiltinOptions.GeluOptions, -93, BuiltinOptions.UniqueOptions, BuiltinOptions.SelectOptions, BuiltinOptions.LeakyReluOptions, -56, -48, -113, -51, -44, BuiltinOptions.LogicalOrOptions, -122, BuiltinOptions.SkipGramOptions, BuiltinOptions.DivOptions, BuiltinOptions.SplitOptions, -17, -12, BuiltinOptions.GatherNdOptions, BuiltinOptions.SpaceToBatchNDOptions, BuiltinOptions.EqualOptions, -26, ByteCompanionObject.MAX_VALUE, BuiltinOptions.DepthToSpaceOptions, -42, BuiltinOptions.UnsortedSegmentSumOptions, BuiltinOptions.ReverseV2Options, BuiltinOptions.TopKV2Options, BuiltinOptions.EmbeddingLookupSparseOptions, -9, BuiltinOptions.SqueezeOptions, BuiltinOptions.ResizeNearestNeighborOptions, BuiltinOptions.SquareOptions, -101, BuiltinOptions.FloorDivOptions, BuiltinOptions.BucketizeOptions, 45, -63, BuiltinOptions.IfOptions, -90, -94, -32, BuiltinOptions.LessEqualOptions, -45, BuiltinOptions.ArgMaxOptions, -69, -55, -82, BuiltinOptions.Conv3DOptions, -47, BuiltinOptions.MatrixSetDiagOptions, BuiltinOptions.SliceOptions, -112, -124, -7, -78, BuiltinOptions.MatrixDiagOptions, -49, 126, -59, -53, -105, -28, BuiltinOptions.PadOptions, BuiltinOptions.HashtableFindOptions, -6, -80, BuiltinOptions.HashtableImportOptions, BuiltinOptions.SequenceRNNOptions, BuiltinOptions.AddNOptions, -103, 13, BuiltinOptions.AbsOptions, 3, -111, -62, BuiltinOptions.MirrorPadOptions, BuiltinOptions.SegmentSumOptions, BuiltinOptions.UnsortedSegmentMaxOptions, -97, -35, -60, BuiltinOptions.RangeOptions, -118, -102, BuiltinOptions.LogSoftmaxOptions, BuiltinOptions.PowOptions, -89, BuiltinOptions.ReverseSequenceOptions, -123, -57, 124, 125, -25, -10, -73, -84, BuiltinOptions.MaximumMinimumOptions, BuiltinOptions.BidirectionalSequenceRNNOptions, -34, -33, BuiltinOptions.PackOptions, -41, -98, BuiltinOptions.PadV2Options, 11, -43, BuiltinOptions.SpaceToDepthOptions, BuiltinOptions.DynamicUpdateSliceOptions, -16, BuiltinOptions.RandomOptions, -74, -99, BuiltinOptions.ReducerOptions, 1, 63, BuiltinOptions.FillOptions, -27, -121, -3, 7, -15, -85, -108, BuiltinOptions.BatchToSpaceNDOptions, -22, -4, BuiltinOptions.FakeQuantOptions, -126, BuiltinOptions.NonMaxSuppressionV4Options, 5, BuiltinOptions.CosOptions, -37, 0, -117, -29, BuiltinOptions.FloorModOptions, 12, -54, BuiltinOptions.UnsortedSegmentMinOptions, -119, 10, -1, BuiltinOptions.LogicalAndOptions, BuiltinOptions.HardSwishOptions, -127, -18, BuiltinOptions.AssignVariableOptions, -30, -38, BuiltinOptions.GreaterOptions, -72, -75, -52, BuiltinOptions.HashtableSizeOptions, -88, BuiltinOptions.HashtableOptions, -83, BuiltinOptions.NonMaxSuppressionV5Options, -58, 8, 4, 2, -24, -11, BuiltinOptions.SplitVOptions, -92, -13, -64, -50, BuiltinOptions.ZerosLikeOptions, BuiltinOptions.CastOptions, BuiltinOptions.SubOptions, BuiltinOptions.ExpOptions, BuiltinOptions.TileOptions, 15, -81, BuiltinOptions.UnidirectionalSequenceLSTMOptions, -19, BuiltinOptions.CumsumOptions, BuiltinOptions.DensifyOptions, -109, -86};
    private static final byte[] T2 = {BuiltinOptions.BidirectionalSequenceLSTMOptions, -44, 11, BuiltinOptions.ZerosLikeOptions, -15, BuiltinOptions.RandomOptions, -19, -92, -62, BuiltinOptions.PowOptions, -26, BuiltinOptions.AssignVariableOptions, -3, -74, BuiltinOptions.FakeQuantOptions, -107, BuiltinOptions.UniqueOptions, BuiltinOptions.FillOptions, BuiltinOptions.LeakyReluOptions, -30, BuiltinOptions.GeluOptions, BuiltinOptions.HashtableOptions, BuiltinOptions.SqueezeOptions, 17, BuiltinOptions.MatrixSetDiagOptions, -58, -76, -40, -91, -118, BuiltinOptions.ReadVariableOptions, -93, -88, -6, 5, -39, -105, BuiltinOptions.UnpackOptions, -55, -112, -104, -113, -36, BuiltinOptions.SkipGramOptions, BuiltinOptions.TransposeConvOptions, BuiltinOptions.GreaterOptions, BuiltinOptions.UnidirectionalSequenceLSTMOptions, BuiltinOptions.Conv3DOptions, -103, -82, -56, ByteCompanionObject.MAX_VALUE, -7, BuiltinOptions.SplitVOptions, BuiltinOptions.WhileOptions, -106, BuiltinOptions.VarHandleOptions, -12, -77, BuiltinOptions.ArgMinOptions, BuiltinOptions.ExpOptions, -38, -100, -123, -98, BuiltinOptions.PackOptions, -16, -65, -17, 6, -18, -27, BuiltinOptions.NonMaxSuppressionV4Options, BuiltinOptions.StridedSliceOptions, 16, -52, BuiltinOptions.LogicalOrOptions, BuiltinOptions.CosOptions, BuiltinOptions.ResizeNearestNeighborOptions, BuiltinOptions.AddNOptions, -108, 14, -64, BuiltinOptions.ArgMaxOptions, -10, BuiltinOptions.RankOptions, BuiltinOptions.NonMaxSuppressionV5Options, -94, -29, 15, -20, -99, BuiltinOptions.LogSoftmaxOptions, -125, 126, -43, 124, -21, BuiltinOptions.BatchToSpaceNDOptions, -41, -51, -35, BuiltinOptions.UnsortedSegmentMinOptions, -1, -37, -95, 9, -48, BuiltinOptions.UnsortedSegmentProdOptions, -124, BuiltinOptions.DynamicUpdateSliceOptions, -69, BuiltinOptions.DivOptions, BuiltinOptions.TransposeOptions, BuiltinOptions.SelectOptions, -80, -2, -42, BuiltinOptions.ExpandDimsOptions, BuiltinOptions.DensifyOptions, BuiltinOptions.EqualOptions, -46, BuiltinOptions.NegOptions, BuiltinOptions.QuantizeOptions, BuiltinOptions.HashtableImportOptions, BuiltinOptions.MirrorPadOptions, BuiltinOptions.UnsortedSegmentMaxOptions, -25, -114, BuiltinOptions.ScatterNdOptions, -49, -97, -50, BuiltinOptions.MaximumMinimumOptions, -11, ByteCompanionObject.MIN_VALUE, -122, -57, -90, -5, -8, -121, -85, BuiltinOptions.SelectV2Options, 63, -33, BuiltinOptions.FloorModOptions, 0, BuiltinOptions.EmbeddingLookupSparseOptions, -102, -67, BuiltinOptions.HardSwishOptions, 4, -110, 2, BuiltinOptions.CastOptions, BuiltinOptions.BatchMatMulOptions, BuiltinOptions.SquaredDifferenceOptions, BuiltinOptions.GatherNdOptions, 12, -14, BuiltinOptions.LessOptions, -81, BuiltinOptions.GatherOptions, BuiltinOptions.HashtableFindOptions, BuiltinOptions.FloorDivOptions, BuiltinOptions.SliceOptions, -23, -109, BuiltinOptions.WhereOptions, -9, -84, BuiltinOptions.BroadcastToOptions, BuiltinOptions.DequantizeOptions, -60, 125, -54, BuiltinOptions.ATan2Options, BuiltinOptions.LogicalAndOptions, -96, BuiltinOptions.ShapeOptions, 3, -63, BuiltinOptions.NotEqualOptions, BuiltinOptions.Rfft2dOptions, BuiltinOptions.CumsumOptions, 8, BuiltinOptions.PadOptions, -89, PSSSigner.TRAILER_IMPLICIT, -59, -45, BuiltinOptions.TopKV2Options, -73, BuiltinOptions.SpaceToDepthOptions, BuiltinOptions.BidirectionalSequenceRNNOptions, BuiltinOptions.SparseToDenseOptions, -24, BuiltinOptions.ReverseSequenceOptions, -120, BuiltinOptions.PadV2Options, -127, -78, BuiltinOptions.AbsOptions, BuiltinOptions.SegmentSumOptions, BuiltinOptions.SubOptions, -86, -111, BuiltinOptions.MatrixDiagOptions, BuiltinOptions.LessEqualOptions, -101, BuiltinOptions.IfOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.ReverseV2Options, BuiltinOptions.BucketizeOptions, BuiltinOptions.SquareOptions, BuiltinOptions.SplitOptions, 1, BuiltinOptions.HashtableSizeOptions, -13, 13, -66, 61, 10, 45, BuiltinOptions.SequenceRNNOptions, BuiltinOptions.CallOnceOptions, BuiltinOptions.TileOptions, BuiltinOptions.SpaceToBatchNDOptions, BuiltinOptions.SignOptions, BuiltinOptions.DepthToSpaceOptions, -22, -34, -117, -53, -87, -116, -115, -83, BuiltinOptions.RangeOptions, -126, -28, -70, -61, BuiltinOptions.MulOptions, -47, -32, -119, -4, -79, -71, -75, 7, BuiltinOptions.UnsortedSegmentSumOptions, -72, -31};
    private static final byte[] T3 = {-78, -74, BuiltinOptions.SplitOptions, 17, -89, -120, -59, -90, BuiltinOptions.ArgMinOptions, -113, -60, -24, BuiltinOptions.BucketizeOptions, BuiltinOptions.TopKV2Options, BuiltinOptions.ZerosLikeOptions, -61, -126, BuiltinOptions.MaximumMinimumOptions, -51, BuiltinOptions.BatchToSpaceNDOptions, BuiltinOptions.ReverseV2Options, BuiltinOptions.SelectV2Options, 45, -9, BuiltinOptions.IfOptions, 14, BuiltinOptions.PackOptions, -3, -54, -101, 13, 15, BuiltinOptions.UnsortedSegmentSumOptions, -116, 16, BuiltinOptions.SquaredDifferenceOptions, BuiltinOptions.GeluOptions, BuiltinOptions.SubOptions, 10, -114, 124, -108, 7, -57, BuiltinOptions.DepthToSpaceOptions, BuiltinOptions.EmbeddingLookupSparseOptions, -95, BuiltinOptions.ExpOptions, BuiltinOptions.ReverseSequenceOptions, BuiltinOptions.UniqueOptions, BuiltinOptions.AbsOptions, -87, ByteCompanionObject.MIN_VALUE, -39, -17, BuiltinOptions.SegmentSumOptions, BuiltinOptions.FloorDivOptions, -49, BuiltinOptions.LogicalOrOptions, -18, BuiltinOptions.LessEqualOptions, BuiltinOptions.SpaceToDepthOptions, BuiltinOptions.LessOptions, -70, BuiltinOptions.ExpandDimsOptions, BuiltinOptions.MatrixSetDiagOptions, -82, -118, BuiltinOptions.ScatterNdOptions, BuiltinOptions.TileOptions, BuiltinOptions.SkipGramOptions, -71, BuiltinOptions.WhereOptions, -88, BuiltinOptions.MulOptions, 5, -10, 3, 6, BuiltinOptions.RangeOptions, -75, BuiltinOptions.CastOptions, 9, BuiltinOptions.PadOptions, 12, BuiltinOptions.NegOptions, BuiltinOptions.PowOptions, -4, BuiltinOptions.StridedSliceOptions, -12, -27, ByteCompanionObject.MAX_VALUE, -41, BuiltinOptions.TransposeConvOptions, BuiltinOptions.PadV2Options, BuiltinOptions.CumsumOptions, BuiltinOptions.VarHandleOptions, -1, BuiltinOptions.RandomOptions, -122, -16, -93, BuiltinOptions.SelectOptions, BuiltinOptions.UnsortedSegmentMinOptions, 0, PSSSigner.TRAILER_IMPLICIT, -52, -30, -80, -15, BuiltinOptions.SquareOptions, -76, BuiltinOptions.SliceOptions, BuiltinOptions.NonMaxSuppressionV4Options, BuiltinOptions.NonMaxSuppressionV5Options, 4, -20, -91, -29, -117, -25, BuiltinOptions.DivOptions, -65, -124, BuiltinOptions.SignOptions, -26, -127, -8, -34, -40, -46, BuiltinOptions.GatherOptions, -50, BuiltinOptions.LeakyReluOptions, BuiltinOptions.UnidirectionalSequenceLSTMOptions, -42, BuiltinOptions.Rfft2dOptions, BuiltinOptions.HashtableFindOptions, BuiltinOptions.SpaceToBatchNDOptions, -103, -102, 1, -77, -123, -79, -7, BuiltinOptions.QuantizeOptions, -62, BuiltinOptions.ShapeOptions, -23, -56, -96, -19, BuiltinOptions.SplitVOptions, -119, BuiltinOptions.BroadcastToOptions, BuiltinOptions.HashtableImportOptions, -43, BuiltinOptions.DequantizeOptions, -111, -121, BuiltinOptions.MatrixDiagOptions, -67, -55, -104, -36, BuiltinOptions.DynamicUpdateSliceOptions, -64, BuiltinOptions.UnsortedSegmentProdOptions, -11, BuiltinOptions.CallOnceOptions, BuiltinOptions.HashtableOptions, 126, -21, BuiltinOptions.AddNOptions, -53, -47, BuiltinOptions.HardSwishOptions, -97, 11, -37, BuiltinOptions.UnpackOptions, -110, BuiltinOptions.TransposeOptions, -6, -84, -28, -31, BuiltinOptions.AssignVariableOptions, BuiltinOptions.SequenceRNNOptions, BuiltinOptions.BatchMatMulOptions, -115, -105, -98, -107, -112, BuiltinOptions.WhileOptions, -73, -63, -81, BuiltinOptions.CosOptions, -5, 2, -32, BuiltinOptions.EqualOptions, -69, BuiltinOptions.FakeQuantOptions, BuiltinOptions.MirrorPadOptions, -83, BuiltinOptions.GreaterOptions, 61, BuiltinOptions.RankOptions, 8, BuiltinOptions.ReducerOptions, BuiltinOptions.ResizeNearestNeighborOptions, -109, BuiltinOptions.Conv3DOptions, -85, -72, BuiltinOptions.ATan2Options, -14, 125, -38, 63, -2, BuiltinOptions.LogicalAndOptions, -66, -22, -86, BuiltinOptions.FillOptions, -58, -48, BuiltinOptions.NotEqualOptions, BuiltinOptions.FloorModOptions, BuiltinOptions.ReadVariableOptions, -106, BuiltinOptions.UnsortedSegmentMaxOptions, BuiltinOptions.LogSoftmaxOptions, BuiltinOptions.GatherNdOptions, -33, -13, -125, BuiltinOptions.ArgMaxOptions, BuiltinOptions.SparseToDenseOptions, BuiltinOptions.BidirectionalSequenceLSTMOptions, BuiltinOptions.SqueezeOptions, -92, -45, -94, BuiltinOptions.BidirectionalSequenceRNNOptions, BuiltinOptions.HashtableSizeOptions, -100, -35, BuiltinOptions.DensifyOptions, -44, -99};
    private boolean forEncryption;
    private long[] internalState;
    private long[][] roundKeys;
    private int roundsAmount;
    private int wordsInBlock;
    private int wordsInKey;
    private long[] workingKey;

    public DSTU7624Engine(int i) throws IllegalArgumentException {
        if (i != 128 && i != 256 && i != 512) {
            throw new IllegalArgumentException("unsupported block length: only 128/256/512 are allowed");
        }
        int i2 = i >>> 6;
        this.wordsInBlock = i2;
        this.internalState = new long[i2];
    }

    private void addRoundKey(int i) {
        long[] jArr = this.roundKeys[i];
        for (int i2 = 0; i2 < this.wordsInBlock; i2++) {
            long[] jArr2 = this.internalState;
            jArr2[i2] = jArr2[i2] + jArr[i2];
        }
    }

    private void decryptBlock_128(byte[] bArr, int i, byte[] bArr2, int i2) {
        long littleEndianToLong = Pack.littleEndianToLong(bArr, i);
        long littleEndianToLong2 = Pack.littleEndianToLong(bArr, i + 8);
        long[][] jArr = this.roundKeys;
        int i3 = this.roundsAmount;
        long[] jArr2 = jArr[i3];
        long j = littleEndianToLong - jArr2[0];
        long j2 = littleEndianToLong2 - jArr2[1];
        while (true) {
            long mixColumnInv = mixColumnInv(j);
            long mixColumnInv2 = mixColumnInv(j2);
            int i4 = (int) mixColumnInv;
            int i5 = (int) (mixColumnInv >>> 32);
            int i6 = (int) mixColumnInv2;
            int i7 = (int) (mixColumnInv2 >>> 32);
            byte[] bArr3 = T0;
            byte b = bArr3[i4 & 255];
            byte[] bArr4 = T1;
            byte b2 = bArr4[(i4 >>> 8) & 255];
            byte[] bArr5 = T2;
            byte b3 = bArr5[(i4 >>> 16) & 255];
            byte[] bArr6 = T3;
            int i8 = (bArr6[i4 >>> 24] << BuiltinOptions.BatchToSpaceNDOptions) | ((b3 & UByte.MAX_VALUE) << 16) | (b & UByte.MAX_VALUE) | ((b2 & UByte.MAX_VALUE) << 8);
            byte b4 = bArr3[i7 & 255];
            byte b5 = bArr4[(i7 >>> 8) & 255];
            byte b6 = bArr5[(i7 >>> 16) & 255];
            byte b7 = bArr6[i7 >>> 24];
            long j3 = (((b7 << BuiltinOptions.BatchToSpaceNDOptions) | (((b4 & UByte.MAX_VALUE) | ((b5 & UByte.MAX_VALUE) << 8)) | ((b6 & UByte.MAX_VALUE) << 16))) << 32) | (i8 & BodyPartID.bodyIdMax);
            byte b8 = bArr3[i6 & 255];
            byte b9 = bArr4[(i6 >>> 8) & 255];
            byte b10 = bArr5[(i6 >>> 16) & 255];
            int i9 = (bArr6[i6 >>> 24] << BuiltinOptions.BatchToSpaceNDOptions) | (b8 & UByte.MAX_VALUE) | ((b9 & UByte.MAX_VALUE) << 8) | ((b10 & UByte.MAX_VALUE) << 16);
            byte b11 = bArr3[i5 & 255];
            byte b12 = bArr4[(i5 >>> 8) & 255];
            byte b13 = bArr5[(i5 >>> 16) & 255];
            byte b14 = bArr6[i5 >>> 24];
            long j4 = (i9 & BodyPartID.bodyIdMax) | (((b14 << BuiltinOptions.BatchToSpaceNDOptions) | (((b11 & UByte.MAX_VALUE) | ((b12 & UByte.MAX_VALUE) << 8)) | ((b13 & UByte.MAX_VALUE) << 16))) << 32);
            i3--;
            if (i3 == 0) {
                long[] jArr3 = this.roundKeys[0];
                long j5 = j3 - jArr3[0];
                long j6 = j4 - jArr3[1];
                Pack.longToLittleEndian(j5, bArr2, i2);
                Pack.longToLittleEndian(j6, bArr2, i2 + 8);
                return;
            }
            long[] jArr4 = this.roundKeys[i3];
            long j7 = j3 ^ jArr4[0];
            j2 = j4 ^ jArr4[1];
            j = j7;
        }
    }

    private void encryptBlock_128(byte[] bArr, int i, byte[] bArr2, int i2) {
        long littleEndianToLong = Pack.littleEndianToLong(bArr, i);
        long littleEndianToLong2 = Pack.littleEndianToLong(bArr, i + 8);
        long[] jArr = this.roundKeys[0];
        long j = littleEndianToLong + jArr[0];
        long j2 = littleEndianToLong2 + jArr[1];
        int i3 = 0;
        while (true) {
            int i4 = (int) j;
            int i5 = (int) (j >>> 32);
            int i6 = (int) j2;
            int i7 = (int) (j2 >>> 32);
            byte[] bArr3 = S0;
            byte b = bArr3[i4 & 255];
            byte[] bArr4 = S1;
            byte b2 = bArr4[(i4 >>> 8) & 255];
            byte[] bArr5 = S2;
            byte b3 = bArr5[(i4 >>> 16) & 255];
            byte[] bArr6 = S3;
            int i8 = ((b3 & UByte.MAX_VALUE) << 16) | (b & UByte.MAX_VALUE) | ((b2 & UByte.MAX_VALUE) << 8) | (bArr6[i4 >>> 24] << BuiltinOptions.BatchToSpaceNDOptions);
            byte b4 = bArr3[i7 & 255];
            byte b5 = bArr4[(i7 >>> 8) & 255];
            byte b6 = bArr5[(i7 >>> 16) & 255];
            byte b7 = bArr6[i7 >>> 24];
            long j3 = (((b7 << BuiltinOptions.BatchToSpaceNDOptions) | (((b4 & UByte.MAX_VALUE) | ((b5 & UByte.MAX_VALUE) << 8)) | ((b6 & UByte.MAX_VALUE) << 16))) << 32) | (i8 & BodyPartID.bodyIdMax);
            byte b8 = bArr3[i6 & 255];
            byte b9 = bArr4[(i6 >>> 8) & 255];
            byte b10 = bArr5[(i6 >>> 16) & 255];
            int i9 = (bArr6[i6 >>> 24] << BuiltinOptions.BatchToSpaceNDOptions) | (b8 & UByte.MAX_VALUE) | ((b9 & UByte.MAX_VALUE) << 8) | ((b10 & UByte.MAX_VALUE) << 16);
            byte b11 = bArr3[i5 & 255];
            byte b12 = bArr4[(i5 >>> 8) & 255];
            byte b13 = bArr5[(i5 >>> 16) & 255];
            byte b14 = bArr6[i5 >>> 24];
            long j4 = (i9 & BodyPartID.bodyIdMax) | (((b14 << BuiltinOptions.BatchToSpaceNDOptions) | (((b11 & UByte.MAX_VALUE) | ((b12 & UByte.MAX_VALUE) << 8)) | ((b13 & UByte.MAX_VALUE) << 16))) << 32);
            long mixColumn = mixColumn(j3);
            long mixColumn2 = mixColumn(j4);
            i3++;
            int i10 = this.roundsAmount;
            if (i3 == i10) {
                long[] jArr2 = this.roundKeys[i10];
                long j5 = mixColumn + jArr2[0];
                long j6 = mixColumn2 + jArr2[1];
                Pack.longToLittleEndian(j5, bArr2, i2);
                Pack.longToLittleEndian(j6, bArr2, i2 + 8);
                return;
            }
            long[] jArr3 = this.roundKeys[i3];
            long j7 = mixColumn ^ jArr3[0];
            j2 = mixColumn2 ^ jArr3[1];
            j = j7;
        }
    }

    private void invShiftRows() {
        int i = this.wordsInBlock;
        if (i == 2) {
            long[] jArr = this.internalState;
            long j = jArr[0];
            long j2 = jArr[1];
            long j3 = (-4294967296L) & (j ^ j2);
            jArr[0] = j ^ j3;
            jArr[1] = j3 ^ j2;
            return;
        }
        if (i == 4) {
            long[] jArr2 = this.internalState;
            long j4 = jArr2[0];
            long j5 = jArr2[1];
            long j6 = jArr2[2];
            long j7 = jArr2[3];
            long j8 = (j4 ^ j5) & (-281470681808896L);
            long j9 = j4 ^ j8;
            long j10 = j5 ^ j8;
            long j11 = (j6 ^ j7) & (-281470681808896L);
            long j12 = j6 ^ j11;
            long j13 = j7 ^ j11;
            long j14 = (j9 ^ j12) & (-4294967296L);
            long j15 = j9 ^ j14;
            long j16 = (j10 ^ j13) & 281474976645120L;
            jArr2[0] = j15;
            jArr2[1] = j10 ^ j16;
            jArr2[2] = j12 ^ j14;
            jArr2[3] = j16 ^ j13;
            return;
        }
        if (i != 8) {
            throw new IllegalStateException("unsupported block length: only 128/256/512 are allowed");
        }
        long[] jArr3 = this.internalState;
        long j17 = jArr3[0];
        long j18 = jArr3[1];
        long j19 = jArr3[2];
        long j20 = jArr3[3];
        long j21 = jArr3[4];
        long j22 = jArr3[5];
        long j23 = jArr3[6];
        long j24 = jArr3[7];
        long j25 = (j17 ^ j18) & (-71777214294589696L);
        long j26 = j17 ^ j25;
        long j27 = j18 ^ j25;
        long j28 = (j19 ^ j20) & (-71777214294589696L);
        long j29 = j19 ^ j28;
        long j30 = j20 ^ j28;
        long j31 = (j21 ^ j22) & (-71777214294589696L);
        long j32 = j21 ^ j31;
        long j33 = j22 ^ j31;
        long j34 = (j23 ^ j24) & (-71777214294589696L);
        long j35 = j23 ^ j34;
        long j36 = j24 ^ j34;
        long j37 = (j26 ^ j29) & (-281470681808896L);
        long j38 = j26 ^ j37;
        long j39 = j29 ^ j37;
        long j40 = (j27 ^ j30) & 72056494543077120L;
        long j41 = j27 ^ j40;
        long j42 = j30 ^ j40;
        long j43 = (j32 ^ j35) & (-281470681808896L);
        long j44 = j32 ^ j43;
        long j45 = j35 ^ j43;
        long j46 = (j33 ^ j36) & 72056494543077120L;
        long j47 = j33 ^ j46;
        long j48 = j36 ^ j46;
        long j49 = (j38 ^ j44) & (-4294967296L);
        long j50 = j38 ^ j49;
        long j51 = j44 ^ j49;
        long j52 = (j41 ^ j47) & 72057594021150720L;
        long j53 = j41 ^ j52;
        long j54 = (j39 ^ j45) & 281474976645120L;
        long j55 = j39 ^ j54;
        long j56 = j54 ^ j45;
        long j57 = (j42 ^ j48) & 1099511627520L;
        jArr3[0] = j50;
        jArr3[1] = j53;
        jArr3[2] = j55;
        jArr3[3] = j42 ^ j57;
        jArr3[4] = j51;
        jArr3[5] = j47 ^ j52;
        jArr3[6] = j56;
        jArr3[7] = j48 ^ j57;
    }

    private void invSubBytes() {
        for (int i = 0; i < this.wordsInBlock; i++) {
            long[] jArr = this.internalState;
            long j = jArr[i];
            int i2 = (int) j;
            int i3 = (int) (j >>> 32);
            byte[] bArr = T0;
            byte b = bArr[i2 & 255];
            byte[] bArr2 = T1;
            byte b2 = bArr2[(i2 >>> 8) & 255];
            byte[] bArr3 = T2;
            byte b3 = bArr3[(i2 >>> 16) & 255];
            byte[] bArr4 = T3;
            int i4 = (bArr4[i2 >>> 24] << BuiltinOptions.BatchToSpaceNDOptions) | (b & UByte.MAX_VALUE) | ((b2 & UByte.MAX_VALUE) << 8) | ((b3 & UByte.MAX_VALUE) << 16);
            byte b4 = bArr[i3 & 255];
            byte b5 = bArr2[(i3 >>> 8) & 255];
            byte b6 = bArr3[(i3 >>> 16) & 255];
            byte b7 = bArr4[i3 >>> 24];
            jArr[i] = (i4 & BodyPartID.bodyIdMax) | (((b7 << BuiltinOptions.BatchToSpaceNDOptions) | (((b4 & UByte.MAX_VALUE) | ((b5 & UByte.MAX_VALUE) << 8)) | ((b6 & UByte.MAX_VALUE) << 16))) << 32);
        }
    }

    private static long mixColumn(long j) {
        long mulX = mulX(j);
        long rotate = rotate(8, j) ^ j;
        long rotate2 = (rotate ^ rotate(16, rotate)) ^ rotate(48, j);
        return ((rotate(32, mulX2((j ^ rotate2) ^ mulX)) ^ rotate2) ^ rotate(40, mulX)) ^ rotate(48, mulX);
    }

    private static long mixColumnInv(long j) {
        long rotate = rotate(8, j) ^ j;
        long rotate2 = (rotate ^ rotate(32, rotate)) ^ rotate(48, j);
        long j2 = rotate2 ^ j;
        long rotate3 = rotate(48, j);
        long rotate4 = rotate(56, j);
        long mulX = mulX(j2 ^ rotate4) ^ rotate(56, j2);
        long mulX2 = mulX(rotate(40, mulX(mulX) ^ j) ^ (rotate(16, j2) ^ j)) ^ (j2 ^ rotate3);
        return mulX(rotate(40, ((j ^ rotate(32, j2)) ^ rotate4) ^ mulX(((rotate3 ^ (rotate(24, j) ^ j2)) ^ rotate4) ^ mulX(mulX(mulX2) ^ rotate(16, rotate2))))) ^ rotate2;
    }

    private void mixColumns() {
        for (int i = 0; i < this.wordsInBlock; i++) {
            long[] jArr = this.internalState;
            jArr[i] = mixColumn(jArr[i]);
        }
    }

    private void mixColumnsInv() {
        for (int i = 0; i < this.wordsInBlock; i++) {
            long[] jArr = this.internalState;
            jArr[i] = mixColumnInv(jArr[i]);
        }
    }

    private static long mulX(long j) {
        return (((j & (-9187201950435737472L)) >>> 7) * 29) ^ ((9187201950435737471L & j) << 1);
    }

    private static long mulX2(long j) {
        return (((j & 4629771061636907072L) >>> 6) * 29) ^ (((4557430888798830399L & j) << 2) ^ ((((-9187201950435737472L) & j) >>> 6) * 29));
    }

    private static long rotate(int i, long j) {
        return (j << (-i)) | (j >>> i);
    }

    private void rotateLeft(long[] jArr, long[] jArr2) {
        int i = this.wordsInBlock;
        if (i == 2) {
            long j = jArr[0];
            long j2 = jArr[1];
            jArr2[0] = (j >>> 56) | (j2 << 8);
            jArr2[1] = (j << 8) | (j2 >>> 56);
            return;
        }
        if (i == 4) {
            long j3 = jArr[0];
            long j4 = jArr[1];
            long j5 = jArr[2];
            long j6 = jArr[3];
            jArr2[0] = (j4 >>> 24) | (j5 << 40);
            jArr2[1] = (j5 >>> 24) | (j6 << 40);
            jArr2[2] = (j6 >>> 24) | (j3 << 40);
            jArr2[3] = (j3 >>> 24) | (j4 << 40);
            return;
        }
        if (i != 8) {
            throw new IllegalStateException("unsupported block length: only 128/256/512 are allowed");
        }
        long j7 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        long j11 = jArr[4];
        long j12 = jArr[5];
        long j13 = jArr[6];
        long j14 = jArr[7];
        jArr2[0] = (j9 >>> 24) | (j10 << 40);
        jArr2[1] = (j10 >>> 24) | (j11 << 40);
        jArr2[2] = (j11 >>> 24) | (j12 << 40);
        jArr2[3] = (j12 >>> 24) | (j13 << 40);
        jArr2[4] = (j13 >>> 24) | (j14 << 40);
        jArr2[5] = (j14 >>> 24) | (j7 << 40);
        jArr2[6] = (j7 >>> 24) | (j8 << 40);
        jArr2[7] = (j8 >>> 24) | (j9 << 40);
    }

    private void shiftRows() {
        int i = this.wordsInBlock;
        if (i == 2) {
            long[] jArr = this.internalState;
            long j = jArr[0];
            long j2 = jArr[1];
            long j3 = (-4294967296L) & (j ^ j2);
            jArr[0] = j ^ j3;
            jArr[1] = j3 ^ j2;
            return;
        }
        if (i == 4) {
            long[] jArr2 = this.internalState;
            long j4 = jArr2[0];
            long j5 = jArr2[1];
            long j6 = jArr2[2];
            long j7 = jArr2[3];
            long j8 = (j4 ^ j6) & (-4294967296L);
            long j9 = j4 ^ j8;
            long j10 = j6 ^ j8;
            long j11 = (j5 ^ j7) & 281474976645120L;
            long j12 = j5 ^ j11;
            long j13 = j7 ^ j11;
            long j14 = (j9 ^ j12) & (-281470681808896L);
            long j15 = (j10 ^ j13) & (-281470681808896L);
            jArr2[0] = j9 ^ j14;
            jArr2[1] = j12 ^ j14;
            jArr2[2] = j10 ^ j15;
            jArr2[3] = j13 ^ j15;
            return;
        }
        if (i != 8) {
            throw new IllegalStateException("unsupported block length: only 128/256/512 are allowed");
        }
        long[] jArr3 = this.internalState;
        long j16 = jArr3[0];
        long j17 = jArr3[1];
        long j18 = jArr3[2];
        long j19 = jArr3[3];
        long j20 = jArr3[4];
        long j21 = jArr3[5];
        long j22 = jArr3[6];
        long j23 = jArr3[7];
        long j24 = (j16 ^ j20) & (-4294967296L);
        long j25 = j16 ^ j24;
        long j26 = j20 ^ j24;
        long j27 = (j17 ^ j21) & 72057594021150720L;
        long j28 = j17 ^ j27;
        long j29 = j21 ^ j27;
        long j30 = (j18 ^ j22) & 281474976645120L;
        long j31 = j18 ^ j30;
        long j32 = j22 ^ j30;
        long j33 = (j19 ^ j23) & 1099511627520L;
        long j34 = j19 ^ j33;
        long j35 = j23 ^ j33;
        long j36 = (j25 ^ j31) & (-281470681808896L);
        long j37 = j25 ^ j36;
        long j38 = j31 ^ j36;
        long j39 = (j28 ^ j34) & 72056494543077120L;
        long j40 = j28 ^ j39;
        long j41 = j34 ^ j39;
        long j42 = (j26 ^ j32) & (-281470681808896L);
        long j43 = j26 ^ j42;
        long j44 = j32 ^ j42;
        long j45 = (j29 ^ j35) & 72056494543077120L;
        long j46 = j29 ^ j45;
        long j47 = j35 ^ j45;
        long j48 = (j37 ^ j40) & (-71777214294589696L);
        long j49 = j37 ^ j48;
        long j50 = j40 ^ j48;
        long j51 = (j38 ^ j41) & (-71777214294589696L);
        long j52 = j38 ^ j51;
        long j53 = j41 ^ j51;
        long j54 = (j43 ^ j46) & (-71777214294589696L);
        long j55 = j43 ^ j54;
        long j56 = j46 ^ j54;
        long j57 = (j44 ^ j47) & (-71777214294589696L);
        jArr3[0] = j49;
        jArr3[1] = j50;
        jArr3[2] = j52;
        jArr3[3] = j53;
        jArr3[4] = j55;
        jArr3[5] = j56;
        jArr3[6] = j44 ^ j57;
        jArr3[7] = j47 ^ j57;
    }

    private void subBytes() {
        for (int i = 0; i < this.wordsInBlock; i++) {
            long[] jArr = this.internalState;
            long j = jArr[i];
            int i2 = (int) j;
            int i3 = (int) (j >>> 32);
            byte[] bArr = S0;
            byte b = bArr[i2 & 255];
            byte[] bArr2 = S1;
            byte b2 = bArr2[(i2 >>> 8) & 255];
            byte[] bArr3 = S2;
            byte b3 = bArr3[(i2 >>> 16) & 255];
            byte[] bArr4 = S3;
            int i4 = (bArr4[i2 >>> 24] << BuiltinOptions.BatchToSpaceNDOptions) | (b & UByte.MAX_VALUE) | ((b2 & UByte.MAX_VALUE) << 8) | ((b3 & UByte.MAX_VALUE) << 16);
            byte b4 = bArr[i3 & 255];
            byte b5 = bArr2[(i3 >>> 8) & 255];
            byte b6 = bArr3[(i3 >>> 16) & 255];
            byte b7 = bArr4[i3 >>> 24];
            jArr[i] = (i4 & BodyPartID.bodyIdMax) | (((b7 << BuiltinOptions.BatchToSpaceNDOptions) | (((b4 & UByte.MAX_VALUE) | ((b5 & UByte.MAX_VALUE) << 8)) | ((b6 & UByte.MAX_VALUE) << 16))) << 32);
        }
    }

    private void subRoundKey(int i) {
        long[] jArr = this.roundKeys[i];
        for (int i2 = 0; i2 < this.wordsInBlock; i2++) {
            long[] jArr2 = this.internalState;
            jArr2[i2] = jArr2[i2] - jArr[i2];
        }
    }

    private void workingKeyExpandEven(long[] jArr, long[] jArr2) {
        int i;
        int i2;
        int i3 = this.wordsInKey;
        long[] jArr3 = new long[i3];
        long[] jArr4 = new long[this.wordsInBlock];
        System.arraycopy(jArr, 0, jArr3, 0, i3);
        long j = 281479271743489L;
        int i4 = 0;
        while (true) {
            for (int i5 = 0; i5 < this.wordsInBlock; i5++) {
                jArr4[i5] = jArr2[i5] + j;
            }
            for (int i6 = 0; i6 < this.wordsInBlock; i6++) {
                this.internalState[i6] = jArr3[i6] + jArr4[i6];
            }
            subBytes();
            shiftRows();
            mixColumns();
            for (int i7 = 0; i7 < this.wordsInBlock; i7++) {
                long[] jArr5 = this.internalState;
                jArr5[i7] = jArr5[i7] ^ jArr4[i7];
            }
            subBytes();
            shiftRows();
            mixColumns();
            int i8 = 0;
            while (true) {
                i = this.wordsInBlock;
                if (i8 >= i) {
                    break;
                }
                long[] jArr6 = this.internalState;
                jArr6[i8] = jArr6[i8] + jArr4[i8];
                i8++;
            }
            System.arraycopy(this.internalState, 0, this.roundKeys[i4], 0, i);
            if (this.roundsAmount == i4) {
                return;
            }
            if (this.wordsInBlock != this.wordsInKey) {
                i4 += 2;
                j <<= 1;
                for (int i9 = 0; i9 < this.wordsInBlock; i9++) {
                    jArr4[i9] = jArr2[i9] + j;
                }
                int i10 = 0;
                while (true) {
                    int i11 = this.wordsInBlock;
                    if (i10 >= i11) {
                        break;
                    }
                    this.internalState[i10] = jArr3[i11 + i10] + jArr4[i10];
                    i10++;
                }
                subBytes();
                shiftRows();
                mixColumns();
                for (int i12 = 0; i12 < this.wordsInBlock; i12++) {
                    long[] jArr7 = this.internalState;
                    jArr7[i12] = jArr7[i12] ^ jArr4[i12];
                }
                subBytes();
                shiftRows();
                mixColumns();
                int i13 = 0;
                while (true) {
                    i2 = this.wordsInBlock;
                    if (i13 >= i2) {
                        break;
                    }
                    long[] jArr8 = this.internalState;
                    jArr8[i13] = jArr8[i13] + jArr4[i13];
                    i13++;
                }
                System.arraycopy(this.internalState, 0, this.roundKeys[i4], 0, i2);
                if (this.roundsAmount == i4) {
                    return;
                }
            }
            i4 += 2;
            j <<= 1;
            long j2 = jArr3[0];
            for (int i14 = 1; i14 < i3; i14++) {
                jArr3[i14 - 1] = jArr3[i14];
            }
            jArr3[i3 - 1] = j2;
        }
    }

    private void workingKeyExpandKT(long[] jArr, long[] jArr2) {
        int i = this.wordsInBlock;
        long[] jArr3 = new long[i];
        long[] jArr4 = new long[i];
        long[] jArr5 = new long[i];
        this.internalState = jArr5;
        long j = jArr5[0];
        int i2 = this.wordsInKey;
        jArr5[0] = j + i + i2 + 1;
        System.arraycopy(jArr, 0, jArr3, 0, i);
        if (i == i2) {
            System.arraycopy(jArr, 0, jArr4, 0, i);
        } else {
            int i3 = this.wordsInBlock;
            System.arraycopy(jArr, i3, jArr4, 0, i3);
        }
        int i4 = 0;
        while (true) {
            long[] jArr6 = this.internalState;
            if (i4 >= jArr6.length) {
                break;
            }
            jArr6[i4] = jArr6[i4] + jArr3[i4];
            i4++;
        }
        subBytes();
        shiftRows();
        mixColumns();
        int i5 = 0;
        while (true) {
            long[] jArr7 = this.internalState;
            if (i5 >= jArr7.length) {
                break;
            }
            jArr7[i5] = jArr7[i5] ^ jArr4[i5];
            i5++;
        }
        subBytes();
        shiftRows();
        mixColumns();
        int i6 = 0;
        while (true) {
            long[] jArr8 = this.internalState;
            if (i6 >= jArr8.length) {
                subBytes();
                shiftRows();
                mixColumns();
                System.arraycopy(this.internalState, 0, jArr2, 0, this.wordsInBlock);
                return;
            }
            jArr8[i6] = jArr8[i6] + jArr3[i6];
            i6++;
        }
    }

    private void workingKeyExpandOdd() {
        for (int i = 1; i < this.roundsAmount; i += 2) {
            long[][] jArr = this.roundKeys;
            rotateLeft(jArr[i - 1], jArr[i]);
        }
    }

    private void xorRoundKey(int i) {
        long[] jArr = this.roundKeys[i];
        for (int i2 = 0; i2 < this.wordsInBlock; i2++) {
            long[] jArr2 = this.internalState;
            jArr2[i2] = jArr2[i2] ^ jArr[i2];
        }
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "DSTU7624";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.wordsInBlock << 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005b A[LOOP:0: B:21:0x0056->B:23:0x005b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064 A[EDGE_INSN: B:24:0x0064->B:25:0x0064 BREAK  A[LOOP:0: B:21:0x0056->B:23:0x005b], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0084  */
    @Override // org.bouncycastle.crypto.BlockCipher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void init(boolean r5, org.bouncycastle.crypto.CipherParameters r6) throws java.lang.IllegalArgumentException {
        /*
            r4 = this;
            boolean r0 = r6 instanceof org.bouncycastle.crypto.params.KeyParameter
            if (r0 == 0) goto L8c
            r4.forEncryption = r5
            org.bouncycastle.crypto.params.KeyParameter r6 = (org.bouncycastle.crypto.params.KeyParameter) r6
            byte[] r5 = r6.getKey()
            int r6 = r5.length
            int r6 = r6 << 3
            int r0 = r4.wordsInBlock
            int r0 = r0 << 6
            r1 = 512(0x200, float:7.17E-43)
            r2 = 256(0x100, float:3.59E-43)
            r3 = 128(0x80, float:1.8E-43)
            if (r6 == r3) goto L28
            if (r6 == r2) goto L28
            if (r6 != r1) goto L20
            goto L28
        L20:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "unsupported key length: only 128/256/512 are allowed"
            r5.<init>(r6)
            throw r5
        L28:
            if (r6 == r0) goto L37
            int r0 = r0 * 2
            if (r6 != r0) goto L2f
            goto L37
        L2f:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Unsupported key length"
            r5.<init>(r6)
            throw r5
        L37:
            if (r6 == r3) goto L44
            if (r6 == r2) goto L41
            if (r6 == r1) goto L3e
            goto L48
        L3e:
            r0 = 18
            goto L46
        L41:
            r0 = 14
            goto L46
        L44:
            r0 = 10
        L46:
            r4.roundsAmount = r0
        L48:
            int r0 = r6 >>> 6
            r4.wordsInKey = r0
            int r0 = r4.roundsAmount
            int r0 = r0 + 1
            long[][] r0 = new long[r0][]
            r4.roundKeys = r0
            r0 = 0
            r1 = r0
        L56:
            long[][] r2 = r4.roundKeys
            int r3 = r2.length
            if (r1 >= r3) goto L64
            int r3 = r4.wordsInBlock
            long[] r3 = new long[r3]
            r2[r1] = r3
            int r1 = r1 + 1
            goto L56
        L64:
            int r1 = r4.wordsInKey
            long[] r1 = new long[r1]
            r4.workingKey = r1
            int r2 = r5.length
            int r6 = r6 >>> 3
            if (r2 != r6) goto L84
            org.bouncycastle.util.Pack.littleEndianToLong(r5, r0, r1)
            int r5 = r4.wordsInBlock
            long[] r5 = new long[r5]
            long[] r6 = r4.workingKey
            r4.workingKeyExpandKT(r6, r5)
            long[] r6 = r4.workingKey
            r4.workingKeyExpandEven(r6, r5)
            r4.workingKeyExpandOdd()
            return
        L84:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Invalid key parameter passed to DSTU7624Engine init"
            r5.<init>(r6)
            throw r5
        L8c:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Invalid parameter passed to DSTU7624Engine init"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.engines.DSTU7624Engine.init(boolean, org.bouncycastle.crypto.CipherParameters):void");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        int i3;
        if (this.workingKey == null) {
            throw new IllegalStateException("DSTU7624Engine not initialised");
        }
        if (getBlockSize() + i > bArr.length) {
            throw new DataLengthException("Input buffer too short");
        }
        if (getBlockSize() + i2 > bArr2.length) {
            throw new OutputLengthException("Output buffer too short");
        }
        int i4 = 0;
        if (this.forEncryption) {
            if (this.wordsInBlock != 2) {
                Pack.littleEndianToLong(bArr, i, this.internalState);
                addRoundKey(0);
                while (true) {
                    subBytes();
                    shiftRows();
                    mixColumns();
                    i4++;
                    i3 = this.roundsAmount;
                    if (i4 == i3) {
                        break;
                    }
                    xorRoundKey(i4);
                }
                addRoundKey(i3);
                Pack.longToLittleEndian(this.internalState, bArr2, i2);
            } else {
                encryptBlock_128(bArr, i, bArr2, i2);
            }
        } else if (this.wordsInBlock != 2) {
            Pack.littleEndianToLong(bArr, i, this.internalState);
            subRoundKey(this.roundsAmount);
            int i5 = this.roundsAmount;
            while (true) {
                mixColumnsInv();
                invShiftRows();
                invSubBytes();
                i5--;
                if (i5 == 0) {
                    break;
                }
                xorRoundKey(i5);
            }
            subRoundKey(0);
            Pack.longToLittleEndian(this.internalState, bArr2, i2);
        } else {
            decryptBlock_128(bArr, i, bArr2, i2);
        }
        return getBlockSize();
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        Arrays.fill(this.internalState, 0L);
    }
}
