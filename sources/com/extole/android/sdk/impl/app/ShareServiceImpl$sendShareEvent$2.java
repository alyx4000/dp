package com.extole.android.sdk.impl.app;

import com.extole.android.sdk.CallExtensionKt;
import com.extole.android.sdk.Event;
import com.extole.android.sdk.Extole;
import com.extole.android.sdk.Id;
import com.extole.android.sdk.impl.ShareResponseImpl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* compiled from: ShareServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/extole/android/sdk/impl/ShareResponseImpl;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.impl.app.ShareServiceImpl$sendShareEvent$2", f = "ShareServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class ShareServiceImpl$sendShareEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ShareResponseImpl>, Object> {
    final /* synthetic */ String $channel;
    final /* synthetic */ Map<String, Object> $data;
    final /* synthetic */ String $partnerShareId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ShareServiceImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShareServiceImpl$sendShareEvent$2(String str, Map<String, ? extends Object> map, String str2, ShareServiceImpl shareServiceImpl, Continuation<? super ShareServiceImpl$sendShareEvent$2> continuation) {
        super(2, continuation);
        this.$partnerShareId = str;
        this.$data = map;
        this.$channel = str2;
        this.this$0 = shareServiceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShareServiceImpl$sendShareEvent$2 shareServiceImpl$sendShareEvent$2 = new ShareServiceImpl$sendShareEvent$2(this.$partnerShareId, this.$data, this.$channel, this.this$0, continuation);
        shareServiceImpl$sendShareEvent$2.L$0 = obj;
        return shareServiceImpl$sendShareEvent$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ShareResponseImpl> continuation) {
        return ((ShareServiceImpl$sendShareEvent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Deferred async$default;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        String str = this.$partnerShareId;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            str = CallExtensionKt.randomAlphaNumericString$default(0, 1, null);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.$data);
        linkedHashMap.put("share.channel", this.$channel);
        linkedHashMap.put("partner_share_id", str);
        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AnonymousClass1(this.this$0, linkedHashMap, null), 3, null);
        return new ShareResponseImpl(str, async$default);
    }

    /* compiled from: ShareServiceImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lcom/extole/android/sdk/Id;", "Lcom/extole/android/sdk/Event;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.extole.android.sdk.impl.app.ShareServiceImpl$sendShareEvent$2$1", f = "ShareServiceImpl.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.extole.android.sdk.impl.app.ShareServiceImpl$sendShareEvent$2$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Id<Event>>, Object> {
        final /* synthetic */ Map<String, Object> $requestData;
        int label;
        final /* synthetic */ ShareServiceImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ShareServiceImpl shareServiceImpl, Map<String, Object> map, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = shareServiceImpl;
            this.$requestData = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$requestData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Id<Event>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = Extole.DefaultImpls.sendEvent$default(this.this$0.getExtole(), "share", this.$requestData, null, this, 4, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }
}
