package com.iterable.iterableapi;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.iterable.iterableapi.IterableWebView;

/* loaded from: classes5.dex */
public class IterableWebChromeClient extends WebChromeClient {
    IterableWebView.HTMLNotificationCallbacks inAppHTMLNotification;

    IterableWebChromeClient(IterableWebView.HTMLNotificationCallbacks hTMLNotificationCallbacks) {
        this.inAppHTMLNotification = hTMLNotificationCallbacks;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        this.inAppHTMLNotification.runResizeScript();
    }
}
