package sdk.pendo.io.g9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.utilities.AndroidUtils;

/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static BroadcastReceiver f1129a;
    private static sdk.pendo.io.w6.b<Boolean> b = sdk.pendo.io.w6.b.n();

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            sdk.pendo.io.w6.b bVar;
            if (!f.a() || (bVar = f.b) == null) {
                return;
            }
            bVar.onNext(Boolean.TRUE);
        }
    }

    class b implements sdk.pendo.io.d6.j<Boolean> {
        b() {
        }

        @Override // sdk.pendo.io.d6.j
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(Boolean bool) {
            return bool.booleanValue();
        }
    }

    private static NetworkInfo a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static synchronized void b(Context context) {
        synchronized (f.class) {
            if (f1129a == null) {
                f1129a = new a();
                context.registerReceiver(f1129a, new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION));
            }
        }
    }

    public static synchronized void c(Context context) {
        synchronized (f.class) {
            BroadcastReceiver broadcastReceiver = f1129a;
            if (broadcastReceiver != null) {
                try {
                    context.unregisterReceiver(broadcastReceiver);
                } catch (Exception unused) {
                    PendoLogger.i("ConnectivityUtils -> trying to unregister not registered receiver", new Object[0]);
                }
                f1129a = null;
            }
        }
    }

    public static boolean a() {
        if (!AndroidUtils.b("android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo a2 = a(PendoInternal.m());
        return a2 != null && a2.isConnected();
    }

    public static sdk.pendo.io.b6.b a(sdk.pendo.io.d6.e<Boolean> eVar) {
        return b.a(new b()).b(sdk.pendo.io.v6.a.b()).a(sdk.pendo.io.v6.a.b()).a(eVar, new sdk.pendo.io.a9.a("ConnectivityUtils connection error consumer"));
    }
}
