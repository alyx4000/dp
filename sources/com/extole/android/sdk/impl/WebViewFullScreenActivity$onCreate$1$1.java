package com.extole.android.sdk.impl;

import android.webkit.WebView;
import com.extole.android.sdk.Extole;
import com.extole.android.sdk.impl.app.App;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WebViewFullScreenActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.impl.WebViewFullScreenActivity$onCreate$1$1", f = "WebViewFullScreenActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class WebViewFullScreenActivity$onCreate$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $data;
    final /* synthetic */ String $extoleZoneName;
    int label;
    final /* synthetic */ WebViewFullScreenActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WebViewFullScreenActivity$onCreate$1$1(WebViewFullScreenActivity webViewFullScreenActivity, Map<String, String> map, String str, Continuation<? super WebViewFullScreenActivity$onCreate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = webViewFullScreenActivity;
        this.$data = map;
        this.$extoleZoneName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewFullScreenActivity$onCreate$1$1(this.this$0, this.$data, this.$extoleZoneName, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewFullScreenActivity$onCreate$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        final WebViewFullScreenActivity webViewFullScreenActivity = this.this$0;
        final Map<String, String> map = this.$data;
        final String str = this.$extoleZoneName;
        webViewFullScreenActivity.runOnUiThread(new Runnable() { // from class: com.extole.android.sdk.impl.WebViewFullScreenActivity$onCreate$1$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                WebViewFullScreenActivity$onCreate$1$1.m381invokeSuspend$lambda0(WebViewFullScreenActivity.this, map, str);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0, reason: not valid java name */
    public static final void m381invokeSuspend$lambda0(WebViewFullScreenActivity webViewFullScreenActivity, Map map, String str) {
        WebView webView;
        ExtoleInternal extole = App.INSTANCE.getExtole();
        webView = webViewFullScreenActivity.webView;
        Intrinsics.checkNotNull(webView);
        Extole.DefaultImpls.webView$default(extole, webView, null, map, 2, null).load(str);
    }
}
