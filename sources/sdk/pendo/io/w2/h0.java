package sdk.pendo.io.w2;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import io.sentry.SentryBaseEvent;
import io.sentry.clientreport.DiscardedEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&¨\u0006\f"}, d2 = {"Lsdk/pendo/io/w2/h0;", "", "", "text", "", "a", "Lsdk/pendo/io/k3/g;", "bytes", "c", "", ApiConstant.KEY_CODE, DiscardedEvent.JsonKeys.REASON, "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public interface h0 {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lsdk/pendo/io/w2/h0$a;", "", "Lsdk/pendo/io/w2/b0;", SentryBaseEvent.JsonKeys.REQUEST, "Lsdk/pendo/io/w2/i0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lsdk/pendo/io/w2/h0;", "a", "okhttp"}, k = 1, mv = {1, 8, 0})
    public interface a {
        h0 a(b0 request, i0 listener);
    }

    boolean a(int code, String reason);

    boolean a(String text);

    boolean c(sdk.pendo.io.k3.g bytes);
}
