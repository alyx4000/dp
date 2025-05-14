package io.castle.android.api;

import io.castle.android.Castle;
import io.castle.android.Utils;
import io.castle.android.api.model.Monitor;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* loaded from: classes2.dex */
public class CastleAPIService {
    private static final int CONNTECTION_TIMEOUT = 10;
    private static CastleAPI instance;

    public interface CastleAPI {
        @POST("monitor")
        Call<Void> monitor(@Body Monitor monitor);
    }

    public static CastleAPI getInstance() {
        if (instance == null) {
            OkHttpClient.Builder connectTimeout = new OkHttpClient.Builder().addInterceptor(new CastleAuthenticationInterceptor()).connectTimeout(10L, TimeUnit.SECONDS);
            if (Castle.debugLoggingEnabled()) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                connectTimeout.addInterceptor(httpLoggingInterceptor);
            }
            instance = (CastleAPI) new Retrofit.Builder().baseUrl(Castle.baseUrl()).addConverterFactory(GsonConverterFactory.create(Utils.getGsonInstance())).client(connectTimeout.build()).build().create(CastleAPI.class);
        }
        return instance;
    }
}
