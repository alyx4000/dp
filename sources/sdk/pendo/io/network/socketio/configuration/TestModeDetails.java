package sdk.pendo.io.network.socketio.configuration;

import com.google.firebase.messaging.Constants;
import io.sentry.Session;
import sdk.pendo.io.l0.c;
import sdk.pendo.io.models.GuideModel;

/* loaded from: classes6.dex */
public class TestModeDetails {

    @c("data")
    public GuideModel data;

    @c(Constants.MessagePayloadKeys.FROM)
    public String from;

    @c(Session.JsonKeys.SID)
    public String sessionId;

    @c("timestamp")
    public long timestamp;

    @c("to")
    public String to;
}
