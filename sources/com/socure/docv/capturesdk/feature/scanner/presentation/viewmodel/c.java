package com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.camera.core.ImageCaptureException;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.socure.docv.capturesdk.api.ResponseCode;
import com.socure.docv.capturesdk.common.network.model.stepup.ExtractedStepUpData;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadEndRequest;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadImage;
import com.socure.docv.capturesdk.common.upload.m;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import com.socure.docv.capturesdk.common.utils.FeedManager;
import com.socure.docv.capturesdk.common.utils.ScannerDurationStore;
import com.socure.docv.capturesdk.common.utils.Screen;
import com.socure.docv.capturesdk.common.utils.Utils;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.core.processor.model.CaptureMetadata;
import com.socure.docv.capturesdk.core.processor.model.DetectionMetric;
import com.socure.docv.capturesdk.core.processor.model.DetectionType;
import com.socure.docv.capturesdk.core.processor.model.Output;
import com.socure.docv.capturesdk.feature.scanner.data.DetectionCallback;
import com.socure.docv.capturesdk.feature.scanner.data.Dimension;
import com.socure.docv.capturesdk.feature.scanner.data.ErrorScenario;
import com.socure.docv.capturesdk.feature.scanner.data.ImageMode;
import com.socure.docv.capturesdk.feature.scanner.data.ViewDimensions;
import io.sentry.protocol.SentryThread;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* loaded from: classes5.dex */
public final class c extends AndroidViewModel implements com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.a {
    public static final /* synthetic */ int u = 0;

    /* renamed from: a, reason: collision with root package name */
    public final com.socure.docv.capturesdk.di.c f529a;
    public final Screen b;
    public final boolean c;
    public final MutableLiveData<DetectionCallback> d;
    public final MutableLiveData<Pair<List<Float>, Dimension>> e;
    public final MutableLiveData<Output> f;
    public final MutableLiveData<Pair<ImageMode, Bitmap>> g;
    public final MutableLiveData<Pair<ErrorScenario, String>> h;
    public final MutableLiveData<com.socure.docv.capturesdk.common.upload.g<Object>> i;
    public final MutableLiveData<m<Object>> j;
    public final Lazy k;
    public final Lazy l;
    public com.socure.docv.capturesdk.feature.scanner.b m;
    public int n;
    public int o;
    public int p;
    public final ScannerDurationStore q;
    public final ScanType r;
    public CaptureType s;
    public final CoroutineExceptionHandler t;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f530a;

        static {
            int[] iArr = new int[CaptureType.values().length];
            iArr[CaptureType.AUTO.ordinal()] = 1;
            iArr[CaptureType.MANUAL.ordinal()] = 2;
            f530a = iArr;
        }
    }

    /* renamed from: com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c$c, reason: collision with other inner class name */
    public static final class C0048c extends Lambda implements Function0<com.socure.docv.capturesdk.core.decision.a> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0048c f532a = new C0048c();

        public C0048c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public com.socure.docv.capturesdk.core.decision.a invoke() {
            return new com.socure.docv.capturesdk.core.decision.a();
        }
    }

    public static final class d extends Lambda implements Function0<com.socure.docv.capturesdk.feature.scanner.a> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public com.socure.docv.capturesdk.feature.scanner.a invoke() {
            return new com.socure.docv.capturesdk.feature.scanner.a(c.this.c());
        }
    }

    public static final class e extends Lambda implements Function0<com.socure.docv.capturesdk.core.pipeline.c> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public com.socure.docv.capturesdk.core.pipeline.c invoke() {
            c cVar = c.this;
            return new com.socure.docv.capturesdk.core.pipeline.c(cVar.f529a, cVar.r, cVar);
        }
    }

    public static final class f extends Lambda implements Function1<Bitmap, Unit> {
        public f() {
            super(1);
        }

        public final void a(Bitmap bitmap) {
            Object obj;
            if (bitmap != null) {
                c cVar = c.this;
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_SVM", cVar.r + " frame received: " + bitmap.getWidth() + ViewHierarchyNode.JsonKeys.X + bitmap.getHeight() + " | " + Utils.INSTANCE.getBytesToHr(bitmap.getByteCount()) + " | on thread: " + Thread.currentThread().getName());
                Pair<List<DetectionMetric>, DetectionCallback> a2 = ((com.socure.docv.capturesdk.feature.scanner.a) cVar.l.getValue()).a(bitmap);
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_SVM", "frame analysed on thread: " + Thread.currentThread().getName());
                Iterator<T> it = a2.getFirst().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (((DetectionMetric) obj).getDetectionType() == DetectionType.CORNER) {
                            break;
                        }
                    }
                }
                c.a(cVar, (DetectionMetric) obj);
                cVar.a(a2.getSecond());
                if (a2.getSecond() == DetectionCallback.CAPTURING) {
                    com.socure.docv.capturesdk.common.logger.b.c("SDLT_SVM", "\n++++++++ INITIATING AUTO CAPTURE! +++++++");
                    cVar.a(3, CaptureType.AUTO);
                }
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
            a(bitmap);
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Bitmap, Unit> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bitmap bitmap) {
            c.this.g.setValue(new Pair<>(ImageMode.PREVIEW, bitmap));
            return Unit.INSTANCE;
        }
    }

    public static final class h extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f537a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(CoroutineExceptionHandler.Companion companion, c cVar) {
            super(companion);
            this.f537a = cVar;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext coroutineContext, Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "Exception handled: " + th.getLocalizedMessage(), null, 4, null);
            this.f537a.j.postValue(new m.b(ResponseCode.UNKNOWN_ERROR, "exceptionHandler: " + Log.getStackTraceString(th)));
        }
    }

    public static final class i extends Lambda implements Function1<ApiResponse, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.socure.docv.capturesdk.common.upload.a f538a;
        public final /* synthetic */ c b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(com.socure.docv.capturesdk.common.upload.a aVar, c cVar) {
            super(1);
            this.f538a = aVar;
            this.b = cVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ApiResponse apiResponse) {
            ApiResponse it = apiResponse;
            Intrinsics.checkNotNullParameter(it, "it");
            if (it.getStatusCode() != ResponseCode.SUCCESS.getCode()) {
                this.f538a.a(UtilsKt.getEventErrorData(it.getHttpCode(), it.getHttpMsg(), it.getStatusCode(), it.getStatusMsg(), it.getApiType().getEndpoint()));
                this.b.j.postValue(new m.a(it));
            } else {
                this.b.j.postValue(new m.c(com.socure.docv.capturesdk.common.upload.f.UploadEnd, it));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(com.socure.docv.capturesdk.di.c dependencyGraph, Screen screen) {
        super(dependencyGraph.c());
        Intrinsics.checkNotNullParameter(dependencyGraph, "dependencyGraph");
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.f529a = dependencyGraph;
        this.b = screen;
        this.c = UtilsKt.isOldOs() || UtilsKt.lowRamDevice();
        this.d = new MutableLiveData<>();
        this.e = new MutableLiveData<>();
        this.f = new MutableLiveData<>();
        this.g = new MutableLiveData<>();
        this.h = new MutableLiveData<>();
        this.i = new MutableLiveData<>();
        this.j = new MutableLiveData<>();
        this.k = LazyKt.lazy(new e());
        this.l = LazyKt.lazy(new d());
        this.q = new ScannerDurationStore(System.currentTimeMillis());
        this.r = screen.getScanType();
        this.t = new h(CoroutineExceptionHandler.INSTANCE, this);
    }

    public static final void a(c cVar, DetectionMetric detectionMetric) {
        Unit unit;
        Dimension processedBitmapDimension;
        cVar.getClass();
        if (detectionMetric == null || (processedBitmapDimension = detectionMetric.getProcessedBitmapDimension()) == null) {
            unit = null;
        } else {
            cVar.e.postValue(new Pair<>(detectionMetric.getRegionList(), processedBitmapDimension));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            cVar.e.postValue(new Pair<>(CollectionsKt.emptyList(), new Dimension(0.0d, 0.0d)));
        }
    }

    @Override // com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.a
    public void a(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (bitmap.isRecycled()) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "recycled bitmap received in showImage - IGNORING", null, 4, null);
        } else {
            this.g.postValue(new Pair<>(ImageMode.DEBUG, bitmap));
        }
    }

    public final void a(CaptureType captureType, ImageCaptureException imageCaptureException) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "captureMaxErrorHandling captureType: " + captureType + " || ex: " + imageCaptureException);
        int i2 = a.f530a[captureType.ordinal()];
        if (i2 == 1) {
            this.o++;
        } else if (i2 != 2) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "captureMaxErrorHandling unhandled captureType: " + captureType);
        } else {
            this.n++;
        }
        if (a()) {
            int i3 = this.p + 1;
            this.p = i3;
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "bothErrorsMaxed count: " + i3, null, 4, null);
            e();
            this.h.postValue(new Pair<>(ErrorScenario.CONTINUOUS_ERRORS_MAXED, "bothErrorsMaxed: " + this.p + " | " + Log.getStackTraceString(imageCaptureException)));
        }
    }

    public final void a(DetectionCallback detectionCallback) {
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_SVM", "sendNotProcessing :" + detectionCallback);
        this.d.postValue(detectionCallback);
    }

    public final void a(boolean z) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "updateBarcodeStateInPipeline called - skipBarcode: " + z + " ");
        c().a(z);
    }

    public final void a(boolean z, FeedManager feedManager) {
        Intrinsics.checkNotNullParameter(feedManager, "feedManager");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "setFrameProvider called - videoFeed: " + z + " ");
        this.m = new com.socure.docv.capturesdk.feature.scanner.b(z, feedManager, this.r, this.f529a.i(), new f(), new g());
    }

    public final boolean a() {
        int i2 = this.o;
        boolean z = i2 >= 10 && this.n >= 3;
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "checkForMaxError - bothMaxed: " + z + " | autoCaptureFailure: " + i2 + " | manualCaptureFailure: " + this.n);
        return z;
    }

    public final void b() {
        this.d.postValue(DetectionCallback.NOT_PROCESSING);
        this.e.postValue(new Pair<>(CollectionsKt.emptyList(), new Dimension(0.0d, 0.0d)));
        this.f.postValue(null);
        this.g.postValue(new Pair<>(ImageMode.DEBUG, null));
        this.h.postValue(null);
    }

    public final com.socure.docv.capturesdk.core.pipeline.c c() {
        return (com.socure.docv.capturesdk.core.pipeline.c) this.k.getValue();
    }

    public final void d() {
        a((this.r == ScanType.SELFIE || this.c) ? 1 : 2, CaptureType.MANUAL);
    }

    public final void e() {
        this.o = 0;
        this.n = 0;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "onCleared called. bothErrorsMaxed count: " + this.p);
        Iterator<Map.Entry<DetectionType, com.socure.docv.capturesdk.core.processor.interfaces.b>> it = c().d.f382a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
        super.onCleared();
    }

    public final void a(int i2, CaptureType captureType) {
        c cVar = this;
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "captureFrames - captureType?: " + captureType.getValue() + ", captureCount: " + i2 + ", manualCaptureOnly: " + cVar.c);
        Lazy lazy = LazyKt.lazy(C0048c.f532a);
        Ref.IntRef intRef = new Ref.IntRef();
        int i3 = cVar.c ? 1 : i2;
        if (1 > i3) {
            return;
        }
        int i4 = 1;
        while (true) {
            com.socure.docv.capturesdk.feature.scanner.b bVar = cVar.m;
            if (bVar != null) {
                ViewDimensions viewDimensions = cVar.f529a.i();
                b captureListener = new b(intRef, this, captureType, i3, lazy, i2);
                Intrinsics.checkNotNullParameter(captureType, "captureType");
                Intrinsics.checkNotNullParameter(viewDimensions, "viewDimensions");
                Intrinsics.checkNotNullParameter(captureListener, "captureListener");
                com.socure.docv.capturesdk.core.provider.interfaces.c cVar2 = bVar.d;
                if (cVar2 != null) {
                    cVar2.takePicture(captureType, i4, viewDimensions, captureListener);
                }
            }
            if (i4 == i3) {
                return;
            }
            i4++;
            cVar = this;
        }
    }

    public final void a(LinkedHashMap<ScanType, UploadImage> uploadImageMap, com.socure.docv.capturesdk.common.upload.a eventUpdater) {
        Intrinsics.checkNotNullParameter(uploadImageMap, "uploadImageMap");
        Intrinsics.checkNotNullParameter(eventUpdater, "eventUpdater");
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_SVM", "updateEndUpload called");
        UploadEndRequest uploadEndRequest = new UploadEndRequest(null, null, null, null, 15, null);
        com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
        uploadEndRequest.setDocumentsUuid(com.socure.docv.capturesdk.common.session.a.e);
        uploadEndRequest.setDocumentsReferenceId(com.socure.docv.capturesdk.common.session.a.f);
        uploadEndRequest.setDocumentVerificationToken(aVar.e());
        ExtractedStepUpData baseExtractedDataForEnd = Utils.INSTANCE.getBaseExtractedDataForEnd(uploadImageMap);
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "uploadResult extractedData: " + (baseExtractedDataForEnd != null ? baseExtractedDataForEnd.toString() : null));
        uploadEndRequest.setDocumentInfo(baseExtractedDataForEnd);
        com.socure.docv.capturesdk.common.upload.e eVar = new com.socure.docv.capturesdk.common.upload.e(this.f529a.g().b(), CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(this.t)), uploadEndRequest);
        i finalResultCallback = new i(eventUpdater, this);
        Intrinsics.checkNotNullParameter(finalResultCallback, "finalResultCallback");
        BuildersKt__Builders_commonKt.launch$default(eVar.f321a, null, null, new com.socure.docv.capturesdk.common.upload.d(eVar, finalResultCallback, null), 3, null);
    }

    public static final class b implements com.socure.docv.capturesdk.core.provider.interfaces.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f531a;
        public final /* synthetic */ c b;
        public final /* synthetic */ CaptureType c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Lazy<com.socure.docv.capturesdk.core.decision.a> e;
        public final /* synthetic */ int f;

        public b(Ref.IntRef intRef, c cVar, CaptureType captureType, int i, Lazy<com.socure.docv.capturesdk.core.decision.a> lazy, int i2) {
            this.f531a = intRef;
            this.b = cVar;
            this.c = captureType;
            this.d = i;
            this.e = lazy;
            this.f = i2;
        }

        @Override // com.socure.docv.capturesdk.core.provider.interfaces.a
        public void a(int i, Bitmap bitmap, CaptureMetadata captureMetadata, Bitmap bitmap2) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Intrinsics.checkNotNullParameter(captureMetadata, "captureMetadata");
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "captured callback - currentCount: " + i);
            this.f531a.element = 0;
            this.b.e();
            c cVar = this.b;
            if (cVar.c) {
                Output output = new Output(bitmap, this.c, null, false, null, bitmap2, 28, null);
                output.setCaptureMetadata(captureMetadata);
                this.b.f.postValue(output);
                return;
            }
            Output next = cVar.c().a(bitmap, this.c);
            next.setCaptureMetadata(captureMetadata);
            Object obj = null;
            if (next.getFinalStatus() || this.c == CaptureType.MANUAL) {
                if (this.c == CaptureType.MANUAL && bitmap2 != null && !bitmap2.isRecycled()) {
                    com.socure.docv.capturesdk.common.logger.b.b("SDLT_SVM", "Added manual debug image to output");
                    next.setDebugBitmap(bitmap2);
                }
                com.socure.docv.capturesdk.core.decision.a value = this.e.getValue();
                value.getClass();
                Intrinsics.checkNotNullParameter(next, "next");
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_BIS", "Add called");
                Output output2 = value.f358a;
                if (output2 == null) {
                    value.f358a = next;
                } else {
                    if (value.b(next) > value.b(output2)) {
                        Output output3 = value.f358a;
                        if (output3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(SentryThread.JsonKeys.CURRENT);
                            output3 = null;
                        }
                        value.a(output3);
                        value.f358a = next;
                    } else {
                        value.a(next);
                    }
                }
            } else {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "Not adding image to best image selector - finalStatus: " + next.getFinalStatus(), null, 4, null);
            }
            if (this.c != CaptureType.MANUAL) {
                c cVar2 = this.b;
                Iterator<T> it = next.getMetrics().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next2 = it.next();
                    if (((DetectionMetric) next2).getDetectionType() == DetectionType.CORNER) {
                        obj = next2;
                        break;
                    }
                }
                c.a(cVar2, (DetectionMetric) obj);
            }
            if (i == this.d) {
                b();
            }
        }

        public final void b() {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "handleLastCapture");
            Lazy<com.socure.docv.capturesdk.core.decision.a> lazy = this.e;
            int i = c.u;
            Output output = lazy.getValue().f358a;
            Unit unit = null;
            if (output == null) {
                output = null;
            }
            if (output != null) {
                c cVar = this.b;
                if (output.getFinalBitmap().isRecycled()) {
                    com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "output finalBitmap is Recycled ", null, 4, null);
                    a();
                } else {
                    com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "We have a good scan from BIM");
                    cVar.f.postValue(output);
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "Bim didn't have a good image, starting analysis mode again");
                a();
            }
        }

        public final void a() {
            com.socure.docv.capturesdk.core.provider.interfaces.c cVar;
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "enableAnalysisOnCaptureError called with openCvSupported: " + ConstantsKt.getOPEN_CV_SUPPORTED());
            if (ConstantsKt.getOPEN_CV_SUPPORTED()) {
                if (this.c == CaptureType.MANUAL) {
                    this.b.h.postValue(new Pair<>(ErrorScenario.REMOVE_BLOCKER_MANUAL_CAPTURE_FAILED, "remove blocker as manual capture failed"));
                } else {
                    this.b.h.postValue(new Pair<>(ErrorScenario.REMOVE_BLOCKER_AUTO_CAPTURE_FAILED, "remove blocker as auto capture failed"));
                }
                c cVar2 = this.b;
                cVar2.getClass();
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "toggleToAnalysisMode");
                com.socure.docv.capturesdk.feature.scanner.b bVar = cVar2.m;
                if (bVar == null || (cVar = bVar.d) == null) {
                    return;
                }
                cVar.toggleAnalysisMode(true);
                return;
            }
            this.b.h.postValue(new Pair<>(ErrorScenario.MANUAL_FAILED, "Capture failed in manual mode"));
        }

        @Override // com.socure.docv.capturesdk.core.provider.interfaces.a
        public void a(int i, ImageCaptureException exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "error currentCount: " + i + " || error: " + exception.getMessage());
            if (i == this.f) {
                com.socure.docv.capturesdk.common.logger.b.c("SDLT_SVM", "Captures finished");
                b();
            }
            Ref.IntRef intRef = this.f531a;
            int i2 = intRef.element + 1;
            intRef.element = i2;
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "errorCountCapture : " + i2);
            int i3 = this.f531a.element;
            int i4 = this.f;
            if (i3 == i4) {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "error errorCountCapture : " + i3 + " || captureCount: " + i4);
                c cVar = this.b;
                CaptureType captureType = this.c;
                int i5 = c.u;
                cVar.a(captureType, exception);
            }
        }
    }
}
