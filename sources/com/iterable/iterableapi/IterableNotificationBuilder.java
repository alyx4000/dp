package com.iterable.iterableapi;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import com.iterable.iterableapi.IterableNotificationData;

/* loaded from: classes5.dex */
public class IterableNotificationBuilder extends NotificationCompat.Builder {
    static final String TAG = "IterableNotification";
    final Context context;
    private String expandedContent;
    private String imageUrl;
    private boolean isGhostPush;
    IterableNotificationData iterableNotificationData;
    int requestCode;

    protected IterableNotificationBuilder(Context context, String str) {
        super(context, str);
        this.context = context;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setExpandedContent(String str) {
        this.expandedContent = str;
    }

    public void setIsGhostPush(boolean z) {
        this.isGhostPush = z;
    }

    public boolean isGhostPush() {
        return this.isGhostPush;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x006f  */
    @Override // androidx.core.app.NotificationCompat.Builder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.app.Notification build() {
        /*
            r5 = this;
            java.lang.String r0 = "IterableNotification"
            java.lang.String r1 = "Notification image could not be loaded from url: "
            java.lang.String r2 = r5.imageUrl
            r3 = 0
            if (r2 == 0) goto L6d
            java.net.URL r2 = new java.net.URL     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            java.lang.String r4 = r5.imageUrl     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            r2.<init>(r4)     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            java.net.URLConnection r2 = r2.openConnection()     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            r4 = 1
            r2.setDoInput(r4)     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            r2.connect()     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            if (r2 == 0) goto L49
            androidx.core.app.NotificationCompat$BigPictureStyle r1 = new androidx.core.app.NotificationCompat$BigPictureStyle     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            r1.<init>()     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            androidx.core.app.NotificationCompat$BigPictureStyle r1 = r1.bigPicture(r2)     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            androidx.core.app.NotificationCompat$BigPictureStyle r1 = r1.bigLargeIcon(r3)     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            java.lang.String r4 = r5.expandedContent     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            androidx.core.app.NotificationCompat$BigPictureStyle r1 = r1.setSummaryText(r4)     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            r5.setLargeIcon(r2)     // Catch: java.io.IOException -> L43 java.net.MalformedURLException -> L46
            r3 = r1
            goto L6d
        L43:
            r2 = move-exception
            r3 = r1
            goto L5d
        L46:
            r2 = move-exception
            r3 = r1
            goto L66
        L49:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            r2.<init>(r1)     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            java.lang.String r1 = r5.imageUrl     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            java.lang.String r1 = r1.toString()     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            com.iterable.iterableapi.IterableLogger.e(r0, r1)     // Catch: java.io.IOException -> L5c java.net.MalformedURLException -> L65
            goto L6d
        L5c:
            r2 = move-exception
        L5d:
            java.lang.String r1 = r2.toString()
            com.iterable.iterableapi.IterableLogger.e(r0, r1)
            goto L6d
        L65:
            r2 = move-exception
        L66:
            java.lang.String r1 = r2.toString()
            com.iterable.iterableapi.IterableLogger.e(r0, r1)
        L6d:
            if (r3 != 0) goto L7a
            androidx.core.app.NotificationCompat$BigTextStyle r0 = new androidx.core.app.NotificationCompat$BigTextStyle
            r0.<init>()
            java.lang.String r1 = r5.expandedContent
            androidx.core.app.NotificationCompat$BigTextStyle r3 = r0.bigText(r1)
        L7a:
            r5.setStyle(r3)
            android.app.Notification r0 = super.build()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iterable.iterableapi.IterableNotificationBuilder.build():android.app.Notification");
    }

    public void createNotificationActionButton(Context context, IterableNotificationData.Button button, Bundle bundle) {
        NotificationCompat.Action.Builder builder = new NotificationCompat.Action.Builder(0, button.title, getPendingIntent(context, button, bundle));
        if (button.buttonType.equals(IterableNotificationData.Button.BUTTON_TYPE_TEXT_INPUT)) {
            builder.addRemoteInput(new RemoteInput.Builder(IterableConstants.USER_INPUT).setLabel(button.inputPlaceholder).build());
        }
        addAction(builder.build());
    }

    private PendingIntent getPendingIntent(Context context, IterableNotificationData.Button button, Bundle bundle) {
        Intent intent = new Intent(IterableConstants.ACTION_PUSH_ACTION);
        intent.putExtras(bundle);
        intent.putExtra(IterableConstants.REQUEST_CODE, this.requestCode);
        intent.putExtra("actionIdentifier", button.identifier);
        intent.putExtra("actionIdentifier", button.identifier);
        if (button.openApp) {
            IterableLogger.d(TAG, "Go through TrampolineActivity");
            intent.setClass(context, IterableTrampolineActivity.class);
            intent.setFlags(268468224);
            return PendingIntent.getActivity(context, intent.hashCode(), intent, 201326592);
        }
        IterableLogger.d(TAG, "Go through IterablePushActionReceiver");
        intent.setClass(context, IterablePushActionReceiver.class);
        return PendingIntent.getBroadcast(context, intent.hashCode(), intent, 201326592);
    }

    public static IterableNotificationBuilder createNotification(Context context, Bundle bundle) {
        return IterableNotificationHelper.createNotification(context, bundle);
    }

    public static void postNotificationOnDevice(Context context, IterableNotificationBuilder iterableNotificationBuilder) {
        IterableNotificationHelper.postNotificationOnDevice(context, iterableNotificationBuilder);
    }
}
