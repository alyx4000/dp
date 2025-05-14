package com.socure.docv.capturesdk.common.stepup;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineScope f307a;
    public final com.socure.docv.capturesdk.common.network.repository.d b;

    public c(CoroutineScope scope, com.socure.docv.capturesdk.common.network.repository.d repo) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(repo, "repo");
        this.f307a = scope;
        this.b = repo;
    }
}
