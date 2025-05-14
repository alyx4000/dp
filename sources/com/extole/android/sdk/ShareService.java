package com.extole.android.sdk;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;

/* compiled from: ShareService.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ=\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/extole/android/sdk/ShareService;", "", "emailShare", "Lcom/extole/android/sdk/Id;", "Lcom/extole/android/sdk/Event;", "recipient", "", "subject", "message", "data", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendShareEvent", "Lcom/extole/android/sdk/ShareResponse;", "channel", "partnerShareId", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ShareService {
    Object emailShare(String str, String str2, String str3, Map<String, ? extends Object> map, Continuation<? super Id<Event>> continuation);

    Object sendShareEvent(String str, Map<String, ? extends Object> map, String str2, Continuation<? super ShareResponse> continuation) throws SendError;

    /* compiled from: ShareService.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object emailShare$default(ShareService shareService, String str, String str2, String str3, Map map, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: emailShare");
            }
            if ((i & 8) != 0) {
                map = MapsKt.emptyMap();
            }
            return shareService.emailShare(str, str2, str3, map, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object sendShareEvent$default(ShareService shareService, String str, Map map, String str2, Continuation continuation, int i, Object obj) throws SendError {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendShareEvent");
            }
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            return shareService.sendShareEvent(str, map, str2, continuation);
        }
    }
}
