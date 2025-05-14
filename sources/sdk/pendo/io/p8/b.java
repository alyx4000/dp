package sdk.pendo.io.p8;

import io.sentry.protocol.Response;
import kotlin.Metadata;
import sdk.pendo.io.network.interfaces.GetAuthToken;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/p8/b;", "", "Lsdk/pendo/io/network/interfaces/GetAuthToken$GetAuthTokenResponse;", Response.TYPE, "", "onGetAccessTokenResponseReceived", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public interface b {
    void onGetAccessTokenResponseReceived(GetAuthToken.GetAuthTokenResponse response);
}
