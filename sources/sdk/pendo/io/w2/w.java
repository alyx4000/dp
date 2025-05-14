package sdk.pendo.io.w2;

import androidx.core.app.NotificationCompat;
import io.sentry.SentryBaseEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001:\u0001\u0005J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/w2/w;", "", "Lsdk/pendo/io/w2/w$a;", "chain", "Lsdk/pendo/io/w2/d0;", "a", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public interface w {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\t\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lsdk/pendo/io/w2/w$a;", "", "Lsdk/pendo/io/w2/b0;", "a", SentryBaseEvent.JsonKeys.REQUEST, "Lsdk/pendo/io/w2/d0;", "Lsdk/pendo/io/w2/j;", "b", "Lsdk/pendo/io/w2/e;", NotificationCompat.CATEGORY_CALL, "okhttp"}, k = 1, mv = {1, 8, 0})
    public interface a {
        b0 a();

        d0 a(b0 request);

        j b();

        e call();
    }

    d0 a(a chain);
}
