package com.extole.android.sdk.impl;

import com.extole.android.sdk.ExtoleLogger;
import com.extole.android.sdk.Id;
import com.extole.android.sdk.RestException;
import com.extole.android.sdk.Zone;
import com.extole.android.sdk.ZoneService;
import com.extole.android.sdk.impl.http.JSONObjectExtensionKt;
import com.extole.android.sdk.impl.http.ZonesEndpoints;
import io.sentry.SentryEvent;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import org.json.JSONObject;

/* compiled from: ZoneServiceImpl.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0002JC\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00182\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/extole/android/sdk/impl/ZoneServiceImpl;", "Lcom/extole/android/sdk/ZoneService;", "extole", "Lcom/extole/android/sdk/impl/ExtoleInternal;", "(Lcom/extole/android/sdk/impl/ExtoleInternal;)V", "getExtole", "()Lcom/extole/android/sdk/impl/ExtoleInternal;", SentryEvent.JsonKeys.LOGGER, "Lcom/extole/android/sdk/ExtoleLogger;", "getLogger", "()Lcom/extole/android/sdk/ExtoleLogger;", "programDomain", "", "getProgramDomain", "()Ljava/lang/String;", "getZone", "Lcom/extole/android/sdk/Zone;", "zoneName", "data", "", "", "getZones", "Lcom/extole/android/sdk/impl/Zones;", "zonesName", "", "programLabels", "(Ljava/util/Set;Ljava/util/Map;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ZoneServiceImpl implements ZoneService {
    private final ExtoleInternal extole;
    private final ExtoleLogger logger;
    private final String programDomain;

    public ZoneServiceImpl(ExtoleInternal extole) {
        Intrinsics.checkNotNullParameter(extole, "extole");
        this.extole = extole;
        this.programDomain = extole.getProgramDomain();
        this.logger = extole.getLogger();
    }

    public final ExtoleInternal getExtole() {
        return this.extole;
    }

    public final String getProgramDomain() {
        return this.programDomain;
    }

    public final ExtoleLogger getLogger() {
        return this.logger;
    }

    @Override // com.extole.android.sdk.ZoneService
    public Object getZones(Set<String> set, Map<String, ? extends Object> map, Set<String> set2, Continuation<? super Zones> continuation) throws RestException {
        return CoroutineScopeKt.coroutineScope(new ZoneServiceImpl$getZones$2(set2, map, set, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Zone getZone(String zoneName, Map<String, ? extends Object> data) throws RestException {
        ZonesEndpoints zonesEndpoints = new ZonesEndpoints(this.programDomain, this.extole.getAccessToken(), this.extole.getHeaders());
        this.logger.debug("Rendering zone=" + zoneName + ", data=" + data, new Object[0]);
        ResponseEntity<JSONObject> render = zonesEndpoints.render(zoneName, data);
        Id id = new Id(render.getEntity().getString("campaign_id"));
        JSONObject jSONObject = render.getEntity().getJSONObject("data");
        Intrinsics.checkNotNullExpressionValue(jSONObject, "response.entity.getJSONObject(\"data\")");
        return new Zone(zoneName, id, JSONObjectExtensionKt.toMap(jSONObject), this.extole);
    }
}
