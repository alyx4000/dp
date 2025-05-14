package com.socure.docv.capturesdk.feature.scanner.presentation.ui;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.FragmentKt;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.socure.docv.capturesdk.R;
import com.socure.docv.capturesdk.api.ResponseCode;
import com.socure.docv.capturesdk.common.analytics.model.Face;
import com.socure.docv.capturesdk.common.analytics.model.MetricCaptureData;
import com.socure.docv.capturesdk.common.network.model.stepup.App;
import com.socure.docv.capturesdk.common.network.model.stepup.PrimaryButton;
import com.socure.docv.capturesdk.common.network.model.stepup.UpdateStatusRequest;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadImage;
import com.socure.docv.capturesdk.common.upload.g;
import com.socure.docv.capturesdk.common.upload.m;
import com.socure.docv.capturesdk.common.utils.AnimationUtilsKt;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import com.socure.docv.capturesdk.common.utils.ApiUtilsKt;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import com.socure.docv.capturesdk.common.utils.FeedManager;
import com.socure.docv.capturesdk.common.utils.HeaderUtils;
import com.socure.docv.capturesdk.common.utils.HelpPreviewUtils;
import com.socure.docv.capturesdk.common.utils.ImageUtils;
import com.socure.docv.capturesdk.common.utils.Scanner;
import com.socure.docv.capturesdk.common.utils.Screen;
import com.socure.docv.capturesdk.common.utils.ScreenKt;
import com.socure.docv.capturesdk.common.utils.Utils;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.common.view.BrandLayout;
import com.socure.docv.capturesdk.common.view.CustomToolbar;
import com.socure.docv.capturesdk.common.view.GraphicOverlay;
import com.socure.docv.capturesdk.core.extractor.e;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.core.processor.model.DetectionMetric;
import com.socure.docv.capturesdk.core.processor.model.DetectionType;
import com.socure.docv.capturesdk.core.processor.model.FinalOutputProcessData;
import com.socure.docv.capturesdk.core.processor.model.Output;
import com.socure.docv.capturesdk.feature.base.presentation.ui.BaseFragment;
import com.socure.docv.capturesdk.feature.help.presentation.ui.HelpView;
import com.socure.docv.capturesdk.feature.preview.data.VerificationRecord;
import com.socure.docv.capturesdk.feature.preview.presentation.ui.PreviewView;
import com.socure.docv.capturesdk.feature.scanner.data.DetectionCallback;
import com.socure.docv.capturesdk.feature.scanner.data.Dimension;
import com.socure.docv.capturesdk.feature.scanner.data.ErrorScenario;
import com.socure.docv.capturesdk.feature.scanner.data.ImageMode;
import com.socure.docv.capturesdk.feature.scanner.data.TimeOutKeeper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SpreadBuilder;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import okhttp3.RequestBody;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/socure/docv/capturesdk/feature/scanner/presentation/ui/ScannerFragment;", "Lcom/socure/docv/capturesdk/feature/base/presentation/ui/BaseFragment;", "<init>", "()V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class ScannerFragment extends BaseFragment {
    public static final /* synthetic */ int C = 0;
    public String A;
    public final CoroutineExceptionHandler B;
    public com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c m;
    public com.socure.docv.capturesdk.databinding.g n;
    public FeedManager o;
    public final Lazy<Job> p;
    public final Lazy q;
    public Job r;
    public Job s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public long w;
    public final Lazy x;
    public final Lazy y;
    public Job z;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f496a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[DetectionCallback.values().length];
            iArr[DetectionCallback.LOW_BRIGHTNESS.ordinal()] = 1;
            iArr[DetectionCallback.GLARE_DETECTED.ordinal()] = 2;
            iArr[DetectionCallback.BLUR_DETECTED.ordinal()] = 3;
            iArr[DetectionCallback.CORNER_DETECTION_FAILED.ordinal()] = 4;
            iArr[DetectionCallback.BARCODE_NOT_FOUND.ordinal()] = 5;
            iArr[DetectionCallback.FACE_NOT_FOUND.ordinal()] = 6;
            iArr[DetectionCallback.FACE_TOO_SMALL.ordinal()] = 7;
            iArr[DetectionCallback.FACE_ORIENTATION_WRONG.ordinal()] = 8;
            iArr[DetectionCallback.READY_FOR_SELFIE_CAPTURE.ordinal()] = 9;
            iArr[DetectionCallback.FACE_AT_LEFT.ordinal()] = 10;
            iArr[DetectionCallback.FACE_AT_RIGHT.ordinal()] = 11;
            iArr[DetectionCallback.FACE_AT_UP.ordinal()] = 12;
            iArr[DetectionCallback.FACE_AT_DOWN.ordinal()] = 13;
            iArr[DetectionCallback.FACE_IS_BIG.ordinal()] = 14;
            iArr[DetectionCallback.CAPTURING.ordinal()] = 15;
            iArr[DetectionCallback.DOCUMENT_TOO_CLOSE.ordinal()] = 16;
            iArr[DetectionCallback.NOT_PROCESSING.ordinal()] = 17;
            f496a = iArr;
            int[] iArr2 = new int[ScanType.values().length];
            iArr2[ScanType.LICENSE_FRONT.ordinal()] = 1;
            iArr2[ScanType.LICENSE_BACK.ordinal()] = 2;
            iArr2[ScanType.PASSPORT.ordinal()] = 3;
            iArr2[ScanType.SELFIE.ordinal()] = 4;
            b = iArr2;
            int[] iArr3 = new int[ImageMode.values().length];
            iArr3[ImageMode.DEBUG.ordinal()] = 1;
            c = iArr3;
        }
    }

    public static final class b extends Lambda implements Function0<BottomSheetBehavior<ConstraintLayout>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public BottomSheetBehavior<ConstraintLayout> invoke() {
            com.socure.docv.capturesdk.databinding.g gVar = ScannerFragment.this.n;
            Intrinsics.checkNotNull(gVar);
            return BottomSheetBehavior.from(gVar.d.e);
        }
    }

    public static final class c extends Lambda implements Function0<com.socure.docv.capturesdk.feature.scanner.presentation.ui.b> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public com.socure.docv.capturesdk.feature.scanner.presentation.ui.b invoke() {
            return new com.socure.docv.capturesdk.feature.scanner.presentation.ui.b(ScannerFragment.this);
        }
    }

    public static final class d extends Lambda implements Function0<Job> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Job invoke() {
            ScannerFragment scannerFragment = ScannerFragment.this;
            boolean isAutomationFlavor$capturesdk_productionRelease = Utils.INSTANCE.isAutomationFlavor$capturesdk_productionRelease();
            int i = ScannerFragment.C;
            LifecycleOwner viewLifecycleOwner = scannerFragment.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            return BuildersKt.launch(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getMain().plus(scannerFragment.B), CoroutineStart.LAZY, new com.socure.docv.capturesdk.feature.scanner.presentation.ui.a(scannerFragment, isAutomationFlavor$capturesdk_productionRelease, null));
        }
    }

    public static final class e extends Lambda implements Function0<Long> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Long invoke() {
            long j;
            if (ScannerFragment.c(ScannerFragment.this)) {
                j = 0;
            } else {
                com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
                j = com.socure.docv.capturesdk.common.session.a.h;
            }
            return Long.valueOf(j);
        }
    }

    public static final class f extends Lambda implements Function1<String, Unit> {
        public f() {
            super(1);
        }

        public final void a(String eventTitle) {
            Intrinsics.checkNotNullParameter(eventTitle, "eventTitle");
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "event triggered " + eventTitle);
            int i = ScannerFragment.C;
            ScannerFragment.this.a(eventTitle, new Pair[0]);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            a(str);
            return Unit.INSTANCE;
        }
    }

    public static final class g implements com.socure.docv.capturesdk.common.view.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreviewView f502a;
        public final /* synthetic */ ScannerFragment b;
        public final /* synthetic */ Output c;
        public final /* synthetic */ FinalOutputProcessData d;
        public final /* synthetic */ long e;

        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f503a;

            static {
                int[] iArr = new int[com.socure.docv.capturesdk.common.view.model.a.values().length];
                iArr[com.socure.docv.capturesdk.common.view.model.a.DEBUG_IMAGE_SAVE.ordinal()] = 1;
                iArr[com.socure.docv.capturesdk.common.view.model.a.CONTINUE.ordinal()] = 2;
                iArr[com.socure.docv.capturesdk.common.view.model.a.RETAKE.ordinal()] = 3;
                f503a = iArr;
            }
        }

        public g(PreviewView previewView, ScannerFragment scannerFragment, Output output, FinalOutputProcessData finalOutputProcessData, long j) {
            this.f502a = previewView;
            this.b = scannerFragment;
            this.c = output;
            this.d = finalOutputProcessData;
            this.e = j;
        }

        @Override // com.socure.docv.capturesdk.common.view.a
        public void a(com.socure.docv.capturesdk.common.view.model.a bsCallbackType, String str) {
            String str2;
            String str3;
            Intrinsics.checkNotNullParameter(bsCallbackType, "bsCallbackType");
            int i = a.f503a[bsCallbackType.ordinal()];
            if (i == 1) {
                Context context = this.f502a.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ScannerFragment scannerFragment = this.b;
                int i2 = ScannerFragment.C;
                new com.socure.docv.capturesdk.feature.preview.helper.a(context, scannerFragment.c(), this.c.getMetrics()).a();
                return;
            }
            com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar = null;
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                ScannerFragment scannerFragment2 = this.b;
                com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar2 = scannerFragment2.m;
                if (cVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    cVar2 = null;
                }
                cVar2.j.removeObservers(scannerFragment2.getViewLifecycleOwner());
                com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar3 = scannerFragment2.m;
                if (cVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    cVar3 = null;
                }
                cVar3.i.removeObservers(scannerFragment2.getViewLifecycleOwner());
                com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar4 = scannerFragment2.m;
                if (cVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    cVar4 = null;
                }
                cVar4.j.postValue(null);
                cVar4.i.postValue(null);
                com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar5 = this.b.m;
                if (cVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    cVar5 = null;
                }
                cVar5.q.setCaptureStartFromRetake();
                BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior = this.b.f();
                Intrinsics.checkNotNullExpressionValue(bottomSheetBehavior, "bottomSheetBehavior");
                ExtensionsKt.hide(bottomSheetBehavior);
                if (str != null) {
                    ScannerFragment scannerFragment3 = this.b;
                    ScanType c = scannerFragment3.c();
                    com.socure.docv.capturesdk.common.analytics.a a2 = scannerFragment3.a();
                    com.socure.docv.capturesdk.databinding.g gVar = scannerFragment3.n;
                    Intrinsics.checkNotNull(gVar);
                    Pair<String, List<Pair<String, String>>> retakeEvent = UtilsKt.getRetakeEvent(c, a2, str, gVar.d.d.getF464a());
                    String first = retakeEvent.getFirst();
                    Object[] array = retakeEvent.getSecond().toArray(new Pair[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    Pair[] pairArr = (Pair[]) array;
                    scannerFragment3.a(first, (Pair<String, String>[]) Arrays.copyOf(pairArr, pairArr.length));
                }
                if (com.socure.docv.capturesdk.common.session.a.f305a.c().getWebsdk().getPersistCaptureState().getValue()) {
                    com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "persistCaptureState is true");
                    com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar6 = this.b.m;
                    if (cVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        cVar = cVar6;
                    }
                    if (cVar.s == CaptureType.MANUAL) {
                        this.b.i().resetRemaining(Scanner.CAMERA_SETUP_DELAY_MS);
                    } else {
                        this.b.i().resetRemaining(((Number) this.b.t.getValue()).longValue() + Scanner.CAMERA_SETUP_DELAY_MS);
                    }
                } else {
                    com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "persistCaptureState is false");
                }
                this.b.r();
                return;
            }
            Context requireContext = this.b.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            if (UtilsKt.isTalkBackEnabled(requireContext)) {
                ScannerFragment.a(this.b, com.socure.docv.capturesdk.common.session.a.f305a.b().getAccessibility().getValidatingImage(), false, 2, null);
            }
            ScannerFragment.a(this.b).count();
            ScannerFragment scannerFragment4 = this.b;
            ScanType c2 = scannerFragment4.c();
            Output output = this.c;
            com.socure.docv.capturesdk.core.extractor.model.a data = this.d.getData();
            ArrayList<Face> face = this.d.getFace();
            int totalAttempts = ScannerFragment.a(this.b).getTotalAttempts();
            boolean isTotalAttemptReached = ScannerFragment.a(this.b).isTotalAttemptReached();
            int maxSubmitCount = ScannerFragment.a(this.b).getMaxSubmitCount();
            long j = this.e;
            Utils utils = Utils.INSTANCE;
            Pair<UploadImage, List<Pair<String, String>>> outputAndMetaData$capturesdk_productionRelease = utils.getOutputAndMetaData$capturesdk_productionRelease(c2, output, data);
            if (utils.isSelfie$capturesdk_productionRelease(c2)) {
                String replacePlaceholders$capturesdk_productionRelease = utils.replacePlaceholders$capturesdk_productionRelease(output.getCaptureType() == CaptureType.MANUAL ? "[Document_Type]_[Capture_Type]_success_manual" : "[Document_Type]_[Capture_Type]_success", c2, scannerFragment4.a());
                Object[] array2 = outputAndMetaData$capturesdk_productionRelease.getSecond().toArray(new Pair[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                Pair[] pairArr2 = (Pair[]) array2;
                scannerFragment4.a(replacePlaceholders$capturesdk_productionRelease, (Pair<String, String>[]) Arrays.copyOf(pairArr2, pairArr2.length));
            } else {
                String replacePlaceholders$capturesdk_productionRelease2 = utils.replacePlaceholders$capturesdk_productionRelease(output.getCaptureType() == CaptureType.MANUAL ? "[Document_Type]_[Capture_Type]_scan_success_manual" : "[Document_Type]_[Capture_Type]_scan_success", c2, scannerFragment4.a());
                Object[] array3 = outputAndMetaData$capturesdk_productionRelease.getSecond().toArray(new Pair[0]);
                Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                Pair[] pairArr3 = (Pair[]) array3;
                scannerFragment4.a(replacePlaceholders$capturesdk_productionRelease2, (Pair<String, String>[]) Arrays.copyOf(pairArr3, pairArr3.length));
            }
            com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar7 = scannerFragment4.m;
            if (cVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar7 = null;
            }
            UploadImage uploadImage = outputAndMetaData$capturesdk_productionRelease.getFirst();
            ArrayList<Screen> screenFlow = scannerFragment4.b().d();
            com.socure.docv.capturesdk.databinding.g gVar2 = scannerFragment4.n;
            Intrinsics.checkNotNull(gVar2);
            long f464a = gVar2.d.d.getF464a();
            com.socure.docv.capturesdk.feature.scanner.presentation.ui.b eventUpdater = scannerFragment4.g();
            cVar7.getClass();
            Intrinsics.checkNotNullParameter(uploadImage, "uploadImage");
            Intrinsics.checkNotNullParameter(screenFlow, "screenFlow");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(eventUpdater, "eventUpdater");
            com.socure.docv.capturesdk.common.logger.b.b("SDLT_SVM", "uploadImage called");
            com.socure.docv.capturesdk.common.network.repository.e uploadRepository = cVar7.f529a.g().a();
            RequestBody docTypeRequestBody = UtilsKt.getDocumentTypeBody(screenFlow);
            com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
            String str4 = com.socure.docv.capturesdk.common.session.a.d;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ApiConstant.CONSENT_ID);
                str4 = null;
            }
            RequestBody consentIdRequestBody = ApiUtilsKt.toTextPlainBody(str4);
            Intrinsics.checkNotNullParameter(uploadRepository, "uploadRepository");
            Intrinsics.checkNotNullParameter(docTypeRequestBody, "docTypeRequestBody");
            Intrinsics.checkNotNullParameter(consentIdRequestBody, "consentIdRequestBody");
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            UtilsKt.appendUploadCommonEventParams(arrayList, uploadImage, screenFlow, isTotalAttemptReached, totalAttempts, maxSubmitCount);
            if (!UtilsKt.isUploadUrlAppendRequired(cVar7.b, com.socure.docv.capturesdk.common.session.a.e) || (str3 = com.socure.docv.capturesdk.common.session.a.e) == null || (str2 = UtilsKt.appendUploadUrl(str3)) == null) {
                str2 = ApiConstant.UPLOAD_URL;
            }
            String uploadUrl = str2;
            CoroutineScope uploadCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(cVar7.t));
            com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.e uploadProcessorCallback = new com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.e(uploadImage, screenFlow, arrayList, eventUpdater, cVar7, currentTimeMillis, isTotalAttemptReached, j, f464a, output, face);
            Intrinsics.checkNotNullParameter(uploadCoroutineScope, "uploadCoroutineScope");
            Intrinsics.checkNotNullParameter(uploadUrl, "uploadUrl");
            Intrinsics.checkNotNullParameter(uploadImage, "uploadImage");
            Intrinsics.checkNotNullParameter(uploadProcessorCallback, "uploadProcessorCallback");
            com.socure.docv.capturesdk.common.logger.b.b("SDLT_UP", "uploadImage called");
            uploadProcessorCallback.a();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            HeaderUtils headerUtils = HeaderUtils.INSTANCE;
            linkedHashMap.putAll(headerUtils.getPrimaryHeader(aVar.d()));
            linkedHashMap.putAll(headerUtils.getStepHeader(aVar.e()));
            linkedHashMap.put(ApiConstant.VALIDATE_IMAGE, String.valueOf(isTotalAttemptReached));
            BuildersKt__Builders_commonKt.launch$default(uploadCoroutineScope, null, null, new com.socure.docv.capturesdk.common.upload.j(new com.socure.docv.capturesdk.common.upload.n(linkedHashMap, uploadUrl, docTypeRequestBody, consentIdRequestBody, uploadRepository, uploadImage), uploadProcessorCallback, null), 3, null);
        }
    }

    public static final class h implements com.socure.docv.capturesdk.core.extractor.d {
        public final /* synthetic */ Output b;
        public final /* synthetic */ long c;

        public h(Output output, long j) {
            this.b = output;
            this.c = j;
        }

        @Override // com.socure.docv.capturesdk.core.extractor.d
        public void a(FinalOutputProcessData finalOutputProcessData) {
            Intrinsics.checkNotNullParameter(finalOutputProcessData, "finalOutputProcessData");
            if (ScannerFragment.b(ScannerFragment.this)) {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", ScannerFragment.this.b, null, 4, null);
                return;
            }
            Pair<String, List<Pair<String, String>>> eventDataFromExtractedData = UtilsKt.getEventDataFromExtractedData(ScannerFragment.this.c(), finalOutputProcessData);
            ImageUtils imageUtils = ImageUtils.INSTANCE;
            Float imageRotatableAngle = imageUtils.getImageRotatableAngle(finalOutputProcessData);
            if (imageRotatableAngle != null) {
                Output output = this.b;
                Bitmap rotateBitmap$capturesdk_productionRelease = imageUtils.rotateBitmap$capturesdk_productionRelease(output.getFinalBitmap(), imageRotatableAngle.floatValue());
                output.getFinalBitmap().recycle();
                output.setFinalBitmap(rotateBitmap$capturesdk_productionRelease);
            }
            if (eventDataFromExtractedData != null) {
                ScannerFragment scannerFragment = ScannerFragment.this;
                String first = eventDataFromExtractedData.getFirst();
                Object[] array = eventDataFromExtractedData.getSecond().toArray(new Pair[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                Pair[] pairArr = (Pair[]) array;
                scannerFragment.a(first, (Pair<String, String>[]) Arrays.copyOf(pairArr, pairArr.length));
            }
            ScannerFragment.this.a(this.b, finalOutputProcessData, this.c);
        }
    }

    @DebugMetadata(c = "com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerFragment$setFrameProviderWithDelay$1", f = "ScannerFragment.kt", i = {0}, l = {540}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f505a;
        public /* synthetic */ Object b;
        public final /* synthetic */ long d;
        public final /* synthetic */ boolean e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(long j, boolean z, Continuation<? super i> continuation) {
            super(2, continuation);
            this.d = j;
            this.e = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            i iVar = ScannerFragment.this.new i(this.d, this.e, continuation);
            iVar.b = obj;
            return iVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            i iVar = ScannerFragment.this.new i(this.d, this.e, continuation);
            iVar.b = coroutineScope;
            return iVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f505a;
            com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar = null;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.b;
                Context requireContext = ScannerFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                if (UtilsKt.isTalkBackEnabled(requireContext)) {
                    ScannerFragment scannerFragment = ScannerFragment.this;
                    ScannerFragment.a(scannerFragment, UtilsKt.getInitialAnnouncement(scannerFragment.c(), com.socure.docv.capturesdk.common.session.a.f305a.b().getAccessibility(), ScannerFragment.this.e()), false, 2, null);
                }
                com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar2 = ScannerFragment.this.m;
                if (cVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    cVar2 = null;
                }
                cVar2.b();
                long j = this.d;
                this.b = coroutineScope2;
                this.f505a = 1;
                if (DelayKt.delay(j, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.b;
                ResultKt.throwOnFailure(obj);
            }
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                ScannerFragment scannerFragment2 = ScannerFragment.this;
                boolean z = this.e;
                int i2 = ScannerFragment.C;
                scannerFragment2.getClass();
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "setFrameProvider");
                FeedManager feedManager = scannerFragment2.o;
                if (feedManager != null) {
                    com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar3 = scannerFragment2.m;
                    if (cVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        cVar = cVar3;
                    }
                    cVar.a(z, feedManager);
                }
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "Calling startFrameGeneration and setupDetectionCallbacks");
                if (ScannerFragment.this.c() == ScanType.PASSPORT) {
                    com.socure.docv.capturesdk.databinding.g gVar = ScannerFragment.this.n;
                    Intrinsics.checkNotNull(gVar);
                    gVar.h.d();
                }
                if (ConstantsKt.getOPEN_CV_SUPPORTED()) {
                    ScannerFragment.this.p();
                }
                ScannerFragment.this.o();
                ScannerFragment.this.m();
                ScannerFragment.this.q();
                ScannerFragment.this.s();
            } else {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "frameProviderDelayJob called when not active", null, 4, null);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function0<Unit> {
        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "Disable the analysis when dialog is visible");
            ScannerFragment scannerFragment = ScannerFragment.this;
            Utils utils = Utils.INSTANCE;
            int i = ScannerFragment.C;
            scannerFragment.a(utils.replacePlaceholders$capturesdk_productionRelease("[Document_Type]_[Capture_Type]_help", scannerFragment.c(), ScannerFragment.this.a()), new Pair[0]);
            ScannerFragment.this.h("help shown");
            ScannerFragment scannerFragment2 = ScannerFragment.this;
            BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior = scannerFragment2.f();
            Intrinsics.checkNotNullExpressionValue(bottomSheetBehavior, "bottomSheetBehavior");
            if (ExtensionsKt.isNotVisible(bottomSheetBehavior)) {
                HelpPreviewUtils helpPreviewUtils = HelpPreviewUtils.INSTANCE;
                com.socure.docv.capturesdk.databinding.g gVar = scannerFragment2.n;
                Intrinsics.checkNotNull(gVar);
                HelpView helpView = gVar.d.c;
                Intrinsics.checkNotNullExpressionValue(helpView, "binding.bsContainer.helpView");
                com.socure.docv.capturesdk.databinding.g gVar2 = scannerFragment2.n;
                Intrinsics.checkNotNull(gVar2);
                helpPreviewUtils.setVisibilityFocus$capturesdk_productionRelease(helpView, gVar2);
                com.socure.docv.capturesdk.databinding.g gVar3 = scannerFragment2.n;
                Intrinsics.checkNotNull(gVar3);
                com.socure.docv.capturesdk.databinding.a aVar = gVar3.d;
                Object tag = aVar.c.getTag();
                Boolean bool = Boolean.TRUE;
                if (Intrinsics.areEqual(tag, bool)) {
                    com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "helpView is already initiated");
                } else {
                    aVar.c.setTag(bool);
                    aVar.c.a(helpPreviewUtils.getHelpViewUiData$capturesdk_productionRelease(scannerFragment2.c(), com.socure.docv.capturesdk.common.session.a.f305a.b()), new com.socure.docv.capturesdk.feature.scanner.presentation.ui.j(scannerFragment2));
                }
                scannerFragment2.e("help shown");
                BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior2 = scannerFragment2.f();
                Intrinsics.checkNotNullExpressionValue(bottomSheetBehavior2, "bottomSheetBehavior");
                ExtensionsKt.show(bottomSheetBehavior2);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Output b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(Output output) {
            super(0);
            this.b = output;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ScannerFragment scannerFragment = ScannerFragment.this;
            Output output = this.b;
            int i = ScannerFragment.C;
            scannerFragment.a(output);
            return Unit.INSTANCE;
        }
    }

    public static final class l extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScannerFragment f508a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(CoroutineExceptionHandler.Companion companion, ScannerFragment scannerFragment) {
            super(companion);
            this.f508a = scannerFragment;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext coroutineContext, Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "exceptionHandler called msg: " + Log.getStackTraceString(th), null, 4, null);
            if (th instanceof CancellationException) {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "CancellationException: cause - " + ((CancellationException) th).getLocalizedMessage());
                return;
            }
            ScannerFragment scannerFragment = this.f508a;
            Object[] array = CollectionsKt.listOf((Object[]) new Pair[]{new Pair("type", "unknown"), new Pair("message", Log.getStackTraceString(th))}).toArray(new Pair[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            Pair[] pairArr = (Pair[]) array;
            Pair<String, String>[] pairArr2 = (Pair[]) Arrays.copyOf(pairArr, pairArr.length);
            int i = ScannerFragment.C;
            scannerFragment.a("error", pairArr2);
            this.f508a.b().a(ResponseCode.UNKNOWN_ERROR);
        }
    }

    public static final class m extends Lambda implements Function0<TimeOutKeeper> {
        public m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TimeOutKeeper invoke() {
            return new TimeOutKeeper(((Number) ScannerFragment.this.t.getValue()).longValue() + Scanner.CAMERA_SETUP_DELAY_MS);
        }
    }

    public static final class n extends Lambda implements Function0<VerificationRecord> {
        public n() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public VerificationRecord invoke() {
            ScannerFragment scannerFragment = ScannerFragment.this;
            int i = ScannerFragment.C;
            return new VerificationRecord(UtilsKt.getAttemptCount(scannerFragment.b().k(), com.socure.docv.capturesdk.common.session.a.f305a.c().getWebsdk(), 3));
        }
    }

    public ScannerFragment() {
        super("SDLT_SF");
        Lazy<Job> lazy = LazyKt.lazy(new d());
        this.p = lazy;
        this.q = lazy;
        this.t = LazyKt.lazy(new e());
        this.u = LazyKt.lazy(new m());
        this.v = LazyKt.lazy(new b());
        this.x = LazyKt.lazy(new n());
        this.y = LazyKt.lazy(new c());
        this.B = new l(CoroutineExceptionHandler.INSTANCE, this);
    }

    public static final VerificationRecord a(ScannerFragment scannerFragment) {
        return (VerificationRecord) scannerFragment.x.getValue();
    }

    public static final void a(ScannerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "Manual button clicked - calling capture and hiding manual button");
        this$0.b(true);
        Utils utils = Utils.INSTANCE;
        this$0.a("clicked", new Pair<>("type", "manual_button"), new Pair<>("facet_type", utils.getDocSelFacet$capturesdk_productionRelease(this$0.b().d(), this$0.c())));
        this$0.a("auto_capture_failed", new Pair<>("type", this$0.d(this$0.A)), new Pair<>("facet_type", utils.getDocSelFacet$capturesdk_productionRelease(this$0.b().d(), this$0.c())));
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar = this$0.m;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        cVar.d();
    }

    public static /* synthetic */ void a(ScannerFragment scannerFragment, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        scannerFragment.a(str, z);
    }

    public static final void b(ScannerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(UtilsKt.getCurrentScreenForScanner(this$0.c()).a());
    }

    public static final boolean b(ScannerFragment scannerFragment) {
        FragmentActivity activity = scannerFragment.getActivity();
        if (activity != null) {
            return activity.isFinishing();
        }
        return true;
    }

    public static final void c(ScannerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Utils utils = Utils.INSTANCE;
        this$0.a(utils.replacePlaceholders$capturesdk_productionRelease(utils.isSelfie$capturesdk_productionRelease(this$0.c()) ? "[Document_Type]_[Capture_Type]_canceled" : "[Document_Type]_[Capture_Type]_scan_canceled", this$0.c(), this$0.a()), this$0.d());
        int backwardNavActionId = this$0.b().a(UtilsKt.getCurrentScreenForScanner(this$0.c())).getBackwardNavActionId();
        if (backwardNavActionId == 0) {
            this$0.a(UtilsKt.getCurrentScreenForScanner(this$0.c()).a());
        } else {
            ExtensionsKt.safeNavigate(FragmentKt.findNavController(this$0), backwardNavActionId);
        }
    }

    public static final boolean c(ScannerFragment scannerFragment) {
        scannerFragment.getClass();
        return Utils.INSTANCE.isSelfie$capturesdk_productionRelease(ScreenKt.getCurrent(scannerFragment.b().d()).getScanType()) || scannerFragment.e();
    }

    public final void a(long j2, boolean z) {
        Job launch$default;
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "setFrameProviderWithDelay - delay: " + j2 + " | videoFeed: " + z);
        f("instantiation");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getMain().plus(this.B), null, new i(j2, z, null), 2, null);
        this.r = launch$default;
    }

    public final void a(ScanType scanType, com.socure.docv.capturesdk.common.view.model.c cVar) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "navigateToNextScan called: currentScanType: " + scanType + " || currentScreen: " + cVar);
        int forwardNavActionId = b().a(cVar).getForwardNavActionId();
        b().b(cVar);
        ExtensionsKt.safeNavigate(FragmentKt.findNavController(this), forwardNavActionId);
    }

    public final void b(String str) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "cameraLoadFailed: " + str, null, 4, null);
        a("camera_open_failed", d());
        b().h();
    }

    public final void c(String str) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "clearManualButtonJob called - cause: " + str);
        Job job = this.s;
        if (job != null) {
            JobKt__JobKt.cancel$default(job, str, null, 2, null);
        }
        this.s = null;
    }

    public final String d(String str) {
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar = this.m;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        if (!cVar.c) {
            Utils utils = Utils.INSTANCE;
            if (!utils.isSelfie$capturesdk_productionRelease(c())) {
                return (!ConstantsKt.getOPEN_CV_SUPPORTED() || utils.isAutomationFlavor$capturesdk_productionRelease()) ? !ConstantsKt.getOPEN_CV_SUPPORTED() ? "open_cv_not_supported" : "manual_automation" : str == null ? "manual_regular" : str;
            }
        }
        return Utils.INSTANCE.isSelfie$capturesdk_productionRelease(c()) ? c().getValue() : "manual_only";
    }

    public final void e(String str) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "pauseManualButtonVisibilityJob called - cause: " + str);
        i().pause();
        c(str);
    }

    public final BottomSheetBehavior<ConstraintLayout> f() {
        return (BottomSheetBehavior) this.v.getValue();
    }

    public final void f(String str) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "resetFrameProviderJob called - cause: " + str);
        Job job = this.r;
        if (job != null) {
            JobKt__JobKt.cancel$default(job, str, null, 2, null);
        }
        this.r = null;
    }

    public final com.socure.docv.capturesdk.feature.scanner.presentation.ui.b g() {
        return (com.socure.docv.capturesdk.feature.scanner.presentation.ui.b) this.y.getValue();
    }

    public final void g(String str) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "resetManualButtonVisibilityJob called - cause: " + str);
        i().reset();
        c(str);
        if (c() == ScanType.LICENSE_BACK) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "calling updateBarcodeStateInPipeline - add barcode check");
            com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar = this.m;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar = null;
            }
            cVar.a(false);
        }
    }

    public final Job h() {
        return (Job) this.q.getValue();
    }

    public final void h(String str) {
        com.socure.docv.capturesdk.core.provider.interfaces.c cVar;
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "resetScanner called - cause: " + str);
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "clearHelpGraphic called");
        com.socure.docv.capturesdk.databinding.g gVar = this.n;
        Intrinsics.checkNotNull(gVar);
        gVar.m.setVisibility(8);
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar2 = null;
        if (this.p.isInitialized() && h().isActive()) {
            Job.DefaultImpls.cancel$default(h(), (CancellationException) null, 1, (Object) null);
        }
        f(str);
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "clearFeed");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "stopFrameGeneration");
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar3 = this.m;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar3 = null;
        }
        com.socure.docv.capturesdk.feature.scanner.b bVar = cVar3.m;
        if (bVar != null && (cVar = bVar.d) != null) {
            cVar.stopGeneratingFrame();
        }
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "clearVmCallbacks");
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar4 = this.m;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar4 = null;
        }
        cVar4.d.removeObservers(getViewLifecycleOwner());
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar5 = this.m;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar5 = null;
        }
        cVar5.e.removeObservers(getViewLifecycleOwner());
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar6 = this.m;
        if (cVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar6 = null;
        }
        cVar6.f.removeObservers(getViewLifecycleOwner());
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar7 = this.m;
        if (cVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar7 = null;
        }
        cVar7.g.removeObservers(getViewLifecycleOwner());
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar8 = this.m;
        if (cVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar8 = null;
        }
        cVar8.h.removeObservers(getViewLifecycleOwner());
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "clearFeedManager");
        FeedManager feedManager = this.o;
        if (feedManager != null) {
            feedManager.clear();
        }
        this.o = null;
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar9 = this.m;
        if (cVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar9 = null;
        }
        cVar9.b();
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar10 = this.m;
        if (cVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cVar2 = cVar10;
        }
        cVar2.e();
        j();
        com.socure.docv.capturesdk.databinding.g gVar2 = this.n;
        Intrinsics.checkNotNull(gVar2);
        gVar2.f.a();
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "resetGuidingViews called");
        com.socure.docv.capturesdk.databinding.g gVar3 = this.n;
        Intrinsics.checkNotNull(gVar3);
        gVar3.h.setGuidingBoxTintColor(R.color.socure_white);
        com.socure.docv.capturesdk.databinding.g gVar4 = this.n;
        Intrinsics.checkNotNull(gVar4);
        gVar4.i.n = false;
        com.socure.docv.capturesdk.databinding.g gVar5 = this.n;
        Intrinsics.checkNotNull(gVar5);
        gVar5.i.a();
        b(false);
        com.socure.docv.capturesdk.databinding.g gVar6 = this.n;
        Intrinsics.checkNotNull(gVar6);
        gVar6.h.b();
        com.socure.docv.capturesdk.databinding.g gVar7 = this.n;
        Intrinsics.checkNotNull(gVar7);
        gVar7.e.a();
    }

    public final TimeOutKeeper i() {
        return (TimeOutKeeper) this.u.getValue();
    }

    public final void i(String str) {
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "showImageUploadProgress called");
        Pair<Integer, Integer> previewProgressButtonColors = HelpPreviewUtils.INSTANCE.getPreviewProgressButtonColors(str);
        com.socure.docv.capturesdk.databinding.g gVar = this.n;
        Intrinsics.checkNotNull(gVar);
        PreviewView previewView = gVar.d.d;
        com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
        previewView.c(aVar.b().getNewLabels().getValidatingImage());
        com.socure.docv.capturesdk.databinding.g gVar2 = this.n;
        Intrinsics.checkNotNull(gVar2);
        gVar2.d.d.getPreviewBottomView().a(aVar.b().getNewLabels().getProcessing(), previewProgressButtonColors.getFirst().intValue(), Color.parseColor(str), Color.parseColor(str), previewProgressButtonColors.getSecond().intValue());
    }

    public final void j() {
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "hideDebugImage");
        com.socure.docv.capturesdk.databinding.g gVar = this.n;
        Intrinsics.checkNotNull(gVar);
        gVar.k.setImageBitmap(null);
        com.socure.docv.capturesdk.databinding.g gVar2 = this.n;
        Intrinsics.checkNotNull(gVar2);
        gVar2.k.setVisibility(8);
    }

    public final void k() {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "setUpPreviewCallback");
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar = this.m;
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        cVar.i.observe(getViewLifecycleOwner(), new Observer() { // from class: com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerFragment$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ScannerFragment.a(ScannerFragment.this, (com.socure.docv.capturesdk.common.upload.g) obj);
            }
        });
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar3 = this.m;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cVar2 = cVar3;
        }
        cVar2.j.observe(getViewLifecycleOwner(), new Observer() { // from class: com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerFragment$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ScannerFragment.a(ScannerFragment.this, (m) obj);
            }
        });
    }

    public final void l() {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "setUpScanDocTypeUI");
        com.socure.docv.capturesdk.databinding.g gVar = this.n;
        Intrinsics.checkNotNull(gVar);
        gVar.h.setGuidingBoxData(UtilsKt.getGuidingBoxData(c()));
        com.socure.docv.capturesdk.databinding.g gVar2 = this.n;
        Intrinsics.checkNotNull(gVar2);
        ScannerHelpGraphic scannerHelpGraphic = gVar2.m;
        ScanType c2 = c();
        com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
        scannerHelpGraphic.a(c2, aVar.b().getNewLabels().getToGetStarted(), HelpPreviewUtils.INSTANCE.getScannerHelpText$capturesdk_productionRelease(c(), aVar.b().getNewLabels()));
    }

    public final void m() {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "setupCaptureErrorCallback");
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar = this.m;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        cVar.h.observe(getViewLifecycleOwner(), new Observer() { // from class: com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ScannerFragment.a(ScannerFragment.this, (Pair) obj);
            }
        });
    }

    public final void n() {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "setupClickListeners");
        com.socure.docv.capturesdk.databinding.g gVar = this.n;
        Intrinsics.checkNotNull(gVar);
        gVar.e.setHelpButtonClickListener(new j());
        com.socure.docv.capturesdk.databinding.g gVar2 = this.n;
        Intrinsics.checkNotNull(gVar2);
        gVar2.e.setManualButtonClickListener(new View.OnClickListener() { // from class: com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScannerFragment.a(ScannerFragment.this, view);
            }
        });
        com.socure.docv.capturesdk.databinding.g gVar3 = this.n;
        Intrinsics.checkNotNull(gVar3);
        gVar3.g.setCloseListener(new View.OnClickListener() { // from class: com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScannerFragment.b(ScannerFragment.this, view);
            }
        });
        if (b().a(UtilsKt.getCurrentScreenForScanner(c())).getBackwardNavActionId() == 0) {
            com.socure.docv.capturesdk.databinding.g gVar4 = this.n;
            Intrinsics.checkNotNull(gVar4);
            gVar4.g.a();
        } else {
            com.socure.docv.capturesdk.databinding.g gVar5 = this.n;
            Intrinsics.checkNotNull(gVar5);
            gVar5.g.setBackListener(new View.OnClickListener() { // from class: com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ScannerFragment.c(ScannerFragment.this, view);
                }
            });
        }
    }

    public final void o() {
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "setupDebugImageCallback");
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar = this.m;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        cVar.g.observe(getViewLifecycleOwner(), new Observer() { // from class: com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ScannerFragment.b(ScannerFragment.this, (Pair) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View findChildViewById;
        View findChildViewById2;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Screen current = ScreenKt.getCurrent(b().d());
        Intrinsics.checkNotNullParameter(current, "<set-?>");
        this.c = current;
        Screen screen = null;
        if (current == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentScreen");
            current = null;
        }
        ScanType scanType = current.getScanType();
        Intrinsics.checkNotNullParameter(scanType, "<set-?>");
        this.d = scanType;
        com.socure.docv.capturesdk.common.analytics.a selection$capturesdk_productionRelease = Utils.INSTANCE.getSelection$capturesdk_productionRelease(b().d());
        Intrinsics.checkNotNullParameter(selection$capturesdk_productionRelease, "<set-?>");
        this.e = selection$capturesdk_productionRelease;
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "onCreateView called with scanType: " + c());
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "requireActivity().application");
        com.socure.docv.capturesdk.di.c a2 = com.socure.docv.capturesdk.di.d.a(application);
        Screen screen2 = this.c;
        if (screen2 != null) {
            screen = screen2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("currentScreen");
        }
        this.m = (com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c) new ViewModelProvider(this, new com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.b(a2, screen)).get(com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c.class);
        View inflate = inflater.inflate(R.layout.fragment_scanner_socure, viewGroup, false);
        int i2 = R.id.blocker_view;
        View findChildViewById3 = ViewBindings.findChildViewById(inflate, i2);
        if (findChildViewById3 != null) {
            i2 = R.id.brand_view;
            BrandLayout brandLayout = (BrandLayout) ViewBindings.findChildViewById(inflate, i2);
            if (brandLayout != null && (findChildViewById = ViewBindings.findChildViewById(inflate, (i2 = R.id.bs_container))) != null) {
                int i3 = R.id.bs_brand_view;
                BrandLayout brandLayout2 = (BrandLayout) ViewBindings.findChildViewById(findChildViewById, i3);
                if (brandLayout2 != null) {
                    i3 = R.id.content_area;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(findChildViewById, i3);
                    if (constraintLayout != null) {
                        i3 = R.id.help_view;
                        HelpView helpView = (HelpView) ViewBindings.findChildViewById(findChildViewById, i3);
                        if (helpView != null) {
                            i3 = R.id.preview_view;
                            PreviewView previewView = (PreviewView) ViewBindings.findChildViewById(findChildViewById, i3);
                            if (previewView != null) {
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) findChildViewById;
                                i3 = R.id.view_padding;
                                View findChildViewById4 = ViewBindings.findChildViewById(findChildViewById, i3);
                                if (findChildViewById4 != null) {
                                    com.socure.docv.capturesdk.databinding.a aVar = new com.socure.docv.capturesdk.databinding.a(constraintLayout2, brandLayout2, constraintLayout, helpView, previewView, constraintLayout2, findChildViewById4);
                                    i2 = R.id.cblView;
                                    ScannerBottomLayout scannerBottomLayout = (ScannerBottomLayout) ViewBindings.findChildViewById(inflate, i2);
                                    if (scannerBottomLayout != null) {
                                        i2 = R.id.cilView;
                                        InfoLayout infoLayout = (InfoLayout) ViewBindings.findChildViewById(inflate, i2);
                                        if (infoLayout != null) {
                                            i2 = R.id.cl_progress_view;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(inflate, i2);
                                            if (constraintLayout3 != null) {
                                                i2 = R.id.clScannerToolbar;
                                                CustomToolbar customToolbar = (CustomToolbar) ViewBindings.findChildViewById(inflate, i2);
                                                if (customToolbar != null) {
                                                    i2 = R.id.docOverView;
                                                    OverlayLayout overlayLayout = (OverlayLayout) ViewBindings.findChildViewById(inflate, i2);
                                                    if (overlayLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(inflate, (i2 = R.id.extraction_blocker_view))) != null) {
                                                        i2 = R.id.extraction_progress_indicator;
                                                        CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) ViewBindings.findChildViewById(inflate, i2);
                                                        if (circularProgressIndicator != null) {
                                                            i2 = R.id.glTop;
                                                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(inflate, i2);
                                                            if (guideline != null) {
                                                                i2 = R.id.graphicOverlay;
                                                                GraphicOverlay graphicOverlay = (GraphicOverlay) ViewBindings.findChildViewById(inflate, i2);
                                                                if (graphicOverlay != null) {
                                                                    i2 = R.id.imgPreview;
                                                                    VideoView videoView = (VideoView) ViewBindings.findChildViewById(inflate, i2);
                                                                    if (videoView != null) {
                                                                        i2 = R.id.iv_dbg_scan_stages;
                                                                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(inflate, i2);
                                                                        if (appCompatImageView != null) {
                                                                            i2 = R.id.preview;
                                                                            androidx.camera.view.PreviewView previewView2 = (androidx.camera.view.PreviewView) ViewBindings.findChildViewById(inflate, i2);
                                                                            if (previewView2 != null) {
                                                                                i2 = R.id.scannerGraphic;
                                                                                ScannerHelpGraphic scannerHelpGraphic = (ScannerHelpGraphic) ViewBindings.findChildViewById(inflate, i2);
                                                                                if (scannerHelpGraphic != null) {
                                                                                    i2 = R.id.view_loader;
                                                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(inflate, i2);
                                                                                    if (constraintLayout4 != null) {
                                                                                        com.socure.docv.capturesdk.databinding.g gVar = new com.socure.docv.capturesdk.databinding.g((CoordinatorLayout) inflate, findChildViewById3, brandLayout, aVar, scannerBottomLayout, infoLayout, constraintLayout3, customToolbar, overlayLayout, findChildViewById2, circularProgressIndicator, guideline, graphicOverlay, videoView, appCompatImageView, previewView2, scannerHelpGraphic, constraintLayout4);
                                                                                        this.n = gVar;
                                                                                        Intrinsics.checkNotNull(gVar);
                                                                                        Intrinsics.checkNotNullExpressionValue(guideline, "binding.glTop");
                                                                                        a(guideline);
                                                                                        com.socure.docv.capturesdk.databinding.g gVar2 = this.n;
                                                                                        Intrinsics.checkNotNull(gVar2);
                                                                                        CoordinatorLayout coordinatorLayout = gVar2.f400a;
                                                                                        Intrinsics.checkNotNullExpressionValue(coordinatorLayout, "binding.root");
                                                                                        return coordinatorLayout;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(findChildViewById.getResources().getResourceName(i3)));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "onDestroyView");
        g("view destroyed");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "clearViews");
        FeedManager feedManager = this.o;
        if (feedManager != null) {
            feedManager.clear();
        }
        this.o = null;
        this.n = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "onPause");
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar = this.m;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        cVar.q.saveCaptureDurationOnPause();
        h("on pause");
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "onResume");
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar = this.m;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        cVar.q.setCaptureStart();
        BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior = f();
        Intrinsics.checkNotNullExpressionValue(bottomSheetBehavior, "bottomSheetBehavior");
        if (ExtensionsKt.isNotVisible(bottomSheetBehavior)) {
            r();
            com.socure.docv.capturesdk.databinding.g gVar = this.n;
            Intrinsics.checkNotNull(gVar);
            UtilsKt.requestFocusAccessibilityEvent(gVar.g.getTvInfoTitle());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Unit unit;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        f().setDraggable(false);
        BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior = f();
        Intrinsics.checkNotNullExpressionValue(bottomSheetBehavior, "bottomSheetBehavior");
        ExtensionsKt.hide(bottomSheetBehavior);
        f().setUpdateImportantForAccessibilityOnSiblings(true);
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "onViewCreated");
        Utils utils = Utils.INSTANCE;
        a(utils.replacePlaceholders$capturesdk_productionRelease(utils.isSelfie$capturesdk_productionRelease(c()) ? "[Document_Type]_[Capture_Type]_initiated" : "[Document_Type]_[Capture_Type]_scan_initiated", c(), a()), new Pair[0]);
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "setupViews");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "setupFeedViews");
        if (utils.isAutomationFlavor$capturesdk_productionRelease()) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "setupVideoFeedViews");
            com.socure.docv.capturesdk.databinding.g gVar = this.n;
            Intrinsics.checkNotNull(gVar);
            gVar.j.setVisibility(0);
            com.socure.docv.capturesdk.databinding.g gVar2 = this.n;
            Intrinsics.checkNotNull(gVar2);
            gVar2.l.setVisibility(4);
            l();
        } else {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "setupCameraViews");
            com.socure.docv.capturesdk.databinding.g gVar3 = this.n;
            Intrinsics.checkNotNull(gVar3);
            gVar3.l.setVisibility(0);
            com.socure.docv.capturesdk.databinding.g gVar4 = this.n;
            Intrinsics.checkNotNull(gVar4);
            gVar4.j.setVisibility(8);
            l();
        }
        com.socure.docv.capturesdk.databinding.g gVar5 = this.n;
        Intrinsics.checkNotNull(gVar5);
        CoordinatorLayout coordinatorLayout = gVar5.f400a;
        com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
        coordinatorLayout.setBackgroundColor(Color.parseColor(aVar.b().getTheme().getPrimary().getBackgroundColor()));
        com.socure.docv.capturesdk.databinding.g gVar6 = this.n;
        Intrinsics.checkNotNull(gVar6);
        gVar6.g.a(UtilsKt.getCaptureTitleText(c(), aVar.b().getScreens()), aVar.b().getTheme().getPrimary().getColor());
        com.socure.docv.capturesdk.databinding.g gVar7 = this.n;
        Intrinsics.checkNotNull(gVar7);
        gVar7.c.a(UtilsKt.getPowerByLabel(aVar.b().getScreens()), R.drawable.socure_logo_white, R.color.socure_white);
        com.socure.docv.capturesdk.databinding.g gVar8 = this.n;
        Intrinsics.checkNotNull(gVar8);
        gVar8.d.b.a(UtilsKt.getPowerByLabel(aVar.b().getScreens()), R.drawable.socure_logo_black, R.color.socure_black);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (UtilsKt.isTalkBackEnabled(requireContext)) {
            com.socure.docv.capturesdk.databinding.g gVar9 = this.n;
            Intrinsics.checkNotNull(gVar9);
            gVar9.e.setHelpButtonContentDescription(aVar.b().getAccessibility().getHelpBtnContDes());
            com.socure.docv.capturesdk.databinding.g gVar10 = this.n;
            Intrinsics.checkNotNull(gVar10);
            gVar10.e.setManualButtonContentDescription(aVar.b().getAccessibility().getManualBtnContDes());
            com.socure.docv.capturesdk.databinding.g gVar11 = this.n;
            Intrinsics.checkNotNull(gVar11);
            gVar11.g.setCloseContentDescription(aVar.b().getAccessibility().getCloseBtnContDes());
            com.socure.docv.capturesdk.databinding.g gVar12 = this.n;
            Intrinsics.checkNotNull(gVar12);
            gVar12.g.setBackContentDescription(aVar.b().getAccessibility().getBackBtnContDes());
        }
        n();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (!utils.isAutomationFlavor$capturesdk_productionRelease()) {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "setupFeeds - Checking permission");
                String screen = UtilsKt.getCurrentScreenForScanner(c()).a();
                f eventTrigger = new f();
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(screen, "screen");
                Intrinsics.checkNotNullParameter(eventTrigger, "eventTrigger");
                com.socure.docv.capturesdk.common.logger.b.a(this.f417a, "requestCameraPermissionWithCallback");
                Context applicationContext = activity.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
                if (utils.hasCameraPermission(applicationContext)) {
                    com.socure.docv.capturesdk.common.logger.b.a(this.f417a, "camera permission already have present");
                } else {
                    this.g = new com.socure.docv.capturesdk.feature.base.presentation.ui.b(this, eventTrigger, screen, activity);
                    a(eventTrigger);
                }
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "setupFeeds - activity is null", null, 4, null);
        }
    }

    public final void p() {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "setupDetectionCallbacks");
        final Ref.LongRef longRef = new Ref.LongRef();
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar = this.m;
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        cVar.d.observe(getViewLifecycleOwner(), new Observer() { // from class: com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ScannerFragment.a(ScannerFragment.this, longRef, (DetectionCallback) obj);
            }
        });
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar3 = this.m;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cVar2 = cVar3;
        }
        cVar2.e.observe(getViewLifecycleOwner(), new Observer() { // from class: com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ScannerFragment.c(ScannerFragment.this, (Pair) obj);
            }
        });
    }

    public final void q() {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "setupOutputCallback");
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar = this.m;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        cVar.f.observe(getViewLifecycleOwner(), new Observer() { // from class: com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ScannerFragment.a(ScannerFragment.this, (Output) obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void r() {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerFragment.r():void");
    }

    public final void s() {
        com.socure.docv.capturesdk.core.provider.interfaces.c cVar;
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "startFrameGeneration");
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar2 = this.m;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar2 = null;
        }
        com.socure.docv.capturesdk.feature.scanner.b bVar = cVar2.m;
        if (bVar != null && (cVar = bVar.d) != null) {
            cVar.startGeneratingFrame();
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerFragment$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    ScannerFragment.d(ScannerFragment.this);
                }
            });
        }
    }

    public static final void b(ScannerFragment this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (a.c[((ImageMode) pair.getFirst()).ordinal()] != 1) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "else hit in setupDebugImageCallback");
            return;
        }
        Bitmap bitmap = (Bitmap) pair.getSecond();
        boolean z = (bitmap == null || bitmap.isRecycled()) ? false : true;
        Unit unit = null;
        if (!z) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "recycled bitmap received in debugScanStageCallback", null, 4, null);
            return;
        }
        Bitmap bitmap2 = (Bitmap) pair.getSecond();
        this$0.getClass();
        if (bitmap2 != null) {
            com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "showDebugImage");
            com.socure.docv.capturesdk.databinding.g gVar = this$0.n;
            Intrinsics.checkNotNull(gVar);
            gVar.k.setVisibility(0);
            com.socure.docv.capturesdk.databinding.g gVar2 = this$0.n;
            Intrinsics.checkNotNull(gVar2);
            gVar2.k.setImageBitmap(null);
            com.socure.docv.capturesdk.databinding.g gVar3 = this$0.n;
            Intrinsics.checkNotNull(gVar3);
            gVar3.k.setImageBitmap(bitmap2);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "calling hideDebugImage");
            this$0.j();
        }
    }

    public static final void c(ScannerFragment this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<Float> coords = (List) pair.component1();
        Dimension dimension = (Dimension) pair.component2();
        int i2 = a.b[this$0.c().ordinal()];
        if (i2 != 1 && i2 != 2) {
            if (i2 == 3 || i2 == 4) {
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "cornerDetectionCallBack called for scanType: " + this$0.c());
                return;
            }
            return;
        }
        com.socure.docv.capturesdk.databinding.g gVar = this$0.n;
        Intrinsics.checkNotNull(gVar);
        gVar.i.a();
        if (!(!coords.isEmpty())) {
            com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "card coordinates is empty");
            return;
        }
        com.socure.docv.capturesdk.databinding.g gVar2 = this$0.n;
        Intrinsics.checkNotNull(gVar2);
        if (gVar2.e.b()) {
            com.socure.docv.capturesdk.databinding.g gVar3 = this$0.n;
            Intrinsics.checkNotNull(gVar3);
            if (UtilsKt.flipDoc(coords, 20.0d, gVar3.h.c())) {
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "trying to flip the guiding box and called passingViewDimensions");
                com.socure.docv.capturesdk.databinding.g gVar4 = this$0.n;
                Intrinsics.checkNotNull(gVar4);
                gVar4.h.a();
                LifecycleOwner viewLifecycleOwner = this$0.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
                LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner).launchWhenStarted(new com.socure.docv.capturesdk.feature.scanner.presentation.ui.e(500L, this$0, null)).start();
                return;
            }
            return;
        }
        if (Utils.INSTANCE.cornersFound$capturesdk_productionRelease(CollectionsKt.toFloatArray(coords))) {
            com.socure.docv.capturesdk.databinding.g gVar5 = this$0.n;
            Intrinsics.checkNotNull(gVar5);
            GraphicOverlay graphicOverlay = gVar5.i;
            graphicOverlay.getClass();
            Intrinsics.checkNotNullParameter(coords, "coords");
            Intrinsics.checkNotNullParameter(dimension, "dimension");
            graphicOverlay.a(coords, dimension);
            graphicOverlay.c.setColor(graphicOverlay.l);
            graphicOverlay.d.setColor(graphicOverlay.m);
            graphicOverlay.invalidate();
            return;
        }
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (!UtilsKt.isTalkBackEnabled(requireContext) || System.currentTimeMillis() - this$0.w <= 3000) {
            return;
        }
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "TalkBackEnabled is enabled | corner doesn't have valid coordinates");
        ImageUtils imageUtils = ImageUtils.INSTANCE;
        List<Float> removeNegative = UtilsKt.removeNegative(coords);
        com.socure.docv.capturesdk.databinding.g gVar6 = this$0.n;
        Intrinsics.checkNotNull(gVar6);
        GraphicOverlay graphicOverlay2 = gVar6.i;
        Intrinsics.checkNotNullExpressionValue(graphicOverlay2, "binding.graphicOverlay");
        List<Float> scaleIddModelCoordinates$capturesdk_productionRelease = imageUtils.scaleIddModelCoordinates$capturesdk_productionRelease(removeNegative, ExtensionsKt.getDimension(graphicOverlay2), dimension);
        ScanType c2 = this$0.c();
        App b2 = com.socure.docv.capturesdk.common.session.a.f305a.b();
        float[] floatArray = CollectionsKt.toFloatArray(scaleIddModelCoordinates$capturesdk_productionRelease);
        com.socure.docv.capturesdk.databinding.g gVar7 = this$0.n;
        Intrinsics.checkNotNull(gVar7);
        GraphicOverlay graphicOverlay3 = gVar7.i;
        Intrinsics.checkNotNullExpressionValue(graphicOverlay3, "binding.graphicOverlay");
        this$0.a(UtilsKt.getCardAccessibilityAnnouncement(c2, b2, floatArray, ExtensionsKt.getDimension(graphicOverlay3)), false);
    }

    public final void a(String str, boolean z) {
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "announceAccessibilityMessage called");
        if (System.currentTimeMillis() - this.w <= 3000 && !z) {
            com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "announcement skipped");
            return;
        }
        com.socure.docv.capturesdk.databinding.g gVar = this.n;
        Intrinsics.checkNotNull(gVar);
        gVar.f400a.announceForAccessibility(str);
        this.w = System.currentTimeMillis();
    }

    public static final void d(ScannerFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Utils utils = Utils.INSTANCE;
        if (utils.isAutomationFlavor$capturesdk_productionRelease()) {
            com.socure.docv.capturesdk.databinding.g gVar = this$0.n;
            Intrinsics.checkNotNull(gVar);
            VideoView videoView = gVar.j;
            Context requireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            videoView.setVideoPath(utils.getVideoPath$capturesdk_productionRelease(requireContext, this$0.c()));
        }
    }

    public final void a(Output output, FinalOutputProcessData finalOutputProcessData, long j2) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "proceedToPreview called ");
        BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior = f();
        Intrinsics.checkNotNullExpressionValue(bottomSheetBehavior, "bottomSheetBehavior");
        if (ExtensionsKt.isNotVisible(bottomSheetBehavior)) {
            HelpPreviewUtils helpPreviewUtils = HelpPreviewUtils.INSTANCE;
            com.socure.docv.capturesdk.databinding.g gVar = this.n;
            Intrinsics.checkNotNull(gVar);
            PreviewView previewView = gVar.d.d;
            Intrinsics.checkNotNullExpressionValue(previewView, "binding.bsContainer.previewView");
            com.socure.docv.capturesdk.databinding.g gVar2 = this.n;
            Intrinsics.checkNotNull(gVar2);
            helpPreviewUtils.setVisibilityFocus$capturesdk_productionRelease(previewView, gVar2);
            h("proceed to preivew");
            com.socure.docv.capturesdk.databinding.g gVar3 = this.n;
            Intrinsics.checkNotNull(gVar3);
            PreviewView previewView2 = gVar3.d.d;
            Context context = previewView2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            previewView2.a(helpPreviewUtils.getPreviewUiData$capturesdk_productionRelease(context, c(), output, com.socure.docv.capturesdk.common.session.a.f305a.b()), new g(previewView2, this, output, finalOutputProcessData, j2));
            com.socure.docv.capturesdk.databinding.g gVar4 = this.n;
            Intrinsics.checkNotNull(gVar4);
            gVar4.d.d.invalidate();
            k();
            BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior2 = f();
            Intrinsics.checkNotNullExpressionValue(bottomSheetBehavior2, "bottomSheetBehavior");
            ExtensionsKt.show(bottomSheetBehavior2);
        }
    }

    public final void b(boolean z) {
        Unit unit;
        if (this.n != null) {
            FragmentActivity activity = getActivity();
            if (activity != null ? activity.isFinishing() : true) {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "showBlocker - activity is finishing", null, 4, null);
            } else {
                com.socure.docv.capturesdk.databinding.g gVar = this.n;
                Intrinsics.checkNotNull(gVar);
                gVar.b.setVisibility(z ? 0 : 8);
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "showBlocker called - show: " + z);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "showBlocker - _binding is null", null, 4, null);
        }
    }

    public final void a(Output output) {
        com.socure.docv.capturesdk.core.extractor.c cVar;
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "processedToNext");
        j();
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "clearFeedManager");
        FeedManager feedManager = this.o;
        if (feedManager != null) {
            feedManager.clear();
        }
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar2 = null;
        this.o = null;
        Utils utils = Utils.INSTANCE;
        String str = utils.isSelfie$capturesdk_productionRelease(c()) ? output.getCaptureType() == CaptureType.MANUAL ? "[Document_Type]_[Capture_Type]_captured_manual" : "[Document_Type]_[Capture_Type]_captured" : output.getCaptureType() == CaptureType.MANUAL ? "[Document_Type]_[Capture_Type]_scanned_manual" : "[Document_Type]_[Capture_Type]_scanned";
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar3 = this.m;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar3 = null;
        }
        long andResetCaptureDurationOnCapture = cVar3.q.getAndResetCaptureDurationOnCapture();
        Pair<String, String>[] scannedEventAttrs = UtilsKt.getScannedEventAttrs(c(), andResetCaptureDurationOnCapture, output);
        a(utils.replacePlaceholders$capturesdk_productionRelease(str, c(), a()), (Pair<String, String>[]) Arrays.copyOf(scannedEventAttrs, scannedEventAttrs.length));
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar4 = this.m;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cVar2 = cVar4;
        }
        if (cVar2.c) {
            a(output, new FinalOutputProcessData(null, null, false, false, 0L, 31, null), andResetCaptureDurationOnCapture);
            return;
        }
        com.socure.docv.capturesdk.core.extractor.e eVar = new com.socure.docv.capturesdk.core.extractor.e(c(), output.getFinalBitmap(), output.getMetrics());
        h outputCallback = new h(output, andResetCaptureDurationOnCapture);
        Intrinsics.checkNotNullParameter(outputCallback, "outputCallback");
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = e.a.f367a[eVar.f366a.ordinal()];
        if (i2 == 1) {
            Bitmap downScaledBitmap = ImageUtils.INSTANCE.getDownScaledBitmap(eVar.b, 300);
            cVar = new com.socure.docv.capturesdk.core.extractor.c(downScaledBitmap, new com.socure.docv.capturesdk.core.extractor.f(currentTimeMillis, downScaledBitmap, eVar, outputCallback), 0, 4, null);
        } else {
            if (i2 == 2) {
                new com.socure.docv.capturesdk.core.extractor.a().a(eVar.b, new com.socure.docv.capturesdk.core.extractor.g(currentTimeMillis, eVar, outputCallback));
                return;
            }
            if (i2 != 3) {
                if (i2 != 4) {
                    return;
                }
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_FOE", "selfie not need final output processor");
                FinalOutputProcessData finalOutputProcessData = new FinalOutputProcessData(null, null, false, false, 0L, 31, null);
                finalOutputProcessData.setFace(CollectionsKt.arrayListOf(new Face(null, Boolean.valueOf(UtilsKt.isFaceFoundForSelfie(eVar.c)), Double.valueOf(1.0d), 0, 1, null)));
                outputCallback.a(finalOutputProcessData);
                return;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            Bitmap downScaledBitmap2 = ImageUtils.INSTANCE.getDownScaledBitmap(eVar.b, 300);
            cVar = new com.socure.docv.capturesdk.core.extractor.c(downScaledBitmap2, new com.socure.docv.capturesdk.core.extractor.h(currentTimeMillis2, downScaledBitmap2, eVar, currentTimeMillis, outputCallback), 0, 4, null);
        }
        cVar.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(ScannerFragment this$0, com.socure.docv.capturesdk.common.upload.g gVar) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = "cancelling from " + gVar;
        this$0.getClass();
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "clearUploadDelayMsgJob called");
        Job job = this$0.z;
        if (job != null) {
            JobKt__JobKt.cancel$default(job, str, null, 2, null);
        }
        this$0.z = null;
        if (Intrinsics.areEqual(gVar, g.b.f323a)) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "launchUploadDelayMsg called");
            LifecycleOwner viewLifecycleOwner = this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getMain().plus(this$0.B), null, new com.socure.docv.capturesdk.feature.scanner.presentation.ui.d(this$0, null), 2, null);
            this$0.z = launch$default;
        }
        if (gVar instanceof g.b) {
            this$0.i(com.socure.docv.capturesdk.common.session.a.f305a.b().getTheme().getPrimary().getButton().getPrimary().getBackgroundColor());
            return;
        }
        if (gVar instanceof g.d) {
            g.d dVar = (g.d) gVar;
            if (dVar.f325a instanceof com.socure.docv.capturesdk.common.upload.b) {
                this$0.b().a(this$0.c());
                this$0.b().a(new MetricCaptureData(this$0.c(), ((com.socure.docv.capturesdk.common.upload.b) dVar.f325a).c.getCaptureType(), ((com.socure.docv.capturesdk.common.upload.b) dVar.f325a).c.getCaptureMetadata(), ((com.socure.docv.capturesdk.common.upload.b) dVar.f325a).c.getMetrics(), Boolean.valueOf(((com.socure.docv.capturesdk.common.upload.b) dVar.f325a).f317a.getExtractedData() != null), ((com.socure.docv.capturesdk.common.upload.b) dVar.f325a).d));
                this$0.b().a().put(this$0.c(), ((com.socure.docv.capturesdk.common.upload.b) dVar.f325a).f317a);
                com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar = this$0.m;
                if (cVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    cVar = null;
                }
                UpdateStatusRequest updateStatusRequest = new UpdateStatusRequest(Utils.INSTANCE.getEventType(this$0.c()), ((com.socure.docv.capturesdk.common.upload.b) dVar.f325a).f317a.getExtractedData());
                com.socure.docv.capturesdk.feature.scanner.presentation.ui.b eventUpdater = this$0.g();
                cVar.getClass();
                Intrinsics.checkNotNullParameter(updateStatusRequest, "updateStatusRequest");
                Intrinsics.checkNotNullParameter(eventUpdater, "eventUpdater");
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_SVM", "updateDocUploadStatus called");
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(cVar), Dispatchers.getIO().plus(cVar.t), null, new com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.d(new com.socure.docv.capturesdk.common.upload.c(cVar.f529a.g().b(), updateStatusRequest), cVar, eventUpdater, null), 2, null);
                return;
            }
        } else {
            if (!(gVar instanceof g.c)) {
                if (gVar instanceof g.a) {
                    this$0.b().b(((g.a) gVar).f322a);
                    return;
                } else {
                    com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "uploadImageIvsCallback liveData reset");
                    return;
                }
            }
            g.c cVar2 = (g.c) gVar;
            if (cVar2.f324a instanceof com.socure.docv.capturesdk.common.upload.b) {
                com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
                PrimaryButton primary = aVar.b().getTheme().getPrimary().getButton().getPrimary();
                com.socure.docv.capturesdk.databinding.g gVar2 = this$0.n;
                Intrinsics.checkNotNull(gVar2);
                gVar2.d.d.a(primary.getBackgroundColor(), primary.getColor(), R.drawable.ic_socure_ivs_failure);
                this$0.a(aVar.b().getNewLabels().getInvalidImage(), true);
                com.socure.docv.capturesdk.databinding.g gVar3 = this$0.n;
                Intrinsics.checkNotNull(gVar3);
                gVar3.d.d.a(HelpPreviewUtils.INSTANCE.getFailureRetryButtonColor(aVar.b()), aVar.b().getNewLabels().getInvalidImage(), UtilsKt.getPreviewWarningMsg(aVar.b().getErrors(), ((com.socure.docv.capturesdk.common.upload.b) cVar2.f324a).b.getErrorCode()));
                return;
            }
        }
        this$0.b().a(ResponseCode.UNKNOWN_ERROR);
    }

    public final void c(boolean z) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "streamingStarted called - isVideoFeed: " + z);
        long j2 = z ? 500L : 0L;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner).launchWhenStarted(new com.socure.docv.capturesdk.feature.scanner.presentation.ui.e(j2, this, null)).start();
        if (h().isActive() || h().isCompleted()) {
            a(z);
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "helpGraphicJob is isActive: " + h().isActive() + " | isCompleted: " + h().isCompleted() + " | isCancelled: " + h().isCancelled());
            return;
        }
        com.socure.docv.capturesdk.databinding.g gVar = this.n;
        Intrinsics.checkNotNull(gVar);
        gVar.m.setVisibility(0);
        com.socure.docv.capturesdk.common.logger.b.c("SDLT_SF", "helpGraphicJob started: " + h().start());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(ScannerFragment this$0, com.socure.docv.capturesdk.common.upload.m mVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!(mVar instanceof m.c)) {
            if (mVar instanceof m.a) {
                this$0.b().b(((m.a) mVar).f330a);
                return;
            }
            if (!(mVar instanceof m.b)) {
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "uploadCallback liveData reset");
                return;
            }
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            m.b bVar = (m.b) mVar;
            Object[] array = CollectionsKt.listOf((Object[]) new Pair[]{new Pair("type", "unknown"), new Pair("message", bVar.b)}).toArray(new Pair[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            spreadBuilder.addSpread(array);
            spreadBuilder.add(this$0.d());
            this$0.a("error", (Pair<String, String>[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
            this$0.b().a(bVar.f331a);
            return;
        }
        m.c cVar = (m.c) mVar;
        if (cVar.f332a == com.socure.docv.capturesdk.common.upload.f.UploadStatus) {
            this$0.getClass();
            com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "handleImageUploadStatus called");
            com.socure.docv.capturesdk.databinding.g gVar = this$0.n;
            Intrinsics.checkNotNull(gVar);
            PreviewView previewView = gVar.d.d;
            com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
            previewView.a(aVar.b().getNewLabels().getImageValidated());
            com.socure.docv.capturesdk.databinding.g gVar2 = this$0.n;
            Intrinsics.checkNotNull(gVar2);
            gVar2.d.d.getPreviewBottomView().a(aVar.b().getNewLabels().getSuccess());
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, new com.socure.docv.capturesdk.feature.scanner.presentation.ui.c(this$0, null), 3, null);
            return;
        }
        this$0.b().a((ApiResponse) cVar.b);
    }

    public static final void a(ScannerFragment this$0, Pair pair) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (pair != null) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "captureErrorCallback msg: " + ((ErrorScenario) pair.getFirst()).getMsg() + " and ex: " + pair.getSecond());
            Utils utils = Utils.INSTANCE;
            this$0.a("image_capture_error", new Pair<>("type", ((ErrorScenario) pair.getFirst()).getMsg()), new Pair<>("facet_type", utils.getDocSelFacet$capturesdk_productionRelease(this$0.b().d(), this$0.c())), new Pair<>("message", pair.getSecond()));
            if (pair.getFirst() == ErrorScenario.MANUAL_FAILED || pair.getFirst() == ErrorScenario.CONTINUOUS_ERRORS_MAXED) {
                this$0.a("error", new Pair<>("type", ((ErrorScenario) pair.getFirst()).getMsg()), new Pair<>("facet_type", utils.getDocSelFacet$capturesdk_productionRelease(this$0.b().d(), this$0.c())), new Pair<>("message", pair.getSecond()));
                this$0.b().l();
            } else {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "capture failed - preparing remove screen blocker");
                com.socure.docv.capturesdk.databinding.g gVar = this$0.n;
                Intrinsics.checkNotNull(gVar);
                if (gVar.e.b()) {
                    com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "reset the manual instruction from Keep steady");
                    this$0.a(this$0.c());
                }
                this$0.b(false);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "irrecoverableErrorCallback is reset || null");
        }
    }

    public static final void a(ScannerFragment this$0, Ref.LongRef secondaryInfoLastShownTimeStamp, DetectionCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(secondaryInfoLastShownTimeStamp, "$secondaryInfoLastShownTimeStamp");
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "detectionCallback: " + it);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.A = UtilsKt.getLastFailure(it);
        switch (a.f496a[it.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                com.socure.docv.capturesdk.databinding.g gVar = this$0.n;
                Intrinsics.checkNotNull(gVar);
                if (!gVar.e.b()) {
                    com.socure.docv.capturesdk.databinding.g gVar2 = this$0.n;
                    Intrinsics.checkNotNull(gVar2);
                    InfoLayout infoLayout = gVar2.f;
                    Intrinsics.checkNotNullExpressionValue(infoLayout, "binding.cilView");
                    ScanType c2 = this$0.c();
                    com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
                    InfoLayout.a(infoLayout, null, UtilsKt.getDetectionWarningMsg(c2, it, aVar), false, 5, null);
                    Context requireContext = this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    if (UtilsKt.isTalkBackEnabled(requireContext) && it != DetectionCallback.CORNER_DETECTION_FAILED) {
                        this$0.a(UtilsKt.getDetectionWarningMsg(this$0.c(), it, aVar), false);
                    }
                }
                if (it == DetectionCallback.CORNER_DETECTION_FAILED) {
                    com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "clearing graphic overlay");
                    com.socure.docv.capturesdk.databinding.g gVar3 = this$0.n;
                    Intrinsics.checkNotNull(gVar3);
                    gVar3.i.a();
                    break;
                }
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                if (System.currentTimeMillis() - secondaryInfoLastShownTimeStamp.element > 1000) {
                    com.socure.docv.capturesdk.databinding.g gVar4 = this$0.n;
                    Intrinsics.checkNotNull(gVar4);
                    gVar4.f.setVisibility(0);
                    com.socure.docv.capturesdk.databinding.g gVar5 = this$0.n;
                    Intrinsics.checkNotNull(gVar5);
                    InfoLayout infoLayout2 = gVar5.f;
                    Intrinsics.checkNotNullExpressionValue(infoLayout2, "binding.cilView");
                    ScanType c3 = this$0.c();
                    com.socure.docv.capturesdk.common.session.a aVar2 = com.socure.docv.capturesdk.common.session.a.f305a;
                    InfoLayout.a(infoLayout2, null, UtilsKt.getDetectionWarningMsg(c3, it, aVar2), false, 5, null);
                    Context requireContext2 = this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                    if (UtilsKt.isTalkBackEnabled(requireContext2)) {
                        this$0.a(UtilsKt.getSelfieAccessibilityAnnouncementMessage(it, aVar2.b()), false);
                    }
                    com.socure.docv.capturesdk.databinding.g gVar6 = this$0.n;
                    Intrinsics.checkNotNull(gVar6);
                    gVar6.h.setGuidingBoxTintColor(it == DetectionCallback.READY_FOR_SELFIE_CAPTURE ? R.color.socure_green : R.color.socure_white);
                    secondaryInfoLastShownTimeStamp.element = System.currentTimeMillis();
                    break;
                }
                break;
            case 15:
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "calling showEdgeDetection and showWarning");
                this$0.b(true);
                com.socure.docv.capturesdk.databinding.g gVar7 = this$0.n;
                Intrinsics.checkNotNull(gVar7);
                InfoLayout infoLayout3 = gVar7.f;
                Intrinsics.checkNotNullExpressionValue(infoLayout3, "binding.cilView");
                ScanType c4 = this$0.c();
                com.socure.docv.capturesdk.common.session.a aVar3 = com.socure.docv.capturesdk.common.session.a.f305a;
                InfoLayout.a(infoLayout3, null, UtilsKt.getDetectionWarningMsg(c4, it, aVar3), false, 5, null);
                Context requireContext3 = this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
                if (UtilsKt.isTalkBackEnabled(requireContext3)) {
                    this$0.a(aVar3.b().getAccessibility().getIdLookingGood(), true);
                    break;
                }
                break;
            case 16:
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "Document too close");
                if (this$0.c() == ScanType.LICENSE_FRONT || this$0.c() == ScanType.LICENSE_BACK) {
                    com.socure.docv.capturesdk.databinding.g gVar8 = this$0.n;
                    Intrinsics.checkNotNull(gVar8);
                    if (!gVar8.e.b()) {
                        com.socure.docv.capturesdk.databinding.g gVar9 = this$0.n;
                        Intrinsics.checkNotNull(gVar9);
                        InfoLayout infoLayout4 = gVar9.f;
                        Intrinsics.checkNotNullExpressionValue(infoLayout4, "binding.cilView");
                        ScanType c5 = this$0.c();
                        com.socure.docv.capturesdk.common.session.a aVar4 = com.socure.docv.capturesdk.common.session.a.f305a;
                        InfoLayout.a(infoLayout4, UtilsKt.getDocumentTooCloseMsg(c5, aVar4.b().getNewLabels()), aVar4.b().getNewLabels().getMovePhoneBack(), false, 4, null);
                        break;
                    }
                }
                break;
            case 17:
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "Not processing callback");
                break;
        }
    }

    public final void a(boolean z) {
        Job launch$default;
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "setupFpAndManualViewTimers - isVideoFeed: " + z);
        long j2 = z ? 1000L : Scanner.CAMERA_SETUP_DELAY_MS;
        a(j2, z);
        c("instantiation");
        com.socure.docv.capturesdk.databinding.g gVar = this.n;
        Intrinsics.checkNotNull(gVar);
        if (gVar.e.b()) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "manual button already showing, returning");
            return;
        }
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "manual button is not showing");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getMain().plus(this.B), null, new com.socure.docv.capturesdk.feature.scanner.presentation.ui.i(this, j2, null), 2, null);
        this.s = launch$default;
    }

    public static final void a(ScannerFragment this$0, Output output) {
        Unit unit;
        Object obj;
        com.socure.docv.capturesdk.core.provider.interfaces.c cVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.socure.docv.capturesdk.common.logger.b.c("SDLT_SF", "outPutCallBack");
        if (output != null) {
            if (output.getFinalBitmap().isRecycled() || !(output.getFinalStatus() || output.getCaptureType() == CaptureType.MANUAL)) {
                this$0.b(false);
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "Recycled bitmap received in outPutCallBack or finalStatus false - setting isProcessing to false", null, 4, null);
            } else {
                if (Build.VERSION.SDK_INT >= 30) {
                    com.socure.docv.capturesdk.databinding.g gVar = this$0.n;
                    Intrinsics.checkNotNull(gVar);
                    gVar.h.performHapticFeedback(0);
                }
                this$0.g("starting animation");
                com.socure.docv.capturesdk.databinding.g gVar2 = this$0.n;
                Intrinsics.checkNotNull(gVar2);
                gVar2.h.b();
                com.socure.docv.capturesdk.databinding.g gVar3 = this$0.n;
                Intrinsics.checkNotNull(gVar3);
                gVar3.e.a();
                com.socure.docv.capturesdk.databinding.g gVar4 = this$0.n;
                Intrinsics.checkNotNull(gVar4);
                InfoLayout infoLayout = gVar4.f;
                Intrinsics.checkNotNullExpressionValue(infoLayout, "binding.cilView");
                com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
                InfoLayout.a(infoLayout, aVar.b().getNewLabels().getCaptureSuccess(), null, true, 2, null);
                Context requireContext = this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                if (UtilsKt.isTalkBackEnabled(requireContext)) {
                    this$0.a(aVar.b().getNewLabels().getCaptureSuccess(), false);
                }
                if (!Utils.INSTANCE.isSelfie$capturesdk_productionRelease(this$0.c())) {
                    ImageUtils imageUtils = ImageUtils.INSTANCE;
                    Iterator<T> it = output.getMetrics().iterator();
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
                    DetectionMetric detectionMetric = (DetectionMetric) obj;
                    com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar2 = this$0.m;
                    if (cVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        cVar2 = null;
                    }
                    Pair<List<Float>, Dimension> cornersAndParentDimenForDrawingRect$capturesdk_productionRelease = imageUtils.getCornersAndParentDimenForDrawingRect$capturesdk_productionRelease(detectionMetric, cVar2.f529a.i().getGuidingBox());
                    List<Float> coords = cornersAndParentDimenForDrawingRect$capturesdk_productionRelease.component1();
                    Dimension dimension = cornersAndParentDimenForDrawingRect$capturesdk_productionRelease.component2();
                    com.socure.docv.capturesdk.databinding.g gVar5 = this$0.n;
                    Intrinsics.checkNotNull(gVar5);
                    gVar5.i.a();
                    com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar3 = this$0.m;
                    if (cVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        cVar3 = null;
                    }
                    com.socure.docv.capturesdk.feature.scanner.b bVar = cVar3.m;
                    if (bVar != null && (cVar = bVar.d) != null) {
                        cVar.freeze();
                    }
                    com.socure.docv.capturesdk.databinding.g gVar6 = this$0.n;
                    Intrinsics.checkNotNull(gVar6);
                    GraphicOverlay graphicOverlay = gVar6.i;
                    k completionCallback = this$0.new k(output);
                    graphicOverlay.getClass();
                    Intrinsics.checkNotNullParameter(coords, "coords");
                    Intrinsics.checkNotNullParameter(dimension, "dimension");
                    Intrinsics.checkNotNullParameter(completionCallback, "completionCallback");
                    graphicOverlay.a(coords, dimension);
                    graphicOverlay.c.setColor(graphicOverlay.i);
                    graphicOverlay.d.setColor(graphicOverlay.j);
                    graphicOverlay.n = true;
                    graphicOverlay.p = AnimationUtilsKt.calculateGridLines(graphicOverlay.b);
                    ValueAnimator createAnimator$default = AnimationUtilsKt.createAnimator$default(600L, 122.0f, 0L, graphicOverlay.q, 4, null);
                    ValueAnimator createAnimator = AnimationUtilsKt.createAnimator(300L, 122.0f, 300L, graphicOverlay.r);
                    ValueAnimator createAnimator$default2 = AnimationUtilsKt.createAnimator$default(300L, 0.0f, 100L, graphicOverlay.s, 2, null);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playSequentially(createAnimator$default, createAnimator, createAnimator$default2);
                    animatorSet.addListener(new com.socure.docv.capturesdk.common.view.b(completionCallback));
                    animatorSet.start();
                } else {
                    this$0.a(output);
                }
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this$0.b(false);
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "PVC received null in outPutCallBack - setting isProcessing to false", null, 4, null);
        }
    }

    public final void a(ScanType scanType) {
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "showManualAlertMsg scanType: " + scanType.getValue());
        Pair<String, String> manualWarningMessages = UtilsKt.getManualWarningMessages(scanType, com.socure.docv.capturesdk.common.session.a.f305a.b().getScreens());
        com.socure.docv.capturesdk.databinding.g gVar = this.n;
        Intrinsics.checkNotNull(gVar);
        InfoLayout infoLayout = gVar.f;
        Intrinsics.checkNotNullExpressionValue(infoLayout, "binding.cilView");
        InfoLayout.a(infoLayout, manualWarningMessages.getFirst(), manualWarningMessages.getSecond(), false, 4, null);
    }
}
