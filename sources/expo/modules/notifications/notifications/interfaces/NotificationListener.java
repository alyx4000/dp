package expo.modules.notifications.notifications.interfaces;

import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationResponse;

/* loaded from: classes2.dex */
public interface NotificationListener {
    default void onNotificationReceived(Notification notification) {
    }

    default boolean onNotificationResponseReceived(NotificationResponse notificationResponse) {
        return false;
    }

    default void onNotificationsDropped() {
    }
}
