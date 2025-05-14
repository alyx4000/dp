package com.extole.android.sdk.impl.protocol.handlers;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import com.extole.android.sdk.ProtocolHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SmsProtocolHandler.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"Lcom/extole/android/sdk/impl/protocol/handlers/SmsProtocolHandler;", "Lcom/extole/android/sdk/ProtocolHandler;", "()V", "handle", "", "view", "Landroid/webkit/WebView;", "url", "", "isInterested", "", "Companion", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SmsProtocolHandler implements ProtocolHandler {
    private static final String PROTOCOL = "sms";

    @Override // com.extole.android.sdk.ProtocolHandler
    public void handle(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.fromParts(PROTOCOL, StringsKt.replace$default(url, "sms:", "", false, 4, (Object) null), null)));
    }

    @Override // com.extole.android.sdk.ProtocolHandler
    public boolean isInterested(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return StringsKt.startsWith$default(url, PROTOCOL, false, 2, (Object) null);
    }
}
