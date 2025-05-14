package com.socure.docv.capturesdk.common.network.transport;

import com.socure.docv.capturesdk.common.network.model.stepup.ConfigResponse;
import com.socure.docv.capturesdk.common.network.model.stepup.ConsentGetResponse;
import com.socure.docv.capturesdk.common.network.model.stepup.ConsentPostRequest;
import com.socure.docv.capturesdk.common.network.model.stepup.ConsentPostResponse;
import com.socure.docv.capturesdk.common.network.model.stepup.FlowResponse;
import com.socure.docv.capturesdk.common.network.model.stepup.StartSessionRequest;
import com.socure.docv.capturesdk.common.network.model.stepup.StartSessionResponse;
import com.socure.docv.capturesdk.common.network.model.stepup.StartUploadResponse;
import com.socure.docv.capturesdk.common.network.model.stepup.UpdateStatusRequest;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadEndRequest;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadEndResponse;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadStatusResponse;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

@Metadata(bv = {}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J9\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H'J$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H'J$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b2\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H'J9\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0001\u0010\u0012\u001a\u00020\u0011H§@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0014J9\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00170\u00072\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0001\u0010\u0016\u001a\u00020\u0015H§@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0018J$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000b2\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H'J9\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00072\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u001bH§@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/transport/c;", "", "", "", "headers", "Lcom/socure/docv/capturesdk/common/network/model/stepup/StartSessionRequest;", "startSessionRequest", "Lretrofit2/Response;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/StartSessionResponse;", "a", "(Ljava/util/Map;Lcom/socure/docv/capturesdk/common/network/model/stepup/StartSessionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lretrofit2/Call;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/StartUploadResponse;", "d", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ConfigResponse;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/FlowResponse;", "c", "Lcom/socure/docv/capturesdk/common/network/model/stepup/UpdateStatusRequest;", "updateStatusRequest", "Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadStatusResponse;", "(Ljava/util/Map;Lcom/socure/docv/capturesdk/common/network/model/stepup/UpdateStatusRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadEndRequest;", "uploadEndRequest", "Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadEndResponse;", "(Ljava/util/Map;Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadEndRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentGetResponse;", "b", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentPostRequest;", "consentPostRequest", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentPostResponse;", "(Ljava/util/Map;Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentPostRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public interface c {
    @POST(ApiConstant.POST_CONSENT_URL)
    Object a(@HeaderMap Map<String, String> map, @Body ConsentPostRequest consentPostRequest, Continuation<? super Response<ConsentPostResponse>> continuation);

    @POST(ApiConstant.STEP_UP_START_URL)
    Object a(@HeaderMap Map<String, String> map, @Body StartSessionRequest startSessionRequest, Continuation<? super Response<StartSessionResponse>> continuation);

    @POST(ApiConstant.UPDATE_STATUS_URL)
    Object a(@HeaderMap Map<String, String> map, @Body UpdateStatusRequest updateStatusRequest, Continuation<? super Response<UploadStatusResponse>> continuation);

    @POST(ApiConstant.END_UPLOAD_URL)
    Object a(@HeaderMap Map<String, String> map, @Body UploadEndRequest uploadEndRequest, Continuation<? super Response<UploadEndResponse>> continuation);

    @GET(ApiConstant.STEP_UP_CONFIG_URL)
    Call<ConfigResponse> a(@HeaderMap Map<String, String> headers);

    @GET(ApiConstant.GET_CONSENT_URL)
    Call<ConsentGetResponse> b(@HeaderMap Map<String, String> headers);

    @GET(ApiConstant.STEP_UP_FLOW_URL)
    Call<FlowResponse> c(@HeaderMap Map<String, String> headers);

    @POST(ApiConstant.STEP_UP_START_UPLOAD_URL)
    Call<StartUploadResponse> d(@HeaderMap Map<String, String> headers);
}
