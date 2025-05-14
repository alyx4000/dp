package expo.modules.notifications.notifications;

import expo.modules.core.interfaces.SingletonModule;
import expo.modules.notifications.notifications.interfaces.NotificationListener;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationResponse;
import expo.modules.notifications.service.delegates.ExpoHandlingDelegate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class NotificationManager implements SingletonModule, expo.modules.notifications.notifications.interfaces.NotificationManager {
    private static final String SINGLETON_NAME = "NotificationManager";
    private Collection<NotificationResponse> mPendingNotificationResponses = new ArrayList();
    private WeakHashMap<NotificationListener, WeakReference<NotificationListener>> mListenerReferenceMap = new WeakHashMap<>();

    @Override // expo.modules.core.interfaces.SingletonModule
    public String getName() {
        return SINGLETON_NAME;
    }

    public NotificationManager() {
        ExpoHandlingDelegate.INSTANCE.addListener(this);
    }

    @Override // expo.modules.notifications.notifications.interfaces.NotificationManager
    public void addListener(NotificationListener notificationListener) {
        if (this.mListenerReferenceMap.containsKey(notificationListener)) {
            return;
        }
        this.mListenerReferenceMap.put(notificationListener, new WeakReference<>(notificationListener));
        if (this.mPendingNotificationResponses.isEmpty()) {
            return;
        }
        Iterator<NotificationResponse> it = this.mPendingNotificationResponses.iterator();
        while (it.hasNext()) {
            notificationListener.onNotificationResponseReceived(it.next());
        }
    }

    @Override // expo.modules.notifications.notifications.interfaces.NotificationManager
    public void removeListener(NotificationListener notificationListener) {
        this.mListenerReferenceMap.remove(notificationListener);
    }

    public void onNotificationReceived(Notification notification) {
        Iterator<WeakReference<NotificationListener>> it = this.mListenerReferenceMap.values().iterator();
        while (it.hasNext()) {
            NotificationListener notificationListener = it.next().get();
            if (notificationListener != null) {
                notificationListener.onNotificationReceived(notification);
            }
        }
    }

    public void onNotificationResponseReceived(NotificationResponse notificationResponse) {
        if (this.mListenerReferenceMap.isEmpty()) {
            this.mPendingNotificationResponses.add(notificationResponse);
            return;
        }
        Iterator<WeakReference<NotificationListener>> it = this.mListenerReferenceMap.values().iterator();
        while (it.hasNext()) {
            NotificationListener notificationListener = it.next().get();
            if (notificationListener != null) {
                notificationListener.onNotificationResponseReceived(notificationResponse);
            }
        }
    }

    public void onNotificationsDropped() {
        Iterator<WeakReference<NotificationListener>> it = this.mListenerReferenceMap.values().iterator();
        while (it.hasNext()) {
            NotificationListener notificationListener = it.next().get();
            if (notificationListener != null) {
                notificationListener.onNotificationsDropped();
            }
        }
    }
}
