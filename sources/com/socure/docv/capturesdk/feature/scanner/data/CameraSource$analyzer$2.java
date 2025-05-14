package com.socure.docv.capturesdk.feature.scanner.data;

import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import com.socure.docv.capturesdk.common.logger.b;
import com.socure.docv.capturesdk.common.utils.ImageUtils;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraSource$analyzer$2 extends Lambda implements Function0<ImageAnalysis.Analyzer> {
    public final /* synthetic */ CameraSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraSource$analyzer$2(CameraSource cameraSource) {
        super(0);
        this.this$0 = cameraSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0, reason: not valid java name */
    public static final void m963invoke$lambda0(CameraSource this$0, ImageProxy it) {
        Function1 function1;
        ScanType scanType;
        ViewDimensions viewDimensions;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        b.b("SDLT_CS", "imageProxy received in analyzer: h:" + it.getHeight() + ", w:" + it.getWidth());
        function1 = this$0.listener;
        ImageUtils imageUtils = ImageUtils.INSTANCE;
        scanType = this$0.scanType;
        CaptureType captureType = CaptureType.AUTO_ANALYSIS;
        viewDimensions = this$0.viewDimensions;
        function1.invoke(imageUtils.getBitmapFromImageProxy(it, scanType, captureType, viewDimensions).getFirst());
        b.b("SDLT_CS", "now imageProxy is getting closed in analyzer");
        it.close();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ImageAnalysis.Analyzer invoke() {
        final CameraSource cameraSource = this.this$0;
        return new ImageAnalysis.Analyzer() { // from class: com.socure.docv.capturesdk.feature.scanner.data.CameraSource$analyzer$2$$ExternalSyntheticLambda0
            @Override // androidx.camera.core.ImageAnalysis.Analyzer
            public final void analyze(ImageProxy imageProxy) {
                CameraSource$analyzer$2.m963invoke$lambda0(CameraSource.this, imageProxy);
            }
        };
    }
}
