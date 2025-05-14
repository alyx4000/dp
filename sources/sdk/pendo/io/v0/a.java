package sdk.pendo.io.v0;

import org.tensorflow.lite.schema.BuiltinOptions;
import sdk.pendo.io.v0.b;

/* loaded from: classes4.dex */
public class a extends b {
    static final byte[] k = {13, 10};
    private static final byte[] l = {BuiltinOptions.FloorDivOptions, BuiltinOptions.SquareOptions, BuiltinOptions.ZerosLikeOptions, BuiltinOptions.FillOptions, BuiltinOptions.BidirectionalSequenceLSTMOptions, BuiltinOptions.BidirectionalSequenceRNNOptions, BuiltinOptions.UnidirectionalSequenceLSTMOptions, BuiltinOptions.FloorModOptions, BuiltinOptions.RangeOptions, BuiltinOptions.ResizeNearestNeighborOptions, BuiltinOptions.LeakyReluOptions, BuiltinOptions.SquaredDifferenceOptions, BuiltinOptions.MirrorPadOptions, BuiltinOptions.AbsOptions, BuiltinOptions.SplitVOptions, BuiltinOptions.UniqueOptions, BuiltinOptions.ReverseV2Options, BuiltinOptions.AddNOptions, BuiltinOptions.GatherNdOptions, BuiltinOptions.CosOptions, BuiltinOptions.WhereOptions, BuiltinOptions.RankOptions, BuiltinOptions.ReverseSequenceOptions, BuiltinOptions.MatrixDiagOptions, BuiltinOptions.QuantizeOptions, BuiltinOptions.MatrixSetDiagOptions, BuiltinOptions.ScatterNdOptions, BuiltinOptions.SelectV2Options, BuiltinOptions.DensifyOptions, BuiltinOptions.SegmentSumOptions, BuiltinOptions.BatchMatMulOptions, BuiltinOptions.CumsumOptions, BuiltinOptions.CallOnceOptions, BuiltinOptions.BroadcastToOptions, BuiltinOptions.Rfft2dOptions, BuiltinOptions.Conv3DOptions, BuiltinOptions.HashtableOptions, BuiltinOptions.HashtableFindOptions, BuiltinOptions.HashtableImportOptions, BuiltinOptions.HashtableSizeOptions, BuiltinOptions.VarHandleOptions, BuiltinOptions.ReadVariableOptions, BuiltinOptions.AssignVariableOptions, BuiltinOptions.RandomOptions, BuiltinOptions.BucketizeOptions, BuiltinOptions.GeluOptions, BuiltinOptions.DynamicUpdateSliceOptions, BuiltinOptions.UnsortedSegmentProdOptions, BuiltinOptions.UnsortedSegmentMaxOptions, BuiltinOptions.UnsortedSegmentMinOptions, BuiltinOptions.UnsortedSegmentSumOptions, BuiltinOptions.ATan2Options, BuiltinOptions.SliceOptions, BuiltinOptions.TransposeConvOptions, BuiltinOptions.SparseToDenseOptions, BuiltinOptions.TileOptions, BuiltinOptions.ExpandDimsOptions, BuiltinOptions.EqualOptions, BuiltinOptions.NotEqualOptions, BuiltinOptions.ShapeOptions, BuiltinOptions.PowOptions, BuiltinOptions.ArgMinOptions, BuiltinOptions.PadV2Options, BuiltinOptions.SelectOptions};
    private static final byte[] m = {BuiltinOptions.FloorDivOptions, BuiltinOptions.SquareOptions, BuiltinOptions.ZerosLikeOptions, BuiltinOptions.FillOptions, BuiltinOptions.BidirectionalSequenceLSTMOptions, BuiltinOptions.BidirectionalSequenceRNNOptions, BuiltinOptions.UnidirectionalSequenceLSTMOptions, BuiltinOptions.FloorModOptions, BuiltinOptions.RangeOptions, BuiltinOptions.ResizeNearestNeighborOptions, BuiltinOptions.LeakyReluOptions, BuiltinOptions.SquaredDifferenceOptions, BuiltinOptions.MirrorPadOptions, BuiltinOptions.AbsOptions, BuiltinOptions.SplitVOptions, BuiltinOptions.UniqueOptions, BuiltinOptions.ReverseV2Options, BuiltinOptions.AddNOptions, BuiltinOptions.GatherNdOptions, BuiltinOptions.CosOptions, BuiltinOptions.WhereOptions, BuiltinOptions.RankOptions, BuiltinOptions.ReverseSequenceOptions, BuiltinOptions.MatrixDiagOptions, BuiltinOptions.QuantizeOptions, BuiltinOptions.MatrixSetDiagOptions, BuiltinOptions.ScatterNdOptions, BuiltinOptions.SelectV2Options, BuiltinOptions.DensifyOptions, BuiltinOptions.SegmentSumOptions, BuiltinOptions.BatchMatMulOptions, BuiltinOptions.CumsumOptions, BuiltinOptions.CallOnceOptions, BuiltinOptions.BroadcastToOptions, BuiltinOptions.Rfft2dOptions, BuiltinOptions.Conv3DOptions, BuiltinOptions.HashtableOptions, BuiltinOptions.HashtableFindOptions, BuiltinOptions.HashtableImportOptions, BuiltinOptions.HashtableSizeOptions, BuiltinOptions.VarHandleOptions, BuiltinOptions.ReadVariableOptions, BuiltinOptions.AssignVariableOptions, BuiltinOptions.RandomOptions, BuiltinOptions.BucketizeOptions, BuiltinOptions.GeluOptions, BuiltinOptions.DynamicUpdateSliceOptions, BuiltinOptions.UnsortedSegmentProdOptions, BuiltinOptions.UnsortedSegmentMaxOptions, BuiltinOptions.UnsortedSegmentMinOptions, BuiltinOptions.UnsortedSegmentSumOptions, BuiltinOptions.ATan2Options, BuiltinOptions.SliceOptions, BuiltinOptions.TransposeConvOptions, BuiltinOptions.SparseToDenseOptions, BuiltinOptions.TileOptions, BuiltinOptions.ExpandDimsOptions, BuiltinOptions.EqualOptions, BuiltinOptions.NotEqualOptions, BuiltinOptions.ShapeOptions, BuiltinOptions.PowOptions, BuiltinOptions.ArgMinOptions, 45, BuiltinOptions.NonMaxSuppressionV4Options};
    private static final byte[] n = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, BuiltinOptions.LogicalAndOptions, -1, BuiltinOptions.LogicalAndOptions, -1, 63, BuiltinOptions.ExpandDimsOptions, BuiltinOptions.EqualOptions, BuiltinOptions.NotEqualOptions, BuiltinOptions.ShapeOptions, BuiltinOptions.PowOptions, BuiltinOptions.ArgMinOptions, BuiltinOptions.FakeQuantOptions, BuiltinOptions.PackOptions, BuiltinOptions.LogicalOrOptions, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, BuiltinOptions.SkipGramOptions, BuiltinOptions.SpaceToDepthOptions, BuiltinOptions.EmbeddingLookupSparseOptions, BuiltinOptions.MulOptions, BuiltinOptions.PadOptions, BuiltinOptions.GatherOptions, BuiltinOptions.BatchToSpaceNDOptions, BuiltinOptions.SpaceToBatchNDOptions, -1, -1, -1, -1, 63, -1, BuiltinOptions.TransposeOptions, BuiltinOptions.ReducerOptions, BuiltinOptions.SubOptions, BuiltinOptions.DivOptions, BuiltinOptions.SqueezeOptions, BuiltinOptions.SequenceRNNOptions, BuiltinOptions.StridedSliceOptions, BuiltinOptions.ExpOptions, BuiltinOptions.TopKV2Options, BuiltinOptions.SplitOptions, BuiltinOptions.LogSoftmaxOptions, BuiltinOptions.CastOptions, BuiltinOptions.DequantizeOptions, BuiltinOptions.MaximumMinimumOptions, BuiltinOptions.ArgMaxOptions, BuiltinOptions.LessOptions, BuiltinOptions.NegOptions, BuiltinOptions.PadV2Options, BuiltinOptions.GreaterOptions, 45, BuiltinOptions.LessEqualOptions, BuiltinOptions.SelectOptions, BuiltinOptions.SliceOptions, BuiltinOptions.TransposeConvOptions, BuiltinOptions.SparseToDenseOptions, BuiltinOptions.TileOptions};
    private final byte[] f;
    private final byte[] g;
    private final byte[] h;
    private final int i;
    private final int j;

    public a() {
        this(0);
    }

    @Override // sdk.pendo.io.v0.b
    void a(byte[] bArr, int i, int i2, b.a aVar) {
        byte b;
        if (aVar.f) {
            return;
        }
        if (i2 < 0) {
            aVar.f = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            byte[] a2 = a(this.i, aVar);
            int i4 = i + 1;
            byte b2 = bArr[i];
            if (b2 == 61) {
                aVar.f = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = n;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    int i5 = (aVar.h + 1) % 4;
                    aVar.h = i5;
                    int i6 = (aVar.f1651a << 6) + b;
                    aVar.f1651a = i6;
                    if (i5 == 0) {
                        int i7 = aVar.d;
                        int i8 = i7 + 1;
                        a2[i7] = (byte) ((i6 >> 16) & 255);
                        int i9 = i8 + 1;
                        a2[i8] = (byte) ((i6 >> 8) & 255);
                        aVar.d = i9 + 1;
                        a2[i9] = (byte) (i6 & 255);
                    }
                }
            }
            i3++;
            i = i4;
        }
        if (!aVar.f || aVar.h == 0) {
            return;
        }
        byte[] a3 = a(this.i, aVar);
        int i10 = aVar.h;
        if (i10 != 1) {
            if (i10 == 2) {
                int i11 = aVar.f1651a >> 4;
                aVar.f1651a = i11;
                int i12 = aVar.d;
                aVar.d = i12 + 1;
                a3[i12] = (byte) (i11 & 255);
                return;
            }
            if (i10 != 3) {
                throw new IllegalStateException("Impossible modulus " + aVar.h);
            }
            int i13 = aVar.f1651a >> 2;
            aVar.f1651a = i13;
            int i14 = aVar.d;
            int i15 = i14 + 1;
            a3[i14] = (byte) ((i13 >> 8) & 255);
            aVar.d = i15 + 1;
            a3[i15] = (byte) (i13 & 255);
        }
    }

    @Override // sdk.pendo.io.v0.b
    void b(byte[] bArr, int i, int i2, b.a aVar) {
        if (aVar.f) {
            return;
        }
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                byte[] a2 = a(this.j, aVar);
                int i4 = (aVar.h + 1) % 3;
                aVar.h = i4;
                int i5 = i + 1;
                int i6 = bArr[i];
                if (i6 < 0) {
                    i6 += 256;
                }
                int i7 = (aVar.f1651a << 8) + i6;
                aVar.f1651a = i7;
                if (i4 == 0) {
                    int i8 = aVar.d;
                    int i9 = i8 + 1;
                    byte[] bArr2 = this.f;
                    a2[i8] = bArr2[(i7 >> 18) & 63];
                    int i10 = i9 + 1;
                    a2[i9] = bArr2[(i7 >> 12) & 63];
                    int i11 = i10 + 1;
                    a2[i10] = bArr2[(i7 >> 6) & 63];
                    int i12 = i11 + 1;
                    aVar.d = i12;
                    a2[i11] = bArr2[i7 & 63];
                    int i13 = aVar.g + 4;
                    aVar.g = i13;
                    int i14 = this.d;
                    if (i14 > 0 && i14 <= i13) {
                        byte[] bArr3 = this.h;
                        System.arraycopy(bArr3, 0, a2, i12, bArr3.length);
                        aVar.d += this.h.length;
                        aVar.g = 0;
                    }
                }
                i3++;
                i = i5;
            }
            return;
        }
        aVar.f = true;
        if (aVar.h == 0 && this.d == 0) {
            return;
        }
        byte[] a3 = a(this.j, aVar);
        int i15 = aVar.d;
        int i16 = aVar.h;
        if (i16 != 0) {
            if (i16 == 1) {
                int i17 = i15 + 1;
                byte[] bArr4 = this.f;
                int i18 = aVar.f1651a;
                a3[i15] = bArr4[(i18 >> 2) & 63];
                int i19 = i17 + 1;
                aVar.d = i19;
                a3[i17] = bArr4[(i18 << 4) & 63];
                if (bArr4 == l) {
                    int i20 = i19 + 1;
                    a3[i19] = 61;
                    aVar.d = i20 + 1;
                    a3[i20] = 61;
                }
            } else {
                if (i16 != 2) {
                    throw new IllegalStateException("Impossible modulus " + aVar.h);
                }
                int i21 = i15 + 1;
                byte[] bArr5 = this.f;
                int i22 = aVar.f1651a;
                a3[i15] = bArr5[(i22 >> 10) & 63];
                int i23 = i21 + 1;
                a3[i21] = bArr5[(i22 >> 4) & 63];
                int i24 = i23 + 1;
                aVar.d = i24;
                a3[i23] = bArr5[(i22 << 2) & 63];
                if (bArr5 == l) {
                    aVar.d = i24 + 1;
                    a3[i24] = 61;
                }
            }
        }
        int i25 = aVar.g;
        int i26 = aVar.d;
        int i27 = i25 + (i26 - i15);
        aVar.g = i27;
        if (this.d <= 0 || i27 <= 0) {
            return;
        }
        byte[] bArr6 = this.h;
        System.arraycopy(bArr6, 0, a3, i26, bArr6.length);
        aVar.d += this.h.length;
    }

    public a(int i) {
        this(i, k);
    }

    @Override // sdk.pendo.io.v0.b
    protected boolean a(byte b) {
        if (b >= 0) {
            byte[] bArr = this.g;
            if (b < bArr.length && bArr[b] != -1) {
                return true;
            }
        }
        return false;
    }

    public a(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(int r5, byte[] r6, boolean r7) {
        /*
            r4 = this;
            r0 = 0
            if (r6 != 0) goto L5
            r1 = r0
            goto L6
        L5:
            int r1 = r6.length
        L6:
            r2 = 3
            r3 = 4
            r4.<init>(r2, r3, r5, r1)
            byte[] r1 = sdk.pendo.io.v0.a.n
            r4.g = r1
            if (r6 == 0) goto L46
            boolean r1 = r4.a(r6)
            if (r1 != 0) goto L27
            if (r5 <= 0) goto L46
            int r5 = r6.length
            int r5 = r5 + r3
            r4.j = r5
            int r5 = r6.length
            byte[] r5 = new byte[r5]
            r4.h = r5
            int r1 = r6.length
            java.lang.System.arraycopy(r6, r0, r5, r0, r1)
            goto L4b
        L27:
            java.lang.String r5 = sdk.pendo.io.k1.j.a(r6)
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "lineSeparator must not contain base64 characters: ["
            r7.<init>(r0)
            java.lang.StringBuilder r5 = r7.append(r5)
            java.lang.String r7 = "]"
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        L46:
            r4.j = r3
            r5 = 0
            r4.h = r5
        L4b:
            int r5 = r4.j
            int r5 = r5 + (-1)
            r4.i = r5
            if (r7 == 0) goto L56
            byte[] r5 = sdk.pendo.io.v0.a.m
            goto L58
        L56:
            byte[] r5 = sdk.pendo.io.v0.a.l
        L58:
            r4.f = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.v0.a.<init>(int, byte[], boolean):void");
    }
}
