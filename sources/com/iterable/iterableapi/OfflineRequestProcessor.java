package com.iterable.iterableapi;

import android.content.Context;
import com.iterable.iterableapi.IterableApiRequest;
import com.iterable.iterableapi.IterableHelper;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class OfflineRequestProcessor implements RequestProcessor {
    private static final Set<String> offlineApiSet = new HashSet(Arrays.asList(IterableConstants.ENDPOINT_TRACK, IterableConstants.ENDPOINT_TRACK_PUSH_OPEN, IterableConstants.ENDPOINT_TRACK_PURCHASE, IterableConstants.ENDPOINT_TRACK_INAPP_OPEN, IterableConstants.ENDPOINT_TRACK_INAPP_CLICK, IterableConstants.ENDPOINT_TRACK_INAPP_CLOSE, IterableConstants.ENDPOINT_TRACK_INBOX_SESSION, IterableConstants.ENDPOINT_TRACK_INAPP_DELIVERY, IterableConstants.ENDPOINT_INAPP_CONSUME));
    private HealthMonitor healthMonitor;
    private IterableTaskRunner taskRunner;
    private TaskScheduler taskScheduler;
    private IterableTaskStorage taskStorage;

    OfflineRequestProcessor(Context context) {
        IterableNetworkConnectivityManager sharedInstance = IterableNetworkConnectivityManager.sharedInstance(context);
        this.taskStorage = IterableTaskStorage.sharedInstance(context);
        this.healthMonitor = new HealthMonitor(this.taskStorage);
        this.taskRunner = new IterableTaskRunner(this.taskStorage, IterableActivityMonitor.getInstance(), sharedInstance, this.healthMonitor);
        this.taskScheduler = new TaskScheduler(this.taskStorage, this.taskRunner);
    }

    OfflineRequestProcessor(TaskScheduler taskScheduler, IterableTaskRunner iterableTaskRunner, IterableTaskStorage iterableTaskStorage, HealthMonitor healthMonitor) {
        this.taskRunner = iterableTaskRunner;
        this.taskScheduler = taskScheduler;
        this.taskStorage = iterableTaskStorage;
        this.healthMonitor = healthMonitor;
    }

    @Override // com.iterable.iterableapi.RequestProcessor
    public void processGetRequest(String str, String str2, JSONObject jSONObject, String str3, IterableHelper.IterableActionHandler iterableActionHandler) {
        new IterableRequestTask().execute(new IterableApiRequest(str, str2, jSONObject, "GET", str3, iterableActionHandler));
    }

    @Override // com.iterable.iterableapi.RequestProcessor
    public void processPostRequest(String str, String str2, JSONObject jSONObject, String str3, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        IterableApiRequest iterableApiRequest = new IterableApiRequest(str, str2, jSONObject, "POST", str3, successHandler, failureHandler);
        if (isRequestOfflineCompatible(iterableApiRequest.resourcePath) && this.healthMonitor.canSchedule()) {
            iterableApiRequest.setProcessorType(IterableApiRequest.ProcessorType.OFFLINE);
            this.taskScheduler.scheduleTask(iterableApiRequest, successHandler, failureHandler);
        } else {
            new IterableRequestTask().execute(iterableApiRequest);
        }
    }

    @Override // com.iterable.iterableapi.RequestProcessor
    public void onLogout(Context context) {
        this.taskStorage.deleteAllTasks();
    }

    boolean isRequestOfflineCompatible(String str) {
        return offlineApiSet.contains(str);
    }
}
