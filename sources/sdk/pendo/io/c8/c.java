package sdk.pendo.io.c8;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import sdk.pendo.io.actions.PendoCommandAction;

/* loaded from: classes6.dex */
public enum c {
    GUIDE_RECEIVED("guideReceived"),
    GUIDE_SEEN("guideSeen"),
    GUIDE_DISPLAYED("guideDisplayed"),
    GUIDE_DISMISSED(PendoCommandAction.PendoCommandGlobalAction.SendPendoGenericAnalyticsConsts.GUIDE_DISMISSED),
    GUIDE_NOT_DISPLAYED("guideNotDisplayed"),
    APP_SCREEN_LEFT("AppScreenLeft"),
    CUSTOM_EVENT_OCCURRED("CustomEventOccurred"),
    TRACK_EVENT("trackEvent"),
    FORM_SUBMITTED("FormSubmitted"),
    POLL_RESPONSE("pollResponse"),
    PAGER_FLOW("PagerFlow"),
    APP_SESSION_START("AppSessionStart"),
    APP_SESSION_END("AppSessionEnd"),
    APP_IN_BACKGROUND("AppInBackground"),
    APP_IN_FOREGROUND("AppInForeground"),
    APP_SCREEN_VIEWED("AppScreenViewed"),
    APP_BUTTON_CLICKED("AppButtonClicked"),
    LIST_ITEM_CLICKED("ListItemClicked"),
    SDK_EXCEPTION("SdkException"),
    SDK_ERROR("SdkError"),
    SECURITY_EXCEPTION("SecurityException"),
    IDENTIFY("identify"),
    UNKNOWN("Unknown");

    private static final Map<String, c> LOOKUP_BY_EVENT = new HashMap();
    private final String mValue;

    static {
        Iterator it = EnumSet.allOf(c.class).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            LOOKUP_BY_EVENT.put(cVar.b(), cVar);
        }
    }

    c(String str) {
        this.mValue = str;
    }

    public String b() {
        return this.mValue;
    }

    public static c a(String str) {
        c cVar = LOOKUP_BY_EVENT.get(str);
        return cVar != null ? cVar : UNKNOWN;
    }
}
