package com.socure.docv.capturesdk.core.processor.frame;

import android.graphics.Bitmap;
import com.socure.docv.capturesdk.common.utils.ImageUtils;
import com.socure.docv.capturesdk.common.utils.Utils;
import com.socure.docv.capturesdk.core.processor.model.Point;
import com.socure.docv.capturesdk.core.processor.model.Quadrilateral;
import com.socure.docv.capturesdk.feature.scanner.data.Dimension;
import com.socure.docv.capturesdk.feature.scanner.data.GuidingBox;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f386a = new c();

    public final float a(GuidingBox gb) {
        Intrinsics.checkNotNullParameter(gb, "gb");
        float w = (float) ((((gb.getParentDimension().getW() - gb.getWidth()) / 2) / gb.getWidth()) * 100);
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_CDU", "minimumPercentageForPadding " + w + ", gb: " + gb);
        return w;
    }

    public final float a(List<Float> modelOutputList, Dimension dimen) {
        StringBuilder sb;
        Intrinsics.checkNotNullParameter(modelOutputList, "modelOutputList");
        Intrinsics.checkNotNullParameter(dimen, "dimen");
        ImageUtils imageUtils = ImageUtils.INSTANCE;
        Quadrilateral quadrilateral$capturesdk_productionRelease = imageUtils.getQuadrilateral$capturesdk_productionRelease(modelOutputList);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(quadrilateral$capturesdk_productionRelease.getTopLeft().getX()));
        arrayList.add(Float.valueOf(quadrilateral$capturesdk_productionRelease.getTopLeft().getY()));
        arrayList.add(Float.valueOf((float) (dimen.getW() - quadrilateral$capturesdk_productionRelease.getTopRight().getX())));
        arrayList.add(Float.valueOf(quadrilateral$capturesdk_productionRelease.getTopRight().getY()));
        arrayList.add(Float.valueOf((float) (dimen.getW() - quadrilateral$capturesdk_productionRelease.getBottomRight().getX())));
        arrayList.add(Float.valueOf((float) (dimen.getH() - quadrilateral$capturesdk_productionRelease.getBottomRight().getY())));
        arrayList.add(Float.valueOf(quadrilateral$capturesdk_productionRelease.getBottomLeft().getX()));
        arrayList.add(Float.valueOf((float) (dimen.getH() - quadrilateral$capturesdk_productionRelease.getBottomLeft().getY())));
        Float minOrNull = CollectionsKt.minOrNull((Iterable<? extends Float>) arrayList);
        float f = 0.0f;
        float floatValue = minOrNull != null ? minOrNull.floatValue() : 0.0f;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Double.valueOf(imageUtils.calculateEdgeLength$capturesdk_productionRelease(quadrilateral$capturesdk_productionRelease.getTopLeft(), quadrilateral$capturesdk_productionRelease.getTopRight())));
        arrayList2.add(Double.valueOf(imageUtils.calculateEdgeLength$capturesdk_productionRelease(quadrilateral$capturesdk_productionRelease.getTopRight(), quadrilateral$capturesdk_productionRelease.getBottomRight())));
        arrayList2.add(Double.valueOf(imageUtils.calculateEdgeLength$capturesdk_productionRelease(quadrilateral$capturesdk_productionRelease.getBottomRight(), quadrilateral$capturesdk_productionRelease.getBottomLeft())));
        arrayList2.add(Double.valueOf(imageUtils.calculateEdgeLength$capturesdk_productionRelease(quadrilateral$capturesdk_productionRelease.getBottomLeft(), quadrilateral$capturesdk_productionRelease.getTopLeft())));
        Double maxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Double>) arrayList2);
        double doubleValue = maxOrNull != null ? maxOrNull.doubleValue() : 0.0d;
        if (floatValue <= 0.0f || doubleValue <= 0.0d) {
            sb = new StringBuilder("availablePercentageForPadding: 0, dimen: ");
        } else {
            f = ((float) ((floatValue / doubleValue) * 100)) - 0.2f;
            sb = new StringBuilder("availablePercentageForPadding: ").append(f).append(", dimen: ");
        }
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_CDU", sb.append(dimen).toString());
        return f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Bitmap a(float[] fArr, List<Float> modelOutputList, Dimension bitmapDimen, Bitmap paddedSquaredBitmap, Bitmap paddedScaledDownBitmap, float f) {
        Intrinsics.checkNotNullParameter(modelOutputList, "modelOutputList");
        Intrinsics.checkNotNullParameter(bitmapDimen, "bitmapDimen");
        Intrinsics.checkNotNullParameter(paddedSquaredBitmap, "paddedSquaredBitmap");
        Intrinsics.checkNotNullParameter(paddedScaledDownBitmap, "paddedScaledDownBitmap");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        long currentTimeMillis = System.currentTimeMillis();
        T t = 0;
        t = 0;
        t = 0;
        if (fArr != null && Utils.INSTANCE.cornersFound$capturesdk_productionRelease(fArr)) {
            c cVar = f386a;
            ImageUtils imageUtils = ImageUtils.INSTANCE;
            if (cVar.a(modelOutputList, bitmapDimen, imageUtils.isCornerExpansionEnabled(), f)) {
                t = imageUtils.postCornerProcessing$capturesdk_productionRelease(paddedScaledDownBitmap, paddedSquaredBitmap, fArr, ImageUtils.getCropDocAspectRatio$default(imageUtils, ArraysKt.toList(fArr), false, 2, null));
            }
        }
        objectRef.element = t;
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_CDU", "time taken for cropping: " + (System.currentTimeMillis() - currentTimeMillis));
        return (Bitmap) objectRef.element;
    }

    public final List<Float> a(List<Float> modelOutputList, float f, boolean z) {
        Intrinsics.checkNotNullParameter(modelOutputList, "modelOutputList");
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_CDU", "getModelOutputWithReducedPadding called");
        List<Float> mutableList = CollectionsKt.toMutableList((Collection) modelOutputList);
        if (z) {
            Iterator it = CollectionsKt.arrayListOf(0, 3, 6, 9).iterator();
            while (it.hasNext()) {
                Integer index = (Integer) it.next();
                Intrinsics.checkNotNullExpressionValue(index, "index");
                mutableList.set(index.intValue(), Float.valueOf(mutableList.get(index.intValue()).floatValue() - f));
            }
        } else {
            Iterator it2 = CollectionsKt.arrayListOf(1, 4, 7, 10).iterator();
            while (it2.hasNext()) {
                Integer index2 = (Integer) it2.next();
                Intrinsics.checkNotNullExpressionValue(index2, "index");
                mutableList.set(index2.intValue(), Float.valueOf(mutableList.get(index2.intValue()).floatValue() - f));
            }
        }
        return mutableList;
    }

    public final boolean a(Quadrilateral quadrilateral, Dimension dimension) {
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_CDU", "proximityCheck called");
        Point[] pointArr = {quadrilateral.getTopLeft(), quadrilateral.getTopRight(), quadrilateral.getBottomRight(), quadrilateral.getBottomLeft()};
        for (int i = 0; i < 4; i++) {
            Point point = pointArr[i];
            if (point.getX() < 0.0f || point.getX() > dimension.getW() || point.getY() < 0.0f || point.getY() > dimension.getH()) {
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_CDU", "proximityCheck failed for quad: " + quadrilateral + " with dimen : " + dimension);
                return false;
            }
        }
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_CDU", "proximityCheck pass for quad: " + quadrilateral + " with dimen : " + dimension);
        return true;
    }

    public final boolean a(List<Float> modelOutputList, Dimension bitmapDimension, boolean z, float f) {
        Quadrilateral quadrilateral$capturesdk_productionRelease;
        Intrinsics.checkNotNullParameter(modelOutputList, "modelOutputList");
        Intrinsics.checkNotNullParameter(bitmapDimension, "bitmapDimension");
        if (z) {
            ImageUtils imageUtils = ImageUtils.INSTANCE;
            Quadrilateral quadrilateral$capturesdk_productionRelease2 = imageUtils.getQuadrilateral$capturesdk_productionRelease(modelOutputList);
            quadrilateral$capturesdk_productionRelease = imageUtils.expandQuadrilateral$capturesdk_productionRelease(quadrilateral$capturesdk_productionRelease2, imageUtils.getExpansionOffset$capturesdk_productionRelease(quadrilateral$capturesdk_productionRelease2, f));
        } else {
            quadrilateral$capturesdk_productionRelease = ImageUtils.INSTANCE.getQuadrilateral$capturesdk_productionRelease(modelOutputList);
        }
        return a(quadrilateral$capturesdk_productionRelease, bitmapDimension);
    }
}
