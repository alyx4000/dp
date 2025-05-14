package com.iterable.iterableapi;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes5.dex */
public class IterableTrampolineActivity extends AppCompatActivity {
    private static final String TAG = "TrampolineActivity";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IterableLogger.v(TAG, "Notification Trampoline Activity created");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        IterableLogger.v(TAG, "Notification Trampoline Activity resumed");
        Intent intent = getIntent();
        if (intent == null) {
            IterableLogger.d(TAG, "Intent is null. Doing nothing.");
            finish();
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            IterableLogger.d(TAG, "Intent action is null. Doing nothing.");
            finish();
            return;
        }
        IterablePushNotificationUtil.dismissNotification(this, intent);
        IterablePushNotificationUtil.dismissNotificationPanel(this);
        if (IterableConstants.ACTION_PUSH_ACTION.equalsIgnoreCase(action)) {
            IterablePushNotificationUtil.handlePushAction(this, intent);
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        IterableLogger.v(TAG, "Notification Trampoline Activity on pause");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        IterableLogger.v(TAG, "Notification Trampoline Activity destroyed");
    }
}
