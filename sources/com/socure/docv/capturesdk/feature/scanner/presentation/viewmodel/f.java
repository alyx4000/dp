package com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel;

import com.socure.docv.capturesdk.common.analytics.model.EventData;
import com.socure.docv.capturesdk.common.analytics.model.MetricData;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadImage;
import com.socure.docv.capturesdk.common.upload.h;
import com.socure.docv.capturesdk.common.upload.i;
import com.socure.docv.capturesdk.common.utils.Utils;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.MultipartBody;

@DebugMetadata(c = "com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.ScannerViewModel$uploadMetricData$1", f = "ScannerViewModel.kt", i = {}, l = {526}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f542a;
    public final /* synthetic */ i b;
    public final /* synthetic */ MetricData c;
    public final /* synthetic */ c d;
    public final /* synthetic */ LinkedHashMap<ScanType, UploadImage> e;
    public final /* synthetic */ com.socure.docv.capturesdk.common.upload.a f;

    public static final class a implements h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f543a;
        public final /* synthetic */ LinkedHashMap<ScanType, UploadImage> b;
        public final /* synthetic */ com.socure.docv.capturesdk.common.upload.a c;

        public a(c cVar, LinkedHashMap<ScanType, UploadImage> linkedHashMap, com.socure.docv.capturesdk.common.upload.a aVar) {
            this.f543a = cVar;
            this.b = linkedHashMap;
            this.c = aVar;
        }

        @Override // com.socure.docv.capturesdk.common.upload.h
        public void a() {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "uploadMetricData onSuccess called");
            this.f543a.a(this.b, this.c);
        }

        @Override // com.socure.docv.capturesdk.common.upload.h
        public void a(ApiResponse apiResponse) {
            Intrinsics.checkNotNullParameter(apiResponse, "apiResponse");
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "uploadMetricData onFailure called");
            this.c.a(new EventData("upload_failed", CollectionsKt.listOf(new Pair("type", "metric"))));
            EventData eventErrorData = UtilsKt.getEventErrorData(apiResponse.getHttpCode(), apiResponse.getHttpMsg(), apiResponse.getStatusCode(), apiResponse.getStatusMsg(), apiResponse.getApiType().getEndpoint());
            this.c.a(new EventData(eventErrorData.getEventName(), eventErrorData.getEventAttrList()));
            this.f543a.a(this.b, this.c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(i iVar, MetricData metricData, c cVar, LinkedHashMap<ScanType, UploadImage> linkedHashMap, com.socure.docv.capturesdk.common.upload.a aVar, Continuation<? super f> continuation) {
        super(2, continuation);
        this.b = iVar;
        this.c = metricData;
        this.d = cVar;
        this.e = linkedHashMap;
        this.f = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new f(this.b, this.c, this.d, this.e, this.f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f542a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            i iVar = this.b;
            MultipartBody.Part multiPartBodyFromMetricData = Utils.INSTANCE.getMultiPartBodyFromMetricData(this.c);
            a aVar = new a(this.d, this.e, this.f);
            this.f542a = 1;
            if (iVar.a(multiPartBodyFromMetricData, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
