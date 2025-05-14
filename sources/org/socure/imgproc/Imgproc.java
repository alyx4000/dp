package org.socure.imgproc;

import org.socure.core.Mat;
import org.socure.core.e;
import org.socure.core.f;

/* loaded from: classes6.dex */
public class Imgproc {
    public static Mat a(Mat mat, Mat mat2) {
        return new Mat(getPerspectiveTransform_1(mat.f803a, mat2.f803a));
    }

    public static void a(Mat mat, Mat mat2, int i) {
        cvtColor_1(mat.f803a, mat2.f803a, i);
    }

    public static void a(Mat mat, Mat mat2, Mat mat3, f fVar, int i, int i2, e eVar) {
        long j = mat.f803a;
        long j2 = mat2.f803a;
        long j3 = mat3.f803a;
        double d = fVar.f808a;
        double d2 = fVar.b;
        double[] dArr = eVar.f807a;
        warpPerspective_0(j, j2, j3, d, d2, i, i2, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    private static native void cvtColor_1(long j, long j2, int i);

    private static native long getPerspectiveTransform_1(long j, long j2);

    private static native void warpPerspective_0(long j, long j2, long j3, double d, double d2, int i, int i2, double d3, double d4, double d5, double d6);
}
