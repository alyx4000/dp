package com.socure.docv.capturesdk.common.stepup;

import com.socure.docv.capturesdk.common.network.model.ApiType;
import com.socure.docv.capturesdk.common.network.model.stepup.FlowData;
import com.socure.docv.capturesdk.common.network.model.stepup.FlowResponse;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes5.dex */
public final class g implements Callback<FlowResponse> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f310a;

    public g(i iVar) {
        this.f310a = iVar;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<FlowResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        if (call.isCanceled()) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "onFailure apiType: " + ApiType.FLOW + " cancelled");
        } else {
            i iVar = this.f310a;
            i.a(iVar, iVar.a(ApiType.FLOW, t));
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<FlowResponse> call, Response<FlowResponse> flowResponse) {
        i iVar;
        ApiResponse apiResponse;
        Unit unit;
        FlowData data;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(flowResponse, "flowResponse");
        if (flowResponse.isSuccessful()) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "flowResponse is successful");
            FlowResponse body = flowResponse.body();
            if (body == null || (data = body.getData()) == null) {
                unit = null;
            } else {
                i iVar2 = this.f310a;
                iVar2.e.put(ApiType.FLOW, data);
                i.a(iVar2);
                unit = Unit.INSTANCE;
            }
            if (unit != null) {
                return;
            }
            iVar = this.f310a;
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "flowResponse flowData is null");
            apiResponse = ExtensionsKt.toUnKnownApiResponse(ApiType.FLOW);
        } else {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "flowResponse is not successful");
            iVar = this.f310a;
            apiResponse = ExtensionsKt.toApiResponse(flowResponse, ApiType.FLOW);
        }
        i.a(iVar, apiResponse);
    }
}
