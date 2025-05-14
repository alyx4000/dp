package com.iterable.iterableapi;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.iterable.iterableapi.IterableActivityMonitor;
import com.iterable.iterableapi.IterableHelper;
import com.iterable.iterableapi.IterableInAppHandler;
import com.iterable.iterableapi.IterableInAppMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class IterableInAppManager implements IterableActivityMonitor.AppStateCallback {
    static final int MESSAGES_TO_FETCH = 100;
    static final long MOVE_TO_FOREGROUND_SYNC_INTERVAL_MS = 60000;
    static final String TAG = "IterableInAppManager";
    private final IterableActivityMonitor activityMonitor;
    private final IterableApi api;
    private boolean autoDisplayPaused;
    private final Context context;
    private final IterableInAppDisplayer displayer;
    private final IterableInAppHandler handler;
    private final double inAppDisplayInterval;
    private long lastInAppShown;
    private long lastSyncTime;
    private final List<Listener> listeners;
    private final IterableInAppStorage storage;

    public interface Listener {
        void onInboxUpdated();
    }

    @Override // com.iterable.iterableapi.IterableActivityMonitor.AppStateCallback
    public void onSwitchToBackground() {
    }

    IterableInAppManager(IterableApi iterableApi, IterableInAppHandler iterableInAppHandler, double d, boolean z) {
        this(iterableApi, iterableInAppHandler, d, getInAppStorageModel(iterableApi, z), IterableActivityMonitor.getInstance(), new IterableInAppDisplayer(IterableActivityMonitor.getInstance()));
    }

    IterableInAppManager(IterableApi iterableApi, IterableInAppHandler iterableInAppHandler, double d, IterableInAppStorage iterableInAppStorage, IterableActivityMonitor iterableActivityMonitor, IterableInAppDisplayer iterableInAppDisplayer) {
        this.listeners = new ArrayList();
        this.lastSyncTime = 0L;
        this.lastInAppShown = 0L;
        this.autoDisplayPaused = false;
        this.api = iterableApi;
        this.context = iterableApi.getMainActivityContext();
        this.handler = iterableInAppHandler;
        this.inAppDisplayInterval = d;
        this.storage = iterableInAppStorage;
        this.displayer = iterableInAppDisplayer;
        this.activityMonitor = iterableActivityMonitor;
        iterableActivityMonitor.addCallback(this);
        syncInApp();
    }

    public synchronized List<IterableInAppMessage> getMessages() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (IterableInAppMessage iterableInAppMessage : this.storage.getMessages()) {
            if (!iterableInAppMessage.isConsumed() && !isMessageExpired(iterableInAppMessage)) {
                arrayList.add(iterableInAppMessage);
            }
        }
        return arrayList;
    }

    synchronized IterableInAppMessage getMessageById(String str) {
        return this.storage.getMessage(str);
    }

    public synchronized List<IterableInAppMessage> getInboxMessages() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (IterableInAppMessage iterableInAppMessage : this.storage.getMessages()) {
            if (!iterableInAppMessage.isConsumed() && !isMessageExpired(iterableInAppMessage) && iterableInAppMessage.isInboxMessage()) {
                arrayList.add(iterableInAppMessage);
            }
        }
        return arrayList;
    }

    public synchronized int getUnreadInboxMessagesCount() {
        int i;
        Iterator<IterableInAppMessage> it = getInboxMessages().iterator();
        i = 0;
        while (it.hasNext()) {
            if (!it.next().isRead()) {
                i++;
            }
        }
        return i;
    }

    public synchronized void setRead(IterableInAppMessage iterableInAppMessage, boolean z) {
        setRead(iterableInAppMessage, z, null, null);
    }

    public synchronized void setRead(IterableInAppMessage iterableInAppMessage, boolean z, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        iterableInAppMessage.setRead(z);
        if (successHandler != null) {
            successHandler.onSuccess(new JSONObject());
        }
        notifyOnChange();
    }

    boolean isAutoDisplayPaused() {
        return this.autoDisplayPaused;
    }

    public void setAutoDisplayPaused(boolean z) {
        this.autoDisplayPaused = z;
        if (z) {
            return;
        }
        scheduleProcessing();
    }

    void syncInApp() {
        IterableLogger.printInfo();
        this.api.getInAppMessages(100, new IterableHelper.IterableActionHandler() { // from class: com.iterable.iterableapi.IterableInAppManager.1
            @Override // com.iterable.iterableapi.IterableHelper.IterableActionHandler
            public void execute(String str) {
                if (str != null && !str.isEmpty()) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        JSONArray optJSONArray = new JSONObject(str).optJSONArray(IterableConstants.ITERABLE_IN_APP_MESSAGE);
                        if (optJSONArray != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                IterableInAppMessage fromJSONObject = IterableInAppMessage.fromJSONObject(optJSONArray.optJSONObject(i), null);
                                if (fromJSONObject != null) {
                                    arrayList.add(fromJSONObject);
                                }
                            }
                            IterableInAppManager.this.syncWithRemoteQueue(arrayList);
                            IterableInAppManager.this.lastSyncTime = IterableUtil.currentTimeMillis();
                            return;
                        }
                        return;
                    } catch (JSONException e) {
                        IterableLogger.e(IterableInAppManager.TAG, e.toString());
                        return;
                    }
                }
                IterableInAppManager.this.scheduleProcessing();
            }
        });
    }

    void reset() {
        IterableLogger.printInfo();
        Iterator<IterableInAppMessage> it = this.storage.getMessages().iterator();
        while (it.hasNext()) {
            this.storage.removeMessage(it.next());
        }
        notifyOnChange();
    }

    public void showMessage(IterableInAppMessage iterableInAppMessage) {
        showMessage(iterableInAppMessage, true, null);
    }

    public void showMessage(IterableInAppMessage iterableInAppMessage, IterableInAppLocation iterableInAppLocation) {
        showMessage(iterableInAppMessage, iterableInAppLocation == IterableInAppLocation.IN_APP, null, iterableInAppLocation);
    }

    public void showMessage(IterableInAppMessage iterableInAppMessage, boolean z, IterableHelper.IterableUrlCallback iterableUrlCallback) {
        showMessage(iterableInAppMessage, z, iterableUrlCallback, IterableInAppLocation.IN_APP);
    }

    public void showMessage(final IterableInAppMessage iterableInAppMessage, boolean z, final IterableHelper.IterableUrlCallback iterableUrlCallback, IterableInAppLocation iterableInAppLocation) {
        if (this.displayer.showMessage(iterableInAppMessage, iterableInAppLocation, new IterableHelper.IterableUrlCallback() { // from class: com.iterable.iterableapi.IterableInAppManager.2
            @Override // com.iterable.iterableapi.IterableHelper.IterableUrlCallback
            public void execute(Uri uri) {
                IterableHelper.IterableUrlCallback iterableUrlCallback2 = iterableUrlCallback;
                if (iterableUrlCallback2 != null) {
                    iterableUrlCallback2.execute(uri);
                }
                IterableInAppManager.this.handleInAppClick(iterableInAppMessage, uri);
                IterableInAppManager.this.lastInAppShown = IterableUtil.currentTimeMillis();
                IterableInAppManager.this.scheduleProcessing();
            }
        })) {
            setRead(iterableInAppMessage, true, null, null);
            if (z) {
                iterableInAppMessage.markForDeletion(true);
            }
        }
    }

    public synchronized void removeMessage(IterableInAppMessage iterableInAppMessage) {
        removeMessage(iterableInAppMessage, null, null, null, null);
    }

    public synchronized void removeMessage(IterableInAppMessage iterableInAppMessage, IterableInAppDeleteActionType iterableInAppDeleteActionType, IterableInAppLocation iterableInAppLocation) {
        removeMessage(iterableInAppMessage, iterableInAppDeleteActionType, iterableInAppLocation, null, null);
    }

    public synchronized void removeMessage(IterableInAppMessage iterableInAppMessage, IterableInAppDeleteActionType iterableInAppDeleteActionType, IterableInAppLocation iterableInAppLocation, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        IterableLogger.printInfo();
        iterableInAppMessage.setConsumed(true);
        this.api.inAppConsume(iterableInAppMessage, iterableInAppDeleteActionType, iterableInAppLocation, successHandler, failureHandler);
        notifyOnChange();
    }

    public void handleInAppClick(IterableInAppMessage iterableInAppMessage, Uri uri) {
        IterableLogger.printInfo();
        if (uri == null || uri.toString().isEmpty()) {
            return;
        }
        String uri2 = uri.toString();
        if (uri2.startsWith(IterableConstants.URL_SCHEME_ACTION)) {
            IterableActionRunner.executeAction(this.context, IterableAction.actionCustomAction(uri2.replace(IterableConstants.URL_SCHEME_ACTION, "")), IterableActionSource.IN_APP);
        } else if (uri2.startsWith(IterableConstants.URL_SCHEME_ITBL)) {
            IterableActionRunner.executeAction(this.context, IterableAction.actionCustomAction(uri2.replace(IterableConstants.URL_SCHEME_ITBL, "")), IterableActionSource.IN_APP);
        } else if (uri2.startsWith(IterableConstants.URL_SCHEME_ITERABLE)) {
            handleIterableCustomAction(uri2.replace(IterableConstants.URL_SCHEME_ITERABLE, ""), iterableInAppMessage);
        } else {
            IterableActionRunner.executeAction(this.context, IterableAction.actionOpenUrl(uri2), IterableActionSource.IN_APP);
        }
    }

    synchronized void removeMessage(String str) {
        IterableInAppMessage message = this.storage.getMessage(str);
        if (message != null) {
            this.storage.removeMessage(message);
        }
        notifyOnChange();
    }

    private boolean isMessageExpired(IterableInAppMessage iterableInAppMessage) {
        return iterableInAppMessage.getExpiresAt() != null && IterableUtil.currentTimeMillis() > iterableInAppMessage.getExpiresAt().getTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncWithRemoteQueue(List<IterableInAppMessage> list) {
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (IterableInAppMessage iterableInAppMessage : list) {
            hashMap.put(iterableInAppMessage.getMessageId(), iterableInAppMessage);
            boolean z2 = this.storage.getMessage(iterableInAppMessage.getMessageId()) != null;
            if (!z2) {
                this.storage.addMessage(iterableInAppMessage);
                onMessageAdded(iterableInAppMessage);
                z = true;
            }
            if (z2) {
                IterableInAppMessage message = this.storage.getMessage(iterableInAppMessage.getMessageId());
                if (!message.isRead() && iterableInAppMessage.isRead()) {
                    message.setRead(iterableInAppMessage.isRead());
                    z = true;
                }
            }
        }
        for (IterableInAppMessage iterableInAppMessage2 : this.storage.getMessages()) {
            if (!hashMap.containsKey(iterableInAppMessage2.getMessageId())) {
                this.storage.removeMessage(iterableInAppMessage2);
                z = true;
            }
        }
        scheduleProcessing();
        if (z) {
            notifyOnChange();
        }
    }

    private List<IterableInAppMessage> getMessagesSortedByPriorityLevel(List<IterableInAppMessage> list) {
        Collections.sort(list, new Comparator<IterableInAppMessage>() { // from class: com.iterable.iterableapi.IterableInAppManager.3
            @Override // java.util.Comparator
            public int compare(IterableInAppMessage iterableInAppMessage, IterableInAppMessage iterableInAppMessage2) {
                if (iterableInAppMessage.getPriorityLevel() < iterableInAppMessage2.getPriorityLevel()) {
                    return -1;
                }
                return iterableInAppMessage.getPriorityLevel() == iterableInAppMessage2.getPriorityLevel() ? 0 : 1;
            }
        });
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMessages() {
        if (!this.activityMonitor.isInForeground() || isShowingInApp() || !canShowInAppAfterPrevious() || isAutoDisplayPaused()) {
            return;
        }
        IterableLogger.printInfo();
        for (IterableInAppMessage iterableInAppMessage : getMessagesSortedByPriorityLevel(getMessages())) {
            if (!iterableInAppMessage.isProcessed() && !iterableInAppMessage.isConsumed() && iterableInAppMessage.getTriggerType() == IterableInAppMessage.Trigger.TriggerType.IMMEDIATE && !iterableInAppMessage.isRead()) {
                IterableLogger.d(TAG, "Calling onNewInApp on " + iterableInAppMessage.getMessageId());
                IterableInAppHandler.InAppResponse onNewInApp = this.handler.onNewInApp(iterableInAppMessage);
                IterableLogger.d(TAG, "Response: " + onNewInApp);
                iterableInAppMessage.setProcessed(true);
                if (onNewInApp == IterableInAppHandler.InAppResponse.SHOW) {
                    showMessage(iterableInAppMessage, !iterableInAppMessage.isInboxMessage(), null);
                    return;
                }
            }
        }
    }

    void scheduleProcessing() {
        IterableLogger.printInfo();
        if (canShowInAppAfterPrevious()) {
            processMessages();
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.iterable.iterableapi.IterableInAppManager.4
                @Override // java.lang.Runnable
                public void run() {
                    IterableInAppManager.this.processMessages();
                }
            }, (long) (((this.inAppDisplayInterval - getSecondsSinceLastInApp()) + 2.0d) * 1000.0d));
        }
    }

    private void onMessageAdded(IterableInAppMessage iterableInAppMessage) {
        if (iterableInAppMessage.isRead()) {
            return;
        }
        this.api.trackInAppDelivery(iterableInAppMessage);
    }

    private boolean isShowingInApp() {
        return this.displayer.isShowingInApp();
    }

    private double getSecondsSinceLastInApp() {
        return (IterableUtil.currentTimeMillis() - this.lastInAppShown) / 1000.0d;
    }

    private boolean canShowInAppAfterPrevious() {
        return getSecondsSinceLastInApp() >= this.inAppDisplayInterval;
    }

    private void handleIterableCustomAction(String str, IterableInAppMessage iterableInAppMessage) {
        if (IterableConstants.ITERABLE_IN_APP_ACTION_DELETE.equals(str)) {
            removeMessage(iterableInAppMessage, IterableInAppDeleteActionType.DELETE_BUTTON, IterableInAppLocation.IN_APP, null, null);
        }
    }

    private static IterableInAppStorage getInAppStorageModel(IterableApi iterableApi, boolean z) {
        if (z) {
            checkAndDeleteUnusedInAppFileStorage(iterableApi.getMainActivityContext());
            return new IterableInAppMemoryStorage();
        }
        return new IterableInAppFileStorage(iterableApi.getMainActivityContext());
    }

    private static void checkAndDeleteUnusedInAppFileStorage(Context context) {
        File file = new File(IterableUtil.getDirectory(IterableUtil.getSDKFilesDirectory(context), "IterableInAppFileStorage"), "itbl_inapp.json");
        if (file.exists()) {
            file.delete();
        }
    }

    @Override // com.iterable.iterableapi.IterableActivityMonitor.AppStateCallback
    public void onSwitchToForeground() {
        if (IterableUtil.currentTimeMillis() - this.lastSyncTime > 60000) {
            syncInApp();
        } else {
            scheduleProcessing();
        }
    }

    public void addListener(Listener listener) {
        synchronized (this.listeners) {
            this.listeners.add(listener);
        }
    }

    public void removeListener(Listener listener) {
        synchronized (this.listeners) {
            this.listeners.remove(listener);
        }
    }

    public void notifyOnChange() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.iterable.iterableapi.IterableInAppManager.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (IterableInAppManager.this.listeners) {
                    Iterator it = IterableInAppManager.this.listeners.iterator();
                    while (it.hasNext()) {
                        ((Listener) it.next()).onInboxUpdated();
                    }
                }
            }
        });
    }
}
