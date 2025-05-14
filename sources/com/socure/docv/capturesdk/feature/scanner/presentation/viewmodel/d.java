package com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel;

import com.socure.docv.capturesdk.api.ResponseCode;
import com.socure.docv.capturesdk.common.upload.m;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.ScannerViewModel$updateDocUploadStatus$1", f = "ScannerViewModel.kt", i = {}, l = {477}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f539a;
    public final /* synthetic */ com.socure.docv.capturesdk.common.upload.c b;
    public final /* synthetic */ c c;
    public final /* synthetic */ com.socure.docv.capturesdk.common.upload.a d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(com.socure.docv.capturesdk.common.upload.c cVar, c cVar2, com.socure.docv.capturesdk.common.upload.a aVar, Continuation<? super d> continuation) {
        super(2, continuation);
        this.b = cVar;
        this.c = cVar2;
        this.d = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new d(this.b, this.c, this.d, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f539a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            com.socure.docv.capturesdk.common.upload.c cVar = this.b;
            this.f539a = 1;
            obj = cVar.a(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ApiResponse apiResponse = (ApiResponse) obj;
        if (apiResponse.getStatusCode() == ResponseCode.SUCCESS.getCode()) {
            this.c.j.postValue(new m.c(com.socure.docv.capturesdk.common.upload.f.UploadStatus, apiResponse));
        } else {
            this.d.a(UtilsKt.getEventErrorData(apiResponse.getHttpCode(), apiResponse.getHttpMsg(), apiResponse.getStatusCode(), apiResponse.getStatusMsg(), apiResponse.getApiType().getEndpoint()));
            this.c.j.postValue(new m.a(apiResponse));
        }
        return Unit.INSTANCE;
    }
}
