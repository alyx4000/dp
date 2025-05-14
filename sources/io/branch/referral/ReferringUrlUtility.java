package io.branch.referral;

import android.net.Uri;
import io.branch.referral.Defines;
import io.sentry.SentryBaseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ReferringUrlUtility.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0002J!\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u0015\u001a\u00020\fH\u0001¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\tJ!\u0010\u001d\u001a\u00020\f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0001¢\u0006\u0002\b\u001eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lio/branch/referral/ReferringUrlUtility;", "", "prefHelper", "Lio/branch/referral/PrefHelper;", "(Lio/branch/referral/PrefHelper;)V", "dateFormat", "Ljava/text/SimpleDateFormat;", "urlQueryParameters", "", "", "Lio/branch/referral/BranchUrlQueryParameter;", "addGclidValueFor", "Lorg/json/JSONObject;", SentryBaseEvent.JsonKeys.REQUEST, "Lio/branch/referral/ServerRequest;", "checkForAndMigrateOldGclid", "", "defaultValidityWindowForParam", "", "paramName", "deserializeFromJson", "json", "deserializeFromJson$Branch_SDK_release", "findUrlQueryParam", "getURLQueryParamsForRequest", "isSupportedQueryParameter", "", "parseReferringURL", "urlString", "serializeToJson", "serializeToJson$Branch_SDK_release", "Branch-SDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ReferringUrlUtility {
    private final SimpleDateFormat dateFormat;
    private PrefHelper prefHelper;
    private final Map<String, BranchUrlQueryParameter> urlQueryParameters;

    public ReferringUrlUtility(PrefHelper prefHelper) {
        Intrinsics.checkNotNullParameter(prefHelper, "prefHelper");
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
        this.prefHelper = prefHelper;
        JSONObject referringURLQueryParameters = prefHelper.getReferringURLQueryParameters();
        Intrinsics.checkNotNullExpressionValue(referringURLQueryParameters, "prefHelper.referringURLQueryParameters");
        this.urlQueryParameters = deserializeFromJson$Branch_SDK_release(referringURLQueryParameters);
        checkForAndMigrateOldGclid();
    }

    public final void parseReferringURL(String urlString) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        if (!Branch.getInstance().isTrackingDisabled()) {
            Uri parse = Uri.parse(urlString);
            if (parse.isHierarchical()) {
                for (String originalParamName : parse.getQueryParameterNames()) {
                    Intrinsics.checkNotNullExpressionValue(originalParamName, "originalParamName");
                    String lowerCase = originalParamName.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    String queryParameter = parse.getQueryParameter(originalParamName);
                    BranchLogger.v("Found URL Query Parameter - Key: " + lowerCase + ", Value: " + queryParameter);
                    if (isSupportedQueryParameter(lowerCase)) {
                        BranchUrlQueryParameter findUrlQueryParam = findUrlQueryParam(lowerCase);
                        findUrlQueryParam.setValue(queryParameter);
                        findUrlQueryParam.setTimestamp(new Date());
                        findUrlQueryParam.setDeepLink(true);
                        if (findUrlQueryParam.getValidityWindow() == 0) {
                            findUrlQueryParam.setValidityWindow(defaultValidityWindowForParam(lowerCase));
                        }
                        this.urlQueryParameters.put(lowerCase, findUrlQueryParam);
                    }
                }
                this.prefHelper.setReferringUrlQueryParameters(serializeToJson$Branch_SDK_release(this.urlQueryParameters));
                BranchLogger.v("Current referringURLQueryParameters: " + this.prefHelper.getReferringURLQueryParameters());
                return;
            }
            BranchLogger.d("Skipping referring URL query parameter parsing because the URI is not hierarchical. URI: " + urlString);
            return;
        }
        BranchLogger.d("Skipping referring URL query parameter parsing due to disabled tracking.");
    }

    public final JSONObject getURLQueryParamsForRequest(ServerRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject addGclidValueFor = addGclidValueFor(request);
        if (addGclidValueFor.length() > 0) {
            Iterator<String> keys = addGclidValueFor.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                Object obj = addGclidValueFor.get(key);
                Intrinsics.checkNotNullExpressionValue(obj, "gclid.get(key)");
                linkedHashMap.put(key, obj);
            }
        }
        return new JSONObject(linkedHashMap);
    }

    private final JSONObject addGclidValueFor(ServerRequest request) {
        BranchUrlQueryParameter branchUrlQueryParameter;
        JSONObject jSONObject = new JSONObject();
        if (((request instanceof ServerRequestLogEvent) || (request instanceof ServerRequestRegisterOpen)) && (branchUrlQueryParameter = this.urlQueryParameters.get(Defines.Jsonkey.Gclid.getKey())) != null && branchUrlQueryParameter.getValue() != null && !Intrinsics.areEqual(branchUrlQueryParameter.getValue(), PrefHelper.NO_STRING_VALUE)) {
            long time = new Date().getTime();
            Date timestamp = branchUrlQueryParameter.getTimestamp();
            Long valueOf = timestamp != null ? Long.valueOf(timestamp.getTime()) : null;
            long validityWindow = branchUrlQueryParameter.getValidityWindow() * 1000;
            if (valueOf != null) {
                if (branchUrlQueryParameter.getValidityWindow() == 0 || time < valueOf.longValue() + validityWindow) {
                    jSONObject.put(Defines.Jsonkey.Gclid.getKey(), branchUrlQueryParameter.getValue());
                    if (request instanceof ServerRequestRegisterOpen) {
                        jSONObject.put(Defines.Jsonkey.IsDeeplinkGclid.getKey(), branchUrlQueryParameter.isDeepLink());
                    }
                    branchUrlQueryParameter.setDeepLink(false);
                    this.prefHelper.setReferringUrlQueryParameters(serializeToJson$Branch_SDK_release(this.urlQueryParameters));
                } else {
                    this.urlQueryParameters.remove(Defines.Jsonkey.Gclid.getKey());
                    this.prefHelper.setReferringUrlQueryParameters(serializeToJson$Branch_SDK_release(this.urlQueryParameters));
                }
            }
        }
        return jSONObject;
    }

    private final boolean isSupportedQueryParameter(String paramName) {
        String lowerCase = paramName.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return CollectionsKt.listOf(Defines.Jsonkey.Gclid.getKey()).contains(lowerCase);
    }

    private final BranchUrlQueryParameter findUrlQueryParam(String paramName) {
        BranchUrlQueryParameter branchUrlQueryParameter = this.urlQueryParameters.get(paramName);
        return branchUrlQueryParameter == null ? new BranchUrlQueryParameter(paramName, null, null, false, 0L, 30, null) : branchUrlQueryParameter;
    }

    private final long defaultValidityWindowForParam(String paramName) {
        if (Intrinsics.areEqual(paramName, Defines.Jsonkey.Gclid.getKey())) {
            return this.prefHelper.getReferrerGclidValidForWindow() / 1000;
        }
        return 0L;
    }

    public final JSONObject serializeToJson$Branch_SDK_release(Map<String, BranchUrlQueryParameter> urlQueryParameters) {
        Intrinsics.checkNotNullParameter(urlQueryParameters, "urlQueryParameters");
        JSONObject jSONObject = new JSONObject();
        try {
            for (BranchUrlQueryParameter branchUrlQueryParameter : urlQueryParameters.values()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("name", branchUrlQueryParameter.getName());
                Object value = branchUrlQueryParameter.getValue();
                if (value == null) {
                    value = JSONObject.NULL;
                }
                jSONObject2.put("value", value);
                Date timestamp = branchUrlQueryParameter.getTimestamp();
                jSONObject2.put("timestamp", timestamp != null ? this.dateFormat.format(timestamp) : null);
                jSONObject2.put("isDeeplink", branchUrlQueryParameter.isDeepLink());
                jSONObject2.put("validityWindow", branchUrlQueryParameter.getValidityWindow());
                jSONObject.put(String.valueOf(branchUrlQueryParameter.getName()), jSONObject2);
            }
        } catch (JSONException e) {
            BranchLogger.logException("Exception when serializing JSON for referring URL query parameters", e);
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0083 A[Catch: JSONException -> 0x00a7, TryCatch #1 {JSONException -> 0x00a7, blocks: (B:35:0x0064, B:12:0x007d, B:14:0x0083, B:15:0x008a, B:17:0x0090, B:18:0x009c, B:21:0x00a2, B:25:0x0098, B:38:0x0073), top: B:34:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0090 A[Catch: JSONException -> 0x00a7, TryCatch #1 {JSONException -> 0x00a7, blocks: (B:35:0x0064, B:12:0x007d, B:14:0x0083, B:15:0x008a, B:17:0x0090, B:18:0x009c, B:21:0x00a2, B:25:0x0098, B:38:0x0073), top: B:34:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x001b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0098 A[Catch: JSONException -> 0x00a7, TryCatch #1 {JSONException -> 0x00a7, blocks: (B:35:0x0064, B:12:0x007d, B:14:0x0083, B:15:0x008a, B:17:0x0090, B:18:0x009c, B:21:0x00a2, B:25:0x0098, B:38:0x0073), top: B:34:0x0064 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.String, io.branch.referral.BranchUrlQueryParameter> deserializeFromJson$Branch_SDK_release(org.json.JSONObject r20) {
        /*
            r19 = this;
            r1 = r20
            java.lang.String r2 = "isDeeplink"
            java.lang.String r3 = "validityWindow"
            java.lang.String r4 = "timestamp"
            java.lang.String r5 = "value"
            java.lang.String r0 = "json"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            r6 = r0
            java.util.Map r6 = (java.util.Map) r6
            java.util.Iterator r7 = r20.keys()     // Catch: org.json.JSONException -> Lac
        L1b:
            boolean r0 = r7.hasNext()     // Catch: org.json.JSONException -> Lac
            if (r0 == 0) goto La9
            java.lang.Object r0 = r7.next()     // Catch: org.json.JSONException -> Lac
            java.lang.String r0 = (java.lang.String) r0     // Catch: org.json.JSONException -> Lac
            org.json.JSONObject r8 = r1.getJSONObject(r0)     // Catch: org.json.JSONException -> Lac
            io.branch.referral.BranchUrlQueryParameter r14 = new io.branch.referral.BranchUrlQueryParameter     // Catch: org.json.JSONException -> Lac
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r0 = 31
            r17 = 0
            r9 = r14
            r18 = r14
            r14 = r15
            r16 = r0
            r9.<init>(r10, r11, r12, r13, r14, r16, r17)     // Catch: org.json.JSONException -> Lac
            java.lang.String r0 = "name"
            java.lang.String r0 = r8.getString(r0)     // Catch: org.json.JSONException -> Lac
            r9 = r18
            r9.setName(r0)     // Catch: org.json.JSONException -> Lac
            boolean r0 = r8.has(r5)     // Catch: org.json.JSONException -> Lac
            if (r0 == 0) goto L58
            java.lang.String r0 = r8.getString(r5)     // Catch: org.json.JSONException -> Lac
            r9.setValue(r0)     // Catch: org.json.JSONException -> Lac
        L58:
            boolean r0 = r8.has(r4)     // Catch: org.json.JSONException -> Lac
            if (r0 == 0) goto L7b
            java.lang.String r0 = r8.getString(r4)     // Catch: java.text.ParseException -> L70 org.json.JSONException -> Lac
            r10 = r19
            java.text.SimpleDateFormat r11 = r10.dateFormat     // Catch: java.text.ParseException -> L6e org.json.JSONException -> La7
            java.util.Date r0 = r11.parse(r0)     // Catch: java.text.ParseException -> L6e org.json.JSONException -> La7
            r9.setTimestamp(r0)     // Catch: java.text.ParseException -> L6e org.json.JSONException -> La7
            goto L7d
        L6e:
            r0 = move-exception
            goto L73
        L70:
            r0 = move-exception
            r10 = r19
        L73:
            java.lang.String r11 = "Exception when parsing referring URL query parameter timestamp"
            java.lang.Exception r0 = (java.lang.Exception) r0     // Catch: org.json.JSONException -> La7
            io.branch.referral.BranchLogger.logException(r11, r0)     // Catch: org.json.JSONException -> La7
            goto L7d
        L7b:
            r10 = r19
        L7d:
            boolean r0 = r8.has(r3)     // Catch: org.json.JSONException -> La7
            if (r0 == 0) goto L8a
            long r11 = r8.getLong(r3)     // Catch: org.json.JSONException -> La7
            r9.setValidityWindow(r11)     // Catch: org.json.JSONException -> La7
        L8a:
            boolean r0 = r8.has(r2)     // Catch: org.json.JSONException -> La7
            if (r0 == 0) goto L98
            boolean r0 = r8.getBoolean(r2)     // Catch: org.json.JSONException -> La7
            r9.setDeepLink(r0)     // Catch: org.json.JSONException -> La7
            goto L9c
        L98:
            r0 = 0
            r9.setDeepLink(r0)     // Catch: org.json.JSONException -> La7
        L9c:
            java.lang.String r0 = r9.getName()     // Catch: org.json.JSONException -> La7
            if (r0 == 0) goto L1b
            r6.put(r0, r9)     // Catch: org.json.JSONException -> La7
            goto L1b
        La7:
            r0 = move-exception
            goto Laf
        La9:
            r10 = r19
            goto Lb6
        Lac:
            r0 = move-exception
            r10 = r19
        Laf:
            java.lang.String r1 = "Exception when deserializing JSON for referring URL query parameters"
            java.lang.Exception r0 = (java.lang.Exception) r0
            io.branch.referral.BranchLogger.logException(r1, r0)
        Lb6:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ReferringUrlUtility.deserializeFromJson$Branch_SDK_release(org.json.JSONObject):java.util.Map");
    }

    private final void checkForAndMigrateOldGclid() {
        String referrerGclid;
        BranchUrlQueryParameter branchUrlQueryParameter = this.urlQueryParameters.get(Defines.Jsonkey.Gclid.getKey());
        if ((branchUrlQueryParameter != null ? branchUrlQueryParameter.getValue() : null) != null || (referrerGclid = this.prefHelper.getReferrerGclid()) == null || Intrinsics.areEqual(referrerGclid, PrefHelper.NO_STRING_VALUE)) {
            return;
        }
        BranchUrlQueryParameter branchUrlQueryParameter2 = new BranchUrlQueryParameter(Defines.Jsonkey.Gclid.getKey(), referrerGclid, new Date(), false, this.prefHelper.getReferrerGclidValidForWindow());
        Map<String, BranchUrlQueryParameter> map = this.urlQueryParameters;
        String key = Defines.Jsonkey.Gclid.getKey();
        Intrinsics.checkNotNullExpressionValue(key, "Gclid.key");
        map.put(key, branchUrlQueryParameter2);
        this.prefHelper.setReferringUrlQueryParameters(serializeToJson$Branch_SDK_release(this.urlQueryParameters));
        this.prefHelper.clearGclid();
        BranchLogger.v("Updated old Gclid (" + referrerGclid + ") to new BranchUrlQueryParameter (" + branchUrlQueryParameter2 + ')');
    }
}
