package expo.modules.storereview;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* compiled from: StoreReviewExceptions.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/storereview/RMTaskException;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-store-review_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RMTaskException extends CodedException {
    public RMTaskException() {
        super("Android ReviewManager task failed", null, 2, null);
    }
}
