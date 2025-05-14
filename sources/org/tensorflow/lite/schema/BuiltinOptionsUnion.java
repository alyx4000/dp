package org.tensorflow.lite.schema;

import com.google.flatbuffers.FlatBufferBuilder;

/* loaded from: classes6.dex */
public class BuiltinOptionsUnion {
    private byte type = 0;
    private Object value = null;

    public byte getType() {
        return this.type;
    }

    public void setType(byte b) {
        this.type = b;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public Conv2DOptionsT asConv2DOptions() {
        return (Conv2DOptionsT) this.value;
    }

    public DepthwiseConv2DOptionsT asDepthwiseConv2DOptions() {
        return (DepthwiseConv2DOptionsT) this.value;
    }

    public ConcatEmbeddingsOptionsT asConcatEmbeddingsOptions() {
        return (ConcatEmbeddingsOptionsT) this.value;
    }

    public LSHProjectionOptionsT asLSHProjectionOptions() {
        return (LSHProjectionOptionsT) this.value;
    }

    public Pool2DOptionsT asPool2DOptions() {
        return (Pool2DOptionsT) this.value;
    }

    public SVDFOptionsT asSVDFOptions() {
        return (SVDFOptionsT) this.value;
    }

    public RNNOptionsT asRNNOptions() {
        return (RNNOptionsT) this.value;
    }

    public FullyConnectedOptionsT asFullyConnectedOptions() {
        return (FullyConnectedOptionsT) this.value;
    }

    public SoftmaxOptionsT asSoftmaxOptions() {
        return (SoftmaxOptionsT) this.value;
    }

    public ConcatenationOptionsT asConcatenationOptions() {
        return (ConcatenationOptionsT) this.value;
    }

    public AddOptionsT asAddOptions() {
        return (AddOptionsT) this.value;
    }

    public L2NormOptionsT asL2NormOptions() {
        return (L2NormOptionsT) this.value;
    }

    public LocalResponseNormalizationOptionsT asLocalResponseNormalizationOptions() {
        return (LocalResponseNormalizationOptionsT) this.value;
    }

    public LSTMOptionsT asLSTMOptions() {
        return (LSTMOptionsT) this.value;
    }

    public ResizeBilinearOptionsT asResizeBilinearOptions() {
        return (ResizeBilinearOptionsT) this.value;
    }

    public CallOptionsT asCallOptions() {
        return (CallOptionsT) this.value;
    }

    public ReshapeOptionsT asReshapeOptions() {
        return (ReshapeOptionsT) this.value;
    }

    public SkipGramOptionsT asSkipGramOptions() {
        return (SkipGramOptionsT) this.value;
    }

    public SpaceToDepthOptionsT asSpaceToDepthOptions() {
        return (SpaceToDepthOptionsT) this.value;
    }

    public EmbeddingLookupSparseOptionsT asEmbeddingLookupSparseOptions() {
        return (EmbeddingLookupSparseOptionsT) this.value;
    }

    public MulOptionsT asMulOptions() {
        return (MulOptionsT) this.value;
    }

    public PadOptionsT asPadOptions() {
        return (PadOptionsT) this.value;
    }

    public GatherOptionsT asGatherOptions() {
        return (GatherOptionsT) this.value;
    }

    public BatchToSpaceNDOptionsT asBatchToSpaceNDOptions() {
        return (BatchToSpaceNDOptionsT) this.value;
    }

    public SpaceToBatchNDOptionsT asSpaceToBatchNDOptions() {
        return (SpaceToBatchNDOptionsT) this.value;
    }

    public TransposeOptionsT asTransposeOptions() {
        return (TransposeOptionsT) this.value;
    }

    public ReducerOptionsT asReducerOptions() {
        return (ReducerOptionsT) this.value;
    }

    public SubOptionsT asSubOptions() {
        return (SubOptionsT) this.value;
    }

    public DivOptionsT asDivOptions() {
        return (DivOptionsT) this.value;
    }

    public SqueezeOptionsT asSqueezeOptions() {
        return (SqueezeOptionsT) this.value;
    }

    public SequenceRNNOptionsT asSequenceRNNOptions() {
        return (SequenceRNNOptionsT) this.value;
    }

    public StridedSliceOptionsT asStridedSliceOptions() {
        return (StridedSliceOptionsT) this.value;
    }

    public ExpOptionsT asExpOptions() {
        return (ExpOptionsT) this.value;
    }

    public TopKV2OptionsT asTopKV2Options() {
        return (TopKV2OptionsT) this.value;
    }

    public SplitOptionsT asSplitOptions() {
        return (SplitOptionsT) this.value;
    }

    public LogSoftmaxOptionsT asLogSoftmaxOptions() {
        return (LogSoftmaxOptionsT) this.value;
    }

    public CastOptionsT asCastOptions() {
        return (CastOptionsT) this.value;
    }

    public DequantizeOptionsT asDequantizeOptions() {
        return (DequantizeOptionsT) this.value;
    }

    public MaximumMinimumOptionsT asMaximumMinimumOptions() {
        return (MaximumMinimumOptionsT) this.value;
    }

    public ArgMaxOptionsT asArgMaxOptions() {
        return (ArgMaxOptionsT) this.value;
    }

    public LessOptionsT asLessOptions() {
        return (LessOptionsT) this.value;
    }

    public NegOptionsT asNegOptions() {
        return (NegOptionsT) this.value;
    }

    public PadV2OptionsT asPadV2Options() {
        return (PadV2OptionsT) this.value;
    }

    public GreaterOptionsT asGreaterOptions() {
        return (GreaterOptionsT) this.value;
    }

    public GreaterEqualOptionsT asGreaterEqualOptions() {
        return (GreaterEqualOptionsT) this.value;
    }

    public LessEqualOptionsT asLessEqualOptions() {
        return (LessEqualOptionsT) this.value;
    }

    public SelectOptionsT asSelectOptions() {
        return (SelectOptionsT) this.value;
    }

    public SliceOptionsT asSliceOptions() {
        return (SliceOptionsT) this.value;
    }

    public TransposeConvOptionsT asTransposeConvOptions() {
        return (TransposeConvOptionsT) this.value;
    }

    public SparseToDenseOptionsT asSparseToDenseOptions() {
        return (SparseToDenseOptionsT) this.value;
    }

    public TileOptionsT asTileOptions() {
        return (TileOptionsT) this.value;
    }

    public ExpandDimsOptionsT asExpandDimsOptions() {
        return (ExpandDimsOptionsT) this.value;
    }

    public EqualOptionsT asEqualOptions() {
        return (EqualOptionsT) this.value;
    }

    public NotEqualOptionsT asNotEqualOptions() {
        return (NotEqualOptionsT) this.value;
    }

    public ShapeOptionsT asShapeOptions() {
        return (ShapeOptionsT) this.value;
    }

    public PowOptionsT asPowOptions() {
        return (PowOptionsT) this.value;
    }

    public ArgMinOptionsT asArgMinOptions() {
        return (ArgMinOptionsT) this.value;
    }

    public FakeQuantOptionsT asFakeQuantOptions() {
        return (FakeQuantOptionsT) this.value;
    }

    public PackOptionsT asPackOptions() {
        return (PackOptionsT) this.value;
    }

    public LogicalOrOptionsT asLogicalOrOptions() {
        return (LogicalOrOptionsT) this.value;
    }

    public OneHotOptionsT asOneHotOptions() {
        return (OneHotOptionsT) this.value;
    }

    public LogicalAndOptionsT asLogicalAndOptions() {
        return (LogicalAndOptionsT) this.value;
    }

    public LogicalNotOptionsT asLogicalNotOptions() {
        return (LogicalNotOptionsT) this.value;
    }

    public UnpackOptionsT asUnpackOptions() {
        return (UnpackOptionsT) this.value;
    }

    public FloorDivOptionsT asFloorDivOptions() {
        return (FloorDivOptionsT) this.value;
    }

    public SquareOptionsT asSquareOptions() {
        return (SquareOptionsT) this.value;
    }

    public ZerosLikeOptionsT asZerosLikeOptions() {
        return (ZerosLikeOptionsT) this.value;
    }

    public FillOptionsT asFillOptions() {
        return (FillOptionsT) this.value;
    }

    public BidirectionalSequenceLSTMOptionsT asBidirectionalSequenceLSTMOptions() {
        return (BidirectionalSequenceLSTMOptionsT) this.value;
    }

    public BidirectionalSequenceRNNOptionsT asBidirectionalSequenceRNNOptions() {
        return (BidirectionalSequenceRNNOptionsT) this.value;
    }

    public UnidirectionalSequenceLSTMOptionsT asUnidirectionalSequenceLSTMOptions() {
        return (UnidirectionalSequenceLSTMOptionsT) this.value;
    }

    public FloorModOptionsT asFloorModOptions() {
        return (FloorModOptionsT) this.value;
    }

    public RangeOptionsT asRangeOptions() {
        return (RangeOptionsT) this.value;
    }

    public ResizeNearestNeighborOptionsT asResizeNearestNeighborOptions() {
        return (ResizeNearestNeighborOptionsT) this.value;
    }

    public LeakyReluOptionsT asLeakyReluOptions() {
        return (LeakyReluOptionsT) this.value;
    }

    public SquaredDifferenceOptionsT asSquaredDifferenceOptions() {
        return (SquaredDifferenceOptionsT) this.value;
    }

    public MirrorPadOptionsT asMirrorPadOptions() {
        return (MirrorPadOptionsT) this.value;
    }

    public AbsOptionsT asAbsOptions() {
        return (AbsOptionsT) this.value;
    }

    public SplitVOptionsT asSplitVOptions() {
        return (SplitVOptionsT) this.value;
    }

    public UniqueOptionsT asUniqueOptions() {
        return (UniqueOptionsT) this.value;
    }

    public ReverseV2OptionsT asReverseV2Options() {
        return (ReverseV2OptionsT) this.value;
    }

    public AddNOptionsT asAddNOptions() {
        return (AddNOptionsT) this.value;
    }

    public GatherNdOptionsT asGatherNdOptions() {
        return (GatherNdOptionsT) this.value;
    }

    public CosOptionsT asCosOptions() {
        return (CosOptionsT) this.value;
    }

    public WhereOptionsT asWhereOptions() {
        return (WhereOptionsT) this.value;
    }

    public RankOptionsT asRankOptions() {
        return (RankOptionsT) this.value;
    }

    public ReverseSequenceOptionsT asReverseSequenceOptions() {
        return (ReverseSequenceOptionsT) this.value;
    }

    public MatrixDiagOptionsT asMatrixDiagOptions() {
        return (MatrixDiagOptionsT) this.value;
    }

    public QuantizeOptionsT asQuantizeOptions() {
        return (QuantizeOptionsT) this.value;
    }

    public MatrixSetDiagOptionsT asMatrixSetDiagOptions() {
        return (MatrixSetDiagOptionsT) this.value;
    }

    public HardSwishOptionsT asHardSwishOptions() {
        return (HardSwishOptionsT) this.value;
    }

    public IfOptionsT asIfOptions() {
        return (IfOptionsT) this.value;
    }

    public WhileOptionsT asWhileOptions() {
        return (WhileOptionsT) this.value;
    }

    public DepthToSpaceOptionsT asDepthToSpaceOptions() {
        return (DepthToSpaceOptionsT) this.value;
    }

    public NonMaxSuppressionV4OptionsT asNonMaxSuppressionV4Options() {
        return (NonMaxSuppressionV4OptionsT) this.value;
    }

    public NonMaxSuppressionV5OptionsT asNonMaxSuppressionV5Options() {
        return (NonMaxSuppressionV5OptionsT) this.value;
    }

    public ScatterNdOptionsT asScatterNdOptions() {
        return (ScatterNdOptionsT) this.value;
    }

    public SelectV2OptionsT asSelectV2Options() {
        return (SelectV2OptionsT) this.value;
    }

    public DensifyOptionsT asDensifyOptions() {
        return (DensifyOptionsT) this.value;
    }

    public SegmentSumOptionsT asSegmentSumOptions() {
        return (SegmentSumOptionsT) this.value;
    }

    public BatchMatMulOptionsT asBatchMatMulOptions() {
        return (BatchMatMulOptionsT) this.value;
    }

    public CumsumOptionsT asCumsumOptions() {
        return (CumsumOptionsT) this.value;
    }

    public CallOnceOptionsT asCallOnceOptions() {
        return (CallOnceOptionsT) this.value;
    }

    public BroadcastToOptionsT asBroadcastToOptions() {
        return (BroadcastToOptionsT) this.value;
    }

    public Rfft2dOptionsT asRfft2dOptions() {
        return (Rfft2dOptionsT) this.value;
    }

    public Conv3DOptionsT asConv3DOptions() {
        return (Conv3DOptionsT) this.value;
    }

    public HashtableOptionsT asHashtableOptions() {
        return (HashtableOptionsT) this.value;
    }

    public HashtableFindOptionsT asHashtableFindOptions() {
        return (HashtableFindOptionsT) this.value;
    }

    public HashtableImportOptionsT asHashtableImportOptions() {
        return (HashtableImportOptionsT) this.value;
    }

    public HashtableSizeOptionsT asHashtableSizeOptions() {
        return (HashtableSizeOptionsT) this.value;
    }

    public VarHandleOptionsT asVarHandleOptions() {
        return (VarHandleOptionsT) this.value;
    }

    public ReadVariableOptionsT asReadVariableOptions() {
        return (ReadVariableOptionsT) this.value;
    }

    public AssignVariableOptionsT asAssignVariableOptions() {
        return (AssignVariableOptionsT) this.value;
    }

    public RandomOptionsT asRandomOptions() {
        return (RandomOptionsT) this.value;
    }

    public BucketizeOptionsT asBucketizeOptions() {
        return (BucketizeOptionsT) this.value;
    }

    public GeluOptionsT asGeluOptions() {
        return (GeluOptionsT) this.value;
    }

    public DynamicUpdateSliceOptionsT asDynamicUpdateSliceOptions() {
        return (DynamicUpdateSliceOptionsT) this.value;
    }

    public UnsortedSegmentProdOptionsT asUnsortedSegmentProdOptions() {
        return (UnsortedSegmentProdOptionsT) this.value;
    }

    public UnsortedSegmentMaxOptionsT asUnsortedSegmentMaxOptions() {
        return (UnsortedSegmentMaxOptionsT) this.value;
    }

    public UnsortedSegmentMinOptionsT asUnsortedSegmentMinOptions() {
        return (UnsortedSegmentMinOptionsT) this.value;
    }

    public UnsortedSegmentSumOptionsT asUnsortedSegmentSumOptions() {
        return (UnsortedSegmentSumOptionsT) this.value;
    }

    public ATan2OptionsT asATan2Options() {
        return (ATan2OptionsT) this.value;
    }

    public SignOptionsT asSignOptions() {
        return (SignOptionsT) this.value;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, BuiltinOptionsUnion builtinOptionsUnion) {
        switch (builtinOptionsUnion.type) {
            case 1:
                return Conv2DOptions.pack(flatBufferBuilder, builtinOptionsUnion.asConv2DOptions());
            case 2:
                return DepthwiseConv2DOptions.pack(flatBufferBuilder, builtinOptionsUnion.asDepthwiseConv2DOptions());
            case 3:
                return ConcatEmbeddingsOptions.pack(flatBufferBuilder, builtinOptionsUnion.asConcatEmbeddingsOptions());
            case 4:
                return LSHProjectionOptions.pack(flatBufferBuilder, builtinOptionsUnion.asLSHProjectionOptions());
            case 5:
                return Pool2DOptions.pack(flatBufferBuilder, builtinOptionsUnion.asPool2DOptions());
            case 6:
                return SVDFOptions.pack(flatBufferBuilder, builtinOptionsUnion.asSVDFOptions());
            case 7:
                return RNNOptions.pack(flatBufferBuilder, builtinOptionsUnion.asRNNOptions());
            case 8:
                return FullyConnectedOptions.pack(flatBufferBuilder, builtinOptionsUnion.asFullyConnectedOptions());
            case 9:
                return SoftmaxOptions.pack(flatBufferBuilder, builtinOptionsUnion.asSoftmaxOptions());
            case 10:
                return ConcatenationOptions.pack(flatBufferBuilder, builtinOptionsUnion.asConcatenationOptions());
            case 11:
                return AddOptions.pack(flatBufferBuilder, builtinOptionsUnion.asAddOptions());
            case 12:
                return L2NormOptions.pack(flatBufferBuilder, builtinOptionsUnion.asL2NormOptions());
            case 13:
                return LocalResponseNormalizationOptions.pack(flatBufferBuilder, builtinOptionsUnion.asLocalResponseNormalizationOptions());
            case 14:
                return LSTMOptions.pack(flatBufferBuilder, builtinOptionsUnion.asLSTMOptions());
            case 15:
                return ResizeBilinearOptions.pack(flatBufferBuilder, builtinOptionsUnion.asResizeBilinearOptions());
            case 16:
                return CallOptions.pack(flatBufferBuilder, builtinOptionsUnion.asCallOptions());
            case 17:
                return ReshapeOptions.pack(flatBufferBuilder, builtinOptionsUnion.asReshapeOptions());
            case 18:
                return SkipGramOptions.pack(flatBufferBuilder, builtinOptionsUnion.asSkipGramOptions());
            case 19:
                return SpaceToDepthOptions.pack(flatBufferBuilder, builtinOptionsUnion.asSpaceToDepthOptions());
            case 20:
                return EmbeddingLookupSparseOptions.pack(flatBufferBuilder, builtinOptionsUnion.asEmbeddingLookupSparseOptions());
            case 21:
                return MulOptions.pack(flatBufferBuilder, builtinOptionsUnion.asMulOptions());
            case 22:
                return PadOptions.pack(flatBufferBuilder, builtinOptionsUnion.asPadOptions());
            case 23:
                return GatherOptions.pack(flatBufferBuilder, builtinOptionsUnion.asGatherOptions());
            case 24:
                return BatchToSpaceNDOptions.pack(flatBufferBuilder, builtinOptionsUnion.asBatchToSpaceNDOptions());
            case 25:
                return SpaceToBatchNDOptions.pack(flatBufferBuilder, builtinOptionsUnion.asSpaceToBatchNDOptions());
            case 26:
                return TransposeOptions.pack(flatBufferBuilder, builtinOptionsUnion.asTransposeOptions());
            case 27:
                return ReducerOptions.pack(flatBufferBuilder, builtinOptionsUnion.asReducerOptions());
            case 28:
                return SubOptions.pack(flatBufferBuilder, builtinOptionsUnion.asSubOptions());
            case 29:
                return DivOptions.pack(flatBufferBuilder, builtinOptionsUnion.asDivOptions());
            case 30:
                return SqueezeOptions.pack(flatBufferBuilder, builtinOptionsUnion.asSqueezeOptions());
            case 31:
                return SequenceRNNOptions.pack(flatBufferBuilder, builtinOptionsUnion.asSequenceRNNOptions());
            case 32:
                return StridedSliceOptions.pack(flatBufferBuilder, builtinOptionsUnion.asStridedSliceOptions());
            case 33:
                return ExpOptions.pack(flatBufferBuilder, builtinOptionsUnion.asExpOptions());
            case 34:
                return TopKV2Options.pack(flatBufferBuilder, builtinOptionsUnion.asTopKV2Options());
            case 35:
                return SplitOptions.pack(flatBufferBuilder, builtinOptionsUnion.asSplitOptions());
            case 36:
                return LogSoftmaxOptions.pack(flatBufferBuilder, builtinOptionsUnion.asLogSoftmaxOptions());
            case 37:
                return CastOptions.pack(flatBufferBuilder, builtinOptionsUnion.asCastOptions());
            case 38:
                return DequantizeOptions.pack(flatBufferBuilder, builtinOptionsUnion.asDequantizeOptions());
            case 39:
                return MaximumMinimumOptions.pack(flatBufferBuilder, builtinOptionsUnion.asMaximumMinimumOptions());
            case 40:
                return ArgMaxOptions.pack(flatBufferBuilder, builtinOptionsUnion.asArgMaxOptions());
            case 41:
                return LessOptions.pack(flatBufferBuilder, builtinOptionsUnion.asLessOptions());
            case 42:
                return NegOptions.pack(flatBufferBuilder, builtinOptionsUnion.asNegOptions());
            case 43:
                return PadV2Options.pack(flatBufferBuilder, builtinOptionsUnion.asPadV2Options());
            case 44:
                return GreaterOptions.pack(flatBufferBuilder, builtinOptionsUnion.asGreaterOptions());
            case 45:
                return GreaterEqualOptions.pack(flatBufferBuilder, builtinOptionsUnion.asGreaterEqualOptions());
            case 46:
                return LessEqualOptions.pack(flatBufferBuilder, builtinOptionsUnion.asLessEqualOptions());
            case 47:
                return SelectOptions.pack(flatBufferBuilder, builtinOptionsUnion.asSelectOptions());
            case 48:
                return SliceOptions.pack(flatBufferBuilder, builtinOptionsUnion.asSliceOptions());
            case 49:
                return TransposeConvOptions.pack(flatBufferBuilder, builtinOptionsUnion.asTransposeConvOptions());
            case 50:
                return SparseToDenseOptions.pack(flatBufferBuilder, builtinOptionsUnion.asSparseToDenseOptions());
            case 51:
                return TileOptions.pack(flatBufferBuilder, builtinOptionsUnion.asTileOptions());
            case 52:
                return ExpandDimsOptions.pack(flatBufferBuilder, builtinOptionsUnion.asExpandDimsOptions());
            case 53:
                return EqualOptions.pack(flatBufferBuilder, builtinOptionsUnion.asEqualOptions());
            case 54:
                return NotEqualOptions.pack(flatBufferBuilder, builtinOptionsUnion.asNotEqualOptions());
            case 55:
                return ShapeOptions.pack(flatBufferBuilder, builtinOptionsUnion.asShapeOptions());
            case 56:
                return PowOptions.pack(flatBufferBuilder, builtinOptionsUnion.asPowOptions());
            case 57:
                return ArgMinOptions.pack(flatBufferBuilder, builtinOptionsUnion.asArgMinOptions());
            case 58:
                return FakeQuantOptions.pack(flatBufferBuilder, builtinOptionsUnion.asFakeQuantOptions());
            case 59:
                return PackOptions.pack(flatBufferBuilder, builtinOptionsUnion.asPackOptions());
            case 60:
                return LogicalOrOptions.pack(flatBufferBuilder, builtinOptionsUnion.asLogicalOrOptions());
            case 61:
                return OneHotOptions.pack(flatBufferBuilder, builtinOptionsUnion.asOneHotOptions());
            case 62:
                return LogicalAndOptions.pack(flatBufferBuilder, builtinOptionsUnion.asLogicalAndOptions());
            case 63:
                return LogicalNotOptions.pack(flatBufferBuilder, builtinOptionsUnion.asLogicalNotOptions());
            case 64:
                return UnpackOptions.pack(flatBufferBuilder, builtinOptionsUnion.asUnpackOptions());
            case 65:
                return FloorDivOptions.pack(flatBufferBuilder, builtinOptionsUnion.asFloorDivOptions());
            case 66:
                return SquareOptions.pack(flatBufferBuilder, builtinOptionsUnion.asSquareOptions());
            case 67:
                return ZerosLikeOptions.pack(flatBufferBuilder, builtinOptionsUnion.asZerosLikeOptions());
            case 68:
                return FillOptions.pack(flatBufferBuilder, builtinOptionsUnion.asFillOptions());
            case 69:
                return BidirectionalSequenceLSTMOptions.pack(flatBufferBuilder, builtinOptionsUnion.asBidirectionalSequenceLSTMOptions());
            case 70:
                return BidirectionalSequenceRNNOptions.pack(flatBufferBuilder, builtinOptionsUnion.asBidirectionalSequenceRNNOptions());
            case 71:
                return UnidirectionalSequenceLSTMOptions.pack(flatBufferBuilder, builtinOptionsUnion.asUnidirectionalSequenceLSTMOptions());
            case 72:
                return FloorModOptions.pack(flatBufferBuilder, builtinOptionsUnion.asFloorModOptions());
            case 73:
                return RangeOptions.pack(flatBufferBuilder, builtinOptionsUnion.asRangeOptions());
            case 74:
                return ResizeNearestNeighborOptions.pack(flatBufferBuilder, builtinOptionsUnion.asResizeNearestNeighborOptions());
            case 75:
                return LeakyReluOptions.pack(flatBufferBuilder, builtinOptionsUnion.asLeakyReluOptions());
            case 76:
                return SquaredDifferenceOptions.pack(flatBufferBuilder, builtinOptionsUnion.asSquaredDifferenceOptions());
            case 77:
                return MirrorPadOptions.pack(flatBufferBuilder, builtinOptionsUnion.asMirrorPadOptions());
            case 78:
                return AbsOptions.pack(flatBufferBuilder, builtinOptionsUnion.asAbsOptions());
            case 79:
                return SplitVOptions.pack(flatBufferBuilder, builtinOptionsUnion.asSplitVOptions());
            case 80:
                return UniqueOptions.pack(flatBufferBuilder, builtinOptionsUnion.asUniqueOptions());
            case 81:
                return ReverseV2Options.pack(flatBufferBuilder, builtinOptionsUnion.asReverseV2Options());
            case 82:
                return AddNOptions.pack(flatBufferBuilder, builtinOptionsUnion.asAddNOptions());
            case 83:
                return GatherNdOptions.pack(flatBufferBuilder, builtinOptionsUnion.asGatherNdOptions());
            case 84:
                return CosOptions.pack(flatBufferBuilder, builtinOptionsUnion.asCosOptions());
            case 85:
                return WhereOptions.pack(flatBufferBuilder, builtinOptionsUnion.asWhereOptions());
            case 86:
                return RankOptions.pack(flatBufferBuilder, builtinOptionsUnion.asRankOptions());
            case 87:
                return ReverseSequenceOptions.pack(flatBufferBuilder, builtinOptionsUnion.asReverseSequenceOptions());
            case 88:
                return MatrixDiagOptions.pack(flatBufferBuilder, builtinOptionsUnion.asMatrixDiagOptions());
            case 89:
                return QuantizeOptions.pack(flatBufferBuilder, builtinOptionsUnion.asQuantizeOptions());
            case 90:
                return MatrixSetDiagOptions.pack(flatBufferBuilder, builtinOptionsUnion.asMatrixSetDiagOptions());
            case 91:
                return HardSwishOptions.pack(flatBufferBuilder, builtinOptionsUnion.asHardSwishOptions());
            case 92:
                return IfOptions.pack(flatBufferBuilder, builtinOptionsUnion.asIfOptions());
            case 93:
                return WhileOptions.pack(flatBufferBuilder, builtinOptionsUnion.asWhileOptions());
            case 94:
                return DepthToSpaceOptions.pack(flatBufferBuilder, builtinOptionsUnion.asDepthToSpaceOptions());
            case 95:
                return NonMaxSuppressionV4Options.pack(flatBufferBuilder, builtinOptionsUnion.asNonMaxSuppressionV4Options());
            case 96:
                return NonMaxSuppressionV5Options.pack(flatBufferBuilder, builtinOptionsUnion.asNonMaxSuppressionV5Options());
            case 97:
                return ScatterNdOptions.pack(flatBufferBuilder, builtinOptionsUnion.asScatterNdOptions());
            case 98:
                return SelectV2Options.pack(flatBufferBuilder, builtinOptionsUnion.asSelectV2Options());
            case 99:
                return DensifyOptions.pack(flatBufferBuilder, builtinOptionsUnion.asDensifyOptions());
            case 100:
                return SegmentSumOptions.pack(flatBufferBuilder, builtinOptionsUnion.asSegmentSumOptions());
            case 101:
                return BatchMatMulOptions.pack(flatBufferBuilder, builtinOptionsUnion.asBatchMatMulOptions());
            case 102:
                return CumsumOptions.pack(flatBufferBuilder, builtinOptionsUnion.asCumsumOptions());
            case 103:
                return CallOnceOptions.pack(flatBufferBuilder, builtinOptionsUnion.asCallOnceOptions());
            case 104:
                return BroadcastToOptions.pack(flatBufferBuilder, builtinOptionsUnion.asBroadcastToOptions());
            case 105:
                return Rfft2dOptions.pack(flatBufferBuilder, builtinOptionsUnion.asRfft2dOptions());
            case 106:
                return Conv3DOptions.pack(flatBufferBuilder, builtinOptionsUnion.asConv3DOptions());
            case 107:
                return HashtableOptions.pack(flatBufferBuilder, builtinOptionsUnion.asHashtableOptions());
            case 108:
                return HashtableFindOptions.pack(flatBufferBuilder, builtinOptionsUnion.asHashtableFindOptions());
            case 109:
                return HashtableImportOptions.pack(flatBufferBuilder, builtinOptionsUnion.asHashtableImportOptions());
            case 110:
                return HashtableSizeOptions.pack(flatBufferBuilder, builtinOptionsUnion.asHashtableSizeOptions());
            case 111:
                return VarHandleOptions.pack(flatBufferBuilder, builtinOptionsUnion.asVarHandleOptions());
            case 112:
                return ReadVariableOptions.pack(flatBufferBuilder, builtinOptionsUnion.asReadVariableOptions());
            case 113:
                return AssignVariableOptions.pack(flatBufferBuilder, builtinOptionsUnion.asAssignVariableOptions());
            case 114:
                return RandomOptions.pack(flatBufferBuilder, builtinOptionsUnion.asRandomOptions());
            case 115:
                return BucketizeOptions.pack(flatBufferBuilder, builtinOptionsUnion.asBucketizeOptions());
            case 116:
                return GeluOptions.pack(flatBufferBuilder, builtinOptionsUnion.asGeluOptions());
            case 117:
                return DynamicUpdateSliceOptions.pack(flatBufferBuilder, builtinOptionsUnion.asDynamicUpdateSliceOptions());
            case 118:
                return UnsortedSegmentProdOptions.pack(flatBufferBuilder, builtinOptionsUnion.asUnsortedSegmentProdOptions());
            case 119:
                return UnsortedSegmentMaxOptions.pack(flatBufferBuilder, builtinOptionsUnion.asUnsortedSegmentMaxOptions());
            case 120:
                return UnsortedSegmentMinOptions.pack(flatBufferBuilder, builtinOptionsUnion.asUnsortedSegmentMinOptions());
            case 121:
                return UnsortedSegmentSumOptions.pack(flatBufferBuilder, builtinOptionsUnion.asUnsortedSegmentSumOptions());
            case 122:
                return ATan2Options.pack(flatBufferBuilder, builtinOptionsUnion.asATan2Options());
            case 123:
                return SignOptions.pack(flatBufferBuilder, builtinOptionsUnion.asSignOptions());
            default:
                return 0;
        }
    }
}
