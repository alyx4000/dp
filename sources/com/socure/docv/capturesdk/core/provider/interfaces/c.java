package com.socure.docv.capturesdk.core.provider.interfaces;

import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.feature.scanner.data.ViewDimensions;

/* loaded from: classes5.dex */
public interface c {
    void freeze();

    void startGeneratingFrame();

    void stopGeneratingFrame();

    void takePicture(CaptureType captureType, int i, ViewDimensions viewDimensions, a aVar);

    void toggleAnalysisMode(boolean z);

    void updateViewDimensions(ViewDimensions viewDimensions);
}
