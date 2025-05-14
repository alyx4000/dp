package com.iterable.iterableapi;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import expo.modules.notifications.service.NotificationsService;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class IterablePushNotificationUtil {
    private static final String TAG = "IterablePushNotificationUtil";
    private static PendingAction pendingAction;

    IterablePushNotificationUtil() {
    }

    static boolean processPendingAction(Context context) {
        PendingAction pendingAction2 = pendingAction;
        if (pendingAction2 == null) {
            return false;
        }
        boolean executeAction = executeAction(context, pendingAction2);
        pendingAction = null;
        return executeAction;
    }

    static boolean executeAction(Context context, PendingAction pendingAction2) {
        IterableApi.sharedInstance.setPayloadData(pendingAction2.intent);
        IterableApi.sharedInstance.setNotificationData(pendingAction2.notificationData);
        IterableApi.sharedInstance.trackPushOpen(pendingAction2.notificationData.getCampaignId(), pendingAction2.notificationData.getTemplateId(), pendingAction2.notificationData.getMessageId(), pendingAction2.dataFields);
        return IterableActionRunner.executeAction(context, pendingAction2.iterableAction, IterableActionSource.PUSH);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void handlePushAction(android.content.Context r9, android.content.Intent r10) {
        /*
            java.lang.String r0 = "default"
            android.os.Bundle r1 = r10.getExtras()
            java.lang.String r2 = "IterablePushNotificationUtil"
            if (r1 != 0) goto L10
            java.lang.String r9 = "handlePushAction: extras == null, can't handle push action"
            com.iterable.iterableapi.IterableLogger.e(r2, r9)
            return
        L10:
            com.iterable.iterableapi.IterableNotificationData r5 = new com.iterable.iterableapi.IterableNotificationData
            android.os.Bundle r1 = r10.getExtras()
            r5.<init>(r1)
            java.lang.String r1 = "actionIdentifier"
            java.lang.String r3 = r10.getStringExtra(r1)
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            r4 = 0
            r6 = 1
            if (r3 == 0) goto L75
            boolean r7 = r3.equals(r0)     // Catch: org.json.JSONException -> L6f
            if (r7 == 0) goto L40
            r8.put(r1, r0)     // Catch: org.json.JSONException -> L6f
            com.iterable.iterableapi.IterableAction r4 = r5.getDefaultAction()     // Catch: org.json.JSONException -> L6f
            if (r4 != 0) goto L75
            android.os.Bundle r0 = r10.getExtras()     // Catch: org.json.JSONException -> L6f
            com.iterable.iterableapi.IterableAction r4 = getLegacyDefaultActionFromPayload(r0)     // Catch: org.json.JSONException -> L6f
            goto L75
        L40:
            r8.put(r1, r3)     // Catch: org.json.JSONException -> L6f
            com.iterable.iterableapi.IterableNotificationData$Button r0 = r5.getActionButton(r3)     // Catch: org.json.JSONException -> L6f
            com.iterable.iterableapi.IterableAction r4 = r0.action     // Catch: org.json.JSONException -> L6f
            boolean r1 = r0.openApp     // Catch: org.json.JSONException -> L6f
            java.lang.String r0 = r0.buttonType     // Catch: org.json.JSONException -> L6c
            java.lang.String r3 = "textInput"
            boolean r0 = r0.equals(r3)     // Catch: org.json.JSONException -> L6c
            if (r0 == 0) goto L6a
            android.os.Bundle r0 = androidx.core.app.RemoteInput.getResultsFromIntent(r10)     // Catch: org.json.JSONException -> L6c
            if (r0 == 0) goto L6a
            java.lang.String r3 = "userInput"
            java.lang.String r0 = r0.getString(r3)     // Catch: org.json.JSONException -> L6c
            if (r0 == 0) goto L6a
            java.lang.String r3 = "userText"
            r8.putOpt(r3, r0)     // Catch: org.json.JSONException -> L6c
            r4.userInput = r0     // Catch: org.json.JSONException -> L6c
        L6a:
            r6 = r1
            goto L75
        L6c:
            r0 = move-exception
            r6 = r1
            goto L70
        L6f:
            r0 = move-exception
        L70:
            java.lang.String r1 = "Encountered an exception while trying to handle the push action"
            com.iterable.iterableapi.IterableLogger.e(r2, r1, r0)
        L75:
            r0 = r6
            r6 = r4
            com.iterable.iterableapi.IterablePushNotificationUtil$PendingAction r1 = new com.iterable.iterableapi.IterablePushNotificationUtil$PendingAction
            r3 = r1
            r4 = r10
            r7 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            com.iterable.iterableapi.IterablePushNotificationUtil.pendingAction = r1
            com.iterable.iterableapi.IterableApi r10 = com.iterable.iterableapi.IterableApi.getInstance()
            android.content.Context r10 = r10.getMainActivityContext()
            if (r10 == 0) goto L90
            boolean r10 = processPendingAction(r9)
            goto L91
        L90:
            r10 = 0
        L91:
            if (r0 == 0) goto Lab
            if (r10 != 0) goto Lab
            android.content.Intent r10 = com.iterable.iterableapi.IterableNotificationHelper.getMainActivityIntent(r9)
            r0 = 872415232(0x34000000, float:1.1920929E-7)
            r10.setFlags(r0)
            android.content.pm.PackageManager r0 = r9.getPackageManager()
            android.content.ComponentName r0 = r10.resolveActivity(r0)
            if (r0 == 0) goto Lab
            r9.startActivity(r10)
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iterable.iterableapi.IterablePushNotificationUtil.handlePushAction(android.content.Context, android.content.Intent):void");
    }

    private static IterableAction getLegacyDefaultActionFromPayload(Bundle bundle) {
        try {
            if (!bundle.containsKey("uri")) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", IterableAction.ACTION_TYPE_OPEN_URL);
            jSONObject.put("data", bundle.getString("uri"));
            return IterableAction.from(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class PendingAction {
        JSONObject dataFields;
        Intent intent;
        IterableAction iterableAction;
        IterableNotificationData notificationData;
        boolean openApp;

        PendingAction(Intent intent, IterableNotificationData iterableNotificationData, IterableAction iterableAction, boolean z, JSONObject jSONObject) {
            this.intent = intent;
            this.notificationData = iterableNotificationData;
            this.iterableAction = iterableAction;
            this.openApp = z;
            this.dataFields = jSONObject;
        }
    }

    static void dismissNotificationPanel(Context context) {
        try {
            context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        } catch (SecurityException e) {
            IterableLogger.w(TAG, e.getLocalizedMessage());
        }
    }

    static void dismissNotification(Context context, Intent intent) {
        ((NotificationManager) context.getSystemService(NotificationsService.NOTIFICATION_KEY)).cancel(intent.getIntExtra(IterableConstants.REQUEST_CODE, 0));
    }
}
