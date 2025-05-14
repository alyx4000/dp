package com.socure.docv.capturesdk.feature.scanner.data;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.socure.docv.capturesdk.common.logger.b;
import com.socure.docv.capturesdk.common.utils.CameraManager;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import com.socure.docv.capturesdk.common.utils.ImageUtils;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.core.processor.model.CaptureMetadata;
import com.socure.docv.capturesdk.core.processor.model.Resolution;
import com.socure.docv.capturesdk.core.provider.interfaces.a;
import com.socure.docv.capturesdk.core.provider.interfaces.c;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00020\"¢\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016J(\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R&\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010!R \u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/socure/docv/capturesdk/feature/scanner/data/CameraSource;", "Lcom/socure/docv/capturesdk/core/provider/interfaces/c;", "", "clearAnalyzer", "setAnalyzer", "startGeneratingFrame", "Lcom/socure/docv/capturesdk/core/pipeline/model/CaptureType;", "captureType", "", "currentCount", "Lcom/socure/docv/capturesdk/feature/scanner/data/ViewDimensions;", "viewDimensions", "Lcom/socure/docv/capturesdk/core/provider/interfaces/a;", "captureListener", "takePicture", "", "enable", "toggleAnalysisMode", "stopGeneratingFrame", "updateViewDimensions", "freeze", "Lcom/socure/docv/capturesdk/common/utils/CameraManager;", "cameraManager", "Lcom/socure/docv/capturesdk/common/utils/CameraManager;", "", "", "cropViewCoordinates", "Ljava/util/List;", "getCropViewCoordinates", "()Ljava/util/List;", "Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;", "scanType", "Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;", "Lcom/socure/docv/capturesdk/feature/scanner/data/ViewDimensions;", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/jvm/functions/Function1;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "analyzer$delegate", "Lkotlin/Lazy;", "getAnalyzer", "()Landroidx/camera/core/ImageAnalysis$Analyzer;", "analyzer", "getFrameListener", "()Lkotlin/jvm/functions/Function1;", "frameListener", "<init>", "(Lcom/socure/docv/capturesdk/common/utils/CameraManager;Ljava/util/List;Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;Lcom/socure/docv/capturesdk/feature/scanner/data/ViewDimensions;Lkotlin/jvm/functions/Function1;)V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class CameraSource implements c {

    /* renamed from: analyzer$delegate, reason: from kotlin metadata */
    private final Lazy analyzer;
    private final CameraManager cameraManager;
    private final List<List<Double>> cropViewCoordinates;
    private final Function1<Bitmap, Unit> listener;
    private final ScanType scanType;
    private ViewDimensions viewDimensions;

    /* JADX WARN: Multi-variable type inference failed */
    public CameraSource(CameraManager cameraManager, List<List<Double>> cropViewCoordinates, ScanType scanType, ViewDimensions viewDimensions, Function1<? super Bitmap, Unit> listener) {
        Intrinsics.checkNotNullParameter(cameraManager, "cameraManager");
        Intrinsics.checkNotNullParameter(cropViewCoordinates, "cropViewCoordinates");
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(viewDimensions, "viewDimensions");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.cameraManager = cameraManager;
        this.cropViewCoordinates = cropViewCoordinates;
        this.scanType = scanType;
        this.viewDimensions = viewDimensions;
        this.listener = listener;
        this.analyzer = LazyKt.lazy(new CameraSource$analyzer$2(this));
    }

    private final void clearAnalyzer() {
        this.cameraManager.clearAnalyzer();
    }

    private final ImageAnalysis.Analyzer getAnalyzer() {
        return (ImageAnalysis.Analyzer) this.analyzer.getValue();
    }

    private final void setAnalyzer() {
        this.cameraManager.setAnalyzer(getAnalyzer());
    }

    @Override // com.socure.docv.capturesdk.core.provider.interfaces.c
    public void freeze() {
        this.cameraManager.freeze();
    }

    public List<List<Double>> getCropViewCoordinates() {
        return this.cropViewCoordinates;
    }

    public Function1<Bitmap, Unit> getFrameListener() {
        return this.listener;
    }

    @Override // com.socure.docv.capturesdk.core.provider.interfaces.c
    public void startGeneratingFrame() {
        b.a("SDLT_CS", "startGeneratingFrame");
        if (ConstantsKt.getOPEN_CV_SUPPORTED() || this.scanType == ScanType.SELFIE) {
            setAnalyzer();
        } else {
            b.a("SDLT_CS", "Not adding analyzer for selfie - openCvSupported: " + ConstantsKt.getOPEN_CV_SUPPORTED());
        }
    }

    @Override // com.socure.docv.capturesdk.core.provider.interfaces.c
    public void stopGeneratingFrame() {
        clearAnalyzer();
    }

    @Override // com.socure.docv.capturesdk.core.provider.interfaces.c
    public void takePicture(final CaptureType captureType, final int currentCount, final ViewDimensions viewDimensions, final a captureListener) {
        Intrinsics.checkNotNullParameter(captureType, "captureType");
        Intrinsics.checkNotNullParameter(viewDimensions, "viewDimensions");
        Intrinsics.checkNotNullParameter(captureListener, "captureListener");
        toggleAnalysisMode(false);
        this.cameraManager.takePicture(new ImageCapture.OnImageCapturedCallback() { // from class: com.socure.docv.capturesdk.feature.scanner.data.CameraSource$takePicture$1
            @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
            public void onCaptureSuccess(ImageProxy imageProxy) {
                ScanType scanType;
                Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
                CaptureMetadata captureMetadata = new CaptureMetadata(CaptureType.this, new Resolution(imageProxy.getWidth(), imageProxy.getHeight()), currentCount, null, 8, null);
                b.a("SDLT_CS", "takePicture - onCaptureSuccess - captureMetadata: " + new Gson().toJson(captureMetadata));
                try {
                    ImageUtils imageUtils = ImageUtils.INSTANCE;
                    scanType = this.scanType;
                    Triple<Bitmap, Bitmap, Integer> bitmapFromImageProxy = imageUtils.getBitmapFromImageProxy(imageProxy, scanType, CaptureType.this, viewDimensions);
                    captureMetadata.setOriginalSize(bitmapFromImageProxy.getThird());
                    captureListener.a(currentCount, bitmapFromImageProxy.getFirst(), captureMetadata, bitmapFromImageProxy.getSecond());
                } catch (Throwable th) {
                    b.a("SDLT_CS", "takePicture ex: " + th.getLocalizedMessage(), null, 4, null);
                    b.b("SDLT_CS", "takePicture ex: " + Log.getStackTraceString(th));
                    a aVar = captureListener;
                    int i = currentCount;
                    String localizedMessage = th.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "getBitmapFromImageProxy ex";
                    }
                    aVar.a(i, new ImageCaptureException(0, localizedMessage, th));
                }
                imageProxy.close();
            }

            @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
            public void onError(ImageCaptureException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                captureListener.a(currentCount, exception);
            }
        });
    }

    @Override // com.socure.docv.capturesdk.core.provider.interfaces.c
    public void toggleAnalysisMode(boolean enable) {
        b.a("SDLT_CS", "toggleAnalysisMode - analysisMode: " + enable);
        if (enable) {
            setAnalyzer();
        } else {
            clearAnalyzer();
        }
    }

    @Override // com.socure.docv.capturesdk.core.provider.interfaces.c
    public void updateViewDimensions(ViewDimensions viewDimensions) {
        Intrinsics.checkNotNullParameter(viewDimensions, "viewDimensions");
        this.viewDimensions = viewDimensions;
    }
}
