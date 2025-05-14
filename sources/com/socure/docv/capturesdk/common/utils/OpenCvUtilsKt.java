package com.socure.docv.capturesdk.common.utils;

import android.graphics.Bitmap;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.socure.docv.capturesdk.common.logger.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.socure.core.Mat;
import org.socure.core.c;
import org.socure.core.d;
import org.socure.core.e;
import org.socure.core.f;
import org.socure.imgproc.Imgproc;

@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u001a:\u0010\b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f\u001a\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012\u001a\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0000\u001a\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u0000\u001a\b\u0010\u001a\u001a\u00020\u0019H\u0000\u001a\b\u0010\u001b\u001a\u00020\u0019H\u0002\u001a\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002\"\u0014\u0010\u001e\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lorg/socure/core/Mat;", "highResImg", "", "", "points", "hRatio", "wRatio", "ratio", "cropAndPerspectiveTransform", "Lorg/socure/core/c;", "input", "", "matOfPoint2fToString", "src", TouchesHelper.TARGET_KEY, "Lcom/socure/docv/capturesdk/common/utils/DIMEN;", "dimen", "dimenRatio", "", "modelOutput", "getDetectedCorners", "floatArray", "calcMeasure", "Landroid/graphics/Bitmap;", "bitmapFromMat", "", "useOpenCv", "loadOpenCv", "", "errorOnOpenCvUse", "TAG", "Ljava/lang/String;", "capturesdk_productionRelease"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class OpenCvUtilsKt {
    private static final String TAG = "SDLT_OP_CU";

    public static final Bitmap bitmapFromMat(Mat src) {
        Intrinsics.checkNotNullParameter(src, "src");
        b.b(TAG, "produceBitmap: " + src);
        Bitmap nBmp = Bitmap.createBitmap(src.a(), src.d(), Bitmap.Config.ARGB_8888);
        org.socure.android.Utils.a(src, nBmp);
        src.c();
        Intrinsics.checkNotNullExpressionValue(nBmp, "nBmp");
        return nBmp;
    }

    public static final double calcMeasure(float[] fArr) {
        if (fArr != null) {
            return (((fArr[2] + fArr[5]) + fArr[8]) + fArr[11]) / 4;
        }
        return 0.0d;
    }

    public static final Mat cropAndPerspectiveTransform(Mat highResImg, List<List<Double>> points, double d, double d2, double d3) {
        Intrinsics.checkNotNullParameter(highResImg, "highResImg");
        Intrinsics.checkNotNullParameter(points, "points");
        b.b(TAG, "getTransformedImage called with points: " + points + " | hRatio:" + d + ", wRatio: " + d2 + " | highResImg dim: " + highResImg.e());
        int a2 = highResImg.a();
        c cVar = new c(new d(points.get(0).get(0).doubleValue() * d2, points.get(0).get(1).doubleValue() * d), new d(points.get(1).get(0).doubleValue() * d2, points.get(1).get(1).doubleValue() * d), new d(points.get(2).get(0).doubleValue() * d2, points.get(2).get(1).doubleValue() * d), new d(points.get(3).get(0).doubleValue() * d2, points.get(3).get(1).doubleValue() * d));
        double d4 = a2;
        f fVar = new f(d4, d4 / d3);
        double d5 = fVar.f808a;
        double d6 = fVar.b;
        c cVar2 = new c(new d(0.0d, 0.0d), new d(d5, 0.0d), new d(d5, d6), new d(0.0d, d6));
        b.b(TAG, "destSize - w:" + fVar.f808a + ", h: " + fVar.b + " | srcTri: " + matOfPoint2fToString(cVar) + " | dstTri: " + matOfPoint2fToString(cVar2));
        Mat a3 = Imgproc.a(cVar, cVar2);
        Mat mat = new Mat();
        Imgproc.a(highResImg, mat, a3, fVar, 1, 0, new e(0.0d));
        return mat;
    }

    public static final double dimenRatio(Mat src, Mat target, DIMEN dimen) {
        double d;
        int d2;
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(dimen, "dimen");
        if (dimen == DIMEN.WIDTH) {
            d = target.a();
            d2 = src.a();
        } else {
            d = target.d();
            d2 = src.d();
        }
        return d / d2;
    }

    private static final Throwable errorOnOpenCvUse() {
        try {
            new Mat().c();
            return null;
        } catch (Throwable th) {
            b.a(TAG, "Th in doesOpenCvWork: " + th.getLocalizedMessage(), null, 4, null);
            return th;
        }
    }

    public static final List<List<Double>> getDetectedCorners(float[] modelOutput) {
        Intrinsics.checkNotNullParameter(modelOutput, "modelOutput");
        b.b(TAG, "getDetectedCorners called");
        ArrayList arrayList = new ArrayList();
        arrayList.add(CollectionsKt.mutableListOf(Double.valueOf(modelOutput[0]), Double.valueOf(modelOutput[1])));
        arrayList.add(CollectionsKt.mutableListOf(Double.valueOf(modelOutput[3]), Double.valueOf(modelOutput[4])));
        arrayList.add(CollectionsKt.mutableListOf(Double.valueOf(modelOutput[6]), Double.valueOf(modelOutput[7])));
        arrayList.add(CollectionsKt.mutableListOf(Double.valueOf(modelOutput[9]), Double.valueOf(modelOutput[10])));
        return arrayList;
    }

    private static final boolean loadOpenCv() {
        try {
            b.c(TAG, "opencv load called");
            System.loadLibrary("opencv_java4");
            b.c(TAG, "opencv loaded");
            return true;
        } catch (Throwable th) {
            b.a(TAG, "Throwable in trying to load opencv_java4: " + th.getLocalizedMessage(), null, 4, null);
            return false;
        }
    }

    private static final String matOfPoint2fToString(c cVar) {
        int f = (int) cVar.f();
        d[] dVarArr = new d[f];
        if (f != 0) {
            cVar.a(0, 0, new float[f * 2]);
            for (int i = 0; i < f; i++) {
                int i2 = i * 2;
                dVarArr[i] = new d(r2[i2], r2[i2 + 1]);
            }
        }
        List<d> list = Arrays.asList(dVarArr);
        Intrinsics.checkNotNullExpressionValue(list, "list");
        String str = "";
        for (d dVar : list) {
            str = ((Object) str) + "(" + dVar.f806a + ", " + dVar.b + "), ";
        }
        return str;
    }

    public static final boolean useOpenCv() {
        return loadOpenCv() && errorOnOpenCvUse() == null;
    }
}
