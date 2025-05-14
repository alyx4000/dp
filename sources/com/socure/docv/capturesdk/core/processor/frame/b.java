package com.socure.docv.capturesdk.core.processor.frame;

import android.graphics.Bitmap;
import com.socure.docv.capturesdk.common.utils.Utils;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.core.processor.model.ProcessResult;
import com.socure.docv.capturesdk.feature.scanner.data.Container;
import com.socure.docv.capturesdk.feature.scanner.data.GuidingBox;
import com.socure.docv.capturesdk.feature.scanner.data.ViewDimensions;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes5.dex */
public final class b implements com.socure.docv.capturesdk.core.processor.interfaces.b {

    /* renamed from: a, reason: collision with root package name */
    public final com.socure.docv.capturesdk.di.c f385a;
    public final ScanType b;
    public com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.a c;
    public final com.socure.docv.capturesdk.core.processor.interfaces.a d;
    public final float e;

    public b(com.socure.docv.capturesdk.di.c dependencyGraph, ScanType scanType) {
        Intrinsics.checkNotNullParameter(dependencyGraph, "dependencyGraph");
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        this.f385a = dependencyGraph;
        this.b = scanType;
        this.d = new com.socure.docv.capturesdk.core.external.ml.impl.b(dependencyGraph);
        this.e = dependencyGraph.a().a().getConfidence();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.util.List] */
    public static final void a(Ref.ObjectRef<Bitmap> objectRef, Ref.ObjectRef<Bitmap> objectRef2, Ref.ObjectRef<Pair<float[], float[]>> objectRef3, Ref.ObjectRef<List<Float>> objectRef4, ProcessResult processResult) {
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_CD", "updateFields called");
        objectRef.element = processResult.getOutputBitmap();
        objectRef2.element = processResult.getModelProcessedBitmap();
        objectRef3.element = processResult.getModelProcessedRawData();
        objectRef4.element = processResult.getModelList();
    }

    public final ViewDimensions a(GuidingBox guidingBox) {
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_CD", "getGuidingViewDimension called");
        return new ViewDimensions(new Container((int) guidingBox.getParentDimension().getW(), (int) guidingBox.getParentDimension().getH()), UtilsKt.getScaledGuidingBoxArea(guidingBox, 0.04f), false, 4, null);
    }

    public final Pair<float[], float[]> a(Bitmap bitmap) {
        Pair<float[], float[]> separateHorizontalConfArray$capturesdk_productionRelease;
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_CD", "processBitmap called");
        long currentTimeMillis = System.currentTimeMillis();
        float[] a2 = this.d.a(bitmap);
        Pair<float[], float[]> pair = (a2 == null || (separateHorizontalConfArray$capturesdk_productionRelease = Utils.INSTANCE.separateHorizontalConfArray$capturesdk_productionRelease(a2)) == null) ? null : new Pair<>(separateHorizontalConfArray$capturesdk_productionRelease.getFirst(), separateHorizontalConfArray$capturesdk_productionRelease.getSecond());
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_CD", "timeTaken: " + (System.currentTimeMillis() - currentTimeMillis));
        return pair;
    }

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.b
    public void a() {
        this.d.a();
    }

    public final void a(CaptureType captureType, Bitmap bitmap, Bitmap bitmap2) {
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.a aVar;
        if (captureType != CaptureType.AUTO_ANALYSIS || (aVar = this.c) == null) {
            return;
        }
        if (bitmap == null) {
            bitmap = bitmap2;
        }
        aVar.a(bitmap);
    }

    public final boolean a(List<Float> modelOutputList) {
        Intrinsics.checkNotNullParameter(modelOutputList, "modelOutputList");
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_CD", "isValidCoordinates called");
        return (modelOutputList.isEmpty() ^ true) && Utils.INSTANCE.cornersFound$capturesdk_productionRelease(CollectionsKt.toFloatArray(modelOutputList));
    }

    public final boolean a(Pair<float[], float[]> pair) {
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_CD", "isRotationRequired called");
        return pair != null && pair.getFirst()[0] < this.e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x007b, code lost:
    
        if (r15 == null) goto L12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.socure.docv.capturesdk.core.processor.frame.b] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r15v4, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r15v45 */
    /* JADX WARN: Type inference failed for: r15v46 */
    /* JADX WARN: Type inference failed for: r1v58, types: [T, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v10, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v6, types: [T, kotlin.Pair] */
    @Override // com.socure.docv.capturesdk.core.processor.interfaces.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.socure.docv.capturesdk.core.processor.model.ProcessOutput a(android.graphics.Bitmap r39, com.socure.docv.capturesdk.core.pipeline.model.CaptureType r40) {
        /*
            Method dump skipped, instructions count: 2186
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socure.docv.capturesdk.core.processor.frame.b.a(android.graphics.Bitmap, com.socure.docv.capturesdk.core.pipeline.model.CaptureType):com.socure.docv.capturesdk.core.processor.model.ProcessOutput");
    }

    public final GuidingBox b() {
        return this.f385a.i().getGuidingBox();
    }
}
