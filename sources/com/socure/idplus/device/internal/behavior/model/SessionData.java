package com.socure.idplus.device.internal.behavior.model;

import com.amplitude.reactnative.DatabaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/socure/idplus/device/internal/behavior/model/SessionData;", "", DatabaseConstants.EVENT_TABLE_NAME, "Lcom/socure/idplus/device/internal/behavior/model/Events;", "(Lcom/socure/idplus/device/internal/behavior/model/Events;)V", "getEvents", "()Lcom/socure/idplus/device/internal/behavior/model/Events;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SessionData {

    @SerializedName(DatabaseConstants.EVENT_TABLE_NAME)
    private final Events events;

    public SessionData(Events events) {
        Intrinsics.checkNotNullParameter(events, "events");
        this.events = events;
    }

    public static /* synthetic */ SessionData copy$default(SessionData sessionData, Events events, int i, Object obj) {
        if ((i & 1) != 0) {
            events = sessionData.events;
        }
        return sessionData.copy(events);
    }

    /* renamed from: component1, reason: from getter */
    public final Events getEvents() {
        return this.events;
    }

    public final SessionData copy(Events events) {
        Intrinsics.checkNotNullParameter(events, "events");
        return new SessionData(events);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SessionData) && Intrinsics.areEqual(this.events, ((SessionData) other).events);
    }

    public final Events getEvents() {
        return this.events;
    }

    public int hashCode() {
        return this.events.hashCode();
    }

    public String toString() {
        return "SessionData(events=" + this.events + ")";
    }
}
