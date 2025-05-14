package com.socure.docv.capturesdk.common.upload;

import com.socure.docv.capturesdk.common.utils.ApiConstant;
import java.io.File;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;

/* loaded from: classes5.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, String> f326a;
    public final RequestBody b;
    public final RequestBody c;
    public final com.socure.docv.capturesdk.common.network.repository.e d;

    @DebugMetadata(c = "com.socure.docv.capturesdk.common.upload.UploadMetricsTask", f = "UploadMetricsTask.kt", i = {0}, l = {23}, m = "upload", n = {"uploadMetricCallback"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f327a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return i.this.a(null, null, this);
        }
    }

    public i(Map<String, String> customHeader, RequestBody docTypeRequestBody, RequestBody consentId, com.socure.docv.capturesdk.common.network.repository.e mUploadRepository) {
        Intrinsics.checkNotNullParameter(customHeader, "customHeader");
        Intrinsics.checkNotNullParameter(docTypeRequestBody, "docTypeRequestBody");
        Intrinsics.checkNotNullParameter(consentId, "consentId");
        Intrinsics.checkNotNullParameter(mUploadRepository, "mUploadRepository");
        this.f326a = customHeader;
        this.b = docTypeRequestBody;
        this.c = consentId;
        this.d = mUploadRepository;
    }

    public final String a() {
        com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
        String str = com.socure.docv.capturesdk.common.session.a.e;
        if (str == null) {
            return ApiConstant.UPLOAD_URL;
        }
        String str2 = ApiConstant.UPLOAD_URL + File.separator + str;
        return str2 == null ? ApiConstant.UPLOAD_URL : str2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(2:3|(8:5|6|7|(1:(2:10|11)(2:19|20))(3:21|22|(1:24))|12|(1:14)(1:18)|15|16))|27|6|7|(0)(0)|12|(0)(0)|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a7, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a8, code lost:
    
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_UMT", "upload metric error: " + r10.getLocalizedMessage());
        r11.a(com.socure.docv.capturesdk.common.utils.ExtensionsKt.getApiResponse(r10, com.socure.docv.capturesdk.common.network.model.ApiType.IMAGE_UPLOAD));
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067 A[Catch: all -> 0x00a7, TryCatch #0 {all -> 0x00a7, blocks: (B:11:0x002d, B:12:0x005f, B:14:0x0067, B:18:0x0070, B:22:0x003c), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070 A[Catch: all -> 0x00a7, TRY_LEAVE, TryCatch #0 {all -> 0x00a7, blocks: (B:11:0x002d, B:12:0x005f, B:14:0x0067, B:18:0x0070, B:22:0x003c), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(okhttp3.MultipartBody.Part r10, com.socure.docv.capturesdk.common.upload.h r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.socure.docv.capturesdk.common.upload.i.a
            if (r0 == 0) goto L13
            r0 = r12
            com.socure.docv.capturesdk.common.upload.i$a r0 = (com.socure.docv.capturesdk.common.upload.i.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.socure.docv.capturesdk.common.upload.i$a r0 = new com.socure.docv.capturesdk.common.upload.i$a
            r0.<init>(r12)
        L18:
            r7 = r0
            java.lang.Object r12 = r7.b
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.d
            r2 = 1
            java.lang.String r8 = "SDLT_UMT"
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            java.lang.Object r10 = r7.f327a
            r11 = r10
            com.socure.docv.capturesdk.common.upload.h r11 = (com.socure.docv.capturesdk.common.upload.h) r11
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> La7
            goto L5f
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L39:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.String r12 = "UploadMetricsTask's upload called"
            com.socure.docv.capturesdk.common.logger.b.a(r8, r12)     // Catch: java.lang.Throwable -> La7
            com.socure.docv.capturesdk.common.network.repository.e r12 = r9.d     // Catch: java.lang.Throwable -> La7
            java.util.Map<java.lang.String, java.lang.String> r3 = r9.f326a     // Catch: java.lang.Throwable -> La7
            java.lang.String r4 = r9.a()     // Catch: java.lang.Throwable -> La7
            okhttp3.RequestBody r5 = r9.b     // Catch: java.lang.Throwable -> La7
            okhttp3.RequestBody r6 = r9.c     // Catch: java.lang.Throwable -> La7
            r7.f327a = r11     // Catch: java.lang.Throwable -> La7
            r7.d = r2     // Catch: java.lang.Throwable -> La7
            com.socure.docv.capturesdk.common.network.transport.d r1 = r12.f302a     // Catch: java.lang.Throwable -> La7
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r10
            java.lang.Object r12 = r1.a(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> La7
            if (r12 != r0) goto L5f
            return r0
        L5f:
            retrofit2.Response r12 = (retrofit2.Response) r12     // Catch: java.lang.Throwable -> La7
            boolean r10 = r12.isSuccessful()     // Catch: java.lang.Throwable -> La7
            if (r10 == 0) goto L70
            java.lang.String r10 = "upload metric success"
            com.socure.docv.capturesdk.common.logger.b.a(r8, r10)     // Catch: java.lang.Throwable -> La7
            r11.a()     // Catch: java.lang.Throwable -> La7
            goto Lc7
        L70:
            java.lang.String r10 = "upload metric failure"
            com.socure.docv.capturesdk.common.logger.b.a(r8, r10)     // Catch: java.lang.Throwable -> La7
            okhttp3.ResponseBody r10 = r12.errorBody()     // Catch: java.lang.Throwable -> La7
            kotlin.Pair r10 = com.socure.docv.capturesdk.common.utils.ErrorHandlerKt.getErrorSocureSdkResponseHttpInfo(r10)     // Catch: java.lang.Throwable -> La7
            com.socure.docv.capturesdk.core.pipeline.model.ApiResponse r6 = new com.socure.docv.capturesdk.core.pipeline.model.ApiResponse     // Catch: java.lang.Throwable -> La7
            com.socure.docv.capturesdk.common.network.model.ApiType r1 = com.socure.docv.capturesdk.common.network.model.ApiType.IMAGE_UPLOAD     // Catch: java.lang.Throwable -> La7
            java.lang.Object r0 = r10.getFirst()     // Catch: java.lang.Throwable -> La7
            java.lang.Number r0 = (java.lang.Number) r0     // Catch: java.lang.Throwable -> La7
            int r2 = r0.intValue()     // Catch: java.lang.Throwable -> La7
            java.lang.Object r10 = r10.getSecond()     // Catch: java.lang.Throwable -> La7
            r3 = r10
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> La7
            int r4 = r12.code()     // Catch: java.lang.Throwable -> La7
            java.lang.String r5 = r12.message()     // Catch: java.lang.Throwable -> La7
            java.lang.String r10 = "response.message()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r10)     // Catch: java.lang.Throwable -> La7
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> La7
            r11.a(r6)     // Catch: java.lang.Throwable -> La7
            goto Lc7
        La7:
            r10 = move-exception
            java.lang.String r12 = r10.getLocalizedMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "upload metric error: "
            r0.<init>(r1)
            java.lang.StringBuilder r12 = r0.append(r12)
            java.lang.String r12 = r12.toString()
            com.socure.docv.capturesdk.common.logger.b.a(r8, r12)
            com.socure.docv.capturesdk.common.network.model.ApiType r12 = com.socure.docv.capturesdk.common.network.model.ApiType.IMAGE_UPLOAD
            com.socure.docv.capturesdk.core.pipeline.model.ApiResponse r10 = com.socure.docv.capturesdk.common.utils.ExtensionsKt.getApiResponse(r10, r12)
            r11.a(r10)
        Lc7:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socure.docv.capturesdk.common.upload.i.a(okhttp3.MultipartBody$Part, com.socure.docv.capturesdk.common.upload.h, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
