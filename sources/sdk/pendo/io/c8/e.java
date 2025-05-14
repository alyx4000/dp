package sdk.pendo.io.c8;

import io.sentry.protocol.Device;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lsdk/pendo/io/c8/e;", "", "", "event", "b", "", "deviceTime", "a", "visitorId", "d", "accountId", Device.JsonKeys.ORIENTATION, "c", "Lorg/json/JSONObject;", "Ljava/lang/String;", "Ljava/lang/Long;", "duration", "e", "f", "Lorg/json/JSONArray;", "g", "Lorg/json/JSONArray;", "activeTime", "<init>", "()V", "h", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String event;

    /* renamed from: b, reason: from kotlin metadata */
    private Long deviceTime;

    /* renamed from: c, reason: from kotlin metadata */
    private String duration;

    /* renamed from: d, reason: from kotlin metadata */
    private String visitorId;

    /* renamed from: e, reason: from kotlin metadata */
    private String accountId;

    /* renamed from: f, reason: from kotlin metadata */
    private String orientation;

    /* renamed from: g, reason: from kotlin metadata */
    private JSONArray activeTime;

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String str = this.event;
        if (str != null) {
            jSONObject.put("event", str);
        }
        Long l = this.deviceTime;
        if (l != null) {
            jSONObject.put("device_time", l.longValue());
        }
        String str2 = this.visitorId;
        if (str2 != null) {
            jSONObject.put("visitorId", str2);
        }
        String str3 = this.accountId;
        if (str3 != null) {
            jSONObject.put("accountId", str3);
        }
        String str4 = this.orientation;
        if (str4 != null) {
            jSONObject.put(Device.JsonKeys.ORIENTATION, str4);
        }
        String str5 = this.duration;
        if (str5 != null) {
            jSONObject.put("duration", str5);
        }
        JSONArray jSONArray = this.activeTime;
        if (jSONArray != null) {
            jSONObject.put("activeTime", jSONArray);
        }
        return jSONObject;
    }

    public final e b(String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.event = event;
        return this;
    }

    public final e c(String orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.orientation = orientation;
        return this;
    }

    public final e d(String visitorId) {
        this.visitorId = visitorId;
        return this;
    }

    public final e a(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public final e a(long deviceTime) {
        this.deviceTime = Long.valueOf(deviceTime);
        return this;
    }
}
