package sdk.pendo.io.network.interfaces;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.amplitude.reactnative.AndroidContextProvider;
import com.iterable.iterableapi.IterableConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.analytics.data.IdentifyData;
import sdk.pendo.io.b.e;
import sdk.pendo.io.e7.g;
import sdk.pendo.io.e9.d;
import sdk.pendo.io.g9.i0;
import sdk.pendo.io.g9.t;
import sdk.pendo.io.g9.y;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.SessionData;
import sdk.pendo.io.network.interfaces.GetAuthToken;
import sdk.pendo.io.network.interfaces.HttpLoggingInterceptor;
import sdk.pendo.io.network.responses.converters.gson.PendoGsonConverterFactory;
import sdk.pendo.io.utilities.AndroidUtils;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.w;
import sdk.pendo.io.w2.z;
import sdk.pendo.io.w6.b;
import sdk.pendo.io.x5.j;
import sdk.pendo.io.y6.s;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f1447a = false;
    private static final Object b = new Object();
    private static Context c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static final long h;
    private static final long i;
    private static volatile String j;
    private static final sdk.pendo.io.w6.a<GetAuthToken.GetAuthTokenResponse> k;
    private static final b<EnumC0213a> l;
    private static z m;
    private static HttpLoggingInterceptor n;
    private static Uri o;
    private static s.b p;
    private static Map<String, s.b> q;
    public static sdk.pendo.io.q8.a r;
    private static final w s;
    private static final w t;

    /* renamed from: sdk.pendo.io.network.interfaces.a$a, reason: collision with other inner class name */
    public enum EnumC0213a {
        SUCCESS,
        FAILED
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        h = timeUnit.toMillis(15L);
        i = timeUnit.toMillis(15L);
        k = sdk.pendo.io.w6.a.n();
        l = b.n();
        m = null;
        q = new HashMap();
        s = new w() { // from class: sdk.pendo.io.network.interfaces.a$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.w2.w
            public final d0 a(w.a aVar) {
                d0 a2;
                a2 = a.a(aVar);
                return a2;
            }
        };
        t = new w() { // from class: sdk.pendo.io.network.interfaces.a$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.w2.w
            public final d0 a(w.a aVar) {
                d0 b2;
                b2 = a.b(aVar);
                return b2;
            }
        };
    }

    public static void a(b0.a aVar) {
        String str = d;
        if (str != null) {
            aVar.a("X-Pendo-App-Key", str);
        }
    }

    private static void b(b0.a aVar) {
        f(aVar);
        aVar.a("X-Pendo-Device-Time", Long.toString(System.currentTimeMillis()));
        aVar.a("X-Pendo-OS", AndroidContextProvider.OS_NAME);
        aVar.a("X-Pendo-Request-Id", sdk.pendo.io.g9.d0.INSTANCE.a(16));
        aVar.a("X-Pendo-Session-Id", d.INSTANCE.d());
        String a2 = i0.a();
        if (a2 != null) {
            aVar.a("X-Pendo-SDK-Ver", a2);
        }
        String g2 = AndroidUtils.g();
        if (g2 != null) {
            aVar.a("X-Pendo-Device-ID", g2);
        } else {
            PendoLogger.w("device id is null!", new Object[0]);
        }
        String d2 = AndroidUtils.d();
        if (d2 != null) {
            aVar.a("X-Pendo-App-Ver", d2);
        }
        aVar.a("X-Pendo-App-Ver-Code", String.valueOf(AndroidUtils.c()));
        String str = AndroidUtils.OS_VERSION;
        if (str != null) {
            aVar.a("X-Pendo-OS-Version", str);
        }
        aVar.a("X-Pendo-Deployment-Target", Integer.toString(AndroidUtils.e()));
        aVar.a("X-Pendo-Target-Version", Integer.toString(AndroidUtils.f()));
        e(aVar);
        c(aVar);
    }

    public static void c(b0.a aVar) {
        String str = e;
        if (str != null) {
            aVar.a("X-Pendo-Framework", str);
        }
        String str2 = f;
        if (str2 != null) {
            aVar.a("X-Pendo-Framework-Type", str2);
        }
        String str3 = g;
        if (str3 != null) {
            aVar.a("X-Pendo-Framework-Version", str3);
        }
    }

    private static void d(b0.a aVar) {
        SessionData y = PendoInternal.y();
        IdentifyData identifyData = y != null ? y.getIdentifyData() : null;
        if (identifyData != null) {
            aVar.a("X-Pendo-Encoded-Old-Visitor-ID", AndroidUtils.a(identifyData.getOldAnonymousVisitor()));
        }
    }

    private static void e(b0.a aVar) {
        if (f1447a) {
            aVar.a("X-Pendo-Redirect", Integer.toString(1));
        }
    }

    private static void f(b0.a aVar) {
        b0 a2 = aVar.a();
        if (TextUtils.isEmpty(a2.a("X-Pendo-JWT")) || TextUtils.isEmpty(a2.a("X-Pendo-SigningKeyName"))) {
            String r2 = PendoInternal.r();
            String A = PendoInternal.A();
            if (PendoInternal.L()) {
                aVar.a("X-Pendo-JWT", r2);
                aVar.a("X-Pendo-SigningKeyName", A);
                return;
            }
            String D = PendoInternal.D();
            String k2 = PendoInternal.k();
            if (!TextUtils.isEmpty(D)) {
                aVar.a("X-Pendo-Encoded-Visitor-Id", AndroidUtils.a(D));
            }
            if (TextUtils.isEmpty(k2)) {
                return;
            }
            aVar.a("X-Pendo-Encoded-Account-Id", AndroidUtils.a(k2));
        }
    }

    public static Uri g() {
        Uri a2;
        Uri uri = o;
        if (uri != null) {
            return uri;
        }
        synchronized (b) {
            a2 = y.f1148a.a();
            o = a2;
        }
        return a2;
    }

    public static s.b h() {
        return a(false, g(), false, false);
    }

    public static j<EnumC0213a> i() {
        return l;
    }

    public static HttpLoggingInterceptor.a j() {
        return PendoInternal.I() ? HttpLoggingInterceptor.a.BODY : HttpLoggingInterceptor.a.NONE;
    }

    public static HttpLoggingInterceptor k() {
        return n;
    }

    public static z.a l() {
        if (m == null) {
            try {
                m = new z();
            } catch (AssertionError e2) {
                PendoLogger.e(e2, "Pendo was NOT initialized, this exception is probably caused by a race condition in the host app changing the security provider" + e2.getMessage(), new Object[0]);
                return null;
            }
        }
        z.a y = m.y();
        sdk.pendo.io.b.a aVar = new sdk.pendo.io.b.a();
        aVar.a(new sdk.pendo.io.b.b() { // from class: sdk.pendo.io.network.interfaces.a$$ExternalSyntheticLambda2
            @Override // sdk.pendo.io.b.b
            public final void a(String str, e eVar) {
                a.a(str, eVar);
            }
        });
        y.b(aVar.a());
        if (n == null) {
            n = new HttpLoggingInterceptor();
        }
        n.a(j());
        y.a(n);
        return y;
    }

    public static s m() {
        s.b a2 = a(true, g(), true);
        if (a2 != null) {
            return a2.a();
        }
        return null;
    }

    public static s n() {
        s.b a2 = a(false, g());
        if (a2 != null) {
            return a2.a();
        }
        return null;
    }

    public static sdk.pendo.io.q8.a o() {
        sdk.pendo.io.q8.a aVar = r;
        if (aVar != null) {
            return aVar;
        }
        s.b h2 = h();
        s a2 = h2 != null ? h2.a() : null;
        if (a2 == null) {
            return null;
        }
        sdk.pendo.io.q8.a aVar2 = (sdk.pendo.io.q8.a) a2.a(sdk.pendo.io.q8.a.class);
        r = aVar2;
        return aVar2;
    }

    public static s p() {
        return a(PendoGsonConverterFactory.create(new external.sdk.pendo.io.gson.a().b().a()));
    }

    public static s.b q() {
        return a(false, g());
    }

    private static void a(z.a aVar) {
        if (sdk.pendo.io.k9.a.INSTANCE.a().a(c)) {
            aVar.a(new sdk.pendo.io.r8.a());
        }
    }

    public static String b() {
        return j;
    }

    public static j<GetAuthToken.GetAuthTokenResponse> c() {
        return k;
    }

    public static s d() {
        s.b e2 = e();
        if (e2 == null) {
            return null;
        }
        return e2.a();
    }

    private static s.b e() {
        return a(false, g());
    }

    public static z f() {
        z.a l2 = l();
        if (l2 == null) {
            return null;
        }
        return l2.a();
    }

    public static void a() {
        o = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ d0 b(w.a aVar) {
        b0.a h2 = aVar.a().h();
        b(h2);
        a(h2);
        return aVar.a(h2.a());
    }

    public static void a(EnumC0213a enumC0213a) {
        l.onNext(enumC0213a);
    }

    public static void a(Boolean bool) {
        f1447a = bool.booleanValue();
    }

    public static s.b a(boolean z, Uri uri) {
        return a(z, uri, false);
    }

    public static synchronized s.b a(boolean z, Uri uri, boolean z2) {
        s.b a2;
        synchronized (a.class) {
            a2 = a(z, uri, z2, true);
        }
        return a2;
    }

    public static synchronized s.b a(boolean z, Uri uri, boolean z2, boolean z3) {
        w wVar;
        synchronized (a.class) {
            if (uri == null) {
                return null;
            }
            String host = uri.getHost();
            String uri2 = uri.toString();
            z.a l2 = l();
            if (l2 == null) {
                return null;
            }
            if (z) {
                s.b bVar = p;
                if (bVar != null && !z2) {
                    return bVar;
                }
                wVar = t;
            } else {
                s.b bVar2 = q.get(host);
                if (bVar2 != null && !z2) {
                    return bVar2.a(uri2);
                }
                wVar = s;
            }
            l2.a(wVar);
            s.b bVar3 = new s.b();
            a(l2);
            long j2 = h;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            l2.a(j2, timeUnit);
            l2.b(i, timeUnit);
            bVar3.a(l2.a()).a(PendoGsonConverterFactory.create());
            if (z3) {
                bVar3.a(g.a());
            }
            bVar3.a(uri2);
            a(z, bVar3, host);
            return bVar3;
        }
    }

    public static s a(PendoGsonConverterFactory pendoGsonConverterFactory) {
        s.b a2 = a(false, g(), true);
        if (a2 != null) {
            return a2.a(pendoGsonConverterFactory).a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, e eVar) {
        PendoLogger.d("CT RESULT", "host: " + str + " VerificationResult: " + eVar.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ d0 a(w.a aVar) {
        b0.a h2 = aVar.a().h();
        b(h2);
        if (t.b(aVar.a().i())) {
            a(h2);
        } else {
            String b2 = b();
            if (b2 != null) {
                h2.a("Authorization", IterableConstants.HEADER_SDK_AUTH_FORMAT + b2);
            }
            if (t.a(aVar.a().i())) {
                d(h2);
            }
        }
        return aVar.a(h2.a());
    }

    public static void a(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
        j = getAuthTokenResponse.accessToken;
        k.onNext(getAuthTokenResponse);
    }

    public static void a(String str) {
        d = str;
    }

    public static void a(Context context) {
        c = context;
    }

    public static void a(String str, String str2, String str3) {
        e = str;
        f = str2;
        g = str3;
    }

    public static void a(boolean z) {
        HttpLoggingInterceptor k2 = k();
        if (k2 != null) {
            k2.a(z ? HttpLoggingInterceptor.a.BODY : HttpLoggingInterceptor.a.NONE);
        }
    }

    private static void a(boolean z, s.b bVar, String str) {
        if (z) {
            if (p == null) {
                p = bVar;
            }
        } else {
            if (q.containsKey(str)) {
                return;
            }
            q.put(str, bVar);
        }
    }
}
