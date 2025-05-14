package com.socure.docv.capturesdk.core.decision;

import android.graphics.Bitmap;
import com.socure.docv.capturesdk.core.processor.model.DetectionMetric;
import com.socure.docv.capturesdk.core.processor.model.Output;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public Output f358a;

    public final void a(Output output) {
        output.getFinalBitmap().recycle();
        output.getMetrics().clear();
        Bitmap debugBitmap = output.getDebugBitmap();
        if (debugBitmap != null) {
            debugBitmap.recycle();
        }
        output.setDebugBitmap(null);
        for (DetectionMetric detectionMetric : output.getMetrics()) {
            Bitmap modelInputImage = detectionMetric.getModelInputImage();
            if (modelInputImage != null) {
                modelInputImage.recycle();
            }
            detectionMetric.setModelInputImage(null);
        }
    }

    public final double b(Output output) {
        double d = 0.0d;
        for (DetectionMetric detectionMetric : output.getMetrics()) {
            Double outputMeasure = detectionMetric.getOutputMeasure();
            if (outputMeasure != null) {
                double doubleValue = outputMeasure.doubleValue();
                if (doubleValue >= 0.0d) {
                    d += detectionMetric.getDetectionType().getWeight() * doubleValue;
                }
            }
        }
        return d;
    }
}
