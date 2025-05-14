package com.socure.docv.capturesdk.core.processor.image;

import android.graphics.Bitmap;
import androidx.core.view.PointerIconCompat;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.processor.model.DetectionMetric;
import com.socure.docv.capturesdk.core.processor.model.DetectionType;
import com.socure.docv.capturesdk.core.processor.model.IResult;
import com.socure.docv.capturesdk.core.processor.model.ProcessOutput;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class e implements com.socure.docv.capturesdk.core.processor.interfaces.b {

    /* renamed from: a, reason: collision with root package name */
    public final com.socure.docv.capturesdk.di.c f391a;

    public e(com.socure.docv.capturesdk.di.c dependencyGraph) {
        Intrinsics.checkNotNullParameter(dependencyGraph, "dependencyGraph");
        this.f391a = dependencyGraph;
    }

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.b
    public IResult a(Bitmap bitmap, CaptureType captureType) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(captureType, "captureType");
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, 112, 112, true);
        com.socure.docv.capturesdk.core.external.ml.impl.d dVar = new com.socure.docv.capturesdk.core.external.ml.impl.d(this.f391a);
        Intrinsics.checkNotNullExpressionValue(scaledBitmap, "scaledBitmap");
        float[] a2 = dVar.a(scaledBitmap);
        scaledBitmap.recycle();
        return new ProcessOutput(new DetectionMetric(DetectionType.GLARE, this.f391a.h().a().getConfidence() < a2[0], null, null, null, 0.0f, null, null, null, null, PointerIconCompat.TYPE_GRAB, null), null, null, 6, null);
    }

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.b
    public void a() {
        this.f391a.h().a().getModel().close();
    }
}
