package com.iterable.iterableapi;

import android.content.Context;
import android.webkit.WebView;

/* loaded from: classes5.dex */
class IterableWebView extends WebView {
    static final String ENCODING = "UTF-8";
    static final String MIME_TYPE = "text/html";

    interface HTMLNotificationCallbacks {
        void onUrlClicked(String str);

        void runResizeScript();

        void setLoaded(boolean z);
    }

    IterableWebView(Context context) {
        super(context);
    }

    void createWithHtml(HTMLNotificationCallbacks hTMLNotificationCallbacks, String str) {
        IterableWebViewClient iterableWebViewClient = new IterableWebViewClient(hTMLNotificationCallbacks);
        IterableWebChromeClient iterableWebChromeClient = new IterableWebChromeClient(hTMLNotificationCallbacks);
        setWebViewClient(iterableWebViewClient);
        setWebChromeClient(iterableWebChromeClient);
        setOverScrollMode(2);
        setBackgroundColor(0);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowFileAccessFromFileURLs(false);
        getSettings().setAllowUniversalAccessFromFileURLs(false);
        getSettings().setAllowContentAccess(false);
        getSettings().setJavaScriptEnabled(false);
        loadDataWithBaseURL("", str, MIME_TYPE, "UTF-8", "");
    }
}
