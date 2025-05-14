package com.socure.docv.capturesdk.common.stepup;

import com.socure.docv.capturesdk.api.ResponseCode;
import com.socure.docv.capturesdk.common.network.model.ApiType;
import com.socure.docv.capturesdk.common.network.model.stepup.App;
import com.socure.docv.capturesdk.common.network.model.stepup.ConfigResponse;
import com.socure.docv.capturesdk.common.network.model.stepup.Consent;
import com.socure.docv.capturesdk.common.network.model.stepup.ConsentGetResponse;
import com.socure.docv.capturesdk.common.network.model.stepup.Data;
import com.socure.docv.capturesdk.common.network.model.stepup.FlowData;
import com.socure.docv.capturesdk.common.network.model.stepup.FlowResponse;
import com.socure.docv.capturesdk.common.network.model.stepup.StartSessionRequest;
import com.socure.docv.capturesdk.common.network.model.stepup.StartSessionResponse;
import com.socure.docv.capturesdk.common.network.model.stepup.StartUploadData;
import com.socure.docv.capturesdk.common.network.model.stepup.StartUploadResponse;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import com.socure.docv.capturesdk.common.utils.HeaderUtils;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Call;
import retrofit2.Response;

@DebugMetadata(c = "com.socure.docv.capturesdk.common.stepup.StepUpTask$proceed$1", f = "StepUpTask.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class k extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f313a;
    public final /* synthetic */ l b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(l lVar, Continuation<? super k> continuation) {
        super(2, continuation);
        this.b = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new k(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new k(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f313a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            l lVar = this.b;
            com.socure.docv.capturesdk.common.network.repository.d dVar = lVar.f315a;
            Map<String, String> primaryHeader = HeaderUtils.INSTANCE.getPrimaryHeader(lVar.b);
            StartSessionRequest startSessionRequest = new StartSessionRequest(null, 0, this.b.c, 3, null);
            this.f313a = 1;
            obj = dVar.f301a.a(primaryHeader, startSessionRequest, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Response response = (Response) obj;
        if (response.isSuccessful()) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "start session call succeeded");
            l lVar2 = this.b;
            StartSessionResponse startSessionResponse = (StartSessionResponse) response.body();
            Unit unit = null;
            lVar2.e = startSessionResponse != null ? startSessionResponse.getData() : null;
            l lVar3 = this.b;
            Data data = lVar3.e;
            if (data != null) {
                i iVar = new i(data.getReferenceId(), lVar3.f315a, new a(lVar3, data));
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "StepUpCallsHandler proceed called");
                com.socure.docv.capturesdk.common.network.repository.d dVar2 = iVar.b;
                HeaderUtils headerUtils = HeaderUtils.INSTANCE;
                Map<String, String> customHeaders = headerUtils.getStepHeader(iVar.f312a);
                dVar2.getClass();
                Intrinsics.checkNotNullParameter(customHeaders, "customHeaders");
                Call<StartUploadResponse> d = dVar2.f301a.d(customHeaders);
                com.socure.docv.capturesdk.common.network.repository.d dVar3 = iVar.b;
                Map<String, String> customHeaders2 = headerUtils.getStepHeader(iVar.f312a);
                dVar3.getClass();
                Intrinsics.checkNotNullParameter(customHeaders2, "customHeaders");
                Call<ConfigResponse> a2 = dVar3.f301a.a(customHeaders2);
                com.socure.docv.capturesdk.common.network.repository.d dVar4 = iVar.b;
                Map<String, String> customHeaders3 = headerUtils.getStepHeader(iVar.f312a);
                dVar4.getClass();
                Intrinsics.checkNotNullParameter(customHeaders3, "customHeaders");
                Call<FlowResponse> c = dVar4.f301a.c(customHeaders3);
                com.socure.docv.capturesdk.common.network.repository.d dVar5 = iVar.b;
                Map<String, String> headers = headerUtils.getStepHeader(iVar.f312a);
                dVar5.getClass();
                Intrinsics.checkNotNullParameter(headers, "headers");
                Call<ConsentGetResponse> b = dVar5.f301a.b(headers);
                iVar.d.add(d);
                iVar.d.add(a2);
                iVar.d.add(c);
                iVar.d.add(b);
                d.enqueue(new e(iVar));
                a2.enqueue(new f(iVar));
                c.enqueue(new g(iVar));
                b.enqueue(new h(iVar));
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                l lVar4 = this.b;
                d dVar6 = lVar4.d;
                Data data2 = lVar4.e;
                ApiType apiType = ApiType.START;
                ResponseCode responseCode = ResponseCode.UNKNOWN_ERROR;
                dVar6.a(data2, new ApiResponse(apiType, responseCode.getCode(), responseCode.getMessage(), -1, ConstantsKt.MESSAGE_NOT_AVAILABLE));
            }
        } else {
            l lVar5 = this.b;
            lVar5.d.a(lVar5.e, ExtensionsKt.toApiResponse(response, ApiType.START));
        }
        return Unit.INSTANCE;
    }

    public static final class a implements j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f314a;
        public final /* synthetic */ Data b;

        public a(l lVar, Data data) {
            this.f314a = lVar;
            this.b = data;
        }

        @Override // com.socure.docv.capturesdk.common.stepup.j
        public void a(ApiResponse apiResponse) {
            Intrinsics.checkNotNullParameter(apiResponse, "apiResponse");
            l lVar = this.f314a;
            lVar.d.a(lVar.e, apiResponse);
        }

        @Override // com.socure.docv.capturesdk.common.stepup.j
        public void a(StartUploadData startUploadData, FlowData flowData, App configApp, Consent consentData) {
            Intrinsics.checkNotNullParameter(startUploadData, "startUploadData");
            Intrinsics.checkNotNullParameter(flowData, "flowData");
            Intrinsics.checkNotNullParameter(configApp, "configApp");
            Intrinsics.checkNotNullParameter(consentData, "consentData");
            ApiType apiType = ApiType.START;
            ResponseCode responseCode = ResponseCode.SUCCESS;
            this.f314a.d.a(this.b, startUploadData, flowData, configApp, consentData, new ApiResponse(apiType, responseCode.getCode(), responseCode.getMessage(), -1, ConstantsKt.MESSAGE_NOT_AVAILABLE));
        }
    }
}
