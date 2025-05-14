package com.quantummetric.ui.internal;

import java.util.zip.Checksum;
import kotlin.UByte;

/* loaded from: classes5.dex */
final class bj implements Checksum {

    /* renamed from: a, reason: collision with root package name */
    private final long f110a = 0;
    private long b;
    private long c;
    private int d;
    private int e;
    private long f;
    private long g;
    private boolean h;
    private long i;
    private long j;

    private static long a(byte[] bArr, int i) {
        return (bArr[i + 7] << 56) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    private void a(long j, long j2) {
        long rotateLeft = (Long.rotateLeft(j * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.b;
        this.b = rotateLeft;
        this.b = ((Long.rotateLeft(rotateLeft, 27) + this.c) * 5) + 1390208809;
        long rotateLeft2 = (Long.rotateLeft(j2 * 5545529020109919103L, 33) * (-8663945395140668459L)) ^ this.c;
        this.c = rotateLeft2;
        this.c = ((Long.rotateLeft(rotateLeft2, 31) + this.b) * 5) + 944331445;
    }

    @Override // java.util.zip.Checksum
    public final long getValue() {
        if (!this.h) {
            this.h = true;
            this.i = this.b;
            this.j = this.c;
            int i = this.e;
            if (i > 0) {
                if (i > 8) {
                    this.j = (Long.rotateLeft(this.g * 5545529020109919103L, 33) * (-8663945395140668459L)) ^ this.j;
                }
                this.i ^= Long.rotateLeft(this.f * (-8663945395140668459L), 31) * 5545529020109919103L;
            }
            long j = this.i;
            int i2 = this.d;
            long j2 = this.j ^ i2;
            long j3 = (j ^ i2) + j2;
            long j4 = j2 + j3;
            long j5 = (j3 ^ (j3 >>> 33)) * (-49064778989728563L);
            long j6 = (j5 ^ (j5 >>> 33)) * (-4265267296055464877L);
            long j7 = (j4 ^ (j4 >>> 33)) * (-49064778989728563L);
            long j8 = (j7 ^ (j7 >>> 33)) * (-4265267296055464877L);
            long j9 = (j8 >>> 33) ^ j8;
            long j10 = (j6 ^ (j6 >>> 33)) + j9;
            this.i = j10;
            this.j = j9 + j10;
        }
        return this.i;
    }

    @Override // java.util.zip.Checksum
    public final void reset() {
        long j = this.f110a;
        this.c = j;
        this.b = j;
        this.d = 0;
        this.e = 0;
        this.h = false;
        this.g = 0L;
        this.f = 0L;
        this.j = 0L;
        this.i = 0L;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0013. Please report as an issue. */
    @Override // java.util.zip.Checksum
    public final void update(int i) {
        long j;
        long j2;
        int i2;
        long j3;
        long j4;
        long j5;
        int i3;
        long j6;
        this.h = false;
        int i4 = this.e;
        switch (i4) {
            case 0:
                j = i & 255;
                this.f = j;
                break;
            case 1:
                j2 = this.f;
                i2 = (i & 255) << 8;
                j3 = i2;
                j = j2 | j3;
                this.f = j;
                break;
            case 2:
                j2 = this.f;
                i2 = (i & 255) << 16;
                j3 = i2;
                j = j2 | j3;
                this.f = j;
                break;
            case 3:
                j2 = this.f;
                j3 = (i & 255) << 24;
                j = j2 | j3;
                this.f = j;
                break;
            case 4:
                j2 = this.f;
                j3 = (255 & i) << 32;
                j = j2 | j3;
                this.f = j;
                break;
            case 5:
                j2 = this.f;
                j3 = (i & 255) << 40;
                j = j2 | j3;
                this.f = j;
                break;
            case 6:
                j = ((255 & i) << 48) | this.f;
                this.f = j;
                break;
            case 7:
                j = this.f | ((i & 255) << 56);
                this.f = j;
                break;
            case 8:
                j4 = i & 255;
                this.g = j4;
                break;
            case 9:
                j5 = this.g;
                i3 = (i & 255) << 8;
                j6 = i3;
                j4 = j5 | j6;
                this.g = j4;
                break;
            case 10:
                j5 = this.g;
                i3 = (i & 255) << 16;
                j6 = i3;
                j4 = j5 | j6;
                this.g = j4;
                break;
            case 11:
                j5 = this.g;
                j6 = (i & 255) << 24;
                j4 = j5 | j6;
                this.g = j4;
                break;
            case 12:
                j5 = this.g;
                j6 = (255 & i) << 32;
                j4 = j5 | j6;
                this.g = j4;
                break;
            case 13:
                j5 = this.g;
                j6 = (i & 255) << 40;
                j4 = j5 | j6;
                this.g = j4;
                break;
            case 14:
                j4 = ((255 & i) << 48) | this.g;
                this.g = j4;
                break;
            case 15:
                j4 = this.g | ((i & 255) << 56);
                this.g = j4;
                break;
        }
        int i5 = i4 + 1;
        this.e = i5;
        if (i5 == 16) {
            a(this.f, this.g);
            this.e = 0;
        }
        this.d++;
    }

    @Override // java.util.zip.Checksum
    public final void update(byte[] bArr, int i, int i2) {
        this.h = false;
        while (this.e != 0 && i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
        int i3 = i2 & 15;
        int i4 = (i2 + i) - i3;
        for (int i5 = i; i5 < i4; i5 += 16) {
            a(a(bArr, i5), a(bArr, i5 + 8));
        }
        this.d += i4 - i;
        for (int i6 = 0; i6 < i3; i6++) {
            update(bArr[i4 + i6]);
        }
    }
}
