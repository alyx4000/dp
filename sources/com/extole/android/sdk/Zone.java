package com.extole.android.sdk;

import com.extole.android.sdk.Extole;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.iterable.iterableapi.IterableConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Zone.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÂ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bHÆ\u0003J\t\u0010\u0015\u001a\u00020\nHÆ\u0003JG\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u0003J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u0006\u0010\u001d\u001a\u00020\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\"J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020!0\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\"R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lcom/extole/android/sdk/Zone;", "", "zoneName", "", IterableConstants.KEY_CAMPAIGN_ID, "Lcom/extole/android/sdk/Id;", "Lcom/extole/android/sdk/Campaign;", "content", "", "extole", "Lcom/extole/android/sdk/Extole;", "(Ljava/lang/String;Lcom/extole/android/sdk/Id;Ljava/util/Map;Lcom/extole/android/sdk/Extole;)V", "getCampaignId", "()Lcom/extole/android/sdk/Id;", "getContent", "()Ljava/util/Map;", "getExtole", "()Lcom/extole/android/sdk/Extole;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "get", "dottedPath", "getFlatten", "getName", "hashCode", "", "tap", "Lcom/extole/android/sdk/Event;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "viewed", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class Zone {
    private final Id<Campaign> campaignId;
    private final Map<String, Object> content;
    private final Extole extole;
    private final String zoneName;

    /* renamed from: component1, reason: from getter */
    private final String getZoneName() {
        return this.zoneName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Zone copy$default(Zone zone, String str, Id id, Map map, Extole extole, int i, Object obj) {
        if ((i & 1) != 0) {
            str = zone.zoneName;
        }
        if ((i & 2) != 0) {
            id = zone.campaignId;
        }
        if ((i & 4) != 0) {
            map = zone.content;
        }
        if ((i & 8) != 0) {
            extole = zone.extole;
        }
        return zone.copy(str, id, map, extole);
    }

    public final Id<Campaign> component2() {
        return this.campaignId;
    }

    public final Map<String, Object> component3() {
        return this.content;
    }

    /* renamed from: component4, reason: from getter */
    public final Extole getExtole() {
        return this.extole;
    }

    public final Zone copy(String zoneName, Id<Campaign> campaignId, Map<String, ? extends Object> content, Extole extole) {
        Intrinsics.checkNotNullParameter(zoneName, "zoneName");
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        Intrinsics.checkNotNullParameter(extole, "extole");
        return new Zone(zoneName, campaignId, content, extole);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Zone)) {
            return false;
        }
        Zone zone = (Zone) other;
        return Intrinsics.areEqual(this.zoneName, zone.zoneName) && Intrinsics.areEqual(this.campaignId, zone.campaignId) && Intrinsics.areEqual(this.content, zone.content) && Intrinsics.areEqual(this.extole, zone.extole);
    }

    public int hashCode() {
        int hashCode = ((this.zoneName.hashCode() * 31) + this.campaignId.hashCode()) * 31;
        Map<String, Object> map = this.content;
        return ((hashCode + (map == null ? 0 : map.hashCode())) * 31) + this.extole.hashCode();
    }

    public String toString() {
        return "Zone(zoneName=" + this.zoneName + ", campaignId=" + this.campaignId + ", content=" + this.content + ", extole=" + this.extole + ')';
    }

    public Zone(String zoneName, Id<Campaign> campaignId, Map<String, ? extends Object> map, Extole extole) {
        Intrinsics.checkNotNullParameter(zoneName, "zoneName");
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        Intrinsics.checkNotNullParameter(extole, "extole");
        this.zoneName = zoneName;
        this.campaignId = campaignId;
        this.content = map;
        this.extole = extole;
    }

    public final Id<Campaign> getCampaignId() {
        return this.campaignId;
    }

    public final Map<String, Object> getContent() {
        return this.content;
    }

    public final Extole getExtole() {
        return this.extole;
    }

    public final String getName() {
        return this.zoneName;
    }

    public final Object get(String dottedPath) {
        Intrinsics.checkNotNullParameter(dottedPath, "dottedPath");
        if (StringsKt.contains$default((CharSequence) dottedPath, (CharSequence) ".", false, 2, (Object) null)) {
            return getFlatten(dottedPath);
        }
        Map<String, Object> map = this.content;
        if (map != null) {
            return map.get(dottedPath);
        }
        return null;
    }

    public final Object tap(Continuation<? super Id<Event>> continuation) {
        return Extole.DefaultImpls.sendEvent$default(this.extole, this.zoneName + "_tap", MapsKt.mapOf(TuplesKt.to(TouchesHelper.TARGET_KEY, "campaign_id:" + this.campaignId)), null, continuation, 4, null);
    }

    public final Object viewed(Continuation<? super Id<Event>> continuation) {
        return Extole.DefaultImpls.sendEvent$default(this.extole, this.zoneName + "_viewed", MapsKt.mapOf(TuplesKt.to(TouchesHelper.TARGET_KEY, "campaign_id:" + this.campaignId)), null, continuation, 4, null);
    }

    private final Object getFlatten(String dottedPath) {
        Map<String, Object> map = this.content;
        List split$default = StringsKt.split$default((CharSequence) dottedPath, new String[]{"."}, false, 0, 6, (Object) null);
        int size = split$default.size() - 2;
        if (size >= 0) {
            int i = 0;
            while (true) {
                map = (Map) (map != null ? map.get(split$default.get(i)) : null);
                if (i == size) {
                    break;
                }
                i++;
            }
        }
        if (map != null) {
            return map.get(split$default.get(split$default.size() - 1));
        }
        return null;
    }
}
