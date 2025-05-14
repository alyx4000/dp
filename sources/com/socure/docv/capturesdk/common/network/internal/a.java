package com.socure.docv.capturesdk.common.network.internal;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f294a;

    public a(boolean z) {
        this.f294a = z;
    }

    public /* synthetic */ a(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final OkHttpClient a() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new com.socure.docv.capturesdk.common.network.interceptor.a());
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(50L, timeUnit);
        builder.readTimeout(50L, timeUnit);
        builder.writeTimeout(50L, timeUnit);
        if (this.f294a) {
            builder.certificatePinner(new CertificatePinner.Builder().add("upload.socure.com", "sha256/u4G1dHiq3ZguTn0rEvWkWLb5RY6ci1CdDTVt3GHZc4Q=").add("upload.socure.com", "sha256/JSMzqOOrtyOT1kmau6zKhgT676hGgczD5VMdRMyJZFA=").add("upload.socure.com", "sha256/++MBgDH5WGvL9Bcn5Be30cRcL0f5O+NyoXuWtQdX1aI=").build());
        }
        return builder.build();
    }
}
