package io.branch.coroutines;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: AdvertisingIds.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"getAmazonFireAdvertisingInfoObject", "Lkotlin/Pair;", "", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGoogleAdvertisingInfoObject", "Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;", "getHuaweiAdvertisingInfoObject", "Lcom/huawei/hms/ads/identifier/AdvertisingIdClient$Info;", "Branch-SDK_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AdvertisingIdsKt {
    public static final Object getGoogleAdvertisingInfoObject(Context context, Continuation<? super AdvertisingIdClient.Info> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new AdvertisingIdsKt$getGoogleAdvertisingInfoObject$2(context, null), continuation);
    }

    public static final Object getHuaweiAdvertisingInfoObject(Context context, Continuation<? super AdvertisingIdClient.Info> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new AdvertisingIdsKt$getHuaweiAdvertisingInfoObject$2(context, null), continuation);
    }

    public static final Object getAmazonFireAdvertisingInfoObject(Context context, Continuation<? super Pair<Integer, String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new AdvertisingIdsKt$getAmazonFireAdvertisingInfoObject$2(context, null), continuation);
    }
}
