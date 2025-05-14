package com.extole.android.sdk.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Zones.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/extole/android/sdk/impl/ZoneResponseKey;", "", "zoneName", "", "(Ljava/lang/String;)V", "getZoneName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ZoneResponseKey {
    private final String zoneName;

    public static /* synthetic */ ZoneResponseKey copy$default(ZoneResponseKey zoneResponseKey, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = zoneResponseKey.zoneName;
        }
        return zoneResponseKey.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getZoneName() {
        return this.zoneName;
    }

    public final ZoneResponseKey copy(String zoneName) {
        Intrinsics.checkNotNullParameter(zoneName, "zoneName");
        return new ZoneResponseKey(zoneName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ZoneResponseKey) && Intrinsics.areEqual(this.zoneName, ((ZoneResponseKey) other).zoneName);
    }

    public int hashCode() {
        return this.zoneName.hashCode();
    }

    public String toString() {
        return "ZoneResponseKey(zoneName=" + this.zoneName + ')';
    }

    public ZoneResponseKey(String zoneName) {
        Intrinsics.checkNotNullParameter(zoneName, "zoneName");
        this.zoneName = zoneName;
    }

    public final String getZoneName() {
        return this.zoneName;
    }
}
