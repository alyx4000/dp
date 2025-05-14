package sdk.pendo.io.w2;

import io.sentry.SentryBaseEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0003J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Lsdk/pendo/io/w2/e;", "", "Lsdk/pendo/io/w2/b0;", "a", "Lsdk/pendo/io/w2/d0;", "b", "Lsdk/pendo/io/w2/f;", "responseCallback", "", "cancel", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public interface e extends Cloneable {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/w2/e$a;", "", "Lsdk/pendo/io/w2/b0;", SentryBaseEvent.JsonKeys.REQUEST, "Lsdk/pendo/io/w2/e;", "a", "okhttp"}, k = 1, mv = {1, 8, 0})
    public interface a {
        e a(b0 request);
    }

    b0 a();

    void a(f responseCallback);

    d0 b();

    void cancel();

    boolean e();
}
