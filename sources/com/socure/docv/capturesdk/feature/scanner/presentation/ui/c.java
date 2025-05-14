package com.socure.docv.capturesdk.feature.scanner.presentation.ui;

import com.facebook.hermes.intl.Constants;
import com.socure.docv.capturesdk.R;
import com.socure.docv.capturesdk.common.analytics.model.MetricData;
import com.socure.docv.capturesdk.common.network.model.stepup.PrimaryButton;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadImage;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import com.socure.docv.capturesdk.common.utils.ApiUtilsKt;
import com.socure.docv.capturesdk.common.utils.HeaderUtils;
import com.socure.docv.capturesdk.common.utils.ScreenKt;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.RequestBody;

@DebugMetadata(c = "com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerFragment$handleImageUploadStatus$1", f = "ScannerFragment.kt", i = {}, l = {669}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f519a;
    public final /* synthetic */ ScannerFragment b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ScannerFragment scannerFragment, Continuation<? super c> continuation) {
        super(2, continuation);
        this.b = scannerFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new c(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new c(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f519a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PrimaryButton primary = com.socure.docv.capturesdk.common.session.a.f305a.b().getTheme().getPrimary().getButton().getPrimary();
            com.socure.docv.capturesdk.databinding.g gVar = this.b.n;
            Intrinsics.checkNotNull(gVar);
            gVar.d.d.a(primary.getBackgroundColor(), primary.getColor(), R.drawable.ic_socure_ivs_success);
            this.f519a = 1;
            if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ScannerFragment scannerFragment = this.b;
        int i2 = ScannerFragment.C;
        if (ScreenKt.isComplete(scannerFragment.b().d())) {
            this.b.b().a("scan_upload_complete", new Pair[0]);
            com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar2 = this.b.m;
            String str = null;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar = null;
            } else {
                cVar = cVar2;
            }
            MetricData metricData = this.b.b().e();
            RequestBody docTypeRequestBody = UtilsKt.getDocumentTypeBody(this.b.b().d());
            com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
            String str2 = com.socure.docv.capturesdk.common.session.a.d;
            if (str2 != null) {
                str = str2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException(ApiConstant.CONSENT_ID);
            }
            RequestBody consentIdRequestBody = ApiUtilsKt.toTextPlainBody(str);
            LinkedHashMap<ScanType, UploadImage> uploadImageMap = this.b.b().a();
            b eventUpdater = this.b.g();
            cVar.getClass();
            Intrinsics.checkNotNullParameter(metricData, "metricData");
            Intrinsics.checkNotNullParameter(docTypeRequestBody, "docTypeRequestBody");
            Intrinsics.checkNotNullParameter(consentIdRequestBody, "consentIdRequestBody");
            Intrinsics.checkNotNullParameter(uploadImageMap, "uploadImageMap");
            Intrinsics.checkNotNullParameter(eventUpdater, "eventUpdater");
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "uploadMetricData");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            HeaderUtils headerUtils = HeaderUtils.INSTANCE;
            linkedHashMap.putAll(headerUtils.getPrimaryHeader(aVar.d()));
            linkedHashMap.putAll(headerUtils.getStepHeader(aVar.e()));
            linkedHashMap.put(ApiConstant.VALIDATE_IMAGE, Constants.CASEFIRST_FALSE);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(cVar.t)), null, null, new com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.f(new com.socure.docv.capturesdk.common.upload.i(linkedHashMap, docTypeRequestBody, consentIdRequestBody, cVar.f529a.g().a()), metricData, cVar, uploadImageMap, eventUpdater, null), 3, null);
        } else {
            ScannerFragment scannerFragment2 = this.b;
            scannerFragment2.a(scannerFragment2.c(), UtilsKt.getCurrentScreenForPreview(this.b.c()));
        }
        return Unit.INSTANCE;
    }
}
