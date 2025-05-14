package com.socure.docv.capturesdk.core.processor.image;

import android.graphics.Bitmap;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.processor.model.DetectionMetric;
import com.socure.docv.capturesdk.core.processor.model.DetectionType;
import com.socure.docv.capturesdk.core.processor.model.IResult;
import com.socure.docv.capturesdk.core.processor.model.ProcessOutput;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d implements com.socure.docv.capturesdk.core.processor.interfaces.b {

    /* renamed from: a, reason: collision with root package name */
    public final com.socure.docv.capturesdk.di.c f390a;
    public com.socure.docv.capturesdk.core.processor.interfaces.b b;
    public com.socure.docv.capturesdk.core.processor.interfaces.a c;

    public d(com.socure.docv.capturesdk.di.c dependencyGraph) {
        Intrinsics.checkNotNullParameter(dependencyGraph, "dependencyGraph");
        this.f390a = dependencyGraph;
    }

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.b
    public IResult a(Bitmap bitmap, CaptureType captureType) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(captureType, "captureType");
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, 112, 112, true);
        e eVar = new e(this.f390a);
        this.b = eVar;
        Intrinsics.checkNotNullExpressionValue(scaledBitmap, "scaledBitmap");
        IResult a2 = eVar.a(scaledBitmap, captureType);
        boolean z = captureType == CaptureType.AUTO;
        if (!a2.getMetric().getCheckPassed()) {
            com.socure.docv.capturesdk.common.logger.b.c("SDLT_GD", "No need to check glare, there isn't enough light intensity");
            if (!z) {
                scaledBitmap.recycle();
            }
            return new ProcessOutput(new DetectionMetric(DetectionType.GLARE, true, Double.valueOf(1.0d), null, null, 0.0f, z ? scaledBitmap : null, null, null, null, 952, null), null, null, 6, null);
        }
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_GD", "Checking glare");
        com.socure.docv.capturesdk.core.external.ml.impl.c cVar = new com.socure.docv.capturesdk.core.external.ml.impl.c(this.f390a);
        this.c = cVar;
        float[] a3 = cVar.a(scaledBitmap);
        if (!z) {
            scaledBitmap.recycle();
        }
        return new ProcessOutput(new DetectionMetric(DetectionType.GLARE, a3[0] <= this.f390a.b().a().getConfidence(), Double.valueOf(1.0d - a3[0]), null, null, 0.0f, z ? scaledBitmap : null, null, null, null, 952, null), null, null, 6, null);
    }

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.b
    public void a() {
        com.socure.docv.capturesdk.core.processor.interfaces.b bVar = this.b;
        if (bVar != null) {
            bVar.a();
        }
        com.socure.docv.capturesdk.core.processor.interfaces.a aVar = this.c;
        if (aVar != null) {
            aVar.a();
        }
    }
}
