package org.bouncycastle.crypto.engines;

import kotlin.UByte;

/* loaded from: classes6.dex */
public class VMPCKSA3Engine extends VMPCEngine {
    @Override // org.bouncycastle.crypto.engines.VMPCEngine, org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "VMPC-KSA3";
    }

    @Override // org.bouncycastle.crypto.engines.VMPCEngine
    protected void initKey(byte[] bArr, byte[] bArr2) {
        this.s = (byte) 0;
        this.P = new byte[256];
        for (int i = 0; i < 256; i++) {
            this.P[i] = (byte) i;
        }
        for (int i2 = 0; i2 < 768; i2++) {
            int i3 = i2 & 255;
            this.s = this.P[(this.s + this.P[i3] + bArr[i2 % bArr.length]) & 255];
            byte b = this.P[i3];
            this.P[i3] = this.P[this.s & UByte.MAX_VALUE];
            this.P[this.s & UByte.MAX_VALUE] = b;
        }
        for (int i4 = 0; i4 < 768; i4++) {
            int i5 = i4 & 255;
            this.s = this.P[(this.s + this.P[i5] + bArr2[i4 % bArr2.length]) & 255];
            byte b2 = this.P[i5];
            this.P[i5] = this.P[this.s & UByte.MAX_VALUE];
            this.P[this.s & UByte.MAX_VALUE] = b2;
        }
        for (int i6 = 0; i6 < 768; i6++) {
            int i7 = i6 & 255;
            this.s = this.P[(this.s + this.P[i7] + bArr[i6 % bArr.length]) & 255];
            byte b3 = this.P[i7];
            this.P[i7] = this.P[this.s & UByte.MAX_VALUE];
            this.P[this.s & UByte.MAX_VALUE] = b3;
        }
        this.n = (byte) 0;
    }
}
