package com.iterable.iterableapi;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import androidx.fragment.app.FragmentActivity;
import com.iterable.iterableapi.IterableHelper;
import com.iterable.iterableapi.IterableInAppMessage;

/* loaded from: classes5.dex */
class IterableInAppDisplayer {
    private final IterableActivityMonitor activityMonitor;

    IterableInAppDisplayer(IterableActivityMonitor iterableActivityMonitor) {
        this.activityMonitor = iterableActivityMonitor;
    }

    boolean isShowingInApp() {
        return IterableInAppFragmentHTMLNotification.getInstance() != null;
    }

    boolean showMessage(IterableInAppMessage iterableInAppMessage, IterableInAppLocation iterableInAppLocation, IterableHelper.IterableUrlCallback iterableUrlCallback) {
        Activity currentActivity = this.activityMonitor.getCurrentActivity();
        if (currentActivity != null) {
            return showIterableFragmentNotificationHTML(currentActivity, iterableInAppMessage.getContent().html, iterableInAppMessage.getMessageId(), iterableUrlCallback, iterableInAppMessage.getContent().backgroundAlpha, iterableInAppMessage.getContent().padding, iterableInAppMessage.getContent().inAppDisplaySettings.shouldAnimate, iterableInAppMessage.getContent().inAppDisplaySettings.inAppBgColor, true, iterableInAppLocation);
        }
        return false;
    }

    static boolean showIterableFragmentNotificationHTML(Context context, String str, String str2, IterableHelper.IterableUrlCallback iterableUrlCallback, double d, Rect rect, boolean z, IterableInAppMessage.InAppBgColor inAppBgColor, boolean z2, IterableInAppLocation iterableInAppLocation) {
        if (context instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            if (str != null) {
                if (IterableInAppFragmentHTMLNotification.getInstance() != null) {
                    IterableLogger.w("IterableInAppManager", "Skipping the in-app notification: another notification is already being displayed");
                    return false;
                }
                IterableInAppFragmentHTMLNotification.createInstance(str, z2, iterableUrlCallback, iterableInAppLocation, str2, Double.valueOf(d), rect, z, inAppBgColor).show(fragmentActivity.getSupportFragmentManager(), "iterable_in_app");
                return true;
            }
        } else {
            IterableLogger.w("IterableInAppManager", "To display in-app notifications, the context must be of an instance of: FragmentActivity");
        }
        return false;
    }
}
