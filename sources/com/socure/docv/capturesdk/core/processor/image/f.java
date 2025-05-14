package com.socure.docv.capturesdk.core.processor.image;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.google.mlkit.vision.face.Face;
import com.socure.docv.capturesdk.common.utils.ImageUtils;
import com.socure.docv.capturesdk.common.utils.Utils;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.core.extractor.i;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.pipeline.model.SelfieRange;
import com.socure.docv.capturesdk.core.pipeline.model.SelfieRangeType;
import com.socure.docv.capturesdk.core.processor.model.IResult;
import com.socure.docv.capturesdk.core.processor.model.ProcessOutput;
import com.socure.docv.capturesdk.feature.scanner.data.GuidingBox;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;

/* loaded from: classes5.dex */
public final class f implements com.socure.docv.capturesdk.core.processor.interfaces.b {

    /* renamed from: a, reason: collision with root package name */
    public final com.socure.docv.capturesdk.di.c f392a;
    public com.socure.docv.capturesdk.core.extractor.c b;
    public Float c;
    public Float d;
    public com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.a e;
    public final Rect f;

    public static final class a implements i {
        @Override // com.socure.docv.capturesdk.core.extractor.i
        public void a(com.socure.docv.capturesdk.core.extractor.model.a aVar, boolean z) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SFP", "Face reader response for selfie - face found?: " + z);
        }
    }

    public f(com.socure.docv.capturesdk.di.c dependencyGraph) {
        Intrinsics.checkNotNullParameter(dependencyGraph, "dependencyGraph");
        this.f392a = dependencyGraph;
        GuidingBox b = b();
        this.f = new Rect(b.getLeftTopX(), b.getLeftTopY(), b.getWidth() + b.getLeftTopX(), b.getHeight() + b.getLeftTopY());
    }

    public final float a(Rect faceRect) {
        Intrinsics.checkNotNullParameter(faceRect, "faceRect");
        GuidingBox b = b();
        float height = b.getHeight() * b.getWidth();
        float height2 = faceRect.height() * faceRect.width();
        float f = height / height2;
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SFP", "Ratio: " + height + "/" + height2 + "=" + f);
        return f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x016e, code lost:
    
        if (r1 == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.socure.docv.capturesdk.core.processor.model.ProcessOutput a(com.google.mlkit.vision.face.Face r18, float r19, float r20) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socure.docv.capturesdk.core.processor.image.f.a(com.google.mlkit.vision.face.Face, float, float):com.socure.docv.capturesdk.core.processor.model.ProcessOutput");
    }

    public final boolean a(Face face, List<SelfieRange> selfieFaceAngleRanges) {
        Object obj;
        Object obj2;
        Object obj3;
        Intrinsics.checkNotNullParameter(face, "face");
        Intrinsics.checkNotNullParameter(selfieFaceAngleRanges, "selfieFaceAngleRanges");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SFP", "X: " + face.getHeadEulerAngleX() + ", Y: " + face.getHeadEulerAngleY() + ", Z: " + face.getHeadEulerAngleZ());
        Iterator<T> it = selfieFaceAngleRanges.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (((SelfieRange) obj2).getType() == SelfieRangeType.PITCH) {
                break;
            }
        }
        IntRange selfieRange = UtilsKt.getSelfieRange((SelfieRange) obj2);
        Iterator<T> it2 = selfieFaceAngleRanges.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it2.next();
            if (((SelfieRange) obj3).getType() == SelfieRangeType.ROLL) {
                break;
            }
        }
        IntRange selfieRange2 = UtilsKt.getSelfieRange((SelfieRange) obj3);
        Iterator<T> it3 = selfieFaceAngleRanges.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next = it3.next();
            if (((SelfieRange) next).getType() == SelfieRangeType.YAW) {
                obj = next;
                break;
            }
        }
        IntRange selfieRange3 = UtilsKt.getSelfieRange((SelfieRange) obj);
        int first = selfieRange.getFirst();
        int last = selfieRange.getLast();
        int roundToInt = MathKt.roundToInt(face.getHeadEulerAngleX());
        if (first <= roundToInt && roundToInt <= last) {
            int first2 = selfieRange2.getFirst();
            int last2 = selfieRange2.getLast();
            int roundToInt2 = MathKt.roundToInt(face.getHeadEulerAngleY());
            if (first2 <= roundToInt2 && roundToInt2 <= last2) {
                int first3 = selfieRange3.getFirst();
                int last3 = selfieRange3.getLast();
                int roundToInt3 = MathKt.roundToInt(face.getHeadEulerAngleZ());
                if (first3 <= roundToInt3 && roundToInt3 <= last3) {
                    return true;
                }
            }
        }
        return false;
    }

    public final GuidingBox b() {
        return this.f392a.i().getGuidingBox();
    }

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.b
    public IResult a(Bitmap bitmap, CaptureType captureType) {
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.a aVar;
        Rect boundingBox;
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.a aVar2;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(captureType, "captureType");
        long currentTimeMillis = System.currentTimeMillis();
        ImageUtils imageUtils = ImageUtils.INSTANCE;
        Bitmap downScaledBitmap = imageUtils.getDownScaledBitmap(bitmap, 300);
        CaptureType captureType2 = CaptureType.AUTO_ANALYSIS;
        if (captureType == captureType2 && (aVar2 = this.e) != null) {
            aVar2.a(downScaledBitmap);
        }
        com.socure.docv.capturesdk.core.extractor.c cVar = new com.socure.docv.capturesdk.core.extractor.c(downScaledBitmap, new a(), 1);
        this.b = cVar;
        Face a2 = cVar.a(350L);
        Bitmap bitmap2 = null;
        Float[] fArr = (a2 == null || (boundingBox = a2.getBoundingBox()) == null) ? null : new Float[]{Float.valueOf(boundingBox.left), Float.valueOf(boundingBox.top), Float.valueOf(0.0f), Float.valueOf(boundingBox.right), Float.valueOf(boundingBox.top), Float.valueOf(0.0f), Float.valueOf(boundingBox.right), Float.valueOf(boundingBox.bottom), Float.valueOf(0.0f), Float.valueOf(boundingBox.left), Float.valueOf(boundingBox.bottom), Float.valueOf(0.0f)};
        if (fArr != null && Utils.INSTANCE.showDebugImage$capturesdk_productionRelease()) {
            float[] floatArray = ArraysKt.toFloatArray(fArr);
            com.socure.docv.capturesdk.common.logger.b.b("SDLT_SFP", "bitmapWithCorners");
            if (this.c != null && this.d != null) {
                GuidingBox b = b();
                Float f = this.c;
                Intrinsics.checkNotNull(f);
                float floatValue = f.floatValue();
                Float f2 = this.d;
                Intrinsics.checkNotNull(f2);
                bitmap2 = imageUtils.getSelfieDebugBmp(downScaledBitmap, floatArray, b, floatValue, f2.floatValue());
            }
        } else {
            com.socure.docv.capturesdk.common.logger.b.b("SDLT_SFP", "Not creating debug image");
        }
        if (captureType == captureType2 && (aVar = this.e) != null) {
            if (bitmap2 == null) {
                bitmap2 = downScaledBitmap;
            }
            aVar.a(bitmap2);
        }
        ProcessOutput a3 = a(a2, downScaledBitmap.getWidth(), downScaledBitmap.getHeight());
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_SFP", "processing time: " + (System.currentTimeMillis() - currentTimeMillis));
        return a3;
    }

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.b
    public void a() {
        com.socure.docv.capturesdk.core.extractor.c cVar = this.b;
        if (cVar != null) {
            cVar.c.close();
        }
    }
}
