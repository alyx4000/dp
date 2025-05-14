package sdk.pendo.io.p2;

import java.util.Comparator;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f1490a = 0;

    private void b(Object obj, Object obj2, Comparator<?> comparator) {
        if (obj instanceof long[]) {
            a((long[]) obj, (long[]) obj2);
            return;
        }
        if (obj instanceof int[]) {
            a((int[]) obj, (int[]) obj2);
            return;
        }
        if (obj instanceof short[]) {
            a((short[]) obj, (short[]) obj2);
            return;
        }
        if (obj instanceof char[]) {
            a((char[]) obj, (char[]) obj2);
            return;
        }
        if (obj instanceof byte[]) {
            a((byte[]) obj, (byte[]) obj2);
            return;
        }
        if (obj instanceof double[]) {
            a((double[]) obj, (double[]) obj2);
            return;
        }
        if (obj instanceof float[]) {
            a((float[]) obj, (float[]) obj2);
        } else if (obj instanceof boolean[]) {
            a((boolean[]) obj, (boolean[]) obj2);
        } else {
            a((Object[]) obj, (Object[]) obj2, comparator);
        }
    }

    public a a(byte b, byte b2) {
        if (this.f1490a != 0) {
            return this;
        }
        this.f1490a = Byte.compare(b, b2);
        return this;
    }

    public a a(char c, char c2) {
        if (this.f1490a != 0) {
            return this;
        }
        this.f1490a = Character.compare(c, c2);
        return this;
    }

    public a a(double d, double d2) {
        if (this.f1490a != 0) {
            return this;
        }
        this.f1490a = Double.compare(d, d2);
        return this;
    }

    public a a(float f, float f2) {
        if (this.f1490a != 0) {
            return this;
        }
        this.f1490a = Float.compare(f, f2);
        return this;
    }

    public a a(int i, int i2) {
        if (this.f1490a != 0) {
            return this;
        }
        this.f1490a = Integer.compare(i, i2);
        return this;
    }

    public a a(long j, long j2) {
        if (this.f1490a != 0) {
            return this;
        }
        this.f1490a = Long.compare(j, j2);
        return this;
    }

    public a a(Object obj, Object obj2) {
        return a(obj, obj2, (Comparator<?>) null);
    }

    public a a(Object obj, Object obj2, Comparator<?> comparator) {
        int i;
        if (this.f1490a != 0 || obj == obj2) {
            return this;
        }
        if (obj == null) {
            i = -1;
        } else {
            if (obj2 != null) {
                if (obj.getClass().isArray()) {
                    b(obj, obj2, comparator);
                } else {
                    this.f1490a = comparator == null ? ((Comparable) obj).compareTo(obj2) : comparator.compare(obj, obj2);
                }
                return this;
            }
            i = 1;
        }
        this.f1490a = i;
        return this;
    }

    public a a(short s, short s2) {
        if (this.f1490a != 0) {
            return this;
        }
        this.f1490a = Short.compare(s, s2);
        return this;
    }

    public a a(boolean z, boolean z2) {
        if (this.f1490a != 0 || z == z2) {
            return this;
        }
        this.f1490a = z ? 1 : -1;
        return this;
    }

    public a a(byte[] bArr, byte[] bArr2) {
        if (this.f1490a != 0 || bArr == bArr2) {
            return this;
        }
        if (bArr == null) {
            this.f1490a = -1;
            return this;
        }
        if (bArr2 == null) {
            this.f1490a = 1;
            return this;
        }
        if (bArr.length != bArr2.length) {
            this.f1490a = bArr.length >= bArr2.length ? 1 : -1;
            return this;
        }
        for (int i = 0; i < bArr.length && this.f1490a == 0; i++) {
            a(bArr[i], bArr2[i]);
        }
        return this;
    }

    public a a(char[] cArr, char[] cArr2) {
        if (this.f1490a != 0 || cArr == cArr2) {
            return this;
        }
        if (cArr == null) {
            this.f1490a = -1;
            return this;
        }
        if (cArr2 == null) {
            this.f1490a = 1;
            return this;
        }
        if (cArr.length != cArr2.length) {
            this.f1490a = cArr.length >= cArr2.length ? 1 : -1;
            return this;
        }
        for (int i = 0; i < cArr.length && this.f1490a == 0; i++) {
            a(cArr[i], cArr2[i]);
        }
        return this;
    }

    public a a(double[] dArr, double[] dArr2) {
        if (this.f1490a != 0 || dArr == dArr2) {
            return this;
        }
        if (dArr == null) {
            this.f1490a = -1;
            return this;
        }
        if (dArr2 == null) {
            this.f1490a = 1;
            return this;
        }
        if (dArr.length != dArr2.length) {
            this.f1490a = dArr.length >= dArr2.length ? 1 : -1;
            return this;
        }
        for (int i = 0; i < dArr.length && this.f1490a == 0; i++) {
            a(dArr[i], dArr2[i]);
        }
        return this;
    }

    public a a(float[] fArr, float[] fArr2) {
        if (this.f1490a != 0 || fArr == fArr2) {
            return this;
        }
        if (fArr == null) {
            this.f1490a = -1;
            return this;
        }
        if (fArr2 == null) {
            this.f1490a = 1;
            return this;
        }
        if (fArr.length != fArr2.length) {
            this.f1490a = fArr.length >= fArr2.length ? 1 : -1;
            return this;
        }
        for (int i = 0; i < fArr.length && this.f1490a == 0; i++) {
            a(fArr[i], fArr2[i]);
        }
        return this;
    }

    public a a(int[] iArr, int[] iArr2) {
        if (this.f1490a != 0 || iArr == iArr2) {
            return this;
        }
        if (iArr == null) {
            this.f1490a = -1;
            return this;
        }
        if (iArr2 == null) {
            this.f1490a = 1;
            return this;
        }
        if (iArr.length != iArr2.length) {
            this.f1490a = iArr.length >= iArr2.length ? 1 : -1;
            return this;
        }
        for (int i = 0; i < iArr.length && this.f1490a == 0; i++) {
            a(iArr[i], iArr2[i]);
        }
        return this;
    }

    public a a(long[] jArr, long[] jArr2) {
        if (this.f1490a != 0 || jArr == jArr2) {
            return this;
        }
        if (jArr == null) {
            this.f1490a = -1;
            return this;
        }
        if (jArr2 == null) {
            this.f1490a = 1;
            return this;
        }
        if (jArr.length != jArr2.length) {
            this.f1490a = jArr.length >= jArr2.length ? 1 : -1;
            return this;
        }
        for (int i = 0; i < jArr.length && this.f1490a == 0; i++) {
            a(jArr[i], jArr2[i]);
        }
        return this;
    }

    public a a(Object[] objArr, Object[] objArr2, Comparator<?> comparator) {
        if (this.f1490a != 0 || objArr == objArr2) {
            return this;
        }
        if (objArr == null) {
            this.f1490a = -1;
            return this;
        }
        if (objArr2 == null) {
            this.f1490a = 1;
            return this;
        }
        if (objArr.length != objArr2.length) {
            this.f1490a = objArr.length >= objArr2.length ? 1 : -1;
            return this;
        }
        for (int i = 0; i < objArr.length && this.f1490a == 0; i++) {
            a(objArr[i], objArr2[i], comparator);
        }
        return this;
    }

    public a a(short[] sArr, short[] sArr2) {
        if (this.f1490a != 0 || sArr == sArr2) {
            return this;
        }
        if (sArr == null) {
            this.f1490a = -1;
            return this;
        }
        if (sArr2 == null) {
            this.f1490a = 1;
            return this;
        }
        if (sArr.length != sArr2.length) {
            this.f1490a = sArr.length >= sArr2.length ? 1 : -1;
            return this;
        }
        for (int i = 0; i < sArr.length && this.f1490a == 0; i++) {
            a(sArr[i], sArr2[i]);
        }
        return this;
    }

    public a a(boolean[] zArr, boolean[] zArr2) {
        if (this.f1490a != 0 || zArr == zArr2) {
            return this;
        }
        if (zArr == null) {
            this.f1490a = -1;
            return this;
        }
        if (zArr2 == null) {
            this.f1490a = 1;
            return this;
        }
        if (zArr.length != zArr2.length) {
            this.f1490a = zArr.length >= zArr2.length ? 1 : -1;
            return this;
        }
        for (int i = 0; i < zArr.length && this.f1490a == 0; i++) {
            a(zArr[i], zArr2[i]);
        }
        return this;
    }

    public int a() {
        return this.f1490a;
    }
}
