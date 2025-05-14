package com.iterable.iterableapi;

import android.util.Base64;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.iterable.iterableapi.util.Future;
import java.io.UnsupportedEncodingException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class IterableAuthManager {
    private static final String TAG = "IterableAuth";
    private static final String expirationString = "exp";
    private final IterableApi api;
    private final IterableAuthHandler authHandler;
    private final long expiringAuthTokenRefreshPeriod;
    private boolean hasFailedPriorAuth;
    private boolean pendingAuth;
    private boolean requiresAuthRefresh;
    Timer timer;

    IterableAuthManager(IterableApi iterableApi, IterableAuthHandler iterableAuthHandler, long j) {
        this.api = iterableApi;
        this.authHandler = iterableAuthHandler;
        this.expiringAuthTokenRefreshPeriod = j;
    }

    public synchronized void requestNewAuthToken(boolean z) {
        if (this.authHandler != null) {
            if (this.pendingAuth) {
                if (!z) {
                    this.requiresAuthRefresh = true;
                }
            } else if (!this.hasFailedPriorAuth || !z) {
                this.hasFailedPriorAuth = z;
                this.pendingAuth = true;
                Future.runAsync(new Callable<String>() { // from class: com.iterable.iterableapi.IterableAuthManager.3
                    @Override // java.util.concurrent.Callable
                    public String call() throws Exception {
                        return IterableAuthManager.this.authHandler.onAuthTokenRequested();
                    }
                }).onSuccess(new Future.SuccessCallback<String>() { // from class: com.iterable.iterableapi.IterableAuthManager.2
                    @Override // com.iterable.iterableapi.util.Future.SuccessCallback
                    public void onSuccess(String str) {
                        if (str != null) {
                            IterableAuthManager.this.queueExpirationRefresh(str);
                            IterableApi.getInstance().setAuthToken(str);
                            IterableAuthManager.this.pendingAuth = false;
                            IterableAuthManager.this.reSyncAuth();
                            IterableAuthManager.this.authHandler.onTokenRegistrationSuccessful(str);
                            return;
                        }
                        IterableLogger.w(IterableAuthManager.TAG, "Auth token received as null. Calling the handler in 10 seconds");
                        IterableAuthManager.this.scheduleAuthTokenRefresh(DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM);
                        IterableAuthManager.this.authHandler.onTokenRegistrationFailed(new Throwable("Auth token null"));
                    }
                }).onFailure(new Future.FailureCallback() { // from class: com.iterable.iterableapi.IterableAuthManager.1
                    @Override // com.iterable.iterableapi.util.Future.FailureCallback
                    public void onFailure(Throwable th) {
                        IterableLogger.e(IterableAuthManager.TAG, "Error while requesting Auth Token", th);
                        IterableAuthManager.this.authHandler.onTokenRegistrationFailed(th);
                        IterableAuthManager.this.pendingAuth = false;
                        IterableAuthManager.this.reSyncAuth();
                    }
                });
            }
        } else {
            IterableApi.getInstance().setAuthToken(null, true);
        }
    }

    public void queueExpirationRefresh(String str) {
        clearRefreshTimer();
        try {
            long decodedExpiration = ((decodedExpiration(str) * 1000) - this.expiringAuthTokenRefreshPeriod) - IterableUtil.currentTimeMillis();
            if (decodedExpiration > 0) {
                scheduleAuthTokenRefresh(decodedExpiration);
            } else {
                IterableLogger.w(TAG, "The expiringAuthTokenRefreshPeriod has already passed for the current JWT");
            }
        } catch (Exception e) {
            IterableLogger.e(TAG, "Error while parsing JWT for the expiration", e);
            this.authHandler.onTokenRegistrationFailed(new Throwable("Auth token decode failure. Scheduling auth token refresh in 10 seconds..."));
            scheduleAuthTokenRefresh(DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM);
        }
    }

    void resetFailedAuth() {
        this.hasFailedPriorAuth = false;
    }

    void reSyncAuth() {
        if (this.requiresAuthRefresh) {
            this.requiresAuthRefresh = false;
            requestNewAuthToken(false);
        }
    }

    void scheduleAuthTokenRefresh(long j) {
        Timer timer = new Timer(true);
        this.timer = timer;
        try {
            timer.schedule(new TimerTask() { // from class: com.iterable.iterableapi.IterableAuthManager.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    IterableAuthManager.this.api.getAuthManager().requestNewAuthToken(false);
                }
            }, j);
        } catch (Exception e) {
            IterableLogger.e(TAG, "timer exception: " + this.timer, e);
        }
    }

    private static long decodedExpiration(String str) throws Exception {
        return new JSONObject(getJson(str.split("\\.")[1])).getLong(expirationString);
    }

    private static String getJson(String str) throws UnsupportedEncodingException {
        return new String(Base64.decode(str, 8), "UTF-8");
    }

    void clearRefreshTimer() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }
}
