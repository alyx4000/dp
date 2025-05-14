package sdk.pendo.io.c8;

import io.sentry.clientreport.DiscardedEvent;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;

/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private GuideModel f962a;
    private long b = -1;
    private String c;
    private b d;

    public enum a {
        TIME_OUT("Timeout"),
        STATE_CHANGED("StateChanged"),
        CLOSE_BUTTON("CloseButton"),
        SYSTEM("System"),
        APP_TERMINATION("AppTermination"),
        USER_ACTION("UserAction"),
        APP_IN_BACKGROUND("AppInBackground");

        private final String mValue;

        a(String str) {
            this.mValue = str;
        }

        public String b() {
            return this.mValue;
        }
    }

    public enum b {
        ERROR_REASON_CAPPING("Capping"),
        ERROR_CONTROL_GROUP("ControlGroup"),
        ERROR_REASON_CONNECTIVITY("Connectivity"),
        ERROR_REASON_IMAGE("ImageError"),
        ERROR_REASON_VIDEO("VideoError"),
        ERROR_REASON_CONFIGURATION("ConfigurationError"),
        ELEMENT_NOT_VISIBLE("ElementNotVisible"),
        ERROR_REASON_UNKNOWN("Unknown"),
        ERROR_REASON_RUN_PREVIEW_GUIDE("RunPreviewInsertError"),
        ERROR_REASON_ENTER_TEST_MODE("EnterTestModeError"),
        ERROR_REASON_BACKEND("BackendError"),
        ERROR_GUIDE_ALREADY_DISPLAYED("GuideAlreadyDisplayed");

        private final String mValue;

        b(String str) {
            this.mValue = str;
        }

        public String b() {
            return this.mValue;
        }
    }

    public enum c {
        JS_ERROR("JSError");

        private final String mValue;

        c(String str) {
            this.mValue = str;
        }

        public String b() {
            return this.mValue;
        }
    }

    /* renamed from: sdk.pendo.io.c8.d$d, reason: collision with other inner class name */
    public enum EnumC0097d {
        INVALID_SIGNATURE("InvalidSignature");

        private final String mValue;

        EnumC0097d(String str) {
            this.mValue = str;
        }

        public String b() {
            return this.mValue;
        }
    }

    public d(GuideModel guideModel) {
        this.f962a = guideModel;
    }

    public void a(JSONObject jSONObject, String str) {
        String str2;
        String b2;
        try {
            jSONObject.put("group", new JSONObject());
            sdk.pendo.io.c8.c a2 = sdk.pendo.io.c8.c.a(str);
            sdk.pendo.io.c8.c.GUIDE_RECEIVED.equals(a2);
            if (sdk.pendo.io.c8.c.GUIDE_DISMISSED.equals(a2)) {
                b2 = a();
                if (b2 == null) {
                    PendoLogger.w("No dismiss reason given!", new Object[0]);
                    return;
                } else {
                    jSONObject.put("displayDurationInMillis", b());
                    str2 = PendoCommandAction.PendoCommandGlobalAction.SendPendoGenericAnalyticsConsts.DISMISSED_BY;
                }
            } else {
                if (!sdk.pendo.io.c8.c.GUIDE_NOT_DISPLAYED.equals(a2)) {
                    return;
                }
                b e = e();
                if (e == null) {
                    PendoLogger.w("No not display reason given!", new Object[0]);
                    return;
                } else {
                    str2 = DiscardedEvent.JsonKeys.REASON;
                    b2 = e.b();
                }
            }
            jSONObject.put(str2, b2);
        } catch (JSONException e2) {
            PendoLogger.e(e2.getMessage(), new Object[0]);
        }
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.f962a.getGuideId();
    }

    protected GuideModel d() {
        return this.f962a;
    }

    public b e() {
        return this.d;
    }

    private String a() {
        return this.c;
    }

    public d a(String str) {
        this.c = str;
        return this;
    }

    public d a(long j) {
        this.b = j;
        return this;
    }

    public d a(b bVar) {
        this.d = bVar;
        return this;
    }
}
