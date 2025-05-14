package com.socure.docv.capturesdk.common.stepup;

import com.socure.docv.capturesdk.common.network.model.ApiType;
import com.socure.docv.capturesdk.common.network.model.stepup.App;
import com.socure.docv.capturesdk.common.network.model.stepup.Consent;
import com.socure.docv.capturesdk.common.network.model.stepup.FlowData;
import com.socure.docv.capturesdk.common.network.model.stepup.StartUploadData;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;

/* loaded from: classes5.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f312a;
    public final com.socure.docv.capturesdk.common.network.repository.d b;
    public final j c;
    public List<Call<?>> d;
    public Map<ApiType, Object> e;

    public i(String authToken, com.socure.docv.capturesdk.common.network.repository.d repo, j stepUpSubApiCallBack) {
        Intrinsics.checkNotNullParameter(authToken, "authToken");
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(stepUpSubApiCallBack, "stepUpSubApiCallBack");
        this.f312a = authToken;
        this.b = repo;
        this.c = stepUpSubApiCallBack;
        this.d = new ArrayList();
        this.e = new LinkedHashMap();
    }

    public static final void a(i iVar, ApiResponse apiResponse) {
        iVar.getClass();
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "triggerFailureCallback called");
        if (!(!iVar.d.isEmpty())) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "triggerFailureCallback is called again", null, 4, null);
            return;
        }
        List<Call<?>> list = iVar.d;
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "cancelCalls called");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((Call) it.next()).cancel();
        }
        iVar.d.clear();
        iVar.c.a(apiResponse);
    }

    public final ApiResponse a(ApiType apiType, Throwable th) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "getApiResponse called message: " + th.getMessage());
        return ExtensionsKt.getApiResponse(th, apiType);
    }

    public static final void a(i iVar) {
        iVar.getClass();
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "triggerSuccessCallback called");
        Set<ApiType> keySet = iVar.e.keySet();
        ApiType apiType = ApiType.START_UPLOAD;
        ApiType apiType2 = ApiType.CONFIG;
        ApiType apiType3 = ApiType.FLOW;
        ApiType apiType4 = ApiType.FETCH_CONSENT;
        if (!keySet.containsAll(CollectionsKt.listOf((Object[]) new ApiType[]{apiType, apiType2, apiType3, apiType4}))) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "outputMap is not full yet");
            return;
        }
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "outputMap contain all apiType");
        j jVar = iVar.c;
        Object obj = iVar.e.get(apiType);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.socure.docv.capturesdk.common.network.model.stepup.StartUploadData");
        }
        StartUploadData startUploadData = (StartUploadData) obj;
        Object obj2 = iVar.e.get(apiType3);
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.socure.docv.capturesdk.common.network.model.stepup.FlowData");
        }
        FlowData flowData = (FlowData) obj2;
        Object obj3 = iVar.e.get(apiType2);
        if (obj3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.socure.docv.capturesdk.common.network.model.stepup.App");
        }
        App app = (App) obj3;
        Object obj4 = iVar.e.get(apiType4);
        if (obj4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.socure.docv.capturesdk.common.network.model.stepup.Consent");
        }
        jVar.a(startUploadData, flowData, app, (Consent) obj4);
    }
}
