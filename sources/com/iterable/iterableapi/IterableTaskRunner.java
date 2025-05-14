package com.iterable.iterableapi;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.iterable.iterableapi.IterableActivityMonitor;
import com.iterable.iterableapi.IterableApiRequest;
import com.iterable.iterableapi.IterableNetworkConnectivityManager;
import com.iterable.iterableapi.IterableTaskStorage;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class IterableTaskRunner implements IterableTaskStorage.TaskCreatedListener, Handler.Callback, IterableNetworkConnectivityManager.IterableNetworkMonitorListener, IterableActivityMonitor.AppStateCallback {
    private static final int OPERATION_PROCESS_TASKS = 100;
    private static final int RETRY_INTERVAL_SECONDS = 60;
    private static final String TAG = "IterableTaskRunner";
    private IterableActivityMonitor activityMonitor;
    Handler handler;
    private HealthMonitor healthMonitor;
    private IterableNetworkConnectivityManager networkConnectivityManager;
    private final HandlerThread networkThread;
    private ArrayList<TaskCompletedListener> taskCompletedListeners;
    private IterableTaskStorage taskStorage;

    interface TaskCompletedListener {
        void onTaskCompleted(String str, TaskResult taskResult, IterableApiResponse iterableApiResponse);
    }

    enum TaskResult {
        SUCCESS,
        FAILURE,
        RETRY
    }

    @Override // com.iterable.iterableapi.IterableNetworkConnectivityManager.IterableNetworkMonitorListener
    public void onNetworkDisconnected() {
    }

    @Override // com.iterable.iterableapi.IterableActivityMonitor.AppStateCallback
    public void onSwitchToBackground() {
    }

    IterableTaskRunner(IterableTaskStorage iterableTaskStorage, IterableActivityMonitor iterableActivityMonitor, IterableNetworkConnectivityManager iterableNetworkConnectivityManager, HealthMonitor healthMonitor) {
        HandlerThread handlerThread = new HandlerThread("NetworkThread");
        this.networkThread = handlerThread;
        this.taskCompletedListeners = new ArrayList<>();
        this.taskStorage = iterableTaskStorage;
        this.activityMonitor = iterableActivityMonitor;
        this.networkConnectivityManager = iterableNetworkConnectivityManager;
        this.healthMonitor = healthMonitor;
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), this);
        iterableTaskStorage.addTaskCreatedListener(this);
        iterableNetworkConnectivityManager.addNetworkListener(this);
        iterableActivityMonitor.addCallback(this);
    }

    void addTaskCompletedListener(TaskCompletedListener taskCompletedListener) {
        this.taskCompletedListeners.add(taskCompletedListener);
    }

    void removeTaskCompletedListener(TaskCompletedListener taskCompletedListener) {
        this.taskCompletedListeners.remove(taskCompletedListener);
    }

    @Override // com.iterable.iterableapi.IterableTaskStorage.TaskCreatedListener
    public void onTaskCreated(IterableTask iterableTask) {
        runNow();
    }

    @Override // com.iterable.iterableapi.IterableNetworkConnectivityManager.IterableNetworkMonitorListener
    public void onNetworkConnected() {
        runNow();
    }

    @Override // com.iterable.iterableapi.IterableActivityMonitor.AppStateCallback
    public void onSwitchToForeground() {
        runNow();
    }

    private void runNow() {
        this.handler.removeMessages(100);
        this.handler.sendEmptyMessage(100);
    }

    private void scheduleRetry() {
        this.handler.removeCallbacksAndMessages(100);
        this.handler.sendEmptyMessageDelayed(100, DateUtils.MILLIS_PER_MINUTE);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 100) {
            return false;
        }
        processTasks();
        return true;
    }

    private void processTasks() {
        IterableTask nextScheduledTask;
        if (!this.activityMonitor.isInForeground()) {
            IterableLogger.d(TAG, "App not in foreground, skipping processing tasks");
            return;
        }
        if (this.healthMonitor.canProcess()) {
            while (this.networkConnectivityManager.isConnected() && (nextScheduledTask = this.taskStorage.getNextScheduledTask()) != null) {
                if (!processTask(nextScheduledTask)) {
                    scheduleRetry();
                    return;
                }
            }
        }
    }

    private boolean processTask(IterableTask iterableTask) {
        if (iterableTask.taskType != IterableTaskType.API) {
            return false;
        }
        TaskResult taskResult = TaskResult.FAILURE;
        IterableApiResponse iterableApiResponse = null;
        try {
            IterableApiRequest fromJSON = IterableApiRequest.fromJSON(getTaskDataWithDate(iterableTask), null, null);
            fromJSON.setProcessorType(IterableApiRequest.ProcessorType.OFFLINE);
            iterableApiResponse = IterableRequestTask.executeApiRequest(fromJSON);
        } catch (Exception e) {
            IterableLogger.e(TAG, "Error while processing request task", e);
            this.healthMonitor.onDBError();
        }
        if (iterableApiResponse != null) {
            if (iterableApiResponse.success) {
                taskResult = TaskResult.SUCCESS;
            } else if (isRetriableError(iterableApiResponse.errorMessage)) {
                taskResult = TaskResult.RETRY;
            } else {
                taskResult = TaskResult.FAILURE;
            }
        }
        callTaskCompletedListeners(iterableTask.id, taskResult, iterableApiResponse);
        if (taskResult == TaskResult.RETRY) {
            return false;
        }
        this.taskStorage.deleteTask(iterableTask.id);
        return true;
    }

    JSONObject getTaskDataWithDate(IterableTask iterableTask) {
        try {
            JSONObject jSONObject = new JSONObject(iterableTask.data);
            jSONObject.getJSONObject("data").put("createdAt", iterableTask.createdAt / 1000);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isRetriableError(String str) {
        return str.contains("failed to connect");
    }

    private void callTaskCompletedListeners(final String str, final TaskResult taskResult, final IterableApiResponse iterableApiResponse) {
        Iterator<TaskCompletedListener> it = this.taskCompletedListeners.iterator();
        while (it.hasNext()) {
            final TaskCompletedListener next = it.next();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.iterable.iterableapi.IterableTaskRunner.1
                @Override // java.lang.Runnable
                public void run() {
                    next.onTaskCompleted(str, taskResult, iterableApiResponse);
                }
            });
        }
    }
}
