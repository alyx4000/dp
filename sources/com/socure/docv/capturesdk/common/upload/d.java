package com.socure.docv.capturesdk.common.upload;

import com.socure.docv.capturesdk.api.ResponseCode;
import com.socure.docv.capturesdk.common.network.model.ApiType;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadEndRequest;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import com.socure.docv.capturesdk.common.utils.ErrorHandlerKt;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import com.socure.docv.capturesdk.common.utils.HeaderUtils;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;

@DebugMetadata(c = "com.socure.docv.capturesdk.common.upload.UpdateEndTask$proceed$1", f = "UpdateEndTask.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f320a;
    public final /* synthetic */ e b;
    public final /* synthetic */ Function1<ApiResponse, Unit> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(e eVar, Function1<? super ApiResponse, Unit> function1, Continuation<? super d> continuation) {
        super(2, continuation);
        this.b = eVar;
        this.c = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new d(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Function1<ApiResponse, Unit> function1;
        ApiResponse apiResponse;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f320a;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HeaderUtils headerUtils = HeaderUtils.INSTANCE;
                com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
                Map<String, String> primaryHeader = headerUtils.getPrimaryHeader(aVar.d());
                Map<String, String> stepHeader = headerUtils.getStepHeader(aVar.e());
                Map<String, String> mutableMap = MapsKt.toMutableMap(primaryHeader);
                mutableMap.putAll(stepHeader);
                e eVar = this.b;
                com.socure.docv.capturesdk.common.network.repository.d dVar = eVar.c;
                UploadEndRequest uploadEndRequest = eVar.b;
                this.f320a = 1;
                obj = dVar.f301a.a(mutableMap, uploadEndRequest, this);
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
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_UET", "EndUpdateStatus is Successful");
                function1 = this.c;
                ApiType apiType = ApiType.UPLOAD_END;
                ResponseCode responseCode = ResponseCode.SUCCESS;
                apiResponse = new ApiResponse(apiType, responseCode.getCode(), responseCode.getMessage(), -1, ConstantsKt.MESSAGE_NOT_AVAILABLE);
            } else {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_UET", "EndUpdateStatus is not Successful");
                Pair<Integer, String> errorSocureSdkResponseHttpInfo = ErrorHandlerKt.getErrorSocureSdkResponseHttpInfo(response.errorBody());
                Function1<ApiResponse, Unit> function12 = this.c;
                ApiType apiType2 = ApiType.UPLOAD_END;
                int intValue = errorSocureSdkResponseHttpInfo.getFirst().intValue();
                String second = errorSocureSdkResponseHttpInfo.getSecond();
                int code = response.code();
                String message = response.message();
                Intrinsics.checkNotNullExpressionValue(message, "statusResponse.message()");
                function1 = function12;
                apiResponse = new ApiResponse(apiType2, intValue, second, code, message);
            }
            function1.invoke(apiResponse);
        } catch (Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_UET", "EndUpdateStatus error:" + th.getMessage(), null, 4, null);
            this.c.invoke(ExtensionsKt.getApiResponse(th, ApiType.UPLOAD_END));
        }
        return Unit.INSTANCE;
    }
}
