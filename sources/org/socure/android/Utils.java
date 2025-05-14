package org.socure.android;

import android.graphics.Bitmap;
import org.socure.core.Mat;

/* loaded from: classes6.dex */
public class Utils {
    public static void a(Bitmap bitmap, Mat mat) {
        if (bitmap == null) {
            throw new IllegalArgumentException("bmp == null");
        }
        nBitmapToMat2(bitmap, mat.f803a, false);
    }

    private static native void nBitmapToMat2(Bitmap bitmap, long j, boolean z);

    private static native void nMatToBitmap2(long j, Bitmap bitmap, boolean z);

    public static void a(Mat mat, Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("bmp == null");
        }
        nMatToBitmap2(mat.f803a, bitmap, false);
    }
}
