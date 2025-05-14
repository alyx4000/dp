package com.extole.android.sdk.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.extole.android.sdk.Persistence;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApplicationContext.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0003J\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/extole/android/sdk/impl/ApplicationContext;", "", "context", "Landroid/content/Context;", "persistence", "Lcom/extole/android/sdk/Persistence;", "", "(Landroid/content/Context;Lcom/extole/android/sdk/Persistence;)V", "getAppContext", "getApplicationInfo", "Landroid/content/pm/ApplicationInfo;", "getPersistence", "startActivity", "", "intent", "Landroid/content/Intent;", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ApplicationContext {
    private final Context context;
    private final Persistence<String, String> persistence;

    public ApplicationContext(Context context, Persistence<String, String> persistence) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.persistence = persistence;
    }

    public final ApplicationInfo getApplicationInfo() {
        PackageManager packageManager = this.context.getPackageManager();
        if (packageManager != null) {
            return packageManager.getApplicationInfo(this.context.getPackageName(), 128);
        }
        return null;
    }

    public final Persistence<String, String> getPersistence() {
        Persistence<String, String> persistence = this.persistence;
        return persistence == null ? new SharedPreferencesPersistence(this.context) : persistence;
    }

    /* renamed from: getAppContext, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final void startActivity(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.context.startActivity(intent);
    }
}
