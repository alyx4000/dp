package com.socure.docv.capturesdk.core.external.opencv.impl;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.socure.android.Utils;
import org.socure.core.Core;
import org.socure.core.Mat;
import org.socure.core.b;
import org.socure.imgproc.Imgproc;

/* loaded from: classes5.dex */
public final class a implements com.socure.docv.capturesdk.core.processor.interfaces.a {
    public final double a(Mat mat) {
        ArrayList arrayList = new ArrayList();
        b bVar = new b(new Mat(1, 1, 6));
        b bVar2 = new b(new Mat(1, 1, 6));
        Mat mat2 = new Mat();
        Mat mat3 = new Mat();
        Imgproc.a(mat, mat2, 1);
        Imgproc.a(mat2, mat3, 53);
        Core.a(mat3, arrayList);
        Mat mat4 = (Mat) arrayList.get(1);
        Core.a(mat4, bVar, bVar2);
        int a2 = bVar.a(1, 6);
        if (a2 < 0) {
            throw new RuntimeException("Native Mat has unexpected type or size: " + bVar.toString());
        }
        double[] dArr = new double[a2 * 1];
        if (a2 != 0) {
            bVar.a(0, 0, dArr);
        }
        double d = dArr[0] / 255;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Mat) it.next()).c();
        }
        arrayList.clear();
        bVar.c();
        bVar2.c();
        mat2.c();
        mat3.c();
        mat4.c();
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_BD_OCV", "mean brightness measured as: " + d);
        return d;
    }

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.a
    public void a() {
    }

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.a
    public float[] a(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return null;
    }

    public final double b(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Mat mat = new Mat();
        long currentTimeMillis = System.currentTimeMillis();
        if (bitmap.getWidth() > 256 && bitmap.getHeight() > 256) {
            bitmap = Bitmap.createScaledBitmap(bitmap, (bitmap.getWidth() * 256) / bitmap.getHeight(), 256, false);
        }
        Utils.a(bitmap, mat);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        long currentTimeMillis3 = System.currentTimeMillis();
        double a2 = a(mat);
        mat.c();
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_BD_OCV", "BrightnessDetectorOCV - timeTaken: " + (System.currentTimeMillis() - currentTimeMillis3) + " | meanBrightness: " + a2 + " | timeTakenBmpToMatConversion: " + currentTimeMillis2);
        return a2;
    }
}
