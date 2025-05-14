package com.socure.docv.capturesdk.common.stepup;

import com.socure.docv.capturesdk.common.network.model.ApiType;
import com.socure.docv.capturesdk.common.network.model.stepup.App;
import com.socure.docv.capturesdk.common.network.model.stepup.ConfigData;
import com.socure.docv.capturesdk.common.network.model.stepup.ConfigResponse;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes5.dex */
public final class f implements Callback<ConfigResponse> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f309a;

    public f(i iVar) {
        this.f309a = iVar;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<ConfigResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        if (call.isCanceled()) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "onFailure apiType: " + ApiType.CONFIG + " cancelled");
        } else {
            i iVar = this.f309a;
            i.a(iVar, iVar.a(ApiType.CONFIG, t));
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<ConfigResponse> call, Response<ConfigResponse> configResponse) {
        i iVar;
        ApiResponse apiResponse;
        Unit unit;
        ConfigData data;
        App app;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(configResponse, "configResponse");
        if (configResponse.isSuccessful()) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "configResponse is successful");
            ConfigResponse body = configResponse.body();
            if (body == null || (data = body.getData()) == null || (app = data.getApp()) == null) {
                unit = null;
            } else {
                i iVar2 = this.f309a;
                iVar2.e.put(ApiType.CONFIG, app);
                i.a(iVar2);
                unit = Unit.INSTANCE;
            }
            if (unit != null) {
                return;
            }
            iVar = this.f309a;
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "configResponse app is null");
            apiResponse = ExtensionsKt.toUnKnownApiResponse(ApiType.CONFIG);
        } else {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "configResponse is not successful");
            iVar = this.f309a;
            apiResponse = ExtensionsKt.toApiResponse(configResponse, ApiType.CONFIG);
        }
        i.a(iVar, apiResponse);
    }
}
