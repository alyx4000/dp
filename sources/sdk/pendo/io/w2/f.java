package sdk.pendo.io.w2;

import androidx.core.app.NotificationCompat;
import io.sentry.protocol.Response;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lsdk/pendo/io/w2/f;", "", "Lsdk/pendo/io/w2/e;", NotificationCompat.CATEGORY_CALL, "Ljava/io/IOException;", "e", "", "a", "Lsdk/pendo/io/w2/d0;", Response.TYPE, "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public interface f {
    void a(e call, IOException e);

    void a(e call, d0 response);
}
