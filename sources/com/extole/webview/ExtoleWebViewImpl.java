package com.extole.webview;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.extole.android.sdk.Extole;
import com.extole.android.sdk.ExtoleWebView;
import com.extole.android.sdk.ProtocolHandler;
import com.extole.android.sdk.impl.ApplicationContext;
import com.extole.android.sdk.impl.ExtoleShareBroadcastReceiver;
import com.extole.android.sdk.impl.JsExtoleShareImpl;
import com.extole.android.sdk.impl.protocol.handlers.MailtoProtocolHandler;
import com.extole.android.sdk.impl.protocol.handlers.SmsProtocolHandler;
import com.extole.android.sdk.impl.protocol.handlers.TelProtocolHandler;
import com.facebook.react.uimanager.events.TouchesHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* compiled from: ExtoleWebViewImpl.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0016\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J\b\u0010 \u001a\u0004\u0018\u00010\u0003J:\u0010!\u001a4\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00150\"H\u0002J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0003H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/extole/webview/ExtoleWebViewImpl;", "Lcom/extole/android/sdk/ExtoleWebView;", "programDomain", "", "webView", "Landroid/webkit/WebView;", "context", "Lcom/extole/android/sdk/impl/ApplicationContext;", "extole", "Lcom/extole/android/sdk/Extole;", "headers", "", "queryParameters", "protocolHandlers", "", "Lcom/extole/android/sdk/ProtocolHandler;", "(Ljava/lang/String;Landroid/webkit/WebView;Lcom/extole/android/sdk/impl/ApplicationContext;Lcom/extole/android/sdk/Extole;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;)V", "afterShareAction", "Lkotlin/Function0;", "", "createChooser", "Landroid/content/Intent;", TouchesHelper.TARGET_KEY, "title", "", "sender", "Landroid/content/IntentSender;", "createPendingIntent", "Landroid/app/PendingIntent;", "broadcastReceiver", "Ljava/lang/Class;", "Lcom/extole/android/sdk/impl/ExtoleShareBroadcastReceiver;", "getPartnerShareId", "intentScopeExtender", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "intent", "load", "zone", "Companion", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExtoleWebViewImpl implements ExtoleWebView {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<ProtocolHandler> DEFAULT_PROTOCOL_HANDLERS = CollectionsKt.listOf((Object[]) new ProtocolHandler[]{new SmsProtocolHandler(), new TelProtocolHandler(), new MailtoProtocolHandler()});
    private final ApplicationContext context;
    private final Extole extole;
    private final Map<String, String> headers;
    private final String programDomain;
    private final List<ProtocolHandler> protocolHandlers;
    private final Map<String, String> queryParameters;
    private final WebView webView;

    /* JADX WARN: Multi-variable type inference failed */
    public ExtoleWebViewImpl(String programDomain, WebView webView, ApplicationContext context, Extole extole, Map<String, String> headers, Map<String, String> queryParameters, List<? extends ProtocolHandler> protocolHandlers) {
        Intrinsics.checkNotNullParameter(programDomain, "programDomain");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extole, "extole");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(queryParameters, "queryParameters");
        Intrinsics.checkNotNullParameter(protocolHandlers, "protocolHandlers");
        this.programDomain = programDomain;
        this.webView = webView;
        this.context = context;
        this.extole = extole;
        this.headers = headers;
        this.queryParameters = queryParameters;
        this.protocolHandlers = protocolHandlers;
        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JsExtoleShareImpl(context.getContext(), getPartnerShareId(), intentScopeExtender(), afterShareAction()), "extoleShare");
        final List mutableList = CollectionsKt.toMutableList((Collection) protocolHandlers);
        mutableList.addAll(DEFAULT_PROTOCOL_HANDLERS);
        webView.setWebViewClient(new WebViewClient() { // from class: com.extole.webview.ExtoleWebViewImpl.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url, "url");
                List<ProtocolHandler> list = mutableList;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((ProtocolHandler) obj).isInterested(url)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = arrayList;
                if (!(!arrayList2.isEmpty())) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                    intent.addFlags(268435456);
                    this.context.startActivity(intent);
                    return true;
                }
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((ProtocolHandler) it.next()).handle(view, url);
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                this.extole.getLogger().error("Http error request (url=" + (request != null ? request.getUrl() : null) + ", method=" + (request != null ? request.getMethod() : null) + ", requestHeaders=" + (request != null ? request.getRequestHeaders() : null) + "), error: " + (errorResponse != null ? errorResponse.getReasonPhrase() : null), new Object[0]);
                super.onReceivedHttpError(view, request, errorResponse);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                this.extole.getLogger().error("SSL error: " + error, new Object[0]);
                super.onReceivedSslError(view, handler, error);
            }
        });
    }

    public /* synthetic */ ExtoleWebViewImpl(String str, WebView webView, ApplicationContext applicationContext, Extole extole, Map map, Map map2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, webView, applicationContext, extole, map, map2, (i & 64) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* compiled from: ExtoleWebViewImpl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/extole/webview/ExtoleWebViewImpl$Companion;", "", "()V", "DEFAULT_PROTOCOL_HANDLERS", "", "Lcom/extole/android/sdk/ProtocolHandler;", "getDEFAULT_PROTOCOL_HANDLERS", "()Ljava/util/List;", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<ProtocolHandler> getDEFAULT_PROTOCOL_HANDLERS() {
            return ExtoleWebViewImpl.DEFAULT_PROTOCOL_HANDLERS;
        }
    }

    @Override // com.extole.android.sdk.ExtoleWebView
    public void load(String zone) {
        Intrinsics.checkNotNullParameter(zone, "zone");
        Uri.Builder appendEncodedPath = new Uri.Builder().scheme("https").appendEncodedPath(this.programDomain + "/zone/" + zone);
        for (Map.Entry<String, String> entry : this.queryParameters.entrySet()) {
            appendEncodedPath.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        this.webView.loadUrl(appendEncodedPath.build().toString(), this.headers);
    }

    private final Function0<Unit> afterShareAction() {
        return new Function0<Unit>() { // from class: com.extole.webview.ExtoleWebViewImpl$afterShareAction$1
            {
                super(0);
            }

            /* compiled from: ExtoleWebViewImpl.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            @DebugMetadata(c = "com.extole.webview.ExtoleWebViewImpl$afterShareAction$1$1", f = "ExtoleWebViewImpl.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.extole.webview.ExtoleWebViewImpl$afterShareAction$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ ExtoleWebViewImpl this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(ExtoleWebViewImpl extoleWebViewImpl, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = extoleWebViewImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.this$0.extole.getLogger().info("Sending preshare event", new Object[0]);
                        this.label = 1;
                        if (Extole.DefaultImpls.sendEvent$default(this.this$0.extole, "preshare", MapsKt.mapOf(TuplesKt.to("partner_share_id", this.this$0.getPartnerShareId())), null, this, 4, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(ExtoleWebViewImpl.this, null), 3, null);
            }
        };
    }

    private final Function2<Intent, String, Intent> intentScopeExtender() {
        return new Function2<Intent, String, Intent>() { // from class: com.extole.webview.ExtoleWebViewImpl$intentScopeExtender$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Intent invoke(Intent intent, String str) {
                PendingIntent createPendingIntent;
                Intent createChooser;
                Intrinsics.checkNotNullParameter(intent, "intent");
                createPendingIntent = ExtoleWebViewImpl.this.createPendingIntent(ExtoleShareBroadcastReceiver.class);
                createChooser = ExtoleWebViewImpl.this.createChooser(intent, str, createPendingIntent.getIntentSender());
                return createChooser;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent createChooser(Intent target, CharSequence title, IntentSender sender) {
        Intent intent = new Intent("android.intent.action.CHOOSER");
        intent.putExtra("android.intent.extra.INTENT", target);
        if (title != null) {
            intent.putExtra("android.intent.extra.TITLE", title);
        }
        if (sender != null) {
            intent.putExtra("android.intent.extra.CHOSEN_COMPONENT_INTENT_SENDER", sender);
        }
        intent.addFlags(268435456);
        return intent;
    }

    public final String getPartnerShareId() {
        String str = this.context.getPersistence().get("partner_share_id");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            this.extole.getLogger().debug("Partner Share id is empty for WebView", new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PendingIntent createPendingIntent(Class<ExtoleShareBroadcastReceiver> broadcastReceiver) {
        PendingIntent broadcast = PendingIntent.getBroadcast(this.context.getContext(), 0, new Intent(this.context.getContext(), broadcastReceiver), 33554432);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(\n          …nt.FLAG_MUTABLE\n        )");
        return broadcast;
    }
}
