package com.quantummetric.ui.internal;

import android.view.View;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.iterable.iterableapi.IterableConstants;
import com.quantummetric.ui.QuantumMetric;
import com.quantummetric.ui.SessionCookieOnChangeListener;
import com.quantummetric.ui.internal.df;
import io.castle.android.api.model.Event;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
final class ax {

    /* renamed from: a, reason: collision with root package name */
    static String f80a = null;
    static boolean b = true;
    private static boolean j;
    private static boolean k;
    private static boolean m;
    private static boolean n;
    private static boolean p;
    private static int q;
    private static String s;
    final WeakReference<WebView> e;
    boolean f;
    private boolean u;
    private final df.AnonymousClass40 v;
    static ConcurrentHashMap<Integer, ax> c = new ConcurrentHashMap<>();
    private static final List<String> g = new ArrayList();
    private static final List<String> h = new ArrayList();
    private static boolean i = true;
    private static int l = ModuleDescriptor.MODULE_VERSION;
    private static boolean o = true;
    private static boolean r = true;
    static boolean d = true;
    private static String x = "if (window.location.href !== 'about:blank'){(function() {var doc = window.document.documentElement; function callback() { var head = doc.querySelector('head'); console.log(head.querySelectorAll('*')); if (!doc.querySelector('#qtm-webview-instrumentation')) { var qtm = document.createElement('script'); qtm.type = 'text/javascript'; qtm.defer = true; qtm.src = '%1$s'; qtm.async = 1; qtm.id = 'qtm-webview-instrumentation';  head.appendChild(qtm); console.log('Injected qtm-webview-instrumentation'); } } if (window.document.readyState == 'complete') { callback(); } else {let counter=0;const intervalId=setInterval(()=>{'complete'==window.document.readyState&&(callback(),clearInterval(intervalId)),6==++counter&&clearInterval(intervalId)},1e3);} })();window['QMFrameId']='%2$s';%3$swindow.QMFrameId;}";
    private String t = "";
    private int w = 0;

    /* renamed from: com.quantummetric.instrument.internal.ax$5, reason: invalid class name */
    final class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            WebView webView = (WebView) ax.this.e.get();
            if (webView != null) {
                if (ax.c(webView.getUrl())) {
                    ax.f(ax.this);
                } else {
                    ax.a(ax.this, true);
                }
            }
        }
    }

    /* renamed from: com.quantummetric.instrument.internal.ax$8, reason: invalid class name */
    final class AnonymousClass8 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        boolean f91a;
        final /* synthetic */ WebView b;
        final /* synthetic */ String c;

        AnonymousClass8(WebView webView, String str) {
            this.b = webView;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (int i = 0; i < 13; i++) {
                try {
                    if (this.f91a) {
                        return;
                    }
                    cl.c(new Runnable() { // from class: com.quantummetric.instrument.internal.ax.8.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (AnonymousClass8.this.b.getProgress() < 100 && !AnonymousClass8.this.f91a) {
                                AnonymousClass8.this.b.evaluateJavascript("window['QMFrameId']='" + AnonymousClass8.this.c + "';", null);
                            }
                            if (AnonymousClass8.this.b.getProgress() == 100) {
                                AnonymousClass8.this.f91a = true;
                            }
                        }
                    });
                    Thread.sleep(300L);
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    /* renamed from: com.quantummetric.instrument.internal.ax$9, reason: invalid class name */
    final class AnonymousClass9 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final AtomicBoolean f93a = new AtomicBoolean(false);

        AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            while (ax.this.e != null && ax.this.e.get() != null) {
                try {
                    if (!cd.f161a && QuantumMetric.b != null) {
                        z = false;
                        if (!z || !e.a().e || this.f93a.get()) {
                            break;
                            break;
                        } else {
                            Thread.sleep(ax.l);
                            cl.c(new Runnable() { // from class: com.quantummetric.instrument.internal.ax.9.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    WebView webView = (WebView) ax.this.e.get();
                                    if (AnonymousClass9.this.f93a.get()) {
                                        return;
                                    }
                                    ax axVar = ax.this;
                                    boolean c = ax.c(webView);
                                    AnonymousClass9.this.f93a.set(c);
                                    if (c || ax.this.t.equals(webView.getUrl())) {
                                        return;
                                    }
                                    ax.a(ax.this, true);
                                }
                            });
                        }
                    }
                    z = true;
                    if (!z) {
                        break;
                    }
                    Thread.sleep(ax.l);
                    cl.c(new Runnable() { // from class: com.quantummetric.instrument.internal.ax.9.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            WebView webView = (WebView) ax.this.e.get();
                            if (AnonymousClass9.this.f93a.get()) {
                                return;
                            }
                            ax axVar = ax.this;
                            boolean c = ax.c(webView);
                            AnonymousClass9.this.f93a.set(c);
                            if (c || ax.this.t.equals(webView.getUrl())) {
                                return;
                            }
                            ax.a(ax.this, true);
                        }
                    });
                } catch (Exception unused) {
                }
            }
            ax.h(ax.this);
        }
    }

    interface a {
        void a();
    }

    class b {
        b() {
        }

        @JavascriptInterface
        public final void onBeforeUnload() {
            cl.c(new Runnable() { // from class: com.quantummetric.instrument.internal.ax.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    WebView webView = (WebView) ax.this.e.get();
                    if (webView != null) {
                        ax axVar = ax.this;
                        if (ax.c(webView.getUrl())) {
                            ax.f(ax.this);
                        } else {
                            ax.a(ax.this, true);
                        }
                    }
                }
            });
        }
    }

    class c {
        c() {
        }

        @JavascriptInterface
        public final String sync() {
            try {
                WebView webView = (WebView) ax.this.e.get();
                if (de.b(ai.f) || webView == null) {
                    return "";
                }
                String str = q.f265a;
                return new JSONObject().put("sessionId", ai.f).put(IterableConstants.KEY_USER_ID, ai.g).put("frameId", com.quantummetric.ui.internal.a.b(webView)).put("config", new JSONObject().put("reportURL", str).put("syncURL", q.b)).toString();
            } catch (Exception unused) {
                return "";
            }
        }
    }

    private ax(WebView webView, df.AnonymousClass40 anonymousClass40) {
        this.e = new WeakReference<>(webView);
        this.v = anonymousClass40;
        if (webView != null) {
            if (o) {
                webView.addJavascriptInterface(new b(), "QM");
            }
            if (r) {
                webView.addJavascriptInterface(new c(), "QMSDK");
            }
            if (k) {
                webView.getSettings().setDomStorageEnabled(true);
            }
            if (j) {
                CookieManager.setAcceptFileSchemeCookies(true);
            }
            if (i && !webView.getSettings().getJavaScriptEnabled()) {
                webView.getSettings().setJavaScriptEnabled(true);
            } else {
                if (i) {
                    return;
                }
                webView.getSettings().getJavaScriptEnabled();
            }
        }
    }

    static ax a(View view) {
        if (view != null) {
            return c.get(Integer.valueOf(view.hashCode()));
        }
        return null;
    }

    static ax a(View view, df.AnonymousClass40 anonymousClass40) {
        if (!(view instanceof WebView)) {
            return null;
        }
        ax axVar = view != null ? c.get(Integer.valueOf(view.hashCode())) : null;
        if (axVar != null) {
            return axVar;
        }
        ax axVar2 = new ax((WebView) view, anonymousClass40);
        c.put(Integer.valueOf(view.hashCode()), axVar2);
        return axVar2;
    }

    static void a() {
        if (c != null) {
            cl.c(new Runnable() { // from class: com.quantummetric.instrument.internal.ax.1
                @Override // java.lang.Runnable
                public final void run() {
                    for (Map.Entry<Integer, ax> entry : ax.c.entrySet()) {
                        ax value = entry.getValue();
                        if (value == null || value.e.get() == null) {
                            ax.c.remove(entry.getKey());
                        } else if (ax.d) {
                            WebView webView = value.e.get();
                            if (ax.a(webView)) {
                                webView.evaluateJavascript("if (window.QuantumMetricAPI) window.QuantumMetricAPI.stopSession()", null);
                                value.f = true;
                            }
                        }
                    }
                }
            });
        }
    }

    static /* synthetic */ void a(ax axVar, final WebView webView) {
        webView.evaluateJavascript("typeof window['QMFrameId']", new ValueCallback<String>() { // from class: com.quantummetric.instrument.internal.ax.6
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str) {
                String str2 = str;
                try {
                    if (webView == null || str2 == null || !str2.equals("\"undefined\"")) {
                        return;
                    }
                    if (ax.e()) {
                        ax.c(ax.this, webView);
                    } else {
                        QuantumMetric.addSessionCookieOnChangeListener(new SessionCookieOnChangeListener() { // from class: com.quantummetric.instrument.internal.ax.6.1

                            /* renamed from: a, reason: collision with root package name */
                            private boolean f88a;

                            @Override // com.quantummetric.ui.SessionCookieOnChangeListener
                            public final void onChange(String str3, String str4) {
                                if (this.f88a) {
                                    return;
                                }
                                ax.c(ax.this, webView);
                                this.f88a = true;
                            }
                        });
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    static /* synthetic */ void a(ax axVar, boolean z) {
        if (axVar.e.get() != null) {
            if (!z || axVar.w <= 0) {
                int i2 = axVar.w;
                if (i2 > q) {
                    axVar.w = 0;
                } else {
                    axVar.w = i2 + 1;
                    cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.ax.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            final WebView webView = (WebView) ax.this.e.get();
                            if (webView == null || ax.c(webView)) {
                                return;
                            }
                            if (!ax.a(webView)) {
                                ax.a(ax.this, false);
                            } else if (webView.getProgress() < 100) {
                                ax.a(ax.this, false);
                            } else {
                                webView.evaluateJavascript("window['QMFrameId']", new ValueCallback<String>() { // from class: com.quantummetric.instrument.internal.ax.3.1
                                    @Override // android.webkit.ValueCallback
                                    public final /* synthetic */ void onReceiveValue(String str) {
                                        String str2 = str;
                                        try {
                                            if (!de.b(str2) && !str2.contains("undefined") && !str2.equals("null")) {
                                                de.a("WebView injection " + webView.getUrl());
                                                boolean z2 = !str2.contains(com.quantummetric.ui.internal.a.b(webView));
                                                if (z2) {
                                                    ax.b(ax.this);
                                                }
                                                if (ax.this.f) {
                                                    if (de.b(ai.f)) {
                                                        ax.a(ax.this, false);
                                                        return;
                                                    }
                                                    ax axVar2 = ax.this;
                                                    WebView webView2 = webView;
                                                    if (webView2 != null && ax.d) {
                                                        webView2.evaluateJavascript(ax.b(webView2) + "if(window.QuantumMetricAPI) window.QuantumMetricAPI.startSession()", null);
                                                        axVar2.f = false;
                                                    }
                                                }
                                                if (!z2) {
                                                    a();
                                                }
                                                ax.e(ax.this);
                                                if (!ax.o) {
                                                    ax.b(ax.this, webView);
                                                    return;
                                                } else {
                                                    ax axVar3 = ax.this;
                                                    webView.evaluateJavascript("window.addEventListener(\"beforeunload\", function(event) {QM.onBeforeUnload(); return undefined;})", null);
                                                    return;
                                                }
                                            }
                                            ax.a(ax.this, webView);
                                            ax.a(ax.this, false);
                                        } catch (Throwable unused) {
                                        }
                                    }
                                });
                            }
                        }
                    }, 1000);
                }
            }
        }
    }

    static void a(String str) {
        a("QuantumMetricScrubPatterns", str);
    }

    private static void a(String str, String str2) {
        if (x.contains(str)) {
            return;
        }
        x = ("window['" + str + "']=" + str2 + ";") + x;
    }

    static void a(List<String> list) {
        List<String> list2 = h;
        list2.clear();
        list2.addAll(list);
    }

    static void a(JSONObject jSONObject) {
        if (QuantumMetric.b != null) {
            b = jSONObject.optBoolean("enable_inject", true);
            i = jSONObject.optBoolean("start_js", true);
            j = jSONObject.optBoolean("enable_local_cookies", true);
            k = jSONObject.optBoolean("dom_storage", true);
            l = jSONObject.optInt("inject_interval", ModuleDescriptor.MODULE_VERSION);
            m = jSONObject.optBoolean("set_domain", true);
            n = jSONObject.optBoolean("iframe_comms", false);
            o = jSONObject.optBoolean("new_page_listener", true);
            p = jSONObject.optBoolean("inject_local_storage");
            q = jSONObject.optInt("max_inject_attempts", 20);
            r = jSONObject.optBoolean("set_sdk_sync", true);
            d = jSONObject.optBoolean("restart_enabled", true);
            List<String> a2 = y.a(jSONObject, "webview_injection_urls");
            List<String> list = h;
            list.clear();
            list.addAll(a2);
            List<String> a3 = y.a(jSONObject, "update_cookie");
            List<String> list2 = g;
            list2.clear();
            list2.addAll(a3);
            s = jSONObject.optString("instrumentationURL", "");
            if (!de.b(f80a)) {
                s = f80a;
            }
            if (de.b(s)) {
                String str = QuantumMetric.b.d;
                if (QuantumMetric.b.f) {
                    str = str + "-test";
                }
                s = String.format("https://cdn.quantummetric.com/qscripts/quantum-%s.js", str);
            }
            final boolean optBoolean = jSONObject.optBoolean("clear_cookies");
            final boolean optBoolean2 = jSONObject.optBoolean("clear_session_cookies");
            if (optBoolean || optBoolean2) {
                cl.c(new Runnable() { // from class: com.quantummetric.instrument.internal.ax.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (optBoolean) {
                            CookieManager.getInstance().removeAllCookies(null);
                        }
                        if (optBoolean2) {
                            CookieManager.getInstance().removeSessionCookies(new ValueCallback<Boolean>() { // from class: com.quantummetric.instrument.internal.ax.2.1
                                @Override // android.webkit.ValueCallback
                                public final /* bridge */ /* synthetic */ void onReceiveValue(Boolean bool) {
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(WebView webView) {
        if (webView == null || de.b(webView.getUrl())) {
            return false;
        }
        for (String str : h) {
            if (!de.b(str) && Pattern.compile(str, 2).matcher(webView.getUrl()).find()) {
                return true;
            }
        }
        return false;
    }

    static String b(WebView webView) {
        StringBuilder append;
        String str;
        if (p) {
            append = new StringBuilder("window.sessionStorage.setItem('QuantumMetricSessionID', '").append(ai.f).append("');window.localStorage.setItem('QuantumMetricUserID', '").append(ai.g);
            str = "');";
        } else {
            String str2 = de.b(m ? e(webView.getUrl()) : "") ? "" : "domain=" + e(webView.getUrl()) + ";";
            append = new StringBuilder("document.cookie='QuantumMetricSessionID=").append(ai.f).append(";path=/;").append(str2).append("';document.cookie='QuantumMetricUserID=").append(ai.g).append(";path=/;").append(str2);
            str = "';";
        }
        return append.append(str).toString();
    }

    static void b() {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        for (String str : g) {
            String e = e(str);
            if (!de.b(e)) {
                CookieManager.getInstance().setCookie(str, "QuantumMetricSessionID=" + ai.f + ";path=/;domain=" + e + ";");
            }
        }
        if ((cd.f161a || QuantumMetric.b == null) || QuantumMetric.f9a == null || (optJSONObject = QuantumMetric.f9a.optJSONObject("webview")) == null || (optJSONArray = optJSONObject.optJSONArray("set_cookie")) == null) {
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
            if (optJSONObject2 != null) {
                String optString = optJSONObject2.optString("url");
                String optString2 = optJSONObject2.optString("cookie");
                if (!de.a(optString, optString2)) {
                    CookieManager.getInstance().setCookie(optString, optString2.replace("%SESSION_ID%", ai.f).replace("%USER_ID%", ai.g));
                }
            }
        }
    }

    static /* synthetic */ void b(ax axVar) {
        WebView webView = axVar.e.get();
        if (webView != null) {
            webView.evaluateJavascript(String.format("if (window.QuantumMetricAPI) {window['QMFrameId']='%s';%swindow['QMFrameId'];}", com.quantummetric.ui.internal.a.b(webView), axVar.f ? "" : "window.QuantumMetricAPI.newPage();"), new ValueCallback<String>() { // from class: com.quantummetric.instrument.internal.ax.4
                @Override // android.webkit.ValueCallback
                public final /* bridge */ /* synthetic */ void onReceiveValue(String str) {
                }
            });
        }
    }

    static /* synthetic */ void b(ax axVar, WebView webView) {
        if (o) {
            return;
        }
        axVar.t = webView.getUrl();
        if (axVar.u) {
            return;
        }
        axVar.u = true;
        new Thread(axVar.new AnonymousClass9()).start();
    }

    public static void b(String str) {
        a("QuantumMetricBlockPage", str);
    }

    static void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray(Event.EVENT_TYPE_CUSTOM);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("url");
                            String optString2 = optJSONObject.optString("cookie");
                            if (!de.a(optString, optString2)) {
                                CookieManager.getInstance().setCookie(optString, optString2);
                            }
                        }
                    }
                }
                if (!jSONObject.optBoolean("clear_default") || de.b(q.f265a)) {
                    return;
                }
                d(q.f265a);
                if (q.f265a.equals(q.b)) {
                    return;
                }
                d(q.b);
            } catch (Throwable unused) {
            }
        }
    }

    static /* synthetic */ void c(ax axVar, final WebView webView) {
        String str;
        if (QuantumMetric.b == null || webView == null) {
            str = "";
        } else {
            str = String.format(x, s, com.quantummetric.ui.internal.a.b(webView), b(webView), ai.f);
        }
        if (webView == null || de.b(str)) {
            return;
        }
        webView.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.quantummetric.instrument.internal.ax.7
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str2) {
                try {
                    if (ax.n) {
                        webView.evaluateJavascript(String.format("window.addEventListener(\"QM-PAGE-READY\",function(e){ window.addEventListener(\"message\",function(e){try{if(e.data.indexOf(\"QM_GET_SESSION_ID\")>-1)e.source.window.postMessage(JSON.stringify({QM_SESSION_ID:\"%s\"}),\"*\")}catch(e){console.error(\"Error handling request for session id:\",e)}},!1);  });", ai.f), new ValueCallback<String>() { // from class: com.quantummetric.instrument.internal.ax.7.1
                            @Override // android.webkit.ValueCallback
                            public final /* bridge */ /* synthetic */ void onReceiveValue(String str3) {
                            }
                        });
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    static /* synthetic */ boolean c(WebView webView) {
        if (webView != null) {
            return webView.getTitle() == null && webView.getUrl() == null;
        }
        return true;
    }

    static /* synthetic */ boolean c(String str) {
        if (de.b(str)) {
            return false;
        }
        Iterator<String> it = g.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static void d(String str) {
        CookieManager.getInstance().setCookie(str, "s".concat("=;path=/;expires=Thu, 01 Jan 1970 00:00:01 GMT"));
        CookieManager.getInstance().setCookie(str, "U".concat("=;path=/;expires=Thu, 01 Jan 1970 00:00:01 GMT"));
    }

    static /* synthetic */ int e(ax axVar) {
        axVar.w = 0;
        return 0;
    }

    private static String e(String str) {
        if (de.b(str)) {
            return "";
        }
        String[] split = str.split("/");
        if (split.length <= 2) {
            return "";
        }
        if (split[2].split(Pattern.quote(".")).length <= 2) {
            return split[2];
        }
        String str2 = split[2];
        return str2.substring(str2.indexOf(46) + 1);
    }

    static /* synthetic */ boolean e() {
        return !de.b(ai.f);
    }

    static /* synthetic */ void f(ax axVar) {
        WebView webView = axVar.e.get();
        if (webView != null) {
            new Thread(axVar.new AnonymousClass8(webView, com.quantummetric.ui.internal.a.d(webView.hashCode()))).start();
        }
    }

    static /* synthetic */ boolean h(ax axVar) {
        axVar.u = false;
        return false;
    }
}
