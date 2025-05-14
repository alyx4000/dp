package sdk.pendo.io.network.responses;

import sdk.pendo.io.l0.c;

/* loaded from: classes6.dex */
public final class AuthTokenErrorResponse {
    public static final String AUTHTOKEN_ERROR_ID = "errorId";
    public static final String AUTHTOKEN_ERROR_MESSAGE = "errorMessage";

    @c(AUTHTOKEN_ERROR_ID)
    private String mErrorId;

    @c("kill")
    private KillSwitchModel mKillSwitchModel;

    @c("errorMessage")
    private String mMessage;

    public String getErrorId() {
        return this.mErrorId;
    }

    public String getErrorMessage() {
        return this.mMessage;
    }

    public KillSwitchModel getKillSwitchModel() {
        return this.mKillSwitchModel;
    }
}
