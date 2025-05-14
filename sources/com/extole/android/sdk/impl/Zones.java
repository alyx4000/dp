package com.extole.android.sdk.impl;

import com.extole.android.sdk.Zone;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Zones.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0005J\u0017\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÂ\u0003J!\u0010\f\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/extole/android/sdk/impl/Zones;", "", "zoneResponses", "", "Lcom/extole/android/sdk/impl/ZoneResponseKey;", "Lcom/extole/android/sdk/Zone;", "(Ljava/util/Map;)V", "add", "", "zoneKey", "zone", "component1", "copy", "equals", "", "other", "get", "zoneName", "", "getAll", "", "hashCode", "", "toString", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class Zones {
    private Map<ZoneResponseKey, Zone> zoneResponses;

    private final Map<ZoneResponseKey, Zone> component1() {
        return this.zoneResponses;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Zones copy$default(Zones zones, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = zones.zoneResponses;
        }
        return zones.copy(map);
    }

    public final Zones copy(Map<ZoneResponseKey, Zone> zoneResponses) {
        Intrinsics.checkNotNullParameter(zoneResponses, "zoneResponses");
        return new Zones(zoneResponses);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Zones) && Intrinsics.areEqual(this.zoneResponses, ((Zones) other).zoneResponses);
    }

    public int hashCode() {
        return this.zoneResponses.hashCode();
    }

    public String toString() {
        return "Zones(zoneResponses=" + this.zoneResponses + ')';
    }

    public Zones(Map<ZoneResponseKey, Zone> zoneResponses) {
        Intrinsics.checkNotNullParameter(zoneResponses, "zoneResponses");
        this.zoneResponses = zoneResponses;
    }

    public final Zone get(String zoneName) {
        Intrinsics.checkNotNullParameter(zoneName, "zoneName");
        return this.zoneResponses.get(new ZoneResponseKey(zoneName));
    }

    public final void add(ZoneResponseKey zoneKey, Zone zone) {
        Intrinsics.checkNotNullParameter(zoneKey, "zoneKey");
        Intrinsics.checkNotNullParameter(zone, "zone");
        this.zoneResponses.put(zoneKey, zone);
    }

    public final Map<ZoneResponseKey, Zone> getAll() {
        return this.zoneResponses;
    }
}
