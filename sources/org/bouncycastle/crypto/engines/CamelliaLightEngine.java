package org.bouncycastle.crypto.engines;

import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes6.dex */
public class CamelliaLightEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final int MASK8 = 255;
    private boolean _keyis128;
    private boolean initialized;
    private static final int[] SIGMA = {-1600231809, 1003262091, -1233459112, 1286239154, -957401297, -380665154, 1426019237, -237801700, 283453434, -563598051, -1336506174, -1276722691};
    private static final byte[] SBOX1 = {BuiltinOptions.ReadVariableOptions, -126, BuiltinOptions.GreaterOptions, -20, -77, BuiltinOptions.MaximumMinimumOptions, -64, -27, -28, -123, BuiltinOptions.ReverseSequenceOptions, BuiltinOptions.EqualOptions, -22, 12, -82, BuiltinOptions.FloorDivOptions, BuiltinOptions.SplitOptions, -17, BuiltinOptions.HashtableOptions, -109, BuiltinOptions.BidirectionalSequenceLSTMOptions, BuiltinOptions.SpaceToBatchNDOptions, -91, BuiltinOptions.ExpOptions, -19, 14, BuiltinOptions.SplitVOptions, BuiltinOptions.AbsOptions, BuiltinOptions.DivOptions, BuiltinOptions.BatchMatMulOptions, -110, -67, -122, -72, -81, -113, 124, -21, BuiltinOptions.SequenceRNNOptions, -50, BuiltinOptions.LogicalAndOptions, BuiltinOptions.SliceOptions, -36, BuiltinOptions.NonMaxSuppressionV4Options, BuiltinOptions.DepthToSpaceOptions, -59, 11, BuiltinOptions.TransposeOptions, -90, -31, BuiltinOptions.ArgMinOptions, -54, -43, BuiltinOptions.UnidirectionalSequenceLSTMOptions, BuiltinOptions.WhileOptions, 61, -39, 1, BuiltinOptions.MatrixSetDiagOptions, -42, BuiltinOptions.ReverseV2Options, BuiltinOptions.RankOptions, BuiltinOptions.HashtableFindOptions, BuiltinOptions.MirrorPadOptions, -117, 13, -102, BuiltinOptions.CumsumOptions, -5, -52, -80, 45, BuiltinOptions.GeluOptions, BuiltinOptions.SkipGramOptions, BuiltinOptions.PadV2Options, BuiltinOptions.StridedSliceOptions, -16, -79, -124, -103, -33, BuiltinOptions.SquaredDifferenceOptions, -53, -62, BuiltinOptions.ExpandDimsOptions, 126, BuiltinOptions.UnsortedSegmentProdOptions, 5, BuiltinOptions.HashtableImportOptions, -73, -87, BuiltinOptions.TransposeConvOptions, -47, BuiltinOptions.GatherOptions, 4, -41, BuiltinOptions.EmbeddingLookupSparseOptions, BuiltinOptions.MatrixDiagOptions, BuiltinOptions.FakeQuantOptions, BuiltinOptions.ScatterNdOptions, -34, BuiltinOptions.ReducerOptions, 17, BuiltinOptions.SubOptions, BuiltinOptions.SparseToDenseOptions, 15, -100, BuiltinOptions.PadOptions, BuiltinOptions.GatherNdOptions, BuiltinOptions.BatchToSpaceNDOptions, -14, BuiltinOptions.TopKV2Options, -2, BuiltinOptions.FillOptions, -49, -78, -61, -75, BuiltinOptions.ATan2Options, -111, BuiltinOptions.LogSoftmaxOptions, 8, -24, -88, BuiltinOptions.NonMaxSuppressionV5Options, -4, BuiltinOptions.Rfft2dOptions, BuiltinOptions.UniqueOptions, -86, -48, -96, 125, -95, -119, BuiltinOptions.SelectV2Options, -105, BuiltinOptions.CosOptions, BuiltinOptions.HardSwishOptions, BuiltinOptions.SqueezeOptions, -107, -32, -1, BuiltinOptions.SegmentSumOptions, -46, 16, -60, 0, BuiltinOptions.FloorModOptions, -93, -9, BuiltinOptions.DynamicUpdateSliceOptions, -37, -118, 3, -26, -38, 9, 63, -35, -108, -121, BuiltinOptions.IfOptions, -125, 2, -51, BuiltinOptions.ResizeNearestNeighborOptions, -112, BuiltinOptions.TileOptions, BuiltinOptions.BucketizeOptions, BuiltinOptions.CallOnceOptions, -10, -13, -99, ByteCompanionObject.MAX_VALUE, -65, -30, BuiltinOptions.AddNOptions, -101, -40, BuiltinOptions.DequantizeOptions, -56, BuiltinOptions.ShapeOptions, -58, BuiltinOptions.PackOptions, -127, -106, BuiltinOptions.VarHandleOptions, BuiltinOptions.LeakyReluOptions, BuiltinOptions.SpaceToDepthOptions, -66, BuiltinOptions.DensifyOptions, BuiltinOptions.LessEqualOptions, -23, BuiltinOptions.UnsortedSegmentSumOptions, -89, -116, -97, BuiltinOptions.HashtableSizeOptions, PSSSigner.TRAILER_IMPLICIT, -114, BuiltinOptions.LessOptions, -11, -7, -74, BuiltinOptions.SelectOptions, -3, -76, BuiltinOptions.QuantizeOptions, BuiltinOptions.UnsortedSegmentMinOptions, -104, 6, BuiltinOptions.Conv3DOptions, -25, BuiltinOptions.BidirectionalSequenceRNNOptions, BuiltinOptions.AssignVariableOptions, -70, -44, BuiltinOptions.CastOptions, -85, BuiltinOptions.SquareOptions, -120, -94, -115, -6, BuiltinOptions.RandomOptions, 7, -71, BuiltinOptions.WhereOptions, -8, -18, -84, 10, BuiltinOptions.NotEqualOptions, BuiltinOptions.RangeOptions, BuiltinOptions.NegOptions, BuiltinOptions.BroadcastToOptions, BuiltinOptions.LogicalOrOptions, BuiltinOptions.PowOptions, -15, -92, BuiltinOptions.UnpackOptions, BuiltinOptions.ArgMaxOptions, -45, BuiltinOptions.SignOptions, -69, -55, BuiltinOptions.ZerosLikeOptions, -63, BuiltinOptions.MulOptions, -29, -83, -12, BuiltinOptions.UnsortedSegmentMaxOptions, -57, ByteCompanionObject.MIN_VALUE, -98};
    private int[] subkey = new int[96];
    private int[] kw = new int[8];
    private int[] ke = new int[12];
    private int[] state = new int[4];

    private int bytes2int(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            i2 = (i2 << 8) + (bArr[i3 + i] & UByte.MAX_VALUE);
        }
        return i2;
    }

    private void camelliaF2(int[] iArr, int[] iArr2, int i) {
        int i2 = iArr[0] ^ iArr2[i + 0];
        int sbox4 = sbox4(i2 & 255) | (sbox3((i2 >>> 8) & 255) << 8) | (sbox2((i2 >>> 16) & 255) << 16);
        byte[] bArr = SBOX1;
        int i3 = ((bArr[(i2 >>> 24) & 255] & UByte.MAX_VALUE) << 24) | sbox4;
        int i4 = iArr[1] ^ iArr2[i + 1];
        int leftRotate = leftRotate((sbox2((i4 >>> 24) & 255) << 24) | (bArr[i4 & 255] & UByte.MAX_VALUE) | (sbox4((i4 >>> 8) & 255) << 8) | (sbox3((i4 >>> 16) & 255) << 16), 8);
        int i5 = i3 ^ leftRotate;
        int leftRotate2 = leftRotate(leftRotate, 8) ^ i5;
        int rightRotate = rightRotate(i5, 8) ^ leftRotate2;
        iArr[2] = (leftRotate(leftRotate2, 16) ^ rightRotate) ^ iArr[2];
        iArr[3] = leftRotate(rightRotate, 8) ^ iArr[3];
        int i6 = iArr[2] ^ iArr2[i + 2];
        int sbox42 = ((bArr[(i6 >>> 24) & 255] & UByte.MAX_VALUE) << 24) | sbox4(i6 & 255) | (sbox3((i6 >>> 8) & 255) << 8) | (sbox2((i6 >>> 16) & 255) << 16);
        int i7 = iArr2[i + 3] ^ iArr[3];
        int leftRotate3 = leftRotate((sbox2((i7 >>> 24) & 255) << 24) | (bArr[i7 & 255] & UByte.MAX_VALUE) | (sbox4((i7 >>> 8) & 255) << 8) | (sbox3((i7 >>> 16) & 255) << 16), 8);
        int i8 = sbox42 ^ leftRotate3;
        int leftRotate4 = leftRotate(leftRotate3, 8) ^ i8;
        int rightRotate2 = rightRotate(i8, 8) ^ leftRotate4;
        iArr[0] = (leftRotate(leftRotate4, 16) ^ rightRotate2) ^ iArr[0];
        iArr[1] = iArr[1] ^ leftRotate(rightRotate2, 8);
    }

    private void camelliaFLs(int[] iArr, int[] iArr2, int i) {
        int leftRotate = iArr[1] ^ leftRotate(iArr[0] & iArr2[i + 0], 1);
        iArr[1] = leftRotate;
        iArr[0] = (leftRotate | iArr2[i + 1]) ^ iArr[0];
        int i2 = iArr[2];
        int i3 = iArr2[i + 3];
        int i4 = iArr[3];
        int i5 = i2 ^ (i3 | i4);
        iArr[2] = i5;
        iArr[3] = leftRotate(iArr2[i + 2] & i5, 1) ^ i4;
    }

    private static void decroldq(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 2;
        int i5 = i2 + 0;
        int i6 = i2 + 1;
        int i7 = 32 - i;
        iArr2[i4] = (iArr[i5] << i) | (iArr[i6] >>> i7);
        int i8 = i3 + 3;
        int i9 = i2 + 2;
        iArr2[i8] = (iArr[i6] << i) | (iArr[i9] >>> i7);
        int i10 = i3 + 0;
        int i11 = i2 + 3;
        iArr2[i10] = (iArr[i9] << i) | (iArr[i11] >>> i7);
        int i12 = i3 + 1;
        iArr2[i12] = (iArr[i11] << i) | (iArr[i5] >>> i7);
        iArr[i5] = iArr2[i4];
        iArr[i6] = iArr2[i8];
        iArr[i9] = iArr2[i10];
        iArr[i11] = iArr2[i12];
    }

    private static void decroldqo32(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 2;
        int i5 = i2 + 1;
        int i6 = i - 32;
        int i7 = i2 + 2;
        int i8 = 64 - i;
        iArr2[i4] = (iArr[i5] << i6) | (iArr[i7] >>> i8);
        int i9 = i3 + 3;
        int i10 = i2 + 3;
        iArr2[i9] = (iArr[i7] << i6) | (iArr[i10] >>> i8);
        int i11 = i3 + 0;
        int i12 = i2 + 0;
        iArr2[i11] = (iArr[i10] << i6) | (iArr[i12] >>> i8);
        int i13 = i3 + 1;
        iArr2[i13] = (iArr[i5] >>> i8) | (iArr[i12] << i6);
        iArr[i12] = iArr2[i4];
        iArr[i5] = iArr2[i9];
        iArr[i7] = iArr2[i11];
        iArr[i10] = iArr2[i13];
    }

    private void int2bytes(int i, byte[] bArr, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[(3 - i3) + i2] = (byte) i;
            i >>>= 8;
        }
    }

    private byte lRot8(byte b, int i) {
        return (byte) (((b & 255) >>> (8 - i)) | (b << i));
    }

    private static int leftRotate(int i, int i2) {
        return (i << i2) + (i >>> (32 - i2));
    }

    private int processBlock128(byte[] bArr, int i, byte[] bArr2, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            this.state[i3] = bytes2int(bArr, (i3 * 4) + i);
            int[] iArr = this.state;
            iArr[i3] = iArr[i3] ^ this.kw[i3];
        }
        camelliaF2(this.state, this.subkey, 0);
        camelliaF2(this.state, this.subkey, 4);
        camelliaF2(this.state, this.subkey, 8);
        camelliaFLs(this.state, this.ke, 0);
        camelliaF2(this.state, this.subkey, 12);
        camelliaF2(this.state, this.subkey, 16);
        camelliaF2(this.state, this.subkey, 20);
        camelliaFLs(this.state, this.ke, 4);
        camelliaF2(this.state, this.subkey, 24);
        camelliaF2(this.state, this.subkey, 28);
        camelliaF2(this.state, this.subkey, 32);
        int[] iArr2 = this.state;
        int i4 = iArr2[2];
        int[] iArr3 = this.kw;
        int i5 = iArr3[4] ^ i4;
        iArr2[2] = i5;
        iArr2[3] = iArr2[3] ^ iArr3[5];
        iArr2[0] = iArr2[0] ^ iArr3[6];
        iArr2[1] = iArr3[7] ^ iArr2[1];
        int2bytes(i5, bArr2, i2);
        int2bytes(this.state[3], bArr2, i2 + 4);
        int2bytes(this.state[0], bArr2, i2 + 8);
        int2bytes(this.state[1], bArr2, i2 + 12);
        return 16;
    }

    private int processBlock192or256(byte[] bArr, int i, byte[] bArr2, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            this.state[i3] = bytes2int(bArr, (i3 * 4) + i);
            int[] iArr = this.state;
            iArr[i3] = iArr[i3] ^ this.kw[i3];
        }
        camelliaF2(this.state, this.subkey, 0);
        camelliaF2(this.state, this.subkey, 4);
        camelliaF2(this.state, this.subkey, 8);
        camelliaFLs(this.state, this.ke, 0);
        camelliaF2(this.state, this.subkey, 12);
        camelliaF2(this.state, this.subkey, 16);
        camelliaF2(this.state, this.subkey, 20);
        camelliaFLs(this.state, this.ke, 4);
        camelliaF2(this.state, this.subkey, 24);
        camelliaF2(this.state, this.subkey, 28);
        camelliaF2(this.state, this.subkey, 32);
        camelliaFLs(this.state, this.ke, 8);
        camelliaF2(this.state, this.subkey, 36);
        camelliaF2(this.state, this.subkey, 40);
        camelliaF2(this.state, this.subkey, 44);
        int[] iArr2 = this.state;
        int i4 = iArr2[2];
        int[] iArr3 = this.kw;
        int i5 = i4 ^ iArr3[4];
        iArr2[2] = i5;
        iArr2[3] = iArr2[3] ^ iArr3[5];
        iArr2[0] = iArr2[0] ^ iArr3[6];
        iArr2[1] = iArr3[7] ^ iArr2[1];
        int2bytes(i5, bArr2, i2);
        int2bytes(this.state[3], bArr2, i2 + 4);
        int2bytes(this.state[0], bArr2, i2 + 8);
        int2bytes(this.state[1], bArr2, i2 + 12);
        return 16;
    }

    private static int rightRotate(int i, int i2) {
        return (i >>> i2) + (i << (32 - i2));
    }

    private static void roldq(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 0;
        int i5 = i2 + 0;
        int i6 = i2 + 1;
        int i7 = 32 - i;
        iArr2[i4] = (iArr[i5] << i) | (iArr[i6] >>> i7);
        int i8 = i3 + 1;
        int i9 = i2 + 2;
        iArr2[i8] = (iArr[i6] << i) | (iArr[i9] >>> i7);
        int i10 = i3 + 2;
        int i11 = i2 + 3;
        iArr2[i10] = (iArr[i9] << i) | (iArr[i11] >>> i7);
        int i12 = i3 + 3;
        iArr2[i12] = (iArr[i11] << i) | (iArr[i5] >>> i7);
        iArr[i5] = iArr2[i4];
        iArr[i6] = iArr2[i8];
        iArr[i9] = iArr2[i10];
        iArr[i11] = iArr2[i12];
    }

    private static void roldqo32(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 0;
        int i5 = i2 + 1;
        int i6 = i - 32;
        int i7 = i2 + 2;
        int i8 = 64 - i;
        iArr2[i4] = (iArr[i5] << i6) | (iArr[i7] >>> i8);
        int i9 = i3 + 1;
        int i10 = i2 + 3;
        iArr2[i9] = (iArr[i7] << i6) | (iArr[i10] >>> i8);
        int i11 = i3 + 2;
        int i12 = i2 + 0;
        iArr2[i11] = (iArr[i10] << i6) | (iArr[i12] >>> i8);
        int i13 = i3 + 3;
        iArr2[i13] = (iArr[i5] >>> i8) | (iArr[i12] << i6);
        iArr[i12] = iArr2[i4];
        iArr[i5] = iArr2[i9];
        iArr[i7] = iArr2[i11];
        iArr[i10] = iArr2[i13];
    }

    private int sbox2(int i) {
        return lRot8(SBOX1[i], 1) & UByte.MAX_VALUE;
    }

    private int sbox3(int i) {
        return lRot8(SBOX1[i], 7) & UByte.MAX_VALUE;
    }

    private int sbox4(int i) {
        return SBOX1[lRot8((byte) i, 1) & UByte.MAX_VALUE] & UByte.MAX_VALUE;
    }

    private void setKey(boolean z, byte[] bArr) {
        int[] iArr = new int[8];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        int[] iArr4 = new int[4];
        int length = bArr.length;
        if (length != 16) {
            if (length == 24) {
                iArr[0] = bytes2int(bArr, 0);
                iArr[1] = bytes2int(bArr, 4);
                iArr[2] = bytes2int(bArr, 8);
                iArr[3] = bytes2int(bArr, 12);
                iArr[4] = bytes2int(bArr, 16);
                int bytes2int = bytes2int(bArr, 20);
                iArr[5] = bytes2int;
                iArr[6] = ~iArr[4];
                iArr[7] = ~bytes2int;
            } else {
                if (length != 32) {
                    throw new IllegalArgumentException("key sizes are only 16/24/32 bytes.");
                }
                iArr[0] = bytes2int(bArr, 0);
                iArr[1] = bytes2int(bArr, 4);
                iArr[2] = bytes2int(bArr, 8);
                iArr[3] = bytes2int(bArr, 12);
                iArr[4] = bytes2int(bArr, 16);
                iArr[5] = bytes2int(bArr, 20);
                iArr[6] = bytes2int(bArr, 24);
                iArr[7] = bytes2int(bArr, 28);
            }
            this._keyis128 = false;
        } else {
            this._keyis128 = true;
            iArr[0] = bytes2int(bArr, 0);
            iArr[1] = bytes2int(bArr, 4);
            iArr[2] = bytes2int(bArr, 8);
            iArr[3] = bytes2int(bArr, 12);
            iArr[7] = 0;
            iArr[6] = 0;
            iArr[5] = 0;
            iArr[4] = 0;
        }
        for (int i = 0; i < 4; i++) {
            iArr2[i] = iArr[i] ^ iArr[i + 4];
        }
        camelliaF2(iArr2, SIGMA, 0);
        for (int i2 = 0; i2 < 4; i2++) {
            iArr2[i2] = iArr2[i2] ^ iArr[i2];
        }
        camelliaF2(iArr2, SIGMA, 4);
        if (this._keyis128) {
            int[] iArr5 = this.kw;
            if (z) {
                iArr5[0] = iArr[0];
                iArr5[1] = iArr[1];
                iArr5[2] = iArr[2];
                iArr5[3] = iArr[3];
                roldq(15, iArr, 0, this.subkey, 4);
                roldq(30, iArr, 0, this.subkey, 12);
                roldq(15, iArr, 0, iArr4, 0);
                int[] iArr6 = this.subkey;
                iArr6[18] = iArr4[2];
                iArr6[19] = iArr4[3];
                roldq(17, iArr, 0, this.ke, 4);
                roldq(17, iArr, 0, this.subkey, 24);
                roldq(17, iArr, 0, this.subkey, 32);
                int[] iArr7 = this.subkey;
                iArr7[0] = iArr2[0];
                iArr7[1] = iArr2[1];
                iArr7[2] = iArr2[2];
                iArr7[3] = iArr2[3];
                roldq(15, iArr2, 0, iArr7, 8);
                roldq(15, iArr2, 0, this.ke, 0);
                roldq(15, iArr2, 0, iArr4, 0);
                int[] iArr8 = this.subkey;
                iArr8[16] = iArr4[0];
                iArr8[17] = iArr4[1];
                roldq(15, iArr2, 0, iArr8, 20);
                roldqo32(34, iArr2, 0, this.subkey, 28);
                roldq(17, iArr2, 0, this.kw, 4);
                return;
            }
            iArr5[4] = iArr[0];
            iArr5[5] = iArr[1];
            iArr5[6] = iArr[2];
            iArr5[7] = iArr[3];
            decroldq(15, iArr, 0, this.subkey, 28);
            decroldq(30, iArr, 0, this.subkey, 20);
            decroldq(15, iArr, 0, iArr4, 0);
            int[] iArr9 = this.subkey;
            iArr9[16] = iArr4[0];
            iArr9[17] = iArr4[1];
            decroldq(17, iArr, 0, this.ke, 0);
            decroldq(17, iArr, 0, this.subkey, 8);
            decroldq(17, iArr, 0, this.subkey, 0);
            int[] iArr10 = this.subkey;
            iArr10[34] = iArr2[0];
            iArr10[35] = iArr2[1];
            iArr10[32] = iArr2[2];
            iArr10[33] = iArr2[3];
            decroldq(15, iArr2, 0, iArr10, 24);
            decroldq(15, iArr2, 0, this.ke, 4);
            decroldq(15, iArr2, 0, iArr4, 0);
            int[] iArr11 = this.subkey;
            iArr11[18] = iArr4[2];
            iArr11[19] = iArr4[3];
            decroldq(15, iArr2, 0, iArr11, 12);
            decroldqo32(34, iArr2, 0, this.subkey, 4);
            roldq(17, iArr2, 0, this.kw, 0);
            return;
        }
        for (int i3 = 0; i3 < 4; i3++) {
            iArr3[i3] = iArr2[i3] ^ iArr[i3 + 4];
        }
        camelliaF2(iArr3, SIGMA, 8);
        int[] iArr12 = this.kw;
        if (z) {
            iArr12[0] = iArr[0];
            iArr12[1] = iArr[1];
            iArr12[2] = iArr[2];
            iArr12[3] = iArr[3];
            roldqo32(45, iArr, 0, this.subkey, 16);
            roldq(15, iArr, 0, this.ke, 4);
            roldq(17, iArr, 0, this.subkey, 32);
            roldqo32(34, iArr, 0, this.subkey, 44);
            roldq(15, iArr, 4, this.subkey, 4);
            roldq(15, iArr, 4, this.ke, 0);
            roldq(30, iArr, 4, this.subkey, 24);
            roldqo32(34, iArr, 4, this.subkey, 36);
            roldq(15, iArr2, 0, this.subkey, 8);
            roldq(30, iArr2, 0, this.subkey, 20);
            int[] iArr13 = this.ke;
            iArr13[8] = iArr2[1];
            iArr13[9] = iArr2[2];
            iArr13[10] = iArr2[3];
            iArr13[11] = iArr2[0];
            roldqo32(49, iArr2, 0, this.subkey, 40);
            int[] iArr14 = this.subkey;
            iArr14[0] = iArr3[0];
            iArr14[1] = iArr3[1];
            iArr14[2] = iArr3[2];
            iArr14[3] = iArr3[3];
            roldq(30, iArr3, 0, iArr14, 12);
            roldq(30, iArr3, 0, this.subkey, 28);
            roldqo32(51, iArr3, 0, this.kw, 4);
            return;
        }
        iArr12[4] = iArr[0];
        iArr12[5] = iArr[1];
        iArr12[6] = iArr[2];
        iArr12[7] = iArr[3];
        decroldqo32(45, iArr, 0, this.subkey, 28);
        decroldq(15, iArr, 0, this.ke, 4);
        decroldq(17, iArr, 0, this.subkey, 12);
        decroldqo32(34, iArr, 0, this.subkey, 0);
        decroldq(15, iArr, 4, this.subkey, 40);
        decroldq(15, iArr, 4, this.ke, 8);
        decroldq(30, iArr, 4, this.subkey, 20);
        decroldqo32(34, iArr, 4, this.subkey, 8);
        decroldq(15, iArr2, 0, this.subkey, 36);
        decroldq(30, iArr2, 0, this.subkey, 24);
        int[] iArr15 = this.ke;
        iArr15[2] = iArr2[1];
        iArr15[3] = iArr2[2];
        iArr15[0] = iArr2[3];
        iArr15[1] = iArr2[0];
        decroldqo32(49, iArr2, 0, this.subkey, 4);
        int[] iArr16 = this.subkey;
        iArr16[46] = iArr3[0];
        iArr16[47] = iArr3[1];
        iArr16[44] = iArr3[2];
        iArr16[45] = iArr3[3];
        decroldq(30, iArr3, 0, iArr16, 32);
        decroldq(30, iArr3, 0, this.subkey, 16);
        roldqo32(51, iArr3, 0, this.kw, 0);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Camellia";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("only simple KeyParameter expected.");
        }
        setKey(z, ((KeyParameter) cipherParameters).getKey());
        this.initialized = true;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws IllegalStateException {
        if (!this.initialized) {
            throw new IllegalStateException("Camellia is not initialized");
        }
        if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i2 + 16 <= bArr2.length) {
            return this._keyis128 ? processBlock128(bArr, i, bArr2, i2) : processBlock192or256(bArr, i, bArr2, i2);
        }
        throw new OutputLengthException("output buffer too short");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
