package com.quantummetric.ui.internal;

import android.app.Application;
import android.content.Context;
import android.provider.Settings;
import androidx.webkit.ProxyConfig;
import com.facebook.common.util.UriUtil;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.quantummetric.ui.BuildConfig;
import com.quantummetric.ui.EventType;
import com.quantummetric.ui.QuantumMetric;
import com.quantummetric.ui.SessionCookieOnChangeListener;
import com.quantummetric.ui.internal.ao;
import com.quantummetric.ui.internal.bm.AnonymousClass4;
import com.quantummetric.ui.internal.bu;
import com.quantummetric.ui.internal.cl;
import io.sentry.protocol.SentryStackFrame;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import org.json.JSONObject;

/* loaded from: classes5.dex */
final class ai {
    static String f = "";
    static String g = "";
    a c;
    b d;
    long j;
    boolean k;
    int n;
    private bu.AnonymousClass1 o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean t;

    /* renamed from: a, reason: collision with root package name */
    final List<bo> f38a = new ArrayList();
    final ArrayList<SessionCookieOnChangeListener> b = new ArrayList<>();
    final bo e = new bo("cache", 0, new bg(), new bf());
    long h = 0;
    int i = 3;
    boolean l = false;
    private float s = 1.0f;
    volatile Set<Integer> m = new HashSet();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        final ConcurrentHashMap<Integer, C0030a> f45a = new ConcurrentHashMap<>();
        boolean b;

        /* renamed from: com.quantummetric.instrument.internal.ai$a$a, reason: collision with other inner class name */
        static class C0030a {

            /* renamed from: a, reason: collision with root package name */
            String f46a;
            String b;

            C0030a(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.f46a = jSONObject.optString("regex");
                    this.b = jSONObject.optString("replacement");
                }
            }
        }

        a(y yVar) {
            this.b = false;
            if (yVar != null) {
                try {
                    JSONObject optJSONObject = yVar.optJSONObject("event_sanitizers");
                    if (optJSONObject != null) {
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            C0030a c0030a = new C0030a(optJSONObject.optJSONObject(next));
                            if (!de.b(c0030a.f46a)) {
                                try {
                                    this.f45a.put(Integer.valueOf(Integer.parseInt(next)), c0030a);
                                    this.b = true;
                                } catch (NumberFormatException unused) {
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        }

        final String a(int i, String str) {
            try {
                C0030a c0030a = this.f45a.get(Integer.valueOf(i));
                return (c0030a == null || str == null) ? str : str.replaceAll(c0030a.f46a, c0030a.b);
            } catch (Throwable unused) {
                return str;
            }
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        final Map<Integer, String> f47a = new HashMap();
        String b;

        b(y yVar) {
            JSONObject optJSONObject = yVar.optJSONObject("js_listeners_native");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = optJSONObject.optString(next);
                    if (!de.b(optString)) {
                        if (de.e(next)) {
                            this.f47a.put(Integer.valueOf(Integer.parseInt(next)), optString);
                        } else if (ProxyConfig.MATCH_ALL_SCHEMES.equals(next)) {
                            this.b = optString;
                        }
                    }
                }
            }
        }
    }

    ai(final bu.AnonymousClass1 anonymousClass1) {
        new Thread(new cl.a(new Runnable() { // from class: com.quantummetric.instrument.internal.ai.1
            @Override // java.lang.Runnable
            public final void run() {
                while (!ai.this.r) {
                    if (QuantumMetric.b == null && ai.this.f38a.size() == 0) {
                        return;
                    }
                    if (QuantumMetric.f9a != null && !QuantumMetric.f9a.l) {
                        if (ai.this.o == null) {
                            ai.this.o = anonymousClass1;
                            anonymousClass1.a();
                            ai.this.d();
                        }
                        try {
                            synchronized (ai.this.f38a) {
                                Iterator it = ai.this.f38a.iterator();
                                while (it.hasNext()) {
                                    ai.this.a((bo) it.next());
                                }
                            }
                        } catch (Exception unused) {
                            QuantumMetric.a(av.EVENT_ENGINE_MAIN_LOOP_EXCEPTION);
                        }
                    }
                    try {
                        Thread.sleep(ai.this.i * 1000);
                    } catch (InterruptedException unused2) {
                    }
                }
            }
        })).start();
    }

    static /* synthetic */ void a(ai aiVar, boolean z) {
        aiVar.a();
        aiVar.k = true;
        aiVar.j = System.currentTimeMillis();
        ao a2 = ao.a();
        if (a2.b != null) {
            a2.b.b = true;
        }
        aiVar.r = true;
        if (!z && !de.b(g) && QuantumMetric.f9a != null) {
            JSONObject optJSONObject = QuantumMetric.f9a.optJSONObject(ViewProps.START);
            if (optJSONObject != null ? optJSONObject.optBoolean("session_expiration") : false) {
                b("", g);
            }
        }
        f = "";
        g = "";
    }

    static void a(bf bfVar, Cipher cipher) {
        if (!ab.a() || cipher == null || !bfVar.containsKey("cache_enc") || bfVar.containsKey("qenc")) {
            return;
        }
        Object obj = bfVar.get("v");
        if (obj instanceof String) {
            String str = (String) obj;
            bfVar.put("qenc", ab.a(str, cipher));
            bfVar.put("v", ab.b(str.toLowerCase()));
        }
    }

    private void a(Throwable th) {
        try {
            bo boVar = this.f38a.size() > 0 ? this.f38a.get(0) : null;
            synchronized (this.f38a) {
                this.f38a.clear();
                if (boVar != null) {
                    bg bgVar = boVar.j;
                    boVar.a();
                    if (bgVar.size() > 0 && bgVar.get(0).get("t") == "s") {
                        boVar.j.add(bgVar.get(0));
                    }
                    this.f38a.add(boVar);
                    QuantumMetric.a(-34, "Stop capture to prevent OutOfMemoryException", new j[0]);
                    QuantumMetric.a(-20505, th + " " + Arrays.asList(th.getStackTrace()), new j[0]);
                }
            }
        } catch (Exception unused) {
        }
        QuantumMetric.a("Received OutOfMemory error. Stopping Quantum Metric SDK");
    }

    static void b() {
        f = "";
    }

    static /* synthetic */ void b(ai aiVar, bo boVar) {
        if (boVar != null) {
            aiVar.e.f125a = boVar.f125a;
            aiVar.e.b = boVar.b;
            aiVar.e.e = boVar.e;
            aiVar.e.c = boVar.c;
            aiVar.e.d = boVar.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(bo boVar) {
        if (boVar != null) {
            try {
                if (de.b(boVar.b)) {
                    return;
                }
                if (this.k) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.j > this.n) {
                        boVar.a();
                        return;
                    }
                    this.j = currentTimeMillis;
                }
                if (boVar.k.size() > 0) {
                    q.a(boVar, (x) boVar.k, false, true, (o<String>) null);
                    boVar.k.clear();
                }
                if (boVar.j.size() > 0) {
                    boolean z = QuantumMetric.f9a.h;
                    Iterator<bf> it = boVar.j.iterator();
                    while (it.hasNext()) {
                        bf next = it.next();
                        if (z && next.containsKey("t") && "xhr".equals(next.get("t"))) {
                            Cipher cipher = boVar.l;
                            if (next.containsKey("req")) {
                                next.put("req_enc", ab.a((String) next.get("req"), cipher));
                                next.remove("req");
                            }
                            if (next.containsKey("reqHeaders")) {
                                next.put("reqHeaders_enc", ab.a((String) next.get("reqHeaders"), cipher));
                                next.remove("reqHeaders");
                            }
                            if (next.containsKey(UriUtil.LOCAL_RESOURCE_SCHEME)) {
                                next.put("res_enc", ab.a((String) next.get(UriUtil.LOCAL_RESOURCE_SCHEME), cipher));
                                next.remove(UriUtil.LOCAL_RESOURCE_SCHEME);
                            }
                            if (next.containsKey("resHeaders")) {
                                next.put("resHeaders_enc", ab.a((String) next.get("resHeaders"), cipher));
                                next.remove("resHeaders");
                            }
                        }
                        if (next.f108a) {
                            next.put("t", "oe");
                        }
                    }
                    q.a(boVar, (x) boVar.j, false, false, QuantumMetric.b != null ? al.a().i : null);
                    boVar.j.clear();
                }
            } catch (Exception unused) {
            } catch (OutOfMemoryError e) {
                a(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, String str2) {
        bu k = de.k();
        if (k != null) {
            String e = aa.e(k.d);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("s", str).put("u", str2).put("t", System.currentTimeMillis());
                de.c(e, jSONObject.toString());
            } catch (Throwable unused) {
            }
        }
    }

    static void c() {
        g = "";
    }

    private bo e() {
        if (this.f38a.size() <= 0) {
            return this.e;
        }
        return this.f38a.get(r0.size() - 1);
    }

    static /* synthetic */ boolean e(ai aiVar) {
        aiVar.q = false;
        return false;
    }

    static /* synthetic */ boolean g(ai aiVar) {
        aiVar.t = true;
        return true;
    }

    static /* synthetic */ void h(ai aiVar) {
        cl.c(new Runnable() { // from class: com.quantummetric.instrument.internal.ai.4
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = ai.this.b.iterator();
                while (it.hasNext()) {
                    SessionCookieOnChangeListener sessionCookieOnChangeListener = (SessionCookieOnChangeListener) it.next();
                    if (sessionCookieOnChangeListener != null) {
                        try {
                            sessionCookieOnChangeListener.onComplete(ai.f, ai.g);
                        } catch (Exception unused) {
                        }
                    }
                    it.remove();
                }
            }
        });
    }

    final void a() {
        ArrayList arrayList;
        try {
            if (de.b(f) && this.q) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            synchronized (this.f38a) {
                arrayList = new ArrayList(this.f38a);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                bo boVar = (bo) it.next();
                a(boVar);
                String str = boVar.b;
                arrayList2.add(boVar);
            }
            synchronized (this.f38a) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    this.f38a.remove((bo) it2.next());
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0149 A[Catch: all -> 0x0151, TRY_LEAVE, TryCatch #0 {all -> 0x0151, blocks: (B:73:0x00b1, B:75:0x00b9, B:77:0x00cb, B:79:0x00d1, B:81:0x00df, B:82:0x00e6, B:84:0x00f7, B:89:0x0101, B:91:0x0109, B:93:0x0111, B:95:0x0117, B:97:0x0127, B:98:0x012e, B:100:0x013f, B:105:0x0149), top: B:72:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0081 A[Catch: all -> 0x0227, TryCatch #2 {, blocks: (B:10:0x0018, B:12:0x0022, B:14:0x0057, B:15:0x0059, B:17:0x006b, B:22:0x0079, B:23:0x00ad, B:25:0x0151, B:27:0x0155, B:29:0x0159, B:33:0x016a, B:35:0x0172, B:37:0x0178, B:39:0x0180, B:41:0x0188, B:43:0x0190, B:47:0x01bc, B:49:0x01c2, B:50:0x01d6, B:52:0x01da, B:54:0x01e1, B:56:0x01e8, B:57:0x01ed, B:59:0x01f3, B:65:0x01fe, B:66:0x0205, B:68:0x0211, B:69:0x021d, B:61:0x01f8, B:109:0x0081, B:111:0x0089, B:114:0x0093, B:116:0x009b, B:118:0x00a1, B:120:0x0225), top: B:9:0x0018, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079 A[Catch: all -> 0x0227, TryCatch #2 {, blocks: (B:10:0x0018, B:12:0x0022, B:14:0x0057, B:15:0x0059, B:17:0x006b, B:22:0x0079, B:23:0x00ad, B:25:0x0151, B:27:0x0155, B:29:0x0159, B:33:0x016a, B:35:0x0172, B:37:0x0178, B:39:0x0180, B:41:0x0188, B:43:0x0190, B:47:0x01bc, B:49:0x01c2, B:50:0x01d6, B:52:0x01da, B:54:0x01e1, B:56:0x01e8, B:57:0x01ed, B:59:0x01f3, B:65:0x01fe, B:66:0x0205, B:68:0x0211, B:69:0x021d, B:61:0x01f8, B:109:0x0081, B:111:0x0089, B:114:0x0093, B:116:0x009b, B:118:0x00a1, B:120:0x0225), top: B:9:0x0018, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0155 A[Catch: all -> 0x0227, TryCatch #2 {, blocks: (B:10:0x0018, B:12:0x0022, B:14:0x0057, B:15:0x0059, B:17:0x006b, B:22:0x0079, B:23:0x00ad, B:25:0x0151, B:27:0x0155, B:29:0x0159, B:33:0x016a, B:35:0x0172, B:37:0x0178, B:39:0x0180, B:41:0x0188, B:43:0x0190, B:47:0x01bc, B:49:0x01c2, B:50:0x01d6, B:52:0x01da, B:54:0x01e1, B:56:0x01e8, B:57:0x01ed, B:59:0x01f3, B:65:0x01fe, B:66:0x0205, B:68:0x0211, B:69:0x021d, B:61:0x01f8, B:109:0x0081, B:111:0x0089, B:114:0x0093, B:116:0x009b, B:118:0x00a1, B:120:0x0225), top: B:9:0x0018, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0178 A[Catch: all -> 0x0227, TryCatch #2 {, blocks: (B:10:0x0018, B:12:0x0022, B:14:0x0057, B:15:0x0059, B:17:0x006b, B:22:0x0079, B:23:0x00ad, B:25:0x0151, B:27:0x0155, B:29:0x0159, B:33:0x016a, B:35:0x0172, B:37:0x0178, B:39:0x0180, B:41:0x0188, B:43:0x0190, B:47:0x01bc, B:49:0x01c2, B:50:0x01d6, B:52:0x01da, B:54:0x01e1, B:56:0x01e8, B:57:0x01ed, B:59:0x01f3, B:65:0x01fe, B:66:0x0205, B:68:0x0211, B:69:0x021d, B:61:0x01f8, B:109:0x0081, B:111:0x0089, B:114:0x0093, B:116:0x009b, B:118:0x00a1, B:120:0x0225), top: B:9:0x0018, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e8 A[Catch: all -> 0x0227, TryCatch #2 {, blocks: (B:10:0x0018, B:12:0x0022, B:14:0x0057, B:15:0x0059, B:17:0x006b, B:22:0x0079, B:23:0x00ad, B:25:0x0151, B:27:0x0155, B:29:0x0159, B:33:0x016a, B:35:0x0172, B:37:0x0178, B:39:0x0180, B:41:0x0188, B:43:0x0190, B:47:0x01bc, B:49:0x01c2, B:50:0x01d6, B:52:0x01da, B:54:0x01e1, B:56:0x01e8, B:57:0x01ed, B:59:0x01f3, B:65:0x01fe, B:66:0x0205, B:68:0x0211, B:69:0x021d, B:61:0x01f8, B:109:0x0081, B:111:0x0089, B:114:0x0093, B:116:0x009b, B:118:0x00a1, B:120:0x0225), top: B:9:0x0018, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01f3 A[Catch: all -> 0x0227, TryCatch #2 {, blocks: (B:10:0x0018, B:12:0x0022, B:14:0x0057, B:15:0x0059, B:17:0x006b, B:22:0x0079, B:23:0x00ad, B:25:0x0151, B:27:0x0155, B:29:0x0159, B:33:0x016a, B:35:0x0172, B:37:0x0178, B:39:0x0180, B:41:0x0188, B:43:0x0190, B:47:0x01bc, B:49:0x01c2, B:50:0x01d6, B:52:0x01da, B:54:0x01e1, B:56:0x01e8, B:57:0x01ed, B:59:0x01f3, B:65:0x01fe, B:66:0x0205, B:68:0x0211, B:69:0x021d, B:61:0x01f8, B:109:0x0081, B:111:0x0089, B:114:0x0093, B:116:0x009b, B:118:0x00a1, B:120:0x0225), top: B:9:0x0018, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01fe A[Catch: all -> 0x0227, TryCatch #2 {, blocks: (B:10:0x0018, B:12:0x0022, B:14:0x0057, B:15:0x0059, B:17:0x006b, B:22:0x0079, B:23:0x00ad, B:25:0x0151, B:27:0x0155, B:29:0x0159, B:33:0x016a, B:35:0x0172, B:37:0x0178, B:39:0x0180, B:41:0x0188, B:43:0x0190, B:47:0x01bc, B:49:0x01c2, B:50:0x01d6, B:52:0x01da, B:54:0x01e1, B:56:0x01e8, B:57:0x01ed, B:59:0x01f3, B:65:0x01fe, B:66:0x0205, B:68:0x0211, B:69:0x021d, B:61:0x01f8, B:109:0x0081, B:111:0x0089, B:114:0x0093, B:116:0x009b, B:118:0x00a1, B:120:0x0225), top: B:9:0x0018, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0211 A[Catch: all -> 0x0227, TryCatch #2 {, blocks: (B:10:0x0018, B:12:0x0022, B:14:0x0057, B:15:0x0059, B:17:0x006b, B:22:0x0079, B:23:0x00ad, B:25:0x0151, B:27:0x0155, B:29:0x0159, B:33:0x016a, B:35:0x0172, B:37:0x0178, B:39:0x0180, B:41:0x0188, B:43:0x0190, B:47:0x01bc, B:49:0x01c2, B:50:0x01d6, B:52:0x01da, B:54:0x01e1, B:56:0x01e8, B:57:0x01ed, B:59:0x01f3, B:65:0x01fe, B:66:0x0205, B:68:0x0211, B:69:0x021d, B:61:0x01f8, B:109:0x0081, B:111:0x0089, B:114:0x0093, B:116:0x009b, B:118:0x00a1, B:120:0x0225), top: B:9:0x0018, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0101 A[Catch: all -> 0x0151, TryCatch #0 {all -> 0x0151, blocks: (B:73:0x00b1, B:75:0x00b9, B:77:0x00cb, B:79:0x00d1, B:81:0x00df, B:82:0x00e6, B:84:0x00f7, B:89:0x0101, B:91:0x0109, B:93:0x0111, B:95:0x0117, B:97:0x0127, B:98:0x012e, B:100:0x013f, B:105:0x0149), top: B:72:0x00b1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void a(int r17, java.lang.String r18, org.json.JSONObject r19, com.quantummetric.ui.internal.j... r20) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.ai.a(int, java.lang.String, org.json.JSONObject, com.quantummetric.instrument.internal.j[]):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006b, code lost:
    
        if (r2 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
    
        r1 = r1.j;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void a(com.quantummetric.ui.internal.bf r10) {
        /*
            r9 = this;
            int r0 = r10.hashCode()     // Catch: java.lang.Exception -> L75
            int r1 = r9.p     // Catch: java.lang.Exception -> L75
            if (r1 == 0) goto L19
            if (r0 != r1) goto L19
            java.lang.String r1 = "S"
            java.lang.String r2 = "t"
            java.lang.Object r2 = r10.get(r2)     // Catch: java.lang.Exception -> L75
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L75
            if (r1 != 0) goto L19
            return
        L19:
            r9.p = r0     // Catch: java.lang.Exception -> L75
            java.util.List<com.quantummetric.instrument.internal.bo> r0 = r9.f38a     // Catch: java.lang.Exception -> L75
            monitor-enter(r0)     // Catch: java.lang.Exception -> L75
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L72
            java.lang.String r3 = "d"
            long r4 = r9.h     // Catch: java.lang.Throwable -> L72
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L2e
            long r6 = r1 - r4
        L2e:
            r9.h = r1     // Catch: java.lang.Throwable -> L72
            java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> L72
            r10.put(r3, r1)     // Catch: java.lang.Throwable -> L72
            java.util.List<com.quantummetric.instrument.internal.bo> r1 = r9.f38a     // Catch: java.lang.Throwable -> L72
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L72
            r2 = 1
            if (r1 <= 0) goto L53
            java.util.List<com.quantummetric.instrument.internal.bo> r1 = r9.f38a     // Catch: java.lang.Throwable -> L72
            int r3 = r1.size()     // Catch: java.lang.Throwable -> L72
            int r3 = r3 - r2
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L72
            com.quantummetric.instrument.internal.bo r1 = (com.quantummetric.ui.internal.bo) r1     // Catch: java.lang.Throwable -> L72
            com.quantummetric.instrument.internal.bg r1 = r1.j     // Catch: java.lang.Throwable -> L72
        L4f:
            r1.add(r10)     // Catch: java.lang.Throwable -> L72
            goto L70
        L53:
            com.quantummetric.instrument.internal.bo r1 = r9.e()     // Catch: java.lang.Throwable -> L72
            java.lang.String r3 = "<HEAD"
            boolean r3 = r10.containsValue(r3)     // Catch: java.lang.Throwable -> L72
            if (r3 != 0) goto L69
            java.lang.String r3 = "xhr"
            boolean r3 = r10.containsValue(r3)     // Catch: java.lang.Throwable -> L72
            if (r3 == 0) goto L68
            goto L69
        L68:
            r2 = 0
        L69:
            if (r1 == 0) goto L70
            if (r2 == 0) goto L70
            com.quantummetric.instrument.internal.bg r1 = r1.j     // Catch: java.lang.Throwable -> L72
            goto L4f
        L70:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L72
            return
        L72:
            r10 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Exception -> L75
            throw r10     // Catch: java.lang.Exception -> L75
        L75:
            com.quantummetric.instrument.internal.av r10 = com.quantummetric.ui.internal.av.EVENT_ENGINE_LOG_EVENT_EXCEPTION
            com.quantummetric.ui.QuantumMetric.a(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.ai.a(com.quantummetric.instrument.internal.bf):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(final bo boVar) {
        if (boVar != null) {
            try {
                if (boVar.j.size() > 0 || boVar.k.size() > 0) {
                    if (de.b(f) && this.q) {
                        return;
                    }
                    if (!de.b(boVar.b)) {
                        b(boVar);
                        return;
                    }
                    if (boVar != null) {
                        bg bgVar = boVar.j;
                        if (bgVar.size() <= 0 || bgVar.get(0).get("t") != "s") {
                            return;
                        }
                        if (aa.A) {
                            this.q = false;
                            boVar.b = "hitId";
                        } else {
                            this.q = true;
                        }
                        String d = de.d();
                        if (!de.b(d)) {
                            QuantumMetric.a(-9999, d, EventType.g);
                        }
                        boVar.c = f;
                        boVar.d = g;
                        bg bgVar2 = new bg();
                        bgVar2.add(bgVar.remove(0));
                        final String str = f;
                        final String str2 = g;
                        q.a(boVar, (x) bgVar2, true, false, new o<String>() { // from class: com.quantummetric.instrument.internal.ai.3
                            @Override // com.quantummetric.ui.internal.o
                            public final /* synthetic */ void a(String str3) {
                                Context f2;
                                String str4 = str3;
                                try {
                                    ai.e(ai.this);
                                    String[] split = str4.split("/");
                                    QuantumMetric.a(-9997, SentryStackFrame.JsonKeys.NATIVE, EventType.f);
                                    QuantumMetric.a(-9998, BuildConfig.VERSION_NAME, EventType.e);
                                    if (!aa.A && split.length == 3) {
                                        bo boVar2 = boVar;
                                        boVar2.c = split[0];
                                        boVar2.d = split[1];
                                        boVar2.b = split[2];
                                        ai.b(ai.this, boVar);
                                        if (!str2.equals(split[1])) {
                                            ai.g = split[1];
                                        }
                                        if (!ai.this.t || !str.equals(split[0])) {
                                            ai.f = split[0];
                                            ai.b(ai.f, ai.g);
                                            if (!ai.this.t) {
                                                ai.g(ai.this);
                                                if (de.j()) {
                                                    if (bm.f117a == null) {
                                                        bm.f117a = new bm();
                                                    }
                                                    final bm bmVar = bm.f117a;
                                                    final String str5 = ai.g;
                                                    if (!bmVar.f && (f2 = de.f()) != null && QuantumMetric.b != null) {
                                                        cl.b(bmVar.new AnonymousClass4(f2));
                                                    }
                                                    cl.a(new Runnable() { // from class: com.quantummetric.instrument.internal.bm.2
                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            if (QuantumMetric.b != null) {
                                                                try {
                                                                    File[] b2 = bm.b();
                                                                    if (b2 != null) {
                                                                        ArrayList<LinkedHashMap> arrayList = new ArrayList();
                                                                        long j = 0;
                                                                        LinkedHashMap linkedHashMap = null;
                                                                        for (File file : b2) {
                                                                            String name = file.getName();
                                                                            String str6 = name.split("-")[0];
                                                                            if (!name.contains("-")) {
                                                                                long parseLong = Long.parseLong(name);
                                                                                if (parseLong - j > 1800000) {
                                                                                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                                                                    arrayList.add(linkedHashMap2);
                                                                                    linkedHashMap = linkedHashMap2;
                                                                                }
                                                                                j = parseLong;
                                                                            }
                                                                            if (linkedHashMap != null) {
                                                                                List list = (List) linkedHashMap.get(str6);
                                                                                if (list != null) {
                                                                                    list.add(file);
                                                                                } else {
                                                                                    ArrayList arrayList2 = new ArrayList();
                                                                                    arrayList2.add(file);
                                                                                    linkedHashMap.put(str6, arrayList2);
                                                                                }
                                                                            }
                                                                        }
                                                                        cl.a(new Runnable() { // from class: com.quantummetric.instrument.internal.bm.2.1
                                                                            @Override // java.lang.Runnable
                                                                            public final void run() {
                                                                                bm.this.a();
                                                                            }
                                                                        }, ModuleDescriptor.MODULE_VERSION);
                                                                        for (final LinkedHashMap linkedHashMap3 : arrayList) {
                                                                            Iterator it = linkedHashMap3.values().iterator();
                                                                            while (true) {
                                                                                if (!it.hasNext()) {
                                                                                    break;
                                                                                }
                                                                                File a2 = bm.a((List) it.next());
                                                                                if (a2 != null) {
                                                                                    final bm bmVar2 = bm.this;
                                                                                    final String str7 = a2.getName().split("-")[0];
                                                                                    bm.a(a2, (String) null, str5, new o<String>() { // from class: com.quantummetric.instrument.internal.bm.3
                                                                                        @Override // com.quantummetric.ui.internal.o
                                                                                        public final /* synthetic */ void a(String str8) {
                                                                                            try {
                                                                                                String[] split2 = str8.split("/");
                                                                                                if (split2.length == 3) {
                                                                                                    final String str9 = split2[0];
                                                                                                    final String str10 = split2[1];
                                                                                                    bm.a((List) linkedHashMap3.remove(str7), str9, str10, split2[2]);
                                                                                                    for (final List list2 : linkedHashMap3.values()) {
                                                                                                        File a3 = bm.a(list2);
                                                                                                        if (a3 != null) {
                                                                                                            bm.a(a3, str9, str10, new o<String>() { // from class: com.quantummetric.instrument.internal.bm.3.1
                                                                                                                @Override // com.quantummetric.ui.internal.o
                                                                                                                public final /* synthetic */ void a(String str11) {
                                                                                                                    try {
                                                                                                                        String[] split3 = str11.split("/");
                                                                                                                        if (split3.length == 3) {
                                                                                                                            bm bmVar3 = bm.this;
                                                                                                                            bm.a(list2, str9, str10, split3[2]);
                                                                                                                        }
                                                                                                                    } catch (Exception unused) {
                                                                                                                        bm.this.a();
                                                                                                                    }
                                                                                                                }
                                                                                                            });
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            } catch (Exception unused) {
                                                                                                bm.this.a();
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } catch (Exception unused) {
                                                                    bm.this.a();
                                                                }
                                                            }
                                                        }
                                                    }, 5000);
                                                }
                                            }
                                            cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.ca.1
                                                AnonymousClass1() {
                                                }

                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    if (ca.a()) {
                                                        QuantumMetric.a(-43, "", new j[0]);
                                                    }
                                                }
                                            });
                                            cl.c(new Runnable() { // from class: com.quantummetric.instrument.internal.ai.3.1
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    if (QuantumMetric.b != null) {
                                                        bu k = de.k();
                                                        Application application = k.c != null ? k.c.get() : null;
                                                        if (application != null) {
                                                            if (k.i != null) {
                                                                application.unregisterComponentCallbacks(k.i);
                                                            }
                                                            k.i = new be();
                                                            application.registerComponentCallbacks(k.i);
                                                        }
                                                    }
                                                    ax.b();
                                                    ai.h(ai.this);
                                                }
                                            });
                                        }
                                    }
                                    if (boVar.j.size() > 0) {
                                        synchronized (ai.this.f38a) {
                                            ai.this.b(boVar);
                                        }
                                    }
                                } catch (Exception unused) {
                                    QuantumMetric.a(av.EVENT_ENGINE_GET_START_EVENT_CALLBACK_EXCEPTION);
                                }
                            }
                        });
                    }
                }
            } catch (OutOfMemoryError e) {
                a(e);
            }
        }
    }

    final void a(String str, bf bfVar) {
        try {
            synchronized (this.f38a) {
                bo e = e();
                if (e != null) {
                    ArrayList arrayList = (ArrayList) e.k.get(str);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        e.k.put(str, arrayList);
                    }
                    arrayList.add(bfVar);
                }
            }
        } catch (Exception unused) {
            QuantumMetric.a(av.EVENT_ENGINE_LOG_OUT_OF_BAND_DATA_TO_ARRAY_EXCEPTION);
        }
    }

    final void a(String str, Object obj) {
        try {
            synchronized (this.f38a) {
                bo e = e();
                if (e != null) {
                    e.k.put(str, obj);
                }
            }
        } catch (Exception unused) {
            QuantumMetric.a(av.EVENT_ENGINE_LOG_OUT_OF_BAND_DATA_EXCEPTION);
        }
    }

    final void d() {
        try {
            this.k = false;
            if (this.j != 0 && System.currentTimeMillis() - this.j > this.n) {
                this.f38a.clear();
                if (this.l) {
                    bu k = de.k();
                    if (k != null) {
                        k.a(false);
                    }
                } else {
                    f = "";
                    dk.a();
                }
            }
            ao a2 = ao.a();
            if (a2.b != null) {
                a2.b.b = true;
            }
            a2.b = new ao.a();
            a2.b.start();
            if (de.f() != null) {
                float f2 = Settings.System.getFloat(de.f().getContentResolver(), "font_scale", 1.0f);
                if (f2 != this.s) {
                    this.s = f2;
                    if (f2 < 1.0d || f2 > 1.0d) {
                        QuantumMetric.a(-54, "Font Scale: " + Float.toString(f2), new j[0]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
