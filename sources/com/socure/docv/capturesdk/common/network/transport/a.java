package com.socure.docv.capturesdk.common.network.transport;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Retrofit f303a;
    public final Retrofit b;
    public final Retrofit c;

    public a() {
        MoshiConverterFactory create = MoshiConverterFactory.create();
        int i = 1;
        this.f303a = new Retrofit.Builder().baseUrl("https://upload.socure.com").addConverterFactory(create).client(new com.socure.docv.capturesdk.common.network.internal.a(true).a()).build();
        boolean z = false;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.b = new Retrofit.Builder().baseUrl("https://stepup.socure.com").addConverterFactory(create).client(new com.socure.docv.capturesdk.common.network.internal.a(z, i, defaultConstructorMarker).a()).build();
        this.c = new Retrofit.Builder().baseUrl("https://api.mixpanel.com/").addConverterFactory(create).client(new com.socure.docv.capturesdk.common.network.internal.a(z, i, defaultConstructorMarker).a()).build();
        Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl("https://www.socure.com/");
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MINUTES;
        baseUrl.client(builder.connectTimeout(5L, timeUnit).writeTimeout(5L, timeUnit).readTimeout(5L, timeUnit).build()).addConverterFactory(create).build();
    }
}
