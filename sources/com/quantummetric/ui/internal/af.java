package com.quantummetric.ui.internal;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.webkit.ProxyConfig;
import com.quantummetric.ui.EventType;
import com.quantummetric.ui.QuantumMetric;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import io.sentry.SentryLockReason;
import io.sentry.cache.EnvelopeCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.utilities.script.JavascriptRunner;

/* loaded from: classes5.dex */
public final class af {

    /* renamed from: a, reason: collision with root package name */
    public static af f26a;
    static boolean l;
    static boolean m;
    List<e> b = new CopyOnWriteArrayList();
    List<e> c = new CopyOnWriteArrayList();
    List<e> d = new CopyOnWriteArrayList();
    List<e> e = new CopyOnWriteArrayList();
    Set<String> f = Collections.newSetFromMap(new ConcurrentHashMap());
    List<i> g = new CopyOnWriteArrayList();
    List<g> h = new CopyOnWriteArrayList();
    List<k> i = new CopyOnWriteArrayList();
    List<k> j = new CopyOnWriteArrayList();
    List<k> k = new CopyOnWriteArrayList();
    final aw n = new aw();

    static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        String f29a;
        String b;
        boolean c;
        String d;
        int e;
        String f;
        String g;
        String h;
        String i;
        boolean j;
        String k;
        String l;
        String m;
        String n;

        a(JSONObject jSONObject) throws JSONException {
            super(jSONObject);
            JSONObject jSONObject2 = jSONObject.getJSONObject(aa.L);
            JSONObject jSONObject3 = jSONObject.getJSONObject(aa.K);
            this.f29a = jSONObject3.getString("regex");
            this.b = jSONObject3.optString("httpstatus_regex");
            this.c = jSONObject2.optBoolean("value_in_request");
            this.d = jSONObject2.optString("transaction_currency_key");
            this.f = jSONObject2.optString("target_currency_code", "USD");
            this.e = jSONObject2.optInt("multiply_by", 1);
            this.g = jSONObject2.optString("match_res_regex");
            this.h = jSONObject2.optString("get_res_regex");
            this.i = jSONObject2.optString("empty_res_regex");
            this.j = jSONObject2.optBoolean("fire_no_value");
            this.k = jSONObject2.optString("header");
            this.l = jSONObject2.optString("json_key");
            this.m = jSONObject2.optString(JavascriptRunner.JAVA_SCRIPT_TYPE);
            this.n = jSONObject2.optString("cookie");
        }
    }

    static class b {
        String o;
        int p;
        int q;
        String r;
        String s;
        String t;
        boolean u;
        boolean v;

        b(JSONObject jSONObject) throws JSONException {
            this.o = jSONObject.optString("type");
            this.p = jSONObject.getInt("event_id");
            this.q = jSONObject.getInt(NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY);
            this.r = jSONObject.optString(EnvelopeCache.PREFIX_CURRENT_SESSION_FILE, aa.H);
            this.s = jSONObject.optString("hit", aa.H);
            this.t = jSONObject.optString("fix_value");
            this.u = jSONObject.optBoolean("reset_session");
            this.v = jSONObject.optBoolean("reset_user");
        }
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        String f30a;
        String b;
        String c;
        boolean d;

        c(JSONObject jSONObject, e eVar) {
            if (jSONObject != null) {
                this.f30a = jSONObject.optString("json_key");
                this.b = jSONObject.optString("contains");
                this.c = jSONObject.optString("regex");
                this.d = jSONObject.optBoolean("req", eVar.f);
            }
        }
    }

    static class d {

        /* renamed from: a, reason: collision with root package name */
        final int f31a;
        final int b;
        final boolean c;
        int d = -1;
        private String e;
        private boolean f;
        private boolean g;
        private final String h;
        private final boolean i;
        private final boolean j;
        private final Set<f> k;

        d(b bVar) {
            this.e = bVar.o;
            this.f31a = bVar.p;
            this.b = bVar.q;
            boolean equals = bVar.r.equals(aa.I);
            this.c = equals;
            this.g = !equals && bVar.r.equals(aa.J);
            this.f = !bVar.s.equals(aa.H);
            this.h = bVar.t;
            this.i = bVar.u;
            this.j = bVar.v;
            this.k = Collections.newSetFromMap(new ConcurrentHashMap());
        }

        final boolean a(f fVar) {
            boolean z = !(this.c && this.d != -1);
            if (QuantumMetric.b != null && z) {
                bu buVar = QuantumMetric.b;
                int b = buVar.h != null ? buVar.h.b() : 0;
                if (this.f) {
                    z = this.d != b;
                }
                if (z && this.g) {
                    z = !this.k.contains(fVar);
                }
                if (z) {
                    this.d = b;
                    this.k.add(fVar);
                }
            }
            return z;
        }

        final boolean a(String str) {
            return a(new f(str));
        }

        final void b(f fVar) {
            if (QuantumMetric.b != null) {
                if (!de.b(this.h)) {
                    fVar = new f(this.h);
                }
                de.k()._sendOutOfBandEvent(this.f31a, fVar.f32a, fVar.b, EventType.b(this.b, fVar.c));
                boolean z = this.j;
                if (z || this.i) {
                    QuantumMetric.resetSession(z);
                }
            }
        }

        final void b(String str) {
            b(new f(str));
        }
    }

    static class e extends d {
        String e;
        boolean f;
        String g;
        String h;
        int i;
        String j;
        String k;
        String l;
        String m;
        boolean n;
        String o;
        String p;
        List<c> q;
        String r;
        String s;
        String t;
        String u;
        String v;
        private String w;

        e(a aVar) {
            super(aVar);
            this.e = aVar.f29a;
            this.w = aVar.b;
            this.f = aVar.c;
            this.h = aVar.d;
            this.j = aVar.f;
            this.i = aVar.e;
            this.q = new ArrayList();
            this.k = aVar.g;
            this.l = aVar.h;
            this.m = aVar.i;
            this.n = aVar.j;
            this.p = aVar.k;
            this.g = aVar.l;
            this.u = aVar.m;
            this.v = aVar.n;
            if (this.g.contains("+")) {
                String[] split = this.g.split(Pattern.quote("+"));
                if (split.length == 2) {
                    this.g = split[0];
                    this.o = split[1];
                }
            }
        }

        final boolean a(String str, String str2) {
            if (de.a(str, this.e)) {
                return de.a(str2, this.w) || de.a(str2, this.w);
            }
            return false;
        }
    }

    static final class f {

        /* renamed from: a, reason: collision with root package name */
        final String f32a;
        final JSONObject b;
        com.quantummetric.ui.internal.j[] c;

        public f(String str) {
            this.f32a = str;
            this.b = null;
        }

        public f(String str, JSONObject jSONObject) {
            this.f32a = str;
            this.b = jSONObject;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            JSONObject jSONObject = this.b;
            if (jSONObject == null) {
                f fVar = (f) obj;
                if (fVar.b == null) {
                    return Objects.equals(this.f32a, fVar.f32a);
                }
            }
            return ay.a(jSONObject, ((f) obj).b);
        }

        public final int hashCode() {
            JSONObject jSONObject = this.b;
            return jSONObject != null ? ay.a(jSONObject) : Objects.hashCode(this.f32a);
        }
    }

    static class g extends d {
        String e;

        g(h hVar) {
            super(hVar);
            this.e = hVar.f33a;
        }
    }

    static class h extends b {

        /* renamed from: a, reason: collision with root package name */
        String f33a;

        h(JSONObject jSONObject) throws JSONException {
            super(jSONObject);
            JSONObject optJSONObject;
            JSONObject optJSONObject2 = jSONObject.optJSONObject(aa.K);
            if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("class_matches")) == null) {
                return;
            }
            this.f33a = optJSONObject.optString(SentryLockReason.JsonKeys.CLASS_NAME);
        }
    }

    static class i extends d {
        String e;
        String f;
        String g;
        String h;
        boolean i;
        private int[] j;
        private int[] k;

        i(j jVar) {
            super(jVar);
            this.e = jVar.f34a;
            this.f = jVar.b;
            this.g = jVar.c;
            this.h = jVar.d;
            this.j = de.j(jVar.e);
            this.k = de.j(jVar.f);
            this.i = jVar.g;
        }

        private boolean c(View view) {
            if (!(view instanceof ViewGroup)) {
                return f(view);
            }
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    return false;
                }
                if (c(viewGroup.getChildAt(i))) {
                    return true;
                }
                i++;
            }
        }

        private String d(View view) {
            String str = null;
            if (!(view instanceof ViewGroup)) {
                if (!(view instanceof TextView)) {
                    return null;
                }
                TextView textView = (TextView) view;
                if (textView.getText() == null || textView.getText().length() <= 1) {
                    return null;
                }
                return textView.getText().toString();
            }
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    return str;
                }
                str = d(viewGroup.getChildAt(i));
                if (!de.b(str)) {
                    return str;
                }
                i++;
            }
        }

        private boolean e(View view) {
            try {
                return f(de.a(view, this.j));
            } catch (Exception unused) {
                return false;
            }
        }

        private boolean f(View view) {
            if (!(view instanceof TextView)) {
                return false;
            }
            TextView textView = (TextView) view;
            return (textView.getText() == null || de.b(this.h) || !de.a(textView.getText().toString(), this.h)) ? false : true;
        }

        final String a(View view) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                if (textView.getText() != null) {
                    return textView.getText().toString();
                }
            }
            return d(view);
        }

        final boolean a(Object obj, String str) {
            boolean b = de.b(this.h);
            if (!b && ag.c(obj) && !de.b(str)) {
                b = de.a(str, this.h);
            }
            if (b || !(obj instanceof View)) {
                return b;
            }
            View view = (View) obj;
            return this.j.length == 0 ? c(view) : e(view);
        }

        public final String b(View view) {
            CharSequence text;
            try {
                View a2 = de.a(view, this.k);
                return (!(a2 instanceof TextView) || (text = ((TextView) a2).getText()) == null || text.length() <= 0) ? "" : text.toString();
            } catch (Exception unused) {
                return "";
            }
        }
    }

    static class j extends b {

        /* renamed from: a, reason: collision with root package name */
        String f34a;
        String b;
        String c;
        String d;
        String e;
        String f;
        public boolean g;

        j(JSONObject jSONObject) throws JSONException {
            super(jSONObject);
            JSONObject jSONObject2 = jSONObject.getJSONObject(aa.K);
            this.f34a = jSONObject2.optString("view_class");
            this.b = jSONObject2.optString("activity_class");
            this.c = jSONObject2.optString("view_rid");
            this.d = jSONObject2.optString("button_text");
            this.e = jSONObject2.optString("indexes");
            JSONObject optJSONObject = jSONObject.optJSONObject(aa.L);
            if (optJSONObject != null) {
                this.f = optJSONObject.optString("path");
                this.g = optJSONObject.optBoolean("search_text");
            }
        }
    }

    static class k extends d {
        String e;
        String f;
        boolean g;
        Pattern h;
        private String i;
        private String j;
        private boolean k;
        private boolean l;
        private String m;
        private boolean n;
        private String o;

        k(l lVar) {
            super(lVar);
            this.o = "";
            this.e = lVar.f35a;
            this.f = lVar.b;
            this.i = lVar.c;
            this.j = lVar.d;
            boolean z = !de.b(lVar.e);
            this.g = z;
            this.h = z ? de.c(lVar.e) : null;
            this.k = lVar.i;
            this.l = lVar.g;
            this.m = lVar.f;
            this.n = lVar.h;
            if (!af.l && !de.b(this.f)) {
                af.l = true;
            }
            if (af.m || this.h == null) {
                return;
            }
            af.m = true;
        }

        final void a() {
            if ((de.b(this.e) && de.b(this.f) && this.h == null) || de.b(this.o) || !a(this.o)) {
                return;
            }
            b(this.o);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x003e, code lost:
        
            if (r3.l == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
        
            if ((r5.h() instanceof android.view.View) == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
        
            r1 = com.quantummetric.ui.internal.de.d((android.view.View) r5.h());
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final void a(java.lang.CharSequence r4, com.quantummetric.instrument.internal.cj.b r5) {
            /*
                r3 = this;
                if (r5 == 0) goto L9
                if (r4 == 0) goto L9
                java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L9f
                goto La
            L9:
                r4 = 0
            La:
                boolean r0 = com.quantummetric.ui.internal.de.b(r4)     // Catch: java.lang.Exception -> L9f
                r1 = 1
                r0 = r0 ^ r1
                r2 = 0
                if (r0 == 0) goto L25
                boolean r0 = r3.n     // Catch: java.lang.Exception -> L9f
                if (r0 == 0) goto L23
                boolean r0 = r5.a()     // Catch: java.lang.Exception -> L9f
                if (r0 != 0) goto L25
                boolean r0 = r5.b()     // Catch: java.lang.Exception -> L9f
                if (r0 != 0) goto L25
            L23:
                r0 = r1
                goto L26
            L25:
                r0 = r2
            L26:
                if (r0 == 0) goto L39
                java.lang.String r0 = r3.m     // Catch: java.lang.Exception -> L9f
                boolean r0 = com.quantummetric.ui.internal.de.b(r0)     // Catch: java.lang.Exception -> L9f
                if (r0 != 0) goto L3a
                java.lang.String r0 = r3.m     // Catch: java.lang.Exception -> L9f
                boolean r0 = com.quantummetric.ui.internal.de.a(r4, r0)     // Catch: java.lang.Exception -> L9f
                if (r0 != 0) goto L39
                goto L3a
            L39:
                r1 = r2
            L3a:
                if (r1 == 0) goto L52
                boolean r0 = r3.l     // Catch: java.lang.Exception -> L9f
                if (r0 == 0) goto L52
                java.lang.Object r0 = r5.h()     // Catch: java.lang.Exception -> L9f
                boolean r0 = r0 instanceof android.view.View     // Catch: java.lang.Exception -> L9f
                if (r0 == 0) goto L52
                java.lang.Object r5 = r5.h()     // Catch: java.lang.Exception -> L9f
                android.view.View r5 = (android.view.View) r5     // Catch: java.lang.Exception -> L9f
                boolean r1 = com.quantummetric.ui.internal.de.d(r5)     // Catch: java.lang.Exception -> L9f
            L52:
                if (r1 == 0) goto L66
                java.lang.String r5 = r3.i     // Catch: java.lang.Exception -> L9f
                boolean r5 = com.quantummetric.ui.internal.de.b(r5)     // Catch: java.lang.Exception -> L9f
                if (r5 != 0) goto L66
                com.quantummetric.instrument.internal.e r5 = com.quantummetric.ui.internal.e.a()     // Catch: java.lang.Exception -> L9f
                java.lang.String r0 = r3.i     // Catch: java.lang.Exception -> L9f
                boolean r1 = r5.a(r0, r2)     // Catch: java.lang.Exception -> L9f
            L66:
                if (r1 == 0) goto L9f
                r3.o = r4     // Catch: java.lang.Exception -> L9f
                java.lang.String r4 = r3.j     // Catch: java.lang.Exception -> L9f
                boolean r4 = com.quantummetric.ui.internal.de.b(r4)     // Catch: java.lang.Exception -> L9f
                if (r4 != 0) goto L98
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9f
                r4.<init>()     // Catch: java.lang.Exception -> L9f
                java.lang.String r5 = r3.j     // Catch: java.lang.Exception -> L9f
                r0 = 2
                java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5, r0)     // Catch: java.lang.Exception -> L9f
                java.lang.String r0 = r3.o     // Catch: java.lang.Exception -> L9f
                java.util.regex.Matcher r5 = r5.matcher(r0)     // Catch: java.lang.Exception -> L9f
            L84:
                boolean r0 = r5.find()     // Catch: java.lang.Exception -> L9f
                if (r0 == 0) goto L92
                java.lang.String r0 = r5.group()     // Catch: java.lang.Exception -> L9f
                r4.append(r0)     // Catch: java.lang.Exception -> L9f
                goto L84
            L92:
                java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L9f
                r3.o = r4     // Catch: java.lang.Exception -> L9f
            L98:
                boolean r4 = r3.k     // Catch: java.lang.Exception -> L9f
                if (r4 == 0) goto L9f
                r3.a()     // Catch: java.lang.Exception -> L9f
            L9f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.instrument.internal.af.k.a(java.lang.CharSequence, com.quantummetric.instrument.internal.cj$b):void");
        }
    }

    static class l extends b {

        /* renamed from: a, reason: collision with root package name */
        String f35a;
        String b;
        String c;
        String d;
        String e;
        String f;
        boolean g;
        boolean h;
        boolean i;

        l(JSONObject jSONObject) throws JSONException {
            super(jSONObject);
            this.f35a = null;
            JSONObject optJSONObject = jSONObject.optJSONObject(aa.K);
            JSONObject jSONObject2 = jSONObject.getJSONObject(aa.L);
            if (optJSONObject != null) {
                this.i = optJSONObject.optBoolean("self");
                this.c = optJSONObject.optString("activity");
            }
            this.f35a = jSONObject2.optString("id");
            this.b = jSONObject2.optString("contain");
            this.e = jSONObject2.optString("regex");
            this.d = jSONObject2.optString("result_regex");
            this.g = jSONObject2.optBoolean("require_visibility");
            this.h = jSONObject2.optBoolean("ignore_masked");
            this.f = jSONObject2.optString("ignore_regex");
        }
    }

    static String a(e eVar, String str, String str2) {
        try {
            str = str.replaceAll("[^.0123456789]", "");
            double parseDouble = Double.parseDouble(str);
            if (!de.b(str2) && QuantumMetric.f9a != null) {
                double a2 = QuantumMetric.f9a.a(eVar.j);
                double a3 = QuantumMetric.f9a.a(str2);
                if (a2 > 0.0d && a3 > 0.0d) {
                    parseDouble = de.a(a2, a3, parseDouble);
                }
            }
            return Long.toString(Math.round(eVar.i * parseDouble));
        } catch (Exception unused) {
            return str;
        }
    }

    private String a(String[] strArr, Object obj) {
        int parseInt;
        try {
            Object obj2 = obj instanceof String ? new Object() : obj;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    parseInt = Integer.parseInt(strArr[i2]);
                    if (i2 == 0 && (obj instanceof String)) {
                        obj2 = new JSONArray((String) obj);
                    }
                } catch (NumberFormatException unused) {
                }
                if (obj2 instanceof JSONArray) {
                    obj2 = ((JSONArray) obj2).get(parseInt);
                }
                if (i2 == 0 && (obj instanceof String)) {
                    obj2 = new JSONObject((String) obj);
                }
                if (strArr[i2].equals(ProxyConfig.MATCH_ALL_SCHEMES)) {
                    if (i2 < strArr.length - 1 && (obj2 instanceof JSONArray)) {
                        JSONArray jSONArray = (JSONArray) obj2;
                        int length = (strArr.length - i2) - 1;
                        String[] strArr2 = new String[length];
                        System.arraycopy(strArr, i2 + 1, strArr2, 0, length);
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            String a2 = a(strArr2, jSONArray.get(i3));
                            if (!de.b(a2)) {
                                return a2;
                            }
                        }
                    }
                    return null;
                }
                if (obj2 instanceof JSONObject) {
                    obj2 = ((JSONObject) obj2).get(strArr[i2]);
                }
            }
            return obj2.toString();
        } catch (Exception unused2) {
            return null;
        }
    }

    final String a(String str, String str2) {
        if (de.b(str)) {
            return null;
        }
        String[] split = str.split(Pattern.quote("."));
        if (str2.contains(split[split.length - 1])) {
            return a(split, str2);
        }
        return null;
    }

    public final void a(int i2, String str, JSONObject jSONObject, com.quantummetric.ui.internal.j... jVarArr) {
        try {
            Iterator it = Arrays.asList(this.b, this.c, this.d, this.e, this.g, this.h, this.i, this.j, this.k).iterator();
            loop0: while (true) {
                if (!it.hasNext()) {
                    r2 = null;
                    break;
                }
                for (d dVar : (List) it.next()) {
                    if (dVar.f31a == i2) {
                        break loop0;
                    }
                }
            }
            if (dVar != null) {
                f fVar = new f(str, jSONObject);
                fVar.c = jVarArr;
                if (dVar.a(fVar)) {
                    dVar.b(fVar);
                }
            }
        } catch (Throwable unused) {
        }
    }

    final void a(e eVar, String str) {
        k b2;
        if (str.equals("EMPTY_RESULT_KEY")) {
            str = "";
        }
        eVar.b(str);
        if (de.b(eVar.o) || (b2 = b(eVar.o)) == null) {
            return;
        }
        b2.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
    
        if (r12 != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
    
        if (com.quantummetric.ui.internal.de.b(r1.g) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
    
        if (r1.g.equals(r9) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005e, code lost:
    
        if (r1.a(r7, r11) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0060, code lost:
    
        r2 = new com.quantummetric.instrument.internal.af.f(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
    
        r4 = r1.a(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ac, code lost:
    
        if (r4 == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b0, code lost:
    
        if ((r7 instanceof android.view.View) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b2, code lost:
    
        r2 = (android.view.View) r7;
        r3 = r1.b(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bd, code lost:
    
        if (com.quantummetric.ui.internal.de.b(r3) != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d0, code lost:
    
        r1.b(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c2, code lost:
    
        if (r1.i == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c4, code lost:
    
        r3 = r1.a(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00cc, code lost:
    
        if (com.quantummetric.ui.internal.de.b(r3) != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00cf, code lost:
    
        r3 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x006a, code lost:
    
        if (r12 != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0070, code lost:
    
        if (com.quantummetric.ui.internal.de.b(r10) != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0078, code lost:
    
        if (r1.e.equals(r10) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x007e, code lost:
    
        if (r1.a(r7, r11) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0080, code lost:
    
        r2 = new com.quantummetric.instrument.internal.af.f(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x008c, code lost:
    
        if (com.quantummetric.ui.internal.de.b(r1.h) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0094, code lost:
    
        if (com.quantummetric.ui.internal.de.b(r1.g) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x009c, code lost:
    
        if (com.quantummetric.ui.internal.de.b(r1.e) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00a4, code lost:
    
        if (com.quantummetric.ui.internal.de.a(r8, r1.h) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00a6, code lost:
    
        r2 = new com.quantummetric.instrument.internal.af.f(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void a(java.lang.Object r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, boolean r12) {
        /*
            r6 = this;
            if (r7 == 0) goto Ld5
            com.quantummetric.instrument.internal.bu r0 = com.quantummetric.ui.QuantumMetric.b     // Catch: java.lang.Exception -> Ld5
            if (r0 == 0) goto Ld5
            java.util.List<com.quantummetric.instrument.internal.af$i> r0 = r6.g     // Catch: java.lang.Exception -> Ld5
            int r0 = r0.size()     // Catch: java.lang.Exception -> Ld5
            if (r0 <= 0) goto Ld5
            java.util.List<com.quantummetric.instrument.internal.af$i> r0 = r6.g     // Catch: java.lang.Exception -> Ld5
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> Ld5
        L14:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Exception -> Ld5
            if (r1 == 0) goto Ld5
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Exception -> Ld5
            com.quantummetric.instrument.internal.af$i r1 = (com.quantummetric.instrument.internal.af.i) r1     // Catch: java.lang.Exception -> Ld5
            boolean r2 = r1.c     // Catch: java.lang.Exception -> Ld5
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L2d
            int r2 = r1.d     // Catch: java.lang.Exception -> Ld5
            r5 = -1
            if (r2 == r5) goto L2d
            r2 = r3
            goto L2e
        L2d:
            r2 = r4
        L2e:
            if (r2 != 0) goto L14
            java.lang.String r2 = r1.f     // Catch: java.lang.Exception -> Ld5
            boolean r2 = com.quantummetric.ui.internal.de.b(r2)     // Catch: java.lang.Exception -> Ld5
            if (r2 != 0) goto L46
            com.quantummetric.instrument.internal.e r2 = com.quantummetric.ui.internal.e.a()     // Catch: java.lang.Exception -> Ld5
            java.lang.String r5 = r1.f     // Catch: java.lang.Exception -> Ld5
            boolean r2 = r2.a(r5, r4)     // Catch: java.lang.Exception -> Ld5
            if (r2 == 0) goto L45
            goto L46
        L45:
            r3 = r4
        L46:
            if (r3 == 0) goto L14
            if (r12 != 0) goto L6a
            java.lang.String r2 = r1.g     // Catch: java.lang.Exception -> Ld5
            boolean r2 = com.quantummetric.ui.internal.de.b(r2)     // Catch: java.lang.Exception -> Ld5
            if (r2 != 0) goto L6a
            java.lang.String r2 = r1.g     // Catch: java.lang.Exception -> Ld5
            boolean r2 = r2.equals(r9)     // Catch: java.lang.Exception -> Ld5
            if (r2 == 0) goto L6a
            boolean r2 = r1.a(r7, r11)     // Catch: java.lang.Exception -> Ld5
            if (r2 == 0) goto L6a
            com.quantummetric.instrument.internal.af$f r2 = new com.quantummetric.instrument.internal.af$f     // Catch: java.lang.Exception -> Ld5
            r2.<init>(r8)     // Catch: java.lang.Exception -> Ld5
        L65:
            boolean r4 = r1.a(r2)     // Catch: java.lang.Exception -> Ld5
            goto Lac
        L6a:
            if (r12 != 0) goto L86
            boolean r2 = com.quantummetric.ui.internal.de.b(r10)     // Catch: java.lang.Exception -> Ld5
            if (r2 != 0) goto L86
            java.lang.String r2 = r1.e     // Catch: java.lang.Exception -> Ld5
            boolean r2 = r2.equals(r10)     // Catch: java.lang.Exception -> Ld5
            if (r2 == 0) goto L86
            boolean r2 = r1.a(r7, r11)     // Catch: java.lang.Exception -> Ld5
            if (r2 == 0) goto L86
            com.quantummetric.instrument.internal.af$f r2 = new com.quantummetric.instrument.internal.af$f     // Catch: java.lang.Exception -> Ld5
            r2.<init>(r8)     // Catch: java.lang.Exception -> Ld5
            goto L65
        L86:
            java.lang.String r2 = r1.h     // Catch: java.lang.Exception -> Ld5
            boolean r2 = com.quantummetric.ui.internal.de.b(r2)     // Catch: java.lang.Exception -> Ld5
            if (r2 != 0) goto Lac
            java.lang.String r2 = r1.g     // Catch: java.lang.Exception -> Ld5
            boolean r2 = com.quantummetric.ui.internal.de.b(r2)     // Catch: java.lang.Exception -> Ld5
            if (r2 == 0) goto Lac
            java.lang.String r2 = r1.e     // Catch: java.lang.Exception -> Ld5
            boolean r2 = com.quantummetric.ui.internal.de.b(r2)     // Catch: java.lang.Exception -> Ld5
            if (r2 == 0) goto Lac
            java.lang.String r2 = r1.h     // Catch: java.lang.Exception -> Ld5
            boolean r2 = com.quantummetric.ui.internal.de.a(r8, r2)     // Catch: java.lang.Exception -> Ld5
            if (r2 == 0) goto Lac
            com.quantummetric.instrument.internal.af$f r2 = new com.quantummetric.instrument.internal.af$f     // Catch: java.lang.Exception -> Ld5
            r2.<init>(r8)     // Catch: java.lang.Exception -> Ld5
            goto L65
        Lac:
            if (r4 == 0) goto L14
            boolean r2 = r7 instanceof android.view.View     // Catch: java.lang.Exception -> Ld5
            if (r2 == 0) goto Lcf
            r2 = r7
            android.view.View r2 = (android.view.View) r2     // Catch: java.lang.Exception -> Ld5
            java.lang.String r3 = r1.b(r2)     // Catch: java.lang.Exception -> Ld5
            boolean r4 = com.quantummetric.ui.internal.de.b(r3)     // Catch: java.lang.Exception -> Ld5
            if (r4 != 0) goto Lc0
            goto Ld0
        Lc0:
            boolean r3 = r1.i     // Catch: java.lang.Exception -> Ld5
            if (r3 == 0) goto Lcf
            java.lang.String r3 = r1.a(r2)     // Catch: java.lang.Exception -> Ld5
            boolean r2 = com.quantummetric.ui.internal.de.b(r3)     // Catch: java.lang.Exception -> Ld5
            if (r2 != 0) goto Lcf
            goto Ld0
        Lcf:
            r3 = r8
        Ld0:
            r1.b(r3)     // Catch: java.lang.Exception -> Ld5
            goto L14
        Ld5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.af.a(java.lang.Object, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }

    final void a(String str) {
        if (de.b(str) || QuantumMetric.b == null) {
            return;
        }
        for (g gVar : this.h) {
            if (!(gVar.c && gVar.d != -1) && gVar.e.equals(str) && gVar.a(new f(""))) {
                gVar.b("");
                return;
            }
        }
    }

    final k b(String str) {
        for (k kVar : this.i) {
            if (kVar.e.equals(str)) {
                return kVar;
            }
        }
        return null;
    }
}
