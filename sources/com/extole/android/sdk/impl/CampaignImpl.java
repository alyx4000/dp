package com.extole.android.sdk.impl;

import android.webkit.WebView;
import com.extole.android.sdk.CallExtensionKt;
import com.extole.android.sdk.Campaign;
import com.extole.android.sdk.Event;
import com.extole.android.sdk.Extole;
import com.extole.android.sdk.ExtoleLogger;
import com.extole.android.sdk.ExtoleServices;
import com.extole.android.sdk.ExtoleWebView;
import com.extole.android.sdk.Id;
import com.extole.android.sdk.RestException;
import com.extole.android.sdk.SendError;
import com.extole.android.sdk.Zone;
import com.extole.webview.ExtoleWebViewImpl;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.iterable.iterableapi.IterableConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignImpl.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ·\u0001\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00162\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\f2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\f2\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\f2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ;\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u001f2\u0006\u0010 \u001a\u00020\u000b2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\"J7\u0010\u001e\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00162\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\u0014H\u0016J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u000bH\u0016J\b\u0010,\u001a\u00020-H\u0016J3\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00032\u0006\u00100\u001a\u00020\u000b2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\"J3\u00101\u001a\b\u0012\u0004\u0012\u00020/0\u00032\u0006\u00102\u001a\u00020\u000b2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\"J\b\u00103\u001a\u000204H\u0016J,\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0002J?\u00106\u001a\b\u0012\u0004\u0012\u00020/0\u00032\u0006\u00107\u001a\u00020\u000b2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\b\u00102\u001a\u0004\u0018\u00010\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u00108J8\u00109\u001a\u00020:2\u0006\u00109\u001a\u00020;2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\f2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\fH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006="}, d2 = {"Lcom/extole/android/sdk/impl/CampaignImpl;", "Lcom/extole/android/sdk/Campaign;", IterableConstants.KEY_CAMPAIGN_ID, "Lcom/extole/android/sdk/Id;", "zone", "Lcom/extole/android/sdk/Zone;", "extole", "Lcom/extole/android/sdk/impl/ExtoleImpl;", "(Lcom/extole/android/sdk/Id;Lcom/extole/android/sdk/Zone;Lcom/extole/android/sdk/impl/ExtoleImpl;)V", "zones", "", "", "", "", "clone", "Lcom/extole/android/sdk/Extole;", "programDomain", "appName", "sandbox", "context", "Lcom/extole/android/sdk/impl/ApplicationContext;", "newLabels", "", "extendCurrentLabels", "newData", "extendCurrentData", "appData", "appHeaders", "email", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/extole/android/sdk/impl/ApplicationContext;Ljava/util/Set;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchZone", "Lkotlin/Pair;", "zoneName", "fethZoneData", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/extole/android/sdk/impl/Zones;", "zonesName", "data", "(Ljava/util/Set;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContext", "getId", "getLogger", "Lcom/extole/android/sdk/ExtoleLogger;", "getProgramLabel", "getServices", "Lcom/extole/android/sdk/ExtoleServices;", "identify", "Lcom/extole/android/sdk/Event;", "identifier", "identifyJwt", "jwt", "logout", "", "prepareRequestData", "sendEvent", IterableConstants.KEY_EVENT_NAME, "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "webView", "Lcom/extole/android/sdk/ExtoleWebView;", "Landroid/webkit/WebView;", "headers", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CampaignImpl implements Campaign {
    private final Id<Campaign> campaignId;
    private final ExtoleImpl extole;
    private final Zone zone;
    private final Map<String, Map<String, Object>> zones;

    public CampaignImpl(Id<Campaign> campaignId, Zone zone, ExtoleImpl extole) {
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        Intrinsics.checkNotNullParameter(zone, "zone");
        Intrinsics.checkNotNullParameter(extole, "extole");
        this.campaignId = campaignId;
        this.zone = zone;
        this.extole = extole;
        this.zones = new LinkedHashMap();
    }

    @Override // com.extole.android.sdk.Campaign
    public String getProgramLabel() {
        return CollectionsKt.joinToString$default(this.extole.getLabels(), ",", null, null, 0, null, null, 62, null);
    }

    @Override // com.extole.android.sdk.Campaign
    public Id<Campaign> getId() {
        return this.campaignId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.extole.android.sdk.Extole
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object fetchZone(java.lang.String r7, java.util.Map<java.lang.String, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super kotlin.Pair<com.extole.android.sdk.Zone, ? extends com.extole.android.sdk.Campaign>> r9) throws com.extole.android.sdk.RestException {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.extole.android.sdk.impl.CampaignImpl$fetchZone$1
            if (r0 == 0) goto L14
            r0 = r9
            com.extole.android.sdk.impl.CampaignImpl$fetchZone$1 r0 = (com.extole.android.sdk.impl.CampaignImpl$fetchZone$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.extole.android.sdk.impl.CampaignImpl$fetchZone$1 r0 = new com.extole.android.sdk.impl.CampaignImpl$fetchZone$1
            r0.<init>(r6, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r0.L$0
            com.extole.android.sdk.impl.CampaignImpl r8 = (com.extole.android.sdk.impl.CampaignImpl) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L80
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            kotlin.ResultKt.throwOnFailure(r9)
            com.extole.android.sdk.Zone r9 = r6.zone
            java.lang.Object r9 = r9.get(r7)
            java.util.Map r2 = kotlin.collections.MapsKt.toMutableMap(r8)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "campaign_id:"
            r4.<init>(r5)
            com.extole.android.sdk.Id<com.extole.android.sdk.Campaign> r5 = r6.campaignId
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "target"
            r2.put(r5, r4)
            if (r9 != 0) goto L94
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> r9 = r6.zones
            boolean r9 = r9.containsKey(r7)
            if (r9 == 0) goto L6e
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> r8 = r6.zones
            java.lang.Object r9 = r8.get(r7)
            goto L94
        L6e:
            java.util.Set r9 = kotlin.collections.SetsKt.setOf(r7)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r9 = r6.fetchZone(r9, r8, r0)
            if (r9 != r1) goto L7f
            return r1
        L7f:
            r8 = r6
        L80:
            com.extole.android.sdk.impl.Zones r9 = (com.extole.android.sdk.impl.Zones) r9
            com.extole.android.sdk.Zone r9 = r9.get(r7)
            if (r9 == 0) goto L8d
            java.util.Map r9 = r9.getContent()
            goto L8e
        L8d:
            r9 = 0
        L8e:
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> r0 = r8.zones
            r0.put(r7, r9)
            goto L95
        L94:
            r8 = r6
        L95:
            kotlin.Pair r0 = new kotlin.Pair
            com.extole.android.sdk.Zone r1 = new com.extole.android.sdk.Zone
            com.extole.android.sdk.Id<com.extole.android.sdk.Campaign> r2 = r8.campaignId
            java.util.Map r9 = (java.util.Map) r9
            com.extole.android.sdk.impl.ExtoleImpl r3 = r8.extole
            com.extole.android.sdk.Extole r3 = (com.extole.android.sdk.Extole) r3
            r1.<init>(r7, r2, r9, r3)
            r0.<init>(r1, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.extole.android.sdk.impl.CampaignImpl.fetchZone(java.lang.String, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.extole.android.sdk.Extole
    public ExtoleServices getServices() {
        return this.extole.getServices();
    }

    @Override // com.extole.android.sdk.Extole
    public ExtoleLogger getLogger() {
        return this.extole.getLogger();
    }

    @Override // com.extole.android.sdk.Extole
    public ApplicationContext getContext() {
        return this.extole.getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object fetchZone$default(CampaignImpl campaignImpl, Set set, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return campaignImpl.fetchZone((Set<String>) set, (Map<String, ? extends Object>) map, (Continuation<? super Zones>) continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchZone(Set<String> set, Map<String, ? extends Object> map, Continuation<? super Zones> continuation) {
        return this.extole.getServices().getZoneService().getZones(set, prepareRequestData(map), SetsKt.emptySet(), continuation);
    }

    private final Map<String, Object> prepareRequestData(Map<String, ? extends Object> data) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(data);
        String id = this.campaignId.getId();
        if (id == null) {
            id = "";
        }
        linkedHashMap.put("campaign_id", id);
        linkedHashMap.put("labels", CollectionsKt.joinToString$default(this.extole.getLabels(), ",", null, null, 0, null, null, 62, null));
        return linkedHashMap;
    }

    @Override // com.extole.android.sdk.Extole
    public Object sendEvent(String str, Map<String, ? extends Object> map, String str2, Continuation<? super Id<Event>> continuation) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(map);
            linkedHashMap.put("labels", CollectionsKt.joinToString$default(this.extole.getLabels(), ",", null, null, 0, null, null, 62, null));
            linkedHashMap.put(TouchesHelper.TARGET_KEY, "campaign_id:" + this.campaignId);
            linkedHashMap.put("sandbox", this.extole.getSandbox());
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("event_name", str);
            linkedHashMap2.put("data", linkedHashMap);
            if (str2 != null) {
                linkedHashMap2.put("jwt", str2);
            }
            return new Id(this.extole.getServices().getEventsEndpoints().post(linkedHashMap2).getEntity().getString("id"));
        } catch (RestException e) {
            throw new SendError(e.getUniqueId(), e.getErrorCode(), e.getHttpStatusCode(), e.getMessage(), e.getParameters());
        }
    }

    @Override // com.extole.android.sdk.Extole
    public Object identify(String str, Map<String, String> map, Continuation<? super Id<Event>> continuation) {
        return this.extole.identify(str, map, continuation);
    }

    @Override // com.extole.android.sdk.Extole
    public Object identifyJwt(String str, Map<String, String> map, Continuation<? super Id<Event>> continuation) {
        return this.extole.identifyJwt(str, map, continuation);
    }

    @Override // com.extole.android.sdk.Extole
    public void logout() {
        this.extole.logout();
    }

    @Override // com.extole.android.sdk.Extole
    public Object clone(String str, String str2, String str3, ApplicationContext applicationContext, Set<String> set, Set<String> set2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, String str4, Continuation<? super Extole> continuation) {
        return this.extole.clone(str, str2, str3, applicationContext, set, set2, map, map2, map3, map4, str4, continuation);
    }

    @Override // com.extole.android.sdk.Extole
    public ExtoleWebView webView(WebView webView, Map<String, String> headers, Map<String, String> data) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(data, "data");
        String randomAlphaNumericString$default = CallExtensionKt.randomAlphaNumericString$default(0, 1, null);
        Map mutableMap = MapsKt.toMutableMap(headers);
        mutableMap.put("Authorization", IterableConstants.HEADER_SDK_AUTH_FORMAT + this.extole.getAccessToken());
        Map mutableMap2 = MapsKt.toMutableMap(data);
        mutableMap2.putAll(this.extole.getData());
        mutableMap2.putAll(this.extole.getAppData());
        this.extole.getContext().getPersistence().put("partner_share_id", randomAlphaNumericString$default);
        String programDomain = this.extole.getProgramDomain();
        ApplicationContext context = this.extole.getContext();
        ExtoleImpl extoleImpl = this.extole;
        return new ExtoleWebViewImpl(programDomain, webView, context, extoleImpl, mutableMap, mutableMap2, extoleImpl.getAdditionalProtocolHandlers());
    }
}
