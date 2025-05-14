package com.quantummetric.ui.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import androidx.exifinterface.media.ExifInterface;
import com.extole.android.sdk.impl.http.HttpRequest;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.iterable.iterableapi.IterableConstants;
import com.quantummetric.ui.BuildConfig;
import com.quantummetric.ui.EventListener;
import com.quantummetric.ui.EventType;
import com.quantummetric.ui.QMMaskingMap;
import com.quantummetric.ui.QuantumMetric;
import com.quantummetric.ui.SessionCookieOnChangeListener;
import com.quantummetric.ui.internal.ai;
import com.quantummetric.ui.internal.ak;
import com.quantummetric.ui.internal.ao;
import com.quantummetric.ui.internal.as;
import com.quantummetric.ui.internal.bm.AnonymousClass1;
import com.quantummetric.ui.internal.bm.AnonymousClass4;
import com.quantummetric.ui.internal.df.AnonymousClass33;
import com.quantummetric.ui.internal.e;
import io.sentry.ProfilingTraceData;
import io.sentry.protocol.Browser;
import io.sentry.protocol.OperatingSystem;
import io.sentry.protocol.ViewHierarchyNode;
import java.io.File;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class bu extends QuantumMetric {
    final WeakReference<Application> c;
    final String d;
    final String e;
    final boolean f;
    final ai g;
    e h;
    be i;
    final bb j;
    final bc k;
    aj l;
    bk m;
    private final String n;
    private final boolean o;
    private boolean p;
    private z q;

    /* renamed from: com.quantummetric.instrument.internal.bu$1, reason: invalid class name */
    final class AnonymousClass1 implements p {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QuantumMetric.Builder f136a;

        AnonymousClass1(QuantumMetric.Builder builder) {
            this.f136a = builder;
        }

        @Override // com.quantummetric.ui.internal.p
        public final void a() {
            bu buVar = bu.this;
            if ((buVar.c != null ? buVar.c.get() : null) != null) {
                ag.a();
                if (QuantumMetric.f9a != null) {
                    int f = QuantumMetric.f9a.f();
                    bu buVar2 = bu.this;
                    Application application = buVar2.c != null ? buVar2.c.get() : null;
                    String str = bu.this.d;
                    String str2 = bu.this.n;
                    String format = String.format("https://%1$s-app.quantummetric.com/", str);
                    String b = QuantumMetric.f9a.b();
                    String c = QuantumMetric.f9a.c();
                    if (de.b(b)) {
                        q.f265a = format;
                    } else {
                        q.f265a = b;
                    }
                    if (de.b(c)) {
                        q.b = q.f265a;
                    } else {
                        q.b = c;
                    }
                    bf bfVar = new bf();
                    bfVar.put(Browser.TYPE, str2);
                    bfVar.put("browserMajorVersion", de.e(application));
                    bfVar.put("deviceName", de.e());
                    bfVar.put("deviceType", "Android");
                    bfVar.put(OperatingSystem.TYPE, Build.VERSION.RELEASE);
                    bfVar.put("osType", "Android");
                    bfVar.put("qmnative", BuildConfig.VERSION_NAME);
                    bfVar.put(HttpRequest.HEADER_CONTENT_ENCODING, "deflate");
                    q.c = bfVar;
                    if ((QuantumMetric.f9a.optJSONObject("cookies") != null ? 1 : 0) != 0) {
                        ax.b(QuantumMetric.f9a.optJSONObject("cookies"));
                    }
                    r1 = f;
                }
                cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.bu.1.1
                    /* JADX WARN: Type inference failed for: r4v0, types: [com.quantummetric.instrument.internal.bu$1$1$1] */
                    @Override // java.lang.Runnable
                    public final void run() {
                        WeakReference<Activity> weakReference;
                        boolean z;
                        Display c2;
                        DisplayCutout cutout;
                        int safeInsetBottom;
                        JSONArray optJSONArray;
                        JSONArray jSONArray;
                        if (!bu.this.o) {
                            al a2 = al.a();
                            if (a2.c) {
                                Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                                if (!(defaultUncaughtExceptionHandler instanceof al) && defaultUncaughtExceptionHandler != null && !a2.j) {
                                    a2.j = true;
                                    a2.f51a = defaultUncaughtExceptionHandler;
                                    Thread.setDefaultUncaughtExceptionHandler(a2);
                                }
                            }
                        }
                        e eVar = bu.this.h;
                        WeakReference<Activity> weakReference2 = AnonymousClass1.this.f136a.b;
                        ?? r4 = new e.a() { // from class: com.quantummetric.instrument.internal.bu.1.1.1
                            @Override // com.quantummetric.instrument.internal.e.a
                            public final void a() {
                                ai aiVar = bu.this.g;
                                aiVar.k = true;
                                aiVar.j = System.currentTimeMillis();
                                ao a3 = ao.a();
                                if (a3.b != null) {
                                    a3.b.b = true;
                                }
                            }

                            @Override // com.quantummetric.instrument.internal.e.a
                            public final void b() {
                                bu.this.g.d();
                            }
                        };
                        if (QuantumMetric.b != null && QuantumMetric.f9a != null) {
                            eVar.c = true;
                            y yVar = QuantumMetric.f9a;
                            if (yVar != null) {
                                List<String> list = eVar.v;
                                List<String> list2 = eVar.w;
                                List<String> list3 = eVar.x;
                                List<String> list4 = eVar.y;
                                List<String> list5 = eVar.z;
                                List<String> list6 = eVar.A;
                                try {
                                    JSONObject optJSONObject = yVar.optJSONObject("view");
                                    if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("tap")) != null) {
                                        int i = 0;
                                        while (i < optJSONArray.length()) {
                                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                                            if (optJSONObject2 != null) {
                                                String optString = optJSONObject2.optString("id");
                                                String optString2 = optJSONObject2.optString("class");
                                                jSONArray = optJSONArray;
                                                boolean optBoolean = optJSONObject2.optBoolean("clickable", true);
                                                weakReference = weakReference2;
                                                try {
                                                    boolean optBoolean2 = optJSONObject2.optBoolean("block_inner", false);
                                                    if (de.b(optString)) {
                                                        if (!de.b(optString2)) {
                                                            if (optBoolean2) {
                                                                list6.add(optString2);
                                                            } else if (optBoolean) {
                                                                list2.add(optString2);
                                                            } else {
                                                                list4.add(optString2);
                                                            }
                                                        }
                                                    } else if (optBoolean2) {
                                                        list5.add(optString);
                                                    } else if (optBoolean) {
                                                        list.add(optString);
                                                    } else {
                                                        list3.add(optString);
                                                    }
                                                } catch (Exception unused) {
                                                }
                                            } else {
                                                weakReference = weakReference2;
                                                jSONArray = optJSONArray;
                                            }
                                            i++;
                                            optJSONArray = jSONArray;
                                            weakReference2 = weakReference;
                                        }
                                    }
                                } catch (Exception unused2) {
                                }
                                weakReference = weakReference2;
                                boolean optBoolean3 = yVar.optBoolean("replay_enabled", true);
                                if (y.f283a) {
                                    optBoolean3 = y.b;
                                } else if (optBoolean3) {
                                    optBoolean3 = y.a(yVar.optInt("replay_sampling", 100));
                                }
                                eVar.d = optBoolean3;
                                JSONObject optJSONObject3 = yVar.optJSONObject("heatmap");
                                eVar.J = optJSONObject3 != null ? optJSONObject3.optBoolean("enabled", true) : true;
                                JSONObject optJSONObject4 = yVar.optJSONObject("heatmap");
                                eVar.K = optJSONObject4 != null ? optJSONObject4.optBoolean("id_criteria", false) : false;
                                eVar.t = yVar.e();
                                eVar.s.addAll(y.a(yVar.optJSONObject("dialogs"), "list"));
                                JSONObject optJSONObject5 = yVar.optJSONObject("activity");
                                if (optJSONObject5 != null) {
                                    eVar.i.addAll(y.a(optJSONObject5, "blacklist"));
                                    eVar.j.addAll(y.a(optJSONObject5, "whitelist"));
                                    eVar.m.addAll(y.a(optJSONObject5, "resume"));
                                    eVar.k.addAll(y.a(optJSONObject5, "pause"));
                                    eVar.l = optJSONObject5.optBoolean("prioritize_pause", true);
                                    eVar.n.addAll(y.a(optJSONObject5, "skip_page"));
                                    eVar.o.addAll(y.a(optJSONObject5, "delay_list"));
                                    eVar.p = optJSONObject5.optInt("delay_millis", eVar.p);
                                    eVar.q.addAll(y.a(optJSONObject5, "tap_blacklist"));
                                    eVar.r.addAll(y.a(optJSONObject5, "touch_blacklist"));
                                    eVar.u = optJSONObject5.optBoolean("force_activity_log", false);
                                    eVar.M = optJSONObject5.optBoolean("consequent_resume_disable", eVar.M);
                                    eVar.N = optJSONObject5.optBoolean("decor_rotation", true);
                                }
                                JSONObject optJSONObject6 = yVar.optJSONObject("window");
                                if (optJSONObject6 != null) {
                                    aa.y = optJSONObject6.optBoolean("track_dialog_translation", false);
                                    eVar.L = optJSONObject6.optBoolean("track_windows", eVar.L);
                                }
                                JSONObject optJSONObject7 = yVar.optJSONObject("pf");
                                if (optJSONObject7 != null) {
                                    eVar.B = y.a(optJSONObject7, "block_container_ids");
                                    eVar.C = y.a(optJSONObject7, "block_messages");
                                }
                                if (!eVar.d) {
                                    eVar.u = true;
                                    eVar.L = false;
                                }
                            } else {
                                weakReference = weakReference2;
                            }
                            Context f2 = de.f();
                            if (f2 != null) {
                                boolean isTouchExplorationEnabled = ((AccessibilityManager) f2.getSystemService("accessibility")).isTouchExplorationEnabled();
                                aa.B = isTouchExplorationEnabled;
                                if (isTouchExplorationEnabled) {
                                    QuantumMetric.a(-51, "", new j[0]);
                                }
                            }
                            eVar.I = r4;
                            bz.a();
                            if (bz.f149a != null) {
                                bz.f149a.c();
                            }
                            if (eVar.h == null && weakReference != null && weakReference.get() != null) {
                                eVar.h = weakReference;
                            }
                            if (eVar.h != null && eVar.h.get() != null) {
                                Activity activity = eVar.h.get();
                                try {
                                    if (Build.VERSION.SDK_INT >= 29 && (c2 = e.c(activity)) != null && (cutout = c2.getCutout()) != null) {
                                        if (cutout.getSafeInsetTop() != 0) {
                                            safeInsetBottom = cutout.getSafeInsetTop();
                                        } else if (cutout.getSafeInsetLeft() != 0) {
                                            safeInsetBottom = cutout.getSafeInsetLeft();
                                        } else if (cutout.getSafeInsetRight() != 0) {
                                            safeInsetBottom = cutout.getSafeInsetRight();
                                        } else if (cutout.getSafeInsetBottom() != 0) {
                                            safeInsetBottom = cutout.getSafeInsetBottom();
                                        }
                                        aa.G = safeInsetBottom;
                                    }
                                } catch (Throwable unused3) {
                                }
                                if (eVar.b == 0 && e.a(activity)) {
                                    int hashCode = activity.hashCode();
                                    if (!eVar.F.contains(Integer.valueOf(hashCode))) {
                                        eVar.F.add(Integer.valueOf(hashCode));
                                        z = true;
                                        eVar.f242a++;
                                        eVar.a(activity, eVar.P, z);
                                    }
                                }
                                z = true;
                                eVar.a(activity, eVar.P, z);
                            }
                        }
                        bu.f(bu.this);
                        ak.a().a(ak.a.SDK_START);
                    }
                }, r1);
            }
        }
    }

    public bu(QuantumMetric.Builder builder) {
        WeakReference<Application> weakReference = builder.f12a;
        this.c = weakReference;
        String str = builder.c;
        this.d = str;
        this.n = builder.e;
        this.e = builder.f;
        boolean z = builder.j;
        this.f = z;
        aa.D = z;
        this.o = builder.l;
        aa.c = builder.k;
        as.a(builder.i);
        aa.h = builder.g;
        ax.f80a = builder.h;
        this.l = new aj();
        this.m = new bk();
        this.j = new bb();
        this.k = new bc();
        if ((weakReference != null ? weakReference.get() : null) != null) {
            this.h = e.a();
            (weakReference != null ? weakReference.get() : null).registerActivityLifecycleCallbacks(this.h);
        }
        final String a2 = aa.a(str, z);
        as asVar = new as(a2, new o<as.a>() { // from class: com.quantummetric.instrument.internal.bu.2
            @Override // com.quantummetric.ui.internal.o
            public final /* synthetic */ void a(as.a aVar) {
                long j;
                as.a aVar2 = aVar;
                try {
                    boolean z2 = false;
                    if (!de.b(aVar2.b)) {
                        bu.a(bu.this, aVar2.b, false);
                        return;
                    }
                    File fileStreamPath = ((Application) bu.this.c.get()).getFileStreamPath(aa.f(bu.this.d));
                    String a3 = de.a(fileStreamPath);
                    if (de.b(a3)) {
                        bu.a(bu.this, a2);
                        return;
                    }
                    bu.a(bu.this, a3, true);
                    if (bm.f117a == null) {
                        bm.f117a = new bm();
                    }
                    bm bmVar = bm.f117a;
                    if (bmVar.e) {
                        File[] b = bm.b();
                        if (b != null) {
                            for (File file : b) {
                                bmVar.d = (int) (bmVar.d + file.length());
                            }
                        }
                        j = System.currentTimeMillis() - fileStreamPath.lastModified();
                    } else {
                        j = 0;
                    }
                    if (bmVar.e && bmVar.d < bmVar.i && j < bmVar.h) {
                        z2 = true;
                    }
                    aa.A = z2;
                } catch (Throwable unused) {
                    QuantumMetric.a("Error downloading configuration. Stopping Quantum Metric SDK");
                }
            }
        });
        asVar.b = 2048;
        as.c.execute(asVar);
        this.g = new ai(new AnonymousClass1(builder));
    }

    static /* synthetic */ void a(bu buVar, final String str) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.quantummetric.instrument.internal.bu.3

            /* renamed from: a, reason: collision with root package name */
            private int f140a = 0;

            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                try {
                    if (QuantumMetric.f9a != null) {
                        timer.cancel();
                        return;
                    }
                    int i = this.f140a;
                    this.f140a = i + 1;
                    if (i < 3 && bu.this.c.get() != null) {
                        bu.b(bu.this, str);
                        return;
                    }
                    timer.cancel();
                    QuantumMetric.a("Error downloading configuration. Stopping Quantum Metric SDK");
                } catch (Throwable unused) {
                }
            }
        }, DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM, DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM);
    }

    static /* synthetic */ void a(bu buVar, String str, boolean z) throws JSONException {
        int optInt;
        QuantumMetric.f9a = new y(str);
        ai aiVar = buVar.g;
        y yVar = QuantumMetric.f9a;
        boolean z2 = true;
        boolean z3 = QuantumMetric.b != null && yVar.optBoolean("master_switch", false) && yVar.a() && (de.b("i.QMopt", de.f()) ^ true);
        if (z3) {
            try {
                al a2 = al.a();
                JSONObject optJSONObject = yVar.optJSONObject("exc");
                if (optJSONObject != null) {
                    a2.c = optJSONObject.optBoolean("set_handler", true);
                    a2.d = optJSONObject.optBoolean("use_start_criteria", true);
                    a2.e = optJSONObject.optBoolean("qm_version_criteria", false);
                    a2.f = optJSONObject.optBoolean("wait_flush", false);
                    a2.g = optJSONObject.optInt("iterations", a2.g);
                    a2.h = y.a(optJSONObject, "not_contains");
                }
            } catch (Exception unused) {
            }
            al a3 = al.a();
            if (a3.d && a3.b.e) {
                boolean z4 = !BuildConfig.VERSION_NAME.equals(a3.b.c);
                z2 = (z4 || a3.e) ? z4 : true ^ de.d().equals(a3.b.d);
            }
            if (!z2) {
                de.a("Potential QM caused crash. QM will not restart");
            }
            z3 = z2;
        }
        if (z3) {
            aiVar.c = new ai.a(yVar);
            aiVar.d = new ai.b(yVar);
            aiVar.i = yVar.optInt("send_interval_seconds", 10);
            JSONObject optJSONObject2 = yVar.optJSONObject(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT);
            aiVar.l = optJSONObject2 != null ? optJSONObject2.optBoolean("restart", false) : false;
            JSONObject optJSONObject3 = yVar.optJSONObject(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT);
            int i = 30;
            if (optJSONObject3 != null && (optInt = optJSONObject3.optInt("timeout_minutes", 30)) <= 30) {
                i = optInt;
            }
            aiVar.n = i * 60 * 1000;
            aiVar.m = y.a((JSONObject) yVar, "block_event_ids");
            bu k = de.k();
            if (!aa.A && k != null) {
                String g = de.g(aa.e(k.d));
                if (!de.b(g)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g);
                        ai.g = jSONObject.optString("u");
                        long optLong = jSONObject.optLong("t");
                        JSONObject optJSONObject4 = yVar.optJSONObject(ViewProps.START);
                        if ((optJSONObject4 != null ? optJSONObject4.optBoolean("session_expiration") : false) && optLong > 0 && System.currentTimeMillis() - optLong < aiVar.n) {
                            ai.f = jSONObject.optString("s");
                        }
                    } catch (JSONException unused2) {
                        if (g.length() == 32) {
                            ai.g = g;
                        }
                    }
                }
            }
            if (aa.A) {
                ai.f = "sessionId";
                ai.g = IterableConstants.KEY_USER_ID;
            }
        } else {
            QuantumMetric.a("Capture is not enabled. Stopping Quantum Metric SDK");
        }
        if (z) {
            return;
        }
        if (bm.f117a == null) {
            bm.f117a = new bm();
        }
        if (bm.f117a.e) {
            de.c(aa.f(buVar.d), str);
        }
    }

    static /* synthetic */ void b(bu buVar, String str) {
        as asVar = new as(str, new o<as.a>() { // from class: com.quantummetric.instrument.internal.bu.4
            @Override // com.quantummetric.ui.internal.o
            public final /* synthetic */ void a(as.a aVar) {
                as.a aVar2 = aVar;
                try {
                    if (de.b(aVar2.b)) {
                        return;
                    }
                    bu.a(bu.this, aVar2.b, false);
                } catch (Exception unused) {
                }
            }
        });
        asVar.b = 2048;
        as.c.execute(asVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        try {
            ax.a();
            this.g.a();
            ai.b();
            if (z) {
                ai.c();
            }
            dk.a();
            e eVar = this.h;
            if (eVar != null) {
                eVar.a((String) null);
            }
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void f(bu buVar) {
        buVar.q = new z();
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _addFrozeUIListener(EventListener<?> eventListener) {
        this.l.b.add(eventListener);
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _addPossibleFrustrationListener(EventListener<View> eventListener) {
        this.l.f48a.add(eventListener);
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _addSessionCookieOnChangeListener(final SessionCookieOnChangeListener sessionCookieOnChangeListener) {
        final ai aiVar = this.g;
        if (!aiVar.b.contains(sessionCookieOnChangeListener)) {
            aiVar.b.add(sessionCookieOnChangeListener);
        }
        if (de.b(ai.f) || de.b(ai.g)) {
            return;
        }
        cl.c(new Runnable() { // from class: com.quantummetric.instrument.internal.ai.2

            /* renamed from: a */
            private /* synthetic */ SessionCookieOnChangeListener f40a;

            AnonymousClass2(final SessionCookieOnChangeListener sessionCookieOnChangeListener2) {
                r2 = sessionCookieOnChangeListener2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (r2 == null || de.b(ai.f) || de.b(ai.g)) {
                    return;
                }
                try {
                    r2.onComplete(ai.f, ai.g);
                } catch (Exception unused) {
                }
            }
        });
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final String _enableOfflineTestingMode() {
        Context f;
        if (bm.f117a == null) {
            bm.f117a = new bm();
        }
        bm bmVar = bm.f117a;
        if (!bmVar.f && (f = de.f()) != null && QuantumMetric.b != null) {
            cl.b(bmVar.new AnonymousClass4(f));
        }
        bmVar.f = true;
        return aa.d(this.d);
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _enableReplay(boolean z) {
        y.f283a = true;
        y.b = z;
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _enableWebViewInjection(boolean z, List<String> list) {
        bc bcVar = this.k;
        bcVar.b = z;
        bcVar.f104a = true;
        if (bcVar.f104a) {
            ax.b = bcVar.b;
            ax.a(bcVar.c);
        }
        if (list != null) {
            bc bcVar2 = this.k;
            bcVar2.c.clear();
            bcVar2.c.addAll(list);
            bcVar2.f104a = true;
            if (bcVar2.f104a) {
                ax.b = bcVar2.b;
                ax.a(bcVar2.c);
            }
        }
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _encryptView(View view) {
        dh.e(view);
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final Uri _getQuery(Uri uri) {
        String str = ai.f;
        String str2 = ai.g;
        return (uri == null || de.a(str, str2)) ? uri : uri.buildUpon().appendQueryParameter(aa.f21a, str).appendQueryParameter(aa.b, str2).build();
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final String _getReplay() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return !de.b(ai.f) ? "https://" + this.d + ".quantummetric.com/#/replay/cookie:" + ai.f + "?ts=" + (currentTimeMillis - 43200) + "-" + (currentTimeMillis + 43200) : "";
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _internalStop() {
        this.p = true;
        QuantumMetric.stop();
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _logRequest(String str, String str2, long j, long j2, int i, String str3, String str4, Map<String, ?> map, Map<String, ?> map2) {
        if (this.m.a(str)) {
            bk.a(bk.a(str, str2, j, j2, i, str3, str4, null, map, map2));
        }
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _manualPageSync(String str) {
        e eVar;
        if ((QuantumMetric.b == null) || (eVar = this.h) == null) {
            return;
        }
        if (cl.a() || !aa.l || eVar.H == null) {
            eVar.a(str);
            return;
        }
        if (cd.f161a && eVar.h.get() != null) {
            eVar.a(eVar.h.get().getClass().getSimpleName(), str);
        }
        if (cd.f161a) {
            return;
        }
        df dfVar = eVar.H;
        dfVar.l = str;
        cl.a(dfVar.m);
        dfVar.m = cl.b(dfVar.new AnonymousClass33(), 3000);
        eVar.f = true;
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _maskContentOfType(QMMaskingMap qMMaskingMap) {
        boolean z;
        bb bbVar = this.j;
        synchronized (bbVar.b) {
            QMMaskingMap.Type valueOf = QMMaskingMap.Type.valueOf((String) qMMaskingMap.get("type"));
            Iterator<QMMaskingMap> it = bbVar.f102a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (QMMaskingMap.Type.valueOf((String) it.next().get("type")).equals(valueOf)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                bbVar.f102a.add(qMMaskingMap);
            }
            if (QuantumMetric.f9a != null) {
                bb.a(qMMaskingMap);
                bb.b(qMMaskingMap);
            }
        }
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _maskText(View view) {
        dh.d(view);
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _maskView(View view) {
        dh.c(view);
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final boolean _removeSessionCookieOnChangeListener(SessionCookieOnChangeListener sessionCookieOnChangeListener) {
        return this.g.b.remove(sessionCookieOnChangeListener);
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _resetSession(final boolean z) {
        if (cl.a()) {
            cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.bu.5
                @Override // java.lang.Runnable
                public final void run() {
                    bu.this.b(z);
                }
            });
        } else {
            b(z);
        }
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _resume() {
        e eVar;
        boolean z = cd.f161a;
        boolean z2 = QuantumMetric.b == null;
        cd.a(false);
        if (!z || z2 || (eVar = this.h) == null) {
            return;
        }
        eVar.a((String) null);
        ao a2 = ao.a();
        if (a2.b != null) {
            a2.b.b = true;
        }
        a2.b = new ao.a();
        a2.b.start();
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _sendOutOfBandData(final String str, final Object obj) {
        if (cl.a()) {
            cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.bu.7
                @Override // java.lang.Runnable
                public final void run() {
                    bu.this.g.a(str, obj);
                }
            });
        } else {
            this.g.a(str, obj);
        }
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _sendOutOfBandEvent(final int i, final String str, final JSONObject jSONObject, j... jVarArr) {
        if (jVarArr == null) {
            jVarArr = new EventType[0];
        }
        final j[] jVarArr2 = jVarArr;
        if (cl.a()) {
            cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.bu.6
                @Override // java.lang.Runnable
                public final void run() {
                    bu.this.g.a(i, str, jSONObject, jVarArr2);
                }
            });
        } else {
            this.g.a(i, str, jSONObject, jVarArr2);
        }
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _sendPageEvent(String str, String str2, String str3) {
        ai aiVar = this.g;
        String k = de.k(str);
        String i = de.i();
        int b = de.b(de.a());
        int b2 = de.b(de.b());
        try {
            long currentTimeMillis = System.currentTimeMillis();
            bf bfVar = new bf();
            bfVar.put("Q", 1);
            bfVar.put("Y", 1);
            bfVar.put("X", i);
            bfVar.put("z", 1);
            bfVar.put("v", Long.valueOf(currentTimeMillis));
            bfVar.put(ExifInterface.GPS_DIRECTION_TRUE, "B");
            bfVar.put("u", k);
            String a2 = de.a(bfVar);
            byte[] f = de.f(str2);
            if (aa.A) {
                if (bm.f117a == null) {
                    bm.f117a = new bm();
                }
                bm bmVar = bm.f117a;
                if (bmVar.e) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(ContextChain.TAG_PRODUCT, bmVar.a(f)).put("q", a2);
                        cl.a(bmVar.new AnonymousClass1(Long.toString(currentTimeMillis), jSONObject.toString()));
                    } catch (Exception unused) {
                    }
                }
            } else {
                q.a(a2, f);
            }
            if (bm.f117a == null) {
                bm.f117a = new bm();
            }
            if (bm.f117a.f) {
                if (bm.f117a == null) {
                    bm.f117a = new bm();
                }
                bm.a(str2);
            }
            bf bfVar2 = new bf();
            bfVar2.put("t", "s");
            bfVar2.put("o", 0);
            bfVar2.put("w", Integer.valueOf(b));
            bfVar2.put("h", Integer.valueOf(b2));
            bfVar2.put(ViewHierarchyNode.JsonKeys.X, Integer.valueOf(b));
            bfVar2.put(ViewHierarchyNode.JsonKeys.Y, Integer.valueOf(b2));
            bfVar2.put("r", str3);
            bfVar2.put(")", i);
            bfVar2.put("s", 0);
            bfVar2.put("pt", str);
            bfVar2.put("qmnative_version", BuildConfig.VERSION_NAME);
            bfVar2.put("test_config", Boolean.valueOf(aa.D));
            bfVar2.put("g-c", BuildConfig.GIT_HASH);
            bfVar2.put("g-t", BuildConfig.GIT_TIME);
            bfVar2.put("url", k);
            bfVar2.put("z", Boolean.TRUE);
            bfVar2.put("d", Long.valueOf(currentTimeMillis));
            bfVar2.put("ekey", ab.c());
            bg bgVar = new bg();
            bgVar.add(bfVar2);
            bo boVar = new bo(k, currentTimeMillis, bgVar, new bf());
            try {
                Cipher cipher = boVar.l;
                if (aiVar.e.k.get(ExifInterface.LONGITUDE_EAST) != null) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    bg bgVar2 = (bg) aiVar.e.k.get(ExifInterface.LONGITUDE_EAST);
                    if (bgVar2 != null) {
                        for (int i2 = 0; i2 < bgVar2.size(); i2++) {
                            bf bfVar3 = bgVar2.get(i2);
                            ai.a(bfVar3, cipher);
                            bfVar3.put("t", Long.valueOf(currentTimeMillis2));
                            bfVar3.put("d", 0);
                        }
                        boVar.k.putAll(aiVar.e.k);
                    }
                }
                if (aiVar.e.j != null) {
                    Iterator<bf> it = aiVar.e.j.iterator();
                    while (it.hasNext()) {
                        bf next = it.next();
                        ai.a(next, cipher);
                        boVar.j.add(next);
                    }
                }
                aiVar.e.a();
            } catch (Exception unused2) {
            }
            aiVar.h = currentTimeMillis;
            if (aiVar.f38a.size() == 0) {
                aiVar.f38a.add(boVar);
                aiVar.a(boVar);
            } else {
                aiVar.a();
                synchronized (aiVar.f38a) {
                    aiVar.f38a.add(boVar);
                }
            }
        } catch (Exception unused3) {
            QuantumMetric.a(av.EVENT_ENGINE_LOG_PAGE_EXCEPTION);
        }
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _sendReplayOnlyEvent(final bf bfVar) {
        if (cl.a()) {
            cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.bu.8
                @Override // java.lang.Runnable
                public final void run() {
                    bu.this.g.a(bfVar);
                }
            });
        } else {
            this.g.a(bfVar);
        }
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _setWebviewBlockPage(String str) {
        ax.b(str);
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _setWebviewScrubList(String str) {
        ax.a(str);
    }

    @Override // com.quantummetric.ui.QuantumMetric
    public final void _stop() {
        try {
            if (this.h != null) {
                WeakReference<Application> weakReference = this.c;
                Application application = weakReference != null ? weakReference.get() : null;
                if (application != null) {
                    application.unregisterActivityLifecycleCallbacks(this.h);
                    be beVar = this.i;
                    if (beVar != null) {
                        application.unregisterComponentCallbacks(beVar);
                    }
                }
                e eVar = this.h;
                eVar.c = false;
                if (eVar.H != null) {
                    df dfVar = eVar.H;
                    if (df.j != null && df.j.size() > 2000) {
                        df.j.clear();
                    }
                    if (dfVar.b != null && dfVar.b.size() > 50000) {
                        dfVar.b.clear();
                    }
                    dfVar.b();
                }
                de.a((List<?>[]) new List[]{eVar.E, eVar.D, eVar.s, eVar.i, eVar.j, eVar.q, eVar.r, eVar.v, eVar.w, eVar.x, eVar.y, eVar.z, eVar.A, eVar.k, eVar.m, eVar.n, eVar.o});
                if (eVar.G != null) {
                    eVar.G.clear();
                }
                eVar.a((Window) null);
                z zVar = this.q;
                if (zVar != null && zVar.f285a != null) {
                    zVar.f285a.unregisterNetworkCallback(zVar.b);
                }
            }
            final ai aiVar = this.g;
            final boolean z = this.p;
            cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.ai.5

                /* renamed from: a */
                private /* synthetic */ boolean f44a;

                AnonymousClass5(final boolean z2) {
                    r2 = z2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ai.a(ai.this, r2);
                }
            });
            if (!this.p) {
                ax.a();
            }
            if (bz.f149a != null) {
                bz a2 = bz.a();
                try {
                    if (a2.h != null) {
                        a2.h.f156a = true;
                    }
                } catch (Exception unused) {
                }
                bz a3 = bz.a();
                at atVar = a3.A;
                atVar.b.clear();
                atVar.c.clear();
                a3.C.clear();
                if (af.f26a == null) {
                    af.f26a = new af();
                }
                af afVar = af.f26a;
                afVar.b.clear();
                afVar.d.clear();
                afVar.c.clear();
                afVar.e.clear();
                afVar.f.clear();
                afVar.g.clear();
                afVar.h.clear();
                afVar.i.clear();
                afVar.j.clear();
                afVar.k.clear();
                af.l = false;
                af.m = false;
                final aw awVar = afVar.n;
                if (awVar.f72a != null) {
                    cl.c(new Runnable() { // from class: com.quantummetric.instrument.internal.aw.5
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (aw.this.f72a != null) {
                                aw.this.f72a.destroy();
                                aw.this.f72a = null;
                                aw.this.b.clear();
                                aw.this.c = false;
                            }
                        }
                    });
                }
                bd a4 = bd.a();
                a4.e.clear();
                a4.f.clear();
                a4.g.clear();
                de.a((List<?>[]) new List[]{a4.j, a4.k, a4.h, a4.l, a4.m, a4.n, a4.i});
                a4.r = false;
                a4.s = false;
                a4.t = false;
                bd.b = false;
                bd.f105a = false;
                bd.d = false;
                if (k.f262a == null) {
                    k.f262a = new k();
                }
                k kVar = k.f262a;
                kVar.b.clear();
                kVar.d.clear();
                kVar.e.clear();
                kVar.f = false;
                kVar.g = false;
                if (ba.f99a == null) {
                    ba.f99a = new ba();
                }
                ba baVar = ba.f99a;
                baVar.d.clear();
                baVar.b = false;
                baVar.c = false;
                dh.a();
                a.a();
                dk.a();
                aj ajVar = this.l;
                ajVar.f48a.clear();
                ajVar.b.clear();
                if (cu.f176a == null) {
                    cu.f176a = new cu();
                }
                cu.f176a.b.clear();
            }
            ak.a().a(ak.a.SDK_STOP);
        } catch (Throwable unused2) {
        }
    }

    final void a(boolean z) {
        String str = ai.f;
        String str2 = ai.g;
        Application application = this.c.get();
        QuantumMetric.a();
        if (z) {
            ai.f = str;
        }
        ai.g = str2;
        QuantumMetric.Builder initialize = QuantumMetric.initialize(this.d, "id", application);
        if (this.f) {
            initialize.enableTestMode();
        }
        initialize.start();
    }
}
