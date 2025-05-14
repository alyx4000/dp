package expo.modules.notifications;

import android.content.Context;
import expo.modules.core.BasePackage;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.SingletonModule;
import expo.modules.notifications.notifications.NotificationManager;
import expo.modules.notifications.notifications.categories.serializers.ExpoNotificationsCategoriesSerializer;
import expo.modules.notifications.notifications.channels.AndroidXNotificationsChannelsProvider;
import expo.modules.notifications.tokens.PushTokenManager;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class NotificationsPackage extends BasePackage {
    @Override // expo.modules.core.BasePackage, expo.modules.core.interfaces.Package
    public List<SingletonModule> createSingletonModules(Context context) {
        return Arrays.asList(new PushTokenManager(), new NotificationManager());
    }

    @Override // expo.modules.core.BasePackage, expo.modules.core.interfaces.Package
    public List<InternalModule> createInternalModules(Context context) {
        return Arrays.asList(new AndroidXNotificationsChannelsProvider(context), new ExpoNotificationsCategoriesSerializer());
    }
}
