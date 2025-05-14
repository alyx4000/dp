package com.socure.docv.capturesdk.common.upload;

import com.socure.docv.capturesdk.common.network.model.stepup.UpdateStatusRequest;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final UpdateStatusRequest f318a;
    public final com.socure.docv.capturesdk.common.network.repository.d b;

    @DebugMetadata(c = "com.socure.docv.capturesdk.common.upload.UpdateDocUploadStatusTask", f = "UpdateDocUploadStatusTask.kt", i = {0}, l = {31}, m = "proceed", n = {"this"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f319a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return c.this.a(this);
        }
    }

    public c(com.socure.docv.capturesdk.common.network.repository.d stepUpRepository, UpdateStatusRequest updateStatusRequest) {
        Intrinsics.checkNotNullParameter(stepUpRepository, "stepUpRepository");
        Intrinsics.checkNotNullParameter(updateStatusRequest, "updateStatusRequest");
        this.f318a = updateStatusRequest;
        this.b = stepUpRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0074 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:11:0x002d, B:12:0x006c, B:14:0x0074, B:17:0x00a7), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a7 A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:11:0x002d, B:12:0x006c, B:14:0x0074, B:17:0x00a7), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super com.socure.docv.capturesdk.core.pipeline.model.ApiResponse> r13) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socure.docv.capturesdk.common.upload.c.a(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
