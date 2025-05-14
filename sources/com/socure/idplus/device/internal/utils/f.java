package com.socure.idplus.device.internal.utils;

import android.telephony.TelephonyManager;
import com.socure.idplus.device.internal.sigmaDeviceV2.model.MobileNetwork;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class f {
    public static MobileNetwork a(int i, TelephonyManager telephonyManager) {
        if (telephonyManager.getSimState(i) != 5) {
            return null;
        }
        String networkOperatorName = telephonyManager.getNetworkOperatorName();
        Intrinsics.checkNotNullExpressionValue(networkOperatorName, "getNetworkOperatorName(...)");
        String networkCountryIso = telephonyManager.getNetworkCountryIso(i);
        Intrinsics.checkNotNullExpressionValue(networkCountryIso, "getNetworkCountryIso(...)");
        return new MobileNetwork(networkOperatorName, networkCountryIso);
    }
}
