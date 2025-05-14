package com.socure.docv.capturesdk.common.upload;

import com.socure.docv.capturesdk.common.network.model.stepup.UploadImage;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;

/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, String> f333a;
    public final String b;
    public final RequestBody c;
    public final RequestBody d;
    public final com.socure.docv.capturesdk.common.network.repository.e e;
    public final UploadImage f;

    @DebugMetadata(c = "com.socure.docv.capturesdk.common.upload.UploadTask", f = "UploadImageTask.kt", i = {0, 0}, l = {25}, m = "upload", n = {"this", "uploadTaskCallback"}, s = {"L$0", "L$1"})
    public static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f334a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return n.this.a(null, this);
        }
    }

    public n(Map<String, String> header, String url, RequestBody docTypeRequestBody, RequestBody consentId, com.socure.docv.capturesdk.common.network.repository.e uploadRepository, UploadImage uploadImage) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(docTypeRequestBody, "docTypeRequestBody");
        Intrinsics.checkNotNullParameter(consentId, "consentId");
        Intrinsics.checkNotNullParameter(uploadRepository, "uploadRepository");
        Intrinsics.checkNotNullParameter(uploadImage, "uploadImage");
        this.f333a = header;
        this.b = url;
        this.c = docTypeRequestBody;
        this.d = consentId;
        this.e = uploadRepository;
        this.f = uploadImage;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007e A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x003e, blocks: (B:11:0x003a, B:12:0x0076, B:14:0x007e, B:16:0x00a6, B:18:0x00b5, B:23:0x00d6), top: B:10:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d6 A[Catch: all -> 0x003e, TRY_LEAVE, TryCatch #1 {all -> 0x003e, blocks: (B:11:0x003a, B:12:0x0076, B:14:0x007e, B:16:0x00a6, B:18:0x00b5, B:23:0x00d6), top: B:10:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(com.socure.docv.capturesdk.common.upload.o r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socure.docv.capturesdk.common.upload.n.a(com.socure.docv.capturesdk.common.upload.o, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
