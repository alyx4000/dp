package com.socure.docv.capturesdk.common.upload;

import com.socure.docv.capturesdk.common.network.model.stepup.UploadImage;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadResult;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.socure.docv.capturesdk.common.upload.UploadProcessor$uploadImage$1", f = "UploadProcessor.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f328a;
    public final /* synthetic */ n b;
    public final /* synthetic */ k c;

    public static final class a implements o {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f329a;

        public a(k kVar) {
            this.f329a = kVar;
        }

        @Override // com.socure.docv.capturesdk.common.upload.o
        public void a(UploadImage uploadImage, UploadResult uploadResult, int i) {
            Intrinsics.checkNotNullParameter(uploadImage, "uploadImage");
            Intrinsics.checkNotNullParameter(uploadResult, "uploadResult");
            this.f329a.a(uploadImage, uploadResult, i);
        }

        @Override // com.socure.docv.capturesdk.common.upload.o
        public void a(UploadImage uploadImage, ApiResponse apiResponse) {
            Intrinsics.checkNotNullParameter(uploadImage, "uploadImage");
            Intrinsics.checkNotNullParameter(apiResponse, "apiResponse");
            this.f329a.a(uploadImage, apiResponse);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(n nVar, k kVar, Continuation<? super j> continuation) {
        super(2, continuation);
        this.b = nVar;
        this.c = kVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new j(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new j(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f328a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            n nVar = this.b;
            a aVar = new a(this.c);
            this.f328a = 1;
            if (nVar.a(aVar, this) == coroutine_suspended) {
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
