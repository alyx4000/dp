package com.socure.docv.capturesdk.core.processor.image;

import android.graphics.Bitmap;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.processor.model.DetectionMetric;
import com.socure.docv.capturesdk.core.processor.model.DetectionType;
import com.socure.docv.capturesdk.core.processor.model.IResult;
import com.socure.docv.capturesdk.core.processor.model.ProcessOutput;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b implements com.socure.docv.capturesdk.core.processor.interfaces.b {

    /* renamed from: a, reason: collision with root package name */
    public final com.socure.docv.capturesdk.di.c f388a;
    public com.socure.docv.capturesdk.core.processor.interfaces.a b;

    public b(com.socure.docv.capturesdk.di.c dependencyGraph) {
        Intrinsics.checkNotNullParameter(dependencyGraph, "dependencyGraph");
        this.f388a = dependencyGraph;
    }

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.b
    public IResult a(Bitmap bitmap, CaptureType captureType) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(captureType, "captureType");
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, 300, 180, true);
        com.socure.docv.capturesdk.core.external.ml.impl.a aVar = new com.socure.docv.capturesdk.core.external.ml.impl.a(this.f388a);
        this.b = aVar;
        Intrinsics.checkNotNullExpressionValue(scaledBitmap, "scaledBitmap");
        float[] a2 = aVar.a(scaledBitmap);
        boolean z = captureType == CaptureType.AUTO;
        if (!z) {
            scaledBitmap.recycle();
        }
        DetectionType detectionType = DetectionType.BLUR;
        boolean z2 = a2[0] <= this.f388a.d().a().getConfidence();
        Double valueOf = Double.valueOf(1.0d - a2[0]);
        if (!z) {
            scaledBitmap = null;
        }
        return new ProcessOutput(new DetectionMetric(detectionType, z2, valueOf, null, null, 0.0f, scaledBitmap, null, null, null, 952, null), null, null, 6, null);
    }

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.b
    public void a() {
        com.socure.docv.capturesdk.core.processor.interfaces.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }
}
