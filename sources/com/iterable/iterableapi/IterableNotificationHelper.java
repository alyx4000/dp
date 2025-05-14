package com.iterable.iterableapi;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import com.iterable.iterableapi.IterableNotificationData;
import expo.modules.notifications.service.NotificationsService;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class IterableNotificationHelper {
    private static final String DEFAULT_CHANNEL_NAME = "iterable channel";
    private static final String NO_BADGE = "_noBadge";
    static IterableNotificationHelperImpl instance = new IterableNotificationHelperImpl();

    IterableNotificationHelper() {
    }

    public static IterableNotificationBuilder createNotification(Context context, Bundle bundle) {
        return instance.createNotification(context, bundle);
    }

    public static void postNotificationOnDevice(Context context, IterableNotificationBuilder iterableNotificationBuilder) {
        instance.postNotificationOnDevice(context, iterableNotificationBuilder);
    }

    public static Intent getMainActivityIntent(Context context) {
        return instance.getMainActivityIntent(context);
    }

    static boolean isIterablePush(Bundle bundle) {
        return instance.isIterablePush(bundle);
    }

    static boolean isGhostPush(Bundle bundle) {
        return instance.isGhostPush(bundle);
    }

    static boolean isEmptyBody(Bundle bundle) {
        return instance.isEmptyBody(bundle);
    }

    static Bundle mapToBundle(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    static class IterableNotificationHelperImpl {
        IterableNotificationHelperImpl() {
        }

        public IterableNotificationBuilder createNotification(Context context, Bundle bundle) {
            String str;
            String currentChannelId;
            String str2;
            String obj = context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
            if (!bundle.containsKey(IterableConstants.ITERABLE_DATA_KEY)) {
                IterableLogger.w("IterableNotification", "Notification doesn't have an Iterable payload. Skipping.");
                return null;
            }
            if (isGhostPush(bundle)) {
                IterableLogger.w("IterableNotification", "Received a ghost push notification. Skipping.");
                return null;
            }
            String string = bundle.getString("title", obj);
            String string2 = bundle.getString("body");
            String string3 = bundle.getString("sound");
            if (string3 != null) {
                if (string3.contains("https")) {
                    str = string3;
                    string3 = string3.substring(string3.lastIndexOf(47) + 1);
                } else {
                    str = null;
                }
                string3 = string3.replaceFirst("[.][^.]+$", "");
            } else {
                str = null;
            }
            Uri soundUri = IterableNotificationHelper.getSoundUri(context, string3, str);
            String channelName = soundUri == Settings.System.DEFAULT_NOTIFICATION_URI ? getChannelName(context) : string3;
            if (soundUri == Settings.System.DEFAULT_NOTIFICATION_URI) {
                currentChannelId = context.getPackageName();
            } else {
                currentChannelId = getCurrentChannelId(context, string3);
            }
            IterableNotificationBuilder iterableNotificationBuilder = new IterableNotificationBuilder(context, currentChannelId);
            String string4 = bundle.getString(IterableConstants.ITERABLE_DATA_KEY);
            try {
                JSONObject jSONObject = new JSONObject(string4);
                str2 = jSONObject.has(IterableConstants.ITERABLE_DATA_PUSH_IMAGE) ? jSONObject.getString(IterableConstants.ITERABLE_DATA_PUSH_IMAGE) : null;
            } catch (JSONException e) {
                IterableLogger.w("IterableNotification", e.toString());
                str2 = null;
            }
            IterableNotificationData iterableNotificationData = new IterableNotificationData(string4);
            iterableNotificationBuilder.iterableNotificationData = iterableNotificationData;
            String messageId = iterableNotificationBuilder.iterableNotificationData.getMessageId();
            Notification notification = new Notification();
            notification.defaults |= 4;
            iterableNotificationBuilder.setSmallIcon(getIconId(context)).setTicker(obj).setAutoCancel(true).setContentTitle(string).setPriority(1).setContentText(string2);
            iterableNotificationBuilder.setShowWhen(true);
            iterableNotificationBuilder.setImageUrl(str2);
            iterableNotificationBuilder.setExpandedContent(string2);
            iterableNotificationBuilder.requestCode = Math.abs((int) System.currentTimeMillis());
            IterableLogger.d("IterableNotification", "Request code = " + iterableNotificationBuilder.requestCode);
            if (messageId != null) {
                iterableNotificationBuilder.requestCode = Math.abs(messageId.hashCode());
                IterableLogger.d("IterableNotification", "Request code = " + iterableNotificationBuilder.requestCode);
            }
            Intent intent = new Intent(IterableConstants.ACTION_PUSH_ACTION);
            intent.setClass(context, IterableTrampolineActivity.class);
            intent.putExtras(bundle);
            intent.putExtra("actionIdentifier", "default");
            intent.setFlags(268468224);
            if (iterableNotificationData.getActionButtons() != null) {
                Iterator<IterableNotificationData.Button> it = iterableNotificationData.getActionButtons().iterator();
                int i = 0;
                while (it.hasNext()) {
                    iterableNotificationBuilder.createNotificationActionButton(context, it.next(), bundle);
                    i++;
                    if (i == 3) {
                        break;
                    }
                }
            }
            iterableNotificationBuilder.setContentIntent(PendingIntent.getActivity(context, iterableNotificationBuilder.requestCode, intent, 201326592));
            iterableNotificationBuilder.setIsGhostPush(isGhostPush(bundle));
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo.metaData != null) {
                    int i2 = applicationInfo.metaData.getInt(IterableConstants.NOTIFICATION_COLOR);
                    try {
                        i2 = context.getResources().getColor(i2);
                    } catch (Resources.NotFoundException unused) {
                    }
                    iterableNotificationBuilder.setColor(i2);
                }
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
            if (context.getPackageManager().checkPermission("android.permission.VIBRATE", context.getPackageName()) == 0) {
                notification.defaults |= 2;
            }
            iterableNotificationBuilder.setDefaults(notification.defaults);
            removeUnusedChannel(context, string3);
            registerChannelIfEmpty(context, currentChannelId, channelName, "", soundUri);
            return iterableNotificationBuilder;
        }

        public Intent getMainActivityIntent(Context context) {
            Context applicationContext = context.getApplicationContext();
            Intent launchIntentForPackage = applicationContext.getPackageManager().getLaunchIntentForPackage(applicationContext.getPackageName());
            if (launchIntentForPackage != null) {
                return launchIntentForPackage;
            }
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(applicationContext.getPackageName());
            return intent;
        }

        public void postNotificationOnDevice(Context context, IterableNotificationBuilder iterableNotificationBuilder) {
            if (iterableNotificationBuilder.isGhostPush()) {
                return;
            }
            ((NotificationManager) context.getSystemService(NotificationsService.NOTIFICATION_KEY)).notify(iterableNotificationBuilder.requestCode, iterableNotificationBuilder.build());
        }

        private void registerChannelIfEmpty(Context context, String str, String str2, String str3, Uri uri) {
            NotificationManager notificationManager = (NotificationManager) context.getApplicationContext().getSystemService(NotificationsService.NOTIFICATION_KEY);
            if (notificationManager != null) {
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
                if (notificationChannel == null || !notificationChannel.getName().equals(str2)) {
                    IterableLogger.d("IterableNotification", "Creating notification: channelId = " + str + " channelName = " + str2 + " channelDescription = " + str3);
                    notificationManager.createNotificationChannel(createNotificationChannel(str, str2, str3, context, uri));
                }
            }
        }

        private void removeUnusedChannel(Context context, String str) {
            NotificationManager notificationManager = (NotificationManager) context.getApplicationContext().getSystemService(NotificationsService.NOTIFICATION_KEY);
            if (notificationManager != null) {
                String oldChannelId = getOldChannelId(context, str);
                if (notificationManager.getNotificationChannel(oldChannelId) != null) {
                    for (StatusBarNotification statusBarNotification : notificationManager.getActiveNotifications()) {
                        if (statusBarNotification.getNotification().getChannelId() == oldChannelId) {
                            IterableLogger.d("IterableNotification", "Not Deleting the channel as there are active notification for old channel");
                            return;
                        }
                    }
                    notificationManager.deleteNotificationChannel(oldChannelId);
                }
            }
        }

        private NotificationChannel createNotificationChannel(String str, String str2, String str3, Context context, Uri uri) {
            AudioAttributes audioAttributes = IterableNotificationHelper.getAudioAttributes();
            NotificationChannel notificationChannel = new NotificationChannel(str, str2, 4);
            notificationChannel.setDescription(str3);
            notificationChannel.enableLights(true);
            notificationChannel.setShowBadge(isNotificationBadgingEnabled(context));
            notificationChannel.setSound(uri, audioAttributes);
            return notificationChannel;
        }

        private static boolean isNotificationBadgingEnabled(Context context) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo.metaData != null) {
                    return applicationInfo.metaData.getBoolean(IterableConstants.NOTIFICAION_BADGING, true);
                }
            } catch (PackageManager.NameNotFoundException e) {
                IterableLogger.e("IterableNotification", e.getLocalizedMessage() + " Failed to read notification badge settings. Setting to defaults - true");
            }
            return true;
        }

        private String getCurrentChannelId(Context context, String str) {
            return getChannelIdName(context, true, str);
        }

        private String getOldChannelId(Context context, String str) {
            return getChannelIdName(context, false, str);
        }

        private String getChannelIdName(Context context, boolean z, String str) {
            String packageName = context.getPackageName();
            if (str == null) {
                str = packageName;
            }
            return z ? !isNotificationBadgingEnabled(context) ? str + IterableNotificationHelper.NO_BADGE : str : isNotificationBadgingEnabled(context) ? str + IterableNotificationHelper.NO_BADGE : str;
        }

        private String getChannelName(Context context) {
            int intValue;
            String str = null;
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo.metaData != null) {
                    Object obj = applicationInfo.metaData.get(IterableConstants.NOTIFICATION_CHANNEL_NAME);
                    if (obj instanceof String) {
                        str = (String) obj;
                    } else if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) != 0) {
                        str = context.getString(intValue);
                    }
                    IterableLogger.d("IterableNotification", "channel name: " + str);
                }
            } catch (Exception e) {
                IterableLogger.e("IterableNotification", "Error while retrieving channel name", e);
            }
            return str != null ? str : IterableNotificationHelper.DEFAULT_CHANNEL_NAME;
        }

        private int getIconId(Context context) {
            int i = 0;
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo.metaData != null) {
                    i = applicationInfo.metaData.getInt(IterableConstants.NOTIFICATION_ICON_NAME, 0);
                    IterableLogger.d("IterableNotification", "iconID: " + applicationInfo.metaData.get(IterableConstants.NOTIFICATION_ICON_NAME));
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(IterableApi.getNotificationIcon(context), IterableConstants.ICON_FOLDER_IDENTIFIER, context.getPackageName());
            }
            if (i != 0) {
                return i;
            }
            if (context.getApplicationInfo().icon != 0) {
                IterableLogger.d("IterableNotification", "No Notification Icon defined - defaulting to app icon");
                return context.getApplicationInfo().icon;
            }
            IterableLogger.w("IterableNotification", "No Notification Icon defined - push notifications will not be displayed");
            return i;
        }

        boolean isIterablePush(Bundle bundle) {
            return bundle != null && bundle.containsKey(IterableConstants.ITERABLE_DATA_KEY);
        }

        boolean isGhostPush(Bundle bundle) {
            if (bundle.containsKey(IterableConstants.ITERABLE_DATA_KEY)) {
                return new IterableNotificationData(bundle.getString(IterableConstants.ITERABLE_DATA_KEY)).getIsGhostPush();
            }
            return false;
        }

        boolean isEmptyBody(Bundle bundle) {
            return (bundle.containsKey(IterableConstants.ITERABLE_DATA_KEY) ? bundle.getString("body", "") : "").isEmpty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AudioAttributes getAudioAttributes() {
        return new AudioAttributes.Builder().setUsage(5).setContentType(4).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Uri getSoundUri(Context context, String str, String str2) {
        if (str2 != null) {
            return Uri.parse(str2);
        }
        int identifier = str != null ? context.getResources().getIdentifier(str, IterableConstants.SOUND_FOLDER_IDENTIFIER, context.getPackageName()) : 0;
        if (identifier == 0) {
            return Settings.System.DEFAULT_NOTIFICATION_URI;
        }
        return Uri.parse(IterableConstants.ANDROID_RESOURCE_PATH + context.getPackageName() + "/" + identifier);
    }
}
