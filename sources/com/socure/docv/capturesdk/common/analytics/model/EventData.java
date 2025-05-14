package com.socure.docv.capturesdk.common.analytics.model;

import com.iterable.iterableapi.IterableConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001b\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00060\u0005HÆ\u0003J/\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/socure/docv/capturesdk/common/analytics/model/EventData;", "", IterableConstants.KEY_EVENT_NAME, "", "eventAttrList", "", "Lkotlin/Pair;", "(Ljava/lang/String;Ljava/util/List;)V", "getEventAttrList", "()Ljava/util/List;", "getEventName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class EventData {
    private final List<Pair<String, String>> eventAttrList;
    private final String eventName;

    public EventData(String eventName, List<Pair<String, String>> eventAttrList) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventAttrList, "eventAttrList");
        this.eventName = eventName;
        this.eventAttrList = eventAttrList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventData copy$default(EventData eventData, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eventData.eventName;
        }
        if ((i & 2) != 0) {
            list = eventData.eventAttrList;
        }
        return eventData.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    public final List<Pair<String, String>> component2() {
        return this.eventAttrList;
    }

    public final EventData copy(String eventName, List<Pair<String, String>> eventAttrList) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventAttrList, "eventAttrList");
        return new EventData(eventName, eventAttrList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventData)) {
            return false;
        }
        EventData eventData = (EventData) other;
        return Intrinsics.areEqual(this.eventName, eventData.eventName) && Intrinsics.areEqual(this.eventAttrList, eventData.eventAttrList);
    }

    public final List<Pair<String, String>> getEventAttrList() {
        return this.eventAttrList;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public int hashCode() {
        return this.eventAttrList.hashCode() + (this.eventName.hashCode() * 31);
    }

    public String toString() {
        return "EventData(eventName=" + this.eventName + ", eventAttrList=" + this.eventAttrList + ")";
    }
}
