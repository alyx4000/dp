package com.extole.android.sdk;

import com.extole.android.sdk.impl.http.EventEndpoints;
import com.extole.android.sdk.impl.http.MeRewardEndpoints;
import kotlin.Metadata;

/* compiled from: ExtoleServices.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/extole/android/sdk/ExtoleServices;", "", "getEventsEndpoints", "Lcom/extole/android/sdk/impl/http/EventEndpoints;", "getMeRewardEndpoints", "Lcom/extole/android/sdk/impl/http/MeRewardEndpoints;", "getRewardService", "Lcom/extole/android/sdk/RewardService;", "getShareService", "Lcom/extole/android/sdk/ShareService;", "getZoneService", "Lcom/extole/android/sdk/ZoneService;", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ExtoleServices {
    EventEndpoints getEventsEndpoints();

    MeRewardEndpoints getMeRewardEndpoints();

    RewardService getRewardService();

    ShareService getShareService();

    ZoneService getZoneService();
}
