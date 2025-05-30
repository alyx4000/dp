package expo.modules.kotlin.events;

import com.facebook.react.uimanager.ViewProps;
import com.iterable.iterableapi.IterableConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: KModuleEventEmitterWrapper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0003"}, d2 = {"normalizeEventName", "", IterableConstants.KEY_EVENT_NAME, "expo-modules-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KModuleEventEmitterWrapperKt {
    public static final String normalizeEventName(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (!StringsKt.startsWith$default(eventName, "on", false, 2, (Object) null)) {
            return eventName;
        }
        String substring = eventName.substring(2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return ViewProps.TOP + substring;
    }
}
