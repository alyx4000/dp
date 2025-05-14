package com.socure.docv.capturesdk.common.network.repository;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final com.socure.docv.capturesdk.common.network.transport.d f302a;

    public e(com.socure.docv.capturesdk.common.network.transport.d uploadApiService) {
        Intrinsics.checkNotNullParameter(uploadApiService, "uploadApiService");
        this.f302a = uploadApiService;
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_UR", "UploadRepository init");
    }
}
