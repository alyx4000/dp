package com.cossacklabs.themis;

/* loaded from: classes.dex */
public class SecureCellData {
    byte[] additionalData;
    byte[] protectedData;

    public SecureCellData(byte[] bArr, byte[] bArr2) {
        this.protectedData = bArr;
        this.additionalData = bArr2;
    }

    public byte[] getProtectedData() {
        return this.protectedData;
    }

    public byte[] getAdditionalData() {
        return this.additionalData;
    }

    public boolean hasAdditionalData() {
        return this.additionalData != null;
    }

    public byte[] component1() {
        return this.protectedData;
    }

    public byte[] component2() {
        return this.additionalData;
    }
}
