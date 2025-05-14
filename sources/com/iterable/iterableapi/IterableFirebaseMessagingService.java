package com.iterable.iterableapi;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* loaded from: classes5.dex */
public class IterableFirebaseMessagingService extends FirebaseMessagingService {
    static final String TAG = "itblFCMMessagingService";

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        handleMessageReceived(this, remoteMessage);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        handleTokenRefresh();
    }

    public static boolean handleMessageReceived(Context context, RemoteMessage remoteMessage) {
        String string;
        Map<String, String> data = remoteMessage.getData();
        if (data == null || data.size() == 0) {
            return false;
        }
        IterableLogger.d(TAG, "Message data payload: " + remoteMessage.getData());
        if (remoteMessage.getNotification() != null) {
            IterableLogger.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }
        Bundle mapToBundle = IterableNotificationHelper.mapToBundle(data);
        if (!IterableNotificationHelper.isIterablePush(mapToBundle)) {
            IterableLogger.d(TAG, "Not an Iterable push message");
            return false;
        }
        if (!IterableNotificationHelper.isGhostPush(mapToBundle)) {
            if (!IterableNotificationHelper.isEmptyBody(mapToBundle)) {
                IterableLogger.d(TAG, "Iterable push received " + data);
                new IterableNotificationManager().execute(IterableNotificationHelper.createNotification(context.getApplicationContext(), mapToBundle));
            } else {
                IterableLogger.d(TAG, "Iterable OS notification push received");
            }
        } else {
            IterableLogger.d(TAG, "Iterable ghost silent push received");
            String string2 = mapToBundle.getString("notificationType");
            if (string2 != null && IterableApi.getInstance().getMainActivityContext() != null) {
                if (string2.equals("InAppUpdate")) {
                    IterableApi.getInstance().getInAppManager().syncInApp();
                } else if (string2.equals("InAppRemove") && (string = mapToBundle.getString(IterableConstants.KEY_MESSAGE_ID)) != null) {
                    IterableApi.getInstance().getInAppManager().removeMessage(string);
                }
            }
        }
        return true;
    }

    public static void handleTokenRefresh() {
        IterableLogger.d(TAG, "New Firebase Token generated: " + getFirebaseToken());
        IterableApi.getInstance().registerForPush();
    }

    public static String getFirebaseToken() {
        try {
            return (String) Tasks.await(FirebaseMessaging.getInstance().getToken());
        } catch (InterruptedException e) {
            IterableLogger.e(TAG, e.getLocalizedMessage());
            return null;
        } catch (ExecutionException e2) {
            IterableLogger.e(TAG, e2.getLocalizedMessage());
            return null;
        } catch (Exception unused) {
            IterableLogger.e(TAG, "Failed to fetch firebase token");
            return null;
        }
    }

    public static boolean isGhostPush(RemoteMessage remoteMessage) {
        Map<String, String> data = remoteMessage.getData();
        if (data == null || data.isEmpty()) {
            return false;
        }
        return IterableNotificationHelper.isGhostPush(IterableNotificationHelper.mapToBundle(data));
    }
}
