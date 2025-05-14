package com.extole.android.sdk.impl;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.amplitude.reactnative.DatabaseConstants;
import com.extole.android.sdk.ExtoleLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;

/* compiled from: ExtoleShareBroadcastReceiver.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/extole/android/sdk/impl/ExtoleShareBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "getProgramDomain", "", "context", "Landroid/content/Context;", "getSharePreferencesValue", DatabaseConstants.KEY_FIELD, "onReceive", "", "intent", "Landroid/content/Intent;", "Companion", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExtoleShareBroadcastReceiver extends BroadcastReceiver {
    public static final String SHARE_EVENT_NAME = "share";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        Object obj = null;
        String sharePreferencesValue = context != null ? getSharePreferencesValue(context, "access_token") : null;
        String sharePreferencesValue2 = context != null ? getSharePreferencesValue(context, "partner_share_id") : null;
        ExtoleLogger build = ExtoleLogger.INSTANCE.builder().withProgramDomain(getProgramDomain(context)).withAccessToken(sharePreferencesValue).build();
        if (intent != null && (extras = intent.getExtras()) != null) {
            obj = extras.get("android.intent.extra.CHOSEN_COMPONENT");
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.content.ComponentName");
        }
        String packageName = ((ComponentName) obj).getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "intent?.getExtras()?.get…omponentName).packageName");
        String programDomain = getProgramDomain(context);
        build.debug("User shared by:" + packageName, new Object[0]);
        if (programDomain.length() > 0) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new ExtoleShareBroadcastReceiver$onReceive$1(sharePreferencesValue, build, sharePreferencesValue2, programDomain, packageName, null), 3, null);
        }
    }

    private final String getSharePreferencesValue(Context context, String key) {
        String str = new SharedPreferencesPersistence(context).get(key);
        return str == null ? "" : str;
    }

    private final String getProgramDomain(Context context) {
        Bundle bundle;
        PackageManager packageManager;
        ExtoleLogger build = ExtoleLogger.INSTANCE.builder().build();
        String str = null;
        ApplicationInfo applicationInfo = (context == null || (packageManager = context.getPackageManager()) == null) ? null : packageManager.getApplicationInfo(context.getPackageName(), 128);
        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
            str = bundle.getString("com.extole.PROGRAM_DOMAIN");
        }
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            build.warn("Program Domain is empty", new Object[0]);
        }
        return String.valueOf(str);
    }
}
