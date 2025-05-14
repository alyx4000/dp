package com.quantummetric.ui.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.quantummetric.ui.internal.bk;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

/* loaded from: classes5.dex */
final class aw {

    /* renamed from: a, reason: collision with root package name */
    WebView f72a;
    final Map<h<String>, String> b = new LinkedHashMap();
    boolean c;

    /* renamed from: com.quantummetric.instrument.internal.aw$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private /* synthetic */ String f74a;
        private /* synthetic */ h b;

        AnonymousClass2(String str, h hVar) {
            this.f74a = str;
            this.b = hVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (aw.this.f72a == null && de.f() != null) {
                final aw awVar = aw.this;
                Context f = de.f();
                if (awVar.f72a == null) {
                    awVar.f72a = new WebView(f);
                    awVar.f72a.addJavascriptInterface(new a((byte) 0), "QM");
                    awVar.f72a.setWillNotDraw(true);
                    awVar.f72a.getSettings().setJavaScriptEnabled(true);
                    awVar.f72a.setWebViewClient(new WebViewClient() { // from class: com.quantummetric.instrument.internal.aw.4
                        @Override // android.webkit.WebViewClient
                        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                            super.onPageStarted(webView, str, bitmap);
                            aw.this.c = true;
                            try {
                                StringBuilder sb = new StringBuilder();
                                sb.append("function init(){");
                                for (b bVar : b.values()) {
                                    sb.append(bVar.name()).append("='';");
                                }
                                sb.append("}; init();");
                                sb.append("function sendEvent(a, b, c = 0){QM.sendEvent(a, b, c)};");
                                sb.append("function sendMultidimensionalEvent(a, b, c, d = 0){QM.sendMultidimensionalEvent(a, b, c, d)};");
                                sb.append("class Event{constructor(t){let s=JSON.parse(t);this.i=s.i,this.v=s.v,this.f=s.f,this.t=s.t}}");
                                webView.evaluateJavascript(sb.toString(), null);
                                aw awVar2 = aw.this;
                                for (Map.Entry<h<String>, String> entry : awVar2.b.entrySet()) {
                                    awVar2.a(entry.getValue(), entry.getKey());
                                }
                                aw.this.b.clear();
                            } catch (Exception unused) {
                            }
                        }
                    });
                    awVar.f72a.loadUrl("https://cdn.quantummetric.com/helpers/blank");
                }
            }
            if (aw.this.f72a == null) {
                return;
            }
            if (aw.this.c) {
                aw.this.a(this.f74a, this.b);
            } else {
                aw.this.b.put(this.b, this.f74a);
            }
        }
    }

    static class a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0010 A[Catch: Exception -> 0x0028, TryCatch #0 {Exception -> 0x0028, blocks: (B:2:0x0000, B:4:0x0006, B:9:0x0010, B:11:0x001c, B:14:0x0025), top: B:1:0x0000 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(int r3, java.lang.String r4, java.lang.String r5, int r6) {
            /*
                boolean r0 = com.quantummetric.ui.internal.cd.f161a     // Catch: java.lang.Exception -> L28
                r1 = 0
                r2 = 1
                if (r0 != 0) goto Ld
                com.quantummetric.instrument.internal.bu r0 = com.quantummetric.ui.QuantumMetric.b     // Catch: java.lang.Exception -> L28
                if (r0 != 0) goto Lb
                goto Ld
            Lb:
                r0 = r1
                goto Le
            Ld:
                r0 = r2
            Le:
                if (r0 != 0) goto L28
                com.quantummetric.instrument.internal.j[] r0 = new com.quantummetric.ui.internal.j[r2]     // Catch: java.lang.Exception -> L28
                com.quantummetric.instrument.internal.j r2 = com.quantummetric.ui.internal.j.c     // Catch: java.lang.Exception -> L28
                r0[r1] = r2     // Catch: java.lang.Exception -> L28
                com.quantummetric.instrument.internal.j[] r6 = com.quantummetric.ui.internal.j.b(r6, r0)     // Catch: java.lang.Exception -> L28
                if (r5 == 0) goto L25
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L28
                r0.<init>(r5)     // Catch: java.lang.Exception -> L28
                com.quantummetric.ui.QuantumMetric.a(r3, r4, r0, r6)     // Catch: java.lang.Exception -> L28
                return
            L25:
                com.quantummetric.ui.QuantumMetric.a(r3, r4, r6)     // Catch: java.lang.Exception -> L28
            L28:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.instrument.internal.aw.a.a(int, java.lang.String, java.lang.String, int):void");
        }

        @JavascriptInterface
        public final void sendEvent(int i, String str, int i2) {
            a(i, str, null, i2);
        }

        @JavascriptInterface
        public final void sendMultidimensionalEvent(int i, String str, String str2, int i2) {
            a(i, str, str2, i2);
        }
    }

    enum b {
        requestBody,
        responseBody,
        requestType,
        url,
        responseCode,
        responseTime,
        requestHeaders,
        responseHeaders,
        currentActivity,
        currentPageName,
        sessionID,
        userID
    }

    aw() {
    }

    private static String a(b bVar) {
        String c;
        switch (bVar) {
            case currentActivity:
                return e.a().c();
            case currentPageName:
                String[] strArr = new String[1];
                e a2 = e.a();
                strArr[0] = a2.P == null ? "" : a2.P;
                if (de.a(strArr)) {
                    c = e.a().c();
                } else {
                    e a3 = e.a();
                    if (a3.P == null) {
                        return "";
                    }
                    c = a3.P;
                }
                return c;
            case sessionID:
                return ai.f;
            case userID:
                return ai.g;
            default:
                return "";
        }
    }

    private static String a(b bVar, bk.b bVar2) {
        Object obj;
        Map<String, ?> map;
        switch (AnonymousClass6.f78a[bVar.ordinal()]) {
            case 1:
                obj = bVar2.f;
                return a((String) obj);
            case 2:
                obj = bVar2.g;
                return a((String) obj);
            case 3:
                return bVar2.f114a;
            case 4:
                return bVar2.b;
            case 5:
                return Integer.toString(bVar2.e);
            case 6:
                return Long.toString(bVar2.c);
            case 7:
                map = bVar2.i;
                break;
            case 8:
                map = bVar2.j;
                break;
            default:
                return a(bVar);
        }
        return de.a(map).toString();
    }

    private static String a(String str) {
        return str.replace("\\", "\\\\").replace("\t", "\\t").replace("\n", "\\n").replace(StringUtils.CR, "\\r").replace("</", "<\\/").replace("'", "\\'");
    }

    static String a(String str, JSONObject jSONObject) {
        ar arVar = new ar();
        a(arVar, str, null, Boolean.FALSE);
        arVar.a((ar) "lastEvent=new Event('").a((ar) jSONObject.toString()).a((ar) "');").a((ar) str).a((ar) ";lastEvent=new Event('{}');");
        return arVar.toString();
    }

    static void a(ar arVar, String str, bk.b bVar, Boolean bool) {
        b[] values = b.values();
        int length = values.length;
        for (int i = 0; i < length; i++) {
            b bVar2 = values[i];
            if (str.contains(bVar2.name())) {
                boolean z = (bVar2 == b.requestHeaders || bVar2 == b.responseHeaders || bVar2 == b.responseCode || bVar2 == b.responseTime) ? false : true;
                String a2 = bool.booleanValue() ? a(bVar2, bVar) : a(bVar2);
                ar a3 = arVar.a((ar) bVar2).a((ar) "=");
                if (z) {
                    a3.a((ar) "'");
                }
                ar a4 = a3.a((ar) a2);
                if (z) {
                    a4.a((ar) "'");
                }
                a4.a((ar) ";");
            }
        }
    }

    final void a(String str, final h<String> hVar) {
        if (cl.a()) {
            this.f72a.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.quantummetric.instrument.internal.aw.3
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str2) {
                    String str3 = str2;
                    try {
                        if (!de.b(str3) && str3.length() > 1 && str3.startsWith("\"") && str3.endsWith("\"")) {
                            str3 = str3.substring(1, str3.length() - 1);
                        }
                        hVar.a(str3);
                    } catch (Exception unused) {
                    }
                }
            });
            this.f72a.evaluateJavascript("init()", null);
        }
    }
}
