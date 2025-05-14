package external.sdk.pendo.io.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;
import external.sdk.pendo.io.glide.manager.ConnectivityMonitor;
import sdk.pendo.io.i0.j;

/* loaded from: classes2.dex */
final class b implements ConnectivityMonitor {

    /* renamed from: a, reason: collision with root package name */
    private final Context f707a;
    final ConnectivityMonitor.a b;
    boolean c;
    private boolean d;
    private final BroadcastReceiver e = new a();

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            b bVar = b.this;
            boolean z = bVar.c;
            bVar.c = bVar.a(context);
            if (z != b.this.c) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + b.this.c);
                }
                b bVar2 = b.this;
                bVar2.b.a(bVar2.c);
            }
        }
    }

    b(Context context, ConnectivityMonitor.a aVar) {
        this.f707a = context.getApplicationContext();
        this.b = aVar;
    }

    private void b() {
        if (this.d) {
            this.f707a.unregisterReceiver(this.e);
            this.d = false;
        }
    }

    boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) j.a((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
            }
            return true;
        }
    }

    @Override // external.sdk.pendo.io.glide.manager.ConnectivityMonitor, sdk.pendo.io.c0.i
    public void onDestroy() {
    }

    @Override // external.sdk.pendo.io.glide.manager.ConnectivityMonitor, sdk.pendo.io.c0.i
    public void onStart() {
        a();
    }

    @Override // external.sdk.pendo.io.glide.manager.ConnectivityMonitor, sdk.pendo.io.c0.i
    public void onStop() {
        b();
    }

    private void a() {
        if (this.d) {
            return;
        }
        this.c = a(this.f707a);
        try {
            this.f707a.registerReceiver(this.e, new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION));
            this.d = true;
        } catch (SecurityException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e);
            }
        }
    }
}
