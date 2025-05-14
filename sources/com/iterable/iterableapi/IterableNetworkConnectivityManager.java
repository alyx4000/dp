package com.iterable.iterableapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes5.dex */
class IterableNetworkConnectivityManager {
    private static final String TAG = "NetworkConnectivityManager";
    private static IterableNetworkConnectivityManager sharedInstance;
    private boolean isConnected;
    private ArrayList<IterableNetworkMonitorListener> networkMonitorListeners = new ArrayList<>();

    public interface IterableNetworkMonitorListener {
        void onNetworkConnected();

        void onNetworkDisconnected();
    }

    static IterableNetworkConnectivityManager sharedInstance(Context context) {
        if (sharedInstance == null) {
            sharedInstance = new IterableNetworkConnectivityManager(context);
        }
        return sharedInstance;
    }

    private IterableNetworkConnectivityManager(Context context) {
        if (context == null) {
            return;
        }
        startNetworkCallback(context);
    }

    private void startNetworkCallback(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        if (connectivityManager != null) {
            connectivityManager.registerNetworkCallback(builder.build(), new ConnectivityManager.NetworkCallback() { // from class: com.iterable.iterableapi.IterableNetworkConnectivityManager.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    IterableLogger.v(IterableNetworkConnectivityManager.TAG, "Network Connected");
                    IterableNetworkConnectivityManager.this.isConnected = true;
                    Iterator it = new ArrayList(IterableNetworkConnectivityManager.this.networkMonitorListeners).iterator();
                    while (it.hasNext()) {
                        ((IterableNetworkMonitorListener) it.next()).onNetworkConnected();
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    super.onLost(network);
                    IterableLogger.v(IterableNetworkConnectivityManager.TAG, "Network Disconnected");
                    IterableNetworkConnectivityManager.this.isConnected = false;
                    Iterator it = new ArrayList(IterableNetworkConnectivityManager.this.networkMonitorListeners).iterator();
                    while (it.hasNext()) {
                        ((IterableNetworkMonitorListener) it.next()).onNetworkDisconnected();
                    }
                }
            });
        }
    }

    synchronized void addNetworkListener(IterableNetworkMonitorListener iterableNetworkMonitorListener) {
        this.networkMonitorListeners.add(iterableNetworkMonitorListener);
    }

    synchronized void removeNetworkListener(IterableNetworkMonitorListener iterableNetworkMonitorListener) {
        this.networkMonitorListeners.remove(iterableNetworkMonitorListener);
    }

    boolean isConnected() {
        return this.isConnected;
    }
}
