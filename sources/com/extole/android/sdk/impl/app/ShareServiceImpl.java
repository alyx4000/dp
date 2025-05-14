package com.extole.android.sdk.impl.app;

import com.extole.android.sdk.Event;
import com.extole.android.sdk.Extole;
import com.extole.android.sdk.Id;
import com.extole.android.sdk.ShareResponse;
import com.extole.android.sdk.ShareService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: ShareServiceImpl.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JE\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J9\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/extole/android/sdk/impl/app/ShareServiceImpl;", "Lcom/extole/android/sdk/ShareService;", "extole", "Lcom/extole/android/sdk/Extole;", "(Lcom/extole/android/sdk/Extole;)V", "getExtole", "()Lcom/extole/android/sdk/Extole;", "emailShare", "Lcom/extole/android/sdk/Id;", "Lcom/extole/android/sdk/Event;", "recipient", "", "subject", "message", "data", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendShareEvent", "Lcom/extole/android/sdk/ShareResponse;", "channel", "partnerShareId", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ShareServiceImpl implements ShareService {
    private final Extole extole;

    public ShareServiceImpl(Extole extole) {
        Intrinsics.checkNotNullParameter(extole, "extole");
        this.extole = extole;
    }

    public final Extole getExtole() {
        return this.extole;
    }

    @Override // com.extole.android.sdk.ShareService
    public Object emailShare(String str, String str2, String str3, Map<String, ? extends Object> map, Continuation<? super Id<Event>> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(map);
        linkedHashMap.put("share.recipient", str);
        linkedHashMap.put("share.subject", str2);
        linkedHashMap.put("share.message", str3);
        linkedHashMap.put("share.channel", "EMAIL");
        return Extole.DefaultImpls.sendEvent$default(this.extole, "share", linkedHashMap, null, continuation, 4, null);
    }

    @Override // com.extole.android.sdk.ShareService
    public Object sendShareEvent(String str, Map<String, ? extends Object> map, String str2, Continuation<? super ShareResponse> continuation) {
        return CoroutineScopeKt.coroutineScope(new ShareServiceImpl$sendShareEvent$2(str2, map, str, this, null), continuation);
    }
}
