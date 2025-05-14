package com.iterable.iterableapi;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.iterable.iterableapi.IterableWebView;

/* loaded from: classes5.dex */
class IterableWebViewClient extends WebViewClient {
    IterableWebView.HTMLNotificationCallbacks inAppHTMLNotification;

    IterableWebViewClient(IterableWebView.HTMLNotificationCallbacks hTMLNotificationCallbacks) {
        this.inAppHTMLNotification = hTMLNotificationCallbacks;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        this.inAppHTMLNotification.onUrlClicked(str);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.inAppHTMLNotification.setLoaded(true);
        this.inAppHTMLNotification.runResizeScript();
    }
}
