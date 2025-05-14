package com.socure.docv.capturesdk.common.analytics;

import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.iterable.iterableapi.IterableConstants;
import com.socure.docv.capturesdk.api.Keys;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import com.socure.docv.capturesdk.common.utils.Utils;
import io.sentry.ProfilingTraceData;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.ArrayList;
import java.util.Map;
import kotlin.KotlinVersion;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final com.socure.docv.capturesdk.common.network.repository.a f291a;
    public final CoroutineExceptionHandler b;
    public final Map<String, String> c;

    public e(com.socure.docv.capturesdk.common.network.repository.a repository, CoroutineExceptionHandler exceptionHandler) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(exceptionHandler, "exceptionHandler");
        this.f291a = repository;
        this.b = exceptionHandler;
        int i = Build.VERSION.SDK_INT;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        this.c = MapsKt.mutableMapOf(TuplesKt.to(IterableConstants.KEY_TOKEN, "2ca8059543e55c4c54b34c1ec2dbbecc"), TuplesKt.to(ProfilingTraceData.JsonKeys.DEVICE_MODEL, Build.MODEL), TuplesKt.to("device_oem", Build.MANUFACTURER), TuplesKt.to("device_os", "Android " + i), TuplesKt.to("screen_size", displayMetrics.widthPixels + ViewHierarchyNode.JsonKeys.X + displayMetrics.heightPixels), TuplesKt.to("build_number", "4.3.0"), TuplesKt.to(Keys.KEY_SDK_VERSION, "4.3.0"), TuplesKt.to("kotlin_version", KotlinVersion.CURRENT.toString()), TuplesKt.to("client", ApiConstant.CLIENT_NAME), TuplesKt.to("referred_by", "Android"), TuplesKt.to("distinct_id", Utils.INSTANCE.randomString$capturesdk_productionRelease(16)), TuplesKt.to("source", ConstantsKt.getSOURCE_PLATFORM().getPlatformName()), TuplesKt.to("verification_level", "1"));
    }

    public void a(Map<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        ArrayList arrayList = new ArrayList(params.size());
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!Intrinsics.areEqual(key, "distinct_id") || !TextUtils.isEmpty(value)) {
                this.c.put(key, value);
            }
            arrayList.add(Unit.INSTANCE);
        }
    }
}
