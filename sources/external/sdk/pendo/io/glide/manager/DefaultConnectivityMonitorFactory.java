package external.sdk.pendo.io.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.core.content.ContextCompat;
import external.sdk.pendo.io.glide.manager.ConnectivityMonitor;

/* loaded from: classes2.dex */
public class DefaultConnectivityMonitorFactory implements a {
    private static final String NETWORK_PERMISSION = "android.permission.ACCESS_NETWORK_STATE";
    private static final String TAG = "ConnectivityMonitor";

    @Override // external.sdk.pendo.io.glide.manager.a
    public ConnectivityMonitor build(Context context, ConnectivityMonitor.a aVar) {
        boolean z = ContextCompat.checkSelfPermission(context, NETWORK_PERMISSION) == 0;
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new b(context, aVar) : new c();
    }
}
