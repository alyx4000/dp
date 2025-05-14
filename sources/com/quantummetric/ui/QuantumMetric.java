package com.quantummetric.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import com.quantummetric.ui.QMMaskingMap;
import com.quantummetric.ui.internal.af;
import com.quantummetric.ui.internal.av;
import com.quantummetric.ui.internal.bf;
import com.quantummetric.ui.internal.bn;
import com.quantummetric.ui.internal.bt;
import com.quantummetric.ui.internal.bu;
import com.quantummetric.ui.internal.cd;
import com.quantummetric.ui.internal.cl;
import com.quantummetric.ui.internal.de;
import com.quantummetric.ui.internal.h;
import com.quantummetric.ui.internal.j;
import com.quantummetric.ui.internal.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.Interceptor;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class QuantumMetric {

    /* renamed from: a, reason: collision with root package name */
    public static y f9a;
    public static bu b;
    private static CriticalErrorListener c;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<Application> f12a;
        public WeakReference<Activity> b;
        public String c;
        String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public Set<String> i;
        public boolean j;
        public boolean k;
        public boolean l;

        private Builder() {
            this.i = new HashSet();
        }

        /* synthetic */ Builder(byte b) {
            this();
        }

        public Builder addCertificateKey(String str) {
            if (!de.b(str)) {
                this.i.add(str);
            }
            return this;
        }

        public Builder customConfigURL(String str) {
            this.g = str;
            return this;
        }

        public Builder disableCrashReporting() {
            this.l = true;
            return this;
        }

        public Builder enableCertificatePinning() {
            this.k = true;
            return this;
        }

        public Builder enableEncryptionWithKey(String str) {
            this.f = str;
            return this;
        }

        public Builder enableTestMode() {
            this.j = true;
            return this;
        }

        public Builder setWebViewInstrumentationURL(String str) {
            if (!de.b(str)) {
                this.h = str;
            }
            return this;
        }

        public void start() {
            if (de.b(this.c)) {
                Log.e("QM Native SDK", "Subscription name is empty; not starting. Please initialize with a valid subscription name.");
                return;
            }
            if (de.b(this.d)) {
                Log.e("QM Native SDK", "UID is empty; not starting. Please initialize with a valid uid.");
                return;
            }
            WeakReference<Application> weakReference = this.f12a;
            if (weakReference == null || weakReference.get() == null) {
                Log.e("QM Native SDK", "Application is null; not starting. Please initialize with a non-null Application instance.");
                return;
            }
            if (de.b(this.e)) {
                this.e = de.a((Context) this.f12a.get());
            }
            if (QuantumMetric.b != null) {
                Log.e("QM Native SDK", "QM is already initialized, no need to call start");
                return;
            }
            if (cd.f161a) {
                cd.a(false);
            }
            try {
                QuantumMetric.b = new bu(this);
            } catch (Exception unused) {
                QuantumMetric.b("Failed to initialize Quantum Metric SDK.");
                QuantumMetric.stop();
            }
        }

        public Builder withBrowserName(String str) {
            this.e = str;
            return this;
        }
    }

    public enum State {
        Uninitialized,
        Running,
        Paused
    }

    public static void a() {
        bu buVar = b;
        if (buVar != null) {
            buVar._internalStop();
        }
    }

    public static void a(int i, String str, JSONObject jSONObject, j... jVarArr) {
        if (b == null) {
            Log.w("QM Native SDK", "Capture is currently uninitialized. Please call initialize and start first.");
            return;
        }
        if (af.f26a == null) {
            af.f26a = new af();
        }
        af.f26a.a(i, str, jSONObject, jVarArr);
    }

    public static void a(int i, String str, j... jVarArr) {
        bu buVar = b;
        if (buVar != null) {
            buVar._sendOutOfBandEvent(i, str, null, jVarArr);
            return;
        }
        j jVar = j.d;
        int length = jVarArr.length;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            if (jVarArr[i2] == jVar) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            Log.w("QM Native SDK", "Capture is currently uninitialized. Please call initialize and start first.");
        }
    }

    public static void a(av avVar) {
        a("Internal Error. Stopping Quantum Metric SDK. Error Code: " + avVar.h);
    }

    public static void a(String str) {
        CriticalErrorListener criticalErrorListener;
        if (str != null && (criticalErrorListener = c) != null) {
            try {
                criticalErrorListener.onError(str);
            } catch (Exception unused) {
            }
        }
        bu buVar = b;
        if (buVar != null) {
            buVar._internalStop();
        }
    }

    public static void a(String str, Object obj) {
        bu buVar = b;
        if (buVar != null) {
            buVar._sendOutOfBandData(str, obj);
        } else {
            Log.w("QM Native SDK", "Capture is currently uninitialized. Please call initialize and start first.");
        }
    }

    public static void a(String str, String str2, String str3) {
        bu buVar = b;
        if (buVar != null) {
            buVar._sendPageEvent(str, str2, str3);
        } else {
            Log.w("QM Native SDK", "Capture is currently uninitialized. Please call initialize and start first.");
        }
    }

    public static void addFrozeUIListener(EventListener<?> eventListener) {
        bu buVar = b;
        if (buVar != null) {
            buVar._addFrozeUIListener(eventListener);
        } else {
            Log.w("QM Native SDK", "Capture is currently uninitialized. Please call initialize and start first.");
        }
    }

    public static void addPossibleFrustrationListener(EventListener<View> eventListener) {
        bu buVar = b;
        if (buVar != null) {
            buVar._addPossibleFrustrationListener(eventListener);
        } else {
            Log.w("QM Native SDK", "Capture is currently uninitialized. Please call initialize and start first.");
        }
    }

    public static Uri addQuery(Uri uri) {
        bu buVar = b;
        Uri _getQuery = buVar != null ? buVar._getQuery(uri) : uri;
        if (_getQuery == uri) {
            Log.w("QM Native SDK", "Session haven't been created yet; returning same uri.");
        }
        return _getQuery;
    }

    public static void addSessionCookieOnChangeListener(SessionCookieOnChangeListener sessionCookieOnChangeListener) {
        bu buVar = b;
        if (buVar != null) {
            buVar._addSessionCookieOnChangeListener(sessionCookieOnChangeListener);
        } else {
            Log.w("QM Native SDK", "Capture is currently uninitialized. Please call initialize and start first.");
        }
    }

    static /* synthetic */ void b(String str) {
        CriticalErrorListener criticalErrorListener = c;
        if (criticalErrorListener != null) {
            try {
                criticalErrorListener.onError(str);
            } catch (Exception unused) {
            }
        }
    }

    public static String enableOfflineTestingMode() {
        bu buVar = b;
        if (buVar != null) {
            return buVar._enableOfflineTestingMode();
        }
        Log.d("QM Native SDK", "Capture is currently uninitialized. Please call initialize and start first.");
        return "";
    }

    public static void enableReplay(boolean z) {
        bu buVar = b;
        if (buVar != null) {
            buVar._enableReplay(z);
        } else {
            Log.w("QM Native SDK", "Capture is currently uninitialized. Please call initialize and start first.");
        }
    }

    public static void enableWebViewInjection(boolean z, String... strArr) {
        bu buVar = b;
        if (buVar != null) {
            buVar._enableWebViewInjection(z, new ArrayList(Arrays.asList(strArr)));
        } else {
            Log.w("QM Native SDK", "Capture is currently uninitialized. Please call initialize and start first.");
        }
    }

    public static void encryptView(View view) {
        bu buVar = b;
        if (buVar != null) {
            buVar._encryptView(view);
        }
    }

    public static State getCurrentState() {
        return b == null ? State.Uninitialized : cd.f161a ? State.Paused : State.Running;
    }

    public static Interceptor getOkHttp3Interceptor() {
        return bn.a();
    }

    public static String getReplay() {
        bu buVar = b;
        if (buVar != null) {
            return buVar._getReplay();
        }
        Log.w("QM Native SDK", "Instrument is null; returning empty string.");
        return "";
    }

    public static Builder initialize(String str, String str2, Activity activity) {
        if (de.b(str)) {
            Log.e("QM Native SDK", "Subscription name is empty. Please initialize with a valid subscription name.");
        }
        if (de.b(str2)) {
            Log.e("QM Native SDK", "UID is empty. Please initialize with a valid uid.");
        }
        if (activity == null) {
            Log.e("QM Native SDK", "Activity is null. Please initialize with a non-null Activity instance.");
        }
        Builder builder = new Builder((byte) 0);
        builder.c = str;
        builder.d = str2;
        if (activity != null) {
            builder.f12a = new WeakReference<>(activity.getApplication());
            builder.b = new WeakReference<>(activity);
        }
        return builder;
    }

    public static Builder initialize(String str, String str2, Application application) {
        if (de.b(str)) {
            Log.e("QM Native SDK", "Subscription name is empty. Please initialize with a valid subscription name.");
        }
        if (de.b(str2)) {
            Log.e("QM Native SDK", "UID is empty. Please initialize with a valid uid.");
        }
        if (application == null) {
            Log.e("QM Native SDK", "Application is null. Please initialize with a non-null Application instance.");
        }
        Builder builder = new Builder((byte) 0);
        builder.c = str;
        builder.d = str2;
        builder.f12a = new WeakReference<>(application);
        return builder;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.quantummetric.instrument.QuantumMetric$1] */
    public static void isUserOptIn(Context context, final QuantumMetricAsyncListener<Boolean> quantumMetricAsyncListener) {
        de.a("i.QMopt", context, (h<Boolean>) new h<Boolean>() { // from class: com.quantummetric.instrument.QuantumMetric.1
            @Override // com.quantummetric.ui.internal.h
            public final /* synthetic */ void a(Boolean bool) {
                final Boolean bool2 = bool;
                cl.c(new Runnable() { // from class: com.quantummetric.instrument.QuantumMetric.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        QuantumMetricAsyncListener.this.onResult(Boolean.valueOf(!bool2.booleanValue()));
                    }
                });
            }
        });
    }

    public static void logRequest(String str, String str2, long j, long j2, int i, String str3, String str4, Map<String, ?> map, Map<String, ?> map2) {
        bu buVar = b;
        if (buVar != null) {
            buVar._logRequest(str, str2, j, j2, i, str3, str4, map, map2);
        }
    }

    public static void maskContentOfType(QMMaskingMap qMMaskingMap) {
        bu buVar = b;
        if (buVar != null) {
            buVar._maskContentOfType(qMMaskingMap);
        } else {
            Log.w("QM Native SDK", "Capture is currently uninitialized. Please call initialize and start first.");
        }
    }

    public static void maskText(View view) {
        bu buVar = b;
        if (buVar != null) {
            buVar._maskText(view);
        }
    }

    public static void maskView(View view) {
        bu buVar = b;
        if (buVar != null) {
            buVar._maskView(view);
        }
    }

    public static void optUserBackIn(Context context) {
        de.a("i.QMopt", context);
    }

    public static void optUserOut(Context context) {
        de.a("i.QMopt", "", context);
        if (b != null) {
            stop();
        }
    }

    public static void pause() {
        cd.a(true);
    }

    public static boolean removeSessionCookieOnChangeListener(SessionCookieOnChangeListener sessionCookieOnChangeListener) {
        bu buVar = b;
        if (buVar != null) {
            return buVar._removeSessionCookieOnChangeListener(sessionCookieOnChangeListener);
        }
        Log.w("QM Native SDK", "Capture is currently uninitialized. Please call initialize and start first.");
        return false;
    }

    public static void resetSession(boolean z) {
        bu buVar = b;
        if (buVar != null) {
            buVar._resetSession(z);
        } else {
            Log.w("QM Native SDK", "Capture is currently uninitialized. Please call initialize and start first.");
        }
    }

    public static void resume() {
        bu buVar = b;
        if (buVar != null) {
            buVar._resume();
        } else {
            Log.e("QM Native SDK", "QM is not initialized, cannot call resume");
        }
    }

    public static void sendError(int i, String str, ErrorType... errorTypeArr) {
        a(i, str, bt.a(errorTypeArr, j.d));
    }

    public static void sendEvent(int i, String str, JSONObject jSONObject, EventType... eventTypeArr) {
        j[] a2 = bt.a(eventTypeArr, j.d);
        if (b == null) {
            Log.w("QM Native SDK", "Capture is currently uninitialized. Please call initialize and start first.");
            return;
        }
        if (af.f26a == null) {
            af.f26a = new af();
        }
        af.f26a.a(i, str, jSONObject, a2);
    }

    public static void sendEvent(int i, String str, EventType... eventTypeArr) {
        a(i, str, bt.a(eventTypeArr, j.d));
    }

    public static void sendNewPageNamed(String str) {
        bu buVar = b;
        if (buVar != null) {
            buVar._manualPageSync(str);
        }
    }

    public static void sendPage() {
        bu buVar = b;
        if (buVar != null) {
            buVar._manualPageSync(null);
        }
    }

    public static void setAPICaptureURLRegex(String... strArr) {
        maskContentOfType(new QMMaskingMap(QMMaskingMap.Type.ApiUrl).addRegexList(strArr));
    }

    public static void setCriticalErrorListener(CriticalErrorListener criticalErrorListener) {
        c = criticalErrorListener;
    }

    public static void setUserEmailAddress(String str) {
        sendEvent(0, str, EventType.Login, EventType.EmailAddress);
    }

    public static void setWebviewBlockPage(String str) {
        bu buVar = b;
        if (buVar != null) {
            buVar._setWebviewBlockPage(str);
        } else {
            Log.w("QM Native SDK", "Capture is currently uninitialized. Please call initialize and start first.");
        }
    }

    public static void setWebviewScrubList(String str) {
        bu buVar = b;
        if (buVar != null) {
            buVar._setWebviewScrubList(str);
        } else {
            Log.w("QM Native SDK", "Capture is currently uninitialized. Please call initialize and start first.");
        }
    }

    public static void stop() {
        bu buVar = b;
        if (buVar != null) {
            buVar._stop();
        } else {
            Log.e("QM Native SDK", "QM is not initialized, cannot call stop");
        }
        if (f9a == null) {
            f9a = new y();
        }
        f9a.l = true;
        b = null;
    }

    protected abstract void _addFrozeUIListener(EventListener<?> eventListener);

    protected abstract void _addPossibleFrustrationListener(EventListener<View> eventListener);

    protected abstract void _addSessionCookieOnChangeListener(SessionCookieOnChangeListener sessionCookieOnChangeListener);

    protected abstract String _enableOfflineTestingMode();

    protected abstract void _enableReplay(boolean z);

    protected abstract void _enableWebViewInjection(boolean z, List<String> list);

    protected abstract void _encryptView(View view);

    protected abstract Uri _getQuery(Uri uri);

    protected abstract String _getReplay();

    protected abstract void _internalStop();

    protected abstract void _logRequest(String str, String str2, long j, long j2, int i, String str3, String str4, Map<String, ?> map, Map<String, ?> map2);

    protected abstract void _manualPageSync(String str);

    protected abstract void _maskContentOfType(QMMaskingMap qMMaskingMap);

    protected abstract void _maskText(View view);

    protected abstract void _maskView(View view);

    protected abstract boolean _removeSessionCookieOnChangeListener(SessionCookieOnChangeListener sessionCookieOnChangeListener);

    protected abstract void _resetSession(boolean z);

    protected abstract void _resume();

    public abstract void _sendOutOfBandData(String str, Object obj);

    protected abstract void _sendOutOfBandEvent(int i, String str, JSONObject jSONObject, j... jVarArr);

    protected abstract void _sendPageEvent(String str, String str2, String str3);

    public abstract void _sendReplayOnlyEvent(bf bfVar);

    protected abstract void _setWebviewBlockPage(String str);

    protected abstract void _setWebviewScrubList(String str);

    protected abstract void _stop();
}
