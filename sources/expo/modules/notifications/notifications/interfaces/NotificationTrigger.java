package expo.modules.notifications.notifications.interfaces;

import android.os.Parcelable;

/* loaded from: classes2.dex */
public interface NotificationTrigger extends Parcelable {
    default String getNotificationChannel() {
        return null;
    }
}
