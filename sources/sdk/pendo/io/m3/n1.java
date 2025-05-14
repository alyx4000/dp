package sdk.pendo.io.m3;

import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes6.dex */
public class n1 extends m {
    public n1(byte[] bArr) {
        super(bArr);
    }

    private byte[] p() {
        byte[] bArr = this.f;
        if (bArr[bArr.length - 1] != 90) {
            return bArr;
        }
        if (!n()) {
            byte[] bArr2 = this.f;
            byte[] bArr3 = new byte[bArr2.length + 4];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length - 1);
            System.arraycopy(sdk.pendo.io.d5.i.a("0000Z"), 0, bArr3, this.f.length - 1, 5);
            return bArr3;
        }
        if (!o()) {
            byte[] bArr4 = this.f;
            byte[] bArr5 = new byte[bArr4.length + 2];
            System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length - 1);
            System.arraycopy(sdk.pendo.io.d5.i.a("00Z"), 0, bArr5, this.f.length - 1, 3);
            return bArr5;
        }
        if (!m()) {
            return this.f;
        }
        int length = this.f.length - 2;
        while (length > 0 && this.f[length] == 48) {
            length--;
        }
        byte[] bArr6 = this.f;
        if (bArr6[length] == 46) {
            byte[] bArr7 = new byte[length + 1];
            System.arraycopy(bArr6, 0, bArr7, 0, length);
            bArr7[length] = BuiltinOptions.MatrixSetDiagOptions;
            return bArr7;
        }
        byte[] bArr8 = new byte[length + 2];
        int i = length + 1;
        System.arraycopy(bArr6, 0, bArr8, 0, i);
        bArr8[i] = BuiltinOptions.MatrixSetDiagOptions;
        return bArr8;
    }

    @Override // sdk.pendo.io.m3.m, sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        yVar.a(z, 24, p());
    }

    @Override // sdk.pendo.io.m3.m, sdk.pendo.io.m3.a0
    a0 i() {
        return this;
    }

    @Override // sdk.pendo.io.m3.m, sdk.pendo.io.m3.a0
    a0 j() {
        return this;
    }

    @Override // sdk.pendo.io.m3.m, sdk.pendo.io.m3.a0
    int a(boolean z) {
        return y.a(z, p().length);
    }
}
