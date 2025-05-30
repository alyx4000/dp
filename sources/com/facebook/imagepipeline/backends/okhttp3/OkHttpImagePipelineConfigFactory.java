package com.facebook.imagepipeline.backends.okhttp3;

import android.content.Context;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* compiled from: OkHttpImagePipelineConfigFactory.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/facebook/imagepipeline/backends/okhttp3/OkHttpImagePipelineConfigFactory;", "", "()V", "newBuilder", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;", "context", "Landroid/content/Context;", "okHttpClient", "Lokhttp3/OkHttpClient;", "imagepipeline-okhttp3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OkHttpImagePipelineConfigFactory {
    public static final OkHttpImagePipelineConfigFactory INSTANCE = new OkHttpImagePipelineConfigFactory();

    private OkHttpImagePipelineConfigFactory() {
    }

    @JvmStatic
    public static final ImagePipelineConfig.Builder newBuilder(Context context, OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        return ImagePipelineConfig.INSTANCE.newBuilder(context).setNetworkFetcher(new OkHttpNetworkFetcher(okHttpClient));
    }
}
