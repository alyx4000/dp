package com.socure.idplus.device.internal.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.socure.idplus.device.internal.sigmaDeviceConfig.model.SigmaDeviceConfigResponse;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f547a;
    public a b;
    public a c;
    public a d;

    public b(boolean z) {
        this.f547a = z;
    }

    public static a a(String str) {
        CertificatePinner build = new CertificatePinner.Builder().add("upload.socure.com", "sha256/u4G1dHiq3ZguTn0rEvWkWLb5RY6ci1CdDTVt3GHZc4Q=").add("upload.socure.com", "sha256/JSMzqOOrtyOT1kmau6zKhgT676hGgczD5VMdRMyJZFA=").add("upload.socure.com", "sha256/++MBgDH5WGvL9Bcn5Be30cRcL0f5O+NyoXuWtQdX1aI=").build();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Gson create = new GsonBuilder().setLenient().create();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(50L, timeUnit);
        builder.readTimeout(50L, timeUnit);
        builder.writeTimeout(50L, timeUnit);
        builder.certificatePinner(build);
        Object create2 = new Retrofit.Builder().baseUrl(str).addConverterFactory(GsonConverterFactory.create(create)).client(builder.build()).build().create(a.class);
        Intrinsics.checkNotNullExpressionValue(create2, "create(...)");
        return (a) create2;
    }

    public final a a() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar;
        }
        a a2 = a(this.f547a ? "https://ingestion.dv.socure.us/" : "https://ingestion.dv.socure.io/");
        this.b = a2;
        return a2;
    }

    public final a a(SigmaDeviceConfigResponse config) {
        Intrinsics.checkNotNullParameter(config, "config");
        a aVar = this.c;
        if (aVar != null) {
            return aVar;
        }
        a a2 = a(config.getDevice().getHost());
        this.c = a2;
        return a2;
    }
}
