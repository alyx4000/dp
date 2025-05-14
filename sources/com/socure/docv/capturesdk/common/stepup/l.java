package com.socure.docv.capturesdk.common.stepup;

import com.socure.docv.capturesdk.common.network.model.ApiType;
import com.socure.docv.capturesdk.common.network.model.stepup.Data;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import com.socure.docv.capturesdk.feature.orchestrator.data.ConfigRequest;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* loaded from: classes5.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final com.socure.docv.capturesdk.common.network.repository.d f315a;
    public final String b;
    public final ConfigRequest c;
    public final d d;
    public Data e;
    public final CoroutineExceptionHandler f;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f316a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CoroutineExceptionHandler.Companion companion, l lVar) {
            super(companion);
            this.f316a = lVar;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext coroutineContext, Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "stepUpExceptionHandler called");
            if (th instanceof CancellationException) {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "CancellationException");
            } else {
                l lVar = this.f316a;
                lVar.d.a(lVar.e, ExtensionsKt.getApiResponse(th, ApiType.START));
            }
        }
    }

    public l(com.socure.docv.capturesdk.common.network.repository.d repo, String publicKey, ConfigRequest configFlowData, d stepUpCallBack) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        Intrinsics.checkNotNullParameter(configFlowData, "configFlowData");
        Intrinsics.checkNotNullParameter(stepUpCallBack, "stepUpCallBack");
        this.f315a = repo;
        this.b = publicKey;
        this.c = configFlowData;
        this.d = stepUpCallBack;
        this.f = new a(CoroutineExceptionHandler.INSTANCE, this);
    }
}
