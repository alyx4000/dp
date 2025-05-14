package com.extole.android.sdk;

import kotlin.Metadata;
import kotlinx.coroutines.Deferred;

/* compiled from: ShareResponse.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/extole/android/sdk/ShareResponse;", "", "getEventId", "Lkotlinx/coroutines/Deferred;", "Lcom/extole/android/sdk/Id;", "Lcom/extole/android/sdk/Event;", "getPartnerShareId", "", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ShareResponse {
    Deferred<Id<Event>> getEventId();

    String getPartnerShareId();
}
