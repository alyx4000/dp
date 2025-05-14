package sdk.pendo.io.p8;

import com.iterable.iterableapi.IterableConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.k8.b;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.JWTSessionData;
import sdk.pendo.io.models.SessionData;
import sdk.pendo.io.p8.d;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b\b\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\r\u001a\u0004\b\u0005\u0010\u000e\"\u0004\b\u0012\u0010\u0010R(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0006\u0010\u000e\"\u0004\b\u0015\u0010\u0010¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/p8/c;", "Lsdk/pendo/io/p8/d;", "", "wasSent", "", "b", "a", "finishedSendingPersistedAnalytics", "c", "Lsdk/pendo/io/models/SessionData;", "sessionData", "shouldSendDeviceInfo", "Lsdk/pendo/io/w6/a;", "Lsdk/pendo/io/w6/a;", "()Lsdk/pendo/io/w6/a;", "setFinishedSendingPersistedAnalytics", "(Lsdk/pendo/io/w6/a;)V", "isFinishedSendingPersistedAnalytics", "setVisitorDataSent", "visitorDataSent", "d", "setAccountDataSent", "accountDataSent", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final c f1504a = new c();

    /* renamed from: b, reason: from kotlin metadata */
    private static sdk.pendo.io.w6.a<Boolean> isFinishedSendingPersistedAnalytics;

    /* renamed from: c, reason: from kotlin metadata */
    private static sdk.pendo.io.w6.a<Boolean> visitorDataSent;

    /* renamed from: d, reason: from kotlin metadata */
    private static sdk.pendo.io.w6.a<Boolean> accountDataSent;

    static {
        Boolean bool = Boolean.FALSE;
        sdk.pendo.io.w6.a<Boolean> b = sdk.pendo.io.w6.a.b(bool);
        Intrinsics.checkNotNullExpressionValue(b, "createDefault(...)");
        isFinishedSendingPersistedAnalytics = b;
        sdk.pendo.io.w6.a<Boolean> b2 = sdk.pendo.io.w6.a.b(bool);
        Intrinsics.checkNotNullExpressionValue(b2, "createDefault(...)");
        visitorDataSent = b2;
        sdk.pendo.io.w6.a<Boolean> b3 = sdk.pendo.io.w6.a.b(bool);
        Intrinsics.checkNotNullExpressionValue(b3, "createDefault(...)");
        accountDataSent = b3;
    }

    private c() {
    }

    public final sdk.pendo.io.w6.a<Boolean> a() {
        return accountDataSent;
    }

    public final sdk.pendo.io.w6.a<Boolean> b() {
        return visitorDataSent;
    }

    public final sdk.pendo.io.w6.a<Boolean> c() {
        return isFinishedSendingPersistedAnalytics;
    }

    @Override // sdk.pendo.io.p8.d
    public void a(SessionData sessionData) {
        d.a.a(this, sessionData);
    }

    @Override // sdk.pendo.io.p8.d
    public void b(boolean wasSent) {
        visitorDataSent.onNext(Boolean.valueOf(wasSent));
    }

    public void c(boolean finishedSendingPersistedAnalytics) {
        isFinishedSendingPersistedAnalytics.onNext(Boolean.valueOf(finishedSendingPersistedAnalytics));
    }

    @Override // sdk.pendo.io.p8.d
    public void a(SessionData sessionData, boolean shouldSendDeviceInfo) {
        if (sessionData == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (shouldSendDeviceInfo) {
                JSONObject jSONObject2 = new JSONObject();
                b.Companion companion = sdk.pendo.io.k8.b.INSTANCE;
                companion.b().a(jSONObject2);
                JSONObject jSONObject3 = jSONObject2.getJSONObject(companion.a());
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "getJSONObject(...)");
                jSONObject.put(IterableConstants.KEY_DEVICE_INFO, jSONObject3);
            }
            boolean z = true;
            boolean z2 = sessionData.getVisitorData() != null;
            if (sessionData.getAccountData() == null) {
                z = false;
            }
            if (sessionData instanceof JWTSessionData) {
                jSONObject.put("jwt", ((JWTSessionData) sessionData).getJwt());
                jSONObject.put("signingKeyName", ((JWTSessionData) sessionData).getSigningKeyName());
            } else {
                SessionData removeDuplicatesKeepingOriginalKeys = sessionData.removeDuplicatesKeepingOriginalKeys();
                if (z2) {
                    jSONObject.put("userAttr", new JSONObject(removeDuplicatesKeepingOriginalKeys.getVisitorData()));
                }
                if (z) {
                    jSONObject.put("accountAttr", new JSONObject(removeDuplicatesKeepingOriginalKeys.getAccountData()));
                }
            }
            a.d().a(sessionData, jSONObject, z, z2);
        } catch (JSONException e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
    }

    @Override // sdk.pendo.io.p8.d
    public void a(boolean wasSent) {
        accountDataSent.onNext(Boolean.valueOf(wasSent));
    }
}
