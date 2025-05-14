package com.socure.idplus.device.internal.permission;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class a {
    public static boolean a(Context context) {
        b permission = b.f584a;
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        return (context != null && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) || (context != null && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0);
    }
}
