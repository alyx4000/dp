package com.socure.idplus.device.internal.api;

import com.socure.idplus.device.internal.behavior.model.SessionDataRequest;
import com.socure.idplus.device.internal.behavior.model.SessionDataResponse;
import com.socure.idplus.device.internal.sigmaDeviceConfig.model.SigmaDeviceConfigResponse;
import com.socure.idplus.device.internal.sigmaDeviceLocation.model.SigmaDeviceLocationModel;
import com.socure.idplus.device.internal.sigmaDeviceSession.model.SigmaDeviceSessionModel;
import com.socure.idplus.device.internal.sigmaDeviceV2.model.SigmaDeviceV2Model;
import io.sentry.cache.EnvelopeCache;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'J\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002H'J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\nH'J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\fH'J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u000fH'¨\u0006\u0011"}, d2 = {"Lcom/socure/idplus/device/internal/api/a;", "", "", "auth", "Lcom/socure/idplus/device/internal/behavior/model/SessionDataRequest;", "uploadSessionData", "Lretrofit2/Call;", "Lcom/socure/idplus/device/internal/behavior/model/SessionDataResponse;", "a", "Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/SigmaDeviceConfigResponse;", "Lcom/socure/idplus/device/internal/sigmaDeviceSession/model/SigmaDeviceSessionModel;", EnvelopeCache.PREFIX_CURRENT_SESSION_FILE, "Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/SigmaDeviceV2Model;", "uploadModel", "Lokhttp3/ResponseBody;", "Lcom/socure/idplus/device/internal/sigmaDeviceLocation/model/SigmaDeviceLocationModel;", "uploadLocation", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public interface a {
    @Headers({"Content-Type: application/json"})
    @GET("/api/v1/configuration")
    Call<SigmaDeviceConfigResponse> a(@Header("Authorization") String auth);

    @Headers({"Content-Type: application/json"})
    @POST("/api/v1/session-data")
    Call<SessionDataResponse> a(@Header("Authorization") String auth, @Body SessionDataRequest uploadSessionData);

    @Headers({"Content-Type: application/json"})
    @PUT("/api/v1/device/location")
    Call<ResponseBody> a(@Header("Authorization") String auth, @Body SigmaDeviceLocationModel uploadLocation);

    @Headers({"Content-Type: application/json"})
    @POST("/api/v1/session")
    Call<SigmaDeviceSessionModel> a(@Header("Authorization") String auth, @Body SigmaDeviceSessionModel session);

    @Headers({"Content-Type: application/json"})
    @POST("/api/v1/device")
    Call<ResponseBody> a(@Header("Authorization") String auth, @Body SigmaDeviceV2Model uploadModel);
}
