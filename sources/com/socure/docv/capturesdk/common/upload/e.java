package com.socure.docv.capturesdk.common.upload;

import com.socure.docv.capturesdk.common.network.model.stepup.UploadEndRequest;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineScope f321a;
    public final UploadEndRequest b;
    public final com.socure.docv.capturesdk.common.network.repository.d c;

    public e(com.socure.docv.capturesdk.common.network.repository.d stepUpRepository, CoroutineScope updateCoroutineScope, UploadEndRequest uploadEndRequest) {
        Intrinsics.checkNotNullParameter(stepUpRepository, "stepUpRepository");
        Intrinsics.checkNotNullParameter(updateCoroutineScope, "updateCoroutineScope");
        Intrinsics.checkNotNullParameter(uploadEndRequest, "uploadEndRequest");
        this.f321a = updateCoroutineScope;
        this.b = uploadEndRequest;
        this.c = stepUpRepository;
    }
}
