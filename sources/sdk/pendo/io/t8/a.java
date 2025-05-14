package sdk.pendo.io.t8;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.function.BooleanSupplier;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.g9.h;
import sdk.pendo.io.g9.i0;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.network.responses.AuthTokenErrorResponse;
import sdk.pendo.io.network.responses.KillSwitchModel;
import sdk.pendo.io.network.responses.validators.JsonWebTokenValidator;
import sdk.pendo.io.utilities.AndroidUtils;
import sdk.pendo.io.w2.e0;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f1637a;
    private static Boolean b;
    private static volatile a c;
    private static int d;

    private a() {
    }

    private static boolean b() {
        Context m = PendoInternal.m();
        if (m != null) {
            String d2 = h.d(m, "host_app_version");
            String d3 = AndroidUtils.d();
            if (d2 == null) {
                h.a(m, d3.getBytes(Charset.forName("UTF-8")), "host_app_version");
            } else if (!d2.equals(d3)) {
                h.c(m, "host_app_version");
                h.c(m, "pendo_killswitch");
                h.a(m, d3.getBytes(Charset.forName("UTF-8")), "host_app_version");
                f1637a = Boolean.TRUE;
                return true;
            }
        }
        f1637a = Boolean.FALSE;
        return false;
    }

    private static boolean c() {
        Context m = PendoInternal.m();
        if (m != null) {
            String d2 = h.d(m, "pendo_killswitch");
            if (!TextUtils.isEmpty(d2)) {
                try {
                    if (a((AuthTokenErrorResponse) PendoInternal.l.a(JsonWebTokenValidator.INSTANCE.validate(d2), AuthTokenErrorResponse.class))) {
                        b = Boolean.TRUE;
                        return true;
                    }
                } catch (Exception unused) {
                }
                h.c(m, "pendo_killswitch");
            }
        }
        b = Boolean.FALSE;
        return false;
    }

    public static synchronized boolean d() {
        synchronized (a.class) {
            Boolean bool = f1637a;
            if (bool != null && bool.booleanValue()) {
                return false;
            }
            Boolean bool2 = b;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            if (b()) {
                return false;
            }
            return c();
        }
    }

    protected boolean a(BooleanSupplier booleanSupplier, int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        return booleanSupplier.getAsBoolean();
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (c == null) {
                c = new a();
            }
            aVar = c;
        }
        return aVar;
    }

    private static void b(AuthTokenErrorResponse authTokenErrorResponse) {
        if (authTokenErrorResponse.getKillSwitchModel() == null) {
            PendoLogger.d("Killswitch response does not contain kill property", new Object[0]);
            return;
        }
        Long expiration = authTokenErrorResponse.getKillSwitchModel().getExpiration();
        List<String> affectedVersions = authTokenErrorResponse.getKillSwitchModel().getAffectedVersions();
        PendoLogger.d("Got kill switch response:   errorId: " + authTokenErrorResponse.getErrorId() + " errorMessage: '" + authTokenErrorResponse.getErrorMessage() + " kill expiration: " + (expiration == null ? "never" : String.valueOf(expiration.longValue())), new Object[0]);
        if (affectedVersions != null) {
            Iterator<String> it = affectedVersions.iterator();
            while (it.hasNext()) {
                PendoLogger.d(" kill version: " + it.next(), new Object[0]);
            }
        }
    }

    public boolean a(e0 e0Var, BooleanSupplier booleanSupplier) {
        if (Looper.myLooper() == Looper.getMainLooper() || !(!a(e0Var)) || d >= 3) {
            return false;
        }
        PendoLogger.d("Got a Kill Switch with a body that doesn't apply here, retrying previous api request.", new Object[0]);
        boolean a2 = a(booleanSupplier, 3000);
        d++;
        return a2;
    }

    private static boolean a(KillSwitchModel killSwitchModel, String str) {
        if (killSwitchModel == null || killSwitchModel.isExpired() || !killSwitchModel.isCurrentSDKVersionAffected(str)) {
            PendoLogger.d("Kill Switch is OFF for this current SDK", new Object[0]);
            return false;
        }
        PendoLogger.d("Kill Switch is ON", new Object[0]);
        return true;
    }

    private static boolean a(AuthTokenErrorResponse authTokenErrorResponse) {
        b(authTokenErrorResponse);
        return a(authTokenErrorResponse.getKillSwitchModel(), i0.a());
    }

    public static boolean a(e0 e0Var) {
        PendoLogger.d("Test got kill switch http code", new Object[0]);
        try {
            String a2 = sdk.pendo.io.g9.a.f1122a.a(e0Var);
            AuthTokenErrorResponse authTokenErrorResponse = (AuthTokenErrorResponse) PendoInternal.l.a(JsonWebTokenValidator.INSTANCE.validate(a2), AuthTokenErrorResponse.class);
            a(a2);
            boolean a3 = a(authTokenErrorResponse);
            if (a3) {
                PendoInternal.g();
            }
            return a3;
        } catch (Exception e) {
            PendoLogger.d("Problem with kill switch handling" + e.getMessage(), new Object[0]);
            return false;
        }
    }

    private static synchronized void a(String str) {
        synchronized (a.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            h.a(PendoInternal.m(), str.getBytes(Charset.forName("UTF-8")), "pendo_killswitch");
            b = null;
        }
    }
}
