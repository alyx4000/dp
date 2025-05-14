package com.extole.android.sdk.impl.app;

import com.iterable.iterableapi.IterableConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppEvent.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0003J+\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/extole/android/sdk/impl/app/AppEvent;", "", IterableConstants.KEY_EVENT_NAME, "", "eventData", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getEventData", "()Ljava/util/Map;", "getEventName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AppEvent {
    private final Map<String, Object> eventData;
    private final String eventName;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppEvent copy$default(AppEvent appEvent, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appEvent.eventName;
        }
        if ((i & 2) != 0) {
            map = appEvent.eventData;
        }
        return appEvent.copy(str, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    public final Map<String, Object> component2() {
        return this.eventData;
    }

    public final AppEvent copy(String eventName, Map<String, ? extends Object> eventData) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        return new AppEvent(eventName, eventData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppEvent)) {
            return false;
        }
        AppEvent appEvent = (AppEvent) other;
        return Intrinsics.areEqual(this.eventName, appEvent.eventName) && Intrinsics.areEqual(this.eventData, appEvent.eventData);
    }

    public int hashCode() {
        return (this.eventName.hashCode() * 31) + this.eventData.hashCode();
    }

    public String toString() {
        return "AppEvent(eventName=" + this.eventName + ", eventData=" + this.eventData + ')';
    }

    public AppEvent(String eventName, Map<String, ? extends Object> eventData) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        this.eventName = eventName;
        this.eventData = eventData;
    }

    public /* synthetic */ AppEvent(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, Object> getEventData() {
        return this.eventData;
    }

    public final String getEventName() {
        return this.eventName;
    }
}
