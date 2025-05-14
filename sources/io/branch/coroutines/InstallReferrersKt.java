package io.branch.coroutines;

import android.content.Context;
import io.branch.data.InstallReferrerResult;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: InstallReferrers.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\u001a\u001b\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"fetchLatestInstallReferrer", "Lio/branch/data/InstallReferrerResult;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGooglePlayStoreReferrerDetails", "getHuaweiAppGalleryReferrerDetails", "getLatestValidReferrerStore", "allReferrers", "", "getSamsungGalaxyStoreReferrerDetails", "getXiaomiGetAppsReferrerDetails", "Branch-SDK_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InstallReferrersKt {
    public static final Object getGooglePlayStoreReferrerDetails(Context context, Continuation<? super InstallReferrerResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new InstallReferrersKt$getGooglePlayStoreReferrerDetails$2(context, null), continuation);
    }

    public static final Object getHuaweiAppGalleryReferrerDetails(Context context, Continuation<? super InstallReferrerResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new InstallReferrersKt$getHuaweiAppGalleryReferrerDetails$2(context, null), continuation);
    }

    public static final Object getSamsungGalaxyStoreReferrerDetails(Context context, Continuation<? super InstallReferrerResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new InstallReferrersKt$getSamsungGalaxyStoreReferrerDetails$2(context, null), continuation);
    }

    public static final Object getXiaomiGetAppsReferrerDetails(Context context, Continuation<? super InstallReferrerResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new InstallReferrersKt$getXiaomiGetAppsReferrerDetails$2(context, null), continuation);
    }

    public static final Object fetchLatestInstallReferrer(Context context, Continuation<? super InstallReferrerResult> continuation) {
        return SupervisorKt.supervisorScope(new InstallReferrersKt$fetchLatestInstallReferrer$2(context, null), continuation);
    }

    public static final InstallReferrerResult getLatestValidReferrerStore(List<InstallReferrerResult> allReferrers) {
        Object obj;
        Intrinsics.checkNotNullParameter(allReferrers, "allReferrers");
        Iterator it = CollectionsKt.filterNotNull(allReferrers).iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long latestInstallTimestamp = ((InstallReferrerResult) next).getLatestInstallTimestamp();
                do {
                    Object next2 = it.next();
                    long latestInstallTimestamp2 = ((InstallReferrerResult) next2).getLatestInstallTimestamp();
                    if (latestInstallTimestamp < latestInstallTimestamp2) {
                        next = next2;
                        latestInstallTimestamp = latestInstallTimestamp2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (InstallReferrerResult) obj;
    }
}
