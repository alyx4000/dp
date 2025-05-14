package com.iterable.iterableapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes5.dex */
public class IterablePushActionReceiver extends BroadcastReceiver {
    private static final String TAG = "IterablePushActionReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IterablePushNotificationUtil.dismissNotification(context, intent);
        IterablePushNotificationUtil.dismissNotificationPanel(context);
        if (IterableConstants.ACTION_PUSH_ACTION.equalsIgnoreCase(intent.getAction())) {
            IterablePushNotificationUtil.handlePushAction(context, intent);
        }
    }
}
