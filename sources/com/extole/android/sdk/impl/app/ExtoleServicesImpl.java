package com.extole.android.sdk.impl.app;

import com.extole.android.sdk.ExtoleServices;
import com.extole.android.sdk.RewardService;
import com.extole.android.sdk.ShareService;
import com.extole.android.sdk.ZoneService;
import com.extole.android.sdk.impl.ExtoleInternal;
import com.extole.android.sdk.impl.ZoneServiceImpl;
import com.extole.android.sdk.impl.http.EventEndpoints;
import com.extole.android.sdk.impl.http.MeRewardEndpoints;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExtoleServicesImpl.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/extole/android/sdk/impl/app/ExtoleServicesImpl;", "Lcom/extole/android/sdk/ExtoleServices;", "extole", "Lcom/extole/android/sdk/impl/ExtoleInternal;", "(Lcom/extole/android/sdk/impl/ExtoleInternal;)V", "eventsEndpoints", "Lcom/extole/android/sdk/impl/http/EventEndpoints;", "getExtole", "()Lcom/extole/android/sdk/impl/ExtoleInternal;", "setExtole", "meRewardEndpoints", "Lcom/extole/android/sdk/impl/http/MeRewardEndpoints;", "rewardService", "Lcom/extole/android/sdk/impl/app/RewardServiceImpl;", "shareService", "Lcom/extole/android/sdk/impl/app/ShareServiceImpl;", "zoneService", "Lcom/extole/android/sdk/impl/ZoneServiceImpl;", "getEventsEndpoints", "getMeRewardEndpoints", "getRewardService", "Lcom/extole/android/sdk/RewardService;", "getShareService", "Lcom/extole/android/sdk/ShareService;", "getZoneService", "Lcom/extole/android/sdk/ZoneService;", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExtoleServicesImpl implements ExtoleServices {
    private EventEndpoints eventsEndpoints;
    private ExtoleInternal extole;
    private MeRewardEndpoints meRewardEndpoints;
    private RewardServiceImpl rewardService;
    private ShareServiceImpl shareService;
    private ZoneServiceImpl zoneService;

    public ExtoleServicesImpl(ExtoleInternal extole) {
        Intrinsics.checkNotNullParameter(extole, "extole");
        this.extole = extole;
        this.eventsEndpoints = new EventEndpoints(this.extole.getProgramDomain(), this.extole.getAccessToken(), this.extole.getHeaders());
        this.meRewardEndpoints = new MeRewardEndpoints(this.extole.getProgramDomain(), this.extole.getAccessToken(), this.extole.getHeaders());
        this.zoneService = new ZoneServiceImpl(this.extole);
        this.rewardService = new RewardServiceImpl(this.meRewardEndpoints);
        this.shareService = new ShareServiceImpl(this.extole);
    }

    public final ExtoleInternal getExtole() {
        return this.extole;
    }

    public final void setExtole(ExtoleInternal extoleInternal) {
        Intrinsics.checkNotNullParameter(extoleInternal, "<set-?>");
        this.extole = extoleInternal;
    }

    @Override // com.extole.android.sdk.ExtoleServices
    public EventEndpoints getEventsEndpoints() {
        return this.eventsEndpoints;
    }

    @Override // com.extole.android.sdk.ExtoleServices
    public MeRewardEndpoints getMeRewardEndpoints() {
        return this.meRewardEndpoints;
    }

    @Override // com.extole.android.sdk.ExtoleServices
    public ZoneService getZoneService() {
        return this.zoneService;
    }

    @Override // com.extole.android.sdk.ExtoleServices
    public RewardService getRewardService() {
        return this.rewardService;
    }

    @Override // com.extole.android.sdk.ExtoleServices
    public ShareService getShareService() {
        return this.shareService;
    }
}
