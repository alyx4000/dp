package io.castle.highwind.android;

/* loaded from: classes2.dex */
public final class r {
    public static final byte[] a(Integer[] numArr) {
        int length = numArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) numArr[i].intValue();
        }
        return bArr;
    }
}
