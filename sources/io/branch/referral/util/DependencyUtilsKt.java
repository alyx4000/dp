package io.branch.referral.util;

import io.branch.referral.BranchLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DependencyUtils.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"billingGooglePlayClass", "", "huaweiAdvertisingIdClientClass", "huaweiInstallReferrerClass", "playStoreAdvertisingIdClientClass", "playStoreInstallReferrerClass", "samsungInstallReferrerClass", "xiaomiInstallReferrerClass", "classExists", "", "className", "Branch-SDK_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DependencyUtilsKt {
    public static final String billingGooglePlayClass = "com.android.billingclient.api.BillingClient";
    public static final String huaweiAdvertisingIdClientClass = "com.huawei.hms.ads.identifier.AdvertisingIdClient";
    public static final String huaweiInstallReferrerClass = "com.huawei.hms.ads.installreferrer.api.InstallReferrerClient";
    public static final String playStoreAdvertisingIdClientClass = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
    public static final String playStoreInstallReferrerClass = "com.android.installreferrer.api.InstallReferrerClient";
    public static final String samsungInstallReferrerClass = "com.samsung.android.sdk.sinstallreferrer.api.InstallReferrerClient";
    public static final String xiaomiInstallReferrerClass = "com.miui.referrer.api.GetAppsReferrerClient";

    public static final boolean classExists(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException unused) {
            BranchLogger.v("Could not find " + className + ". If expected, import the dependency into your app.");
            return false;
        }
    }
}
