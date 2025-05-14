package com.socure.docv.capturesdk.common.utils;

import android.content.Context;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;
import com.socure.docv.capturesdk.common.logger.b;
import com.socure.docv.capturesdk.common.utils.FeedManager;
import com.socure.docv.capturesdk.feature.scanner.data.FrameGenerator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\r\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0010\u0012J\b\u0010)\u001a\u00020\u0011H\u0002J\b\u0010*\u001a\u00020\u0011H\u0016J\u0006\u0010+\u001a\u00020\u0011J\b\u0010,\u001a\u00020\u0011H\u0016J\u000e\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/J(\u00100\u001a\u00020\u00112 \u00101\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0018\u000103j\u0004\u0018\u0001`4\u0012\u0004\u0012\u00020\u001102J\u000e\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u000207R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/socure/docv/capturesdk/common/utils/CameraManager;", "Lcom/socure/docv/capturesdk/common/utils/FeedManager;", "manualCaptureOnly", "", "context", "Landroid/content/Context;", "previewView", "Landroidx/camera/view/PreviewView;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "lensFacing", "", "cropCoordinates", "", "", "onStreaming", "Lkotlin/Function0;", "", "(ZLandroid/content/Context;Landroidx/camera/view/PreviewView;Landroidx/lifecycle/LifecycleOwner;ILjava/util/List;Lkotlin/jvm/functions/Function0;)V", "cameraExecutor", "Ljava/util/concurrent/ExecutorService;", "getCameraExecutor", "()Ljava/util/concurrent/ExecutorService;", "cameraExecutor$delegate", "Lkotlin/Lazy;", "cameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "cameraSelector", "Landroidx/camera/core/CameraSelector;", "getCameraSelector", "()Landroidx/camera/core/CameraSelector;", "cameraSelector$delegate", "getCropCoordinates", "()Ljava/util/List;", "imageAnalysis", "Landroidx/camera/core/ImageAnalysis;", "imageCapture", "Landroidx/camera/core/ImageCapture;", "preview", "Landroidx/camera/core/Preview;", "screenAspectRatio", "bindCameraUseCases", "clear", "clearAnalyzer", "freeze", "setAnalyzer", "analyzer", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "setCamera", "cameraStartListener", "Lkotlin/Function2;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "takePicture", "captureListener", "Landroidx/camera/core/ImageCapture$OnImageCapturedCallback;", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraManager implements FeedManager {

    /* renamed from: cameraExecutor$delegate, reason: from kotlin metadata */
    private final Lazy cameraExecutor;
    private ProcessCameraProvider cameraProvider;

    /* renamed from: cameraSelector$delegate, reason: from kotlin metadata */
    private final Lazy cameraSelector;
    private final Context context;
    private final List<List<Double>> cropCoordinates;
    private ImageAnalysis imageAnalysis;
    private ImageCapture imageCapture;
    private final LifecycleOwner lifecycleOwner;
    private final boolean manualCaptureOnly;
    private final Function0<Unit> onStreaming;
    private Preview preview;
    private final PreviewView previewView;
    private final int screenAspectRatio;

    public CameraManager(boolean z, Context context, PreviewView previewView, LifecycleOwner lifecycleOwner, final int i, List<List<Double>> cropCoordinates, Function0<Unit> onStreaming) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(previewView, "previewView");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cropCoordinates, "cropCoordinates");
        Intrinsics.checkNotNullParameter(onStreaming, "onStreaming");
        this.manualCaptureOnly = z;
        this.context = context;
        this.previewView = previewView;
        this.lifecycleOwner = lifecycleOwner;
        this.cropCoordinates = cropCoordinates;
        this.onStreaming = onStreaming;
        this.cameraExecutor = LazyKt.lazy(new Function0<ExecutorService>() { // from class: com.socure.docv.capturesdk.common.utils.CameraManager$cameraExecutor$2
            @Override // kotlin.jvm.functions.Function0
            public final ExecutorService invoke() {
                return Executors.newSingleThreadExecutor();
            }
        });
        this.cameraSelector = LazyKt.lazy(new Function0<CameraSelector>() { // from class: com.socure.docv.capturesdk.common.utils.CameraManager$cameraSelector$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CameraSelector invoke() {
                CameraSelector build = new CameraSelector.Builder().requireLensFacing(i).build();
                Intrinsics.checkNotNullExpressionValue(build, "Builder().requireLensFacing(lensFacing).build()");
                return build;
            }
        });
        this.screenAspectRatio = 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00d2, code lost:
    
        if (r8.bindToLifecycle(r9, r10, r11) == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void bindCameraUseCases() {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socure.docv.capturesdk.common.utils.CameraManager.bindCameraUseCases():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindCameraUseCases$lambda-3, reason: not valid java name */
    public static final void m958bindCameraUseCases$lambda3(CameraManager this$0, PreviewView.StreamState streamState) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (streamState == PreviewView.StreamState.STREAMING) {
            this$0.onStreaming.invoke();
        }
    }

    private final ExecutorService getCameraExecutor() {
        Object value = this.cameraExecutor.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-cameraExecutor>(...)");
        return (ExecutorService) value;
    }

    private final CameraSelector getCameraSelector() {
        return (CameraSelector) this.cameraSelector.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: setCamera$lambda-0, reason: not valid java name */
    public static final void m959setCamera$lambda0(CameraManager this$0, ListenableFuture cameraProviderFuture, Function2 cameraStartListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cameraProviderFuture, "$cameraProviderFuture");
        Intrinsics.checkNotNullParameter(cameraStartListener, "$cameraStartListener");
        V v = cameraProviderFuture.get();
        Intrinsics.checkNotNullExpressionValue(v, "cameraProviderFuture.get()");
        this$0.cameraProvider = (ProcessCameraProvider) v;
        try {
            this$0.bindCameraUseCases();
            cameraStartListener.invoke(Boolean.TRUE, null);
        } catch (Exception e) {
            b.a("SDLT_CM", "setCamera exception");
            cameraStartListener.invoke(Boolean.FALSE, e);
        }
    }

    @Override // com.socure.docv.capturesdk.common.utils.FeedManager
    public void clear() {
        b.a("SDLT_CM", "clear");
        ProcessCameraProvider processCameraProvider = this.cameraProvider;
        if (processCameraProvider != null) {
            if (processCameraProvider == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cameraProvider");
                processCameraProvider = null;
            }
            processCameraProvider.unbindAll();
        }
        getCameraExecutor().shutdown();
        this.previewView.getPreviewStreamState().removeObservers(this.lifecycleOwner);
        Preview preview = this.preview;
        if (preview != null) {
            if (preview == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preview");
                preview = null;
            }
            preview.setSurfaceProvider(null);
        }
    }

    public final void clearAnalyzer() {
        ImageAnalysis imageAnalysis = this.imageAnalysis;
        if (imageAnalysis != null) {
            imageAnalysis.clearAnalyzer();
        }
    }

    @Override // com.socure.docv.capturesdk.common.utils.FeedManager
    public void freeze() {
        ProcessCameraProvider processCameraProvider = this.cameraProvider;
        Preview preview = null;
        if (processCameraProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraProvider");
            processCameraProvider = null;
        }
        UseCase[] useCaseArr = new UseCase[1];
        Preview preview2 = this.preview;
        if (preview2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preview");
        } else {
            preview = preview2;
        }
        useCaseArr[0] = preview;
        processCameraProvider.unbind(useCaseArr);
    }

    @Override // com.socure.docv.capturesdk.common.utils.FeedManager
    public List<List<Double>> getCropCoordinates() {
        return this.cropCoordinates;
    }

    @Override // com.socure.docv.capturesdk.common.utils.FeedManager
    public FrameGenerator getFrameGenerator() {
        return FeedManager.DefaultImpls.getFrameGenerator(this);
    }

    public final void setAnalyzer(ImageAnalysis.Analyzer analyzer) {
        Intrinsics.checkNotNullParameter(analyzer, "analyzer");
        ImageAnalysis imageAnalysis = this.imageAnalysis;
        if (imageAnalysis != null) {
            imageAnalysis.setAnalyzer(getCameraExecutor(), analyzer);
        }
    }

    public final void setCamera(final Function2<? super Boolean, ? super Exception, Unit> cameraStartListener) {
        Intrinsics.checkNotNullParameter(cameraStartListener, "cameraStartListener");
        b.a("SDLT_CM", "setCamera");
        final ListenableFuture<ProcessCameraProvider> processCameraProvider = ProcessCameraProvider.getInstance(this.context);
        Intrinsics.checkNotNullExpressionValue(processCameraProvider, "getInstance(context)");
        processCameraProvider.addListener(new Runnable() { // from class: com.socure.docv.capturesdk.common.utils.CameraManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                CameraManager.m959setCamera$lambda0(CameraManager.this, processCameraProvider, cameraStartListener);
            }
        }, ContextCompat.getMainExecutor(this.context));
    }

    public final void takePicture(ImageCapture.OnImageCapturedCallback captureListener) {
        Intrinsics.checkNotNullParameter(captureListener, "captureListener");
        b.c("SDLT_CM", "takePicture called on imageCapture");
        ImageCapture imageCapture = this.imageCapture;
        if (imageCapture == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageCapture");
            imageCapture = null;
        }
        imageCapture.m137lambda$takePicture$3$androidxcameracoreImageCapture(getCameraExecutor(), captureListener);
    }
}
