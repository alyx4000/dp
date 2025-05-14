package expo.modules.notifications.notifications.presentation.builders;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import expo.modules.notifications.R;
import expo.modules.notifications.notifications.channels.managers.AndroidXNotificationsChannelGroupManager;
import expo.modules.notifications.notifications.channels.managers.AndroidXNotificationsChannelManager;
import expo.modules.notifications.notifications.channels.managers.NotificationsChannelManager;
import expo.modules.notifications.notifications.interfaces.NotificationTrigger;
import expo.modules.notifications.notifications.model.NotificationRequest;
import expo.modules.notifications.service.NotificationsService;

/* loaded from: classes2.dex */
public abstract class ChannelAwareNotificationBuilder extends BaseNotificationBuilder {
    private static final String FALLBACK_CHANNEL_ID = "expo_notifications_fallback_notification_channel";
    private static final int FALLBACK_CHANNEL_IMPORTANCE = 4;

    public ChannelAwareNotificationBuilder(Context context) {
        super(context);
    }

    protected NotificationCompat.Builder createBuilder() {
        return new NotificationCompat.Builder(getContext(), getChannelId());
    }

    protected String getChannelId() {
        NotificationTrigger trigger = getTrigger();
        if (trigger == null) {
            Log.e(NotificationsService.NOTIFICATIONS_KEY, String.format("Couldn't get channel for the notifications - trigger is 'null'. Fallback to '%s' channel", FALLBACK_CHANNEL_ID));
            return getFallbackNotificationChannel().getId();
        }
        String notificationChannel = trigger.getNotificationChannel();
        if (notificationChannel == null) {
            return getFallbackNotificationChannel().getId();
        }
        NotificationChannel notificationChannel2 = getNotificationsChannelManager().getNotificationChannel(notificationChannel);
        if (notificationChannel2 == null) {
            Log.e(NotificationsService.NOTIFICATIONS_KEY, String.format("Channel '%s' doesn't exists. Fallback to '%s' channel", notificationChannel, FALLBACK_CHANNEL_ID));
            return getFallbackNotificationChannel().getId();
        }
        return notificationChannel2.getId();
    }

    protected NotificationsChannelManager getNotificationsChannelManager() {
        return new AndroidXNotificationsChannelManager(getContext(), new AndroidXNotificationsChannelGroupManager(getContext()));
    }

    public NotificationChannel getFallbackNotificationChannel() {
        NotificationChannel notificationChannel = getNotificationManager().getNotificationChannel(FALLBACK_CHANNEL_ID);
        return notificationChannel != null ? notificationChannel : createFallbackChannel();
    }

    protected NotificationChannel createFallbackChannel() {
        NotificationChannel notificationChannel = new NotificationChannel(FALLBACK_CHANNEL_ID, getFallbackChannelName(), 4);
        notificationChannel.setShowBadge(true);
        notificationChannel.enableVibration(true);
        getNotificationManager().createNotificationChannel(notificationChannel);
        return notificationChannel;
    }

    protected String getFallbackChannelName() {
        return getContext().getString(R.string.expo_notifications_fallback_channel_name);
    }

    private NotificationManager getNotificationManager() {
        return (NotificationManager) getContext().getSystemService(NotificationsService.NOTIFICATION_KEY);
    }

    private NotificationTrigger getTrigger() {
        NotificationRequest notificationRequest = getNotification().getNotificationRequest();
        if (notificationRequest == null) {
            return null;
        }
        return notificationRequest.getTrigger();
    }
}
