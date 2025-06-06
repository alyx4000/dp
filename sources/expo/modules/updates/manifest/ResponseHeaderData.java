package expo.modules.updates.manifest;

import android.util.Log;
import expo.modules.structuredheaders.BooleanItem;
import expo.modules.structuredheaders.ListElement;
import expo.modules.structuredheaders.NumberItem;
import expo.modules.structuredheaders.ParseException;
import expo.modules.structuredheaders.Parser;
import expo.modules.structuredheaders.StringItem;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ResponseHeaderData.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0011HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0016\u0010\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lexpo/modules/updates/manifest/ResponseHeaderData;", "", "protocolVersionRaw", "", "serverDefinedHeadersRaw", "manifestFiltersRaw", "manifestSignature", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "manifestFilters", "Lorg/json/JSONObject;", "getManifestFilters", "()Lorg/json/JSONObject;", "manifestFilters$delegate", "Lkotlin/Lazy;", "getManifestSignature", "()Ljava/lang/String;", "protocolVersion", "", "getProtocolVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "serverDefinedHeaders", "getServerDefinedHeaders", "serverDefinedHeaders$delegate", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ResponseHeaderData {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "ResponseHeaderData";

    /* renamed from: manifestFilters$delegate, reason: from kotlin metadata */
    private final Lazy manifestFilters;
    private final String manifestFiltersRaw;
    private final String manifestSignature;
    private final Integer protocolVersion;
    private final String protocolVersionRaw;

    /* renamed from: serverDefinedHeaders$delegate, reason: from kotlin metadata */
    private final Lazy serverDefinedHeaders;
    private final String serverDefinedHeadersRaw;

    public ResponseHeaderData() {
        this(null, null, null, null, 15, null);
    }

    /* renamed from: component1, reason: from getter */
    private final String getProtocolVersionRaw() {
        return this.protocolVersionRaw;
    }

    /* renamed from: component2, reason: from getter */
    private final String getServerDefinedHeadersRaw() {
        return this.serverDefinedHeadersRaw;
    }

    /* renamed from: component3, reason: from getter */
    private final String getManifestFiltersRaw() {
        return this.manifestFiltersRaw;
    }

    public static /* synthetic */ ResponseHeaderData copy$default(ResponseHeaderData responseHeaderData, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = responseHeaderData.protocolVersionRaw;
        }
        if ((i & 2) != 0) {
            str2 = responseHeaderData.serverDefinedHeadersRaw;
        }
        if ((i & 4) != 0) {
            str3 = responseHeaderData.manifestFiltersRaw;
        }
        if ((i & 8) != 0) {
            str4 = responseHeaderData.manifestSignature;
        }
        return responseHeaderData.copy(str, str2, str3, str4);
    }

    /* renamed from: component4, reason: from getter */
    public final String getManifestSignature() {
        return this.manifestSignature;
    }

    public final ResponseHeaderData copy(String protocolVersionRaw, String serverDefinedHeadersRaw, String manifestFiltersRaw, String manifestSignature) {
        return new ResponseHeaderData(protocolVersionRaw, serverDefinedHeadersRaw, manifestFiltersRaw, manifestSignature);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResponseHeaderData)) {
            return false;
        }
        ResponseHeaderData responseHeaderData = (ResponseHeaderData) other;
        return Intrinsics.areEqual(this.protocolVersionRaw, responseHeaderData.protocolVersionRaw) && Intrinsics.areEqual(this.serverDefinedHeadersRaw, responseHeaderData.serverDefinedHeadersRaw) && Intrinsics.areEqual(this.manifestFiltersRaw, responseHeaderData.manifestFiltersRaw) && Intrinsics.areEqual(this.manifestSignature, responseHeaderData.manifestSignature);
    }

    public int hashCode() {
        String str = this.protocolVersionRaw;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.serverDefinedHeadersRaw;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.manifestFiltersRaw;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.manifestSignature;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "ResponseHeaderData(protocolVersionRaw=" + this.protocolVersionRaw + ", serverDefinedHeadersRaw=" + this.serverDefinedHeadersRaw + ", manifestFiltersRaw=" + this.manifestFiltersRaw + ", manifestSignature=" + this.manifestSignature + ")";
    }

    public ResponseHeaderData(String str, String str2, String str3, String str4) {
        this.protocolVersionRaw = str;
        this.serverDefinedHeadersRaw = str2;
        this.manifestFiltersRaw = str3;
        this.manifestSignature = str4;
        this.protocolVersion = str != null ? Integer.valueOf(str) : null;
        this.serverDefinedHeaders = LazyKt.lazy(new Function0<JSONObject>() { // from class: expo.modules.updates.manifest.ResponseHeaderData$serverDefinedHeaders$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final JSONObject invoke() {
                String str5;
                str5 = ResponseHeaderData.this.serverDefinedHeadersRaw;
                if (str5 != null) {
                    return ResponseHeaderData.INSTANCE.headerDictionaryToJSONObject(str5);
                }
                return null;
            }
        });
        this.manifestFilters = LazyKt.lazy(new Function0<JSONObject>() { // from class: expo.modules.updates.manifest.ResponseHeaderData$manifestFilters$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final JSONObject invoke() {
                String str5;
                str5 = ResponseHeaderData.this.manifestFiltersRaw;
                if (str5 != null) {
                    return ResponseHeaderData.INSTANCE.headerDictionaryToJSONObject(str5);
                }
                return null;
            }
        });
    }

    public /* synthetic */ ResponseHeaderData(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getManifestSignature() {
        return this.manifestSignature;
    }

    public final Integer getProtocolVersion() {
        return this.protocolVersion;
    }

    public final JSONObject getServerDefinedHeaders() {
        return (JSONObject) this.serverDefinedHeaders.getValue();
    }

    public final JSONObject getManifestFilters() {
        return (JSONObject) this.manifestFilters.getValue();
    }

    /* compiled from: ResponseHeaderData.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lexpo/modules/updates/manifest/ResponseHeaderData$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "headerDictionaryToJSONObject", "Lorg/json/JSONObject;", "headerDictionary", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JSONObject headerDictionaryToJSONObject(String headerDictionary) {
            JSONObject jSONObject = new JSONObject();
            try {
                Map<String, ListElement<? extends Object>> map = new Parser(headerDictionary).parseDictionary().get();
                for (String str : map.keySet()) {
                    ListElement<? extends Object> listElement = map.get(str);
                    Intrinsics.checkNotNull(listElement);
                    ListElement<? extends Object> listElement2 = listElement;
                    if ((listElement2 instanceof StringItem) || (listElement2 instanceof BooleanItem) || (listElement2 instanceof NumberItem)) {
                        jSONObject.put(str, listElement2.get());
                    }
                }
                return jSONObject;
            } catch (ParseException e) {
                Log.e(ResponseHeaderData.TAG, "Failed to parse manifest header content", e);
                return null;
            } catch (JSONException e2) {
                Log.e(ResponseHeaderData.TAG, "Failed to parse manifest header content", e2);
                return null;
            }
        }
    }
}
