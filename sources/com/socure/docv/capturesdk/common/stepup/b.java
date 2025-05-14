package com.socure.docv.capturesdk.common.stepup;

import com.socure.docv.capturesdk.api.ResponseCode;
import com.socure.docv.capturesdk.common.network.model.ApiType;
import com.socure.docv.capturesdk.common.network.model.stepup.ConsentData;
import com.socure.docv.capturesdk.common.network.model.stepup.ConsentPostRequest;
import com.socure.docv.capturesdk.common.network.model.stepup.ConsentPostResponse;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import com.socure.docv.capturesdk.common.utils.ErrorHandlerKt;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import com.socure.docv.capturesdk.common.utils.HeaderUtils;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;

@DebugMetadata(c = "com.socure.docv.capturesdk.common.stepup.ConsentTask$call$1", f = "ConsentTask.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f306a;
    public final /* synthetic */ c b;
    public final /* synthetic */ ConsentPostRequest c;
    public final /* synthetic */ a d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, ConsentPostRequest consentPostRequest, a aVar, Continuation<? super b> continuation) {
        super(2, continuation);
        this.b = cVar;
        this.c = consentPostRequest;
        this.d = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new b(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new b(this.b, this.c, this.d, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Response response;
        a aVar;
        ApiResponse apiResponse;
        Unit unit;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f306a;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                com.socure.docv.capturesdk.common.network.repository.d dVar = this.b.b;
                Map<String, String> stepHeader = HeaderUtils.INSTANCE.getStepHeader(com.socure.docv.capturesdk.common.session.a.f305a.e());
                ConsentPostRequest consentPostRequest = this.c;
                this.f306a = 1;
                obj = dVar.f301a.a(stepHeader, consentPostRequest, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            response = (Response) obj;
        } catch (Throwable th) {
            if (th instanceof CancellationException) {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_CT", "CancellationException");
            } else {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_CT", "consent call Exception " + th.getLocalizedMessage(), null, 4, null);
                this.d.a(ExtensionsKt.getApiResponse(th, ApiType.POST_CONSENT));
            }
        }
        if (response.isSuccessful()) {
            ConsentPostResponse consentPostResponse = (ConsentPostResponse) response.body();
            if (consentPostResponse != null) {
                a aVar2 = this.d;
                ConsentData data = consentPostResponse.getData();
                ApiType apiType = ApiType.POST_CONSENT;
                ResponseCode responseCode = ResponseCode.SUCCESS;
                int code = responseCode.getCode();
                String message = responseCode.getMessage();
                int code2 = response.code();
                String message2 = response.message();
                Intrinsics.checkNotNullExpressionValue(message2, "response.message()");
                aVar2.a(data, new ApiResponse(apiType, code, message, code2, message2));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                aVar = this.d;
                apiResponse = new ApiResponse(ApiType.POST_CONSENT, ResponseCode.UNKNOWN_ERROR.getCode(), "upload_response_null", -1, ConstantsKt.MESSAGE_NOT_AVAILABLE);
            }
            return Unit.INSTANCE;
        }
        Pair<Integer, String> errorSocureSdkResponseHttpInfo = ErrorHandlerKt.getErrorSocureSdkResponseHttpInfo(response.errorBody());
        a aVar3 = this.d;
        ApiType apiType2 = ApiType.POST_CONSENT;
        int intValue = errorSocureSdkResponseHttpInfo.getFirst().intValue();
        String second = errorSocureSdkResponseHttpInfo.getSecond();
        int code3 = response.code();
        String message3 = response.message();
        Intrinsics.checkNotNullExpressionValue(message3, "response.message()");
        aVar = aVar3;
        apiResponse = new ApiResponse(apiType2, intValue, second, code3, message3);
        aVar.a(apiResponse);
        return Unit.INSTANCE;
    }
}
