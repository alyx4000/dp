package sdk.pendo.io.p8;

import kotlin.Metadata;
import sdk.pendo.io.models.SessionData;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\n"}, d2 = {"Lsdk/pendo/io/p8/d;", "", "", "wasSent", "", "b", "a", "Lsdk/pendo/io/models/SessionData;", "sessionData", "shouldSendDeviceInfo", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public interface d {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class a {
        public static void a(d dVar, SessionData sessionData) {
            dVar.a(sessionData, false);
        }
    }

    void a(SessionData sessionData);

    void a(SessionData sessionData, boolean shouldSendDeviceInfo);

    void a(boolean wasSent);

    void b(boolean wasSent);
}
