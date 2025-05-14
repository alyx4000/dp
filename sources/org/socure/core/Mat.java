package org.socure.core;

import androidx.webkit.ProxyConfig;

/* loaded from: classes6.dex */
public class Mat {

    /* renamed from: a, reason: collision with root package name */
    public final long f803a;

    public Mat() {
        this.f803a = n_Mat();
    }

    public Mat(int i, int i2, int i3) {
        this.f803a = n_Mat(i, i2, i3);
    }

    public Mat(long j) {
        if (j == 0) {
            throw new UnsupportedOperationException("Native object address is NULL");
        }
        this.f803a = j;
    }

    public Mat(Mat mat, Range range) {
        this.f803a = n_Mat(mat.f803a, range.f804a, range.b);
    }

    private static native int nGetD(long j, int i, int i2, int i3, double[] dArr);

    private static native int nGetF(long j, int i, int i2, int i3, float[] fArr);

    private static native int nGetI(long j, int i, int i2, int i3, int[] iArr);

    private static native int nPutF(long j, int i, int i2, int i3, float[] fArr);

    private static native long n_Mat();

    private static native long n_Mat(int i, int i2, int i3);

    private static native long n_Mat(long j, int i, int i2);

    private static native int n_checkVector(long j, int i, int i2);

    private static native long n_clone(long j);

    private static native int n_cols(long j);

    private static native void n_create(long j, int i, int i2, int i3);

    private static native long n_dataAddr(long j);

    private static native void n_delete(long j);

    private static native int n_dims(long j);

    private static native boolean n_empty(long j);

    private static native boolean n_isContinuous(long j);

    private static native boolean n_isSubmatrix(long j);

    private static native void n_release(long j);

    private static native int n_rows(long j);

    private static native double[] n_size(long j);

    private static native int n_size_i(long j, int i);

    private static native long n_total(long j);

    private static native int n_type(long j);

    public int a() {
        return n_cols(this.f803a);
    }

    public int a(int i, int i2) {
        return n_checkVector(this.f803a, i, i2);
    }

    public int a(int i, int i2, double[] dArr) {
        int n_type = n_type(this.f803a);
        if (dArr.length % a.a(n_type) != 0) {
            throw new UnsupportedOperationException("Provided data element number (" + dArr.length + ") should be multiple of the Mat channels count (" + a.a(n_type) + ")");
        }
        if ((n_type & 7) == 6) {
            return nGetD(this.f803a, i, i2, dArr.length, dArr);
        }
        throw new UnsupportedOperationException("Mat data type is not compatible: " + n_type);
    }

    public void a(int i, int i2, int i3) {
        n_create(this.f803a, i, i2, i3);
    }

    public int b(int i, int i2, float[] fArr) {
        int n_type = n_type(this.f803a);
        if (fArr.length % a.a(n_type) != 0) {
            throw new UnsupportedOperationException("Provided data element number (" + fArr.length + ") should be multiple of the Mat channels count (" + a.a(n_type) + ")");
        }
        if ((n_type & 7) == 5) {
            return nPutF(this.f803a, i, i2, fArr.length, fArr);
        }
        throw new UnsupportedOperationException("Mat data type is not compatible: " + n_type);
    }

    public boolean b() {
        return n_empty(this.f803a);
    }

    public void c() {
        n_release(this.f803a);
    }

    public Object clone() {
        return new Mat(n_clone(this.f803a));
    }

    public int d() {
        return n_rows(this.f803a);
    }

    public f e() {
        return new f(n_size(this.f803a));
    }

    public long f() {
        return n_total(this.f803a);
    }

    public void finalize() {
        n_delete(this.f803a);
        super.finalize();
    }

    public int g() {
        return n_type(this.f803a);
    }

    public String toString() {
        String str;
        String str2 = n_dims(this.f803a) > 0 ? "" : "-1*-1*";
        for (int i = 0; i < n_dims(this.f803a); i++) {
            str2 = str2 + n_size_i(this.f803a, i) + ProxyConfig.MATCH_ALL_SCHEMES;
        }
        StringBuilder append = new StringBuilder("Mat [ ").append(str2);
        int n_type = n_type(this.f803a);
        int i2 = a.f805a;
        switch (n_type & 7) {
            case 0:
                str = "CV_8U";
                break;
            case 1:
                str = "CV_8S";
                break;
            case 2:
                str = "CV_16U";
                break;
            case 3:
                str = "CV_16S";
                break;
            case 4:
                str = "CV_32S";
                break;
            case 5:
                str = "CV_32F";
                break;
            case 6:
                str = "CV_64F";
                break;
            case 7:
                str = "CV_16F";
                break;
            default:
                throw new UnsupportedOperationException("Unsupported CvType value: " + n_type);
        }
        int a2 = a.a(n_type);
        return append.append((a2 <= 4 ? new StringBuilder().append(str).append("C").append(a2) : new StringBuilder().append(str).append("C(").append(a2).append(")")).toString()).append(", isCont=").append(n_isContinuous(this.f803a)).append(", isSubmat=").append(n_isSubmatrix(this.f803a)).append(", nativeObj=0x").append(Long.toHexString(this.f803a)).append(", dataAddr=0x").append(Long.toHexString(n_dataAddr(this.f803a))).append(" ]").toString();
    }

    public int a(int i, int i2, float[] fArr) {
        int n_type = n_type(this.f803a);
        if (fArr.length % a.a(n_type) != 0) {
            throw new UnsupportedOperationException("Provided data element number (" + fArr.length + ") should be multiple of the Mat channels count (" + a.a(n_type) + ")");
        }
        if ((n_type & 7) == 5) {
            return nGetF(this.f803a, i, i2, fArr.length, fArr);
        }
        throw new UnsupportedOperationException("Mat data type is not compatible: " + n_type);
    }

    public int a(int i, int i2, int[] iArr) {
        int n_type = n_type(this.f803a);
        if (iArr.length % a.a(n_type) != 0) {
            throw new UnsupportedOperationException("Provided data element number (" + iArr.length + ") should be multiple of the Mat channels count (" + a.a(n_type) + ")");
        }
        if ((n_type & 7) == 4) {
            return nGetI(this.f803a, i, i2, iArr.length, iArr);
        }
        throw new UnsupportedOperationException("Mat data type is not compatible: " + n_type);
    }
}
