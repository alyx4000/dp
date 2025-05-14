package sdk.pendo.io.h0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import external.sdk.pendo.io.glide.signature.ObjectKey;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import sdk.pendo.io.q.f;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentMap<String, f> f1153a = new ConcurrentHashMap();

    private static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e);
            return null;
        }
    }

    public static f b(Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, f> concurrentMap = f1153a;
        f fVar = concurrentMap.get(packageName);
        if (fVar != null) {
            return fVar;
        }
        f c = c(context);
        f putIfAbsent = concurrentMap.putIfAbsent(packageName, c);
        return putIfAbsent == null ? c : putIfAbsent;
    }

    private static f c(Context context) {
        return new ObjectKey(a(a(context)));
    }

    private static String a(PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }
}
