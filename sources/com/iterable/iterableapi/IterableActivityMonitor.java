package com.iterable.iterableapi;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.iterable.iterableapi.util.DeviceInfoUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class IterableActivityMonitor {
    private static final int BACKGROUND_DELAY_MS = 1000;
    private static boolean initialized = false;
    static IterableActivityMonitor instance = new IterableActivityMonitor();
    private WeakReference<Activity> currentActivity;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private int numStartedActivities = 0;
    private boolean inForeground = false;
    private List<WeakReference<AppStateCallback>> callbacks = new ArrayList();
    private Runnable backgroundTransitionRunnable = new Runnable() { // from class: com.iterable.iterableapi.IterableActivityMonitor.1
        @Override // java.lang.Runnable
        public void run() {
            IterableActivityMonitor.this.inForeground = false;
            for (WeakReference weakReference : IterableActivityMonitor.this.callbacks) {
                if (weakReference.get() != null) {
                    ((AppStateCallback) weakReference.get()).onSwitchToBackground();
                }
            }
        }
    };
    private Application.ActivityLifecycleCallbacks lifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.iterable.iterableapi.IterableActivityMonitor.2
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            IterableActivityMonitor.this.handler.removeCallbacks(IterableActivityMonitor.this.backgroundTransitionRunnable);
            IterableActivityMonitor.access$408(IterableActivityMonitor.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            IterableActivityMonitor.this.currentActivity = new WeakReference(activity);
            if (!IterableActivityMonitor.this.inForeground || DeviceInfoUtils.isFireTV(activity.getPackageManager())) {
                IterableActivityMonitor.this.inForeground = true;
                for (WeakReference weakReference : IterableActivityMonitor.this.callbacks) {
                    if (weakReference.get() != null) {
                        ((AppStateCallback) weakReference.get()).onSwitchToForeground();
                    }
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (IterableActivityMonitor.this.getCurrentActivity() == activity) {
                IterableActivityMonitor.this.currentActivity = null;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (IterableActivityMonitor.this.numStartedActivities > 0) {
                IterableActivityMonitor.access$410(IterableActivityMonitor.this);
            }
            if (IterableActivityMonitor.this.numStartedActivities == 0 && IterableActivityMonitor.this.inForeground) {
                IterableActivityMonitor.this.handler.postDelayed(IterableActivityMonitor.this.backgroundTransitionRunnable, 1000L);
            }
        }
    };

    public interface AppStateCallback {
        void onSwitchToBackground();

        void onSwitchToForeground();
    }

    static /* synthetic */ int access$408(IterableActivityMonitor iterableActivityMonitor) {
        int i = iterableActivityMonitor.numStartedActivities;
        iterableActivityMonitor.numStartedActivities = i + 1;
        return i;
    }

    static /* synthetic */ int access$410(IterableActivityMonitor iterableActivityMonitor) {
        int i = iterableActivityMonitor.numStartedActivities;
        iterableActivityMonitor.numStartedActivities = i - 1;
        return i;
    }

    public static IterableActivityMonitor getInstance() {
        return instance;
    }

    public void registerLifecycleCallbacks(Context context) {
        if (initialized) {
            return;
        }
        initialized = true;
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this.lifecycleCallbacks);
    }

    public void unregisterLifecycleCallbacks(Context context) {
        if (initialized) {
            initialized = false;
            ((Application) context.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.lifecycleCallbacks);
        }
    }

    public Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean isInForeground() {
        return getCurrentActivity() != null;
    }

    public void addCallback(AppStateCallback appStateCallback) {
        Iterator<WeakReference<AppStateCallback>> it = this.callbacks.iterator();
        while (it.hasNext()) {
            if (it.next().get() == appStateCallback) {
                return;
            }
        }
        this.callbacks.add(new WeakReference<>(appStateCallback));
    }

    public void removeCallback(AppStateCallback appStateCallback) {
        Iterator<WeakReference<AppStateCallback>> it = this.callbacks.iterator();
        while (it.hasNext()) {
            if (it.next().get() == appStateCallback) {
                it.remove();
            }
        }
    }
}
