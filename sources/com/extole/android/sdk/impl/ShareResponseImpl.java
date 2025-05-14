package com.extole.android.sdk.impl;

import com.extole.android.sdk.Event;
import com.extole.android.sdk.Id;
import com.extole.android.sdk.ShareResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* compiled from: ShareResponseImpl.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/extole/android/sdk/impl/ShareResponseImpl;", "Lcom/extole/android/sdk/ShareResponse;", "partnerShareId", "", "eventId", "Lkotlinx/coroutines/Deferred;", "Lcom/extole/android/sdk/Id;", "Lcom/extole/android/sdk/Event;", "(Ljava/lang/String;Lkotlinx/coroutines/Deferred;)V", "getEventId", "getPartnerShareId", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ShareResponseImpl implements ShareResponse {
    private final Deferred<Id<Event>> eventId;
    private final String partnerShareId;

    public ShareResponseImpl(String partnerShareId, Deferred<Id<Event>> eventId) {
        Intrinsics.checkNotNullParameter(partnerShareId, "partnerShareId");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        this.partnerShareId = partnerShareId;
        this.eventId = eventId;
    }

    @Override // com.extole.android.sdk.ShareResponse
    public String getPartnerShareId() {
        return this.partnerShareId;
    }

    @Override // com.extole.android.sdk.ShareResponse
    public Deferred<Id<Event>> getEventId() {
        return this.eventId;
    }
}
