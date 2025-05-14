package com.extole.android.sdk;

import kotlin.Metadata;

/* compiled from: Campaign.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/extole/android/sdk/Campaign;", "Lcom/extole/android/sdk/Extole;", "getId", "Lcom/extole/android/sdk/Id;", "getProgramLabel", "", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Campaign extends Extole {
    Id<Campaign> getId();

    String getProgramLabel();
}
